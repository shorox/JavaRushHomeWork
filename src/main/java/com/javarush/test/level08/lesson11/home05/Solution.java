package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        char[] c = (" " + s).toCharArray();
        for (int i = 1; i < c.length; i++)
            if (Character.isWhitespace(c[i - 1]) && Character.isAlphabetic(c[i]))
                c[i] = Character.toUpperCase(c[i]);
        for (int i = 1; i < c.length; i++) System.out.print(c[i]);
    }
}
