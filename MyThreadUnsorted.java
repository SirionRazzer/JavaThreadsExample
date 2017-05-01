package com.company;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Tomas Soukal
 *
 * EXAMPLE OUTPUT:
 * ...
 * 2: 45
 * 2: 46
 * 2: 49
 * 2: 50
 * 3: 48
 * 1: 47
 *
 * Class represents thread for printing numbers in the range [0, 50] in unsorted order.
 */
public class MyThreadUnsorted implements Runnable {

    private int threadNumber;
    private static AtomicInteger num = new AtomicInteger(0);

    public MyThreadUnsorted(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    public void run() {
        int v;

        Thread.currentThread().setName(Integer.toString(threadNumber));
        //for(long l = 0; l < 1000000000; l++){}
        while ((v = num.getAndIncrement()) <= 50) {
            //for(long l = 0; l < 1000000000; l++){}

            System.out.println("vlakno " + Thread.currentThread().getName() + ": " + v);
            //for(long l = 0; l < 100000000; l++){}

        }
    }
}


