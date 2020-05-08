package com.laozhang.leecode.interview.part17;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
 *
 * 示例:
 *
 * 输入: 25
 * 输出: 9
 * 解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次)
 *
 * 提示：
 *
 *     n <= 10^9
 */
public class interview1706 {
    /**
     * - i     a      b      res
     * - 1     324    0      (324+7)/10*1 + 0 = 33
     * - 10    32     4      (32+7)/10*10 + 5 = 35
     * - 100   3      24     (3+7)/10*100 + 0 = 100
     */
    public int numberOf2sInRange(int n) {
        if(n <= 1)
            return 0;
        if(n <= 11)
            return 1;
        int a=0, b=0, res=0;
        for(int i=1; i<=n; i*=10){
            a = n/i;
            b = n%i;
            if(a % 10 == 2) {
                res += (a+7)/10*i + (b + 1);
            }else{
                res += (a+7)/10*i;
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(numberOf2sInRange(324));
    }
}