package com.xuan.algorithm.leetcode;

public class Solution_203 {

    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){val = x;}

        public ListNode(int[] arr){
            this.val = arr[0];
            ListNode cur = this;
            for (int i = 1; i < arr.length; i++) {
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
        }

        @Override
        public String toString(){
            StringBuilder res = new StringBuilder();
            ListNode cur = this;
            while (cur != null){
                res.append(cur.val + "->");
                cur = cur.next;
            }
            res.append("NULL");
            return res.toString();
        }
    }

    public ListNode removeElements(ListNode head,int val,int depth){

        //第一种方法
//        while(head != null && head.val == val){
//            ListNode delNode = head;
//            head = head.next;
//            delNode.next = null;
//        }
//
//        if(head == null){
//            return null;
//        }
//
//        ListNode prev = head;
//        while(prev.next != null){
//            if(prev.next.val == val){
//                ListNode delNode = prev.next;
//                prev.next = delNode.next;
//                delNode.next = null;
//            }else{
//                prev = prev.next;
//            }
//        }
//
//        return head;

        //第二种方法
//        ListNode dummyHead = new ListNode(-1);
//        dummyHead.next = head;
//        ListNode prev = dummyHead;
//        while(prev.next != null){
//            if(prev.next.val == val){
//                prev.next = prev.next.next;
//            }else{
//                prev = prev.next;
//            }
//        }
//        return dummyHead.next;

        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in " + head);

        
        if(head == null){
            System.out.print(depthString);
            System.out.println("Return: " + head);
            return null;
        }


        ListNode res = removeElements(head.next, val,depth + 1);
        System.out.print(depthString);
        System.out.println("After remove: " + val +" in " +head);
        ListNode ret;
        if(head.val == val){
            ret = res;
        }else{
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: " + ret);
        return ret;
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1,6,2,3,4,6,5};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution_203()).removeElements(head, 6,0);
        System.out.println(res);
    }
}
