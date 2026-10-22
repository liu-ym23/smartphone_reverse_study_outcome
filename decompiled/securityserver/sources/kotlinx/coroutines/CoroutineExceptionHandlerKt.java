package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CoroutineExceptionHandlerKt {
    public static final void a(CoroutineContext r3, Throwable r4) {
        CoroutineExceptionHandler r0 = (CoroutineExceptionHandler) r3.f(CoroutineExceptionHandler.Key.f368a);     // Catch: Throwable -> L6
        if (r0 == null) goto L8;
        r0.y();     // Catch: Throwable -> L6
        return;
    L8:
        CoroutineExceptionHandlerImplKt.a(r3, r4);
        return;
    L6:
        th = move-exception;
        if (r4 == th) goto L13;
        RuntimeException r1 = new RuntimeException("Exception while trying to handle coroutine exception", th);
        kotlin.ExceptionsKt.a(r1, r4);
        r4 = r1;
    L13:
        CoroutineExceptionHandlerImplKt.a(r3, r4);
    }
}
