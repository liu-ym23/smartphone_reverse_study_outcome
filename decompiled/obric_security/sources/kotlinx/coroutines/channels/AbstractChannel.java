package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.framwork.core.sdklib.DBHelper;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
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
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedList_commonKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0007STUVWXYB'\u0012 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0016\u0010\u0019\u001a\u00020\u00062\u000e\u0010\u001a\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001dJ\u0017\u0010\u001e\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0000¢\u0006\u0002\b\u001fJ\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0004J\u0016\u0010\"\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0002J\u0016\u0010%\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0014JR\u0010&\u001a\u00020\n\"\u0004\b\u0001\u0010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2$\u0010*\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+2\u0006\u0010.\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0002\u00100J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00028\u000002H\u0086\u0002J\u0010\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\nH\u0014J/\u00105\u001a\u00020\u00062\f\u00106\u001a\b\u0012\u0004\u0012\u000208072\n\u00109\u001a\u0006\u0012\u0002\b\u00030:H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b;\u0010<J\b\u0010=\u001a\u00020\u0006H\u0014J\b\u0010>\u001a\u00020\u0006H\u0014J\n\u0010?\u001a\u0004\u0018\u00010,H\u0014J\u0016\u0010@\u001a\u0004\u0018\u00010,2\n\u0010(\u001a\u0006\u0012\u0002\b\u00030)H\u0014J\u0011\u0010#\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010AJ\"\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\bC\u0010AJ\u001f\u0010D\u001a\u0002H'\"\u0004\b\u0001\u0010'2\u0006\u0010.\u001a\u00020/H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010EJR\u0010F\u001a\u00020\u0006\"\u0004\b\u0001\u0010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\u0006\u0010.\u001a\u00020/2$\u0010*\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+H\u0002ø\u0001\u0000¢\u0006\u0002\u0010GJ \u0010H\u001a\u00020\u00062\n\u0010I\u001a\u0006\u0012\u0002\b\u00030J2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$H\u0002J\u0010\u0010K\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010LH\u0014J\u001c\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\bN\u0010OJX\u0010P\u001a\u00020\u0006\"\u0004\b\u0001\u0010'* \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\u0006\u0010.\u001a\u00020/2\b\u0010Q\u001a\u0004\u0018\u00010,H\u0002ø\u0001\u0000¢\u0006\u0002\u0010RR\u0014\u0010\t\u001a\u00020\n8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\nX¤\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0012\u0010\u000e\u001a\u00020\nX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170\u00138Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Z"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/Channel;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "hasReceiveOrClosed", "", "getHasReceiveOrClosed", "()Z", "isBufferAlwaysEmpty", "isBufferEmpty", "isClosedForReceive", "isEmpty", "isEmptyImpl", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching", "cancel", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", "cancelInternal$kotlinx_coroutines_core", "describeTryPoll", "Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "enqueueReceive", "receive", "Lkotlinx/coroutines/channels/Receive;", "enqueueReceiveInternal", "enqueueReceiveSelect", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "receiveMode", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)Z", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "onCancelIdempotent", "wasClosed", "onCancelIdempotentList", "list", "Lkotlinx/coroutines/internal/InlineList;", "Lkotlinx/coroutines/channels/Send;", "closed", "Lkotlinx/coroutines/channels/Closed;", "onCancelIdempotentList-w-w6eGU", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "onReceiveDequeued", "onReceiveEnqueued", "pollInternal", "pollSelectInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveSuspend", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerSelectReceiveMode", "(Lkotlinx/coroutines/selects/SelectInstance;ILkotlin/jvm/functions/Function2;)V", "removeReceiveOnCancel", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "takeFirstReceiveOrPeekClosed", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "tryStartBlockUnintercepted", "value", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/selects/SelectInstance;ILjava/lang/Object;)V", "Itr", "ReceiveElement", "ReceiveElementWithUndeliveredHandler", "ReceiveHasNext", "ReceiveSelect", "RemoveReceiveOnCancel", "TryPollDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbstractChannel<E> extends AbstractSendChannel<E> implements Channel<E> {

    /* JADX INFO: compiled from: AbstractChannel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0011\u0010\f\u001a\u00020\rH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0011\u0010\u0010\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0011\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\tR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$Itr;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ChannelIterator;", "channel", "Lkotlinx/coroutines/channels/AbstractChannel;", "(Lkotlinx/coroutines/channels/AbstractChannel;)V", "result", "", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "hasNext", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextResult", "hasNextSuspend", "next", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class Itr<E> implements ChannelIterator<E> {
        public final AbstractChannel<E> channel;
        private Object result;

        public Itr(AbstractChannel<E> r1) {
            this.channel = r1;
            this.result = AbstractChannelKt.POLL_FAILED;
        }

        public static final /* synthetic */ Object access$hasNextSuspend(Itr r0, Continuation r1) {
            return r0.hasNextSuspend(r1);
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        public /* synthetic */ Object next(Continuation r1) {
            return ChannelIterator.DefaultImpls.next(this, r1);
        }

        public final Object getResult() {
            return this.result;
        }

        public final void setResult(Object r1) {
            this.result = r1;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public Object hasNext(Continuation<? super Boolean> r3) {
            if (this.result != AbstractChannelKt.POLL_FAILED) goto L5;
            Object r0 = this.channel.pollInternal();
            this.result = r0;
            if (r0 == AbstractChannelKt.POLL_FAILED) goto L11;
            return Boxing.boxBoolean(hasNextResult(this.result));
        L11:
            return hasNextSuspend(r3);
        L5:
            return Boxing.boxBoolean(hasNextResult(this.result));
        }

        private final boolean hasNextResult(Object r1) {
            if ((r1 instanceof Closed) == false) goto L10;
            Closed r2 = (Closed) r1;
            if (r2.closeCause != null) goto L9;
            return false;
        L9:
            throw StackTraceRecoveryKt.recoverStackTrace(r2.getReceiveException());
        L10:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() {
            E r0 = (E) this.result;
            if ((r0 instanceof Closed) == true) goto L11;
            if (r0 == AbstractChannelKt.POLL_FAILED) goto L9;
            this.result = AbstractChannelKt.POLL_FAILED;
            return r0;
        L9:
            throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
        L11:
            throw StackTraceRecoveryKt.recoverStackTrace(((Closed) r0).getReceiveException());
        }

        private final Object hasNextSuspend(Continuation<? super Boolean> r6) {
            CancellableContinuationImpl r0 = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(r6));
            CancellableContinuationImpl r1 = r0;
            ReceiveHasNext r2 = new ReceiveHasNext(this, r1);
        L3:
            ReceiveHasNext r4 = r2;
            if (AbstractChannel.access$enqueueReceive(this.channel, r4) == true) goto L5;
            Object r3 = this.channel.pollInternal();
            setResult(r3);
            if ((r3 instanceof Closed) == true) goto L8;
            if (r3 == AbstractChannelKt.POLL_FAILED) goto L3;
            Boolean r5 = Boxing.boxBoolean(true);
            Function1<E, Unit> r7 = this.channel.onUndeliveredElement;
            if (r7 == null) goto L17;
            Function1<Throwable, Unit> r8 = OnUndeliveredElementKt.bindCancellationFun(r7, r3, r1.getContext());
        L18:
            r1.resume(r5, r8);
        L19:
            Object r9 = r0.getResult();
            if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
            DebugProbesKt.probeCoroutineSuspended(r6);
        L22:
            return r9;
        L17:
            r8 = null;
            goto L18
        L8:
            Closed r10 = (Closed) r3;
            if (r10.closeCause != null) goto L11;
            Result.Companion r11 = Result.Companion;
            r1.resumeWith(Result.m774constructorimpl(Boxing.boxBoolean(false)));
            goto L19
        L11:
            Result.Companion r12 = Result.Companion;
            r1.resumeWith(Result.m774constructorimpl(ResultKt.createFailure(r10.getReceiveException())));
            goto L19
        L5:
            AbstractChannel.access$removeReceiveOnCancel(this.channel, r1, r4);
            goto L19
        }
    }

    /* JADX INFO: compiled from: AbstractChannel.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\u00020\n2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00028\u0001¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J!\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000b\u001a\u00028\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0018R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/Receive;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "receiveMode", "", "(Lkotlinx/coroutines/CancellableContinuation;I)V", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "resumeValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static class ReceiveElement<E> extends Receive<E> {
        public final CancellableContinuation<Object> cont;
        public final int receiveMode;

        public ReceiveElement(CancellableContinuation<Object> r1, int r2) {
            this.cont = r1;
            this.receiveMode = r2;
        }

        public final Object resumeValue(E r2) {
            if (this.receiveMode == 1) goto L5;
            return r2;
        L5:
            return ChannelResult.m2286boximpl(ChannelResult.Companion.m2301successJP2dKIU(r2));
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public Symbol tryResumeReceive(E r5, LockFreeLinkedListNode.PrepareOp r6) {
            CancellableContinuation<Object> r0 = this.cont;
            Object r1 = resumeValue(r5);
            if (r6 == null) goto L5;
            LockFreeLinkedListNode.AbstractAtomicDesc r3 = r6.desc;
        L6:
            Object r4 = r0.tryResume(r1, r3, resumeOnCancellationFun(r5));
            if (r4 != null) goto L10;
            return null;
        L10:
            if (DebugKt.getASSERTIONS_ENABLED() == true) goto L12;
        L19:
            if (r6 == null) goto L22;
            r6.finishPrepare();
        L22:
            return CancellableContinuationImplKt.RESUME_TOKEN;
        L12:
            if (r4 != CancellableContinuationImplKt.RESUME_TOKEN) goto L14;
            boolean r7 = true;
        L15:
            if (r7 == true) goto L19;
            throw new AssertionError();
        L14:
            r7 = false;
            goto L15
        L5:
            r3 = null;
            goto L6
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(E r1) {
            this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void resumeReceiveClosed(Closed<?> r3) {
            if (this.receiveMode != 1) goto L5;
            CancellableContinuation<Object> r2 = this.cont;
            ChannelResult r4 = ChannelResult.m2286boximpl(ChannelResult.Companion.m2299closedJP2dKIU(r3.closeCause));
            Result.Companion r0 = Result.Companion;
            r2.resumeWith(Result.m774constructorimpl(r4));
            return;
        L5:
            CancellableContinuation<Object> r5 = this.cont;
            Result.Companion r1 = Result.Companion;
            r5.resumeWith(Result.m774constructorimpl(ResultKt.createFailure(r3.getReceiveException())));
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "ReceiveElement@" + DebugStringsKt.getHexAddress(this) + "[receiveMode=" + this.receiveMode + ']';
        }
    }

    /* JADX INFO: compiled from: AbstractChannel.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B;\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00028\u0001`\u000b¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010R&\u0010\b\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00028\u0001`\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElementWithUndeliveredHandler;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "receiveMode", "", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlinx/coroutines/CancellableContinuation;ILkotlin/jvm/functions/Function1;)V", "resumeOnCancellationFun", "", "value", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class ReceiveElementWithUndeliveredHandler<E> extends ReceiveElement<E> {
        public final Function1<E, Unit> onUndeliveredElement;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveElementWithUndeliveredHandler(CancellableContinuation<Object> r1, int r2, Function1<? super E, Unit> r3) {
            super(r1, r2);
            this.onUndeliveredElement = r3;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public Function1<Throwable, Unit> resumeOnCancellationFun(E r2) {
            return OnUndeliveredElementKt.bindCancellationFun(this.onUndeliveredElement, r2, this.cont.getContext());
        }
    }

    /* JADX INFO: compiled from: AbstractChannel.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\n2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J!\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000b\u001a\u00028\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aR\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveHasNext;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/Receive;", "iterator", "Lkotlinx/coroutines/channels/AbstractChannel$Itr;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/channels/AbstractChannel$Itr;Lkotlinx/coroutines/CancellableContinuation;)V", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "resumeOnCancellationFun", "Lkotlin/Function1;", "", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static class ReceiveHasNext<E> extends Receive<E> {
        public final CancellableContinuation<Boolean> cont;
        public final Itr<E> iterator;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveHasNext(Itr<E> r1, CancellableContinuation<? super Boolean> r2) {
            this.iterator = r1;
            this.cont = r2;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public Symbol tryResumeReceive(E r6, LockFreeLinkedListNode.PrepareOp r7) {
            CancellableContinuation<Boolean> r0 = this.cont;
            boolean r1 = true;
            if (r7 == null) goto L5;
            LockFreeLinkedListNode.AbstractAtomicDesc r4 = r7.desc;
        L6:
            Object r5 = r0.tryResume(true, r4, resumeOnCancellationFun(r6));
            if (r5 != null) goto L10;
            return null;
        L10:
            if (DebugKt.getASSERTIONS_ENABLED() == true) goto L12;
        L19:
            if (r7 == null) goto L22;
            r7.finishPrepare();
        L22:
            return CancellableContinuationImplKt.RESUME_TOKEN;
        L12:
            if (r5 == CancellableContinuationImplKt.RESUME_TOKEN) goto L15;
            r1 = false;
        L15:
            if (r1 == true) goto L19;
            throw new AssertionError();
        L5:
            r4 = null;
            goto L6
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(E r2) {
            this.iterator.setResult(r2);
            this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void resumeReceiveClosed(Closed<?> r5) {
            if (r5.closeCause != null) goto L5;
            Object r0 = CancellableContinuation.DefaultImpls.tryResume$default(this.cont, false, null, 2, null);
        L6:
            if (r0 == null) goto L9;
            this.iterator.setResult(r5);
            this.cont.completeResume(r0);
            return;
        L9:
            return;
        L5:
            r0 = this.cont.tryResumeWithException(r5.getReceiveException());
            goto L6
        }

        @Override // kotlinx.coroutines.channels.Receive
        public Function1<Throwable, Unit> resumeOnCancellationFun(E r2) {
            Function1<E, Unit> r0 = this.iterator.channel.onUndeliveredElement;
            if (r0 != null) goto L7;
            return null;
        L7:
            return OnUndeliveredElementKt.bindCancellationFun(r0, r2, this.cont.getContext());
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "ReceiveHasNext@" + DebugStringsKt.getHexAddress(this);
        }
    }

    /* JADX INFO: compiled from: AbstractChannel.kt */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u00032\u00020\u0004BR\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b\u0012$\u0010\t\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\u0012\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0016J#\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00172\u0006\u0010\u0013\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u00122\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J!\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0013\u001a\u00028\u00022\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0002\u0010#R3\u0010\t\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8\u0006X\u0087\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveSelect;", "R", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/Receive;", "Lkotlinx/coroutines/DisposableHandle;", "channel", "Lkotlinx/coroutines/channels/AbstractChannel;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "receiveMode", "", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)V", "Lkotlin/jvm/functions/Function2;", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "dispose", "resumeOnCancellationFun", "Lkotlin/Function1;", "", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class ReceiveSelect<R, E> extends Receive<E> implements DisposableHandle {
        public final Function2<Object, Continuation<? super R>, Object> block;
        public final AbstractChannel<E> channel;
        public final int receiveMode;
        public final SelectInstance<R> select;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveSelect(AbstractChannel<E> r1, SelectInstance<? super R> r2, Function2<Object, ? super Continuation<? super R>, ? extends Object> r3, int r4) {
            this.channel = r1;
            this.select = r2;
            this.block = r3;
            this.receiveMode = r4;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public Symbol tryResumeReceive(E r1, LockFreeLinkedListNode.PrepareOp r2) {
            return (Symbol) this.select.trySelectOther(r2);
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(E r4) {
            Function2<Object, Continuation<? super R>, Object> r0 = this.block;
            if (this.receiveMode != 1) goto L5;
            Object r1 = ChannelResult.m2286boximpl(ChannelResult.Companion.m2301successJP2dKIU(r4));
        L6:
            CancellableKt.startCoroutineCancellable(r0, r1, this.select.getCompletion(), resumeOnCancellationFun(r4));
            return;
        L5:
            r1 = r4;
            goto L6
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void resumeReceiveClosed(Closed<?> r9) {
            if (this.select.trySelect() == true) goto L5;
            return;
        L5:
            int r0 = this.receiveMode;
            if (r0 != 0) goto L8;
            this.select.resumeSelectWithException(r9.getReceiveException());
            return;
        L8:
            if (r0 != 1) goto L14;
            CancellableKt.startCoroutineCancellable$default(this.block, ChannelResult.m2286boximpl(ChannelResult.Companion.m2299closedJP2dKIU(r9.closeCause)), this.select.getCompletion(), null, 4, null);
            return;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            if (mo2325remove() == false) goto L6;
            this.channel.onReceiveDequeued();
            return;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public Function1<Throwable, Unit> resumeOnCancellationFun(E r2) {
            Function1<E, Unit> r0 = this.channel.onUndeliveredElement;
            if (r0 != null) goto L7;
            return null;
        L7:
            return OnUndeliveredElementKt.bindCancellationFun(r0, r2, this.select.getCompletion().getContext());
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "ReceiveSelect@" + DebugStringsKt.getHexAddress(this) + '[' + this.select + ",receiveMode=" + this.receiveMode + ']';
        }
    }

    /* JADX INFO: compiled from: AbstractChannel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$RemoveReceiveOnCancel;", "Lkotlinx/coroutines/BeforeResumeCancelHandler;", "receive", "Lkotlinx/coroutines/channels/Receive;", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/channels/Receive;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class RemoveReceiveOnCancel extends BeforeResumeCancelHandler {
        private final Receive<?> receive;
        final /* synthetic */ AbstractChannel<E> this$0;

        public RemoveReceiveOnCancel(AbstractChannel r1, Receive<?> r2) {
            this.this$0 = r1;
            this.receive = r2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable r1) {
            invoke2(r1);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CancelHandlerBase
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(Throwable r1) {
            if (this.receive.mo2325remove() == false) goto L6;
            this.this$0.onReceiveDequeued();
            return;
        }

        public String toString() {
            return "RemoveReceiveOnCancel[" + this.receive + ']';
        }
    }

    /* JADX INFO: compiled from: AbstractChannel.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0016\u0010\f\u001a\u0004\u0018\u00010\t2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", DBHelper.TABLE_QUEUE, "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;)V", "failure", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "onPrepare", "prepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/PrepareOp;", "onRemoved", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    protected static final class TryPollDesc<E> extends LockFreeLinkedListNode.RemoveFirstDesc<Send> {
        public TryPollDesc(LockFreeLinkedListHead r1) {
            super(r1);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc, kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected Object failure(LockFreeLinkedListNode r1) {
            if ((r1 instanceof Closed) == false) goto L6;
            return r1;
        L6:
            if ((r1 instanceof Send) == false) goto L10;
            return null;
        L10:
            return AbstractChannelKt.POLL_FAILED;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object onPrepare(LockFreeLinkedListNode.PrepareOp r1) {
            Symbol r0 = ((Send) r1.affected).tryResumeSend(r1);
            if (r0 != null) goto L7;
            return LockFreeLinkedList_commonKt.REMOVE_PREPARED;
        L7:
            if (r0 != AtomicKt.RETRY_ATOMIC) goto L11;
            return AtomicKt.RETRY_ATOMIC;
        L11:
            if (DebugKt.getASSERTIONS_ENABLED() == true) goto L13;
            return null;
        L13:
            if (r0 != CancellableContinuationImplKt.RESUME_TOKEN) goto L15;
            boolean r2 = true;
        L16:
            if (r2 == false) goto L19;
            return null;
        L19:
            throw new AssertionError();
        L15:
            r2 = false;
            goto L16
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void onRemoved(LockFreeLinkedListNode r1) {
            ((Send) r1).undeliveredElement();
        }
    }

    protected abstract boolean isBufferAlwaysEmpty();

    protected abstract boolean isBufferEmpty();

    protected void onReceiveDequeued() {
    }

    protected void onReceiveEnqueued() {
    }

    public static final /* synthetic */ boolean access$enqueueReceive(AbstractChannel r0, Receive r1) {
        return r0.enqueueReceive(r1);
    }

    public static final /* synthetic */ Object access$receiveSuspend(AbstractChannel r0, int r1, Continuation r2) {
        return r0.receiveSuspend(r1, r2);
    }

    public static final /* synthetic */ void access$registerSelectReceiveMode(AbstractChannel r0, SelectInstance r1, int r2, Function2 r3) {
        r0.registerSelectReceiveMode(r1, r2, r3);
    }

    public static final /* synthetic */ void access$removeReceiveOnCancel(AbstractChannel r0, CancellableContinuation r1, Receive r2) {
        r0.removeReceiveOnCancel(r1, r2);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        Channel.DefaultImpls.cancel(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<E> getOnReceiveOrNull() {
        return Channel.DefaultImpls.getOnReceiveOrNull(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    public E poll() {
        return (E) Channel.DefaultImpls.poll(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    public Object receiveOrNull(Continuation<? super E> r1) {
        return Channel.DefaultImpls.receiveOrNull(this, r1);
    }

    public AbstractChannel(Function1<? super E, Unit> r1) {
        super(r1);
    }

    protected Object pollInternal() {
    L2:
        Send r0 = takeFirstSendOrPeekClosed();
        if (r0 == null) goto L5;
        Symbol r1 = r0.tryResumeSend(null);
        if (r1 != null) goto L9;
        r0.undeliveredElement();
        goto L2
    L9:
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L11;
    L18:
        r0.completeResumeSend();
        return r0.getPollResult();
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
        return AbstractChannelKt.POLL_FAILED;
    }

    protected Object pollSelectInternal(SelectInstance<?> r2) {
        TryPollDesc<E> r1 = describeTryPoll();
        Object r3 = r2.performAtomicTrySelect(r1);
        if (r3 == null) goto L5;
        return r3;
    L5:
        r1.getResult().completeResumeSend();
        return r1.getResult().getPollResult();
    }

    protected final boolean getHasReceiveOrClosed() {
        return getQueue().getNextNode() instanceof ReceiveOrClosed;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        if (getClosedForReceive() != null) goto L5;
    L7:
        return false;
    L5:
        if (isBufferEmpty() == false) goto L7;
        return true;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        return isEmptyImpl();
    }

    protected final boolean isEmptyImpl() {
        if ((getQueue().getNextNode() instanceof Send) == false) goto L5;
    L7:
        return false;
    L5:
        if (isBufferEmpty() == false) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object receive(Continuation<? super E> r3) {
        Object r0 = pollInternal();
        if (r0 == AbstractChannelKt.POLL_FAILED) goto L8;
        if ((r0 instanceof Closed) == true) goto L8;
        return r0;
    L8:
        return receiveSuspend(0, r3);
    }

    protected boolean enqueueReceiveInternal(Receive<? super E> r6) {
        if (isBufferAlwaysEmpty() == false) goto L11;
        LockFreeLinkedListHead r0 = getQueue();
    L5:
        LockFreeLinkedListNode r5 = r0.getPrevNode();
        if ((!(r5 instanceof Send)) == false) goto L29;
        if (r5.addNext(r6, r0) == false) goto L5;
    L21:
        return true;
    L29:
        return false;
    L11:
        LockFreeLinkedListHead r1 = getQueue();
        final Receive<? super E> r7 = r6;
        LockFreeLinkedListNode.CondAddOp r3 = new AbstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1(r7, this);
    L12:
        LockFreeLinkedListNode r8 = r1.getPrevNode();
        if ((!(r8 instanceof Send)) == false) goto L31;
        int r9 = r8.tryCondAddNext(r7, r1, r3);
        if (r9 == 1) goto L21;
        if (r9 != 2) goto L12;
        return false;
    L31:
        return false;
    }

    private final boolean enqueueReceive(Receive<? super E> r1) {
        boolean r2 = enqueueReceiveInternal(r1);
        if (r2 == false) goto L5;
        onReceiveEnqueued();
    L5:
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU, reason: not valid java name */
    public final Object mo2279receiveCatchingJP2dKIU(Continuation<? super ChannelResult<? extends E>> r5) {
        if ((r5 instanceof AbstractChannel$receiveCatching$1) == false) goto L7;
        AbstractChannel$receiveCatching$1 r0 = (AbstractChannel$receiveCatching$1) r5;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L25:
        return ((ChannelResult) r6).m2298unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        Object r7 = pollInternal();
        if (r7 != AbstractChannelKt.POLL_FAILED) goto L17;
        r0.label = 1;
        r6 = receiveSuspend(1, r0);
        if (r6 != r1) goto L25;
        return r1;
    L17:
        if ((r7 instanceof Closed) == false) goto L20;
        return ChannelResult.Companion.m2299closedJP2dKIU(((Closed) r7).closeCause);
    L20:
        return ChannelResult.Companion.m2301successJP2dKIU(r7);
    L7:
        r0 = new AbstractChannel$receiveCatching$1(this, r5);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: tryReceive-PtdJZtk, reason: not valid java name */
    public final Object mo2280tryReceivePtdJZtk() {
        Object r1 = pollInternal();
        if (r1 != AbstractChannelKt.POLL_FAILED) goto L7;
        return ChannelResult.Companion.m2300failurePtdJZtk();
    L7:
        if ((r1 instanceof Closed) == false) goto L11;
        return ChannelResult.Companion.m2299closedJP2dKIU(((Closed) r1).closeCause);
    L11:
        return ChannelResult.Companion.m2301successJP2dKIU(r1);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean cancel(Throwable r1) {
        return cancelInternal$kotlinx_coroutines_core(r1);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(CancellationException r3) {
        if (isClosedForReceive() == false) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        r3 = new CancellationException(DebugStringsKt.getClassSimpleName(this) + " was cancelled");
    L7:
        cancelInternal$kotlinx_coroutines_core(r3);
    }

    public final boolean cancelInternal$kotlinx_coroutines_core(Throwable r1) {
        boolean r2 = close(r1);
        onCancelIdempotent(r2);
        return r2;
    }

    protected void onCancelIdempotent(boolean r4) {
        Closed<?> r5 = getClosedForSend();
        if (r5 == null) goto L21;
        Object r0 = InlineList.m2317constructorimpl$default(null, 1, null);
    L5:
        LockFreeLinkedListNode r1 = r5.getPrevNode();
        if ((r1 instanceof LockFreeLinkedListHead) == true) goto L7;
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L17;
        if ((r1 instanceof Send) == true) goto L17;
        throw new AssertionError();
    L17:
        if (r1.mo2325remove() == false) goto L18;
        r0 = InlineList.m2322plusFjFbRPM(r0, (Send) r1);
        goto L5
    L18:
        r1.helpRemove();
        goto L5
    L7:
        mo2278onCancelIdempotentListww6eGU(r0, r5);
        return;
    L21:
        throw new IllegalStateException("Cannot happen".toString());
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final ChannelIterator<E> iterator() {
        return new Itr(this);
    }

    protected final TryPollDesc<E> describeTryPoll() {
        return new TryPollDesc(getQueue());
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1<E> getOnReceive() {
        return new AbstractChannel$onReceive$1(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        return new AbstractChannel$onReceiveCatching$1(this);
    }

    private final <R> void registerSelectReceiveMode(SelectInstance<? super R> r3, int r4, Function2<Object, ? super Continuation<? super R>, ? extends Object> r5) {
    L3:
        if (r3.isSelected() == true) goto L4;
        if (isEmptyImpl() == true) goto L8;
        Object r0 = pollSelectInternal(r3);
        if (r0 == SelectKt.getALREADY_SELECTED()) goto L12;
        if (r0 == AbstractChannelKt.POLL_FAILED) goto L3;
        if (r0 == AtomicKt.RETRY_ATOMIC) goto L3;
        tryStartBlockUnintercepted(r5, r3, r4, r0);
        goto L3
    L12:
        return;
    L8:
        if (enqueueReceiveSelect(r3, r5, r4) == false) goto L3;
        return;
    }

    private final <R> void tryStartBlockUnintercepted(Function2<Object, ? super Continuation<? super R>, ? extends Object> r2, SelectInstance<? super R> r3, int r4, Object r5) {
        boolean r1 = r5 instanceof Closed;
        if (r1 == false) goto L13;
        if (r4 == 0) goto L12;
        if (r4 == 1) goto L8;
        return;
    L8:
        if (r3.trySelect() == true) goto L10;
        return;
    L10:
        UndispatchedKt.startCoroutineUnintercepted(r2, ChannelResult.m2286boximpl(ChannelResult.Companion.m2299closedJP2dKIU(((Closed) r5).closeCause)), r3.getCompletion());
        return;
    L12:
        throw StackTraceRecoveryKt.recoverStackTrace(((Closed) r5).getReceiveException());
    L13:
        if (r4 != 1) goto L18;
        if (r1 == false) goto L16;
        Object r6 = ChannelResult.Companion.m2299closedJP2dKIU(((Closed) r5).closeCause);
    L17:
        UndispatchedKt.startCoroutineUnintercepted(r2, ChannelResult.m2286boximpl(r6), r3.getCompletion());
        return;
    L16:
        r6 = ChannelResult.Companion.m2301successJP2dKIU(r5);
        goto L17
    L18:
        UndispatchedKt.startCoroutineUnintercepted(r2, r5, r3.getCompletion());
    }

    private final <R> boolean enqueueReceiveSelect(SelectInstance<? super R> r2, Function2<Object, ? super Continuation<? super R>, ? extends Object> r3, int r4) {
        ReceiveSelect r0 = new ReceiveSelect(this, r2, r3, r4);
        boolean r1 = enqueueReceive(r0);
        if (r1 == false) goto L5;
        r2.disposeOnSelect(r0);
    L5:
        return r1;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed() {
        ReceiveOrClosed<E> r0 = super.takeFirstReceiveOrPeekClosed();
        if (r0 != null) goto L5;
    L7:
        return r0;
    L5:
        if ((r0 instanceof Closed) == true) goto L7;
        onReceiveDequeued();
        goto L7
    }

    private final void removeReceiveOnCancel(CancellableContinuation<?> r2, Receive<?> r3) {
        r2.invokeOnCancellation(new RemoveReceiveOnCancel(this, r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <R> Object receiveSuspend(int r5, Continuation<? super R> r6) {
        CancellableContinuationImpl r0 = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(r6));
        CancellableContinuationImpl r1 = r0;
        if (this.onUndeliveredElement != null) goto L5;
        ReceiveElement r2 = new ReceiveElement(r1, r5);
    L6:
        Receive r7 = r2;
        if (access$enqueueReceive(this, r7) == true) goto L8;
        Object r8 = pollInternal();
        if ((r8 instanceof Closed) == true) goto L11;
        if (r8 == AbstractChannelKt.POLL_FAILED) goto L6;
        r1.resume(r2.resumeValue(r8), r2.resumeOnCancellationFun(r8));
    L15:
        Object r4 = r0.getResult();
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L18:
        return r4;
    L11:
        r2.resumeReceiveClosed((Closed) r8);
        goto L15
    L8:
        access$removeReceiveOnCancel(this, r1, r7);
        goto L15
    L5:
        r2 = new ReceiveElementWithUndeliveredHandler(r1, r5, this.onUndeliveredElement);
        goto L6
    }

    /* JADX INFO: renamed from: onCancelIdempotentList-w-w6eGU, reason: not valid java name */
    protected void mo2278onCancelIdempotentListww6eGU(Object r2, Closed<?> r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if ((r2 instanceof ArrayList) == true) goto L6;
        ((Send) r2).resumeSendClosed(r3);
        return;
    L6:
        if (r2 == null) goto L12;
        ArrayList r4 = (ArrayList) r2;
        int r1 = r4.size();
    L8:
        r1 = r1 - 1;
        if ((-1) >= r1) goto L16;
        ((Send) r4.get(r1)).resumeSendClosed(r3);
        goto L8
    L16:
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
    }
}
