package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DebugStringsKt {
    public static final String a(Object r0) {
        return Integer.toHexString(System.identityHashCode(r0));
    }

    public static final String b(Continuation r3) {
        if ((r3 instanceof DispatchedContinuation) == false) goto L16;
        return r3.toString();
    L16:
        Object r1 = r3 + '@' + a(r3);     // Catch: Throwable -> L8
    L11:
        if (Result.a(r1) == null) goto L15;
        r1 = r3.getClass().getName() + '@' + a(r3);
    L15:
        return (String) r1;
    L8:
        th = move-exception;
        r1 = ResultKt.a(th);
        goto L11
    }
}
