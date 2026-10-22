package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DispatchedTaskKt {
    public static final boolean a(int r2) {
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public static final void b(DispatchedTask r2, Continuation r3, boolean r4) {
        Object r0 = r2.i();
        Throwable r1 = r2.d(r0);
        if (r1 == null) goto L5;
        Object r5 = ResultKt.a(r1);
    L6:
        if (r4 == false) goto L16;
        if (r3 == null) goto L15;
        DispatchedContinuation r6 = (DispatchedContinuation) r3;
        Continuation r7 = r6.l;
        CoroutineContext r8 = r7.getContext();
        Object r9 = ThreadContextKt.c(r8, r6.j);
        r7.k(r5);     // Catch: Throwable -> L11
        ThreadContextKt.a(r8, r9);
        return;
    L11:
        th = move-exception;
        ThreadContextKt.a(r8, r9);
        throw th;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
    L16:
        r3.k(r5);
        return;
    L5:
        r5 = r2.f(r0);
        goto L6
    }
}
