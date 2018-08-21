package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        r.close();
        String[] lines = s.substring(s.indexOf("?") + 1).split("&");
        String obj = "";
        for (String line : lines) {
            String[] prm = line.split("=");
            System.out.print(prm[0] + " ");
            if (prm[0].equals("obj")) obj = prm[1];
        }
        System.out.println();
        if (!obj.equals("")) try {
            alert((double) Double.parseDouble(obj));
        } catch (Exception e) {
            alert(obj);
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
