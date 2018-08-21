package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Кенгуру on 20.12.2015.
 */
public class MyThread extends Thread {
    private static AtomicInteger priority = new AtomicInteger(Thread.MIN_PRIORITY);

    public MyThread() {
        this.setPriority(priority.get());
        priority.set(priority.get() == Thread.MAX_PRIORITY ? Thread.MIN_PRIORITY : priority.get() + 1);
    }

    public MyThread(Runnable target) {
        super(target);
        this.setPriority(priority.get());
        priority.set(priority.get() == Thread.MAX_PRIORITY ? Thread.MIN_PRIORITY : priority.get() + 1);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        this.setPriority(priority.get() >= group.getMaxPriority() ? group.getMaxPriority() : priority.get());
        priority.set(priority.get() == Thread.MAX_PRIORITY   ? Thread.MIN_PRIORITY : priority.get() + 1);
    }

    public MyThread(String name) {
        super(name);
        this.setPriority(priority.get());
        priority.set(priority.get() == Thread.MAX_PRIORITY ? Thread.MIN_PRIORITY : priority.get() + 1);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        this.setPriority(priority.get() >= group.getMaxPriority() ? group.getMaxPriority() : priority.get());
        priority.set(priority.get() == Thread.MAX_PRIORITY   ? Thread.MIN_PRIORITY : priority.get() + 1);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        this.setPriority(priority.get());
        priority.set(priority.get() == Thread.MAX_PRIORITY ? Thread.MIN_PRIORITY : priority.get() + 1);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        this.setPriority(priority.get() >= group.getMaxPriority() ? group.getMaxPriority() : priority.get());
        priority.set(priority.get() == Thread.MAX_PRIORITY   ? Thread.MIN_PRIORITY : priority.get() + 1);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        this.setPriority(priority.get() >= group.getMaxPriority() ? group.getMaxPriority() : priority.get());
        priority.set(priority.get() == Thread.MAX_PRIORITY   ? Thread.MIN_PRIORITY : priority.get() + 1);
    }


}
