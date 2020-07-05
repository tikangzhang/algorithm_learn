package com.laozhang.leecode.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

 示例 1：
 输入：target = 9
 输出：[[2,3,4],[4,5]]

 示例 2：
 输入：target = 15
 输出：[[1,2,3,4,5],[4,5,6],[7,8]]

 限制：
 1 <= target <= 10^5
 */
public class offer57_2 {
    /**
     * 等差数列
     *  ((a+a+n-1)/2)*n=target,
     *  推导得 a=(target-n*(n-1)/2)/n, n(n-1)/2 是1到n-1的和
     */
    public int[][] findContinuousSequence(int target) {

        List<int[]> result = new ArrayList<>();
        int i = 1;

        while(target>0)
        {
            target -= i++;
            if(target>0 && target%i == 0)
            {
                int[] array = new int[i];
                for(int k = target/i, j = 0; k < target/i+i; k++,j++)
                {
                    array[j] = k;
                }
                result.add(array);
            }
        }
        Collections.reverse(result);
        return result.toArray(new int[0][]);
    }
//
//    public int[][] findContinuousSequence(int target) {
//        int i = 1; // 滑动窗口的左边界
//        int j = 1; // 滑动窗口的右边界
//        int sum = 0; // 滑动窗口中数字的和
//        List<int[]> res = new ArrayList<>();
//
//        while (i <= target / 2) {
//            if (sum < target) {
//                // 右边界向右移动
//                sum += j;
//                j++;
//            } else if (sum > target) {
//                // 左边界向右移动
//                sum -= i;
//                i++;
//            } else {
//                // 记录结果
//                int[] arr = new int[j-i];
//                for (int k = i; k < j; k++) {
//                    arr[k-i] = k;
//                }
//                res.add(arr);
//                // 左边界向右移动
//                sum -= i;
//                i++;
//            }
//        }
//
//        return res.toArray(new int[res.size()][]);
//    }
}
