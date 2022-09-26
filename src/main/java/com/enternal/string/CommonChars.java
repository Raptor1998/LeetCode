package com.enternal.string;

import java.util.ArrayList;
import java.util.List;

public class CommonChars {

    public static List<String> commonChars(String[] words) {
        int n = words.length;
        int[] charNum = new int[26];
        for (int i = 0; i < words[0].length(); i++) {
            charNum[words[0].charAt(i) - 'a']++;
        }
        for (int i = 1; i < n; i++) {
            int[] otherNum = new int[26];
            String s = words[i];
            int len = s.length();
            for (int j = 0; j < len; j++) {
                otherNum[s.charAt(j) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                charNum[j] = Math.min(charNum[j], otherNum[j]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (charNum[i] != 0) {
                int num = charNum[i];
                while (num != 0) {
                    ans.add(String.valueOf((char)(i + 'a')));
                    num--;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        List<String> stringList = commonChars(new String[]{"bella", "label", "roller"});
        stringList.forEach(item -> System.out.println(item));
    }
}
