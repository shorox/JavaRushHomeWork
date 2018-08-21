package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static String filename;
    private static Map<Long, String> map = new HashMap<Long, String>();
    private static String[] args;
    private static long id;

    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        filename = r.readLine();
        r.close();
        GetList();
        Solution.args = args;
        Solution.id = Long.parseLong(args[1]);
        if (args[0].equals("-u")) Update();
        else if (args[0].equals("-d")) Delete();
    }

    private static void Update() throws  IOException{
        PrintWriter out;
        String line = setParam();
        if (map.containsKey(id)) {
            map.put(id, line);
            out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
            for (String s : map.values()) out.println(s);
        } else {
            out = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));
            out.println(line);
        }
        out.close();
    }

    private static void Delete() throws IOException{
        if(map.containsKey(id)) {
            map.remove(id);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
            for (String s : map.values()) out.println(s);
            out.close();
        }
    }

    private static String FixPos(String pos, int length){
        if(pos.length() > length) {
            return pos.substring(0, length);
        }else if(pos.length() < length) {
            String s = "";
            while (pos.length() + s.length() < length) s += " ";
            return pos + s;
        } else
            return pos;
    }

    private static void GetList() throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(filename));
        while (in.ready()) {
            String s = in.readLine();
            map.put(Long.parseLong(s.substring(0, 8).trim()), s);
        }
        in.close();
    }

    private static String setParam() throws IOException{
        String id = FixPos(args[1], 8);
        String productName = "";
        for(int i = 2; i < args.length - 2; i++) productName += args[i] + (i + 1 == args.length - 2 ? "" : " ");
        productName = FixPos(productName, 30);
        String price = FixPos(args[args.length - 2], 8);
        String quantity = FixPos(args[args.length - 1], 4);
        return id + productName + price + quantity;
    }
}
