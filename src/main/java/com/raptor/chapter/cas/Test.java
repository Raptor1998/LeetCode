package com.raptor.chapter.cas;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println((int)Math.ceil(10/3));
    }

    public static int foo(){
        try {
            throw new RuntimeException("error");
        }catch (Exception e){
            return 1;
        }finally {
            return 2;
        }
    }
}
