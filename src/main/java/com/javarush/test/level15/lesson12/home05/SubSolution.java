package com.javarush.test.level15.lesson12.home05;

import java.math.BigInteger;

/**
 * Created by sharov on 16.09.2015.
 */
public class SubSolution extends Solution
{
    SubSolution(long l) { super(l); }

    SubSolution(double d) { super(d); }

    SubSolution(float f) { super(f); }

    protected SubSolution(Integer i) { super(i); }

    protected SubSolution(BigInteger b) { super(b); }

    protected SubSolution(Number n) { super(n); }

    public SubSolution(char ch) { super(ch); }

    public SubSolution(Double d) { super(d); }

    public SubSolution(Float f) { super(f); }

    private SubSolution(Object o){}

    private SubSolution(int i){}

    private SubSolution(String s){}
}
