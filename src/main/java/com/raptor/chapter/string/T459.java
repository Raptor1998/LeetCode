package com.raptor.chapter.string;

public class T459 {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if (n == 0 || n == 1) {
            return false;
        }
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                String temp = "";
                for (int j = 0; j < n / i; j++) {
                    temp += s.charAt(j);
                }
                String newTemp = "";
                for (int k = 0; k < i; k++) {
                    newTemp += temp;
                }
                System.out.println("temp:"+temp+"    newTemp:"+newTemp);
                if (newTemp.equals(s) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new T459().repeatedSubstringPattern("bb"));
    }
}
