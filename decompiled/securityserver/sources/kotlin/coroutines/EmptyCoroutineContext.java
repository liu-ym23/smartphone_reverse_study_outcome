package kotlin.coroutines;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
public final class EmptyCoroutineContext implements CoroutineContext, Serializable {
    public static final EmptyCoroutineContext b = null;

    static {
        b = new EmptyCoroutineContext();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object H(Object r1, Function2 r2) {
        return r1;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element f(CoroutineContext.Key r1) {
        Intrinsics.f(r1, "key");
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext i(CoroutineContext r1) {
        Intrinsics.f(r1, "context");
        return r1;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext v(CoroutineContext.Key r2) {
        Intrinsics.f(r2, "key");
        return this;
    }
}
