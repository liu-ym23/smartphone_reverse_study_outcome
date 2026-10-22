package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
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

/* JADX INFO: compiled from: ConflatedChannel.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012 \u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0018\u001a\u00020\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0014J\u0015\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u001dJ!\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00028\u00002\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 H\u0014¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\rH\u0014J\n\u0010$\u001a\u0004\u0018\u00010\u0017H\u0014J\u0016\u0010%\u001a\u0004\u0018\u00010\u00172\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 H\u0014J\u0014\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017H\u0002R\u0014\u0010\b\u001a\u00020\t8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0012\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lkotlinx/coroutines/channels/ConflatedChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractChannel;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "bufferDebugString", "", "getBufferDebugString", "()Ljava/lang/String;", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "isEmpty", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "value", "", "enqueueReceiveInternal", "receive", "Lkotlinx/coroutines/channels/Receive;", "offerInternal", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "onCancelIdempotent", "wasClosed", "pollInternal", "pollSelectInternal", "updateValueLocked", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ConflatedChannel<E> extends AbstractChannel<E> {
    private final ReentrantLock lock;
    private Object value;

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean isBufferAlwaysEmpty() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean isBufferAlwaysFull() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean isBufferFull() {
        return false;
    }

    public ConflatedChannel(Function1<? super E, Unit> r1) {
        super(r1);
        this.lock = new ReentrantLock();
        this.value = AbstractChannelKt.EMPTY;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean isBufferEmpty() {
        ReentrantLock r0 = this.lock;
        r0.lock();
        if (this.value != AbstractChannelKt.EMPTY) goto L6;
        boolean r2 = true;
    L7:
        r0.unlock();
        return r2;
    L6:
        r2 = false;
    L9:
        th = move-exception;
        r0.unlock();
        throw th;
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

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object offerInternal(E r4) {
        ReentrantLock r0 = this.lock;
        r0.lock();
        Closed<?> r1 = getClosedForSend();     // Catch: Throwable -> L37
        if (r1 == null) goto L8;
        r0.unlock();
        return r1;
    L8:
        if (this.value != AbstractChannelKt.EMPTY) goto L31;
    L9:
        ReceiveOrClosed<E> r2 = takeFirstReceiveOrPeekClosed();     // Catch: Throwable -> L37
        if (r2 == null) goto L31;
        if ((r2 instanceof Closed) == true) goto L14;
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L37
        Symbol r3 = r2.tryResumeReceive(r4, null);     // Catch: Throwable -> L37
        if (r3 == null) goto L9;
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L21;
    L28:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L37
        r0.unlock();
        r2.completeResumeReceive(r4);
        return r2.getOfferResult();
    L21:
        if (r3 != CancellableContinuationImplKt.RESUME_TOKEN) goto L23;
        boolean r6 = true;
    L24:
        if (r6 == true) goto L28;
        throw new AssertionError();     // Catch: Throwable -> L37
    L23:
        r6 = false;
        goto L24
    L14:
        r0.unlock();
        return r2;
    L31:
        UndeliveredElementException r7 = updateValueLocked(r4);     // Catch: Throwable -> L37
        if (r7 != null) goto L36;
        Symbol r8 = AbstractChannelKt.OFFER_SUCCESS;     // Catch: Throwable -> L37
        r0.unlock();
        return r8;
    L36:
        throw r7;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object offerSelectInternal(E r4, SelectInstance<?> r5) {
        ReentrantLock r0 = this.lock;
        r0.lock();
        Closed<?> r1 = getClosedForSend();     // Catch: Throwable -> L38
        if (r1 == null) goto L8;
        r0.unlock();
        return r1;
    L8:
        if (this.value != AbstractChannelKt.EMPTY) goto L28;
    L9:
        AbstractSendChannel.TryOfferDesc<E> r2 = describeTryOffer(r4);     // Catch: Throwable -> L38
        Object r3 = r5.performAtomicTrySelect(r2);     // Catch: Throwable -> L38
        if (r3 == null) goto L11;
        if (r3 == AbstractChannelKt.OFFER_FAILED) goto L28;
        if (r3 == AtomicKt.RETRY_ATOMIC) goto L9;
        if (r3 != SelectKt.getALREADY_SELECTED()) goto L21;
    L25:
        r0.unlock();
        return r3;
    L21:
        if ((r3 instanceof Closed) == true) goto L25;
        throw new IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + r3).toString());     // Catch: Throwable -> L38
    L11:
        ReceiveOrClosed<? super E> r6 = r2.getResult();     // Catch: Throwable -> L38
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L38
        r0.unlock();
        Intrinsics.checkNotNull(r6);
        ReceiveOrClosed<? super E> r8 = r6;
        r8.completeResumeReceive(r4);
        return r8.getOfferResult();
    L28:
        if (r5.trySelect() == true) goto L32;
        Object r9 = SelectKt.getALREADY_SELECTED();     // Catch: Throwable -> L38
        r0.unlock();
        return r9;
    L32:
        UndeliveredElementException r10 = updateValueLocked(r4);     // Catch: Throwable -> L38
        if (r10 != null) goto L37;
        Symbol r11 = AbstractChannelKt.OFFER_SUCCESS;     // Catch: Throwable -> L38
        r0.unlock();
        return r11;
    L37:
        throw r10;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected Object pollInternal() {
        ReentrantLock r0 = this.lock;
        r0.lock();
    L13:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if (this.value != AbstractChannelKt.EMPTY) goto L10;
        Object r3 = getClosedForSend();     // Catch: Throwable -> L13
        if (r3 != null) goto L8;
        r3 = AbstractChannelKt.POLL_FAILED;     // Catch: Throwable -> L13
    L8:
        r0.unlock();
        return r3;
    L10:
        Object r1 = this.value;     // Catch: Throwable -> L13
        this.value = AbstractChannelKt.EMPTY;     // Catch: Throwable -> L13
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L13
        r0.unlock();
        return r1;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected Object pollSelectInternal(SelectInstance<?> r4) {
        ReentrantLock r0 = this.lock;
        r0.lock();
    L18:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if (this.value != AbstractChannelKt.EMPTY) goto L11;
        Object r3 = getClosedForSend();     // Catch: Throwable -> L18
        if (r3 != null) goto L8;
        r3 = AbstractChannelKt.POLL_FAILED;     // Catch: Throwable -> L18
    L8:
        r0.unlock();
        return r3;
    L11:
        if (r4.trySelect() == true) goto L15;
        Object r5 = SelectKt.getALREADY_SELECTED();     // Catch: Throwable -> L18
        r0.unlock();
        return r5;
    L15:
        Object r6 = this.value;     // Catch: Throwable -> L18
        this.value = AbstractChannelKt.EMPTY;     // Catch: Throwable -> L18
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L18
        r0.unlock();
        return r6;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected void onCancelIdempotent(boolean r4) {
        ReentrantLock r0 = this.lock;
        r0.lock();
        UndeliveredElementException r1 = updateValueLocked(AbstractChannelKt.EMPTY);     // Catch: Throwable -> L8
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L8
        r0.unlock();
        super.onCancelIdempotent(r4);
        if (r1 != null) goto L7;
        return;
    L7:
        throw r1;
    L8:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    private final UndeliveredElementException updateValueLocked(Object r5) {
        Object r0 = this.value;
        UndeliveredElementException r2 = null;
        if (r0 == AbstractChannelKt.EMPTY) goto L8;
        Function1<E, Unit> r1 = this.onUndeliveredElement;
        if (r1 == null) goto L8;
        r2 = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(r1, r0, null, 2, null);
    L8:
        this.value = r5;
        return r2;
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

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected String getBufferDebugString() {
        ReentrantLock r1 = this.lock;
        r1.lock();
        String r3 = "(value=" + this.value + ')';     // Catch: Throwable -> L6
        r1.unlock();
        return r3;
    L6:
        th = move-exception;
        r1.unlock();
        throw th;
    }
}
