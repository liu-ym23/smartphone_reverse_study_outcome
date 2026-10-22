package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.core.util.Pools;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class FactoryPools {
    private static final int DEFAULT_POOL_SIZE = 20;
    private static final Resetter<Object> EMPTY_RESETTER = null;
    private static final String TAG = "FactoryPools";

    public interface Factory<T> {
        T create();
    }

    private static final class FactoryPool<T> implements Pools.Pool<T> {
        private final Factory<T> factory;
        private final Pools.Pool<T> pool;
        private final Resetter<T> resetter;

        FactoryPool(Pools.Pool<T> r1, Factory<T> r2, Resetter<T> r3) {
            this.pool = r1;
            this.factory = r2;
            this.resetter = r3;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T r0 = this.pool.acquire();
            if (r0 != null) goto L8;
            r0 = this.factory.create();
            if (Log.isLoggable(FactoryPools.TAG, 2) == false) goto L8;
            Log.v(FactoryPools.TAG, "Created new " + r0.getClass());
        L8:
            if ((r0 instanceof Poolable) == false) goto L10;
            ((Poolable) r0).getVerifier().setRecycled(false);
        L10:
            return r0;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(T r3) {
            if ((r3 instanceof Poolable) == false) goto L5;
            ((Poolable) r3).getVerifier().setRecycled(true);
        L5:
            this.resetter.reset(r3);
            return this.pool.release(r3);
        }
    }

    public interface Poolable {
        StateVerifier getVerifier();
    }

    public interface Resetter<T> {
        void reset(T r1);
    }

    static {
        EMPTY_RESETTER = new AnonymousClass1();
    }

    private FactoryPools() {
    }

    public static <T extends Poolable> Pools.Pool<T> simple(int r1, Factory<T> r2) {
        return build(new Pools.SimplePool(r1), r2);
    }

    public static <T extends Poolable> Pools.Pool<T> threadSafe(int r1, Factory<T> r2) {
        return build(new Pools.SynchronizedPool(r1), r2);
    }

    public static <T extends Poolable> Pools.Pool<T> threadSafe(int r1, Factory<T> r2, Resetter<T> r3) {
        return build(new Pools.SynchronizedPool(r1), r2, r3);
    }

    public static <T> Pools.Pool<List<T>> threadSafeList() {
        return threadSafeList(20);
    }

    public static <T> Pools.Pool<List<T>> threadSafeList(int r2) {
        return build(new Pools.SynchronizedPool(r2), new AnonymousClass2(), new AnonymousClass3());
    }

    private static <T extends Poolable> Pools.Pool<T> build(Pools.Pool<T> r1, Factory<T> r2) {
        return build(r1, r2, emptyResetter());
    }

    private static <T> Pools.Pool<T> build(Pools.Pool<T> r1, Factory<T> r2, Resetter<T> r3) {
        return new FactoryPool(r1, r2, r3);
    }

    private static <T> Resetter<T> emptyResetter() {
        return (Resetter<T>) EMPTY_RESETTER;
    }
}
