package d.c.i.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.facebook.imagepipeline.memory.e0;
import d.c.i.e.p;
import d.c.i.p.z0;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class j {
    private static final Class<?> u = null;
    private static j v;
    private static d.c.i.i.c w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z0 f16100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f16101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d.c.i.e.h<d.c.b.a.d, d.c.i.l.c> f16102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private p<d.c.b.a.d, d.c.i.l.c> f16103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d.c.i.e.h<d.c.b.a.d, d.c.c.g.h> f16104e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private p<d.c.b.a.d, d.c.c.g.h> f16105f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d.c.i.e.e f16106g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d.c.b.b.j f16107h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private d.c.i.i.c f16108i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private g f16109j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private d.c.i.s.c f16110k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private l f16111l;
    private m m;
    private d.c.i.e.e n;
    private HashMap<String, d.c.i.e.e> o;
    private d.c.b.b.j p;
    private HashMap<String, d.c.b.b.j> q;
    private d.c.i.d.f r;
    private d.c.i.n.g s;
    private d.c.i.c.b.a t;

    static {
        u = j.class;
    }

    public j(h r2) {
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("ImagePipelineConfig()");
    L5:
        d.c.c.d.i.g(r2);
        this.f16101b = r2;
        this.f16100a = new z0(r2.j().b());
        if (d.c.i.r.b.d() == false) goto L9;
        d.c.i.r.b.b();
        return;
    }

    public static d.c.i.d.f b(e0 r2, d.c.i.n.g r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 21) goto L7;
        return new d.c.i.d.a(r2.a());
    L7:
        if (r0 < 11) goto L11;
        return new d.c.i.d.e(new d.c.i.d.b(r2.g()), r3);
    L11:
        return new d.c.i.d.c();
    }

    public static d.c.i.n.g c(e0 r2, boolean r3, boolean r4) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 != 28) goto L8;
        if (r4 == false) goto L8;
        int r5 = r2.d();
        return new d.c.i.n.f(r2.a(), r5, new Pools.SynchronizedPool(r5));
    L8:
        if (r0 < 26) goto L12;
        int r6 = r2.d();
        return new d.c.i.n.e(r2.a(), r6, new Pools.SynchronizedPool(r6));
    L12:
        if (r0 < 21) goto L15;
        int r7 = r2.d();
        return new d.c.i.n.a(r2.a(), r7, new Pools.SynchronizedPool(r7));
    L15:
        if (r3 == false) goto L21;
        if (r0 >= 19) goto L21;
        return new d.c.i.n.c();
    L21:
        return new d.c.i.n.d(r2.c());
    }

    private d.c.i.i.c l() {
        if (this.f16108i != null) goto L18;
        if (this.f16101b.n() == null) goto L8;
        d.c.i.i.c r0 = this.f16101b.n();
    L7:
        this.f16108i = r0;
        goto L18
    L8:
        d.c.i.c.b.a r1 = e();
        d.c.i.i.c r5 = a();
        if (r1 == null) goto L11;
        d.c.i.i.c r2 = r1.b(Bitmap.Config.RGB_565);
        d.c.i.i.c r3 = r1.c(Bitmap.Config.RGB_565);
        d.c.i.i.c r4 = r1.d(Bitmap.Config.ARGB_8888);
    L13:
        if (this.f16101b.o() != null) goto L15;
        r0 = new d.c.i.i.b(r2, r3, r4, r5, s());
        goto L7
    L15:
        s();
        this.f16101b.o().a();
        throw null;
    L11:
        r2 = null;
        r3 = null;
        r4 = null;
    L18:
        return this.f16108i;
    }

    public static j o() {
        j r0 = v;
        d.c.c.d.i.h(r0, "ImagePipelineFactory was not initialized!");
        return r0;
    }

    private l t() {
        if (this.f16111l != null) goto L6;
        this.f16111l = this.f16101b.k().e().a(this.f16101b.d(), this.f16101b.y().j(), l(), this.f16101b.z(), this.f16101b.D(), this.f16101b.E(), this.f16101b.k().j(), this.f16101b.j(), this.f16101b.y().h(this.f16101b.u()), g(), k(), p(), v(), h(), this.f16101b.c(), r(), this.f16101b.k().c(), this.f16101b.k().b(), this.f16101b.k().a(), this.f16101b.k().d(), this.f16101b.k().n());
    L6:
        return this.f16111l;
    }

    private m u() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
    L7:
        boolean r0 = false;
    L8:
        boolean r9 = r0;
        if (this.m != null) goto L12;
        this.m = new m(this.f16101b.d().getApplicationContext().getContentResolver(), t(), this.f16101b.x(), this.f16101b.E(), this.f16101b.k().q(), this.f16100a, this.f16101b.D(), r9, this.f16101b.k().o(), this.f16101b.C(), n());
    L12:
        return this.m;
    L5:
        if (this.f16101b.k().f() == false) goto L7;
        r0 = true;
        goto L8
    }

    public static synchronized void x(Context r2) {
        monitor-enter(j.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (d.c.i.r.b.d() == false) goto L7;
        d.c.i.r.b.a("ImagePipelineFactory#initialize");     // Catch: Throwable -> L12
    L7:
        y(h.F(r2).D());     // Catch: Throwable -> L12
        if (d.c.i.r.b.d() == false) goto L10;
        d.c.i.r.b.b();     // Catch: Throwable -> L12
    L10:
        monitor-exit(j.class);
    }

    public static synchronized void y(h r3) {
        monitor-enter(j.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (v == null) goto L7;
        d.c.c.e.a.y(u, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");     // Catch: Throwable -> L10
    L7:
        v = new j(r3);     // Catch: Throwable -> L10
        monitor-exit(j.class);
    }

    protected d.c.i.i.c a() {
        if (w != null) goto L9;
        w = (d.c.i.i.c) Class.forName("com.bytedance.fresco.heif.HeifDecoder$HeifFormatDecoder").getConstructor(new Class[]{d.c.c.g.i.class}).newInstance(new Object[]{this.f16101b.y().g()});     // Catch: Throwable -> L6
    L6:
        return null;
    L9:
        return w;
    }

    @Nullable
    public d.c.i.j.a d(Context r1) {
        d.c.i.c.b.a r0 = e();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.a(r1);
    }

    @Nullable
    public d.c.i.c.b.a e() {
        if (this.t != null) goto L6;
        this.t = d.c.i.c.b.b.a(r(), this.f16101b.j(), f());
    L6:
        return this.t;
    }

    public d.c.i.e.h<d.c.b.a.d, d.c.i.l.c> f() {
        if (this.f16102c != null) goto L6;
        this.f16102c = d.c.i.e.a.a(this.f16101b.a(), this.f16101b.w(), this.f16101b.b());
    L6:
        return this.f16102c;
    }

    public p<d.c.b.a.d, d.c.i.l.c> g() {
        if (this.f16103d != null) goto L6;
        this.f16103d = d.c.i.e.b.a(f(), this.f16101b.m());
    L6:
        return this.f16103d;
    }

    public HashMap<String, d.c.i.e.e> h() {
        if (this.o != null) goto L12;
        this.o = new HashMap();
        HashMap<String, d.c.b.b.j> r0 = i();
        Iterator<String> r1 = r0.keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L12;
        String r2 = r1.next();
        d.c.i.e.e r10 = new d.c.i.e.e(r0.get(r2), this.f16101b.y().h(this.f16101b.u()), this.f16101b.y().i(), this.f16101b.j().e(), this.f16101b.j().d(), this.f16101b.m());
        d.c.b.b.c r3 = this.f16101b.e().get(r2);
        if (r3 == null) goto L10;
        r10.u(r3.o());
        r10.t(r3.n());
    L10:
        this.o.put(r2, r10);
    L12:
        return this.o;
    }

    public HashMap<String, d.c.b.b.j> i() {
        if (this.q != null) goto L9;
        this.q = new HashMap();
        HashMap<String, d.c.b.b.c> r0 = this.f16101b.e();
        Iterator<String> r1 = r0.keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L9;
        String r2 = r1.next();
        d.c.b.b.j r3 = this.f16101b.l().a(r0.get(r2));
        this.q.put(r2, r3);
    L9:
        return this.q;
    }

    public d.c.i.e.h<d.c.b.a.d, d.c.c.g.h> j() {
        if (this.f16104e != null) goto L6;
        this.f16104e = d.c.i.e.l.a(this.f16101b.i(), this.f16101b.w());
    L6:
        return this.f16104e;
    }

    public p<d.c.b.a.d, d.c.c.g.h> k() {
        if (this.f16105f != null) goto L6;
        this.f16105f = d.c.i.e.m.a(j(), this.f16101b.m());
    L6:
        return this.f16105f;
    }

    public g m() {
        if (this.f16109j != null) goto L6;
        this.f16109j = new g(u(), this.f16101b.A(), this.f16101b.s(), g(), k(), p(), v(), h(), this.f16101b.c(), this.f16100a, d.c.c.d.m.a(Boolean.FALSE), this.f16101b.k().l());
    L6:
        return this.f16109j;
    }

    protected d.c.i.s.c n() {
        if (this.f16110k != null) goto L14;
        if (this.f16101b.p() == null) goto L7;
    L11:
        d.c.i.s.c r0 = new d.c.i.s.e(this.f16101b.k().d(), this.f16101b.k().g(), this.f16101b.p(), this.f16101b.r());
    L12:
        this.f16110k = r0;
        goto L14
    L7:
        if (this.f16101b.r() != null) goto L11;
        if (this.f16101b.k().m() == false) goto L11;
        r0 = new d.c.i.s.g(this.f16101b.k().d());
    L14:
        return this.f16110k;
    }

    public d.c.i.e.e p() {
        if (this.f16106g != null) goto L6;
        d.c.i.e.e r0 = new d.c.i.e.e(q(), this.f16101b.y().h(this.f16101b.u()), this.f16101b.y().i(), this.f16101b.j().e(), this.f16101b.j().d(), this.f16101b.m());
        this.f16106g = r0;
        r0.u(this.f16101b.t().o());
        this.f16106g.t(this.f16101b.t().n());
    L6:
        return this.f16106g;
    }

    public d.c.b.b.j q() {
        if (this.f16107h != null) goto L6;
        d.c.b.b.c r0 = this.f16101b.t();
        this.f16107h = this.f16101b.l().a(r0);
    L6:
        return this.f16107h;
    }

    public d.c.i.d.f r() {
        if (this.r != null) goto L6;
        this.r = b(this.f16101b.y(), s());
    L6:
        return this.r;
    }

    public d.c.i.n.g s() {
        if (this.s != null) goto L6;
        this.s = c(this.f16101b.y(), this.f16101b.k().k(), this.f16101b.k().p());
    L6:
        return this.s;
    }

    public d.c.i.e.e v() {
        if (this.n != null) goto L6;
        d.c.i.e.e r0 = new d.c.i.e.e(w(), this.f16101b.y().h(this.f16101b.u()), this.f16101b.y().i(), this.f16101b.j().e(), this.f16101b.j().d(), this.f16101b.m());
        this.n = r0;
        r0.u(this.f16101b.t().o());
        this.n.t(this.f16101b.t().n());
    L6:
        return this.n;
    }

    public d.c.b.b.j w() {
        if (this.p != null) goto L6;
        d.c.b.b.c r0 = this.f16101b.B();
        this.p = this.f16101b.l().a(r0);
    L6:
        return this.p;
    }
}
