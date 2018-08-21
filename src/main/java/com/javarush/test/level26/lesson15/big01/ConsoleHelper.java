package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.IllegalFormatException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

/**
 * Created by sharov on 25.11.2015.
 */
public class ConsoleHelper {
    private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException{
        String s = "";
        try {
            s = r.readLine();
            if ("EXIT".equalsIgnoreCase(s)) throw new InterruptOperationException();
        } catch (IOException e) {}
        return s;
    }

    public static String askCurrencyCode() throws InterruptOperationException{
        writeMessage(res.getString("choose.currency.code"));
        String code = null;
        while((code = readString()).length() != 3) writeMessage(res.getString("invalid.data"));
        return code.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException{
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
        while(true) {
            try {
                String sCurrAndCount = readString();
                if (sCurrAndCount == null) throw new NumberFormatException();
                String[] aCurrAndCount = sCurrAndCount.split(" ");
                if (aCurrAndCount.length != 2) throw new NumberFormatException();
                int currency = Integer.parseInt(aCurrAndCount[0]);
                int count = Integer.parseInt(aCurrAndCount[1]);
                if (currency <= 0 || count <= 0) throw new NumberFormatException();
                return new String[]{aCurrAndCount[0], aCurrAndCount[1]};
            } catch (NumberFormatException e) {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static Operation askOperation() throws InterruptOperationException{
        writeMessage(String.format("\n\n1. %s\n2. %s\n3. %s\n4. %s\n\n%s: ", res.getString("operation.INFO"),
                res.getString("operation.DEPOSIT"), res.getString("operation.WITHDRAW"), res.getString("operation.EXIT"),
                res.getString("choose.operation")));
        while(true) {
            String s = readString();
            if(Pattern.compile("^[0-4]$").matcher(s).matches()) {
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(s));
            }else writeMessage(res.getString("invalid.data"));
        }
    }

    public static void printExitMessage(){
        writeMessage(res.getString("the.end"));
    }
}
