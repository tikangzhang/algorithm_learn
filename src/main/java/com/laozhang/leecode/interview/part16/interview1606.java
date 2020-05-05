package com.laozhang.leecode.interview.part16;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
 *
 * 示例：
 *
 * 输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
 * 输出： 3，即数值对(11, 8)
 *
 * 提示：
 *
 *     1 <= a.length, b.length <= 100000
 *     -2147483648 <= a[i], b[i] <= 2147483647
 *     正确结果在区间[-2147483648, 2147483647]内
 */
public class interview1606 {
    public int smallestDifference(int[] a, int[] b) {
        long min =  Integer.MAX_VALUE;
        int aP = 0;
        int bP = 0;
        Arrays.parallelSort(a);
        Arrays.parallelSort(b);
        while(aP<a.length && bP<b.length) {
            if(min == 0)return 0;
            if(a[aP]<b[bP]) {
                while(aP<a.length &&a[aP]<b[bP]) {
                    aP++;
                }
                if(aP<a.length) {
                    min = Math.min(min, Math.abs((long)a[aP]-b[bP]));

                }
                min = Math.min(min, Math.abs((long)a[aP-1]-b[bP]));

            }else if(a[aP]>=b[bP]) {
                while(bP<b.length &&a[aP]>b[bP]) {
                    bP++;
                }
                if(bP<b.length) {
                    min = Math.min(min, Math.abs((long)a[aP]-b[bP]));

                }
                min = Math.min(min, Math.abs((long)a[aP]-b[bP-1]));
            }


        }
        return (int)min;
    }

    @Test
    public void test(){

    }
}