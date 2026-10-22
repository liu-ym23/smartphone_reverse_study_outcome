package kotlin.s0.w.d.l0.e.a;

import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.c.j1;

/* JADX INFO: loaded from: classes2.dex */
public final class s implements kotlin.s0.w.d.l0.k.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19639a = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        private final boolean b(kotlin.s0.w.d.l0.c.y r5) {
            if (r5.h().size() == 1) goto L5;
            return false;
        L5:
            kotlin.s0.w.d.l0.c.m r4 = r5.c();
            kotlin.s0.w.d.l0.c.e r3 = null;
            if ((r4 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L8;
            kotlin.s0.w.d.l0.c.e r6 = (kotlin.s0.w.d.l0.c.e) r4;
        L9:
            if (r6 != null) goto L11;
            return false;
        L11:
            List<j1> r7 = r5.h();
            kotlin.n0.d.o.e(r7, "f.valueParameters");
            kotlin.s0.w.d.l0.c.h r8 = ((j1) kotlin.i0.r.o0(r7)).b().O0().d();
            if ((r8 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L14;
            r3 = (kotlin.s0.w.d.l0.c.e) r8;
        L14:
            if (r3 != null) goto L17;
            return false;
        L17:
            if (kotlin.s0.w.d.l0.b.h.q0(r6) == false) goto L22;
            if (kotlin.n0.d.o.a(kotlin.s0.w.d.l0.k.t.a.h(r6), kotlin.s0.w.d.l0.k.t.a.h(r3)) == false) goto L22;
            return true;
        L22:
            return false;
        L8:
            r6 = null;
            goto L9
        }

        private final kotlin.s0.w.d.l0.e.b.l c(kotlin.s0.w.d.l0.c.y r3, j1 r4) {
            if (kotlin.s0.w.d.l0.e.b.v.e(r3) == false) goto L5;
        L8:
            kotlin.s0.w.d.l0.n.e0 r2 = r4.b();
            kotlin.n0.d.o.e(r2, "valueParameterDescriptor.type");
            kotlin.s0.w.d.l0.n.e0 r5 = kotlin.s0.w.d.l0.n.x1.a.t(r2);
        L10:
            return kotlin.s0.w.d.l0.e.b.v.g(r5);
        L5:
            if (b(r3) == true) goto L8;
            r5 = r4.b();
            kotlin.n0.d.o.e(r5, "valueParameterDescriptor.type");
            goto L10
        }

        public final boolean a(kotlin.s0.w.d.l0.c.a r7, kotlin.s0.w.d.l0.c.a r8) {
            kotlin.n0.d.o.f(r7, "superDescriptor");
            kotlin.n0.d.o.f(r8, "subDescriptor");
            if ((r8 instanceof kotlin.s0.w.d.l0.e.a.k0.e) == true) goto L5;
        L14:
            return false;
        L5:
            if ((r7 instanceof kotlin.s0.w.d.l0.c.y) == false) goto L14;
            kotlin.s0.w.d.l0.e.a.k0.e r0 = (kotlin.s0.w.d.l0.e.a.k0.e) r8;
            r0.h().size();
            kotlin.s0.w.d.l0.c.y r9 = (kotlin.s0.w.d.l0.c.y) r7;
            r9.h().size();
            List<j1> r1 = r0.n1().h();
            kotlin.n0.d.o.e(r1, "subDescriptor.original.valueParameters");
            List<j1> r2 = r9.a().h();
            kotlin.n0.d.o.e(r2, "superDescriptor.original.valueParameters");
            Iterator r3 = kotlin.i0.r.G0(r1, r2).iterator();
        L9:
            if (r3.hasNext() == false) goto L14;
            kotlin.u r4 = (kotlin.u) r3.next();
            j1 r5 = (j1) r4.a();
            j1 r6 = (j1) r4.b();
            kotlin.n0.d.o.e(r5, "subParameter");
            boolean r10 = c((kotlin.s0.w.d.l0.c.y) r8, r5) instanceof kotlin.s0.w.d.l0.e.b.l.d;
            kotlin.n0.d.o.e(r6, "superParameter");
            if (r10 == (c(r9, r6) instanceof kotlin.s0.w.d.l0.e.b.l.d)) goto L9;
            return true;
        }
    }

    static {
        f19639a = new a(null);
    }

    public s() {
    }

    private final boolean c(kotlin.s0.w.d.l0.c.a r7, kotlin.s0.w.d.l0.c.a r8, kotlin.s0.w.d.l0.c.e r9) {
        if ((r7 instanceof kotlin.s0.w.d.l0.c.b) == true) goto L5;
    L48:
        return false;
    L5:
        if ((r8 instanceof kotlin.s0.w.d.l0.c.y) == false) goto L48;
        if (kotlin.s0.w.d.l0.b.h.f0(r8) == true) goto L48;
        f r6 = f.m;
        kotlin.s0.w.d.l0.c.y r10 = (kotlin.s0.w.d.l0.c.y) r8;
        kotlin.s0.w.d.l0.g.f r1 = r10.getName();
        kotlin.n0.d.o.e(r1, "subDescriptor.name");
        if (r6.l(r1) == true) goto L14;
        h0.a r11 = h0.f19266a;
        kotlin.s0.w.d.l0.g.f r2 = r10.getName();
        kotlin.n0.d.o.e(r2, "subDescriptor.name");
        if (r11.k(r2) == true) goto L14;
        return false;
    L14:
        kotlin.s0.w.d.l0.c.b r12 = g0.e((kotlin.s0.w.d.l0.c.b) r7);
        boolean r3 = r7 instanceof kotlin.s0.w.d.l0.c.y;
        if (r3 == false) goto L17;
        kotlin.s0.w.d.l0.c.y r4 = (kotlin.s0.w.d.l0.c.y) r7;
    L19:
        if (r4 != null) goto L21;
    L23:
        boolean r5 = false;
    L25:
        if ((!r5) == false) goto L31;
        if (r12 != null) goto L28;
    L29:
        return true;
    L28:
        if (r10.w0() == false) goto L29;
    L31:
        if ((r9 instanceof kotlin.s0.w.d.l0.e.a.k0.c) == false) goto L48;
        if (r10.d0() != null) goto L48;
        if (r12 == null) goto L48;
        if (g0.f(r9, r12) == true) goto L48;
        if ((r12 instanceof kotlin.s0.w.d.l0.c.y) == false) goto L47;
        if (r3 == false) goto L47;
        if (f.k((kotlin.s0.w.d.l0.c.y) r12) == null) goto L47;
        String r13 = kotlin.s0.w.d.l0.e.b.v.c(r10, false, false, 2, null);
        kotlin.s0.w.d.l0.c.y r14 = ((kotlin.s0.w.d.l0.c.y) r7).a();
        kotlin.n0.d.o.e(r14, "superDescriptor.original");
        if (kotlin.n0.d.o.a(r13, kotlin.s0.w.d.l0.e.b.v.c(r14, false, false, 2, null)) == false) goto L47;
        return false;
    L47:
        return true;
    L21:
        if (r10.w0() != r4.w0()) goto L23;
        r5 = true;
        goto L25
    L17:
        r4 = null;
        goto L19
    }

    @Override // kotlin.s0.w.d.l0.k.e
    public kotlin.s0.w.d.l0.k.e.a a() {
        return kotlin.s0.w.d.l0.k.e.a.f20515f;
    }

    @Override // kotlin.s0.w.d.l0.k.e
    public kotlin.s0.w.d.l0.k.e.b b(kotlin.s0.w.d.l0.c.a r2, kotlin.s0.w.d.l0.c.a r3, kotlin.s0.w.d.l0.c.e r4) {
        kotlin.n0.d.o.f(r2, "superDescriptor");
        kotlin.n0.d.o.f(r3, "subDescriptor");
        if (c(r2, r3, r4) == false) goto L7;
        return kotlin.s0.w.d.l0.k.e.b.f20521h;
    L7:
        if (f19639a.a(r2, r3) == false) goto L11;
        return kotlin.s0.w.d.l0.k.e.b.f20521h;
    L11:
        return kotlin.s0.w.d.l0.k.e.b.f20522i;
    }
}
