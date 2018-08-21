package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = r.readLine();
        String fileName2 = r.readLine();
        r.close();
        BufferedReader in = new BufferedReader(new FileReader(fileName1));
        PrintWriter out = new PrintWriter(fileName2);
        while(in.ready())
            out.println(in.readLine().replace(".", "!"));
        in.close();
        out.close();
    }
}
