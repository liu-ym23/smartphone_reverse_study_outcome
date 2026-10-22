package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.NonBlockingContext;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class DispatchedTask<T> extends Task {
    public int e;

    public DispatchedTask(int r4) {
        super(0, NonBlockingContext.b);
        this.e = r4;
    }

    public void a(Object r1, CancellationException r2) {
    }

    public abstract Continuation b();

    public Throwable d(Object r2) {
        if ((r2 instanceof CompletedExceptionally) == true) goto L5;
        r2 = null;
    L5:
        CompletedExceptionally r3 = (CompletedExceptionally) r2;
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.f364a;
    }

    public Object f(Object r1) {
        return r1;
    }

    public final void h(Throwable r3, Throwable r4) {
        if (r3 != null) goto L5;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 == null) goto L8;
        if (r4 == null) goto L8;
        kotlin.ExceptionsKt.a(r3, r4);
    L8:
        if (r3 != null) goto L11;
        r3 = r4;
    L11:
        Intrinsics.c(r3);
        CoroutineExceptionHandlerKt.a(b().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", r3));
    }

    public abstract Object i();

    @Override // java.lang.Runnable
    public final void run() {
        Object r0 = Unit.f330a;
        boolean r1 = DebugKt.f370a;
        TaskContext r2 = this.c;
        Continuation r3 = b();     // Catch: Throwable -> L33
        if (r3 == null) goto L38;
        DispatchedContinuation r4 = (DispatchedContinuation) r3;     // Catch: Throwable -> L33
        Continuation r5 = r4.l;     // Catch: Throwable -> L33
        CoroutineContext r6 = r5.getContext();     // Catch: Throwable -> L33
        Object r7 = i();     // Catch: Throwable -> L33
        Object r8 = ThreadContextKt.c(r6, r4.j);     // Catch: Throwable -> L33
        Throwable r9 = d(r7);     // Catch: Throwable -> L11
        if (r9 == null) goto L9;
    L13:
        Job r10 = null;
    L14:
        if (r10 != null) goto L16;
    L24:
        if (r9 == null) goto L26;
        r5.k(ResultKt.a(r9));     // Catch: Throwable -> L11
    L27:
        ThreadContextKt.a(r6, r8);     // Catch: Throwable -> L33
        r2.c();     // Catch: Throwable -> L30
    L32:
        h(null, Result.a(r0));
        return;
    L30:
        th = move-exception;
        r0 = ResultKt.a(th);
        goto L32
    L26:
        r5.k(f(r7));     // Catch: Throwable -> L11
        goto L27
    L16:
        if (r10.isActive() == true) goto L24;
        CancellationException r11 = r10.q();     // Catch: Throwable -> L11
        a(r7, r11);     // Catch: Throwable -> L11
        Throwable r12 = r11;
        if (DebugKt.b == true) goto L20;
    L23:
        r5.k(ResultKt.a(r12));     // Catch: Throwable -> L11
        goto L27
    L20:
        if ((r5 instanceof CoroutineStackFrame) == true) goto L22;
        r12 = r11;
        goto L23
    L22:
        r12 = StackTraceRecoveryKt.a(r11, (CoroutineStackFrame) r5);     // Catch: Throwable -> L11
        goto L23
    L9:
        if (DispatchedTaskKt.a(this.e) == false) goto L13;
        r10 = (Job) r6.f(Job.g);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        ThreadContextKt.a(r6, r8);     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L38:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        r2.c();     // Catch: Throwable -> L41
    L43:
        h(th, Result.a(r0));
        return;
    L41:
        th = move-exception;
        r0 = ResultKt.a(th);
        goto L43
    }
}
