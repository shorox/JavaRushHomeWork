package com.javarush.test.level31.lesson06.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/com.javarush.test.zip.003
C:/pathToTest/com.javarush.test.zip.001
C:/pathToTest/com.javarush.test.zip.004
C:/pathToTest/com.javarush.test.zip.002
*/
public class Solution {
    public static void main(String[] args) {
        File resultFileName = new File(args[0]);
        List<File> listFiles = new ArrayList<>();
        for(int i = 1; i < args.length; i++){
            listFiles.add(new File(args[i]));
        }
        Collections.sort(listFiles);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for(File file : listFiles) {
            try (FileInputStream in = new FileInputStream(file)) {
                byte[] b = new byte[2048];
                int count;
                while ((count = in.read(b)) != -1) baos.write(b, 0, count);
                baos.flush();
            } catch (IOException e) {
            }
        }

        try(
                ZipInputStream zIn = new ZipInputStream(new ByteArrayInputStream(baos.toByteArray()));
                FileOutputStream out = new FileOutputStream(resultFileName);
        ) {
            ZipEntry entry;
            while((entry = zIn.getNextEntry()) != null){
                byte[] b = new byte[2048];
                int count;
                while((count = zIn.read(b)) != -1) out.write(b, 0, count);
                out.flush();
            }
        }catch (IOException e){
        }
    }
}
