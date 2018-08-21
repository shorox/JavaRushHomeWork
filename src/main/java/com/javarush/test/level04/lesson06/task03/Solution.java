package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(reader.readLine());
        int b=Integer.parseInt(reader.readLine());
        int c=Integer.parseInt(reader.readLine());
        if (a==max(a, max(b, c)))
            System.out.println(a+" "+(b==max(b,c)?b+" "+c:c+" "+b));
        else if (b==max(b,c))
            System.out.println(b+" "+(a==max(a,c)?a+" "+c:c+" "+a));
        else
            System.out.println(c+" "+(a==max(a,b)?a+" "+b:b+" "+a));
    }

    public static int max(int a, int b)
    {
        return a>b?a:b;
    }

}
