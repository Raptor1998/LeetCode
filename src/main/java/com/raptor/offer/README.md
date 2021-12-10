# 剑指Offer专题

## [用两个栈实现队列](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/)

**初始化**

- 初始化 `stack1` 和 `stack2` 为空

**插入元素**

- `stack1` 直接插入元素

**删除元素**

- 如果 `stack2` 为空，则将 `stack1` 里的所有元素弹出插入到 `stack2` 里

- 如果 `stack2` 仍为空，则返回 `-1`，否则从 `stack2` 弹出一个元素并返回

```java
class CQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
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
}
```

## [包含main函数的栈](https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/)

