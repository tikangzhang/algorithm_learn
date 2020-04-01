package com.laozhang.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *    最佳情况：T(n) = O(n+k)
 *    最差情况：T(n) = O(n+k)
 *    平均情况：T(n) = O(n2)
 *
 *    空间复杂度 O(n + k)
 */
public class BucketSort implements Sort{
    public int[] sort(int[] array) {
        int len = array.length;
        if(len == 0){
            return array;
        }
        List<Integer> arrayList = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            arrayList.add(array[i]);
        }
        List<Integer> integers = BucketSorting(arrayList, 5);
        for (int i = 0; i < len; i++) {
            array[i] = integers.get(i);
        }
        return array;
    }
    private List<Integer> BucketSorting(List<Integer> arrayList,int bucketSize){
        if(arrayList == null || arrayList.size() < 2){
            return arrayList;
        }
        int len = arrayList.size();
        int max = arrayList.get(0);
        int min = max;
        for (int i = 0; i < len; i++) {
            if(arrayList.get(i) > max){
                max = arrayList.get(i);
                continue;
            }
            if(arrayList.get(i) < min){
                min = arrayList.get(i);
            }
        }
        int bucketCount = (max - min) / bucketSize + 1;
        List<List<Integer>> bucketArray = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            bucketArray.add(new ArrayList<>(bucketSize));
        }
        List<Integer> resultArray = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            bucketArray.get((arrayList.get(i) - min) / bucketSize).add(arrayList.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if(bucketSize == 1){
                for (int j = 0; j < bucketArray.get(i).size(); j++) {
                    resultArray.add(bucketArray.get(i).get(j));
                }
            }else{
                if(bucketCount == 1){
                    bucketSize--;
                }
                List<Integer> temp = BucketSorting(bucketArray.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++)
                    resultArray.add(temp.get(j));
            }
        }
        return resultArray;
    }
}

