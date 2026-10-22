package kotlin.s0.w.d.l0.c.s1.a;

import kotlin.f0;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.h0;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f19093c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.l.b.k f19094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.c.s1.a.a f19095b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final k a(ClassLoader r8) {
            o.f(r8, "classLoader");
            g r7 = new g(r8);
            kotlin.s0.w.d.l0.e.b.e.a r0 = kotlin.s0.w.d.l0.e.b.e.f19758b;
            ClassLoader r1 = f0.class.getClassLoader();
            o.e(r1, "Unit::class.java.classLoader");
            kotlin.s0.w.d.l0.e.b.e.a.C0531a r9 = r0.a(r7, new g(r1), new d(r8), "runtime module for " + r8, j.f19092b, l.f19096a);
            return new k(r9.a().a(), new kotlin.s0.w.d.l0.c.s1.a.a(r9.b(), r7), null);
        }
    }

    static {
        f19093c = new a(null);
    }

    private k(kotlin.s0.w.d.l0.l.b.k r1, kotlin.s0.w.d.l0.c.s1.a.a r2) {
        this.f19094a = r1;
        this.f19095b = r2;
    }

    public /* synthetic */ k(kotlin.s0.w.d.l0.l.b.k r1, kotlin.s0.w.d.l0.c.s1.a.a r2, kotlin.n0.d.g r3) {
        this(r1, r2);
    }

    public final kotlin.s0.w.d.l0.l.b.k a() {
        return this.f19094a;
    }

    public final h0 b() {
        return this.f19094a.p();
    }

    public final kotlin.s0.w.d.l0.c.s1.a.a c() {
        return this.f19095b;
    }
}
