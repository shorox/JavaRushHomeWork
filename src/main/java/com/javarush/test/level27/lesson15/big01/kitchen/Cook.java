package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable{
    private LinkedBlockingQueue<Order> queue;
    private String name;
    private boolean busy;

    public Cook(String name) {
        this.name = name;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public boolean isBusy() {
        return busy;
    }

    public void startCookingOrder(Order order) throws InterruptedException {
        busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + "min");
        StatisticEventManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(), name, order.getTotalCookingTime() * 60, order.getDishes()));
        Thread.sleep(order.getTotalCookingTime() * 10);
        setChanged();
        notifyObservers(order);
        busy = false;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (!queue.isEmpty())
                    if (!this.isBusy()) this.startCookingOrder(queue.take());
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
    }
}
