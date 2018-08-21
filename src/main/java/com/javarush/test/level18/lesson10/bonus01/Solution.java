package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream in = new FileInputStream(args[1]);
        FileOutputStream out = new FileOutputStream(args[2]);
        if(args[0].equals("-e")){
            while(in.available() > 0){
                int b = in.read();
                out.write(b == 255 ? 0 : b + 1);
            }

        }
        else if(args[0].equals("-d")){
            while(in.available() > 0){
                int b = in.read();
                out.write(b == 0 ? 255 : b - 1);
            }
        }
        in.close();
        out.close();
    }

}
