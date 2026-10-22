package d.c.i.q;

import android.net.Uri;
import android.text.TextUtils;
import d.c.c.d.h;
import d.c.i.f.g;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f16491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Uri f16492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Uri> f16493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f16494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private File f16495e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f16496f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f16497g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f16498h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f16499i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final d.c.i.f.c f16500j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final d.c.i.f.f f16501k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final g f16502l;
    private final d.c.i.f.a m;
    private final d.c.i.f.e n;
    private final EnumC0435b o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private final d s;
    private final d.c.i.m.d t;
    private final String u;
    private d.c.i.a v;
    private boolean w;
    private boolean x;
    private boolean y;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f16503f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f16504g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f16505h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ a[] f16506i = null;

        static {
            a r0 = new a("CUSTOM", 0);
            f16503f = r0;
            a r1 = new a("SMALL", 1);
            f16504g = r1;
            a r3 = new a("DEFAULT", 2);
            f16505h = r3;
            f16506i = new a[]{r0, r1, r3};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f16506i.clone();
        }
    }

    /* JADX INFO: renamed from: d.c.i.q.b$b, reason: collision with other inner class name */
    public static final enum EnumC0435b extends Enum<EnumC0435b> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final EnumC0435b f16507g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final EnumC0435b f16508h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final EnumC0435b f16509i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final EnumC0435b f16510j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final /* synthetic */ EnumC0435b[] f16511k = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f16512f;

        static {
            EnumC0435b r0 = new EnumC0435b("FULL_FETCH", 0, 1);
            f16507g = r0;
            EnumC0435b r1 = new EnumC0435b("DISK_CACHE", 1, 2);
            f16508h = r1;
            EnumC0435b r4 = new EnumC0435b("ENCODED_MEMORY_CACHE", 2, 3);
            f16509i = r4;
            EnumC0435b r6 = new EnumC0435b("BITMAP_MEMORY_CACHE", 3, 4);
            f16510j = r6;
            f16511k = new EnumC0435b[]{r0, r1, r4, r6};
        }

        private EnumC0435b(String r1, int r2, int r3) {
            super(r1, r2);
            this.f16512f = r3;
        }

        public static EnumC0435b a(EnumC0435b r2, EnumC0435b r3) {
            if (r2.b() <= r3.b()) goto L6;
            return r2;
        L6:
            return r3;
        }

        public static EnumC0435b valueOf(String r1) {
            return (EnumC0435b) Enum.valueOf(EnumC0435b.class, r1);
        }

        public static EnumC0435b[] values() {
            return (EnumC0435b[]) f16511k.clone();
        }

        public int b() {
            return this.f16512f;
        }
    }

    protected b(c r3) {
        this.f16491a = r3.e();
        Uri r0 = r3.o();
        this.f16492b = r0;
        this.f16493c = r3.c();
        this.f16494d = x(r0, r3.i());
        this.f16496f = r3.u();
        this.f16498h = r3.t();
        this.f16497g = r3.v();
        this.f16499i = r3.q();
        this.f16500j = r3.g();
        this.f16501k = r3.m();
        if (r3.n() != null) goto L5;
        g r1 = g.a();
    L6:
        this.f16502l = r1;
        this.m = r3.d();
        this.n = r3.l();
        this.o = r3.h();
        this.p = r3.p();
        this.q = r3.w();
        this.r = r3.r();
        this.s = r3.j();
        this.t = r3.k();
        this.u = r3.f();
        this.w = r3.s();
        return;
    L5:
        r1 = r3.n();
        goto L6
    }

    public static b a(Uri r0) {
        if (r0 != null) goto L5;
        return null;
    L5:
        return c.x(r0).a();
    }

    private static int x(Uri r2, String r3) {
        if (r2 != null) goto L6;
        return -1;
    L6:
        if (d.c.c.k.f.k(r2) == false) goto L10;
        return 0;
    L10:
        if (d.c.c.k.f.i(r2) == false) goto L18;
        if (d.c.c.f.a.d(d.c.c.f.a.b(r2.getPath())) == false) goto L15;
        return 2;
    L15:
        return 3;
    L18:
        if (d.c.c.k.f.h(r2) == false) goto L32;
        if (TextUtils.isEmpty(r3) == false) goto L22;
        return 4;
    L22:
        if (d.c.c.f.a.d(r3) == false) goto L26;
        return 9;
    L26:
        if (d.c.c.f.a.c(r3) == false) goto L48;
        return 10;
    L48:
        return 4;
    L32:
        if (d.c.c.k.f.e(r2) == false) goto L36;
        return 5;
    L36:
        if (d.c.c.k.f.j(r2) == false) goto L40;
        return 6;
    L40:
        if (d.c.c.k.f.d(r2) == false) goto L44;
        return 7;
    L44:
        if (d.c.c.k.f.l(r2) == false) goto L47;
        return 8;
    L47:
        return -1;
    }

    public boolean A() {
        return this.w;
    }

    public boolean B() {
        if (C() == true) goto L5;
    L7:
        return false;
    L5:
        if (r() == null) goto L7;
        return true;
    }

    public boolean C() {
        return this.q;
    }

    public boolean D() {
        return this.y;
    }

    public void E(boolean r1) {
        this.x = r1;
    }

    public void F(d.c.i.a r1) {
        this.v = r1;
    }

    public void G(boolean r1) {
        this.y = r1;
    }

    public List<Uri> b() {
        return this.f16493c;
    }

    public d.c.i.f.a c() {
        return this.m;
    }

    public a d() {
        return this.f16491a;
    }

    public String e() {
        return this.u;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof b) == true) goto L5;
        return false;
    L5:
        b r5 = (b) r4;
        if (h.a(this.f16492b, r5.f16492b) == true) goto L8;
    L29:
        return false;
    L8:
        if (h.a(this.f16491a, r5.f16491a) == false) goto L29;
        if (h.a(this.f16495e, r5.f16495e) == false) goto L29;
        if (h.a(this.m, r5.m) == false) goto L29;
        if (h.a(this.f16500j, r5.f16500j) == false) goto L29;
        if (h.a(this.f16501k, r5.f16501k) == false) goto L29;
        if (h.a(this.f16502l, r5.f16502l) == false) goto L29;
        d r3 = this.s;
        d.c.b.a.d r0 = null;
        if (r3 == null) goto L23;
        d.c.b.a.d r6 = r3.c();
    L24:
        d r7 = r5.s;
        if (r7 == null) goto L28;
        r0 = r7.c();
    L28:
        return h.a(r6, r0);
    L23:
        r6 = null;
        goto L24
    }

    public boolean f() {
        return this.x;
    }

    public d.c.i.f.c g() {
        return this.f16500j;
    }

    public boolean h() {
        return this.f16499i;
    }

    public int hashCode() {
        d r0 = this.s;
        if (r0 == null) goto L5;
        d.c.b.a.d r1 = r0.c();
    L7:
        return h.b(new Object[]{this.f16491a, this.f16492b, this.f16495e, this.m, this.f16500j, this.f16501k, this.f16502l, r1});
    L5:
        r1 = null;
        goto L7
    }

    public EnumC0435b i() {
        return this.o;
    }

    public d j() {
        return this.s;
    }

    public int k() {
        d.c.i.f.f r0 = this.f16501k;
        if (r0 != null) goto L7;
        return 2048;
    L7:
        return r0.f16022b;
    }

    public int l() {
        d.c.i.f.f r0 = this.f16501k;
        if (r0 != null) goto L7;
        return 2048;
    L7:
        return r0.f16021a;
    }

    public d.c.i.f.e m() {
        return this.n;
    }

    public boolean n() {
        return this.f16498h;
    }

    public boolean o() {
        return this.f16496f;
    }

    public boolean p() {
        return this.f16497g;
    }

    public d.c.i.m.d q() {
        return this.t;
    }

    public d.c.i.f.f r() {
        return this.f16501k;
    }

    public g s() {
        return this.f16502l;
    }

    public d.c.i.a t() {
        return this.v;
    }

    public String toString() {
        h.b r0 = h.d(this);
        r0.b("uri", this.f16492b);
        r0.b("cacheChoice", this.f16491a);
        r0.b("decodeOptions", this.f16500j);
        r0.b("postprocessor", this.s);
        r0.b("priority", this.n);
        r0.b("resizeOptions", this.f16501k);
        r0.b("rotationOptions", this.f16502l);
        r0.b("bytesRange", this.m);
        return r0.toString();
    }

    public synchronized File u() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f16495e != null) goto L6;
        this.f16495e = new File(this.f16492b.getPath());     // Catch: Throwable -> L9
    L6:
        File r0 = this.f16495e;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public Uri v() {
        return this.f16492b;
    }

    public int w() {
        return this.f16494d;
    }

    public boolean y() {
        return this.p;
    }

    public boolean z() {
        return this.r;
    }
}
