package h.a.e3.b0;

import h.a.e3.b0.c;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;
import kotlin.v;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00060\u0003j\u0002`\u0004B\u0005¢\u0006\u0002\u0010\u0005J\r\u0010\u0018\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0019J\r\u0010\u001a\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u0019J\u001d\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000e2\u0006\u0010\u001c\u001a\u00020\tH$¢\u0006\u0002\u0010\u001dJ\u001d\u0010\u001e\u001a\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f0!H\u0084\bJ\u0015\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010$R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R:\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000e2\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000e@BX\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "S", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "()V", "_subscriptionCount", "Lkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow;", "<set-?>", "", "nCollectors", "getNCollectors", "()I", "nextIndex", "", "slots", "getSlots$annotations", "getSlots", "()[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "getSubscriptionCount", "()Lkotlinx/coroutines/flow/StateFlow;", "allocateSlot", "()Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "createSlot", "createSlotArray", "size", "(I)[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "forEachSlotLocked", "", "block", "Lkotlin/Function1;", "freeSlot", "slot", "(Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class a<S extends c<?>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private S[] f17253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f17254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f17255h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private k f17256i;

    public a() {
    }

    public static final /* synthetic */ int b(a r0) {
        return r0.f17254g;
    }

    public static final /* synthetic */ c[] c(a r0) {
        return r0.f17253f;
    }

    protected final S d() {
        monitor-enter(this);
        S[] r0 = (S[]) i();
        if (r0 != null) goto L7;
        r0 = (S[]) f(2);
        this.f17253f = r0;     // Catch: Throwable -> L24
    L9:
        int r1 = this.f17255h;     // Catch: Throwable -> L24
    L10:
        S r2 = r0[r1];     // Catch: Throwable -> L24
        if (r2 != null) goto L13;
        r2 = (S) e();
        r0[r1] = r2;     // Catch: Throwable -> L24
    L13:
        r1 = r1 + 1;     // Catch: Throwable -> L24
        if (r1 < r0.length) goto L17;
        r1 = 0;
    L17:
        if (r2.a(this) == false) goto L10;
        this.f17255h = r1;     // Catch: Throwable -> L24
        this.f17254g = h() + 1;     // Catch: Throwable -> L24
        k r3 = this.f17256i;     // Catch: Throwable -> L24
        monitor-exit(this);
        if (r3 != null) goto L22;
        return r2;
    L22:
        r3.T(1);
        throw null;
    L7:
        if (h() < r0.length) goto L9;
        Object[] r4 = Arrays.copyOf(r0, r0.length * 2);     // Catch: Throwable -> L24
        o.e(r4, "copyOf(this, newSize)");     // Catch: Throwable -> L24
        this.f17253f = (S[]) ((c[]) r4);     // Catch: Throwable -> L24
        r0 = (S[]) ((c[]) r4);
    L24:
        th = move-exception;
        throw th;
    }

    protected abstract S e();

    protected abstract S[] f(int r1);

    protected final void g(S r6) {
        monitor-enter(this);
        this.f17254g = h() - 1;     // Catch: Throwable -> L18
        k r0 = this.f17256i;     // Catch: Throwable -> L18
        int r3 = 0;
        if (h() != 0) goto L6;
        this.f17255h = 0;     // Catch: Throwable -> L18
    L6:
        kotlin.k0.d<f0>[] r7 = r6.b(this);     // Catch: Throwable -> L18
        monitor-exit(this);
        int r5 = r7.length;
    L9:
        if (r3 >= r5) goto L14;
        kotlin.k0.d<f0> r2 = r7[r3];
        r3 = r3 + 1;
        if (r2 == null) goto L9;
        v.a r4 = v.f21457g;
        f0 r8 = f0.f18324a;
        v.b(r8);
        r2.resumeWith(r8);
        goto L9
    L14:
        if (r0 != null) goto L16;
        return;
    L16:
        r0.T(-1);
        throw null;
    L18:
        th = move-exception;
        throw th;
    }

    protected final int h() {
        return this.f17254g;
    }

    protected final S[] i() {
        return this.f17253f;
    }
}
