package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by sharov on 27.11.2015.
 */
interface Command {
    void execute() throws InterruptOperationException;
}
