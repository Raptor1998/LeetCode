package com.raptor.offer.day01;

import java.util.Stack;
import java.util.Vector;

/**
 * @author raptor
 * @description Offer30
 * @date 2021/12/10 10:09
 */
public class Offer30 {
    public static void main(String[] args) {

    //["MinStack","push",        "push",      "push", "top","pop","min","pop","min","pop","push",     "top","min","    push",    "top","min","pop","min"]
    //[  [],    [2147483646],[2147483646],[2147483647],[],   [],    [],   [],   [],   [],[2147483647], [],    [],  [-2147483648], [],    [],   [],   []]
        MinStack obj = new MinStack();
        System.out.println("push 2147483646");
        obj.push(2147483646);
        System.out.println("push 2147483646");
        obj.push(2147483646);
        System.out.println("push 2147483646");
        obj.push(2147483646);
        System.out.println(obj.top());
        System.out.println("pop one");
        obj.pop();
        System.out.println(obj.min());
        System.out.println("pop one");
        obj.pop();
        System.out.println(obj.min());
        System.out.println("pop one");
        obj.pop();
        System.out.println("push 2147483646");
        obj.push(2147483646);
        System.out.println(obj.top());
        System.out.println(obj.min());
        System.out.println("push -2147483646");
        obj.push(-2147483646);
        System.out.println(obj.top());
        System.out.println(obj.min());
        System.out.println("pop one");
        obj.pop();
        System.out.println(obj.min());
    }
}

/**
 * 不适用额外空间
 * 连续存最小值，存差值
 */
class MinStack {

    Stack<Long> stack1;
    Long minVal = Long.MIN_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack1 = new Stack<>();
    }


    public void push(int x) {
        //栈 初始为空，压入0，最小值为 x
        if (stack1.isEmpty()) {
            stack1.push(0L);
            minVal = Long.valueOf(x);
        } else {
            // 栈不为空，压入 x-最小值
            stack1.push(x - minVal);
            //更新最小值
            minVal = Math.min(minVal, x);
        }
    }

    public void pop() {

        Long pop = stack1.pop();
        //栈顶元素小于0，说明x的原值小于之前的最小值，要恢复栈顶元素插入之前的最小值
        if (pop < 0) {
            // 存的是栈顶元素的差值与原最小值的差，恢复原最小值 = 现在的最小值 + 差值  （差值<0） 所以 min = min - pop
            minVal = minVal - pop;
        }
    }

    public int top() {
        //return self.minv + top if top >= 0 else self.minv
        Long peek = stack1.peek();
        //如果peek>0  说明 x比minVal大，栈内存的 peek = x-minVal 恢复原来的 x = minVal + peek
        if (peek > 0) {
            return (int) (peek + minVal);
        } else {
            // 否则  说明x的值比当时的最小值小，peek即最小值
            return min();
        }
    }

    //最小值
    public int min() {
        return minVal.intValue();
    }
}

/**
 * 辅助栈中保证有序，降低辅助栈中元素个数
 */
class MinStack2 {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /**
     * initialize your data structure here.
     */
    public MinStack2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // 保证栈2中元素降序
    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || x <= stack2.peek()) {
            stack2.push(x);
        }
    }

    public void pop() {
        Integer pop = stack1.pop();
        if (pop.equals(stack2.peek())) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}

/**
 * 借助两个栈实现,每次添加或者删除元素时同时维护当前的最小值
 */
class MinStack1 {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    Integer minVal;

    /**
     * initialize your data structure here.
     */
    public MinStack1() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        if (stack1.isEmpty()) {
            minVal = x;
        } else {
            minVal = Math.min(minVal, x);
        }
        stack1.push(x);
        stack2.push(minVal);
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
        if (!stack2.isEmpty()) {
            minVal = stack2.peek();
        }
    }

    public int top() {
        if (stack1.isEmpty()) {
            return -1;
        }
        return stack1.peek();
    }

    public int min() {
        if (stack2.isEmpty()) {
            return -1;
        }
        return stack2.peek();
    }
}