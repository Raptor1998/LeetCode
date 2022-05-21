package com.raptor.chapter.cas;

public class Solution {

    public String add(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        StringBuffer buffer1 = new StringBuffer();
        buffer1.append(s1);
        StringBuffer reverse1 = buffer1.reverse();
        StringBuffer buffer2 = new StringBuffer();
        buffer2.append(s2);
        StringBuffer reverse2 = buffer2.reverse();
        StringBuffer ans = new StringBuffer();
        int i = 0;
        int j = 0;
        //进位
        int t = 0;
        while (i <len1 || j < len2) {
            char c1 = i < len1 ? reverse1.charAt(i) : '0';
            char c2 = j < len2 ? reverse2.charAt(j) : '0';
            int temp = c1 - '0' + c2 - '0' + t;
            int single = temp % 10;
            t = temp / 10;
            ans.append(single);
            i++;
            j++;
        }
        if (t != 0) {
            return t + ans.reverse().toString();
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "9999";
        String s2 = "3";
        System.out.println(new Solution().add(s1, s2));
    }
}
