package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String file1 = r.readLine();
        String file2 = r.readLine();
        r.close();

        BufferedReader f1 = new BufferedReader(new FileReader(file1));
        BufferedReader f2 = new BufferedReader(new FileReader(file2));

        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();

        while(f1.ready()) list1.add(f1.readLine());
        while(f2.ready()) list2.add(f2.readLine());

        f1.close();
        f2.close();

        while(list1.size() > 0 || list2.size() > 0)
        {
            if(list1.size() == 0 && list2.size() > 0 && lines.get(lines.size() - 1).type.equals(Type.SAME)){
                lines.add(new LineItem(Type.ADDED, list2.get(0)));
                list2.remove(0);
                break;
            } else if(list1.size() > 0 && list2.size() == 0 && lines.get(lines.size() - 1).type.equals(Type.SAME)){
                lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                list1.remove(0);
                break;
            } else if (list1.get(0).equals(list2.get(0))) {
                lines.add(new LineItem(Type.SAME, list1.get(0)));
                list1.remove(0);
                list2.remove(0);
            }
            else if (list1.get(1).equals(list2.get(0))) {
                lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                list1.remove(0);
            }
            else if ( list2.get(1).equals(list1.get(0))) {
                lines.add(new LineItem(Type.ADDED, list2.get(0)));
                list2.remove(0);
            }
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
