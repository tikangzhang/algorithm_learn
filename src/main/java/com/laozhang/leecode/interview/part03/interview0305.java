package com.laozhang.leecode.interview.part03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 *
 * 示例1:
 *
 *  输入：
 * ["SortedStack", "push", "push", "peek", "pop", "peek"]
 * [[], [1], [2], [], [], []]
 *  输出：
 * [null,null,null,1,null,2]
 *
 * 示例2:
 *
 *  输入：
 * ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
 * [[], [], [], [1], [], []]
 *  输出：
 * [null,null,null,null,null,true]
 */
public class interview0305 {
    static class SortedStack {

        private Stack<Integer> sourceContainer;
        private Stack<Integer> tempContainer;
        public SortedStack() {
            sourceContainer = new Stack<>();
            tempContainer = new Stack<>();
        }

        public void push(int val) {
            if (sourceContainer.size() == 0){
                sourceContainer.push(val);
            }else{
                while(!sourceContainer.isEmpty()){
                    if (sourceContainer.peek() < val){
                        tempContainer.push(sourceContainer.pop());
                        if (sourceContainer.isEmpty()){
                            tempContainer.push(val);
                        }
                    }else{
                        tempContainer.push(val);
                        moveTo(sourceContainer,tempContainer);
                    }
                }
                moveTo(tempContainer,sourceContainer);
            }
        }

        public void pop() {
            sourceContainer.pop();
        }

        public int peek() {
            return sourceContainer.peek();
        }

        public boolean isEmpty() {
            return sourceContainer.isEmpty();
        }

        private void moveTo(Stack<Integer> source,Stack<Integer> target){
            while(!source.empty()){
                target.push(source.pop());
            }
        }
    }

    @Test
    public void test(){
        SortedStack queue = new SortedStack();
        queue.push(2);
        queue.push(1);
        queue.push(3);
        queue.push(35);
        queue.push(2);

        Assertions.assertEquals(queue.peek(),1);
        queue.pop();
        Assertions.assertEquals(queue.peek(),2);
        Assertions.assertFalse(queue.isEmpty()); // 返回 false
    }
}
