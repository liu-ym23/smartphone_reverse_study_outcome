package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.framwork.core.sdklib.DBHelper;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedList_commonKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u000006:\u0004defgB)\u0012 \u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0013\u001a\u000e\u0012\u0002\b\u00030\u0011j\u0006\u0012\u0002\b\u0003`\u00122\u0006\u0010\u0010\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u0010\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001f\u001a\u00020\u00032\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J#\u0010!\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00028\u00002\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002¢\u0006\u0004\b!\u0010\"J\u001b\u0010!\u001a\u00020\b2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002¢\u0006\u0004\b!\u0010#J)\u0010&\u001a\u00020\u00032\u0018\u0010%\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`$H\u0016¢\u0006\u0004\b&\u0010\u0007J\u0019\u0010'\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00028\u0000H\u0014¢\u0006\u0004\b+\u0010,J#\u0010/\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00028\u00002\n\u0010.\u001a\u0006\u0012\u0002\b\u00030-H\u0014¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u000201H\u0014¢\u0006\u0004\b2\u00103JX\u00109\u001a\u00020\u0003\"\u0004\b\u0001\u001042\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00010-2\u0006\u0010\u0010\u001a\u00028\u00002(\u00108\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000107\u0012\u0006\u0012\u0004\u0018\u00010\u001a05H\u0002ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u001b\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010;J\u001d\u0010=\u001a\b\u0012\u0002\b\u0003\u0018\u00010<2\u0006\u0010\u0010\u001a\u00028\u0000H\u0004¢\u0006\u0004\b=\u0010>J\u001b\u0010?\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b?\u0010;J\u0017\u0010@\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010<H\u0014¢\u0006\u0004\b@\u0010AJ\u0011\u0010B\u001a\u0004\u0018\u00010\u0018H\u0004¢\u0006\u0004\bB\u0010CJ\u000f\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\bE\u0010FJ$\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00030G2\u0006\u0010\u0010\u001a\u00028\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bH\u0010,J+\u0010J\u001a\u00020\u0003*\u0006\u0012\u0002\b\u0003072\u0006\u0010\u0010\u001a\u00028\u00002\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002¢\u0006\u0004\bJ\u0010KR\u0014\u0010M\u001a\u00020D8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bL\u0010FR\u001a\u0010P\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u001a\u0010R\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010OR\u0014\u0010S\u001a\u00020\n8$X¤\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0014\u0010U\u001a\u00020\n8$X¤\u0004¢\u0006\u0006\u001a\u0004\bU\u0010TR\u0011\u0010V\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bV\u0010TR\u0014\u0010W\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bW\u0010TR#\u0010[\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000060X8F¢\u0006\u0006\u001a\u0004\bY\u0010ZR.\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00048\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\\R\u001a\u0010^\u001a\u00020]8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u0014\u0010c\u001a\u00020D8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bb\u0010F\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006h"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "", "countQueueSize", "()I", "element", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/AddLastDesc;", "describeSendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "describeTryOffer", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "Lkotlinx/coroutines/channels/Send;", CommonKey.KEY_SEND, "", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Closed;", "closed", "helpClose", "(Lkotlinx/coroutines/channels/Closed;)V", "helpCloseAndGetSendException", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "(Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "invokeOnCloseHandler", "(Ljava/lang/Throwable;)V", "offer", "(Ljava/lang/Object;)Z", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "onClosedIdempotent", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "R", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendSuspend", "takeFirstReceiveOrPeekClosed", "()Lkotlinx/coroutines/channels/ReceiveOrClosed;", "takeFirstSendOrPeekClosed", "()Lkotlinx/coroutines/channels/Send;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "trySend", "helpCloseAndResumeWithSendException", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "getBufferDebugString", "bufferDebugString", "getClosedForReceive", "()Lkotlinx/coroutines/channels/Closed;", "closedForReceive", "getClosedForSend", "closedForSend", "isBufferAlwaysFull", "()Z", "isBufferFull", "isClosedForSend", "isFullImpl", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", DBHelper.TABLE_QUEUE, "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueue", "()Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueueDebugStateString", "queueDebugStateString", "SendBuffered", "SendBufferedDesc", "SendSelect", "TryOfferDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbstractSendChannel<E> implements SendChannel<E> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater onCloseHandler$FU = null;
    private volatile /* synthetic */ Object onCloseHandler;
    protected final Function1<E, Unit> onUndeliveredElement;
    private final LockFreeLinkedListHead queue;

    /* JADX INFO: compiled from: AbstractChannel.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0014\u0010\f\u001a\u00020\u000b2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0012\u0010\u0003\u001a\u00028\u00018\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/Send;", "element", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "pollResult", "", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SendBuffered<E> extends Send {
        public final E element;

        @Override // kotlinx.coroutines.channels.Send
        public void completeResumeSend() {
        }

        public SendBuffered(E r1) {
            this.element = r1;
        }

        @Override // kotlinx.coroutines.channels.Send
        public Object getPollResult() {
            return this.element;
        }

        @Override // kotlinx.coroutines.channels.Send
        public Symbol tryResumeSend(LockFreeLinkedListNode.PrepareOp r1) {
            Symbol r0 = CancellableContinuationImplKt.RESUME_TOKEN;
            if (r1 == null) goto L5;
            r1.finishPrepare();
        L5:
            return r0;
        }

        @Override // kotlinx.coroutines.channels.Send
        public void resumeSendClosed(Closed<?> r1) {
            if (DebugKt.getASSERTIONS_ENABLED() == true) goto L6;
            return;
        L6:
            throw new AssertionError();
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "SendBuffered@" + DebugStringsKt.getHexAddress(this) + '(' + this.element + ')';
        }
    }

    /* JADX INFO: compiled from: AbstractChannel.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003`\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0001¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBufferedDesc;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", "Lkotlinx/coroutines/internal/AddLastDesc;", DBHelper.TABLE_QUEUE, "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "element", "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;Ljava/lang/Object;)V", "failure", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static class SendBufferedDesc<E> extends LockFreeLinkedListNode.AddLastDesc<SendBuffered<? extends E>> {
        public SendBufferedDesc(LockFreeLinkedListHead r2, E r3) {
            super(r2, new SendBuffered(r3));
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected Object failure(LockFreeLinkedListNode r1) {
            if ((r1 instanceof Closed) == false) goto L6;
            return r1;
        L6:
            if ((r1 instanceof ReceiveOrClosed) == true) goto L10;
            return null;
        L10:
            return AbstractChannelKt.OFFER_FAILED;
        }
    }

    /* JADX INFO: compiled from: AbstractChannel.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\u00020\u00032\u00020\u0004BV\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\t\u0012(\u0010\n\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000bø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0014\u0010\u0017\u001a\u00020\u00152\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0015H\u0016R7\u0010\n\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b8\u0006X\u0087\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendSelect;", ExifInterface.LONGITUDE_EAST, "R", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/DisposableHandle;", "pollResult", "channel", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/AbstractSendChannel;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "getPollResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "completeResumeSend", "", "dispose", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "undeliveredElement", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class SendSelect<E, R> extends Send implements DisposableHandle {
        public final Function2<SendChannel<? super E>, Continuation<? super R>, Object> block;
        public final AbstractSendChannel<E> channel;
        private final E pollResult;
        public final SelectInstance<R> select;

        @Override // kotlinx.coroutines.channels.Send
        public E getPollResult() {
            return this.pollResult;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SendSelect(E r1, AbstractSendChannel<E> r2, SelectInstance<? super R> r3, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> r4) {
            this.pollResult = r1;
            this.channel = r2;
            this.select = r3;
            this.block = r4;
        }

        @Override // kotlinx.coroutines.channels.Send
        public Symbol tryResumeSend(LockFreeLinkedListNode.PrepareOp r1) {
            return (Symbol) this.select.trySelectOther(r1);
        }

        @Override // kotlinx.coroutines.channels.Send
        public void completeResumeSend() {
            CancellableKt.startCoroutineCancellable$default(this.block, this.channel, this.select.getCompletion(), null, 4, null);
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            if (mo2325remove() == true) goto L5;
            return;
        L5:
            undeliveredElement();
        }

        @Override // kotlinx.coroutines.channels.Send
        public void resumeSendClosed(Closed<?> r2) {
            if (this.select.trySelect() == false) goto L6;
            this.select.resumeSelectWithException(r2.getSendException());
            return;
        }

        @Override // kotlinx.coroutines.channels.Send
        public void undeliveredElement() {
            Function1<E, Unit> r0 = this.channel.onUndeliveredElement;
            if (r0 == null) goto L6;
            OnUndeliveredElementKt.callUndeliveredElement(r0, getPollResult(), this.select.getCompletion().getContext());
            return;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "SendSelect@" + DebugStringsKt.getHexAddress(this) + '(' + getPollResult() + ")[" + this.channel + ", " + this.select + ']';
        }
    }

    /* JADX INFO: compiled from: AbstractChannel.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003`\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H\u0016R\u0012\u0010\u0005\u001a\u00028\u00018\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "element", DBHelper.TABLE_QUEUE, "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListHead;)V", "Ljava/lang/Object;", "failure", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "onPrepare", "prepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/PrepareOp;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    protected static final class TryOfferDesc<E> extends LockFreeLinkedListNode.RemoveFirstDesc<ReceiveOrClosed<? super E>> {
        public final E element;

        public TryOfferDesc(E r1, LockFreeLinkedListHead r2) {
            super(r2);
            this.element = r1;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc, kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected Object failure(LockFreeLinkedListNode r1) {
            if ((r1 instanceof Closed) == false) goto L6;
            return r1;
        L6:
            if ((r1 instanceof ReceiveOrClosed) == false) goto L10;
            return null;
        L10:
            return AbstractChannelKt.OFFER_FAILED;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object onPrepare(LockFreeLinkedListNode.PrepareOp r2) {
            Symbol r1 = ((ReceiveOrClosed) r2.affected).tryResumeReceive(this.element, r2);
            if (r1 != null) goto L7;
            return LockFreeLinkedList_commonKt.REMOVE_PREPARED;
        L7:
            if (r1 != AtomicKt.RETRY_ATOMIC) goto L11;
            return AtomicKt.RETRY_ATOMIC;
        L11:
            if (DebugKt.getASSERTIONS_ENABLED() == true) goto L13;
            return null;
        L13:
            if (r1 != CancellableContinuationImplKt.RESUME_TOKEN) goto L15;
            boolean r3 = true;
        L16:
            if (r3 == false) goto L19;
            return null;
        L19:
            throw new AssertionError();
        L15:
            r3 = false;
            goto L16
        }
    }

    static {
        onCloseHandler$FU = AtomicReferenceFieldUpdater.newUpdater(AbstractSendChannel.class, Object.class, "onCloseHandler");
    }

    protected String getBufferDebugString() {
        return "";
    }

    protected abstract boolean isBufferAlwaysFull();

    protected abstract boolean isBufferFull();

    protected void onClosedIdempotent(LockFreeLinkedListNode r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractSendChannel(Function1<? super E, Unit> r1) {
        this.onUndeliveredElement = r1;
        this.queue = new LockFreeLinkedListHead();
        this.onCloseHandler = null;
    }

    public static final /* synthetic */ void access$helpCloseAndResumeWithSendException(AbstractSendChannel r0, Continuation r1, Object r2, Closed r3) {
        r0.helpCloseAndResumeWithSendException(r1, r2, r3);
    }

    public static final /* synthetic */ boolean access$isFullImpl(AbstractSendChannel r0) {
        return r0.isFullImpl();
    }

    public static final /* synthetic */ void access$registerSelectSend(AbstractSendChannel r0, SelectInstance r1, Object r2, Function2 r3) {
        r0.registerSelectSend(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$sendSuspend(AbstractSendChannel r0, Object r1, Continuation r2) {
        return r0.sendSuspend(r1, r2);
    }

    protected final LockFreeLinkedListHead getQueue() {
        return this.queue;
    }

    protected Object offerInternal(E r3) {
    L2:
        ReceiveOrClosed<E> r0 = takeFirstReceiveOrPeekClosed();
        if (r0 == null) goto L5;
        Symbol r1 = r0.tryResumeReceive(r3, null);
        if (r1 == null) goto L2;
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L11;
    L18:
        r0.completeResumeReceive(r3);
        return r0.getOfferResult();
    L11:
        if (r1 != CancellableContinuationImplKt.RESUME_TOKEN) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L18;
        throw new AssertionError();
    L13:
        r2 = false;
        goto L14
    L5:
        return AbstractChannelKt.OFFER_FAILED;
    }

    protected Object offerSelectInternal(E r2, SelectInstance<?> r3) {
        TryOfferDesc<E> r1 = describeTryOffer(r2);
        Object r4 = r3.performAtomicTrySelect(r1);
        if (r4 == null) goto L5;
        return r4;
    L5:
        ReceiveOrClosed<? super E> r5 = r1.getResult();
        r5.completeResumeReceive(r2);
        return r5.getOfferResult();
    }

    protected final Closed<?> getClosedForSend() {
        LockFreeLinkedListNode r0 = this.queue.getPrevNode();
        if ((r0 instanceof Closed) == false) goto L5;
        Closed<?> r1 = (Closed) r0;
    L6:
        if (r1 == null) goto L9;
        helpClose(r1);
        return r1;
    L9:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    protected final Closed<?> getClosedForReceive() {
        LockFreeLinkedListNode r0 = this.queue.getNextNode();
        if ((r0 instanceof Closed) == false) goto L5;
        Closed<?> r1 = (Closed) r0;
    L6:
        if (r1 == null) goto L9;
        helpClose(r1);
        return r1;
    L9:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    protected final Send takeFirstSendOrPeekClosed() {
        LockFreeLinkedListHead r3 = this.queue;
    L3:
        LockFreeLinkedListNode r0 = (LockFreeLinkedListNode) r3.getNext();
        if (r0 == r3) goto L5;
        if ((r0 instanceof Send) == false) goto L5;
        if ((((Send) r0) instanceof Closed) == true) goto L12;
    L14:
        LockFreeLinkedListNode r1 = r0.removeOrNext();
        if (r1 == null) goto L17;
        r1.helpRemovePrev();
    L17:
        return (Send) r0;
    L12:
        if (r0.isRemoved() == true) goto L14;
    L5:
        r0 = null;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final ReceiveOrClosed<?> sendBuffered(E r3) {
        LockFreeLinkedListHead r2 = this.queue;
        SendBuffered r0 = new SendBuffered(r3);
    L3:
        LockFreeLinkedListNode r4 = r2.getPrevNode();
        if ((r4 instanceof ReceiveOrClosed) == true) goto L6;
        if (r4.addNext(r0, r2) == false) goto L3;
        return null;
    L6:
        return (ReceiveOrClosed) r4;
    }

    protected final LockFreeLinkedListNode.AddLastDesc<?> describeSendBuffered(E r2) {
        return new SendBufferedDesc(this.queue, r2);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean isClosedForSend() {
        if (getClosedForSend() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean isFullImpl() {
        if ((this.queue.getNextNode() instanceof ReceiveOrClosed) == false) goto L5;
    L7:
        return false;
    L5:
        if (isBufferFull() == false) goto L7;
        return true;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object send(E r3, Continuation<? super Unit> r4) {
        if (offerInternal(r3) == AbstractChannelKt.OFFER_SUCCESS) goto L5;
        Object r2 = sendSuspend(r3, r4);
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r2;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean offer(E r4) {
        return SendChannel.DefaultImpls.offer(this, r4);
    L4:
        th = move-exception;
        Function1<E, Unit> r3 = this.onUndeliveredElement;
        if (r3 == null) goto L11;
        UndeliveredElementException r5 = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(r3, r4, null, 2, null);
        if (r5 == null) goto L11;
        ExceptionsKt.addSuppressed(r5, th);
        throw r5;
    L11:
        throw th;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU, reason: not valid java name */
    public final Object mo2281trySendJP2dKIU(E r3) {
        Object r4 = offerInternal(r3);
        if (r4 != AbstractChannelKt.OFFER_SUCCESS) goto L6;
        return ChannelResult.Companion.m2301successJP2dKIU(Unit.INSTANCE);
    L6:
        if (r4 != AbstractChannelKt.OFFER_FAILED) goto L13;
        Closed<?> r5 = getClosedForSend();
        if (r5 != null) goto L19;
        return ChannelResult.Companion.m2300failurePtdJZtk();
    L19:
        return ChannelResult.Companion.m2299closedJP2dKIU(helpCloseAndGetSendException(r5));
    L13:
        if ((r4 instanceof Closed) == false) goto L17;
        return ChannelResult.Companion.m2299closedJP2dKIU(helpCloseAndGetSendException((Closed) r4));
    L17:
        throw new IllegalStateException(("trySend returned " + r4).toString());
    }

    private final Throwable helpCloseAndGetSendException(Closed<?> r1) {
        helpClose(r1);
        return r1.getSendException();
    }

    private final Throwable helpCloseAndGetSendException(E r3, Closed<?> r4) {
        helpClose(r4);
        Function1<E, Unit> r2 = this.onUndeliveredElement;
        if (r2 == null) goto L10;
        UndeliveredElementException r5 = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(r2, r3, null, 2, null);
        if (r5 == null) goto L10;
        ExceptionsKt.addSuppressed(r5, r4.getSendException());
        throw r5;
    L10:
        return r4.getSendException();
    }

    private final void helpCloseAndResumeWithSendException(Continuation<?> r3, E r4, Closed<?> r5) {
        helpClose(r5);
        Throwable r6 = r5.getSendException();
        Function1<E, Unit> r2 = this.onUndeliveredElement;
        if (r2 == null) goto L8;
        UndeliveredElementException r7 = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(r2, r4, null, 2, null);
        if (r7 == null) goto L8;
        UndeliveredElementException r8 = r7;
        ExceptionsKt.addSuppressed(r8, r6);
        Result.Companion r9 = Result.Companion;
        r3.resumeWith(Result.m774constructorimpl(ResultKt.createFailure(r8)));
        return;
    L8:
        Result.Companion r10 = Result.Companion;
        r3.resumeWith(Result.m774constructorimpl(ResultKt.createFailure(r6)));
    }

    protected Object enqueueSend(Send r4) {
        if (isBufferAlwaysFull() == false) goto L11;
        LockFreeLinkedListHead r0 = this.queue;
    L5:
        LockFreeLinkedListNode r3 = r0.getPrevNode();
        if ((r3 instanceof ReceiveOrClosed) == true) goto L7;
        if (r3.addNext(r4, r0) == false) goto L5;
        return null;
    L7:
        return r3;
    L11:
        LockFreeLinkedListHead r1 = this.queue;
        final Send r5 = r4;
        LockFreeLinkedListNode.CondAddOp r2 = new AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1(r5, this);
    L12:
        LockFreeLinkedListNode r6 = r1.getPrevNode();
        if ((r6 instanceof ReceiveOrClosed) == true) goto L14;
        int r7 = r6.tryCondAddNext(r5, r1, r2);
        boolean r8 = true;
        if (r7 == 1) goto L21;
        if (r7 != 2) goto L12;
        r8 = false;
    L21:
        if (r8 == false) goto L23;
        return null;
    L23:
        return AbstractChannelKt.ENQUEUE_FAILED;
    L14:
        return r6;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable r6) {
        Closed<?> r0 = new Closed(r6);
        LockFreeLinkedListHead r1 = this.queue;
    L3:
        LockFreeLinkedListNode r2 = r1.getPrevNode();
        boolean r4 = true;
        if ((!(r2 instanceof Closed)) == false) goto L5;
        if (r2.addNext(r0, r1) == false) goto L3;
    L8:
        if (r4 == true) goto L11;
        r0 = (Closed) this.queue.getPrevNode();
    L11:
        helpClose(r0);
        if (r4 == false) goto L14;
        invokeOnCloseHandler(r6);
    L14:
        return r4;
    L5:
        r4 = false;
        goto L8
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
        Closed<?> r1 = getClosedForSend();
        if (r1 != null) goto L13;
        return;
    L13:
        if (b0$$ExternalSyntheticBackport0.m(r0, this, r4, AbstractChannelKt.HANDLER_INVOKED) == false) goto L17;
        r4.invoke(r1.closeCause);
        return;
    }

    private final void helpClose(Closed<?> r6) {
        Object r2 = InlineList.m2317constructorimpl$default(null, 1, null);
    L3:
        LockFreeLinkedListNode r3 = r6.getPrevNode();
        if ((r3 instanceof Receive) == false) goto L6;
        Receive r4 = (Receive) r3;
    L7:
        if (r4 == null) goto L8;
        if (r4.mo2325remove() == false) goto L23;
        r2 = InlineList.m2322plusFjFbRPM(r2, r4);
        goto L3
    L23:
        r4.helpRemove();
        goto L3
    L8:
        if (r2 != null) goto L10;
    L19:
        onClosedIdempotent(r6);
        return;
    L10:
        if ((r2 instanceof ArrayList) == true) goto L12;
        ((Receive) r2).resumeReceiveClosed(r6);
        goto L19
    L12:
        if (r2 == null) goto L18;
        ArrayList r5 = (ArrayList) r2;
        int r0 = r5.size() - 1;
    L15:
        if ((-1) >= r0) goto L19;
        ((Receive) r5.get(r0)).resumeReceiveClosed(r6);
        r0 = r0 - 1;
        goto L15
    L18:
        throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
    L6:
        r4 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.internal.LockFreeLinkedListNode] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    protected ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed() {
        LockFreeLinkedListHead r3 = this.queue;
    L3:
        ?? r0 = (LockFreeLinkedListNode) r3.getNext();
        if (r0 == r3) goto L5;
        if ((r0 instanceof ReceiveOrClosed) == false) goto L5;
        if ((((ReceiveOrClosed) r0) instanceof Closed) == true) goto L12;
    L14:
        LockFreeLinkedListNode r1 = r0.removeOrNext();
        if (r1 == null) goto L17;
        r1.helpRemovePrev();
    L17:
        return (ReceiveOrClosed) r0;
    L12:
        if (r0.isRemoved() == true) goto L14;
    L5:
        r0 = 0;
        goto L17
    }

    protected final TryOfferDesc<E> describeTryOffer(E r2) {
        return new TryOfferDesc(r2, this.queue);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final SelectClause2<E, SendChannel<E>> getOnSend() {
        return new AbstractSendChannel$onSend$1(this);
    }

    private final <R> void registerSelectSend(SelectInstance<? super R> r3, E r4, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> r5) {
    L3:
        if (r3.isSelected() == true) goto L4;
        if (isFullImpl() == false) goto L22;
        SendSelect r0 = new SendSelect(r4, this, r3, r5);
        Object r1 = enqueueSend(r0);
        if (r1 == null) goto L9;
        if ((r1 instanceof Closed) == true) goto L21;
        if (r1 == AbstractChannelKt.ENQUEUE_FAILED) goto L22;
        if ((r1 instanceof Receive) == true) goto L22;
        throw new IllegalStateException(("enqueueSend returned " + r1 + ' ').toString());
    L21:
        throw StackTraceRecoveryKt.recoverStackTrace(helpCloseAndGetSendException(r4, (Closed) r1));
    L9:
        r3.disposeOnSelect(r0);
        return;
    L22:
        Object r2 = offerSelectInternal(r4, r3);
        if (r2 == SelectKt.getALREADY_SELECTED()) goto L24;
        if (r2 == AbstractChannelKt.OFFER_FAILED) goto L3;
        if (r2 == AtomicKt.RETRY_ATOMIC) goto L3;
        if (r2 != AbstractChannelKt.OFFER_SUCCESS) goto L34;
        UndispatchedKt.startCoroutineUnintercepted(r5, this, r3.getCompletion());
        return;
    L34:
        if ((r2 instanceof Closed) == false) goto L38;
        throw StackTraceRecoveryKt.recoverStackTrace(helpCloseAndGetSendException(r4, (Closed) r2));
    L38:
        throw new IllegalStateException(("offerSelectInternal returned " + r2).toString());
    L24:
        return;
    }

    public String toString() {
        return DebugStringsKt.getClassSimpleName(this) + '@' + DebugStringsKt.getHexAddress(this) + '{' + getQueueDebugStateString() + '}' + getBufferDebugString();
    }

    private final String getQueueDebugStateString() {
        LockFreeLinkedListNode r0 = this.queue.getNextNode();
        if (r0 != this.queue) goto L7;
        return "EmptyQueue";
    L7:
        if ((r0 instanceof Closed) == false) goto L10;
        String r1 = r0.toString();
    L16:
        LockFreeLinkedListNode r2 = this.queue.getPrevNode();
        if (r2 == r0) goto L22;
        String r3 = r1 + ",queueSize=" + countQueueSize();
        if ((r2 instanceof Closed) == true) goto L21;
        return r3;
    L21:
        return r3 + ",closedForSend=" + r2;
    L22:
        return r1;
    L10:
        if ((r0 instanceof Receive) == false) goto L13;
        r1 = "ReceiveQueued";
        goto L16
    L13:
        if ((r0 instanceof Send) == false) goto L15;
        r1 = "SendQueued";
        goto L16
    L15:
        r1 = "UNEXPECTED:" + r0;
        goto L16
    }

    private final int countQueueSize() {
        LockFreeLinkedListHead r3 = this.queue;
        LockFreeLinkedListNode r0 = (LockFreeLinkedListNode) r3.getNext();
        int r1 = 0;
    L4:
        if (Intrinsics.areEqual(r0, r3) == true) goto L9;
        if ((r0 instanceof LockFreeLinkedListNode) == false) goto L8;
        r1 = r1 + 1;
    L8:
        r0 = r0.getNextNode();
        goto L4
    L9:
        return r1;
    }

    private final Object sendSuspend(E r5, Continuation<? super Unit> r6) {
        CancellableContinuationImpl r0 = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(r6));
        CancellableContinuationImpl r1 = r0;
    L4:
        if (access$isFullImpl(this) == true) goto L6;
    L22:
        Object r2 = offerInternal(r5);
        if (r2 == AbstractChannelKt.OFFER_SUCCESS) goto L24;
        if (r2 == AbstractChannelKt.OFFER_FAILED) goto L4;
        if ((r2 instanceof Closed) == false) goto L39;
        access$helpCloseAndResumeWithSendException(this, r1, r5, (Closed) r2);
    L30:
        Object r4 = r0.getResult();
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L34;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L34:
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L37;
        return r4;
    L37:
        return Unit.INSTANCE;
    L39:
        throw new IllegalStateException(("offerInternal returned " + r2).toString());
    L24:
        Result.Companion r7 = Result.Companion;
        r1.resumeWith(Result.m774constructorimpl(Unit.INSTANCE));
        goto L30
    L6:
        if (this.onUndeliveredElement != null) goto L8;
        SendElementWithUndeliveredHandler r3 = new SendElement(r5, r1);
    L9:
        Object r8 = enqueueSend(r3);
        if (r8 == null) goto L11;
        if ((r8 instanceof Closed) == true) goto L14;
        if (r8 == AbstractChannelKt.ENQUEUE_FAILED) goto L22;
        if ((r8 instanceof Receive) == true) goto L22;
        throw new IllegalStateException(("enqueueSend returned " + r8).toString());
    L14:
        access$helpCloseAndResumeWithSendException(this, r1, r5, (Closed) r8);
        goto L30
    L11:
        CancellableContinuationKt.removeOnCancellation(r1, r3);
        goto L30
    L8:
        r3 = new SendElementWithUndeliveredHandler(r5, r1, this.onUndeliveredElement);
        goto L9
    }
}
