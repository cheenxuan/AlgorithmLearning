package com.xuan.algorithm;

import com.xuan.algorithm.datastructure.*;
import com.xuan.algorithm.tools.FileOperatior;

import java.util.ArrayList;
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

    public static double testHeap(Integer[] testData,boolean isHeapify) {
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if(isHeapify)
            maxHeap = new MaxHeap<>(testData);
        else{
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
            if(arr[i - 1] < arr[i])
                throw new IllegalArgumentException("Error");
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 100000000.0;
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
//        BSTMap<String,Integer> bstSet = new BSTMap<>();
//        double tiem1 = testMap(bstSet, fileName);
//        System.out.println("BST Map: " + tiem1 + " s");
//
//        System.out.println();
//
//        LinkedListMap<String,Integer> linkedListSet = new LinkedListMap<>();
//        double time2 = testMap(linkedListSet, fileName);
//        System.out.println("LinkedList Map: " + time2 + " s");

        int n = 1000000;

//        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Integer[] testData = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
//            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }

        double time1 = testHeap(testData, false);
        System.out.println("MaxHeap without heapify time: " + time1 + " s");

        double time2 = testHeap(testData, true);
        System.out.println("MaxHeap with heapify time: " + time2 + " s");

//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = maxHeap.extracMax();
//        }
//
//        for (int i = 1; i < n; i++) {
//            if(arr[i - 1] < arr[i])
//                throw new IllegalArgumentException("Error");
//        }
//
//        System.out.println("Test MaxHeap completed.");



    }
}
