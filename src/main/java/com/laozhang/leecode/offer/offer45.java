package com.laozhang.leecode.offer;

import java.util.Arrays;

/**
 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。

 示例 1:

 输入: [10,2]
 输出: "102"

 示例 2:

 输入: [3,30,34,5,9]
 输出: "3033459"


 提示:
 0 < nums.length <= 100

 说明:
 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 */
public class offer45 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        fastSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
    void fastSort(String[] strs, int l, int r) {
        if(l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while(i < j) {
            while((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        fastSort(strs, l, i - 1);
        fastSort(strs, i + 1, r);
    }

//    public String minNumber(int[] nums) {
//        String[] strs = new String[nums.length];
//        for(int i = 0; i < nums.length; i++)
//            strs[i] = String.valueOf(nums[i]);
//        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
//        StringBuilder res = new StringBuilder();
//        for(String s : strs)
//            res.append(s);
//        return res.toString();
//    }
}
