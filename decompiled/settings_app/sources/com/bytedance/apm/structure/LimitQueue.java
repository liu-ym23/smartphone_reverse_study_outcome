package com.bytedance.apm.structure;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public class LimitQueue<T> {
    private LinkedList<T> list;
    private int maxSize;

    public LimitQueue(int r2) {
        this.list = new LinkedList();
        this.maxSize = r2;
    }

    public void enqueue(T r3) {
        if (this.list.size() <= this.maxSize) goto L5;
        this.list.removeFirst();
    L5:
        this.list.addLast(r3);
    }

    public LinkedList<T> toList() {
        return this.list;
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public int size() {
        return this.list.size();
    }

    public void clear() {
        this.list.clear();
    }
}
