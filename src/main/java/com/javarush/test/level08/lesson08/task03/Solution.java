package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Голубков", "Роман");
        map.put("Федоров", "Федор");
        map.put("Немзоров", "Борис");
        map.put("Иванов", "Иван");
        map.put("Петров", "Петр");
        map.put("Сидоров", "Сидор");
        map.put("Козлов", "Николай");
        map.put("Большов", "Роман");
        map.put("Путин", "Владимир");
        map.put("Медведев", "Дмитрий");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        int count=0;
        for(String s : map.values())
            if(s.equals(name)) count++;
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        //напишите тут ваш код
        int count=0;
        for(String s : map.keySet())
            if(s.equals(familiya)) count++;
        return count;
    }
}
