package com.laozhang.leecode.interview.part17;

import org.junit.jupiter.api.Test;

/**
 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。

 示例：

 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 输出： [1,2,3,4]

 提示：

 0 <= len(arr) <= 100000
 0 <= k <= min(100000, len(arr))
 */
public class interview1714 {
    public int[] smallestK(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }

        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int pos = partition(arr, low, high);
            if (pos == k - 1) {
                break;
            } else if (pos < k - 1) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }

        int[] dest = new int[k];
        System.arraycopy(arr, 0, dest, 0, k);
        return dest;
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }

            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

//    public int[] smallestK(int[] arr, int k) {
//        int len = arr.length;
//        if (k >= len) {
//            return arr;
//        }
//
//        buildMinHeap(arr, len);
//
//        int pos = len - k;
//        for (int i = len - 1; i >= pos; i--) {
//            swap(arr, 0, i);
//            heapify(arr, 0, --len);
//        }
//
//        int[] ret = new int[k];
//        System.arraycopy(arr, pos, ret, 0, k);
//        return ret;
//    }
//
//    private void buildMinHeap(int[] arr, int len) {
//        for (int i = (len - 1) / 2; i >= 0; i--) {
//            heapify(arr, i, len);
//        }
//    }
//
//    private void heapify(int[] arr, int i, int len) {
//        if (i >= len) return;
//
//        int min = i;
//        int c1 = 2 * i + 1;
//        int c2 = 2 * i + 2;
//
//        if (c1 < len && arr[c1] < arr[min]) {
//            min = c1;
//        }
//        if (c2 < len && arr[c2] < arr[min]) {
//            min = c2;
//        }
//
//        if (min != i) {
//            swap(arr, i, min);
//            heapify(arr, min, len);
//        }
//    }
//
//    private void swap(int[] arr, int i, int j) {
//        int tmp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = tmp;
//    }

    @Test
    public void test(){

    }
}