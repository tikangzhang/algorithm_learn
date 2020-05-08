package com.laozhang.leecode.interview.part17;

import org.junit.jupiter.api.Test;

/**
 如果数组中多一半的数都是同一个，则称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。

 示例 1：

 输入：[1,2,5,9,5,9,5,5,5]
 输出：5



 示例 2：

 输入：[3,2]
 输出：-1



 示例 3：

 输入：[2,2,1,1,1,2,2]
 输出：2



 说明：
 你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？
 */
public class interview1710 {
    public int majorityElement(int[] nums) {
        // 投票算法
        int temp = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == temp) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                temp = nums[i];
                count = 1;
            }
        }

        // 验证是否满足要求
        int t = nums.length / 2 + 1;
        count = 0;
        for (int num : nums) {
            if (num == temp) count++;
            if (count == t) return temp;
        }
        return -1;
    }

    @Test
    public void test(){

    }
}