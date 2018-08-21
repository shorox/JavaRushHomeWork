package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by sharov on 11.01.2016.
 */
public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int n = 1; n <= 9; n++) {
                System.out.format("Элемент 'ShareItem-%d' добавлен\n", n);
                queue.offer(new ShareItem("ShareItem-" + n, n));
                Thread.sleep(100);
                if(queue.hasWaitingConsumer())
                    System.out.println("Consumer в ожидании!");
            }

        } catch (InterruptedException e) {
        }
    }
}
