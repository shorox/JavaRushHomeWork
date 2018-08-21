package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by sharov on 16.09.2015.
 */
public class LatteMaker  extends DrinkMaker
{
    void getRightCup(){ System.out.println("Берем чашку для латте"); }

    void putIngredient(){ System.out.println("Делаем кофе"); }

    void pour(){
        System.out.println("Заливаем молоком с пенкой");
    }
}
