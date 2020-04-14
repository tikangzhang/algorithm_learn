package com.laozhang.leecode.interview.part04;

import com.laozhang.leecode.interview.common.ListNode;
import com.laozhang.leecode.interview.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *
 *
 *
 * 示例：
 *
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 */
public class interview0403 {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) return null;

        List<ListNode> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> childQueue = new LinkedList<>();
        queue.add(tree);
        int depth = 0;
        ListNode node;
        while(queue.size() > 0 || childQueue.size() > 0){
            if (queue.size() > 0) {
                TreeNode temp = queue.poll();
                if (result.size() <= depth){
                    node = new ListNode(temp.val);
                    result.add(depth,node);
                }else {
                    node = result.get(depth);
                    while (node.next != null) node = node.next;
                    node.next = new ListNode(temp.val);
                }
                if (temp.left != null)childQueue.add(temp.left);
                if (temp.right != null)childQueue.add(temp.right);
            }else{
                LinkedList<TreeNode> tempQ = queue;
                queue = childQueue;
                childQueue = tempQ;
                depth++;
            }
        }
        int len = result.size();
        ListNode[] container = new ListNode[len];
        for (int i = 0; i < len; i++) {
            container[i] = result.get(i);
        }
        return container;
    }

    @Test
    public void test(){
        Integer[] sorted = new Integer[]{1,2,3,4,5,null,7,8};
        TreeNode node = TreeNode.build(sorted);

        ListNode[] listNodes = listOfDepth(node);
        Arrays.stream(listNodes).forEach(ListNode::print);
    }
}
