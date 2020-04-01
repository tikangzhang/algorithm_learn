package com.laozhang.sort;

/**
 *    最佳情况：T(n) = O(nlogn)
 *    最差情况：T(n) = O(nlogn)
 *    平均情况：T(n) = O(nlogn)
 *
 *    空间复杂度 O(1)
 */
public class HeapSort implements Sort{
    static int len;
    public int[] sort(int[] array) {
        len = array.length;
        if(len == 0){
            return array;
        }
        buildMaxHeap(array);
        while(len > 0){
            swap(array,0,len - 1);
            len --;
            adjustHeap(array,0);
        }

        return array;
    }

    private void buildMaxHeap(int[] array){
        for(int i = len / 2 - 1; i >= 0; i--){
            adjustHeap(array,i);
        }
    }

    private void adjustHeap(int[] array,int i){
        int maxIndex = i;
        int temp = i * 2;
        if(temp < len && array[temp] > array[maxIndex]){
            maxIndex = temp;
        }

        temp = i * 2 + 1;
        if(temp < len && array[temp] > array[maxIndex]){
            maxIndex = temp;
        }

        if(i != maxIndex){
            swap(array,i,maxIndex);
            adjustHeap(array,maxIndex);
        }
    }

    private void swap(int[] array,int a,int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
