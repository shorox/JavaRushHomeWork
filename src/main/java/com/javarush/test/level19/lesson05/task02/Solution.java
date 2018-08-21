package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = r.readLine();
        r.close();
        BufferedReader f = new BufferedReader(new FileReader(fileName1));
        int count = 0;
        while(f.ready()){
            String[] words = f.readLine().split("[,. !?]");
            for(String word : words)
                if(word.trim().equals("world")) count++;
        }
        System.out.println(count);
        f.close();
    }
}
