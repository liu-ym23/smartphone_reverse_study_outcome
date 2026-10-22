package kotlinx.coroutines.channels;

import d.b;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@ExperimentalCoroutinesApi
public final class ConflatedBroadcastChannel<E> implements BroadcastChannel<E> {
    public static final AtomicReferenceFieldUpdater b = null;
    public static final AtomicIntegerFieldUpdater c = null;
    public static final AtomicReferenceFieldUpdater e = null;
    public static final Closed f = null;
    private volatile Object _state;
    private volatile int _updating;
    private volatile Object onCloseHandler;

    @Metadata
    public static final class Closed {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f386a;

        public Closed(Throwable r1) {
            this.f386a = r1;
        }
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class State<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f387a;
        public final Subscriber[] b;

        public State(Object r1, Subscriber[] r2) {
            this.f387a = r1;
            this.b = r2;
        }
    }

    @Metadata
    public static final class Subscriber<E> extends ConflatedChannel<E> implements ReceiveChannel<E> {
        @Override // kotlinx.coroutines.channels.ConflatedChannel, kotlinx.coroutines.channels.AbstractChannel
        public final void u(boolean r1) {
            if (r1 == false) goto L5;
            ConflatedBroadcastChannel.a(null, this);
            return;
        }
    }

    static {
        f = new Closed(null);
        new Symbol("UNDEFINED");
        b = AtomicReferenceFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, Object.class, "_state");
        c = AtomicIntegerFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, "_updating");
        e = AtomicReferenceFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, Object.class, "onCloseHandler");
    }

    public static final void a(ConflatedBroadcastChannel r13, Subscriber r14) {
    L3:
        Object r1 = r13._state;
        if ((r1 instanceof Closed) == true) goto L16;
        if ((r1 instanceof State) == false) goto L20;
        State r3 = (State) r1;
        Object r4 = r3.f387a;
        if (r1 == null) goto L18;
        Subscriber[] r5 = r3.b;
        Intrinsics.c(r5);
        int r6 = r5.length;
        int r11 = ArraysKt.s(r5, r14);
        boolean r7 = DebugKt.f370a;
        if (r6 != 1) goto L13;
        Subscriber[] r8 = null;
    L14:
        State r2 = new State(r4, r8);
        if (b.compareAndSet(r13, r1, r2) == false) goto L3;
        return;
    L13:
        Subscriber[] r12 = new Subscriber[r6 - 1];
        ArraysKt.i(r5, r12, 0, 0, r11, 6);
        ArraysKt.i(r5, r12, r11, r11 + 1, 0, 8);
        r8 = r12;
        goto L14
    L18:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
    L20:
        throw new IllegalStateException(b.a(r1, "Invalid state ").toString());
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final void E(Function1 r5) {
        AtomicReferenceFieldUpdater r0 = e;
        boolean r1 = r0.compareAndSet(this, null, r5);
        Symbol r2 = AbstractChannelKt.f;
        if (r1 == true) goto L10;
        Object r4 = this.onCloseHandler;
        if (r4 != r2) goto L9;
        throw new IllegalStateException("Another handler was already registered and successfully invoked");
    L9:
        throw new IllegalStateException(b.a(r4, "Another handler was already registered: "));
    L10:
        Object r3 = this._state;
        if ((r3 instanceof Closed) == true) goto L13;
        return;
    L13:
        if (r0.compareAndSet(this, r5, r2) == false) goto L17;
        r5.invoke(((Closed) r3).f386a);
        return;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object I(Object r6, Continuation r7) {
        Closed r1 = null;
        if (c.compareAndSet(this, 0, 1) == true) goto L40;
    L23:
        if (r1 == null) goto L25;
        Throwable r5 = r1.f386a;
        if (r5 == null) goto L33;
        throw r5;
    L33:
        throw new ClosedSendChannelException("Channel was closed");
    L25:
        if (r1 != CoroutineSingletons.b) goto L28;
        return r1;
    L28:
        return Unit.f330a;
    L40:
        Object r8 = this._state;     // Catch: Throwable -> L9
        if ((r8 instanceof Closed) == true) goto L7;
        if ((r8 instanceof State) == false) goto L37;
        if (r8 == null) goto L35;
        if (b.compareAndSet(this, r8, new State(r6, ((State) r8).b)) == false) goto L40;
        Subscriber[] r9 = ((State) r8).b;     // Catch: Throwable -> L9
        if (r9 != null) goto L19;
    L8:
        this._updating = 0;
        goto L23
    L19:
        int r2 = r9.length;     // Catch: Throwable -> L9
        int r3 = 0;
    L20:
        if (r3 >= r2) goto L8;
        r9[r3].k(r6);     // Catch: Throwable -> L9
        r3 = r3 + 1;
        goto L20
    L35:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");     // Catch: Throwable -> L9
    L37:
        throw new IllegalStateException(("Invalid state " + r8).toString());     // Catch: Throwable -> L9
    L7:
        r1 = (Closed) r8;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        this._updating = 0;
        throw th;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean J() {
        throw null;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean z(Throwable r5) {
    L2:
        Object r0 = this._state;
        int r2 = 0;
        if ((r0 instanceof Closed) == true) goto L4;
        if ((r0 instanceof State) == false) goto L29;
        if (r5 != null) goto L9;
        Closed r1 = f;
    L11:
        if (b.compareAndSet(this, r0, r1) == false) goto L2;
        if (r0 == null) goto L27;
        Subscriber[] r3 = ((State) r0).b;
        if (r3 == null) goto L18;
        int r4 = r3.length;
    L16:
        if (r2 >= r4) goto L18;
        r3[r2].z(r5);
        r2 = r2 + 1;
    L18:
        Object r6 = this.onCloseHandler;
        if (r6 == null) goto L25;
        Symbol r7 = AbstractChannelKt.f;
        if (r6 == r7) goto L25;
        if (e.compareAndSet(this, r6, r7) == false) goto L25;
        TypeIntrinsics.b(1, r6);
        ((Function1) r6).invoke(r5);
    L25:
        return true;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
    L9:
        r1 = new Closed(r5);
        goto L11
    L29:
        throw new IllegalStateException(b.a(r0, "Invalid state ").toString());
    L4:
        return false;
    }
}
