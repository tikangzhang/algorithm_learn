package com.laozhang.leecode.interview.part02;

import com.laozhang.leecode.interview.common.ListNode;
import org.junit.jupiter.api.Test;

/**
 * 给定一个有环链表，实现一个算法返回环路的开头节点。
 * 有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 */
public class interview0208 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode cur = head;
                while (cur != slow) {
                    cur = cur.next;
                    slow = slow.next;
                }
                cur.next = null;
                return cur;
            }
        }

        return null;
    }
//    public ListNode detectCycle(ListNode head) {
//        if (head == null || head.next == null) return null;
//        ListNode slow = head.next,fast = slow.next;
//        ListNode cyclePoint = null;
//        int local = 0;
//        while(slow != null && fast != null){
//            local++;
//            if (slow == fast) {
//                cyclePoint = slow;
//                break;
//            }
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        if (cyclePoint != null) {
//            if (local % 2 == 0) {
//                cyclePoint.next = null;
//                return cyclePoint;
//            }else {
//                if(cyclePoint == cyclePoint.next){
//                    cyclePoint.next = null;
//                    return cyclePoint;
//                }
//                cyclePoint.next.next = null;
//                return cyclePoint.next;
//            }
//        }else{
//            return null;
//        }
//    }

    @Test
    public void test01(){
        ListNode first;
        first = ListNode.cycle(new int[]{1, 2, 3, 4, 5},2);
        ListNode.print(detectCycle(first));

//        first = ListNode.init(new int[]{1, 2, 3, 4});
//        ListNode.print(detectCycle(first));
    }
}
