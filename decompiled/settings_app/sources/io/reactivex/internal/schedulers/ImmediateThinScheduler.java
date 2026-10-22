package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class ImmediateThinScheduler extends Scheduler {
    static final Disposable DISPOSED = null;
    public static final Scheduler INSTANCE = null;
    static final Scheduler.Worker WORKER = null;

    static final class ImmediateThinWorker extends Scheduler.Worker {
        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return false;
        }

        ImmediateThinWorker() {
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable r1) {
            r1.run();
            return ImmediateThinScheduler.DISPOSED;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable r1, long r2, TimeUnit r4) {
            throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedulePeriodically(Runnable r1, long r2, long r4, TimeUnit r6) {
            throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
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
    public Disposable scheduleDirect(Runnable r1) {
        r1.run();
        return DISPOSED;
    }

    @Override // io.reactivex.Scheduler
    public Disposable scheduleDirect(Runnable r1, long r2, TimeUnit r4) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }

    @Override // io.reactivex.Scheduler
    public Disposable schedulePeriodicallyDirect(Runnable r1, long r2, long r4, TimeUnit r6) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        return WORKER;
    }
}
