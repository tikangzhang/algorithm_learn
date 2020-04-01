package com.laozhang.sort;

/**
 * 最佳情况：T(n) = O(n)
 * 最差情况：T(n) = O(n2)
 * 平均情况：T(n) = O(n2)
 *
 * 空间复杂度 O(1)
 */
public class QuickSort implements Sort{
    public int[] sort(int[] array) {
        int len = array.length;
        if(len == 0){
            return array;
        }
        return quickSort(array,0,array.length - 1);
    }

    private int[] quickSort(int[] array,int start,int end){
        if(array.length <= 0 || start < 0 || start > end){
            return null;
        }
        int smallIndex = partition(array,start,end);
        if(smallIndex > start){
            quickSort(array,start,smallIndex -1);
        }
        if(smallIndex < end){
            quickSort(array,smallIndex,end);
        }
        return array;
    }

    private int partition(int[] array,int start,int end){
        int pivot = (int)(start + Math.random() * (end - start + 1));
        swap(array,pivot,end);
        int smallIndex = start - 1;
        for(int i = start;i <= end;i++){
            if(array[i] <= array[end]){
                smallIndex++;
                if(i > smallIndex) {
                    swap(array, i, smallIndex);
                }
            }
        }
        return smallIndex;
    }

    private void swap(int[] array,int a,int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
