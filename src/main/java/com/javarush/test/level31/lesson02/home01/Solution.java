package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {
    public static void main(String[] args) {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        if (allFilesContent.exists()) allFilesContent.delete();

        List<File> list = new LinkedList<>();
        solve(path, resultFileAbsolutePath, list);

        Collections.sort(list, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        try (FileOutputStream out = new FileOutputStream(resultFileAbsolutePath)) {
            while (list.size() > 0) {
                try (FileInputStream in = new FileInputStream(list.get(0))) {
                    byte[] b = new byte[in.available()];
                    in.read(b);
                    out.write(b);
                    list.remove(0);
                    if (list.size() > 0) out.write("\r\n".getBytes());
                }
            }
        } catch (IOException e) {
        }

        resultFileAbsolutePath.renameTo(allFilesContent);
        deleteDirect(path);
    }

    public static void solve(File file, File resultFileAbsolutePath, List<File> list) {
        if (file.equals(resultFileAbsolutePath)) return;
        if (file.isDirectory()) {
            for (File directory : file.listFiles()) solve(directory, resultFileAbsolutePath, list);
        } else if (file.isFile()) {
            if (file.length() > 50) file.delete();
            else list.add(file);
        }
    }

    public static void deleteDirect(File path){
        if(path.isDirectory()){
            for(File direct: path.listFiles()) deleteDirect(direct);
            if(path.listFiles().length == 0) path.delete();
        }
    }
}
