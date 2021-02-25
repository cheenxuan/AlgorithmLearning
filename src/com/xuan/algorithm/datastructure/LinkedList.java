package com.xuan.algorithm.datastructure;


public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的index（0 - based）位置添加新的元素e
     * 在链表中不是一个常规操作
     */
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

//        if (index == 0)
//            addFirst(e);
//        else {
//            Node prev = head;
//            for (int i = 0; i < index - 1; i++) {
//                prev = prev.next;
//            }
////            Node node = new Node(e);
////            node.next = prev.next;
////            prev.next = node;
//
//            prev.next = new Node(e, prev.next);
//        }

//        Node prev = dummyHead;
//        for (int i = 0; i < index; i++) {
//            prev = prev.next;
//        }
//        prev.next = new Node(e, prev.next);
        dummyHead.next = add(dummyHead.next,index,e);
        size++;
    }

    private Node add(Node node,int index , E e){
        if(index == 0){
            return new Node(e,node);
        }

        node.next = add(node.next,index-1,e);
        return node;
    }

    //在链表头添加新的元素e
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 后的链表中的第index个位置的元素
     */
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    //获得链表中的第一个元素
    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Remove failed. Illegal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node ret = prev.next;
        prev.next = ret.next;
        ret.next = null;
        size--;

        return ret.e;
    }

    private Node remove(Node node, int index){

        if(index == 0){
            return node.next;
        }

        node.next = remove(node.next,index -1);
        return node;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size -1);
    }

    public boolean contains(E e) {

        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
//        Node cur = dummyHead.next;
//        while(cur != null){
//            res.append(cur + "->");
//            cur = cur.next;
//        }

        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }

        res.append("NULL");
        return res.toString();
    }


    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }

}
