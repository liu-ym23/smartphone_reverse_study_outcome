package kotlin.s0.w.d.l0.e.a;

/* JADX INFO: loaded from: classes2.dex */
public final class w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f19649d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final w f19650e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y f19651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.n0.c.l<kotlin.s0.w.d.l0.g.c, f0> f19652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f19653c;

    /* synthetic */ class a extends kotlin.n0.d.l implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.c, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f19654f = null;

        static {
            f19654f = new a();
        }

        a() {
            super(1);
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "getDefaultReportLevelForAnnotation";
        }

        @Override // kotlin.n0.d.c
        public final kotlin.s0.f getOwner() {
            return kotlin.n0.d.e0.d(u.class, "compiler.common.jvm");
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "getDefaultReportLevelForAnnotation(Lorg/jetbrains/kotlin/name/FqName;)Lorg/jetbrains/kotlin/load/java/ReportLevel;";
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(kotlin.s0.w.d.l0.g.c r1) {
            return m(r1);
        }

        public final f0 m(kotlin.s0.w.d.l0.g.c r1) {
            kotlin.n0.d.o.f(r1, "p0");
            return u.d(r1);
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.n0.d.g r1) {
            this();
        }

        public final w a() {
            return w.a();
        }
    }

    static {
        f19649d = new b(null);
        f19650e = new w(u.b(null, 1, null), a.f19654f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w(y r2, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.c, ? extends f0> r3) {
        kotlin.n0.d.o.f(r2, "jsr305");
        kotlin.n0.d.o.f(r3, "getReportLevelForAnnotation");
        this.f19651a = r2;
        this.f19652b = r3;
        if (r2.d() == false) goto L5;
    L8:
        boolean r4 = true;
    L9:
        this.f19653c = r4;
        return;
    L5:
        if (r3.invoke(u.e()) == f0.f19253g) goto L8;
        r4 = false;
        goto L9
    }

    public static final /* synthetic */ w a() {
        return f19650e;
    }

    public final boolean b() {
        return this.f19653c;
    }

    public final kotlin.n0.c.l<kotlin.s0.w.d.l0.g.c, f0> c() {
        return this.f19652b;
    }

    public final y d() {
        return this.f19651a;
    }

    public String toString() {
        return "JavaTypeEnhancementState(jsr305=" + this.f19651a + ", getReportLevelForAnnotation=" + this.f19652b + ')';
    }
}
