package kotlin.s0.w.d.l0.l.b;

import java.util.Iterator;
import kotlin.s0.w.d.l0.c.l0;
import kotlin.s0.w.d.l0.c.m0;
import kotlin.s0.w.d.l0.c.o0;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m0 f20854a;

    public o(m0 r2) {
        kotlin.n0.d.o.f(r2, "packageFragmentProvider");
        this.f20854a = r2;
    }

    @Override // kotlin.s0.w.d.l0.l.b.h
    public g a(kotlin.s0.w.d.l0.g.b r3) {
        kotlin.n0.d.o.f(r3, "classId");
        m0 r2 = this.f20854a;
        kotlin.s0.w.d.l0.g.c r0 = r3.h();
        kotlin.n0.d.o.e(r0, "classId.packageFqName");
        Iterator<l0> r4 = o0.c(r2, r0).iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        l0 r1 = r4.next();
        if ((r1 instanceof p) == false) goto L4;
        g r5 = ((p) r1).F0().a(r3);
        if (r5 == null) goto L4;
        return r5;
    L10:
        return null;
    }
}
