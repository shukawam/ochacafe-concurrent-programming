package com.oracle.jp.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import com.oracle.jp.utils.DemoUtils;

public class SimpleThreadPoolMain {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        IntStream.rangeClosed(1, 100).forEach(i -> {
            threadPool.submit(() -> {
                DemoUtils.log(Integer.toString(i));
            });
        });
    }
}
