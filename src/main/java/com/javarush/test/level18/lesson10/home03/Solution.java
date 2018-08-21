package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream f1 = new FileOutputStream(r.readLine());
        FileInputStream f2 = new FileInputStream(r.readLine());
        FileInputStream f3 = new FileInputStream(r.readLine());
        while(f2.available() > 0) f1.write(f2.read());
        while(f3.available() > 0) f1.write(f3.read());
        f1.close();
        f2.close();
        f3.close();
        r.close();
    }
}
