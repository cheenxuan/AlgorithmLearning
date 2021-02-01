package com.xuan.algorithm.leetcode;

import java.util.HashSet;

/**
 * 反转一个链表
 */
public class Solution_206 {

    public ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode cur = head;
//        ListNode next = head.next;
//
//        while (cur != null) {
//            cur.next = prev;
//
//            prev = cur;
//            cur = next;
//            next = next == null ? null : next.next;
//        }
//
//
//        return prev;

//        if(head == null || head.next == null) return head;
//        ListNode rev = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//
//        return rev;

        return reverse(null,head);
    }

    private static ListNode reverse(ListNode pre,ListNode cur){
        if(cur==null) return pre;
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(cur,next);
    }

    private int[] add(){
        int a = Integer.MAX_VALUE;
        System.out.println(a);
        return new int[]{1,2};
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        System.out.println(head);


        ListNode res = new Solution_206().reverseList(head);
        System.out.println(res);

        int a = Integer.MAX_VALUE;
        System.out.println(a);
    }
}

