package com.xuan.algorithm.datastructure;

import java.util.ArrayList;
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

    public void levelOrder(){
        Queue<Node> queue = new LinkedListQueue<>();
        queue.enqueue(root);
        while(!queue.isEmpty()){
            Node cur = queue.dequeue();

            System.out.println(cur.e);

            if (cur.left != null)
                queue.enqueue(cur.left);
            if(cur.right != null)
                queue.enqueue(cur.right);
        }
    }

    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty.");
        return minimum(root).e;
    }

    private Node minimum(Node node) {

        if(node.left == null) return node;
        return minimum(node.left);
    }

    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty.");
        return maximum(root).e;
    }

    private Node maximum(Node node) {

        if(node.right == null) return node;
        return maximum(node.right);
    }

    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e){
        root = remove(root,e);
    }

    private Node remove(Node node, E e) {
        if(node == null)
            return null;
        if(e.compareTo(node.e)< 0){
            node.left = remove(node.left,e);
        }else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right,e);
        }else{//e == node.e
            //待删除节点左子树为空
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //待删除节点右子树为空
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //待删除节点左右子树均不为空
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置
//            Node successor = minimum(node.right);
//            successor.right = removeMin(node.right);
//            successor.left = node.left;
//
//            node.left = node.right = null;
//
//            return successor;

            Node predecessor = maximum(node.left);
            predecessor.left = removeMax(node.left);
            predecessor.right = node.right;

            node.left = node.right = null;

            return predecessor;
        }

        return node;
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
        int[] data = {5,3,6,2,4,8,7,1};
        for (int e : data) {
            bst.add(e);
        }


        System.out.println(bst);

        bst.remove(6);

        System.out.println(bst);
//
////        for (int i = 0; i < 10; i++) {
////            Random random = new Random();
////            bst.add(random.nextInt(10));
////        }
//
////        bst.inOrder();
////        System.out.println();
////        bst.postOrder();
////
////        System.out.println(bst);
//
//        bst.preOrder();
//        System.out.println();
//        bst.levelOrder();

//        Random random = new Random();
//        int n = 1000;
//        for (int i = 0; i < n; i++) {
//            bst.add(random.nextInt(10000));
//        }

        ArrayList<Integer> nums = new ArrayList<>();
//        while (!bst.isEmpty())
//            nums.add(bst.removeMin());
//
//        System.out.println(nums);
//        for (int i = 1; i < nums.size(); i++) {
//
//            if(nums.get(i - 1) > nums.get(i))
//                throw new IllegalArgumentException("Error");
//        }
//        System.out.println("RemoveMin test completed.");

//        while (!bst.isEmpty())
//            nums.add(bst.removeMax());
//
//        System.out.println(nums);
//
//        for (int i = 1; i < nums.size(); i++)
//            if(nums.get(i - 1) < nums.get(i))
//                throw new IllegalArgumentException("Error.");
//
//        System.out.println("removeMax test completed.");
    }
}
