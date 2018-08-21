package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while(!(fileName = r.readLine()).equals("exit"))
            new ReadThread(fileName).run();
        r.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run(){
            try {
                FileInputStream in = new FileInputStream(this.fileName);
                Map<Integer, Integer> map = new TreeMap<>();
                while (in.available() > 0) {
                    int n = in.read();
                    map.put(n, map.containsKey(n) ? map.get(n) + 1 : 1);
                }
                int max = 0;
                int b = 0;
                for(Entry<Integer, Integer> cur : map.entrySet())
                    if(cur.getValue() > max){
                        max = cur.getValue();
                        b = cur.getKey();
                    }
                resultMap.put(this.fileName, b);
                in.close();
            }catch (IOException e){}
        }
    }
}
