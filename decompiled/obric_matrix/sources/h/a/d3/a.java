package h.a.d3;

import h.a.f3.e0;
import h.a.q0;
import h.a.r0;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.f0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0007STUVWXYB'\u0012 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0016\u0010\u0019\u001a\u00020\u00062\u000e\u0010\u001a\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001dJ\u0017\u0010\u001e\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0000¢\u0006\u0002\b\u001fJ\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0004J\u0016\u0010\"\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0002J\u0016\u0010%\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0014JR\u0010&\u001a\u00020\n\"\u0004\b\u0001\u0010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2$\u0010*\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+2\u0006\u0010.\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0002\u00100J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00028\u000002H\u0086\u0002J\u0010\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\nH\u0014J/\u00105\u001a\u00020\u00062\f\u00106\u001a\b\u0012\u0004\u0012\u000208072\n\u00109\u001a\u0006\u0012\u0002\b\u00030:H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b;\u0010<J\b\u0010=\u001a\u00020\u0006H\u0014J\b\u0010>\u001a\u00020\u0006H\u0014J\n\u0010?\u001a\u0004\u0018\u00010,H\u0014J\u0016\u0010@\u001a\u0004\u0018\u00010,2\n\u0010(\u001a\u0006\u0012\u0002\b\u00030)H\u0014J\u0011\u0010#\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010AJ\"\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\bC\u0010AJ\u001f\u0010D\u001a\u0002H'\"\u0004\b\u0001\u0010'2\u0006\u0010.\u001a\u00020/H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010EJR\u0010F\u001a\u00020\u0006\"\u0004\b\u0001\u0010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\u0006\u0010.\u001a\u00020/2$\u0010*\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+H\u0002ø\u0001\u0000¢\u0006\u0002\u0010GJ \u0010H\u001a\u00020\u00062\n\u0010I\u001a\u0006\u0012\u0002\b\u00030J2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$H\u0002J\u0010\u0010K\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010LH\u0014J\u001c\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\bN\u0010OJX\u0010P\u001a\u00020\u0006\"\u0004\b\u0001\u0010'* \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\u0006\u0010.\u001a\u00020/2\b\u0010Q\u001a\u0004\u0018\u00010,H\u0002ø\u0001\u0000¢\u0006\u0002\u0010RR\u0014\u0010\t\u001a\u00020\n8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\nX¤\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0012\u0010\u000e\u001a\u00020\nX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170\u00138Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Z"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel;", "E", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/Channel;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "hasReceiveOrClosed", "", "getHasReceiveOrClosed", "()Z", "isBufferAlwaysEmpty", "isBufferEmpty", "isClosedForReceive", "isEmpty", "isEmptyImpl", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching", "cancel", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", "cancelInternal$kotlinx_coroutines_core", "describeTryPoll", "Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "enqueueReceive", "receive", "Lkotlinx/coroutines/channels/Receive;", "enqueueReceiveInternal", "enqueueReceiveSelect", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "receiveMode", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)Z", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "onCancelIdempotent", "wasClosed", "onCancelIdempotentList", "list", "Lkotlinx/coroutines/internal/InlineList;", "Lkotlinx/coroutines/channels/Send;", "closed", "Lkotlinx/coroutines/channels/Closed;", "onCancelIdempotentList-w-w6eGU", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "onReceiveDequeued", "onReceiveEnqueued", "pollInternal", "pollSelectInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveSuspend", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerSelectReceiveMode", "(Lkotlinx/coroutines/selects/SelectInstance;ILkotlin/jvm/functions/Function2;)V", "removeReceiveOnCancel", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "takeFirstReceiveOrPeekClosed", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "tryStartBlockUnintercepted", "value", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/selects/SelectInstance;ILjava/lang/Object;)V", "Itr", "ReceiveElement", "ReceiveElementWithUndeliveredHandler", "ReceiveHasNext", "ReceiveSelect", "RemoveReceiveOnCancel", "TryPollDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class a<E> extends h.a.d3.c<E> implements h.a.d3.f<E> {

    /* JADX INFO: renamed from: h.a.d3.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0011\u0010\f\u001a\u00020\rH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0011\u0010\u0010\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0011\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\tR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$Itr;", "E", "Lkotlinx/coroutines/channels/ChannelIterator;", "channel", "Lkotlinx/coroutines/channels/AbstractChannel;", "(Lkotlinx/coroutines/channels/AbstractChannel;)V", "result", "", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "hasNext", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextResult", "hasNextSuspend", "next", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class C0457a<E> implements h<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a<E> f17189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Object f17190b;

        public C0457a(a<E> r1) {
            this.f17189a = r1;
            this.f17190b = h.a.d3.b.f17207d;
        }

        private final boolean c(Object r1) {
            if ((r1 instanceof m) == false) goto L10;
            m r2 = (m) r1;
            if (r2.f17233i != null) goto L9;
            return false;
        L9:
            throw e0.k(r2.J());
        L10:
            return true;
        }

        private final Object d(kotlin.k0.d<? super Boolean> r5) {
            h.a.o r0 = h.a.q.b(kotlin.k0.i.b.b(r5));
            d r1 = new d(this, r0);
        L4:
            if (a.D(this.f17189a, r1) == true) goto L5;
            Object r2 = this.f17189a.P();
            e(r2);
            if ((r2 instanceof m) == true) goto L8;
            if (r2 == h.a.d3.b.f17207d) goto L4;
            Boolean r3 = kotlin.k0.j.a.b.a(true);
            kotlin.n0.c.l<E, f0> r4 = this.f17189a.f17212f;
            if (r4 != null) goto L18;
            kotlin.n0.c.l<Throwable, f0> r6 = null;
        L19:
            r0.n(r3, r6);
        L20:
            Object r7 = r0.x();
            if (r7 != kotlin.k0.i.b.c()) goto L23;
            kotlin.k0.j.a.h.c(r5);
        L23:
            return r7;
        L18:
            r6 = h.a.f3.z.a(r4, r2, r0.getContext());
            goto L19
        L8:
            m r8 = (m) r2;
            if (r8.f17233i != null) goto L11;
            kotlin.v.a r9 = kotlin.v.f21457g;
            Object r10 = kotlin.k0.j.a.b.a(false);
        L12:
            kotlin.v.b(r10);
            r0.resumeWith(r10);
            goto L20
        L11:
            kotlin.v.a r11 = kotlin.v.f21457g;
            r10 = kotlin.w.a(r8.J());
            goto L12
        L5:
            a.E(this.f17189a, r0, r1);
            goto L20
        }

        @Override // h.a.d3.h
        public Object a(kotlin.k0.d<? super Boolean> r3) {
            Object r0 = b();
            h.a.f3.f0 r1 = h.a.d3.b.f17207d;
            if (r0 != r1) goto L5;
            e(this.f17189a.P());
            if (b() != r1) goto L5;
            return d(r3);
        L5:
            return kotlin.k0.j.a.b.a(c(b()));
        }

        public final Object b() {
            return this.f17190b;
        }

        public final void e(Object r1) {
            this.f17190b = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.a.d3.h
        public E next() {
            E r0 = (E) this.f17190b;
            if ((r0 instanceof m) == true) goto L11;
            h.a.f3.f0 r1 = h.a.d3.b.f17207d;
            if (r0 == r1) goto L9;
            this.f17190b = r1;
            return r0;
        L9:
            throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
        L11:
            throw e0.k(((m) r0).J());
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\u00020\n2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00028\u0001¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J!\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000b\u001a\u00028\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0018R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", "E", "Lkotlinx/coroutines/channels/Receive;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "receiveMode", "", "(Lkotlinx/coroutines/CancellableContinuation;I)V", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "resumeValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static class b<E> extends u<E> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final h.a.n<Object> f17191i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f17192j;

        public b(h.a.n<Object> r1, int r2) {
            this.f17191i = r1;
            this.f17192j = r2;
        }

        @Override // h.a.d3.u
        public void E(m<?> r3) {
            int r0 = this.f17192j;
            h.a.n<Object> r2 = this.f17191i;
            if (r0 != 1) goto L5;
            kotlin.v.a r1 = kotlin.v.f21457g;
            Object r4 = j.b(j.f17229b.a(r3.f17233i));
        L6:
            kotlin.v.b(r4);
            r2.resumeWith(r4);
            return;
        L5:
            kotlin.v.a r5 = kotlin.v.f21457g;
            r4 = kotlin.w.a(r3.J());
            goto L6
        }

        public final Object F(E r2) {
            if (this.f17192j != 1) goto L6;
            j.f17229b.c(r2);
            return j.b(r2);
        L6:
            return r2;
        }

        @Override // h.a.d3.w
        public void h(E r1) {
            this.f17191i.q(h.a.p.f17553a);
        }

        @Override // h.a.d3.w
        public h.a.f3.f0 i(E r5, h.a.f3.s.c r6) {
            h.a.n<Object> r0 = this.f17191i;
            Object r1 = F(r5);
            if (r6 != null) goto L5;
            h.a.f3.s.a r3 = null;
        L6:
            Object r4 = r0.l(r1, r3, D(r5));
            if (r4 != null) goto L10;
            return null;
        L10:
            if (q0.a() == true) goto L12;
        L19:
            if (r6 == null) goto L21;
            r6.d();
            throw null;
        L21:
            return h.a.p.f17553a;
        L12:
            if (r4 != h.a.p.f17553a) goto L14;
            boolean r7 = true;
        L15:
            if (r7 == true) goto L19;
            throw new AssertionError();
        L14:
            r7 = false;
            goto L15
        L5:
            r3 = r6.f17416a;
            goto L6
        }

        @Override // h.a.f3.s
        public String toString() {
            return "ReceiveElement@" + r0.b(this) + "[receiveMode=" + this.f17192j + ']';
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B;\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00028\u0001`\u000b¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010R&\u0010\b\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00028\u0001`\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElementWithUndeliveredHandler;", "E", "Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "receiveMode", "", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlinx/coroutines/CancellableContinuation;ILkotlin/jvm/functions/Function1;)V", "resumeOnCancellationFun", "", "value", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class c<E> extends b<E> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final kotlin.n0.c.l<E, f0> f17193k;

        /* JADX WARN: Multi-variable type inference failed */
        public c(h.a.n<Object> r1, int r2, kotlin.n0.c.l<? super E, f0> r3) {
            super(r1, r2);
            this.f17193k = r3;
        }

        @Override // h.a.d3.u
        public kotlin.n0.c.l<Throwable, f0> D(E r2) {
            return h.a.f3.z.a(this.f17193k, r2, this.f17191i.getContext());
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\n2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J!\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000b\u001a\u00028\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aR\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveHasNext;", "E", "Lkotlinx/coroutines/channels/Receive;", "iterator", "Lkotlinx/coroutines/channels/AbstractChannel$Itr;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/channels/AbstractChannel$Itr;Lkotlinx/coroutines/CancellableContinuation;)V", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "resumeOnCancellationFun", "Lkotlin/Function1;", "", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static class d<E> extends u<E> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final C0457a<E> f17194i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final h.a.n<Boolean> f17195j;

        /* JADX WARN: Multi-variable type inference failed */
        public d(C0457a<E> r1, h.a.n<? super Boolean> r2) {
            this.f17194i = r1;
            this.f17195j = r2;
        }

        @Override // h.a.d3.u
        public kotlin.n0.c.l<Throwable, f0> D(E r2) {
            kotlin.n0.c.l<E, f0> r0 = this.f17194i.f17189a.f17212f;
            if (r0 != null) goto L6;
            return null;
        L6:
            return h.a.f3.z.a(r0, r2, this.f17195j.getContext());
        }

        @Override // h.a.d3.u
        public void E(m<?> r5) {
            if (r5.f17233i != null) goto L5;
            Object r0 = h.a.n.a.a(this.f17195j, Boolean.FALSE, null, 2, null);
        L6:
            if (r0 == null) goto L9;
            this.f17194i.e(r5);
            this.f17195j.q(r0);
            return;
        L9:
            return;
        L5:
            r0 = this.f17195j.j(r5.J());
            goto L6
        }

        @Override // h.a.d3.w
        public void h(E r2) {
            this.f17194i.e(r2);
            this.f17195j.q(h.a.p.f17553a);
        }

        @Override // h.a.d3.w
        public h.a.f3.f0 i(E r5, h.a.f3.s.c r6) {
            h.a.n<Boolean> r0 = this.f17195j;
            Boolean r1 = Boolean.TRUE;
            if (r6 != null) goto L5;
            h.a.f3.s.a r3 = null;
        L6:
            Object r4 = r0.l(r1, r3, D(r5));
            if (r4 != null) goto L10;
            return null;
        L10:
            if (q0.a() == true) goto L12;
        L19:
            if (r6 == null) goto L21;
            r6.d();
            throw null;
        L21:
            return h.a.p.f17553a;
        L12:
            if (r4 != h.a.p.f17553a) goto L14;
            boolean r7 = true;
        L15:
            if (r7 == true) goto L19;
            throw new AssertionError();
        L14:
            r7 = false;
            goto L15
        L5:
            r3 = r6.f17416a;
            goto L6
        }

        @Override // h.a.f3.s
        public String toString() {
            return kotlin.n0.d.o.m("ReceiveHasNext@", r0.b(this));
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$RemoveReceiveOnCancel;", "Lkotlinx/coroutines/BeforeResumeCancelHandler;", "receive", "Lkotlinx/coroutines/channels/Receive;", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/channels/Receive;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class e extends h.a.e {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final u<?> f17196f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a<E> f17197g;

        public e(a r1, u<?> r2) {
            this.f17197g = r1;
            this.f17196f = r2;
        }

        @Override // h.a.m
        public void a(Throwable r1) {
            if (this.f17196f.x() == false) goto L6;
            this.f17197g.N();
            return;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Throwable r1) {
            a(r1);
            return f0.f18324a;
        }

        public String toString() {
            return "RemoveReceiveOnCancel[" + this.f17196f + ']';
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class f extends h.a.f3.s.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f17198d;

        public f(h.a.f3.s r1, a r2) {
            this.f17198d = r2;
            super(r1);
        }

        @Override // h.a.f3.d
        public /* bridge */ /* synthetic */ Object g(h.a.f3.s r1) {
            return i(r1);
        }

        public Object i(h.a.f3.s r1) {
            if (this.f17198d.J() == false) goto L6;
            return null;
        L6:
            return h.a.f3.r.a();
        }
    }

    @kotlin.k0.j.a.f(c = "kotlinx.coroutines.channels.AbstractChannel", f = "AbstractChannel.kt", l = {633}, m = "receiveCatching-JP2dKIU")
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    static final class g extends kotlin.k0.j.a.d {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f17199f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a<E> f17200g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f17201h;

        g(a<E> r1, kotlin.k0.d<? super g> r2) {
            this.f17200g = r1;
            super(r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r2) {
            this.f17199f = r2;
            this.f17201h |= Integer.MIN_VALUE;
            Object r1 = this.f17200g.d(this);
            if (r1 != kotlin.k0.i.b.c()) goto L6;
            return r1;
        L6:
            return j.b(r1);
        }
    }

    public a(kotlin.n0.c.l<? super E, f0> r1) {
        super(r1);
    }

    public static final /* synthetic */ boolean D(a r0, u r1) {
        return r0.G(r1);
    }

    public static final /* synthetic */ void E(a r0, h.a.n r1, u r2) {
        r0.R(r1, r2);
    }

    private final boolean G(u<? super E> r1) {
        boolean r2 = H(r1);
        if (r2 == false) goto L5;
        O();
    L5:
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <R> Object Q(int r4, kotlin.k0.d<? super R> r5) {
        h.a.o r0 = h.a.q.b(kotlin.k0.i.b.b(r5));
        if (this.f17212f != null) goto L5;
        b r1 = new b(r0, r4);
    L7:
        if (D(this, r1) == true) goto L8;
        Object r6 = P();
        if ((r6 instanceof m) == true) goto L11;
        if (r6 == h.a.d3.b.f17207d) goto L7;
        r0.n(r1.F(r6), r1.D(r6));
    L15:
        Object r3 = r0.x();
        if (r3 != kotlin.k0.i.b.c()) goto L18;
        kotlin.k0.j.a.h.c(r5);
    L18:
        return r3;
    L11:
        r1.E((m) r6);
        goto L15
    L8:
        E(this, r0, r1);
        goto L15
    L5:
        r1 = new c(r0, r4, this.f17212f);
        goto L7
    }

    private final void R(h.a.n<?> r2, u<?> r3) {
        r2.h(new e(this, r3));
    }

    @Override // h.a.d3.c
    protected w<E> B() {
        w<E> r0 = super.B();
        if (r0 != null) goto L5;
    L7:
        return r0;
    L5:
        if ((r0 instanceof m) == true) goto L7;
        N();
        goto L7
    }

    public final boolean F(Throwable r1) {
        boolean r2 = e(r1);
        L(r2);
        return r2;
    }

    protected boolean H(u<? super E> r6) {
        if (I() == false) goto L11;
        h.a.f3.s r0 = n();
    L5:
        h.a.f3.s r5 = r0.t();
        if ((!(r5 instanceof y)) == false) goto L29;
        if (r5.m(r6, r0) == false) goto L5;
    L21:
        return true;
    L29:
        return false;
    L11:
        h.a.f3.s r1 = n();
        f r3 = new f(r6, this);
    L12:
        h.a.f3.s r7 = r1.t();
        if ((!(r7 instanceof y)) == false) goto L31;
        int r8 = r7.B(r6, r1, r3);
        if (r8 == 1) goto L21;
        if (r8 != 2) goto L12;
        return false;
    L31:
        return false;
    }

    protected abstract boolean I();

    protected abstract boolean J();

    public boolean K() {
        if (l() != null) goto L5;
    L7:
        return false;
    L5:
        if (J() == false) goto L7;
        return true;
    }

    protected void L(boolean r4) {
        m<?> r5 = m();
        if (r5 == null) goto L21;
        Object r0 = h.a.f3.n.b(null, 1, null);
    L5:
        h.a.f3.s r1 = r5.t();
        if ((r1 instanceof h.a.f3.q) == true) goto L7;
        if (q0.a() == false) goto L17;
        if ((r1 instanceof y) == true) goto L17;
        throw new AssertionError();
    L17:
        if (r1.x() == false) goto L18;
        r0 = h.a.f3.n.c(r0, (y) r1);
        goto L5
    L18:
        r1.u();
        goto L5
    L7:
        M(r0, r5);
        return;
    L21:
        throw new IllegalStateException("Cannot happen".toString());
    }

    protected void M(Object r2, m<?> r3) {
        if (r2 != null) goto L5;
        return;
    L5:
        if ((r2 instanceof ArrayList) == true) goto L7;
        ((y) r2).E(r3);
        return;
    L7:
        Objects.requireNonNull(r2, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList r4 = (ArrayList) r2;
        int r1 = r4.size() - 1;
        if (r1 < 0) goto L15;
    L9:
        int r0 = r1 - 1;
        ((y) r4.get(r1)).E(r3);
        if (r0 < 0) goto L17;
        r1 = r0;
        goto L9
    L17:
        return;
    }

    protected void N() {
    }

    protected void O() {
    }

    protected Object P() {
    L2:
        y r0 = C();
        if (r0 == null) goto L5;
        h.a.f3.f0 r1 = r0.F(null);
        if (r1 != null) goto L9;
        r0.G();
        goto L2
    L9:
        if (q0.a() == true) goto L11;
    L18:
        r0.C();
        return r0.D();
    L11:
        if (r1 != h.a.p.f17553a) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L18;
        throw new AssertionError();
    L13:
        r2 = false;
        goto L14
    L5:
        return h.a.d3.b.f17207d;
    }

    @Override // h.a.d3.v
    public final void a(CancellationException r3) {
        if (K() == false) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        r3 = new CancellationException(kotlin.n0.d.o.m(r0.a(this), " was cancelled"));
    L7:
        F(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.a.d3.v
    public final Object d(kotlin.k0.d<? super j<? extends E>> r5) {
        if ((r5 instanceof g) == false) goto L7;
        g r0 = (g) r5;
        int r1 = r0.f17201h;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.f17201h = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f17199f;
        Object r2 = kotlin.k0.i.b.c();
        int r3 = r0.f17201h;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        kotlin.w.b(r6);
    L25:
        return ((j) r6).k();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.w.b(r6);
        Object r7 = P();
        if (r7 != h.a.d3.b.f17207d) goto L17;
        r0.f17201h = 1;
        r6 = Q(1, r0);
        if (r6 != r2) goto L25;
        return r2;
    L17:
        if ((r7 instanceof m) == true) goto L26;
        j.f17229b.c(r7);
        return r7;
    L26:
        return j.f17229b.a(((m) r7).f17233i);
    L7:
        r0 = new g(this, r5);
        goto L8
    }

    @Override // h.a.d3.v
    public final h<E> iterator() {
        return new C0457a(this);
    }
}
