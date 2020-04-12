package com.laozhang.leecode.interview.part03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 *
 * 示例：
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 *
 *
 * 说明：
 *
 *     你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
 *     你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *     假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 */
public class interview0304 {
    static class MyQueue {
        private Stack<Integer> sourceContainer;
        private Stack<Integer> tempContainer;

        public MyQueue() {
            sourceContainer = new Stack<>();
            tempContainer = new Stack<>();
        }

        public void push(int x) {
            if (tempContainer.size() != 0){
                moveTo(tempContainer,sourceContainer);
            }
            sourceContainer.add(x);
        }

        public int pop() {
            peek();
            return tempContainer.pop();
        }

        public int peek() {
            if (tempContainer.size() == 0){
                moveTo(sourceContainer,tempContainer);
            }
            return tempContainer.peek();
        }

        public boolean empty() {
            return tempContainer.size() == 0 && sourceContainer.size() == 0;
        }

        private void moveTo(Stack<Integer> source,Stack<Integer> target){
            while(!source.empty()){
                target.push(source.pop());
            }
        }
    }

    @Test
    public void test(){
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        Assertions.assertEquals(queue.peek(),1);;  // 返回 1
        Assertions.assertEquals(queue.pop(),1);   // 返回 1

        queue.push(3);
        Assertions.assertEquals(queue.pop(),2);   // 返回 1
        Assertions.assertEquals(queue.peek(),3);
        Assertions.assertEquals(queue.pop(),3);
        Assertions.assertTrue(queue.empty()); // 返回 false
    }
}
