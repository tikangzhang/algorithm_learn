package com.laozhang.leecode.interview.part04;

import com.laozhang.leecode.interview.common.ListNode;
import com.laozhang.leecode.interview.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

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

        return null;
    }

    private void getList(TreeNode node){

    }

    @Test
    public void test(){
        Integer[] sorted = new Integer[]{1,2,3,4,5,null,7,8};
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(sorted));
        TreeNode node = build(queue);

        ListNode[] listNodes = listOfDepth(node);
        Arrays.stream(listNodes).forEach(ListNode::print);
    }

    private TreeNode build(LinkedList<Integer> queue){
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
