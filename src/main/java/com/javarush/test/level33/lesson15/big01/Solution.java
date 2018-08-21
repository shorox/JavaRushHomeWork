package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sharov on 29.02.2016.
 */
public class Solution {
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> set = new HashSet<>();
        for (String string : strings) set.add(shortener.getId(string));
        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> set = new HashSet<>();
        for(Long key : keys) set.add(shortener.getString(key));
        return set;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) set.add(Helper.generateRandomString());
        Shortener shortener = new Shortener(strategy);
        long t1 = new Date().getTime();
        Set<Long> keys = getIds(shortener, set);
        Helper.printMessage(String.valueOf(new Date().getTime() - t1));
        long t2 = new Date().getTime();
        Set<String> values = getStrings(shortener, keys);
        Helper.printMessage(String.valueOf(new Date().getTime() - t2));
        if (set.equals(values)) Helper.printMessage("Тест пройден.");
        else Helper.printMessage("Тест не пройден.");
    }

    public static void main(String[] args){
        testStrategy(new HashMapStorageStrategy(), 10000L);
        testStrategy(new OurHashMapStorageStrategy(), 10000L);
        testStrategy(new FileStorageStrategy(), 100L);
        testStrategy(new OurHashBiMapStorageStrategy(), 10000L);
        testStrategy(new HashBiMapStorageStrategy(), 10000L);
        testStrategy(new DualHashBidiMapStorageStrategy(), 10000L);
    }
}
