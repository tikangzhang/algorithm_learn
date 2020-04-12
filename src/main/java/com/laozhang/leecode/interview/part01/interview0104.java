package com.laozhang.leecode.interview.part01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 *
 *
 * 示例1：
 *
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 */
public class interview0104 {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return false;
        if (s.length() == 1) return true;
        long low = 0L,high = 0L;
        for (char c : s.toCharArray()) {
            if(c >= 64){
                high ^= 1 << (c - 64);
            }else{
                low ^= 1 << c;
            }
        }
        return Long.bitCount(low) + Long.bitCount(high) <= 1;
    }
//    public boolean canPermutePalindrome(String s) {
//        if (s == null || s.length() == 0) return false;
//        if (s.length() == 1) return true;
//        Set<Character> result = new HashSet<>();
//        for (char temp : s.toCharArray()) {
//            if(result.contains(temp)){
//                result.remove(temp);
//            }else{
//                result.add(temp);
//            }
//        }
//        return result.size() <= 1;
//    }

    @Test
    public void test01(){
        Assertions.assertFalse(canPermutePalindrome("abc"));
        Assertions.assertTrue(canPermutePalindrome("tactcoa"));
        Assertions.assertTrue(canPermutePalindrome("laozhanglaozhang"));
    }
}
