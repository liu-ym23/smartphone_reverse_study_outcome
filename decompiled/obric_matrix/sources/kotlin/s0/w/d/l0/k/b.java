package kotlin.s0.w.d.l0.k;

import java.util.Collection;
import kotlin.i0.r;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.d0;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.l0;
import kotlin.s0.w.d.l0.n.e1;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f20507a = null;

    static final class a extends q implements kotlin.n0.c.p<kotlin.s0.w.d.l0.c.m, kotlin.s0.w.d.l0.c.m, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f20508f = null;

        static {
            f20508f = new a();
        }

        a() {
            super(2);
        }

        public final Boolean a(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.m r2) {
            return Boolean.FALSE;
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Boolean invoke(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.m r2) {
            return a(r1, r2);
        }
    }

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.k.b$b, reason: collision with other inner class name */
    static final class C0559b implements kotlin.s0.w.d.l0.n.t1.e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f20509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.c.a f20510b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.c.a f20511c;

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.k.b$b$a */
        static final class a extends q implements kotlin.n0.c.p<kotlin.s0.w.d.l0.c.m, kotlin.s0.w.d.l0.c.m, Boolean> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ kotlin.s0.w.d.l0.c.a f20512f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ kotlin.s0.w.d.l0.c.a f20513g;

            a(kotlin.s0.w.d.l0.c.a r1, kotlin.s0.w.d.l0.c.a r2) {
                this.f20512f = r1;
                this.f20513g = r2;
                super(2);
            }

            public final Boolean a(kotlin.s0.w.d.l0.c.m r2, kotlin.s0.w.d.l0.c.m r3) {
                if (kotlin.n0.d.o.a(r2, this.f20512f) == true) goto L5;
            L7:
                boolean r1 = false;
            L9:
                return Boolean.valueOf(r1);
            L5:
                if (kotlin.n0.d.o.a(r3, this.f20513g) == false) goto L7;
                r1 = true;
                goto L9
            }

            @Override // kotlin.n0.c.p
            public /* bridge */ /* synthetic */ Boolean invoke(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.m r2) {
                return a(r1, r2);
            }
        }

        C0559b(boolean r1, kotlin.s0.w.d.l0.c.a r2, kotlin.s0.w.d.l0.c.a r3) {
            this.f20509a = r1;
            this.f20510b = r2;
            this.f20511c = r3;
        }

        @Override // kotlin.s0.w.d.l0.n.t1.e.a
        public final boolean a(e1 r5, e1 r6) {
            kotlin.n0.d.o.f(r5, "c1");
            kotlin.n0.d.o.f(r6, "c2");
            if (kotlin.n0.d.o.a(r5, r6) == false) goto L6;
            return true;
        L6:
            kotlin.s0.w.d.l0.c.h r7 = r5.d();
            kotlin.s0.w.d.l0.c.h r8 = r6.d();
            if ((r7 instanceof f1) == true) goto L9;
            return false;
        L9:
            if ((r8 instanceof f1) == true) goto L12;
            return false;
        L12:
            return b.f20507a.g((f1) r7, (f1) r8, this.f20509a, new a(this.f20510b, this.f20511c));
        }
    }

    static final class c extends q implements kotlin.n0.c.p<kotlin.s0.w.d.l0.c.m, kotlin.s0.w.d.l0.c.m, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f20514f = null;

        static {
            f20514f = new c();
        }

        c() {
            super(2);
        }

        public final Boolean a(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.m r2) {
            return Boolean.FALSE;
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Boolean invoke(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.m r2) {
            return a(r1, r2);
        }
    }

    static {
        f20507a = new b();
    }

    private b() {
    }

    public static /* synthetic */ boolean b(b r7, kotlin.s0.w.d.l0.c.a r8, kotlin.s0.w.d.l0.c.a r9, boolean r10, boolean r11, boolean r12, kotlin.s0.w.d.l0.n.t1.g r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L5;
        r11 = true;
    L5:
        boolean r4 = r11;
        if ((r14 & 16) == 0) goto L9;
        r12 = false;
    L9:
        return r7.a(r8, r9, r10, r4, r12, r13);
    }

    private final boolean c(kotlin.s0.w.d.l0.c.e r1, kotlin.s0.w.d.l0.c.e r2) {
        return kotlin.n0.d.o.a(r1.k(), r2.k());
    }

    public static /* synthetic */ boolean e(b r0, kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.m r2, boolean r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = true;
    L6:
        return r0.d(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean h(b r0, f1 r1, f1 r2, boolean r3, kotlin.n0.c.p r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = c.f20514f;
    L6:
        return r0.g(r1, r2, r3, r4);
    }

    private final boolean i(kotlin.s0.w.d.l0.c.m r8, kotlin.s0.w.d.l0.c.m r9, kotlin.n0.c.p<? super kotlin.s0.w.d.l0.c.m, ? super kotlin.s0.w.d.l0.c.m, Boolean> r10, boolean r11) {
        kotlin.s0.w.d.l0.c.m r1 = r8.c();
        kotlin.s0.w.d.l0.c.m r2 = r9.c();
        if ((r1 instanceof kotlin.s0.w.d.l0.c.b) == true) goto L9;
        if ((r2 instanceof kotlin.s0.w.d.l0.c.b) == true) goto L9;
        return e(this, r1, r2, r11, false, 8, null);
    L9:
        return r10.invoke(r1, r2).booleanValue();
    }

    private final a1 j(kotlin.s0.w.d.l0.c.a r3) {
    L3:
        if ((r3 instanceof kotlin.s0.w.d.l0.c.b) == false) goto L13;
        kotlin.s0.w.d.l0.c.b r2 = (kotlin.s0.w.d.l0.c.b) r3;
        if (r2.i() != kotlin.s0.w.d.l0.c.b.a.f18849g) goto L13;
        Collection<? extends kotlin.s0.w.d.l0.c.b> r4 = r2.f();
        kotlin.n0.d.o.e(r4, "overriddenDescriptors");
        r3 = (kotlin.s0.w.d.l0.c.b) r.p0(r4);
        if (r3 != null) goto L3;
        return null;
    L13:
        return r3.getSource();
    }

    public final boolean a(kotlin.s0.w.d.l0.c.a r4, kotlin.s0.w.d.l0.c.a r5, boolean r6, boolean r7, boolean r8, kotlin.s0.w.d.l0.n.t1.g r9) {
        kotlin.n0.d.o.f(r4, "a");
        kotlin.n0.d.o.f(r5, "b");
        kotlin.n0.d.o.f(r9, "kotlinTypeRefiner");
        if (kotlin.n0.d.o.a(r4, r5) == false) goto L6;
        return true;
    L6:
        if (kotlin.n0.d.o.a(r4.getName(), r5.getName()) == true) goto L8;
        return false;
    L8:
        if (r7 == false) goto L17;
        if ((r4 instanceof d0) == false) goto L17;
        if ((r5 instanceof d0) == false) goto L17;
        if (((d0) r4).L() == ((d0) r5).L()) goto L17;
        return false;
    L17:
        if (kotlin.n0.d.o.a(r4.c(), r5.c()) == false) goto L24;
        if (r6 == true) goto L21;
        return false;
    L21:
        if (kotlin.n0.d.o.a(j(r4), j(r5)) == true) goto L24;
        return false;
    L24:
        if (d.E(r4) == false) goto L26;
    L38:
        return false;
    L26:
        if (d.E(r5) == true) goto L38;
        if (i(r4, r5, a.f20508f, r6) == true) goto L31;
        return false;
    L31:
        j r3 = j.i(r9, new C0559b(r6, r4, r5));
        kotlin.n0.d.o.e(r3, "a: CallableDescriptor,\n …= a && y == b }\n        }");
        j.i.a r10 = r3.E(r4, r5, null, !r8).c();
        j.i.a r11 = j.i.a.f20542f;
        if (r10 != r11) goto L37;
        if (r3.E(r5, r4, null, !r8).c() != r11) goto L37;
        return true;
    L37:
        return false;
    }

    public final boolean d(kotlin.s0.w.d.l0.c.m r11, kotlin.s0.w.d.l0.c.m r12, boolean r13, boolean r14) {
        if ((r11 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L8;
        if ((r12 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L8;
        return c((kotlin.s0.w.d.l0.c.e) r11, (kotlin.s0.w.d.l0.c.e) r12);
    L8:
        if ((r11 instanceof f1) == false) goto L13;
        if ((r12 instanceof f1) == false) goto L13;
        return h(this, (f1) r11, (f1) r12, r13, null, 8, null);
    L13:
        if ((r11 instanceof kotlin.s0.w.d.l0.c.a) == false) goto L18;
        if ((r12 instanceof kotlin.s0.w.d.l0.c.a) == false) goto L18;
        return b(this, (kotlin.s0.w.d.l0.c.a) r11, (kotlin.s0.w.d.l0.c.a) r12, r13, r14, false, kotlin.s0.w.d.l0.n.t1.g.a.f21080a, 16, null);
    L18:
        if ((r11 instanceof l0) == false) goto L23;
        if ((r12 instanceof l0) == false) goto L23;
        return kotlin.n0.d.o.a(((l0) r11).e(), ((l0) r12).e());
    L23:
        return kotlin.n0.d.o.a(r11, r12);
    }

    public final boolean f(f1 r9, f1 r10, boolean r11) {
        kotlin.n0.d.o.f(r9, "a");
        kotlin.n0.d.o.f(r10, "b");
        return h(this, r9, r10, r11, null, 8, null);
    }

    public final boolean g(f1 r4, f1 r5, boolean r6, kotlin.n0.c.p<? super kotlin.s0.w.d.l0.c.m, ? super kotlin.s0.w.d.l0.c.m, Boolean> r7) {
        kotlin.n0.d.o.f(r4, "a");
        kotlin.n0.d.o.f(r5, "b");
        kotlin.n0.d.o.f(r7, "equivalentCallables");
        if (kotlin.n0.d.o.a(r4, r5) == false) goto L6;
        return true;
    L6:
        if (kotlin.n0.d.o.a(r4.c(), r5.c()) == false) goto L9;
        return false;
    L9:
        if (i(r4, r5, r7, r6) == true) goto L12;
        return false;
    L12:
        if (r4.j() != r5.j()) goto L15;
        return true;
    L15:
        return false;
    }
}
