package com.laozhang.leecode.interview.part05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 *
 * 示例1:
 *
 *  输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 *  输出：2
 *
 * 示例2:
 *
 *  输入：A = 1，B = 2
 *  输出：2
 *
 * 提示:
 *
 *     A，B范围在[-2147483648, 2147483647]之间
 */
public class interview0506 {
    public int convertInteger(int A, int B) {
        int temp = A ^ B;
        int count = 0;
        while (temp != 0) {
            temp &= (temp - 1);  // 去掉二进制表示的最右边的1
            count++;
        }
        return count;
    }
//    public int convertInteger(int A, int B) {
//        int count = 0;
//        for (int i = 0; i < 32; i++) {
//            if ((A >> i & 1) != (B >> i & 1)){
//                count++;
//            }
//        }
//        return count;
//    }

    @Test
    public void test(){
        Assertions.assertEquals(convertInteger(29 ,15),2);
        Assertions.assertEquals(convertInteger(1 ,2),2);
    }
}
