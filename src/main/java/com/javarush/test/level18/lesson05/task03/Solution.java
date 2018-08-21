package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream f1 = new FileInputStream(r.readLine());
        FileOutputStream f2 = new FileOutputStream(r.readLine());
        FileOutputStream f3 = new FileOutputStream(r.readLine());
        int count = f1.available();
        for(int i = 0; i < count / 2 + count % 2; i++)
            f2.write(f1.read());
        for(int i = count / 2 + count % 2; i < count; i++)
            f3.write(f1.read());
        f1.close();
        f2.close();
        f3.close();
        r.close();
    }
}
