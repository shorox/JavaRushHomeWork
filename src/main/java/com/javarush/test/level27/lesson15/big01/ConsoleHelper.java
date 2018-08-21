package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return r.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        writeMessage("Выберите блюдо " + Dish.allDishesToString() + ", для выхода exit");
        while (true) {
            String s = readString();
            if (s.equalsIgnoreCase("exit")) break;
            try {
                dishes.add(Dish.valueOf(s));
            } catch (IllegalArgumentException e) {
                writeMessage(s + " is not detected");
            }
        }
        return dishes;
    }
}
