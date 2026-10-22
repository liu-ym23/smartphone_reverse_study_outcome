package kotlin.s0.w.d.l0.c.s1.a;

import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.b1;
import kotlin.s0.w.d.l0.c.s1.b.p;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements kotlin.s0.w.d.l0.e.a.m0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f19096a = null;

    public static final class a implements kotlin.s0.w.d.l0.e.a.m0.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final p f19097b;

        public a(p r2) {
            o.f(r2, "javaElement");
            this.f19097b = r2;
        }

        @Override // kotlin.s0.w.d.l0.c.a1
        public b1 a() {
            b1 r1 = b1.f18854a;
            o.e(r1, "NO_SOURCE_FILE");
            return r1;
        }

        @Override // kotlin.s0.w.d.l0.e.a.m0.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.e.a.n0.l b() {
            return d();
        }

        public p d() {
            return this.f19097b;
        }

        public String toString() {
            return a.class.getName() + ": " + d();
        }
    }

    static {
        f19096a = new l();
    }

    private l() {
    }

    @Override // kotlin.s0.w.d.l0.e.a.m0.b
    public kotlin.s0.w.d.l0.e.a.m0.a a(kotlin.s0.w.d.l0.e.a.n0.l r1) {
        o.f(r1, "javaElement");
        return new a((p) r1);
    }
}
