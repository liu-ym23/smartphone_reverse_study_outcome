package kotlin.coroutines;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
@ExperimentalStdlibApi
public abstract class AbstractCoroutineContextKey<B extends CoroutineContext.Element, E extends B> implements CoroutineContext.Key<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1 f334a;
    public final CoroutineContext.Key b;

    public AbstractCoroutineContextKey(CoroutineContext.Key r2, Function1 r3) {
        Intrinsics.f(r2, "baseKey");
        this.f334a = r3;
        if ((r2 instanceof AbstractCoroutineContextKey) == false) goto L5;
        r2 = ((AbstractCoroutineContextKey) r2).b;
    L5:
        this.b = r2;
    }
}
