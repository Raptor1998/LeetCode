package com.raptor.chapter.bytedance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0 || n == 1) {
            return n;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int st = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //如果存在过这个字符    更新起点的位置
            if (hashMap.containsKey(c)) {
                st = Math.max(hashMap.get(c), st);
            }
            ans = Math.max(ans, i - st + 1);
            //当前字符的位置  加入集合
            hashMap.put(c, i + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = 0, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk  < n && !occ.contains(s.charAt(rk ))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring2("a"));
    }
}
