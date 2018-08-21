package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;
import java.util.Map.Entry;

/**
 * Created by sharov on 25.11.2015.
 */
public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new TreeMap<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public String getCurrencyCode() {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode) {this.currencyCode = currencyCode; }

    public void addAmount(int denomination, int count){
        denominations.put(denomination, denominations.containsKey(denomination) ? denominations.get(denomination) + count : count);
    }

    public int getTotalAmount(){
        int total = 0;
        for(Entry<Integer, Integer> pair : denominations.entrySet()) total += pair.getKey() * pair.getValue();
        return total;
    }

    public boolean hasMoney(){
        return denominations.size() > 0;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        try {
            Map<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            int amount = expectedAmount;
            for (Entry<Integer, Integer> pair : denominations.entrySet()) {
                for (int count = pair.getValue(); count > 0; count--)
                    if (pair.getKey() * count <= amount) {
                        map.put(pair.getKey(), count);
                        amount -= pair.getKey() * count;
                        break;
                    }
            }
            if (amount > 0) throw new NotEnoughMoneyException();
            for (Entry<Integer, Integer> pair : map.entrySet())
                if (denominations.get(pair.getKey()) - pair.getValue() == 0) denominations.remove(pair.getKey());
                else denominations.put(pair.getKey(), denominations.get(pair.getKey()) - pair.getValue());
            return map;
        } catch (ConcurrentModificationException e) {
            return null;
        }
    }

    public boolean isAmountAvailable(int expectedAmount){
        return this.getTotalAmount() - expectedAmount >= 0;
    }
}
