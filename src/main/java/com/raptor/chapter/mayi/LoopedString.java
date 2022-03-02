package com.raptor.chapter.mayi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author raptor
 * @description LoopedString
 * @date 2022/3/1 20:17
 */
public class LoopedString {
    public static List<String> ans = new ArrayList<>();

    public static String splitLoopedString2(List<String> strs) {
        // write your code here
        String strsArray[] = new String[strs.size()];
        int num = 0;
        for (String str : strs) {
            strsArray[num++] = str;
        }
        allMixedString(strsArray, 0);

        List<String> strReverse = addListReverse(strs);



        Collections.sort(ans, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });

        for (String s : ans) {
            System.out.println(s);
        }
        System.out.println("-----------------------");
        return ans.get(0);
    }

    public static void allMixedString(String[] strs, int cur) {
        int n = strs.length;
        if (cur == n - 1) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < n; i++) {
                stringBuffer.append(strs[i]);
            }
            ans.add(stringBuffer.toString());
        }
        for (int i = cur; i < n; i++) {
            swap(strs, cur, i);
            allMixedString(strs, cur + 1);
            swap(strs, cur, i);
        }
    }

    public static void swap(String[] strs, int i, int j) {
        String temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;
    }

    public static List<String> addListReverse(List<String> strs) {
        ArrayList<String> objects = new ArrayList<>();
        for (String str : strs) {
            objects.add(new StringBuffer(str).reverse().toString());
        }
        return objects;
    }


    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("abc");
        strs.add("xyz");
        System.out.println(splitLoopedString(strs));
    }

    private static void allMixed(int[] a, int cur) {
        int n = a.length;
        if (cur == n - 1) {
            for (int i = 0; i < n; i++) {
                System.out.print(a[i]);
            }
            System.out.println();
        }

        for (int i = cur; i < n; i++) {
            swap(a, cur, i);
            allMixed(a, cur + 1);
            swap(a, cur, i);
        }
    }

    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }




    public static String splitLoopedString(List<String> strs) {
        int n = strs.size();

        // 每个字符串翻转/不翻转, 选择字典序更大的那个, 连接入循环字符串中
        String loopstr = "";
        for (int i = 0; i < n; i++) {
            String s = strs.get(i);
            String rs = (new StringBuffer(s)).reverse().toString();
            if (s.compareTo(rs) < 0) {
                loopstr += rs;
            }
            else {
                loopstr += s;
            }
        }

        String ans = "";
        int sumlen = 0;
        for (int i = 0; i < n; i++) { // 枚举断点所在位置, 而断点所在位置的字符串可能需要翻转, 可能不需要
            int len = strs.get(i).length();
            String rloopstr = loopstr.substring(0, sumlen) +
                    (new StringBuffer(loopstr.substring(sumlen, sumlen + len))).reverse().toString() +
                    loopstr.substring(sumlen + len);
            // loopstr 是按照每个字符串翻转/不翻转字典序比较大的那个连接而得的循环字符串
            // rloopstr 是将当前枚举的断点所在的字符串与loopstr中相反的方向存在的循环字符串

            // 枚举断点
            for (int j = 0; j < len; j++) {
                String splitLoop = "";

                // 在两个循环字符串中取最大值
                splitLoop = loopstr.substring(sumlen + j) + loopstr.substring(0, sumlen + j);
                if (ans.compareTo(splitLoop) < 0) {
                    ans = splitLoop;
                }

                splitLoop = rloopstr.substring(sumlen + j) + rloopstr.substring(0, sumlen + j);
                if (ans.compareTo(splitLoop) < 0) {
                    ans = splitLoop;
                }
            }

            sumlen += len;
        }
        return ans;
    }
}
