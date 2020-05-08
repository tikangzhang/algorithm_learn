package com.laozhang.leecode.interview.part17;

import com.laozhang.leecode.interview.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求值的顺序保持不变，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。

 返回转换后的单向链表的头节点。

 注意：本题相对原题稍作改动



 示例：

 输入： [4,2,5,1,3,null,6,0]
 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]

 提示：

 节点数量不会超过 100000。
 */
public class interview1712 {
    /**
     * 非递归
     */
    public TreeNode convertBiNode(TreeNode root) {
        TreeNode head = new TreeNode(0);// 单链表的头指针哨兵
        TreeNode prev = head;// 移动的链表前置指针
        // 开始中序遍历
        TreeNode node = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (node != null || !stack.isEmpty()){
            if (node != null){
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                // ---链表处理
                node.left = null;// 当前节点左指针置空
                prev.right = node;// 前置指针右指针指向当前节点，作为链表的next指针，链表新增元素
                prev = node;// 指针后移
                // ---链表处理
                // 中序遍历进入右子树
                node = node.right;
            }
        }
        return head.right;
    }

    /**
     * 递归
     */
//    public TreeNode convertBiNode(TreeNode root) {
//        TreeNode head = new TreeNode(0);// 单链表的头指针哨兵
//        // 开始中序遍历
//        inorder(root,head);
//        return head.right;
//    }
//
//    private TreeNode inorder(TreeNode root,TreeNode prev){
//        if (root != null){
//            prev = inorder(root.left,prev);
//            root.left = null;
//            prev.right = root;
//            prev = root;
//            prev = inorder(root.right,prev);
//        }
//        return prev;
//    }

    @Test
    public void test(){

    }
}