package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream f1 = new FileInputStream(r.readLine());
        FileOutputStream f2 = new FileOutputStream(r.readLine());
        List<Integer> list = new ArrayList<Integer>();
        while(f1.available() > 0)
            list.add(0, f1.read());
        for(int x : list)
            f2.write(x);
        f1.close();
        f2.close();
        r.close();
    }
}
