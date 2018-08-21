package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = r.readLine();
        String fileName2 = r.readLine();
        r.close();
        BufferedReader in = new BufferedReader(new FileReader(fileName1));
        PrintWriter out = new PrintWriter(fileName2);
        String result = "";
        while(in.ready()){
            String[] words = in.readLine().split(" ");
            for(String word : words) {
                try {
                    result += String.valueOf(Integer.parseInt(word)) + " ";
                } catch (Exception e) {
                }
            }
        }
        out.println(result.trim());
        in.close();
        out.close();
    }
}
