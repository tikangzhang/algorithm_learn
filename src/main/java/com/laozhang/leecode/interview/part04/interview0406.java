package com.laozhang.leecode.interview.part04;

import com.laozhang.leecode.interview.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 *
 * 示例 1:
 *
 * 输入: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 *
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * 输出: null
 */
public class interview0406 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // p存在右子树，直接后继就是右子树的最左节点
        if (p.right != null){
            p = p.right;
            while (p.left != null){
                p = p.left;
            }
            return p;
        }
        // p不存在右子树
        TreeNode node = root;
        TreeNode res = null;
        while (p != node){
            if (p.val < node.val){
                // node比p大，表示node在p的后继路径上
                res = node;// 左孩子的父节点
                node = node.left;
            }else {
                // node比p小，表示node在p的前驱路径上
                node = node.right;
            }
        }
        return res;
    }

    @Test
    public void test(){
    }
}
