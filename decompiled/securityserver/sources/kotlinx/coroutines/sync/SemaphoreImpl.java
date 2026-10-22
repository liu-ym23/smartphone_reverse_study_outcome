package kotlinx.coroutines.sync;

import a.a;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class SemaphoreImpl implements Semaphore {
    public static final AtomicReferenceFieldUpdater c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f446d = null;
    public static final AtomicReferenceFieldUpdater e = null;
    public static final AtomicLongFieldUpdater f = null;
    public static final AtomicIntegerFieldUpdater g = null;
    volatile int _availablePermits;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1 f447a;
    public final int b;
    private volatile long deqIdx;
    private volatile long enqIdx;
    private volatile Object head;
    private volatile Object tail;

    static {
        c = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head");
        f446d = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");
        e = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail");
        f = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");
        g = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");
    }

    public SemaphoreImpl(int r6, int r7) {
        this.b = r6;
        this.deqIdx = 0;
        this.enqIdx = 0;
        boolean r2 = false;
        if (r6 <= 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L17;
        if (r7 < 0) goto L11;
        if (r6 < r7) goto L11;
        r2 = true;
    L11:
        if (r2 == false) goto L15;
        SemaphoreSegment r3 = new SemaphoreSegment(0, null, 2);
        this.head = r3;
        this.tail = r3;
        this._availablePermits = r6 - r7;
        this.f447a = new SemaphoreImpl$onCancellationRelease$1(this);
        return;
    L15:
        throw new IllegalArgumentException(a.e(r6, "The number of acquired permits should be in 0..").toString());
    L17:
        throw new IllegalArgumentException(a.e(r6, "Semaphore should have at least 1 permit, but had ").toString());
    L5:
        r4 = false;
        goto L6
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public final Object a(ContinuationImpl r18) {
        int r1 = g.getAndDecrement(this);
        Unit r2 = Unit.f330a;
        if (r1 <= 0) goto L5;
        return r2;
    L5:
        CancellableContinuationImpl r3 = CancellableContinuationKt.a(IntrinsicsKt.b(r18));
    L6:
        SemaphoreSegment r4 = (SemaphoreSegment) this.tail;
        long r5 = f.getAndIncrement(this);
        long r6 = r5 / ((long) SemaphoreKt.f);
    L7:
        Segment r8 = r4;
    L8:
        long r9 = r8.c;
        Symbol r11 = ConcurrentLinkedListKt.f409a;
        if (r9 >= r6) goto L11;
    L14:
        Object r10 = ConcurrentLinkedListNode.a(r8);
        if (r10 == r11) goto L16;
        long r15 = r6;
        Segment r12 = (Segment) ((ConcurrentLinkedListNode) r10);
        if (r12 == null) goto L52;
        r8 = r12;
    L51:
        r6 = r15;
        goto L8
    L52:
        SemaphoreSegment r13 = new SemaphoreSegment(r8.c + 1, (SemaphoreSegment) r8, 0);
        if (ConcurrentLinkedListNode.f410a.compareAndSet(r8, null, r13) == false) goto L51;
        if (r8.b() == false) goto L57;
        r8.d();
    L57:
        r8 = r13;
        goto L51
    L16:
        Object r14 = r11;
    L17:
        if (r14 == r11) goto L31;
        Segment r16 = SegmentOrClosed.a(r14);
    L20:
        Segment r17 = (Segment) this.tail;
        long r19 = r6;
        if (r17.c >= r16.c) goto L31;
        if (r16.g() == false) goto L25;
        if (e.compareAndSet(this, r17, r16) == true) goto L29;
        if (r16.e() == false) goto L47;
        r16.d();
    L47:
        r6 = r19;
        goto L20
    L29:
        if (r17.e() == false) goto L31;
        r17.d();
        goto L31
    L25:
        r6 = r19;
    L31:
        SemaphoreSegment r7 = (SemaphoreSegment) SegmentOrClosed.a(r14);
        int r20 = (int) (r5 % ((long) SemaphoreKt.f));
        if (r7.e.compareAndSet(r20, null, r3) == true) goto L33;
        Symbol r21 = SemaphoreKt.b;
        Symbol r22 = SemaphoreKt.c;
        if (r7.e.compareAndSet(r20, r21, r22) == true) goto L36;
        boolean r23 = DebugKt.f370a;
        if (g.getAndDecrement(this) <= 0) goto L6;
        Function1 r0 = this.f447a;
        r3.A(r2, r3.e, r0);
    L40:
        Object r24 = r3.s();
        if (r24 != CoroutineSingletons.b) goto L43;
        return r24;
    L43:
        return r2;
    L36:
        Function1 r25 = this.f447a;
        r3.A(r2, r3.e, r25);
        goto L40
    L33:
        r3.u(new CancelSemaphoreAcquisitionHandler(r7, r20));
        goto L40
    L11:
        if (r8.b() == true) goto L14;
        r14 = r8;
        goto L17
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public final void release() {
    L2:
        int r0 = this._availablePermits;
        if (r0 >= this.b) goto L66;
        if (g.compareAndSet(this, r0, r0 + 1) == false) goto L2;
        if (r0 >= 0) goto L7;
        SemaphoreSegment r1 = (SemaphoreSegment) this.head;
        long r2 = f446d.getAndIncrement(this);
        long r3 = r2 / ((long) SemaphoreKt.f);
    L9:
        Segment r5 = r1;
    L10:
        long r6 = r5.c;
        Symbol r8 = ConcurrentLinkedListKt.f409a;
        int r9 = 0;
        if (r6 >= r3) goto L13;
    L16:
        Object r7 = ConcurrentLinkedListNode.a(r5);
        if (r7 == r8) goto L18;
        Segment r10 = (Segment) ((ConcurrentLinkedListNode) r7);
        if (r10 != null) goto L58;
        SemaphoreSegment r11 = new SemaphoreSegment(r5.c + 1, (SemaphoreSegment) r5, 0);
        if (ConcurrentLinkedListNode.f410a.compareAndSet(r5, null, r11) == false) goto L10;
        if (r5.b() == false) goto L64;
        r5.d();
    L64:
        r5 = r11;
        goto L10
    L58:
        r5 = r10;
        goto L10
    L18:
        Object r12 = r8;
    L19:
        if (r12 == r8) goto L33;
        Segment r13 = SegmentOrClosed.a(r12);
    L22:
        Segment r14 = (Segment) this.head;
        if (r14.c >= r13.c) goto L33;
        if (r13.g() == false) goto L9;
        if (c.compareAndSet(this, r14, r13) == true) goto L31;
        if (r13.e() == false) goto L22;
        r13.d();
        goto L22
    L31:
        if (r14.e() == false) goto L33;
        r14.d();
    L33:
        SemaphoreSegment r4 = (SemaphoreSegment) SegmentOrClosed.a(r12);
        ConcurrentLinkedListNode.b.lazySet(r4, null);
        if (r4.c > r3) goto L51;
        int r15 = (int) (r2 % ((long) SemaphoreKt.f));
        Object r16 = r4.e.getAndSet(r15, SemaphoreKt.b);
        if (r16 != null) goto L46;
        int r17 = SemaphoreKt.f448a;
    L39:
        if (r9 >= r17) goto L44;
        if (r4.e.get(r15) == SemaphoreKt.c) goto L42;
        r9 = r9 + 1;
    L42:
        r9 = 1;
        goto L51
    L44:
        r9 = !r4.e.compareAndSet(r15, SemaphoreKt.b, SemaphoreKt.f449d) ? 1 : 0;
        goto L51
    L46:
        if (r16 == SemaphoreKt.e) goto L51;
        CancellableContinuation r18 = (CancellableContinuation) r16;
        if (r18.m(Unit.f330a, null, this.f447a) == null) goto L51;
        r18.g();
    L51:
        if (r9 == 0) goto L2;
        return;
    L13:
        if (r5.b() == true) goto L16;
        r12 = r5;
        goto L19
    L7:
        return;
    L66:
        throw new IllegalStateException(("The number of released permits cannot be greater than " + this.b).toString());
    }
}
