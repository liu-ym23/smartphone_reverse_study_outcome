package kotlin.s0.w.d.l0.b.p;

import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.g.f;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f18756h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f18757i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f18758j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c f18759k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final c f18760l = null;
    private static final /* synthetic */ c[] m = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.c f18761f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f18762g;

    public static final class a {

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.b.p.c$a$a, reason: collision with other inner class name */
        public static final class C0497a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final c f18763a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f18764b;

            public C0497a(c r2, int r3) {
                o.f(r2, "kind");
                this.f18763a = r2;
                this.f18764b = r3;
            }

            public final c a() {
                return this.f18763a;
            }

            public final int b() {
                return this.f18764b;
            }

            public final c c() {
                return this.f18763a;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0497a) == true) goto L8;
                return false;
            L8:
                C0497a r6 = (C0497a) r5;
                if (this.f18763a == r6.f18763a) goto L12;
                return false;
            L12:
                if (this.f18764b == r6.f18764b) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (this.f18763a.hashCode() * 31) + this.f18764b;
            }

            public String toString() {
                return "KindWithArity(kind=" + this.f18763a + ", arity=" + this.f18764b + ')';
            }
        }

        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }

        private final Integer d(String r8) {
            if (r8.length() != 0) goto L5;
            boolean r7 = true;
        L7:
            if (r7 == false) goto L9;
            return null;
        L9:
            int r9 = r8.length();
            int r3 = 0;
            int r4 = 0;
        L10:
            if (r3 >= r9) goto L21;
            int r5 = r8.charAt(r3) - '0';
            if (r5 >= 0) goto L14;
        L16:
            boolean r6 = false;
        L17:
            if (r6 == false) goto L18;
            r4 = (r4 * 10) + r5;
            r3 = r3 + 1;
            goto L10
        L18:
            return null;
        L14:
            if (r5 >= 10) goto L16;
            r6 = true;
            goto L17
        L21:
            return Integer.valueOf(r4);
        L5:
            r7 = false;
            goto L7
        }

        public final c a(kotlin.s0.w.d.l0.g.c r8, String r9) {
            o.f(r8, "packageFqName");
            o.f(r9, "className");
            c[] r7 = c.values();
            int r0 = r7.length;
            int r2 = 0;
        L4:
            if (r2 >= r0) goto L17;
            c r4 = r7[r2];
            if (o.a(r4.c(), r8) == true) goto L8;
        L10:
            boolean r3 = false;
        L11:
            if (r3 == true) goto L14;
            r2 = r2 + 1;
            goto L4
        L14:
            return r4;
        L8:
            if (k.A(r9, r4.b(), false, 2, null) == false) goto L10;
            r3 = true;
            goto L11
        L17:
            return null;
        }

        public final c b(String r2, kotlin.s0.w.d.l0.g.c r3) {
            o.f(r2, "className");
            o.f(r3, "packageFqName");
            C0497a r1 = c(r2, r3);
            if (r1 != null) goto L7;
            return null;
        L7:
            return r1.c();
        }

        public final C0497a c(String r3, kotlin.s0.w.d.l0.g.c r4) {
            o.f(r3, "className");
            o.f(r4, "packageFqName");
            c r5 = a(r4, r3);
            if (r5 != null) goto L5;
            return null;
        L5:
            String r6 = r3.substring(r5.b().length());
            o.e(r6, "this as java.lang.String).substring(startIndex)");
            Integer r2 = d(r6);
            if (r2 != null) goto L8;
            return null;
        L8:
            return new C0497a(r5, r2.intValue());
        }
    }

    static {
        f18757i = new c("Function", 0, kotlin.s0.w.d.l0.b.k.f18715k, "Function", false, false);
        f18758j = new c("SuspendFunction", 1, kotlin.s0.w.d.l0.b.k.f18709e, "SuspendFunction", true, false);
        kotlin.s0.w.d.l0.g.c r8 = kotlin.s0.w.d.l0.b.k.f18712h;
        f18759k = new c("KFunction", 2, r8, "KFunction", false, true);
        f18760l = new c("KSuspendFunction", 3, r8, "KSuspendFunction", true, true);
        m = a();
        f18756h = new a(null);
    }

    private c(String r1, int r2, kotlin.s0.w.d.l0.g.c r3, String r4, boolean r5, boolean r6) {
        super(r1, r2);
        this.f18761f = r3;
        this.f18762g = r4;
    }

    private static final /* synthetic */ c[] a() {
        return new c[]{f18757i, f18758j, f18759k, f18760l};
    }

    public static c valueOf(String r1) {
        return (c) Enum.valueOf(c.class, r1);
    }

    public static c[] values() {
        return (c[]) m.clone();
    }

    public final String b() {
        return this.f18762g;
    }

    public final kotlin.s0.w.d.l0.g.c c() {
        return this.f18761f;
    }

    public final f g(int r2) {
        f r1 = f.k(this.f18762g + r2);
        o.e(r1, "identifier(\"$classNamePrefix$arity\")");
        return r1;
    }
}
