package com.laozhang.leecode.interview.part04;

import com.laozhang.leecode.interview.common.ListNode;
import com.laozhang.leecode.interview.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *       1
 *      / \
 *     2   2
 *    / \
 *   3   3
 *  / \
 * 4   4
 * 返回 false 。
 */
public class interview0404 {
    private boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        high(root);
        return balanced;
    }

    private int high(TreeNode node){
        if (!balanced) return 0;
        if (node == null) return 0;

        int left = high(node.left);
        int right = high(node.right);
        if(Math.abs(left - right) > 1){
            balanced = false;
        }
        return Math.max(left,right) + 1;
    }

    @Test
    public void test(){
        Integer[] sorted = new Integer[]{3,9,20,null,null,15,7};
        TreeNode node = TreeNode.build(sorted);
        Assertions.assertTrue(isBalanced(node));

        sorted = new Integer[]{1,2,2,3,3,null,null,4,4};
        node = TreeNode.build(sorted);
        Assertions.assertFalse(isBalanced(node));
    }
}
