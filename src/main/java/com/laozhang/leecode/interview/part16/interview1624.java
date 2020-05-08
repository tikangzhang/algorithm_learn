package com.laozhang.leecode.interview.part16;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
 *
 * 示例 1:
 *
 * 输入: nums = [5,6,5], target = 11
 * 输出: [[5,6]]
 *
 * 示例 2:
 *
 * 输入: nums = [5,6,5,6], target = 11
 * 输出: [[5,6],[5,6]]
 *
 * 提示：
 *
 *     nums.length <= 100000
 */
public class interview1624 {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        Arrays.sort(nums);
        int start=0,end=nums.length-1;
        List<List<Integer>> ans=new ArrayList<>();
        while(start<end){
            if(nums[start]+nums[end]==target){
                List<Integer> list=new ArrayList<>();
                list.add(nums[start]);
                list.add(nums[end]);
                ans.add(list);
                start++;
                end--;
            }
            else if(nums[start]+nums[end]<target)
                start++;
            else
                end--;
        }
        return ans;
    }


    @Test
    public void test(){

    }
}