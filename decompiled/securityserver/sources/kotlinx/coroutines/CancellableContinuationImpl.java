package kotlinx.coroutines;

import d.b;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@PublishedApi
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame {
    public static final AtomicIntegerFieldUpdater j = null;
    public static final AtomicReferenceFieldUpdater k = null;
    private volatile int _decision;
    private volatile Object _parentHandle;
    private volatile Object _state;
    public final CoroutineContext f;
    public final Continuation i;

    static {
        j = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decision");
        k = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state");
    }

    public CancellableContinuationImpl(int r1, Continuation r2) {
        super(r1);
        this.i = r2;
        boolean r3 = DebugKt.f370a;
        this.f = r2.getContext();
        this._decision = 0;
        this._state = Active.b;
        this._parentHandle = null;
    }

    public static Object C(NotCompleted r7, Object r8, int r9, Function1 r10, Object r11) {
        if ((r8 instanceof CompletedExceptionally) == false) goto L6;
        boolean r12 = DebugKt.f370a;
        return r8;
    L6:
        if (DispatchedTaskKt.a(r9) == true) goto L9;
        if (r11 != null) goto L9;
        return r8;
    L9:
        if (r10 != null) goto L16;
        if ((r7 instanceof CancelHandler) == true) goto L13;
    L14:
        if (r11 != null) goto L16;
        return r8;
    L13:
        if ((r7 instanceof BeforeResumeCancelHandler) == true) goto L14;
    L16:
        if ((r7 instanceof CancelHandler) == true) goto L18;
        r7 = null;
    L18:
        CancellationException r5 = null;
        return new CompletedContinuation(r8, (CancelHandler) r7, r10, r11, r5, 16);
    }

    public static void v(Object r2, Function1 r3) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + r3 + ", already has " + r2).toString());
    }

    public final void A(Object r4, int r5, Function1 r6) {
    L2:
        Object r0 = this._state;
        if ((r0 instanceof NotCompleted) == false) goto L16;
        Object r1 = C((NotCompleted) r0, r4, r5, r6, null);
        if (k.compareAndSet(this, r0, r1) == false) goto L2;
        Continuation r7 = this.i;
        if ((r7 instanceof DispatchedContinuation) == true) goto L10;
    L12:
        p();
    L13:
        q(r5);
        return;
    L10:
        if (((DispatchedContinuation) r7).o(this) == false) goto L12;
    L16:
        if ((r0 instanceof CancelledContinuation) == false) goto L23;
        CancelledContinuation r2 = (CancelledContinuation) r0;
        r2.getClass();
        if (CancelledContinuation.c.compareAndSet(r2, 0, 1) == false) goto L23;
        if (r6 == null) goto L27;
        n(r6, r2.f364a);
        return;
    L27:
        return;
    L23:
        throw new IllegalStateException(b.a(r4, "Already resumed, but proposed with update ").toString());
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void B(CoroutineDispatcher r5) {
        Unit r0 = Unit.f330a;
        Continuation r1 = this.i;
        if ((r1 instanceof DispatchedContinuation) == true) goto L5;
        r1 = null;
    L5:
        DispatchedContinuation r2 = (DispatchedContinuation) r1;
        if (r2 == null) goto L8;
        CoroutineDispatcher r3 = r2.k;
    L9:
        if (r3 != r5) goto L11;
        int r6 = 4;
    L12:
        A(r0, r6, null);
        return;
    L11:
        r6 = this.e;
        goto L12
    L8:
        r3 = null;
        goto L9
    }

    public final void D() {
        boolean r0 = t();
        boolean r3 = true;
        if (this.e != 2) goto L14;
        Continuation r1 = this.i;
        if ((r1 instanceof DispatchedContinuation) == true) goto L7;
        r1 = null;
    L7:
        DispatchedContinuation r2 = (DispatchedContinuation) r1;
        if (r2 == null) goto L14;
        Throwable r4 = r2.j(this);
        if (r4 == null) goto L14;
        if (r0 == true) goto L13;
        o(r4);
    L13:
        r0 = true;
    L14:
        if (r0 == false) goto L17;
        return;
    L17:
        if (((DisposableHandle) this._parentHandle) == null) goto L19;
        return;
    L19:
        Job r5 = (Job) this.i.getContext().f(Job.g);
        if (r5 == null) goto L32;
        DisposableHandle r6 = Job.DefaultImpls.a(r5, true, new ChildContinuation(r5, this), 2);
        this._parentHandle = r6;
        if (t() == false) goto L33;
        Continuation r7 = this.i;
        if ((r7 instanceof DispatchedContinuation) == true) goto L26;
    L28:
        r3 = false;
    L29:
        if (r3 == true) goto L34;
        r6.dispose();
        this._parentHandle = NonDisposableHandle.b;
        return;
    L34:
        return;
    L26:
        if (((DispatchedContinuation) r7).o(this) == false) goto L28;
    L33:
        return;
    }

    public final Symbol E(Object r5, Object r6, Function1 r7) {
    L2:
        Object r0 = this._state;
        boolean r1 = r0 instanceof NotCompleted;
        Symbol r2 = CancellableContinuationImplKt.f361a;
        if (r1 == false) goto L15;
        Object r3 = C((NotCompleted) r0, r5, this.e, r7, r6);
        if (k.compareAndSet(this, r0, r3) == false) goto L2;
        Continuation r8 = this.i;
        if ((r8 instanceof DispatchedContinuation) == true) goto L10;
    L12:
        p();
    L13:
        return r2;
    L10:
        if (((DispatchedContinuation) r8).o(this) == false) goto L12;
    L15:
        if ((r0 instanceof CompletedContinuation) == false) goto L22;
        if (r6 == null) goto L21;
        if (((CompletedContinuation) r0).f363d != r6) goto L21;
        boolean r4 = DebugKt.f370a;
        return r2;
    L21:
        return null;
    L22:
        return null;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final void a(Object r10, CancellationException r11) {
    L2:
        Object r12 = this._state;
        if ((r12 instanceof NotCompleted) == true) goto L30;
        if ((r12 instanceof CompletedExceptionally) == true) goto L6;
        if ((r12 instanceof CompletedContinuation) == true) goto L9;
        if (k.compareAndSet(this, r12, new CompletedContinuation(r12, null, null, null, r11, 14)) == false) goto L2;
        return;
    L9:
        CompletedContinuation r0 = (CompletedContinuation) r12;
        if (r0.e == null) goto L12;
        boolean r1 = true;
    L14:
        if ((!r1) == false) goto L25;
        if (k.compareAndSet(this, r12, CompletedContinuation.a(r0, null, r11, 15)) == false) goto L2;
        CancelHandler r13 = r0.b;
        if (r13 == null) goto L20;
        l(r13, r11);
    L20:
        Function1 r14 = r0.c;
        if (r14 == null) goto L41;
        n(r14, r11);
        return;
    L41:
        return;
    L25:
        throw new IllegalStateException("Must be called at most once".toString());
    L12:
        r1 = false;
        goto L14
    L6:
        return;
    L30:
        throw new IllegalStateException("Not completed".toString());
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Continuation b() {
        return this.i;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final Symbol c(Object r2, Object r3) {
        return E(r2, r3, null);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Throwable d(Object r2) {
        Throwable r3 = super.d(r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        if (DebugKt.b == false) goto L12;
        Continuation r1 = this.i;
        if ((r1 instanceof CoroutineStackFrame) == true) goto L13;
        return r3;
    L13:
        return StackTraceRecoveryKt.a(r3, (CoroutineStackFrame) r1);
    L12:
        return r3;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame e() {
        Continuation r1 = this.i;
        if ((r1 instanceof CoroutineStackFrame) == true) goto L6;
        r1 = null;
    L6:
        return (CoroutineStackFrame) r1;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Object f(Object r1) {
        if ((r1 instanceof CompletedContinuation) == true) goto L5;
        return r1;
    L5:
        return ((CompletedContinuation) r1).f362a;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void g() {
        boolean r0 = DebugKt.f370a;
        q(this.e);
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.f;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Object i() {
        return this._state;
    }

    public final void j(Function1 r3, Throwable r4) {
        r3.invoke(r4);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CoroutineExceptionHandlerKt.a(this.f, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
    }

    @Override // kotlin.coroutines.Continuation
    public final void k(Object r3) {
        Throwable r0 = Result.a(r3);
        if (r0 != null) goto L6;
    L9:
        A(r3, this.e, null);
        return;
    L6:
        if (DebugKt.b == false) goto L8;
        r0 = StackTraceRecoveryKt.a(r0, this);
    L8:
        r3 = new CompletedExceptionally(r0, false);
        goto L9
    }

    public final void l(CancelHandler r3, Throwable r4) {
        r3.c(r4);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CoroutineExceptionHandlerKt.a(this.f, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final Symbol m(Object r1, LockFreeLinkedListNode.AbstractAtomicDesc r2, Function1 r3) {
        return E(r1, r2, r3);
    }

    public final void n(Function1 r3, Throwable r4) {
        r3.invoke(r4);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CoroutineExceptionHandlerKt.a(this.f, new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th));
    }

    public final void o(Throwable r5) {
    L2:
        Object r0 = this._state;
        if ((r0 instanceof NotCompleted) == false) goto L4;
        boolean r2 = r0 instanceof CancelHandler;
        CancelledContinuation r1 = new CancelledContinuation(this, r5, r2);
        if (k.compareAndSet(this, r0, r1) == false) goto L2;
        if (r2 == true) goto L10;
        r0 = null;
    L10:
        CancelHandler r3 = (CancelHandler) r0;
        if (r3 == null) goto L13;
        l(r3, r5);
    L13:
        Continuation r6 = this.i;
        if ((r6 instanceof DispatchedContinuation) == true) goto L16;
    L18:
        p();
    L19:
        q(this.e);
        return;
    L16:
        if (((DispatchedContinuation) r6).o(this) == false) goto L18;
    }

    public final void p() {
        DisposableHandle r0 = (DisposableHandle) this._parentHandle;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this._parentHandle = NonDisposableHandle.b;
    }

    public final void q(int r5) {
    L2:
        int r0 = this._decision;
        boolean r1 = false;
        if (r0 != 0) goto L5;
        if (j.compareAndSet(this, 0, 2) == false) goto L2;
        return;
    L5:
        if (r0 != 1) goto L35;
        boolean r2 = DebugKt.f370a;
        Continuation r3 = this.i;
        if (r5 != 4) goto L9;
        r1 = true;
    L9:
        if (r1 == false) goto L11;
    L32:
        DispatchedTaskKt.b(this, r3, r1);
        return;
    L11:
        if ((r3 instanceof DispatchedContinuation) == false) goto L32;
        if (DispatchedTaskKt.a(r5) != DispatchedTaskKt.a(this.e)) goto L32;
        CoroutineDispatcher r6 = ((DispatchedContinuation) r3).k;
        CoroutineContext r4 = ((DispatchedContinuation) r3).l.getContext();
        if (r6.l() == false) goto L17;
        r6.j(r4, this);
        return;
    L17:
        EventLoop r7 = ThreadLocalEventLoop.a();
        if (r7.u() == false) goto L20;
        r7.n(this);
        return;
    L20:
        r7.s(true);
        DispatchedTaskKt.b(this, this.i, true);     // Catch: Throwable -> L25
    L22:
        if (r7.w() == true) goto L22;
    L24:
        r7.m();
        return;
    L25:
        th = move-exception;
        h(th, null);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        r7.m();
        throw th;
    L35:
        throw new IllegalStateException("Already resumed".toString());
    }

    public Throwable r(Job r1) {
        return r1.q();
    }

    public final Object s() {
        D();
    L3:
        int r0 = this._decision;
        if (r0 != 0) goto L6;
        if (j.compareAndSet(this, 0, 1) == false) goto L3;
        return CoroutineSingletons.b;
    L6:
        if (r0 != 2) goto L26;
        Object r1 = this._state;
        if ((r1 instanceof CompletedExceptionally) == false) goto L14;
        Throwable r2 = ((CompletedExceptionally) r1).f364a;
        if (DebugKt.b == true) goto L12;
        throw r2;
    L12:
        throw StackTraceRecoveryKt.a(r2, this);
    L14:
        if (DispatchedTaskKt.a(this.e) == false) goto L24;
        Job r3 = (Job) this.f.f(Job.g);
        if (r3 == null) goto L24;
        if (r3.isActive() == true) goto L24;
        CancellationException r4 = r3.q();
        a(r1, r4);
        if (DebugKt.b == true) goto L22;
        throw r4;
    L22:
        throw StackTraceRecoveryKt.a(r4, this);
    L24:
        return f(r1);
    L26:
        throw new IllegalStateException("Already suspended".toString());
    }

    public final boolean t() {
        return !(this._state instanceof NotCompleted);
    }

    public final String toString() {
        return y() + '(' + DebugStringsKt.b(this.i) + "){" + this._state + "}@" + DebugStringsKt.a(this);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void u(Function1 r11) {
        if ((r11 instanceof CancelHandler) == false) goto L5;
        CancelHandler r0 = (CancelHandler) r11;
    L6:
        Object r8 = this._state;
        if ((r8 instanceof Active) == true) goto L9;
        Throwable r2 = null;
        if ((r8 instanceof CancelHandler) == true) goto L51;
        if ((r8 instanceof CompletedExceptionally) == true) goto L15;
        if ((r8 instanceof CompletedContinuation) == true) goto L31;
        if ((r0 instanceof BeforeResumeCancelHandler) == true) goto L47;
        CancelHandler r3 = r0;
        if (k.compareAndSet(this, r8, new CompletedContinuation(r8, r3, null, null, null, 28)) == false) goto L6;
        return;
    L47:
        return;
    L31:
        CompletedContinuation r1 = (CompletedContinuation) r8;
        if (r1.b != null) goto L43;
        if ((r0 instanceof BeforeResumeCancelHandler) == true) goto L35;
        Throwable r4 = r1.e;
        if (r4 != null) goto L38;
        if (k.compareAndSet(this, r8, CompletedContinuation.a(r1, r0, null, 29)) == false) goto L6;
        return;
    L38:
        j(r11, r4);
        return;
    L35:
        return;
    L43:
        v(r8, r11);
        throw null;
    L15:
        CompletedExceptionally r5 = (CompletedExceptionally) r8;
        r5.getClass();
        if (CompletedExceptionally.b.compareAndSet(r5, 0, 1) == true) goto L18;
        v(r8, r11);
        throw null;
    L18:
        if ((r8 instanceof CancelledContinuation) == true) goto L20;
        return;
    L20:
        if ((r8 instanceof CompletedExceptionally) == true) goto L22;
        r8 = null;
    L22:
        CompletedExceptionally r9 = (CompletedExceptionally) r8;
        if (r9 == null) goto L25;
        r2 = r9.f364a;
    L25:
        j(r11, r2);
        return;
    L51:
        v(r8, r11);
        throw null;
    L9:
        if (k.compareAndSet(this, r8, r0) == false) goto L6;
        return;
    L5:
        r0 = new InvokeOnCancel(r11);
        goto L6
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement w() {
        return null;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final Symbol x(Throwable r3) {
        return E(new CompletedExceptionally(r3, false), null, null);
    }

    public String y() {
        return "CancellableContinuation";
    }

    public final boolean z() {
        boolean r0 = DebugKt.f370a;
        Object r1 = this._state;
        if ((r1 instanceof CompletedContinuation) == true) goto L5;
    L8:
        this._decision = 0;
        this._state = Active.b;
        return true;
    L5:
        if (((CompletedContinuation) r1).f363d == null) goto L8;
        p();
        return false;
    }
}
