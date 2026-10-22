package kotlin.s0.w.d.l0.l.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.c.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements c<kotlin.s0.w.d.l0.c.o1.c, kotlin.s0.w.d.l0.k.r.g<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.l.a f20703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f20704b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20705a = null;

        static {
            int[] r0 = new int[b.values().length];
            r0[b.f20696g.ordinal()] = 1;
            r0[b.f20697h.ordinal()] = 2;
            r0[b.f20698i.ordinal()] = 3;
            f20705a = r0;
        }
    }

    public d(h0 r2, k0 r3, kotlin.s0.w.d.l0.l.a r4) {
        kotlin.n0.d.o.f(r2, "module");
        kotlin.n0.d.o.f(r3, "notFoundClasses");
        kotlin.n0.d.o.f(r4, "protocol");
        this.f20703a = r4;
        this.f20704b = new e(r2, r3);
    }

    @Override // kotlin.s0.w.d.l0.l.b.f
    public List<kotlin.s0.w.d.l0.c.o1.c> a(kotlin.s0.w.d.l0.f.s r4, kotlin.s0.w.d.l0.f.z.c r5) {
        kotlin.n0.d.o.f(r4, "proto");
        kotlin.n0.d.o.f(r5, "nameResolver");
        List r6 = (List) r4.t(this.f20703a.l());
        if (r6 != null) goto L5;
        r6 = kotlin.i0.r.g();
    L5:
        ArrayList r0 = new ArrayList(kotlin.i0.r.q(r6, 10));
        Iterator r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        kotlin.s0.w.d.l0.f.b r1 = (kotlin.s0.w.d.l0.f.b) r7.next();
        r0.add(this.f20704b.a(r1, r5));
        goto L7
    L9:
        return r0;
    }

    @Override // kotlin.s0.w.d.l0.l.b.f
    public List<kotlin.s0.w.d.l0.c.o1.c> b(z r2, kotlin.s0.w.d.l0.i.q r3, b r4, int r5, kotlin.s0.w.d.l0.f.u r6) {
        kotlin.n0.d.o.f(r2, "container");
        kotlin.n0.d.o.f(r3, "callableProto");
        kotlin.n0.d.o.f(r4, "kind");
        kotlin.n0.d.o.f(r6, "proto");
        List r7 = (List) r6.t(this.f20703a.g());
        if (r7 != null) goto L5;
        r7 = kotlin.i0.r.g();
    L5:
        ArrayList r8 = new ArrayList(kotlin.i0.r.q(r7, 10));
        Iterator r9 = r7.iterator();
    L7:
        if (r9.hasNext() == false) goto L9;
        kotlin.s0.w.d.l0.f.b r10 = (kotlin.s0.w.d.l0.f.b) r9.next();
        r8.add(this.f20704b.a(r10, r2.b()));
        goto L7
    L9:
        return r8;
    }

    @Override // kotlin.s0.w.d.l0.l.b.f
    public List<kotlin.s0.w.d.l0.c.o1.c> c(z.a r6) {
        kotlin.n0.d.o.f(r6, "container");
        List r0 = (List) r6.f().t(this.f20703a.a());
        if (r0 != null) goto L5;
        r0 = kotlin.i0.r.g();
    L5:
        ArrayList r1 = new ArrayList(kotlin.i0.r.q(r0, 10));
        Iterator r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        kotlin.s0.w.d.l0.f.b r3 = (kotlin.s0.w.d.l0.f.b) r2.next();
        r1.add(this.f20704b.a(r3, r6.b()));
        goto L7
    L9:
        return r1;
    }

    @Override // kotlin.s0.w.d.l0.l.b.f
    public List<kotlin.s0.w.d.l0.c.o1.c> d(kotlin.s0.w.d.l0.f.q r4, kotlin.s0.w.d.l0.f.z.c r5) {
        kotlin.n0.d.o.f(r4, "proto");
        kotlin.n0.d.o.f(r5, "nameResolver");
        List r6 = (List) r4.t(this.f20703a.k());
        if (r6 != null) goto L5;
        r6 = kotlin.i0.r.g();
    L5:
        ArrayList r0 = new ArrayList(kotlin.i0.r.q(r6, 10));
        Iterator r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        kotlin.s0.w.d.l0.f.b r1 = (kotlin.s0.w.d.l0.f.b) r7.next();
        r0.add(this.f20704b.a(r1, r5));
        goto L7
    L9:
        return r0;
    }

    @Override // kotlin.s0.w.d.l0.l.b.c
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.k.r.g<?> e(z r1, kotlin.s0.w.d.l0.f.n r2, kotlin.s0.w.d.l0.n.e0 r3) {
        return m(r1, r2, r3);
    }

    @Override // kotlin.s0.w.d.l0.l.b.f
    public List<kotlin.s0.w.d.l0.c.o1.c> f(z r5, kotlin.s0.w.d.l0.f.g r6) {
        kotlin.n0.d.o.f(r5, "container");
        kotlin.n0.d.o.f(r6, "proto");
        List r7 = (List) r6.t(this.f20703a.d());
        if (r7 != null) goto L5;
        r7 = kotlin.i0.r.g();
    L5:
        ArrayList r0 = new ArrayList(kotlin.i0.r.q(r7, 10));
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L9;
        kotlin.s0.w.d.l0.f.b r1 = (kotlin.s0.w.d.l0.f.b) r8.next();
        r0.add(this.f20704b.a(r1, r5.b()));
        goto L7
    L9:
        return r0;
    }

    @Override // kotlin.s0.w.d.l0.l.b.f
    public List<kotlin.s0.w.d.l0.c.o1.c> g(z r1, kotlin.s0.w.d.l0.f.n r2) {
        kotlin.n0.d.o.f(r1, "container");
        kotlin.n0.d.o.f(r2, "proto");
        return kotlin.i0.r.g();
    }

    @Override // kotlin.s0.w.d.l0.l.b.f
    public List<kotlin.s0.w.d.l0.c.o1.c> h(z r1, kotlin.s0.w.d.l0.i.q r2, b r3) {
        kotlin.n0.d.o.f(r1, "container");
        kotlin.n0.d.o.f(r2, "proto");
        kotlin.n0.d.o.f(r3, "kind");
        return kotlin.i0.r.g();
    }

    @Override // kotlin.s0.w.d.l0.l.b.f
    public List<kotlin.s0.w.d.l0.c.o1.c> i(z r1, kotlin.s0.w.d.l0.f.n r2) {
        kotlin.n0.d.o.f(r1, "container");
        kotlin.n0.d.o.f(r2, "proto");
        return kotlin.i0.r.g();
    }

    @Override // kotlin.s0.w.d.l0.l.b.f
    public List<kotlin.s0.w.d.l0.c.o1.c> j(z r4, kotlin.s0.w.d.l0.i.q r5, b r6) {
        kotlin.n0.d.o.f(r4, "container");
        kotlin.n0.d.o.f(r5, "proto");
        kotlin.n0.d.o.f(r6, "kind");
        if ((r5 instanceof kotlin.s0.w.d.l0.f.d) == false) goto L7;
        kotlin.s0.w.d.l0.i.i.d r7 = (kotlin.s0.w.d.l0.f.d) r5;
        Object r8 = this.f20703a.c();
    L5:
        List r9 = (List) r7.t(r8);
        if (r9 != null) goto L24;
        r9 = kotlin.i0.r.g();
    L24:
        ArrayList r10 = new ArrayList(kotlin.i0.r.q(r9, 10));
        Iterator r11 = r9.iterator();
    L26:
        if (r11.hasNext() == false) goto L28;
        r10.add(this.f20704b.a((kotlin.s0.w.d.l0.f.b) r11.next(), r4.b()));
        goto L26
    L28:
        return r10;
    L7:
        if ((r5 instanceof kotlin.s0.w.d.l0.f.i) == false) goto L10;
        r7 = (kotlin.s0.w.d.l0.f.i) r5;
        r8 = this.f20703a.f();
        goto L5
    L10:
        if ((r5 instanceof kotlin.s0.w.d.l0.f.n) == false) goto L30;
        int r12 = a.f20705a[r6.ordinal()];
        if (r12 != 1) goto L14;
        r7 = (kotlin.s0.w.d.l0.f.n) r5;
        r8 = this.f20703a.h();
        goto L5
    L14:
        if (r12 != 2) goto L16;
        r7 = (kotlin.s0.w.d.l0.f.n) r5;
        r8 = this.f20703a.i();
        goto L5
    L16:
        if (r12 != 3) goto L19;
        r7 = (kotlin.s0.w.d.l0.f.n) r5;
        r8 = this.f20703a.j();
        goto L5
    L19:
        throw new IllegalStateException("Unsupported callable kind with property proto".toString());
    L30:
        throw new IllegalStateException(("Unknown message: " + r5).toString());
    }

    @Override // kotlin.s0.w.d.l0.l.b.c
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.k.r.g<?> k(z r1, kotlin.s0.w.d.l0.f.n r2, kotlin.s0.w.d.l0.n.e0 r3) {
        return l(r1, r2, r3);
    }

    public kotlin.s0.w.d.l0.k.r.g<?> l(z r1, kotlin.s0.w.d.l0.f.n r2, kotlin.s0.w.d.l0.n.e0 r3) {
        kotlin.n0.d.o.f(r1, "container");
        kotlin.n0.d.o.f(r2, "proto");
        kotlin.n0.d.o.f(r3, "expectedType");
        return null;
    }

    public kotlin.s0.w.d.l0.k.r.g<?> m(z r2, kotlin.s0.w.d.l0.f.n r3, kotlin.s0.w.d.l0.n.e0 r4) {
        kotlin.n0.d.o.f(r2, "container");
        kotlin.n0.d.o.f(r3, "proto");
        kotlin.n0.d.o.f(r4, "expectedType");
        kotlin.s0.w.d.l0.f.b.C0541b.c r5 = (kotlin.s0.w.d.l0.f.b.C0541b.c) kotlin.s0.w.d.l0.f.z.e.a(r3, this.f20703a.b());
        if (r5 != null) goto L7;
        return null;
    L7:
        return this.f20704b.f(r4, r5, r2.b());
    }
}
