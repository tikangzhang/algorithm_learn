package com.laozhang.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class knapsackfor01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] result = new int[m][n];

        int[] weight = new int[m];
        int[] volume = new int[m];
        for (int i = 0; i < m; i++) {
            weight[i] = scanner.nextInt();
            volume[i] = scanner.nextInt();
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = result[i - 1][j];
                if (volume[i] < j){
                    result[i][j] = Math.max(result[i - 1][j],result[i - 1][j - volume[i]] + weight[i]);
                }
            }
        }


        int[] oResult = new int[n];
        oResult[0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= volume[i]; j--){
                oResult[i] = Math.max(oResult[j], oResult[j - volume[i]] + weight[i]);
            }
        }
    }
}
