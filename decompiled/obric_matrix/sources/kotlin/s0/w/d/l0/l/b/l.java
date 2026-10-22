package kotlin.s0.w.d.l0.l.b;

/* JADX INFO: loaded from: classes2.dex */
public interface l {

    public static final class a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20842a = null;

        static {
            f20842a = new a();
        }

        private a() {
        }

        @Override // kotlin.s0.w.d.l0.l.b.l
        public boolean a() {
            return b.b(this);
        }

        @Override // kotlin.s0.w.d.l0.l.b.l
        public boolean b() {
            return b.a(this);
        }

        @Override // kotlin.s0.w.d.l0.l.b.l
        public boolean c() {
            return b.e(this);
        }

        @Override // kotlin.s0.w.d.l0.l.b.l
        public boolean d() {
            return b.d(this);
        }

        @Override // kotlin.s0.w.d.l0.l.b.l
        public boolean e() {
            return b.c(this);
        }

        @Override // kotlin.s0.w.d.l0.l.b.l
        public boolean f() {
            return b.f(this);
        }
    }

    public static final class b {
        public static boolean a(l r0) {
            return false;
        }

        public static boolean b(l r0) {
            return false;
        }

        public static boolean c(l r0) {
            return false;
        }

        public static boolean d(l r0) {
            return false;
        }

        public static boolean e(l r0) {
            return false;
        }

        public static boolean f(l r0) {
            return true;
        }
    }

    boolean a();

    boolean b();

    boolean c();

    boolean d();

    boolean e();

    boolean f();
}
