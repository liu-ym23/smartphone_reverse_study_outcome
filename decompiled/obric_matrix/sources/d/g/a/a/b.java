package d.g.a.a;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f16693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f16697e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f16698f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f16699g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f16700h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f16701i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f16702j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f16703k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f16704l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int p;
    private float q;

    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: d.g.a.a.b$b, reason: collision with other inner class name */
    public static class C0439b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f16705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f16706b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f16707c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f16708d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f16709e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f16710f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f16711g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f16712h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f16713i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f16714j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f16715k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f16716l;
        private boolean m;
        private boolean n;
        private boolean o;
        private boolean p;
        private int q;

        public C0439b(Context r3) {
            this.f16706b = 14;
            this.f16707c = 20971520;
            this.f16708d = 0.1f;
            this.f16709e = 2097152;
            this.f16712h = true;
            this.f16713i = true;
            this.f16714j = 3;
            this.f16715k = "fecbb32b759120b672045f74edc41d159b6a426ffc863b9e0be9ad4be12824546f549959b838993a430344f15197221e87bd362298814c75f5068148b980306f";
            this.f16716l = true;
            this.m = false;
            this.n = false;
            this.o = false;
            this.p = false;
            this.q = 256;
            if (r3 == null) goto L10;
            Context r0 = r3.getApplicationContext();
            if (r0 == null) goto L7;
            r3 = r0;
        L7:
            this.f16705a = r3;
            return;
        L10:
            throw new RuntimeException("context must not be null");
        }

        public b a() {
            b r0 = new b(null);
            r0.u(this.f16705a);
            r0.A(this.f16706b);
            r0.C(this.f16707c);
            r0.H(this.f16708d);
            r0.F(this.f16709e);
            if (TextUtils.isEmpty(this.f16710f) == false) goto L5;
            String r1 = d.g.a.a.i.a.a(this.f16705a);
        L6:
            r0.r(r1);
            if (TextUtils.isEmpty(this.f16711g) == false) goto L9;
            String r2 = d.g.a.a.i.a.b(this.f16705a).getAbsolutePath();
        L10:
            r0.z(r2);
            r0.t(this.f16712h);
            r0.x(this.f16713i);
            r0.y(this.f16714j);
            r0.G(this.f16715k);
            r0.B(this.f16716l);
            r0.E(this.m);
            r0.v(this.n);
            r0.w(this.p);
            r0.D(this.o);
            r0.s(this.q);
            return r0;
        L9:
            r2 = this.f16711g;
            goto L10
        L5:
            r1 = this.f16710f;
            goto L6
        }

        public C0439b b(boolean r1) {
            this.f16712h = r1;
            return this;
        }

        public C0439b c(boolean r1) {
            this.f16713i = r1;
            return this;
        }

        public C0439b d(int r1) {
            this.f16714j = r1;
            return this;
        }

        public C0439b e(String r1) {
            this.f16711g = r1;
            return this;
        }

        public C0439b f(int r1) {
            this.f16706b = r1;
            return this;
        }

        public C0439b g(int r1) {
            this.f16707c = r1;
            return this;
        }

        public C0439b h(boolean r1) {
            this.m = r1;
            return this;
        }
    }

    private b() {
    }

    /* synthetic */ b(a r1) {
        this();
    }

    public void A(int r1) {
        this.f16694b = r1;
    }

    public void B(boolean r1) {
        this.f16703k = r1;
    }

    public void C(int r1) {
        this.f16695c = r1;
    }

    public void D(boolean r1) {
        this.n = r1;
    }

    public void E(boolean r1) {
        this.f16704l = r1;
    }

    public void F(int r1) {
        this.f16696d = r1;
    }

    public void G(String r1) {
        this.f16702j = r1;
    }

    public void H(float r1) {
        this.q = r1;
    }

    public boolean a() {
        return this.m;
    }

    public boolean b() {
        return this.o;
    }

    public String c() {
        return this.f16697e;
    }

    public int d() {
        return this.p;
    }

    public Context e() {
        return this.f16693a;
    }

    public int f() {
        return this.f16701i;
    }

    public String g() {
        return this.f16698f;
    }

    public int h() {
        return this.f16694b;
    }

    public int i() {
        return this.f16695c;
    }

    public int j() {
        return this.f16696d;
    }

    public String k() {
        return this.f16702j;
    }

    public float l() {
        return this.q;
    }

    public boolean m() {
        return this.f16699g;
    }

    public boolean n() {
        return this.f16700h;
    }

    public boolean o() {
        return this.f16703k;
    }

    public boolean p() {
        return this.n;
    }

    public boolean q() {
        return this.f16704l;
    }

    public void r(String r1) {
        this.f16697e = r1;
    }

    public void s(int r1) {
        this.p = r1;
    }

    public void t(boolean r1) {
        this.f16699g = r1;
    }

    public void u(Context r1) {
        this.f16693a = r1;
    }

    public void v(boolean r1) {
        this.m = r1;
    }

    public void w(boolean r1) {
        this.o = r1;
    }

    public void x(boolean r1) {
        this.f16700h = r1;
    }

    public void y(int r1) {
        this.f16701i = r1;
    }

    public void z(String r1) {
        this.f16698f = r1;
    }
}
