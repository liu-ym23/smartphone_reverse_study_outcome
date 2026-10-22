package com.bytedance.frameworks.baselib.network.http.util;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LRUCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private Map<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LRUCache(int r4) {
        if (r4 <= 0) goto L7;
        this.maxSize = r4;
        this.map = Collections.synchronizedMap(new LinkedHashMap(0, 0.75f, true));
        return;
    L7:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int safeSizeOf(K r3, V r4) {
        int r2 = sizeOf(r3, r4);
        if (r2 < 0) goto L6;
        return r2;
    L6:
        throw new IllegalStateException("Negative size: " + r3 + "=" + r4);
    }

    private void trimToSize(int r5) {
    L3:
        if (this.size <= r5) goto L11;
        if (this.map.isEmpty() == true) goto L11;
        Map.Entry<K, V> r0 = this.map.entrySet().iterator().next();
        if (r0 == null) goto L11;
        K r1 = r0.getKey();
        V r2 = r0.getValue();
        this.map.remove(r1);
        this.size -= safeSizeOf(r1, r2);
        this.evictionCount++;
        entryEvicted(r1, r2);
    L11:
        if (this.size < 0) goto L18;
        if (this.map.isEmpty() == true) goto L15;
        return;
    L15:
        if (this.size != 0) goto L18;
        return;
    L18:
        throw new IllegalStateException(getClass().getName().concat(".sizeOf() is reporting inconsistent results!"));
    }

    public V create(K r1) {
        return null;
    }

    public final synchronized int createCount() {
        monitor-enter(this);
        int r0 = this.createCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void entryEvicted(K r1, V r2) {
    }

    public final synchronized void evictAll() {
        monitor-enter(this);
        trimToSize(-1);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized int evictionCount() {
        monitor-enter(this);
        int r0 = this.evictionCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized V get(K r4) {
        monitor-enter(this);
        if (r4 == null) goto L17;
        V r0 = this.map.get(r4);     // Catch: Throwable -> L9
        if (r0 == null) goto L11;
        this.hitCount++;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    L11:
        this.missCount++;     // Catch: Throwable -> L9
        V r1 = create(r4);     // Catch: Throwable -> L9
        if (r1 == null) goto L14;
        this.createCount++;     // Catch: Throwable -> L9
        this.size += safeSizeOf(r4, r1);     // Catch: Throwable -> L9
        this.map.put(r4, r1);     // Catch: Throwable -> L9
        trimToSize(this.maxSize);     // Catch: Throwable -> L9
    L14:
        monitor-exit(this);
        return r1;
    L17:
        throw new NullPointerException("key == null");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized int hitCount() {
        monitor-enter(this);
        int r0 = this.hitCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Map<K, V> map() {
        monitor-enter(this);
        Map<K, V> r0 = this.map;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int maxSize() {
        monitor-enter(this);
        int r0 = this.maxSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int missCount() {
        monitor-enter(this);
        int r0 = this.missCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized V put(K r3, V r4) {
        monitor-enter(this);
        if (r3 == null) goto L14;
        if (r4 == null) goto L14;
        this.putCount++;     // Catch: Throwable -> L8
        this.size += safeSizeOf(r3, r4);     // Catch: Throwable -> L8
        V r5 = this.map.put(r3, r4);     // Catch: Throwable -> L8
        if (r5 == null) goto L10;
        this.size -= safeSizeOf(r3, r5);     // Catch: Throwable -> L8
    L10:
        trimToSize(this.maxSize);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r5;
    L14:
        throw new NullPointerException("key == null || value == null");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized int putCount() {
        monitor-enter(this);
        int r0 = this.putCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized V remove(K r3) {
        monitor-enter(this);
        if (r3 == null) goto L13;
        V r0 = this.map.remove(r3);     // Catch: Throwable -> L8
        if (r0 == null) goto L10;
        this.size -= safeSizeOf(r3, r0);     // Catch: Throwable -> L8
    L10:
        monitor-exit(this);
        return r0;
    L13:
        throw new NullPointerException("key == null");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized int size() {
        monitor-enter(this);
        int r0 = this.size;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public int sizeOf(K r1, V r2) {
        return 1;
    }

    public final synchronized Map<K, V> snapshot() {
        monitor-enter(this);
        LinkedHashMap r0 = new LinkedHashMap(this.map);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized String toString() {
        monitor-enter(this);
        int r0 = this.hitCount;     // Catch: Throwable -> L6
        int r1 = this.missCount + r0;     // Catch: Throwable -> L6
        if (r1 == 0) goto L8;
        int r2 = (r0 * 100) / r1;     // Catch: Throwable -> L6
    L9:
        String r3 = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(r2)});     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L8:
        r2 = 0;
    L6:
        th = move-exception;
        throw th;
    }
}
