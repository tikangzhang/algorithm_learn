package com.laozhang.leecode.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: false
 *
 * 示例 2：
 *
 * 输入: s = "abc"
 * 输出: true
 *
 * 限制：
 *
 *     0 <= len(s) <= 100
 *     如果你不使用额外的数据结构，会很加分。
 */
public class interview0101 {
    public boolean isUnique(String str) {
        if(str == null || str.length() == 0){
            return false;
        }
        int flag = 0;
        char[] chars = str.toCharArray();
        int index = 0;
        for(char c : chars){
            index = 1 << c - 'a';
            if((index & flag) != 0){
                return false;
            }else{
                flag |= index;
            }
        }
        return true;
    }

    @Test
    public void test01(){
        Assertions.assertTrue(isUnique("abc"));
        Assertions.assertFalse(isUnique("abbc"));
        Assertions.assertFalse(isUnique("leetcode"));
    }
}
