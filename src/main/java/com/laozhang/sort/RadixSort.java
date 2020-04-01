package com.laozhang.sort;

import java.util.ArrayList;
import java.util.List;

/**
 *    最佳情况：T(n) = O(n * k)
 *    最差情况：T(n) = O(n * k)
 *    平均情况：T(n) = O(n * k)
 *
 *    空间复杂度 O(n + k)
 */
public class RadixSort implements Sort{
    public int[] sort(int[] array) {
        int len = array.length;
        if(len == 0){
            return array;
        }
        int max = array[0];
        for (int i = 0; i < len; i++) {
            if(array[i] > max){
                max = array[i];
            }
        }
        int radix = 0;
        while(max > 0){
            max /= 10;
            radix++;
        }
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            resultList.add(new ArrayList<>());
        }
        int voa = 10,div = 1;
        for (int i = 0; i < radix; i++,voa *= 10,div *= 10) {
            for (int j = 0; j < len; j++) {
                int num = (array[j] % voa) / div;
                resultList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < resultList.size(); j++) {
                for (int k = 0; k < resultList.get(j).size(); k++) {
                    array[index++] = resultList.get(j).get(k);
                }
                resultList.get(j).clear();
            }
        }
        return array;
    }
}
