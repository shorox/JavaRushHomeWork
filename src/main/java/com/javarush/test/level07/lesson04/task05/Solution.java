package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
        int[] a=new int[20];
        for(int i=0;i<a.length;i++) a[i] = Integer.parseInt(buf.readLine());
        int[] b=new int[10];
        int[] c=new int[10];
        for(int i=0;i<a.length/2;i++)
        {
            b[i]=a[i];
            c[i]=a[a.length/2+i];
        }
        for(int i=0;i<c.length;i++) System.out.println(c[i]);
    }
}
