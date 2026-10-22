package h.a;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0014J\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bR\"\u0010\b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/UndispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "threadStateToRecover", "Ljava/lang/ThreadLocal;", "Lkotlin/Pair;", "", "afterResume", "", WsConstants.KEY_CONNECTION_STATE, "clearThreadContext", "", "saveThreadContext", "oldValue", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a3<T> extends h.a.f3.d0<T> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ThreadLocal<kotlin.u<kotlin.k0.g, Object>> f17180i;

    public a3(kotlin.k0.g r3, kotlin.k0.d<? super T> r4) {
        b3 r0 = b3.f17183f;
        if (r3.get(r0) != null) goto L5;
        r3 = r3.plus(r0);
    L5:
        super(r3, r4);
        this.f17180i = new ThreadLocal();
    }

    @Override // h.a.f3.d0, h.a.a
    protected void L0(Object r6) {
        kotlin.u<kotlin.k0.g, Object> r0 = this.f17180i.get();
        a3<?> r1 = null;
        if (r0 == null) goto L6;
        h.a.f3.j0.a(r0.a(), r0.b());
        this.f17180i.set(null);
    L6:
        Object r7 = c0.a(r6, this.f17362h);
        kotlin.k0.d<T> r2 = this.f17362h;
        kotlin.k0.g r3 = r2.getContext();
        Object r4 = h.a.f3.j0.c(r3, null);
        if (r4 == h.a.f3.j0.f17377a) goto L21;
        r1 = f0.g(r2, r3, r4);
    L21:
        this.f17362h.resumeWith(r7);     // Catch: Throwable -> L15
        kotlin.f0 r5 = kotlin.f0.f18324a;     // Catch: Throwable -> L15
        if (r1 != null) goto L12;
    L13:
        h.a.f3.j0.a(r3, r4);
        return;
    L12:
        if (r1.Q0() == true) goto L13;
        return;
    L15:
        th = move-exception;
        if (r1 != null) goto L18;
    L19:
        h.a.f3.j0.a(r3, r4);
    L20:
        throw th;
    L18:
        if (r1.Q0() == false) goto L20;
        goto L19
    }

    public final boolean Q0() {
        if (this.f17180i.get() != null) goto L6;
        return false;
    L6:
        this.f17180i.set(null);
        return true;
    }

    public final void R0(kotlin.k0.g r1, Object r2) {
        this.f17180i.set(kotlin.a0.a(r1, r2));
    }
}
