package kotlinx.coroutines;

import d.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public class JobSupport implements Job, ChildJob, ParentJob, SelectClause0 {
    public static final AtomicReferenceFieldUpdater b = null;
    private volatile Object _parentHandle;
    private volatile Object _state;

    @Metadata
    public static final class AwaitContinuation<T> extends CancellableContinuationImpl<T> {
        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public final Throwable r(Job r1) {
            throw null;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public final String y() {
            return "AwaitContinuation";
        }
    }

    @Metadata
    public static final class ChildCompletion extends JobNode<Job> {
        public final JobSupport i;
        public final Finishing j;
        public final ChildHandleNode k;
        public final Object l;

        public ChildCompletion(JobSupport r2, Finishing r3, ChildHandleNode r4, Object r5) {
            super(r4.i);
            this.i = r2;
            this.j = r3;
            this.k = r4;
            this.l = r5;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        public final void K(Throwable r7) {
            AtomicReferenceFieldUpdater r8 = JobSupport.b;
            JobSupport r9 = this.i;
            r9.getClass();
            boolean r0 = DebugKt.f370a;
            ChildHandleNode r1 = JobSupport.k0(this.k);
            Finishing r2 = this.j;
            Object r6 = this.l;
            if (r1 == null) goto L10;
        L4:
            ChildCompletion r3 = new ChildCompletion(r9, r2, r1, r6);
            if (Job.DefaultImpls.a(r1.i, false, r3, 1) != NonDisposableHandle.b) goto L15;
            r1 = JobSupport.k0(r1);
            if (r1 == null) goto L10;
        L15:
            return;
        L10:
            r9.M(r9.V(r2, r6));
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Object invoke(Object r1) {
            K((Throwable) r1);
            return Unit.f330a;
        }
    }

    @Metadata
    public static final class Finishing implements Incomplete {
        private volatile Object _exceptionsHolder;
        private volatile int _isCompleting;
        private volatile Object _rootCause;
        public final NodeList b;

        public Finishing(NodeList r1, Throwable r2) {
            this.b = r1;
            this._isCompleting = 0;
            this._rootCause = r2;
            this._exceptionsHolder = null;
        }

        public final void a(Throwable r4) {
            Throwable r0 = (Throwable) this._rootCause;
            if (r0 != null) goto L6;
            this._rootCause = r4;
            return;
        L6:
            if (r4 != r0) goto L8;
            return;
        L8:
            Object r1 = this._exceptionsHolder;
            if (r1 != null) goto L12;
            this._exceptionsHolder = r4;
            return;
        L12:
            if ((r1 instanceof Throwable) == false) goto L17;
            if (r4 != r1) goto L15;
            return;
        L15:
            ArrayList r2 = new ArrayList(4);
            r2.add(r1);
            r2.add(r4);
            this._exceptionsHolder = r2;
            return;
        L17:
            if ((r1 instanceof ArrayList) == false) goto L21;
            ((ArrayList) r1).add(r4);
            return;
        L21:
            throw new IllegalStateException(b.a(r1, "State is ").toString());
        }

        public final Throwable b() {
            return (Throwable) this._rootCause;
        }

        public final boolean c() {
            if (((Throwable) this._rootCause) == null) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
        public final boolean d() {
            return this._isCompleting;
        }

        public final boolean e() {
            if (this._exceptionsHolder != JobSupportKt.e) goto L5;
            return true;
        L5:
            return false;
        }

        public final ArrayList f(Throwable r4) {
            Object r0 = this._exceptionsHolder;
            if (r0 != null) goto L6;
            ArrayList r1 = new ArrayList(4);
        L11:
            Throwable r2 = (Throwable) this._rootCause;
            if (r2 == null) goto L14;
            r1.add(0, r2);
        L14:
            if (r4 != null) goto L16;
        L18:
            this._exceptionsHolder = JobSupportKt.e;
            return r1;
        L16:
            if ((!r4.equals(r2)) == false) goto L18;
            r1.add(r4);
            goto L18
        L6:
            if ((r0 instanceof Throwable) == false) goto L9;
            ArrayList r3 = new ArrayList(4);
            r3.add(r0);
            r1 = r3;
            goto L11
        L9:
            if ((r0 instanceof ArrayList) == false) goto L21;
            r1 = (ArrayList) r0;
            goto L11
        L21:
            throw new IllegalStateException(b.a(r0, "State is ").toString());
        }

        public final void g() {
            this._isCompleting = 1;
        }

        @Override // kotlinx.coroutines.Incomplete
        public final boolean isActive() {
            if (((Throwable) this._rootCause) != null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlinx.coroutines.Incomplete
        public final NodeList j() {
            return this.b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [boolean, int] */
        public final String toString() {
            return "Finishing[cancelling=" + c() + ", completing=" + this._isCompleting + ", rootCause=" + ((Throwable) this._rootCause) + ", exceptions=" + this._exceptionsHolder + ", list=" + this.b + ']';
        }
    }

    static {
        b = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
    }

    public JobSupport(boolean r1) {
        if (r1 == false) goto L5;
        Empty r2 = JobSupportKt.g;
    L6:
        this._state = r2;
        this._parentHandle = null;
        return;
    L5:
        r2 = JobSupportKt.f;
        goto L6
    }

    public static void L(Throwable r4, ArrayList r5) {
        if (r5.size() > 1) goto L5;
        return;
    L5:
        Set r0 = Collections.newSetFromMap(new IdentityHashMap(r5.size()));
        if (DebugKt.b == true) goto L8;
        Throwable r1 = r4;
    L9:
        Iterator r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L23;
        Throwable r2 = (Throwable) r6.next();
        if (DebugKt.b == false) goto L16;
        r2 = StackTraceRecoveryKt.d(r2);
    L16:
        if (r2 == r4) goto L11;
        if (r2 == r1) goto L11;
        if ((r2 instanceof CancellationException) == true) goto L11;
        if (r0.add(r2) == false) goto L11;
        kotlin.ExceptionsKt.a(r4, r2);
        goto L11
    L23:
        return;
    L8:
        r1 = StackTraceRecoveryKt.d(r4);
        goto L9
    }

    public static ChildHandleNode k0(LockFreeLinkedListNode r1) {
    L3:
        if (r1.F() == false) goto L5;
        r1 = r1.C();
    L5:
        r1 = r1.A();
        if (r1.F() == true) goto L5;
        if ((r1 instanceof ChildHandleNode) == true) goto L11;
        if ((r1 instanceof NodeList) == false) goto L5;
        return null;
    L11:
        return (ChildHandleNode) r1;
    }

    public static String s0(Object r2) {
        if ((r2 instanceof Finishing) == false) goto L11;
        Finishing r3 = (Finishing) r2;
        if (r3.c() == false) goto L8;
        return "Cancelling";
    L8:
        if (r3.d() == false) goto L22;
        return "Completing";
    L22:
        return "Active";
    L11:
        if ((r2 instanceof Incomplete) == false) goto L17;
        if (((Incomplete) r2).isActive() == true) goto L26;
        return "New";
    L26:
        return "Active";
    L17:
        if ((r2 instanceof CompletedExceptionally) == false) goto L19;
        return "Cancelled";
    L19:
        return "Completed";
    }

    public static CancellationException t0(JobSupport r2, Throwable r3) {
        r2.getClass();
        if ((r3 instanceof CancellationException) == true) goto L5;
        Throwable r0 = null;
    L6:
        CancellationException r1 = (CancellationException) r0;
        if (r1 == null) goto L10;
        return r1;
    L10:
        return new JobCancellationException(r2.R(), r3, r2);
    L5:
        r0 = r3;
        goto L6
    }

    @Override // kotlinx.coroutines.ParentJob
    public final CancellationException F() {
        Object r0 = c0();
        Throwable r2 = null;
        if ((r0 instanceof Finishing) == false) goto L6;
        Throwable r1 = ((Finishing) r0).b();
    L12:
        if ((r1 instanceof CancellationException) == false) goto L15;
        r2 = r1;
    L15:
        CancellationException r3 = (CancellationException) r2;
        if (r3 == null) goto L19;
        return r3;
    L19:
        return new JobCancellationException("Parent job is ".concat(s0(r0)), r1, this);
    L6:
        if ((r0 instanceof CompletedExceptionally) == false) goto L9;
        r1 = ((CompletedExceptionally) r0).f364a;
        goto L12
    L9:
        if ((r0 instanceof Incomplete) == true) goto L21;
        r1 = null;
        goto L12
    L21:
        throw new IllegalStateException(b.a(r0, "Cannot be cancelling child in this state: ").toString());
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object H(Object r1, Function2 r2) {
        return r2.mo7invoke(r1, this);
    }

    public void M(Object r1) {
    }

    public void N(Object r1) {
        M(r1);
    }

    public final boolean O(Object r9) {
        Object r0 = JobSupportKt.f377a;
        if (Z() == false) goto L19;
    L4:
        Object r1 = c0();
        if ((r1 instanceof Incomplete) == false) goto L14;
        if ((r1 instanceof Finishing) == true) goto L9;
    L11:
        r0 = u0(r1, new CompletedExceptionally(U(r9), false));
        if (r0 == JobSupportKt.c) goto L4;
    L16:
        if (r0 != JobSupportKt.b) goto L19;
        return true;
    L9:
        if (((Finishing) r1).d() == false) goto L11;
    L14:
        r0 = JobSupportKt.f377a;
    L19:
        if (r0 != JobSupportKt.f377a) goto L70;
        Throwable r2 = null;
        Throwable r3 = null;
    L21:
        Object r4 = c0();
        if ((r4 instanceof Finishing) == true) goto L23;
        if ((r4 instanceof Incomplete) == false) goto L68;
        if (r3 != null) goto L52;
        r3 = U(r9);
    L52:
        Incomplete r5 = (Incomplete) r4;
        if (r5.isActive() == true) goto L54;
        Object r6 = u0(r4, new CompletedExceptionally(r3, false));
        if (r6 == JobSupportKt.f377a) goto L67;
        if (r6 == JobSupportKt.c) goto L21;
        r0 = r6;
        goto L70
    L67:
        throw new IllegalStateException(b.a(r4, "Cannot happen in ").toString());
    L54:
        boolean r7 = DebugKt.f370a;
        NodeList r8 = a0(r5);
        if (r8 == null) goto L21;
        if (b.compareAndSet(this, r5, new Finishing(r8, r3)) == false) goto L21;
        l0(r8, r3);
        Symbol r10 = JobSupportKt.f377a;
    L28:
        r0 = r10;
        goto L70
    L68:
        r10 = JobSupportKt.f378d;
        goto L28
    L23:
        monitor-enter(r4);
    L44:
        th = move-exception;
        throw th;
    L25:
        if (((Finishing) r4).e() == false) goto L29;
        r10 = JobSupportKt.f378d;     // Catch: Throwable -> L44
        monitor-exit(r4);
        goto L28
    L29:
        boolean r11 = ((Finishing) r4).c();     // Catch: Throwable -> L44
        if (r9 != null) goto L32;
        if (r11 == false) goto L32;
    L36:
        Throwable r12 = ((Finishing) r4).b();     // Catch: Throwable -> L44
        if ((!r11) == false) goto L40;
        r2 = r12;
    L40:
        monitor-exit(r4);
        if (r2 == null) goto L43;
        l0(((Finishing) r4).b, r2);
    L43:
        r10 = JobSupportKt.f377a;
    L32:
        if (r3 != null) goto L35;
        r3 = U(r9);     // Catch: Throwable -> L44
    L35:
        ((Finishing) r4).a(r3);     // Catch: Throwable -> L44
    L70:
        if (r0 != JobSupportKt.f377a) goto L73;
    L79:
        return true;
    L73:
        if (r0 == JobSupportKt.b) goto L79;
        if (r0 == JobSupportKt.f378d) goto L97;
        M(r0);
        goto L79
    L97:
        return false;
    }

    public void P(CancellationException r1) {
        O(r1);
    }

    public final boolean Q(Throwable r4) {
        if (g0() == false) goto L5;
        return true;
    L5:
        boolean r0 = r4 instanceof CancellationException;
        ChildHandle r3 = (ChildHandle) this._parentHandle;
        if (r3 != null) goto L8;
    L16:
        return r0;
    L8:
        if (r3 == NonDisposableHandle.b) goto L16;
        if (r3.i(r4) == true) goto L17;
        if (r0 == true) goto L18;
        return false;
    L18:
        return true;
    L17:
        return true;
    }

    public String R() {
        return "Job was cancelled";
    }

    public boolean S(Throwable r3) {
        if ((r3 instanceof CancellationException) == false) goto L6;
        return true;
    L6:
        if (O(r3) == true) goto L8;
    L10:
        return false;
    L8:
        if (Y() == false) goto L10;
        return true;
    }

    public final void T(Incomplete r8, Object r9) {
        ChildHandle r0 = (ChildHandle) this._parentHandle;
        if (r0 == null) goto L5;
        r0.dispose();
        this._parentHandle = NonDisposableHandle.b;
    L5:
        CompletionHandlerException r1 = null;
        if ((r9 instanceof CompletedExceptionally) == true) goto L8;
        r9 = null;
    L8:
        CompletedExceptionally r10 = (CompletedExceptionally) r9;
        if (r10 == null) goto L11;
        Throwable r11 = r10.f364a;
    L13:
        if ((r8 instanceof JobNode) == true) goto L42;
        NodeList r12 = r8.j();
        if (r12 == null) goto L49;
        Object r2 = r12.z();
        if (r2 == null) goto L38;
        LockFreeLinkedListNode r3 = (LockFreeLinkedListNode) r2;
    L24:
        if ((!r3.equals(r12)) == false) goto L35;
        if ((r3 instanceof JobNode) == false) goto L34;
        JobNode r4 = (JobNode) r3;
        r4.K(r11);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        if (r1 == null) goto L33;
        kotlin.ExceptionsKt.a(r1, th);
        goto L34
    L33:
        r1 = new CompletionHandlerException("Exception in completion handler " + r4 + " for " + this, th);
    L34:
        r3 = r3.A();
        goto L24
    L35:
        if (r1 == null) goto L50;
        e0(r1);
        return;
    L50:
        return;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    L49:
        return;
    L42:
        ((JobNode) r8).K(r11);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        e0(new CompletionHandlerException("Exception in completion handler " + r8 + " for " + this, th));
        return;
    L11:
        r11 = null;
        goto L13
    }

    public final Throwable U(Object r3) {
        if (r3 == null) goto L4;
        boolean r0 = r3 instanceof Throwable;
    L5:
        if (r0 == false) goto L9;
        if (r3 == null) goto L15;
        return (Throwable) r3;
    L15:
        return new JobCancellationException(R(), null, this);
    L9:
        if (r3 == null) goto L13;
        return ((ParentJob) r3).F();
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
    L4:
        r0 = true;
        goto L5
    }

    public final Object V(Finishing r7, Object r8) {
        boolean r0 = DebugKt.f370a;
        Throwable r1 = null;
        if ((r8 instanceof CompletedExceptionally) == true) goto L5;
        Object r2 = null;
    L6:
        CompletedExceptionally r3 = (CompletedExceptionally) r2;
        if (r3 == null) goto L9;
        r1 = r3.f364a;
    L9:
        monitor-enter(r7);
        boolean r4 = r7.c();     // Catch: Throwable -> L37
        ArrayList r5 = r7.f(r1);     // Catch: Throwable -> L37
        Throwable r6 = X(r7, r5);     // Catch: Throwable -> L37
        if (r6 == null) goto L13;
        L(r6, r5);     // Catch: Throwable -> L37
    L13:
        monitor-exit(r7);
        if (r6 == null) goto L20;
        if (r6 == r1) goto L20;
        r8 = new CompletedExceptionally(r6, false);
    L20:
        if (r6 != null) goto L22;
    L29:
        if (r4 == true) goto L31;
        m0(r6);
    L31:
        n0(r8);
        AtomicReferenceFieldUpdater r9 = b;
        if ((r8 instanceof Incomplete) == false) goto L34;
        Object r10 = new IncompleteStateBox((Incomplete) r8);
    L35:
        r9.compareAndSet(this, r7, r10);
        T(r7, r8);
        return r8;
    L34:
        r10 = r8;
        goto L35
    L22:
        if (Q(r6) == false) goto L24;
    L25:
        if (r8 == null) goto L28;
        CompletedExceptionally.b.compareAndSet((CompletedExceptionally) r8, 0, 1);
        goto L29
    L28:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
    L24:
        if (d0(r6) == false) goto L29;
    L37:
        th = move-exception;
        throw th;
    L5:
        r2 = r8;
        goto L6
    }

    public final Object W() {
        Object r1 = c0();
        if ((!(r1 instanceof Incomplete)) == false) goto L11;
        if ((r1 instanceof CompletedExceptionally) == true) goto L9;
        return JobSupportKt.a(r1);
    L9:
        throw ((CompletedExceptionally) r1).f364a;
    L11:
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    public final Throwable X(Finishing r3, ArrayList r4) {
        Object r1 = null;
        if (r4.isEmpty() == true) goto L5;
        Iterator r2 = r4.iterator();
    L11:
        if (r2.hasNext() == false) goto L15;
        Object r5 = r2.next();
        if ((!(((Throwable) r5) instanceof CancellationException)) == false) goto L11;
    L16:
        Throwable r6 = (Throwable) r5;
        if (r6 == null) goto L19;
        return r6;
    L19:
        Throwable r7 = (Throwable) r4.get(0);
        if ((r7 instanceof TimeoutCancellationException) == false) goto L32;
        Iterator r8 = r4.iterator();
    L23:
        if (r8.hasNext() == false) goto L29;
        Object r9 = r8.next();
        Throwable r0 = (Throwable) r9;
        if (r0 == r7) goto L23;
        if ((r0 instanceof TimeoutCancellationException) == false) goto L23;
        r1 = r9;
    L29:
        Throwable r10 = (Throwable) r1;
        if (r10 == null) goto L32;
        return r10;
    L32:
        return r7;
    L15:
        r5 = null;
        goto L16
    L5:
        if (r3.c() == true) goto L7;
        return null;
    L7:
        return new JobCancellationException(R(), null, this);
    }

    public boolean Y() {
        return true;
    }

    public boolean Z() {
        return this instanceof CompletableDeferredImpl;
    }

    @Override // kotlinx.coroutines.Job
    public void a(CancellationException r3) {
        if (r3 != null) goto L5;
        r3 = new JobCancellationException(R(), null, this);
    L5:
        P(r3);
    }

    public final NodeList a0(Incomplete r2) {
        NodeList r0 = r2.j();
        if (r0 == null) goto L6;
        return r0;
    L6:
        if ((r2 instanceof Empty) == false) goto L9;
        return new NodeList();
    L9:
        if ((r2 instanceof JobNode) == false) goto L13;
        p0((JobNode) r2);
        return null;
    L13:
        throw new IllegalStateException(("State should have list: " + r2).toString());
    }

    public final ChildHandle b0() {
        return (ChildHandle) this._parentHandle;
    }

    public final Object c0() {
    L2:
        Object r0 = this._state;
        if ((r0 instanceof OpDescriptor) == false) goto L4;
        ((OpDescriptor) r0).c(this);
        goto L2
    L4:
        return r0;
    }

    public Object d() {
        return W();
    }

    public boolean d0(Throwable r1) {
        return false;
    }

    public void e0(CompletionHandlerException r1) {
        throw r1;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element f(CoroutineContext.Key r1) {
        return CoroutineContext.Element.DefaultImpls.a(this, r1);
    }

    public final void f0(Job r3) {
        boolean r0 = DebugKt.f370a;
        NonDisposableHandle r1 = NonDisposableHandle.b;
        if (r3 != null) goto L6;
        this._parentHandle = r1;
        return;
    L6:
        r3.start();
        ChildHandle r4 = r3.r(this);
        this._parentHandle = r4;
        if ((!(c0() instanceof Incomplete)) == false) goto L10;
        r4.dispose();
        this._parentHandle = r1;
        return;
    }

    public boolean g0() {
        return this instanceof BlockingCoroutine;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return Job.g;
    }

    public void h(SelectInstance r1, Function2 r2) {
        q0(r1, r2);
    }

    public final Object h0(Object r4) {
    L2:
        Object r0 = u0(c0(), r4);
        if (r0 == JobSupportKt.f377a) goto L4;
        if (r0 == JobSupportKt.c) goto L2;
        return r0;
    L4:
        String r3 = "Job " + this + " is already complete or completing, but is being completed with " + r4;
        Throwable r2 = null;
        if ((r4 instanceof CompletedExceptionally) == true) goto L7;
        r4 = null;
    L7:
        CompletedExceptionally r5 = (CompletedExceptionally) r4;
        if (r5 == null) goto L11;
        r2 = r5.f364a;
    L11:
        throw new IllegalStateException(r3, r2);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext i(CoroutineContext r1) {
        return CoroutineContext.Element.DefaultImpls.c(this, r1);
    }

    public final JobNode i0(Function1 r2, boolean r3) {
        Function1 r0 = null;
        if (r3 == false) goto L13;
        if ((r2 instanceof JobCancellingNode) == false) goto L8;
        r0 = r2;
    L8:
        JobCancellingNode r1 = (JobCancellingNode) r0;
        if (r1 == null) goto L22;
        boolean r4 = DebugKt.f370a;
        return r1;
    L22:
        return new InvokeOnCancelling(this, r2);
    L13:
        if ((r2 instanceof JobNode) == false) goto L16;
        r0 = r2;
    L16:
        JobNode r5 = (JobNode) r0;
        if (r5 == null) goto L20;
        boolean r6 = DebugKt.f370a;
        return r5;
    L20:
        return new InvokeOnCompletion(this, r2);
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object r1 = c0();
        if ((r1 instanceof Incomplete) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Incomplete) r1).isActive() == false) goto L7;
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object r1 = c0();
        if ((r1 instanceof CompletedExceptionally) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r1 instanceof Finishing) == true) goto L7;
    L9:
        return false;
    L7:
        if (((Finishing) r1).c() == false) goto L9;
        goto L9
    }

    public String j0() {
        return getClass().getSimpleName();
    }

    public final void l0(NodeList r7, Throwable r8) {
        m0(r8);
        Object r0 = r7.z();
        if (r0 == null) goto L22;
        LockFreeLinkedListNode r1 = (LockFreeLinkedListNode) r0;
        CompletionHandlerException r2 = null;
    L6:
        if ((!r1.equals(r7)) == false) goto L17;
        if ((r1 instanceof JobCancellingNode) == false) goto L16;
        JobNode r3 = (JobNode) r1;
        r3.K(r8);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (r2 == null) goto L15;
        kotlin.ExceptionsKt.a(r2, th);
        goto L16
    L15:
        r2 = new CompletionHandlerException("Exception in completion handler " + r3 + " for " + this, th);
    L16:
        r1 = r1.A();
        goto L6
    L17:
        if (r2 == null) goto L19;
        e0(r2);
    L19:
        Q(r8);
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    public void m0(Throwable r1) {
    }

    public void n0(Object r1) {
    }

    @Override // kotlinx.coroutines.Job
    public final Object o(ContinuationImpl r5) {
    L2:
        Object r0 = c0();
        boolean r1 = r0 instanceof Incomplete;
        Unit r2 = Unit.f330a;
        if (r1 == false) goto L4;
        if (r0(r0) < 0) goto L2;
        CancellableContinuationImpl r3 = new CancellableContinuationImpl(1, IntrinsicsKt.b(r5));
        r3.D();
        r3.u(new DisposeOnCancel(p(false, true, new ResumeOnCompletion(this, r3))));
        Object r4 = r3.s();
        if (r4 != CoroutineSingletons.b) goto L17;
        return r4;
    L17:
        return r2;
    L4:
        Job r6 = (Job) r5.getContext().f(Job.g);
        if (r6 != null) goto L7;
    L11:
        return r2;
    L7:
        if (r6.isActive() == true) goto L11;
        throw r6.q();
    }

    public void o0() {
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle p(boolean r10, boolean r11, Function1 r12) {
        Throwable r0 = null;
        final JobNode r1 = null;
    L3:
        Object r2 = c0();
        if ((r2 instanceof Empty) == true) goto L5;
        if ((r2 instanceof Incomplete) == false) goto L75;
        NodeList r3 = ((Incomplete) r2).j();
        if (r3 == null) goto L22;
        DisposableHandle r4 = NonDisposableHandle.b;
        if (r10 == false) goto L61;
        if ((r2 instanceof Finishing) == false) goto L61;
        monitor-enter(r2);
        Throwable r7 = ((Finishing) r2).b();     // Catch: Throwable -> L38
        if (r7 != null) goto L34;
    L40:
        if (r1 != null) goto L43;
        r1 = i0(r12, r10);     // Catch: Throwable -> L38
    L43:
        final Incomplete r5 = (Incomplete) r2;     // Catch: Throwable -> L38
        LockFreeLinkedListNode.CondAddOp r8 = new JobSupport$addLastAtomic$$inlined$addLastIf$1(r1, this, r5);     // Catch: Throwable -> L38
    L44:
        int r6 = r3.C().J(r1, r3, r8);     // Catch: Throwable -> L38
        if (r6 == 1) goto L49;
        if (r6 != 2) goto L44;
        boolean r9 = false;
    L50:
        if (r9 == true) goto L53;
        monitor-exit(r2);
        goto L3
    L53:
        if (r7 == null) goto L54;
        r4 = r1;
    L57:
        monitor-exit(r2);
    L62:
        if (r7 != null) goto L63;
        if (r1 != null) goto L69;
        r1 = i0(r12, r10);
    L69:
        final Incomplete r13 = (Incomplete) r2;
        LockFreeLinkedListNode.CondAddOp r14 = new JobSupport$addLastAtomic$$inlined$addLastIf$1(r1, this, r13);
    L70:
        int r15 = r3.C().J(r1, r3, r14);
        if (r15 == 1) goto L74;
        if (r15 == 2) goto L3;
    L74:
        return r1;
    L63:
        if (r11 == false) goto L65;
        r12.invoke(r7);
    L65:
        return r4;
    L54:
        monitor-exit(r2);
        return r1;
    L49:
        r9 = true;
        goto L50
    L34:
        if ((r12 instanceof ChildHandleNode) == false) goto L57;
        if (((Finishing) r2).d() == true) goto L57;
    L38:
        th = move-exception;
        throw th;
    L61:
        r7 = null;
        goto L62
    L22:
        if (r2 == null) goto L25;
        p0((JobNode) r2);
        goto L3
    L25:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
    L75:
        if (r11 == false) goto L84;
        if ((r2 instanceof CompletedExceptionally) == true) goto L79;
        r2 = null;
    L79:
        CompletedExceptionally r16 = (CompletedExceptionally) r2;
        if (r16 == null) goto L82;
        r0 = r16.f364a;
    L82:
        r12.invoke(r0);
    L84:
        return NonDisposableHandle.b;
    L5:
        Empty r17 = (Empty) r2;
        if (r17.b == true) goto L7;
        NodeList r18 = new NodeList();
        Object r19 = r18;
        if (r17.b == true) goto L17;
        r19 = new InactiveNodeList(r18);
    L17:
        b.compareAndSet(this, r17, r19);
        goto L3
    L7:
        if (r1 != null) goto L11;
        r1 = i0(r12, r10);
    L11:
        if (b.compareAndSet(this, r2, r1) == false) goto L3;
        return r1;
    }

    public final void p0(JobNode r4) {
        NodeList r0 = new NodeList();
        r4.getClass();
        LockFreeLinkedListNode.c.lazySet(r0, r4);
        AtomicReferenceFieldUpdater r1 = LockFreeLinkedListNode.b;
        r1.lazySet(r0, r4);
    L4:
        if (r4.z() != r4) goto L9;
        if (r1.compareAndSet(r4, r4, r0) == false) goto L4;
        r0.y(r4);
    L9:
        LockFreeLinkedListNode r2 = r4.A();
        b.compareAndSet(this, r4, r2);
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException q() {
        Object r0 = c0();
        Throwable r2 = null;
        if ((r0 instanceof Finishing) == false) goto L21;
        Throwable r1 = ((Finishing) r0).b();
        if (r1 == null) goto L19;
        String r3 = getClass().getSimpleName().concat(" is cancelling");
        if ((r1 instanceof CancellationException) == false) goto L10;
        r2 = r1;
    L10:
        CancellationException r4 = (CancellationException) r2;
        if (r4 == null) goto L14;
        return r4;
    L14:
        if (r3 != null) goto L29;
        r3 = R();
    L29:
        return new JobCancellationException(r3, r1, this);
    L19:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    L21:
        if ((r0 instanceof Incomplete) == true) goto L28;
        if ((r0 instanceof CompletedExceptionally) == false) goto L26;
        return t0(this, ((CompletedExceptionally) r0).f364a);
    L26:
        return new JobCancellationException(getClass().getSimpleName().concat(" has completed normally"), null, this);
    L28:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public final void q0(SelectInstance r3, Function2 r4) {
    L2:
        Object r0 = c0();
        if (r3.l() == true) goto L4;
        if ((r0 instanceof Incomplete) == false) goto L8;
        if (r0(r0) != 0) goto L2;
        r3.s(p(false, true, new SelectAwaitOnCompletion(this, r3, r4)));
        return;
    L8:
        if (r3.h() == true) goto L10;
        return;
    L10:
        if ((r0 instanceof CompletedExceptionally) == false) goto L12;
        r3.p(((CompletedExceptionally) r0).f364a);
        return;
    L12:
        UndispatchedKt.a(JobSupportKt.a(r0), r3.n(), r4);
        return;
    }

    @Override // kotlinx.coroutines.Job
    public final ChildHandle r(JobSupport r3) {
        return (ChildHandle) Job.DefaultImpls.a(this, true, new ChildHandleNode(this, r3), 2);
    }

    public final int r0(Object r6) {
        boolean r0 = r6 instanceof Empty;
        AtomicReferenceFieldUpdater r3 = b;
        if (r0 == false) goto L13;
        if (((Empty) r6).b == false) goto L8;
        return 0;
    L8:
        if (r3.compareAndSet(this, r6, JobSupportKt.g) == true) goto L10;
        return -1;
    L10:
        o0();
        return 1;
    L13:
        if ((r6 instanceof InactiveNodeList) == true) goto L15;
        return 0;
    L15:
        if (r3.compareAndSet(this, r6, ((InactiveNodeList) r6).b) == true) goto L17;
        return -1;
    L17:
        o0();
        return 1;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
    L2:
        int r0 = r0(c0());
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L2;
        return true;
    L8:
        return false;
    }

    @Override // kotlinx.coroutines.ChildJob
    public final void t(ParentJob r1) {
        O(r1);
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(j0() + '{' + s0(c0()) + '}');
        r0.append('@');
        r0.append(DebugStringsKt.a(this));
        return r0.toString();
    }

    public final Object u0(Object r7, Object r8) {
        if ((r7 instanceof Incomplete) == false) goto L5;
        ChildHandleNode r1 = null;
        if ((r7 instanceof Empty) == true) goto L11;
        if ((r7 instanceof JobNode) == true) goto L11;
    L24:
        Incomplete r9 = (Incomplete) r7;
        NodeList r0 = a0(r9);
        if (r0 == null) goto L85;
        if ((r9 instanceof Finishing) == true) goto L29;
        Incomplete r2 = null;
    L30:
        Finishing r3 = (Finishing) r2;
        if (r3 != null) goto L34;
        r3 = new Finishing(r0, null);
    L34:
        monitor-enter(r3);
    L47:
        th = move-exception;
        throw th;
    L36:
        if (r3.d() == false) goto L40;
        Symbol r6 = JobSupportKt.f377a;     // Catch: Throwable -> L47
        monitor-exit(r3);
        return r6;
    L40:
        r3.g();     // Catch: Throwable -> L47
        if (r3 != r9) goto L43;
    L49:
        boolean r4 = DebugKt.f370a;     // Catch: Throwable -> L47
        boolean r5 = r3.c();     // Catch: Throwable -> L47
        if ((r8 instanceof CompletedExceptionally) == true) goto L52;
        Object r10 = null;
    L53:
        CompletedExceptionally r11 = (CompletedExceptionally) r10;     // Catch: Throwable -> L47
        if (r11 == null) goto L56;
        r3.a(r11.f364a);     // Catch: Throwable -> L47
    L56:
        Throwable r12 = r3.b();     // Catch: Throwable -> L47
        if ((!r5) == true) goto L61;
        r12 = null;
    L61:
        monitor-exit(r3);
        if (r12 == null) goto L65;
        l0(r0, r12);
    L65:
        if ((r9 instanceof ChildHandleNode) == true) goto L67;
        Incomplete r13 = null;
    L68:
        ChildHandleNode r14 = (ChildHandleNode) r13;
        if (r14 == null) goto L71;
        r1 = r14;
    L74:
        if (r1 == null) goto L91;
    L76:
        if (Job.DefaultImpls.a(r1.i, false, new ChildCompletion(this, r3, r1, r8), 1) != NonDisposableHandle.b) goto L90;
        r1 = k0(r1);
        if (r1 == null) goto L91;
    L90:
        return JobSupportKt.b;
    L91:
        return V(r3, r8);
    L71:
        NodeList r15 = r9.j();
        if (r15 == null) goto L74;
        r1 = k0(r15);
        goto L74
    L67:
        r13 = r9;
        goto L68
    L52:
        r10 = r8;
        goto L53
    L43:
        if (b.compareAndSet(this, r9, r3) == true) goto L49;
        Symbol r16 = JobSupportKt.c;     // Catch: Throwable -> L47
        monitor-exit(r3);
        return r16;
    L29:
        r2 = r9;
        goto L30
    L85:
        return JobSupportKt.c;
    L11:
        if ((r7 instanceof ChildHandleNode) == true) goto L24;
        if ((r8 instanceof CompletedExceptionally) == true) goto L24;
        Incomplete r17 = (Incomplete) r7;
        boolean r18 = DebugKt.f370a;
        AtomicReferenceFieldUpdater r19 = b;
        if ((r8 instanceof Incomplete) == false) goto L17;
        Object r20 = new IncompleteStateBox((Incomplete) r8);
    L19:
        if (r19.compareAndSet(this, r17, r20) == false) goto L21;
        m0(null);
        n0(r8);
        T(r17, r8);
        return r8;
    L21:
        return JobSupportKt.c;
    L17:
        r20 = r8;
        goto L19
    L5:
        return JobSupportKt.f377a;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext v(CoroutineContext.Key r1) {
        return CoroutineContext.Element.DefaultImpls.b(this, r1);
    }
}
