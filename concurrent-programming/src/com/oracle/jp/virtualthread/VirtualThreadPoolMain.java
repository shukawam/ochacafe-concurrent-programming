package com.oracle.jp.virtualthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import com.oracle.jp.utils.DemoUtils;
import com.oracle.jp.utils.FizzBuzzTask;

public class VirtualThreadPoolMain {
    private static final Logger logger = Logger.getLogger(VirtualThreadMain.class.getName());

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        // Demo 1
        // ThreadFactory virtualThreadFactory = Thread.ofVirtual().factory();
        // createFixedThreadPool(virtualThreadFactory);

        // Demo 2
        ThreadFactory platformThreadFactory = Thread.ofPlatform().factory();
        createFixedThreadPool(platformThreadFactory);
        long end = System.currentTimeMillis();
        logger.info("Execution time: " + Long.toString(end - start) + "[ms]");
    }

    public static void createFixedThreadPool(ThreadFactory factory) {
        FizzBuzzTask task = new FizzBuzzTask();
        try (ExecutorService exector = Executors.newFixedThreadPool(200, factory)) {
            IntStream.rangeClosed(1, 10_000).forEach(i -> {
                exector.submit(() -> {
                    task.execWithSleep(i, 3_000);
                    DemoUtils.log(i + ": " + task.exec(i));
                });
            });
        }
    }
}
