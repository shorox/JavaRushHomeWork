package com.javarush.test.level07.lesson09.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Слова в обратном порядке
Введи с клавиатуры 5 слов в список строк. Удали 3 - ий элемент списка, и выведи оставшиеся элементы в обратном порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list=new ArrayList<String>();
        for(int i=0;i<5;i++) list.add(buf.readLine());
        list.remove(2);
        for(int i=0;i<list.size();i++)
        {
            list.add(i,list.get(list.size()-1));
            list.remove(list.size()-1);
        }
        for(String x : list) System.out.println(x);
    }
}
