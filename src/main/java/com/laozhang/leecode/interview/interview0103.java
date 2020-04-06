package com.laozhang.leecode.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 *
 * 示例1:
 *
 *  输入："Mr John Smith    ", 13
 *  输出："Mr%20John%20Smith"
 *
 * 示例2:
 *
 *  输入："               ", 5
 *  输出："%20%20%20%20%20"
 *
 * 提示：
 *
 *     字符串长度在[0, 500000]范围内。
 */
public class interview0103 {
    public String replaceSpaces(String S, int length) {
        if(S == null) return "";
        if(length == 0) return "";
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if(S.charAt(i) == ' ') spaceCount++;
        }
        int resultLen = length + spaceCount * 2;
        char[] resultArray = new char[resultLen];
        int index = 0,ptr = 0;
        char c;
        while(ptr < resultLen){
            c = S.charAt(index);
            if(c != ' '){
                resultArray[ptr++] = c;
            }else{
                resultArray[ptr++] = '%';
                resultArray[ptr++] = '2';
                resultArray[ptr++] = '0';
            }
            index++;
        }
        return new String(resultArray);
    }

    @Test
    public void test01(){
        Assertions.assertEquals(replaceSpaces("Mr John Smith    ",13),"Mr%20John%20Smith");
        Assertions.assertEquals(replaceSpaces("             ",5),"%20%20%20%20%20");
    }
}
