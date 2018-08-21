package com.javarush.test.level35.lesson04.home01;

public class GenericStatic {
    public static <T extends Object> T someStaticMethod(T genericObject) {
        System.out.println(genericObject);
        return (T)genericObject;
    }
}
