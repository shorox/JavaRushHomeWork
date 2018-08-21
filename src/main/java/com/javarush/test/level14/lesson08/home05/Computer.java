package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Кенгуру on 12.09.2015.
 */
public class Computer
{
    private Keyboard keyboard;

    private Mouse mouse;

    private Monitor monitor;

    public Computer() {
        this.keyboard = new Keyboard();
        this.mouse = new Mouse();
        this.monitor = new Monitor();
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public Monitor getMonitor() {
        return monitor;
    }
}
