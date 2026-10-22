package kotlin.s0.w.d.l0.e.b;

/* JADX INFO: loaded from: classes2.dex */
public interface o extends kotlin.s0.w.d.l0.l.b.u {

    public static abstract class a {

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.e.b.o$a$a, reason: collision with other inner class name */
        public static final class C0532a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final byte[] f19790a;

            public final byte[] b() {
                return this.f19790a;
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final q f19791a;

            public b(q r1, byte[] r2) {
                kotlin.n0.d.o.f(r1, "kotlinJvmBinaryClass");
                super(null);
                this.f19791a = r1;
            }

            public /* synthetic */ b(q r1, byte[] r2, int r3, kotlin.n0.d.g r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = null;
            L5:
                this(r1, r2);
            }

            public final q b() {
                return this.f19791a;
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final q a() {
            if ((this instanceof b) == false) goto L5;
            b r2 = (b) this;
        L6:
            if (r2 != null) goto L8;
            return null;
        L8:
            return r2.b();
        L5:
            r2 = null;
            goto L6
        }
    }

    a a(kotlin.s0.w.d.l0.e.a.n0.g r1);

    a c(kotlin.s0.w.d.l0.g.b r1);
}
