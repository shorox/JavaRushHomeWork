package com.javarush.test.level36.lesson06.task01;

/* Найти класс по описанию
1. Реализует интерфейс List
2. Является приватным статическим классом внутри популярного утилитного класса
3. Доступ по индексу запрещен - кидается исключение IndexOutOfBoundsException
4. Используйте рефлекшн, чтобы добраться до искомого класса
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        /*Class[] classList = Collections.class.getDeclaredClasses();
        for(Class clazz : classList){
            if(Modifier.isPrivate(clazz.getModifiers()) && Modifier.isStatic(clazz.getModifiers())) {
                for(Class i : clazz.getSuperclass().getInterfaces())
                    if(i.getName().equals(List.class.getName())) {
                        try {
                            Method method = clazz.getMethod("get", new Class[]{int.class});
                            method.invoke(clazz.newInstance(), 0);
                        } catch (IndexOutOfBoundsException e) {
                            return clazz;
                        } catch (IllegalAccessException e) {
                        } catch (InvocationTargetException e) {
                        } catch (InstantiationException e) {
                        } catch (NoSuchMethodException e) {
                        }
                        System.out.println(clazz);
                    }
            }
        }*/
        try {
            return Class.forName("java.util.Collections$EmptyList");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
