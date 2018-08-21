package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by sharov on 27.11.2015.
 */
class WithdrawCommand implements Command{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(ConsoleHelper.askCurrencyCode());
        ConsoleHelper.writeMessage(res.getString("specify.amount"));
        while(true) {
            try {
                int sum = Integer.parseInt(ConsoleHelper.readString());
                if (sum <= 0) {ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount")); continue;}
                if (!manipulator.isAmountAvailable(sum)) {ConsoleHelper.writeMessage(res.getString("not.enough.money")); continue;}
                Map<Integer, Integer> map = manipulator.withdrawAmount(sum);
                for (Map.Entry<Integer, Integer> pair : map.entrySet())
                    ConsoleHelper.writeMessage(String.format("\t%d - %d", pair.getKey(), pair.getValue()));
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), sum, manipulator.getCurrencyCode()));
                break;
            } catch (NumberFormatException e) {ConsoleHelper.writeMessage(res.getString("specify.amount"));
            } catch (NotEnoughMoneyException e) {ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));}
        }
    }
}
