package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human stepa = new Human("Степан", true, 23);
        Human kseniya = new Human("Ксения", false, 18);
        Human liza = new Human("Елизавета", false, 15);
        ArrayList<Human> tmp = new ArrayList<Human>();
        Collections.addAll(tmp, stepa, kseniya, liza);
        Human sergej = new Human("Сергей", true, 52, tmp);
        Human marina = new Human("Марина", false, 45, tmp);
        ArrayList<Human> tmp2 = new ArrayList<Human>();
        tmp2.add(sergej);
        Human kolya = new Human("Николай", true, 81, tmp2);
        Human sveta = new Human("Светлана", false, 76, tmp2);
        ArrayList<Human> tmp3 = new ArrayList<Human>();
        tmp3.add(marina);
        Human boris = new Human("Борис", true, 79, tmp3);
        Human mariya = new Human("Мария", false, 75, tmp3);
        System.out.println(boris);
        System.out.println(kolya);
        System.out.println(mariya);
        System.out.println(sveta);
        System.out.println(sergej);
        System.out.println(marina);
        System.out.println(stepa);
        System.out.println(kseniya);
        System.out.println(liza);
    }

    public static class Human
    {
        //напишите тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children;

        Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = new ArrayList<Human>();
        }

        Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
