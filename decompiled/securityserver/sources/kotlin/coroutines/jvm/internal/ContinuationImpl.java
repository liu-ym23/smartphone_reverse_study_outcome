package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
public abstract class ContinuationImpl extends BaseContinuationImpl {
    public final CoroutineContext c;
    public transient Continuation e;

    public ContinuationImpl(Continuation r1, CoroutineContext r2) {
        super(r1);
        this.c = r2;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        CoroutineContext r0 = this.c;
        Intrinsics.c(r0);
        return r0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void j() {
        Continuation r0 = this.e;
        if (r0 == null) goto L6;
        if (r0 == this) goto L6;
        CoroutineContext.Element r1 = getContext().f(ContinuationInterceptor.Key.f336a);
        Intrinsics.c(r1);
        ((ContinuationInterceptor) r1).b(r0);
    L6:
        this.e = CompletedContinuation.b;
    }

    public ContinuationImpl(Continuation r2) {
        if (r2 == null) goto L4;
        CoroutineContext r0 = r2.getContext();
    L5:
        this(r2, r0);
        return;
    L4:
        r0 = null;
        goto L5
    }
}
