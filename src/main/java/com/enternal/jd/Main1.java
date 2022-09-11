package com.enternal.jd;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/9/8  21:11
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            int len = s.length();
            int ans = 0;
            int index = 0;
            Stack<Character> stack = new Stack<>();
            boolean[] exists= new boolean[3];
            char[] chars = {'r','e','d'};
            while(index < len){
                char c = s.charAt(index);
                if (stack.size() == 0 || stack.peek()!=c){
                    stack.add(c);
                }else {
                    ans++;
                    Character pop = stack.pop();
                    Character peek = stack.size() != 0 ? stack.peek():pop;
                    Character next = index+1<len?s.charAt(index+1):pop;
                    exists = new boolean[3];
                    if (pop=='r' || peek == 'r' || next == 'r'){
                        exists[0] = true;
                    }
                    if (pop=='e' || peek == 'e' || next == 'e'){
                        exists[1] = true;
                    }
                    if (pop=='d' || peek == 'd' || next == 'd'){
                        exists[2] = true;
                    }
                    boolean flag = true;
                    for (int i = 0; i < exists.length; i++) {
                        if (!exists[i]){
                            stack.add(chars[i]);
                            flag = false;
                            break;
                        }
                    }
                    if (flag){
                        stack.add(pop);
                    }
                }
                index++;
            }

            System.out.println(ans);
        }
    }
}
