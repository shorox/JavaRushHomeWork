package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new ArrayList<>();
        File folder = new File(root);
        while(folder != null) {
            for (File file : folder.listFiles()) list.add(file.getAbsolutePath());
            folder = null;
            for(int i = 0; i < list.size(); i++) {
                File tmp = new File(list.get(i));
                if (tmp.isDirectory()) {
                    folder = tmp;
                    list.remove(i);
                    break;
                }
            }
        }
        return list;
    }
}
