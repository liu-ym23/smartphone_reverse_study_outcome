package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: Semaphore.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0002\u0018\u00002\u00020\u001eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\bJ\u001d\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u00060\nH\u0002¢\u0006\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00060\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreImpl;", "", "permits", "acquiredPermits", "<init>", "(II)V", "", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireSlowPath", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "", "addAcquireToQueue", "(Lkotlinx/coroutines/CancellableContinuation;)Z", "release", "()V", "tryAcquire", "()Z", "tryResumeNextFromQueue", "tryResumeAcquire", "getAvailablePermits", "()I", "availablePermits", "Lkotlin/Function1;", "", "onCancellationRelease", "Lkotlin/jvm/functions/Function1;", "I", "kotlinx-coroutines-core", "Lkotlinx/coroutines/sync/Semaphore;"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class SemaphoreImpl implements Semaphore {
    static final /* synthetic */ AtomicIntegerFieldUpdater _availablePermits$FU = null;
    private static final /* synthetic */ AtomicLongFieldUpdater deqIdx$FU = null;
    private static final /* synthetic */ AtomicLongFieldUpdater enqIdx$FU = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater head$FU = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater tail$FU = null;
    volatile /* synthetic */ int _availablePermits;
    private volatile /* synthetic */ long deqIdx;
    private volatile /* synthetic */ long enqIdx;
    private volatile /* synthetic */ Object head;
    private final Function1<Throwable, Unit> onCancellationRelease;
    private final int permits;
    private volatile /* synthetic */ Object tail;

    static {
        head$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head");
        deqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");
        tail$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail");
        enqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");
        _availablePermits$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");
    }

    public SemaphoreImpl(int r6, int r7) {
        this.permits = r6;
        this.deqIdx = 0;
        this.enqIdx = 0;
        boolean r2 = true;
        if (r6 <= 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L17;
        if (r7 < 0) goto L10;
        if (r7 > r6) goto L10;
    L11:
        if (r2 == false) goto L15;
        SemaphoreSegment r3 = new SemaphoreSegment(0, null, 2);
        this.head = r3;
        this.tail = r3;
        this._availablePermits = r6 - r7;
        this.onCancellationRelease = new SemaphoreImpl$onCancellationRelease$1(this);
        return;
    L15:
        throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + r6).toString());
    L10:
        r2 = false;
        goto L11
    L17:
        throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + r6).toString());
    L5:
        r4 = false;
        goto L6
    }

    public static final /* synthetic */ Object access$acquireSlowPath(SemaphoreImpl r0, Continuation r1) {
        return r0.acquireSlowPath(r1);
    }

    public static final /* synthetic */ boolean access$addAcquireToQueue(SemaphoreImpl r0, CancellableContinuation r1) {
        return r0.addAcquireToQueue(r1);
    }

    public static final /* synthetic */ Function1 access$getOnCancellationRelease$p(SemaphoreImpl r0) {
        return r0.onCancellationRelease;
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public int getAvailablePermits() {
        return Math.max(this._availablePermits, 0);
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public Object acquire(Continuation<? super Unit> r2) {
        if (_availablePermits$FU.getAndDecrement(this) > 0) goto L5;
        Object r1 = acquireSlowPath(r2);
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r1;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    private final boolean addAcquireToQueue(CancellableContinuation<? super Unit> r15) {
        SemaphoreSegment r0 = (SemaphoreSegment) this.tail;
        long r1 = enqIdx$FU.getAndIncrement(this);
        long r3 = r1 / ((long) SemaphoreKt.access$getSEGMENT_SIZE$p());
    L3:
        SemaphoreSegment r5 = r0;
    L5:
        if (r5.getId() >= r3) goto L7;
    L10:
        Object r6 = ConcurrentLinkedListNode.access$getNextOrClosed(r5);
        if (r6 == ConcurrentLinkedListKt.access$getCLOSED$p()) goto L12;
        SemaphoreSegment r7 = (Segment) ((ConcurrentLinkedListNode) r6);
        if (r7 != null) goto L53;
        r7 = SemaphoreKt.access$createSegment(r5.getId() + 1, (SemaphoreSegment) r5);
        if (r5.trySetNext(r7) == false) goto L5;
        if (r5.getRemoved() == false) goto L53;
        r5.remove();
    L53:
        r5 = r7;
        goto L5
    L12:
        Object r8 = SegmentOrClosed.m2329constructorimpl(ConcurrentLinkedListKt.access$getCLOSED$p());
    L13:
        boolean r9 = true;
        if (SegmentOrClosed.m2334isClosedimpl(r8) == true) goto L32;
        Segment r10 = SegmentOrClosed.m2332getSegmentimpl(r8);
    L16:
        Segment r11 = (Segment) this.tail;
        if (r11.getId() >= r10.getId()) goto L18;
        if (r10.tryIncPointers$kotlinx_coroutines_core() == false) goto L21;
        if (b0$$ExternalSyntheticBackport0.m(tail$FU, this, r11, r10) == true) goto L25;
        if (r10.decPointers$kotlinx_coroutines_core() == false) goto L16;
        r10.remove();
        goto L16
    L25:
        if (r11.decPointers$kotlinx_coroutines_core() == false) goto L18;
        r11.remove();
        goto L18
    L21:
        boolean r12 = false;
    L27:
        if (r12 == false) goto L3;
    L18:
        r12 = true;
    L32:
        SemaphoreSegment r2 = (SemaphoreSegment) SegmentOrClosed.m2332getSegmentimpl(r8);
        int r4 = (int) (r1 % ((long) SemaphoreKt.access$getSEGMENT_SIZE$p()));
        if (b0$$ExternalSyntheticBackport0.m(r2.acquirers, r4, null, r15) == false) goto L37;
        r15.invokeOnCancellation(new CancelSemaphoreAcquisitionHandler(r2, r4));
        return true;
    L37:
        if (b0$$ExternalSyntheticBackport0.m(r2.acquirers, r4, SemaphoreKt.access$getPERMIT$p(), SemaphoreKt.access$getTAKEN$p()) == false) goto L41;
        r15.resume(Unit.INSTANCE, this.onCancellationRelease);
        return true;
    L41:
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L43;
    L50:
        return false;
    L43:
        if (r2.acquirers.get(r4) == SemaphoreKt.access$getBROKEN$p()) goto L46;
        r9 = false;
    L46:
        if (r9 == true) goto L50;
        throw new AssertionError();
    L7:
        if (r5.getRemoved() == true) goto L10;
        r8 = SegmentOrClosed.m2329constructorimpl(r5);
        goto L13
    }

    private final boolean tryResumeNextFromQueue() {
        SemaphoreSegment r0 = (SemaphoreSegment) this.head;
        long r1 = deqIdx$FU.getAndIncrement(this);
        long r3 = r1 / ((long) SemaphoreKt.access$getSEGMENT_SIZE$p());
    L3:
        SemaphoreSegment r5 = r0;
    L5:
        if (r5.getId() >= r3) goto L7;
    L10:
        Object r6 = ConcurrentLinkedListNode.access$getNextOrClosed(r5);
        if (r6 == ConcurrentLinkedListKt.access$getCLOSED$p()) goto L12;
        SemaphoreSegment r7 = (Segment) ((ConcurrentLinkedListNode) r6);
        if (r7 != null) goto L52;
        r7 = SemaphoreKt.access$createSegment(r5.getId() + 1, (SemaphoreSegment) r5);
        if (r5.trySetNext(r7) == false) goto L5;
        if (r5.getRemoved() == false) goto L52;
        r5.remove();
    L52:
        r5 = r7;
        goto L5
    L12:
        Object r8 = SegmentOrClosed.m2329constructorimpl(ConcurrentLinkedListKt.access$getCLOSED$p());
    L13:
        int r9 = 0;
        if (SegmentOrClosed.m2334isClosedimpl(r8) == true) goto L32;
        Segment r10 = SegmentOrClosed.m2332getSegmentimpl(r8);
    L16:
        Segment r11 = (Segment) this.head;
        if (r11.getId() >= r10.getId()) goto L18;
        if (r10.tryIncPointers$kotlinx_coroutines_core() == false) goto L21;
        if (b0$$ExternalSyntheticBackport0.m(head$FU, this, r11, r10) == true) goto L25;
        if (r10.decPointers$kotlinx_coroutines_core() == false) goto L16;
        r10.remove();
        goto L16
    L25:
        if (r11.decPointers$kotlinx_coroutines_core() == false) goto L18;
        r11.remove();
        goto L18
    L21:
        boolean r12 = false;
    L27:
        if (r12 == false) goto L3;
    L18:
        r12 = true;
    L32:
        SemaphoreSegment r2 = (SemaphoreSegment) SegmentOrClosed.m2332getSegmentimpl(r8);
        r2.cleanPrev();
        if (r2.getId() <= r3) goto L35;
        return false;
    L35:
        int r4 = (int) (r1 % ((long) SemaphoreKt.access$getSEGMENT_SIZE$p()));
        Object r13 = r2.acquirers.getAndSet(r4, SemaphoreKt.access$getPERMIT$p());
        if (r13 != null) goto L46;
        int r14 = SemaphoreKt.access$getMAX_SPIN_CYCLES$p();
    L38:
        if (r9 >= r14) goto L44;
        if (r2.acquirers.get(r4) == SemaphoreKt.access$getTAKEN$p()) goto L41;
        r9 = r9 + 1;
        goto L38
    L41:
        return true;
    L44:
        return !b0$$ExternalSyntheticBackport0.m(r2.acquirers, r4, SemaphoreKt.access$getPERMIT$p(), SemaphoreKt.access$getBROKEN$p());
    L46:
        if (r13 != SemaphoreKt.access$getCANCELLED$p()) goto L49;
        return false;
    L49:
        return tryResumeAcquire((CancellableContinuation) r13);
    L7:
        if (r5.getRemoved() == true) goto L10;
        r8 = SegmentOrClosed.m2329constructorimpl(r5);
        goto L13
    }

    private final boolean tryResumeAcquire(CancellableContinuation<? super Unit> r3) {
        Object r2 = r3.tryResume(Unit.INSTANCE, null, this.onCancellationRelease);
        if (r2 != null) goto L6;
        return false;
    L6:
        r3.completeResume(r2);
        return true;
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public boolean tryAcquire() {
    L2:
        int r0 = this._availablePermits;
        if (r0 <= 0) goto L4;
        if (_availablePermits$FU.compareAndSet(this, r0, r0 - 1) == false) goto L2;
        return true;
    L4:
        return false;
    }

    private final Object acquireSlowPath(Continuation<? super Unit> r4) {
        CancellableContinuationImpl r0 = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(r4));
        CancellableContinuationImpl r1 = r0;
    L4:
        if (access$addAcquireToQueue(this, r1) == true) goto L8;
        if (_availablePermits$FU.getAndDecrement(this) <= 0) goto L4;
        r1.resume(Unit.INSTANCE, access$getOnCancellationRelease$p(this));
    L8:
        Object r3 = r0.getResult();
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L12:
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        return r3;
    L15:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public void release() {
    L2:
        int r0 = this._availablePermits;
        if (r0 >= this.permits) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L15;
        if (_availablePermits$FU.compareAndSet(this, r0, r0 + 1) == false) goto L2;
        if (r0 >= 0) goto L10;
        if (tryResumeNextFromQueue() == false) goto L2;
        return;
    L10:
        return;
    L15:
        throw new IllegalStateException(("The number of released permits cannot be greater than " + this.permits).toString());
    L5:
        r1 = false;
        goto L6
    }
}
