package com.laozhang.leecode.interview.common;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }

    public static void print(TreeNode treeNode){
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        print(treeNode.left);
        print(treeNode.right);
    }
}
