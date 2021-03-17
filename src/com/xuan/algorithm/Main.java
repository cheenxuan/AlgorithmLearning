package com.xuan.algorithm;

import com.xuan.algorithm.datastructure.*;
import com.xuan.algorithm.tools.FileOperatior;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

    private static double testQueue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static double testStack(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static double testSet(Set<String> set, String fileName) {
        long startTime = System.nanoTime();

        System.out.println(fileName);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperatior.readFile(fileName, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words)
                set.add(word);
            System.out.println("Total different words: " + set.getSize());
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static double testMap(Map<String, Integer> map, String fileName) {
        long startTime = System.nanoTime();

        System.out.println(fileName);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperatior.readFile(fileName, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words)
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            System.out.println("Total different words: " + map.getSize());
        }

//        System.out.println(String.format("this file contains word %s show nums %d","the",map.get("the")));
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static double testHeap(Integer[] testData, boolean isMax, boolean isHeapify) {
        long startTime = System.nanoTime();
        if (isMax) {
            MaxHeap<Integer> maxHeap;
            if (isHeapify)
                maxHeap = new MaxHeap<>(testData);
            else {
                maxHeap = new MaxHeap<>();
                for (int num : testData) {
                    maxHeap.add(num);
                }
            }

            int[] arr = new int[testData.length];
            for (int i = 0; i < testData.length; i++) {
                arr[i] = maxHeap.extracMax();
            }

            for (int i = 1; i < testData.length; i++) {
                if (arr[i - 1] < arr[i])
                    throw new IllegalArgumentException("Error");
            }
        } else {
            MinHeap<Integer> minHeap;
            if (isHeapify)
                minHeap = new MinHeap<>(testData);
            else {
                minHeap = new MinHeap<>();
                for (int num : testData) {
                    minHeap.add(num);
                }
            }

            int[] arr = new int[testData.length];
            for (int i = 0; i < testData.length; i++) {
                arr[i] = minHeap.extracMin();
            }

            for (int i = 1; i < testData.length; i++) {
                if (arr[i - 1] > arr[i])
                    throw new IllegalArgumentException("Error");
            }
        }


        long endTime = System.nanoTime();
        return (endTime - startTime) / 100000000.0;
    }

    private static double testUF(UF uf,int m) {
        int size = uf.getSize();
        Random random = new Random();
        long startTime = System.nanoTime();

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);

            uf.unionElement(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);

            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
//
//        int opCount = 100000;
//        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
//        double time1 = testQueue(arrayQueue,opCount);
//        System.out.println("ArrayQueue, time: " +time1+" s");
//
//        LoopQueue<Integer> loopQueue = new LoopQueue<>();
//        double time2 = testQueue(loopQueue,opCount);
//        System.out.println("LoopQueue, time: " + time2 + " s");
//
//        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
//        double time3 = testQueue(linkedListQueue,opCount);
//        System.out.println("LinkedListQueue, time: " + time3 + "s");


//        int opCount = 1000000;
//        ArrayStack<Integer> arrayStack = new ArrayStack<>();
//        double time1 = testStack(arrayStack, opCount);
//        System.out.println("ArrayStack: time = " + time1 + "s");
//
//        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
//        double time2 = testStack(linkedListStack, opCount);
//        System.out.println("LinkedListStack: time = " + time2 + "s");

//        System.out.println("BBC - US");
//        ArrayList<String> words1 = new ArrayList<>();
//        FileOperatior.readFile("src/bbc.txt", words1);
//        System.out.println("Total words: " + words1.size());
//
//        LinkedListSet<String> set1 = new LinkedListSet<>();
//        for (String word : words1) {
//            set1.add(word);
//        }
//
//        System.out.println("Total different words: "  + set1.getSize());

//        String fileName = "Pride and Prejudice.txt";
//        BSTSet<String> bstSet = new BSTSet<>();
//        double tiem1 = testSet(bstSet, fileName);
//        System.out.println("BST Set: " + tiem1 + " s");
//
//        System.out.println();
//
//        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
//        double time2 = testSet(linkedListSet, fileName);
//        System.out.println("LinkedList Set: " + time2 + " s");
//
//        System.out.println();
//
//        AVLSet<String> avlSet = new AVLSet<>();
//        double time3 = testSet(avlSet, fileName);
//        System.out.println("AVL Set: " + time3 + " s");

//        String fileName = "Pride and Prejudice.txt";
//        BSTMap<String,Integer> bstSet = new BSTMap<>();
//        double tiem1 = testMap(bstSet, fileName);
//        System.out.println("BST Map: " + tiem1 + " s");
//
//        System.out.println();
//
//        LinkedListMap<String,Integer> linkedListSet = new LinkedListMap<>();
//        double time2 = testMap(linkedListSet, fileName);
//        System.out.println("LinkedList Map: " + time2 + " s");
//
//        System.out.println();
//
//        AVLMap<String,Integer> avlMap = new AVLMap<>();
//        double time3 = testMap(avlMap, fileName);
//        System.out.println("AVL Map: " + time3 + " s");

//        int n = 100000;

//        MaxHeap<Integer> maxHeap = new MaxHeap<>();
//        MinHeap<Integer> minHeap = new MinHeap<>();
//        Integer[] testData = new Integer[n];
//        Random random = new Random();
//        for (int i = 0; i < n; i++) {
//            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
//                minHeap.add(random.nextInt(Integer.MAX_VALUE));
//            testData[i] = random.nextInt(Integer.MAX_VALUE);
//        }
//
//        double time1 = testHeap(testData, false, false);
//        System.out.println("MinHeap without heapify time: " + time1 + " s");
//
//        double time2 = testHeap(testData, false, true);
//        System.out.println("MinHeap with heapify time: " + time2 + " s");

//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = minHeap.extracMin();
//        }
//
//        for (int i = 1; i < n; i++) {
//            if(arr[i - 1] > arr[i])
//                throw new IllegalArgumentException("Error");
//        }
//
//        System.out.println("Test MaxHeap completed.");

//        System.out.println("Pride and Prejudice");
//
//        String fileName = "Pride and Prejudice.txt";
//        ArrayList<String> words = new ArrayList<>();
//
//
//        if (FileOperatior.readFile(fileName, words)) {
//            long startTime = System.nanoTime();
//            BSTSet<String> set = new BSTSet<>();
//            for (String word : words)
//                set.add(word);
//
//            for (String word : words)
//                set.contains(word);
//
//            long endTime = System.nanoTime();
//            double time = (endTime - startTime) / 1000000000.0;
//            System.out.println("Total different words: " + set.getSize());
//            System.out.println("BSTSet : " + time +" s");
//
//            startTime = System.nanoTime();
//            Trie trie = new Trie();
//            for (String word : words)
//                trie.add2(word);
//
//            for (String word : words)
//                trie.contains(word);
//
//            endTime = System.nanoTime();
//            time = (endTime - startTime) / 1000000000.0;
//            System.out.println("Total different words: " + trie.getSize());
//            System.out.println("Trie : " + time +" s");
//        }

        //testUF
//        int size = 10000000;
//        int m = 10000000;

//        UnionFind1 uf1 = new UnionFind1(size);
//        System.out.println("UnionFind1 : " + testUF(uf1,m) + " s");
//
//        UnionFind2 uf2 = new UnionFind2(size);
//        System.out.println("UnionFind2 : " + testUF(uf2,m) + " s");

//        UnionFind3 uf3 = new UnionFind3(size);
//        System.out.println("UnionFind3 : " + testUF(uf3,m) + " s");
//
//        UnionFind4 uf4 = new UnionFind4(size);
//        System.out.println("UnionFind4 : " + testUF(uf4,m) + " s");
//
//        UnionFind5 uf5 = new UnionFind5(size);
//        System.out.println("UnionFind5 : " + testUF(uf5,m) + " s");
//
//        UnionFind6 uf6 = new UnionFind6(size);
//        System.out.println("UnionFind6 : " + testUF(uf6,m) + " s");

        String fileName = "Pride and Prejudice.txt";
        ArrayList<String> words = new ArrayList<>();
        if (FileOperatior.readFile(fileName, words)) {

            Collections.sort(words);

            long startTime = System.nanoTime();
            BSTMap<String, Integer> bst = new BSTMap<>();
            for (String word : words) {
                if (bst.contains(word))
                    bst.set(word, bst.get(word) + 1);
                else
                    bst.add(word, 1);
            }

            for (String word : words)
                bst.contains(word);

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;

            System.out.println("BST time : " + time +" s");

            startTime = System.nanoTime();
            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            for (String word : words)
                map.contains(word);

            endTime = System.nanoTime();
            time = (endTime - startTime)  / 1000000000.0;
            System.out.println("AVLTree time : " + time + " s");

            startTime = System.nanoTime();
            RBTree<String, Integer> rbTree = new RBTree<>();
            for (String word : words) {
                if (rbTree.contains(word))
                    rbTree.set(word, rbTree.get(word) + 1);
                else
                    rbTree.add(word, 1);
            }

            for (String word : words)
                rbTree.contains(word);

            endTime = System.nanoTime();
            time = (endTime - startTime)  / 1000000000.0;
            System.out.println("RBTree time : " + time + " s");


            startTime = System.nanoTime();
            HashTable<String, Integer> hashTable = new HashTable<>();
            for (String word : words) {
                if (hashTable.contains(word))
                    hashTable.set(word, hashTable.get(word) + 1);
                else
                    hashTable.add(word, 1);
            }

            for (String word : words)
                hashTable.contains(word);

            endTime = System.nanoTime();
            time = (endTime - startTime)  / 1000000000.0;
            System.out.println("HashTable time : " + time + " s");

        }
    }
}
