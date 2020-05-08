package com.laozhang.leecode.interview.part16;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 *
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
 *
 * 示例:
 *
 * 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
 * 输出: [1, 3]
 *
 * 示例:
 *
 * 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
 * 输出: []
 *
 * 提示：
 *
 *     1 <= array1.length, array2.length <= 100000
 */
public class interview1621 {
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0, sum2 = 0;
        int len1 = array1.length, len2 = array2.length;
        HashSet<Integer> set1 = new HashSet<>(len1), set2 = new HashSet<>(len2);
        for (int num : array1) {
            sum1 += num;
            set1.add(num);
        }
        for (int num : array2) {
            sum2 += num;
            set2.add(num);
        }
        if ((sum1 + sum2) % 2 != 0) return new int[0];

        int avg = (sum1 + sum2) >> 1;
        int diff1 = sum1 - avg;
        if (diff1 < 0) {
            for (int num1 : set1)
                if (set2.contains(num1 - diff1))
                    return new int[]{num1, num1 - diff1};
        } else {
            for (int num2 : set2)
                if (set1.contains(num2 + diff1))
                    return new int[]{num2 + diff1, num2};
        }
        return new int[0];
    }
    @Test
    public void test(){

    }
}