package com.laozhang.leecode.interview.part08;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 *
 * 示例1:
 *
 *  输入：nums = [0, 2, 3, 4, 5]
 *  输出：0
 *  说明: 0下标的元素为0
 *
 * 示例2:
 *
 *  输入：nums = [1, 1, 1]
 *  输出：1
 *
 * 提示:
 *
 *     nums长度在[1, 1000000]之间
 */
public class interview0803 {
    public int findMagicIndex(int[] nums) {
        return helper(nums,0,nums.length - 1);
    }

    private int helper(int[] nums,int left, int right) {
        if (left > right) {
            return - 1;
        }
        // 二分搜索，所以找中间点
        int mid = left + ((right - left) >> 1);
        if (nums[mid] == mid) {
            // mid 肯定是魔术索引，但 [left, right - 1] 也有可能存在魔术索引
            int res = helper(nums,left, right - 1);
            if (res == -1) {
                return mid;
            } else {
                return res;
            }
        } else if (nums[mid] > mid) {
            // mid 不是魔术索引，但 [left, mid - 1] 和 [nums[mid], right] 可能存在魔术索引
            // 换句话说，[mid, nums[mid] - 1] 之间肯定不存在魔术索引
            int res1 = helper(nums,left, mid - 1);
            if (res1 != -1) {
                return res1;
            }
            return helper(nums,nums[mid], right);

        } else {
            // mid 不是魔术索引，但 [left, nums[mid]] 和 [mid + 1, right] 可能存在魔术索引
            // 换句话说，[nums[mid] + 1, mid] 之间肯定不存在魔术索引
            int res1 = helper(nums,left, nums[mid]);
            if (res1 != -1) {
                return res1;
            }
            return helper(nums,mid + 1, right);
        }
    }

    @Test
    public void test(){

    }
}
