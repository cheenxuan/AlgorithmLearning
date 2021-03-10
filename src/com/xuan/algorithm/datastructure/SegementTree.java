package com.xuan.algorithm.datastructure;

public class SegementTree<E> {

    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegementTree(E[] arr, Merger<E> merger) {
        this.merger = merger;

        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        tree = (E[]) new Object[4 * arr.length];
        buildSegementTree(0, 0, data.length - 1);
    }

    private void buildSegementTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        buildSegementTree(leftTreeIndex, l, mid);
        buildSegementTree(rightTreeIndex, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("index is illegal.");
        return data[index];
    }

    public int leftChild(int index) {
        return 2 * index + 1;
    }

    public int rightChild(int index) {
        return 2 * index + 2;
    }

    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length ||
                queryR < 0 || queryR >= data.length)
            throw new IllegalArgumentException("index is illegal.");

        return query(0, 0, data.length - 1, queryL, queryR);
    }

    private E query(int treeindex, int l, int r, int queryL, int queryR) {

        if (l == queryL && r == queryR) {
            return tree[treeindex];
        }

        int mid = l + (r - l) / 2;
        int leftChildIndex = leftChild(treeindex);
        int rightChildIndex = rightChild(treeindex);

        if (queryL >= mid + 1)
            return query(rightChildIndex, mid + 1, r, queryL, queryR);
        else if (queryR <= mid)
            return query(leftChildIndex, l, mid, queryL, queryR);

        E leftResult = query(leftChildIndex, l, mid, queryL, mid);
        E rightResult = query(rightChildIndex, mid + 1, r, mid + 1, queryR);

        return merger.merge(leftResult, rightResult);
    }

    public void set(int index, E e) {
        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("index is illegal");

        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if(index >= mid + 1)
            set(rightTreeIndex, mid + 1, r, index, e);
        else
            set(leftTreeIndex, l, mid, index, e);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if (i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegementTree<Integer> segTree = new SegementTree<>(nums, (a, b) -> a + b);

        System.out.println(segTree);

        Integer query = segTree.query(0, 2);
        System.out.println(query);
        System.out.println(segTree.query(2, 5));
        System.out.println(segTree.query(0, 5));
    }


}
