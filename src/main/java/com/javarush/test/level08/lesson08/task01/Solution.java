package com.javarush.test.level08.lesson08.task01;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        //напишите тут ваш код
        HashSet<String> set = new HashSet<String>();
        set.add("лоб");
        set.add("лук");
        set.add("ложь");
        set.add("лень");
        set.add("лорд");
        set.add("лед");
        set.add("лак");
        set.add("лен");
        set.add("лиса");
        set.add("лик");
        set.add("лекарство");
        set.add("локон");
        set.add("лада");
        set.add("лена");
        set.add("лес");
        set.add("луна");
        set.add("лупа");
        set.add("лоджия");
        set.add("ланита");
        set.add("лезвие");
        return set;
    }
}
