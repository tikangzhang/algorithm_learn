package com.laozhang.leecode.interview.part05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
 *
 * 示例1:
 *
 *  输入：num = 2（或者0b10）
 *  输出 1 (或者 0b01)
 *
 * 示例2:
 *
 *  输入：num = 3
 *  输出：3
 *
 * 提示:
 *
 *     num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。
 */
public class interview0507 {
    public int exchangeBits(int num) {
        int even = 0xAAAAAAAA & num;
        int odd = 0x55555555 & num;
        return (odd << 1) | (even >> 1);
    }

    @Test
    public void test(){
        Assertions.assertEquals(exchangeBits(2),1);
        Assertions.assertEquals(exchangeBits(3),3);
    }
}
