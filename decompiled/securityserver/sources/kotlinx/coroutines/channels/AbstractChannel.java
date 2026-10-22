package kotlinx.coroutines.channels;

import a.a;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BeforeResumeCancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedList_commonKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectBuilderImpl;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class AbstractChannel<E> extends AbstractSendChannel<E> implements Channel<E> {
    public static final /* synthetic */ int f = 0;

    @Metadata
    public static final class Itr<E> implements ChannelIterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f380a;
        public final AbstractChannel b;

        public Itr(AbstractChannel r1) {
            this.b = r1;
            this.f380a = AbstractChannelKt.f383d;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public final Object a(Continuation r6) {
            Object r0 = this.f380a;
            Symbol r1 = AbstractChannelKt.f383d;
            boolean r2 = true;
            if (r0 != r1) goto L5;
            AbstractChannel r3 = this.b;
            Object r4 = r3.v();
            this.f380a = r4;
            if (r4 != r1) goto L16;
            CancellableContinuationImpl r7 = CancellableContinuationKt.a(IntrinsicsKt.b(r6));
            ReceiveHasNext r5 = new ReceiveHasNext(this, r7);
        L25:
            int r8 = AbstractChannel.f;
            if (r3.q(r5) == true) goto L27;
            Object r9 = r3.v();
            this.f380a = r9;
            if ((r9 instanceof Closed) == true) goto L30;
            if (r9 == r1) goto L25;
            Boolean r10 = Boolean.TRUE;
            Function1 r11 = r3.c;
            if (r11 == null) goto L38;
            Function1 r12 = OnUndeliveredElementKt.a(r11, r9, r7.f);
        L39:
            r7.A(r10, r7.e, r12);
        L41:
            return r7.s();
        L38:
            r12 = null;
            goto L39
        L30:
            Closed r13 = (Closed) r9;
            if (r13.f != null) goto L33;
            r7.k(Boolean.FALSE);
            goto L41
        L33:
            r7.k(ResultKt.a(r13.P()));
            goto L41
        L27:
            r7.u(new RemoveReceiveOnCancel(r3, r5));
            goto L41
        L16:
            if ((r4 instanceof Closed) == false) goto L23;
            Closed r14 = (Closed) r4;
            if (r14.f != null) goto L21;
            r2 = false;
            goto L23
        L21:
            throw StackTraceRecoveryKt.c(r14.P());
        L23:
            return Boolean.valueOf(r2);
        L5:
            if ((r0 instanceof Closed) == false) goto L12;
            Closed r15 = (Closed) r0;
            if (r15.f != null) goto L10;
            r2 = false;
            goto L12
        L10:
            throw StackTraceRecoveryKt.c(r15.P());
        L12:
            return Boolean.valueOf(r2);
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public final Object next() {
            Object r0 = this.f380a;
            if ((r0 instanceof Closed) == true) goto L11;
            Symbol r1 = AbstractChannelKt.f383d;
            if (r0 == r1) goto L9;
            this.f380a = r1;
            return r0;
        L9:
            throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
        L11:
            throw StackTraceRecoveryKt.c(((Closed) r0).P());
        }
    }

    @Metadata
    public static class ReceiveElement<E> extends Receive<E> {
        public final CancellableContinuation f;
        public final int i;

        public ReceiveElement(CancellableContinuationImpl r1, int r2) {
            this.f = r1;
            this.i = r2;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public final void L(Closed r3) {
            CancellableContinuation r1 = this.f;
            int r2 = this.i;
            if (r2 != 1) goto L8;
            if (r3.f != null) goto L8;
            r1.k(null);
            return;
        L8:
            if (r2 != 2) goto L10;
            r1.k(new ValueOrClosed(new ValueOrClosed.Closed(r3.f)));
            return;
        L10:
            r1.k(ResultKt.a(r3.P()));
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public final void o(Object r1) {
            this.f.g();
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public final Symbol r(Object r4, LockFreeLinkedListNode.PrepareOp r5) {
            if (this.i == 2) goto L5;
            Object r0 = r4;
        L7:
            if (r5 == null) goto L9;
            LockFreeLinkedListNode.AbstractAtomicDesc r2 = r5.c;
        L11:
            if (this.f.m(r0, r2, K(r4)) == null) goto L17;
            boolean r3 = DebugKt.f370a;
            if (r5 == null) goto L16;
            r5.d();
        L16:
            return CancellableContinuationImplKt.f361a;
        L17:
            return null;
        L9:
            r2 = null;
            goto L11
        L5:
            r0 = new ValueOrClosed(r4);
            goto L7
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public final String toString() {
            StringBuilder r0 = new StringBuilder("ReceiveElement@");
            r0.append(DebugStringsKt.a(this));
            r0.append("[receiveMode=");
            return a.l(r0, this.i, ']');
        }
    }

    @Metadata
    public static final class ReceiveElementWithUndeliveredHandler<E> extends ReceiveElement<E> {
        public final Function1 j;

        public ReceiveElementWithUndeliveredHandler(CancellableContinuationImpl r1, int r2, Function1 r3) {
            super(r1, r2);
            this.j = r3;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public final Function1 K(Object r2) {
            CoroutineContext r0 = this.f.getContext();
            return OnUndeliveredElementKt.a(this.j, r2, r0);
        }
    }

    @Metadata
    public static class ReceiveHasNext<E> extends Receive<E> {
        public final Itr f;
        public final CancellableContinuation i;

        public ReceiveHasNext(Itr r1, CancellableContinuationImpl r2) {
            this.f = r1;
            this.i = r2;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public final Function1 K(Object r2) {
            Function1 r0 = this.f.b.c;
            if (r0 != null) goto L7;
            return null;
        L7:
            return OnUndeliveredElementKt.a(r0, r2, this.i.getContext());
        }

        @Override // kotlinx.coroutines.channels.Receive
        public final void L(Closed r4) {
            Throwable r0 = r4.f;
            CancellableContinuation r1 = this.i;
            if (r0 != null) goto L5;
            Symbol r2 = r1.c(Boolean.FALSE, null);
        L6:
            if (r2 == null) goto L9;
            this.f.f380a = r4;
            r1.g();
            return;
        L9:
            return;
        L5:
            r2 = r1.x(r4.P());
            goto L6
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public final void o(Object r2) {
            this.f.f380a = r2;
            this.i.g();
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public final Symbol r(Object r4, LockFreeLinkedListNode.PrepareOp r5) {
            Boolean r0 = Boolean.TRUE;
            if (r5 == null) goto L5;
            LockFreeLinkedListNode.AbstractAtomicDesc r2 = r5.c;
        L7:
            if (this.i.m(r0, r2, K(r4)) == null) goto L13;
            boolean r3 = DebugKt.f370a;
            if (r5 == null) goto L12;
            r5.d();
        L12:
            return CancellableContinuationImplKt.f361a;
        L13:
            return null;
        L5:
            r2 = null;
            goto L7
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public final String toString() {
            return "ReceiveHasNext@" + DebugStringsKt.a(this);
        }
    }

    @Metadata
    public static final class ReceiveSelect<R, E> extends Receive<E> implements DisposableHandle {
        public final AbstractChannel f;
        public final SelectInstance i;
        public final Function2 j;
        public final int k;

        public ReceiveSelect(int r1, Function2 r2, AbstractChannel r3, SelectInstance r4) {
            this.f = r3;
            this.i = r4;
            this.j = r2;
            this.k = r1;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public final Function1 K(Object r2) {
            Function1 r0 = this.f.c;
            if (r0 != null) goto L7;
            return null;
        L7:
            return OnUndeliveredElementKt.a(r0, r2, this.i.n().f.getContext());
        }

        @Override // kotlinx.coroutines.channels.Receive
        public final void L(Closed r5) {
            SelectInstance r0 = this.i;
            if (r0.h() == true) goto L5;
            return;
        L5:
            int r1 = this.k;
            if (r1 == 0) goto L17;
            Function2 r4 = this.j;
            if (r1 == 1) goto L14;
            if (r1 != 2) goto L22;
            CancellableKt.b(r4, new ValueOrClosed(new ValueOrClosed.Closed(r5.f)), r0.n(), null);
            return;
        L22:
            return;
        L14:
            if (r5.f != null) goto L16;
            CancellableKt.b(r4, null, r0.n(), null);
            return;
        L16:
            r0.p(r5.P());
            return;
        L17:
            r0.p(r5.P());
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode, kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            if (G() == false) goto L6;
            this.f.getClass();
            return;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public final void o(Object r3) {
            if (this.k != 2) goto L5;
            Object r0 = new ValueOrClosed(r3);
        L6:
            SelectBuilderImpl r1 = this.i.n();
            Function1 r4 = K(r3);
            CancellableKt.b(this.j, r0, r1, r4);
            return;
        L5:
            r0 = r3;
            goto L6
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public final Symbol r(Object r1, LockFreeLinkedListNode.PrepareOp r2) {
            return (Symbol) this.i.d(r2);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public final String toString() {
            StringBuilder r0 = new StringBuilder("ReceiveSelect@");
            r0.append(DebugStringsKt.a(this));
            r0.append('[');
            r0.append(this.i);
            r0.append(",receiveMode=");
            return a.l(r0, this.k, ']');
        }
    }

    @Metadata
    public final class RemoveReceiveOnCancel extends BeforeResumeCancelHandler {
        public final Receive b;
        public final /* synthetic */ AbstractChannel c;

        public RemoveReceiveOnCancel(AbstractChannel r1, Receive r2) {
            this.c = r1;
            this.b = r2;
        }

        @Override // kotlinx.coroutines.CancelHandlerBase
        public final void c(Throwable r1) {
            if (this.b.G() == false) goto L6;
            this.c.getClass();
            return;
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Object invoke(Object r1) {
            c((Throwable) r1);
            return Unit.f330a;
        }

        public final String toString() {
            return "RemoveReceiveOnCancel[" + this.b + ']';
        }
    }

    @Metadata
    public static final class TryPollDesc<E> extends LockFreeLinkedListNode.RemoveFirstDesc<Send> {
        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc, kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final Object c(LockFreeLinkedListNode r1) {
            if ((r1 instanceof Closed) == false) goto L6;
            return r1;
        L6:
            if ((r1 instanceof Send) == false) goto L10;
            return null;
        L10:
            return AbstractChannelKt.f383d;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final Object h(LockFreeLinkedListNode.PrepareOp r1) {
            LockFreeLinkedListNode r0 = r1.f415a;
            if (r0 == null) goto L14;
            Symbol r2 = ((Send) r0).N(r1);
            if (r2 == null) goto L12;
            Symbol r3 = AtomicKt.b;
            if (r2 != r3) goto L9;
            return r3;
        L9:
            boolean r4 = DebugKt.f370a;
            return null;
        L12:
            return LockFreeLinkedList_commonKt.f417a;
        L14:
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.Send");
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final void i(LockFreeLinkedListNode r1) {
            if (r1 == null) goto L6;
            ((Send) r1).O();
            return;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.Send");
        }
    }

    public static final void p(int r3, Function2 r4, AbstractChannel r5, SelectInstance r6) {
        r5.getClass();
    L4:
        if (r6.l() == true) goto L17;
        if ((r5.b.A() instanceof Send) == true) goto L15;
        if (r5.t() == false) goto L15;
        ReceiveSelect r0 = new ReceiveSelect(r3, r4, r5, r6);
        boolean r1 = r5.q(r0);
        if (r1 == false) goto L13;
        r6.s(r0);
    L13:
        if (r1 == false) goto L4;
        return;
    L15:
        Object r2 = r5.w(r6);
        if (r2 == SelectKt.b) goto L81;
        if (r2 == AbstractChannelKt.f383d) goto L4;
        if (r2 == AtomicKt.b) goto L4;
        boolean r7 = r2 instanceof Closed;
        if (r7 == true) goto L26;
        if (r3 == 2) goto L46;
        UndispatchedKt.a(r2, r6.n(), r4);
        goto L4
    L46:
        if (r7 == false) goto L48;
        r2 = new ValueOrClosed.Closed(((Closed) r2).f);
    L48:
        UndispatchedKt.a(new ValueOrClosed(r2), r6.n(), r4);
        goto L4
    L26:
        if (r3 == 0) goto L44;
        if (r3 != 1) goto L29;
        Closed r8 = (Closed) r2;
        if (r8.f != null) goto L42;
        if (r6.h() == false) goto L4;
        UndispatchedKt.a(null, r6.n(), r4);
        goto L4
    L42:
        throw StackTraceRecoveryKt.c(r8.P());
    L29:
        if (r3 != 2) goto L4;
        if (r6.h() == false) goto L4;
        UndispatchedKt.a(new ValueOrClosed(new ValueOrClosed.Closed(((Closed) r2).f)), r6.n(), r4);
        goto L4
    L44:
        throw StackTraceRecoveryKt.c(((Closed) r2).P());
    L81:
        return;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object G(Continuation r5) {
        if ((r5 instanceof AbstractChannel$receiveOrClosed$1) == false) goto L7;
        AbstractChannel$receiveOrClosed$1 r0 = (AbstractChannel$receiveOrClosed$1) r5;
        int r1 = r0.i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.i = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f;
        CoroutineSingletons r2 = CoroutineSingletons.b;
        int r3 = r0.i;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.b(r6);
    L24:
        return ((ValueOrClosed) r6).f388a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.b(r6);
        Object r7 = v();
        if (r7 != AbstractChannelKt.f383d) goto L17;
        r0.getClass();
        r0.k = r7;
        r0.i = 1;
        r6 = x(2, r0);
        if (r6 != r2) goto L24;
        return r2;
    L17:
        if ((r7 instanceof Closed) == true) goto L19;
        return r7;
    L19:
        return new ValueOrClosed.Closed(((Closed) r7).f);
    L7:
        r0 = new AbstractChannel$receiveOrClosed$1(this, r5);
        goto L8
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void a(CancellationException r3) {
        if (j() == false) goto L5;
        return;
    L5:
        if (r3 != null) goto L8;
        r3 = new CancellationException(getClass().getSimpleName().concat(" was cancelled"));
    L8:
        u(z(r3));
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final ChannelIterator iterator() {
        return new Itr(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean j() {
        if (e() != null) goto L5;
    L7:
        return false;
    L5:
        if (t() == false) goto L7;
        return true;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1 l() {
        return new AbstractChannel$onReceive$1(this);
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final ReceiveOrClosed m() {
        ReceiveOrClosed r1 = super.m();
        if (r1 == null) goto L5;
        boolean r0 = r1 instanceof Closed;
    L5:
        return r1;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1 n() {
        return new AbstractChannel$onReceiveOrNull$1(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object poll() {
        Object r2 = v();
        if (r2 != AbstractChannelKt.f383d) goto L6;
        return null;
    L6:
        if ((r2 instanceof Closed) == false) goto L13;
        Throwable r3 = ((Closed) r2).f;
        if (r3 != null) goto L11;
        r2 = null;
        goto L13
    L11:
        throw StackTraceRecoveryKt.c(r3);
    L13:
        return r2;
    }

    public boolean q(final Receive r6) {
        boolean r0 = r();
        LockFreeLinkedListNode r1 = this.b;
        if (r0 == false) goto L10;
    L4:
        LockFreeLinkedListNode r5 = r1.C();
        if ((!(r5 instanceof Send)) == false) goto L27;
        if (r5.t(r6, r1) == false) goto L4;
    L19:
        return true;
    L27:
        return false;
    L10:
        LockFreeLinkedListNode.CondAddOp r2 = new AbstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1(r6, this);
    L11:
        LockFreeLinkedListNode r7 = r1.C();
        if ((!(r7 instanceof Send)) == false) goto L29;
        int r8 = r7.J(r6, r1, r2);
        if (r8 == 1) goto L19;
        if (r8 != 2) goto L11;
        return false;
    L29:
        return false;
    }

    public abstract boolean r();

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object s(Continuation r3) {
        Object r0 = v();
        if (r0 == AbstractChannelKt.f383d) goto L8;
        if ((r0 instanceof Closed) == true) goto L8;
        return r0;
    L8:
        return x(1, r3);
    }

    public abstract boolean t();

    /* JADX WARN: Multi-variable type inference failed */
    public void u(boolean r4) {
        Closed r3 = f();
        if (r3 == null) goto L27;
        Object r5 = null;
    L5:
        LockFreeLinkedListNode r0 = r3.C();
        if ((r0 instanceof LockFreeLinkedListHead) == true) goto L7;
        boolean r1 = DebugKt.f370a;
        if (r0.G() == false) goto L18;
        Send r2 = (Send) r0;
        if (r5 == null) goto L21;
        if ((r5 instanceof ArrayList) == true) goto L24;
        ArrayList r6 = new ArrayList(4);
        r6.add(r5);
        r6.add(r2);
        r5 = r6;
        goto L5
    L24:
        ((ArrayList) r5).add(r2);
        goto L5
    L21:
        r5 = r2;
        goto L5
    L18:
        r0.D();
        goto L5
    L7:
        if (r5 != null) goto L10;
        return;
    L10:
        if ((r5 instanceof ArrayList) == true) goto L12;
        ((Send) r5).M(r3);
        return;
    L12:
        ArrayList r7 = (ArrayList) r5;
        int r8 = r7.size() - 1;
    L13:
        if (r8 < 0) goto L42;
        ((Send) r7.get(r8)).M(r3);
        r8 = r8 - 1;
        goto L13
    L42:
        return;
    L27:
        throw new IllegalStateException("Cannot happen".toString());
    }

    public Object v() {
    L2:
        Send r0 = o();
        if (r0 == null) goto L10;
        if (r0.N(null) != null) goto L6;
        r0.O();
        goto L2
    L6:
        boolean r2 = DebugKt.f370a;
        r0.K();
        return r0.L();
    L10:
        return AbstractChannelKt.f383d;
    }

    public Object w(SelectInstance r2) {
        TryPollDesc r0 = new TryPollDesc(this.b);
        Object r1 = r2.q(r0);
        if (r1 == null) goto L5;
        return r1;
    L5:
        ((Send) r0.m()).K();
        return ((Send) r0.m()).L();
    }

    public final Object x(int r3, Continuation r4) {
        CancellableContinuationImpl r5 = CancellableContinuationKt.a(IntrinsicsKt.b(r4));
        Function1 r0 = this.c;
        if (r0 != null) goto L5;
        ReceiveElement r1 = new ReceiveElement(r5, r3);
    L7:
        if (q(r1) == true) goto L8;
        Object r6 = v();
        if ((r6 instanceof Closed) == true) goto L11;
        if (r6 == AbstractChannelKt.f383d) goto L7;
        if (r1.i == 2) goto L17;
        Object r2 = r6;
    L18:
        Function1 r7 = r1.K(r6);
        r5.A(r2, r5.e, r7);
    L20:
        return r5.s();
    L17:
        r2 = new ValueOrClosed(r6);
        goto L18
    L11:
        r1.L((Closed) r6);
        goto L20
    L8:
        r5.u(new RemoveReceiveOnCancel(this, r1));
        goto L20
    L5:
        r1 = new ReceiveElementWithUndeliveredHandler(r5, r3, r0);
        goto L7
    }
}
