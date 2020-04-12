package com.laozhang.leecode.interview.part02;

import com.laozhang.leecode.interview.common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.beans.PropertyEditorSupport;
import java.util.Objects;

/**
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 *
 *
 * 示例 1：
 *
 * 输入： 1->2
 * 输出： false
 *
 * 示例 2：
 *
 * 输入： 1->2->2->1
 * 输出： true
 */
public class interview0206 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode pre = head;
        ListNode slow = pre.next;
        ListNode fast = slow.next;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (pre != null)
            pre.next = null;
        pre = null;
        while (slow != null) {
            ListNode tempNode = slow.next;
            slow.next = pre;
            pre = slow;
            slow = tempNode;
        }
        while (pre != null && head != null) {
            if (pre.val != head.val)
                return false;
            pre = pre.next;
            head = head.next;
        }
        return true;
    }
//    public boolean isPalindrome(ListNode head) {
//        if (head == null) return false;
//        ListNode slow,fast = null,revers = null;
//        slow = head.next;
//        if (slow != null) {
//            fast = slow.next;
//        }
//
//        revers = head;
//        head = head.next;
//        revers.next = null;
//        while(fast != null && fast.next != null){
//            slow = slow.next;
//            fast = fast.next.next;
//
//            ListNode temp = head;
//            head = head.next;
//            temp.next = revers;
//            revers = temp;
//        }
//        if (fast != null) {
//            slow = slow.next;
//        }
//        while (slow != null) {
//            if (slow.val != revers.val) {
//                return false;
//            }
//            slow = slow.next;
//            revers = revers.next;
//        }
//        return true;
//    }

    @Test
    public void test01(){
        ListNode head;
        head = ListNode.init(new int[]{1});
        Assertions.assertTrue(isPalindrome(head));

        head = ListNode.init(new int[]{1, 1});
        Assertions.assertTrue(isPalindrome(head));

        head = ListNode.init(new int[]{1, 2});
        Assertions.assertFalse(isPalindrome(head));

        head = ListNode.init(new int[]{1, 3, 3, 1});
        Assertions.assertTrue(isPalindrome(head));
//
        head = ListNode.init(new int[]{2, 2, 2, 3, 2});
        Assertions.assertFalse(isPalindrome(head));

        head = ListNode.init(new int[]{2, 2, 2, 2, 1});
        Assertions.assertFalse(isPalindrome(head));

        head = ListNode.init(new int[]{2, 2, 2, 2, 2});
        Assertions.assertTrue(isPalindrome(head));
    }
}
