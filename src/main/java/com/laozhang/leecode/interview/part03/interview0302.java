package com.laozhang.leecode.interview.part03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 *
 * 示例：
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class interview0302 {
    static class Node{
        public Node pre;
        public int val;
        public Node(Node pre,int val){
            this.pre = pre;
            this.val = val;
        }

    }
    static class MinStack {
        private Node cContainer;
        private Node mContainer;
        private Node head;

        public MinStack() {
            head = cContainer = new Node(null,Integer.MAX_VALUE);
            mContainer = new Node(null,Integer.MAX_VALUE);
        }

        public void push(int x) {
            cContainer = new Node(cContainer,x);
            if (x < mContainer.val){
                mContainer = new Node(mContainer,x);
            }else{
                mContainer = new Node(mContainer,mContainer.val);
            }
        }

        public void pop() {
            if(cContainer != head){
                cContainer = cContainer.pre;
                mContainer = mContainer.pre;
            }
        }

        public int top() {
            return cContainer.val;
        }

        public int getMin() {
            return mContainer.val;
        }
    }


    @Test
    public void test(){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assertions.assertEquals(minStack.getMin(),-3);
        minStack.pop();
        Assertions.assertEquals(minStack.top(),0);
        Assertions.assertEquals(minStack.getMin(),-2);
    }
}
