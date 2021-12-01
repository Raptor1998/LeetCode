package com.raptor.random;

import org.junit.Test;
import org.omg.CORBA.MARSHAL;

import javax.annotation.Resource;
import java.lang.reflect.Proxy;

/**
 * @author raptor
 * @description ReverseInteger_7
 * @date 2021/6/8 20:15
 */
public class ReverseInteger_7 {
    public int reverse(int x) {
        int temp_x = x;
        x = Math.abs(x);
        StringBuilder s = new StringBuilder(String.valueOf(x));
        s.reverse();
        int parseInt=0;
        try {
            parseInt = Integer.parseInt(s.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
        return temp_x > 0 ? parseInt : -parseInt;
    }

    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            //取出当前个位数
            int digit = x % 10;
            //剔除个位数
            x /= 10;
            //翻转后的数据累计
            rev = rev * 10 + digit;
        }
        return rev;
    }

    @Test
    public void context() {
        System.out.println(reverse(1999999999));
    }
}
