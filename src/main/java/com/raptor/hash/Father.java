package com.raptor.hash;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class Father {
    private int a;
    Lock lock= new ReentrantLock();
}
