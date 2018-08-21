package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(r.readLine());
        int b = Integer.parseInt(r.readLine());
        int max = max(a, b);
        int min = min(a, b);
        while(max % min != 0) min--;
        System.out.println(min);
    }

    private static int max(int a, int b)
    {
        return (a > b ? a : b);
    }

    private static int min(int a, int b)
    {
        return (a < b ? a : b);
    }
}
