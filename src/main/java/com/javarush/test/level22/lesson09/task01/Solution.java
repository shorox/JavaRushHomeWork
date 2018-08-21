package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(r.readLine())));
        List<String> list = new ArrayList<>();
        while(in.ready()) Collections.addAll(list, in.readLine().split(" "));
        for(int i = 0; i < list.size() - 1; i++)
            for(int j = i + 1; j < list.size(); j++)
                if(list.get(i).equals(new StringBuilder(list.get(j)).reverse().toString()))
                    result.add(new Pair(list.get(i), list.get(j)));
        in.close();
        r.close();
    }

    public static class Pair {
        String first;
        String second;

        public Pair(String first, String second){
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
