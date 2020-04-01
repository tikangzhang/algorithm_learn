package com.laozhang.sort;

/**
 * 最佳情况：T(n) = O(nlog2 n)
 * 最坏情况：T(n) = O(nlog2 n)
 * 平均情况：T(n) =O(nlog2n)
 * 空间复杂度 O(1)
 */
public class ShellSort implements Sort{
    public int[] sort(int[] array) {
        int len = array.length;
        if(len == 0){
            return array;
        }
        int gap;
        gap = len / 2;
        while(gap > 0){
            for (int i = gap; i < len; i++) {
                int preIndex = i - gap;
                int current = array[i];
                while(preIndex >= 0 && current < array[preIndex]){
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = current;
            }
            gap = gap / 2;
        }
        return array;
    }
}
