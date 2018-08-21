package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
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
                if(word.length() - word.replaceAll("[0-9]", "").length() > 0)
                    result += word + " ";
        }
        w.println(result.trim());
        w.close();
        r.close();
    }
}
