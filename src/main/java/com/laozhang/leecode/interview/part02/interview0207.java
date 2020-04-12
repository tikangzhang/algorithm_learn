package com.laozhang.leecode.interview.part02;

import com.laozhang.leecode.interview.common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
 *
 * 示例 1：
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 *
 * 示例 2：
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 *
 * 示例 3：
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 */
public class interview0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            if (pa != null) {
                pa = pa.next;
            }else{
                pa = headB;
            }

            if (pb != null) {
                pb = pb.next;
            }else{
                pb = headA;
            }
        }
        if (pa ==null) {
            return null;
        }
        return pa;
    }

//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode a = headA,b = headB;
//        int aLen = 0,bLen = 0;
//        while(a != null) {
//            aLen++;
//            a = a.next;
//        }
//        while(b != null) {
//            bLen++;
//            b = b.next;
//        }
//
//        if(aLen > bLen){
//            a = headA;
//            b = headB;
//        }else{
//            a = headB;
//            b = headA;
//
//            int temp = aLen;
//            aLen = bLen;
//            bLen = temp;
//        }
//        int index = 0;
//        while(a != null){
//            if(index++ >= aLen - bLen) {
//                if(a == b){
//                    return a;
//                }
//                b = b.next;
//            }
//            a = a.next;
//        }
//        return null;
//    }

    @Test
    public void test01(){
        ListNode first,second,same;
        first = ListNode.init(new int[]{1, 3, 3, 1});
        second = ListNode.init(new int[]{1, 3});
        same = ListNode.init(new int[]{10, 3});

        first = ListNode.append(first,same);
        second = ListNode.append(second,same);

        ListNode.print(getIntersectionNode(first,second));

//        first = ListNode.init(new int[]{1, 3, 3, 1});
//        second = ListNode.init(new int[]{1, 3});
//
//        ListNode.print(getIntersectionNode(first,second));

//        head = ListNode.init(new int[]{2, 2, 2, 3, 2});
//        Assertions.assertFalse(isPalindrome(head));
//
//        head = ListNode.init(new int[]{2, 2, 2, 2, 1});
//        Assertions.assertFalse(isPalindrome(head));
//
//        head = ListNode.init(new int[]{2, 2, 2, 2, 2});
//        Assertions.assertTrue(isPalindrome(head));
    }
}
