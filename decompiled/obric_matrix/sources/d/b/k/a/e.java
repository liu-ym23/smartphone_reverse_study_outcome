package d.b.k.a;

import androidx.annotation.ColorInt;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f13982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @ColorInt
    private int f13983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @ColorInt
    private int f13984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f13985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f13986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f13987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private c f13988g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d f13989h;

    static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f13990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f13991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f13992c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f13993d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f13994e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private float f13995f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private c f13996g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private d f13997h;

        public b() {
            this.f13990a = false;
            this.f13991b = 0.0f;
            this.f13992c = 0;
            this.f13993d = 0;
            this.f13994e = 0.0f;
            this.f13995f = 0.0f;
            this.f13997h = d.f13999g;
        }

        static /* synthetic */ boolean a(b r0) {
            return r0.f13990a;
        }

        static /* synthetic */ float b(b r0) {
            return r0.f13991b;
        }

        static /* synthetic */ int c(b r0) {
            return r0.f13992c;
        }

        static /* synthetic */ int d(b r0) {
            return r0.f13993d;
        }

        static /* synthetic */ float e(b r0) {
            return r0.f13994e;
        }

        static /* synthetic */ float f(b r0) {
            return r0.f13995f;
        }

        static /* synthetic */ c g(b r0) {
            return r0.f13996g;
        }

        static /* synthetic */ d h(b r0) {
            return r0.f13997h;
        }

        public e i() {
            return new e(this, null);
        }

        public b j(float r1) {
            this.f13994e = r1;
            return this;
        }
    }

    public static class c {
        public float a() {
            throw null;
        }
    }

    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f13998f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final d f13999g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ d[] f14000h = null;

        static {
            d r0 = new d("OVERLAY_COLOR", 0);
            f13998f = r0;
            d r1 = new d("BITMAP_ONLY", 1);
            f13999g = r1;
            f14000h = new d[]{r0, r1};
        }

        private d(String r1, int r2) {
            super(r1, r2);
        }

        public static d valueOf(String r1) {
            return (d) Enum.valueOf(d.class, r1);
        }

        public static d[] values() {
            return (d[]) f14000h.clone();
        }
    }

    private e(b r2) {
        this.f13985d = b.a(r2);
        this.f13982a = b.b(r2);
        this.f13983b = b.c(r2);
        this.f13984c = b.d(r2);
        this.f13986e = b.e(r2);
        this.f13987f = b.f(r2);
        b.g(r2);
        this.f13989h = b.h(r2);
    }

    /* synthetic */ e(b r1, a r2) {
        this(r1);
    }

    public static b i() {
        return new b();
    }

    public int a() {
        return this.f13983b;
    }

    public float b() {
        return this.f13982a;
    }

    public c c() {
        return this.f13988g;
    }

    public float d() {
        return this.f13986e;
    }

    public int e() {
        return this.f13984c;
    }

    public float f() {
        return this.f13987f;
    }

    public d g() {
        return this.f13989h;
    }

    public boolean h() {
        return this.f13985d;
    }
}
