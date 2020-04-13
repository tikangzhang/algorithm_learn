package com.laozhang.leecode.interview.part04;

import com.laozhang.leecode.interview.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *           0
 *          / \
 *        -3   9
 *        /   /
 *      -10  5
 */
public class interview0402 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int middle = nums.length / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,middle));
        node.right = sortedArrayToBST(Arrays.copyOfRange(nums,middle + 1,nums.length));
        return node;
    }

    @Test
    public void test(){
        int[] sorted = new int[]{-10,-3,0,5,9};
        TreeNode treeNode = sortedArrayToBST(sorted);
        TreeNode.print(treeNode);
    }
}
