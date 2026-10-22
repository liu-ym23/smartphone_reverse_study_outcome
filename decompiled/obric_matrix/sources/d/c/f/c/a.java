package d.c.f.c;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.infer.annotation.ReturnsOwnership;
import d.c.c.d.h;
import d.c.c.d.i;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T, INFO> implements d.c.f.h.a, d.c.f.b.a.b, d.c.f.g.a.InterfaceC0422a {
    private static final Class<?> v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.f.b.b f15561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.f.b.a f15562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f15563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d.c.f.b.c f15564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d.c.f.g.a f15565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d<INFO> f15566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d.c.f.h.c f15567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Drawable f15568h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f15569i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Object f15570j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f15571k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f15572l;
    private boolean m;
    private boolean n;
    private boolean o;
    private String p;
    private d.c.d.c<T> q;
    private T r;
    private Drawable s;
    private boolean t;
    private d.c.i.q.b u;

    /* JADX INFO: renamed from: d.c.f.c.a$a, reason: collision with other inner class name */
    class C0419a extends d.c.d.b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f15573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f15574b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f15575c;

        C0419a(a r1, String r2, boolean r3) {
            this.f15575c = r1;
            this.f15573a = r2;
            this.f15574b = r3;
        }

        @Override // d.c.d.b, d.c.d.e
        public void d(d.c.d.c<T> r4) {
            boolean r0 = r4.b();
            float r1 = r4.getProgress();
            a.j(this.f15575c, this.f15573a, r4, r1, r0);
        }

        @Override // d.c.d.b
        public void e(d.c.d.c<T> r4) {
            a.i(this.f15575c, this.f15573a, r4, r4.c(), true);
        }

        @Override // d.c.d.b
        public void f(d.c.d.c<T> r9) {
            boolean r5 = r9.b();
            boolean r7 = r9.d();
            float r4 = r9.getProgress();
            T r3 = r9.e();
            if (r3 == null) goto L5;
            a.h(this.f15575c, this.f15573a, r9, r3, r4, r5, this.f15574b, r7);
            return;
        L5:
            if (r5 == false) goto L9;
            a.i(this.f15575c, this.f15573a, r9, new NullPointerException(), true);
            return;
        }
    }

    private static class b<INFO> extends f<INFO> {
        private b() {
        }

        public static <INFO> b<INFO> o(d<? super INFO> r1, d<? super INFO> r2) {
            if (d.c.i.r.b.d() == false) goto L5;
            d.c.i.r.b.a("AbstractDraweeController#createInternal");
        L5:
            b<INFO> r0 = new b();
            r0.k(r1);
            r0.k(r2);
            if (d.c.i.r.b.d() == false) goto L8;
            d.c.i.r.b.b();
        L8:
            return r0;
        }
    }

    static {
        v = a.class;
    }

    public a(d.c.f.b.a r2, Executor r3, String r4, Object r5) {
        this.f15561a = d.c.f.b.b.a();
        this.t = true;
        this.f15562b = r2;
        this.f15563c = r3;
        y(r4, r5);
    }

    private boolean A(String r3, d.c.d.c<T> r4) {
        if (r4 != null) goto L8;
        if (this.q != null) goto L8;
        return true;
    L8:
        if (r3.equals(this.f15569i) == true) goto L10;
    L14:
        return false;
    L10:
        if (r4 != this.q) goto L14;
        if (this.f15572l == false) goto L14;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean B(T r2) {
        d.c.i.l.c r0 = null;
        if ((r2 instanceof d.c.c.h.a) == false) goto L5;
        d.c.c.h.a r3 = (d.c.c.h.a) r2;
    L6:
        if (r3 != null) goto L8;
    L10:
        if (r0 != null) goto L14;
        return false;
    L14:
        return r0.C();
    L8:
        if ((r3.N() instanceof d.c.i.l.c) == false) goto L10;
        r0 = (d.c.i.l.c) r3.N();
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    private void C(String r8, Throwable r9) {
        if (d.c.c.e.a.p(2) == false) goto L6;
        d.c.c.e.a.v(v, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.f15569i, r8, r9);
        return;
    }

    private void D(String r6, T r7) {
        if (d.c.c.e.a.p(2) == false) goto L6;
        d.c.c.e.a.w(v, "controller %x %s: %s: image: %s %x", new Object[]{Integer.valueOf(System.identityHashCode(this)), this.f15569i, r6, t(r7), Integer.valueOf(u(r7))});
        return;
    }

    private void E(String r2, d.c.d.c<T> r3, Throwable r4, boolean r5) {
        if (d.c.i.r.b.d() == false) goto L6;
        d.c.i.r.b.a("AbstractDraweeController#onFailureInternal");
    L6:
        if (A(r2, r3) == true) goto L11;
        C("ignore_old_datasource @ onFailure", r4);
        r3.close();
        if (d.c.i.r.b.d() == false) goto L32;
        d.c.i.r.b.b();
        return;
    L32:
        return;
    L11:
        d.c.f.b.b r6 = this.f15561a;
        if (r5 == false) goto L14;
        d.c.f.b.b.a r7 = d.c.f.b.b.a.r;
    L15:
        r6.b(r7);
        if (r5 == false) goto L27;
        C("final_failed @ onFailure", r4);
        this.q = null;
        this.m = true;
        if (this.n == false) goto L23;
        Drawable r8 = this.s;
        if (r8 == null) goto L23;
        this.f15567g.f(r8, 1.0f, true);
    L26:
        n().c(this.f15569i, r4);
    L29:
        if (d.c.i.r.b.d() == false) goto L33;
        d.c.i.r.b.b();
        return;
    L33:
        return;
    L23:
        if (T() == false) goto L25;
        this.f15567g.b(r4);
        goto L26
    L25:
        this.f15567g.c(r4);
        goto L26
    L27:
        C("intermediate_failed @ onFailure", r4);
        n().f(this.f15569i, r4);
        goto L29
    L14:
        r7 = d.c.f.b.b.a.s;
        goto L15
    }

    private void G(String r14, d.c.d.c<T> r15, T r16, float r17, boolean r18, boolean r19, boolean r20) {
    L57:
        th = move-exception;
        if (d.c.i.r.b.d() == false) goto L61;
        d.c.i.r.b.b();
    L61:
        throw th;
    L4:
        if (d.c.i.r.b.d() == false) goto L7;
        d.c.i.r.b.a("AbstractDraweeController#onNewResultInternal");     // Catch: Throwable -> L57
    L7:
        if (A(r14, r15) == true) goto L13;
        D("ignore_old_datasource @ onNewResult", r16);     // Catch: Throwable -> L57
        K(r16);     // Catch: Throwable -> L57
        r15.close();     // Catch: Throwable -> L57
        if (d.c.i.r.b.d() == false) goto L66;
        d.c.i.r.b.b();
        return;
    L66:
        return;
    L13:
        d.c.f.b.b r4 = this.f15561a;     // Catch: Throwable -> L57
        if (r18 == false) goto L16;
        d.c.f.b.b.a r5 = d.c.f.b.b.a.p;     // Catch: Throwable -> L57
    L17:
        r4.b(r5);     // Catch: Throwable -> L57
        Drawable r9 = l(r16);     // Catch: Exception -> L51 Throwable -> L57
        T r10 = this.r;     // Catch: Throwable -> L57
        Drawable r11 = this.s;     // Catch: Throwable -> L57
        this.r = r16;     // Catch: Throwable -> L57
        this.s = r9;     // Catch: Throwable -> L57
        HashMap r7 = new HashMap();     // Catch: Throwable -> L57
        r7.put("drawableWidth", Integer.valueOf(r9.getIntrinsicWidth()));     // Catch: Throwable -> L57
        r7.put("drawableHeight", Integer.valueOf(r9.getIntrinsicHeight()));     // Catch: Throwable -> L57
        if (r18 == false) goto L29;
        D("set_final_result @ onNewResult", r16);     // Catch: Throwable -> L27
        this.q = null;     // Catch: Throwable -> L27
        this.f15567g.f(r9, 1.0f, r19);     // Catch: Throwable -> L27
        d<INFO> r0 = n();     // Catch: Throwable -> L27
        if ((r0 instanceof c) == false) goto L25;
        ((c) r0).i(r14, v(r16), e(), w(), r7);     // Catch: Throwable -> L27
    L34:
        if (r11 == null) goto L37;
        if (r11 == r9) goto L37;
        I(r11);     // Catch: Throwable -> L57
    L37:
        if (r10 == null) goto L41;
        if (r10 == r16) goto L41;
        D("release_previous_result @ onNewResult", r10);     // Catch: Throwable -> L57
        K(r10);     // Catch: Throwable -> L57
    L41:
        if (d.c.i.r.b.d() == false) goto L67;
        d.c.i.r.b.b();
        return;
    L67:
        return;
    L25:
        INFO r2 = v(r16);     // Catch: Throwable -> L27
        Animatable r6 = e();     // Catch: Throwable -> L27
    L26:
        r0.b(r14, r2, r6);     // Catch: Throwable -> L27
        goto L34
    L29:
        if (r20 == false) goto L31;
        D("set_temporary_result @ onNewResult", r16);     // Catch: Throwable -> L27
        this.f15567g.f(r9, 1.0f, r19);     // Catch: Throwable -> L27
        r0 = n();     // Catch: Throwable -> L27
        r2 = v(r16);     // Catch: Throwable -> L27
        r6 = e();     // Catch: Throwable -> L27
        goto L26
    L31:
        D("set_intermediate_result @ onNewResult", r16);     // Catch: Throwable -> L27
        this.f15567g.f(r9, r17, r19);     // Catch: Throwable -> L27
        n().a(r14, v(r16));     // Catch: Throwable -> L27
        if ((n() instanceof c) == false) goto L34;
        ((c) n()).j(r14, v(r16), e());     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        if (r11 == null) goto L47;
        if (r11 == r9) goto L47;
        I(r11);     // Catch: Throwable -> L57
    L47:
        if (r10 == null) goto L50;
        if (r10 == r16) goto L50;
        D("release_previous_result @ onNewResult", r10);     // Catch: Throwable -> L57
        K(r10);     // Catch: Throwable -> L57
    L50:
        throw th;     // Catch: Throwable -> L57
    L51:
        e = move-exception;
        D("drawable_failed @ onNewResult", r16);     // Catch: Throwable -> L57
        K(r16);     // Catch: Throwable -> L57
        E(r14, r15, e, r18);     // Catch: Throwable -> L57
        if (d.c.i.r.b.d() == false) goto L68;
        d.c.i.r.b.b();
        return;
    L68:
        return;
    L16:
        r5 = d.c.f.b.b.a.q;     // Catch: Throwable -> L57
        goto L17
    }

    private void H(String r1, d.c.d.c<T> r2, float r3, boolean r4) {
        if (A(r1, r2) == true) goto L6;
        C("ignore_old_datasource @ onProgress", null);
        r2.close();
        return;
    L6:
        if (r4 == true) goto L9;
        this.f15567g.d(r3, false);
        return;
    }

    private void J() {
        boolean r0 = this.f15572l;
        this.f15572l = false;
        this.m = false;
        d.c.d.c<T> r1 = this.q;
        if (r1 == null) goto L5;
        r1.close();
        this.q = null;
    L5:
        Drawable r2 = this.s;
        if (r2 == null) goto L9;
        I(r2);
    L9:
        if (this.p == null) goto L11;
        this.p = null;
    L11:
        this.s = null;
        T r3 = this.r;
        if (r3 == null) goto L14;
        D("release", r3);
        K(this.r);
        this.r = null;
    L14:
        if (r0 == false) goto L17;
        n().d(this.f15569i);
        return;
    }

    private boolean T() {
        if (this.m == false) goto L9;
        d.c.f.b.c r1 = this.f15564d;
        if (r1 == null) goto L9;
        if (r1.e() == false) goto L9;
        return true;
    L9:
        return false;
    }

    static /* synthetic */ void h(a r0, String r1, d.c.d.c r2, Object r3, float r4, boolean r5, boolean r6, boolean r7) {
        r0.G(r1, r2, r3, r4, r5, r6, r7);
    }

    static /* synthetic */ void i(a r0, String r1, d.c.d.c r2, Throwable r3, boolean r4) {
        r0.E(r1, r2, r3, r4);
    }

    static /* synthetic */ void j(a r0, String r1, d.c.d.c r2, float r3, boolean r4) {
        r0.H(r1, r2, r3, r4);
    }

    private synchronized void y(String r5, Object r6) {
        monitor-enter(this);
    L35:
        th = move-exception;
        throw th;
    L4:
        if (d.c.i.r.b.d() == false) goto L6;
        d.c.i.r.b.a("AbstractDraweeController#init");     // Catch: Throwable -> L35
    L6:
        this.f15561a.b(d.c.f.b.b.a.f15556k);     // Catch: Throwable -> L35
        if (this.t == true) goto L11;
        d.c.f.b.a r0 = this.f15562b;     // Catch: Throwable -> L35
        if (r0 == null) goto L11;
        r0.c(this);     // Catch: Throwable -> L35
    L11:
        this.f15571k = false;     // Catch: Throwable -> L35
        J();     // Catch: Throwable -> L35
        this.n = false;     // Catch: Throwable -> L35
        d.c.f.b.c r1 = this.f15564d;     // Catch: Throwable -> L35
        if (r1 == null) goto L14;
        r1.a();     // Catch: Throwable -> L35
    L14:
        d.c.f.g.a r2 = this.f15565e;     // Catch: Throwable -> L35
        if (r2 == null) goto L17;
        r2.a();     // Catch: Throwable -> L35
        this.f15565e.f(this);     // Catch: Throwable -> L35
    L17:
        d<INFO> r3 = this.f15566f;     // Catch: Throwable -> L35
        if ((r3 instanceof b) == false) goto L20;
        ((b) r3).l();     // Catch: Throwable -> L35
    L21:
        d.c.f.h.c r4 = this.f15567g;     // Catch: Throwable -> L35
        if (r4 != null) goto L24;
    L27:
        this.f15568h = null;     // Catch: Throwable -> L35
        if (d.c.c.e.a.p(2) == false) goto L30;
        d.c.c.e.a.u(v, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.f15569i, r5);     // Catch: Throwable -> L35
    L30:
        this.f15569i = r5;     // Catch: Throwable -> L35
        this.f15570j = r6;     // Catch: Throwable -> L35
        if (d.c.i.r.b.d() == false) goto L33;
        d.c.i.r.b.b();     // Catch: Throwable -> L35
    L33:
        monitor-exit(this);
        return;
    L24:
        if (this.o == true) goto L26;
        r4.reset();     // Catch: Throwable -> L35
    L26:
        this.f15567g.a(null);     // Catch: Throwable -> L35
        this.f15567g = null;     // Catch: Throwable -> L35
        goto L27
    L20:
        this.f15566f = null;     // Catch: Throwable -> L35
        goto L21
    }

    protected void F(String r1, T r2) {
    }

    protected abstract void I(Drawable r1);

    protected abstract void K(T r1);

    public void L(d<? super INFO> r3) {
        i.g(r3);
        d<INFO> r0 = this.f15566f;
        if ((r0 instanceof b) == false) goto L6;
        ((b) r0).n(r3);
        return;
    L6:
        if (r0 != r3) goto L9;
        this.f15566f = null;
        return;
    }

    public void M(String r1) {
        this.p = r1;
    }

    protected void N(Drawable r1) {
        this.f15568h = r1;
        d.c.f.h.c r0 = this.f15567g;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public void O(e r1) {
    }

    protected void P(d.c.f.g.a r1) {
        this.f15565e = r1;
        if (r1 == null) goto L6;
        r1.f(this);
        return;
    }

    protected void Q(boolean r1) {
        this.n = r1;
    }

    public void R(boolean r1) {
        this.o = r1;
    }

    protected boolean S() {
        return T();
    }

    protected void U() {
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("AbstractDraweeController#submitRequest");
    L5:
        T r4 = m();
        boolean r0 = B(r4);
        if (r4 == null) goto L18;
        if (r0 == true) goto L18;
        if (d.c.i.r.b.d() == false) goto L11;
        d.c.i.r.b.a("AbstractDraweeController#submitRequest->cache");
    L11:
        this.q = null;
        this.f15572l = true;
        this.m = false;
        this.f15561a.b(d.c.f.b.b.a.C);
        n().e(this.f15569i, this.f15570j);
        F(this.f15569i, r4);
        G(this.f15569i, this.q, r4, 1.0f, true, true, true);
        if (d.c.i.r.b.d() == false) goto L15;
        d.c.i.r.b.b();
    L15:
        if (d.c.i.r.b.d() == false) goto L25;
        d.c.i.r.b.b();
        return;
    L25:
        return;
    L18:
        this.f15561a.b(d.c.f.b.b.a.o);
        n().e(this.f15569i, this.f15570j);
        this.f15567g.d(0.0f, true);
        this.f15572l = true;
        this.m = false;
        this.q = p();
        if (d.c.c.e.a.p(2) == false) goto L21;
        d.c.c.e.a.u(v, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.f15569i, Integer.valueOf(System.identityHashCode(this.q)));
    L21:
        C0419a r2 = new C0419a(this, this.f15569i, this.q.a());
        this.q.f(r2, this.f15563c);
        if (d.c.i.r.b.d() == false) goto L26;
        d.c.i.r.b.b();
        return;
    }

    @Override // d.c.f.g.a.InterfaceC0422a
    public boolean a() {
        if (d.c.c.e.a.p(2) == false) goto L6;
        d.c.c.e.a.t(v, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.f15569i);
    L6:
        if (T() == false) goto L9;
        this.f15564d.b();
        this.f15567g.reset();
        U();
        return true;
    L9:
        return false;
    }

    @Override // d.c.f.b.a.b
    public void b() {
        this.f15561a.b(d.c.f.b.b.a.n);
        d.c.f.b.c r0 = this.f15564d;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        d.c.f.g.a r1 = this.f15565e;
        if (r1 == null) goto L8;
        r1.e();
    L8:
        d.c.f.h.c r2 = this.f15567g;
        if (r2 == null) goto L11;
        r2.reset();
    L11:
        J();
    }

    @Override // d.c.f.h.a
    public void c() {
        if (d.c.i.r.b.d() == false) goto L6;
        d.c.i.r.b.a("AbstractDraweeController#onDetach");
    L6:
        if (d.c.c.e.a.p(2) == false) goto L8;
        d.c.c.e.a.t(v, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.f15569i);
    L8:
        this.f15561a.b(d.c.f.b.b.a.m);
        this.f15571k = false;
        this.f15562b.f(this);
        if (d.c.i.r.b.d() == false) goto L12;
        d.c.i.r.b.b();
        return;
    }

    @Override // d.c.f.h.a
    public d.c.f.h.b d() {
        return this.f15567g;
    }

    @Override // d.c.f.h.a
    public Animatable e() {
        Object r1 = this.s;
        if ((r1 instanceof Animatable) == true) goto L7;
        return null;
    L7:
        return (Animatable) r1;
    }

    @Override // d.c.f.h.a
    public void f() {
        if (d.c.i.r.b.d() == false) goto L6;
        d.c.i.r.b.a("AbstractDraweeController#onAttach");
    L6:
        if (d.c.c.e.a.p(2) == false) goto L12;
        Class<?> r0 = v;
        Integer r1 = Integer.valueOf(System.identityHashCode(this));
        String r2 = this.f15569i;
        if (this.f15572l == false) goto L10;
        String r3 = "request already submitted";
    L11:
        d.c.c.e.a.u(r0, "controller %x %s: onAttach: %s", r1, r2, r3);
        goto L12
    L10:
        r3 = "request needs submit";
    L12:
        this.f15561a.b(d.c.f.b.b.a.f15557l);
        i.g(this.f15567g);
        this.f15562b.c(this);
        this.f15571k = true;
        if (this.f15572l == true) goto L16;
        U();
    L16:
        if (d.c.i.r.b.d() == false) goto L19;
        d.c.i.r.b.b();
        return;
    }

    @Override // d.c.f.h.a
    public void g(d.c.f.h.b r5) {
        if (d.c.c.e.a.p(2) == false) goto L5;
        d.c.c.e.a.u(v, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.f15569i, r5);
    L5:
        d.c.f.b.b r0 = this.f15561a;
        if (r5 == null) goto L8;
        d.c.f.b.b.a r1 = d.c.f.b.b.a.f15551f;
    L9:
        r0.b(r1);
        if (this.f15572l == false) goto L12;
        this.f15562b.c(this);
        b();
    L12:
        d.c.f.h.c r2 = this.f15567g;
        if (r2 == null) goto L15;
        r2.a(null);
        this.f15567g = null;
    L15:
        if (r5 == null) goto L18;
        i.b(r5 instanceof d.c.f.h.c);
        d.c.f.h.c r6 = (d.c.f.h.c) r5;
        this.f15567g = r6;
        r6.a(this.f15568h);
        return;
    L18:
        return;
    L8:
        r1 = d.c.f.b.b.a.f15552g;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void k(d<? super INFO> r3) {
        i.g(r3);
        d<INFO> r0 = this.f15566f;
        if ((r0 instanceof b) == false) goto L6;
        ((b) r0).k(r3);
        return;
    L6:
        if (r0 == null) goto L9;
        this.f15566f = b.o(r0, r3);
        return;
    L9:
        this.f15566f = r3;
    }

    protected abstract Drawable l(T r1);

    protected T m() {
        return null;
    }

    protected d<INFO> n() {
        d<INFO> r0 = this.f15566f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return c.g();
    }

    protected Drawable o() {
        return this.f15568h;
    }

    @Override // d.c.f.h.a
    public boolean onTouchEvent(MotionEvent r5) {
        if (d.c.c.e.a.p(2) == false) goto L5;
        d.c.c.e.a.u(v, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.f15569i, r5);
    L5:
        d.c.f.g.a r0 = this.f15565e;
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r0.b() == false) goto L11;
    L14:
        this.f15565e.d(r5);
        return true;
    L11:
        if (S() == true) goto L14;
        return false;
    }

    public abstract d.c.d.c<T> p();

    public Drawable q() {
        return this.s;
    }

    protected d.c.f.g.a r() {
        return this.f15565e;
    }

    public String s() {
        return this.f15569i;
    }

    protected String t(T r1) {
        if (r1 != null) goto L6;
        return "<null>";
    L6:
        return r1.getClass().getSimpleName();
    }

    public String toString() {
        h.b r0 = h.d(this);
        r0.c("isAttached", this.f15571k);
        r0.c("isRequestSubmitted", this.f15572l);
        r0.c("hasFetchFailed", this.m);
        r0.a("fetchedImage", u(this.r));
        r0.b("events", this.f15561a.toString());
        return r0.toString();
    }

    protected int u(T r1) {
        return System.identityHashCode(r1);
    }

    protected abstract INFO v(T r1);

    public d.c.i.q.b w() {
        return this.u;
    }

    @ReturnsOwnership
    protected d.c.f.b.c x() {
        if (this.f15564d != null) goto L6;
        this.f15564d = new d.c.f.b.c();
    L6:
        return this.f15564d;
    }

    protected void z(String r1, Object r2, d.c.i.q.b r3) {
        this.u = r3;
        y(r1, r2);
        this.t = false;
    }
}
