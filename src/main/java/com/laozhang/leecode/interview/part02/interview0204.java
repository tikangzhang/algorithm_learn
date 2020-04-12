package com.laozhang.leecode.interview.part02;

import com.laozhang.leecode.interview.common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 *
 * 示例:
 *
 * 输入: head = 3->5->8->5->10->2->1, x = 5
 * 输出: 3->1->2->10->5->5->8
 */
public class interview0204 {
    public ListNode partition(ListNode head, int x) {
        ListNode more = new ListNode(-1);
        ListNode less = new ListNode(-1);

        ListNode moreHead = more,lessHead = less;
        while(head != null){
            if(head.val < x){
                less.next = head;
                less = less.next;
            }else{
                more.next = head;
                more = more.next;
            }
            head = head.next;
        }
        less.next = moreHead.next;
        return lessHead.next;
    }



    @Test
    public void test01(){
        int[] ints = {1, 2, 3, 10, 2, 1, 5, 6};
        ListNode head = ListNode.init(ints);
        ListNode.print(head);

        ListNode partition = partition(head,5);
        ListNode.print(partition);

    }
}
