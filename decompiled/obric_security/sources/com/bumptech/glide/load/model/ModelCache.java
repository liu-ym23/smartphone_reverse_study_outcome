package com.bumptech.glide.load.model;

import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class ModelCache<A, B> {
    private static final int DEFAULT_SIZE = 250;
    private final LruCache<ModelKey<A>, B> cache;

    static final class ModelKey<A> {
        private static final Queue<ModelKey<?>> KEY_QUEUE = null;
        private int height;
        private A model;
        private int width;

        static {
            KEY_QUEUE = Util.createQueue(0);
        }

        static <A> ModelKey<A> get(A r2, int r3, int r4) {
            Queue<ModelKey<?>> r0 = KEY_QUEUE;
            monitor-enter(r0);
            ModelKey<A> r1 = (ModelKey) r0.poll();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            if (r1 != null) goto L8;
            r1 = new ModelKey();
        L8:
            r1.init(r2, r3, r4);
            return r1;
        L10:
            th = move-exception;
            throw th;
        }

        private ModelKey() {
        }

        private void init(A r1, int r2, int r3) {
            this.model = r1;
            this.width = r2;
            this.height = r3;
        }

        public void release() {
            Queue<ModelKey<?>> r0 = KEY_QUEUE;
            monitor-enter(r0);
            r0.offer(this);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean equals(Object r4) {
            if ((r4 instanceof ModelKey) == false) goto L12;
            ModelKey r5 = (ModelKey) r4;
            if (this.width == r5.width) goto L7;
            return false;
        L7:
            if (this.height == r5.height) goto L9;
            return false;
        L9:
            if (this.model.equals(r5.model) == false) goto L15;
            return true;
        L15:
            return false;
        L12:
            return false;
        }

        public int hashCode() {
            return (((this.height * 31) + this.width) * 31) + this.model.hashCode();
        }
    }

    public ModelCache() {
        this(250);
    }

    public ModelCache(final long r2) {
        this.cache = new AnonymousClass1(this, r2);
    }

    public B get(A r1, int r2, int r3) {
        ModelKey<A> r4 = ModelKey.get(r1, r2, r3);
        B r0 = this.cache.get(r4);
        r4.release();
        return r0;
    }

    public void put(A r1, int r2, int r3, B r4) {
        ModelKey<A> r5 = ModelKey.get(r1, r2, r3);
        this.cache.put(r5, r4);
    }

    public void clear() {
        this.cache.clearMemory();
    }
}
