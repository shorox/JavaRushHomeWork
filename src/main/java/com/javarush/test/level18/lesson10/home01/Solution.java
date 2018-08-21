package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream in = new FileInputStream(args[0]);
        byte[] str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".getBytes();
        int count = 0;
        while(in.available() > 0){
            int c = in.read();
            for(int i = 0; i < str.length - 1; i++)
                if(c == str[i]){
                    count++;
                    break;
                }
        }
        System.out.println(count);
        in.close();
    }
}
