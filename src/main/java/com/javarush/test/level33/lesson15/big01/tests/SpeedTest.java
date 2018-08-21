package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import org.junit.Assert;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sharov on 04.03.2016.
 */
public class SpeedTest {
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        Date startTime = new Date();
        for(String s : strings) ids.add(shortener.getId(s));
        return new Date().getTime() - startTime.getTime();
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Date startTime = new Date();
        for(Long id : ids) strings.add(shortener.getString(id));
        return new Date().getTime() - startTime.getTime();
    }

    public void testHashMapStorage(){
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++) origStrings.add(Helper.generateRandomString());
        Set<Long> ids1 = new HashSet<>();
        long time1 = getTimeForGettingIds(shortener1, origStrings, ids1);
        Set<Long> ids2 = new HashSet<>();
        long time2 = getTimeForGettingIds(shortener2, origStrings, ids2);
        Assert.assertTrue(time1 > time2);
        Set<String> strings1 = new HashSet<>();
        long time3 = getTimeForGettingStrings(shortener1, ids1, strings1);
        Set<String> strings2 = new HashSet<>();
        long time4 = getTimeForGettingStrings(shortener2, ids2, strings2);
        Assert.assertEquals((float) time3, (float) time4, 5f);

    }
}
