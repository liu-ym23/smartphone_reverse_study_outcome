package kotlin.s0.w.d.l0.e.a.k0;

import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.e0;
import kotlin.s0.w.d.l0.c.u;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends f {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final z0 f19335J;
    private final z0 K;
    private final u0 L;

    public d(kotlin.s0.w.d.l0.c.e r17, z0 r18, z0 r19, u0 r20) {
        o.f(r17, "ownerDescriptor");
        o.f(r18, "getterMethod");
        o.f(r20, "overriddenProperty");
        kotlin.s0.w.d.l0.c.o1.g r2 = kotlin.s0.w.d.l0.c.o1.g.f18919b.b();
        e0 r3 = r18.l();
        u r4 = r18.getVisibility();
        if (r19 == null) goto L5;
        boolean r0 = true;
    L6:
        super(r17, r2, r3, r4, r0, r20.getName(), r18.getSource(), null, kotlin.s0.w.d.l0.c.b.a.f18848f, false, null);
        this.f19335J = r18;
        this.K = r19;
        this.L = r20;
        return;
    L5:
        r0 = false;
        goto L6
    }
}
