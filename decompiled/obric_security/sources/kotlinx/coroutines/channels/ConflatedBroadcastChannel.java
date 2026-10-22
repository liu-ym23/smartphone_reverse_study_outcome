package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.CommonKey;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: ConflatedBroadcastChannel.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\b\u0007\u0018\u0000 B*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000G:\u0004CBDEB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004B\u0007¢\u0006\u0004\b\u0003\u0010\u0005J?\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00062\u0014\u0010\b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0018\u00010\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0017¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u000f\u001a\u00020\u00132\u000e\u0010\r\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012H\u0016¢\u0006\u0004\b\u000f\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0010J\u001d\u0010\u0016\u001a\u00020\u00132\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001b\u001a\u00020\u00132\u0018\u0010\u001a\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00130\u0018j\u0002`\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016¢\u0006\u0004\b$\u0010%JX\u0010.\u001a\u00020\u0013\"\u0004\b\u0001\u0010&2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010'2\u0006\u0010\u001f\u001a\u00028\u00002(\u0010-\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000*\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010+\u0012\u0006\u0012\u0004\u0018\u00010,0)H\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010/J?\u00100\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0018\u00010\u00062\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002¢\u0006\u0004\b0\u0010\u000bJ\u001b\u00101\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b1\u00102J&\u00106\u001a\b\u0012\u0004\u0012\u00020\u0013032\u0006\u0010\u001f\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b4\u00105R\u0014\u00107\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R&\u0010<\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000*098VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0017\u0010\u0002\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b?\u0010\u0005\u001a\u0004\b=\u0010>R\u0013\u0010A\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b@\u0010>\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006F"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", ExifInterface.LONGITUDE_EAST, "value", "<init>", "(Ljava/lang/Object;)V", "()V", "", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "list", "subscriber", "addSubscriber", "([Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "(Ljava/util/concurrent/CancellationException;)V", "close", "closeSubscriber", "(Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "invokeOnCloseHandler", "(Ljava/lang/Throwable;)V", "element", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "offerInternal", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "", "block", "registerSelectSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "removeSubscriber", CommonKey.KEY_SEND, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "isClosedForSend", "()Z", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "getValue", "()Ljava/lang/Object;", "getValue$annotations", "getValueOrNull", "valueOrNull", "Companion", "Closed", "State", "Subscriber", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/BroadcastChannel;"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ConflatedBroadcastChannel<E> implements BroadcastChannel<E> {

    @Deprecated
    private static final Closed CLOSED = null;
    private static final Companion Companion = null;

    @Deprecated
    private static final State<Object> INITIAL_STATE = null;

    @Deprecated
    private static final Symbol UNDEFINED = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU = null;
    private static final /* synthetic */ AtomicIntegerFieldUpdater _updating$FU = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater onCloseHandler$FU = null;
    private volatile /* synthetic */ Object _state;
    private volatile /* synthetic */ int _updating;
    private volatile /* synthetic */ Object onCloseHandler;

    /* JADX INFO: compiled from: ConflatedBroadcastChannel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "", "closeCause", "", "(Ljava/lang/Throwable;)V", "sendException", "getSendException", "()Ljava/lang/Throwable;", "valueException", "getValueException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class Closed {
        public final Throwable closeCause;

        public Closed(Throwable r1) {
            this.closeCause = r1;
        }

        public final Throwable getSendException() {
            Throwable r1 = this.closeCause;
            if (r1 == null) goto L5;
            return r1;
        L5:
            return new ClosedSendChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
        }

        public final Throwable getValueException() {
            Throwable r1 = this.closeCause;
            if (r1 == null) goto L5;
            return r1;
        L5:
            return new IllegalStateException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
        }
    }

    /* JADX INFO: compiled from: ConflatedBroadcastChannel.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Companion;", "", "()V", "CLOSED", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "INITIAL_STATE", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$State;", "UNDEFINED", "Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: ConflatedBroadcastChannel.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R \u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$State;", ExifInterface.LONGITUDE_EAST, "", "value", "subscribers", "", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "(Ljava/lang/Object;[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V", "[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class State<E> {
        public final Subscriber<E>[] subscribers;
        public final Object value;

        public State(Object r1, Subscriber<E>[] r2) {
            this.value = r1;
            this.subscribers = r2;
        }
    }

    /* JADX INFO: compiled from: ConflatedBroadcastChannel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ConflatedChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "broadcastChannel", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "(Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;)V", "offerInternal", "", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "onCancelIdempotent", "", "wasClosed", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class Subscriber<E> extends ConflatedChannel<E> implements ReceiveChannel<E> {
        private final ConflatedBroadcastChannel<E> broadcastChannel;

        public Subscriber(ConflatedBroadcastChannel<E> r2) {
            super(null);
            this.broadcastChannel = r2;
        }

        @Override // kotlinx.coroutines.channels.ConflatedChannel, kotlinx.coroutines.channels.AbstractChannel
        protected void onCancelIdempotent(boolean r1) {
            if (r1 == false) goto L5;
            ConflatedBroadcastChannel.access$closeSubscriber(this.broadcastChannel, this);
            return;
        }

        @Override // kotlinx.coroutines.channels.ConflatedChannel, kotlinx.coroutines.channels.AbstractSendChannel
        public Object offerInternal(E r1) {
            return super.offerInternal(r1);
        }
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    public ConflatedBroadcastChannel() {
        this._state = INITIAL_STATE;
        this._updating = 0;
        this.onCloseHandler = null;
    }

    public static final /* synthetic */ void access$closeSubscriber(ConflatedBroadcastChannel r0, Subscriber r1) {
        r0.closeSubscriber(r1);
    }

    public static final /* synthetic */ void access$registerSelectSend(ConflatedBroadcastChannel r0, SelectInstance r1, Object r2, Function2 r3) {
        r0.registerSelectSend(r1, r2, r3);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E r1) {
        return BroadcastChannel.DefaultImpls.offer(this, r1);
    }

    public ConflatedBroadcastChannel(E r4) {
        this();
        _state$FU.lazySet(this, new State(r4, null));
    }

    static {
        Companion = new Companion(null);
        CLOSED = new Closed(null);
        Symbol r0 = new Symbol("UNDEFINED");
        UNDEFINED = r0;
        INITIAL_STATE = new State(r0, null);
        _state$FU = AtomicReferenceFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, Object.class, "_state");
        _updating$FU = AtomicIntegerFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, "_updating");
        onCloseHandler$FU = AtomicReferenceFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, Object.class, "onCloseHandler");
    }

    public final E getValueOrNull() {
        Object r3 = this._state;
        if ((r3 instanceof Closed) == false) goto L6;
        return null;
    L6:
        if ((r3 instanceof State) == false) goto L13;
        Symbol r0 = UNDEFINED;
        E r4 = (E) ((State) r3).value;
        if (r4 != r0) goto L11;
        return null;
    L11:
        return r4;
    L13:
        throw new IllegalStateException(("Invalid state " + r3).toString());
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this._state instanceof Closed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel<E> openSubscription() {
        Subscriber r0 = new Subscriber(this);
    L3:
        Object r1 = this._state;
        if ((r1 instanceof Closed) == true) goto L5;
        if ((r1 instanceof State) == false) goto L17;
        State r2 = (State) r1;
        if (r2.value == UNDEFINED) goto L13;
        r0.offerInternal(r2.value);
    L13:
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r1, new State(r2.value, addSubscriber(r2.subscribers, r0))) == false) goto L3;
        return r0;
    L17:
        throw new IllegalStateException(("Invalid state " + r1).toString());
    L5:
        r0.close(((Closed) r1).closeCause);
        return r0;
    }

    private final Subscriber<E>[] addSubscriber(Subscriber<E>[] r1, Subscriber<E> r2) {
        if (r1 != null) goto L6;
        return new Subscriber[]{r2};
    L6:
        return (Subscriber[]) ArraysKt.plus(r1, r2);
    }

    private final Subscriber<E>[] removeSubscriber(Subscriber<E>[] r8, Subscriber<E> r9) {
        int r7 = r8.length;
        int r10 = ArraysKt.indexOf(r8, r9);
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L11;
        if (r10 < 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L11;
        throw new AssertionError();
    L6:
        r0 = false;
    L11:
        if (r7 != 1) goto L14;
        return null;
    L14:
        Subscriber<E>[] r11 = new Subscriber[r7 - 1];
        ArraysKt.copyInto$default(r8, r11, 0, 0, r10, 6, null);
        ArraysKt.copyInto$default(r8, r11, r10, r10 + 1, 0, 8, null);
        return r11;
    }

    private final void invokeOnCloseHandler(Throwable r4) {
        Object r0 = this.onCloseHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0 != AbstractChannelKt.HANDLER_INVOKED) goto L7;
        return;
    L7:
        if (b0$$ExternalSyntheticBackport0.m(onCloseHandler$FU, this, r0, AbstractChannelKt.HANDLER_INVOKED) == false) goto L12;
        ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r0, 1)).invoke(r4);
        return;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1<? super Throwable, Unit> r4) {
        AtomicReferenceFieldUpdater r0 = onCloseHandler$FU;
        if (b0$$ExternalSyntheticBackport0.m(r0, this, null, r4) == true) goto L10;
        Object r3 = this.onCloseHandler;
        if (r3 != AbstractChannelKt.HANDLER_INVOKED) goto L9;
        throw new IllegalStateException("Another handler was already registered and successfully invoked");
    L9:
        throw new IllegalStateException("Another handler was already registered: " + r3);
    L10:
        Object r1 = this._state;
        if ((r1 instanceof Closed) == true) goto L13;
        return;
    L13:
        if (b0$$ExternalSyntheticBackport0.m(r0, this, r4, AbstractChannelKt.HANDLER_INVOKED) == false) goto L17;
        r4.invoke(((Closed) r1).closeCause);
        return;
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean cancel(Throwable r1) {
        return close(r1);
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public void cancel(CancellationException r1) {
        close(r1);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(E r1, Continuation<? super Unit> r2) {
        Closed r0 = offerInternal(r1);
        if (r0 != null) goto L11;
        if (IntrinsicsKt.getCOROUTINE_SUSPENDED() != null) goto L9;
        return null;
    L9:
        return Unit.INSTANCE;
    L11:
        throw r0.getSendException();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo2281trySendJP2dKIU(E r1) {
        Closed r0 = offerInternal(r1);
        if (r0 == null) goto L7;
        return ChannelResult.Companion.m2299closedJP2dKIU(r0.getSendException());
    L7:
        return ChannelResult.Companion.m2301successJP2dKIU(Unit.INSTANCE);
    }

    private final Closed offerInternal(E r7) {
        if (_updating$FU.compareAndSet(this, 0, 1) == true) goto L27;
        return null;
    L27:
        Object r0 = this._state;     // Catch: Throwable -> L24
        if ((r0 instanceof Closed) == true) goto L7;
        if ((r0 instanceof State) == false) goto L23;
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r0, new State(r7, ((State) r0).subscribers)) == false) goto L27;
        Subscriber<E>[] r1 = ((State) r0).subscribers;     // Catch: Throwable -> L24
        if (r1 == null) goto L20;
        int r3 = r1.length;     // Catch: Throwable -> L24
        int r4 = 0;
    L17:
        if (r4 >= r3) goto L20;
        r1[r4].offerInternal(r7);     // Catch: Throwable -> L24
        r4 = r4 + 1;
    L20:
        this._updating = 0;
        return null;
    L23:
        throw new IllegalStateException(("Invalid state " + r0).toString());     // Catch: Throwable -> L24
    L7:
        Closed r2 = (Closed) r0;     // Catch: Throwable -> L24
        this._updating = 0;
        return r2;
    L24:
        th = move-exception;
        this._updating = 0;
        throw th;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return new ConflatedBroadcastChannel$onSend$1(this);
    }

    private final <R> void registerSelectSend(SelectInstance<? super R> r2, E r3, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> r4) {
        if (r2.trySelect() == true) goto L5;
        return;
    L5:
        Closed r5 = offerInternal(r3);
        if (r5 == null) goto L9;
        r2.resumeSelectWithException(r5.getSendException());
        return;
    L9:
        UndispatchedKt.startCoroutineUnintercepted(r4, this, r2.getCompletion());
    }

    public final E getValue() {
        Object r3 = this._state;
        if ((r3 instanceof Closed) == true) goto L15;
        if ((r3 instanceof State) == false) goto L13;
        State r4 = (State) r3;
        if (r4.value == UNDEFINED) goto L11;
        return (E) r4.value;
    L11:
        throw new IllegalStateException("No value");
    L13:
        throw new IllegalStateException(("Invalid state " + r3).toString());
    L15:
        throw ((Closed) r3).getValueException();
    }

    private final void closeSubscriber(Subscriber<E> r5) {
    L2:
        Object r0 = this._state;
        if ((r0 instanceof Closed) == true) goto L4;
        if ((r0 instanceof State) == false) goto L11;
        State r2 = (State) r0;
        Object r3 = r2.value;
        Subscriber<E>[] r4 = r2.subscribers;
        Intrinsics.checkNotNull(r4);
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r0, new State(r3, removeSubscriber(r4, r5))) == false) goto L2;
        return;
    L11:
        throw new IllegalStateException(("Invalid state " + r0).toString());
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable r5) {
    L2:
        Object r0 = this._state;
        int r2 = 0;
        if ((r0 instanceof Closed) == true) goto L4;
        if ((r0 instanceof State) == false) goto L20;
        if (r5 != null) goto L9;
        Closed r1 = CLOSED;
    L11:
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r0, r1) == false) goto L2;
        Subscriber<E>[] r3 = ((State) r0).subscribers;
        if (r3 == null) goto L17;
        int r4 = r3.length;
    L15:
        if (r2 >= r4) goto L17;
        r3[r2].close(r5);
        r2 = r2 + 1;
    L17:
        invokeOnCloseHandler(r5);
        return true;
    L9:
        r1 = new Closed(r5);
        goto L11
    L20:
        throw new IllegalStateException(("Invalid state " + r0).toString());
    L4:
        return false;
    }
}
