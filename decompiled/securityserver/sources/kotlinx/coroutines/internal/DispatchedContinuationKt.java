package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletedWithCancellation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DispatchedContinuationKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Symbol f411a = null;
    public static final Symbol b = null;

    static {
        f411a = new Symbol("UNDEFINED");
        b = new Symbol("REUSABLE_CLAIMED");
    }

    public static final void a(Object r4, Continuation r5, Function1 r6) {
        if ((r5 instanceof DispatchedContinuation) == false) goto L39;
        DispatchedContinuation r7 = (DispatchedContinuation) r5;
        Throwable r0 = Result.a(r4);
        if (r0 != null) goto L9;
        if (r6 == null) goto L8;
        Object r1 = new CompletedWithCancellation(r4, r6);
    L10:
        Continuation r8 = r7.l;
        r8.getContext();
        CoroutineDispatcher r2 = r7.k;
        if (r2.l() == false) goto L13;
        r7.f = r1;
        r7.e = 1;
        r2.j(r8.getContext(), r7);
        return;
    L13:
        boolean r3 = DebugKt.f370a;
        EventLoop r9 = ThreadLocalEventLoop.a();
        if (r9.u() == false) goto L16;
        r7.f = r1;
        r7.e = 1;
        r9.n(r7);
        return;
    L16:
        r9.s(true);
        Job r10 = (Job) r8.getContext().f(Job.g);     // Catch: Throwable -> L22
        if (r10 != null) goto L20;
    L24:
        CoroutineContext r11 = r8.getContext();     // Catch: Throwable -> L22
        Object r12 = ThreadContextKt.c(r11, r7.j);     // Catch: Throwable -> L22
        r8.k(r4);     // Catch: Throwable -> L30
        ThreadContextKt.a(r11, r12);     // Catch: Throwable -> L22
    L28:
        if (r9.w() == true) goto L28;
    L29:
        r9.m();
        return;
    L30:
        th = move-exception;
        ThreadContextKt.a(r11, r12);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L20:
        if (r10.isActive() == true) goto L24;
        CancellationException r13 = r10.q();     // Catch: Throwable -> L22
        r7.a(r1, r13);     // Catch: Throwable -> L22
        r7.k(ResultKt.a(r13));     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r7.h(th, null);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        r9.m();
        throw th;
    L8:
        r1 = r4;
        goto L10
    L9:
        r1 = new CompletedExceptionally(r0, false);
        goto L10
    L39:
        r5.k(r4);
    }
}
