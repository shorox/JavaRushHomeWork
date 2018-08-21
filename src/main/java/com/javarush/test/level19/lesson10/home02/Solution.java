package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        Map<String, Double> map = new TreeMap<String, Double>();
        BufferedReader r = new BufferedReader(new FileReader(args[0]));
        while(r.ready()){
            String[] line = r.readLine().split(" ");
            String name = line[0];
            double num = Double.parseDouble(line[1]);
            map.put(name, map.containsKey(name) ? map.get(name) + num : num);
        }
        r.close();
        Double max = Collections.max(map.values());
        for(Map.Entry<String , Double> pair : map.entrySet())
            if(pair.getValue() == max)
                System.out.println(pair.getKey());
    }
}
