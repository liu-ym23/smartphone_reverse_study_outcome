package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ThreadLocalElement<T> implements ThreadContextElement<T> {
    @Override // kotlinx.coroutines.ThreadContextElement
    public final void D(Object r1) {
        throw null;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object H(Object r1, Function2 r2) {
        return r2.mo7invoke(r1, this);
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public final Object K(CoroutineContext r1) {
        throw null;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element f(CoroutineContext.Key r2) {
        if (Intrinsics.a(null, r2) == false) goto L6;
        return this;
    L6:
        return null;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return null;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext i(CoroutineContext r1) {
        return CoroutineContext.Element.DefaultImpls.c(this, r1);
    }

    public final String toString() {
        return "ThreadLocal(value=null, threadLocal = null)";
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext v(CoroutineContext.Key r2) {
        if (Intrinsics.a(null, r2) == true) goto L5;
        return this;
    L5:
        return EmptyCoroutineContext.b;
    }
}
