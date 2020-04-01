package com.laozhang.sort;

import java.util.Arrays;

/**
 * 最佳情况：T(n) = O(n)
 * 最差情况：T(n) = O(nlogn)
 * 平均情况：T(n) = O(nlogn)
 * 空间复杂度 O(n)
 */
public class MergeSort implements Sort{
    public int[] sort(int[] array) {
        int len = array.length;
        if(len <= 1){
            return array;
        }
        int mid = len / 2;
        int[] left = Arrays.copyOfRange(array,0,mid);
        int[] right = Arrays.copyOfRange(array,mid,len);
        return merge(sort(left),sort(right));
    }

    private int[] merge(int[] left,int[] right){
        int leftLen = left.length;
        int rightLen = right.length;
        int[] result = new int[leftLen + rightLen];
        for(int index = 0,i = 0,j = 0;index < result.length;index++){
            if(i >= leftLen){
                result[index] = right[j++];
            }else if(j >= rightLen){
                result[index] = left[i++];
            }else if(left[i] > right[j]){
                result[index] = right[j++];
            }else{
                result[index] = left[i++];
            }
        }
        return result;
    }
}
