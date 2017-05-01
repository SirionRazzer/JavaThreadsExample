package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: Tomas Soukal
 *
 * Class for handling threads
 */
public class ThreadHandler implements Runnable {

    private int threadNum = 3;

    @Override
    public void run() {

        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        for (int i = 1; i <= threadNum; i++) {
            executorService.execute(new MyThreadSorted(i));
        }
        executorService.shutdown();
    }
}
