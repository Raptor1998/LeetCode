package com.raptor.chapter.string;

import javax.swing.plaf.PanelUI;
import java.util.HashMap;
import java.util.Map;

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


    public static void main(String[] args) {
        String s = "";
        System.out.println(new T3().lengthOfLongestSubstring(s));
    }
}
