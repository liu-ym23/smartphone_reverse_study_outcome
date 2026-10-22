package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: StateFlow.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0013B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ)\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f0\u000b2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0002J\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowSlot;", "<init>", "()V", "Lkotlinx/coroutines/flow/StateFlowImpl;", "flow", "", "allocateLocked", "(Lkotlinx/coroutines/flow/StateFlowImpl;)Z", "", "awaitPending", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lkotlin/coroutines/Continuation;", "freeLocked", "(Lkotlinx/coroutines/flow/StateFlowImpl;)[Lkotlin/coroutines/Continuation;", "makePending", "takePending", "()Z", "kotlinx-coroutines-core", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class StateFlowSlot extends AbstractSharedFlowSlot<StateFlowImpl<?>> {
    static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU = null;
    volatile /* synthetic */ Object _state;

    static {
        _state$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowSlot.class, Object.class, "_state");
    }

    public StateFlowSlot() {
        this._state = null;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public /* bridge */ /* synthetic */ boolean allocateLocked(StateFlowImpl<?> r1) {
        return allocateLocked2(r1);
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public /* bridge */ /* synthetic */ Continuation[] freeLocked(StateFlowImpl<?> r1) {
        return freeLocked2(r1);
    }

    /* JADX INFO: renamed from: allocateLocked, reason: avoid collision after fix types in other method */
    public boolean allocateLocked2(StateFlowImpl<?> r1) {
        if (this._state == null) goto L6;
        return false;
    L6:
        this._state = StateFlowKt.access$getNONE$p();
        return true;
    }

    /* JADX INFO: renamed from: freeLocked, reason: avoid collision after fix types in other method */
    public Continuation<Unit>[] freeLocked2(StateFlowImpl<?> r1) {
        this._state = null;
        return AbstractSharedFlowKt.EMPTY_RESUMES;
    }

    public final boolean takePending() {
        Object r2 = _state$FU.getAndSet(this, StateFlowKt.access$getNONE$p());
        Intrinsics.checkNotNull(r2);
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L10;
        if ((!(r2 instanceof CancellableContinuationImpl)) == true) goto L10;
        throw new AssertionError();
    L10:
        if (r2 == StateFlowKt.access$getPENDING$p()) goto L14;
        return false;
    L14:
        return true;
    }

    public final void makePending() {
    L2:
        Object r0 = this._state;
        if (r0 == null) goto L4;
        if (r0 == StateFlowKt.access$getPENDING$p()) goto L7;
        if (r0 == StateFlowKt.access$getNONE$p()) goto L11;
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r0, StateFlowKt.access$getNONE$p()) == false) goto L2;
        Result.Companion r3 = Result.Companion;
        ((CancellableContinuationImpl) r0).resumeWith(Result.m774constructorimpl(Unit.INSTANCE));
        return;
    L11:
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r0, StateFlowKt.access$getPENDING$p()) == false) goto L2;
        return;
    L7:
        return;
    }

    public final Object awaitPending(Continuation<? super Unit> r6) {
        boolean r2 = true;
        CancellableContinuationImpl r0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r6), 1);
        r0.initCancellability();
        CancellableContinuationImpl r1 = r0;
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L10;
        if ((!(this._state instanceof CancellableContinuationImpl)) == true) goto L10;
        throw new AssertionError();
    L10:
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, StateFlowKt.access$getNONE$p(), r1) == false) goto L12;
    L22:
        Object r5 = r0.getResult();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L26:
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        return r5;
    L29:
        return Unit.INSTANCE;
    L12:
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L14;
    L21:
        Result.Companion r7 = Result.Companion;
        r1.resumeWith(Result.m774constructorimpl(Unit.INSTANCE));
        goto L22
    L14:
        if (this._state == StateFlowKt.access$getPENDING$p()) goto L17;
        r2 = false;
    L17:
        if (r2 == true) goto L21;
        throw new AssertionError();
    }
}
