package h.a.d3;

import h.a.q0;
import h.a.r0;
import kotlin.Metadata;
import kotlin.f0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0014\u0010\f\u001a\u00020\u00062\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/channels/SendElement;", "E", "Lkotlinx/coroutines/channels/Send;", "pollResult", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "getPollResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "completeResumeSend", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class a0<E> extends y {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final E f17202i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h.a.n<f0> f17203j;

    /* JADX WARN: Multi-variable type inference failed */
    public a0(E r1, h.a.n<? super f0> r2) {
        this.f17202i = r1;
        this.f17203j = r2;
    }

    @Override // h.a.d3.y
    public void C() {
        this.f17203j.q(h.a.p.f17553a);
    }

    @Override // h.a.d3.y
    public E D() {
        return this.f17202i;
    }

    @Override // h.a.d3.y
    public void E(m<?> r2) {
        h.a.n<f0> r1 = this.f17203j;
        kotlin.v.a r0 = kotlin.v.f21457g;
        Object r3 = kotlin.w.a(r2.K());
        kotlin.v.b(r3);
        r1.resumeWith(r3);
    }

    @Override // h.a.d3.y
    public h.a.f3.f0 F(h.a.f3.s.c r4) {
        h.a.n<f0> r3 = this.f17203j;
        f0 r0 = f0.f18324a;
        if (r4 != null) goto L5;
        h.a.f3.s.a r2 = null;
    L6:
        Object r5 = r3.c(r0, r2);
        if (r5 != null) goto L10;
        return null;
    L10:
        if (q0.a() == true) goto L12;
    L19:
        if (r4 == null) goto L21;
        r4.d();
        throw null;
    L21:
        return h.a.p.f17553a;
    L12:
        if (r5 != h.a.p.f17553a) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == true) goto L19;
        throw new AssertionError();
    L14:
        r6 = false;
        goto L15
    L5:
        r2 = r4.f17416a;
        goto L6
    }

    @Override // h.a.f3.s
    public String toString() {
        return r0.a(this) + '@' + r0.b(this) + '(' + D() + ')';
    }
}
