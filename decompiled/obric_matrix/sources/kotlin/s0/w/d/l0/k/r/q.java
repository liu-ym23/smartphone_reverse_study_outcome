package kotlin.s0.w.d.l0.k.r;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.n.a1;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.f0;
import kotlin.s0.w.d.l0.n.g0;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.i1;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends g<b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f20588b = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final g<?> a(e0 r5) {
            kotlin.n0.d.o.f(r5, "argumentType");
            if (g0.a(r5) == false) goto L5;
            return null;
        L5:
            int r2 = 0;
            e0 r1 = r5;
        L7:
            if (kotlin.s0.w.d.l0.b.h.c0(r1) == false) goto L9;
            r1 = ((g1) kotlin.i0.r.o0(r1.M0())).b();
            kotlin.n0.d.o.e(r1, "type.arguments.single().type");
            r2 = r2 + 1;
            goto L7
        L9:
            kotlin.s0.w.d.l0.c.h r3 = r1.O0().d();
            if ((r3 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L17;
            kotlin.s0.w.d.l0.g.b r4 = kotlin.s0.w.d.l0.k.t.a.g(r3);
            if (r4 != null) goto L21;
            return new q(new b.a(r5));
        L21:
            return new q(r4, r2);
        L17:
            if ((r3 instanceof f1) == false) goto L22;
            kotlin.s0.w.d.l0.g.b r6 = kotlin.s0.w.d.l0.g.b.m(kotlin.s0.w.d.l0.b.k.a.f18719b.l());
            kotlin.n0.d.o.e(r6, "topLevel(StandardNames.FqNames.any.toSafe())");
            return new q(r6, 0);
        L22:
            return null;
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final e0 f20589a;

            public a(e0 r2) {
                kotlin.n0.d.o.f(r2, WsConstants.KEY_CONNECTION_TYPE);
                super(null);
                this.f20589a = r2;
            }

            public final e0 a() {
                return this.f20589a;
            }

            public boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof a) == true) goto L9;
                return false;
            L9:
                if (kotlin.n0.d.o.a(this.f20589a, ((a) r4).f20589a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f20589a.hashCode();
            }

            public String toString() {
                return "LocalClass(type=" + this.f20589a + ')';
            }
        }

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.k.r.q$b$b, reason: collision with other inner class name */
        public static final class C0561b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final f f20590a;

            public C0561b(f r2) {
                kotlin.n0.d.o.f(r2, "value");
                super(null);
                this.f20590a = r2;
            }

            public final int a() {
                return this.f20590a.c();
            }

            public final kotlin.s0.w.d.l0.g.b b() {
                return this.f20590a.d();
            }

            public final f c() {
                return this.f20590a;
            }

            public boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0561b) == true) goto L9;
                return false;
            L9:
                if (kotlin.n0.d.o.a(this.f20590a, ((C0561b) r4).f20590a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f20590a.hashCode();
            }

            public String toString() {
                return "NormalClass(value=" + this.f20590a + ')';
            }
        }

        private b() {
        }

        public /* synthetic */ b(kotlin.n0.d.g r1) {
            this();
        }
    }

    static {
        f20588b = new a(null);
    }

    public q(kotlin.s0.w.d.l0.g.b r2, int r3) {
        kotlin.n0.d.o.f(r2, "classId");
        this(new f(r2, r3));
    }

    public q(f r2) {
        kotlin.n0.d.o.f(r2, "value");
        this(new b.C0561b(r2));
    }

    public q(b r2) {
        kotlin.n0.d.o.f(r2, "value");
        super(r2);
    }

    @Override // kotlin.s0.w.d.l0.k.r.g
    public e0 a(h0 r4) {
        kotlin.n0.d.o.f(r4, "module");
        a1 r0 = a1.f20943g.h();
        kotlin.s0.w.d.l0.c.e r1 = r4.o().E();
        kotlin.n0.d.o.e(r1, "module.builtIns.kClass");
        return f0.g(r0, r1, kotlin.i0.r.d(new i1(c(r4))));
    }

    public final e0 c(h0 r5) {
        kotlin.n0.d.o.f(r5, "module");
        b r0 = b();
        if ((r0 instanceof b.a) == false) goto L7;
        return ((b.a) b()).a();
    L7:
        if ((r0 instanceof b.C0561b) == false) goto L17;
        f r4 = ((b.C0561b) b()).c();
        kotlin.s0.w.d.l0.g.b r1 = r4.a();
        int r6 = r4.b();
        kotlin.s0.w.d.l0.c.e r2 = kotlin.s0.w.d.l0.c.x.a(r5, r1);
        int r3 = 0;
        if (r2 != null) goto L12;
        kotlin.s0.w.d.l0.n.u1.j r7 = kotlin.s0.w.d.l0.n.u1.j.m;
        String r8 = r1.toString();
        kotlin.n0.d.o.e(r8, "classId.toString()");
        return kotlin.s0.w.d.l0.n.u1.k.d(r7, new String[]{r8, String.valueOf(r6)});
    L12:
        m0 r9 = r2.s();
        kotlin.n0.d.o.e(r9, "descriptor.defaultType");
        e0 r10 = kotlin.s0.w.d.l0.n.x1.a.w(r9);
    L13:
        if (r3 >= r6) goto L15;
        r10 = r5.o().l(r1.f21065h, r10);
        kotlin.n0.d.o.e(r10, "module.builtIns.getArray…Variance.INVARIANT, type)");
        r3 = r3 + 1;
        goto L13
    L15:
        return r10;
    L17:
        throw new kotlin.m();
    }
}
