package kotlin.s0.w.d.l0.n.u1;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.i0.r;
import kotlin.i0.t0;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.c.m;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.e1;
import kotlin.s0.w.d.l0.n.g1;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f21165a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final h0 f21166b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a f21167c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final e0 f21168d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final e0 f21169e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final u0 f21170f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Set<u0> f21171g = null;

    static {
        f21165a = new k();
        f21166b = d.f21133f;
        String r1 = String.format(b.f21125g.b(), Arrays.copyOf(new Object[]{"unknown class"}, 1));
        o.e(r1, "format(this, *args)");
        kotlin.s0.w.d.l0.g.f r2 = kotlin.s0.w.d.l0.g.f.n(r1);
        o.e(r2, "special(ErrorEntity.ERRO….format(\"unknown class\"))");
        f21167c = new a(r2);
        f21168d = d(j.A, new String[0]);
        f21169e = d(j.x0, new String[0]);
        e r0 = new e();
        f21170f = r0;
        f21171g = t0.a(r0);
    }

    private k() {
    }

    public static final f a(g r1, boolean r2, String... r3) {
        o.f(r1, "kind");
        o.f(r3, "formatParams");
        if (r2 == false) goto L6;
        return new l(r1, (String[]) Arrays.copyOf(r3, r3.length));
    L6:
        return new f(r1, (String[]) Arrays.copyOf(r3, r3.length));
    }

    public static final f b(g r1, String... r2) {
        o.f(r1, "kind");
        o.f(r2, "formatParams");
        return a(r1, false, (String[]) Arrays.copyOf(r2, r2.length));
    }

    public static final h d(j r3, String... r4) {
        o.f(r3, "kind");
        o.f(r4, "formatParams");
        return f21165a.g(r3, r.g(), (String[]) Arrays.copyOf(r4, r4.length));
    }

    public static final boolean m(m r2) {
        if (r2 == null) goto L10;
        k r0 = f21165a;
        if (r0.n(r2) == false) goto L6;
    L9:
        return true;
    L6:
        if (r0.n(r2.c()) == true) goto L9;
        if (r2 == f21166b) goto L9;
    L10:
        return false;
    }

    private final boolean n(m r1) {
        return r1 instanceof a;
    }

    public static final boolean o(e0 r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        e1 r3 = r2.O0();
        if ((r3 instanceof i) == true) goto L8;
        return false;
    L8:
        if (((i) r3).g() != j.D) goto L12;
        return true;
    L12:
        return false;
    }

    public final h c(j r3, e1 r4, String... r5) {
        o.f(r3, "kind");
        o.f(r4, "typeConstructor");
        o.f(r5, "formatParams");
        return f(r3, r.g(), r4, (String[]) Arrays.copyOf(r5, r5.length));
    }

    public final i e(j r2, String... r3) {
        o.f(r2, "kind");
        o.f(r3, "formatParams");
        return new i(r2, (String[]) Arrays.copyOf(r3, r3.length));
    }

    public final h f(j r8, List<? extends g1> r9, e1 r10, String... r11) {
        o.f(r8, "kind");
        o.f(r9, "arguments");
        o.f(r10, "typeConstructor");
        o.f(r11, "formatParams");
        return new h(r10, b(g.m, new String[]{r10.toString()}), r8, r9, false, (String[]) Arrays.copyOf(r11, r11.length));
    }

    public final h g(j r3, List<? extends g1> r4, String... r5) {
        o.f(r3, "kind");
        o.f(r4, "arguments");
        o.f(r5, "formatParams");
        return f(r3, r4, e(r3, (String[]) Arrays.copyOf(r5, r5.length)), (String[]) Arrays.copyOf(r5, r5.length));
    }

    public final a h() {
        return f21167c;
    }

    public final h0 i() {
        return f21166b;
    }

    public final Set<u0> j() {
        return f21171g;
    }

    public final e0 k() {
        return f21169e;
    }

    public final e0 l() {
        return f21168d;
    }
}
