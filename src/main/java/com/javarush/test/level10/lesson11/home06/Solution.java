package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        String name;
        String lastname;
        int age;
        boolean sex;
        String birthday;
        String city;

        Human(String name)
        {
            this.name = name;
        }

        Human(String name, String lastname)
        {
            this.name = name;
            this.lastname = lastname;
        }

        Human(String name, String lastname, int age)
        {
            this.name = name;
            this.lastname = lastname;
            this.age = age;
        }

        Human(String name, String lastname, int age, boolean sex)
        {
            this.name = name;
            this.lastname = lastname;
            this.age = age;
            this.sex = sex;
        }

        Human(String name, String lastname, int age, boolean sex, String birthday)
        {
            this.name = name;
            this.lastname = lastname;
            this.age = age;
            this.sex = sex;
            this.birthday = birthday;
        }

        Human(String name, String lastname, int age, boolean sex, String birthday, String city)
        {
            this.name = name;
            this.lastname = lastname;
            this.age = age;
            this.sex = sex;
            this.birthday = birthday;
            this.city = city;
        }

        Human(String name, int age, boolean sex, String birthday, String city)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.birthday = birthday;
            this.city = city;
        }

        Human(String name, String lastname, boolean sex, String birthday, String city)
        {
            this.name = name;
            this.lastname = lastname;
            this.sex = sex;
            this.birthday = birthday;
            this.city = city;
        }

        Human(String name, String lastname, int age, String birthday, String city)
        {
            this.name = name;
            this.lastname = lastname;
            this.age = age;
            this.birthday = birthday;
            this.city = city;
        }

        Human(String name, String lastname, String birthday, String city)
        {
            this.name = name;
            this.lastname = lastname;
            this.birthday = birthday;
            this.city = city;
        }
    }
}
