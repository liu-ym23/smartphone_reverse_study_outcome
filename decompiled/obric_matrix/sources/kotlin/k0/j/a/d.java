package kotlin.k0.j.a;

import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b!\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005B!\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003J\b\u0010\r\u001a\u00020\u000eH\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "_context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;)V", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "intercepted", "releaseIntercepted", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class d extends a {
    private final kotlin.k0.g _context;
    private transient kotlin.k0.d<Object> intercepted;

    public d(kotlin.k0.d<Object> r2) {
        if (r2 == null) goto L4;
        kotlin.k0.g r0 = r2.getContext();
    L5:
        this(r2, r0);
        return;
    L4:
        r0 = null;
        goto L5
    }

    public d(kotlin.k0.d<Object> r1, kotlin.k0.g r2) {
        super(r1);
        this._context = r2;
    }

    @Override // kotlin.k0.d
    public kotlin.k0.g getContext() {
        kotlin.k0.g r0 = this._context;
        o.c(r0);
        return r0;
    }

    public final kotlin.k0.d<Object> intercepted() {
        kotlin.k0.d<Object> r0 = this.intercepted;
        if (r0 != null) goto L10;
        kotlin.k0.e r1 = (kotlin.k0.e) getContext().get(kotlin.k0.e.f18396a);
        if (r1 == null) goto L8;
        r0 = r1.interceptContinuation(this);
        if (r0 == null) goto L8;
    L9:
        this.intercepted = r0;
    L8:
        r0 = this;
    L10:
        return r0;
    }

    @Override // kotlin.k0.j.a.a
    protected void releaseIntercepted() {
        kotlin.k0.d<?> r0 = this.intercepted;
        if (r0 == null) goto L6;
        if (r0 == this) goto L6;
        kotlin.k0.g.b r1 = getContext().get(kotlin.k0.e.f18396a);
        o.c(r1);
        ((kotlin.k0.e) r1).releaseInterceptedContinuation(r0);
    L6:
        this.intercepted = c.f18410f;
    }
}
