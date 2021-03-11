package com.xuan.algorithm.datastructure;

import java.util.TreeMap;

public class Trie {

    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public void add2(String word) {
        add2(root, word, 0);
    }

    private void add2(Node node, String word, int index) {

        if (index >= word.length()) {
            if (!node.isWord) {
                node.isWord = true;
                size++;
            }
            return;
        }
        char c = word.charAt(index);

        if (node.next.get(c) == null)
            node.next.put(c, new Node());

        add2(node.next.get(c), word, index + 1);
    }

    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }

        return cur.isWord;
    }

    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }

    public static void main(String[] args) {

        String a = "cat";
        String e = "cat";
        String b = "can";
        String c = "panda";
        String d = "pan";

        Trie trie = new Trie();
        trie.add2(a);
        trie.add2(b);
        trie.add2(c);
        trie.add2(d);
        trie.add2(e);

        System.out.println(trie.getSize());
    }
}
