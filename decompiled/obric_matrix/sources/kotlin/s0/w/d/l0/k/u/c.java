package kotlin.s0.w.d.l0.k.u;

import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.e.a.j0.g;
import kotlin.s0.w.d.l0.e.a.n0.d0;
import kotlin.s0.w.d.l0.k.w.h;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.e.a.l0.f f20603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f20604b;

    public c(kotlin.s0.w.d.l0.e.a.l0.f r2, g r3) {
        o.f(r2, "packageFragmentProvider");
        o.f(r3, "javaResolverCache");
        this.f20603a = r2;
        this.f20604b = r3;
    }

    public final kotlin.s0.w.d.l0.e.a.l0.f a() {
        return this.f20603a;
    }

    public final kotlin.s0.w.d.l0.c.e b(kotlin.s0.w.d.l0.e.a.n0.g r4) {
        o.f(r4, "javaClass");
        kotlin.s0.w.d.l0.g.c r0 = r4.e();
        if (r0 != null) goto L5;
    L8:
        kotlin.s0.w.d.l0.e.a.n0.g r1 = r4.j();
        if (r1 == null) goto L21;
        kotlin.s0.w.d.l0.c.e r3 = b(r1);
        if (r3 == null) goto L13;
        h r5 = r3.y0();
    L14:
        if (r5 == null) goto L16;
        kotlin.s0.w.d.l0.c.h r6 = r5.f(r4.getName(), kotlin.s0.w.d.l0.d.b.d.x);
    L18:
        if ((r6 instanceof kotlin.s0.w.d.l0.c.e) == true) goto L20;
        return null;
    L20:
        return (kotlin.s0.w.d.l0.c.e) r6;
    L16:
        r6 = null;
        goto L18
    L13:
        r5 = null;
        goto L14
    L21:
        if (r0 != null) goto L23;
        return null;
    L23:
        kotlin.s0.w.d.l0.e.a.l0.f r7 = this.f20603a;
        kotlin.s0.w.d.l0.g.c r2 = r0.e();
        o.e(r2, "fqName.parent()");
        kotlin.s0.w.d.l0.e.a.l0.l.h r8 = (kotlin.s0.w.d.l0.e.a.l0.l.h) r.R(r7.a(r2));
        if (r8 != null) goto L26;
        return null;
    L26:
        return r8.M0(r4);
    L5:
        if (r4.I() != d0.f19527f) goto L8;
        return this.f20604b.a(r0);
    }
}
