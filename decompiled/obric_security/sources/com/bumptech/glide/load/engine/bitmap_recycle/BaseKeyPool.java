package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import com.bumptech.glide.util.Util;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
abstract class BaseKeyPool<T extends Poolable> {
    private static final int MAX_SIZE = 20;
    private final Queue<T> keyPool;

    abstract T create();

    BaseKeyPool() {
        this.keyPool = Util.createQueue(20);
    }

    T get() {
        T r0 = this.keyPool.poll();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (T) create();
    }

    public void offer(T r3) {
        if (this.keyPool.size() >= 20) goto L6;
        this.keyPool.offer(r3);
        return;
    }
}
