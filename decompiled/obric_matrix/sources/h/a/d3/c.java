package h.a.d3;

import h.a.f3.p0;
import h.a.q0;
import h.a.r0;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.j0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u000006:\u0004defgB)\u0012 \u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0013\u001a\u000e\u0012\u0002\b\u00030\u0011j\u0006\u0012\u0002\b\u0003`\u00122\u0006\u0010\u0010\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u0010\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001f\u001a\u00020\u00032\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J#\u0010!\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00028\u00002\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002¢\u0006\u0004\b!\u0010\"J\u001b\u0010!\u001a\u00020\b2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002¢\u0006\u0004\b!\u0010#J)\u0010&\u001a\u00020\u00032\u0018\u0010%\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`$H\u0016¢\u0006\u0004\b&\u0010\u0007J\u0019\u0010'\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00028\u0000H\u0014¢\u0006\u0004\b+\u0010,J#\u0010/\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00028\u00002\n\u0010.\u001a\u0006\u0012\u0002\b\u00030-H\u0014¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u000201H\u0014¢\u0006\u0004\b2\u00103JX\u00109\u001a\u00020\u0003\"\u0004\b\u0001\u001042\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00010-2\u0006\u0010\u0010\u001a\u00028\u00002(\u00108\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000107\u0012\u0006\u0012\u0004\u0018\u00010\u001a05H\u0002ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u001b\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010;J\u001d\u0010=\u001a\b\u0012\u0002\b\u0003\u0018\u00010<2\u0006\u0010\u0010\u001a\u00028\u0000H\u0004¢\u0006\u0004\b=\u0010>J\u001b\u0010?\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b?\u0010;J\u0017\u0010@\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010<H\u0014¢\u0006\u0004\b@\u0010AJ\u0011\u0010B\u001a\u0004\u0018\u00010\u0018H\u0004¢\u0006\u0004\bB\u0010CJ\u000f\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\bE\u0010FJ$\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00030G2\u0006\u0010\u0010\u001a\u00028\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bH\u0010,J+\u0010J\u001a\u00020\u0003*\u0006\u0012\u0002\b\u0003072\u0006\u0010\u0010\u001a\u00028\u00002\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002¢\u0006\u0004\bJ\u0010KR\u0014\u0010M\u001a\u00020D8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bL\u0010FR\u001a\u0010P\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u001a\u0010R\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010OR\u0014\u0010S\u001a\u00020\n8$X¤\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0014\u0010U\u001a\u00020\n8$X¤\u0004¢\u0006\u0006\u001a\u0004\bU\u0010TR\u0011\u0010V\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bV\u0010TR\u0014\u0010W\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bW\u0010TR#\u0010[\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000060X8F¢\u0006\u0006\u001a\u0004\bY\u0010ZR.\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00048\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\\R\u001a\u0010^\u001a\u00020]8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u0014\u0010c\u001a\u00020D8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bb\u0010F\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006h"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel;", "E", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "", "countQueueSize", "()I", "element", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/AddLastDesc;", "describeSendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "describeTryOffer", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "Lkotlinx/coroutines/channels/Send;", "send", "", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Closed;", "closed", "helpClose", "(Lkotlinx/coroutines/channels/Closed;)V", "helpCloseAndGetSendException", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "(Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "invokeOnCloseHandler", "(Ljava/lang/Throwable;)V", "offer", "(Ljava/lang/Object;)Z", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "onClosedIdempotent", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "R", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendSuspend", "takeFirstReceiveOrPeekClosed", "()Lkotlinx/coroutines/channels/ReceiveOrClosed;", "takeFirstSendOrPeekClosed", "()Lkotlinx/coroutines/channels/Send;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "trySend", "helpCloseAndResumeWithSendException", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "getBufferDebugString", "bufferDebugString", "getClosedForReceive", "()Lkotlinx/coroutines/channels/Closed;", "closedForReceive", "getClosedForSend", "closedForSend", "isBufferAlwaysFull", "()Z", "isBufferFull", "isClosedForSend", "isFullImpl", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueue", "()Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueueDebugStateString", "queueDebugStateString", "SendBuffered", "SendBufferedDesc", "SendSelect", "TryOfferDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class c<E> implements z<E> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f17211h = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final kotlin.n0.c.l<E, f0> f17212f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final h.a.f3.q f17213g;
    private volatile /* synthetic */ Object onCloseHandler;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0014\u0010\f\u001a\u00020\u000b2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0012\u0010\u0003\u001a\u00028\u00018\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", "E", "Lkotlinx/coroutines/channels/Send;", "element", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "pollResult", "", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a<E> extends y {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final E f17214i;

        public a(E r1) {
            this.f17214i = r1;
        }

        @Override // h.a.d3.y
        public void C() {
        }

        @Override // h.a.d3.y
        public Object D() {
            return this.f17214i;
        }

        @Override // h.a.d3.y
        public void E(m<?> r1) {
            if (q0.a() == true) goto L5;
            return;
        L5:
            throw new AssertionError();
        }

        @Override // h.a.d3.y
        public h.a.f3.f0 F(h.a.f3.s.c r1) {
            h.a.f3.f0 r0 = h.a.p.f17553a;
            if (r1 != null) goto L5;
            return r0;
        L5:
            r1.d();
            throw null;
        }

        @Override // h.a.f3.s
        public String toString() {
            return "SendBuffered@" + r0.b(this) + '(' + this.f17214i + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends h.a.f3.s.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f17215d;

        public b(h.a.f3.s r1, c r2) {
            this.f17215d = r2;
            super(r1);
        }

        @Override // h.a.f3.d
        public /* bridge */ /* synthetic */ Object g(h.a.f3.s r1) {
            return i(r1);
        }

        public Object i(h.a.f3.s r1) {
            if (this.f17215d.v() == false) goto L6;
            return null;
        L6:
            return h.a.f3.r.a();
        }
    }

    static {
        f17211h = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "onCloseHandler");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(kotlin.n0.c.l<? super E, f0> r1) {
        this.f17212f = r1;
        this.f17213g = new h.a.f3.q();
        this.onCloseHandler = null;
    }

    private final Object A(E r4, kotlin.k0.d<? super f0> r5) {
        h.a.o r0 = h.a.q.b(kotlin.k0.i.b.b(r5));
    L4:
        if (c(this) == true) goto L6;
    L23:
        Object r1 = x(r4);
        if (r1 == h.a.d3.b.f17205b) goto L25;
        if (r1 == h.a.d3.b.f17206c) goto L4;
        if ((r1 instanceof m) == false) goto L41;
        b(this, r0, r4, (m) r1);
    L32:
        Object r3 = r0.x();
        if (r3 != kotlin.k0.i.b.c()) goto L36;
        kotlin.k0.j.a.h.c(r5);
    L36:
        if (r3 != kotlin.k0.i.b.c()) goto L39;
        return r3;
    L39:
        return f0.f18324a;
    L41:
        throw new IllegalStateException(kotlin.n0.d.o.m("offerInternal returned ", r1).toString());
    L25:
        kotlin.v.a r6 = kotlin.v.f21457g;
        f0 r7 = f0.f18324a;
        kotlin.v.b(r7);
        r0.resumeWith(r7);
        goto L32
    L6:
        if (this.f17212f != null) goto L8;
        y r2 = new a0(r4, r0);
    L9:
        Object r8 = h(r2);
        if (r8 == null) goto L11;
        if ((r8 instanceof m) == true) goto L14;
        if (r8 == h.a.d3.b.f17208e) goto L23;
        if ((r8 instanceof u) == true) goto L23;
        throw new IllegalStateException(kotlin.n0.d.o.m("enqueueSend returned ", r8).toString());
    L14:
        b(this, r0, r4, (m) r8);
        goto L32
    L11:
        h.a.q.c(r0, r2);
        goto L32
    L8:
        r2 = new b0(r4, r0, this.f17212f);
        goto L9
    }

    public static final /* synthetic */ void b(c r0, kotlin.k0.d r1, Object r2, m r3) {
        r0.s(r1, r2, r3);
    }

    public static final /* synthetic */ boolean c(c r0) {
        return r0.w();
    }

    private final int g() {
        h.a.f3.q r3 = this.f17213g;
        h.a.f3.s r0 = (h.a.f3.s) r3.r();
        int r1 = 0;
    L4:
        if (kotlin.n0.d.o.a(r0, r3) == true) goto L9;
        if ((r0 instanceof h.a.f3.s) == false) goto L8;
        r1 = r1 + 1;
    L8:
        r0 = r0.s();
        goto L4
    L9:
        return r1;
    }

    private final String o() {
        h.a.f3.s r0 = this.f17213g.s();
        if (r0 != this.f17213g) goto L7;
        return "EmptyQueue";
    L7:
        if ((r0 instanceof m) == false) goto L10;
        String r1 = r0.toString();
    L16:
        h.a.f3.s r2 = this.f17213g.t();
        if (r2 == r0) goto L22;
        String r3 = r1 + ",queueSize=" + g();
        if ((r2 instanceof m) == true) goto L21;
        return r3;
    L21:
        return r3 + ",closedForSend=" + r2;
    L22:
        return r1;
    L10:
        if ((r0 instanceof u) == false) goto L13;
        r1 = "ReceiveQueued";
        goto L16
    L13:
        if ((r0 instanceof y) == false) goto L15;
        r1 = "SendQueued";
        goto L16
    L15:
        r1 = kotlin.n0.d.o.m("UNEXPECTED:", r0);
        goto L16
    }

    private final void q(m<?> r6) {
        Object r2 = h.a.f3.n.b(null, 1, null);
    L3:
        h.a.f3.s r3 = r6.t();
        if ((r3 instanceof u) == false) goto L6;
        u r4 = (u) r3;
    L7:
        if (r4 == null) goto L8;
        if (r4.x() == false) goto L23;
        r2 = h.a.f3.n.c(r2, r4);
        goto L3
    L23:
        r4.u();
        goto L3
    L8:
        if (r2 != null) goto L11;
    L19:
        y(r6);
        return;
    L11:
        if ((r2 instanceof ArrayList) == true) goto L13;
        ((u) r2).E(r6);
        goto L19
    L13:
        Objects.requireNonNull(r2, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList r5 = (ArrayList) r2;
        int r0 = r5.size() - 1;
        if (r0 < 0) goto L19;
    L15:
        int r1 = r0 - 1;
        ((u) r5.get(r0)).E(r6);
        if (r1 < 0) goto L19;
        r0 = r1;
        goto L15
    L6:
        r4 = null;
        goto L7
    }

    private final Throwable r(m<?> r1) {
        q(r1);
        return r1.K();
    }

    private final void s(kotlin.k0.d<?> r3, E r4, m<?> r5) {
        q(r5);
        Throwable r6 = r5.K();
        kotlin.n0.c.l<E, f0> r2 = this.f17212f;
        if (r2 == null) goto L7;
        p0 r7 = h.a.f3.z.d(r2, r4, null, 2, null);
        if (r7 == null) goto L7;
        kotlin.a.a(r7, r6);
        kotlin.v.a r8 = kotlin.v.f21457g;
        Object r9 = kotlin.w.a(r7);
    L8:
        kotlin.v.b(r9);
        r3.resumeWith(r9);
        return;
    L7:
        kotlin.v.a r10 = kotlin.v.f21457g;
        r9 = kotlin.w.a(r6);
        goto L8
    }

    private final void t(Throwable r4) {
        Object r0 = this.onCloseHandler;
        if (r0 == null) goto L10;
        h.a.f3.f0 r1 = h.a.d3.b.f17209f;
        if (r0 != r1) goto L7;
        return;
    L7:
        if (f17211h.compareAndSet(this, r0, r1) == false) goto L12;
        j0.e(r0, 1);
        ((kotlin.n0.c.l) r0).invoke(r4);
        return;
    L12:
        return;
    }

    private final boolean w() {
        if ((this.f17213g.s() instanceof w) == false) goto L5;
    L7:
        return false;
    L5:
        if (v() == false) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [h.a.f3.s] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    protected w<E> B() {
        h.a.f3.q r3 = this.f17213g;
    L3:
        ?? r0 = (h.a.f3.s) r3.r();
        if (r0 == r3) goto L5;
        if ((r0 instanceof w) == false) goto L5;
        if ((((w) r0) instanceof m) == true) goto L12;
    L14:
        h.a.f3.s r1 = r0.z();
        if (r1 == null) goto L17;
        r1.v();
    L17:
        return (w) r0;
    L12:
        if (r0.w() == true) goto L14;
    L5:
        r0 = 0;
        goto L17
    }

    protected final y C() {
        h.a.f3.q r3 = this.f17213g;
    L3:
        h.a.f3.s r0 = (h.a.f3.s) r3.r();
        if (r0 == r3) goto L5;
        if ((r0 instanceof y) == false) goto L5;
        if ((((y) r0) instanceof m) == true) goto L12;
    L14:
        h.a.f3.s r1 = r0.z();
        if (r1 == null) goto L17;
        r1.v();
    L17:
        return (y) r0;
    L12:
        if (r0.w() == true) goto L14;
    L5:
        r0 = null;
        goto L17
    }

    @Override // h.a.d3.z
    public boolean e(Throwable r6) {
        m<?> r0 = new m(r6);
        h.a.f3.s r1 = this.f17213g;
    L3:
        h.a.f3.s r2 = r1.t();
        boolean r4 = true;
        if ((!(r2 instanceof m)) == false) goto L5;
        if (r2.m(r0, r1) == false) goto L3;
    L8:
        if (r4 == true) goto L11;
        r0 = (m) this.f17213g.t();
    L11:
        q(r0);
        if (r4 == false) goto L14;
        t(r6);
    L14:
        return r4;
    L5:
        r4 = false;
        goto L8
    }

    @Override // h.a.d3.z
    public void f(kotlin.n0.c.l<? super Throwable, f0> r4) {
        AtomicReferenceFieldUpdater r0 = f17211h;
        if (r0.compareAndSet(this, null, r4) == true) goto L10;
        Object r3 = this.onCloseHandler;
        if (r3 != h.a.d3.b.f17209f) goto L9;
        throw new IllegalStateException("Another handler was already registered and successfully invoked");
    L9:
        throw new IllegalStateException(kotlin.n0.d.o.m("Another handler was already registered: ", r3));
    L10:
        m<?> r1 = m();
        if (r1 != null) goto L13;
        return;
    L13:
        if (r0.compareAndSet(this, r4, h.a.d3.b.f17209f) == false) goto L17;
        r4.invoke(r1.f17233i);
        return;
    }

    protected Object h(y r4) {
        if (u() == false) goto L11;
        h.a.f3.s r0 = this.f17213g;
    L5:
        h.a.f3.s r3 = r0.t();
        if ((r3 instanceof w) == true) goto L7;
        if (r3.m(r4, r0) == false) goto L5;
        return null;
    L7:
        return r3;
    L11:
        h.a.f3.s r1 = this.f17213g;
        b r2 = new b(r4, this);
    L12:
        h.a.f3.s r5 = r1.t();
        if ((r5 instanceof w) == true) goto L14;
        int r6 = r5.B(r4, r1, r2);
        boolean r7 = true;
        if (r6 == 1) goto L21;
        if (r6 != 2) goto L12;
        r7 = false;
    L21:
        if (r7 == false) goto L23;
        return null;
    L23:
        return h.a.d3.b.f17208e;
    L14:
        return r5;
    }

    @Override // h.a.d3.z
    public final Object i(E r2) {
        Object r3 = x(r2);
        if (r3 != h.a.d3.b.f17205b) goto L6;
        j.b r1 = j.f17229b;
        f0 r4 = f0.f18324a;
        r1.c(r4);
        return r4;
    L6:
        if (r3 != h.a.d3.b.f17206c) goto L13;
        m<?> r5 = m();
        if (r5 == null) goto L10;
        j.b r0 = j.f17229b;
    L16:
        return r0.a(r(r5));
    L10:
        return j.f17229b.b();
    L13:
        if ((r3 instanceof m) == false) goto L18;
        r0 = j.f17229b;
        r5 = (m) r3;
        goto L16
    L18:
        throw new IllegalStateException(kotlin.n0.d.o.m("trySend returned ", r3).toString());
    }

    protected String j() {
        return "";
    }

    @Override // h.a.d3.z
    public final Object k(E r3, kotlin.k0.d<? super f0> r4) {
        if (x(r3) == h.a.d3.b.f17205b) goto L5;
        Object r2 = A(r3, r4);
        if (r2 != kotlin.k0.i.b.c()) goto L10;
        return r2;
    L10:
        return f0.f18324a;
    L5:
        return f0.f18324a;
    }

    protected final m<?> l() {
        h.a.f3.s r0 = this.f17213g.s();
        if ((r0 instanceof m) == false) goto L5;
        m<?> r1 = (m) r0;
    L6:
        if (r1 == null) goto L10;
        q(r1);
        return r1;
    L10:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    protected final m<?> m() {
        h.a.f3.s r0 = this.f17213g.t();
        if ((r0 instanceof m) == false) goto L5;
        m<?> r1 = (m) r0;
    L6:
        if (r1 == null) goto L10;
        q(r1);
        return r1;
    L10:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    protected final h.a.f3.q n() {
        return this.f17213g;
    }

    @Override // h.a.d3.z
    public boolean offer(E r4) {
        return z.a.b(this, r4);
    L4:
        th = move-exception;
        kotlin.n0.c.l<E, f0> r3 = this.f17212f;
        if (r3 == null) goto L12;
        p0 r5 = h.a.f3.z.d(r3, r4, null, 2, null);
        if (r5 == null) goto L12;
        kotlin.a.a(r5, th);
        throw r5;
    L12:
        throw th;
    }

    @Override // h.a.d3.z
    public final boolean p() {
        if (m() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return r0.a(this) + '@' + r0.b(this) + '{' + o() + '}' + j();
    }

    protected abstract boolean u();

    protected abstract boolean v();

    protected Object x(E r3) {
    L2:
        w<E> r0 = B();
        if (r0 == null) goto L5;
        h.a.f3.f0 r1 = r0.i(r3, null);
        if (r1 == null) goto L2;
        if (q0.a() == true) goto L11;
    L18:
        r0.h(r3);
        return r0.a();
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
        return h.a.d3.b.f17206c;
    }

    protected void y(h.a.f3.s r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final w<?> z(E r3) {
        h.a.f3.q r2 = this.f17213g;
        a r0 = new a(r3);
    L3:
        h.a.f3.s r4 = r2.t();
        if ((r4 instanceof w) == true) goto L6;
        if (r4.m(r0, r2) == false) goto L3;
        return null;
    L6:
        return (w) r4;
    }
}
