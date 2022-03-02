package com.raptor.chapter.mayi;

/**
 * @author raptor
 * @description ReverseString
 * @date 2022/3/1 21:17
 */
public class ReverseString {

    public boolean isPalindrome(String s) {
        // write your code here
        int n = s.length();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                stringBuffer.append(c);
            }
        }
        System.out.println(stringBuffer.toString());
        int i = 0;
        int j = stringBuffer.length() - 1;
        while (i < j) {
            char c1 = stringBuffer.charAt(i);
            char c2 = stringBuffer.charAt(j);
            if (c1 == c2 || ( !(c1 >= '0' && c1 <= '9') &&!(c2 >= '0' && c2 <= '9') && Math.abs(c1 - c2) == 32)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "0P";
        System.out.println(new ReverseString().isPalindrome(s));
    }
}
