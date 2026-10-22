package com.bumptech.glide.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LruCache<T, Y> {
    private final Map<T, Entry<Y>> cache;
    private long currentSize;
    private final long initialMaxSize;
    private long maxSize;

    static final class Entry<Y> {
        final int size;
        final Y value;

        Entry(Y r1, int r2) {
            this.value = r1;
            this.size = r2;
        }
    }

    protected int getSize(Y r1) {
        return 1;
    }

    protected void onItemEvicted(T r1, Y r2) {
    }

    public LruCache(long r5) {
        this.cache = new LinkedHashMap(100, 0.75f, true);
        this.initialMaxSize = r5;
        this.maxSize = r5;
    }

    public synchronized void setSizeMultiplier(float r3) {
        monitor-enter(this);
        if (r3 < 0.0f) goto L11;
        this.maxSize = Math.round(this.initialMaxSize * r3);     // Catch: Throwable -> L8
        evict();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IllegalArgumentException("Multiplier must be >= 0");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    protected synchronized int getCount() {
        monitor-enter(this);
        int r0 = this.cache.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized long getMaxSize() {
        monitor-enter(this);
        long r0 = this.maxSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized long getCurrentSize() {
        monitor-enter(this);
        long r0 = this.currentSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean contains(T r2) {
        monitor-enter(this);
        boolean r3 = this.cache.containsKey(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Y get(T r2) {
        monitor-enter(this);
        Entry<Y> r3 = this.cache.get(r2);     // Catch: Throwable -> L10
        if (r3 == null) goto L7;
        Y r4 = r3.value;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r4;
    L7:
        r4 = null;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized Y put(T r8, Y r9) {
        monitor-enter(this);
        int r0 = getSize(r9);     // Catch: Throwable -> L24
        long r1 = r0;
        Y r4 = null;
        if (r1 < this.maxSize) goto L8;
        onItemEvicted(r8, r9);     // Catch: Throwable -> L24
        monitor-exit(this);
        return null;
    L8:
        if (r9 == null) goto L10;
        this.currentSize += r1;     // Catch: Throwable -> L24
    L10:
        Map<T, Entry<Y>> r2 = this.cache;     // Catch: Throwable -> L24
        if (r9 != null) goto L13;
        Entry<Y> r3 = null;
    L14:
        Entry<Y> r5 = r2.put(r8, r3);     // Catch: Throwable -> L24
        if (r5 == null) goto L19;
        this.currentSize -= (long) r5.size;     // Catch: Throwable -> L24
        if (r5.value.equals(r9) == true) goto L19;
        onItemEvicted(r8, r5.value);     // Catch: Throwable -> L24
    L19:
        evict();     // Catch: Throwable -> L24
        if (r5 == null) goto L22;
        r4 = r5.value;     // Catch: Throwable -> L24
    L22:
        monitor-exit(this);
        return r4;
    L13:
        r3 = new Entry(r9, r0);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public synchronized Y remove(T r5) {
        monitor-enter(this);
        Entry<Y> r6 = this.cache.remove(r5);     // Catch: Throwable -> L11
        if (r6 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        this.currentSize -= (long) r6.size;     // Catch: Throwable -> L11
        Y r7 = r6.value;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r7;
    L11:
        th = move-exception;
        throw th;
    }

    public void clearMemory() {
        trimToSize(0);
    }

    protected synchronized void trimToSize(long r8) {
        monitor-enter(this);
    L12:
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.currentSize <= r8) goto L7;
        Iterator<Map.Entry<T, Entry<Y>>> r0 = this.cache.entrySet().iterator();     // Catch: Throwable -> L9
        Map.Entry<T, Entry<Y>> r1 = r0.next();     // Catch: Throwable -> L9
        Entry<Y> r2 = r1.getValue();     // Catch: Throwable -> L9
        this.currentSize -= (long) r2.size;     // Catch: Throwable -> L9
        T r3 = r1.getKey();     // Catch: Throwable -> L9
        r0.remove();     // Catch: Throwable -> L9
        onItemEvicted(r3, r2.value);     // Catch: Throwable -> L9
        goto L12
    L7:
        monitor-exit(this);
    }

    private void evict() {
        trimToSize(this.maxSize);
    }
}
