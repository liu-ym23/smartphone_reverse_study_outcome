package yt;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.internal.q;
import kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends Thread {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f23325i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f23326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Ref.ObjectRef f23327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CoroutineScheduler$WorkerState f23328c;
    public long d;
    public long e;
    public int f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c f23329h;
    private volatile int indexInArray;
    private volatile Object nextParkedWorker;
    private volatile /* synthetic */ int workerCtl$volatile;

    static {
        f23325i = AtomicIntegerFieldUpdater.newUpdater(b.class, "workerCtl$volatile");
    }

    public b(c r5, int r10) {
        this.f23329h = r5;
        setDaemon(true);
        setContextClassLoader(r5.getClass().getClassLoader());
        this.f23326a = new m();
        this.f23327b = new Ref.ObjectRef();
        this.f23328c = CoroutineScheduler$WorkerState.DORMANT;
        this.nextParkedWorker = c.f23333k;
        int r11 = (int) System.nanoTime();
        if (r11 != 0) goto L6;
        r11 = 42;
    L6:
        this.f = r11;
        f(r10);
    }

    public final i a(boolean r13) {
        CoroutineScheduler$WorkerState r5 = this.f23328c;
        CoroutineScheduler$WorkerState r10 = CoroutineScheduler$WorkerState.CPU_ACQUIRED;
        i r11 = null;
        m r12 = this.f23326a;
        boolean r14 = true;
        c r15 = this.f23329h;
        if (r5 == r10) goto L36;
        AtomicLongFieldUpdater r16 = c.f23331i;
    L6:
        c r17 = this.f23329h;
        long r18 = r16.get(r17);
        if (((int) ((9223367638808264704L & r18) >> 42)) == 0) goto L8;
        if (c.f23331i.compareAndSet(r17, r18, r18 - 4398046511104L) == false) goto L6;
        this.f23328c = CoroutineScheduler$WorkerState.CPU_ACQUIRED;
        goto L36
    L8:
        r12.getClass();
    L9:
        AtomicReferenceFieldUpdater r19 = m.f23349b;
        i r20 = (i) r19.get(r12);
        if (r20 == null) goto L20;
        if (r20.f23343b != true) goto L20;
    L15:
        if (r19.compareAndSet(r12, r20, null) == true) goto L16;
        if (r19.get(r12) == r20) goto L15;
    L16:
        r11 = r20;
    L28:
        if (r11 != null) goto L71;
        i r21 = (i) r15.f.d();
        if (r21 == null) goto L32;
        return r21;
    L32:
        return i(1);
    L71:
        return r11;
    L20:
        int r110 = m.d.get(r12);
        int r22 = m.f23350c.get(r12);
    L21:
        if (r110 == r22) goto L28;
        if (m.e.get(r12) == 0) goto L28;
        r22 = r22 - 1;
        i r23 = r12.c(r22, true);
        if (r23 == null) goto L21;
        r11 = r23;
    L36:
        if (r13 == true) goto L38;
        i r111 = e();
        if (r111 == null) goto L58;
        return r111;
    L58:
        return i(3);
    L38:
        if (d(r15.f23334a * 2) == 0) goto L41;
        r14 = false;
    L41:
        if (r14 == false) goto L45;
        i r112 = e();
        if (r112 == null) goto L45;
        return r112;
    L45:
        r12.getClass();
        i r113 = (i) m.f23349b.getAndSet(r12, null);
        if (r113 != null) goto L48;
        r113 = r12.b();
    L48:
        if (r113 != null) goto L74;
        if (r14 == true) goto L58;
        i r114 = e();
        if (r114 == null) goto L58;
        return r114;
    L74:
        return r113;
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int r5) {
        int r10 = this.f;
        int r11 = r10 ^ (r10 << 13);
        int r12 = r11 ^ (r11 >> 17);
        int r13 = r12 ^ (r12 << 5);
        this.f = r13;
        int r14 = r5 - 1;
        if ((r14 & r5) != 0) goto L7;
        return r14 & r13;
    L7:
        return (Integer.MAX_VALUE & r13) % r5;
    }

    public final i e() {
        int r5 = d(2);
        c r10 = this.f23329h;
        if (r5 != 0) goto L9;
        i r11 = (i) r10.e.d();
        if (r11 == null) goto L8;
        return r11;
    L8:
        return (i) r10.f.d();
    L9:
        i r12 = (i) r10.f.d();
        if (r12 == null) goto L13;
        return r12;
    L13:
        return (i) r10.e.d();
    }

    public final void f(int r5) {
        StringBuilder r10 = new StringBuilder();
        r10.append(this.f23329h.d);
        r10.append("-worker-");
        if (r5 != 0) goto L5;
        String r11 = "TERMINATED";
    L6:
        r10.append(r11);
        setName(r10.toString());
        this.indexInArray = r5;
        return;
    L5:
        r11 = String.valueOf(r5);
        goto L6
    }

    public final void g(Object r5) {
        this.nextParkedWorker = r5;
    }

    public final boolean h(CoroutineScheduler$WorkerState r10) {
        CoroutineScheduler$WorkerState r5 = this.f23328c;
        if (r5 != CoroutineScheduler$WorkerState.CPU_ACQUIRED) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L8;
        c.f23331i.addAndGet(this.f23329h, 4398046511104L);
    L8:
        if (r5 == r10) goto L10;
        this.f23328c = r10;
    L10:
        return r11;
    L5:
        r11 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1, types: [T, java.lang.Object, yt.i] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [yt.i] */
    /* JADX WARN: Type inference failed for: r7v9, types: [yt.i] */
    public final i i(int r21) {
        AtomicLongFieldUpdater r5 = c.f23331i;
        c r10 = this.f23329h;
        int r11 = (int) (r5.get(r10) & 2097151);
        if (r11 >= 2) goto L5;
        return null;
    L5:
        int r12 = d(r11);
        int r13 = 0;
        long r14 = Long.MAX_VALUE;
    L6:
        if (r13 >= r11) goto L61;
        r12 = r12 + 1;
        if (r12 <= r11) goto L10;
        r12 = 1;
    L10:
        b r15 = (b) r10.g.b(r12);
        if (r15 == null) goto L59;
        if (r15 == this) goto L59;
        m r16 = r15.f23326a;
        if (r21 != 3) goto L16;
        T r17 = r16.b();
    L28:
        Ref.ObjectRef r18 = this.f23327b;
        if (r17 == 0) goto L32;
        r18.element = r17;
        long r19 = -1;
    L50:
        if (r19 == (-1)) goto L51;
        if (r19 <= 0) goto L59;
        r14 = Math.min(r14, r19);
        goto L59
    L51:
        i r20 = (i) r18.element;
        r18.element = null;
        return r20;
    L32:
        AtomicReferenceFieldUpdater r22 = m.f23349b;
        ?? r110 = (i) r22.get(r16);
        long r111 = -2;
        if (r110 == 0) goto L48;
        if (r110.f23343b == false) goto L38;
        int r112 = 1;
    L40:
        if ((r112 & r21) == 0) goto L48;
        k.f.getClass();
        long r113 = System.nanoTime() - r110.f23342a;
        long r23 = k.f23346b;
        if (r113 < r23) goto L44;
    L46:
        if (r22.compareAndSet(r16, r110, null) == true) goto L47;
        if (r22.get(r16) == r110) goto L46;
    L47:
        r18.element = r110;
        r111 = -1;
        goto L48
    L44:
        r111 = r23 - r113;
        goto L48
    L38:
        r112 = 2;
    L48:
        r19 = r111;
        goto L50
    L16:
        r16.getClass();
        int r24 = m.d.get(r16);
        int r25 = m.f23350c.get(r16);
        if (r21 != 1) goto L19;
        boolean r26 = true;
    L20:
        if (r24 == r25) goto L24;
        if (r26 == true) goto L23;
    L25:
        int r114 = r24 + 1;
        r17 = r16.c(r24, r26);
        if (r17 != 0) goto L28;
        r24 = r114;
        goto L20
    L23:
        if (m.e.get(r16) != 0) goto L25;
    L24:
        r17 = 0;
        goto L28
    L19:
        r26 = false;
    L59:
        r13 = r13 + 1;
        goto L6
    L61:
        if (r14 != Long.MAX_VALUE) goto L64;
        r14 = 0;
    L64:
        this.e = r14;
        return null;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean r5 = false;
    L3:
        boolean r10 = r5;
    L4:
        c r11 = this.f23329h;
        r11.getClass();
        if (c.f23332j.get(r11) != 0) goto L104;
        CoroutineScheduler$WorkerState r12 = this.f23328c;
        CoroutineScheduler$WorkerState r13 = CoroutineScheduler$WorkerState.TERMINATED;
        if (r12 == r13) goto L104;
        i r14 = a(this.g);
        long r15 = -2097152;
        if (r14 != null) goto L11;
        this.g = r5;
        if (this.e != 0) goto L40;
        Object r16 = this.nextParkedWorker;
        g8.g r17 = c.f23333k;
        if (r16 == r17) goto L46;
        boolean r18 = true;
    L48:
        if (r18 == true) goto L56;
        c r19 = this.f23329h;
        r19.getClass();
        if (this.nextParkedWorker != r17) goto L103;
    L52:
        AtomicLongFieldUpdater r110 = c.f23330h;
        long r111 = r110.get(r19);
        int r20 = this.indexInArray;
        this.nextParkedWorker = r19.g.b((int) (r111 & 2097151));
        if (r110.compareAndSet(r19, r111, ((2097152 + r111) & r15) | ((long) r20)) == true) goto L103;
        r15 = -2097152;
    L103:
        r5 = r5;
        goto L4
    L56:
        f23325i.set(this, -1);
    L58:
        if (this.nextParkedWorker == c.f23333k) goto L103;
        AtomicIntegerFieldUpdater r21 = f23325i;
        if (r21.get(this) != (-1)) goto L103;
        c r22 = this.f23329h;
        r22.getClass();
        AtomicIntegerFieldUpdater r23 = c.f23332j;
        if (r23.get(r22) != 0) goto L103;
        CoroutineScheduler$WorkerState r24 = this.f23328c;
        CoroutineScheduler$WorkerState r112 = CoroutineScheduler$WorkerState.TERMINATED;
        if (r24 == r112) goto L103;
        h(CoroutineScheduler$WorkerState.PARKING);
        Thread.interrupted();
        if (this.d != 0) goto L71;
        this.d = System.nanoTime() + this.f23329h.f23336c;
    L71:
        LockSupport.parkNanos(this.f23329h.f23336c);
        if ((System.nanoTime() - this.d) < 0) goto L101;
        this.d = 0;
        c r25 = this.f23329h;
        q r26 = r25.g;
        monitor-enter(r26);
        if (r23.get(r25) == 0) goto L78;
        boolean r27 = true;
    L79:
        if (r27 == false) goto L82;
        monitor-exit(r26);
        goto L101
    L82:
        AtomicLongFieldUpdater r28 = c.f23331i;     // Catch: Throwable -> L94
        if (((int) (r28.get(r25) & 2097151)) > r25.f23334a) goto L88;
        monitor-exit(r26);
        goto L101
    L88:
        if (r21.compareAndSet(this, -1, 1) == true) goto L91;
        monitor-exit(r26);
        goto L101
    L91:
        int r29 = this.indexInArray;     // Catch: Throwable -> L94
        boolean r113 = false;
        f(0);     // Catch: Throwable -> L94
        r25.f(this, r29, 0);     // Catch: Throwable -> L94
        int r30 = (int) (r28.getAndDecrement(r25) & 2097151);     // Catch: Throwable -> L94
        if (r30 == r29) goto L96;
        Object r114 = r25.g.b(r30);     // Catch: Throwable -> L94
        Intrinsics.checkNotNull(r114);     // Catch: Throwable -> L94
        b r115 = (b) r114;     // Catch: Throwable -> L94
        r25.g.c(r29, r115);     // Catch: Throwable -> L94
        r115.f(r29);     // Catch: Throwable -> L94
        r25.f(r115, r30, r29);     // Catch: Throwable -> L94
    L96:
        r25.g.c(r30, null);     // Catch: Throwable -> L94
        Unit r31 = Unit.INSTANCE;     // Catch: Throwable -> L94
        monitor-exit(r26);
        this.f23328c = r112;
    L102:
        r5 = r113;
        goto L58
    L78:
        r27 = false;
    L94:
        th = move-exception;
        throw th;
    L101:
        r113 = false;
        goto L102
    L46:
        r18 = r5;
        goto L48
    L40:
        if (r10 == true) goto L42;
        r10 = true;
        goto L4
    L42:
        h(CoroutineScheduler$WorkerState.PARKING);
        Thread.interrupted();
        LockSupport.parkNanos(this.e);
        this.e = 0;
        goto L3
    L11:
        this.e = 0;
        this.d = 0;
        if (this.f23328c != CoroutineScheduler$WorkerState.PARKING) goto L14;
        this.f23328c = CoroutineScheduler$WorkerState.BLOCKING;
    L14:
        boolean r32 = r14.f23343b;
        c r33 = this.f23329h;
        if (r32 == true) goto L17;
        r33.getClass();
        r14.run();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        Thread r34 = Thread.currentThread();
        r34.getUncaughtExceptionHandler().uncaughtException(r34, th);
        goto L3
    L17:
        if (h(CoroutineScheduler$WorkerState.BLOCKING) == true) goto L19;
    L25:
        r33.getClass();
        r14.run();     // Catch: Throwable -> L28
    L30:
        c.f23331i.addAndGet(r33, -2097152);
        if (this.f23328c == r13) goto L3;
        this.f23328c = CoroutineScheduler$WorkerState.DORMANT;
    L28:
        th = move-exception;
        Thread r35 = Thread.currentThread();
        r35.getUncaughtExceptionHandler().uncaughtException(r35, th);
        goto L30
    L19:
        if (r33.m() == true) goto L25;
        if (r33.g(c.f23331i.get(r33)) == true) goto L25;
        r33.m();
    L104:
        h(CoroutineScheduler$WorkerState.TERMINATED);
    }
}
