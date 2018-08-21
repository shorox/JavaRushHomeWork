package com.javarush.test.level37.lesson04.big01.male;

import com.javarush.test.level37.lesson04.big01.AbstractFactory;
import com.javarush.test.level37.lesson04.big01.Human;

/**
 * Created by sharov on 12.04.2016.
 */
public class MaleFactory implements AbstractFactory{

    @Override
    public Human getPerson(int age){
        if(age <= 12)
            return new KidBoy();
        else if(age <= 19)
            return new TeenBoy();
        else
            return new Man();
    }
}
