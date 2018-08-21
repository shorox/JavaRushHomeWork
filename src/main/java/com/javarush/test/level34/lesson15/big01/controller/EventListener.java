package com.javarush.test.level34.lesson15.big01.controller;

import com.javarush.test.level34.lesson15.big01.model.Direction;

/**
 * Created by sharov on 10.03.2016.
 */
public interface EventListener {
    void move(Direction direction); // передвинуть объект в определенном направлении.
    void restart();                 // начать заново текущий уровень.
    void startNextLevel();          // начать следующий уровень.
    void levelCompleted(int level); // уровень с номером level завершён.
}
