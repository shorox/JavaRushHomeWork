package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    //напишите тут ваш код
    private String name=null;
    private int drowth;
    private String color=null;

    public Dog(String name)
    {
        this.name=name;
    }

    public Dog(String name, int drowth)
    {
        this.name=name;
        this.drowth=drowth;
    }

    public Dog(String name, int drowth, String color)
    {
        this.name=name;
        this.drowth=drowth;
        this.color=color;
    }
}
