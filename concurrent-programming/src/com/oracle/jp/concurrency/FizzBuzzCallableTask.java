package com.oracle.jp.concurrency;

import java.util.concurrent.Callable;

import com.oracle.jp.utils.FizzBuzzTask;

public class FizzBuzzCallableTask implements Callable<String> {
    private final int input;
    private boolean isSleep = false;
    private long ms;

    /**
     * @param input
     */
    public FizzBuzzCallableTask(int input) {
        this.input = input;
    }

    /**
     * @param input
     * @param ms
     */
    public FizzBuzzCallableTask(int input, long ms) {
        this.input = input;
        this.ms = ms;
        isSleep = true;
    }

    @Override
    public String call() throws Exception {
        if (isSleep) {
            return new FizzBuzzTask().execWithSleep(input, ms);
        } else {
            return new FizzBuzzTask().exec(input);
        }
    }

}
