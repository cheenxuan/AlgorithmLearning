package com.xuan.algorithm.datastructure;

public interface UF {

    int getSize();
    boolean isConnected(int p, int q);
    void unionElement(int p, int q);
}
