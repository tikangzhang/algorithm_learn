package com.laozhang.leecode.offer;

import com.laozhang.leecode.interview.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

 参考以下这颗二叉搜索树：

 5
 / \
 2   6
 / \
 1   3

 示例 1：

 输入: [1,6,3,2,5]
 输出: false

 示例 2：

 输入: [1,3,2,6,5]
 输出: true

 提示：

 数组长度 <= 1000
 */
public class offer33 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    boolean recur(int[] postorder, int i, int j) {
        if(i >= j) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }


//    public boolean verifyPostorder(int[] postorder) {
//        Stack<Integer> stack = new Stack<>();
//        int root = Integer.MAX_VALUE;
//        for(int i = postorder.length - 1; i >= 0; i--) {
//            if(postorder[i] > root) return false;
//            while(!stack.isEmpty() && stack.peek() > postorder[i])
//                root = stack.pop();
//            stack.add(postorder[i]);
//        }
//        return true;
//    }
}
