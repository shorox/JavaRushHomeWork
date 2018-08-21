package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, String> map = new TreeMap<Integer, String>();
        String buff;
        while(!(buff = r.readLine()).equals("end"))
            map.put(Integer.parseInt(buff.substring(buff.indexOf(".part") + 5)), buff);
        FileOutputStream out = new FileOutputStream(map.get(1).substring(0, map.get(1).indexOf(".part")));
        for(String fileName : map.values()){
            FileInputStream in = new FileInputStream(fileName);
            while(in.available() > 0) out.write(in.read());
            in.close();
        }
        out.close();
        r.close();
    }
}
