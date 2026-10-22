package com.bytedance.networkstackapplib;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class RingBuffer<T> {
    private final T[] mBuffer;
    private long mCapacity;
    private long mCursor;
    private T mLatestItem;

    public RingBuffer(Class<T> r3, int r4) {
        this.mCursor = 0;
        this.mCapacity = 0;
        this.mLatestItem = null;
        if (r4 >= 1) goto L5;
        r4 = 1;
    L5:
        this.mCapacity = r4;
        this.mBuffer = (T[]) ((Object[]) Array.newInstance(r3, r4));
    }

    public int size() {
        return (int) Math.min(this.mBuffer.length, this.mCursor);
    }

    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void clear() {
        int r0 = 0;
    L4:
        if (r0 >= size()) goto L6;
        this.mBuffer[r0] = null;
        r0 = r0 + 1;
        goto L4
    L6:
        this.mCursor = 0;
    }

    public void append(T r6) {
        T[] r0 = this.mBuffer;
        long r1 = this.mCursor;
        this.mCursor = 1 + r1;
        r0[indexOf(r1)] = r6;
        this.mLatestItem = r6;
    }

    public T getEarliestItem() {
        long r0 = this.mCursor;
        if (r0 != 0) goto L7;
        return null;
    L7:
        if (r0 > this.mCapacity) goto L11;
        return this.mBuffer[0];
    L11:
        return this.mBuffer[indexOf(r0)];
    }

    public T getLatestItem() {
        return this.mLatestItem;
    }

    public T getNextSlot() {
        long r0 = this.mCursor;
        this.mCursor = 1 + r0;
        int r1 = indexOf(r0);
        T[] r2 = this.mBuffer;
        if (r2[r1] != null) goto L6;
        r2[r1] = createNewItem();
    L6:
        return this.mBuffer[r1];
    }

    protected T createNewItem() {
        return (T) this.mBuffer.getClass().getComponentType().newInstance();
    L5:
        return null;
    }

    public T[] toArray() {
        T[] r0 = (T[]) Arrays.copyOf(this.mBuffer, size(), this.mBuffer.getClass());
        long r1 = this.mCursor - 1;
        int r5 = r0.length - 1;
    L3:
        if (r5 < 0) goto L5;
        r0[r5] = this.mBuffer[indexOf(r1)];
        r5 = r5 - 1;
        r1 = r1 - 1;
        goto L3
    L5:
        return r0;
    }

    private int indexOf(long r3) {
        return (int) Math.abs(r3 % ((long) this.mBuffer.length));
    }
}
