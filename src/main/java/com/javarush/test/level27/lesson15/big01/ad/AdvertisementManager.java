package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class AdvertisementManager {
    private static final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    List<Advertisement> resultList = new ArrayList<>();

    private void shadowMethod(List<Advertisement> temp, int iteration) {
        if (temp == null) temp = new ArrayList<>();
        for (int i = iteration; i < storage.list().size(); i++) {
            int currentTime = 0;
            for(Advertisement ad : temp) currentTime += ad.getDuration();
            if ((storage.list().get(i).getHits() > 0) && (currentTime + storage.list().get(i).getDuration() <= timeSeconds) && !temp.contains(storage.list().get(i))) {
                temp.add(storage.list().get(i));
                if (i + 1 < storage.list().size())
                    shadowMethod(temp, i + 1);
            }
        }
        if (temp.size() > 0) {
            int profit1 = 0, profit2 = 0, time1 = 0, time2 = 0, countMovie1 = 0, countMovie2 = 0;
            for (Advertisement o1 : resultList) {
                profit1 += o1.getAmountPerOneDisplaying();
                time1 += o1.getDuration();
                countMovie1 += o1.getHits();
            }
            for (Advertisement o2 : temp) {
                profit2 += o2.getAmountPerOneDisplaying();
                time2 += o2.getDuration();
                countMovie2 += o2.getHits();
            }
            if ((profit2 > profit1) || ((profit2 == profit1) && ((time2 > time1) || ((time2 == time1) && (countMovie2 < countMovie1)))))
                resultList = new ArrayList<>(temp);
            temp.remove(temp.size() - 1);
        }
    }

    public void processVideos() {
        Collections.sort(storage.list(), new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
            }
        });
        shadowMethod(null, 0);
        List<Advertisement> advertisements = resultList;
        if (advertisements.isEmpty()) throw new NoVideoAvailableException();
        Collections.sort(advertisements, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int result = Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
                return result != 0 ? result : Long.compare(o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration(),
                        o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration());
            }
        });
        long amount = 0;
        int totalDuration = 0;
        for (Advertisement ad : advertisements){
            amount += ad.getAmountPerOneDisplaying();
            totalDuration += ad.getDuration();
        }
        StatisticEventManager.getInstance().register(new VideoSelectedEventDataRow(advertisements, amount, totalDuration));
        for (Advertisement advertisement : advertisements) {
            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... "
                    + advertisement.getAmountPerOneDisplaying() + ", "
                    + advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration());
            advertisement.revalidate();
        }
    }
}
