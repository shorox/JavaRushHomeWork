package com.javarush.test.level27.lesson15.big01.ad;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Кикимара on 01.02.2016.
 */
public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    private StatisticAdvertisementManager() {
    }

    public Set<Advertisement> activeVideoSet() {
        Set<Advertisement> set = new TreeSet<>(
                new Comparator<Advertisement>() {
                    @Override
                    public int compare(Advertisement o1, Advertisement o2) {
                        return o1.getName().compareToIgnoreCase(o2.getName());
                    }
                });
        for (Advertisement ad : advertisementStorage.list())
            if (ad.getHits() >= 1)
                set.add(ad);
        return set;
    }

    public Set<Advertisement> archivedVideoSet(){
        Set<Advertisement> set = new TreeSet<>(
                new Comparator<Advertisement>() {
                    @Override
                    public int compare(Advertisement o1, Advertisement o2) {
                        return o1.getName().compareToIgnoreCase(o2.getName());
                    }
                });
        for(Advertisement ad : advertisementStorage.list())
            if(ad.getHits() == 0) set.add(ad);
        return set;
    }
}
