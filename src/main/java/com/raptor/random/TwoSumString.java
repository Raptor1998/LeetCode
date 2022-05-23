package com.raptor.random;

/**
 * @author raptor
 * @description TwoSumString
 * @date 2022/4/18 16:40
 */
public class TwoSumString {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int t = 0;
        int i = len1 - 1;
        int j = len2 - 1;
        StringBuffer ans = new StringBuffer();
        while(i>=0 || j>=0){
            char c1 = i>=0?num1.charAt(i):'0';
            char c2 = j>=0?num2.charAt(j):'0';
            int single = c1 - '0' + c2 - '0' + t;
            t = single / 10;
            single = single % 10;
            ans.append(single);
            i--;
            j--;
        }
        if(t!=0){
            ans.append(t);
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new TwoSumString().addStrings("999","12"));
    }
}
