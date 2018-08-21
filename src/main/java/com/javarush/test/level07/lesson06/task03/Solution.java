package com.javarush.test.level07.lesson06.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 5 строчек в обратном порядке
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в него.
3. Расположи их в обратном порядке.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list=new ArrayList<String>();
        for(int i=0;i<5;i++) list.add(buf.readLine());
        for(int i=0;i<list.size()-1;i++)
        {
            list.add(i, list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }
        for(int i=0;i<5;i++) System.out.println(list.get(i));
    }
}
