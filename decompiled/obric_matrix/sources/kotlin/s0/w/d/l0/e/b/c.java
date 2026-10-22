package kotlin.s0.w.d.l0.e.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.k0;
import kotlin.s0.w.d.l0.n.e0;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends kotlin.s0.w.d.l0.e.b.a<kotlin.s0.w.d.l0.c.o1.c, kotlin.s0.w.d.l0.k.r.g<?>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h0 f19701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final k0 f19702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.l.b.e f19703e;

    private abstract class a implements q.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f19704a;

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.e.b.c$a$a, reason: collision with other inner class name */
        public static final class C0524a implements q.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final /* synthetic */ q.a f19705a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ q.a f19706b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f19707c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ kotlin.s0.w.d.l0.g.f f19708d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ ArrayList<kotlin.s0.w.d.l0.c.o1.c> f19709e;

            C0524a(q.a r1, a r2, kotlin.s0.w.d.l0.g.f r3, ArrayList<kotlin.s0.w.d.l0.c.o1.c> r4) {
                this.f19706b = r1;
                this.f19707c = r2;
                this.f19708d = r3;
                this.f19709e = r4;
                this.f19705a = r1;
            }

            @Override // kotlin.s0.w.d.l0.e.b.q.a
            public void a() {
                this.f19706b.a();
                this.f19707c.h(this.f19708d, new kotlin.s0.w.d.l0.k.r.a((kotlin.s0.w.d.l0.c.o1.c) kotlin.i0.r.o0(this.f19709e)));
            }

            @Override // kotlin.s0.w.d.l0.e.b.q.a
            public void b(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.k.r.f r3) {
                kotlin.n0.d.o.f(r3, "value");
                this.f19705a.b(r2, r3);
            }

            @Override // kotlin.s0.w.d.l0.e.b.q.a
            public void c(kotlin.s0.w.d.l0.g.f r1, Object r2) {
                this.f19705a.c(r1, r2);
            }

            @Override // kotlin.s0.w.d.l0.e.b.q.a
            public void d(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.g.b r3, kotlin.s0.w.d.l0.g.f r4) {
                kotlin.n0.d.o.f(r3, "enumClassId");
                kotlin.n0.d.o.f(r4, "enumEntryName");
                this.f19705a.d(r2, r3, r4);
            }

            @Override // kotlin.s0.w.d.l0.e.b.q.a
            public q.a e(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.g.b r3) {
                kotlin.n0.d.o.f(r3, "classId");
                return this.f19705a.e(r2, r3);
            }

            @Override // kotlin.s0.w.d.l0.e.b.q.a
            public q.b f(kotlin.s0.w.d.l0.g.f r1) {
                return this.f19705a.f(r1);
            }
        }

        public static final class b implements q.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final ArrayList<kotlin.s0.w.d.l0.k.r.g<?>> f19710a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ c f19711b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ kotlin.s0.w.d.l0.g.f f19712c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f19713d;

            /* JADX INFO: renamed from: kotlin.s0.w.d.l0.e.b.c$a$b$a, reason: collision with other inner class name */
            public static final class C0525a implements q.a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final /* synthetic */ q.a f19714a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ q.a f19715b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ b f19716c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ ArrayList<kotlin.s0.w.d.l0.c.o1.c> f19717d;

                C0525a(q.a r1, b r2, ArrayList<kotlin.s0.w.d.l0.c.o1.c> r3) {
                    this.f19715b = r1;
                    this.f19716c = r2;
                    this.f19717d = r3;
                    this.f19714a = r1;
                }

                @Override // kotlin.s0.w.d.l0.e.b.q.a
                public void a() {
                    this.f19715b.a();
                    b.f(this.f19716c).add(new kotlin.s0.w.d.l0.k.r.a((kotlin.s0.w.d.l0.c.o1.c) kotlin.i0.r.o0(this.f19717d)));
                }

                @Override // kotlin.s0.w.d.l0.e.b.q.a
                public void b(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.k.r.f r3) {
                    kotlin.n0.d.o.f(r3, "value");
                    this.f19714a.b(r2, r3);
                }

                @Override // kotlin.s0.w.d.l0.e.b.q.a
                public void c(kotlin.s0.w.d.l0.g.f r1, Object r2) {
                    this.f19714a.c(r1, r2);
                }

                @Override // kotlin.s0.w.d.l0.e.b.q.a
                public void d(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.g.b r3, kotlin.s0.w.d.l0.g.f r4) {
                    kotlin.n0.d.o.f(r3, "enumClassId");
                    kotlin.n0.d.o.f(r4, "enumEntryName");
                    this.f19714a.d(r2, r3, r4);
                }

                @Override // kotlin.s0.w.d.l0.e.b.q.a
                public q.a e(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.g.b r3) {
                    kotlin.n0.d.o.f(r3, "classId");
                    return this.f19714a.e(r2, r3);
                }

                @Override // kotlin.s0.w.d.l0.e.b.q.a
                public q.b f(kotlin.s0.w.d.l0.g.f r1) {
                    return this.f19714a.f(r1);
                }
            }

            b(c r1, kotlin.s0.w.d.l0.g.f r2, a r3) {
                this.f19711b = r1;
                this.f19712c = r2;
                this.f19713d = r3;
                this.f19710a = new ArrayList();
            }

            public static final /* synthetic */ ArrayList f(b r0) {
                return r0.f19710a;
            }

            @Override // kotlin.s0.w.d.l0.e.b.q.b
            public void a() {
                this.f19713d.g(this.f19712c, this.f19710a);
            }

            @Override // kotlin.s0.w.d.l0.e.b.q.b
            public void b(Object r3) {
                this.f19710a.add(c.J(this.f19711b, this.f19712c, r3));
            }

            @Override // kotlin.s0.w.d.l0.e.b.q.b
            public void c(kotlin.s0.w.d.l0.g.b r2, kotlin.s0.w.d.l0.g.f r3) {
                kotlin.n0.d.o.f(r2, "enumClassId");
                kotlin.n0.d.o.f(r3, "enumEntryName");
                this.f19710a.add(new kotlin.s0.w.d.l0.k.r.j(r2, r3));
            }

            @Override // kotlin.s0.w.d.l0.e.b.q.b
            public q.a d(kotlin.s0.w.d.l0.g.b r5) {
                kotlin.n0.d.o.f(r5, "classId");
                ArrayList r0 = new ArrayList();
                c r1 = this.f19711b;
                a1 r2 = a1.f18847a;
                kotlin.n0.d.o.e(r2, "NO_SOURCE");
                q.a r6 = r1.x(r5, r2, r0);
                kotlin.n0.d.o.c(r6);
                return new C0525a(r6, this, r0);
            }

            @Override // kotlin.s0.w.d.l0.e.b.q.b
            public void e(kotlin.s0.w.d.l0.k.r.f r2) {
                kotlin.n0.d.o.f(r2, "value");
                this.f19710a.add(new kotlin.s0.w.d.l0.k.r.q(r2));
            }
        }

        public a(c r1) {
            this.f19704a = r1;
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.a
        public void b(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.k.r.f r3) {
            kotlin.n0.d.o.f(r3, "value");
            h(r2, new kotlin.s0.w.d.l0.k.r.q(r3));
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.a
        public void c(kotlin.s0.w.d.l0.g.f r2, Object r3) {
            h(r2, c.J(this.f19704a, r2, r3));
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.a
        public void d(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.g.b r3, kotlin.s0.w.d.l0.g.f r4) {
            kotlin.n0.d.o.f(r3, "enumClassId");
            kotlin.n0.d.o.f(r4, "enumEntryName");
            h(r2, new kotlin.s0.w.d.l0.k.r.j(r3, r4));
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.a
        public q.a e(kotlin.s0.w.d.l0.g.f r5, kotlin.s0.w.d.l0.g.b r6) {
            kotlin.n0.d.o.f(r6, "classId");
            ArrayList r0 = new ArrayList();
            c r1 = this.f19704a;
            a1 r2 = a1.f18847a;
            kotlin.n0.d.o.e(r2, "NO_SOURCE");
            q.a r7 = r1.x(r6, r2, r0);
            kotlin.n0.d.o.c(r7);
            return new C0524a(r7, this, r5, r0);
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.a
        public q.b f(kotlin.s0.w.d.l0.g.f r3) {
            return new b(this.f19704a, r3, this);
        }

        public abstract void g(kotlin.s0.w.d.l0.g.f r1, ArrayList<kotlin.s0.w.d.l0.k.r.g<?>> r2);

        public abstract void h(kotlin.s0.w.d.l0.g.f r1, kotlin.s0.w.d.l0.k.r.g<?> r2);
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final HashMap<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<?>> f19718b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f19719c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.c.e f19720d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.g.b f19721e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List<kotlin.s0.w.d.l0.c.o1.c> f19722f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a1 f19723g;

        b(c r1, kotlin.s0.w.d.l0.c.e r2, kotlin.s0.w.d.l0.g.b r3, List<kotlin.s0.w.d.l0.c.o1.c> r4, a1 r5) {
            this.f19719c = r1;
            this.f19720d = r2;
            this.f19721e = r3;
            this.f19722f = r4;
            this.f19723g = r5;
            super(r1);
            this.f19718b = new HashMap();
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.a
        public void a() {
            if (this.f19719c.E(this.f19721e, this.f19718b) == false) goto L6;
            return;
        L6:
            if (this.f19719c.w(this.f19721e) == false) goto L8;
            return;
        L8:
            this.f19722f.add(new kotlin.s0.w.d.l0.c.o1.d(this.f19720d.s(), this.f19718b, this.f19723g));
        }

        @Override // kotlin.s0.w.d.l0.e.b.c.a
        public void g(kotlin.s0.w.d.l0.g.f r4, ArrayList<kotlin.s0.w.d.l0.k.r.g<?>> r5) {
            kotlin.n0.d.o.f(r5, "elements");
            if (r4 != null) goto L5;
            return;
        L5:
            j1 r0 = kotlin.s0.w.d.l0.e.a.j0.a.b(r4, this.f19720d);
            if (r0 == null) goto L9;
            HashMap<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<?>> r3 = this.f19718b;
            kotlin.s0.w.d.l0.k.r.h r1 = kotlin.s0.w.d.l0.k.r.h.f20566a;
            List<? extends kotlin.s0.w.d.l0.k.r.g<?>> r6 = kotlin.s0.w.d.l0.p.a.c(r5);
            e0 r2 = r0.b();
            kotlin.n0.d.o.e(r2, "parameter.type");
            r3.put(r4, r1.b(r6, r2));
            return;
        L9:
            if (this.f19719c.w(this.f19721e) == true) goto L11;
            return;
        L11:
            if (kotlin.n0.d.o.a(r4.b(), "value") == false) goto L30;
            ArrayList r7 = new ArrayList();
            Iterator<T> r8 = r5.iterator();
        L14:
            if (r8.hasNext() == false) goto L18;
            Object r9 = r8.next();
            if ((r9 instanceof kotlin.s0.w.d.l0.k.r.a) == false) goto L14;
            r7.add(r9);
            goto L14
        L18:
            List<kotlin.s0.w.d.l0.c.o1.c> r10 = this.f19722f;
            Iterator r11 = r7.iterator();
        L20:
            if (r11.hasNext() == false) goto L31;
            r10.add(((kotlin.s0.w.d.l0.k.r.a) r11.next()).b());
            goto L20
        L31:
            return;
        }

        @Override // kotlin.s0.w.d.l0.e.b.c.a
        public void h(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.k.r.g<?> r3) {
            kotlin.n0.d.o.f(r3, "value");
            if (r2 == null) goto L6;
            this.f19718b.put(r2, r3);
            return;
        }
    }

    public c(h0 r2, k0 r3, kotlin.s0.w.d.l0.m.n r4, o r5) {
        kotlin.n0.d.o.f(r2, "module");
        kotlin.n0.d.o.f(r3, "notFoundClasses");
        kotlin.n0.d.o.f(r4, "storageManager");
        kotlin.n0.d.o.f(r5, "kotlinClassFinder");
        super(r4, r5);
        this.f19701c = r2;
        this.f19702d = r3;
        this.f19703e = new kotlin.s0.w.d.l0.l.b.e(r2, r3);
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.k.r.g J(c r0, kotlin.s0.w.d.l0.g.f r1, Object r2) {
        return r0.K(r1, r2);
    }

    private final kotlin.s0.w.d.l0.k.r.g<?> K(kotlin.s0.w.d.l0.g.f r2, Object r3) {
        kotlin.s0.w.d.l0.k.r.g<?> r1 = kotlin.s0.w.d.l0.k.r.h.f20566a.c(r3);
        if (r1 == null) goto L5;
        return r1;
    L5:
        return kotlin.s0.w.d.l0.k.r.k.f20571b.a("Unsupported annotation argument: " + r2);
    }

    private final kotlin.s0.w.d.l0.c.e N(kotlin.s0.w.d.l0.g.b r2) {
        return kotlin.s0.w.d.l0.c.x.c(this.f19701c, r2, this.f19702d);
    }

    @Override // kotlin.s0.w.d.l0.e.b.b
    public /* bridge */ /* synthetic */ Object A(kotlin.s0.w.d.l0.f.b r1, kotlin.s0.w.d.l0.f.z.c r2) {
        return M(r1, r2);
    }

    @Override // kotlin.s0.w.d.l0.e.b.a
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.k.r.g<?> G(String r1, Object r2) {
        return L(r1, r2);
    }

    @Override // kotlin.s0.w.d.l0.e.b.a
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.k.r.g<?> I(kotlin.s0.w.d.l0.k.r.g<?> r1) {
        return O(r1);
    }

    protected kotlin.s0.w.d.l0.k.r.g<?> L(String r4, Object r5) {
        kotlin.n0.d.o.f(r4, "desc");
        kotlin.n0.d.o.f(r5, "initializer");
        boolean r0 = false;
        if (kotlin.u0.k.F("ZBCS", r4, false, 2, null) == false) goto L29;
        int r3 = ((Integer) r5).intValue();
        int r6 = r4.hashCode();
        if (r6 == 66) goto L24;
        if (r6 == 67) goto L21;
        if (r6 == 83) goto L18;
        if (r6 != 90) goto L27;
        if (r4.equals("Z") == false) goto L27;
        if (r3 == 0) goto L16;
        r0 = true;
    L16:
        r5 = Boolean.valueOf(r0);
    L27:
        throw new AssertionError(r4);
    L18:
        if (r4.equals("S") == false) goto L27;
        r5 = Short.valueOf((short) r3);
        goto L29
    L21:
        if (r4.equals("C") == false) goto L27;
        r5 = Character.valueOf((char) r3);
        goto L29
    L24:
        if (r4.equals("B") == false) goto L27;
        r5 = Byte.valueOf((byte) r3);
    L29:
        return kotlin.s0.w.d.l0.k.r.h.f20566a.c(r5);
    }

    protected kotlin.s0.w.d.l0.c.o1.c M(kotlin.s0.w.d.l0.f.b r2, kotlin.s0.w.d.l0.f.z.c r3) {
        kotlin.n0.d.o.f(r2, "proto");
        kotlin.n0.d.o.f(r3, "nameResolver");
        return this.f19703e.a(r2, r3);
    }

    protected kotlin.s0.w.d.l0.k.r.g<?> O(kotlin.s0.w.d.l0.k.r.g<?> r3) {
        kotlin.n0.d.o.f(r3, "constant");
        if ((r3 instanceof kotlin.s0.w.d.l0.k.r.d) == false) goto L7;
        kotlin.s0.w.d.l0.k.r.g<?> r2 = new kotlin.s0.w.d.l0.k.r.w(((kotlin.s0.w.d.l0.k.r.d) r3).b().byteValue());
    L15:
        return r2;
    L7:
        if ((r3 instanceof kotlin.s0.w.d.l0.k.r.u) == false) goto L10;
        r2 = new kotlin.s0.w.d.l0.k.r.z(((kotlin.s0.w.d.l0.k.r.u) r3).b().shortValue());
        goto L15
    L10:
        if ((r3 instanceof kotlin.s0.w.d.l0.k.r.m) == false) goto L13;
        r2 = new kotlin.s0.w.d.l0.k.r.x(((kotlin.s0.w.d.l0.k.r.m) r3).b().intValue());
        goto L15
    L13:
        if ((r3 instanceof kotlin.s0.w.d.l0.k.r.r) == false) goto L16;
        r2 = new kotlin.s0.w.d.l0.k.r.y(((kotlin.s0.w.d.l0.k.r.r) r3).b().longValue());
        goto L15
    L16:
        return r3;
    }

    @Override // kotlin.s0.w.d.l0.e.b.b
    protected q.a x(kotlin.s0.w.d.l0.g.b r8, a1 r9, List<kotlin.s0.w.d.l0.c.o1.c> r10) {
        kotlin.n0.d.o.f(r8, "annotationClassId");
        kotlin.n0.d.o.f(r9, "source");
        kotlin.n0.d.o.f(r10, "result");
        return new b(this, N(r8), r8, r10, r9);
    }
}
