package h.a.f3;

import com.bytedance.common.wschannel.WsConstants;
import h.a.x1;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u000e\u0010\u0019\u001a\n\u0018\u00010\u001aj\u0004\u0018\u0001`\u001bR\u0019\u0010\n\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/internal/ScopeCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "isScopedCoroutine", "", "()Z", "parent", "Lkotlinx/coroutines/Job;", "getParent$kotlinx_coroutines_core", "()Lkotlinx/coroutines/Job;", "afterCompletion", "", WsConstants.KEY_CONNECTION_STATE, "", "afterResume", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class d0<T> extends h.a.a<T> implements kotlin.k0.j.a.e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final kotlin.k0.d<T> f17362h;

    /* JADX WARN: Multi-variable type inference failed */
    public d0(kotlin.k0.g r2, kotlin.k0.d<? super T> r3) {
        super(r2, true, true);
        this.f17362h = r3;
    }

    @Override // h.a.a
    protected void L0(Object r1) {
        kotlin.k0.d<T> r0 = this.f17362h;
        r0.resumeWith(h.a.c0.a(r1, r0));
    }

    public final x1 P0() {
        h.a.t r0 = b0();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getParent();
    }

    @Override // kotlin.k0.j.a.e
    public final kotlin.k0.j.a.e getCallerFrame() {
        kotlin.k0.d<T> r1 = this.f17362h;
        if ((r1 instanceof kotlin.k0.j.a.e) == true) goto L7;
        return null;
    L7:
        return (kotlin.k0.j.a.e) r1;
    }

    @Override // kotlin.k0.j.a.e
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // h.a.f2
    protected final boolean k0() {
        return true;
    }

    @Override // h.a.f2
    protected void w(Object r3) {
        j.c(kotlin.k0.i.b.b(this.f17362h), h.a.c0.a(r3, this.f17362h), null, 2, null);
    }
}
