package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by sharov on 10.03.2016.
 */
public class Home extends GameObject {
    public Home(int x, int y) {
        super(x, y, 2, 2);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.drawOval(getX() - getWidth() / 2, getY() - getHeight() / 2, getWidth(), getHeight());
    }
}
