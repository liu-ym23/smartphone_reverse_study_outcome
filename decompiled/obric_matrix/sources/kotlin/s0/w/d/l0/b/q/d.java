package kotlin.s0.w.d.l0.b.q;

import java.util.Collection;
import kotlin.i0.r;
import kotlin.i0.t0;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.b.k;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f18786a = null;

    static {
        f18786a = new d();
    }

    private d() {
    }

    public static /* synthetic */ kotlin.s0.w.d.l0.c.e f(d r0, kotlin.s0.w.d.l0.g.c r1, kotlin.s0.w.d.l0.b.h r2, Integer r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.e(r1, r2, r3);
    }

    public final kotlin.s0.w.d.l0.c.e a(kotlin.s0.w.d.l0.c.e r4) {
        o.f(r4, "mutable");
        kotlin.s0.w.d.l0.g.c r0 = c.f18771a.o(kotlin.s0.w.d.l0.k.d.m(r4));
        if (r0 == null) goto L7;
        kotlin.s0.w.d.l0.c.e r3 = kotlin.s0.w.d.l0.k.t.a.f(r4).o(r0);
        o.e(r3, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
        return r3;
    L7:
        throw new IllegalArgumentException("Given class " + r4 + " is not a mutable collection");
    }

    public final kotlin.s0.w.d.l0.c.e b(kotlin.s0.w.d.l0.c.e r3) {
        o.f(r3, "readOnly");
        kotlin.s0.w.d.l0.g.c r2 = c.f18771a.p(kotlin.s0.w.d.l0.k.d.m(r3));
        if (r2 == null) goto L7;
        kotlin.s0.w.d.l0.c.e r4 = kotlin.s0.w.d.l0.k.t.a.f(r3).o(r2);
        o.e(r4, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
        return r4;
    L7:
        throw new IllegalArgumentException("Given class " + r3 + " is not a read-only collection");
    }

    public final boolean c(kotlin.s0.w.d.l0.c.e r1) {
        o.f(r1, "mutable");
        return c.f18771a.k(kotlin.s0.w.d.l0.k.d.m(r1));
    }

    public final boolean d(kotlin.s0.w.d.l0.c.e r1) {
        o.f(r1, "readOnly");
        return c.f18771a.l(kotlin.s0.w.d.l0.k.d.m(r1));
    }

    public final kotlin.s0.w.d.l0.c.e e(kotlin.s0.w.d.l0.g.c r1, kotlin.s0.w.d.l0.b.h r2, Integer r3) {
        o.f(r1, "fqName");
        o.f(r2, "builtIns");
        if (r3 != null) goto L5;
    L7:
        kotlin.s0.w.d.l0.g.b r0 = c.f18771a.m(r1);
    L8:
        if (r0 != null) goto L12;
        return null;
    L12:
        return r2.o(r0.b());
    L5:
        if (o.a(r1, c.f18771a.h()) == false) goto L7;
        r0 = k.a(r3.intValue());
        goto L8
    }

    public final Collection<kotlin.s0.w.d.l0.c.e> g(kotlin.s0.w.d.l0.g.c r8, kotlin.s0.w.d.l0.b.h r9) {
        o.f(r8, "fqName");
        o.f(r9, "builtIns");
        kotlin.s0.w.d.l0.c.e r7 = f(this, r8, r9, null, 4, null);
        if (r7 == null) goto L5;
        kotlin.s0.w.d.l0.g.c r10 = c.f18771a.p(kotlin.s0.w.d.l0.k.t.a.i(r7));
        if (r10 == null) goto L9;
        kotlin.s0.w.d.l0.c.e r11 = r9.o(r10);
        o.e(r11, "builtIns.getBuiltInClass…otlinMutableAnalogFqName)");
        return r.j(new kotlin.s0.w.d.l0.c.e[]{r7, r11});
    L9:
        return t0.a(r7);
    L5:
        return t0.b();
    }
}
