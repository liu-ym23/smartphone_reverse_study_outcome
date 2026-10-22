package kotlin.s0.w.d.l0.e.a.j0;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.i0.t0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.o1.m;
import kotlin.s0.w.d.l0.c.o1.n;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f19310a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, EnumSet<n>> f19311b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, m> f19312c = null;

    static final class a extends q implements l<h0, e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f19313f = null;

        static {
            f19313f = new a();
        }

        a() {
            super(1);
        }

        public final e0 a(h0 r2) {
            o.f(r2, "module");
            j1 r1 = kotlin.s0.w.d.l0.e.a.j0.a.b(c.f19305a.d(), r2.o().o(kotlin.s0.w.d.l0.b.k.a.u));
            if (r1 == null) goto L5;
            e0 r3 = r1.b();
        L6:
            if (r3 == null) goto L8;
            return r3;
        L8:
            return kotlin.s0.w.d.l0.n.u1.k.d(kotlin.s0.w.d.l0.n.u1.j.I0, new String[0]);
        L5:
            r3 = null;
            goto L6
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ e0 invoke(h0 r1) {
            return a(r1);
        }
    }

    static {
        f19310a = new d();
        f19311b = m0.k(new u[]{a0.a("PACKAGE", EnumSet.noneOf(n.class)), a0.a("TYPE", EnumSet.of(n.u, n.H)), a0.a("ANNOTATION_TYPE", EnumSet.of(n.v)), a0.a("TYPE_PARAMETER", EnumSet.of(n.w)), a0.a("FIELD", EnumSet.of(n.y)), a0.a("LOCAL_VARIABLE", EnumSet.of(n.z)), a0.a("PARAMETER", EnumSet.of(n.A)), a0.a("CONSTRUCTOR", EnumSet.of(n.B)), a0.a("METHOD", EnumSet.of(n.C, n.D, n.E)), a0.a("TYPE_USE", EnumSet.of(n.F))});
        f19312c = m0.k(new u[]{a0.a("RUNTIME", m.f18934f), a0.a("CLASS", m.f18935g), a0.a("SOURCE", m.f18936h)});
    }

    private d() {
    }

    public final kotlin.s0.w.d.l0.k.r.g<?> a(kotlin.s0.w.d.l0.e.a.n0.b r3) {
        if ((r3 instanceof kotlin.s0.w.d.l0.e.a.n0.m) == false) goto L5;
        kotlin.s0.w.d.l0.e.a.n0.m r4 = (kotlin.s0.w.d.l0.e.a.n0.m) r3;
    L6:
        if (r4 == null) goto L15;
        Map<String, m> r2 = f19312c;
        kotlin.s0.w.d.l0.g.f r5 = r4.d();
        if (r5 == null) goto L10;
        String r6 = r5.b();
    L11:
        m r7 = r2.get(r6);
        if (r7 == null) goto L16;
        kotlin.s0.w.d.l0.g.b r0 = kotlin.s0.w.d.l0.g.b.m(kotlin.s0.w.d.l0.b.k.a.w);
        o.e(r0, "topLevel(StandardNames.F…ames.annotationRetention)");
        kotlin.s0.w.d.l0.g.f r8 = kotlin.s0.w.d.l0.g.f.k(r7.name());
        o.e(r8, "identifier(retention.name)");
        return new kotlin.s0.w.d.l0.k.r.j(r0, r8);
    L16:
        return null;
    L10:
        r6 = null;
        goto L11
    L15:
        return null;
    L5:
        r4 = null;
        goto L6
    }

    public final Set<n> b(String r1) {
        EnumSet<n> r0 = f19311b.get(r1);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return t0.b();
    }

    public final kotlin.s0.w.d.l0.k.r.g<?> c(List<? extends kotlin.s0.w.d.l0.e.a.n0.b> r5) {
        o.f(r5, "arguments");
        ArrayList r4 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r0 = r6.next();
        if ((r0 instanceof kotlin.s0.w.d.l0.e.a.n0.m) == false) goto L4;
        r4.add(r0);
        goto L4
    L8:
        ArrayList r7 = new ArrayList();
        Iterator r8 = r4.iterator();
    L10:
        if (r8.hasNext() == false) goto L16;
        kotlin.s0.w.d.l0.e.a.n0.m r1 = (kotlin.s0.w.d.l0.e.a.n0.m) r8.next();
        d r2 = f19310a;
        kotlin.s0.w.d.l0.g.f r3 = r1.d();
        if (r3 == null) goto L14;
        String r9 = r3.b();
    L15:
        r.v(r7, r2.b(r9));
        goto L10
    L14:
        r9 = null;
        goto L15
    L16:
        ArrayList r10 = new ArrayList(r.q(r7, 10));
        Iterator r11 = r7.iterator();
    L18:
        if (r11.hasNext() == false) goto L21;
        n r12 = (n) r11.next();
        kotlin.s0.w.d.l0.g.b r13 = kotlin.s0.w.d.l0.g.b.m(kotlin.s0.w.d.l0.b.k.a.v);
        o.e(r13, "topLevel(StandardNames.FqNames.annotationTarget)");
        kotlin.s0.w.d.l0.g.f r14 = kotlin.s0.w.d.l0.g.f.k(r12.name());
        o.e(r14, "identifier(kotlinTarget.name)");
        r10.add(new kotlin.s0.w.d.l0.k.r.j(r13, r14));
        goto L18
    L21:
        return new kotlin.s0.w.d.l0.k.r.b(r10, a.f19313f);
    }
}
