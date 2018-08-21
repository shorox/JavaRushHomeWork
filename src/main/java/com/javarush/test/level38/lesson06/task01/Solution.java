package com.javarush.test.level38.lesson06.task01;

/* Улучшения в Java 7 (try-with-resources)
Перепиши реализации методов класса Solution.
Используй нововведения, касающиеся обработки исключений, которые были добавлены в Java 7.
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public void printFile1() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream("file.txt")){
            int data;
            while ((data = fileInputStream.read()) != -1) System.out.println(data);
        }
    }

    public void printFile2() throws IOException {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("file.txt"))){
            int data;
            while ((data = bufferedInputStream.read()) != -1) System.out.println(data);
        }
    }
}