package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by sharov on 21.10.2015.
 */
public class Hippodrome {
    private ArrayList<Horse> horses = new ArrayList<>();

    public static Hippodrome game;
    
    public ArrayList<Horse> getHorses() {return horses;}

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome();
        Horse lola = new Horse("Лола", 3.0, 0.0);
        Horse nochka = new Horse("Ночка", 3.0, 0.0);
        Horse buyak = new Horse("Буяк", 3.0, 0.0);
        game.getHorses().add(lola);
        game.getHorses().add(nochka);
        game.getHorses().add(buyak);
        game.run();
        game.printWinner();
    }

    public void run() throws InterruptedException {
        for(int i = 1; i <= 100; i++){
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move(){
        for(Horse horse : getHorses()){
            horse.move();
        }
    }

    public void print(){
        for(Horse horse : getHorses()){
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner(){
        if(getHorses().size() > 0){
            Horse winner = new Horse(null, 0.0, 0.0);
            for(Horse horse : getHorses())
                if(winner.getDistance() < horse.getDistance())
                    winner = horse;
            return winner.getName() != null ? winner : null;
        }
        return null;
    }

    public void printWinner(){
        String name = getWinner().getName();
        if(name != null) System.out.println("Winner is " + name + "!");}
}
