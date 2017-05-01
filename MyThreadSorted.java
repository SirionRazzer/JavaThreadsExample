package com.company;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author: Tomas Soukal
 *
 * Class represents thread for printing numbers in the range [0, 50] in sorted order.
 */
public class MyThreadSorted implements Runnable {

    public static final int MAX = 50; // any number >= 0
    private int threadNumber;
    private static Integer num = 0;
    private static BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(MAX + 1);

    public MyThreadSorted(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    /**
     * Increment counter if smaller than MAX
     *
     * @return true if counter was incremented
     */
    static synchronized boolean canIncrement() {
        if (num <= MAX) {
            bq.add(new Integer(num));
            num++;
            //for (long l = 0; l < 1000000000; l++) {};
            return true;
        }
        return false;
    }

    public void run() {

        Thread.currentThread().setName(Integer.toString(threadNumber));

        while (canIncrement()) {
            //for (long l = 0; l < 10000000; l++) {}
            synchronized (System.out) {
                //for (long l = 0; l < 1000000000; l++) {}
                try {
                    //for(long l = 0; l < 100000000; l++){}
                    System.out.println("vlakno " + Thread.currentThread().getName() + ": " + bq.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //for (long l = 0; l < 1000000000; l++) {}
            }
            //for (long l = 0; l < 1000000000; l++) {}
        }

    }
}