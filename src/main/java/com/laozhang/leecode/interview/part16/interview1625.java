package com.laozhang.leecode.interview.part16;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。
 *
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2  缓存容量  );
        *
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // 返回  1
        *cache.put(3,3);    // 该操作会使得密钥 2 作废
        *cache.get(2);       // 返回 -1 (未找到)
        *cache.put(4,4);    // 该操作会使得密钥 1 作废
        *cache.get(1);       // 返回 -1 (未找到)
        *cache.get(3);       // 返回  3
        *cache.get(4);       // 返回  4
 */
public class interview1625 {
    // *******************************
    // LinkedHashMap
//    int capacity;
//    Map<Integer, Integer> map;
//
//    public interview1625(int capacity) {
//        this.capacity = capacity;
//        map = new LinkedHashMap<>();
//    }
//
//    public int get(int key) {
//        if (!map.containsKey(key)) {
//            return -1;
//        }
//        //先删除旧的位置，再放入新位置
//        Integer value = map.remove(key);
//        map.put(key, value);
//        return value;
//    }
//
//
//    public void put(int key, int value) {
//        if (map.containsKey(key)) {
//            map.remove(key);
//            map.put(key, value);
//            return;
//        }
//        map.put(key, value);
//        //超出capacity，删除最久没用的,利用迭代器，删除第一个
//        if (map.size() > capacity) {
//            map.remove(map.entrySet().iterator().next().getKey());
//        }
//    }


    // *******************************
    // 使用双链表+HashMap
    //定义双向链表节点
//    private class ListNode {
//        int key;
//        int val;
//        ListNode pre;
//        ListNode next;
//
//        public ListNode(int key, int val) {
//            this.key = key;
//            this.val = val;
//            pre = null;
//            next = null;
//        }
//    }
//
//    private int capacity;
//    private Map<Integer, ListNode> map;     //key->node
//    private ListNode head;  //dummy head
//    private ListNode tail;  //dummy tail
//
//    public interview1625(int capacity) {
//        this.capacity = capacity;
//        map = new HashMap<>();
//        head = new ListNode(-1, -1);
//        tail = new ListNode(-1, -1);
//        head.next = tail;
//        tail.pre = head;
//    }
//
//    public int get(int key) {
//        if (!map.containsKey(key)) {
//            return -1;
//        }
//        ListNode node = map.get(key);
//        //先把这个节点删除，再接到尾部
//        node.pre.next = node.next;
//        node.next.pre = node.pre;
//        moveToTail(node);
//
//        return node.val;
//    }
//
//    public void put(int key, int value) {
//        //直接调用这边的get方法，如果存在，它会在get内部被移动到尾巴，不用再移动一遍,直接修改值即可
//        if (get(key) != -1) {
//            map.get(key).val = value;
//            return;
//        }
//        //不存在，new一个出来,如果超出容量，把头去掉
//        ListNode node = new ListNode(key, value);
//        map.put(key, node);
//        moveToTail(node);
//
//        if (map.size() > capacity) {
//            map.remove(head.next.key);
//            head.next = head.next.next;
//            head.next.pre = head;
//        }
//    }
//
//    private void moveToTail(ListNode node) {
//        node.pre = tail.pre;
//        tail.pre = node;
//        node.pre.next = node;
//        node.next = tail;
//    }

    // *******************************
    // 使用单链表
    private class ListNode {
        int key, val;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    private int capacity;
    private Map<Integer, ListNode> map;     //key-> node.pre
    private ListNode head;  //dummy
    private ListNode tail;

    public interview1625(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        //map中存放的是要找的节点的前驱
        ListNode pre = map.get(key);
        ListNode cur = pre.next;

        //把当前节点删掉并移到尾部
        if (cur != tail) {
            pre.next = cur.next;
            map.put(cur.next.key, pre); //更新它后面node的前驱
            map.put(cur.key, tail);
            moveToTail(cur);
        }
        return cur.val;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).next.val = value;
            return;
        }
        //不存在就new一个
        ListNode node = new ListNode(key, value);
        map.put(key, tail); //当前node的pre是tail
        moveToTail(node);

        if (map.size() > capacity) {
            map.remove(head.next.key);
            map.put(head.next.next.key, head);
            head.next = head.next.next;
        }
    }

    private void moveToTail(ListNode node) {
        node.next = null;
        tail.next = node;
        tail = tail.next;
    }


    @Test
    public void test(){

    }
}