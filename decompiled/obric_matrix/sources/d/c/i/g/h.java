package d.c.i.g;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.facebook.imagepipeline.memory.d0;
import com.facebook.imagepipeline.memory.e0;
import d.c.i.e.n;
import d.c.i.e.r;
import d.c.i.e.u;
import d.c.i.p.g0;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    private static c B;
    private final boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.c.d.l<r> f16048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.i.e.h.c f16049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.c.i.e.f f16050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f16051d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f16052e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final f f16053f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final d.c.c.d.l<r> f16054g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final e f16055h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final n f16056i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final d.c.i.i.c f16057j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final d.c.i.s.c f16058k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Integer f16059l;
    private final d.c.c.d.l<Boolean> m;
    private final d.c.b.b.c n;
    private final d.c.c.g.d o;
    private final int p;
    private final g0 q;
    private final int r;
    private final e0 s;
    private final d.c.i.i.f t;
    private final Set<d.c.i.m.d> u;
    private final boolean v;
    private final d.c.b.b.c w;
    private final HashMap<String, d.c.b.b.c> x;
    private final d.c.i.i.d y;
    private final i z;

    class a implements d.c.c.d.l<Boolean> {
        a(h r1) {
        }

        public Boolean a() {
            return Boolean.TRUE;
        }

        @Override // d.c.c.d.l
        public /* bridge */ /* synthetic */ Boolean get() {
            return a();
        }
    }

    public static class b {
        private int A;
        private final i.b B;
        private boolean C;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Bitmap.Config f16060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private d.c.c.d.l<r> f16061b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private d.c.i.e.h.c f16062c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private d.c.i.e.f f16063d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Context f16064e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f16065f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private d.c.c.d.l<r> f16066g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private e f16067h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private n f16068i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private d.c.i.i.c f16069j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private d.c.i.s.c f16070k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private Integer f16071l;
        private d.c.c.d.l<Boolean> m;
        private d.c.b.b.c n;
        private d.c.c.g.d o;
        private Integer p;
        private g0 q;
        private d.c.i.d.f r;
        private e0 s;
        private d.c.i.i.f t;
        private Set<d.c.i.m.d> u;
        private boolean v;
        private d.c.b.b.c w;
        private HashMap<String, d.c.b.b.c> x;
        private f y;
        private d.c.i.i.d z;

        private b(Context r3) {
            this.f16065f = false;
            this.f16071l = null;
            this.p = null;
            this.v = true;
            this.A = -1;
            this.B = new i.b(this);
            this.C = true;
            d.c.c.d.i.g(r3);
            this.f16064e = r3;
        }

        /* synthetic */ b(Context r1, a r2) {
            this(r1);
        }

        static /* synthetic */ f A(b r0) {
            return r0.y;
        }

        static /* synthetic */ boolean B(b r0) {
            return r0.f16065f;
        }

        static /* synthetic */ d.c.c.d.l C(b r0) {
            return r0.f16066g;
        }

        static /* synthetic */ i.b a(b r0) {
            return r0.B;
        }

        static /* synthetic */ n b(b r0) {
            return r0.f16068i;
        }

        static /* synthetic */ d.c.i.i.c c(b r0) {
            return r0.f16069j;
        }

        static /* synthetic */ Integer d(b r0) {
            return r0.f16071l;
        }

        static /* synthetic */ d.c.c.d.l e(b r0) {
            return r0.m;
        }

        static /* synthetic */ d.c.b.b.c f(b r0) {
            return r0.n;
        }

        static /* synthetic */ d.c.c.g.d g(b r0) {
            return r0.o;
        }

        static /* synthetic */ int h(b r0) {
            return r0.A;
        }

        static /* synthetic */ g0 i(b r0) {
            return r0.q;
        }

        static /* synthetic */ d.c.i.d.f j(b r0) {
            return r0.r;
        }

        static /* synthetic */ e0 k(b r0) {
            return r0.s;
        }

        static /* synthetic */ d.c.c.d.l l(b r0) {
            return r0.f16061b;
        }

        static /* synthetic */ d.c.i.i.f m(b r0) {
            return r0.t;
        }

        static /* synthetic */ Set n(b r0) {
            return r0.u;
        }

        static /* synthetic */ boolean o(b r0) {
            return r0.v;
        }

        static /* synthetic */ d.c.b.b.c p(b r0) {
            return r0.w;
        }

        static /* synthetic */ HashMap q(b r0) {
            return r0.x;
        }

        static /* synthetic */ d.c.i.i.d r(b r0) {
            return r0.z;
        }

        static /* synthetic */ e s(b r0) {
            return r0.f16067h;
        }

        static /* synthetic */ boolean t(b r0) {
            return r0.C;
        }

        static /* synthetic */ d.c.i.s.c u(b r0) {
            return r0.f16070k;
        }

        static /* synthetic */ Context v(b r0) {
            return r0.f16064e;
        }

        static /* synthetic */ Integer w(b r0) {
            return r0.p;
        }

        static /* synthetic */ d.c.i.e.h.c x(b r0) {
            return r0.f16062c;
        }

        static /* synthetic */ Bitmap.Config y(b r0) {
            return r0.f16060a;
        }

        static /* synthetic */ d.c.i.e.f z(b r0) {
            return r0.f16063d;
        }

        public h D() {
            return new h(this, null);
        }

        public b E(d.c.c.d.l<r> r1) {
            d.c.c.d.i.g(r1);
            this.f16061b = r1;
            return this;
        }

        public b F(Bitmap.Config r1) {
            this.f16060a = r1;
            return this;
        }

        public b G(boolean r1) {
            this.f16065f = r1;
            return this;
        }

        public b H(d.c.c.d.l<r> r1) {
            d.c.c.d.i.g(r1);
            this.f16066g = r1;
            return this;
        }

        public b I(d.c.b.b.c r1) {
            this.n = r1;
            return this;
        }

        public b J(d.c.c.g.d r1) {
            this.o = r1;
            return this;
        }

        public b K(g0 r1) {
            this.q = r1;
            return this;
        }

        public b L(e0 r1) {
            this.s = r1;
            return this;
        }

        public b M(Set<d.c.i.m.d> r1) {
            this.u = r1;
            return this;
        }

        public b N(d.c.b.b.c r1) {
            this.w = r1;
            return this;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f16072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f16073b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f16074c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f16075d;

        private c() {
            this.f16072a = false;
            this.f16073b = false;
            this.f16074c = false;
            this.f16075d = 30;
        }

        /* synthetic */ c(a r1) {
            this();
        }

        public int a() {
            return this.f16075d;
        }

        public boolean b() {
            return this.f16073b;
        }

        public boolean c() {
            return this.f16072a;
        }

        public boolean d() {
            return this.f16074c;
        }
    }

    static {
        B = new c(null);
    }

    private h(b r5) {
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("ImagePipelineConfig()");
    L5:
        i r0 = b.a(r5).m();
        this.z = r0;
        if (b.l(r5) != null) goto L8;
        d.c.c.d.l<r> r1 = new d.c.i.e.i((ActivityManager) b.v(r5).getSystemService("activity"));
    L9:
        this.f16048a = r1;
        if (b.x(r5) != null) goto L12;
        d.c.i.e.h.c r2 = new d.c.i.e.d();
    L13:
        this.f16049b = r2;
        if (b.y(r5) != null) goto L16;
        Bitmap.Config r3 = Bitmap.Config.ARGB_8888;
    L18:
        if (b.z(r5) != null) goto L20;
        d.c.i.e.f r4 = d.c.i.e.j.h();
    L21:
        this.f16050c = r4;
        Context r6 = b.v(r5);
        d.c.c.d.i.g(r6);
        this.f16051d = r6;
        if (b.A(r5) != null) goto L24;
        f r7 = new d.c.i.g.b(new d());
    L25:
        this.f16053f = r7;
        this.f16052e = b.B(r5);
        if (b.C(r5) != null) goto L28;
        d.c.c.d.l<r> r8 = new d.c.i.e.k();
    L29:
        this.f16054g = r8;
        if (b.b(r5) != null) goto L32;
        n r9 = u.n();
    L33:
        this.f16056i = r9;
        this.f16057j = b.c(r5);
        this.f16058k = q(r5);
        this.f16059l = b.d(r5);
        if (b.e(r5) != null) goto L36;
        d.c.c.d.l<Boolean> r10 = new a(this);
    L37:
        this.m = r10;
        if (b.f(r5) != null) goto L40;
        d.c.b.b.c r11 = h(b.v(r5));
    L41:
        this.n = r11;
        if (b.g(r5) != null) goto L44;
        d.c.c.g.d r12 = d.c.c.g.e.b();
    L45:
        this.o = r12;
        this.p = v(r5, r0);
        if (b.h(r5) >= 0) goto L48;
        int r13 = LocationInfoConst.HALF_MINUTES;
    L49:
        this.r = r13;
        if (d.c.i.r.b.d() == false) goto L53;
        d.c.i.r.b.a("ImagePipelineConfig->mNetworkFetcher");
    L53:
        if (b.i(r5) != null) goto L55;
        g0 r14 = new d.c.i.p.u(r13);
    L56:
        this.q = r14;
        if (d.c.i.r.b.d() == false) goto L59;
        d.c.i.r.b.b();
    L59:
        b.j(r5);
        if (b.k(r5) != null) goto L62;
        e0 r15 = new e0(d0.l().l());
    L63:
        this.s = r15;
        if (b.m(r5) != null) goto L66;
        d.c.i.i.f r16 = new d.c.i.i.h();
    L67:
        this.t = r16;
        if (b.n(r5) != null) goto L70;
        Set<d.c.i.m.d> r17 = new HashSet();
    L71:
        this.u = r17;
        this.v = b.o(r5);
        if (b.p(r5) == null) goto L75;
        r11 = b.p(r5);
    L75:
        this.w = r11;
        if (b.q(r5) != null) goto L78;
        HashMap<String, d.c.b.b.c> r18 = f();
    L79:
        this.x = r18;
        b.r(r5);
        int r19 = r15.d();
        if (b.s(r5) != null) goto L82;
        e r20 = new d.c.i.g.a(r19);
    L83:
        this.f16055h = r20;
        this.A = b.t(r5);
        d.c.c.l.b r21 = r0.h();
        if (r21 == null) goto L88;
        d.c.i.d.d r22 = new d.c.i.d.d(y());
    L86:
        G(r21, r0, r22);
    L95:
        if (d.c.i.r.b.d() == false) goto L98;
        d.c.i.r.b.b();
        return;
    L98:
        return;
    L88:
        if (r0.q() == false) goto L95;
        if (d.c.c.l.c.f15447a == false) goto L95;
        r21 = d.c.c.l.c.i();
        if (r21 == null) goto L95;
        r22 = new d.c.i.d.d(y());
        goto L86
    L82:
        r20 = b.s(r5);
        goto L83
    L78:
        r18 = b.q(r5);
        goto L79
    L70:
        r17 = b.n(r5);
        goto L71
    L66:
        r16 = b.m(r5);
        goto L67
    L62:
        r15 = b.k(r5);
        goto L63
    L55:
        r14 = b.i(r5);
        goto L56
    L48:
        r13 = b.h(r5);
        goto L49
    L44:
        r12 = b.g(r5);
        goto L45
    L40:
        r11 = b.f(r5);
        goto L41
    L36:
        r10 = b.e(r5);
        goto L37
    L32:
        r9 = b.b(r5);
        goto L33
    L28:
        r8 = b.C(r5);
        goto L29
    L24:
        r7 = b.A(r5);
        goto L25
    L20:
        r4 = b.z(r5);
        goto L21
    L16:
        b.y(r5);
        goto L18
    L12:
        r2 = b.x(r5);
        goto L13
    L8:
        r1 = b.l(r5);
        goto L9
    }

    /* synthetic */ h(b r1, a r2) {
        this(r1);
    }

    public static b F(Context r2) {
        return new b(r2, null);
    }

    private static void G(d.c.c.l.b r0, i r1, d.c.c.l.a r2) {
        d.c.c.l.c.f15449c = r0;
        d.c.c.l.b.a r3 = r1.i();
        if (r3 == null) goto L5;
        r0.c(r3);
    L5:
        if (r2 == null) goto L8;
        r0.a(r2);
        return;
    }

    private static HashMap<String, d.c.b.b.c> f() {
    L10:
        th = move-exception;
        if (d.c.i.r.b.d() == false) goto L14;
        d.c.i.r.b.b();
    L14:
        throw th;
    L3:
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("DiskCacheConfig.getDefaultCustomDiskCacheConfigMap");     // Catch: Throwable -> L10
    L5:
        HashMap<String, d.c.b.b.c> r0 = new HashMap();     // Catch: Throwable -> L10
        if (d.c.i.r.b.d() == false) goto L9;
        d.c.i.r.b.b();
    L9:
        return r0;
    }

    public static c g() {
        return B;
    }

    private static d.c.b.b.c h(Context r1) {
    L10:
        th = move-exception;
        if (d.c.i.r.b.d() == false) goto L14;
        d.c.i.r.b.b();
    L14:
        throw th;
    L3:
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("DiskCacheConfig.getDefaultMainDiskCacheConfig");     // Catch: Throwable -> L10
    L5:
        d.c.b.b.c r2 = d.c.b.b.c.q(r1).q();     // Catch: Throwable -> L10
        if (d.c.i.r.b.d() == false) goto L9;
        d.c.i.r.b.b();
    L9:
        return r2;
    }

    private static d.c.i.s.c q(b r1) {
        if (b.u(r1) == null) goto L10;
        if (b.d(r1) == null) goto L10;
        throw new IllegalStateException("You can't define a custom ImageTranscoderFactory and provide an ImageTranscoderType");
    L10:
        if (b.u(r1) != null) goto L12;
        return null;
    L12:
        return b.u(r1);
    }

    private static int v(b r1, i r2) {
        if (b.w(r1) == null) goto L7;
        return b.w(r1).intValue();
    L7:
        if (r2.m() == false) goto L10;
        return 1;
    L10:
        return 0;
    }

    public Set<d.c.i.m.d> A() {
        return Collections.unmodifiableSet(this.u);
    }

    public d.c.b.b.c B() {
        return this.w;
    }

    public boolean C() {
        return this.A;
    }

    public boolean D() {
        return this.f16052e;
    }

    public boolean E() {
        return this.v;
    }

    public d.c.c.d.l<r> a() {
        return this.f16048a;
    }

    public d.c.i.e.h.c b() {
        return this.f16049b;
    }

    public d.c.i.e.f c() {
        return this.f16050c;
    }

    public Context d() {
        return this.f16051d;
    }

    public HashMap<String, d.c.b.b.c> e() {
        return this.x;
    }

    public d.c.c.d.l<r> i() {
        return this.f16054g;
    }

    public e j() {
        return this.f16055h;
    }

    public i k() {
        return this.z;
    }

    public f l() {
        return this.f16053f;
    }

    public n m() {
        return this.f16056i;
    }

    public d.c.i.i.c n() {
        return this.f16057j;
    }

    public d.c.i.i.d o() {
        return this.y;
    }

    public d.c.i.s.c p() {
        return this.f16058k;
    }

    public Integer r() {
        return this.f16059l;
    }

    public d.c.c.d.l<Boolean> s() {
        return this.m;
    }

    public d.c.b.b.c t() {
        return this.n;
    }

    public int u() {
        return this.p;
    }

    public d.c.c.g.d w() {
        return this.o;
    }

    public g0 x() {
        return this.q;
    }

    public e0 y() {
        return this.s;
    }

    public d.c.i.i.f z() {
        return this.t;
    }
}
