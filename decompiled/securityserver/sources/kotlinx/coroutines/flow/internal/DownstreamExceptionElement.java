package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DownstreamExceptionElement implements CoroutineContext.Element {
    public static final Key c = null;
    public final Throwable b;

    @Metadata
    public static final class Key implements CoroutineContext.Key<DownstreamExceptionElement> {
    }

    static {
        c = new Key();
    }

    public DownstreamExceptionElement(Throwable r1) {
        this.b = r1;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object H(Object r1, Function2 r2) {
        return r2.mo7invoke(r1, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element f(CoroutineContext.Key r1) {
        return CoroutineContext.Element.DefaultImpls.a(this, r1);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return c;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext i(CoroutineContext r1) {
        return CoroutineContext.Element.DefaultImpls.c(this, r1);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext v(CoroutineContext.Key r1) {
        return CoroutineContext.Element.DefaultImpls.b(this, r1);
    }
}
