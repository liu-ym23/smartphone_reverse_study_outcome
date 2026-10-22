package kotlin.s0.w.d.l0.k.w;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20620a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final int f20621b = 0;

        static {
            f20620a = new a();
            d.a r0 = d.f20623c;
            int r1 = r0.b();
            int r2 = r0.d();
            f20621b = (~(r0.i() | r2)) & r1;
        }

        private a() {
        }

        @Override // kotlin.s0.w.d.l0.k.w.c
        public int a() {
            return f20621b;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f20622a = null;

        static {
            f20622a = new b();
        }

        private b() {
        }

        @Override // kotlin.s0.w.d.l0.k.w.c
        public int a() {
            return 0;
        }
    }

    public c() {
    }

    public abstract int a();

    public String toString() {
        return getClass().getSimpleName();
    }
}
