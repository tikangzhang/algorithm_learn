package com.laozhang.leecode.interview.part17;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 随机产生数字并传递给一个方法。你能否完成这个方法，在每次产生新值时，寻找当前所有值的中间值（中位数）并保存。

 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。

 例如，

 [2,3,4] 的中位数是 3

 [2,3] 的中位数是 (2 + 3) / 2 = 2.5

 设计一个支持以下两种操作的数据结构：

 void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 double findMedian() - 返回目前所有元素的中位数。

 示例：

 addNum(1)
 addNum(2)
 findMedian() -> 1.5
 addNum(3)
 findMedian() -> 2
 */
public class interview1720 {

    // 存储小于等于中位数的数，使用大顶堆
    private PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());

    // 存储大于等于中位数的数，使用小顶堆
    private PriorityQueue<Integer> right = new PriorityQueue<>();

    void resize() {
        if (left.size() >= right.size() + 2) {
            right.add(left.peek());
            left.poll();
        } else if (right.size() > left.size()) {
            left.add(right.peek());
            right.poll();
        }
    }

    class MedianFinder {

        /** initialize your data structure here. */
        public MedianFinder() {
            left.add(Integer.MIN_VALUE);
            right.add(Integer.MAX_VALUE);
        }

        public void addNum(int num) {
            int lmax = left.peek(), rmin = right.peek();
            if (num <= lmax)
                left.add(num);
            else
                right.add(num);
            resize();
        }

        public double findMedian() {
            if (left.size() == right.size())
                return ((double) left.peek() + right.peek()) / 2;
            else
                return left.peek();
        }
    }
    @Test
    public void test(){


    }
}