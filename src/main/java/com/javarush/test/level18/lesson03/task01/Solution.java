package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        InputStream file = new FileInputStream(r.readLine());
        r.close();
        int max = 0;
        int b;
        while(file.available() > 0)
            if((b = file.read()) > max)
                max = b;
        file.close();
        System.out.println(max);
    }
}
