package com.raptor.chapter.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raptor
 * @description Offer58
 * @date 2022/3/25 15:41
 */
public class Offer58 {
    public String reverseWords(String s) {
        String trim1 = s.trim();
        if (trim1.length()==0) {
            return "";
        }
        String trim = removeSpace(s).toString();
        StringBuilder stringBuilder = new StringBuilder();
        String[] s1 = trim.split(" ");
        for (int i = s1.length - 1; i > 0; i--) {
            stringBuilder.append(s1[i]);
            stringBuilder.append(" ");
        }
        stringBuilder.append(s1[0]);
        return stringBuilder.toString();
    }

    private StringBuilder removeSpace(String s) {
        // System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') {
            start++;
        }
        while (s.charAt(end) == ' ') {
            end--;
        }
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
        return sb;
    }

    public static void main(String[] args) {
        System.out.println(new Offer58().reverseWords(" asdas qwe"));
    }
}
