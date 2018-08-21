package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sharov on 25.11.2015.
 */
public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> manipulatorByCurrencyCode = new HashMap<>();

    private CurrencyManipulatorFactory(){}

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        if(!manipulatorByCurrencyCode.containsKey(currencyCode))
            manipulatorByCurrencyCode.put(currencyCode, new CurrencyManipulator(currencyCode));
        return manipulatorByCurrencyCode.get(currencyCode);
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return manipulatorByCurrencyCode.values();
    }
}
