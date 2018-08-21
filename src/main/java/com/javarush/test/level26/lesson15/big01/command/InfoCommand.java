package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.*;

import java.util.ResourceBundle;

/**
 * Created by sharov on 27.11.2015.
 */
class InfoCommand implements Command{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");

    @Override
    public void execute() {
        ConsoleHelper.writeMessage(res.getString("before"));
        boolean isMoney = false;
        for (CurrencyManipulator currency : CurrencyManipulatorFactory.getAllCurrencyManipulators())
            if(currency.hasMoney()) {
                isMoney = true;
                System.out.println(String.format("%s - %d", currency.getCurrencyCode(),
                        CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency.getCurrencyCode()).
                                getTotalAmount()));
            }
        if(!isMoney) ConsoleHelper.writeMessage(res.getString("no.money"));
    }
}
