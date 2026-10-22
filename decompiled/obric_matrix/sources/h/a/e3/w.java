package h.a.e3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import h.a.b2;
import h.a.x1;
import kotlin.Metadata;
import kotlin.f0;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<T>] */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u0010062\b\u0012\u0004\u0012\u00028\u0000072\b\u0012\u0004\u0012\u00028\u0000082\b\u0012\u0004\u0012\u00028\u000009B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0019H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0004\b&\u0010'J!\u0010*\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u00022\u0006\u0010)\u001a\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010\u000fR\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R*\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\u0012\u0012\u0004\b4\u0010%\u001a\u0004\b1\u00102\"\u0004\b3\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", "", "initialState", "<init>", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expect", "update", "", "compareAndSet", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/flow/StateFlowSlot;", "createSlot", "()Lkotlinx/coroutines/flow/StateFlowSlot;", "", "size", "", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "resetReplayCache", "()V", "tryEmit", "(Ljava/lang/Object;)Z", "expectedState", "newState", "updateState", "", "getReplayCache", "()Ljava/util/List;", "replayCache", "sequence", "I", "getValue", "()Ljava/lang/Object;", "setValue", "getValue$annotations", "kotlinx-coroutines-core", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class w<T> extends h.a.e3.b0.a<y> implements n<T>, Object<T> {
    private volatile /* synthetic */ Object _state;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f17324j;

    @kotlin.k0.j.a.f(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {386, 398, TypedValues.CycleType.TYPE_ALPHA}, m = "collect")
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends kotlin.k0.j.a.d {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f17325f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f17326g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f17327h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Object f17328i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f17329j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f17330k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ w<T> f17331l;
        int m;

        a(w<T> r1, kotlin.k0.d<? super a> r2) {
            this.f17331l = r1;
            super(r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r2) {
            this.f17330k = r2;
            this.m |= Integer.MIN_VALUE;
            return this.f17331l.collect(null, this);
        }
    }

    public w(Object r1) {
        this._state = r1;
    }

    private final boolean l(Object r7, Object r8) {
        i();
        monitor-enter(this);
        Object r0 = this._state;     // Catch: Throwable -> L44
        if (r7 == null) goto L12;
        if (kotlin.n0.d.o.a(r0, r7) == true) goto L12;
        monitor-exit(this);
        return false;
    L12:
        if (kotlin.n0.d.o.a(r0, r8) == false) goto L15;
        monitor-exit(this);
        return true;
    L15:
        this._state = r8;     // Catch: Throwable -> L44
        int r9 = this.f17324j;     // Catch: Throwable -> L44
        if ((r9 & 1) != 0) goto L41;
        int r10 = r9 + 1;     // Catch: Throwable -> L44
        this.f17324j = r10;     // Catch: Throwable -> L44
        y[] r11 = i();     // Catch: Throwable -> L44
        f0 r2 = f0.f18324a;     // Catch: Throwable -> L44
        monitor-exit(this);
    L19:
        y[] r12 = r11;
        if (r12 == null) goto L28;
        int r3 = r12.length;
        int r4 = 0;
    L23:
        if (r4 >= r3) goto L28;
        y r5 = r12[r4];
        r4 = r4 + 1;
        if (r5 == null) goto L23;
        r5.f();
    L28:
        monitor-enter(this);
        int r13 = this.f17324j;     // Catch: Throwable -> L37
        if (r13 == r10) goto L31;
        y[] r14 = i();     // Catch: Throwable -> L37
        f0 r6 = f0.f18324a;     // Catch: Throwable -> L37
        monitor-exit(this);
        r11 = r14;
        r10 = r13;
        goto L19
    L31:
        this.f17324j = r10 + 1;     // Catch: Throwable -> L37
        monitor-exit(this);
        return true;
    L37:
        th = move-exception;
        throw th;
    L41:
        this.f17324j = r9 + 2;     // Catch: Throwable -> L44
        monitor-exit(this);
        return true;
    L44:
        th = move-exception;
        throw th;
    }

    @Override // h.a.e3.m
    public boolean a(T r1) {
        setValue(r1);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [h.a.e3.b0.c] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [h.a.e3.y, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3, types: [h.a.e3.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00da -> B:33:0x00a7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00ec -> B:33:0x00a7). Please report as a decompilation issue!!! */
    @Override // h.a.e3.r, h.a.e3.e
    public Object collect(f<? super T> r11, kotlin.k0.d<?> r12) {
        if ((r12 instanceof a) == false) goto L7;
        a r0 = (a) r12;
        int r1 = r0.m;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.m = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f17330k;
        Object r2 = kotlin.k0.i.b.c();
        ?? r3 = r0.m;
        if (r3 == 0) goto L26;
        if (r3 != 1) goto L58;
        y r4 = (y) r0.f17327h;
        r11 = (f) r0.f17326g;
        w<T> this = (w) r0.f17325f;
        kotlin.w.b(r13);     // Catch: Throwable -> L54
        y r5 = r4;
    L32:
        ?? r6 = r11;
        x1 r14 = (x1) r0.getContext().get(x1.f17584d);     // Catch: Throwable -> L54
        Object r15 = null;
        r3 = r5;
    L33:
        Object r7 = this._state;     // Catch: Throwable -> L54
        if (r14 == null) goto L37;
        b2.h(r14);     // Catch: Throwable -> L54
    L37:
        if (r15 == null) goto L41;
        ?? r8 = r3;
        ?? r9 = r6;
        if (kotlin.n0.d.o.a(r15, r7) == false) goto L41;
    L49:
        boolean r10 = r8.g();     // Catch: Throwable -> L54
        r3 = r8;
        r6 = r9;
        if (r10 == true) goto L33;
        r0.f17325f = this;     // Catch: Throwable -> L54
        r0.f17326g = r9;     // Catch: Throwable -> L54
        r0.f17327h = r8;     // Catch: Throwable -> L54
        r0.f17328i = r14;     // Catch: Throwable -> L54
        r0.f17329j = r15;     // Catch: Throwable -> L54
        r0.m = 3;     // Catch: Throwable -> L54
        Object r16 = r8.d(r0);     // Catch: Throwable -> L54
        r3 = r8;
        r6 = r9;
        if (r16 != r2) goto L33;
        return r2;
    L41:
        if (r7 != h.a.e3.b0.g.f17272a) goto L43;
        Object r17 = null;
    L44:
        r0.f17325f = this;     // Catch: Throwable -> L54
        r0.f17326g = r6;     // Catch: Throwable -> L54
        r0.f17327h = r3;     // Catch: Throwable -> L54
        r0.f17328i = r14;     // Catch: Throwable -> L54
        r0.f17329j = r7;     // Catch: Throwable -> L54
        r0.m = 2;     // Catch: Throwable -> L54
        if (r6.emit(r17, r0) != r2) goto L47;
        return r2;
    L47:
        w<T> r18 = this;
        Object r19 = r7;
        ?? r20 = r3;
        ?? r21 = r6;
    L48:
        r15 = r19;
        this = r18;
        r8 = r20;
        r9 = r21;
        goto L49
    L43:
        r17 = r7;
        goto L44
    L58:
        if (r3 == 2) goto L18;
        if (r3 != 3) goto L17;
        Object r110 = r0.f17329j;
        r14 = (x1) r0.f17328i;
        y r22 = (y) r0.f17327h;
        f r23 = (f) r0.f17326g;
        w<T> r24 = (w) r0.f17325f;
        kotlin.w.b(r13);     // Catch: Throwable -> L21
        r15 = r110;
        this = r24;
        r3 = r22;
        r6 = r23;
        goto L33
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r19 = r0.f17329j;
        r14 = (x1) r0.f17328i;
        y r25 = (y) r0.f17327h;
        f r26 = (f) r0.f17326g;
        r18 = (w) r0.f17325f;
        kotlin.w.b(r13);     // Catch: Throwable -> L21
        r20 = r25;
        r21 = r26;
    L21:
        Throwable th = th;
    L56:
        r7.g(r3);
        throw th;
    L26:
        kotlin.w.b(r13);
        y r27 = d();
        r5 = r27;
        if ((r11 instanceof z) == false) goto L32;
        r0.f17325f = this;     // Catch: Throwable -> L54
        r0.f17326g = r11;     // Catch: Throwable -> L54
        r0.f17327h = r27;     // Catch: Throwable -> L54
        r0.m = 1;     // Catch: Throwable -> L54
        r5 = r27;
        if (((z) r11).b(r0) != r2) goto L32;
        return r2;
    L54:
        th = move-exception;
        w<T> r28 = this;
        th = th;
    L7:
        r0 = new a(this, r12);
        goto L8
    }

    @Override // h.a.e3.b0.a
    public /* bridge */ /* synthetic */ h.a.e3.b0.c e() {
        return j();
    }

    @Override // h.a.e3.f
    public Object emit(T r1, kotlin.k0.d<? super f0> r2) {
        setValue(r1);
        return f0.f18324a;
    }

    @Override // h.a.e3.b0.a
    public /* bridge */ /* synthetic */ h.a.e3.b0.c[] f(int r1) {
        return k(r1);
    }

    @Override // h.a.e3.n, h.a.e3.v
    public T getValue() {
        h.a.f3.f0 r0 = h.a.e3.b0.g.f17272a;
        T r1 = (T) this._state;
        if (r1 != r0) goto L6;
        return null;
    L6:
        return r1;
    }

    protected y j() {
        return new y();
    }

    protected y[] k(int r1) {
        return new y[r1];
    }

    @Override // h.a.e3.n
    public void setValue(T r2) {
        if (r2 != null) goto L4;
        r2 = (T) h.a.e3.b0.g.f17272a;
    L4:
        l(null, r2);
    }
}
