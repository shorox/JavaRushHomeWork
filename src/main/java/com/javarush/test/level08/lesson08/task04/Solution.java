package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));

        //напишите тут ваш код
        map.put("Голубков", new Date("MARCH 3 1972"));
        map.put("Федоров", new Date("JANUARY 23 1990"));
        map.put("Немзоров", new Date("JULY 1 1985"));
        map.put("Иванов", new Date("AUGUST 12 1951"));
        map.put("Петров", new Date("DECEMBER 12 1946"));
        map.put("Сидоров", new Date("JULY 8 1975"));
        map.put("Козлов", new Date("MARCH 25 1964"));
        map.put("Большов", new Date("OCTOBER 8 1958"));
        map.put("Путин", new Date("SEPTEMBER 14 1995"));
        //map.put("Обама", new Date("SEPTEMBER 16 1991"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        HashMap<String, Date> mapcopy = new HashMap<String, Date>(map);
        for(Map.Entry<String, Date> pair : mapcopy.entrySet())
        {
            if (pair.getValue().getMonth() >= 5 && pair.getValue().getMonth() <= 7)
                map.remove(pair.getKey());
        }
        for(Map.Entry<String, Date> p : map.entrySet())
            System.out.println(p.getKey() + " - " + p.getValue());
    }

    public static void main(String[] args)
    {
        removeAllSummerPeople(createMap());
    }
}
