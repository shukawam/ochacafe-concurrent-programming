package com.oracle.jp.utils;

import java.util.concurrent.TimeUnit;

public class DemoUtils {

    private DemoUtils() {
    }

    public static void log(String message) {
        System.out.println(String.format("[%s]: %s", Thread.currentThread().getName(), message));
    }

    public static void sleep(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

}
