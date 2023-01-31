package com.oracle.jp.slide;

import java.util.concurrent.Callable;

public class SimpleCallableTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "Hello world!";
    }

}
