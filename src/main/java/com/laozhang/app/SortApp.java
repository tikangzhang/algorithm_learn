package com.laozhang.app;

import com.laozhang.sort.*;

import java.util.Arrays;

public class SortApp {
    public static void main(String[] args) {
        int[] array = new int[]{2,4,6,1,1,6,10,2,1,1,1};

        Sort sort = new RadixSort();
        int[] result = sort.sort(array);
        System.out.println(Arrays.toString(result));
    }
}
