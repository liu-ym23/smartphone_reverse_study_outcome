package kotlin.s0.w.d.l0.e.b;

/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f19794b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19795a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final t a(String r2, String r3) {
            kotlin.n0.d.o.f(r2, "name");
            kotlin.n0.d.o.f(r3, "desc");
            return new t(r2 + '#' + r3, null);
        }

        public final t b(kotlin.s0.w.d.l0.f.a0.b.d r2) {
            kotlin.n0.d.o.f(r2, "signature");
            if ((r2 instanceof kotlin.s0.w.d.l0.f.a0.b.d.b) == false) goto L6;
            return d(r2.c(), r2.b());
        L6:
            if ((r2 instanceof kotlin.s0.w.d.l0.f.a0.b.d.a) == false) goto L10;
            return a(r2.c(), r2.b());
        L10:
            throw new kotlin.m();
        }

        public final t c(kotlin.s0.w.d.l0.f.z.c r2, kotlin.s0.w.d.l0.f.a0.a.c r3) {
            kotlin.n0.d.o.f(r2, "nameResolver");
            kotlin.n0.d.o.f(r3, "signature");
            return d(r2.b(r3.w()), r2.b(r3.v()));
        }

        public final t d(String r2, String r3) {
            kotlin.n0.d.o.f(r2, "name");
            kotlin.n0.d.o.f(r3, "desc");
            return new t(r2 + r3, null);
        }

        public final t e(t r2, int r3) {
            kotlin.n0.d.o.f(r2, "signature");
            return new t(r2.a() + '@' + r3, null);
        }
    }

    static {
        f19794b = new a(null);
    }

    private t(String r1) {
        this.f19795a = r1;
    }

    public /* synthetic */ t(String r1, kotlin.n0.d.g r2) {
        this(r1);
    }

    public final String a() {
        return this.f19795a;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof t) == true) goto L9;
        return false;
    L9:
        if (kotlin.n0.d.o.a(this.f19795a, ((t) r4).f19795a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f19795a.hashCode();
    }

    public String toString() {
        return "MemberSignature(signature=" + this.f19795a + ')';
    }
}
