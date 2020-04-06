package com.laozhang.leecode.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 *
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 *
 * 说明：
 *
 *     0 <= len(s1) <= 100
 *     0 <= len(s2) <= 100
 */
public class interview0102 {
    public boolean CheckPermutation(String s1, String s2) {
        if(s1 == null || s2 == null){
            return false;
        }
        if (s1.length() != s2.length()){
            return false;
        }
        char[] array01 = s1.toCharArray();
        char[] array02 = s2.toCharArray();
        Arrays.sort(array01);
        Arrays.sort(array02);
        return Arrays.equals(array01,array02);
    }
//    public boolean CheckPermutation(String s1, String s2) {
//        if(s1 == null || s2 == null){
//            return false;
//        }
//        if (s1.length() != s2.length()){
//            return false;
//        }
//        int[] flags = new int[26];
//        Arrays.fill(flags,0);
//        for (int i = 0,len = s1.length(); i < len; i++) {
//            flags[s1.charAt(i) - 'a']++;
//            flags[s2.charAt(i) - 'a']--;
//        }
//        for (int result : flags){
//            if (result != 0){
//                return false;
//            }
//        }
//        return true;
//    }


//    有问题
//    public boolean CheckPermutation(String s1, String s2) {
//        if(s1 == null || s2 == null){
//            return false;
//        }
//        int lenStr01 = s1.length();
//        int lenStr02 = s2.length();
//        if (lenStr01 != lenStr02){
//            return false;
//        }
//        int flag = 0;
//        for (int i = 0; i < lenStr01; i++) {
//            flag ^= s1.charAt(i);
//            flag ^= s2.charAt(i);
//        }
//        return flag == 0;
//    }

    @Test
    public void test01(){
        Assertions.assertTrue(CheckPermutation("abc","cab"));
        Assertions.assertTrue(CheckPermutation("abbc","cbba"));
        Assertions.assertFalse(CheckPermutation("aabb","bbcc"));
    }
}
