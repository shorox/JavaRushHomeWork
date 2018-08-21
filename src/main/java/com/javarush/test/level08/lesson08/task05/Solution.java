package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        HashMap<String, String> copymap = new HashMap<String, String>(map);
        for(Map.Entry<String, String> pair : copymap.entrySet())
            removeItemFromMapByValue(map, pair.getValue());

        for(Map.Entry<String, String> p : map.entrySet())
            System.out.println(p.getKey() + " - " + p.getValue());
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        String key=null;
        boolean flag=true;
        for (Map.Entry<String, String> pair: copy.entrySet())
            if (pair.getValue().equals(value))
                if(key==null)
                    key=pair.getKey();
                else
                {
                    if (flag) {map.remove(key); flag=false;}
                    map.remove(pair.getKey());
                }
    }

    public static void main(String[] args)
    {
        removeTheFirstNameDuplicates(createMap());
    }
}
