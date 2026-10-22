package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ArrayQueue;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {
    public static final AtomicReferenceFieldUpdater j = null;
    public static final AtomicReferenceFieldUpdater k = null;
    private volatile Object _delayed;
    private volatile int _isCompleted;
    private volatile Object _queue;

    @Metadata
    public final class DelayedResumeTask extends DelayedTask {
        public final CancellableContinuation f;
        public final /* synthetic */ EventLoopImplBase i;

        public DelayedResumeTask(EventLoopImplBase r1, long r2, CancellableContinuationImpl r4) {
            this.i = r1;
            super(r2);
            this.f = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f.B(this.i);
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        public final String toString() {
            return super.toString() + this.f.toString();
        }
    }

    @Metadata
    public static final class DelayedRunnableTask extends DelayedTask {
        public final Runnable f;

        public DelayedRunnableTask(Runnable r1, long r2) {
            super(r2);
            this.f = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f.run();
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        public final String toString() {
            return super.toString() + this.f.toString();
        }
    }

    @Metadata
    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {
        public Object b;
        public int c;
        public long e;

        public DelayedTask(long r1) {
            this.e = r1;
            this.c = -1;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public final void a(ThreadSafeHeap r3) {
            if (this.b == EventLoop_commonKt.f373a) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.b = r3;
            return;
        L10:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L5:
            r0 = false;
            goto L6
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public final void b(int r1) {
            this.c = r1;
        }

        public final ThreadSafeHeap c() {
            Object r1 = this.b;
            if ((r1 instanceof ThreadSafeHeap) == true) goto L6;
            r1 = null;
        L6:
            return (ThreadSafeHeap) r1;
        }

        @Override // java.lang.Comparable
        public final int compareTo(DelayedTask r3) {
            long r0 = this.e - r3.e;
            if (r0 <= 0) goto L5;
            return 1;
        L5:
            if (r0 >= 0) goto L7;
            return -1;
        L7:
            return 0;
        }

        public final int d() {
            return this.c;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final synchronized void dispose() {
            monitor-enter(this);
            Object r0 = this.b;     // Catch: Throwable -> L25
            Symbol r1 = EventLoop_commonKt.f373a;     // Catch: Throwable -> L25
            if (r0 != r1) goto L8;
            monitor-exit(this);
            return;
        L8:
            if ((r0 instanceof DelayedTaskQueue) == true) goto L10;
            r0 = null;
        L10:
            DelayedTaskQueue r2 = (DelayedTaskQueue) r0;     // Catch: Throwable -> L25
            if (r2 == null) goto L22;
            monitor-enter(r2);     // Catch: Throwable -> L25
        L19:
            th = move-exception;
            throw th;     // Catch: Throwable -> L25
        L14:
            if (c() == null) goto L17;
            int r3 = d();     // Catch: Throwable -> L19
            boolean r4 = DebugKt.f370a;     // Catch: Throwable -> L19
            r2.c(r3);     // Catch: Throwable -> L19
        L17:
            monitor-exit(r2);     // Catch: Throwable -> L25
        L22:
            this.b = r1;     // Catch: Throwable -> L25
            monitor-exit(this);
            return;
        L25:
            th = move-exception;
            throw th;
        }

        public String toString() {
            return "Delayed[nanos=" + this.e + ']';
        }
    }

    @Metadata
    public static final class DelayedTaskQueue extends ThreadSafeHeap<DelayedTask> {
        public long b;
    }

    static {
        j = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_queue");
        k = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_delayed");
    }

    public EventLoopImplBase() {
        this._queue = null;
        this._delayed = null;
        this._isCompleted = 0;
    }

    public final void A(Runnable r2) {
        if (B(r2) == false) goto L7;
        Thread r1 = x();
        if (Thread.currentThread() == r1) goto L9;
        LockSupport.unpark(r1);
        return;
    L9:
        return;
    L7:
        DefaultExecutor.m.A(r2);
    }

    public final boolean B(Runnable r6) {
    L2:
        Object r0 = this._queue;
        if (this._isCompleted != 0) goto L4;
        if (r0 == null) goto L8;
        if ((r0 instanceof LockFreeTaskQueueCore) == true) goto L12;
        if (r0 == EventLoop_commonKt.b) goto L23;
        LockFreeTaskQueueCore r2 = new LockFreeTaskQueueCore(8, true);
        r2.a((Runnable) r0);
        r2.a(r6);
        if (j.compareAndSet(this, r0, r2) == false) goto L2;
        return true;
    L23:
        return false;
    L12:
        LockFreeTaskQueueCore r3 = (LockFreeTaskQueueCore) r0;
        int r4 = r3.a(r6);
        if (r4 == 0) goto L20;
        if (r4 != 1) goto L16;
        j.compareAndSet(this, r0, r3.e());
        goto L2
    L16:
        if (r4 != 2) goto L2;
        return false;
    L20:
        return true;
    L8:
        if (j.compareAndSet(this, null, r6) == false) goto L2;
        return true;
    L4:
        return false;
    }

    public final boolean E() {
        ArrayQueue r0 = this.i;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        return false;
    L11:
        DelayedTaskQueue r2 = (DelayedTaskQueue) this._delayed;
        if (r2 != null) goto L14;
    L16:
        Object r4 = this._queue;
        if (r4 != null) goto L20;
    L25:
        return true;
    L20:
        if ((r4 instanceof LockFreeTaskQueueCore) == false) goto L23;
        return ((LockFreeTaskQueueCore) r4).d();
    L23:
        if (r4 == EventLoop_commonKt.b) goto L25;
        return false;
    L14:
        if (r2.b() == true) goto L16;
        return false;
    L5:
        if (r0.b == r0.c) goto L8;
        r1 = false;
        goto L9
    }

    public final long G() {
        if (w() == false) goto L5;
        return 0;
    L5:
        DelayedTaskQueue r0 = (DelayedTaskQueue) this._delayed;
        ThreadSafeHeapNode r3 = null;
        if (r0 == null) goto L35;
        if (r0.b() == true) goto L35;
        long r5 = System.nanoTime();
    L10:
        monitor-enter(r0);
        ThreadSafeHeapNode[] r7 = r0.f430a;     // Catch: Throwable -> L19
        if (r7 == null) goto L14;
        ThreadSafeHeapNode r8 = r7[0];     // Catch: Throwable -> L19
    L15:
        if (r8 == null) goto L28;
        DelayedTask r9 = (DelayedTask) r8;     // Catch: Throwable -> L19
        if ((r5 - r9.e) < 0) goto L21;
        boolean r10 = B(r9);     // Catch: Throwable -> L19
    L22:
        if (r10 == false) goto L25;
        ThreadSafeHeapNode r11 = r0.c(0);     // Catch: Throwable -> L19
    L26:
        monitor-exit(r0);
    L31:
        if (((DelayedTask) r11) == null) goto L35;
    L25:
        r11 = null;
        goto L26
    L21:
        r10 = false;
        goto L22
    L28:
        monitor-exit(r0);
        r11 = null;
        goto L31
    L14:
        r8 = null;
    L19:
        th = move-exception;
        throw th;
    L35:
        Object r1 = this._queue;
        if (r1 == null) goto L37;
        if ((r1 instanceof LockFreeTaskQueueCore) == true) goto L40;
        if (r1 == EventLoop_commonKt.b) goto L37;
        if (j.compareAndSet(this, r1, null) == false) goto L35;
        Runnable r6 = (Runnable) r1;
    L50:
        if (r6 == null) goto L53;
        r6.run();
        return 0;
    L53:
        ArrayQueue r2 = this.i;
        if (r2 != null) goto L56;
    L62:
        long r12 = Long.MAX_VALUE;
    L64:
        if (r12 == 0) goto L113;
        Object r4 = this._queue;
        if (r4 != null) goto L70;
    L74:
        DelayedTaskQueue r13 = (DelayedTaskQueue) this._delayed;
        if (r13 == null) goto L111;
        monitor-enter(r13);
        ThreadSafeHeapNode[] r14 = r13.f430a;     // Catch: Throwable -> L87
        if (r14 == null) goto L80;
        r3 = r14[0];     // Catch: Throwable -> L87
    L80:
        monitor-exit(r13);
        DelayedTask r15 = (DelayedTask) r3;
        if (r15 == null) goto L111;
        long r16 = r15.e - System.nanoTime();
        if (r16 >= 0) goto L94;
        return 0;
    L94:
        return r16;
    L87:
        th = move-exception;
        throw th;
    L111:
        return Long.MAX_VALUE;
    L70:
        if ((r4 instanceof LockFreeTaskQueueCore) == false) goto L92;
        if (((LockFreeTaskQueueCore) r4).d() == true) goto L74;
        return 0;
    L92:
        if (r4 == EventLoop_commonKt.b) goto L111;
        return 0;
    L113:
        return 0;
    L56:
        if (r2.b != r2.c) goto L58;
        boolean r17 = true;
    L59:
        if (r17 == true) goto L62;
        r12 = 0;
        goto L64
    L58:
        r17 = false;
        goto L59
    L40:
        LockFreeTaskQueueCore r18 = (LockFreeTaskQueueCore) r1;
        Object r19 = r18.f();
        if (r19 != LockFreeTaskQueueCore.g) goto L42;
        j.compareAndSet(this, r1, r18.e());
        goto L35
    L42:
        r6 = (Runnable) r19;
    L37:
        r6 = null;
        goto L50
    }

    public final void I() {
        this._queue = null;
        this._delayed = null;
    }

    public final void J(long r13, DelayedTask r15) {
        ThreadSafeHeapNode r2 = null;
        if (this._isCompleted == 0) goto L5;
    L4:
        char r0 = 1;
    L44:
        if (r0 == 0) goto L51;
        if (r0 == 1) goto L50;
        if (r0 != 2) goto L49;
        return;
    L49:
        throw new IllegalStateException("unexpected result".toString());
    L50:
        EventLoopImplPlatform.z(r13, r15);
        return;
    L51:
        DelayedTaskQueue r14 = (DelayedTaskQueue) this._delayed;
        if (r14 == null) goto L62;
        monitor-enter(r14);
        ThreadSafeHeapNode[] r16 = r14.f430a;     // Catch: Throwable -> L59
        if (r16 == null) goto L57;
        r2 = r16[0];     // Catch: Throwable -> L59
    L57:
        monitor-exit(r14);
        r2 = (DelayedTask) r2;
    L59:
        th = move-exception;
        throw th;
    L62:
        if (r2 != r15) goto L77;
        Thread r12 = x();
        if (Thread.currentThread() == r12) goto L78;
        LockSupport.unpark(r12);
        return;
    L78:
        return;
    L77:
        return;
    L5:
        DelayedTaskQueue r1 = (DelayedTaskQueue) this._delayed;
        if (r1 != null) goto L9;
        AtomicReferenceFieldUpdater r3 = k;
        DelayedTaskQueue r5 = new DelayedTaskQueue();
        r5.b = r13;
        r3.compareAndSet(this, null, r5);
        Object r4 = this._delayed;
        Intrinsics.c(r4);
        r1 = (DelayedTaskQueue) r4;
    L9:
        monitor-enter(r15);
    L24:
        th = move-exception;
        throw th;
    L11:
        if (r15.b != EventLoop_commonKt.f373a) goto L14;
        monitor-exit(r15);
        r0 = 2;
        goto L44
    L14:
        monitor-enter(r1);     // Catch: Throwable -> L24
        ThreadSafeHeapNode[] r6 = r1.f430a;     // Catch: Throwable -> L29
        if (r6 == null) goto L18;
        ThreadSafeHeapNode r7 = r6[0];     // Catch: Throwable -> L29
    L19:
        DelayedTask r8 = (DelayedTask) r7;     // Catch: Throwable -> L29
        if (this._isCompleted == 0) goto L27;
        monitor-exit(r1);     // Catch: Throwable -> L24
        monitor-exit(r15);
        goto L4
    L27:
        if (r8 != null) goto L31;
        r1.b = r13;     // Catch: Throwable -> L29
    L37:
        long r9 = r15.e;     // Catch: Throwable -> L29
        long r10 = r1.b;     // Catch: Throwable -> L29
        if ((r9 - r10) >= 0) goto L40;
        r15.e = r10;     // Catch: Throwable -> L29
    L40:
        r1.a(r15);     // Catch: Throwable -> L29
        monitor-exit(r1);     // Catch: Throwable -> L24
        monitor-exit(r15);
        r0 = 0;
        goto L44
    L31:
        long r11 = r8.e;     // Catch: Throwable -> L29
        if ((r11 - r13) < 0) goto L35;
        r11 = r13;
    L35:
        if ((r11 - r1.b) <= 0) goto L37;
        r1.b = r11;     // Catch: Throwable -> L29
        goto L37
    L18:
        r7 = null;
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    }

    @Override // kotlinx.coroutines.Delay
    public final void e(long r4, CancellableContinuationImpl r6) {
        long r5 = EventLoop_commonKt.a(r4);
        if (r5 >= 4611686018427387903L) goto L6;
        long r0 = System.nanoTime();
        DelayedResumeTask r2 = new DelayedResumeTask(this, r5 + r0, r6);
        r6.u(new DisposeOnCancel(r2));
        J(r0, r2);
        return;
    }

    public DisposableHandle h(long r1, Runnable r3, CoroutineContext r4) {
        return DefaultExecutorKt.f371a.h(r1, r3, r4);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void j(CoroutineContext r1, Runnable r2) {
        A(r2);
    }

    @Override // kotlinx.coroutines.EventLoop
    public final void shutdown() {
        ThreadLocalEventLoop.f379a.set(null);
        this._isCompleted = 1;
        boolean r2 = DebugKt.f370a;
    L3:
        Object r3 = this._queue;
        Symbol r4 = EventLoop_commonKt.b;
        if (r3 == null) goto L6;
        if ((r3 instanceof LockFreeTaskQueueCore) == true) goto L10;
        if (r3 == r4) goto L16;
        LockFreeTaskQueueCore r5 = new LockFreeTaskQueueCore(8, true);
        r5.a((Runnable) r3);
        if (j.compareAndSet(this, r3, r5) == false) goto L3;
    L16:
        if (G() <= 0) goto L16;
        long r0 = System.nanoTime();
    L19:
        DelayedTaskQueue r6 = (DelayedTaskQueue) this._delayed;
        if (r6 == null) goto L24;
        DelayedTask r7 = (DelayedTask) r6.d();
        if (r7 == null) goto L39;
        EventLoopImplPlatform.z(r0, r7);
        goto L19
    L39:
        return;
    L24:
        return;
    L10:
        ((LockFreeTaskQueueCore) r3).b();
        goto L16
    L6:
        if (j.compareAndSet(this, null, r4) == false) goto L3;
        goto L16
    }
}
