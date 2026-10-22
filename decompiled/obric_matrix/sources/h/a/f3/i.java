package h.a.f3;

import com.bytedance.common.wschannel.WsConstants;
import h.a.h1;
import h.a.r0;
import h.a.v2;
import h.a.y0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000O2\u00060?j\u0002`@2\b\u0012\u0004\u0012\u00028\u00000\u0004B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0011\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0010¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\n\u0018\u00010\u001bj\u0004\u0018\u0001`\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\b¢\u0006\u0004\b$\u0010\nJH\u0010+\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%2%\b\b\u0010*\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b\u0018\u00010'H\u0086\bø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001a\u0010.\u001a\u00020\u001f2\b\u0010-\u001a\u0004\u0018\u00010\u000bH\u0086\b¢\u0006\u0004\b.\u0010/J!\u00100\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0086\bø\u0001\u0000¢\u0006\u0004\b0\u00101J \u00102\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016ø\u0001\u0000¢\u0006\u0004\b2\u00101J\u0011\u00105\u001a\u0004\u0018\u00010\u000bH\u0010¢\u0006\u0004\b3\u00104J\u000f\u00107\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108J\u001b\u0010:\u001a\u0004\u0018\u00010\r2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u000309¢\u0006\u0004\b:\u0010;R\u001e\u0010<\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b<\u0010=\u0012\u0004\b>\u0010\nR\u001c\u0010C\u001a\n\u0018\u00010?j\u0004\u0018\u0001`@8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0014\u0010\u0016\u001a\u00020\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bD\u0010ER\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010FR\u0014\u0010G\u001a\u00020\u000b8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\bG\u0010=R\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010KR\u001a\u0010M\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006N"}, d2 = {"Lkotlinx/coroutines/internal/DispatchedContinuation;", "T", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlin/coroutines/Continuation;", "continuation", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "", "awaitReusability", "()V", "", "takenState", "", "cause", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "Lkotlinx/coroutines/CancellableContinuationImpl;", "claimReusableCancellableContinuation", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlin/coroutines/CoroutineContext;", "context", "value", "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "dispatchYield", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "", "isReusable", "()Z", "postponeCancellation", "(Ljava/lang/Throwable;)Z", "release", "Lkotlin/Result;", "result", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onCancellation", "resumeCancellableWith", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", WsConstants.KEY_CONNECTION_STATE, "resumeCancelled", "(Ljava/lang/Object;)Z", "resumeUndispatchedWith", "(Ljava/lang/Object;)V", "resumeWith", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/CancellableContinuation;", "tryReleaseClaimedContinuation", "(Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Throwable;", "_state", "Ljava/lang/Object;", "get_state$kotlinx_coroutines_core$annotations", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "countOrElement", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/CoroutineDispatcher;", "getReusableCancellableContinuation", "reusableCancellableContinuation", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class i<T> extends y0<T> implements kotlin.k0.j.a.e, kotlin.k0.d<T> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater m = null;
    private volatile /* synthetic */ Object _reusableCancellableContinuation;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final h.a.g0 f17371i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final kotlin.k0.d<T> f17372j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Object f17373k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f17374l;

    static {
        m = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_reusableCancellableContinuation");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(h.a.g0 r2, kotlin.k0.d<? super T> r3) {
        super(-1);
        this.f17371i = r2;
        this.f17372j = r3;
        this.f17373k = j.a();
        this.f17374l = j0.b(getContext());
        this._reusableCancellableContinuation = null;
    }

    private final h.a.o<?> p() {
        Object r1 = this._reusableCancellableContinuation;
        if ((r1 instanceof h.a.o) == true) goto L7;
        return null;
    L7:
        return (h.a.o) r1;
    }

    @Override // h.a.y0
    public void a(Object r1, Throwable r2) {
        if ((r1 instanceof h.a.z) == false) goto L6;
        ((h.a.z) r1).f17597b.invoke(r2);
        return;
    }

    @Override // h.a.y0
    public kotlin.k0.d<T> b() {
        return this;
    }

    @Override // h.a.y0
    public Object g() {
        Object r0 = this.f17373k;
        if (h.a.q0.a() == true) goto L5;
    L12:
        this.f17373k = j.a();
        return r0;
    L5:
        if (r0 == j.a()) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L12;
        throw new AssertionError();
    L7:
        r1 = false;
        goto L8
    }

    @Override // kotlin.k0.j.a.e
    public kotlin.k0.j.a.e getCallerFrame() {
        kotlin.k0.d<T> r1 = this.f17372j;
        if ((r1 instanceof kotlin.k0.j.a.e) == true) goto L7;
        return null;
    L7:
        return (kotlin.k0.j.a.e) r1;
    }

    @Override // kotlin.k0.d
    public kotlin.k0.g getContext() {
        return this.f17372j.getContext();
    }

    @Override // kotlin.k0.j.a.e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final void i() {
    L3:
        if (this._reusableCancellableContinuation == j.f17376b) goto L3;
    }

    public final h.a.o<T> k() {
    L2:
        Object r0 = this._reusableCancellableContinuation;
        if (r0 == null) goto L4;
        if ((r0 instanceof h.a.o) == true) goto L9;
        if (r0 == j.f17376b) goto L2;
        if ((r0 instanceof Throwable) == true) goto L2;
        throw new IllegalStateException(kotlin.n0.d.o.m("Inconsistent state ", r0).toString());
    L9:
        if (m.compareAndSet(this, r0, j.f17376b) == false) goto L2;
        return (h.a.o) r0;
    L4:
        this._reusableCancellableContinuation = j.f17376b;
        return null;
    }

    public final boolean r() {
        if (this._reusableCancellableContinuation == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.k0.d
    public void resumeWith(Object r7) {
        kotlin.k0.g r0 = this.f17372j.getContext();
        Object r3 = h.a.c0.d(r7, null, 1, null);
        if (this.f17371i.isDispatchNeeded(r0) == false) goto L5;
        this.f17373k = r3;
        this.f17589h = 0;
        this.f17371i.dispatch(r0, this);
        return;
    L5:
        h.a.q0.a();
        h1 r1 = v2.f17573a.b();
        if (r1.o0() == false) goto L8;
        this.f17373k = r3;
        this.f17589h = 0;
        r1.k0(this);
        return;
    L8:
        r1.m0(true);
        kotlin.k0.g r4 = getContext();     // Catch: Throwable -> L18
        Object r5 = j0.c(r4, this.f17374l);     // Catch: Throwable -> L18
        this.f17372j.resumeWith(r7);     // Catch: Throwable -> L15
        kotlin.f0 r8 = kotlin.f0.f18324a;     // Catch: Throwable -> L15
        j0.a(r4, r5);     // Catch: Throwable -> L18
    L13:
        if (r1.r0() == true) goto L13;
    L20:
        r1.h0(true);
        return;
    L15:
        th = move-exception;
        j0.a(r4, r5);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        f(th, null);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r1.h0(true);
        throw th;
    }

    public final boolean s(Throwable r5) {
    L2:
        Object r0 = this._reusableCancellableContinuation;
        f0 r1 = j.f17376b;
        if (kotlin.n0.d.o.a(r0, r1) == true) goto L5;
        if ((r0 instanceof Throwable) == true) goto L9;
        if (m.compareAndSet(this, r0, null) == false) goto L2;
        return false;
    L9:
        return true;
    L5:
        if (m.compareAndSet(this, r1, r5) == false) goto L2;
        return true;
    }

    public final void t() {
        i();
        h.a.o<?> r0 = p();
        if (r0 == null) goto L7;
        r0.t();
        return;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f17371i + ", " + r0.c(this.f17372j) + ']';
    }

    public final Throwable u(h.a.n<?> r4) {
    L2:
        Object r0 = this._reusableCancellableContinuation;
        f0 r1 = j.f17376b;
        if (r0 != r1) goto L8;
        if (m.compareAndSet(this, r1, r4) == false) goto L2;
        return null;
    L8:
        if ((r0 instanceof Throwable) == false) goto L16;
        if (m.compareAndSet(this, r0, null) == false) goto L14;
        return (Throwable) r0;
    L14:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L16:
        throw new IllegalStateException(kotlin.n0.d.o.m("Inconsistent state ", r0).toString());
    }
}
