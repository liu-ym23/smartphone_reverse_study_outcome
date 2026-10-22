package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class TestScheduler extends Scheduler {
    long counter;
    final Queue<TimedRunnable> queue;
    volatile long time;

    public final class TestWorker extends Scheduler.Worker {
        volatile boolean disposed;
        final /* synthetic */ TestScheduler this$0;

        public final class QueueRemove implements Runnable {
            final /* synthetic */ TestWorker this$1;
            final TimedRunnable timedAction;

            public QueueRemove(TestWorker r1, TimedRunnable r2) {
                this.this$1 = r1;
                this.timedAction = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.this$1.this$0.queue.remove(this.timedAction);
            }
        }

        public TestWorker(TestScheduler r1) {
            this.this$0 = r1;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.Scheduler.Worker
        public long now(@NonNull TimeUnit r1) {
            return this.this$0.now(r1);
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable r9, long r10, @NonNull TimeUnit r12) {
            if (this.disposed == true) goto L5;
            long r0 = this.this$0.time;
            long r2 = r12.toNanos(r10) + r0;
            TestScheduler r11 = this.this$0;
            long r5 = r11.counter;
            r11.counter = 1 + r5;
            TimedRunnable r7 = new TimedRunnable(this, r2, r9, r5);
            this.this$0.queue.add(r7);
            return Disposables.fromRunnable(new QueueRemove(this, r7));
        L5:
            return EmptyDisposable.INSTANCE;
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable r9) {
            if (this.disposed == true) goto L5;
            TestScheduler r0 = this.this$0;
            long r5 = r0.counter;
            r0.counter = 1 + r5;
            TimedRunnable r7 = new TimedRunnable(this, 0, r9, r5);
            this.this$0.queue.add(r7);
            return Disposables.fromRunnable(new QueueRemove(this, r7));
        L5:
            return EmptyDisposable.INSTANCE;
        }
    }

    public static final class TimedRunnable implements Comparable<TimedRunnable> {
        final long count;
        final Runnable run;
        final TestWorker scheduler;
        final long time;

        public TimedRunnable(TestWorker r1, long r2, Runnable r4, long r5) {
            this.time = r2;
            this.run = r4;
            this.scheduler = r1;
            this.count = r5;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(TimedRunnable r1) {
            return compareTo2(r1);
        }

        public String toString() {
            return String.format("TimedRunnable(time = %d, run = %s)", new Object[]{Long.valueOf(this.time), this.run.toString()});
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(TimedRunnable r6) {
            long r0 = this.time;
            long r2 = r6.time;
            if (r0 != r2) goto L7;
            return ObjectHelper.compare(this.count, r6.count);
        L7:
            return ObjectHelper.compare(r0, r2);
        }
    }

    public TestScheduler() {
        this.queue = new PriorityBlockingQueue(11);
    }

    public void advanceTimeBy(long r3, TimeUnit r5) {
        long r0 = this.time;
        advanceTimeTo(r5.toNanos(r3) + r0, TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long r1, TimeUnit r3) {
        triggerActions(r3.toNanos(r1));
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        return new TestWorker(this);
    }

    @Override // io.reactivex.Scheduler
    public long now(@NonNull TimeUnit r3) {
        return r3.convert(this.time, TimeUnit.NANOSECONDS);
    }

    public void triggerActions() {
        triggerActions(this.time);
    }

    private void triggerActions(long r6) {
    L2:
        TimedRunnable r0 = this.queue.peek();
        if (r0 == null) goto L13;
        long r1 = r0.time;
        if (r1 > r6) goto L13;
        if (r1 != 0) goto L10;
        r1 = this.time;
    L10:
        this.time = r1;
        this.queue.remove(r0);
        if (r0.scheduler.disposed == true) goto L2;
        r0.run.run();
    L13:
        this.time = r6;
    }

    public TestScheduler(long r3, TimeUnit r5) {
        this.queue = new PriorityBlockingQueue(11);
        this.time = r5.toNanos(r3);
    }
}
