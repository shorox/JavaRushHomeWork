package com.javarush.test.level14.lesson08.bonus01;

import java.util.ArrayList;
import java.util.List;
import java.lang.*;
import java.text.*;
import java.util.*;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try { float i = 1 / 0; } catch (Exception e) { exceptions.add(e); }

        //Add your code here
        try{ throw new NullPointerException(); } catch (NullPointerException e){ exceptions.add(e); }

        try{ throw new CloneNotSupportedException(); } catch (CloneNotSupportedException e){ exceptions.add(e); }

        try{ throw new ParseException("text", 0); } catch (ParseException e){ exceptions.add(e); }

        try{ throw new StringIndexOutOfBoundsException(); } catch (StringIndexOutOfBoundsException e){ exceptions.add(e); }

        try{ throw new NumberFormatException(); } catch (NumberFormatException e){ exceptions.add(e); }

        try{ throw new ClassCastException(); } catch (ClassCastException e){ exceptions.add(e); }

        try{ throw new ArrayIndexOutOfBoundsException(); } catch (ArrayIndexOutOfBoundsException e){ exceptions.add(e); }

        try{ throw new NoSuchElementException(); } catch (NoSuchElementException e){ exceptions.add(e); }

        try{ throw new IndexOutOfBoundsException(); } catch (IndexOutOfBoundsException e){ exceptions.add(e); }
    }
}
