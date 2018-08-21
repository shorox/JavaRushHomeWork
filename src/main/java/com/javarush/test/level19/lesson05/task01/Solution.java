package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = r.readLine();
        String fileName2 = r.readLine();
        r.close();
        FileInputStream in = new FileInputStream(fileName1);
        FileOutputStream out = new FileOutputStream(fileName2);
        for(int i = 1; in.available() > 0; i++){
            int n = in.read();
            if(i % 2 == 0) out.write(n);
        }
        in.close();
        out.close();
    }
}
