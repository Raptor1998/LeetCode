package com.raptor.chapter.string;

import java.awt.print.Pageable;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author raptor
 * @description CheckString
 * @date 2022/3/1 11:07
 */
public class CheckString {
    public boolean checkValidString(String s) {
        Deque<Integer> leftStack = new LinkedList<Integer>();
        Deque<Integer> asteriskStack = new LinkedList<Integer>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftStack.push(i);
            } else if (c == '*') {
                asteriskStack.push(i);
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!asteriskStack.isEmpty()) {
                    asteriskStack.pop();
                } else {
                    return false;
                }
            }
        }
        while (!leftStack.isEmpty() && !asteriskStack.isEmpty()) {
            int leftIndex = leftStack.pop();
            int asteriskIndex = asteriskStack.pop();
            if (leftIndex > asteriskIndex) {
                return false;
            }
        }
        return leftStack.isEmpty();
    }

    public boolean check2(String s) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack1.add(i);
            } else if (c == '*') {
                stack2.add(i);
            } else {
                if (stack1.isEmpty() == false) {
                    stack1.pop();
                } else if (stack2.isEmpty() == false) {
                    stack2.pop();
                } else {
                    return false;
                }
            }
        }

        while (stack1.isEmpty()==false && stack2.isEmpty()==false){
            Integer pop1 = stack1.pop();
            Integer pop2 = stack2.pop();
            if (pop1 > pop2){
                return false;
            }
        }

        return stack1.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(new CheckString().check2("()"));
    }
}
