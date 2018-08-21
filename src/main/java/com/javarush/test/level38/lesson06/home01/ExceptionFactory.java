package com.javarush.test.level38.lesson06.home01;

/**
 * Created by sharov on 19.04.2016.
 */
public class ExceptionFactory {
    public static Throwable getFactoryClass(Enum message) {
        if(message != null) {
            String s = message.name().substring(0, 1).toUpperCase() + message.name().substring(1).toLowerCase().replace("_", " ");
            if (message instanceof ExceptionApplicationMessage) return new Exception(s);
            else if (message instanceof ExceptionDBMessage) return new RuntimeException(s);
            else if (message instanceof ExceptionUserMessage) return new Error(s);
        }
        return new IllegalArgumentException();
    }
}
