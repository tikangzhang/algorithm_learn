package com.laozhang.leecode.interview.part04;

import com.laozhang.leecode.interview.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Stack;

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
    long pre;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        pre = Long.MIN_VALUE;
        flag = true;
        help(root);
        return flag;
    }
    void help(TreeNode root) {
        if (root == null || !flag) return;
        help(root.left);
        if (root.val > pre)
            pre = root.val;
        else
            flag = false;
        help(root.right);
    }

//    public boolean isValidBST(TreeNode root) {
//        long pre=Long.MIN_VALUE;
//        Stack<TreeNode> stack=new Stack<>();
//        while (root != null) {
//            stack.push(root);
//            root=root.left;
//        }
//        while(!stack.empty()){
//            TreeNode temp=stack.pop();
//            if(temp.val<=pre)
//                return false;
//            pre=temp.val;
//            if(temp.right!=null){
//                TreeNode r=temp.right;
//                while(r!=null){
//                    stack.push(r);
//                    r=r.left;
//                }
//            }
//        }
//        return true;
//    }


//    public boolean isValidBST(TreeNode root) {
//        if (root == null) return true;
//        TreeNode left = root.left,right = root.right;
//        while(left != null && left.right != null) left = left.right;
//        while(right != null && right.left != null) right = right.left;
//        boolean re = (left == null || left.val < root.val) && (right == null || right.val > root.val);
//        return re & isValidBST(root.left) & isValidBST(root.right);
//    }

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
