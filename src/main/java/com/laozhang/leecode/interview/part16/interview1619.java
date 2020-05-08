package com.laozhang.leecode.interview.part16;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。

 示例：

 输入：
 [
 [0,2,1,0],
 [0,1,0,1],
 [1,1,0,1],
 [0,1,0,1]
 ]
 输出： [1,2,4]

 提示：

 0 < len(land) <= 1000
 0 < len(land[i]) <= 1000
 */
public class interview1619 {
    public int[] pondSizes(int[][] land) {
        if (land == null || land.length == 0) {
            return new int[0];
        }

        List<Integer> pondSizeList = new ArrayList<>();

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    currPondSize = 0;
                    dfs(land, i, j);
                    pondSizeList.add(currPondSize);
                }
            }
        }

        int[] res = new int[pondSizeList.size()];
        for (int i = 0; i < pondSizeList.size(); i++) {
            res[i] = pondSizeList.get(i);
        }
        Arrays.sort(res);
        return res;
    }

    int[][] dirs = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };

    public int currPondSize = 0;

    public void dfs(int[][] land, int i, int j) {
        land[i][j] = -1;
        currPondSize++;

        for (int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (0 <= newI && newI < land.length && 0 <= newJ && newJ < land[0].length && land[newI][newJ] == 0) {
                dfs(land, newI, newJ);
            }
        }
    }

    @Test
    public void test(){

    }
}