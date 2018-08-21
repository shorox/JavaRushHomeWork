package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file = reader.readLine();
        OutputStream out = new FileOutputStream(file);
        ArrayList<String> list = new ArrayList<String>();

        while(true)
        {
            String text = reader.readLine();
            list.add(text + System.lineSeparator());
            if(text.equals("exit")) break;
        }

        while(list.size() > 0)
        {
            for (char ch : list.get(0).toCharArray()) out.write(ch);
            list.remove(0);
        }

        out.close();
        reader.close();
    }
}
