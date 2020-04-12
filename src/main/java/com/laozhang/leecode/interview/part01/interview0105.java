package com.laozhang.leecode.interview.part01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 *
 *
 * 示例 1:
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *
 *
 *
 * 示例 2:
 *
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 */
public class interview0105 {
    public boolean oneEditAway(String first, String second) {
        if(first == null || second == null) return false;
        int moreLen = first.length();
        int lessLen = second.length();
        if(moreLen < lessLen){
            return oneEditAway(second,first);
        }
        if(moreLen - lessLen > 1){
            return false;
        }

        int editCount = 0;
        for(int i = 0,j = 0; i < moreLen;i++){
            if(j >= lessLen || first.charAt(i) != second.charAt(j)){
                editCount++;
                if(moreLen == lessLen){
                    j++;
                }
            }else{
                j++;
            }
            if(editCount > 1){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test01(){
        Assertions.assertTrue(oneEditAway("ple","pale"));
        Assertions.assertTrue(oneEditAway("pale","ple"));
        Assertions.assertFalse(oneEditAway("pales","pal"));
        Assertions.assertFalse(oneEditAway("leetcode","ltcode"));
        Assertions.assertFalse(oneEditAway("letcode","ltcodee"));
        Assertions.assertTrue(oneEditAway("leetcode","leatcode"));
    }
}
