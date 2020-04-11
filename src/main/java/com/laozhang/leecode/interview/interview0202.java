package com.laozhang.leecode.interview;

import com.laozhang.leecode.interview.common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 *
 * 说明：
 *
 * 给定的 k 保证是有效的。
 */
public class interview0202 {
    public int kthToLast(ListNode head, int k) {
        if (k <= 0) return -1;
        ListNode p1;
        p1 = head;
        while(p1 != null){
            if(k-- <= 0){
                head = head.next;
            }
            p1 = p1.next;
        }
        return head.val;
    }

    @Test
    public void test01(){
        ListNode init = ListNode.init(new int[]{1, 2, 3, 3, 2, 1});
        Assertions.assertEquals(kthToLast(init,3),3);

        init = ListNode.init(new int[]{1, 2,2,2,5, 1, 1,2, 2,4});
        Assertions.assertEquals(kthToLast(init,6),5);
    }
}
