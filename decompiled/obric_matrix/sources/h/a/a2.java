package h.a;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0000\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0003R\u0014\u0010\u0006\u001a\u00020\u0007X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/JobImpl;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableJob;", "parent", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "handlesException", "", "getHandlesException$kotlinx_coroutines_core", "()Z", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "complete", "completeExceptionally", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class a2 extends f2 implements w {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f17179g;

    public a2(x1 r2) {
        super(true);
        h0(r2);
        this.f17179g = L0();
    }

    private final boolean L0() {
        t r3 = b0();
        if ((r3 instanceof u) == false) goto L5;
        u r4 = (u) r3;
    L6:
        if (r4 != null) goto L8;
        f2 r5 = null;
    L10:
        if (r5 != null) goto L13;
        return false;
    L13:
        if (r5.W() == true) goto L14;
        t r6 = r5.b0();
        if ((r6 instanceof u) == false) goto L19;
        u r7 = (u) r6;
    L20:
        if (r7 != null) goto L22;
        r5 = null;
    L23:
        if (r5 != null) goto L13;
        return false;
    L22:
        r5 = r7.D();
        goto L23
    L19:
        r7 = null;
        goto L20
    L14:
        return true;
    L8:
        r5 = r4.D();
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    @Override // h.a.f2
    public boolean W() {
        return this.f17179g;
    }

    @Override // h.a.f2
    public boolean Z() {
        return true;
    }
}
