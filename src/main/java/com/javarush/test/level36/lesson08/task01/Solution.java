package com.javarush.test.level36.lesson08.task01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

/* Использование TreeSet
Первым параметром приходит имя файла: файл1.
файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
Отсортировать буквы по алфавиту и вывести на экран первые 5 различных букв в одну строку без разделителей.
Если файл1 содержит менее 5 различных букв, то вывести их все.
Буквы различного регистра считаются одинаковыми.
Регистр выводимых букв не влияет на результат.
Закрыть потоки.

Пример 1 данных входного файла:
zBk yaz b-kN
Пример 1 вывода:
abkny

Пример 2 данных входного файла:
caAC
A, aB? bB
Пример 2 вывода:
abc

Подсказка: использовать TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String str = "abcdefghijklmnopqrstuvwxyz";
        TreeSet<Character> set = new TreeSet<>();
        try(InputStreamReader in = new InputStreamReader(new FileInputStream(new File(args[0])))){
            while(in.ready()){
                Character ch = Character.toLowerCase((char) in.read());
                if(str.contains(ch.toString()))
                    set.add(ch);
            }
        }catch (IOException e){
        }
        Iterator<Character> it = set.iterator();
        int n = set.size() < 5 ? set.size() : 5;
        for(int i = 0;  i < n; i++) System.out.print(it.next());
    }
}
