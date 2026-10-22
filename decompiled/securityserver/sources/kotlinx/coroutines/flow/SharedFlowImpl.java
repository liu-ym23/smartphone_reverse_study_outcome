package kotlinx.coroutines.flow;

import java.util.Arrays;
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
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class SharedFlowImpl<T> extends AbstractSharedFlow<SharedFlowSlot> implements MutableSharedFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    public Object[] f;
    public long i;
    public long j;
    public int k;
    public int l;

    @Metadata
    public static final class Emitter implements DisposableHandle {
        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            throw null;
        }
    }

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[BufferOverflow.values().length];
            r0[0] = 1;
            r0[2] = 2;
            r0[1] = 3;
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object a(FlowCollector r13, Continuation r14) {
        if ((r14 instanceof SharedFlowImpl$collect$1) == false) goto L7;
        SharedFlowImpl$collect$1 r0 = (SharedFlowImpl$collect$1) r14;
        int r1 = r0.i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.i = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.f;
        CoroutineSingletons r2 = CoroutineSingletons.b;
        int r3 = r0.i;
        if (r3 == 0) goto L26;
        if (r3 == 1) goto L21;
        if (r3 == 2) goto L20;
        if (r3 != 3) goto L19;
        Job r12 = r0.n;
        SharedFlowSlot r16 = (SharedFlowSlot) r0.m;
        FlowCollector r4 = r0.l;
        SharedFlowImpl<T> r6 = (SharedFlowImpl) r0.k;
    L71:
        ResultKt.b(r15);     // Catch: Throwable -> L16
        FlowCollector r17 = r4;
        Job r5 = r12;
        SharedFlowImpl<T> this = r6;
    L37:
        Object r7 = this.n(r16);     // Catch: Throwable -> L49
        if (r7 != SharedFlowKt.f397a) goto L39;
        r0.k = this;     // Catch: Throwable -> L49
        r0.l = r17;     // Catch: Throwable -> L49
        r0.m = r16;     // Catch: Throwable -> L49
        r0.n = r5;     // Catch: Throwable -> L49
        r0.o = r7;     // Catch: Throwable -> L49
        r0.i = 2;     // Catch: Throwable -> L49
        CancellableContinuationImpl r8 = new CancellableContinuationImpl(1, IntrinsicsKt.b(r0));     // Catch: Throwable -> L49
        r8.D();     // Catch: Throwable -> L49
        monitor-enter(this);     // Catch: Throwable -> L49
        if (this.m(r16) >= 0) goto L56;
        r16.b = r8;     // Catch: Throwable -> L61
    L57:
        monitor-exit(this);     // Catch: Throwable -> L49
        if (r8.s() != r2) goto L37;
        return r2;
    L56:
        r8.k(Unit.f330a);     // Catch: Throwable -> L61
        goto L57
    L61:
        th = move-exception;
        throw th;     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        r6 = this;
        Throwable th = th;
    L64:
        r6.g(r16);
        throw th;
    L39:
        if (r5 != null) goto L41;
    L46:
        r0.k = this;     // Catch: Throwable -> L49
        r0.l = r17;     // Catch: Throwable -> L49
        r0.m = r16;     // Catch: Throwable -> L49
        r0.n = r5;     // Catch: Throwable -> L49
        r0.o = r7;     // Catch: Throwable -> L49
        r0.i = 3;     // Catch: Throwable -> L49
        if (r17.d(r7, r0) != r2) goto L37;
        return r2;
    L41:
        if (r5.isActive() == true) goto L46;
        throw r5.q();     // Catch: Throwable -> L49
    L16:
        th = th;
        goto L64
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        r12 = r0.n;
        r16 = (SharedFlowSlot) r0.m;
        r4 = r0.l;
        r6 = (SharedFlowImpl) r0.k;
        goto L71
    L21:
        r16 = (SharedFlowSlot) r0.m;
        FlowCollector r18 = r0.l;
        SharedFlowImpl<T> r9 = (SharedFlowImpl) r0.k;
        ResultKt.b(r15);     // Catch: Throwable -> L24
        r17 = r18;
        this = r9;
    L70:
        CoroutineContext r10 = r0.c;     // Catch: Throwable -> L49
        Intrinsics.c(r10);     // Catch: Throwable -> L49
        r5 = (Job) r10.f(Job.g);     // Catch: Throwable -> L49
    L24:
        th = th;
        r6 = r9;
        goto L64
    L26:
        ResultKt.b(r15);
        SharedFlowSlot r19 = (SharedFlowSlot) c();
    L33:
        th = move-exception;
        r6 = this;
        th = th;
        r16 = r19;
        goto L64
    L28:
        if ((r13 instanceof SubscribedFlowCollector) == false) goto L35;
        r0.k = this;     // Catch: Throwable -> L33
        r0.l = r13;     // Catch: Throwable -> L33
        r0.m = r19;     // Catch: Throwable -> L33
        r0.i = 1;     // Catch: Throwable -> L33
        ((SubscribedFlowCollector) r13).a(r0);     // Catch: Throwable -> L33
        if (Unit.f330a != r2) goto L35;
        return r2;
    L35:
        r17 = r13;
        r16 = r19;
    L7:
        r0 = new SharedFlowImpl$collect$1(this, r14);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public final Flow b(CoroutineContext r1, int r2, BufferOverflow r3) {
        return SharedFlowKt.b(this, r1, r2, r3);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object d(Object r1, Continuation r2) {
        l(r1);
        return Unit.f330a;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public final AbstractSharedFlowSlot e() {
        SharedFlowSlot r2 = new SharedFlowSlot();
        r2.f398a = -1;
        return r2;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public final AbstractSharedFlowSlot[] f() {
        return new SharedFlowSlot[2];
    }

    public final void h() {
        if (this.l > 1) goto L5;
        return;
    L5:
        Object[] r0 = this.f;
        Intrinsics.c(r0);
    L7:
        if (this.l <= 0) goto L11;
        long r2 = j();
        int r4 = this.k;
        int r5 = this.l;
        if (r0[((int) ((r2 + ((long) (r4 + r5))) - 1)) & (r0.length - 1)] != SharedFlowKt.f397a) goto L14;
        this.l = r5 - 1;
        SharedFlowKt.a(r0, j() + ((long) (this.k + this.l)), null);
        goto L7
    L14:
        return;
    }

    public final Continuation[] i(Continuation[] r11) {
        int r0 = r11.length;
        if (this.c == 0) goto L21;
        AbstractSharedFlowSlot[] r1 = this.b;
        if (r1 == null) goto L21;
        int r2 = r1.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L21;
        AbstractSharedFlowSlot r4 = r1[r3];
        if (r4 == null) goto L20;
        SharedFlowSlot r5 = (SharedFlowSlot) r4;
        CancellableContinuationImpl r6 = r5.b;
        if (r6 == null) goto L20;
        if (m(r5) < 0) goto L20;
        if (r0 < r11.length) goto L19;
        Object[] r12 = Arrays.copyOf(r11, Math.max(2, r11.length * 2));
        Intrinsics.e(r12, "java.util.Arrays.copyOf(this, newSize)");
        r11 = (Continuation[]) r12;
    L19:
        r11[r0] = r6;
        r5.b = null;
        r0 = r0 + 1;
    L20:
        r3 = r3 + 1;
    L21:
        return r11;
    }

    public final long j() {
        return Math.min(this.j, this.i);
    }

    public final Object[] k(Object[] r8, int r9, int r10) {
        int r0 = 0;
        if (r10 <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L15;
        Object[] r11 = new Object[r10];
        this.f = r11;
        if (r8 != null) goto L10;
        return r11;
    L10:
        long r3 = j();
    L11:
        if (r0 >= r9) goto L13;
        long r4 = ((long) r0) + r3;
        SharedFlowKt.a(r11, r4, r8[((int) r4) & (r8.length - 1)]);
        r0 = r0 + 1;
        goto L11
    L13:
        return r11;
    L15:
        throw new IllegalStateException("Buffer size overflow".toString());
    L5:
        r2 = false;
        goto L6
    }

    public final void l(Object r17) {
        Continuation[] r0 = AbstractSharedFlowKt.f402a;
        monitor-enter(this);
        int r11 = 0;
        if (this.c != 0) goto L7;
        boolean r1 = DebugKt.f370a;     // Catch: Throwable -> L55
    L46:
        Continuation[] r2 = i(r0);     // Catch: Throwable -> L55
        monitor-exit(this);
        int r3 = r2.length;
    L49:
        if (r11 >= r3) goto L54;
        Continuation r4 = r2[r11];
        if (r4 == null) goto L53;
        r4.k(Unit.f330a);
    L53:
        r11 = r11 + 1;
        goto L49
    L54:
        return;
    L7:
        int r5 = this.k;     // Catch: Throwable -> L55
        if (r5 >= 0) goto L10;
    L13:
        int r6 = r5 + this.l;     // Catch: Throwable -> L55
        Object[] r7 = this.f;     // Catch: Throwable -> L55
        if (r7 != null) goto L17;
        r7 = k(null, 0, 2);     // Catch: Throwable -> L55
    L19:
        SharedFlowKt.a(r7, j() + ((long) r6), r17);     // Catch: Throwable -> L55
        int r8 = this.k + 1;     // Catch: Throwable -> L55
        this.k = r8;     // Catch: Throwable -> L55
        if (r8 <= 0) goto L43;
        Object[] r9 = this.f;     // Catch: Throwable -> L55
        Intrinsics.c(r9);     // Catch: Throwable -> L55
        SharedFlowKt.a(r9, j(), null);     // Catch: Throwable -> L55
        this.k--;     // Catch: Throwable -> L55
        long r10 = j() + 1;     // Catch: Throwable -> L55
        if (this.i >= r10) goto L25;
        this.i = r10;     // Catch: Throwable -> L55
    L25:
        if (this.j < r10) goto L27;
    L42:
        boolean r12 = DebugKt.f370a;     // Catch: Throwable -> L55
        goto L43
    L27:
        if (this.c == 0) goto L41;
        AbstractSharedFlowSlot[] r13 = this.b;     // Catch: Throwable -> L55
        if (r13 == null) goto L41;
        int r14 = r13.length;     // Catch: Throwable -> L55
        int r15 = 0;
    L32:
        if (r15 >= r14) goto L41;
        AbstractSharedFlowSlot r16 = r13[r15];     // Catch: Throwable -> L55
        if (r16 == null) goto L40;
        SharedFlowSlot r18 = (SharedFlowSlot) r16;     // Catch: Throwable -> L55
        long r19 = r18.f398a;     // Catch: Throwable -> L55
        if (r19 < 0) goto L40;
        if (r19 >= r10) goto L40;
        r18.f398a = r10;     // Catch: Throwable -> L55
    L40:
        r15 = r15 + 1;     // Catch: Throwable -> L55
    L41:
        this.j = r10;     // Catch: Throwable -> L55
    L43:
        long r20 = j() + ((long) this.k);     // Catch: Throwable -> L55
        long r21 = this.i;     // Catch: Throwable -> L55
        if (((int) (r20 - r21)) <= 0) goto L46;
        o(r21 + 1, this.j, j() + ((long) this.k), (j() + ((long) this.k)) + ((long) this.l));     // Catch: Throwable -> L55
        goto L46
    L17:
        if (r6 < r7.length) goto L19;
        r7 = k(r7, r6, r7.length * 2);     // Catch: Throwable -> L55
        goto L19
    L10:
        if (this.j > this.i) goto L13;
        throw null;     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        throw th;
    }

    public final long m(SharedFlowSlot r7) {
        long r0 = r7.f398a;
        if (r0 >= (j() + ((long) this.k))) goto L6;
        return r0;
    L6:
        if (r0 <= j()) goto L9;
        return -1;
    L9:
        if (this.l != 0) goto L11;
        return -1;
    L11:
        return r0;
    }

    public final Object n(SharedFlowSlot r9) {
        Continuation[] r0 = AbstractSharedFlowKt.f402a;
        monitor-enter(this);
        long r1 = m(r9);     // Catch: Throwable -> L7
        if (r1 >= 0) goto L9;
        Object r10 = SharedFlowKt.f397a;     // Catch: Throwable -> L7
    L13:
        monitor-exit(this);
        int r8 = r0.length;
        int r2 = 0;
    L15:
        if (r2 >= r8) goto L20;
        Continuation r3 = r0[r2];
        if (r3 == null) goto L19;
        r3.k(Unit.f330a);
    L19:
        r2 = r2 + 1;
        goto L15
    L20:
        return r10;
    L9:
        long r4 = r9.f398a;     // Catch: Throwable -> L7
        Object[] r5 = this.f;     // Catch: Throwable -> L7
        Intrinsics.c(r5);     // Catch: Throwable -> L7
        Object r6 = r5[((int) r1) & (r5.length - 1)];     // Catch: Throwable -> L7
        if ((r6 instanceof Emitter) == true) goto L22;
        r9.f398a = r1 + 1;     // Catch: Throwable -> L7
        r0 = p(r4);     // Catch: Throwable -> L7
        r10 = r6;
        goto L13
    L22:
        throw null;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public final void o(long r7, long r9, long r11, long r13) {
        long r0 = Math.min(r9, r7);
        boolean r2 = DebugKt.f370a;
        long r3 = j();
    L4:
        if (r3 >= r0) goto L6;
        Object[] r4 = this.f;
        Intrinsics.c(r4);
        SharedFlowKt.a(r4, r3, null);
        r3 = r3 + 1;
        goto L4
    L6:
        this.i = r7;
        this.j = r9;
        this.k = (int) (r11 - r0);
        this.l = (int) (r13 - r11);
        boolean r6 = DebugKt.f370a;
    }

    public final Continuation[] p(long r19) {
        boolean r0 = DebugKt.f370a;
        long r1 = this.j;
        Continuation[] r2 = AbstractSharedFlowKt.f402a;
        if (r19 <= r1) goto L5;
        return r2;
    L5:
        long r3 = j();
        long r4 = ((long) this.k) + r3;
        if (this.l <= 0) goto L9;
        r4 = r4 + 1;
    L9:
        if (this.c == 0) goto L23;
        AbstractSharedFlowSlot[] r5 = this.b;
        if (r5 == null) goto L23;
        int r8 = r5.length;
        int r12 = 0;
    L14:
        if (r12 >= r8) goto L23;
        AbstractSharedFlowSlot r13 = r5[r12];
        if (r13 == null) goto L22;
        long r14 = ((SharedFlowSlot) r13).f398a;
        if (r14 < 0) goto L22;
        if (r14 >= r4) goto L22;
        r4 = r14;
    L22:
        r12 = r12 + 1;
    L23:
        boolean r6 = DebugKt.f370a;
        if (r4 > this.j) goto L26;
        return r2;
    L26:
        long r15 = j() + ((long) this.k);
        if (this.c <= 0) goto L29;
        int r7 = Math.min(this.l, 0 - ((int) (r15 - r4)));
    L30:
        long r16 = ((long) this.l) + r15;
        Symbol r9 = SharedFlowKt.f397a;
        if (r7 <= 0) goto L44;
        r2 = new Continuation[r7];
        Object[] r10 = this.f;
        Intrinsics.c(r10);
        long r17 = r15;
        long r11 = r17;
    L34:
        if (r11 >= r16) goto L43;
        Object r18 = r10[(r10.length - 1) & ((int) r11)];
        if (r18 != r9) goto L37;
        r11 = r11 + 1;
        goto L34
    L37:
        if (r18 == null) goto L41;
        Emitter r20 = (Emitter) r18;
        throw null;
    L41:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
    L43:
        Continuation[] r110 = r2;
        int r21 = (int) (r17 - r3);
        if (this.c != 0) goto L48;
        long r22 = r17;
    L49:
        boolean r111 = false;
        long r23 = Math.max(this.i, r17 - ((long) Math.min(0, r21)));
        if (r23 >= r16) goto L54;
        Object[] r24 = this.f;
        Intrinsics.c(r24);
        if (Intrinsics.a(r24[((int) r23) & (r24.length - 1)], r9) == false) goto L54;
        long r25 = r23 + 1;
        long r26 = r17 + 1;
    L55:
        o(r25, r22, r26, r16);
        h();
        if (r110.length != 0) goto L59;
        r111 = true;
    L59:
        if ((!r111) == true) goto L61;
        return r110;
    L61:
        return i(r110);
    L54:
        r25 = r23;
        r26 = r17;
        goto L55
    L48:
        r22 = r4;
        goto L49
    L44:
        r17 = r15;
        goto L43
    L29:
        r7 = this.l;
        goto L30
    }
}
