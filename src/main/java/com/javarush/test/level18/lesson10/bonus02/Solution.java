package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    private static String filename;

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        filename = r.readLine();
        r.close();
        if(args[0].equals("-c")) {
            String result = setParam(args);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));
            out.println(result);
            out.close();
        }
    }

    private static String FixPos(String pos, int length){
        if(pos.length() > length)
            return pos.substring(0, length);
        else if(pos.length() < length)
            while(pos.length() < length) pos += " ";
        return pos;
    }

    private static long GetID() throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(filename));
        long max = 0;
        while (in.ready()) {
            long c = Long.parseLong(in.readLine().substring(0, 8).trim());
            if (max < c) max = c;
        }
        in.close();
        return ++max;
    }

    private static String setParam(String[] args) throws IOException{
        String id = FixPos(String.valueOf(GetID()), 8);
        String productName = "";
        for(int i = 1; i < args.length - 2; i++) productName += args[i] + (i + 1 == args.length - 2 ? "" : " ");
        productName = FixPos(productName, 30);
        String price = FixPos(args[args.length - 2], 8);
        String quantity = FixPos(args[args.length - 1], 4);
        return id + productName + price + quantity;
    }
}
