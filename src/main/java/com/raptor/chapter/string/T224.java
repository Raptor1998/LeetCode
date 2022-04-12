package com.raptor.chapter.string;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author raptor
 * @description T224
 * @date 2022/4/12 9:29
 */
public class T224 {
    public int calculate1(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            //空字符跳过
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                int num = 0;
                while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }

    public int calculate2(String s) {
        //去空格
        s = s.replaceAll(" ", "");
        if (s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();//数据栈
        char sign = '+'; //符号
        int res = 0, pre = 0, i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            //处理两位数的问题
            if (Character.isDigit(ch)) {
                pre = pre * 10 + (ch - '0');
            }
            //碰到左括号 就把括号里面当成一个 新的被加数
            if (ch == '(') {
                int j = findClosing(s.substring(i));
                pre = calculate2(s.substring(i + 1, i + j));
                i += j;
            }
            if (i == s.length() - 1 || !Character.isDigit(ch)) {
                //将所有的结果压栈 最后统一加起来
                switch (sign) {
                    case '+':
                        stack.push(pre);
                        break;
                    case '-':
                        stack.push(-pre);
                        break;
                    case '*':
                        stack.push(stack.pop() * pre);
                        break;
                    case '/':
                        stack.push(stack.pop() / pre);
                        break;
                }
                pre = 0;
                //记录当前的符号
                sign = ch;
            }
            i++;
        }
        // 本质上说全都是加法
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    //删除所有的括号对，并返回右括号的位置
    private int findClosing(String s) {
        int level = 0, i = 0;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                level++;
            } else if (s.charAt(i) == ')') {
                level--;
                if (level == 0) {
                    break;
                }
            } else {
                continue;
            }
        }
        return i;
    }


    public static void main(String[] args) {
        String s = "(2*3)+8";
        System.out.println(new T224().calculate2(s));
    }
}
