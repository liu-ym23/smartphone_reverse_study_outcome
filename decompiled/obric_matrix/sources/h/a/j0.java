package h.a;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a%\u0010\u0000\u001a\u00020\u00012\u001a\b\u0004\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003H\u0086\b\u001a\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0005H\u0007\u001a\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0000¨\u0006\r"}, d2 = {"CoroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handler", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "", "", "handleCoroutineException", "context", "exception", "handlerException", "originalException", "thrownException", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class j0 {
    public static final void a(kotlin.k0.g r1, Throwable r2) {
        h0 r0 = (h0) r1.get(h0.f17446c);     // Catch: Throwable -> L8
        if (r0 != null) goto L6;
        i0.a(r1, r2);
        return;
    L6:
        r0.handleException(r1, r2);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        i0.a(r1, b(r2, th));
    }

    public static final Throwable b(Throwable r2, Throwable r3) {
        if (r2 != r3) goto L4;
        return r2;
    L4:
        RuntimeException r0 = new RuntimeException("Exception while trying to handle coroutine exception", r3);
        kotlin.a.a(r0, r2);
        return r0;
    }
}
