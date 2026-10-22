package kotlin.s0.w.d.l0.n;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f1 extends j1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21004b = null;

    public static final class a {

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.n.f1$a$a, reason: collision with other inner class name */
        public static final class C0577a extends f1 {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Map<e1, g1> f21005c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f21006d;

            /* JADX WARN: Multi-variable type inference failed */
            C0577a(Map<e1, ? extends g1> r1, boolean r2) {
                this.f21005c = r1;
                this.f21006d = r2;
            }

            @Override // kotlin.s0.w.d.l0.n.j1
            public boolean a() {
                return this.f21006d;
            }

            @Override // kotlin.s0.w.d.l0.n.j1
            public boolean f() {
                return this.f21005c.isEmpty();
            }

            @Override // kotlin.s0.w.d.l0.n.f1
            public g1 k(e1 r2) {
                kotlin.n0.d.o.f(r2, "key");
                return this.f21005c.get(r2);
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public static /* synthetic */ f1 e(a r0, Map r1, boolean r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = false;
        L6:
            return r0.d(r1, r2);
        }

        public final j1 a(e0 r2) {
            kotlin.n0.d.o.f(r2, "kotlinType");
            return b(r2.O0(), r2.M0());
        }

        public final j1 b(e1 r6, List<? extends g1> r7) {
            kotlin.n0.d.o.f(r6, "typeConstructor");
            kotlin.n0.d.o.f(r7, "arguments");
            List<kotlin.s0.w.d.l0.c.f1> r0 = r6.getParameters();
            kotlin.n0.d.o.e(r0, "typeConstructor.parameters");
            kotlin.s0.w.d.l0.c.f1 r2 = (kotlin.s0.w.d.l0.c.f1) kotlin.i0.r.d0(r0);
            boolean r3 = true;
            if (r2 != null) goto L5;
        L7:
            r3 = false;
        L8:
            if (r3 == false) goto L16;
            List<kotlin.s0.w.d.l0.c.f1> r8 = r6.getParameters();
            kotlin.n0.d.o.e(r8, "typeConstructor.parameters");
            ArrayList r1 = new ArrayList(kotlin.i0.r.q(r8, 10));
            Iterator<T> r9 = r8.iterator();
        L11:
            if (r9.hasNext() == false) goto L14;
            r1.add(((kotlin.s0.w.d.l0.c.f1) r9.next()).k());
            goto L11
        L14:
            return e(this, kotlin.i0.m0.q(kotlin.i0.r.G0(r1, r7)), false, 2, null);
        L16:
            return new c0(r0, r7);
        L5:
            if (r2.o0() != true) goto L7;
            goto L7
        }

        public final f1 c(Map<e1, ? extends g1> r4) {
            kotlin.n0.d.o.f(r4, "map");
            return e(this, r4, false, 2, null);
        }

        public final f1 d(Map<e1, ? extends g1> r1, boolean r2) {
            kotlin.n0.d.o.f(r1, "map");
            return new C0577a(r1, r2);
        }
    }

    static {
        f21004b = new a(null);
    }

    public f1() {
    }

    public static final j1 i(e1 r1, List<? extends g1> r2) {
        return f21004b.b(r1, r2);
    }

    public static final f1 j(Map<e1, ? extends g1> r1) {
        return f21004b.c(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.j1
    public g1 e(e0 r2) {
        kotlin.n0.d.o.f(r2, "key");
        return k(r2.O0());
    }

    public abstract g1 k(e1 r1);
}
