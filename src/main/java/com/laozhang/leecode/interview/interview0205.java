package com.laozhang.leecode.interview;

import com.laozhang.leecode.interview.common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 *
 *
 * 示例：
 *
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 *
 * 进阶：假设这些数位是正向存放的，请再做一遍。
 *
 * 示例：
 *
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 */
public class interview0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0),head;
        head = result;

        l1 = Objects.requireNonNull(l1);
        l2 = Objects.requireNonNull(l2);

        int forward = 0,currentCalc = 0;
        int a,b;
        while(l1 != null || l2 != null){
            a = l1 == null ? 0 : l1.val;
            b = l2 == null ? 0 : l2.val;

            currentCalc = a + b + forward;
            forward = currentCalc / 10;
            currentCalc %= 10;
            result.next = new ListNode(currentCalc);
            result = result.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;;
            }
        }

        if (forward != 0){
            result.next = new ListNode(forward);
        }
        return head.next;
    }

    @Test
    public void test01(){
        ListNode first = ListNode.init(new int[]{7, 1, 6, 9});
        ListNode second = ListNode.init(new int[]{5, 9, 6});
        ListNode result = addTwoNumbers(first,second);
        ListNode.print(result);

        first = ListNode.init(new int[]{6, 1, 7});
        second = ListNode.init(new int[]{2, 9, 5, 3});
        result = addTwoNumbers(first,second);
        ListNode.print(result);

    }
}
