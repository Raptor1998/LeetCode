package com.raptor.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author raptor
 * @description HashTest2
 * @date 2022/2/14 15:02
 */
public class NoHashCodeAndEquals {
    public static void main(String[] args) {
        Object o = new Object();
        HashMap hashMap = new HashMap<>();
        ArrayList list = new ArrayList();
        Demo a = new Demo("A");
        Demo b = new Demo("A");

        System.out.println(a.equals(b));

        hashMap.put(a, "hello");
        String s = (String) hashMap.get(b);
        System.out.println(s);

        String ss = "a";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(ss.hashCode());
    }
}

class Demo {
    String key;

    Demo(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Demo demo = (Demo) o;
        return Objects.equals(key, demo.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
