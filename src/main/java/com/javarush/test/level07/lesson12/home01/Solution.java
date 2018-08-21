package com.javarush.test.level07.lesson12.home01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Вывести числа в обратном порядке
Ввести с клавиатуры 10 чисел и заполнить ими список.
Вывести их в обратном порядке.
Использовать только цикл for.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<10;i++) list.add(Integer.parseInt(reader.readLine()));
        for(int i=0;i<list.size();i++)
        {
            list.add(i,list.get(list.size()-1));
            list.remove(list.size()-1);
        }
        for(Integer x : list) System.out.println(x);
    }
}
