package com.laozhang.leecode.interview.part08;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 *
 * 示例1:
 *
 *  输入：A = 1, B = 10
 *  输出：10
 *
 * 示例2:
 *
 *  输入：A = 3, B = 4
 *  输出：12
 *
 * 提示:
 *
 *     保证乘法范围不会溢出
 */
public class interview0805 {
    public int multiply(int A, int B) {
        int min = Math.min(A, B);
        int max = Math.max(A, B);

        if (min == 0) {
            return 0;
        }

        int ans = 0;

        for (int i = 0; min != 0; i++) {
            if ((min & 1) == 1) {
                ans += max << i;
            }
            min >>= 1;
        }

        return ans;
    }
    @Test
    public void test(){

    }
}
