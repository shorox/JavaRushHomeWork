package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(args[0]));
        PrintWriter w = new PrintWriter(args[1]);
        String result = "";
        while(r.ready()){
            String[] words = r.readLine().split(" ");
            for(String word : words)
                if(word.length() > 6)
                    result += word + ",";
        }
        w.println(result.substring(0, result.length() - 1));
        w.close();
        r.close();
    }
}
