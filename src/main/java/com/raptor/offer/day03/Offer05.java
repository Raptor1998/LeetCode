package com.raptor.offer.day03;

/**
 * @author raptor
 * @description Offer05
 * @date 2021/12/11 21:03
 */
public class Offer05 {
    public static String replaceSpace(String s) {
        //return s.replace(" ","%20");
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c==' '){
                buffer.append("%20");
            }else {
                buffer.append(c);
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        String s1 = replaceSpace(s);
        System.out.println(s1);
    }
}
