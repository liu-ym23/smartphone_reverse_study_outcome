package d.b.k.a;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f14023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bitmap.Config f14024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private m f14026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private File f14027e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f14028f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f14029g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f14030h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f14031i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f14032j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f14033k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private d.b.k.a.w.b.a f14034l;
    private boolean m;
    private boolean n;
    private d.b.k.a.y.j o;
    private List<d.b.k.a.a> p;
    private boolean q;
    private l r;

    static /* synthetic */ class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f14035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private m f14036b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private File f14037c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f14038d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f14039e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f14040f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f14041g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f14042h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private d.b.k.a.w.b.a f14043i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Bitmap.Config f14044j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f14045k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f14046l;
        private boolean m;
        private d.b.k.a.y.j n;
        private boolean o;
        private List<d.b.k.a.a> p;
        private boolean q;
        private l r;

        b(Context r2) {
            this.f14042h = 5;
            this.f14045k = -1;
            this.q = true;
            this.f14035a = r2;
        }

        static /* synthetic */ Context a(b r0) {
            return r0.f14035a;
        }

        static /* synthetic */ m b(b r0) {
            return r0.f14036b;
        }

        static /* synthetic */ int c(b r0) {
            return r0.f14045k;
        }

        static /* synthetic */ boolean d(b r0) {
            return r0.f14046l;
        }

        static /* synthetic */ d.b.k.a.y.j e(b r0) {
            return r0.n;
        }

        static /* synthetic */ boolean f(b r0) {
            return r0.o;
        }

        static /* synthetic */ boolean g(b r0) {
            return r0.m;
        }

        static /* synthetic */ List h(b r0) {
            return r0.p;
        }

        static /* synthetic */ boolean i(b r0) {
            return r0.q;
        }

        static /* synthetic */ l j(b r0) {
            return r0.r;
        }

        static /* synthetic */ File k(b r0) {
            return r0.f14037c;
        }

        static /* synthetic */ long l(b r2) {
            return r2.f14038d;
        }

        static /* synthetic */ long m(b r2) {
            return r2.f14039e;
        }

        static /* synthetic */ long n(b r2) {
            return r2.f14040f;
        }

        static /* synthetic */ long o(b r2) {
            return r2.f14041g;
        }

        static /* synthetic */ int p(b r0) {
            return r0.f14042h;
        }

        static /* synthetic */ d.b.k.a.w.b.a q(b r0) {
            return r0.f14043i;
        }

        static /* synthetic */ Bitmap.Config r(b r0) {
            return r0.f14044j;
        }

        public b s(Bitmap.Config r1) {
            this.f14044j = r1;
            return this;
        }

        public r t() {
            return new r(this, null);
        }

        public b u(boolean r1) {
            this.o = r1;
            return this;
        }

        public b v(int r1) {
            this.f14045k = r1;
            return this;
        }
    }

    private r(b r3) {
        this.f14023a = b.a(r3);
        this.f14026d = b.b(r3);
        this.f14027e = b.k(r3);
        this.f14030h = b.l(r3);
        this.f14028f = b.m(r3);
        this.f14029g = b.n(r3);
        this.f14031i = b.o(r3);
        this.f14032j = b.p(r3);
        b.q(r3);
        this.f14024b = b.r(r3);
        this.f14025c = b.c(r3);
        this.m = b.d(r3);
        this.o = b.e(r3);
        this.f14033k = b.f(r3);
        this.n = b.g(r3);
        this.p = b.h(r3);
        this.q = b.i(r3);
        this.r = b.j(r3);
    }

    /* synthetic */ r(b r1, a r2) {
        this(r1);
    }

    public static b s(Context r1) {
        return new b(r1);
    }

    public List<d.b.k.a.a> a() {
        return this.p;
    }

    public Bitmap.Config b() {
        return this.f14024b;
    }

    public Context c() {
        return this.f14023a;
    }

    public d.b.k.a.w.b.a d() {
        return this.f14034l;
    }

    public int e() {
        return this.f14032j;
    }

    public File f() {
        return this.f14027e;
    }

    public m g() {
        return this.f14026d;
    }

    public d.b.k.a.y.j h() {
        return this.o;
    }

    public long i() {
        return this.f14028f;
    }

    public long j() {
        return this.f14030h;
    }

    public long k() {
        return this.f14029g;
    }

    public int l() {
        return this.f14025c;
    }

    public long m() {
        return this.f14031i;
    }

    public l n() {
        return this.r;
    }

    public boolean o() {
        return this.f14033k;
    }

    public boolean p() {
        return this.m;
    }

    public boolean q() {
        return this.n;
    }

    public boolean r() {
        return this.q;
    }
}
