package com.laozhang.leecode.offer;

import com.laozhang.leecode.interview.common.ListNode;

/**
 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

 示例:

 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL

 限制：

 0 <= 节点个数 <= 5000

 */
public class offer24 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ret = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }
//    public ListNode reverseList(ListNode head) {
//        ListNode cur = null, pre = head;
//        while (pre != null) {
//            ListNode t = pre.next;
//            pre.next = cur;
//            cur = pre;
//            pre = t;
//        }
//        return cur;
//    }
}
