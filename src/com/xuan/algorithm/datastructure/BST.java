package com.xuan.algorithm.datastructure;

import sun.tools.jconsole.JConsole;

import java.util.Random;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root,e);
    }

    /**
     * 向以node为根的二分搜索树种插入元素E，递归算法
     * 返回插入节点二分搜索树的根
     * @param node node节点
     * @param e    元素e
     */
    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0)
            node.left =  add(node.left, e);
        else if(e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    public void add2(E e){

        if (root == null) {
            root = new Node(e);
            size++;
            return;
        }

        Node t = root;
        while(t != null){
            if(e.compareTo(t.e) > 0){
                if (t.right == null) {
                    t.right = new Node(e);
                    size++;
                    return;
                }else
                    t = t.right;
            }else if(e.compareTo(t.e) < 0){
                if (t.left == null) {
                    t.left = new Node(e);
                    size++;
                    return;
                }else
                    t = t.left;
            }else
                return;
        }
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node,E e) {
        if(node == null)
            return false;
        if(e.compareTo(node.e) == 0)
            return true;
        else if(e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }

    //二分搜索树的钱旭遍历
    public void  preOrder() {
        preOrder(root);
    }

    //钱旭遍历以node为根的二分搜索树，递归算法
    private void preOrder(Node node) {
        if(node == null)
            return;

        System.out.println(node.e);

        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrder2(){

        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();

            System.out.println(cur.e);
            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node == null)
            return;

        inOrder(node.left);
        inOrder(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        int[] data = {7,2,5,6,3,8,1,9,4};
        for (int e : data) {
            bst.add(e);
        }

//        for (int i = 0; i < 10; i++) {
//            Random random = new Random();
//            bst.add(random.nextInt(10));
//        }

//        bst.inOrder();
//        System.out.println();
//        bst.postOrder();
//
        System.out.println(bst);


        bst.preOrder2();
    }
}
