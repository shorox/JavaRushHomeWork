package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{
        int index = 0;
        if(string != null ? (string.length() == 0 ? true : (index = string.indexOf("\t")) == -1) : true)
            throw new TooShortStringException();
        int begin = index + 1;
        if((index = string.indexOf("\t", index + 1)) == -1)
            throw new TooShortStringException();
        return string.substring(begin, index);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException{
        System.out.println(getPartOfString("Первая табуляция\tВторая табуляция\tТретья табуляция"));
    }
}
