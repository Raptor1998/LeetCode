package com.raptor.chapter.string;

import javax.swing.plaf.PanelUI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author raptor
 * @description T3
 * @date 2022/3/24 14:42
 */
public class T3 {
    public int lengthOfLongestSubstring(String s) {
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

    public int lengthOfLongestSubstring2(String s) {
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

    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        if (n == 1) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (!set.contains(c)) {
                    set.add(c);
                } else {
                    break;
                }
            }
            ans = Math.max(ans, set.size());
        }
        return ans;
    }


    public static void main(String[] args) {
        String s = "gs";
        System.out.println(new T3().lengthOfLongestSubstring3(s));
    }
}
