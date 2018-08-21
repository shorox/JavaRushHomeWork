package com.javarush.test.level30.lesson06.home01;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * Created by sharov on 11.01.2016.
 */
public class BinaryRepresentationTask extends RecursiveTask {
    private int i;

    public BinaryRepresentationTask(int i) {
        this.i = i;
    }

    @Override
    protected String compute() {
        String result = null;
        List<BinaryRepresentationTask> subTasks = new LinkedList<>();
        if(i >= 2) {
            result = String.valueOf(i % 2);
            BinaryRepresentationTask task = new BinaryRepresentationTask(i / 2);
            task.fork();
            subTasks.add(task);
        } if(i < 2 && i > 0){
            result = String.valueOf(i);
        }

        for(BinaryRepresentationTask task : subTasks) {
            result = String.valueOf(task.join()) + result;
        }
        return result;
    }
}
