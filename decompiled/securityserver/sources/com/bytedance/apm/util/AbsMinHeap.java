package com.bytedance.apm.util;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsMinHeap<T> {
    private T[] mData;

    public AbsMinHeap(T[] r1) {
        this.mData = r1;
        buildHeap(r1.length);
    }

    private int left(int r1) {
        return ((r1 + 1) << 1) - 1;
    }

    private int right(int r1) {
        return (r1 + 1) << 1;
    }

    public void buildHeap(int r2) {
        int r0 = (r2 / 2) - 1;
    L3:
        if (r0 < 0) goto L5;
        heapify(r0, r2);
        r0 = r0 - 1;
        goto L3
    }

    public abstract boolean compare(T r1, T r2);

    public T getRoot() {
        return this.mData[0];
    }

    public void heapify(int r5, int r6) {
        int r0 = right(r5);
        int r1 = left(r5);
        if (r0 >= r6) goto L7;
        T[] r2 = this.mData;
        if (compare(r2[r0], r2[r5]) == false) goto L7;
    L8:
        if (r1 >= r6) goto L12;
        T[] r3 = this.mData;
        if (compare(r3[r1], r3[r0]) == false) goto L12;
    L13:
        if (r1 != r5) goto L15;
        return;
    L15:
        swap(r5, r1);
        heapify(r1, r6);
        return;
    L12:
        r1 = r0;
    L7:
        r0 = r5;
        goto L8
    }

    public void setRoot(T r3) {
        T[] r0 = this.mData;
        r0[0] = r3;
        heapify(0, r0.length);
    }

    public void swap(int r3, int r4) {
        T[] r2 = this.mData;
        T r0 = r2[r3];
        r2[r3] = r2[r4];
        r2[r4] = r0;
    }
}
