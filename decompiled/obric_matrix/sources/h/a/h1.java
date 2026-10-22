package h.a;

import androidx.core.location.LocationRequestCompat;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0004J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0012\u0010\u0016\u001a\u00020\u00132\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0010J\u0010\u0010\u0018\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\nH\u0016J\u0006\u0010\u001d\u001a\u00020\u0004J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u0014\u0010\t\u001a\u00020\n8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "isActive", "", "()Z", "isEmpty", "isUnconfinedLoopActive", "isUnconfinedQueueEmpty", "nextTime", "", "getNextTime", "()J", "shared", "unconfinedQueue", "Lkotlinx/coroutines/internal/ArrayQueue;", "Lkotlinx/coroutines/DispatchedTask;", "useCount", "decrementUseCount", "", "unconfined", "delta", "dispatchUnconfined", "task", "incrementUseCount", "limitedParallelism", "parallelism", "", "processNextEvent", "processUnconfinedEvent", "shouldBeProcessedFromContext", "shutdown", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class h1 extends g0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f17448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f17449g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private h.a.f3.a<y0<?>> f17450h;

    public h1() {
    }

    public static /* synthetic */ void i0(h1 r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.h0(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    private final long j0(boolean r1) {
        if (r1 == false) goto L4;
        return 4294967296L;
    L4:
        return 1;
    }

    public static /* synthetic */ void n0(h1 r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.m0(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public final void h0(boolean r5) {
        long r0 = this.f17448f - j0(r5);
        this.f17448f = r0;
        if (r0 <= 0) goto L6;
        return;
    L6:
        if (q0.a() == false) goto L16;
        if (this.f17448f != 0) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == true) goto L16;
        throw new AssertionError();
    L10:
        r6 = false;
    L16:
        if (this.f17449g == false) goto L19;
        shutdown();
        return;
    }

    public final void k0(y0<?> r2) {
        h.a.f3.a<y0<?>> r0 = this.f17450h;
        if (r0 != null) goto L5;
        r0 = new h.a.f3.a();
        this.f17450h = r0;
    L5:
        r0.a(r2);
    }

    protected long l0() {
        h.a.f3.a<y0<?>> r2 = this.f17450h;
        if (r2 != null) goto L6;
        return LocationRequestCompat.PASSIVE_INTERVAL;
    L6:
        if (r2.c() == true) goto L10;
        return 0;
    L10:
        return LocationRequestCompat.PASSIVE_INTERVAL;
    }

    @Override // h.a.g0
    public final g0 limitedParallelism(int r1) {
        h.a.f3.p.a(r1);
        return this;
    }

    public final void m0(boolean r5) {
        this.f17448f += j0(r5);
        if (r5 == true) goto L6;
        this.f17449g = true;
        return;
    }

    public final boolean o0() {
        if (this.f17448f >= j0(true)) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean p0() {
        h.a.f3.a<y0<?>> r0 = this.f17450h;
        if (r0 != null) goto L6;
        return true;
    L6:
        return r0.c();
    }

    public long q0() {
        if (r0() == true) goto L6;
        return LocationRequestCompat.PASSIVE_INTERVAL;
    L6:
        return 0;
    }

    public final boolean r0() {
        h.a.f3.a<y0<?>> r1 = this.f17450h;
        if (r1 != null) goto L5;
        return false;
    L5:
        y0<?> r2 = r1.d();
        if (r2 != null) goto L8;
        return false;
    L8:
        r2.run();
        return true;
    }

    public boolean s0() {
        return false;
    }

    public void shutdown() {
    }
}
