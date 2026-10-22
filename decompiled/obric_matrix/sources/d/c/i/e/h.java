package d.c.i.e;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class h<K, V> implements q<K, V>, d.c.c.g.c {
    static final long m = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final g<K, d<K, V>> f15949f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final g<K, d<K, V>> f15950g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final x<V> f15951h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final c f15952i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final d.c.c.d.l<r> f15953j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected r f15954k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f15955l;

    class a implements x<d<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f15956a;

        a(h r1, x r2) {
            this.f15956a = r2;
        }

        @Override // d.c.i.e.x
        public /* bridge */ /* synthetic */ int a(Object r1) {
            return b((d) r1);
        }

        public int b(d<K, V> r1) {
            return this.f15956a.a(r1.f15960b.N());
        }
    }

    class b implements d.c.c.h.c<V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f15957f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ h f15958g;

        b(h r1, d r2) {
            this.f15958g = r1;
            this.f15957f = r2;
        }

        @Override // d.c.c.h.c
        public void release(V r1) {
            h.c(this.f15958g, this.f15957f);
        }
    }

    public interface c {
        double a(d.c.c.g.b r1);
    }

    public static class d<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f15959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d.c.c.h.a<V> f15960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15961c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f15962d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final e<K> f15963e;

        private d(K r1, d.c.c.h.a<V> r2, e<K> r3) {
            d.c.c.d.i.g(r1);
            this.f15959a = r1;
            d.c.c.h.a<V> r4 = d.c.c.h.a.E(r2);
            d.c.c.d.i.g(r4);
            this.f15960b = r4;
            this.f15961c = 0;
            this.f15962d = false;
            this.f15963e = r3;
        }

        static <K, V> d<K, V> a(K r1, d.c.c.h.a<V> r2, e<K> r3) {
            return new d(r1, r2, r3);
        }
    }

    public interface e<K> {
        void a(K r1, boolean r2);
    }

    static {
        m = TimeUnit.MINUTES.toMillis(5);
    }

    public h(x<V> r3, c r4, d.c.c.d.l<r> r5) {
        new WeakHashMap();
        this.f15951h = r3;
        this.f15949f = new g(A(r3));
        this.f15950g = new g(A(r3));
        this.f15952i = r4;
        this.f15953j = r5;
        this.f15954k = r5.get();
        this.f15955l = SystemClock.uptimeMillis();
    }

    private x<d<K, V>> A(x<V> r2) {
        return new a(this, r2);
    }

    static /* synthetic */ void c(h r0, d r1) {
        r0.w(r1);
    }

    private synchronized boolean e(V r4) {
        monitor-enter(this);
        int r5 = this.f15951h.a(r4);     // Catch: Throwable -> L14
        boolean r1 = true;
        if (r5 <= this.f15954k.f15978e) goto L6;
    L11:
        r1 = false;
    L12:
        monitor-exit(this);
        return r1;
    L6:
        if (i() > (this.f15954k.f15975b - 1)) goto L11;
        if (j() > (this.f15954k.f15974a - r5)) goto L11;
    L14:
        th = move-exception;
        throw th;
    }

    private synchronized void h(d<K, V> r3) {
        monitor-enter(this);
        d.c.c.d.i.g(r3);     // Catch: Throwable -> L10
        if (r3.f15961c <= 0) goto L6;
        boolean r0 = true;
    L7:
        d.c.c.d.i.i(r0);     // Catch: Throwable -> L10
        r3.f15961c--;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r0 = false;
    L10:
        th = move-exception;
        throw th;
    }

    private synchronized void k(d<K, V> r3) {
        monitor-enter(this);
        d.c.c.d.i.g(r3);     // Catch: Throwable -> L10
        if (r3.f15962d == true) goto L6;
        boolean r0 = true;
    L7:
        d.c.c.d.i.i(r0);     // Catch: Throwable -> L10
        r3.f15961c++;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r0 = false;
    L10:
        th = move-exception;
        throw th;
    }

    private synchronized void l(d<K, V> r3) {
        monitor-enter(this);
        d.c.c.d.i.g(r3);     // Catch: Throwable -> L10
        if (r3.f15962d == true) goto L6;
        boolean r0 = true;
    L7:
        d.c.c.d.i.i(r0);     // Catch: Throwable -> L10
        r3.f15962d = true;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r0 = false;
    L10:
        th = move-exception;
        throw th;
    }

    private synchronized void m(ArrayList<d<K, V>> r2) {
        monitor-enter(this);
        if (r2 != null) goto L14;
    L12:
        monitor-exit(this);
        return;
    L14:
        Iterator<d<K, V>> r3 = r2.iterator();     // Catch: Throwable -> L9
    L6:
        if (r3.hasNext() == false) goto L12;
        l(r3.next());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private synchronized boolean n(d<K, V> r3) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (r3.f15962d == false) goto L6;
    L11:
        boolean r4 = false;
    L9:
        monitor-exit(this);
        return r4;
    L6:
        if (r3.f15961c != 0) goto L11;
        this.f15949f.h(r3.f15959a, r3);     // Catch: Throwable -> L12
        r4 = true;
        goto L9
    }

    private void o(ArrayList<d<K, V>> r2) {
        if (r2 == null) goto L7;
        Iterator<d<K, V>> r3 = r2.iterator();
    L5:
        if (r3.hasNext() == false) goto L9;
        d.c.c.h.a.L(v(r3.next()));
        goto L5
    L9:
        return;
    }

    private void p() {
        monitor-enter(this);
        r r0 = this.f15954k;     // Catch: Throwable -> L6
        int r1 = Math.min(r0.f15977d, r0.f15975b - i());     // Catch: Throwable -> L6
        r r2 = this.f15954k;     // Catch: Throwable -> L6
        z(r1, Math.min(r2.f15976c, r2.f15974a - j()));     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private static <K, V> void q(d<K, V> r2) {
        if (r2 == null) goto L7;
        e<K> r0 = r2.f15963e;
        if (r0 == null) goto L8;
        r0.a(r2.f15959a, true);
        return;
    L8:
        return;
    }

    private static <K, V> void r(d<K, V> r2) {
        if (r2 == null) goto L7;
        e<K> r0 = r2.f15963e;
        if (r0 == null) goto L8;
        r0.a(r2.f15959a, false);
        return;
    L8:
        return;
    }

    private void s(ArrayList<d<K, V>> r1) {
        if (r1 == null) goto L7;
        Iterator<d<K, V>> r0 = r1.iterator();
    L5:
        if (r0.hasNext() == false) goto L9;
        r(r0.next());
        goto L5
    L9:
        return;
    }

    private synchronized void t() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if ((this.f15955l + m) <= SystemClock.uptimeMillis()) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f15955l = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        this.f15954k = this.f15953j.get();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    private synchronized d.c.c.h.a<V> u(d<K, V> r3) {
        monitor-enter(this);
        k(r3);     // Catch: Throwable -> L6
        d.c.c.h.a<V> r4 = d.c.c.h.a.X(r3.f15960b.N(), new b(this, r3));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized d.c.c.h.a<V> v(d<K, V> r2) {
        monitor-enter(this);
        d.c.c.d.i.g(r2);     // Catch: Throwable -> L12
        if (r2.f15962d == true) goto L6;
    L9:
        d.c.c.h.a<V> r3 = null;
    L10:
        monitor-exit(this);
        return r3;
    L6:
        if (r2.f15961c != 0) goto L9;
        r3 = r2.f15960b;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    private void w(d<K, V> r3) {
        d.c.c.d.i.g(r3);
        monitor-enter(this);
        h(r3);     // Catch: Throwable -> L12
        boolean r0 = n(r3);     // Catch: Throwable -> L12
        d.c.c.h.a<V> r1 = v(r3);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        d.c.c.h.a.L(r1);
        if (r0 == true) goto L10;
        r3 = null;
    L10:
        q(r3);
        t();
        p();
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private synchronized void z(int r3, int r4) {
        monitor-enter(this);
        int r5 = Math.max(r3, 0);     // Catch: Throwable -> L25
        int r6 = Math.max(r4, 0);     // Catch: Throwable -> L25
        if (this.f15949f.d() > r5) goto L10;
        if (this.f15949f.f() > r6) goto L10;
        monitor-exit(this);
        return;
    L10:
        if (this.f15949f.d() <= r5) goto L13;
    L17:
        K r0 = this.f15949f.e();     // Catch: Throwable -> L25
        if (r0 == null) goto L19;
        this.f15949f.i(r0);     // Catch: Throwable -> L25
        d<K, V> r1 = this.f15950g.i(r0);     // Catch: Throwable -> L25
        if (r1 == null) goto L10;
        l(r1);     // Catch: Throwable -> L25
        d.c.c.h.a.L(v(r1));     // Catch: Throwable -> L25
        r(r1);     // Catch: Throwable -> L25
        goto L10
    L19:
        monitor-exit(this);
        return;
    L13:
        if (this.f15949f.f() > r6) goto L17;
        monitor-exit(this);
        return;
    L25:
        th = move-exception;
        throw th;
    }

    @Override // d.c.c.g.c
    public void a(d.c.c.g.b r7) {
        double r0 = this.f15952i.a(r7);
        monitor-enter(this);
        z(Integer.MAX_VALUE, Math.max(0, ((int) (((double) this.f15950g.f()) * (1.0d - r0))) - j()));     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        t();
        p();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // d.c.i.e.q
    public d.c.c.h.a<V> b(K r2, d.c.c.h.a<V> r3) {
        return d(r2, r3, null);
    }

    public d.c.c.h.a<V> d(K r5, d.c.c.h.a<V> r6, e<K> r7) {
        d.c.c.d.i.g(r5);
        d.c.c.d.i.g(r6);
        t();
        monitor-enter(this);
        d<K, V> r0 = this.f15949f.i(r5);     // Catch: Throwable -> L14
        d<K, V> r1 = this.f15950g.i(r5);     // Catch: Throwable -> L14
        d.c.c.h.a<V> r2 = null;
        if (r1 == null) goto L7;
        l(r1);     // Catch: Throwable -> L14
        d.c.c.h.a<V> r3 = v(r1);     // Catch: Throwable -> L14
    L9:
        if (e(r6.N()) == false) goto L11;
        d<K, V> r8 = d.a(r5, r6, r7);     // Catch: Throwable -> L14
        this.f15950g.h(r5, r8);     // Catch: Throwable -> L14
        r2 = u(r8);     // Catch: Throwable -> L14
    L11:
        monitor-exit(this);     // Catch: Throwable -> L14
        d.c.c.h.a.L(r3);
        r(r0);
        p();
        return r2;
    L7:
        r3 = null;
    L14:
        th = move-exception;
        throw th;
    }

    public void f() {
        monitor-enter(this);
        ArrayList<d<K, V>> r0 = this.f15949f.a();     // Catch: Throwable -> L7
        ArrayList<d<K, V>> r1 = this.f15950g.a();     // Catch: Throwable -> L7
        m(r1);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        o(r1);
        s(r0);
        t();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized boolean g(K r2) {
        monitor-enter(this);
        boolean r3 = this.f15950g.b(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // d.c.i.e.q
    public d.c.c.h.a<V> get(K r3) {
        d.c.c.d.i.g(r3);
        monitor-enter(this);
        d<K, V> r0 = this.f15949f.i(r3);     // Catch: Throwable -> L11
        d<K, V> r4 = this.f15950g.c(r3);     // Catch: Throwable -> L11
        if (r4 == null) goto L7;
        d.c.c.h.a<V> r5 = u(r4);     // Catch: Throwable -> L11
    L8:
        monitor-exit(this);     // Catch: Throwable -> L11
        r(r0);
        t();
        p();
        return r5;
    L7:
        r5 = null;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized int i() {
        monitor-enter(this);
        int r0 = this.f15950g.d() - this.f15949f.d();
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized int j() {
        monitor-enter(this);
        int r0 = this.f15950g.f() - this.f15949f.f();
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public int x(d.c.c.d.j<K> r5) {
        ArrayList<d<K, V>> r0 = new ArrayList();
        monitor-enter(this);
        ArrayList<d<K, V>> r6 = this.f15949f.j(r5);     // Catch: Throwable -> L11
        int r1 = 0;
    L6:
        if (r1 >= r6.size()) goto L8;
        d<K, V> r2 = r6.get(r1);     // Catch: Throwable -> L11
        r0.add(this.f15950g.i(r2.f15959a));     // Catch: Throwable -> L11
        r1 = r1 + 1;     // Catch: Throwable -> L11
        goto L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L11
        o(r0);
        s(r6);
        t();
        p();
        return r0.size();
    L11:
        th = move-exception;
        throw th;
    }

    public d.c.c.h.a<V> y(K r5) {
        d.c.c.d.i.g(r5);
        monitor-enter(this);
        d<K, V> r0 = this.f15949f.i(r5);     // Catch: Throwable -> L15
        boolean r1 = true;
        boolean r2 = false;
        if (r0 == null) goto L10;
        d<K, V> r6 = this.f15950g.i(r5);     // Catch: Throwable -> L15
        d.c.c.d.i.g(r6);     // Catch: Throwable -> L15
        if (r6.f15961c != 0) goto L9;
        r2 = true;
    L9:
        d.c.c.d.i.i(r2);     // Catch: Throwable -> L15
        d.c.c.h.a<V> r7 = r6.f15960b;     // Catch: Throwable -> L15
    L11:
        monitor-exit(this);     // Catch: Throwable -> L15
        if (r1 == false) goto L14;
        r(r0);
    L14:
        return r7;
    L10:
        r7 = null;
        r1 = false;
    L15:
        th = move-exception;
        throw th;
    }
}
