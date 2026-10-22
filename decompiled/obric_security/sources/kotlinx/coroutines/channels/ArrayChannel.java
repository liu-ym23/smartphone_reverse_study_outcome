package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.PerfConsts;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

/* JADX INFO: compiled from: ArrayChannel.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000BB9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012 \u0010\t\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00172\u0006\u0010\r\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010 \u001a\u00020\u00172\u0006\u0010\r\u001a\u00028\u00002\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0014¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0012H\u0014¢\u0006\u0004\b#\u0010$J\u0011\u0010%\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b%\u0010&J\u001d\u0010'\u001a\u0004\u0018\u00010\u00172\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0014¢\u0006\u0004\b'\u0010(J\u0019\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010+R\u001e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00102\u001a\u00020/8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00103R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00103R\u0014\u00105\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u00107\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b7\u00106R\u0014\u00108\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b8\u00106R\u0014\u00109\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b9\u00106R\u0014\u0010:\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u00106R\u0014\u0010;\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u00106R\u0018\u0010>\u001a\u00060<j\u0002`=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010@¨\u0006A"}, d2 = {"Lkotlinx/coroutines/channels/ArrayChannel;", ExifInterface.LONGITUDE_EAST, "", PerfConsts.KEY_CURRENT_CAPACITY, "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "currentSize", "element", "enqueueElement", "(ILjava/lang/Object;)V", "Lkotlinx/coroutines/channels/Receive;", "receive", "", "enqueueReceiveInternal", "(Lkotlinx/coroutines/channels/Receive;)Z", "Lkotlinx/coroutines/channels/Send;", CommonKey.KEY_SEND, "", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "ensureCapacity", "(I)V", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "wasClosed", "onCancelIdempotent", "(Z)V", "pollInternal", "()Ljava/lang/Object;", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "updateBufferSize", "(I)Lkotlinx/coroutines/internal/Symbol;", "", "buffer", "[Ljava/lang/Object;", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "I", "head", "isBufferAlwaysEmpty", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "isClosedForReceive", "isEmpty", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/channels/BufferOverflow;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/AbstractChannel;"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ArrayChannel<E> extends AbstractChannel<E> {
    private Object[] buffer;
    private final int capacity;
    private int head;
    private final ReentrantLock lock;
    private final BufferOverflow onBufferOverflow;
    private volatile /* synthetic */ int size;

    /* JADX INFO: compiled from: ArrayChannel.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[BufferOverflow.values().length];
            r0[BufferOverflow.SUSPEND.ordinal()] = 1;
            r0[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            r0[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            $EnumSwitchMapping$0 = r0;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean isBufferAlwaysEmpty() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean isBufferAlwaysFull() {
        return false;
    }

    public ArrayChannel(int r7, BufferOverflow r8, Function1<? super E, Unit> r9) {
        super(r9);
        this.capacity = r7;
        this.onBufferOverflow = r8;
        boolean r10 = true;
        if (r7 >= 1) goto L6;
        r10 = false;
    L6:
        if (r10 == false) goto L10;
        this.lock = new ReentrantLock();
        Object[] r11 = new Object[Math.min(r7, 8)];
        ArraysKt.fill$default(r11, AbstractChannelKt.EMPTY, 0, 0, 6, null);
        this.buffer = r11;
        this.size = 0;
        return;
    L10:
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + r7 + " was specified").toString());
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean isBufferEmpty() {
        if (this.size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean isBufferFull() {
        if (this.size == this.capacity) goto L5;
    L7:
        return false;
    L5:
        if (this.onBufferOverflow != BufferOverflow.SUSPEND) goto L7;
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel, kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        ReentrantLock r0 = this.lock;
        r0.lock();
        boolean r1 = isEmptyImpl();     // Catch: Throwable -> L6
        r0.unlock();
        return r1;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel, kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        ReentrantLock r0 = this.lock;
        r0.lock();
        boolean r1 = super.isClosedForReceive();     // Catch: Throwable -> L6
        r0.unlock();
        return r1;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object offerInternal(E r6) {
        ReentrantLock r0 = this.lock;
        r0.lock();
        int r1 = this.size;     // Catch: Throwable -> L38
        Closed<?> r2 = getClosedForSend();     // Catch: Throwable -> L38
        if (r2 == null) goto L7;
        r0.unlock();
        return r2;
    L7:
        Symbol r3 = updateBufferSize(r1);     // Catch: Throwable -> L38
        if (r3 == null) goto L11;
        r0.unlock();
        return r3;
    L11:
        if (r1 != 0) goto L35;
    L12:
        ReceiveOrClosed<E> r4 = takeFirstReceiveOrPeekClosed();     // Catch: Throwable -> L38
        if (r4 == null) goto L35;
        if ((r4 instanceof Closed) == true) goto L17;
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L38
        Symbol r5 = r4.tryResumeReceive(r6, null);     // Catch: Throwable -> L38
        if (r5 == null) goto L12;
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L25;
    L32:
        this.size = r1;     // Catch: Throwable -> L38
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L38
        r0.unlock();
        r4.completeResumeReceive(r6);
        return r4.getOfferResult();
    L25:
        if (r5 != CancellableContinuationImplKt.RESUME_TOKEN) goto L27;
        boolean r8 = true;
    L28:
        if (r8 == true) goto L32;
        throw new AssertionError();     // Catch: Throwable -> L38
    L27:
        r8 = false;
        goto L28
    L17:
        this.size = r1;     // Catch: Throwable -> L38
        r0.unlock();
        return r4;
    L35:
        enqueueElement(r1, r6);     // Catch: Throwable -> L38
        Symbol r9 = AbstractChannelKt.OFFER_SUCCESS;     // Catch: Throwable -> L38
        r0.unlock();
        return r9;
    L38:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object offerSelectInternal(E r5, SelectInstance<?> r6) {
        ReentrantLock r0 = this.lock;
        r0.lock();
        int r1 = this.size;     // Catch: Throwable -> L39
        Closed<?> r2 = getClosedForSend();     // Catch: Throwable -> L39
        if (r2 == null) goto L7;
        r0.unlock();
        return r2;
    L7:
        Symbol r3 = updateBufferSize(r1);     // Catch: Throwable -> L39
        if (r3 == null) goto L11;
        r0.unlock();
        return r3;
    L11:
        if (r1 != 0) goto L32;
    L12:
        AbstractSendChannel.TryOfferDesc<E> r4 = describeTryOffer(r5);     // Catch: Throwable -> L39
        Object r7 = r6.performAtomicTrySelect(r4);     // Catch: Throwable -> L39
        if (r7 == null) goto L14;
        if (r7 == AbstractChannelKt.OFFER_FAILED) goto L32;
        if (r7 == AtomicKt.RETRY_ATOMIC) goto L12;
        if (r7 != SelectKt.getALREADY_SELECTED()) goto L24;
    L28:
        this.size = r1;     // Catch: Throwable -> L39
        r0.unlock();
        return r7;
    L24:
        if ((r7 instanceof Closed) == true) goto L28;
        throw new IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + r7).toString());     // Catch: Throwable -> L39
    L14:
        this.size = r1;     // Catch: Throwable -> L39
        ReceiveOrClosed<? super E> r8 = r4.getResult();     // Catch: Throwable -> L39
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L39
        r0.unlock();
        Intrinsics.checkNotNull(r8);
        ReceiveOrClosed<? super E> r10 = r8;
        r10.completeResumeReceive(r5);
        return r10.getOfferResult();
    L32:
        if (r6.trySelect() == true) goto L36;
        this.size = r1;     // Catch: Throwable -> L39
        Object r11 = SelectKt.getALREADY_SELECTED();     // Catch: Throwable -> L39
        r0.unlock();
        return r11;
    L36:
        enqueueElement(r1, r5);     // Catch: Throwable -> L39
        Symbol r12 = AbstractChannelKt.OFFER_SUCCESS;     // Catch: Throwable -> L39
        r0.unlock();
        return r12;
    L39:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object enqueueSend(Send r2) {
        ReentrantLock r0 = this.lock;
        r0.lock();
        Object r1 = super.enqueueSend(r2);     // Catch: Throwable -> L6
        r0.unlock();
        return r1;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    private final Symbol updateBufferSize(int r4) {
        if (r4 >= this.capacity) goto L6;
        this.size = r4 + 1;
        return null;
    L6:
        BufferOverflow r3 = this.onBufferOverflow;
        int r5 = WhenMappings.$EnumSwitchMapping$0[r3.ordinal()];
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L18;
        if (r5 != 3) goto L14;
        return null;
    L14:
        throw new NoWhenBranchMatchedException();
    L18:
        return AbstractChannelKt.OFFER_SUCCESS;
    L17:
        return AbstractChannelKt.OFFER_FAILED;
    }

    private final void enqueueElement(int r6, E r7) {
        if (r6 >= this.capacity) goto L6;
        ensureCapacity(r6);
        Object[] r0 = this.buffer;
        r0[(this.head + r6) % r0.length] = r7;
        return;
    L6:
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L8;
    L15:
        Object[] r1 = this.buffer;
        int r2 = this.head;
        r1[r2 % r1.length] = null;
        r1[(r6 + r2) % r1.length] = r7;
        this.head = (r2 + 1) % r1.length;
        return;
    L8:
        if (this.onBufferOverflow != BufferOverflow.DROP_OLDEST) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L15;
        throw new AssertionError();
    L10:
        r3 = false;
        goto L11
    }

    private final void ensureCapacity(int r8) {
        Object[] r0 = this.buffer;
        if (r8 < r0.length) goto L10;
        int r1 = Math.min(r0.length * 2, this.capacity);
        Object[] r2 = new Object[r1];
        int r3 = 0;
    L5:
        if (r3 >= r8) goto L7;
        Object[] r4 = this.buffer;
        r2[r3] = r4[(this.head + r3) % r4.length];
        r3 = r3 + 1;
        goto L5
    L7:
        ArraysKt.fill(r2, AbstractChannelKt.EMPTY, r8, r1);
        this.buffer = r2;
        this.head = 0;
        return;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected Object pollInternal() {
        ReentrantLock r0 = this.lock;
        r0.lock();
        int r1 = this.size;     // Catch: Throwable -> L39
        if (r1 != 0) goto L10;
        Object r9 = getClosedForSend();     // Catch: Throwable -> L39
        if (r9 != null) goto L8;
        r9 = AbstractChannelKt.POLL_FAILED;     // Catch: Throwable -> L39
    L8:
        r0.unlock();
        return r9;
    L10:
        Object[] r2 = this.buffer;     // Catch: Throwable -> L39
        int r3 = this.head;     // Catch: Throwable -> L39
        Object r4 = r2[r3];     // Catch: Throwable -> L39
        Send r5 = null;
        r2[r3] = null;     // Catch: Throwable -> L39
        this.size = r1 - 1;     // Catch: Throwable -> L39
        Object r6 = AbstractChannelKt.POLL_FAILED;     // Catch: Throwable -> L39
        boolean r7 = false;
        if (r1 != this.capacity) goto L30;
        Send r8 = null;
    L13:
        Send r10 = takeFirstSendOrPeekClosed();     // Catch: Throwable -> L39
        if (r10 == null) goto L15;
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L39
        Symbol r11 = r10.tryResumeSend(null);     // Catch: Throwable -> L39
        if (r11 != null) goto L19;
        r10.undeliveredElement();     // Catch: Throwable -> L39
        r8 = r10;
        goto L13
    L19:
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L21;
    L27:
        r6 = r10.getPollResult();     // Catch: Throwable -> L39
        r7 = true;
        r5 = r10;
        goto L30
    L21:
        if (r11 != CancellableContinuationImplKt.RESUME_TOKEN) goto L23;
        r7 = true;
    L23:
        if (r7 == true) goto L27;
        throw new AssertionError();     // Catch: Throwable -> L39
    L15:
        r5 = r8;
    L30:
        if (r6 != AbstractChannelKt.POLL_FAILED) goto L32;
    L34:
        this.head = (this.head + 1) % this.buffer.length;     // Catch: Throwable -> L39
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L39
        r0.unlock();
        if (r7 == false) goto L38;
        Intrinsics.checkNotNull(r5);
        r5.completeResumeSend();
    L38:
        return r4;
    L32:
        if ((r6 instanceof Closed) == true) goto L34;
        this.size = r1;     // Catch: Throwable -> L39
        Object[] r13 = this.buffer;     // Catch: Throwable -> L39
        r13[(this.head + r1) % r13.length] = r6;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected Object pollSelectInternal(SelectInstance<?> r9) {
        ReentrantLock r0 = this.lock;
        r0.lock();
        int r1 = this.size;     // Catch: Throwable -> L45
        if (r1 != 0) goto L10;
        Object r8 = getClosedForSend();     // Catch: Throwable -> L45
        if (r8 != null) goto L8;
        r8 = AbstractChannelKt.POLL_FAILED;     // Catch: Throwable -> L45
    L8:
        r0.unlock();
        return r8;
    L10:
        Object[] r2 = this.buffer;     // Catch: Throwable -> L45
        int r3 = this.head;     // Catch: Throwable -> L45
        Object r4 = r2[r3];     // Catch: Throwable -> L45
        Object r5 = null;
        r2[r3] = null;     // Catch: Throwable -> L45
        this.size = r1 - 1;     // Catch: Throwable -> L45
        Object r6 = AbstractChannelKt.POLL_FAILED;     // Catch: Throwable -> L45
        if (r1 != this.capacity) goto L29;
    L12:
        AbstractChannel.TryPollDesc<E> r7 = describeTryPoll();     // Catch: Throwable -> L45
        Object r10 = r9.performAtomicTrySelect(r7);     // Catch: Throwable -> L45
        if (r10 == null) goto L14;
        if (r10 == AbstractChannelKt.POLL_FAILED) goto L29;
        if (r10 == AtomicKt.RETRY_ATOMIC) goto L12;
        if (r10 != SelectKt.getALREADY_SELECTED()) goto L25;
        this.size = r1;     // Catch: Throwable -> L45
        this.buffer[this.head] = r4;     // Catch: Throwable -> L45
        r0.unlock();
        return r10;
    L25:
        if ((r10 instanceof Closed) == false) goto L28;
        boolean r11 = true;
        r6 = r10;
        r5 = r6;
    L31:
        if (r6 == AbstractChannelKt.POLL_FAILED) goto L36;
        if ((r6 instanceof Closed) == true) goto L36;
        this.size = r1;     // Catch: Throwable -> L45
        Object[] r12 = this.buffer;     // Catch: Throwable -> L45
        r12[(this.head + r1) % r12.length] = r6;     // Catch: Throwable -> L45
    L40:
        this.head = (this.head + 1) % this.buffer.length;     // Catch: Throwable -> L45
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L45
        r0.unlock();
        if (r11 == false) goto L44;
        Intrinsics.checkNotNull(r5);
        ((Send) r5).completeResumeSend();
    L44:
        return r4;
    L36:
        if (r9.trySelect() == true) goto L40;
        this.size = r1;     // Catch: Throwable -> L45
        this.buffer[this.head] = r4;     // Catch: Throwable -> L45
        Object r14 = SelectKt.getALREADY_SELECTED();     // Catch: Throwable -> L45
        r0.unlock();
        return r14;
    L28:
        throw new IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + r10).toString());     // Catch: Throwable -> L45
    L14:
        r5 = r7.getResult();     // Catch: Throwable -> L45
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L45
        r6 = ((Send) r5).getPollResult();     // Catch: Throwable -> L45
        r11 = true;
    L29:
        r11 = false;
    L45:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected boolean enqueueReceiveInternal(Receive<? super E> r2) {
        ReentrantLock r0 = this.lock;
        r0.lock();
        boolean r1 = super.enqueueReceiveInternal(r2);     // Catch: Throwable -> L6
        r0.unlock();
        return r1;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected void onCancelIdempotent(boolean r10) {
        Function1<E, Unit> r0 = this.onUndeliveredElement;
        ReentrantLock r1 = this.lock;
        r1.lock();
        int r2 = this.size;     // Catch: Throwable -> L16
        UndeliveredElementException r4 = null;
        int r5 = 0;
    L4:
        if (r5 >= r2) goto L11;
        Object r6 = this.buffer[this.head];     // Catch: Throwable -> L16
        if (r0 == null) goto L10;
        if (r6 == AbstractChannelKt.EMPTY) goto L10;
        r4 = OnUndeliveredElementKt.callUndeliveredElementCatchingException(r0, r6, r4);     // Catch: Throwable -> L16
    L10:
        this.buffer[this.head] = AbstractChannelKt.EMPTY;     // Catch: Throwable -> L16
        this.head = (this.head + 1) % this.buffer.length;     // Catch: Throwable -> L16
        r5 = r5 + 1;     // Catch: Throwable -> L16
        goto L4
    L11:
        this.size = 0;     // Catch: Throwable -> L16
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L16
        r1.unlock();
        super.onCancelIdempotent(r10);
        if (r4 != null) goto L15;
        return;
    L15:
        throw r4;
    L16:
        th = move-exception;
        r1.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected String getBufferDebugString() {
        return "(buffer:capacity=" + this.capacity + ",size=" + this.size + ')';
    }
}
