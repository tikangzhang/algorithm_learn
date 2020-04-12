package com.laozhang.leecode.interview.part03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
 *
 * 当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.
 *
 * 示例1:
 *
 *  输入：
 * ["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
 * [[1], [1], [2], [1], [], []]
 *  输出：
 * [null, null, null, 2, 1, -1]
 *
 * 示例2:
 *
 *  输入：
 * ["StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"]
 * [[2], [1], [2], [3], [0], [0], [0]]
 *  输出：
 * [null, null, null, null, 2, 1, 3]
 */
public class interview0303 {
    static class StackOfPlates {
        private List<Stack<Integer>> container;
        private int cap;

        public StackOfPlates(int cap) {
            this.cap = cap;
            this.container = new LinkedList<>();
        }

        public void push(int val) {
            if(this.container.size() == 0){
                Stack<Integer> stack = new Stack<>();
                stack.add(val);
                this.container.add(stack);
                return;
            }

            Stack<Integer> integers = this.container.get(this.container.size() - 1);
            if(integers.size() >= cap){
                Stack<Integer> objects = new Stack<>();
                objects.add(val);
                this.container.add(objects);
            }else{
                integers.add(val);
            }
        }

        public int pop() {
            return popAt(this.container.size() - 1);
        }

        public int popAt(int index) {
            Stack<Integer> integers = this.container.get(index);
            Integer pop = integers.pop();
            if(integers.size() == 0){
                this.container.remove(index);
            }
            return pop;
        }
    }


    @Test
    public void test(){
        StackOfPlates stackOfPlates = new StackOfPlates(2);
        stackOfPlates.push(-2);
        stackOfPlates.push(0);
        stackOfPlates.push(-3);
        stackOfPlates.push(1);
        stackOfPlates.push(10);
        stackOfPlates.push(-10);
        Assertions.assertEquals(stackOfPlates.pop(),-10);
        Assertions.assertEquals(stackOfPlates.popAt(1),1);
        Assertions.assertEquals(stackOfPlates.popAt(1),-3);
        Assertions.assertEquals(stackOfPlates.pop(),10);
    }
}
