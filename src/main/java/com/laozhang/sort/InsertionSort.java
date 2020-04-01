package com.laozhang.sort;

/**
 * 最佳情况：T(n) = O(n)
 * 最坏情况：T(n) = O(n2)
 * 平均情况：T(n) = O(n2)
 * 空间复杂度 O(1)
 */
public class InsertionSort implements Sort{
    public int[] sort(int[] array) {
        int len = array.length;
        if(len == 0){
            return array;
        }
        int preIndex,current;
        for (int i = 0; i < len - 1; i++) {
            preIndex = i;
            current = array[preIndex + 1];
            while(preIndex >= 0 && current < array[preIndex]){
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
}
