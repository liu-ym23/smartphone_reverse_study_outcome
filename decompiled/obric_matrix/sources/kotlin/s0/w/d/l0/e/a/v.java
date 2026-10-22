package kotlin.s0.w.d.l0.e.a;

/* JADX INFO: loaded from: classes2.dex */
public final class v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f19644d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final v f19645e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f0 f19646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.f f19647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f0 f19648c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final v a() {
            return v.a();
        }
    }

    static {
        f19644d = new a(null);
        f19645e = new v(f0.f19255i, null, null, 6, null);
    }

    public v(f0 r2, kotlin.f r3, f0 r4) {
        kotlin.n0.d.o.f(r2, "reportLevelBefore");
        kotlin.n0.d.o.f(r4, "reportLevelAfter");
        this.f19646a = r2;
        this.f19647b = r3;
        this.f19648c = r4;
    }

    public /* synthetic */ v(f0 r2, kotlin.f r3, f0 r4, int r5, kotlin.n0.d.g r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = new kotlin.f(1, 0);
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = r2;
    L8:
        this(r2, r3, r4);
    }

    public static final /* synthetic */ v a() {
        return f19645e;
    }

    public final f0 b() {
        return this.f19648c;
    }

    public final f0 c() {
        return this.f19646a;
    }

    public final kotlin.f d() {
        return this.f19647b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof v) == true) goto L8;
        return false;
    L8:
        v r6 = (v) r5;
        if (this.f19646a == r6.f19646a) goto L12;
        return false;
    L12:
        if (kotlin.n0.d.o.a(this.f19647b, r6.f19647b) == true) goto L15;
        return false;
    L15:
        if (this.f19648c == r6.f19648c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.f19646a.hashCode() * 31;
        kotlin.f r1 = this.f19647b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.f19648c.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "JavaNullabilityAnnotationsStatus(reportLevelBefore=" + this.f19646a + ", sinceVersion=" + this.f19647b + ", reportLevelAfter=" + this.f19648c + ')';
    }
}
