package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(r.readLine());
        int b=Integer.parseInt(r.readLine());
        int c=Integer.parseInt(r.readLine());
        if((a>b && a<c) || (a>c && a<b))
            System.out.println(a);
        else if((b>a && b<c) || (b>c && b<a))
            System.out.println(b);
        else if((c>a && c<b) || (c>b && c<a))
            System.out.println(c);
    }
}
