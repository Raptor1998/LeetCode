package com.raptor.T200;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
        System.out.println("A");
        new Test();
        new Test();
    }
    {
        System.out.println("C");
    }
    public Test() {
        System.out.println("B");
    }

    static {
        System.out.println("D");
    }
}
