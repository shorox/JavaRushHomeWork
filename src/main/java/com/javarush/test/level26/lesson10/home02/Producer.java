package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {
        try{
            int i = 0;
            while(true){
                i++;
                System.out.println(String.format("Some text for %d", i));
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            System.out.println(String.format("[thread-%d] thread was terminated", Thread.currentThread().getId()));
        }
        Thread currentThread = Thread.currentThread();
        while (!currentThread.isInterrupted()) {
            if (!map.isEmpty()) {
                for (String key : map.keySet()) {
                    System.out.println(map.remove(key));
                }
            }
        }
    }
}