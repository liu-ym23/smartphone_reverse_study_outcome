package kotlin.s0.w.d.l0.k;

import kotlin.s0.w.d.l0.c.k1;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.v0;
import kotlin.s0.w.d.l0.c.z;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.g.c f20524a = null;

    static {
        kotlin.s0.w.d.l0.g.c r0 = new kotlin.s0.w.d.l0.g.c("kotlin.jvm.JvmInline");
        f20524a = r0;
        kotlin.n0.d.o.e(kotlin.s0.w.d.l0.g.b.m(r0), "topLevel(JVM_INLINE_ANNOTATION_FQ_NAME)");
    }

    public static final boolean a(kotlin.s0.w.d.l0.c.a r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        if ((r1 instanceof v0) == false) goto L7;
        u0 r2 = ((v0) r1).B0();
        kotlin.n0.d.o.e(r2, "correspondingProperty");
        if (d(r2) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public static final boolean b(kotlin.s0.w.d.l0.c.m r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        if ((r1 instanceof kotlin.s0.w.d.l0.c.e) == true) goto L5;
    L7:
        return false;
    L5:
        if ((((kotlin.s0.w.d.l0.c.e) r1).z0() instanceof z) == false) goto L7;
        return true;
    }

    public static final boolean c(e0 r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.s0.w.d.l0.c.h r2 = r1.O0().d();
        if (r2 != null) goto L7;
        return false;
    L7:
        return b(r2);
    }

    public static final boolean d(k1 r3) {
        kotlin.n0.d.o.f(r3, "<this>");
        if (r3.m0() != null) goto L15;
        kotlin.s0.w.d.l0.c.m r0 = r3.c();
        kotlin.s0.w.d.l0.g.f r2 = null;
        if ((r0 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L7;
        kotlin.s0.w.d.l0.c.e r1 = (kotlin.s0.w.d.l0.c.e) r0;
    L8:
        if (r1 == null) goto L13;
        z<m0> r4 = kotlin.s0.w.d.l0.k.t.a.j(r1);
        if (r4 == null) goto L13;
        r2 = r4.c();
    L13:
        if (kotlin.n0.d.o.a(r2, r3.getName()) == false) goto L15;
        return true;
    L7:
        r1 = null;
    L15:
        return false;
    }

    public static final e0 e(e0 r2) {
        kotlin.n0.d.o.f(r2, "<this>");
        kotlin.s0.w.d.l0.c.h r3 = r2.O0().d();
        if ((r3 instanceof kotlin.s0.w.d.l0.c.e) == true) goto L5;
        r3 = null;
    L5:
        kotlin.s0.w.d.l0.c.e r4 = (kotlin.s0.w.d.l0.c.e) r3;
        if (r4 == null) goto L11;
        z<m0> r5 = kotlin.s0.w.d.l0.k.t.a.j(r4);
        if (r5 != null) goto L10;
        return null;
    L10:
        return (m0) r5.d();
    L11:
        return null;
    }
}
