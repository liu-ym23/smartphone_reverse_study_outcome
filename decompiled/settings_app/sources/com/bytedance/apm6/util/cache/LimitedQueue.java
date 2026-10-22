package com.bytedance.apm6.util.cache;

import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes3.dex */
public class LimitedQueue<T> {
    private final int cacheSize;
    private EvictListener<T> evictListener;
    private ConcurrentLinkedQueue<T> queue;

    public interface EvictListener<T> {
        void onEvict(T r1);
    }

    public LimitedQueue(int r2) {
        this.queue = new ConcurrentLinkedQueue();
        this.cacheSize = r2;
    }

    public void setEvictListener(EvictListener<T> r1) {
        this.evictListener = r1;
    }

    public void push(T r2) {
        this.queue.add(r2);
        if (this.queue.size() <= this.cacheSize) goto L8;
        T r3 = this.queue.poll();
        EvictListener<T> r1 = this.evictListener;
        if (r1 == null) goto L9;
        r1.onEvict(r3);
        return;
    L9:
        return;
    }

    public T pop() {
        return this.queue.poll();
    }

    public T peek() {
        return this.queue.peek();
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public void clear() {
        this.queue.clear();
    }
}
