package com.laozhang.leecode.interview.part10;

import org.junit.jupiter.api.Test;

/**
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 *
 * 示例1:
 *
 *  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 *  输出：-1
 *  说明: 不存在返回-1。
 *
 * 示例2:
 *
 *  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 *  输出：4
 *
 * 提示:
 *
 *     words的长度在[1, 1000000]之间
 */
public class interview1005 {
    public int findString(String[] words, String s) {
        int left = 0, right = words.length - 1;
        while (left <= right) {
            if (words[left].length() == 0) {
                left++;
                continue;
            }
            if (words[right].length() == 0) {
                right--;
                continue;
            }
            int mid = (right + left) / 2;
            while (words[mid].length() == 0) {
                mid++;
                if (mid == right) {
                    right = (right + left) / 2;
                    continue;
                }
            }

            if (words[mid] == s)
                return mid;
            else if (words[mid].compareTo(s) > 0) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }

    @Test
    public void test(){

    }
}
