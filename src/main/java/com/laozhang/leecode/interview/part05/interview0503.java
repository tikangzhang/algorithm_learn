package com.laozhang.leecode.interview.part05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 *
 * 示例 1：
 *
 * 输入: num = 1775(110111011112)
 * 输出: 8
 *
 * 示例 2：
 *
 * 输入: num = 7(01112)
 * 输出: 4
 */
public class interview0503 {
    public int reverseBits(int num) {
        int count = 1;
        int pos = -1;
        int result = 0;
        for (int i = 0; i < 33; i++) {
            if ((num & 1) == 1){
                count++;
            }else{
                result = Math.max(count,result);
                count = i - pos;
                pos = i;
            }
            System.out.println(result + " " + count + " " + pos);
            num = num >>> 1;
        }
        return result;
    }

    @Test
    public void test(){
        Assertions.assertEquals(reverseBits(1775),8);
        //Assertions.assertEquals(reverseBits(7),4);
    }
}
