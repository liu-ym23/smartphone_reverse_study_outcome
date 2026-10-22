package kotlinx.coroutines.channels;

import a.a;
import d.b;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class AbstractSendChannel<E> implements SendChannel<E> {
    public static final AtomicReferenceFieldUpdater e = null;
    public final LockFreeLinkedListHead b;
    public final Function1 c;
    private volatile Object onCloseHandler;

    @Metadata
    public static final class SendBuffered<E> extends Send {
        public final Object f;

        public SendBuffered(Object r1) {
            this.f = r1;
        }

        @Override // kotlinx.coroutines.channels.Send
        public final void K() {
        }

        @Override // kotlinx.coroutines.channels.Send
        public final Object L() {
            return this.f;
        }

        @Override // kotlinx.coroutines.channels.Send
        public final void M(Closed r1) {
        }

        @Override // kotlinx.coroutines.channels.Send
        public final Symbol N(LockFreeLinkedListNode.PrepareOp r1) {
            Symbol r0 = CancellableContinuationImplKt.f361a;
            if (r1 == null) goto L5;
            r1.d();
        L5:
            return r0;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public final String toString() {
            return "SendBuffered@" + DebugStringsKt.a(this) + '(' + this.f + ')';
        }
    }

    @Metadata
    public static class SendBufferedDesc<E> extends LockFreeLinkedListNode.AddLastDesc<SendBuffered<? extends E>> {
        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final Object c(LockFreeLinkedListNode r1) {
            if ((r1 instanceof Closed) == false) goto L6;
            return r1;
        L6:
            if ((r1 instanceof ReceiveOrClosed) == true) goto L10;
            return null;
        L10:
            return AbstractChannelKt.c;
        }
    }

    @Metadata
    public static final class SendSelect<E, R> extends Send implements DisposableHandle {
        @Override // kotlinx.coroutines.channels.Send
        public final void K() {
            throw null;
        }

        @Override // kotlinx.coroutines.channels.Send
        public final Object L() {
            throw null;
        }

        @Override // kotlinx.coroutines.channels.Send
        public final void M(Closed r1) {
            throw null;
        }

        @Override // kotlinx.coroutines.channels.Send
        public final Symbol N(LockFreeLinkedListNode.PrepareOp r1) {
            throw null;
        }

        @Override // kotlinx.coroutines.channels.Send
        public final void O() {
            throw null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode, kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            if (G() == true) goto L5;
            return;
        L5:
            O();
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public final String toString() {
            StringBuilder r0 = new StringBuilder("SendSelect@");
            r0.append(DebugStringsKt.a(this));
            r0.append('(');
            throw null;
        }
    }

    @Metadata
    public static final class TryOfferDesc<E> extends LockFreeLinkedListNode.RemoveFirstDesc<ReceiveOrClosed<? super E>> {
        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc, kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final Object c(LockFreeLinkedListNode r1) {
            if ((r1 instanceof Closed) == false) goto L6;
            return r1;
        L6:
            if ((r1 instanceof ReceiveOrClosed) == false) goto L10;
            return null;
        L10:
            return AbstractChannelKt.c;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final Object h(LockFreeLinkedListNode.PrepareOp r1) {
            Object r0 = r1.f415a;
            if (r0 == null) goto L7;
            ReceiveOrClosed r2 = (ReceiveOrClosed) r0;
            throw null;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveOrClosed<E>");
        }
    }

    static {
        e = AtomicReferenceFieldUpdater.newUpdater(AbstractSendChannel.class, Object.class, "onCloseHandler");
    }

    public AbstractSendChannel(Function1 r1) {
        this.c = r1;
        this.b = new LockFreeLinkedListHead();
        this.onCloseHandler = null;
    }

    public static final void b(AbstractSendChannel r1, CancellableContinuationImpl r2, Object r3, Closed r4) {
        r1.getClass();
        g(r4);
        Throwable r5 = r4.Q();
        Function1 r6 = r1.c;
        if (r6 == null) goto L7;
        UndeliveredElementException r7 = OnUndeliveredElementKt.b(r6, r3, null);
        if (r7 == null) goto L7;
        ExceptionsKt.a(r7, r5);
        r2.k(ResultKt.a(r7));
        return;
    L7:
        r2.k(ResultKt.a(r5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void g(Closed r5) {
        Object r1 = null;
    L3:
        LockFreeLinkedListNode r2 = r5.C();
        if ((r2 instanceof Receive) == true) goto L6;
        r2 = null;
    L6:
        Receive r3 = (Receive) r2;
        if (r3 == null) goto L18;
        if (r3.G() == false) goto L10;
        boolean r4 = DebugKt.f370a;
        if (r1 == null) goto L13;
        if ((r1 instanceof ArrayList) == true) goto L16;
        ArrayList r6 = new ArrayList(4);
        r6.add(r1);
        r6.add(r3);
        r1 = r6;
        goto L3
    L16:
        ((ArrayList) r1).add(r3);
        goto L3
    L13:
        r1 = r3;
        goto L3
    L10:
        r3.D();
        goto L3
    L18:
        if (r1 != null) goto L21;
        return;
    L21:
        if ((r1 instanceof ArrayList) == true) goto L23;
        ((Receive) r1).L(r5);
        return;
    L23:
        ArrayList r7 = (ArrayList) r1;
        int r0 = r7.size() - 1;
    L24:
        if (r0 < 0) goto L41;
        ((Receive) r7.get(r0)).L(r5);
        r0 = r0 - 1;
        goto L24
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final void E(Function1 r4) {
        AtomicReferenceFieldUpdater r0 = e;
        boolean r1 = r0.compareAndSet(this, null, r4);
        Symbol r2 = AbstractChannelKt.f;
        if (r1 == true) goto L10;
        Object r3 = this.onCloseHandler;
        if (r3 != r2) goto L9;
        throw new IllegalStateException("Another handler was already registered and successfully invoked");
    L9:
        throw new IllegalStateException(b.a(r3, "Another handler was already registered: "));
    L10:
        Closed r5 = f();
        if (r5 != null) goto L13;
        return;
    L13:
        if (r0.compareAndSet(this, r4, r2) == false) goto L17;
        r4.invoke(r5.f);
        return;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object I(Object r5, Continuation r6) {
        Object r0 = k(r5);
        Symbol r1 = AbstractChannelKt.b;
        Unit r2 = Unit.f330a;
        if (r0 != r1) goto L5;
        return r2;
    L5:
        CancellableContinuationImpl r7 = CancellableContinuationKt.a(IntrinsicsKt.b(r6));
    L7:
        if ((this.b.A() instanceof ReceiveOrClosed) == false) goto L9;
    L28:
        Object r3 = k(r5);
        if (r3 == r1) goto L30;
        if (r3 == AbstractChannelKt.c) goto L7;
        if ((r3 instanceof Closed) == false) goto L42;
        b(this, r7, r5, (Closed) r3);
    L37:
        Object r4 = r7.s();
        if (r4 != CoroutineSingletons.b) goto L40;
        return r4;
    L40:
        return r2;
    L42:
        throw new IllegalStateException(b.a(r3, "offerInternal returned ").toString());
    L30:
        r7.k(r2);
        goto L37
    L9:
        if (i() == false) goto L28;
        Function1 r8 = this.c;
        if (r8 != null) goto L13;
        SendElement r9 = new SendElement(r5, r7);
    L14:
        Object r10 = c(r9);
        if (r10 == null) goto L16;
        if ((r10 instanceof Closed) == true) goto L19;
        if (r10 == AbstractChannelKt.e) goto L28;
        if ((r10 instanceof Receive) == true) goto L28;
        throw new IllegalStateException(b.a(r10, "enqueueSend returned ").toString());
    L19:
        b(this, r7, r5, (Closed) r10);
        goto L37
    L16:
        CancellableContinuationKt.b(r7, r9);
        goto L37
    L13:
        r9 = new SendElementWithUndeliveredHandler(r5, r7, r8);
        goto L14
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean J() {
        if (f() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public Object c(final Send r4) {
        boolean r0 = h();
        LockFreeLinkedListNode r1 = this.b;
        if (r0 == false) goto L10;
    L4:
        LockFreeLinkedListNode r3 = r1.C();
        if ((r3 instanceof ReceiveOrClosed) == true) goto L6;
        if (r3.t(r4, r1) == false) goto L4;
        return null;
    L6:
        return r3;
    L10:
        LockFreeLinkedListNode.CondAddOp r2 = new AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1(r4, this);
    L11:
        LockFreeLinkedListNode r5 = r1.C();
        if ((r5 instanceof ReceiveOrClosed) == true) goto L13;
        int r6 = r5.J(r4, r1, r2);
        if (r6 == 1) goto L30;
        if (r6 != 2) goto L11;
        return AbstractChannelKt.e;
    L30:
        return null;
    L13:
        return r5;
    }

    public String d() {
        return "";
    }

    public final Closed e() {
        LockFreeLinkedListNode r2 = this.b.A();
        if ((r2 instanceof Closed) == true) goto L5;
        r2 = null;
    L5:
        Closed r3 = (Closed) r2;
        if (r3 == null) goto L9;
        g(r3);
        return r3;
    L9:
        return null;
    }

    public final Closed f() {
        LockFreeLinkedListNode r2 = this.b.C();
        if ((r2 instanceof Closed) == true) goto L5;
        r2 = null;
    L5:
        Closed r3 = (Closed) r2;
        if (r3 == null) goto L9;
        g(r3);
        return r3;
    L9:
        return null;
    }

    public abstract boolean h();

    public abstract boolean i();

    public Object k(Object r3) {
    L2:
        ReceiveOrClosed r0 = m();
        if (r0 == null) goto L9;
        if (r0.r(r3, null) == null) goto L2;
        boolean r2 = DebugKt.f370a;
        r0.o(r3);
        return r0.f();
    L9:
        return AbstractChannelKt.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [kotlinx.coroutines.internal.LockFreeLinkedListNode] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    public ReceiveOrClosed m() {
        LockFreeLinkedListHead r3 = this.b;
    L3:
        Object r0 = r3.z();
        if (r0 == null) goto L22;
        ?? r1 = (LockFreeLinkedListNode) r0;
        if (r1 == r3) goto L7;
        if ((r1 instanceof ReceiveOrClosed) == false) goto L7;
        if ((((ReceiveOrClosed) r1) instanceof Closed) == true) goto L14;
    L16:
        LockFreeLinkedListNode r2 = r1.H();
        if (r2 == null) goto L19;
        r2.E();
    L19:
        return (ReceiveOrClosed) r1;
    L14:
        if (r1.F() == true) goto L16;
    L7:
        r1 = 0;
        goto L19
    L22:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    public final Send o() {
        LockFreeLinkedListHead r3 = this.b;
    L3:
        Object r0 = r3.z();
        if (r0 == null) goto L22;
        LockFreeLinkedListNode r1 = (LockFreeLinkedListNode) r0;
        if (r1 == r3) goto L7;
        if ((r1 instanceof Send) == false) goto L7;
        if ((((Send) r1) instanceof Closed) == true) goto L14;
    L16:
        LockFreeLinkedListNode r2 = r1.H();
        if (r2 == null) goto L19;
        r2.E();
    L19:
        return (Send) r1;
    L14:
        if (r1.F() == true) goto L16;
    L7:
        r1 = null;
        goto L19
    L22:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(getClass().getSimpleName());
        r0.append('@');
        r0.append(DebugStringsKt.a(this));
        r0.append('{');
        LockFreeLinkedListNode r1 = this.b;
        LockFreeLinkedListNode r2 = r1.A();
        if (r2 != r1) goto L6;
        String r3 = "EmptyQueue";
    L29:
        r0.append(r3);
        r0.append('}');
        r0.append(d());
        return r0.toString();
    L6:
        if ((r2 instanceof Closed) == false) goto L9;
        String r4 = r2.toString();
    L15:
        LockFreeLinkedListNode r5 = r1.C();
        if (r5 == r2) goto L28;
        StringBuilder r6 = a.t(r4, ",queueSize=");
        Object r7 = r1.z();
        if (r7 == null) goto L27;
        LockFreeLinkedListNode r8 = (LockFreeLinkedListNode) r7;
        int r9 = 0;
    L21:
        if ((!r8.equals(r1)) == false) goto L23;
        r9 = r9 + 1;
        r8 = r8.A();
        goto L21
    L23:
        r6.append(r9);
        r3 = r6.toString();
        if ((r5 instanceof Closed) == false) goto L29;
        r3 = r3 + ",closedForSend=" + r5;
        goto L29
    L27:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    L28:
        r3 = r4;
        goto L29
    L9:
        if ((r2 instanceof Receive) == false) goto L12;
        r4 = "ReceiveQueued";
        goto L15
    L12:
        if ((r2 instanceof Send) == false) goto L14;
        r4 = "SendQueued";
        goto L15
    L14:
        r4 = "UNEXPECTED:" + r2;
        goto L15
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean z(Throwable r6) {
        Closed r0 = new Closed(r6);
        LockFreeLinkedListNode r1 = this.b;
    L3:
        LockFreeLinkedListNode r2 = r1.C();
        if ((!(r2 instanceof Closed)) == false) goto L5;
        if (r2.t(r0, r1) == false) goto L3;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L12;
        r0 = (Closed) this.b.C();
    L12:
        g(r0);
        if (r3 == false) goto L21;
        Object r4 = this.onCloseHandler;
        if (r4 == null) goto L21;
        Symbol r5 = AbstractChannelKt.f;
        if (r4 == r5) goto L21;
        if (e.compareAndSet(this, r4, r5) == false) goto L21;
        TypeIntrinsics.b(1, r4);
        ((Function1) r4).invoke(r6);
    L21:
        return r3;
    L5:
        r3 = false;
        goto L9
    }
}
