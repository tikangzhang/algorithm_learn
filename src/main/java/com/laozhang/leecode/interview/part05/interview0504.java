package com.laozhang.leecode.interview.part05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
 *
 * 示例1:
 *
 *  输入：num = 2（或者0b10）
 *  输出：[4, 1] 或者（[0b100, 0b1]）
 *
 * 示例2:
 *
 *  输入：num = 1
 *  输出：[2, -1]
 *
 * 提示:
 *
 *     num的范围在[1, 2147483647]之间；
 *     如果找不到前一个或者后一个满足条件的正数，那么输出 -1。
 */
public class interview0504 {
    public int[] findClosedNumbers(int num) {
        int maxValue,minValue;
        if (num <= 0) {
            return new int[]{-1,-1};
        }else if (num == 1){
            return new int[]{2, -1};
        }

        int oneCount = 0;
        maxValue = num;
        for (int i = 0; i < 32; i++) {
            // 01xxx -> 10xxx
            if ((num >> i & 1) == 1 && (num >> (i + 1) & 1) == 0){
                maxValue -= 1 << i;
                maxValue += 1 << (i + 1);
                i = 0;
                while(oneCount-- > 0){
                    maxValue += 1 << ++i;
                }
                break;
            }else if ((num >> i & 1) == 1){
                oneCount++;
            }
        }

        oneCount = 0;
        minValue = num;
        for (int i = 0; i < 32; i++) {
            // 10xxx -> 01xxx
            if ((num >> i & 1) == 0 && (num >> (i + 1) & 1) == 1){
                minValue -= 1 << (i + 1);
                minValue += 1 << i;
                while(oneCount-- > 0){
                    minValue += 1 << --i;
                }
                break;
            }else if ((num >> i & 1) == 1){
                oneCount++;
            }
        }

        return new int[]{maxValue,minValue};
    }

    @Test
    public void test(){
        Assertions.assertArrayEquals(findClosedNumbers(8),new int[]{16,4});
        Assertions.assertArrayEquals(findClosedNumbers(2),new int[]{4,1});
        Assertions.assertArrayEquals(findClosedNumbers(1),new int[]{2,-1});
    }
}
