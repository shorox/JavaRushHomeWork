package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;
import com.javarush.test.level27.lesson15.big01.ad.StatisticAdvertisementManager;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by Кикимара on 30.01.2016.
 */
public class DirectorTablet {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

    public void printAdvertisementProfit(){
        Map<Date, Double> map = StatisticEventManager.getInstance().advertisementProfit();
        double total = 0d;

        for(Map.Entry<Date, Double> pair : map.entrySet()) {
            total += pair.getValue();
            ConsoleHelper.writeMessage(String.format("%s - %.2f", dateFormat.format(pair.getKey()), pair.getValue()));
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f", total));
    }

    public void printCookWorkloading(){
        Map<Date, Map<String, Integer>> map = StatisticEventManager.getInstance().cookWorkloading();
        for(Map.Entry<Date, Map<String, Integer>> pair : map.entrySet()) {
            ConsoleHelper.writeMessage("");
            ConsoleHelper.writeMessage(dateFormat.format(pair.getKey()));
            for(Map.Entry<String, Integer> sub : pair.getValue().entrySet())
                if(sub.getValue() > 0) ConsoleHelper.writeMessage(sub.getKey() + " - " + sub.getValue() + " min");
        }
    }

    public void printActiveVideoSet(){
        for(Advertisement ad : StatisticAdvertisementManager.getInstance().activeVideoSet())
            ConsoleHelper.writeMessage(String.format("%s - %d", ad.getName(), ad.getHits()));
    }

    public void printArchivedVideoSet(){
        for(Advertisement ad : StatisticAdvertisementManager.getInstance().archivedVideoSet())
            ConsoleHelper.writeMessage(ad.getName());
    }
}
