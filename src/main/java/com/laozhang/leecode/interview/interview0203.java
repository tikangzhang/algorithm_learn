package com.laozhang.leecode.interview;

import com.laozhang.leecode.interview.common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 实现一种算法，删除单向链表中间的某个节点（除了第一个和最后一个节点，不一定是中间节点），假定你只能访问该节点。
 *
 *
 *
 * 示例：
 *
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 */
public class interview0203 {
    public void deleteNode(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        System.out.println("Consume:" + head.next.val);
        head.next = head.next.next;
    }

    @Test
    public void test01(){
        int[] ints = {1, 2, 3, 3, 2, 1};
        ListNode head = ListNode.init(ints);
        ListNode.print(head);

        for (int i = 0; i < ints.length; i++) {
            deleteNode(head);
            System.out.print("剩下：");
            ListNode.print(head);

        }
    }
}
