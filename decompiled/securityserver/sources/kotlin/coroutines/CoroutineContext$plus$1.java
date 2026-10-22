package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class CoroutineContext$plus$1 extends Lambda implements Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext> {
    public static final CoroutineContext$plus$1 b = null;

    static {
        b = new CoroutineContext$plus$1(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r3, Object r4) {
        CoroutineContext r5 = (CoroutineContext) r3;
        CoroutineContext.Element r6 = (CoroutineContext.Element) r4;
        Intrinsics.f(r5, "acc");
        Intrinsics.f(r6, "element");
        CoroutineContext r2 = r5.v(r6.getKey());
        EmptyCoroutineContext r7 = EmptyCoroutineContext.b;
        if (r2 == r7) goto L15;
        ContinuationInterceptor.Key r0 = ContinuationInterceptor.Key.f336a;
        ContinuationInterceptor r1 = (ContinuationInterceptor) r2.f(r0);
        if (r1 != null) goto L9;
        CombinedContext r8 = new CombinedContext(r6, r2);
    L13:
        return r8;
    L9:
        CoroutineContext r9 = r2.v(r0);
        if (r9 == r7) goto L14;
        r8 = new CombinedContext(r1, new CombinedContext(r6, r9));
        goto L13
    L14:
        return new CombinedContext(r1, r6);
    L15:
        return r6;
    }
}
