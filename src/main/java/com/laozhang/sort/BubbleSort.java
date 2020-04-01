package com.laozhang.sort;

/**
 * 最佳情况：T(n) = O(n)
 * 最差情况：T(n) = O(n2)
 * 平均情况：T(n) = O(n2)
 *
 * 空间复杂度 O(1)
 */
public class BubbleSort implements Sort{
    public int[] sort(int[] array) {
        int len = array.length;
        if(len == 0){
            return array;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if(array[j + 1] > array[j]){
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
