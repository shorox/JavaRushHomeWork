package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException{
        //...
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(r.readLine())));
        List<String> list = new ArrayList<>();
        while(in.ready()) Collections.addAll(list, in.readLine().split(" "));
        in.close();
        r.close();
        StringBuilder result = getLine(list.toArray(new String[list.size()]));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if(words == null ? true : words.length == 0) return new StringBuilder();
        List<String> list = new ArrayList<>();
        Collections.addAll(list, words);
        while(!isOK(list)) Collections.shuffle(list);
        StringBuilder result = new StringBuilder();
        for(String s : list) result.append(" ").append(s);
        result.deleteCharAt(0);
        return  result;
    }

    public static boolean isOK(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++)
            if (list.get(i).toLowerCase().charAt(list.get(i).length() - 1) != list.get(i+1).toLowerCase().charAt(0))
                return false;
        return true;
    }
}
