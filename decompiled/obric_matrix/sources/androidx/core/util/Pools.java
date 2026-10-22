package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class Pools {

    public interface Pool<T> {
        @Nullable
        T acquire();

        boolean release(@NonNull T r1);
    }

    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        public SimplePool(int r1) {
            if (r1 <= 0) goto L7;
            this.mPool = new Object[r1];
            return;
        L7:
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private boolean isInPool(@NonNull T r4) {
            int r1 = 0;
        L4:
            if (r1 >= this.mPoolSize) goto L10;
            if (this.mPool[r1] == r4) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            return true;
        L10:
            return false;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            int r0 = this.mPoolSize;
            if (r0 <= 0) goto L6;
            int r2 = r0 - 1;
            Object[] r3 = this.mPool;
            T r4 = (T) r3[r2];
            r3[r2] = null;
            this.mPoolSize = r0 - 1;
            return r4;
        L6:
            return null;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T r4) {
            if (isInPool(r4) == true) goto L11;
            int r0 = this.mPoolSize;
            Object[] r1 = this.mPool;
            if (r0 >= r1.length) goto L8;
            r1[r0] = r4;
            this.mPoolSize = r0 + 1;
            return true;
        L8:
            return false;
        L11:
            throw new IllegalStateException("Already in the pool!");
        }
    }

    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object mLock;

        public SynchronizedPool(int r1) {
            super(r1);
            this.mLock = new Object();
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public T acquire() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            T r1 = (T) super.acquire();
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public boolean release(@NonNull T r2) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            boolean r1 = super.release(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private Pools() {
    }
}
