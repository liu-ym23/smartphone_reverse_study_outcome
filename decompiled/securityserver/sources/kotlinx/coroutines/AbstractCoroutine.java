package kotlinx.coroutines;

import a.a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.intrinsics.CancellableKt;

/* JADX INFO: loaded from: classes2.dex */
@InternalCoroutinesApi
@Metadata
public abstract class AbstractCoroutine<T> extends JobSupport implements Job, Continuation<T>, CoroutineScope {
    public final CoroutineContext c;
    public final CoroutineContext e;

    public AbstractCoroutine(CoroutineContext r1, boolean r2) {
        super(r2);
        this.e = r1;
        this.c = r1.i(this);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext A() {
        return this.c;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final String R() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void e0(CompletionHandlerException r1) {
        CoroutineExceptionHandlerKt.a(this.c, r1);
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.c;
    }

    @Override // kotlinx.coroutines.JobSupport
    public String j0() {
        boolean r0 = CoroutineContextKt.f366a;
        String r1 = null;
        if (DebugKt.f370a == false) goto L8;
        CoroutineId.Key r2 = CoroutineId.e;
        CoroutineContext r3 = this.c;
        CoroutineId r4 = (CoroutineId) r3.f(r2);
        if (r4 == null) goto L8;
        CoroutineName r5 = (CoroutineName) r3.f(CoroutineName.c);
        r1 = "coroutine#" + r4.c;
    L8:
        if (r1 == null) goto L12;
        StringBuilder r6 = a.u("\"", r1, "\":");
        r6.append(super.j0());
        return r6.toString();
    L12:
        return super.j0();
    }

    @Override // kotlin.coroutines.Continuation
    public final void k(Object r3) {
        Throwable r0 = Result.a(r3);
        if (r0 == null) goto L6;
        r3 = new CompletedExceptionally(r0, false);
    L6:
        Object r4 = h0(r3);
        if (r4 != JobSupportKt.b) goto L9;
        return;
    L9:
        N(r4);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void n0(Object r2) {
        if ((r2 instanceof CompletedExceptionally) == false) goto L5;
        CompletedExceptionally r3 = (CompletedExceptionally) r2;
        v0(r3.f364a, r3.a());
        return;
    L5:
        w0(r2);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void o0() {
        x0();
    }

    public void v0(Throwable r1, boolean r2) {
    }

    public void w0(Object r1) {
    }

    public void x0() {
    }

    public final void y0(CoroutineStart r4, AbstractCoroutine r5, Function2 r6) {
        f0((Job) this.e.f(Job.g));
        int r7 = r4.ordinal();
        if (r7 != 0) goto L5;
        CancellableKt.b(r6, r5, this, null);
        return;
    L5:
        if (r7 != 1) goto L7;
        return;
    L7:
        if (r7 != 2) goto L9;
        IntrinsicsKt.b(IntrinsicsKt.a(r5, this, r6)).k(Unit.f330a);
        return;
    L9:
        if (r7 != 3) goto L23;
        CoroutineContext r8 = this.c;     // Catch: Throwable -> L16
        Object r0 = ThreadContextKt.c(r8, null);     // Catch: Throwable -> L16
        TypeIntrinsics.b(2, r6);     // Catch: Throwable -> L18
        Object r9 = r6.mo7invoke(r5, this);     // Catch: Throwable -> L18
        ThreadContextKt.a(r8, r0);     // Catch: Throwable -> L16
        if (r9 == CoroutineSingletons.b) goto L31;
        k(r9);
        return;
    L31:
        return;
    L18:
        th = move-exception;
        ThreadContextKt.a(r8, r0);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        k(ResultKt.a(th));
        return;
    L23:
        throw new NoWhenBranchMatchedException();
    }
}
