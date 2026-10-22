package h.a.d3;

import h.a.f3.f0;
import h.a.q0;
import h.a.r0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\u0014\u0010\u0016\u001a\u00020\u00122\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u001f\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00028\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0002\u0010\u001eJ\u0012\u0010\u001f\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e¨\u0006 "}, d2 = {"Lkotlinx/coroutines/channels/Closed;", "E", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "closeCause", "", "(Ljava/lang/Throwable;)V", "offerResult", "getOfferResult", "()Lkotlinx/coroutines/channels/Closed;", "pollResult", "getPollResult", "receiveException", "getReceiveException", "()Ljava/lang/Throwable;", "sendException", "getSendException", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "completeResumeSend", "resumeSendClosed", "closed", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "tryResumeSend", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class m<E> extends y implements w<E> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Throwable f17233i;

    public m(Throwable r1) {
        this.f17233i = r1;
    }

    @Override // h.a.d3.y
    public void C() {
    }

    @Override // h.a.d3.y
    public /* bridge */ /* synthetic */ Object D() {
        I();
        return this;
    }

    @Override // h.a.d3.y
    public void E(m<?> r1) {
        if (q0.a() == true) goto L5;
        return;
    L5:
        throw new AssertionError();
    }

    @Override // h.a.d3.y
    public f0 F(h.a.f3.s.c r1) {
        f0 r0 = h.a.p.f17553a;
        if (r1 != null) goto L5;
        return r0;
    L5:
        r1.d();
        throw null;
    }

    public m<E> H() {
        return this;
    }

    public m<E> I() {
        return this;
    }

    public final Throwable J() {
        Throwable r1 = this.f17233i;
        if (r1 == null) goto L5;
        return r1;
    L5:
        return new n("Channel was closed");
    }

    public final Throwable K() {
        Throwable r1 = this.f17233i;
        if (r1 == null) goto L5;
        return r1;
    L5:
        return new o("Channel was closed");
    }

    @Override // h.a.d3.w
    public /* bridge */ /* synthetic */ Object a() {
        H();
        return this;
    }

    @Override // h.a.d3.w
    public void h(E r1) {
    }

    @Override // h.a.d3.w
    public f0 i(E r1, h.a.f3.s.c r2) {
        f0 r0 = h.a.p.f17553a;
        if (r2 != null) goto L5;
        return r0;
    L5:
        r2.d();
        throw null;
    }

    @Override // h.a.f3.s
    public String toString() {
        return "Closed@" + r0.b(this) + '[' + this.f17233i + ']';
    }
}
