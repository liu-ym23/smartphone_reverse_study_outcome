package h.a.e3;

import h.a.q0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.f0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0013B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ)\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f0\u000b2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0002J\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowSlot;", "<init>", "()V", "Lkotlinx/coroutines/flow/StateFlowImpl;", "flow", "", "allocateLocked", "(Lkotlinx/coroutines/flow/StateFlowImpl;)Z", "", "awaitPending", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lkotlin/coroutines/Continuation;", "freeLocked", "(Lkotlinx/coroutines/flow/StateFlowImpl;)[Lkotlin/coroutines/Continuation;", "makePending", "takePending", "()Z", "kotlinx-coroutines-core", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class y extends h.a.e3.b0.c<w<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f17334a = null;
    volatile /* synthetic */ Object _state;

    static {
        f17334a = AtomicReferenceFieldUpdater.newUpdater(y.class, Object.class, "_state");
    }

    public y() {
        this._state = null;
    }

    @Override // h.a.e3.b0.c
    public /* bridge */ /* synthetic */ boolean a(w<?> r1) {
        return c(r1);
    }

    @Override // h.a.e3.b0.c
    public /* bridge */ /* synthetic */ kotlin.k0.d[] b(w<?> r1) {
        return e(r1);
    }

    public boolean c(w<?> r1) {
        if (this._state == null) goto L6;
        return false;
    L6:
        this._state = x.b();
        return true;
    }

    public final Object d(kotlin.k0.d<? super f0> r5) {
        boolean r2 = true;
        h.a.o r0 = new h.a.o(kotlin.k0.i.b.b(r5), 1);
        r0.A();
        if (q0.a() == false) goto L10;
        if ((!(this._state instanceof h.a.o)) == true) goto L10;
        throw new AssertionError();
    L10:
        if (f17334a.compareAndSet(this, x.b(), r0) == false) goto L13;
    L23:
        Object r4 = r0.x();
        if (r4 != kotlin.k0.i.b.c()) goto L27;
        kotlin.k0.j.a.h.c(r5);
    L27:
        if (r4 != kotlin.k0.i.b.c()) goto L30;
        return r4;
    L30:
        return f0.f18324a;
    L13:
        if (q0.a() == true) goto L15;
    L22:
        kotlin.v.a r6 = kotlin.v.f21457g;
        f0 r7 = f0.f18324a;
        kotlin.v.b(r7);
        r0.resumeWith(r7);
        goto L23
    L15:
        if (this._state == x.c()) goto L18;
        r2 = false;
    L18:
        if (r2 == true) goto L22;
        throw new AssertionError();
    }

    public kotlin.k0.d<f0>[] e(w<?> r1) {
        this._state = null;
        return h.a.e3.b0.b.f17257a;
    }

    public final void f() {
    L2:
        Object r0 = this._state;
        if (r0 == null) goto L4;
        if (r0 == x.c()) goto L7;
        if (r0 == x.b()) goto L11;
        if (f17334a.compareAndSet(this, r0, x.b()) == false) goto L2;
        kotlin.v.a r3 = kotlin.v.f21457g;
        f0 r4 = f0.f18324a;
        kotlin.v.b(r4);
        ((h.a.o) r0).resumeWith(r4);
        return;
    L11:
        if (f17334a.compareAndSet(this, r0, x.c()) == false) goto L2;
        return;
    L7:
        return;
    }

    public final boolean g() {
        Object r2 = f17334a.getAndSet(this, x.b());
        kotlin.n0.d.o.c(r2);
        if (q0.a() == false) goto L10;
        if ((!(r2 instanceof h.a.o)) == true) goto L10;
        throw new AssertionError();
    L10:
        if (r2 == x.c()) goto L14;
        return false;
    L14:
        return true;
    }
}
