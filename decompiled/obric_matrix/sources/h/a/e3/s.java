package h.a.e3;

import h.a.b2;
import h.a.d1;
import h.a.q0;
import h.a.x1;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.f0;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<T>] */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006:\u0001hB\u001d\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020,2\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020,H\u0002J\u001f\u00103\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u000006H\u0096@ø\u0001\u0000¢\u0006\u0002\u00107J\u0010\u00108\u001a\u00020,2\u0006\u00109\u001a\u00020\u0012H\u0002J\b\u0010:\u001a\u00020\u0003H\u0014J\u001d\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000e2\u0006\u0010<\u001a\u00020\bH\u0014¢\u0006\u0002\u0010=J\b\u0010>\u001a\u00020,H\u0002J\u0019\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010AJ\u0019\u0010B\u001a\u00020,2\u0006\u0010@\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010AJ\u0012\u0010C\u001a\u00020,2\b\u0010D\u001a\u0004\u0018\u00010\u000fH\u0002J1\u0010E\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010F0\u000e2\u0014\u0010G\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010F0\u000eH\u0002¢\u0006\u0002\u0010HJ&\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010N\u001a\u0004\u0018\u00010\u000f2\u0006\u0010O\u001a\u00020\u0012H\u0002J7\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0010\u0010Q\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e2\u0006\u0010R\u001a\u00020\b2\u0006\u0010S\u001a\u00020\bH\u0002¢\u0006\u0002\u0010TJ\b\u0010U\u001a\u00020,H\u0016J\u0015\u0010V\u001a\u00020W2\u0006\u0010@\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010XJ\u0015\u0010Y\u001a\u00020W2\u0006\u0010@\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010XJ\u0015\u0010Z\u001a\u00020W2\u0006\u0010@\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010XJ\u0010\u0010[\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0003H\u0002J\u0012\u0010\\\u001a\u0004\u0018\u00010\u000f2\u0006\u0010-\u001a\u00020\u0003H\u0002J(\u0010]\u001a\u00020,2\u0006\u0010^\u001a\u00020\u00122\u0006\u0010_\u001a\u00020\u00122\u0006\u0010`\u001a\u00020\u00122\u0006\u0010a\u001a\u00020\u0012H\u0002J%\u0010b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010F0\u000e2\u0006\u0010c\u001a\u00020\u0012H\u0000¢\u0006\u0004\bd\u0010eJ\r\u0010f\u001a\u00020\u0012H\u0000¢\u0006\u0002\bgR\u001a\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00028\u00008DX\u0084\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014R\u000e\u0010 \u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006i"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "replay", "", "bufferCapacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "buffer", "", "", "[Ljava/lang/Object;", "bufferEndIndex", "", "getBufferEndIndex", "()J", "bufferSize", "head", "getHead", "lastReplayedLocked", "getLastReplayedLocked$annotations", "()V", "getLastReplayedLocked", "()Ljava/lang/Object;", "minCollectorIndex", "queueEndIndex", "getQueueEndIndex", "queueSize", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "replayIndex", "replaySize", "getReplaySize", "()I", "totalSize", "getTotalSize", "awaitValue", "", "slot", "(Lkotlinx/coroutines/flow/SharedFlowSlot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelEmitter", "emitter", "Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "cleanupTailLocked", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "correctCollectorIndexesOnDropOldest", "newHead", "createSlot", "createSlotArray", "size", "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "dropOldestLocked", "emit", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSuspend", "enqueueLocked", "item", "findSlotsToResumeLocked", "Lkotlin/coroutines/Continuation;", "resumesIn", "([Lkotlin/coroutines/Continuation;)[Lkotlin/coroutines/Continuation;", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "getPeekedValueLockedAt", "index", "growBuffer", "curBuffer", "curSize", "newSize", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "resetReplayCache", "tryEmit", "", "(Ljava/lang/Object;)Z", "tryEmitLocked", "tryEmitNoCollectorsLocked", "tryPeekLocked", "tryTakeValue", "updateBufferLocked", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "updateCollectorIndexLocked", "oldIndex", "updateCollectorIndexLocked$kotlinx_coroutines_core", "(J)[Lkotlin/coroutines/Continuation;", "updateNewCollectorIndexLocked", "updateNewCollectorIndexLocked$kotlinx_coroutines_core", "Emitter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class s<T> extends h.a.e3.b0.a<u> implements m<T>, Object<T> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f17306j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f17307k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final h.a.d3.e f17308l;
    private Object[] m;
    private long n;
    private long o;
    private int p;
    private int q;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B1\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\nH\u0016R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "Lkotlinx/coroutines/DisposableHandle;", "flow", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "index", "", "value", "", "cont", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lkotlin/coroutines/Continuation;)V", "dispose", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class a implements d1 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final s<?> f17309f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f17310g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Object f17311h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final kotlin.k0.d<f0> f17312i;

        /* JADX WARN: Multi-variable type inference failed */
        public a(s<?> r1, long r2, Object r4, kotlin.k0.d<? super f0> r5) {
            this.f17309f = r1;
            this.f17310g = r2;
            this.f17311h = r4;
            this.f17312i = r5;
        }

        @Override // h.a.d1
        public void dispose() {
            s.j(this.f17309f, this);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17313a = null;

        static {
            int[] r0 = new int[h.a.d3.e.values().length];
            r0[h.a.d3.e.f17221f.ordinal()] = 1;
            r0[h.a.d3.e.f17223h.ordinal()] = 2;
            r0[h.a.d3.e.f17222g.ordinal()] = 3;
            f17313a = r0;
        }
    }

    @kotlin.k0.j.a.f(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", l = {373, 380, 383}, m = "collect$suspendImpl")
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    static final class c extends kotlin.k0.j.a.d {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f17314f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f17315g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f17316h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Object f17317i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        /* synthetic */ Object f17318j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ s<T> f17319k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f17320l;

        c(s<T> r1, kotlin.k0.d<? super c> r2) {
            this.f17319k = r1;
            super(r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r2) {
            this.f17318j = r2;
            this.f17320l |= Integer.MIN_VALUE;
            return s.w(this.f17319k, null, this);
        }
    }

    public s(int r1, int r2, h.a.d3.e r3) {
        this.f17306j = r1;
        this.f17307k = r2;
        this.f17308l = r3;
    }

    private final void A() {
        Object[] r0 = this.m;
        kotlin.n0.d.o.c(r0);
        t.d(r0, G(), null);
        this.p--;
        long r1 = G() + 1;
        if (this.n >= r1) goto L6;
        this.n = r1;
    L6:
        if (this.o >= r1) goto L9;
        x(r1);
    L9:
        if (q0.a() == true) goto L11;
        return;
    L11:
        if (G() != r1) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L17;
        return;
    L17:
        throw new AssertionError();
    L13:
        r4 = false;
        goto L14
    }

    static /* synthetic */ Object B(s r1, Object r2, kotlin.k0.d r3) {
        if (r1.a(r2) == true) goto L5;
        Object r4 = r1.C(r2, r3);
        if (r4 != kotlin.k0.i.b.c()) goto L10;
        return r4;
    L10:
        return f0.f18324a;
    L5:
        return f0.f18324a;
    }

    private final Object C(T r11, kotlin.k0.d<? super f0> r12) {
        h.a.o r6 = new h.a.o(kotlin.k0.i.b.b(r12), 1);
        r6.A();
        kotlin.k0.d<f0>[] r8 = h.a.e3.b0.b.f17257a;
        monitor-enter(this);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (r(this, r11) == false) goto L7;
        kotlin.v.a r13 = kotlin.v.f21457g;     // Catch: Throwable -> L29
        f0 r14 = f0.f18324a;     // Catch: Throwable -> L29
        kotlin.v.b(r14);     // Catch: Throwable -> L29
        r6.resumeWith(r14);     // Catch: Throwable -> L29
        kotlin.k0.d<f0>[] r15 = l(this, r8);     // Catch: Throwable -> L29
        a r0 = null;
    L11:
        monitor-exit(this);
        if (r0 == null) goto L15;
        h.a.q.a(r6, r0);
    L15:
        int r10 = 0;
        int r1 = r15.length;
    L16:
        if (r10 >= r1) goto L21;
        kotlin.k0.d<f0> r2 = r15[r10];
        r10 = r10 + 1;
        if (r2 == null) goto L16;
        kotlin.v.a r3 = kotlin.v.f21457g;
        f0 r4 = f0.f18324a;
        kotlin.v.b(r4);
        r2.resumeWith(r4);
        goto L16
    L21:
        Object r16 = r6.x();
        if (r16 != kotlin.k0.i.b.c()) goto L25;
        kotlin.k0.j.a.h.c(r12);
    L25:
        if (r16 != kotlin.k0.i.b.c()) goto L28;
        return r16;
    L28:
        return f0.f18324a;
    L7:
        long r5 = n(this);     // Catch: Throwable -> L29
        a r9 = new a(this, ((long) p(this)) + r5, r11, r6);     // Catch: Throwable -> L29
        k(this, r9);     // Catch: Throwable -> L29
        q(this, o(this) + 1);     // Catch: Throwable -> L29
        if (m(this) != 0) goto L10;
        r8 = l(this, r8);     // Catch: Throwable -> L29
    L10:
        r15 = r8;
        r0 = r9;
        goto L11
    }

    private final void D(Object r7) {
        int r0 = K();
        Object[] r1 = this.m;
        if (r1 != null) goto L6;
        r1 = L(null, 0, 2);
    L8:
        t.d(r1, G() + ((long) r0), r7);
        return;
    L6:
        if (r0 < r1.length) goto L8;
        r1 = L(r1, r0, r1.length * 2);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [kotlin.k0.d<kotlin.f0>[]] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r6v3 */
    private final kotlin.k0.d<f0>[] E(kotlin.k0.d<f0>[] r11) {
        int r0 = r11.length;
        if (h.a.e3.b0.a.b(this) == 0) goto L23;
        h.a.e3.b0.c[] r1 = h.a.e3.b0.a.c(this);
        if (r1 == null) goto L23;
        int r2 = 0;
        int r3 = r1.length;
    L9:
        if (r2 >= r3) goto L23;
        h.a.e3.b0.c r4 = r1[r2];
        r2 = r2 + 1;
        if (r4 == null) goto L9;
        u r5 = (u) r4;
        kotlin.k0.d<? super f0> r6 = r5.f17323b;
        if (r6 == null) goto L9;
        if (O(r5) < 0) goto L9;
        int r7 = r11.length;
        r11 = r11;
        if (r0 < r7) goto L21;
        Object[] r12 = Arrays.copyOf(r11, Math.max(2, r11.length * 2));
        kotlin.n0.d.o.e(r12, "copyOf(this, newSize)");
        r11 = r12;
    L21:
        ((kotlin.k0.d[]) r11)[r0] = r6;
        r5.f17323b = null;
        r0 = r0 + 1;
    L23:
        return (kotlin.k0.d[]) r11;
    }

    private final long F() {
        return G() + ((long) this.p);
    }

    private final long G() {
        return Math.min(this.o, this.n);
    }

    private final Object H(long r1) {
        Object[] r0 = this.m;
        kotlin.n0.d.o.c(r0);
        Object r2 = t.c(r0, r1);
        if ((r2 instanceof a) == true) goto L5;
        return r2;
    L5:
        return ((a) r2).f17311h;
    }

    private final long I() {
        return (G() + ((long) this.p)) + ((long) this.q);
    }

    private final int J() {
        return (int) ((G() + ((long) this.p)) - this.n);
    }

    private final int K() {
        return this.p + this.q;
    }

    private final Object[] L(Object[] r6, int r7, int r8) {
        int r0 = 0;
        if (r8 <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L15;
        Object[] r9 = new Object[r8];
        this.m = r9;
        if (r6 != null) goto L10;
        return r9;
    L10:
        long r2 = G();
    L11:
        if (r0 >= r7) goto L13;
        long r3 = ((long) r0) + r2;
        t.d(r9, r3, t.c(r6, r3));
        r0 = r0 + 1;
        goto L11
    L13:
        return r9;
    L15:
        throw new IllegalStateException("Buffer size overflow".toString());
    L5:
        r1 = false;
        goto L6
    }

    private final boolean M(T r15) {
        if (h() != 0) goto L7;
        return N(r15);
    L7:
        if (this.p >= this.f17307k) goto L9;
    L18:
        D(r15);
        int r16 = this.p + 1;
        this.p = r16;
        if (r16 <= this.f17307k) goto L22;
        A();
    L22:
        if (J() <= this.f17306j) goto L24;
        Q(this.n + 1, this.o, F(), I());
    L24:
        return true;
    L9:
        if (this.o > this.n) goto L18;
        h.a.d3.e r0 = this.f17308l;
        int r1 = b.f17313a[r0.ordinal()];
        if (r1 != 1) goto L13;
        return false;
    L13:
        if (r1 != 2) goto L18;
        return true;
    }

    private final boolean N(T r7) {
        if (q0.a() == false) goto L13;
        if (h() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        throw new AssertionError();
    L7:
        r0 = false;
    L13:
        if (this.f17306j != 0) goto L15;
        return true;
    L15:
        D(r7);
        int r8 = this.p + 1;
        this.p = r8;
        if (r8 <= this.f17306j) goto L18;
        A();
    L18:
        this.o = G() + ((long) this.p);
        return true;
    }

    private final long O(u r7) {
        long r0 = r7.f17322a;
        if (r0 >= F()) goto L6;
        return r0;
    L6:
        if (this.f17307k <= 0) goto L9;
        return -1;
    L9:
        if (r0 <= G()) goto L12;
        return -1;
    L12:
        if (this.q != 0) goto L14;
        return -1;
    L14:
        return r0;
    }

    private final Object P(u r9) {
        kotlin.k0.d<f0>[] r0 = h.a.e3.b0.b.f17257a;
        monitor-enter(this);
        long r1 = O(r9);     // Catch: Throwable -> L17
        if (r1 >= 0) goto L7;
        Object r10 = t.f17321a;     // Catch: Throwable -> L17
    L9:
        monitor-exit(this);
        int r8 = 0;
        int r2 = r0.length;
    L11:
        if (r8 >= r2) goto L16;
        kotlin.k0.d<f0> r3 = r0[r8];
        r8 = r8 + 1;
        if (r3 == null) goto L11;
        kotlin.v.a r4 = kotlin.v.f21457g;
        f0 r5 = f0.f18324a;
        kotlin.v.b(r5);
        r3.resumeWith(r5);
        goto L11
    L16:
        return r10;
    L7:
        long r6 = r9.f17322a;     // Catch: Throwable -> L17
        Object r7 = H(r1);     // Catch: Throwable -> L17
        r9.f17322a = r1 + 1;     // Catch: Throwable -> L17
        r0 = R(r6);     // Catch: Throwable -> L17
        r10 = r7;
    L17:
        th = move-exception;
        throw th;
    }

    private final void Q(long r16, long r18, long r20, long r22) {
        long r5 = Math.min(r18, r16);
        boolean r8 = true;
        if (q0.a() == true) goto L5;
    L12:
        long r10 = G();
    L14:
        if (r10 >= r5) goto L16;
        Object[] r7 = this.m;
        kotlin.n0.d.o.c(r7);
        t.d(r7, r10, null);
        r10 = 1 + r10;
        goto L14
    L16:
        this.n = r16;
        this.o = r18;
        this.p = (int) (r20 - r5);
        this.q = (int) (r22 - r20);
        if (q0.a() == false) goto L27;
        if (this.p < 0) goto L21;
        boolean r1 = true;
    L22:
        if (r1 == true) goto L27;
        throw new AssertionError();
    L21:
        r1 = false;
    L27:
        if (q0.a() == false) goto L37;
        if (this.q < 0) goto L31;
        boolean r2 = true;
    L32:
        if (r2 == true) goto L37;
        throw new AssertionError();
    L31:
        r2 = false;
    L37:
        if (q0.a() == true) goto L39;
        return;
    L39:
        if (this.n <= (G() + ((long) this.p))) goto L42;
        r8 = false;
    L42:
        if (r8 == false) goto L45;
        return;
    L45:
        throw new AssertionError();
    L5:
        if (r5 < G()) goto L7;
        boolean r9 = true;
    L8:
        if (r9 == true) goto L12;
        throw new AssertionError();
    L7:
        r9 = false;
        goto L8
    }

    public static final /* synthetic */ void j(s r0, a r1) {
        r0.u(r1);
    }

    public static final /* synthetic */ void k(s r0, Object r1) {
        r0.D(r1);
    }

    public static final /* synthetic */ kotlin.k0.d[] l(s r0, kotlin.k0.d[] r1) {
        return r0.E(r1);
    }

    public static final /* synthetic */ int m(s r0) {
        return r0.f17307k;
    }

    public static final /* synthetic */ long n(s r2) {
        return r2.G();
    }

    public static final /* synthetic */ int o(s r0) {
        return r0.q;
    }

    public static final /* synthetic */ int p(s r0) {
        return r0.K();
    }

    public static final /* synthetic */ void q(s r0, int r1) {
        r0.q = r1;
    }

    public static final /* synthetic */ boolean r(s r0, Object r1) {
        return r0.M(r1);
    }

    public static final /* synthetic */ long s(s r0, u r1) {
        return r0.O(r1);
    }

    private final Object t(u r6, kotlin.k0.d<? super f0> r7) {
        h.a.o r0 = new h.a.o(kotlin.k0.i.b.b(r7), 1);
        r0.A();
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (s(this, r6) >= 0) goto L7;
        r6.f17323b = r0;     // Catch: Throwable -> L17
        r6.f17323b = r0;     // Catch: Throwable -> L17
    L8:
        f0 r8 = f0.f18324a;     // Catch: Throwable -> L17
        monitor-exit(this);
        Object r5 = r0.x();
        if (r5 != kotlin.k0.i.b.c()) goto L14;
        kotlin.k0.j.a.h.c(r7);
    L14:
        if (r5 != kotlin.k0.i.b.c()) goto L16;
        return r5;
    L16:
        return r8;
    L7:
        kotlin.v.a r9 = kotlin.v.f21457g;     // Catch: Throwable -> L17
        f0 r10 = f0.f18324a;     // Catch: Throwable -> L17
        kotlin.v.b(r10);     // Catch: Throwable -> L17
        r0.resumeWith(r10);     // Catch: Throwable -> L17
        goto L8
    }

    private final void u(a r5) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r5.f17310g >= G()) goto L8;
        monitor-exit(this);
        return;
    L8:
        Object[] r0 = this.m;     // Catch: Throwable -> L15
        kotlin.n0.d.o.c(r0);     // Catch: Throwable -> L15
        if (t.c(r0, r5.f17310g) == r5) goto L12;
        monitor-exit(this);
        return;
    L12:
        t.d(r0, r5.f17310g, t.f17321a);     // Catch: Throwable -> L15
        v();     // Catch: Throwable -> L15
        f0 r6 = f0.f18324a;     // Catch: Throwable -> L15
        monitor-exit(this);
    }

    private final void v() {
        if (this.f17307k == 0) goto L5;
    L7:
        Object[] r0 = this.m;
        kotlin.n0.d.o.c(r0);
    L9:
        if (this.q <= 0) goto L13;
        if (t.c(r0, (G() + ((long) K())) - 1) != t.f17321a) goto L16;
        this.q--;
        t.d(r0, G() + ((long) K()), null);
        goto L9
    L16:
        return;
    L13:
        return;
    L5:
        if (this.q > 1) goto L7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object w(s r8, f r9, kotlin.k0.d r10) {
        if ((r10 instanceof c) == false) goto L7;
        c r0 = (c) r10;
        int r1 = r0.f17320l;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.f17320l = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f17318j;
        Object r2 = kotlin.k0.i.b.c();
        int r3 = r0.f17320l;
        if (r3 == 0) goto L26;
        if (r3 == 1) goto L21;
        if (r3 == 2) goto L18;
        if (r3 != 3) goto L17;
        x1 r12 = (x1) r0.f17317i;
        u r13 = (u) r0.f17316h;
        f r4 = (f) r0.f17315g;
        s r5 = (s) r0.f17314f;
    L57:
        kotlin.w.b(r11);     // Catch: Throwable -> L19
        f r14 = r4;
        x1 r6 = r12;
        r8 = r5;
    L34:
        Object r7 = r8.P(r13);     // Catch: Throwable -> L45
        if (r7 != t.f17321a) goto L36;
        r0.f17314f = r8;     // Catch: Throwable -> L45
        r0.f17315g = r14;     // Catch: Throwable -> L45
        r0.f17316h = r13;     // Catch: Throwable -> L45
        r0.f17317i = r6;     // Catch: Throwable -> L45
        r0.f17320l = 2;     // Catch: Throwable -> L45
        if (r8.t(r13, r0) != r2) goto L34;
        return r2;
    L36:
        if (r6 == null) goto L39;
        b2.h(r6);     // Catch: Throwable -> L45
    L39:
        r0.f17314f = r8;     // Catch: Throwable -> L45
        r0.f17315g = r14;     // Catch: Throwable -> L45
        r0.f17316h = r13;     // Catch: Throwable -> L45
        r0.f17317i = r6;     // Catch: Throwable -> L45
        r0.f17320l = 3;     // Catch: Throwable -> L45
        if (r14.emit(r7, r0) != r2) goto L34;
        return r2;
    L45:
        th = move-exception;
        r5 = r8;
        Throwable th = th;
    L49:
        r5.g(r13);
        throw th;
    L19:
        th = th;
        goto L49
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r12 = (x1) r0.f17317i;
        r13 = (u) r0.f17316h;
        r4 = (f) r0.f17315g;
        r5 = (s) r0.f17314f;
        goto L57
    L21:
        r13 = (u) r0.f17316h;
        f r15 = (f) r0.f17315g;
        s r16 = (s) r0.f17314f;
        kotlin.w.b(r11);     // Catch: Throwable -> L24
        f r17 = r15;
        r8 = r16;
    L53:
        r6 = (x1) r0.getContext().get(x1.f17584d);     // Catch: Throwable -> L45
        r14 = r17;
    L24:
        th = th;
        r5 = r16;
        goto L49
    L26:
        kotlin.w.b(r11);
        u r18 = r8.d();
    L47:
        th = move-exception;
        r5 = r8;
        th = th;
        r13 = r18;
        goto L49
    L28:
        if ((r9 instanceof z) == false) goto L32;
        r0.f17314f = r8;     // Catch: Throwable -> L47
        r0.f17315g = r9;     // Catch: Throwable -> L47
        r0.f17316h = r18;     // Catch: Throwable -> L47
        r0.f17320l = 1;     // Catch: Throwable -> L47
        if (((z) r9).b(r0) != r2) goto L32;
        return r2;
    L32:
        r17 = r9;
        r13 = r18;
    L7:
        r0 = new c(r8, r10);
        goto L8
    }

    private final void x(long r9) {
        if (h.a.e3.b0.a.b(this) == 0) goto L17;
        h.a.e3.b0.c[] r0 = h.a.e3.b0.a.c(this);
        if (r0 == null) goto L17;
        int r1 = 0;
        int r2 = r0.length;
    L9:
        if (r1 >= r2) goto L17;
        h.a.e3.b0.c r3 = r0[r1];
        r1 = r1 + 1;
        if (r3 == null) goto L9;
        u r4 = (u) r3;
        long r5 = r4.f17322a;
        if (r5 < 0) goto L9;
        if (r5 >= r9) goto L9;
        r4.f17322a = r9;
    L17:
        this.o = r9;
    }

    public final kotlin.k0.d<f0>[] R(long r22) {
        if (q0.a() == false) goto L13;
        if (r22 < this.o) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        throw new AssertionError();
    L7:
        r0 = false;
    L13:
        if (r22 > this.o) goto L15;
        long r1 = G();
        long r2 = ((long) this.p) + r1;
        long r5 = 1;
        if (this.f17307k != 0) goto L22;
        if (this.q <= 0) goto L22;
        r2 = r2 + 1;
    L22:
        if (h.a.e3.b0.a.b(this) == 0) goto L37;
        h.a.e3.b0.c[] r4 = h.a.e3.b0.a.c(this);
        if (r4 == null) goto L37;
        int r7 = r4.length;
        int r8 = 0;
    L28:
        if (r8 >= r7) goto L37;
        h.a.e3.b0.c r12 = r4[r8];
        r8 = r8 + 1;
        if (r12 == null) goto L28;
        long r13 = ((u) r12).f17322a;
        if (r13 < 0) goto L28;
        if (r13 >= r2) goto L28;
        r2 = r13;
    L37:
        if (q0.a() == false) goto L47;
        if (r2 < this.o) goto L41;
        boolean r6 = true;
    L42:
        if (r6 == true) goto L47;
        throw new AssertionError();
    L41:
        r6 = false;
    L47:
        if (r2 <= this.o) goto L49;
        long r9 = F();
        if (h() <= 0) goto L53;
        int r10 = (int) (r9 - r2);
        int r11 = Math.min(this.q, this.f17307k - r10);
    L54:
        kotlin.k0.d<f0>[] r14 = h.a.e3.b0.b.f17257a;
        long r15 = ((long) this.q) + r9;
        if (r11 <= 0) goto L69;
        r14 = new kotlin.k0.d[r11];
        Object[] r16 = this.m;
        kotlin.n0.d.o.c(r16);
        long r17 = r9;
        int r18 = 0;
    L58:
        if (r9 >= r15) goto L67;
        r9 = r9 + r5;
        Object r19 = t.c(r16, r9);
        h.a.f3.f0 r20 = t.f17321a;
        if (r19 == r20) goto L66;
        long r110 = r2;
        Objects.requireNonNull(r19, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
        a r21 = (a) r19;
        int r3 = r18 + 1;
        r14[r18] = r21.f17312i;
        t.d(r16, r9, r20);
        t.d(r16, r17, r21.f17311h);
        r17 = r17 + 1;
        if (r3 >= r11) goto L68;
        r18 = r3;
        r2 = r110;
    L68:
        r9 = r17;
    L70:
        int r23 = (int) (r9 - r1);
        if (h() != 0) goto L73;
        long r24 = r9;
    L74:
        long r25 = Math.max(this.n, r9 - ((long) Math.min(this.f17306j, r23)));
        if (this.f17307k == 0) goto L77;
    L81:
        Q(r25, r24, r9, r15);
        v();
        if (r14.length != 0) goto L84;
        boolean r111 = true;
    L86:
        if ((true ^ r111) == true) goto L88;
        return r14;
    L88:
        return E(r14);
    L84:
        r111 = false;
        goto L86
    L77:
        if (r25 >= r15) goto L81;
        Object[] r26 = this.m;
        kotlin.n0.d.o.c(r26);
        if (kotlin.n0.d.o.a(t.c(r26, r25), t.f17321a) == false) goto L81;
        r9 = r9 + 1;
        r25 = r25 + 1;
        goto L81
    L73:
        r24 = r110;
    L66:
        r5 = 1;
        goto L58
    L67:
        r110 = r2;
        goto L68
    L69:
        r110 = r2;
        goto L70
    L53:
        r11 = this.q;
        goto L54
    L49:
        return h.a.e3.b0.b.f17257a;
    L15:
        return h.a.e3.b0.b.f17257a;
    }

    public final long S() {
        long r0 = this.n;
        if (r0 >= this.o) goto L5;
        this.o = r0;
    L5:
        return r0;
    }

    @Override // h.a.e3.m
    public boolean a(T r5) {
        kotlin.k0.d<f0>[] r0 = h.a.e3.b0.b.f17257a;
        monitor-enter(this);
        int r1 = 0;
        if (M(r5) == false) goto L8;
        r0 = E(r0);     // Catch: Throwable -> L17
        boolean r6 = true;
    L9:
        monitor-exit(this);
        int r4 = r0.length;
    L11:
        if (r1 >= r4) goto L16;
        kotlin.k0.d<f0> r2 = r0[r1];
        r1 = r1 + 1;
        if (r2 == null) goto L11;
        kotlin.v.a r3 = kotlin.v.f21457g;
        f0 r7 = f0.f18324a;
        kotlin.v.b(r7);
        r2.resumeWith(r7);
        goto L11
    L16:
        return r6;
    L8:
        r6 = false;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // h.a.e3.r, h.a.e3.e
    public Object collect(f<? super T> r1, kotlin.k0.d<?> r2) {
        return w(this, r1, r2);
    }

    @Override // h.a.e3.b0.a
    public /* bridge */ /* synthetic */ h.a.e3.b0.c e() {
        return y();
    }

    @Override // h.a.e3.f
    public Object emit(T r1, kotlin.k0.d<? super f0> r2) {
        return B(this, r1, r2);
    }

    @Override // h.a.e3.b0.a
    public /* bridge */ /* synthetic */ h.a.e3.b0.c[] f(int r1) {
        return z(r1);
    }

    protected u y() {
        return new u();
    }

    protected u[] z(int r1) {
        return new u[r1];
    }
}
