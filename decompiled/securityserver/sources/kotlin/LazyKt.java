package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class LazyKt extends LazyKt__LazyKt {
    public static Lazy a(Function0 r1) {
        return new SynchronizedLazyImpl(r1);
    }

    public static Lazy b(Function0 r1) {
        Intrinsics.f(r1, "initializer");
        return new SynchronizedLazyImpl(r1);
    }
}
