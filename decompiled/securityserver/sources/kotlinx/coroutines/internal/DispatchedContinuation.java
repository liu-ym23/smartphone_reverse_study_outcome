package kotlinx.coroutines.internal;

import d.b;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletedWithCancellation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.ThreadLocalEventLoop;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DispatchedContinuation<T> extends DispatchedTask<T> implements CoroutineStackFrame, Continuation<T> {
    public static final AtomicReferenceFieldUpdater m = null;
    private volatile Object _reusableCancellableContinuation;
    public Object f;
    public final CoroutineStackFrame i;
    public final Object j;
    public final CoroutineDispatcher k;
    public final Continuation l;

    static {
        m = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation");
    }

    public DispatchedContinuation(CoroutineDispatcher r2, ContinuationImpl r3) {
        super(-1);
        this.k = r2;
        this.l = r3;
        this.f = DispatchedContinuationKt.f411a;
        this.i = r3;
        this.j = ThreadContextKt.b(r3.getContext());
        this._reusableCancellableContinuation = null;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final void a(Object r1, CancellationException r2) {
        if ((r1 instanceof CompletedWithCancellation) == false) goto L6;
        ((CompletedWithCancellation) r1).b.invoke(r2);
        return;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Continuation b() {
        return this;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame e() {
        return this.i;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.l.getContext();
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Object i() {
        Object r0 = this.f;
        boolean r1 = DebugKt.f370a;
        this.f = DispatchedContinuationKt.f411a;
        return r0;
    }

    public final Throwable j(CancellableContinuation r4) {
    L2:
        Object r0 = this._reusableCancellableContinuation;
        Symbol r1 = DispatchedContinuationKt.b;
        if (r0 != r1) goto L7;
        if (m.compareAndSet(this, r1, r4) == false) goto L2;
        return null;
    L7:
        if (r0 != null) goto L10;
        return null;
    L10:
        if ((r0 instanceof Throwable) == false) goto L18;
        if (m.compareAndSet(this, r0, null) == false) goto L16;
        return (Throwable) r0;
    L16:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L18:
        throw new IllegalStateException(b.a(r0, "Inconsistent state ").toString());
    }

    @Override // kotlin.coroutines.Continuation
    public final void k(Object r7) {
        Continuation r0 = this.l;
        CoroutineContext r1 = r0.getContext();
        Throwable r2 = Result.a(r7);
        if (r2 != null) goto L5;
        Object r4 = r7;
    L6:
        CoroutineDispatcher r3 = this.k;
        if (r3.l() == false) goto L9;
        this.f = r4;
        this.e = 0;
        r3.j(r1, this);
        return;
    L9:
        boolean r5 = DebugKt.f370a;
        EventLoop r6 = ThreadLocalEventLoop.a();
        if (r6.u() == false) goto L12;
        this.f = r4;
        this.e = 0;
        r6.n(this);
        return;
    L12:
        r6.s(true);
        CoroutineContext r8 = r0.getContext();     // Catch: Throwable -> L19
        Object r9 = ThreadContextKt.c(r8, this.j);     // Catch: Throwable -> L19
        r0.k(r7);     // Catch: Throwable -> L21
        ThreadContextKt.a(r8, r9);     // Catch: Throwable -> L19
    L17:
        if (r6.w() == true) goto L17;
    L18:
        r6.m();
        return;
    L21:
        th = move-exception;
        ThreadContextKt.a(r8, r9);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        h(th, null);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        r6.m();
        throw th;
    L5:
        r4 = new CompletedExceptionally(r2, false);
        goto L6
    }

    public final CancellableContinuationImpl l() {
    L2:
        Object r0 = this._reusableCancellableContinuation;
        Symbol r1 = DispatchedContinuationKt.b;
        if (r0 == null) goto L4;
        if ((r0 instanceof CancellableContinuationImpl) == false) goto L13;
        if (m.compareAndSet(this, r0, r1) == false) goto L2;
        return (CancellableContinuationImpl) r0;
    L13:
        throw new IllegalStateException(b.a(r0, "Inconsistent state ").toString());
    L4:
        this._reusableCancellableContinuation = r1;
        return null;
    }

    public final CancellableContinuationImpl n() {
        Object r1 = this._reusableCancellableContinuation;
        if ((r1 instanceof CancellableContinuationImpl) == true) goto L6;
        r1 = null;
    L6:
        return (CancellableContinuationImpl) r1;
    }

    public final boolean o(CancellableContinuationImpl r4) {
        Object r3 = this._reusableCancellableContinuation;
        if (r3 != null) goto L5;
        return false;
    L5:
        if ((r3 instanceof CancellableContinuationImpl) == false) goto L9;
        if (r3 == r4) goto L8;
        return false;
    L8:
        return true;
    L9:
        return true;
    }

    public final boolean p(Throwable r5) {
    L2:
        Object r0 = this._reusableCancellableContinuation;
        Symbol r1 = DispatchedContinuationKt.b;
        if (Intrinsics.a(r0, r1) == true) goto L5;
        if ((r0 instanceof Throwable) == true) goto L9;
        if (m.compareAndSet(this, r0, null) == false) goto L2;
        return false;
    L9:
        return true;
    L5:
        if (m.compareAndSet(this, r1, r5) == false) goto L2;
        return true;
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.k + ", " + DebugStringsKt.b(this.l) + ']';
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement w() {
        return null;
    }
}
