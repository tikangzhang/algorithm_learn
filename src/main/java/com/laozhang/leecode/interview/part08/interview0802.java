package com.laozhang.leecode.interview.part08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
 * 解释:
 * 输入中标粗的位置即为输出表示的路径，即
 * 0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
 *
 * 说明：r 和 c 的值均不超过 100。
 */
public class interview0802 {
    private LinkedList<List<Integer>> res = new LinkedList<>();
    private int global_row, global_col;
    private int[][] global_grid;
    private boolean found = false;

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        global_row = obstacleGrid.length;
        global_col = obstacleGrid[0].length;
        if (obstacleGrid[0][0] > 0 || obstacleGrid[global_row - 1][global_col - 1] > 0) return res;
        global_grid = obstacleGrid;
        res.addLast(Arrays.asList(0, 0));
        dfs(0, 0);
        return found ? res : new LinkedList<>();
    }

    private void dfs(int row, int col) {
        if (row == global_row - 1 && col == global_col - 1) {
            found = true;
            return;
        }
        if (col + 1 < global_col && global_grid[row][col + 1] == 0) {
            res.addLast(Arrays.asList(row, col + 1));
            dfs(row, col + 1);
            if (found) return;
            res.removeLast();
        }
        if (row + 1 < global_row && global_grid[row + 1][col] == 0) {
            res.addLast(Arrays.asList(row + 1, col));
            dfs(row + 1, col);
            if (found) return;
            res.removeLast();
        }
    }

    @Test
    public void test(){

    }
}
