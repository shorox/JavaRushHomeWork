package com.javarush.test.level14.lesson06.home01;

/**
 * Created by sharov on 11.09.2015.
 */
public class RussianHen extends Hen
{
    public int getCountOfEggsPerMonth(){ return 150; }

    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
