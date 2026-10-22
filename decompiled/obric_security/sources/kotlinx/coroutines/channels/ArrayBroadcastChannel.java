package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.security.Utils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ConcurrentKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

/* JADX INFO: compiled from: ArrayBroadcastChannel.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000L2\b\u0012\u0004\u0012\u00028\u00000M:\u0001JB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0017¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\t\u001a\u00020\r2\u000e\u0010\u0007\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fH\u0016¢\u0006\u0004\b\t\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\nJ\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00028\u00002\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0014¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0016¢\u0006\u0004\b\"\u0010#J4\u0010'\u001a\u00020\r2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$H\u0082\u0010¢\u0006\u0004\b'\u0010(R\u001c\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020,8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0018\u00102\u001a\u000600j\u0002`18\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00104\u001a\u0004\b5\u00106R$\u0010;\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u00138B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b8\u0010\u0015\"\u0004\b9\u0010:R\u0014\u0010<\u001a\u00020\b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020\b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b>\u0010=R$\u0010A\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u00028B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b?\u00106\"\u0004\b@\u0010\u0005R6\u0010D\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000$0Bj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000$`C8\u0002X\u0082\u0004¢\u0006\f\n\u0004\bD\u0010E\u0012\u0004\bF\u0010\u0011R$\u0010I\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u00138B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bG\u0010\u0015\"\u0004\bH\u0010:¨\u0006K"}, d2 = {"Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", ExifInterface.LONGITUDE_EAST, "", PerfConsts.KEY_CURRENT_CAPACITY, "<init>", "(I)V", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "(Ljava/util/concurrent/CancellationException;)V", "cancelInternal", "checkSubOffers", "()V", "close", "", "computeMinHead", "()J", Utils.INTENT_KEY_INDEX, "elementAt", "(J)Ljava/lang/Object;", "element", "", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", "addSub", "removeSub", "updateHead", "(Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;)V", "", "buffer", "[Ljava/lang/Object;", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "bufferLock", "Ljava/util/concurrent/locks/ReentrantLock;", "I", "getCapacity", "()I", "value", "getHead", "setHead", "(J)V", "head", "isBufferAlwaysFull", "()Z", "isBufferFull", "getSize", "setSize", PerfConsts.PERF_DISK_FILE_SIZE, "", "Lkotlinx/coroutines/internal/SubscribersList;", "subscribers", "Ljava/util/List;", "getSubscribers$annotations", "getTail", "setTail", "tail", "Subscriber", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/BroadcastChannel;"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ArrayBroadcastChannel<E> extends AbstractSendChannel<E> implements BroadcastChannel<E> {
    private volatile /* synthetic */ long _head;
    private volatile /* synthetic */ int _size;
    private volatile /* synthetic */ long _tail;
    private final Object[] buffer;
    private final ReentrantLock bufferLock;
    private final int capacity;
    private final List<Subscriber<E>> subscribers;

    /* JADX INFO: compiled from: ArrayBroadcastChannel.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010'2\b\u0012\u0004\u0012\u00028\u00010(B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\bJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0011\u0010\u0010J\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\bR\u0014\u0010\u0018\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\bR\u0014\u0010\u0019\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\bR\u0014\u0010\u001a\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\bR$\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u00060\"j\u0002`#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "broadcastChannel", "<init>", "(Lkotlinx/coroutines/channels/ArrayBroadcastChannel;)V", "", "checkOffer", "()Z", "", "cause", "close", "(Ljava/lang/Throwable;)Z", "needsToCheckOfferWithoutLock", "", "peekUnderLock", "()Ljava/lang/Object;", "pollInternal", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "isBufferAlwaysEmpty", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "", "value", "getSubHead", "()J", "setSubHead", "(J)V", "subHead", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "subLock", "Ljava/util/concurrent/locks/ReentrantLock;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/AbstractChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class Subscriber<E> extends AbstractChannel<E> implements ReceiveChannel<E> {
        private volatile /* synthetic */ long _subHead;
        private final ArrayBroadcastChannel<E> broadcastChannel;
        private final ReentrantLock subLock;

        @Override // kotlinx.coroutines.channels.AbstractChannel
        protected boolean isBufferAlwaysEmpty() {
            return false;
        }

        public Subscriber(ArrayBroadcastChannel<E> r3) {
            super(null);
            this.broadcastChannel = r3;
            this.subLock = new ReentrantLock();
            this._subHead = 0;
        }

        public final long getSubHead() {
            return this._subHead;
        }

        public final void setSubHead(long r1) {
            this._subHead = r1;
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        protected boolean isBufferEmpty() {
            if (getSubHead() < ArrayBroadcastChannel.access$getTail(this.broadcastChannel)) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlinx.coroutines.channels.AbstractSendChannel
        protected boolean isBufferAlwaysFull() {
            throw new IllegalStateException("Should not be used".toString());
        }

        @Override // kotlinx.coroutines.channels.AbstractSendChannel
        protected boolean isBufferFull() {
            throw new IllegalStateException("Should not be used".toString());
        }

        @Override // kotlinx.coroutines.channels.AbstractSendChannel, kotlinx.coroutines.channels.SendChannel
        public boolean close(Throwable r4) {
            boolean r5 = super.close(r4);
            if (r5 == false) goto L10;
            ArrayBroadcastChannel.updateHead$default(this.broadcastChannel, null, this, 1, null);
            ReentrantLock r0 = this.subLock;
            r0.lock();
            setSubHead(ArrayBroadcastChannel.access$getTail(this.broadcastChannel));     // Catch: Throwable -> L7
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L7
            r0.unlock();
        L7:
            th = move-exception;
            r0.unlock();
            throw th;
        L10:
            return r5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final boolean checkOffer() {
            boolean r1 = false;
        L3:
            Closed r3 = null;
            if (needsToCheckOfferWithoutLock() == false) goto L38;
            if (this.subLock.tryLock() == false) goto L38;
            Object r2 = peekUnderLock();     // Catch: Throwable -> L35
            if (r2 == AbstractChannelKt.POLL_FAILED) goto L9;
            if ((r2 instanceof Closed) == true) goto L12;
            ReceiveOrClosed<E> r4 = takeFirstReceiveOrPeekClosed();     // Catch: Throwable -> L35
            if (r4 == 0) goto L13;
            if ((r4 instanceof Closed) == true) goto L13;
            Symbol r5 = r4.tryResumeReceive(r2, null);     // Catch: Throwable -> L35
            if (r5 == null) goto L9;
            if (DebugKt.getASSERTIONS_ENABLED() == true) goto L26;
        L33:
            setSubHead(getSubHead() + 1);     // Catch: Throwable -> L35
            this.subLock.unlock();
            r4.completeResumeReceive(r2);
            r1 = true;
            goto L3
        L26:
            if (r5 != CancellableContinuationImplKt.RESUME_TOKEN) goto L28;
            boolean r6 = true;
        L29:
            if (r6 == true) goto L33;
            throw new AssertionError();     // Catch: Throwable -> L35
        L28:
            r6 = false;
        L13:
            this.subLock.unlock();
            goto L38
        L12:
            r3 = (Closed) r2;     // Catch: Throwable -> L35
        L9:
            this.subLock.unlock();
        L35:
            th = move-exception;
            this.subLock.unlock();
            throw th;
        L38:
            if (r3 == null) goto L40;
            close(r3.closeCause);
        L40:
            return r1;
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        protected Object pollInternal() {
            ReentrantLock r0 = this.subLock;
            r0.lock();
            Object r1 = peekUnderLock();     // Catch: Throwable -> L23
            boolean r3 = true;
            if ((r1 instanceof Closed) == false) goto L6;
        L9:
            boolean r2 = false;
        L10:
            r0.unlock();
            if ((r1 instanceof Closed) == false) goto L13;
            Closed r4 = (Closed) r1;
        L14:
            if (r4 == null) goto L17;
            close(r4.closeCause);
        L17:
            if (checkOffer() == true) goto L20;
            r3 = r2;
        L20:
            if (r3 == false) goto L22;
            ArrayBroadcastChannel.updateHead$default(this.broadcastChannel, null, null, 3, null);
        L22:
            return r1;
        L13:
            r4 = null;
            goto L14
        L6:
            if (r1 == AbstractChannelKt.POLL_FAILED) goto L9;
            setSubHead(getSubHead() + 1);     // Catch: Throwable -> L23
            r2 = true;
        L23:
            th = move-exception;
            r0.unlock();
            throw th;
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        protected Object pollSelectInternal(SelectInstance<?> r9) {
            ReentrantLock r0 = this.subLock;
            r0.lock();
            Object r1 = peekUnderLock();     // Catch: Throwable -> L25
            boolean r3 = true;
            boolean r4 = false;
            if ((r1 instanceof Closed) == false) goto L6;
        L12:
            r0.unlock();
            if ((r1 instanceof Closed) == false) goto L15;
            Closed r10 = (Closed) r1;
        L16:
            if (r10 == null) goto L19;
            close(r10.closeCause);
        L19:
            if (checkOffer() == true) goto L22;
            r3 = r4;
        L22:
            if (r3 == false) goto L24;
            ArrayBroadcastChannel.updateHead$default(this.broadcastChannel, null, null, 3, null);
        L24:
            return r1;
        L15:
            r10 = null;
            goto L16
        L6:
            if (r1 == AbstractChannelKt.POLL_FAILED) goto L12;
            if (r9.trySelect() == true) goto L10;
            r1 = SelectKt.getALREADY_SELECTED();     // Catch: Throwable -> L25
            goto L12
        L10:
            setSubHead(getSubHead() + 1);     // Catch: Throwable -> L25
            r4 = true;
        L25:
            th = move-exception;
            r0.unlock();
            throw th;
        }

        private final boolean needsToCheckOfferWithoutLock() {
            if (getClosedForReceive() == null) goto L6;
            return false;
        L6:
            if (isBufferEmpty() == true) goto L8;
            return true;
        L8:
            if (this.broadcastChannel.getClosedForReceive() != null) goto L12;
            return false;
        L12:
            return true;
        }

        private final Object peekUnderLock() {
            long r0 = getSubHead();
            Closed<?> r2 = this.broadcastChannel.getClosedForReceive();
            if (r0 < ArrayBroadcastChannel.access$getTail(this.broadcastChannel)) goto L9;
            if (r2 != null) goto L13;
            Closed<?> r3 = getClosedForReceive();
            if (r3 == null) goto L8;
            return r3;
        L8:
            return AbstractChannelKt.POLL_FAILED;
        L13:
            return r2;
        L9:
            Object r1 = ArrayBroadcastChannel.access$elementAt(this.broadcastChannel, r0);
            Closed<?> r5 = getClosedForReceive();
            if (r5 == null) goto L12;
            return r5;
        L12:
            return r1;
        }
    }

    private static /* synthetic */ void getSubscribers$annotations() {
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected boolean isBufferAlwaysFull() {
        return false;
    }

    public static final /* synthetic */ Object access$elementAt(ArrayBroadcastChannel r0, long r1) {
        return r0.elementAt(r1);
    }

    public static final /* synthetic */ long access$getTail(ArrayBroadcastChannel r2) {
        return r2.getTail();
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public ArrayBroadcastChannel(int r4) {
        super(null);
        this.capacity = r4;
        boolean r1 = true;
        if (r4 >= 1) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L10;
        this.bufferLock = new ReentrantLock();
        this.buffer = new Object[r4];
        this._head = 0;
        this._tail = 0;
        this._size = 0;
        this.subscribers = ConcurrentKt.subscriberList();
        return;
    L10:
        throw new IllegalArgumentException(("ArrayBroadcastChannel capacity must be at least 1, but " + r4 + " was specified").toString());
    }

    private final long getHead() {
        return this._head;
    }

    private final void setHead(long r1) {
        this._head = r1;
    }

    private final long getTail() {
        return this._tail;
    }

    private final void setTail(long r1) {
        this._tail = r1;
    }

    private final int getSize() {
        return this._size;
    }

    private final void setSize(int r1) {
        this._size = r1;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected boolean isBufferFull() {
        if (getSize() < this.capacity) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel<E> openSubscription() {
        Subscriber r0 = new Subscriber(this);
        updateHead$default(this, r0, null, 2, null);
        return r0;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel, kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable r1) {
        if (super.close(r1) == true) goto L6;
        return false;
    L6:
        checkSubOffers();
        return true;
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean cancel(Throwable r1) {
        return cancelInternal(r1);
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public void cancel(CancellationException r1) {
        cancelInternal(r1);
    }

    private final boolean cancelInternal(Throwable r3) {
        boolean r0 = close(r3);
        Iterator<Subscriber<E>> r2 = this.subscribers.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r2.next().cancelInternal$kotlinx_coroutines_core(r3);
        goto L4
    L6:
        return r0;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object offerInternal(E r8) {
        ReentrantLock r0 = this.bufferLock;
        r0.lock();
        Closed<?> r1 = getClosedForSend();     // Catch: Throwable -> L15
        if (r1 == null) goto L7;
        r0.unlock();
        return r1;
    L7:
        int r2 = getSize();     // Catch: Throwable -> L15
        if (r2 < this.capacity) goto L12;
        Symbol r7 = AbstractChannelKt.OFFER_FAILED;     // Catch: Throwable -> L15
        r0.unlock();
        return r7;
    L12:
        long r3 = getTail();     // Catch: Throwable -> L15
        this.buffer[(int) (r3 % ((long) this.capacity))] = r8;     // Catch: Throwable -> L15
        setSize(r2 + 1);     // Catch: Throwable -> L15
        setTail(r3 + 1);     // Catch: Throwable -> L15
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r0.unlock();
        checkSubOffers();
        return AbstractChannelKt.OFFER_SUCCESS;
    L15:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object offerSelectInternal(E r7, SelectInstance<?> r8) {
        ReentrantLock r0 = this.bufferLock;
        r0.lock();
        Closed<?> r1 = getClosedForSend();     // Catch: Throwable -> L20
        if (r1 == null) goto L7;
        r0.unlock();
        return r1;
    L7:
        int r2 = getSize();     // Catch: Throwable -> L20
        if (r2 < this.capacity) goto L13;
        Symbol r6 = AbstractChannelKt.OFFER_FAILED;     // Catch: Throwable -> L20
        r0.unlock();
        return r6;
    L13:
        if (r8.trySelect() == true) goto L17;
        Object r9 = SelectKt.getALREADY_SELECTED();     // Catch: Throwable -> L20
        r0.unlock();
        return r9;
    L17:
        long r3 = getTail();     // Catch: Throwable -> L20
        this.buffer[(int) (r3 % ((long) this.capacity))] = r7;     // Catch: Throwable -> L20
        setSize(r2 + 1);     // Catch: Throwable -> L20
        setTail(r3 + 1);     // Catch: Throwable -> L20
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L20
        r0.unlock();
        checkSubOffers();
        return AbstractChannelKt.OFFER_SUCCESS;
    L20:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    private final void checkSubOffers() {
        Iterator<Subscriber<E>> r0 = this.subscribers.iterator();
        boolean r1 = false;
    L3:
        boolean r2 = r1;
    L5:
        if (r0.hasNext() == false) goto L10;
        if (r0.next().checkOffer() == true) goto L8;
        r2 = true;
        goto L5
    L8:
        r1 = true;
        goto L3
    L10:
        if (r1 == true) goto L12;
        if (r2 == false) goto L12;
        return;
    L12:
        updateHead$default(this, null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void updateHead$default(ArrayBroadcastChannel r1, Subscriber r2, Subscriber r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        r1.updateHead(r2, r3);
    }

    private final void updateHead(Subscriber<E> r14, Subscriber<E> r15) {
    L2:
        ReentrantLock r0 = this.bufferLock;
        r0.lock();
        if (r14 != null) goto L52;
    L10:
        if (r15 == null) goto L16;
        this.subscribers.remove(r15);     // Catch: Throwable -> L8
        if (getHead() == r15.getSubHead()) goto L16;
        r0.unlock();
        return;
    L16:
        long r16 = computeMinHead();     // Catch: Throwable -> L8
        long r1 = getTail();     // Catch: Throwable -> L8
        long r3 = getHead();     // Catch: Throwable -> L8
        long r17 = RangesKt.coerceAtMost(r16, r1);     // Catch: Throwable -> L8
        if (r17 <= r3) goto L19;
        int r5 = getSize();     // Catch: Throwable -> L8
    L23:
        if (r3 >= r17) goto L48;
        Object[] r6 = this.buffer;     // Catch: Throwable -> L8
        int r7 = this.capacity;     // Catch: Throwable -> L8
        r6[(int) (r3 % ((long) r7))] = null;     // Catch: Throwable -> L8
        boolean r8 = false;
        if (r5 < r7) goto L27;
        boolean r9 = true;
    L28:
        r3 = r3 + 1;     // Catch: Throwable -> L8
        setHead(r3);     // Catch: Throwable -> L8
        r5 = r5 - 1;     // Catch: Throwable -> L8
        setSize(r5);     // Catch: Throwable -> L8
        if (r9 == false) goto L23;
    L30:
        Send r10 = takeFirstSendOrPeekClosed();     // Catch: Throwable -> L8
        if (r10 == null) goto L23;
        if ((r10 instanceof Closed) == true) goto L23;
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L8
        Symbol r12 = r10.tryResumeSend(null);     // Catch: Throwable -> L8
        if (r12 == null) goto L30;
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L40;
    L46:
        this.buffer[(int) (r1 % ((long) this.capacity))] = r10.getPollResult();     // Catch: Throwable -> L8
        setSize(r5 + 1);     // Catch: Throwable -> L8
        setTail(r1 + 1);     // Catch: Throwable -> L8
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L8
        r0.unlock();
        r10.completeResumeSend();
        checkSubOffers();
        r14 = null;
        r15 = null;
        goto L2
    L40:
        if (r12 != CancellableContinuationImplKt.RESUME_TOKEN) goto L42;
        r8 = true;
    L42:
        if (r8 == true) goto L46;
        throw new AssertionError();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r0.unlock();
        throw th;
    L27:
        r9 = false;
        goto L28
    L48:
        r0.unlock();
        return;
    L19:
        r0.unlock();
        return;
    L52:
        r14.setSubHead(getTail());     // Catch: Throwable -> L8
        boolean r2 = this.subscribers.isEmpty();     // Catch: Throwable -> L8
        this.subscribers.add(r14);     // Catch: Throwable -> L8
        if (r2 == true) goto L10;
        r0.unlock();
    }

    private final long computeMinHead() {
        Iterator<Subscriber<E>> r4 = this.subscribers.iterator();
        long r0 = Long.MAX_VALUE;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = RangesKt.coerceAtMost(r0, r4.next().getSubHead());
        goto L4
    L6:
        return r0;
    }

    private final E elementAt(long r4) {
        return (E) this.buffer[(int) (r4 % ((long) this.capacity))];
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected String getBufferDebugString() {
        return "(buffer:capacity=" + this.buffer.length + ",size=" + getSize() + ')';
    }
}
