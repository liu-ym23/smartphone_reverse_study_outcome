package kotlin.s0.w.d.l0.l.b;

import kotlin.s0.w.d.l0.c.a1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.f.z.c f20898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.f.z.g f20899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a1 f20900c;

    public static final class a extends z {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.f.c f20901d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final a f20902e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.g.b f20903f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.f.c.EnumC0545c f20904g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f20905h;

        public a(kotlin.s0.w.d.l0.f.c r2, kotlin.s0.w.d.l0.f.z.c r3, kotlin.s0.w.d.l0.f.z.g r4, a1 r5, a r6) {
            kotlin.n0.d.o.f(r2, "classProto");
            kotlin.n0.d.o.f(r3, "nameResolver");
            kotlin.n0.d.o.f(r4, "typeTable");
            super(r3, r4, r5, null);
            this.f20901d = r2;
            this.f20902e = r6;
            this.f20903f = x.a(r3, r2.E0());
            kotlin.s0.w.d.l0.f.c.EnumC0545c r7 = kotlin.s0.w.d.l0.f.z.b.f20235f.d(r2.D0());
            if (r7 != null) goto L5;
            r7 = kotlin.s0.w.d.l0.f.c.EnumC0545c.f19943g;
        L5:
            this.f20904g = r7;
            Boolean r8 = kotlin.s0.w.d.l0.f.z.b.f20236g.g(r2.D0());
            kotlin.n0.d.o.e(r8, "IS_INNER.get(classProto.flags)");
            this.f20905h = r8.booleanValue();
        }

        @Override // kotlin.s0.w.d.l0.l.b.z
        public kotlin.s0.w.d.l0.g.c a() {
            kotlin.s0.w.d.l0.g.c r1 = this.f20903f.b();
            kotlin.n0.d.o.e(r1, "classId.asSingleFqName()");
            return r1;
        }

        public final kotlin.s0.w.d.l0.g.b e() {
            return this.f20903f;
        }

        public final kotlin.s0.w.d.l0.f.c f() {
            return this.f20901d;
        }

        public final kotlin.s0.w.d.l0.f.c.EnumC0545c g() {
            return this.f20904g;
        }

        public final a h() {
            return this.f20902e;
        }

        public final boolean i() {
            return this.f20905h;
        }
    }

    public static final class b extends z {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.g.c f20906d;

        public b(kotlin.s0.w.d.l0.g.c r2, kotlin.s0.w.d.l0.f.z.c r3, kotlin.s0.w.d.l0.f.z.g r4, a1 r5) {
            kotlin.n0.d.o.f(r2, "fqName");
            kotlin.n0.d.o.f(r3, "nameResolver");
            kotlin.n0.d.o.f(r4, "typeTable");
            super(r3, r4, r5, null);
            this.f20906d = r2;
        }

        @Override // kotlin.s0.w.d.l0.l.b.z
        public kotlin.s0.w.d.l0.g.c a() {
            return this.f20906d;
        }
    }

    private z(kotlin.s0.w.d.l0.f.z.c r1, kotlin.s0.w.d.l0.f.z.g r2, a1 r3) {
        this.f20898a = r1;
        this.f20899b = r2;
        this.f20900c = r3;
    }

    public /* synthetic */ z(kotlin.s0.w.d.l0.f.z.c r1, kotlin.s0.w.d.l0.f.z.g r2, a1 r3, kotlin.n0.d.g r4) {
        this(r1, r2, r3);
    }

    public abstract kotlin.s0.w.d.l0.g.c a();

    public final kotlin.s0.w.d.l0.f.z.c b() {
        return this.f20898a;
    }

    public final a1 c() {
        return this.f20900c;
    }

    public final kotlin.s0.w.d.l0.f.z.g d() {
        return this.f20899b;
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + a();
    }
}
