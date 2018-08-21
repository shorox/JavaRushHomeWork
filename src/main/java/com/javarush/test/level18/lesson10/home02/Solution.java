package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream in = new FileInputStream(args[0]);
        byte str = (" ".getBytes())[0];
        int total = in.available();
        int cur = 0;
        while(in.available() > 0){
            if(in.read() == str)
                cur++;
        }
        System.out.println(cur/(total*1.00)*100);
        in.close();
    }
}
