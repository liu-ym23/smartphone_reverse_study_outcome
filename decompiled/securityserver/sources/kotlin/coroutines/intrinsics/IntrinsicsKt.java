package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class IntrinsicsKt extends IntrinsicsKt__IntrinsicsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static Continuation a(final Object r2, final Continuation r3, final Function2 r4) {
        Intrinsics.f(r4, "<this>");
        Intrinsics.f(r3, "completion");
        if ((r4 instanceof BaseContinuationImpl) == true) goto L10;
        final CoroutineContext r0 = r3.getContext();
        if (r0 != EmptyCoroutineContext.b) goto L9;
        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3(r2, r3, r4);
    L9:
        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4(r3, r0, r4, r2);
    L10:
        return ((BaseContinuationImpl) r4).f(r2, r3);
    }

    public static Continuation b(Continuation r2) {
        Intrinsics.f(r2, "<this>");
        if ((r2 instanceof ContinuationImpl) == false) goto L5;
        ContinuationImpl r0 = (ContinuationImpl) r2;
    L6:
        if (r0 == null) goto L14;
        r2 = r0.e;
        if (r2 != null) goto L14;
        ContinuationInterceptor r3 = (ContinuationInterceptor) r0.getContext().f(ContinuationInterceptor.Key.f336a);
        if (r3 == null) goto L12;
        r2 = r3.C(r0);
    L13:
        r0.e = r2;
        goto L14
    L12:
        r2 = r0;
    L14:
        return r2;
    L5:
        r0 = null;
        goto L6
    }
}
