package com.xuan.algorithm.leetcode;

public class Solution_2 {

    //     Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode root = new ListNode(0);
        ListNode cuccessor = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {

            int cur1 = l1 != null ? l1.val : 0;
            int cur2 = l2 != null ? l2.val : 0;
            int sum = cur1 + cur2 + carry;
            carry = sum / 10;

            ListNode listNode = new ListNode(sum % 10);
            cuccessor.next = listNode;
            cuccessor = listNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }


        return root.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        for (int i = 0; i < 6; i++) {
            l1 = new ListNode(9, l1);
        }
        ListNode l2 = new ListNode(9);
        for (int i = 0; i < 3; i++) {
            l2 = new ListNode(9, l2);
        }

        System.out.println("-------");

        ListNode listNode = addTwoNumbers(l1, l2);

        System.out.println("-------------");
    }

}
