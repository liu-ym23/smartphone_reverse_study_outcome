package h.a.h3;

import h.a.j0;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.k0.g;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"handleUndeliverableException", "", "cause", "", "context", "Lkotlin/coroutines/CoroutineContext;", "kotlinx-coroutines-rx2"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class c {
    public static final void a(Throwable r1, g r2) {
        if ((r1 instanceof CancellationException) == false) goto L10;
        return;
    L10:
        f.a.k.a.m(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        kotlin.a.a(r1, th);
        j0.a(r2, r1);
    }
}
