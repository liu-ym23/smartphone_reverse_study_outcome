package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable DONE = null;
    private static final int MAX_BUSY_WAIT_SPINS = 1000;
    private static final Runnable PARKED = null;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.InterruptibleTask$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static final class Blocker extends AbstractOwnableSynchronizer implements Runnable {
        private final InterruptibleTask<?> task;

        @Override // java.lang.Runnable
        public void run() {
        }

        /* synthetic */ Blocker(InterruptibleTask r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ void access$200(Blocker r0, Thread r1) {
            r0.setOwner(r1);
        }

        private Blocker(InterruptibleTask<?> r1) {
            this.task = r1;
        }

        private void setOwner(Thread r1) {
            super.setExclusiveOwnerThread(r1);
        }

        public String toString() {
            return this.task.toString();
        }
    }

    private static final class DoNothingRunnable implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        private DoNothingRunnable() {
        }

        /* synthetic */ DoNothingRunnable(AnonymousClass1 r1) {
            this();
        }
    }

    abstract void afterRanInterruptiblyFailure(Throwable r1);

    abstract void afterRanInterruptiblySuccess(@ParametricNullness T r1);

    abstract boolean isDone();

    @ParametricNullness
    abstract T runInterruptibly() throws Exception;

    abstract String toPendingString();

    InterruptibleTask() {
    }

    static {
        AnonymousClass1 r1 = null;
        DONE = new DoNothingRunnable(r1);
        PARKED = new DoNothingRunnable(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Thread r0 = Thread.currentThread();
        Object r1 = null;
        if (compareAndSet(null, r0) == true) goto L5;
        return;
    L5:
        boolean r2 = !isDone();
        if (r2 == false) goto L16;
        r1 = runInterruptibly();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (compareAndSet(r0, DONE) == true) goto L13;
        waitForInterrupt(r0);
    L13:
        if (r2 == false) goto L23;
        afterRanInterruptiblyFailure(th);
        return;
    L23:
        return;
    L16:
        if (compareAndSet(r0, DONE) == true) goto L18;
        waitForInterrupt(r0);
    L18:
        if (r2 == false) goto L25;
        afterRanInterruptiblySuccess(NullnessCasts.uncheckedCastNullableTToT(r1));
        return;
    }

    private void waitForInterrupt(Thread r8) {
        Runnable r0 = get();
        Blocker r2 = null;
        boolean r3 = false;
        int r4 = 0;
    L3:
        boolean r5 = r0 instanceof Blocker;
        if (r5 == false) goto L6;
    L11:
        if (r5 == false) goto L13;
        r2 = (Blocker) r0;
    L13:
        r4 = r4 + 1;
        if (r4 <= 1000) goto L26;
        Runnable r6 = PARKED;
        if (r0 == r6) goto L20;
        if (compareAndSet(r0, r6) == true) goto L20;
    L27:
        r0 = get();
    L20:
        if (Thread.interrupted() == true) goto L24;
        if (r3 == true) goto L24;
        r3 = false;
    L25:
        LockSupport.park(r2);
    L24:
        r3 = true;
        goto L25
    L26:
        Thread.yield();
        goto L27
    L6:
        if (r0 == PARKED) goto L11;
        if (r3 == false) goto L32;
        r8.interrupt();
        return;
    }

    final void interruptTask() {
        Runnable r0 = get();
        if ((r0 instanceof Thread) == false) goto L15;
        Blocker r1 = new Blocker(this, null);
        Blocker.access$200(r1, Thread.currentThread());
        if (compareAndSet(r0, r1) == false) goto L18;
        ((Thread) r0).interrupt();     // Catch: Throwable -> L10
        if (getAndSet(DONE) != PARKED) goto L19;
        LockSupport.unpark((Thread) r0);
        return;
    L19:
        return;
    L10:
        th = move-exception;
        if (getAndSet(DONE) != PARKED) goto L14;
        LockSupport.unpark((Thread) r0);
    L14:
        throw th;
    L18:
        return;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        Runnable r0 = get();
        if (r0 != DONE) goto L6;
        String r1 = "running=[DONE]";
    L12:
        String r3 = toPendingString();
        return new StringBuilder((String.valueOf(r1).length() + 2) + String.valueOf(r3).length()).append(r1).append(", ").append(r3).toString();
    L6:
        if ((r0 instanceof Blocker) == false) goto L9;
        r1 = "running=[INTERRUPTED]";
        goto L12
    L9:
        if ((r0 instanceof Thread) == false) goto L11;
        String r2 = ((Thread) r0).getName();
        r1 = new StringBuilder(String.valueOf(r2).length() + 21).append("running=[RUNNING ON ").append(r2).append("]").toString();
        goto L12
    L11:
        r1 = "running=[NOT STARTED YET]";
        goto L12
    }
}
