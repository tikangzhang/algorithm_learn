package com.laozhang.leecode.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 * 示例 2：
 *
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 */
public class interview0108 {
    public void setZeroes(int[][] matrix) {
        if(matrix == null) return;
        int m = matrix.length;
        int n = matrix[0].length;

        boolean hang = false,lie = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    if (i == 0) {
                        hang = true;
                    }
                    if (j == 0) {
                        lie = true;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if(matrix[i][0] == 0){
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if(matrix[0][i] == 0){
                for (int j = 1; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if(hang){
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if(lie){
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    @Test
    public void test01(){
        int[][] source = new int[][]{
                new int[]{1,1,1},
                new int[]{1,0,1},
                new int[]{1,1,1}};
        Arrays.stream(source).forEach(line -> System.out.println(Arrays.toString(line)));
        System.out.println();
        setZeroes(source);
        Arrays.stream(source).forEach(line -> System.out.println(Arrays.toString(line)));
        System.out.println();


        int[][] source01 = new int[][]{
                new int[]{0,1,2,0},
                new int[]{3,4,5,2},
                new int[]{1,3,1,5}};
        Arrays.stream(source01).forEach(line -> System.out.println(Arrays.toString(line)));
        System.out.println();
        setZeroes(source01);
        Arrays.stream(source01).forEach(line -> System.out.println(Arrays.toString(line)));
        System.out.println();
    }
}
