package com.laozhang.leecode.interview.part02;

import com.laozhang.leecode.interview.common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 *
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 */
public class interview0201 {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode p = new ListNode(-1),cur;
        ListNode pp = p;
        Set<Integer> set = new HashSet<>();
        while(head != null){
            if(!set.contains(head.val)){
                set.add(head.val);
                cur = head;
                head = head.next;
                cur.next = null;

                pp.next = cur;
                pp = pp.next;
                continue;
            }
            head = head.next;
        }
        return p.next;
    }
//    public ListNode removeDuplicateNodes(ListNode head) {
//        ListNode p1,p2,cur;
//        cur = p2 = new ListNode(-1);
//        while(head != null){
//            if (!find(p2,head.val)){
//                p1 = head;
//                head = head.next;
//                p1.next = null;
//
//                cur.next = p1;
//                cur = cur.next;
//                continue;
//            }
//            head = head.next;
//        }
//        return p2.next;
//    }
//
//    private boolean find(ListNode cache,int value){
//        ListNode head = cache;
//        while(head != null){
//            if(head.val == value){
//                return true;
//            }
//            head = head.next;
//        }
//        return false;
//    }

    @Test
    public void test01(){
        ListNode head = removeDuplicateNodes(ListNode.init(new int[]{1, 2, 3, 3, 2, 1}));
        ListNode.print(head);

        head = removeDuplicateNodes(ListNode.init(new int[]{1, 2,2,2,5, 1, 1,2, 2,4}));
        ListNode.print(head);
    }
}
