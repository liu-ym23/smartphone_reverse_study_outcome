package kotlinx.coroutines.sync;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: compiled from: Semaphore.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0016\u001a\u00020\u0014H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0017Jb\u0010\u0016\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u0019\u001a\u0002H\u00182!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001d0\u00122!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00140\u0012H\u0083\b¢\u0006\u0002\u0010\u001fJ\u0016\u0010\u0016\u001a\u00020\u00142\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140 H\u0005J\u0011\u0010!\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u0014H\u0002J\b\u0010%\u001a\u00020\u0003H\u0002J\u001e\u0010&\u001a\u00020\u00142\n\u0010'\u001a\u0006\u0012\u0002\b\u00030(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0004J\b\u0010+\u001a\u00020\u0014H\u0016J\b\u0010,\u001a\u00020\u001dH\u0016J\b\u0010-\u001a\u00020\u001dH\u0002J\f\u0010.\u001a\u00020\u001d*\u00020*H\u0002R\t\u0010\u0006\u001a\u00020\u0007X\u0082\u0004R\u0014\u0010\b\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\t\u0010\u000b\u001a\u00020\fX\u0082\u0004R\t\u0010\r\u001a\u00020\fX\u0082\u0004R\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreImpl;", "Lkotlinx/coroutines/sync/Semaphore;", "permits", "", "acquiredPermits", "(II)V", "_availablePermits", "Lkotlinx/atomicfu/AtomicInt;", "availablePermits", "getAvailablePermits", "()I", "deqIdx", "Lkotlinx/atomicfu/AtomicLong;", "enqIdx", "head", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "onCancellationRelease", "Lkotlin/Function1;", "", "", "tail", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ExifInterface.LONGITUDE_WEST, "waiter", "suspend", "Lkotlin/ParameterName;", "name", "", "onAcquired", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CancellableContinuation;", "acquireSlowPath", "addAcquireToQueue", "Lkotlinx/coroutines/Waiter;", "coerceAvailablePermitsAtMaximum", "decPermits", "onAcquireRegFunction", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "ignoredParam", "", "release", "tryAcquire", "tryResumeNextFromQueue", "tryResumeAcquire", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class SemaphoreImpl implements Semaphore {
    private static final AtomicIntegerFieldUpdater _availablePermits$FU = null;
    private static final AtomicLongFieldUpdater deqIdx$FU = null;
    private static final AtomicLongFieldUpdater enqIdx$FU = null;
    private static final AtomicReferenceFieldUpdater head$FU = null;
    private static final AtomicReferenceFieldUpdater tail$FU = null;

    @Volatile
    private volatile int _availablePermits;

    @Volatile
    private volatile long deqIdx;

    @Volatile
    private volatile long enqIdx;

    @Volatile
    private volatile Object head;
    private final Function1<Throwable, Unit> onCancellationRelease;
    private final int permits;

    @Volatile
    private volatile Object tail;

    static {
        head$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head");
        deqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");
        tail$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail");
        enqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");
        _availablePermits$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public Object acquire(Continuation<? super Unit> r1) {
        return acquire$suspendImpl(this, r1);
    }

    public SemaphoreImpl(int r6, int r7) {
        this.permits = r6;
        boolean r0 = true;
        if (r6 <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L17;
        if (r7 < 0) goto L10;
        if (r7 > r6) goto L10;
    L11:
        if (r0 == false) goto L15;
        SemaphoreSegment r1 = new SemaphoreSegment(0, null, 2);
        this.head = r1;
        this.tail = r1;
        this._availablePermits = r6 - r7;
        this.onCancellationRelease = new SemaphoreImpl$onCancellationRelease$1(this);
        return;
    L15:
        throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + r6).toString());
    L10:
        r0 = false;
        goto L11
    L17:
        throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + r6).toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final /* synthetic */ Object access$acquireSlowPath(SemaphoreImpl r0, Continuation r1) {
        return r0.acquireSlowPath(r1);
    }

    public static final /* synthetic */ boolean access$addAcquireToQueue(SemaphoreImpl r0, Waiter r1) {
        return r0.addAcquireToQueue(r1);
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public int getAvailablePermits() {
        return Math.max(_availablePermits$FU.get(this), 0);
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public boolean tryAcquire() {
    L2:
        AtomicIntegerFieldUpdater r0 = _availablePermits$FU;
        int r1 = r0.get(this);
        if (r1 > this.permits) goto L4;
        if (r1 <= 0) goto L6;
        if (r0.compareAndSet(this, r1, r1 - 1) == false) goto L2;
        return true;
    L6:
        return false;
    L4:
        coerceAvailablePermitsAtMaximum();
        goto L2
    }

    static /* synthetic */ Object acquire$suspendImpl(SemaphoreImpl r1, Continuation<? super Unit> r2) {
        if (r1.decPermits() > 0) goto L5;
        Object r3 = r1.acquireSlowPath(r2);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r3;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    private final <W> void acquire(W r2, Function1<? super W, Boolean> r3, Function1<? super W, Unit> r4) {
    L3:
        if (decPermits() > 0) goto L4;
        if (r3.invoke(r2).booleanValue() == false) goto L3;
        return;
    L4:
        r4.invoke(r2);
    }

    private final int decPermits() {
    L2:
        int r0 = _availablePermits$FU.getAndDecrement(this);
        if (r0 > this.permits) goto L2;
        return r0;
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public void release() {
    L2:
        int r0 = _availablePermits$FU.getAndIncrement(this);
        if (r0 >= this.permits) goto L9;
        if (r0 >= 0) goto L5;
        if (tryResumeNextFromQueue() == false) goto L2;
        return;
    L5:
        return;
    L9:
        coerceAvailablePermitsAtMaximum();
        throw new IllegalStateException(("The number of released permits cannot be greater than " + this.permits).toString());
    }

    private final void coerceAvailablePermitsAtMaximum() {
    L2:
        AtomicIntegerFieldUpdater r0 = _availablePermits$FU;
        int r1 = r0.get(this);
        int r2 = this.permits;
        if (r1 <= r2) goto L6;
        if (r0.compareAndSet(this, r1, r2) == false) goto L2;
        return;
    }

    private final boolean addAcquireToQueue(Waiter r17) {
        AtomicReferenceFieldUpdater r2 = tail$FU;
        SemaphoreSegment r3 = (SemaphoreSegment) r2.get(this);
        long r4 = enqIdx$FU.getAndIncrement(this);
        SemaphoreImpl$addAcquireToQueue$createNewSegment$1 r6 = SemaphoreImpl$addAcquireToQueue$createNewSegment$1.INSTANCE;
        long r7 = r4 / ((long) SemaphoreKt.access$getSEGMENT_SIZE$p());
    L3:
        Object r9 = ConcurrentLinkedListKt.findSegmentInternal(r3, r7, r6);
        if (SegmentOrClosed.m3075isClosedimpl(r9) == true) goto L22;
        Segment r10 = SegmentOrClosed.m3073getSegmentimpl(r9);
    L6:
        Segment r13 = (Segment) r2.get(this);
        if (r13.id >= r10.id) goto L8;
        if (r10.tryIncPointers$kotlinx_coroutines_core() == false) goto L11;
        if (r2.compareAndSet(this, r13, r10) == true) goto L15;
        if (r10.decPointers$kotlinx_coroutines_core() == false) goto L6;
        r10.remove();
        goto L6
    L15:
        if (r13.decPointers$kotlinx_coroutines_core() == false) goto L8;
        r13.remove();
        goto L8
    L11:
        boolean r11 = false;
    L17:
        if (r11 == false) goto L3;
    L8:
        r11 = true;
    L22:
        SemaphoreSegment r5 = (SemaphoreSegment) SegmentOrClosed.m3073getSegmentimpl(r9);
        int r8 = (int) (r4 % ((long) SemaphoreKt.access$getSEGMENT_SIZE$p()));
        if (r5.getAcquirers().compareAndSet(r8, null, r17) == false) goto L27;
        r17.invokeOnCancellation(r5, r8);
        return true;
    L27:
        if (r5.getAcquirers().compareAndSet(r8, SemaphoreKt.access$getPERMIT$p(), SemaphoreKt.access$getTAKEN$p()) == false) goto L39;
        if ((r17 instanceof CancellableContinuation) == false) goto L33;
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        ((CancellableContinuation) r17).resume(Unit.INSTANCE, this.onCancellationRelease);
        return true;
    L33:
        if ((r17 instanceof SelectInstance) == false) goto L37;
        ((SelectInstance) r17).selectInRegistrationPhase(Unit.INSTANCE);
        return true;
    L37:
        throw new IllegalStateException(("unexpected: " + r17).toString());
    L39:
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L41;
        return false;
    L41:
        if (r5.getAcquirers().get(r8) != SemaphoreKt.access$getBROKEN$p()) goto L43;
        boolean r12 = true;
    L44:
        if (r12 == false) goto L47;
        return false;
    L47:
        throw new AssertionError();
    L43:
        r12 = false;
        goto L44
    }

    private final boolean tryResumeNextFromQueue() {
        AtomicReferenceFieldUpdater r1 = head$FU;
        SemaphoreSegment r2 = (SemaphoreSegment) r1.get(this);
        long r3 = deqIdx$FU.getAndIncrement(this);
        long r5 = r3 / ((long) SemaphoreKt.access$getSEGMENT_SIZE$p());
        SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 r7 = SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1.INSTANCE;
    L3:
        Object r8 = ConcurrentLinkedListKt.findSegmentInternal(r2, r5, r7);
        if (SegmentOrClosed.m3075isClosedimpl(r8) == true) goto L22;
        Segment r9 = SegmentOrClosed.m3073getSegmentimpl(r8);
    L6:
        Segment r12 = (Segment) r1.get(this);
        if (r12.id >= r9.id) goto L8;
        if (r9.tryIncPointers$kotlinx_coroutines_core() == false) goto L11;
        if (r1.compareAndSet(this, r12, r9) == true) goto L15;
        if (r9.decPointers$kotlinx_coroutines_core() == false) goto L6;
        r9.remove();
        goto L6
    L15:
        if (r12.decPointers$kotlinx_coroutines_core() == false) goto L8;
        r12.remove();
        goto L8
    L11:
        boolean r10 = false;
    L17:
        if (r10 == false) goto L3;
    L8:
        r10 = true;
    L22:
        SemaphoreSegment r4 = (SemaphoreSegment) SegmentOrClosed.m3073getSegmentimpl(r8);
        r4.cleanPrev();
        if (r4.id <= r5) goto L26;
        return false;
    L26:
        int r6 = (int) (r3 % ((long) SemaphoreKt.access$getSEGMENT_SIZE$p()));
        Object r11 = r4.getAcquirers().getAndSet(r6, SemaphoreKt.access$getPERMIT$p());
        if (r11 != null) goto L38;
        int r0 = SemaphoreKt.access$getMAX_SPIN_CYCLES$p();
        int r13 = 0;
    L29:
        if (r13 >= r0) goto L36;
        if (r4.getAcquirers().get(r6) == SemaphoreKt.access$getTAKEN$p()) goto L32;
        r13 = r13 + 1;
        goto L29
    L32:
        return true;
    L36:
        return !r4.getAcquirers().compareAndSet(r6, SemaphoreKt.access$getPERMIT$p(), SemaphoreKt.access$getBROKEN$p());
    L38:
        if (r11 != SemaphoreKt.access$getCANCELLED$p()) goto L42;
        return false;
    L42:
        return tryResumeAcquire(r11);
    }

    private final boolean tryResumeAcquire(Object r3) {
        if ((r3 instanceof CancellableContinuation) == false) goto L9;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        CancellableContinuation r4 = (CancellableContinuation) r3;
        Object r2 = r4.tryResume(Unit.INSTANCE, null, this.onCancellationRelease);
        if (r2 == null) goto L7;
        r4.completeResume(r2);
        return true;
    L7:
        return false;
    L9:
        if ((r3 instanceof SelectInstance) == false) goto L13;
        return ((SelectInstance) r3).trySelect(this, Unit.INSTANCE);
    L13:
        throw new IllegalStateException(("unexpected: " + r3).toString());
    }

    private final Object acquireSlowPath(Continuation<? super Unit> r3) {
        CancellableContinuationImpl r0 = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(r3));
    L14:
        th = move-exception;
        r0.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
        throw th;
    L4:
        if (access$addAcquireToQueue(this, r0) == true) goto L6;
        acquire(r0);     // Catch: Throwable -> L14
    L6:
        Object r2 = r0.getResult();
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        DebugProbesKt.probeCoroutineSuspended(r3);
    L10:
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r2;
    L13:
        return Unit.INSTANCE;
    }

    protected final void acquire(CancellableContinuation<? super Unit> r2) {
    L3:
        if (decPermits() > 0) goto L4;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
        if (addAcquireToQueue((Waiter) r2) == false) goto L3;
        return;
    L4:
        r2.resume(Unit.INSTANCE, this.onCancellationRelease);
    }

    protected final void onAcquireRegFunction(SelectInstance<?> r1, Object r2) {
    L3:
        if (decPermits() > 0) goto L4;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
        if (addAcquireToQueue((Waiter) r1) == false) goto L3;
        return;
    L4:
        r1.selectInRegistrationPhase(Unit.INSTANCE);
    }
}
