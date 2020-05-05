package com.laozhang.leecode.interview.part16;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 *
 * 示例：
 *
 * 输入： a = 1, b = 2
 * 输出： 2
 */
public class interview1607 {
    /**
     * max(a, b) = ((a + b) + abs(a - b)) / 2
     *
     * 类型 	绝对值位运算
     * int8_t 	(var ^ (var >> 7)) - (var >> 7)
     * int16_t 	(var ^ (var >> 15)) - (var >> 15)
     * int32_t 	(var ^ (var >> 31)) - (var >> 31)
     * int64_t 	(var ^ (var >> 63)) - (var >> 63)
     */
    public int maximum(int a, int b) {
        long _sum = (long)a + (long)b;
        long _diff = (long)a - (long)b;
        long _abs_diff = (_diff ^ (_diff >> 63)) - (_diff >> 63);
        return (int)((_sum + _abs_diff) / 2);
    }

    @Test
    public void test(){

    }
}