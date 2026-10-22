package kotlinx.coroutines.scheduling;

import a.a;
import android.support.v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CoroutineScheduler implements Executor, Closeable {
    public static final AtomicLongFieldUpdater l = null;
    public static final AtomicLongFieldUpdater m = null;
    public static final AtomicIntegerFieldUpdater n = null;
    public static final Symbol o = null;
    private volatile int _isTerminated;
    public final GlobalQueue b;
    public final GlobalQueue c;
    volatile long controlState;
    public final AtomicReferenceArray e;
    public final int f;
    public final int i;
    public final long j;
    public final String k;
    private volatile long parkedWorkersStack;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[WorkerState.values().length];
            r0[2] = 1;
            r0[1] = 2;
            r0[0] = 3;
            r0[3] = 4;
            r0[4] = 5;
        }
    }

    @Metadata
    public final class Worker extends Thread {
        public static final AtomicIntegerFieldUpdater l = null;
        public final WorkQueue b;
        public WorkerState c;
        public long e;
        public long f;
        public int i;
        private volatile int indexInArray;
        public boolean j;
        public final /* synthetic */ CoroutineScheduler k;

        @Nullable
        private volatile Object nextParkedWorker;

        @NotNull
        volatile int workerCtl;

        static {
            l = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl");
        }

        public Worker(CoroutineScheduler r1, int r2) {
            this.k = r1;
            setDaemon(true);
            this.b = new WorkQueue();
            this.c = WorkerState.f;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.o;
            Random.b.getClass();
            this.i = Random.c.b();
            f(r2);
        }

        public final Task a(boolean r11) {
            WorkerState r0 = this.c;
            WorkerState r1 = WorkerState.b;
            boolean r3 = true;
            if (r0 == r1) goto L25;
            CoroutineScheduler r2 = this.k;
        L6:
            long r6 = r2.controlState;
            if (((int) ((9223367638808264704L & r6) >> 42)) == 0) goto L8;
            if (CoroutineScheduler.m.compareAndSet(r2, r6, r6 - 4398046511104L) == false) goto L6;
            this.c = r1;
            goto L25
        L8:
            if (r11 == false) goto L16;
            WorkQueue r12 = this.b;
            r12.getClass();
            Task r4 = (Task) WorkQueue.b.getAndSet(r12, null);
            if (r4 != null) goto L13;
            r4 = r12.c();
        L13:
            if (r4 != null) goto L17;
            r4 = (Task) this.k.c.d();
        L17:
            if (r4 == null) goto L20;
            return r4;
        L20:
            return i(true);
        L16:
            r4 = (Task) this.k.c.d();
        L25:
            if (r11 == true) goto L27;
            Task r13 = e();
            if (r13 == null) goto L48;
            return r13;
        L48:
            return i(false);
        L27:
            if (d(this.k.f * 2) == 0) goto L30;
            r3 = false;
        L30:
            if (r3 == false) goto L34;
            Task r14 = e();
            if (r14 == null) goto L34;
            return r14;
        L34:
            WorkQueue r15 = this.b;
            r15.getClass();
            Task r5 = (Task) WorkQueue.b.getAndSet(r15, null);
            if (r5 == null) goto L37;
            Task r16 = r5;
        L38:
            if (r16 != null) goto L54;
            if (r3 == true) goto L48;
            Task r17 = e();
            if (r17 == null) goto L48;
            return r17;
        L54:
            return r16;
        L37:
            r16 = r15.c();
            goto L38
        }

        public final int b() {
            return this.indexInArray;
        }

        public final Object c() {
            return this.nextParkedWorker;
        }

        public final int d(int r3) {
            int r0 = this.i;
            int r1 = r0 ^ (r0 << 13);
            int r2 = r1 ^ (r1 >> 17);
            int r4 = r2 ^ (r2 << 5);
            this.i = r4;
            int r5 = r3 - 1;
            if ((r5 & r3) != 0) goto L7;
            return r5 & r4;
        L7:
            return (Integer.MAX_VALUE & r4) % r3;
        }

        public final Task e() {
            int r0 = d(2);
            CoroutineScheduler r1 = this.k;
            if (r0 != 0) goto L9;
            Task r2 = (Task) r1.b.d();
            if (r2 == null) goto L8;
            return r2;
        L8:
            return (Task) r1.c.d();
        L9:
            Task r3 = (Task) r1.c.d();
            if (r3 == null) goto L13;
            return r3;
        L13:
            return (Task) r1.b.d();
        }

        public final void f(int r3) {
            StringBuilder r0 = new StringBuilder();
            r0.append(this.k.k);
            r0.append("-worker-");
            if (r3 != 0) goto L5;
            String r1 = "TERMINATED";
        L6:
            r0.append(r1);
            setName(r0.toString());
            this.indexInArray = r3;
            return;
        L5:
            r1 = String.valueOf(r3);
            goto L6
        }

        public final void g(Object r1) {
            this.nextParkedWorker = r1;
        }

        public final boolean h(WorkerState r7) {
            WorkerState r0 = this.c;
            if (r0 != WorkerState.b) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L8;
            CoroutineScheduler.m.addAndGet(this.k, 4398046511104L);
        L8:
            if (r0 == r7) goto L10;
            this.c = r7;
        L10:
            return r1;
        L5:
            r1 = false;
            goto L6
        }

        public final Task i(boolean r21) {
            boolean r2 = DebugKt.f370a;
            CoroutineScheduler r3 = this.k;
            int r4 = (int) (r3.controlState & 2097151);
            if (r4 >= 2) goto L5;
            return null;
        L5:
            int r5 = d(r4);
            int r9 = 0;
            long r10 = Long.MAX_VALUE;
        L7:
            if (r9 >= r4) goto L36;
            r5 = r5 + 1;
            if (r5 <= r4) goto L11;
            r5 = 1;
        L11:
            Worker r14 = (Worker) r3.e.get(r5);
            if (r14 == null) goto L34;
            if (r14 == this) goto L34;
            boolean r15 = DebugKt.f370a;
            WorkQueue r16 = this.b;
            WorkQueue r17 = r14.b;
            if (r21 == false) goto L17;
            long r7 = r16.d(r17);
        L25:
            if (r7 == (-1)) goto L26;
            if (r7 <= 0) goto L34;
            r10 = Math.min(r10, r7);
            goto L34
        L26:
            r16.getClass();
            Task r0 = (Task) WorkQueue.b.getAndSet(r16, null);
            if (r0 == null) goto L30;
            return r0;
        L30:
            return r16.c();
        L17:
            r16.getClass();
            Task r8 = r17.c();
            if (r8 == null) goto L23;
            Task r11 = (Task) WorkQueue.b.getAndSet(r16, r8);
            if (r11 == null) goto L22;
            r16.a(r11);
        L22:
            r7 = -1;
            goto L25
        L23:
            r7 = r16.e(r17, false);
        L34:
            r9 = r9 + 1;
            goto L7
        L36:
            if (r10 != Long.MAX_VALUE) goto L39;
            r10 = 0;
        L39:
            this.f = r10;
            return null;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
        L3:
            boolean r1 = false;
        L5:
            if (this.k.isTerminated() == true) goto L82;
            WorkerState r2 = this.c;
            WorkerState r3 = WorkerState.i;
            if (r2 == r3) goto L82;
            Task r4 = a(this.j);
            if (r4 != null) goto L10;
            this.j = false;
            if (this.f != 0) goto L37;
            if (this.nextParkedWorker != CoroutineScheduler.o) goto L42;
            this.k.d(this);
            goto L5
        L42:
            boolean r5 = DebugKt.f370a;
            this.workerCtl = -1;
        L44:
            if (this.nextParkedWorker == CoroutineScheduler.o) goto L5;
            if (this.workerCtl != (-1)) goto L5;
            if (this.k.isTerminated() == true) goto L5;
            WorkerState r6 = this.c;
            WorkerState r7 = WorkerState.i;
            if (r6 == r7) goto L5;
            h(WorkerState.e);
            Thread.interrupted();
            if (this.e != 0) goto L55;
            this.e = System.nanoTime() + this.k.j;
        L55:
            LockSupport.parkNanos(this.k.j);
            if ((System.nanoTime() - this.e) < 0) goto L44;
            this.e = 0;
            AtomicReferenceArray r8 = this.k.e;
            monitor-enter(r8);
            if (this.k.isTerminated() == true) goto L61;
            if (((int) (this.k.controlState & 2097151)) <= this.k.f) goto L65;
            if (l.compareAndSet(this, -1, 1) == false) goto L69;
            int r9 = this.indexInArray;     // Catch: Throwable -> L74
            f(0);     // Catch: Throwable -> L74
            this.k.e(this, r9, 0);     // Catch: Throwable -> L74
            int r10 = (int) (CoroutineScheduler.m.getAndDecrement(this.k) & 2097151);     // Catch: Throwable -> L74
            if (r10 == r9) goto L76;
            Object r11 = this.k.e.get(r10);     // Catch: Throwable -> L74
            Intrinsics.c(r11);     // Catch: Throwable -> L74
            Worker r12 = (Worker) r11;     // Catch: Throwable -> L74
            this.k.e.set(r9, r12);     // Catch: Throwable -> L74
            r12.f(r9);     // Catch: Throwable -> L74
            this.k.e(r12, r10, r9);     // Catch: Throwable -> L74
        L76:
            this.k.e.set(r10, null);     // Catch: Throwable -> L74
            monitor-exit(r8);
            this.c = r7;
            goto L44
        L69:
            monitor-exit(r8);
            goto L44
        L65:
            monitor-exit(r8);
            goto L44
        L61:
            monitor-exit(r8);
        L74:
            th = move-exception;
            throw th;
        L37:
            if (r1 == true) goto L39;
            r1 = true;
            goto L5
        L39:
            h(WorkerState.e);
            Thread.interrupted();
            LockSupport.parkNanos(this.f);
            this.f = 0;
            goto L3
        L10:
            this.f = 0;
            int r13 = r4.c.g();
            this.e = 0;
            WorkerState r14 = this.c;
            WorkerState r15 = WorkerState.e;
            WorkerState r16 = WorkerState.c;
            if (r14 != r15) goto L13;
            boolean r17 = DebugKt.f370a;
            this.c = r16;
        L13:
            CoroutineScheduler r18 = this.k;
            if (r13 != 0) goto L17;
        L25:
            r18.getClass();
            r4.run();     // Catch: Throwable -> L28
        L30:
            if (r13 == 0) goto L3;
            CoroutineScheduler.m.addAndGet(r18, -2097152);
            if (this.c == r3) goto L3;
            boolean r19 = DebugKt.f370a;
            this.c = WorkerState.f;
        L28:
            th = move-exception;
            Thread r20 = Thread.currentThread();
            r20.getUncaughtExceptionHandler().uncaughtException(r20, th);
            goto L30
        L17:
            if (h(r16) == false) goto L25;
            if (r18.g() == true) goto L25;
            if (r18.f(r18.controlState) == true) goto L25;
            r18.g();
        L82:
            h(WorkerState.i);
        }
    }

    @Metadata
    public static final enum WorkerState extends Enum<WorkerState> {
        public static final WorkerState b = null;
        public static final WorkerState c = null;
        public static final WorkerState e = null;
        public static final WorkerState f = null;
        public static final WorkerState i = null;
        public static final /* synthetic */ WorkerState[] j = null;

        static {
            WorkerState r0 = new WorkerState("CPU_ACQUIRED", 0);
            b = r0;
            WorkerState r1 = new WorkerState("BLOCKING", 1);
            c = r1;
            WorkerState r2 = new WorkerState("PARKING", 2);
            e = r2;
            WorkerState r3 = new WorkerState("DORMANT", 3);
            f = r3;
            WorkerState r4 = new WorkerState("TERMINATED", 4);
            i = r4;
            j = new WorkerState[]{r0, r1, r2, r3, r4};
        }

        public static WorkerState valueOf(String r1) {
            return (WorkerState) Enum.valueOf(WorkerState.class, r1);
        }

        public static WorkerState[] values() {
            return (WorkerState[]) j.clone();
        }
    }

    static {
        o = new Symbol("NOT_IN_STACK");
        l = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
        m = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
        n = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");
    }

    public CoroutineScheduler(long r5, String r7, int r8, int r9) {
        this.f = r8;
        this.i = r9;
        this.j = r5;
        this.k = r7;
        if (r8 < 1) goto L23;
        if (r9 < r8) goto L7;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L21;
        if (r9 > 2097150) goto L19;
        if (r5 <= 0) goto L17;
        this.b = new GlobalQueue();
        this.c = new GlobalQueue();
        this.parkedWorkersStack = 0;
        this.e = new AtomicReferenceArray(r9 + 1);
        this.controlState = ((long) r8) << 42;
        this._isTerminated = 0;
        return;
    L17:
        throw new IllegalArgumentException(("Idle worker keep alive time " + r5 + " must be positive").toString());
    L19:
        throw new IllegalArgumentException(a.f(r9, "Max pool size ", " should not exceed maximal supported number of threads 2097150").toString());
    L21:
        throw new IllegalArgumentException(("Max pool size " + r9 + " should be greater than or equals to core pool size " + r8).toString());
    L7:
        r1 = false;
        goto L9
    L23:
        throw new IllegalArgumentException(a.f(r8, "Core pool size ", " should be at least 1").toString());
    }

    public static /* synthetic */ void c(CoroutineScheduler r1, Runnable r2, boolean r3, int r4) {
        NonBlockingContext r0 = NonBlockingContext.b;
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r1.b(r2, r0, r3);
    }

    public final int a() {
        AtomicReferenceArray r0 = this.e;
        monitor-enter(r0);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (this._isTerminated == 0) goto L9;
        monitor-exit(r0);
        return -1;
    L9:
        long r1 = this.controlState;     // Catch: Throwable -> L25
        int r5 = (int) (r1 & 2097151);     // Catch: Throwable -> L25
        int r2 = r5 - ((int) ((r1 & 4398044413952L) >> 21));     // Catch: Throwable -> L25
        boolean r3 = false;
        if (r2 >= 0) goto L13;
        r2 = 0;
    L13:
        if (r2 < this.f) goto L17;
        monitor-exit(r0);
        return 0;
    L17:
        if (r5 < this.i) goto L20;
        monitor-exit(r0);
        return 0;
    L20:
        int r6 = ((int) (this.controlState & 2097151)) + 1;     // Catch: Throwable -> L25
        if (r6 > 0) goto L23;
    L27:
        boolean r7 = false;
    L28:
        if (r7 == false) goto L40;
        Worker r8 = new Worker(this, r6);     // Catch: Throwable -> L25
        this.e.set(r6, r8);     // Catch: Throwable -> L25
        if (r6 != ((int) (2097151 & m.incrementAndGet(this)))) goto L32;
        r3 = true;
    L32:
        if (r3 == false) goto L38;
        r8.start();     // Catch: Throwable -> L25
        int r4 = r2 + 1;
        monitor-exit(r0);
        return r4;
    L38:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L25
    L40:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L25
    L23:
        if (this.e.get(r6) != null) goto L27;
        r7 = true;
        goto L28
    }

    public final void b(Runnable r5, TaskContext r6, boolean r7) {
        TasksKt.e.getClass();
        long r0 = System.nanoTime();
        if ((r5 instanceof Task) == false) goto L5;
        Task r8 = (Task) r5;
        r8.b = r0;
        r8.c = r6;
    L6:
        Thread r9 = Thread.currentThread();
        Task r1 = null;
        if ((r9 instanceof Worker) == true) goto L9;
        r9 = null;
    L9:
        Worker r10 = (Worker) r9;
        if (r10 != null) goto L12;
    L14:
        r10 = null;
    L15:
        boolean r2 = true;
        if (r10 != null) goto L19;
    L17:
        r1 = r8;
    L32:
        if (r1 != null) goto L34;
    L41:
        if (r7 == false) goto L44;
        if (r10 == null) goto L44;
    L46:
        if (r8.c.g() != 0) goto L56;
        if (r2 == false) goto L50;
        return;
    L50:
        if (g() == false) goto L53;
        return;
    L53:
        if (f(this.controlState) == true) goto L69;
        g();
        return;
    L69:
        return;
    L56:
        long r11 = m.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        if (r2 == false) goto L60;
        return;
    L60:
        if (g() == false) goto L63;
        return;
    L63:
        if (f(r11) == true) goto L72;
        g();
        return;
    L72:
        return;
    L44:
        r2 = false;
        goto L46
    L34:
        if (r1.c.g() != 1) goto L36;
        boolean r3 = this.c.a(r1);
    L37:
        if (r3 == true) goto L41;
        throw new RejectedExecutionException(a.o(new StringBuilder(), this.k, " was terminated"));
    L36:
        r3 = this.b.a(r1);
        goto L37
    L19:
        if (r10.c == WorkerState.i) goto L17;
        if (r8.c.g() == 0) goto L24;
    L26:
        r10.j = true;
        WorkQueue r4 = r10.b;
        if (r7 == false) goto L29;
        r1 = r4.a(r8);
        goto L32
    L29:
        r4.getClass();
        Task r12 = (Task) WorkQueue.b.getAndSet(r4, r8);
        if (r12 == null) goto L32;
        r1 = r4.a(r12);
        goto L32
    L24:
        if (r10.c != WorkerState.c) goto L26;
    L12:
        if (Intrinsics.a(r10.k, this) == false) goto L14;
    L5:
        r8 = new TaskImpl(r5, r0, r6);
        goto L6
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (n.compareAndSet(this, 0, 1) == false) goto L67;
        Thread r1 = Thread.currentThread();
        if ((r1 instanceof Worker) == true) goto L8;
        r1 = null;
    L8:
        Worker r2 = (Worker) r1;
        if (r2 != null) goto L11;
    L13:
        r2 = null;
    L14:
        AtomicReferenceArray r3 = this.e;
        monitor-enter(r3);
        int r4 = (int) (this.controlState & 2097151);
        monitor-exit(r3);
        if (1 > r4) goto L34;
        int r5 = 1;
    L21:
        Object r6 = this.e.get(r5);
        Intrinsics.c(r6);
        Worker r7 = (Worker) r6;
        if (r7 != r2) goto L24;
    L32:
        if (r5 == r4) goto L34;
        r5 = r5 + 1;
    L24:
        if (r7.isAlive() == false) goto L26;
        LockSupport.unpark(r7);
        r7.join(10000);
        goto L24
    L26:
        boolean r8 = DebugKt.f370a;
        WorkQueue r9 = r7.b;
        GlobalQueue r10 = this.c;
        r9.getClass();
        Task r11 = (Task) WorkQueue.b.getAndSet(r9, null);
        if (r11 == null) goto L29;
        r10.a(r11);
    L29:
        Task r12 = r9.c();
        if (r12 == null) goto L32;
        r10.a(r12);
    L34:
        this.c.b();
        this.b.b();
    L35:
        if (r2 == null) goto L39;
        Task r13 = r2.a(true);
        if (r13 == null) goto L39;
    L40:
        if (r13 != null) goto L43;
        r13 = (Task) this.c.d();
    L43:
        if (r13 == null) goto L48;
        r13.run();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        Thread r14 = Thread.currentThread();
        r14.getUncaughtExceptionHandler().uncaughtException(r14, th);
        goto L35
    L48:
        if (r2 == null) goto L50;
        r2.h(WorkerState.i);
    L50:
        boolean r0 = DebugKt.f370a;
        this.parkedWorkersStack = 0;
        this.controlState = 0;
        return;
    L39:
        r13 = (Task) this.b.d();
    L52:
        th = move-exception;
        throw th;
    L11:
        if (Intrinsics.a(r2.k, this) == false) goto L13;
    }

    public final void d(Worker r9) {
        if (r9.c() == o) goto L5;
        return;
    L5:
        long r4 = this.parkedWorkersStack;
        long r1 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + r4) & (-2097152);
        int r3 = r9.b();
        boolean r6 = DebugKt.f370a;
        AtomicReferenceArray r7 = this.e;
        r9.g(r7.get((int) (2097151 & r4)));
        if (l.compareAndSet(this, r4, ((long) r3) | r1) == false) goto L5;
    }

    public final void e(Worker r9, int r10, int r11) {
    L2:
        long r2 = this.parkedWorkersStack;
        int r0 = (int) (2097151 & r2);
        long r4 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + r2) & (-2097152);
        if (r0 != r10) goto L16;
        if (r11 != 0) goto L15;
        Object r1 = r9.c();
    L7:
        if (r1 == o) goto L8;
        if (r1 == null) goto L10;
        Worker r3 = (Worker) r1;
        int r5 = r3.b();
        if (r5 != 0) goto L13;
        r1 = r3.c();
        goto L7
    L13:
        r0 = r5;
        goto L16
    L10:
        r0 = 0;
        goto L16
    L8:
        r0 = -1;
        goto L16
    L15:
        r0 = r11;
    L16:
        if (r0 < 0) goto L2;
        if (l.compareAndSet(this, r2, r4 | ((long) r0)) == false) goto L2;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r3) {
        c(this, r3, false, 6);
    }

    public final boolean f(long r4) {
        int r0 = ((int) (2097151 & r4)) - ((int) ((r4 & 4398044413952L) >> 21));
        if (r0 >= 0) goto L5;
        r0 = 0;
    L5:
        int r5 = this.f;
        if (r0 >= r5) goto L13;
        int r1 = a();
        if (r1 != 1) goto L11;
        if (r5 <= 1) goto L11;
        a();
    L11:
        if (r1 <= 0) goto L13;
        return true;
    L13:
        return false;
    }

    public final boolean g() {
    L2:
        long r2 = this.parkedWorkersStack;
        Worker r6 = (Worker) this.e.get((int) (2097151 & r2));
        if (r6 == null) goto L18;
        long r0 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + r2) & (-2097152);
        Object r4 = r6.c();
    L5:
        Symbol r9 = o;
        if (r4 == r9) goto L7;
        if (r4 == null) goto L9;
        Worker r5 = (Worker) r4;
        int r7 = r5.b();
        if (r7 != 0) goto L12;
        r4 = r5.c();
    L12:
        if (r7 < 0) goto L2;
        if (l.compareAndSet(this, r2, ((long) r7) | r0) == false) goto L2;
        r6.g(r9);
    L19:
        if (r6 == null) goto L24;
        if (Worker.l.compareAndSet(r6, -1, 0) == false) goto L2;
        LockSupport.unpark(r6);
        return true;
    L24:
        return false;
    L9:
        r7 = 0;
        goto L12
    L7:
        r7 = -1;
        goto L12
    L18:
        r6 = null;
        goto L19
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final String toString() {
        ArrayList r0 = new ArrayList();
        int r1 = this.e.length();
        int r2 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
        int r8 = 1;
    L3:
        if (r8 >= r1) goto L24;
        Worker r9 = (Worker) this.e.get(r8);
        if (r9 == null) goto L23;
        int r10 = r9.b.b();
        int r11 = r9.c.ordinal();
        if (r11 == 0) goto L22;
        if (r11 != 1) goto L10;
        r4 = r4 + 1;
        r0.add(String.valueOf(r10) + "b");
        goto L23
    L10:
        if (r11 != 2) goto L12;
        r5 = r5 + 1;
        goto L23
    L12:
        if (r11 != 3) goto L14;
        r6 = r6 + 1;
        if (r10 <= 0) goto L23;
        r0.add(String.valueOf(r10) + "d");
        goto L23
    L14:
        if (r11 != 4) goto L23;
        r7 = r7 + 1;
        goto L23
    L22:
        r2 = r2 + 1;
        r0.add(String.valueOf(r10) + "c");
    L23:
        r8 = r8 + 1;
        goto L3
    L24:
        long r12 = this.controlState;
        return this.k + '@' + DebugStringsKt.a(this) + "[Pool Size {core = " + this.f + ", max = " + this.i + "}, Worker States {CPU = " + r2 + ", blocking = " + r4 + ", parked = " + r5 + ", dormant = " + r6 + ", terminated = " + r7 + "}, running workers queues = " + r0 + ", global CPU queue size = " + this.b.c() + ", global blocking queue size = " + this.c.c() + ", Control State {created workers= " + ((int) (2097151 & r12)) + ", blocking tasks = " + ((int) ((4398044413952L & r12) >> 21)) + ", CPUs acquired = " + (this.f - ((int) ((9223367638808264704L & r12) >> 42))) + "}]";
    }
}
