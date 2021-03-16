package com.xuan.algorithm;

import com.xuan.algorithm.datastructure.AVLTree;
import com.xuan.algorithm.datastructure.BST;
import com.xuan.algorithm.datastructure.BSTMap;
import com.xuan.algorithm.datastructure.RBTree;

import java.util.ArrayList;
import java.util.Random;

public class Main2 {

    public static void main(String[] args) {
        int n = 20000000;
        Random random = new Random();
        ArrayList<Integer> testData = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            testData.add(random.nextInt(Integer.MAX_VALUE));
        }

        long startTime = System.nanoTime();
        BSTMap<Integer, Integer> bst = new BSTMap<>();
        for (Integer x : testData) {
            bst.add(x, null);
        }
        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("BST time = " + time + " s");

        startTime = System.nanoTime();
        AVLTree<Integer, Integer> avl = new AVLTree<>();
        for (Integer x : testData) {
            avl.add(x, null);
        }
        endTime = System.nanoTime();

        double time2 = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL time = " + time2 + " s");

        startTime = System.nanoTime();
        RBTree<Integer, Integer> rbt = new RBTree<>();
        for (Integer x : testData) {
            rbt.add(x, null);
        }
        endTime = System.nanoTime();

        double time3 = (endTime - startTime) / 1000000000.0;
        System.out.println("RBT time = " + time3 + " s");
    }


}
