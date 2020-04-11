package com.laozhang.leecode.interview.common;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static ListNode init(int[] array){
        ListNode head = new ListNode(array[0]);
        ListNode cur = head;
        for (int i = 1,len = array.length; i < len; i++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
        return head;
    }
    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
