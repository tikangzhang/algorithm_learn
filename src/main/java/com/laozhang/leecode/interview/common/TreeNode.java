package com.laozhang.leecode.interview.common;

import java.util.Arrays;
import java.util.LinkedList;

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

    public static TreeNode build(Integer[] sorted){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(sorted));

        LinkedList<TreeNode> container = new LinkedList<>();
        TreeNode treeNode = new TreeNode(queue.poll());
        container.add(treeNode);

        TreeNode cur;
        Integer temp;
        while(container.size() > 0){
            cur = container.poll();
            temp = queue.poll();
            if (temp == null){
                cur.left = null;
            }else{
                cur.left = new TreeNode(temp);
                container.add(cur.left);
            }

            temp = queue.poll();
            if (temp == null){
                cur.right = null;
            }else{
                cur.right = new TreeNode(temp);
                container.add(cur.right);
            }
        }
        return treeNode;
    }
}
