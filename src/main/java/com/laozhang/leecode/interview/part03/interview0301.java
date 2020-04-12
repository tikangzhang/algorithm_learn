package com.laozhang.leecode.interview.part03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class interview0301 {
    static class TripleInOne {
        private static int STACK_NUM = 3;
        private int stackSize;
        private int[] indexArray;
        private int[] container;
        public TripleInOne(int stackSize) {
            this.stackSize = stackSize;
            this.indexArray = new int[STACK_NUM];
            Arrays.fill(this.indexArray,0);
            this.container = new int[stackSize * STACK_NUM];
        }

        public void push(int stackNum, int value) {
            if (indexArray[stackNum] < stackSize){
                container[STACK_NUM *stackNum + indexArray[stackNum]++] = value;
            }
        }

        public int pop(int stackNum) {
            if(!isEmpty(stackNum)){
                return container[STACK_NUM *stackNum + --indexArray[stackNum]];
            }
            return -1;
        }

        public int peek(int stackNum) {
            if(isEmpty(stackNum)) {
                return -1;
            }
            return container[STACK_NUM * stackNum + indexArray[stackNum] - 1];
        }

        public boolean isEmpty(int stackNum) {
            return indexArray[stackNum] == 0;
        }
    }

    @Test
    public void test(){
        TripleInOne obj;
        obj = new TripleInOne(1);
        obj.push(0,1);
        Assertions.assertFalse(obj.isEmpty(0));
        obj.push(0,2);
        Assertions.assertFalse(obj.isEmpty(0));
        Assertions.assertEquals(obj.pop(0),1);
        Assertions.assertEquals(obj.pop(0),-1);
        Assertions.assertEquals(obj.pop(0),-1);
        Assertions.assertTrue(obj.isEmpty(0));


        obj = new TripleInOne(2);
        obj.push(0,3);
        Assertions.assertFalse(obj.isEmpty(0));
        obj.push(0,33);
        Assertions.assertFalse(obj.isEmpty(0));
        obj.push(0,1);
        Assertions.assertEquals(obj.pop(0),33);
        Assertions.assertEquals(obj.pop(0),3);
        Assertions.assertEquals(obj.pop(0),-1);
        Assertions.assertEquals(obj.pop(0),-1);
        Assertions.assertTrue(obj.isEmpty(0));

        obj.push(1,1);
        Assertions.assertEquals(obj.peek(1),1);
        obj.push(1,2);
        Assertions.assertEquals(obj.peek(1),2);
        obj.push(1,3);
        Assertions.assertEquals(obj.peek(1),2);
        Assertions.assertFalse(obj.isEmpty(1));
        Assertions.assertEquals(obj.pop(1),2);
        Assertions.assertEquals(obj.pop(1),1);
        Assertions.assertEquals(obj.pop(1),-1);
        Assertions.assertEquals(obj.peek(1),-1);
    }
}
