package com.enternal.arrays;

import com.sun.org.apache.xerces.internal.impl.dtd.models.CMAny;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/7/13  20:41
 */
public class MinWindow {
    public HashMap<Character,Integer> sMap = new HashMap<>();
    public HashMap<Character,Integer> tMap = new HashMap<>();

    public String minWindow(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        for (int i = 0; i < len2; i++) {
            char c = t.charAt(i);
            tMap.put(c,tMap.getOrDefault(c,0) + 1);
        }
        if (len1<len2){
            return "";
        }
        int left = 0,low=  0;
        int right = 0,high = 0;
        int min = Integer.MAX_VALUE;
        while (true){
            if (check()){
                if (right - left < min){
                    low = left;
                    high = right;
                    min = right - left;
                }
                //此时包含t      左侧右移    去除第一个字母的统计
                char c1 = s.charAt(left);
                sMap.put(c1,sMap.get(c1) - 1);
                left++;
            }else{
                //s 字串 不包含 t    右侧++

                if (right == len1){
                    break;
                }
                char c = s.charAt(right);
                sMap.put(c, sMap.getOrDefault(c,0)+1);
                right++;
            }
        }
        return s.substring(low,high);
    }

    public boolean check(){
        Iterator<Character> iterator = tMap.keySet().iterator();
        while (iterator.hasNext()){
            Character next = iterator.next();
            if (sMap.get(next) == null || sMap.get(next) < tMap.get(next)){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String s2 = "ABC";
        System.out.println(new MinWindow().minWindow(s1,s2));
    }
}
