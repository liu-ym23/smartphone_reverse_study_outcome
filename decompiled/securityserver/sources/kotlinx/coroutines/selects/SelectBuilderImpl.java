package kotlinx.coroutines.selects;

import d.b;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellingNode;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@PublishedApi
public final class SelectBuilderImpl<R> extends LockFreeLinkedListHead implements SelectBuilder<R>, SelectInstance<R>, Continuation<R>, CoroutineStackFrame {
    public static final AtomicReferenceFieldUpdater i = null;
    public static final AtomicReferenceFieldUpdater j = null;
    private volatile Object _parentHandle;
    volatile Object _result;
    volatile Object _state;
    public final Continuation f;

    @Metadata
    public static final class AtomicSelectOp extends AtomicOp<Object> {
        public final long b;
        public final SelectBuilderImpl c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicDesc f437d;

        public AtomicSelectOp(SelectBuilderImpl r3, AtomicDesc r4) {
            this.c = r3;
            this.f437d = r4;
            SeqNumber r5 = SelectKt.e;
            r5.getClass();
            this.b = SeqNumber.f441a.incrementAndGet(r5);
            r4.f406a = this;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public final void d(Object r4, Object r5) {
            if (r5 != null) goto L4;
            boolean r6 = true;
        L5:
            if (r6 == false) goto L7;
            Symbol r0 = null;
        L8:
            AtomicReferenceFieldUpdater r1 = SelectBuilderImpl.i;
            SelectBuilderImpl r2 = this.c;
            if (r1.compareAndSet(r2, this, r0) == false) goto L12;
            if (r6 == false) goto L12;
            r2.K();
        L12:
            this.f437d.a(this, r5);
            return;
        L7:
            r0 = SelectKt.f439a;
            goto L8
        L4:
            r6 = false;
            goto L5
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public final long g() {
            return this.b;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public final Object i(Object r6) {
            if (r6 != null) goto L24;
            SelectBuilderImpl r0 = this.c;
        L4:
            Object r1 = r0._state;
            Symbol r2 = null;
            if (r1 == this) goto L16;
            if ((r1 instanceof OpDescriptor) == true) goto L9;
            Symbol r3 = SelectKt.f439a;
            if (r1 != r3) goto L15;
            SelectBuilderImpl r4 = this.c;
            if (SelectBuilderImpl.i.compareAndSet(r4, r3, this) == false) goto L4;
        L15:
            r2 = SelectKt.b;
            goto L16
        L9:
            ((OpDescriptor) r1).c(this.c);
        L16:
            if (r2 == null) goto L24;
            return r2;
        L24:
            return this.f437d.b(this);
        L20:
            th = move-exception;
            if (r6 != null) goto L23;
            AtomicReferenceFieldUpdater r7 = SelectBuilderImpl.i;
            Symbol r5 = SelectKt.f439a;
            r7.compareAndSet(this.c, this, r5);
        L23:
            throw th;
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public final String toString() {
            return "AtomicSelectOp(sequence=" + this.b + ')';
        }
    }

    @Metadata
    public static final class DisposeNode extends LockFreeLinkedListNode {
        public final DisposableHandle f;

        public DisposeNode(DisposableHandle r1) {
            this.f = r1;
        }
    }

    @Metadata
    public static final class PairSelectOp extends OpDescriptor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LockFreeLinkedListNode.PrepareOp f438a;

        public PairSelectOp(LockFreeLinkedListNode.PrepareOp r1) {
            this.f438a = r1;
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public final AtomicOp a() {
            return this.f438a.a();
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public final Object c(Object r4) {
            if (r4 == null) goto L10;
            SelectBuilderImpl r5 = (SelectBuilderImpl) r4;
            LockFreeLinkedListNode.PrepareOp r0 = this.f438a;
            r0.d();
            Object r1 = r0.a().e(null);
            if (r1 != null) goto L6;
            Object r2 = r0.c;
        L7:
            SelectBuilderImpl.i.compareAndSet(r5, this, r2);
            return r1;
        L6:
            r2 = SelectKt.f439a;
            goto L7
        L10:
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
        }
    }

    @Metadata
    public final class SelectOnCancelling extends JobCancellingNode<Job> {
        public final /* synthetic */ SelectBuilderImpl i;

        public SelectOnCancelling(SelectBuilderImpl r1, Job r2) {
            this.i = r1;
            super(r2);
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        public final void K(Throwable r2) {
            SelectBuilderImpl r3 = this.i;
            if (r3.h() == false) goto L6;
            r3.p(this.f.q());
            return;
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Object invoke(Object r1) {
            K((Throwable) r1);
            return Unit.f330a;
        }
    }

    static {
        i = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_state");
        j = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_result");
    }

    public SelectBuilderImpl(Continuation r1) {
        this.f = r1;
        this._state = SelectKt.f439a;
        this._result = SelectKt.c;
        this._parentHandle = null;
    }

    public final void K() {
        DisposableHandle r0 = (DisposableHandle) this._parentHandle;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Object r1 = z();
        if (r1 == null) goto L16;
        LockFreeLinkedListNode r2 = (LockFreeLinkedListNode) r1;
    L9:
        if ((!r2.equals(this)) == false) goto L14;
        if ((r2 instanceof DisposeNode) == false) goto L13;
        ((DisposeNode) r2).f.dispose();
    L13:
        r2 = r2.A();
        goto L9
    L14:
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    public final Object L() {
        if (l() == true) goto L9;
        Job r0 = (Job) this.f.getContext().f(Job.g);
        if (r0 == null) goto L9;
        DisposableHandle r1 = Job.DefaultImpls.a(r0, true, new SelectOnCancelling(this, r0), 2);
        this._parentHandle = r1;
        if (l() == false) goto L9;
        r1.dispose();
    L9:
        Object r2 = this._result;
        Symbol r3 = SelectKt.c;
        if (r2 != r3) goto L16;
        AtomicReferenceFieldUpdater r4 = j;
        CoroutineSingletons r5 = CoroutineSingletons.b;
        if (r4.compareAndSet(this, r3, r5) == false) goto L14;
        return r5;
    L14:
        r2 = this._result;
    L16:
        if (r2 == SelectKt.f440d) goto L23;
        if ((r2 instanceof CompletedExceptionally) == true) goto L21;
        return r2;
    L21:
        throw ((CompletedExceptionally) r2).f364a;
    L23:
        throw new IllegalStateException("Already resumed");
    }

    public final void M(Throwable r3) {
        if (h() == false) goto L6;
        k(ResultKt.a(r3));
        return;
    L6:
        if ((r3 instanceof CancellationException) == true) goto L20;
        Object r0 = L();
        if ((r0 instanceof CompletedExceptionally) == false) goto L17;
        Throwable r1 = ((CompletedExceptionally) r0).f364a;
        boolean r2 = DebugKt.b;
        if (r2 == false) goto L13;
        r1 = StackTraceRecoveryKt.d(r1);
    L13:
        if (r2 == true) goto L15;
        Throwable r4 = r3;
    L16:
        if (r1 != r4) goto L17;
        return;
    L15:
        r4 = StackTraceRecoveryKt.d(r3);
    L17:
        CoroutineExceptionHandlerKt.a(this.f.getContext(), r3);
        return;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final Object d(LockFreeLinkedListNode.PrepareOp r5) {
    L2:
        Object r0 = this._state;
        Symbol r1 = SelectKt.f439a;
        Symbol r2 = CancellableContinuationImplKt.f361a;
        if (r0 == r1) goto L4;
        if ((r0 instanceof OpDescriptor) == false) goto L31;
        if (r5 == null) goto L30;
        AtomicOp r3 = r5.a();
        if ((r3 instanceof AtomicSelectOp) == false) goto L27;
        if (((AtomicSelectOp) r3).c != this) goto L27;
        throw new IllegalStateException("Cannot use matching select clauses on the same object".toString());
    L27:
        if (r3.b((OpDescriptor) r0) == false) goto L30;
        return AtomicKt.b;
    L30:
        ((OpDescriptor) r0).c(this);
        goto L2
    L31:
        if (r5 != null) goto L34;
        return null;
    L34:
        if (r0 != r5.c) goto L36;
        return r2;
    L36:
        return null;
    L4:
        if (r5 == null) goto L6;
        PairSelectOp r4 = new PairSelectOp(r5);
        if (i.compareAndSet(this, r1, r4) == false) goto L2;
        Object r6 = r4.c(this);
        if (r6 == null) goto L14;
        return r6;
    L14:
        K();
        return r2;
    L6:
        if (i.compareAndSet(this, r1, null) == true) goto L14;
        goto L14
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame e() {
        Continuation r1 = this.f;
        if ((r1 instanceof CoroutineStackFrame) == true) goto L6;
        r1 = null;
    L6:
        return (CoroutineStackFrame) r1;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.f.getContext();
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final boolean h() {
        Object r1 = d(null);
        if (r1 != CancellableContinuationImplKt.f361a) goto L5;
        return true;
    L5:
        if (r1 != null) goto L9;
        return false;
    L9:
        throw new IllegalStateException(b.a(r1, "Unexpected trySelectIdempotent result ").toString());
    }

    @Override // kotlin.coroutines.Continuation
    public final void k(Object r5) {
        boolean r0 = DebugKt.f370a;
    L3:
        Object r1 = this._result;
        Symbol r2 = SelectKt.c;
        if (r1 == r2) goto L5;
        CoroutineSingletons r3 = CoroutineSingletons.b;
        if (r1 != r3) goto L28;
        if (j.compareAndSet(this, r3, SelectKt.f440d) == false) goto L3;
        if ((r5 instanceof Result.Failure) == false) goto L25;
        Continuation r4 = this.f;
        Throwable r6 = Result.a(r5);
        Intrinsics.c(r6);
        if (DebugKt.b == true) goto L21;
    L24:
        r4.k(ResultKt.a(r6));
        return;
    L21:
        if ((r4 instanceof CoroutineStackFrame) == false) goto L24;
        r6 = StackTraceRecoveryKt.a(r6, (CoroutineStackFrame) r4);
        goto L24
    L25:
        this.f.k(r5);
        return;
    L28:
        throw new IllegalStateException("Already resumed");
    L5:
        Throwable r7 = Result.a(r5);
        if (r7 != null) goto L8;
        Object r8 = r5;
    L10:
        if (j.compareAndSet(this, r2, r8) == false) goto L3;
        return;
    L8:
        r8 = new CompletedExceptionally(r7, false);
        goto L10
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final boolean l() {
    L2:
        Object r0 = this._state;
        if (r0 == SelectKt.f439a) goto L4;
        if ((r0 instanceof OpDescriptor) == false) goto L9;
        ((OpDescriptor) r0).c(this);
        goto L2
    L9:
        return true;
    L4:
        return false;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final SelectBuilderImpl n() {
        return this;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final void p(Throwable r5) {
        boolean r0 = DebugKt.f370a;
    L3:
        Object r1 = this._result;
        Symbol r2 = SelectKt.c;
        if (r1 == r2) goto L5;
        CoroutineSingletons r3 = CoroutineSingletons.b;
        if (r1 != r3) goto L22;
        if (j.compareAndSet(this, r3, SelectKt.f440d) == false) goto L3;
        IntrinsicsKt.b(this.f).k(ResultKt.a(r5));
        return;
    L22:
        throw new IllegalStateException("Already resumed");
    L5:
        Continuation r4 = this.f;
        if (DebugKt.b == true) goto L8;
    L11:
        Throwable r6 = r5;
    L12:
        CompletedExceptionally r7 = new CompletedExceptionally(r6, false);
        if (j.compareAndSet(this, r2, r7) == false) goto L3;
        return;
    L8:
        if ((r4 instanceof CoroutineStackFrame) == false) goto L11;
        r6 = StackTraceRecoveryKt.a(r5, (CoroutineStackFrame) r4);
        goto L12
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final Object q(AtomicDesc r2) {
        return new AtomicSelectOp(this, r2).c(null);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final void s(DisposableHandle r3) {
        DisposeNode r0 = new DisposeNode(r3);
        if (l() == false) goto L5;
    L9:
        r3.dispose();
        return;
    L5:
        if (C().t(r0, this) == false) goto L5;
        if (l() == true) goto L9;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final String toString() {
        return "SelectInstance(state=" + this._state + ", result=" + this._result + ')';
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement w() {
        return null;
    }
}
