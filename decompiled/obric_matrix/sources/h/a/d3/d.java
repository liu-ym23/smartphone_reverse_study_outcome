package h.a.d3;

import h.a.f3.p0;
import h.a.q0;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.f0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000BB9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012 \u0010\t\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00172\u0006\u0010\r\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010 \u001a\u00020\u00172\u0006\u0010\r\u001a\u00028\u00002\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0014¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0012H\u0014¢\u0006\u0004\b#\u0010$J\u0011\u0010%\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b%\u0010&J\u001d\u0010'\u001a\u0004\u0018\u00010\u00172\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0014¢\u0006\u0004\b'\u0010(J\u0019\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010+R\u001e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00102\u001a\u00020/8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00103R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00103R\u0014\u00105\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u00107\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b7\u00106R\u0014\u00108\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b8\u00106R\u0014\u00109\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b9\u00106R\u0014\u0010:\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u00106R\u0014\u0010;\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u00106R\u0018\u0010>\u001a\u00060<j\u0002`=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010@¨\u0006A"}, d2 = {"Lkotlinx/coroutines/channels/ArrayChannel;", "E", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "currentSize", "element", "enqueueElement", "(ILjava/lang/Object;)V", "Lkotlinx/coroutines/channels/Receive;", "receive", "", "enqueueReceiveInternal", "(Lkotlinx/coroutines/channels/Receive;)Z", "Lkotlinx/coroutines/channels/Send;", "send", "", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "ensureCapacity", "(I)V", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "wasClosed", "onCancelIdempotent", "(Z)V", "pollInternal", "()Ljava/lang/Object;", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "updateBufferSize", "(I)Lkotlinx/coroutines/internal/Symbol;", "", "buffer", "[Ljava/lang/Object;", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "I", "head", "isBufferAlwaysEmpty", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "isClosedForReceive", "isEmpty", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/channels/BufferOverflow;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/AbstractChannel;"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class d<E> extends h.a.d3.a<E> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f17216i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final e f17217j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ReentrantLock f17218k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Object[] f17219l;
    private int m;
    private volatile /* synthetic */ int size;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17220a = null;

        static {
            int[] r0 = new int[e.values().length];
            r0[e.f17221f.ordinal()] = 1;
            r0[e.f17223h.ordinal()] = 2;
            r0[e.f17222g.ordinal()] = 3;
            f17220a = r0;
        }
    }

    public d(int r7, e r8, kotlin.n0.c.l<? super E, f0> r9) {
        super(r9);
        this.f17216i = r7;
        this.f17217j = r8;
        boolean r10 = true;
        if (r7 >= 1) goto L6;
        r10 = false;
    L6:
        if (r10 == false) goto L10;
        this.f17218k = new ReentrantLock();
        Object[] r11 = new Object[Math.min(r7, 8)];
        kotlin.i0.i.m(r11, b.f17204a, 0, 0, 6, null);
        this.f17219l = r11;
        this.size = 0;
        return;
    L10:
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + r7 + " was specified").toString());
    }

    private final void S(int r6, E r7) {
        if (r6 >= this.f17216i) goto L6;
        T(r6);
        Object[] r0 = this.f17219l;
        r0[(this.m + r6) % r0.length] = r7;
        return;
    L6:
        if (q0.a() == true) goto L8;
    L15:
        Object[] r1 = this.f17219l;
        int r2 = this.m;
        r1[r2 % r1.length] = null;
        r1[(r6 + r2) % r1.length] = r7;
        this.m = (r2 + 1) % r1.length;
        return;
    L8:
        if (this.f17217j != e.f17222g) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L15;
        throw new AssertionError();
    L10:
        r3 = false;
        goto L11
    }

    private final void T(int r9) {
        Object[] r0 = this.f17219l;
        if (r9 < r0.length) goto L10;
        int r1 = Math.min(r0.length * 2, this.f17216i);
        Object[] r2 = new Object[r1];
        int r3 = 0;
    L5:
        if (r3 >= r9) goto L7;
        Object[] r5 = this.f17219l;
        r2[r3] = r5[(this.m + r3) % r5.length];
        r3 = r3 + 1;
        goto L5
    L7:
        kotlin.i0.i.l(r2, b.f17204a, r9, r1);
        this.f17219l = r2;
        this.m = 0;
        return;
    }

    private final h.a.f3.f0 U(int r4) {
        if (r4 >= this.f17216i) goto L6;
        this.size = r4 + 1;
        return null;
    L6:
        e r3 = this.f17217j;
        int r5 = a.f17220a[r3.ordinal()];
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L18;
        if (r5 != 3) goto L14;
        return null;
    L14:
        throw new kotlin.m();
    L18:
        return b.f17205b;
    L17:
        return b.f17206c;
    }

    @Override // h.a.d3.a
    protected boolean H(u<? super E> r2) {
        ReentrantLock r0 = this.f17218k;
        r0.lock();
        boolean r1 = super.H(r2);     // Catch: Throwable -> L6
        r0.unlock();
        return r1;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // h.a.d3.a
    protected final boolean I() {
        return false;
    }

    @Override // h.a.d3.a
    protected final boolean J() {
        if (this.size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // h.a.d3.a
    public boolean K() {
        ReentrantLock r0 = this.f17218k;
        r0.lock();
        boolean r1 = super.K();     // Catch: Throwable -> L6
        r0.unlock();
        return r1;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // h.a.d3.a
    protected void L(boolean r10) {
        kotlin.n0.c.l<E, f0> r0 = this.f17212f;
        ReentrantLock r1 = this.f17218k;
        r1.lock();
        int r2 = this.size;     // Catch: Throwable -> L16
        p0 r4 = null;
        int r5 = 0;
    L4:
        if (r5 >= r2) goto L11;
        r5 = r5 + 1;     // Catch: Throwable -> L16
        Object r6 = this.f17219l[this.m];     // Catch: Throwable -> L16
        if (r0 == null) goto L10;
        if (r6 == b.f17204a) goto L10;
        r4 = h.a.f3.z.c(r0, r6, r4);     // Catch: Throwable -> L16
    L10:
        Object[] r7 = this.f17219l;     // Catch: Throwable -> L16
        int r8 = this.m;     // Catch: Throwable -> L16
        r7[r8] = b.f17204a;     // Catch: Throwable -> L16
        this.m = (r8 + 1) % r7.length;     // Catch: Throwable -> L16
        goto L4
    L11:
        this.size = 0;     // Catch: Throwable -> L16
        f0 r3 = f0.f18324a;     // Catch: Throwable -> L16
        r1.unlock();
        super.L(r10);
        if (r4 != null) goto L15;
        return;
    L15:
        throw r4;
    L16:
        th = move-exception;
        r1.unlock();
        throw th;
    }

    @Override // h.a.d3.a
    protected Object P() {
        ReentrantLock r0 = this.f17218k;
        r0.lock();
        int r1 = this.size;     // Catch: Throwable -> L39
        if (r1 != 0) goto L10;
        Object r9 = m();     // Catch: Throwable -> L39
        if (r9 != null) goto L8;
        r9 = b.f17207d;     // Catch: Throwable -> L39
    L8:
        r0.unlock();
        return r9;
    L10:
        Object[] r2 = this.f17219l;     // Catch: Throwable -> L39
        int r3 = this.m;     // Catch: Throwable -> L39
        Object r4 = r2[r3];     // Catch: Throwable -> L39
        y r5 = null;
        r2[r3] = null;     // Catch: Throwable -> L39
        this.size = r1 - 1;     // Catch: Throwable -> L39
        Object r6 = b.f17207d;     // Catch: Throwable -> L39
        boolean r7 = false;
        if (r1 != this.f17216i) goto L30;
        y r8 = null;
    L13:
        y r10 = C();     // Catch: Throwable -> L39
        if (r10 == null) goto L15;
        h.a.f3.f0 r11 = r10.F(null);     // Catch: Throwable -> L39
        if (r11 != null) goto L19;
        r10.G();     // Catch: Throwable -> L39
        r8 = r10;
        goto L13
    L19:
        if (q0.a() == true) goto L21;
    L27:
        r6 = r10.D();     // Catch: Throwable -> L39
        r7 = true;
        r5 = r10;
        goto L30
    L21:
        if (r11 != h.a.p.f17553a) goto L23;
        r7 = true;
    L23:
        if (r7 == true) goto L27;
        throw new AssertionError();     // Catch: Throwable -> L39
    L15:
        r5 = r8;
    L30:
        if (r6 != b.f17207d) goto L32;
    L34:
        this.m = (this.m + 1) % this.f17219l.length;     // Catch: Throwable -> L39
        f0 r12 = f0.f18324a;     // Catch: Throwable -> L39
        r0.unlock();
        if (r7 == false) goto L38;
        kotlin.n0.d.o.c(r5);
        r5.C();
    L38:
        return r4;
    L32:
        if ((r6 instanceof m) == true) goto L34;
        this.size = r1;     // Catch: Throwable -> L39
        Object[] r13 = this.f17219l;     // Catch: Throwable -> L39
        r13[(this.m + r1) % r13.length] = r6;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // h.a.d3.c
    protected Object h(y r2) {
        ReentrantLock r0 = this.f17218k;
        r0.lock();
        Object r1 = super.h(r2);     // Catch: Throwable -> L6
        r0.unlock();
        return r1;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // h.a.d3.c
    protected String j() {
        return "(buffer:capacity=" + this.f17216i + ",size=" + this.size + ')';
    }

    @Override // h.a.d3.c
    protected final boolean u() {
        return false;
    }

    @Override // h.a.d3.c
    protected final boolean v() {
        if (this.size == this.f17216i) goto L5;
    L7:
        return false;
    L5:
        if (this.f17217j != e.f17221f) goto L7;
        return true;
    }

    @Override // h.a.d3.c
    protected Object x(E r6) {
        ReentrantLock r0 = this.f17218k;
        r0.lock();
        int r1 = this.size;     // Catch: Throwable -> L39
        m<?> r2 = m();     // Catch: Throwable -> L39
        if (r2 != null) goto L37;
        h.a.f3.f0 r3 = U(r1);     // Catch: Throwable -> L39
        if (r3 != null) goto L35;
        if (r1 != 0) goto L32;
    L8:
        w<E> r4 = B();     // Catch: Throwable -> L39
        if (r4 == null) goto L32;
        if ((r4 instanceof m) == true) goto L13;
        h.a.f3.f0 r5 = r4.i(r6, null);     // Catch: Throwable -> L39
        if (r5 == null) goto L8;
        if (q0.a() == true) goto L22;
    L29:
        this.size = r1;     // Catch: Throwable -> L39
        f0 r7 = f0.f18324a;     // Catch: Throwable -> L39
        r0.unlock();
        r4.h(r6);
        return r4.a();
    L22:
        if (r5 != h.a.p.f17553a) goto L24;
        boolean r8 = true;
    L25:
        if (r8 == true) goto L29;
        throw new AssertionError();     // Catch: Throwable -> L39
    L24:
        r8 = false;
        goto L25
    L13:
        this.size = r1;     // Catch: Throwable -> L39
        r0.unlock();
        return r4;
    L32:
        S(r1, r6);     // Catch: Throwable -> L39
        h.a.f3.f0 r9 = b.f17205b;     // Catch: Throwable -> L39
        r0.unlock();
        return r9;
    L35:
        r0.unlock();
        return r3;
    L37:
        r0.unlock();
        return r2;
    L39:
        th = move-exception;
        r0.unlock();
        throw th;
    }
}
