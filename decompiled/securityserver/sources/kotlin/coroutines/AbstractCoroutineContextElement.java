package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
public abstract class AbstractCoroutineContextElement implements CoroutineContext.Element {
    public final CoroutineContext.Key b;

    public AbstractCoroutineContextElement(CoroutineContext.Key r2) {
        Intrinsics.f(r2, "key");
        this.b = r2;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public Object H(Object r1, Function2 r2) {
        return r2.mo7invoke(r1, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext.Element f(CoroutineContext.Key r1) {
        return CoroutineContext.Element.DefaultImpls.a(this, r1);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return this.b;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext i(CoroutineContext r1) {
        return CoroutineContext.Element.DefaultImpls.c(this, r1);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext v(CoroutineContext.Key r1) {
        return CoroutineContext.Element.DefaultImpls.b(this, r1);
    }
}
