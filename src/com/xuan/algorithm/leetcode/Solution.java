package com.xuan.algorithm.leetcode;

public class Solution {

    static int[] G = new int[1001];

    static {
        G[1] = 1;
        for (int i = 2; i < 1001; i++)
            dfs(i);
    }

    public int getKth(int lo, int hi, int k) {
        int[] A = new int[hi - lo + 1];
        for (int i = lo; i <= hi; i++)
            A[i - lo] = i;
        return partition(A, 0, A.length, k);
    }

    static int dfs(int a) {
        if (a > 1000) return dfs(a % 2 == 0 ? a / 2 : 3 * a + 1) + 1;
        if (G[a] != 0) return G[a];
        return G[a] = dfs(a % 2 == 0 ? a / 2 : 3 * a + 1) + 1;
    }

    int partition(int[] A, int start, int end, int mid) {
        int lo = start - 1, hi = end;
        int p = A[start];
        for (; ; ) {
            while (G[A[++lo]] < G[p] || G[A[lo]] == G[p] && A[lo] < p) ;
            while (G[A[--hi]] > G[p] || G[A[hi]] == G[p] && A[hi] > p) ;
            if (lo >= hi) break;
            int tmp = A[lo];
            A[lo] = A[hi];
            A[hi] = tmp;
        }
        if (mid < lo)
            return partition(A, start, lo, mid);
        else if (mid > hi + 1)
            return partition(A, hi + 1, end, mid);
        else {
            p = A[start];
            while (--mid > start)
                if (G[A[mid]] > G[p] || G[A[mid]] == G[p] && A[mid] > p)
                    p = A[mid];
            return p;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getKth(1,1000,777));
    }

}
