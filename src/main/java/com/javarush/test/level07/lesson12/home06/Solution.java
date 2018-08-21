package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human kolya = new Human("Николай", true, 78);
        Human sergej = new Human("Сергей", true, 73);
        Human mariya = new Human("Мария", false, 75);
        Human pelageya = new Human("Пелагея", false, 76);
        Human roma = new Human("Роман", true, 49, kolya, mariya);
        Human rita = new Human("Маргарита", false, 45, sergej, pelageya);
        Human jenya = new Human("Евгений", true, 21, roma, rita);
        Human petya = new Human("Петр", true, 19, roma, rita);
        Human katya = new Human("Екатерина", false, 16, roma, rita);
        System.out.println(kolya.toString());
        System.out.println(sergej.toString());
        System.out.println(mariya.toString());
        System.out.println(pelageya.toString());
        System.out.println(roma.toString());
        System.out.println(rita.toString());
        System.out.println(jenya.toString());
        System.out.println(petya.toString());
        System.out.println(katya.toString());
    }

    public static class Human
    {
        //напишите тут ваш код
        private String name;
        private boolean sex;
        private int age;
        Human father;
        Human mother;

        Human(String name, boolean sex, int age)
        {
            this.name=name;
            this.sex=sex;
            this.age=age;
        }

        Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.father=father;
            this.mother=mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
