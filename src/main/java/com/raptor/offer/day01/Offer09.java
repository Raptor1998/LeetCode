package com.raptor.offer.day01;

import java.util.Stack;

/**
 * @author raptor
 * @description Base09
 * @date 2021/12/10 9:37
 */
public class Offer09 {

    public static void main(String[] args) {
        int value = 3;
        CQueue obj = new CQueue();
        obj.appendTail(value);
        int param_2 = obj.deleteHead();
        System.out.println(param_2);
    }
}

class CQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        size = 0;
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }
        //出栈中的数据为空
        if (stack2.isEmpty()) {
            //将入栈中的数据全部压入
            while (!stack1.isEmpty()) {
                Integer pop = stack1.pop();
                stack2.push(pop);
            }
        }
        return stack2.pop();
    }


    //public void appendTail(int value) {
    //    stack1.push(value);
    //    size++;
    //}
    //
    //public int deleteHead() {
    //    if (size == 0) {
    //        return -1;
    //    }
    //    if (stack2.empty()) {
    //        while (!stack1.empty()) {
    //            stack2.push(stack1.pop());
    //        }
    //    }
    //    size--;
    //    return stack2.pop();
    //
    //}
}
