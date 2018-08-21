package com.javarush.test.level35.lesson10.bonus01;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;

/* ClassLoader - что это такое?
Реализуйте логику метода getAllAnimals.
Аргумент метода pathToAnimals - это абсолютный путь к директории, в которой хранятся скомпилированные классы.
Путь не обязательно содержит / в конце.
НЕ все классы наследуются от интерфейса Animal.
НЕ все классы имеют публичный конструктор без параметров.
Только для классов, которые наследуются от Animal и имеют публичный конструктор без параметров, - создать по одному объекту.
Добавить созданные объекты в результирующий сет и вернуть.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals("C:/Users/sharov/Dropbox/IntelliJ IDEA/JavaRushHomeWork/out/production/JavaRushHomeWork/com/javarush/com.javarush.test/level35/lesson10/bonus01/data");
        System.out.println(allAnimals.size());
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        if(!pathToAnimals.endsWith("/")) pathToAnimals += "/";
        String[] files = new File(pathToAnimals).list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".class");
            }
        });
        Set<Animal> animals = new HashSet<>();
        for(String file : files){
            try {
                final File finalFile = new File(pathToAnimals + file);
                Class clazz = new ClassLoader()
                {
                    @Override
                    public Class<?> findClass(String className) throws ClassNotFoundException
                    {
                        try {
                            byte b[] = Files.readAllBytes(finalFile.toPath());
                            return defineClass(null, b, 0, b.length);
                        } catch (Exception e1) {
                            return super.findClass(className);
                        }
                    }
                }.loadClass(file);
                Class[] interfaces = clazz.getInterfaces();
                for(Class i : interfaces){
                    if(i.getName().equals(Animal.class.getName())){
                        Constructor[] constructors = clazz.getConstructors();
                        for(Constructor c : constructors){
                            if(c.getParameterTypes().length == 0){
                                animals.add((Animal) clazz.newInstance());
                                break;
                            }
                        }
                        break;
                    }
                }
            } catch (Exception e) {
            }
        }
        return animals;
    }
}
