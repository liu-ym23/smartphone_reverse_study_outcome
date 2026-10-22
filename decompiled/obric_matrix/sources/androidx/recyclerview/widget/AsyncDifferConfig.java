package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class AsyncDifferConfig<T> {

    @NonNull
    private final Executor mBackgroundThreadExecutor;

    @NonNull
    private final DiffUtil.ItemCallback<T> mDiffCallback;

    @Nullable
    private final Executor mMainThreadExecutor;

    public static final class Builder<T> {
        private static Executor sDiffExecutor;
        private static final Object sExecutorLock = null;
        private Executor mBackgroundThreadExecutor;
        private final DiffUtil.ItemCallback<T> mDiffCallback;

        @Nullable
        private Executor mMainThreadExecutor;

        static {
            sExecutorLock = new Object();
        }

        public Builder(@NonNull DiffUtil.ItemCallback<T> r1) {
            this.mDiffCallback = r1;
        }

        @NonNull
        public AsyncDifferConfig<T> build() {
            if (this.mBackgroundThreadExecutor != null) goto L15;
            Object r0 = sExecutorLock;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (sDiffExecutor != null) goto L9;
            sDiffExecutor = Executors.newFixedThreadPool(2);     // Catch: Throwable -> L11
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
            this.mBackgroundThreadExecutor = sDiffExecutor;
        L15:
            return new AsyncDifferConfig(this.mMainThreadExecutor, this.mBackgroundThreadExecutor, this.mDiffCallback);
        }

        @NonNull
        public Builder<T> setBackgroundThreadExecutor(Executor r1) {
            this.mBackgroundThreadExecutor = r1;
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder<T> setMainThreadExecutor(Executor r1) {
            this.mMainThreadExecutor = r1;
            return this;
        }
    }

    AsyncDifferConfig(@Nullable Executor r1, @NonNull Executor r2, @NonNull DiffUtil.ItemCallback<T> r3) {
        this.mMainThreadExecutor = r1;
        this.mBackgroundThreadExecutor = r2;
        this.mDiffCallback = r3;
    }

    @NonNull
    public Executor getBackgroundThreadExecutor() {
        return this.mBackgroundThreadExecutor;
    }

    @NonNull
    public DiffUtil.ItemCallback<T> getDiffCallback() {
        return this.mDiffCallback;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Executor getMainThreadExecutor() {
        return this.mMainThreadExecutor;
    }
}
