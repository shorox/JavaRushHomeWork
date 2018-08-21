package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new FileReader(r.readLine()));
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(String text = in.readLine(); text != null; text = in.readLine())
        {
            int data = Integer.parseInt(text);
            if (data % 2 == 0) list.add(data);
        }

        Collections.sort(list);

        for(int x : list)
            System.out.println(x);

        in.close();;
        r.close();
    }
}
