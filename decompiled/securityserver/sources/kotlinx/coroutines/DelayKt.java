package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DelayKt {
    public static final Object a(long r3, Continuation r5) {
        if (r3 <= 0) goto L5;
        CancellableContinuationImpl r0 = new CancellableContinuationImpl(1, IntrinsicsKt.b(r5));
        r0.D();
        if (r3 >= Long.MAX_VALUE) goto L10;
        b(r0.f).e(r3, r0);
    L10:
        return r0.s();
    L5:
        return Unit.f330a;
    }

    public static final Delay b(CoroutineContext r1) {
        CoroutineContext.Element r2 = r1.f(ContinuationInterceptor.Key.f336a);
        if ((r2 instanceof Delay) == true) goto L5;
        r2 = null;
    L5:
        Delay r3 = (Delay) r2;
        if (r3 == null) goto L9;
        return r3;
    L9:
        return DefaultExecutorKt.f371a;
    }
}
