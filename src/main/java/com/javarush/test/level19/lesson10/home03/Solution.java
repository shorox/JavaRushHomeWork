package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(args[0]));
        while(r.ready()){
            String[] line = r.readLine().split(" ");
            String name = "";
            for(int i = 0; i < line.length - 3; i++)
                name += line[i] + (i + 1 == line.length - 3 ? "" : " ");
            int day = Integer.parseInt(line[line.length - 3]);
            int month = Integer.parseInt(line[line.length - 2]);
            int year = Integer.parseInt(line[line.length - 1]);
            try {
                Date birthDate = new SimpleDateFormat("dd MM yyyy").parse(day + " " + month + " " + year);
                PEOPLE.add(new Person(name, birthDate));
            } catch (ParseException e) {}
        }
        r.close();
    }

}
