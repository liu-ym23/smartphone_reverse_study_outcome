package h.a.f3;

import h.a.d1;
import h.a.i2;
import h.a.u0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000e2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\fH\u0002J\u001e\u0010 \u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "cause", "", "errorHint", "", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "delay", "", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "isDispatchNeeded", "", "limitedParallelism", "Lkotlinx/coroutines/CoroutineDispatcher;", "parallelism", "", "missing", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class y extends i2 implements u0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Throwable f17431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f17432g;

    public y(Throwable r1, String r2) {
        this.f17431f = r1;
        this.f17432g = r2;
    }

    private final Void k0() {
        if (this.f17431f == null) goto L12;
        String r0 = this.f17432g;
        String r1 = "";
        if (r0 == null) goto L11;
        String r2 = kotlin.n0.d.o.m(". ", r0);
        if (r2 == null) goto L11;
        r1 = r2;
    L11:
        throw new IllegalStateException(kotlin.n0.d.o.m("Module with the Main dispatcher had failed to initialize", r1), this.f17431f);
    L12:
        x.d();
        throw null;
    }

    @Override // h.a.u0
    public d1 M(long r1, Runnable r3, kotlin.k0.g r4) {
        k0();
        throw null;
    }

    @Override // h.a.g0
    public /* bridge */ /* synthetic */ void dispatch(kotlin.k0.g r1, Runnable r2) {
        j0(r1, r2);
        throw null;
    }

    @Override // h.a.i2
    public i2 h0() {
        return this;
    }

    @Override // h.a.g0
    public boolean isDispatchNeeded(kotlin.k0.g r1) {
        k0();
        throw null;
    }

    public Void j0(kotlin.k0.g r1, Runnable r2) {
        k0();
        throw null;
    }

    @Override // h.a.u0
    public /* bridge */ /* synthetic */ void l(long r1, h.a.n r3) {
        l0(r1, r3);
        throw null;
    }

    public Void l0(long r1, h.a.n<? super kotlin.f0> r3) {
        k0();
        throw null;
    }

    @Override // h.a.i2, h.a.g0
    public h.a.g0 limitedParallelism(int r1) {
        k0();
        throw null;
    }

    @Override // h.a.i2, h.a.g0
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("Dispatchers.Main[missing");
        Throwable r2 = this.f17431f;
        if (r2 == null) goto L5;
        String r3 = kotlin.n0.d.o.m(", cause=", r2);
    L6:
        r0.append(r3);
        r0.append(']');
        return r0.toString();
    L5:
        r3 = "";
        goto L6
    }
}
