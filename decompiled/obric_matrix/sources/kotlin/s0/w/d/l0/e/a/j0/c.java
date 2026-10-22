package kotlin.s0.w.d.l0.e.a.j0;

import java.util.Map;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.n0.d.o;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f19305a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.g.f f19306b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.g.f f19307c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.g.f f19308d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<kotlin.s0.w.d.l0.g.c, kotlin.s0.w.d.l0.g.c> f19309e = null;

    static {
        f19305a = new c();
        kotlin.s0.w.d.l0.g.f r0 = kotlin.s0.w.d.l0.g.f.k("message");
        o.e(r0, "identifier(\"message\")");
        f19306b = r0;
        kotlin.s0.w.d.l0.g.f r1 = kotlin.s0.w.d.l0.g.f.k("allowedTargets");
        o.e(r1, "identifier(\"allowedTargets\")");
        f19307c = r1;
        kotlin.s0.w.d.l0.g.f r2 = kotlin.s0.w.d.l0.g.f.k("value");
        o.e(r2, "identifier(\"value\")");
        f19308d = r2;
        f19309e = m0.k(new u[]{a0.a(kotlin.s0.w.d.l0.b.k.a.u, kotlin.s0.w.d.l0.e.a.a0.f19206c), a0.a(kotlin.s0.w.d.l0.b.k.a.x, kotlin.s0.w.d.l0.e.a.a0.f19207d), a0.a(kotlin.s0.w.d.l0.b.k.a.z, kotlin.s0.w.d.l0.e.a.a0.f19209f)});
    }

    private c() {
    }

    public static /* synthetic */ kotlin.s0.w.d.l0.c.o1.c f(c r0, kotlin.s0.w.d.l0.e.a.n0.a r1, kotlin.s0.w.d.l0.e.a.l0.g r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        return r0.e(r1, r2, r3);
    }

    public final kotlin.s0.w.d.l0.c.o1.c a(kotlin.s0.w.d.l0.g.c r7, kotlin.s0.w.d.l0.e.a.n0.d r8, kotlin.s0.w.d.l0.e.a.l0.g r9) {
        o.f(r7, "kotlinName");
        o.f(r8, "annotationOwner");
        o.f(r9, "c");
        if (o.a(r7, kotlin.s0.w.d.l0.b.k.a.n) == false) goto L10;
        kotlin.s0.w.d.l0.g.c r6 = kotlin.s0.w.d.l0.e.a.a0.f19208e;
        o.e(r6, "DEPRECATED_ANNOTATION");
        kotlin.s0.w.d.l0.e.a.n0.a r10 = r8.i(r6);
        if (r10 != null) goto L9;
        if (r8.l() == false) goto L10;
    L9:
        return new e(r10, r9);
    L10:
        kotlin.s0.w.d.l0.g.c r11 = f19309e.get(r7);
        if (r11 == null) goto L16;
        kotlin.s0.w.d.l0.e.a.n0.a r1 = r8.i(r11);
        if (r1 != null) goto L15;
        return null;
    L15:
        return f(f19305a, r1, r9, false, 4, null);
    L16:
        return null;
    }

    public final kotlin.s0.w.d.l0.g.f b() {
        return f19306b;
    }

    public final kotlin.s0.w.d.l0.g.f c() {
        return f19308d;
    }

    public final kotlin.s0.w.d.l0.g.f d() {
        return f19307c;
    }

    public final kotlin.s0.w.d.l0.c.o1.c e(kotlin.s0.w.d.l0.e.a.n0.a r2, kotlin.s0.w.d.l0.e.a.l0.g r3, boolean r4) {
        o.f(r2, "annotation");
        o.f(r3, "c");
        kotlin.s0.w.d.l0.g.b r1 = r2.f();
        if (o.a(r1, kotlin.s0.w.d.l0.g.b.m(kotlin.s0.w.d.l0.e.a.a0.f19206c)) == false) goto L6;
        return new i(r2, r3);
    L6:
        if (o.a(r1, kotlin.s0.w.d.l0.g.b.m(kotlin.s0.w.d.l0.e.a.a0.f19207d)) == false) goto L9;
        return new h(r2, r3);
    L9:
        if (o.a(r1, kotlin.s0.w.d.l0.g.b.m(kotlin.s0.w.d.l0.e.a.a0.f19209f)) == false) goto L12;
        return new b(r3, r2, kotlin.s0.w.d.l0.b.k.a.z);
    L12:
        if (o.a(r1, kotlin.s0.w.d.l0.g.b.m(kotlin.s0.w.d.l0.e.a.a0.f19208e)) == false) goto L15;
        return null;
    L15:
        return new kotlin.s0.w.d.l0.e.a.l0.l.e(r3, r2, r4);
    }
}
