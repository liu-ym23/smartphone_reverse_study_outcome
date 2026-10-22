package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class StackFrameContinuation<T> implements Continuation<T>, CoroutineStackFrame {
    public final Continuation b;
    public final CoroutineContext c;

    public StackFrameContinuation(Continuation r1, CoroutineContext r2) {
        this.b = r1;
        this.c = r2;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame e() {
        Continuation r1 = this.b;
        if ((r1 instanceof CoroutineStackFrame) == true) goto L6;
        r1 = null;
    L6:
        return (CoroutineStackFrame) r1;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.c;
    }

    @Override // kotlin.coroutines.Continuation
    public final void k(Object r1) {
        this.b.k(r1);
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement w() {
        return null;
    }
}
