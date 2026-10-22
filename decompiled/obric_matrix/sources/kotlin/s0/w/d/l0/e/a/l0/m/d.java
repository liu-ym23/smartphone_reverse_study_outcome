package kotlin.s0.w.d.l0.e.a.l0.m;

import java.util.Set;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.e.a.j0.k;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.i1;
import kotlin.s0.w.d.l0.n.s0;
import kotlin.s0.w.d.l0.n.t0;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.g.c f19505a = null;

    static {
        f19505a = new kotlin.s0.w.d.l0.g.c("java.lang.Class");
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.g.c a() {
        return f19505a;
    }

    public static final g1 b(f1 r1, a r2) {
        o.f(r1, "typeParameter");
        o.f(r2, "attr");
        if (r2.e() != k.f19332f) goto L6;
        return new i1(t0.b(r1));
    L6:
        return new s0(r1);
    }

    public static final a c(k r8, boolean r9, f1 r10) {
        o.f(r8, "<this>");
        if (r10 == null) goto L5;
        Set r11 = kotlin.i0.t0.a(r10);
    L7:
        return new a(r8, null, r9, r11, null, 18, null);
    L5:
        r11 = null;
        goto L7
    }

    public static /* synthetic */ a d(k r0, boolean r1, f1 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = null;
    L9:
        return c(r0, r1, r2);
    }
}
