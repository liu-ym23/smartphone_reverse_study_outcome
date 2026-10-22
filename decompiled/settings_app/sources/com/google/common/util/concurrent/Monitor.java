package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BooleanSupplier;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Monitor {

    @CheckForNull
    private Guard activeGuards;
    private final boolean fair;
    private final ReentrantLock lock;

    public static abstract class Guard {
        final Condition condition;
        final Monitor monitor;

        @CheckForNull
        Guard next;
        int waiterCount;

        public abstract boolean isSatisfied();

        protected Guard(Monitor r2) {
            this.waiterCount = 0;
            this.monitor = (Monitor) Preconditions.checkNotNull(r2, "monitor");
            this.condition = Monitor.access$000(r2).newCondition();
        }
    }

    static /* synthetic */ ReentrantLock access$000(Monitor r0) {
        return r0.lock;
    }

    public Monitor() {
        this(false);
    }

    public Monitor(boolean r2) {
        this.activeGuards = null;
        this.fair = r2;
        this.lock = new ReentrantLock(r2);
    }

    public Guard newGuard(final BooleanSupplier r2) {
        Preconditions.checkNotNull(r2, "isSatisfied");
        return new AnonymousClass1(this, this, r2);
    }

    public void enter() {
        this.lock.lock();
    }

    public boolean enter(Duration r3) {
        return enter(Internal.toNanosSaturated(r3), TimeUnit.NANOSECONDS);
    }

    public boolean enter(long r7, TimeUnit r9) {
        long r8 = toSafeNanos(r7, r9);
        ReentrantLock r10 = this.lock;
        boolean r0 = true;
        if (this.fair == false) goto L5;
    L7:
        boolean r6 = Thread.interrupted();
        long r1 = System.nanoTime();     // Catch: Throwable -> L18
        long r3 = r8;
    L25:
        boolean r11 = r10.tryLock(r3, TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L14 Throwable -> L18
    L11:
        if (r6 == false) goto L13;
        Thread.currentThread().interrupt();
    L13:
        return r11;
    L14:
        r3 = remainingNanos(r1, r8);     // Catch: Throwable -> L16
        r6 = true;
    L16:
        th = th;
    L20:
        if (r0 == false) goto L22;
        Thread.currentThread().interrupt();
    L22:
        throw th;
    L18:
        th = th;
        r0 = r6;
        goto L20
    L5:
        if (r10.tryLock() == false) goto L7;
        return true;
    }

    public void enterInterruptibly() throws InterruptedException {
        this.lock.lockInterruptibly();
    }

    public boolean enterInterruptibly(Duration r3) throws InterruptedException {
        return enterInterruptibly(Internal.toNanosSaturated(r3), TimeUnit.NANOSECONDS);
    }

    public boolean enterInterruptibly(long r1, TimeUnit r3) throws InterruptedException {
        return this.lock.tryLock(r1, r3);
    }

    public boolean tryEnter() {
        return this.lock.tryLock();
    }

    public void enterWhen(Guard r3) throws InterruptedException {
        if (r3.monitor != this) goto L13;
        ReentrantLock r0 = this.lock;
        boolean r1 = r0.isHeldByCurrentThread();
        r0.lockInterruptibly();
    L9:
        th = move-exception;
        leave();
        throw th;
    L6:
        if (r3.isSatisfied() == true) goto L16;
        await(r3, r1);     // Catch: Throwable -> L9
        return;
    L16:
        return;
    L13:
        throw new IllegalMonitorStateException();
    }

    public boolean enterWhen(Guard r3, Duration r4) throws InterruptedException {
        return enterWhen(r3, Internal.toNanosSaturated(r4), TimeUnit.NANOSECONDS);
    }

    public boolean enterWhen(Guard r11, long r12, TimeUnit r14) throws InterruptedException {
        long r0 = toSafeNanos(r12, r14);
        if (r11.monitor != this) goto L38;
        ReentrantLock r2 = this.lock;
        boolean r3 = r2.isHeldByCurrentThread();
        boolean r5 = false;
        if (this.fair == false) goto L7;
    L13:
        long r8 = initNanoTime(r0);
        if (r2.tryLock(r12, r14) == true) goto L39;
        return false;
    L39:
    L28:
        th = move-exception;
        if (r3 == false) goto L41;
    L35:
        r2.unlock();
        throw th;
    L41:
        signalNextWaiter();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        r2.unlock();
        throw th;
    L17:
        if (r11.isSatisfied() == false) goto L19;
    L24:
        r5 = true;
    L25:
        if (r5 == true) goto L27;
        r2.unlock();
    L27:
        return r5;
    L19:
        if (r8 == 0) goto L22;
        r0 = remainingNanos(r8, r0);     // Catch: Throwable -> L28
    L22:
        if (awaitNanos(r11, r0, r3) == false) goto L25;
    L7:
        if (Thread.interrupted() == true) goto L12;
        if (r2.tryLock() == false) goto L13;
        r8 = 0;
        goto L39
    L12:
        throw new InterruptedException();
    L38:
        throw new IllegalMonitorStateException();
    }

    public void enterWhenUninterruptibly(Guard r3) {
        if (r3.monitor != this) goto L13;
        ReentrantLock r0 = this.lock;
        boolean r1 = r0.isHeldByCurrentThread();
        r0.lock();
    L9:
        th = move-exception;
        leave();
        throw th;
    L6:
        if (r3.isSatisfied() == true) goto L16;
        awaitUninterruptibly(r3, r1);     // Catch: Throwable -> L9
        return;
    L16:
        return;
    L13:
        throw new IllegalMonitorStateException();
    }

    public boolean enterWhenUninterruptibly(Guard r3, Duration r4) {
        return enterWhenUninterruptibly(r3, Internal.toNanosSaturated(r4), TimeUnit.NANOSECONDS);
    }

    public boolean enterWhenUninterruptibly(Guard r12, long r13, TimeUnit r15) {
        long r14 = toSafeNanos(r13, r15);
        if (r12.monitor != this) goto L44;
        ReentrantLock r16 = this.lock;
        boolean r0 = r16.isHeldByCurrentThread();
        boolean r1 = Thread.interrupted();
        boolean r6 = true;
        if (this.fair == false) goto L8;
    L11:
        long r7 = initNanoTime(r14);     // Catch: Throwable -> L39
        long r9 = r14;
    L46:
        if (r16.tryLock(r9, TimeUnit.NANOSECONDS) == true) goto L48;
        if (r1 == false) goto L34;
        Thread.currentThread().interrupt();
    L34:
        return false;
    L48:
    L31:
        r0 = false;
        r1 = r6;
    L28:
        th = move-exception;
        r16.unlock();     // Catch: Throwable -> L39
        throw th;     // Catch: Throwable -> L39
    L16:
        if (r12.isSatisfied() == true) goto L23;
        if (r7 != 0) goto L21;
        r7 = initNanoTime(r14);     // Catch: Throwable -> L28 InterruptedException -> L31
        long r10 = r14;
    L22:
        r6 = awaitNanos(r12, r10, r0);     // Catch: Throwable -> L28 InterruptedException -> L31
    L21:
        r10 = remainingNanos(r7, r14);     // Catch: Throwable -> L28 InterruptedException -> L31
    L23:
        if (r6 == true) goto L25;
        r16.unlock();     // Catch: Throwable -> L39
    L25:
        if (r1 == false) goto L27;
        Thread.currentThread().interrupt();
    L27:
        return r6;
    L35:
        r9 = remainingNanos(r7, r14);     // Catch: Throwable -> L37
        r1 = true;
    L37:
        th = th;
        r1 = true;
    L40:
        if (r1 == false) goto L42;
        Thread.currentThread().interrupt();
    L42:
        throw th;
    L8:
        if (r16.tryLock() == false) goto L11;
        r7 = 0;
    L39:
        th = th;
        goto L40
    L44:
        throw new IllegalMonitorStateException();
    }

    public boolean enterIf(Guard r2) {
        if (r2.monitor != this) goto L13;
        ReentrantLock r1 = this.lock;
        r1.lock();
        boolean r3 = r2.isSatisfied();     // Catch: Throwable -> L9
        if (r3 == true) goto L8;
        r1.unlock();
    L8:
        return r3;
    L9:
        th = move-exception;
        r1.unlock();
        throw th;
    L13:
        throw new IllegalMonitorStateException();
    }

    public boolean enterIf(Guard r3, Duration r4) {
        return enterIf(r3, Internal.toNanosSaturated(r4), TimeUnit.NANOSECONDS);
    }

    public boolean enterIf(Guard r2, long r3, TimeUnit r5) {
        if (r2.monitor != this) goto L16;
        if (enter(r3, r5) == true) goto L17;
        return false;
    L17:
        boolean r4 = r2.isSatisfied();     // Catch: Throwable -> L12
        if (r4 == true) goto L11;
        this.lock.unlock();
    L11:
        return r4;
    L12:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L16:
        throw new IllegalMonitorStateException();
    }

    public boolean enterIfInterruptibly(Guard r2) throws InterruptedException {
        if (r2.monitor != this) goto L13;
        ReentrantLock r1 = this.lock;
        r1.lockInterruptibly();
        boolean r3 = r2.isSatisfied();     // Catch: Throwable -> L9
        if (r3 == true) goto L8;
        r1.unlock();
    L8:
        return r3;
    L9:
        th = move-exception;
        r1.unlock();
        throw th;
    L13:
        throw new IllegalMonitorStateException();
    }

    public boolean enterIfInterruptibly(Guard r3, Duration r4) throws InterruptedException {
        return enterIfInterruptibly(r3, Internal.toNanosSaturated(r4), TimeUnit.NANOSECONDS);
    }

    public boolean enterIfInterruptibly(Guard r2, long r3, TimeUnit r5) throws InterruptedException {
        if (r2.monitor != this) goto L16;
        ReentrantLock r1 = this.lock;
        if (r1.tryLock(r3, r5) == true) goto L17;
        return false;
    L17:
        boolean r4 = r2.isSatisfied();     // Catch: Throwable -> L12
        if (r4 == true) goto L11;
        r1.unlock();
    L11:
        return r4;
    L12:
        th = move-exception;
        r1.unlock();
        throw th;
    L16:
        throw new IllegalMonitorStateException();
    }

    public boolean tryEnterIf(Guard r2) {
        if (r2.monitor != this) goto L16;
        ReentrantLock r1 = this.lock;
        if (r1.tryLock() == true) goto L17;
        return false;
    L17:
        boolean r3 = r2.isSatisfied();     // Catch: Throwable -> L12
        if (r3 == true) goto L11;
        r1.unlock();
    L11:
        return r3;
    L12:
        th = move-exception;
        r1.unlock();
        throw th;
    L16:
        throw new IllegalMonitorStateException();
    }

    public void waitFor(Guard r4) throws InterruptedException {
        if (r4.monitor != this) goto L5;
        boolean r0 = true;
    L7:
        if ((r0 & this.lock.isHeldByCurrentThread()) == false) goto L13;
        if (r4.isSatisfied() == true) goto L14;
        await(r4, true);
        return;
    L14:
        return;
    L13:
        throw new IllegalMonitorStateException();
    L5:
        r0 = false;
        goto L7
    }

    public boolean waitFor(Guard r3, Duration r4) throws InterruptedException {
        return waitFor(r3, Internal.toNanosSaturated(r4), TimeUnit.NANOSECONDS);
    }

    public boolean waitFor(Guard r3, long r4, TimeUnit r6) throws InterruptedException {
        long r5 = toSafeNanos(r4, r6);
        if (r3.monitor != this) goto L5;
        boolean r7 = true;
    L7:
        if ((r7 & this.lock.isHeldByCurrentThread()) == false) goto L18;
        if (r3.isSatisfied() == false) goto L12;
        return true;
    L12:
        if (Thread.interrupted() == true) goto L16;
        return awaitNanos(r3, r5, true);
    L16:
        throw new InterruptedException();
    L18:
        throw new IllegalMonitorStateException();
    L5:
        r7 = false;
        goto L7
    }

    public void waitForUninterruptibly(Guard r4) {
        if (r4.monitor != this) goto L5;
        boolean r0 = true;
    L7:
        if ((r0 & this.lock.isHeldByCurrentThread()) == false) goto L13;
        if (r4.isSatisfied() == true) goto L14;
        awaitUninterruptibly(r4, true);
        return;
    L14:
        return;
    L13:
        throw new IllegalMonitorStateException();
    L5:
        r0 = false;
        goto L7
    }

    public boolean waitForUninterruptibly(Guard r3, Duration r4) {
        return waitForUninterruptibly(r3, Internal.toNanosSaturated(r4), TimeUnit.NANOSECONDS);
    }

    public boolean waitForUninterruptibly(Guard r8, long r9, TimeUnit r11) {
        long r10 = toSafeNanos(r9, r11);
        boolean r1 = true;
        if (r8.monitor != this) goto L5;
        boolean r12 = true;
    L7:
        if ((r12 & this.lock.isHeldByCurrentThread()) == false) goto L29;
        if (r8.isSatisfied() == false) goto L11;
        return true;
    L11:
        long r2 = initNanoTime(r10);
        boolean r13 = Thread.interrupted();
        long r4 = r10;
        boolean r6 = true;
    L30:
        boolean r7 = this.awaitNanos(r8, r4, r6);     // Catch: Throwable -> L16 InterruptedException -> L18
        goto L19
    L13:
        if (r13 == false) goto L15;
        Thread.currentThread().interrupt();
    L15:
        return r7;
    L16:
        th = th;
        r1 = r13;
    L25:
        if (r1 == false) goto L27;
        Thread.currentThread().interrupt();
    L27:
        throw th;
    L24:
        th = th;
    L19:
        if (r8.isSatisfied() == true) goto L20;
        r4 = remainingNanos(r2, r10);     // Catch: Throwable -> L24
        r6 = false;
        r13 = true;
        goto L30
    L20:
        Thread.currentThread().interrupt();
        return true;
    L29:
        throw new IllegalMonitorStateException();
    L5:
        r12 = false;
        goto L7
    }

    public void leave() {
        ReentrantLock r0 = this.lock;
    L8:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if (r0.getHoldCount() != 1) goto L6;
        signalNextWaiter();     // Catch: Throwable -> L8
    L6:
        r0.unlock();
    }

    public boolean isFair() {
        return this.fair;
    }

    public boolean isOccupied() {
        return this.lock.isLocked();
    }

    public boolean isOccupiedByCurrentThread() {
        return this.lock.isHeldByCurrentThread();
    }

    public int getOccupiedDepth() {
        return this.lock.getHoldCount();
    }

    public int getQueueLength() {
        return this.lock.getQueueLength();
    }

    public boolean hasQueuedThreads() {
        return this.lock.hasQueuedThreads();
    }

    public boolean hasQueuedThread(Thread r1) {
        return this.lock.hasQueuedThread(r1);
    }

    public boolean hasWaiters(Guard r1) {
        if (getWaitQueueLength(r1) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getWaitQueueLength(Guard r2) {
        if (r2.monitor != this) goto L12;
        this.lock.lock();
        int r3 = r2.waiterCount;     // Catch: Throwable -> L8
        this.lock.unlock();
        return r3;
    L8:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L12:
        throw new IllegalMonitorStateException();
    }

    private static long toSafeNanos(long r6, TimeUnit r8) {
        return Longs.constrainToRange(r8.toNanos(r6), 0, 6917529027641081853L);
    }

    private static long initNanoTime(long r2) {
        if (r2 > 0) goto L5;
        return 0;
    L5:
        long r3 = System.nanoTime();
        if (r3 != 0) goto L9;
        return 1;
    L9:
        return r3;
    }

    private static long remainingNanos(long r3, long r5) {
        if (r5 > 0) goto L6;
        return 0;
    L6:
        return r5 - (System.nanoTime() - r3);
    }

    private void signalNextWaiter() {
        Guard r0 = this.activeGuards;
    L3:
        if (r0 == null) goto L11;
        if (isSatisfied(r0) == true) goto L6;
        r0 = r0.next;
        goto L3
    L6:
        r0.condition.signal();
        return;
    }

    private boolean isSatisfied(Guard r1) {
        return r1.isSatisfied();
    L4:
        th = move-exception;
        signalAllWaiters();
        throw th;
    }

    private void signalAllWaiters() {
        Guard r1 = this.activeGuards;
    L3:
        if (r1 == null) goto L5;
        r1.condition.signalAll();
        r1 = r1.next;
        goto L3
    }

    private void beginWaitingFor(Guard r3) {
        int r0 = r3.waiterCount;
        r3.waiterCount = r0 + 1;
        if (r0 != 0) goto L6;
        r3.next = this.activeGuards;
        this.activeGuards = r3;
        return;
    }

    private void endWaitingFor(Guard r5) {
        int r0 = r5.waiterCount - 1;
        r5.waiterCount = r0;
        if (r0 != 0) goto L11;
        Guard r1 = this.activeGuards;
        Guard r2 = null;
    L5:
        if (r1 == r5) goto L6;
        r2 = r1;
        r1 = r1.next;
        goto L5
    L6:
        if (r2 != null) goto L8;
        this.activeGuards = r1.next;
    L9:
        r1.next = null;
        return;
    L8:
        r2.next = r1.next;
        goto L9
    }

    private void await(Guard r1, boolean r2) throws InterruptedException {
        if (r2 == false) goto L4;
        signalNextWaiter();
    L4:
        beginWaitingFor(r1);
    L12:
        r1.condition.await();     // Catch: Throwable -> L9
        if (r1.isSatisfied() == false) goto L12;
        endWaitingFor(r1);
        return;
    L9:
        th = move-exception;
        endWaitingFor(r1);
        throw th;
    }

    private void awaitUninterruptibly(Guard r1, boolean r2) {
        if (r2 == false) goto L4;
        signalNextWaiter();
    L4:
        beginWaitingFor(r1);
    L12:
        r1.condition.awaitUninterruptibly();     // Catch: Throwable -> L9
        if (r1.isSatisfied() == false) goto L12;
        endWaitingFor(r1);
        return;
    L9:
        th = move-exception;
        endWaitingFor(r1);
        throw th;
    }

    private boolean awaitNanos(Guard r5, long r6, boolean r8) throws InterruptedException {
        boolean r1 = true;
    L4:
        if (r6 <= 0) goto L5;
        if (r1 == false) goto L12;
        if (r8 == true) goto L21;
    L11:
        beginWaitingFor(r5);     // Catch: Throwable -> L17
        r1 = false;
        goto L12
    L21:
        signalNextWaiter();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        if (r1 == true) goto L20;
        endWaitingFor(r5);
    L20:
        throw th;
    L12:
        r6 = r5.condition.awaitNanos(r6);     // Catch: Throwable -> L17
        if (r5.isSatisfied() == false) goto L4;
        if (r1 == true) goto L16;
        endWaitingFor(r5);
    L16:
        return true;
    L5:
        if (r1 == true) goto L7;
        endWaitingFor(r5);
    L7:
        return false;
    }
}
