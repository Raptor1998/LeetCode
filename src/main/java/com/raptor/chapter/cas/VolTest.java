package com.raptor.chapter.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author raptor
 * @description VolTest
 * @date 2022/3/21 17:34
 */
public class VolTest {
    public volatile int num = 0;
    AtomicInteger atomicInteger = new AtomicInteger();

    public void incr() {
        num++;
    }

    public void incr2() {
        atomicInteger.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        VolTest volTest = new VolTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    volTest.incr2();
                }
            }).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        Thread.sleep(5000);
        System.out.println(volTest.atomicInteger);
    }
}
