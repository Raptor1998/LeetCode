package com.raptor.chapter.cas;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        System.out.println(Integer.parseInt("-45"));

        Scanner scanner = new Scanner(System.in);
        int a  = scanner.nextInt();
        String string2 = scanner.nextLine();
        System.out.println(string2);
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
