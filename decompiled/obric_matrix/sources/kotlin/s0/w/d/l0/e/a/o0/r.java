package kotlin.s0.w.d.l0.e.a.o0;

import java.util.List;
import kotlin.s0.w.d.l0.e.a.a0;
import kotlin.s0.w.d.l0.n.e0;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f19628a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f19629b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19630a = null;

        static {
            int[] r0 = new int[h.values().length];
            r0[h.f19560g.ordinal()] = 1;
            r0[h.f19561h.ordinal()] = 2;
            f19630a = r0;
        }
    }

    static {
        kotlin.s0.w.d.l0.g.c r1 = a0.p;
        kotlin.n0.d.o.e(r1, "ENHANCED_NULLABILITY_ANNOTATION");
        f19628a = new c(r1);
        kotlin.s0.w.d.l0.g.c r2 = a0.q;
        kotlin.n0.d.o.e(r2, "ENHANCED_MUTABILITY_ANNOTATION");
        f19629b = new c(r2);
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.c.o1.g a(List r0) {
        return f(r0);
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.c.h b(kotlin.s0.w.d.l0.c.h r0, e r1, o r2) {
        return g(r0, r1, r2);
    }

    public static final /* synthetic */ c c() {
        return f19629b;
    }

    public static final /* synthetic */ c d() {
        return f19628a;
    }

    public static final /* synthetic */ Boolean e(e r0, o r1) {
        return h(r0, r1);
    }

    private static final kotlin.s0.w.d.l0.c.o1.g f(List<? extends kotlin.s0.w.d.l0.c.o1.g> r2) {
        int r0 = r2.size();
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L8;
        return new kotlin.s0.w.d.l0.c.o1.k(kotlin.i0.r.z0(r2));
    L8:
        return (kotlin.s0.w.d.l0.c.o1.g) kotlin.i0.r.o0(r2);
    L10:
        throw new IllegalStateException("At least one Annotations object expected".toString());
    }

    private static final kotlin.s0.w.d.l0.c.h g(kotlin.s0.w.d.l0.c.h r4, e r5, o r6) {
        kotlin.s0.w.d.l0.b.q.d r0 = kotlin.s0.w.d.l0.b.q.d.f18786a;
        if (p.a(r6) == true) goto L6;
        return null;
    L6:
        if ((r4 instanceof kotlin.s0.w.d.l0.c.e) == true) goto L9;
        return null;
    L9:
        if (r5.c() != f.f19555f) goto L16;
        if (r6 != o.f19623f) goto L16;
        kotlin.s0.w.d.l0.c.e r1 = (kotlin.s0.w.d.l0.c.e) r4;
        if (r0.c(r1) == false) goto L16;
        return r0.a(r1);
    L16:
        if (r5.c() == f.f19556g) goto L18;
        return null;
    L18:
        if (r6 != o.f19624g) goto L25;
        kotlin.s0.w.d.l0.c.e r7 = (kotlin.s0.w.d.l0.c.e) r4;
        if (r0.d(r7) == true) goto L22;
        return null;
    L22:
        return r0.b(r7);
    L25:
        return null;
    }

    private static final Boolean h(e r1, o r2) {
        if (p.a(r2) == true) goto L5;
        return null;
    L5:
        h r3 = r1.d();
        if (r3 != null) goto L8;
        int r4 = -1;
    L10:
        if (r4 == 1) goto L16;
        if (r4 == 2) goto L17;
        return null;
    L17:
        return Boolean.FALSE;
    L16:
        return Boolean.TRUE;
    L8:
        r4 = a.f19630a[r3.ordinal()];
        goto L10
    }

    public static final boolean i(e0 r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        return s.c(kotlin.s0.w.d.l0.n.t1.q.f21107a, r1);
    }
}
