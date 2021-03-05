package com.xuan.algorithm.datastructure;


public class MinHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MinHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MinHeap() {
        data = new Array<>();
    }

    public MinHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(data.getSize() - 1); i >= 0 ; i--) {
            siftDown(i);
        }
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.getSize() == 0;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E extracMin() {
        E ret = data.get(0);

//        E e = data.removeLast();
//        data.set(0, e);
        data.swap(0,data.getSize() - 1);
        data.removeLast();

        siftDown(0);

        return ret;
    }

    private void siftDown(int k) {

        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) < 0)
                j++;

            if (data.get(k).compareTo(data.get(j)) <= 0)
                break;

            data.swap(k, j);

            k = j;
        }
    }


}
