package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sharov on 04.03.2016.
 */
public class FunctionalTest {
    public void testStorage(Shortener shortener){
        String line1 = Helper.generateRandomString();
        String line2 = Helper.generateRandomString();
        String line3 = line1;
        Long id1 = shortener.getId(line1);
        Long id2 = shortener.getId(line2);
        Long id3 = shortener.getId(line3);
        Assert.assertNotEquals(id2, id1);
        Assert.assertNotEquals(id2, id3);
        Assert.assertEquals(id1, id3);
        Assert.assertEquals(line1, shortener.getString(id1));
        Assert.assertEquals(line2, shortener.getString(id2));
        Assert.assertEquals(line3, shortener.getString(id3));
    }

    @Test
    public void testHashMapStorageStrategy(){
        testStorage(new Shortener(new HashMapStorageStrategy()));
    }

    @Test
    public void testOurHashMapStorageStrategy(){
        testStorage(new Shortener(new OurHashMapStorageStrategy()));
    }

    @Test
    public void testFileStorageStrategy(){
        testStorage(new Shortener(new FileStorageStrategy()));
    }

    @Test
    public void testHashBiMapStorageStrategy(){
        testStorage(new Shortener(new HashBiMapStorageStrategy()));
    }

    @Test
    public void testDualHashBidiMapStorageStrategy(){
        testStorage(new Shortener(new DualHashBidiMapStorageStrategy()));
    }

    @Test
    public void testOurHashBiMapStorageStrategy(){
        testStorage(new Shortener(new OurHashBiMapStorageStrategy()));
    }
}
