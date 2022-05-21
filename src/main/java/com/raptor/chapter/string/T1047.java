package com.raptor.chapter.string;

import java.util.Stack;

public class T1047 {
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty()) {
                Character peek = stack.peek();
                if (peek == c) {
                    stack.pop();
                }else {
                    stack.add(c);
                }
            } else {
                stack.add(c);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!stack.isEmpty()) {
            stringBuffer.append(stack.pop());
        }
        return stringBuffer.reverse().toString();
    }

    public static void main(String[] args) {
        String s = removeDuplicates("abbaca");
        System.out.println(s);
    }
}
