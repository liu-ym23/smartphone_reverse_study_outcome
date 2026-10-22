package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ThreadContextKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Symbol f428a = null;
    public static final Function2 b = null;
    public static final Function2 c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Function2 f429d = null;
    public static final Function2 e = null;

    static {
        f428a = new Symbol("ZERO");
    }

    public static final void a(CoroutineContext r2, Object r3) {
        if (r3 != f428a) goto L6;
        return;
    L6:
        if ((r3 instanceof ThreadState) == false) goto L8;
        ((ThreadState) r3).b = 0;
        r2.H(r3, ThreadContextKt$restoreState$1.b);
        return;
    L8:
        Object r4 = r2.H(null, ThreadContextKt$findOne$1.b);
        if (r4 == null) goto L13;
        ((ThreadContextElement) r4).D(r3);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
    }

    public static final Object b(CoroutineContext r2) {
        Object r3 = r2.H(0, ThreadContextKt$countAll$1.b);
        Intrinsics.c(r3);
        return r3;
    }

    public static final Object c(CoroutineContext r1, Object r2) {
        if (r2 != null) goto L6;
        r2 = b(r1);
    L6:
        if (r2 != 0) goto L9;
        return f428a;
    L9:
        if ((r2 instanceof Integer) == false) goto L12;
        return r1.H(new ThreadState(r1, ((Number) r2).intValue()), ThreadContextKt$updateState$1.b);
    L12:
        return ((ThreadContextElement) r2).K(r1);
    }
}
