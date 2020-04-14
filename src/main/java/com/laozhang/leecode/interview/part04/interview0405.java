package com.laozhang.leecode.interview.part04;

import com.laozhang.leecode.interview.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class interview0405 {
    public boolean isValidBST(TreeNode root) {
        return false;
    }

    @Test
    public void test(){
        Integer[] sorted = new Integer[]{2,1,3};
        TreeNode node = TreeNode.build(sorted);
        Assertions.assertTrue(isValidBST(node));

        sorted = new Integer[]{5,1,4,null,null,3,6};
        node = TreeNode.build(sorted);
        Assertions.assertFalse(isValidBST(node));
    }
}
