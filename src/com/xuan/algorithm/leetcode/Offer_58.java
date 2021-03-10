package com.xuan.algorithm.leetcode;

public class Offer_58 {

    public String reverseLeftWords(String s, int n) {

        if(s != null && s.length() > n){
            s = s.substring(n) + s.substring(0,n);
        }
        return s;
    }

    public static void main(String[] args) {
        String a = "baskd";
        String s = new Offer_58().reverseLeftWords(a, 2);
        System.out.println(s);
    }
}
