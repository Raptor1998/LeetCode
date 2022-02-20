package com.raptor.hash;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Vector;

/**
 * @author raptor
 * @description HashTest
 * @date 2022/2/13 16:38
 */
public class HashTest {
    public static void main(String[] args) {

        String s = new String("as") + new String("d");
        String a = "asd";
        String b = s.intern();
        System.out.println(s.hashCode());
        System.out.println(a.hashCode());

        System.out.println(s == a);
        System.out.println(b == a);
        System.out.println(b == s);

    }
}
