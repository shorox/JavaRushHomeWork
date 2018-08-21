package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Кикимара on 13.09.2015.
 */
public class USD extends Money
{
    public USD(double amount) {
        super(amount);
    }

    public String getCurrencyName(){ return "USD"; }
}
