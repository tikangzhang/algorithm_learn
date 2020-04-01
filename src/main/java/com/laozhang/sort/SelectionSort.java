package com.laozhang.sort;

/**
 * 最佳情况：T(n) = O(n2)
 * 最差情况：T(n) = O(n2)
 * 平均情况：T(n) = O(n2)
 *
 * 空间复杂度 O(1)
 */
public class SelectionSort implements Sort{
    public int[] sort(int[] array) {
        int len = array.length;
        if(len == 0){
            return array;
        }
        int min;
        for (int i = 0; i < len; i++) {
            min = i;
            for (int j = i + 1; j < len ;j++) {
                if(array[min] > array[j]){
                    min = j;
                }
            }
            if(min != i) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        return array;
    }
}
