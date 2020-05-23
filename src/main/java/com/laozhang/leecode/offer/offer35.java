package com.laozhang.leecode.offer;

import com.laozhang.leecode.interview.common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。

 示例 1：
 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]

 示例 2：
 输入：head = [[1,1],[2,1]]
 输出：[[1,1],[2,1]]

 示例 3：
 输入：head = [[3,null],[3,0],[3,null]]
 输出：[[3,null],[3,0],[3,null]]

 示例 4：
 输入：head = []
 输出：[]
 解释：给定的链表为空（空指针），因此返回 null。

 提示：
 -10000 <= Node.val <= 10000
 Node.random 为空（null）或指向链表中的节点。
 节点数目不超过 1000 。
 */
public class offer35 {
//    public Node copyRandomList(Node head) {
//        Map<Node,Node> map=new HashMap<>();
//        Node p=head;
//        while(p!=null){
//            map.put(p,new Node(p.val));
//            p=p.next;
//        }
//        p=head;
//        while(p!=null){
//            map.get(p).next=map.get(p.next);
//            map.get(p).random=map.get(p.random);
//            p=p.next;
//        }
//        return map.get(head);
//    }


    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        copy(head);
        randomDirect(head);
        return reList(head);
    }
    //拷贝链表
    private void copy(Node head){
        while(head!=null){
            Node cloneNode = new Node(head.val);
            Node nextNode = head.next;
            head.next = cloneNode;
            cloneNode.next = nextNode;
            head = cloneNode.next;
        }
    }
    //指定随机指针
    private void randomDirect(Node head){
        while(head!=null){
            Node cloneNode = head.next;
            if(head.random!=null){
                Node direct = head.random;
                cloneNode.random = direct.next;
            }
            head = cloneNode.next;
        }
    }
    //重新连接 链表
    private Node reList(Node head){
        Node cloneNode = head.next;
        Node cloneHead = cloneNode;
        head.next = cloneNode.next;
        head = head.next;
        while(head!=null){
            cloneNode.next = head.next;
            head.next = head.next.next;
            head = head.next;
            cloneNode = cloneNode.next;
        }
        return cloneHead;
    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
