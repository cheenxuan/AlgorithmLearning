package com.xuan.algorithm.tools;

public class HashUtil {

    public int hash(String s, int B, int M) {
        int hashCode = 0;
        for (int i = 0; i < s.length(); i++) {
            hashCode = (hashCode * B) + s.charAt(i) % M;
        }

        return hashCode;
    }
}
