package com.laozhang.sort;

import java.util.Arrays;

/**
 *    最佳情况：T(n) = O(n+k)
 *    最差情况：T(n) = O(n+k)
 *    平均情况：T(n) = O(n+k)
 *
 *    空间复杂度 O(k)
 */
public class CountingSort implements Sort{
    public int[] sort(int[] array) {
        int len = array.length;
        if(len == 0){
            return array;
        }
        int max = array[0],min = array[0];
        for (int i = 0; i < len; i++) {
            if(array[i] > max){
                max = array[i];
                continue;
            }
            if(array[i] < min){
                min = array[i];
            }
        }
        int offset = -min;
        int[] countArray = new int[max - min + 1];
        Arrays.fill(countArray,0);
        for (int i = 0; i < len; i++) {
            countArray[array[i] + offset]++;
        }
        int index = 0,i = 0;
        while(index < len){
            if(countArray[i] > 0){
                array[index++] = min + i;
                countArray[i]--;
            }else{
                i++;
            }
        }
        return array;
    }
}
