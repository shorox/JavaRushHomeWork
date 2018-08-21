package com.javarush.test.level31.lesson06.home01;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/com.javarush.test.zip

Файлы внутри com.javarush.test.zip:
a.txt
b.txt

После запуска Solution.main архив com.javarush.test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static void main(String[] args) {
        File fileName = new File(args[0]);
        File zipFile = new File(args[1]);

        Map<String, byte[]> map = new HashMap<>();

        try (ZipInputStream zIn = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry zipEntry;
            while ((zipEntry = zIn.getNextEntry()) != null) {
                if (!zipEntry.getName().equals("new/" + fileName.getName())) {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] b = new byte[1024];
                    int count;
                    while ((count = zIn.read(b)) != -1) baos.write(b, 0, count);
                    map.put(zipEntry.getName(), baos.toByteArray());
                    zIn.closeEntry();
                }
            }
        } catch (IOException e) {
        }

        try (ZipOutputStream zOut = new ZipOutputStream(new FileOutputStream(zipFile))) {
            for (Map.Entry<String, byte[]> pair : map.entrySet()) {
                zOut.putNextEntry(new ZipEntry(pair.getKey()));
                zOut.write(pair.getValue());
                zOut.closeEntry();
            }
        } catch (IOException e) {
        }
    }
}
