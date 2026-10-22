package d.c.b.b;

import android.content.Context;
import d.c.c.d.l;
import d.c.c.d.m;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f15302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final l<File> f15304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f15305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f15306e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f15307f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final i f15308g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final d.c.b.a.a f15309h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final d.c.b.a.c f15310i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final d.c.c.a.b f15311j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Context f15312k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f15313l;
    private final boolean m;
    private final boolean n;
    private String o;
    private l<File> p;

    static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f15314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f15315b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private l<File> f15316c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f15317d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f15318e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f15319f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private i f15320g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private d.c.b.a.a f15321h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private d.c.b.a.c f15322i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private d.c.c.a.b f15323j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f15324k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f15325l;
        private boolean m;
        private String n;
        private l<File> o;
        private final Context p;

        class a implements l<File> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f15326a;

            a(b r1) {
                this.f15326a = r1;
            }

            public File a() {
                return b.c(this.f15326a).getApplicationContext().getCacheDir();
            }

            @Override // d.c.c.d.l
            public /* bridge */ /* synthetic */ File get() {
                return a();
            }
        }

        private b(Context r3) {
            this.f15314a = 1;
            this.f15315b = "image_cache";
            this.f15317d = 41943040;
            this.f15318e = 10485760;
            this.f15319f = 2097152;
            this.f15320g = new d.c.b.b.b();
            this.n = "image_config";
            this.p = r3;
        }

        /* synthetic */ b(Context r1, a r2) {
            this(r1);
        }

        static /* synthetic */ int a(b r0) {
            return r0.f15314a;
        }

        static /* synthetic */ String b(b r0) {
            return r0.f15315b;
        }

        static /* synthetic */ Context c(b r0) {
            return r0.p;
        }

        static /* synthetic */ boolean d(b r0) {
            return r0.f15324k;
        }

        static /* synthetic */ boolean e(b r0) {
            return r0.f15325l;
        }

        static /* synthetic */ boolean f(b r0) {
            return r0.m;
        }

        static /* synthetic */ String g(b r0) {
            return r0.n;
        }

        static /* synthetic */ l h(b r0) {
            return r0.o;
        }

        static /* synthetic */ l i(b r0) {
            return r0.f15316c;
        }

        static /* synthetic */ long j(b r2) {
            return r2.f15317d;
        }

        static /* synthetic */ long k(b r2) {
            return r2.f15318e;
        }

        static /* synthetic */ long l(b r2) {
            return r2.f15319f;
        }

        static /* synthetic */ i m(b r0) {
            return r0.f15320g;
        }

        static /* synthetic */ d.c.b.a.a n(b r0) {
            return r0.f15321h;
        }

        static /* synthetic */ d.c.b.a.c o(b r0) {
            return r0.f15322i;
        }

        static /* synthetic */ d.c.c.a.b p(b r0) {
            return r0.f15323j;
        }

        public c q() {
            if (this.f15316c == null) goto L5;
        L8:
            boolean r0 = true;
        L9:
            d.c.c.d.i.j(r0, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.f15316c != null) goto L15;
            if (this.p == null) goto L15;
            this.f15316c = new a(this);
        L15:
            if (this.o != null) goto L20;
            if (this.p == null) goto L20;
            this.o = this.f15316c;
        L20:
            return new c(this, null);
        L5:
            if (this.p != null) goto L8;
            r0 = false;
            goto L9
        }

        public b r(String r1) {
            this.f15315b = r1;
            return this;
        }

        public b s(File r1) {
            this.f15316c = m.a(r1);
            return this;
        }

        public b t(d.c.c.a.b r1) {
            this.f15323j = r1;
            return this;
        }

        public b u(long r1) {
            this.f15317d = r1;
            return this;
        }
    }

    private c(b r3) {
        this.f15302a = b.a(r3);
        String r0 = b.b(r3);
        d.c.c.d.i.g(r0);
        this.f15303b = r0;
        l<File> r1 = b.i(r3);
        d.c.c.d.i.g(r1);
        this.f15304c = r1;
        this.f15305d = b.j(r3);
        this.f15306e = b.k(r3);
        this.f15307f = b.l(r3);
        i r2 = b.m(r3);
        d.c.c.d.i.g(r2);
        this.f15308g = r2;
        if (b.n(r3) != null) goto L5;
        d.c.b.a.a r4 = d.c.b.a.h.b();
    L6:
        this.f15309h = r4;
        if (b.o(r3) != null) goto L9;
        d.c.b.a.c r5 = d.c.b.a.i.i();
    L10:
        this.f15310i = r5;
        if (b.p(r3) != null) goto L13;
        d.c.c.a.b r6 = d.c.c.a.c.b();
    L14:
        this.f15311j = r6;
        this.f15312k = b.c(r3);
        this.f15313l = b.d(r3);
        this.m = b.e(r3);
        this.n = b.f(r3);
        this.o = b.g(r3);
        this.p = b.h(r3);
        return;
    L13:
        r6 = b.p(r3);
        goto L14
    L9:
        r5 = b.o(r3);
        goto L10
    L5:
        r4 = b.n(r3);
        goto L6
    }

    /* synthetic */ c(b r1, a r2) {
        this(r1);
    }

    public static b q(Context r2) {
        return new b(r2, null);
    }

    public String a() {
        return this.f15303b;
    }

    public l<File> b() {
        return this.f15304c;
    }

    public d.c.b.a.a c() {
        return this.f15309h;
    }

    public d.c.b.a.c d() {
        return this.f15310i;
    }

    public String e() {
        return this.o;
    }

    public l<File> f() {
        return this.p;
    }

    public Context g() {
        return this.f15312k;
    }

    public long h() {
        return this.f15305d;
    }

    public d.c.c.a.b i() {
        return this.f15311j;
    }

    public i j() {
        return this.f15308g;
    }

    public boolean k() {
        return this.f15313l;
    }

    public long l() {
        return this.f15306e;
    }

    public long m() {
        return this.f15307f;
    }

    public boolean n() {
        return this.n;
    }

    public boolean o() {
        return this.m;
    }

    public int p() {
        return this.f15302a;
    }
}
