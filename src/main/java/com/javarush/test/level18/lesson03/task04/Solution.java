package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        InputStream file = new FileInputStream(r.readLine());

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        while(file.available() > 0) {
            int b = file.read();
            if (map.containsKey(b)) {
                int tmp = map.get(b);
                map.remove(b);
                map.put(b, ++tmp);
            }else
                map.put(b, 1);
        }

        int min = Byte.MAX_VALUE;
        for(int t : map.values())
            if(t < min)
                min = t;

        for(int b : map.keySet())
            if(map.get(b) == min)
                System.out.print(b + " ");
        file.close();
        r.close();
    }
}
