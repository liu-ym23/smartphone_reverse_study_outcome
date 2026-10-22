package d.c.i.q;

import android.net.Uri;
import d.c.c.d.i;
import d.c.i.f.g;
import d.c.i.g.h;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Uri f16513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<Uri> f16514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b.EnumC0435b f16515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d.c.i.f.f f16516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private g f16517e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d.c.i.f.c f16518f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b.a f16519g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f16520h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f16521i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f16522j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f16523k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private d.c.i.f.e f16524l;
    private d m;
    private boolean n;
    private boolean o;
    private boolean p;
    private d.c.i.m.d q;
    private d.c.i.f.a r;
    private String s;
    private String t;
    private boolean u;

    public static class a extends RuntimeException {
        public a(String r3) {
            super("Invalid request builder: " + r3);
        }
    }

    private c() {
        this.f16513a = null;
        this.f16514b = null;
        this.f16515c = b.EnumC0435b.f16507g;
        this.f16516d = null;
        this.f16517e = null;
        this.f16518f = d.c.i.f.c.a();
        this.f16519g = b.a.f16505h;
        this.f16520h = h.g().c();
        this.f16521i = h.g().b();
        this.f16522j = h.g().d();
        this.f16523k = false;
        this.f16524l = d.c.i.f.e.f16016g;
        this.m = null;
        this.n = true;
        this.o = false;
        this.p = true;
        this.r = null;
        this.s = null;
        this.u = !this.f16521i;
    }

    public static c b(b r2) {
        c r0 = x(r2.v());
        r0.B(r2.g());
        r0.z(r2.c());
        r0.A(r2.d());
        r0.C(r2.h());
        r0.D(r2.i());
        r0.E(r2.j());
        r0.F(r2.o());
        r0.H(r2.m());
        r0.I(r2.r());
        r0.G(r2.q());
        r0.J(r2.s());
        return r0;
    }

    public static c x(Uri r1) {
        c r0 = new c();
        r0.K(r1);
        return r0;
    }

    public c A(b.a r1) {
        this.f16519g = r1;
        return this;
    }

    public c B(d.c.i.f.c r1) {
        this.f16518f = r1;
        return this;
    }

    public c C(boolean r1) {
        this.f16523k = r1;
        return this;
    }

    public c D(b.EnumC0435b r1) {
        this.f16515c = r1;
        return this;
    }

    public c E(d r1) {
        this.m = r1;
        return this;
    }

    public c F(boolean r1) {
        this.f16520h = r1;
        return this;
    }

    public c G(d.c.i.m.d r1) {
        this.q = r1;
        return this;
    }

    public c H(d.c.i.f.e r1) {
        this.f16524l = r1;
        return this;
    }

    public c I(d.c.i.f.f r1) {
        this.f16516d = r1;
        return this;
    }

    public c J(g r1) {
        this.f16517e = r1;
        return this;
    }

    public c K(Uri r1) {
        i.g(r1);
        this.f16513a = r1;
        return this;
    }

    protected void L() {
        Uri r0 = this.f16513a;
        if (r0 == null) goto L34;
        if (d.c.c.k.f.j(r0) == false) goto L19;
        if (this.f16513a.isAbsolute() == false) goto L17;
        if (this.f16513a.getPath().isEmpty() == true) goto L15;
        Integer.parseInt(this.f16513a.getPath().substring(1));     // Catch: NumberFormatException -> L12
    L13:
        throw new a("Resource URI path must be a resource id.");
    L15:
        throw new a("Resource URI must not be empty");
    L17:
        throw new a("Resource URI path must be absolute.");
    L19:
        if (this.s != null) goto L26;
        if (this.f16519g.equals(b.a.f16503f) == false) goto L26;
        throw new a("CustomCacheName must be set as you have choice your cacheChoice as 'CUSTOM'");
    L26:
        if (d.c.c.k.f.e(this.f16513a) == true) goto L28;
        return;
    L28:
        if (this.f16513a.isAbsolute() == false) goto L31;
        return;
    L31:
        throw new a("Asset URI path must be absolute.");
    L34:
        throw new a("Source must be set!");
    }

    public b a() {
        L();
        return new b(this);
    }

    public List<Uri> c() {
        return this.f16514b;
    }

    public d.c.i.f.a d() {
        return this.r;
    }

    public b.a e() {
        return this.f16519g;
    }

    public String f() {
        return this.s;
    }

    public d.c.i.f.c g() {
        return this.f16518f;
    }

    public b.EnumC0435b h() {
        return this.f16515c;
    }

    public String i() {
        return this.t;
    }

    public d j() {
        return this.m;
    }

    public d.c.i.m.d k() {
        return this.q;
    }

    public d.c.i.f.e l() {
        return this.f16524l;
    }

    public d.c.i.f.f m() {
        return this.f16516d;
    }

    public g n() {
        return this.f16517e;
    }

    public Uri o() {
        return this.f16513a;
    }

    public boolean p() {
        if (this.n == true) goto L5;
    L7:
        return false;
    L5:
        if (d.c.c.k.f.k(this.f16513a) == false) goto L7;
        return true;
    }

    public boolean q() {
        return this.f16523k;
    }

    public boolean r() {
        return this.p;
    }

    public boolean s() {
        return this.u;
    }

    public boolean t() {
        return this.f16521i;
    }

    public boolean u() {
        return this.f16520h;
    }

    public boolean v() {
        return this.f16522j;
    }

    public boolean w() {
        return this.o;
    }

    @Deprecated
    public c y(boolean r1) {
        if (r1 == false) goto L6;
        g r2 = g.a();
    L4:
        J(r2);
        return this;
    L6:
        r2 = g.d();
        goto L4
    }

    public c z(d.c.i.f.a r1) {
        this.r = r1;
        return this;
    }
}
