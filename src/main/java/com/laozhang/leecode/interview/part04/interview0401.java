package com.laozhang.leecode.interview.part04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 *
 * 示例1:
 *
 *  输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 *  输出：true
 *
 * 示例2:
 *
 *  输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 *  输出 true
 *
 * 提示：
 *
 *     节点数量n在[0, 1e5]范围内。
 *     节点编号大于等于 0 小于 n。
 *     图中可能存在自环和平行边。
 */
public class interview0401 {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        LinkedList<Integer>[] container = new LinkedList[n];
        for (int[] side : graph){
            if(container[side[0]] == null){
                container[side[0]] = new LinkedList<>();
            }
            container[side[0]].add(side[1]);
        }
        boolean[] check = new boolean[n];

        //return dfs(check,container,start,target);
        return bfs(check,container,start,target);
    }

    private boolean dfs(boolean[] check ,LinkedList<Integer>[] container,int start,int target){
        if (start == target) return true;
        check[start] = true;

        LinkedList<Integer> integers = container[start];
        if (integers == null) return false;
        for (Integer child : integers){
            if (check[child]) continue;
            return dfs(check,container,child,target);
        }
        return false;
    }

    private boolean bfs(boolean[] check ,LinkedList<Integer>[] container,int start,int target){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(queue.size() > 0){
            int head = queue.poll();
            if (check[head]) {
                continue;
            }
            check[head] = true;
            if (head == target){
                return true;
            }else{
                if (container[head] != null){
                    queue.addAll(container[head]);
                }
            }
        }
        return false;
    }

    @Test
    public void test(){
        int[][] graph = new int[][]{new int[]{0,1}, new int[]{0, 0},new int[]{0, 0}, new int[]{1, 2}};
        int source = 0,target = 2,n = 3;
        Assertions.assertTrue(findWhetherExistsPath(n,graph,source,target));

        graph = new int[][]{new int[]{0, 0}, new int[]{0, 2},new int[]{1, 4}, new int[]{1, 4},
                new int[]{0, 0}, new int[]{1, 3},new int[]{2, 4}, new int[]{1, 3},
                new int[]{2, 3}, new int[]{1, 4}};
        n = 5;
        target = 4;
        Assertions.assertTrue(findWhetherExistsPath(n,graph,source,target));
    }
}
