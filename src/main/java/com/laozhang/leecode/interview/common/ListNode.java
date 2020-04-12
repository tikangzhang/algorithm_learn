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
    public static ListNode append(ListNode source,int[] array){
        ListNode head = source;
        while(source != null) {
            if(source.next !=null){
                source = source.next;
            }else{
                break;
            }
        }

        for (int i = 0,len = array.length; i < len; i++) {
            source.next = new ListNode(array[i]);
            source = source.next;
        }
        return head;
    }
    public static ListNode append(ListNode source,ListNode tail){
        ListNode head = source;
        while(source != null) {
            if(source.next !=null){
                source = source.next;
            }else{
                break;
            }
        }
        source.next = tail;
        return head;
    }

    public static ListNode cycle(int[] array,int index){
        ListNode head = new ListNode(-1),cycleHead = null;
        ListNode cur = head;
        for (int i = 0,len = array.length; i < len; i++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
            if(i == index){
                cycleHead = cur;
            }
        }
        cur.next = cycleHead;
        return head.next;
    }
    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
