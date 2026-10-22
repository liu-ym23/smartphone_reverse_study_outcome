package h.a.d3;

import h.a.f3.p0;
import h.a.q0;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.f0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012 \u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0018\u001a\u00020\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0014J\u0015\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u001dJ!\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00028\u00002\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 H\u0014¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\rH\u0014J\n\u0010$\u001a\u0004\u0018\u00010\u0017H\u0014J\u0016\u0010%\u001a\u0004\u0018\u00010\u00172\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 H\u0014J\u0014\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017H\u0002R\u0014\u0010\b\u001a\u00020\t8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0012\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lkotlinx/coroutines/channels/ConflatedChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "bufferDebugString", "", "getBufferDebugString", "()Ljava/lang/String;", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "isEmpty", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "value", "", "enqueueReceiveInternal", "receive", "Lkotlinx/coroutines/channels/Receive;", "offerInternal", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "onCancelIdempotent", "wasClosed", "pollInternal", "pollSelectInternal", "updateValueLocked", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class p<E> extends a<E> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ReentrantLock f17234i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Object f17235j;

    public p(kotlin.n0.c.l<? super E, f0> r1) {
        super(r1);
        this.f17234i = new ReentrantLock();
        this.f17235j = b.f17204a;
    }

    private final p0 S(Object r5) {
        Object r0 = this.f17235j;
        p0 r2 = null;
        if (r0 == b.f17204a) goto L9;
        kotlin.n0.c.l<E, f0> r1 = this.f17212f;
        if (r1 == null) goto L9;
        r2 = h.a.f3.z.d(r1, r0, null, 2, null);
    L9:
        this.f17235j = r5;
        return r2;
    }

    @Override // h.a.d3.a
    protected boolean H(u<? super E> r2) {
        ReentrantLock r0 = this.f17234i;
        r0.lock();
        boolean r1 = super.H(r2);     // Catch: Throwable -> L6
        r0.unlock();
        return r1;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // h.a.d3.a
    protected final boolean I() {
        return false;
    }

    @Override // h.a.d3.a
    protected final boolean J() {
        if (this.f17235j != b.f17204a) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // h.a.d3.a
    protected void L(boolean r4) {
        ReentrantLock r0 = this.f17234i;
        r0.lock();
        p0 r1 = S(b.f17204a);     // Catch: Throwable -> L8
        f0 r2 = f0.f18324a;     // Catch: Throwable -> L8
        r0.unlock();
        super.L(r4);
        if (r1 != null) goto L7;
        return;
    L7:
        throw r1;
    L8:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // h.a.d3.a
    protected Object P() {
        ReentrantLock r0 = this.f17234i;
        r0.lock();
        Object r1 = this.f17235j;     // Catch: Throwable -> L13
        h.a.f3.f0 r2 = b.f17204a;     // Catch: Throwable -> L13
        if (r1 != r2) goto L10;
        Object r3 = m();     // Catch: Throwable -> L13
        if (r3 != null) goto L8;
        r3 = b.f17207d;     // Catch: Throwable -> L13
    L8:
        r0.unlock();
        return r3;
    L10:
        this.f17235j = r2;     // Catch: Throwable -> L13
        f0 r4 = f0.f18324a;     // Catch: Throwable -> L13
        r0.unlock();
        return r1;
    L13:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // h.a.d3.c
    protected String j() {
        return "(value=" + this.f17235j + ')';
    }

    @Override // h.a.d3.c
    protected final boolean u() {
        return false;
    }

    @Override // h.a.d3.c
    protected final boolean v() {
        return false;
    }

    @Override // h.a.d3.c
    protected Object x(E r4) {
        ReentrantLock r0 = this.f17234i;
        r0.lock();
        m<?> r1 = m();     // Catch: Throwable -> L38
        if (r1 == null) goto L6;
        r0.unlock();
        return r1;
    L6:
        if (this.f17235j != b.f17204a) goto L30;
    L7:
        w<E> r2 = B();     // Catch: Throwable -> L38
        if (r2 == null) goto L30;
        if ((r2 instanceof m) == true) goto L12;
        h.a.f3.f0 r3 = r2.i(r4, null);     // Catch: Throwable -> L38
        if (r3 == null) goto L7;
        if (q0.a() == true) goto L20;
    L27:
        f0 r5 = f0.f18324a;     // Catch: Throwable -> L38
        r0.unlock();
        r2.h(r4);
        return r2.a();
    L20:
        if (r3 != h.a.p.f17553a) goto L22;
        boolean r6 = true;
    L23:
        if (r6 == true) goto L27;
        throw new AssertionError();     // Catch: Throwable -> L38
    L22:
        r6 = false;
        goto L23
    L12:
        r0.unlock();
        return r2;
    L30:
        p0 r7 = S(r4);     // Catch: Throwable -> L38
        if (r7 != null) goto L35;
        h.a.f3.f0 r8 = b.f17205b;     // Catch: Throwable -> L38
        r0.unlock();
        return r8;
    L35:
        throw r7;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        r0.unlock();
        throw th;
    }
}
