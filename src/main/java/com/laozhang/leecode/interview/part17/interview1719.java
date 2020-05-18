package com.laozhang.leecode.interview.part17;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？

 以任意顺序返回这两个数字均可。

 示例 1:

 输入: [1]
 输出: [2,3]

 示例 2:

 输入: [2,3]
 输出: [1,4]

 提示：

 nums.length <= 30000
 */
public class interview1719 {
    public int[] missingTwo(int[] nums) {
        int xor = 0, idx = 0;
        for (int num : nums) {
            xor ^= num;
            xor ^= ++idx;
        }
        xor ^= ++idx;
        xor ^= ++idx;
        int diff = xor & (-xor);
        int x = 0;
        idx = 0;
        for (int num : nums) {
            if ((diff & num) != 0)
                x ^= num;
            if ((diff & ++idx) != 0)
                x ^= idx;
        }
        if ((diff & ++idx) != 0)
            x ^= idx;
        if ((diff & ++idx) != 0)
            x ^= idx;
        return new int[]{x, xor ^ x};
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(missingTwo(new int[]{2,3})));

    }
}