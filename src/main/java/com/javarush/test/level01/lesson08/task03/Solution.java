package com.javarush.test.level01.lesson08.task03;

/* Решаем задачи
Напиши программу, которая выводит на экран надпись: «Хочешь - решай задачи, не хочешь - решай нехотя» 16 раз.
*/
public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        print4Times("Хочешь - решай задачи, не хочешь - решай нехотя");
        print4Times("Хочешь - решай задачи, не хочешь - решай нехотя");
        print4Times("Хочешь - решай задачи, не хочешь - решай нехотя");
        print4Times("Хочешь - решай задачи, не хочешь - решай нехотя");
    }

    public static void print4Times(String s)
    {
        System.out.println(s);
        System.out.println(s);
        System.out.println(s);
        System.out.println(s);
    }
}
