package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
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

    public void initialize(String name)
    {
        this.name=name;
    }

    public void initialize(String name, int drowth)
    {
        this.name=name;
        this.drowth=drowth;
    }

    public void initialize(String name, int drowth, String color)
    {
        this.name=name;
        this.drowth=drowth;
        this.color=color;
    }
}
