package com.laozhang.leecode.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 *
 * 示例2:
 *
 *  输入："abbccd"
 *  输出："abbccd"
 *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 *
 * 提示：
 *
 *     字符串长度在[0, 50000]范围内。
 */
public class interview0106 {
    public String compressString(String S) {
        if (S == null) return S;
        int len = S.length();
        if (len <= 2) return S;

        StringBuilder sb = new StringBuilder();
        char head = S.charAt(0),temp;
        int count = 0;
        for (int i = 0; i < len; i++) {
            temp = S.charAt(i);
            if(head == temp){
                ++count;
            }else {
                sb.append(head).append(count);
                head = temp;
                count = 1;
            }
        }
        if (count > 0){
            sb.append(head).append(count);
        }
        if(sb.length() < len){
            return sb.toString();
        }
        return S;
    }

    @Test
    public void test01(){
        Assertions.assertEquals(compressString("aabcccccaaa"),"a2b1c5a3");
        Assertions.assertEquals(compressString("abbccd"),"abbccd");
    }
}
