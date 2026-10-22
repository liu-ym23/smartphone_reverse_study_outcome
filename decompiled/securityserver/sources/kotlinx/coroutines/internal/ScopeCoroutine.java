package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CompletionStateKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class ScopeCoroutine<T> extends AbstractCoroutine<T> implements CoroutineStackFrame {
    public final Continuation f;

    public ScopeCoroutine(Continuation r2, CoroutineContext r3) {
        super(r3, true);
        this.f = r2;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void M(Object r2) {
        Continuation r1 = this.f;
        Continuation r0 = IntrinsicsKt.b(r1);
        DispatchedContinuationKt.a(CompletionStateKt.a(r2, r1), r0, null);
    }

    @Override // kotlinx.coroutines.JobSupport
    public void N(Object r1) {
        Continuation r0 = this.f;
        r0.k(CompletionStateKt.a(r1, r0));
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame e() {
        Continuation r1 = this.f;
        if ((r1 instanceof CoroutineStackFrame) == true) goto L6;
        r1 = null;
    L6:
        return (CoroutineStackFrame) r1;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean g0() {
        return true;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement w() {
        return null;
    }
}
