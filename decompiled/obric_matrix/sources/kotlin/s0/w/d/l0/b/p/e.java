package kotlin.s0.w.d.l0.b.p;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.i0.r;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.e0;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.m;
import kotlin.s0.w.d.l0.c.q1.g0;
import kotlin.s0.w.d.l0.c.q1.l0;
import kotlin.s0.w.d.l0.c.q1.p;
import kotlin.s0.w.d.l0.c.t;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.c.y;
import kotlin.s0.w.d.l0.g.f;
import kotlin.s0.w.d.l0.n.l1;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.r1;
import kotlin.s0.w.d.l0.o.q;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends g0 {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final a f18766J = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }

        private final j1 b(e r15, int r16, f1 r17) {
            String r0 = r17.getName().b();
            o.e(r0, "typeParameter.name.asString()");
            if (o.a(r0, "T") == false) goto L6;
            String r1 = "instance";
        L9:
            kotlin.s0.w.d.l0.c.o1.g r5 = kotlin.s0.w.d.l0.c.o1.g.f18919b.b();
            f r6 = f.k(r1);
            o.e(r6, "identifier(name)");
            m0 r7 = r17.s();
            o.e(r7, "typeParameter.defaultType");
            a1 r12 = a1.f18847a;
            o.e(r12, "NO_SOURCE");
            return new l0(r15, null, r16, r5, r6, r7, false, false, false, null, r12);
        L6:
            if (o.a(r0, "E") == false) goto L8;
            r1 = "receiver";
            goto L9
        L8:
            r1 = r0.toLowerCase(Locale.ROOT);
            o.e(r1, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            goto L9
        }

        public final e a(b r12, boolean r13) {
            o.f(r12, "functionClass");
            List<f1> r11 = r12.u();
            e r9 = new e(r12, null, kotlin.s0.w.d.l0.c.b.a.f18848f, r13, null);
            x0 r2 = r12.K0();
            List<x0> r3 = r.g();
            List<? extends f1> r4 = r.g();
            ArrayList r14 = new ArrayList();
            Iterator<T> r15 = r11.iterator();
        L4:
            if (r15.hasNext() == false) goto L12;
            Object r0 = r15.next();
            if (((f1) r0).n() != r1.f21066i) goto L8;
            boolean r1 = true;
        L9:
            if (r1 == false) goto L12;
            r14.add(r0);
            goto L4
        L8:
            r1 = false;
        L12:
            Iterable r16 = r.F0(r14);
            ArrayList r5 = new ArrayList(r.q(r16, 10));
            Iterator r17 = r16.iterator();
        L14:
            if (r17.hasNext() == false) goto L16;
            kotlin.i0.g0 r18 = (kotlin.i0.g0) r17.next();
            r5.add(e.f18766J.b(r9, r18.c(), (f1) r18.d()));
            goto L14
        L16:
            r9.o1(null, r2, r3, r4, r5, ((f1) r.b0(r11)).s(), e0.f18863j, t.f19163e);
            r9.a1(true);
            return r9;
        }
    }

    static {
        f18766J = new a(null);
    }

    private e(m r9, e r10, kotlin.s0.w.d.l0.c.b.a r11, boolean r12) {
        super(r9, r10, kotlin.s0.w.d.l0.c.o1.g.f18919b.b(), q.f21248g, r11, a1.f18847a);
        g1(true);
        i1(r12);
        Z0(false);
    }

    public /* synthetic */ e(m r1, e r2, kotlin.s0.w.d.l0.c.b.a r3, boolean r4, g r5) {
        this(r1, r2, r3, r4);
    }

    private final y q1(List<f> r10) {
        int r0 = h().size() - r10.size();
        boolean r1 = true;
        if (r0 != 0) goto L17;
        List<j1> r4 = h();
        o.e(r4, "valueParameters");
        List r5 = r.G0(r10, r4);
        if ((r5 instanceof Collection) == true) goto L7;
    L9:
        Iterator r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L8;
        u r7 = (u) r6.next();
        if (o.a((f) r7.a(), ((j1) r7.b()).getName()) == true) goto L11;
        boolean r8 = false;
    L15:
        if (r8 == false) goto L17;
        return this;
    L8:
        r8 = true;
        goto L15
    L7:
        if (r5.isEmpty() == false) goto L9;
    L17:
        List<j1> r9 = h();
        o.e(r9, "valueParameters");
        ArrayList r2 = new ArrayList(r.q(r9, 10));
        Iterator<T> r11 = r9.iterator();
    L19:
        if (r11.hasNext() == false) goto L26;
        j1 r12 = (j1) r11.next();
        f r13 = r12.getName();
        o.e(r13, "it.name");
        int r14 = r12.j();
        int r15 = r14 - r0;
        if (r15 < 0) goto L25;
        f r16 = r10.get(r15);
        if (r16 == null) goto L25;
        r13 = r16;
    L25:
        r2.add(r12.H0(this, r13, r14));
        goto L19
    L26:
        p.c r3 = T0(l1.f21038b);
        if ((r10 instanceof Collection) == true) goto L29;
    L31:
        Iterator<T> r17 = r10.iterator();
    L33:
        if (r17.hasNext() == false) goto L30;
        if (((f) r17.next()) != null) goto L37;
        boolean r18 = true;
    L38:
        if (r18 == false) goto L33;
    L39:
        r3.G(r1);
        r3.U(r2);
        r3.N(n1());
        o.e(r3, "newCopyBuilder(TypeSubst…   .setOriginal(original)");
        y r19 = super.N0(r3);
        o.c(r19);
        return r19;
    L37:
        r18 = false;
    L30:
        r1 = false;
        goto L39
    L29:
        if (r10.isEmpty() == false) goto L31;
        goto L30
    }

    @Override // kotlin.s0.w.d.l0.c.q1.g0, kotlin.s0.w.d.l0.c.q1.p
    protected p M0(m r1, y r2, kotlin.s0.w.d.l0.c.b.a r3, f r4, kotlin.s0.w.d.l0.c.o1.g r5, a1 r6) {
        o.f(r1, "newOwner");
        o.f(r3, "kind");
        o.f(r5, "annotations");
        o.f(r6, "source");
        return new e(r1, (e) r2, r3, isSuspend());
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p
    protected y N0(p.c r6) {
        o.f(r6, "configuration");
        e r5 = (e) super.N0(r6);
        if (r5 != null) goto L6;
        return null;
    L6:
        List<j1> r7 = r5.h();
        o.e(r7, "substituted.valueParameters");
        boolean r2 = false;
        if ((r7 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r8 = r7.iterator();
    L13:
        if (r8.hasNext() == false) goto L10;
        kotlin.s0.w.d.l0.n.e0 r1 = ((j1) r8.next()).b();
        o.e(r1, "it.type");
        if (kotlin.s0.w.d.l0.b.g.d(r1) == null) goto L17;
        boolean r3 = true;
    L18:
        if (r3 == false) goto L13;
    L19:
        if (r2 == false) goto L21;
        return r5;
    L21:
        List<j1> r9 = r5.h();
        o.e(r9, "substituted.valueParameters");
        ArrayList r0 = new ArrayList(r.q(r9, 10));
        Iterator<T> r10 = r9.iterator();
    L23:
        if (r10.hasNext() == false) goto L26;
        kotlin.s0.w.d.l0.n.e0 r4 = ((j1) r10.next()).b();
        o.e(r4, "it.type");
        r0.add(kotlin.s0.w.d.l0.b.g.d(r4));
        goto L23
    L26:
        return r5.q1(r0);
    L17:
        r3 = false;
    L10:
        r2 = true;
        goto L19
    L9:
        if (r7.isEmpty() == false) goto L11;
        goto L10
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.y
    public boolean P() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.d0
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.y
    public boolean isInline() {
        return false;
    }
}
