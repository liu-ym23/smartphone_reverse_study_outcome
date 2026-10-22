package kotlinx.coroutines.internal;

import d.b;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OnUndeliveredElementKt {
    public static final Function1 a(final Function1 r1, final Object r2, final CoroutineContext r3) {
        return new OnUndeliveredElementKt$bindCancellationFun$1(r1, r2, r3);
    }

    public static final UndeliveredElementException b(Function1 r1, Object r2, UndeliveredElementException r3) {
        r1.invoke(r2);     // Catch: Throwable -> L4
    L9:
        return r3;
    L4:
        th = move-exception;
        if (r3 == null) goto L11;
        if (r3.getCause() == th) goto L11;
        ExceptionsKt.a(r3, th);
    L11:
        return new UndeliveredElementException(b.a(r2, "Exception in undelivered element handler for "), th);
    }
}
