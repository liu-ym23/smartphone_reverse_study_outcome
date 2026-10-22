package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

/* JADX INFO: compiled from: LinkedListChannel.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012 \u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0011J!\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0014¢\u0006\u0002\u0010\u0015J/\u0010\u0016\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\b\u001a\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000b\u001a\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\n\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/channels/LinkedListChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractChannel;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "offerInternal", "", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "onCancelIdempotentList", "list", "Lkotlinx/coroutines/internal/InlineList;", "Lkotlinx/coroutines/channels/Send;", "closed", "Lkotlinx/coroutines/channels/Closed;", "onCancelIdempotentList-w-w6eGU", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class LinkedListChannel<E> extends AbstractChannel<E> {
    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean isBufferAlwaysEmpty() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean isBufferAlwaysFull() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean isBufferEmpty() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean isBufferFull() {
        return false;
    }

    public LinkedListChannel(Function1<? super E, Unit> r1) {
        super(r1);
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object offerInternal(E r3) {
    L2:
        Object r0 = super.offerInternal(r3);
        if (r0 == AbstractChannelKt.OFFER_SUCCESS) goto L5;
        if (r0 != AbstractChannelKt.OFFER_FAILED) goto L16;
        ReceiveOrClosed<?> r1 = sendBuffered(r3);
        if (r1 == null) goto L11;
        if ((r1 instanceof Closed) == false) goto L2;
        return r1;
    L11:
        return AbstractChannelKt.OFFER_SUCCESS;
    L16:
        if ((r0 instanceof Closed) == false) goto L19;
        return r0;
    L19:
        throw new IllegalStateException(("Invalid offerInternal result " + r0).toString());
    L5:
        return AbstractChannelKt.OFFER_SUCCESS;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object offerSelectInternal(E r3, SelectInstance<?> r4) {
    L3:
        if (getHasReceiveOrClosed() == false) goto L5;
        Object r0 = super.offerSelectInternal(r3, r4);
    L9:
        if (r0 == SelectKt.getALREADY_SELECTED()) goto L11;
        if (r0 == AbstractChannelKt.OFFER_SUCCESS) goto L15;
        if (r0 == AbstractChannelKt.OFFER_FAILED) goto L3;
        if (r0 == AtomicKt.RETRY_ATOMIC) goto L3;
        if ((r0 instanceof Closed) == false) goto L24;
        return r0;
    L24:
        throw new IllegalStateException(("Invalid result " + r0).toString());
    L15:
        return AbstractChannelKt.OFFER_SUCCESS;
    L11:
        return SelectKt.getALREADY_SELECTED();
    L5:
        r0 = r4.performAtomicTrySelect(describeSendBuffered(r3));
        if (r0 != null) goto L9;
        r0 = AbstractChannelKt.OFFER_SUCCESS;
        goto L9
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* JADX INFO: renamed from: onCancelIdempotentList-w-w6eGU */
    protected void mo2278onCancelIdempotentListww6eGU(Object r6, Closed<?> r7) {
        UndeliveredElementException r0 = null;
        if (r6 != null) goto L5;
    L27:
        if (r0 != null) goto L29;
        return;
    L29:
        throw r0;
    L5:
        if ((r6 instanceof ArrayList) == true) goto L12;
        Send r8 = (Send) r6;
        if ((r8 instanceof AbstractSendChannel.SendBuffered) == false) goto L11;
        Function1<E, Unit> r5 = this.onUndeliveredElement;
        if (r5 == null) goto L27;
        UndeliveredElementException r9 = (UndeliveredElementException) null;
        r0 = OnUndeliveredElementKt.callUndeliveredElementCatchingException(r5, ((AbstractSendChannel.SendBuffered) r8).element, null);
        goto L27
    L11:
        r8.resumeSendClosed(r7);
        goto L27
    L12:
        if (r6 == null) goto L26;
        ArrayList r10 = (ArrayList) r6;
        int r1 = r10.size() - 1;
        UndeliveredElementException r2 = null;
    L15:
        if ((-1) >= r1) goto L24;
        Send r3 = (Send) r10.get(r1);
        if ((r3 instanceof AbstractSendChannel.SendBuffered) == false) goto L22;
        Function1<E, Unit> r4 = this.onUndeliveredElement;
        if (r4 == null) goto L21;
        r2 = OnUndeliveredElementKt.callUndeliveredElementCatchingException(r4, ((AbstractSendChannel.SendBuffered) r3).element, r2);
    L23:
        r1 = r1 - 1;
        goto L15
    L21:
        r2 = null;
        goto L23
    L22:
        r3.resumeSendClosed(r7);
        goto L23
    L24:
        r0 = r2;
        goto L27
    L26:
        throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
    }
}
