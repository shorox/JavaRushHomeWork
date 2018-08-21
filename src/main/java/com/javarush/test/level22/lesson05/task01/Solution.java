package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        int index = 0;
        if(string != null ? (string.length() == 0 ? true : (index = string.indexOf(" ")) == -1) : true)
            throw new TooShortStringException();
        int begin = index + 1;
        for(int i = 1; i <= 4; i++)
            if((index = string.indexOf(" ", index + 1)) == -1)
                throw new TooShortStringException();
        return string.substring(begin, index);
    }

    public static class TooShortStringException extends Exception{
    }

    public static void main(String[] args) throws TooShortStringException{
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }
}
