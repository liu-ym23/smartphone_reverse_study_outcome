package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class ImmediateThinScheduler extends Scheduler {
    static final Disposable DISPOSED = null;
    public static final Scheduler INSTANCE = null;
    static final Scheduler.Worker WORKER = null;

    public static final class ImmediateThinWorker extends Scheduler.Worker {
        public ImmediateThinWorker() {
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return false;
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable r1) {
            r1.run();
            return ImmediateThinScheduler.DISPOSED;
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedulePeriodically(@NonNull Runnable r1, long r2, long r4, TimeUnit r6) {
            throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable r1, long r2, @NonNull TimeUnit r4) {
            throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
        }
    }

    static {
        INSTANCE = new ImmediateThinScheduler();
        WORKER = new ImmediateThinWorker();
        Disposable r0 = Disposables.empty();
        DISPOSED = r0;
        r0.dispose();
    }

    private ImmediateThinScheduler() {
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        return WORKER;
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable r1) {
        r1.run();
        return DISPOSED;
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable r1, long r2, long r4, TimeUnit r6) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable r1, long r2, TimeUnit r4) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }
}
