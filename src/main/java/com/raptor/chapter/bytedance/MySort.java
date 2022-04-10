package com.raptor.chapter.bytedance;

import com.sun.corba.se.spi.ior.IORFactories;

public class MySort {
    public static int mySqrt(int x) {
        if (x == 0 || x == 1){
            return x;
        }
        for (long i = 0; i < x; i++) {
            if ((long)i * i > x) {
                return (int) (i - 1);
            } else if (i * i == x) {
                return (int) i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(1));
    }
}
