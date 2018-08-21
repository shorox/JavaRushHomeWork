package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream in = new FileInputStream(args[0]);
        Map<Character, Integer> map = new TreeMap<>();
        while(in.available() > 0) {
            char ch = (char)in.read();
            map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
        }
        for(Entry<Character, Integer> pair : map.entrySet())
            System.out.println(pair.getKey() + " " + pair.getValue());
        in.close();
    }
}
