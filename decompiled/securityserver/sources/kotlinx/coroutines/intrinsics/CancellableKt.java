package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.DispatchedContinuationKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CancellableKt {
    public static final void a(Continuation r2, Continuation r3) {
        Continuation r4 = IntrinsicsKt.b(r2);     // Catch: Throwable -> L4
        DispatchedContinuationKt.a(Unit.f330a, r4, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        r3.k(ResultKt.a(th));
    }

    public static final void b(Function2 r0, Object r1, Continuation r2, Function1 r3) {
        Continuation r4 = IntrinsicsKt.b(IntrinsicsKt.a(r1, r2, r0));     // Catch: Throwable -> L4
        DispatchedContinuationKt.a(Unit.f330a, r4, r3);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        r2.k(ResultKt.a(th));
    }
}
