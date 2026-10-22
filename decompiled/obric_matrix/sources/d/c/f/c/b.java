package d.c.f.c;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.facebook.infer.annotation.ReturnsOwnership;
import d.c.c.d.h;
import d.c.c.d.i;
import d.c.c.d.l;
import d.c.d.g;
import d.c.f.c.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public abstract class b<BUILDER extends b<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements d.c.f.h.d {
    private static final d<Object> r = null;
    private static final NullPointerException s = null;
    private static final AtomicLong t = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f15576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<d> f15577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f15578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private REQUEST f15579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private REQUEST f15580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private REQUEST[] f15581f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f15582g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private l<d.c.d.c<IMAGE>> f15583h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private d<? super INFO> f15584i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Set<d> f15585j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private e f15586k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f15587l;
    private boolean m;
    private boolean n;
    private boolean o;
    private String p;
    private d.c.f.h.a q;

    static class a extends d.c.f.c.c<Object> {
        a() {
        }

        @Override // d.c.f.c.c, d.c.f.c.d
        public void b(String r1, Object r2, Animatable r3) {
            if (r3 == null) goto L5;
            r3.start();
            return;
        }

        @Override // d.c.f.c.c
        public void j(String r1, Object r2, Animatable r3) {
            super.j(r1, r2, r3);
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.isRunning() == true) goto L9;
            r3.start();
            return;
        }
    }

    /* JADX INFO: renamed from: d.c.f.c.b$b, reason: collision with other inner class name */
    class C0420b implements l<d.c.d.c<IMAGE>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.c.f.h.a f15588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15589b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f15590c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f15591d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f15592e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f15593f;

        C0420b(b r1, d.c.f.h.a r2, String r3, Object r4, Object r5, c r6) {
            this.f15593f = r1;
            this.f15588a = r2;
            this.f15589b = r3;
            this.f15590c = r4;
            this.f15591d = r5;
            this.f15592e = r6;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d.c.d.c<IMAGE> a() {
            return this.f15593f.i(this.f15588a, this.f15589b, this.f15590c, this.f15591d, this.f15592e);
        }

        @Override // d.c.c.d.l
        public /* bridge */ /* synthetic */ Object get() {
            return a();
        }

        public String toString() {
            h.b r0 = h.d(this);
            r0.b("request", this.f15590c.toString());
            return r0.toString();
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f15594f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f15595g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f15596h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ c[] f15597i = null;

        static {
            c r0 = new c("FULL_FETCH", 0);
            f15594f = r0;
            c r1 = new c("DISK_CACHE", 1);
            f15595g = r1;
            c r3 = new c("BITMAP_MEMORY_CACHE", 2);
            f15596h = r3;
            f15597i = new c[]{r0, r1, r3};
        }

        private c(String r1, int r2) {
            super(r1, r2);
        }

        public static c valueOf(String r1) {
            return (c) Enum.valueOf(c.class, r1);
        }

        public static c[] values() {
            return (c[]) f15597i.clone();
        }
    }

    static {
        r = new a();
        s = new NullPointerException("No image request was specified!");
        t = new AtomicLong();
    }

    protected b(Context r1, Set<d> r2) {
        this.f15576a = r1;
        this.f15577b = r2;
        r();
    }

    protected static String e() {
        return String.valueOf(t.getAndIncrement());
    }

    private void r() {
        this.f15578c = null;
        this.f15579d = null;
        this.f15580e = null;
        this.f15581f = null;
        this.f15582g = true;
        this.f15584i = null;
        this.f15586k = null;
        this.f15587l = false;
        this.m = false;
        this.q = null;
        this.p = null;
    }

    public BUILDER A(REQUEST[] r2) {
        B(r2, true);
        return this;
    }

    public BUILDER B(REQUEST[] r3, boolean r4) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        i.c(r0, "No requests specified!");
        this.f15581f = r3;
        this.f15582g = r4;
        q();
        return this;
    L4:
        if (r3.length > 0) goto L7;
        r0 = false;
        goto L8
    }

    public void C(Set<d> r1) {
        this.f15585j = r1;
    }

    public BUILDER D(REQUEST r1) {
        this.f15579d = r1;
        q();
        return this;
    }

    public BUILDER E(d.c.f.h.a r1) {
        this.q = r1;
        q();
        return this;
    }

    public BUILDER F(boolean r1) {
        this.n = r1;
        q();
        return this;
    }

    public BUILDER G(boolean r1) {
        this.f15587l = r1;
        q();
        return this;
    }

    protected void H() {
        boolean r1 = false;
        if (this.f15581f != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        i.j(r0, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.f15583h != null) goto L12;
    L17:
        r1 = true;
    L18:
        i.j(r1, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
        return;
    L12:
        if (this.f15581f != null) goto L18;
        if (this.f15579d != null) goto L18;
        if (this.f15580e != null) goto L18;
    L5:
        if (this.f15579d == null) goto L8;
        r0 = false;
        goto L9
    }

    @Override // d.c.f.h.d
    public /* bridge */ /* synthetic */ d.c.f.h.d b(d.c.f.h.a r1) {
        E(r1);
        return this;
    }

    @Override // d.c.f.h.d
    public /* bridge */ /* synthetic */ d.c.f.h.a build() {
        return c();
    }

    public d.c.f.c.a c() {
        H();
        if (this.f15579d != null) goto L10;
        if (this.f15581f != null) goto L10;
        REQUEST r0 = this.f15580e;
        if (r0 == null) goto L10;
        this.f15579d = r0;
        this.f15580e = null;
    L10:
        return d();
    }

    protected d.c.f.c.a d() {
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("AbstractDraweeControllerBuilder#buildController");
    L5:
        d.c.f.c.a r0 = v();
        r0.Q(o());
        r0.M(g());
        r0.O(h());
        u(r0);
        s(r0);
        if (d.c.i.r.b.d() == false) goto L8;
        d.c.i.r.b.b();
    L8:
        return r0;
    }

    public Object f() {
        return this.f15578c;
    }

    public String g() {
        return this.p;
    }

    public e h() {
        return this.f15586k;
    }

    protected abstract d.c.d.c<IMAGE> i(d.c.f.h.a r1, String r2, REQUEST r3, Object r4, c r5);

    protected l<d.c.d.c<IMAGE>> j(d.c.f.h.a r2, String r3, REQUEST r4) {
        return k(r2, r3, r4, c.f15594f);
    }

    protected l<d.c.d.c<IMAGE>> k(d.c.f.h.a r9, String r10, REQUEST r11, c r12) {
        return new C0420b(this, r9, r10, r11, f(), r12);
    }

    protected l<d.c.d.c<IMAGE>> l(d.c.f.h.a r5, String r6, REQUEST[] r7, boolean r8) {
        ArrayList r0 = new ArrayList(r7.length * 2);
        int r1 = 0;
        if (r8 == false) goto L9;
        int r9 = 0;
    L6:
        if (r9 >= r7.length) goto L9;
        r0.add(k(r5, r6, r7[r9], c.f15596h));
        r9 = r9 + 1;
    L9:
        if (r1 >= r7.length) goto L12;
        r0.add(j(r5, r6, r7[r1]));
        r1 = r1 + 1;
        goto L9
    L12:
        return d.c.d.f.b(r0);
    }

    public REQUEST m() {
        return this.f15579d;
    }

    public d.c.f.h.a n() {
        return this.q;
    }

    public boolean o() {
        return this.n;
    }

    public boolean p() {
        return this.o;
    }

    protected final BUILDER q() {
        return this;
    }

    protected void s(d.c.f.c.a r5) {
        Set<d> r0 = this.f15577b;
        if (r0 == null) goto L8;
        Iterator<d> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r5.k(r1.next());
    L8:
        d<? super INFO> r2 = this.f15584i;
        if (r2 == null) goto L11;
        r5.k(r2);
    L11:
        Set<d> r3 = this.f15585j;
        if (r3 != null) goto L14;
    L19:
        d<INFO> r4 = r5.n();
        if (r4 == null) goto L25;
        if ((r4 instanceof d.c.f.c.c) == false) goto L25;
        ((d.c.f.c.c) r4).h((d.c.i.q.b) m(), System.currentTimeMillis());
    L25:
        if (this.m == false) goto L30;
        r5.k(r);
        return;
    L30:
        return;
    L14:
        if (r3.size() == 0) goto L19;
        Iterator<d> r6 = this.f15585j.iterator();
    L17:
        if (r6.hasNext() == false) goto L19;
        r5.k(r6.next());
        goto L17
    }

    protected void t(d.c.f.c.a r2) {
        if (r2.r() != null) goto L6;
        r2.P(d.c.f.g.a.c(this.f15576a));
        return;
    }

    protected void u(d.c.f.c.a r3) {
        if (this.f15587l == true) goto L5;
        return;
    L5:
        r3.x().d(this.f15587l);
        t(r3);
    }

    @ReturnsOwnership
    protected abstract d.c.f.c.a v();

    protected l<d.c.d.c<IMAGE>> w(d.c.f.h.a r4, String r5) {
        l<d.c.d.c<IMAGE>> r0 = this.f15583h;
        if (r0 == null) goto L5;
        return r0;
    L5:
        l<d.c.d.c<IMAGE>> r1 = null;
        REQUEST r2 = this.f15579d;
        if (r2 == null) goto L8;
        r1 = j(r4, r5, r2);
    L11:
        if (r1 != null) goto L13;
    L15:
        if (r1 == null) goto L17;
        return r1;
    L17:
        return d.c.d.d.a(s);
    L13:
        if (this.f15580e == null) goto L15;
        ArrayList r3 = new ArrayList(2);
        r3.add(r1);
        r3.add(j(r4, r5, this.f15580e));
        r1 = g.c(r3, false);
        goto L15
    L8:
        REQUEST[] r6 = this.f15581f;
        if (r6 == null) goto L11;
        r1 = l(r4, r5, r6, this.f15582g);
        goto L11
    }

    public BUILDER x(boolean r1) {
        this.m = r1;
        q();
        return this;
    }

    public BUILDER y(Object r1) {
        this.f15578c = r1;
        q();
        return this;
    }

    public BUILDER z(d<? super INFO> r1) {
        this.f15584i = r1;
        q();
        return this;
    }
}
