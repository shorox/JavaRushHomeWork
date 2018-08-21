package com.javarush.test.level38.lesson10.home02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= ElementType.FIELD)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface Author {
    //напиши свой код
    String value() default "";
    Position position() default Position.OTHER;
}
