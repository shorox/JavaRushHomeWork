package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by sharov on 02.12.2015.
 */
public class LoginCommand implements Command {

    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        ConsoleHelper.writeMessage(res.getString("specify.data"));
        String sCard = "";
        while(true){
            try{
                sCard = ConsoleHelper.readString();
                String sPin = ConsoleHelper.readString();
                if(sCard.length() != 12 || sPin.length() != 4){
                    ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                    continue;
                }
                long card = Long.parseLong(sCard);
                int pin = Integer.parseInt(sPin);
                if(validCreditCards.containsKey(String.valueOf(card)) ?
                        pin != Integer.parseInt(validCreditCards.getString(String.valueOf(card))) : true)
                    throw new NumberFormatException();
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), card));
                break;
            }catch (NumberFormatException e){
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), sCard));
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
            }
        }
    }
}
