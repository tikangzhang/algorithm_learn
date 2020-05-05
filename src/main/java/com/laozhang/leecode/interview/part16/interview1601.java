package com.laozhang.leecode.interview.part16;

import org.junit.jupiter.api.Test;

/**
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 *
 * 示例：
 *
 * 输入: numbers = [1,2]
 * 输出: [2,1]
 *
 * 提示：
 *
 *     numbers.length == 2
 */
public class interview1601 {
//    public int[] swapNumbers(int[] numbers) {
//        return new int[]{numbers[1],numbers[0]};
//    }

//    public int[] swapNumbers(int[] numbers) {
//        numbers[0] = numbers[0] ^ numbers[1];
//        numbers[1] = numbers[0] ^ numbers[1];
//        numbers[0] = numbers[0] ^ numbers[1];
//        return numbers;
//    }

    public int[] swapNumbers(int[] numbers) {
        numbers[0]=numbers[1]-numbers[0];
        numbers[1]=numbers[1]-numbers[0];
        numbers[0]=numbers[1]+numbers[0];
        return numbers;
    }
    @Test
    public void test(){

    }
}