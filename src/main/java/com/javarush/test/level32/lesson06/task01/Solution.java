package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        char[] symb = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        outputStream.write(String.valueOf(new Random().nextInt(9)).toCharArray()[0]);
        outputStream.write(String.valueOf(new Random().nextInt(9)).toCharArray()[0]);
        outputStream.write(String.valueOf(new Random().nextInt(9)).toCharArray()[0]);
        outputStream.write(String.valueOf(new Random().nextInt(9)).toCharArray()[0]);
        outputStream.write(symb[symb.length / 2 + new Random().nextInt(symb.length / 2)]);
        outputStream.write(symb[new Random().nextInt(symb.length / 2)]);
        outputStream.write(symb[symb.length / 2 + new Random().nextInt(symb.length / 2)]);
        outputStream.write(symb[new Random().nextInt(symb.length / 2)]);
        return outputStream;
    }
}
