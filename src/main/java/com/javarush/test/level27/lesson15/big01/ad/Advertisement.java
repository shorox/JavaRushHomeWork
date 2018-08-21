package com.javarush.test.level27.lesson15.big01.ad;

public class Advertisement {
    private Object content; // видео
    private String name; // название
    private long initialAmount; // общая сумма в копейках
    private int hits; // количество оплаченных показов
    private int duration; // продолжительность в секундах

    private long amountPerOneDisplaying; // сумма в копейках за показ одного данного видео

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = initialAmount / hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public int getHits() {
        return hits;
    }

    public void revalidate(){
        if (hits <= 0) throw new UnsupportedOperationException();
        amountPerOneDisplaying = Math.round(initialAmount * 1.0 / hits);
        initialAmount -= amountPerOneDisplaying;
        hits--;
    }
}
