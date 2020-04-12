package com.laozhang.leecode.interview.part01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 *
 * 示例2:
 *
 *  输入：s1 = "aa", "aba"
 *  输出：False
 */
public class interview0109 {
    public boolean isFlipedString(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;

        return (s1 + s2).contains(s1);
    }

    @Test
    public void test01(){
        Assertions.assertTrue(isFlipedString("waterbottle","erbottlewat"));
        Assertions.assertFalse(isFlipedString("aa","aba"));
    }
}
