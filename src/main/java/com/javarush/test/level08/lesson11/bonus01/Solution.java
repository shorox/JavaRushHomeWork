package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //напишите тут ваш код
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String month = buf.readLine();
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, "January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December");
        for(int i=0;i<list.size();i++)
            if(list.get(i).equals(month))
            {
                System.out.println(month + " is " + (i + 1) + " month");
                break;
            }
    }

}
