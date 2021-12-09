package com.raptor.base.day6;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author raptor
 * @description Solution3
 * @date 2021/12/8 20:19
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Solution3 {
    public static int lengthOfLongestSubstring1(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        int i, j, k;
        for (i = 0; i < s.length(); i++) {
            for (j = i + 1; j < s.length(); j++) {
                Boolean flag = false;
                for (k = i; k < j; k++) {
                    if (chars[j] == chars[k]) {
                        flag = true;
                        break;
                    }
                }
                if (flag == true) {
                    break;
                }
            }
            max = Math.max(max, j - i);
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int length = s.length();
        if (length == 0 || length == 1) {
            return length;
        }
        Set<Character> set = new HashSet<>();
        int max = 0;
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (index < length) {
                if (!set.contains(s.charAt(index))) {
                    set.add(s.charAt(index));
                    index++;
                } else {
                    break;
                }

            }
            max = Math.max(max, index - i);
        }
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
