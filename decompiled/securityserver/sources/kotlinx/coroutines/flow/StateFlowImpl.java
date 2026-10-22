package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    private volatile Object _state;
    public int f;

    public StateFlowImpl(Object r1) {
        this._state = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0046: MOVE (r1 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY]), block:B:17:0x0046 */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.util.concurrent.atomic.AtomicReferenceFieldUpdater] */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2, types: [kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00f3 -> B:35:0x00a4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x011c -> B:35:0x00a4). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    public final Object a(FlowCollector r18, Continuation r19) {
        StateFlowImpl<T> r1 = this;
        FlowCollector r0 = r18;
        if ((r19 instanceof StateFlowImpl$collect$1) == false) goto L7;
        StateFlowImpl$collect$1 r3 = (StateFlowImpl$collect$1) r19;
        int r4 = r3.i;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.i = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f;
        CoroutineSingletons r5 = CoroutineSingletons.b;
        ?? r6 = r3.i;
        Unit r7 = Unit.f330a;
        if (r6 == 0) goto L28;
        if (r6 != 1) goto L68;
        StateFlowSlot r8 = (StateFlowSlot) r3.m;
        r0 = r3.l;
        r1 = (StateFlowImpl) r3.k;
        ResultKt.b(r2);     // Catch: Throwable -> L26
        StateFlowSlot r9 = r8;
    L34:
        CoroutineContext r10 = r3.c;     // Catch: Throwable -> L26
        Intrinsics.c(r10);     // Catch: Throwable -> L26
        Job r11 = (Job) r10.f(Job.g);     // Catch: Throwable -> L26
        FlowCollector r12 = r0;
        Object r13 = null;
        r6 = r9;
    L35:
        Object r14 = r1._state;     // Catch: Throwable -> L26
        if (r11 != null) goto L38;
    L42:
        if (r13 == null) goto L46;
        ?? r15 = r6;
        if ((!r13.equals(r14)) == true) goto L46;
    L54:
        r15.getClass();     // Catch: Throwable -> L26
        Symbol r16 = StateFlowKt.f400a;     // Catch: Throwable -> L26
        ?? r17 = StateFlowSlot.f401a;     // Catch: Throwable -> L26
        Object r110 = r17.getAndSet(r15, r16);     // Catch: Throwable -> L26
        Intrinsics.c(r110);     // Catch: Throwable -> L26
        boolean r111 = DebugKt.f370a;     // Catch: Throwable -> L26
        if (r110 != StateFlowKt.b) goto L57;
        r6 = r15;
        goto L35
    L57:
        r3.k = r1;     // Catch: Throwable -> L26
        r3.l = r12;     // Catch: Throwable -> L26
        r3.m = r15;     // Catch: Throwable -> L26
        r3.n = r11;     // Catch: Throwable -> L26
        r3.o = r13;     // Catch: Throwable -> L26
        r3.p = r14;     // Catch: Throwable -> L26
        r3.i = 3;     // Catch: Throwable -> L26
        CancellableContinuationImpl r20 = new CancellableContinuationImpl(1, IntrinsicsKt.b(r3));     // Catch: Throwable -> L26
        r20.D();     // Catch: Throwable -> L26
        if (r17.compareAndSet(r15, r16, r20) == true) goto L61;
        r20.k(r7);     // Catch: Throwable -> L26
    L61:
        r6 = r15;
        if (r20.s() != r5) goto L35;
        return r5;
    L46:
        if (r14 != NullSurrogateKt.f403a) goto L48;
        Object r112 = null;
    L49:
        r3.k = r1;     // Catch: Throwable -> L26
        r3.l = r12;     // Catch: Throwable -> L26
        r3.m = r6;     // Catch: Throwable -> L26
        r3.n = r11;     // Catch: Throwable -> L26
        r3.o = r13;     // Catch: Throwable -> L26
        r3.p = r14;     // Catch: Throwable -> L26
        r3.i = 2;     // Catch: Throwable -> L26
        if (r12.d(r112, r3) != r5) goto L52;
        return r5;
    L52:
        r13 = r14;
        StateFlowImpl<T> r113 = r1;
        Job r21 = r11;
        ?? r22 = r6;
    L53:
        r11 = r21;
        r1 = r113;
        r14 = r13;
        r15 = r22;
        goto L54
    L48:
        r112 = r14;
        goto L49
    L38:
        if (r11.isActive() == true) goto L42;
        throw r11.q();     // Catch: Throwable -> L26
    L68:
        if (r6 == 2) goto L20;
        if (r6 != 3) goto L19;
        r13 = r3.o;
        Job r23 = r3.n;
        StateFlowSlot r24 = (StateFlowSlot) r3.m;
        r12 = r3.l;
        StateFlowImpl<T> r114 = (StateFlowImpl) r3.k;
        ResultKt.b(r2);     // Catch: Throwable -> L16
        r11 = r23;
        r1 = r114;
        r6 = r24;
        goto L35
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        r13 = r3.p;
        r21 = r3.n;
        StateFlowSlot r25 = (StateFlowSlot) r3.m;
        r12 = r3.l;
        r113 = (StateFlowImpl) r3.k;
        ResultKt.b(r2);     // Catch: Throwable -> L16
        r22 = r25;
    L16:
        th = th;
        r1 = r12;
    L64:
        r1.g(r6);
        throw th;
    L28:
        ResultKt.b(r2);
        StateFlowSlot r26 = (StateFlowSlot) c();
        r9 = r26;
        if ((r0 instanceof SubscribedFlowCollector) == false) goto L34;
        r3.k = r1;     // Catch: Throwable -> L26
        r3.l = r0;     // Catch: Throwable -> L26
        r3.m = r26;     // Catch: Throwable -> L26
        r3.i = 1;     // Catch: Throwable -> L26
        ((SubscribedFlowCollector) r0).a(r3);     // Catch: Throwable -> L26
        r9 = r26;
        if (r7 != r5) goto L34;
        return r5;
    L26:
        th = th;
    L7:
        r3 = new StateFlowImpl$collect$1(r1, r19);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public final Flow b(CoroutineContext r2, int r3, BufferOverflow r4) {
        boolean r0 = DebugKt.f370a;
        if (r3 < 0) goto L7;
        if (1 < r3) goto L7;
    L9:
        if (r4 != BufferOverflow.c) goto L12;
        return this;
    L12:
        return SharedFlowKt.b(this, r2, r3, r4);
    L7:
        if (r3 != (-2)) goto L12;
        goto L9
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object d(Object r1, Continuation r2) {
        setValue(r1);
        return Unit.f330a;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public final AbstractSharedFlowSlot e() {
        StateFlowSlot r1 = new StateFlowSlot();
        r1._state = null;
        return r1;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public final AbstractSharedFlowSlot[] f() {
        return new StateFlowSlot[2];
    }

    public final Object h() {
        Symbol r0 = NullSurrogateKt.f403a;
        Object r1 = this._state;
        if (r1 != r0) goto L6;
        return null;
    L6:
        return r1;
    }

    public final boolean i(Object r10, Object r11) {
        StateFlowSlot[] r0 = (StateFlowSlot[]) this.b;
        monitor-enter(this);
        Object r1 = this._state;     // Catch: Throwable -> L11
        if (r10 == null) goto L14;
        if ((!Intrinsics.a(r1, r10)) == false) goto L14;
        monitor-exit(this);
        return false;
    L14:
        if (Intrinsics.a(r1, r11) == false) goto L17;
        monitor-exit(this);
        return true;
    L17:
        this._state = r11;     // Catch: Throwable -> L11
        int r12 = this.f;     // Catch: Throwable -> L11
        if ((r12 & 1) != 0) goto L55;
        int r13 = r12 + 1;     // Catch: Throwable -> L11
        this.f = r13;     // Catch: Throwable -> L11
        StateFlowSlot[] r14 = (StateFlowSlot[]) this.b;     // Catch: Throwable -> L11
        monitor-exit(this);
    L21:
        if (r14 == null) goto L41;
        int r2 = r14.length;
        int r3 = 0;
    L23:
        if (r3 >= r2) goto L41;
        StateFlowSlot r4 = r14[r3];
        if (r4 == null) goto L40;
    L26:
        Object r5 = r4._state;
        if (r5 == null) goto L40;
        Symbol r6 = StateFlowKt.b;
        if (r5 == r6) goto L40;
        Symbol r7 = StateFlowKt.f400a;
        if (r5 == r7) goto L35;
        if (StateFlowSlot.f401a.compareAndSet(r4, r5, r7) == false) goto L26;
        ((CancellableContinuationImpl) r5).k(Unit.f330a);
        goto L40
    L35:
        if (StateFlowSlot.f401a.compareAndSet(r4, r5, r6) == false) goto L26;
    L40:
        r3 = r3 + 1;
    L41:
        monitor-enter(this);
        int r15 = this.f;     // Catch: Throwable -> L47
        if (r15 == r13) goto L44;
        StateFlowSlot[] r16 = (StateFlowSlot[]) this.b;     // Catch: Throwable -> L47
        monitor-exit(this);
        r14 = r16;
        r13 = r15;
        goto L21
    L44:
        this.f = r13 + 1;     // Catch: Throwable -> L47
        monitor-exit(this);
        return true;
    L47:
        th = move-exception;
        throw th;
    L55:
        this.f = r12 + 2;     // Catch: Throwable -> L11
        monitor-exit(this);
        return true;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public final void setValue(Object r2) {
        if (r2 != null) goto L5;
        r2 = NullSurrogateKt.f403a;
    L5:
        i(null, r2);
    }
}
