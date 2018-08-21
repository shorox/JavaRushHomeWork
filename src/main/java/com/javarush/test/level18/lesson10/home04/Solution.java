package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String name1 = r.readLine();
        String name2 = r.readLine();
        FileInputStream f1 = new FileInputStream(name1);
        byte[] b1 = new byte[f1.available()];
        int count1 = f1.read(b1);
        f1.close();
        FileOutputStream f2 = new FileOutputStream(name1);
        FileInputStream f3 = new FileInputStream(name2);
        byte[] b2 = new byte[f3.available()];
        int count2 = f3.read(b2);
        f2.write(b2);
        f2.write(b1);
        f2.close();
        f3.close();
        r.close();
    }
}
