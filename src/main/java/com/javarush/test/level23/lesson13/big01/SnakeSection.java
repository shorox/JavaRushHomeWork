package com.javarush.test.level23.lesson13.big01;

public class SnakeSection
{
    private int x;
    private int y;


    public SnakeSection(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        SnakeSection part = (SnakeSection) obj;
        if(part != null ? this.hashCode() != part.hashCode() : true) return false;
        if(part.getX() == this.getX() && part.getY() == this.getY()) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return 31 * this.x + this.y;
    }
}
