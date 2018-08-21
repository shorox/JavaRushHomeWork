package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

/**
 * Created by sharov on 27.01.2016.
 */
public class StatisticEventManager {
    private static StatisticEventManager ourInstance = new StatisticEventManager();
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticEventManager() {
    }

    public static StatisticEventManager getInstance() {
        return ourInstance;
    }

    public void register(EventDataRow data) {
        //TODO
        if (data != null) statisticStorage.put(data);
    }

    public Map<Date, Double> advertisementProfit(){
        Map<Date, Double> map = new TreeMap<>(Collections.reverseOrder());
        for(EventDataRow even : statisticStorage.getEvent(EventType.SELECTED_VIDEOS)){
            VideoSelectedEventDataRow row = (VideoSelectedEventDataRow) even;
            Date date = new Date(row.getDate().getYear(), row.getDate().getMonth(), row.getDate().getDay());
            map.put(date, (0.01d * (double) row.getAmount()) + (map.containsKey(date) ? map.get(date) : 0d));
        }
        return map;
    }

    public Map<Date, Map<String, Integer>> cookWorkloading(){
        Map<Date, Map<String, Integer>> map = new TreeMap<>(Collections.reverseOrder());
        for(EventDataRow even : statisticStorage.getEvent(EventType.COOKED_ORDER)) {
            CookedOrderEventDataRow row = (CookedOrderEventDataRow) even;
            Date date = new Date(row.getDate().getYear(), row.getDate().getMonth(), row.getDate().getDay());
            if(row.getTime() != 0) {
                if (!map.containsKey(date)) map.put(date, new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER));
                map.get(date).put(row.getCookName(), (int)((row.getTime() + 59) / 60) +
                        (map.get(date).containsKey(row.getCookName()) ? map.get(date).get(row.getCookName()): 0));
            }
        }
        return map;
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> eventMap = new HashMap<>();

        private StatisticStorage() {
            for (EventType eventType : EventType.values())
                eventMap.put(eventType, new ArrayList<EventDataRow>());
        }

        private void put(EventDataRow data) {
            if (data != null) eventMap.get(data.getType()).add(data);
        }

        private List<EventDataRow> getEvent(EventType eventType){
            return eventMap.get(eventType);
        }
    }
}
