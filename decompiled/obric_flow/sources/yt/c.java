package yt;

import ai.j0;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.q;
import kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Executor, Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f23330h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f23331i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f23332j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final g8.g f23333k = null;
    private volatile /* synthetic */ int _isTerminated$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f23336c;
    private volatile /* synthetic */ long controlState$volatile;
    public final String d;
    public final f e;
    public final f f;
    public final q g;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    static {
        f23330h = AtomicLongFieldUpdater.newUpdater(c.class, "parkedWorkersStack$volatile");
        f23331i = AtomicLongFieldUpdater.newUpdater(c.class, "controlState$volatile");
        f23332j = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isTerminated$volatile");
        f23333k = new g8.g("NOT_IN_STACK", 10);
    }

    public c(long r5, String r10, int r11, int r12) {
        this.f23334a = r11;
        this.f23335b = r12;
        this.f23336c = r5;
        this.d = r10;
        if (r11 < 1) goto L19;
        if (r12 < r11) goto L17;
        if (r12 > 2097150) goto L15;
        if (r5 <= 0) goto L13;
        this.e = new f();
        this.f = new f();
        this.g = new q((r11 + 1) * 2);
        this.controlState$volatile = ((long) r11) << 42;
        this._isTerminated$volatile = 0;
        return;
    L13:
        throw new IllegalArgumentException(("Idle worker keep alive time " + r5 + " must be positive").toString());
    L15:
        throw new IllegalArgumentException(j0.h(r12, "Max pool size ", " should not exceed maximal supported number of threads 2097150").toString());
    L17:
        throw new IllegalArgumentException(j0.f(r12, r11, "Max pool size ", " should be greater than or equals to core pool size ").toString());
    L19:
        throw new IllegalArgumentException(j0.h(r11, "Core pool size ", " should be at least 1").toString());
    }

    public static /* synthetic */ void e(c r5, Runnable r10, boolean r11, int r12) {
        if ((r12 & 4) == 0) goto L5;
        r11 = false;
    L5:
        r5.d(r10, false, r11);
    }

    public final int b() {
        q r5 = this.g;
        monitor-enter(r5);
    L34:
        th = move-exception;
        throw th;
    L6:
        if (f23332j.get(this) == 0) goto L8;
        boolean r10 = true;
    L9:
        if (r10 == false) goto L13;
        monitor-exit(r5);
        return -1;
    L13:
        AtomicLongFieldUpdater r11 = f23331i;     // Catch: Throwable -> L34
        long r12 = r11.get(this);     // Catch: Throwable -> L34
        int r13 = (int) (r12 & 2097151);     // Catch: Throwable -> L34
        int r14 = RangesKt.coerceAtLeast(r13 - ((int) ((r12 & 4398044413952L) >> 21)), 0);     // Catch: Throwable -> L34
        if (r14 < this.f23334a) goto L18;
        monitor-exit(r5);
        return 0;
    L18:
        if (r13 < this.f23335b) goto L21;
        monitor-exit(r5);
        return 0;
    L21:
        int r15 = ((int) (r11.get(this) & 2097151)) + 1;     // Catch: Throwable -> L34
        if (r15 <= 0) goto L37;
        if (this.g.b(r15) != null) goto L37;
        b r16 = new b(this, r15);     // Catch: Throwable -> L34
        this.g.c(r15, r16);     // Catch: Throwable -> L34
        if (r15 != ((int) (2097151 & r11.incrementAndGet(this)))) goto L33;
        int r17 = r14 + 1;
        monitor-exit(r5);
        r16.start();
        return r17;
    L33:
        throw new IllegalArgumentException("Failed requirement.");     // Catch: Throwable -> L34
    L37:
        throw new IllegalArgumentException("Failed requirement.");     // Catch: Throwable -> L34
    L8:
        r10 = false;
        goto L9
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (f23332j.compareAndSet(this, 0, 1) == false) goto L66;
        Thread r5 = Thread.currentThread();
        if ((r5 instanceof b) == false) goto L8;
        b r10 = (b) r5;
    L9:
        if (r10 != null) goto L11;
    L13:
        r10 = null;
    L14:
        q r11 = this.g;
        monitor-enter(r11);
        int r12 = (int) (f23331i.get(this) & 2097151);
        monitor-exit(r11);
        if (1 > r12) goto L35;
        int r13 = 1;
    L21:
        Object r14 = this.g.b(r13);
        Intrinsics.checkNotNull(r14);
        b r15 = (b) r14;
        if (r15 != r10) goto L24;
    L33:
        if (r13 == r12) goto L35;
        r13 = r13 + 1;
    L24:
        if (r15.getState() == Thread.State.TERMINATED) goto L26;
        LockSupport.unpark(r15);
        r15.join(10000);
        goto L24
    L26:
        m r16 = r15.f23326a;
        f r17 = this.f;
        r16.getClass();
        i r18 = (i) m.f23349b.getAndSet(r16, null);
        if (r18 == null) goto L29;
        r17.a(r18);
    L29:
        i r19 = r16.b();
        if (r19 == null) goto L33;
        r17.a(r19);
    L35:
        this.f.b();
        this.e.b();
    L36:
        if (r10 == null) goto L39;
        i r20 = r10.a(true);
        if (r20 == null) goto L39;
    L56:
        r20.run();     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        Thread r21 = Thread.currentThread();
        r21.getUncaughtExceptionHandler().uncaughtException(r21, th);
    L39:
        r20 = (i) this.e.d();
        if (r20 != null) goto L56;
        r20 = (i) this.f.d();
        if (r20 != null) goto L56;
        if (r10 == null) goto L45;
        r10.h(CoroutineScheduler$WorkerState.TERMINATED);
    L45:
        f23330h.set(this, 0);
        f23331i.set(this, 0);
        return;
    L51:
        th = move-exception;
        throw th;
    L11:
        if (Intrinsics.areEqual(r10.f23329h, this) == false) goto L13;
    L8:
        r10 = null;
        goto L9
    }

    public final void d(Runnable r10, boolean r11, boolean r12) {
        k.f.getClass();
        long r5 = System.nanoTime();
        if ((r10 instanceof i) == false) goto L5;
        i r13 = (i) r10;
        r13.f23342a = r5;
        r13.f23343b = r11;
    L6:
        boolean r14 = r13.f23343b;
        AtomicLongFieldUpdater r15 = f23331i;
        if (r14 == false) goto L9;
        long r16 = r15.addAndGet(this, 2097152);
    L10:
        Thread r17 = Thread.currentThread();
        if ((r17 instanceof b) == false) goto L13;
        b r18 = (b) r17;
    L14:
        if (r18 != null) goto L16;
    L18:
        r18 = null;
    L19:
        boolean r19 = true;
        if (r18 == null) goto L37;
        CoroutineScheduler$WorkerState r20 = r18.f23328c;
        if (r20 == CoroutineScheduler$WorkerState.TERMINATED) goto L37;
        if (r13.f23343b == false) goto L28;
    L30:
        r18.g = true;
        m r21 = r18.f23326a;
        if (r12 == false) goto L33;
        r13 = r21.a(r13);
        goto L37
    L33:
        r21.getClass();
        i r22 = (i) m.f23349b.getAndSet(r21, r13);
        if (r22 != null) goto L36;
        r13 = null;
        goto L37
    L36:
        r13 = r21.a(r22);
        goto L37
    L28:
        if (r20 != CoroutineScheduler$WorkerState.BLOCKING) goto L30;
    L37:
        if (r13 != null) goto L39;
    L46:
        if (r12 == false) goto L49;
        if (r18 == null) goto L49;
    L50:
        if (r14 == false) goto L60;
        if (r19 == false) goto L54;
        return;
    L54:
        if (m() == false) goto L57;
        return;
    L57:
        if (g(r16) == true) goto L73;
        m();
        return;
    L73:
        return;
    L60:
        if (r19 == false) goto L63;
        return;
    L63:
        if (m() == false) goto L66;
        return;
    L66:
        if (g(r15.get(this)) == true) goto L75;
        m();
        return;
    L75:
        return;
    L49:
        r19 = false;
        goto L50
    L39:
        if (r13.f23343b == false) goto L41;
        boolean r23 = this.f.a(r13);
    L42:
        if (r23 == true) goto L46;
        throw new RejectedExecutionException(j0.q(new StringBuilder(), this.d, " was terminated"));
    L41:
        r23 = this.e.a(r13);
        goto L42
    L16:
        if (Intrinsics.areEqual(r18.f23329h, this) == false) goto L18;
    L13:
        r18 = null;
        goto L14
    L9:
        r16 = 0;
        goto L10
    L5:
        r13 = new j(r10, r5, r11);
        goto L6
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r5) {
        e(this, r5, false, 6);
    }

    public final void f(b r10, int r11, int r12) {
    L2:
        long r5 = f23330h.get(this);
        int r13 = (int) (2097151 & r5);
        long r14 = (2097152 + r5) & (-2097152);
        if (r13 != r11) goto L16;
        if (r12 != 0) goto L15;
        Object r15 = r10.c();
    L7:
        if (r15 == f23333k) goto L8;
        if (r15 == null) goto L10;
        b r16 = (b) r15;
        int r17 = r16.b();
        if (r17 != 0) goto L13;
        r15 = r16.c();
        goto L7
    L13:
        r13 = r17;
        goto L16
    L10:
        r13 = 0;
        goto L16
    L8:
        r13 = -1;
        goto L16
    L15:
        r13 = r12;
    L16:
        if (r13 < 0) goto L2;
        long r18 = ((long) r13) | r14;
        if (f23330h.compareAndSet(this, r5, r18) == false) goto L2;
    }

    public final boolean g(long r5) {
        int r10 = RangesKt.coerceAtLeast(((int) (2097151 & r5)) - ((int) ((r5 & 4398044413952L) >> 21)), 0);
        int r11 = this.f23334a;
        if (r10 >= r11) goto L10;
        int r12 = b();
        if (r12 != 1) goto L8;
        if (r11 <= 1) goto L8;
        b();
    L8:
        if (r12 <= 0) goto L10;
        return true;
    L10:
        return false;
    }

    public final boolean m() {
    L2:
        AtomicLongFieldUpdater r5 = f23330h;
        long r10 = r5.get(this);
        b r11 = (b) this.g.b((int) (2097151 & r10));
        if (r11 == null) goto L4;
        long r12 = (2097152 + r10) & (-2097152);
        Object r13 = r11.c();
    L6:
        g8.g r14 = f23333k;
        if (r13 == r14) goto L8;
        if (r13 == null) goto L10;
        b r15 = (b) r13;
        int r16 = r15.b();
        if (r16 != 0) goto L13;
        r13 = r15.c();
    L13:
        if (r16 < 0) goto L2;
        if (r5.compareAndSet(this, r10, r12 | ((long) r16)) == false) goto L2;
        r11.g(r14);
    L17:
        if (r11 == null) goto L18;
        if (b.f23325i.compareAndSet(r11, -1, 0) == false) goto L2;
        LockSupport.unpark(r11);
        return true;
    L18:
        return false;
    L10:
        r16 = 0;
        goto L13
    L8:
        r16 = -1;
        goto L13
    L4:
        r11 = null;
        goto L17
    }

    public final String toString() {
        ArrayList r5 = new ArrayList();
        q r10 = this.g;
        int r11 = r10.a();
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
        int r17 = 1;
    L3:
        if (r17 >= r11) goto L31;
        b r18 = (b) r10.b(r17);
        if (r18 == null) goto L30;
        m r19 = r18.f23326a;
        r19.getClass();
        if (m.f23349b.get(r19) == null) goto L10;
        int r110 = (m.f23350c.get(r19) - m.d.get(r19)) + 1;
    L11:
        int r111 = a.f23324a[r18.f23328c.ordinal()];
        if (r111 != 1) goto L14;
        r14 = r14 + 1;
        goto L30
    L14:
        if (r111 != 2) goto L16;
        r13 = r13 + 1;
        StringBuilder r112 = new StringBuilder();
        r112.append(r110);
        r112.append('b');
        r5.add(r112.toString());
        goto L30
    L16:
        if (r111 != 3) goto L18;
        r12 = r12 + 1;
        StringBuilder r113 = new StringBuilder();
        r113.append(r110);
        r113.append('c');
        r5.add(r113.toString());
        goto L30
    L18:
        if (r111 != 4) goto L20;
        r15 = r15 + 1;
        if (r110 <= 0) goto L30;
        StringBuilder r114 = new StringBuilder();
        r114.append(r110);
        r114.append('d');
        r5.add(r114.toString());
        goto L30
    L20:
        if (r111 != 5) goto L23;
        r16 = r16 + 1;
        goto L30
    L23:
        throw new NoWhenBranchMatchedException();
    L10:
        r110 = m.f23350c.get(r19) - m.d.get(r19);
    L30:
        r17 = r17 + 1;
        goto L3
    L31:
        long r20 = f23331i.get(this);
        StringBuilder r21 = new StringBuilder();
        r21.append(this.d);
        r21.append('@');
        r21.append(kotlinx.coroutines.j0.f(this));
        r21.append("[Pool Size {core = ");
        int r22 = this.f23334a;
        r21.append(r22);
        r21.append(", max = ");
        androidx.room.jarjarred.org.antlr.runtime.a.C(r21, this.f23335b, "}, Worker States {CPU = ", r12, ", blocking = ");
        androidx.room.jarjarred.org.antlr.runtime.a.C(r21, r13, ", parked = ", r14, ", dormant = ");
        androidx.room.jarjarred.org.antlr.runtime.a.C(r21, r15, ", terminated = ", r16, "}, running workers queues = ");
        r21.append(r5);
        r21.append(", global CPU queue size = ");
        r21.append(this.e.c());
        r21.append(", global blocking queue size = ");
        r21.append(this.f.c());
        r21.append(", Control State {created workers= ");
        r21.append((int) (2097151 & r20));
        r21.append(", blocking tasks = ");
        r21.append((int) ((4398044413952L & r20) >> 21));
        r21.append(", CPUs acquired = ");
        r21.append(r22 - ((int) ((r20 & 9223367638808264704L) >> 42)));
        r21.append("}]");
        return r21.toString();
    }
}
