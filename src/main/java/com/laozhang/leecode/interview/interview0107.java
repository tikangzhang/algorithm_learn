package com.laozhang.leecode.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给定一幅由N × N矩阵表示的图像，其中每个像素的大小为4字节，编写一种方法，将图像旋转90度。
 *
 * 不占用额外内存空间能否做到？
 *
 *
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class interview0107 {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 1) return;
        int len = matrix.length;
        int temp = 0;

        // 镜像反转
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                swap(matrix,i,j,i,len - 1 -j);
            }
        }
        // 对角线反转
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if(i != j) {
                    swap(matrix,i,j,j,i);
                }
            }
        }
    }
//    public void rotate(int[][] matrix) {
//        if(matrix == null || matrix.length == 1) return;
//        int n = matrix.length;
//        int r = (n-1)>>1;
//        int c = (n>>1)-1;
//        for (int i = r; i >= 0; i--) {
//            for(int j = c; j >= 0; j--){
//                swap(matrix,i,j,j,n-i-1);
//                swap(matrix,i,j,n-i-1,n-1-j);
//                swap(matrix,i,j,n-1-j,i);
//            }
//        }
//    }

    private void swap(int[][] matrix,int i,int j,int m,int n){
        matrix[i][j] = matrix[i][j] ^ matrix[m][n];
        matrix[m][n] = matrix[m][n] ^ matrix[i][j];
        matrix[i][j] = matrix[m][n] ^ matrix[i][j];
    }

    @Test
    public void test01(){
        int[][] source = new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9}};
        Arrays.stream(source).forEach(line -> System.out.println(Arrays.toString(line)));
        System.out.println();
        rotate(source);
        Arrays.stream(source).forEach(line -> System.out.println(Arrays.toString(line)));
        System.out.println();


        source = new int[][]{
                new int[]{5, 1, 9,11},
                new int[]{2, 4, 8,10},
                new int[]{13, 3, 6, 7},
                new int[]{15,14,12,16}
        };
        Arrays.stream(source).forEach(line -> System.out.println(Arrays.toString(line)));
        System.out.println();
        rotate(source);
        Arrays.stream(source).forEach(line -> System.out.println(Arrays.toString(line)));
        System.out.println();
    }
}
