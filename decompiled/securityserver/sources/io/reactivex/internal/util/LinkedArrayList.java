package io.reactivex.internal.util;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class LinkedArrayList {
    final int capacityHint;
    Object[] head;
    int indexInTail;
    volatile int size;
    Object[] tail;

    public LinkedArrayList(int r1) {
        this.capacityHint = r1;
    }

    public void add(Object r5) {
        if (this.size != 0) goto L5;
        Object[] r0 = new Object[this.capacityHint + 1];
        this.head = r0;
        this.tail = r0;
        r0[0] = r5;
        this.indexInTail = 1;
        this.size = 1;
        return;
    L5:
        int r1 = this.indexInTail;
        int r3 = this.capacityHint;
        if (r1 != r3) goto L8;
        Object[] r2 = new Object[r3 + 1];
        r2[0] = r5;
        this.tail[r3] = r2;
        this.tail = r2;
        this.indexInTail = 1;
        this.size++;
        return;
    L8:
        this.tail[r1] = r5;
        this.indexInTail = r1 + 1;
        this.size++;
    }

    public Object[] head() {
        return this.head;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        int r0 = this.capacityHint;
        int r1 = this.size;
        ArrayList r2 = new ArrayList(r1 + 1);
        Object[] r7 = head();
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r1) goto L8;
        r2.add(r7[r5]);
        r4 = r4 + 1;
        r5 = r5 + 1;
        if (r5 != r0) goto L3;
        r7 = (Object[]) r7[r0];
        r5 = 0;
        goto L3
    L8:
        return r2.toString();
    }
}
