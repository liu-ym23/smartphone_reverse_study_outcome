package d.c.b.b;

import android.content.Context;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class e implements j, d.c.c.a.a {
    private static final Class<?> r = null;
    private static final long s = 0;
    private static final long t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f15327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f15328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CountDownLatch f15329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f15330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.c.b.a.f f15331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Set<String> f15332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f15333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f15334h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final d.c.c.i.a f15335i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final d f15336j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final i f15337k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final d.c.b.a.a f15338l;
    private final boolean m;
    private final b n;
    private final com.facebook.common.time.a o;
    private final Object p;
    private boolean q;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f15339f;

        a(e r1) {
            this.f15339f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r0 = e.i(this.f15339f);
            monitor-enter(r0);
            e.j(this.f15339f);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            e.k(this.f15339f, true);
            e.l(this.f15339f).countDown();
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f15340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f15341b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f15342c;

        b() {
            this.f15340a = false;
            this.f15341b = -1;
            this.f15342c = -1;
        }

        public synchronized long a() {
            monitor-enter(this);
            long r0 = this.f15342c;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized long b() {
            monitor-enter(this);
            long r0 = this.f15341b;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void c(long r3, long r5) {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.f15340a == false) goto L6;
            this.f15341b += r3;     // Catch: Throwable -> L8
            this.f15342c += r5;     // Catch: Throwable -> L8
        L6:
            monitor-exit(this);
        }

        public synchronized boolean d() {
            monitor-enter(this);
            boolean r0 = this.f15340a;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void e() {
            monitor-enter(this);
            this.f15340a = false;     // Catch: Throwable -> L7
            this.f15342c = -1;     // Catch: Throwable -> L7
            this.f15341b = -1;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public synchronized void f(long r1, long r3) {
            monitor-enter(this);
            this.f15342c = r3;     // Catch: Throwable -> L6
            this.f15341b = r1;     // Catch: Throwable -> L6
            this.f15340a = true;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f15343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f15344b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f15345c;

        public c(long r1, long r3, long r5) {
            this.f15343a = r1;
            this.f15344b = r3;
            this.f15345c = r5;
        }
    }

    static {
        r = e.class;
        s = TimeUnit.HOURS.toMillis(2);
        t = TimeUnit.MINUTES.toMillis(30);
    }

    public e(d r3, i r4, c r5, d.c.b.a.c r6, d.c.b.a.a r7, d.c.c.a.b r8, Context r9, Executor r10, boolean r11) {
        this.p = new Object();
        this.f15327a = r5.f15344b;
        long r0 = r5.f15345c;
        this.f15328b = r0;
        this.f15330d = r0;
        this.f15335i = d.c.c.i.a.d();
        this.f15336j = r3;
        this.f15337k = r4;
        this.f15333g = -1;
        d.c.b.a.f r12 = new d.c.b.a.f();
        this.f15331e = r12;
        r12.i(r6);
        this.f15334h = r5.f15343a;
        this.f15338l = r7;
        this.n = new b();
        this.o = com.facebook.common.time.c.a();
        this.m = r11;
        this.f15332f = new HashSet();
        if (r8 == null) goto L6;
        r8.a(this);
    L6:
        if (r11 == false) goto L8;
        this.f15329c = new CountDownLatch(1);
        r10.execute(new a(this));
        return;
    L8:
        this.f15329c = new CountDownLatch(0);
    }

    static /* synthetic */ Object i(e r0) {
        return r0.p;
    }

    static /* synthetic */ boolean j(e r0) {
        return r0.s();
    }

    static /* synthetic */ boolean k(e r0, boolean r1) {
        r0.q = r1;
        return r1;
    }

    static /* synthetic */ CountDownLatch l(e r0) {
        return r0.f15329c;
    }

    private d.c.a.a n(d.b r4, d.c.b.a.d r5, String r6) {
        Object r0 = this.p;
        monitor-enter(r0);
        d.c.a.a r7 = r4.c(r5);     // Catch: Throwable -> L7
        this.f15332f.add(r6);     // Catch: Throwable -> L7
        this.n.c(r7.size(), 1);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    private void o(long r18, d.c.b.a.c.a r20) {
        Collection<d.a> r0 = p(this.f15336j.h());     // Catch: IOException -> L16
        long r4 = this.n.b();
        long r6 = r4 - r18;
        int r8 = 0;
        Iterator<d.a> r1 = r0.iterator();
        long r11 = 0;
    L6:
        if (r1.hasNext() == false) goto L14;
        d.a r13 = r1.next();
        if (r11 > r6) goto L14;
        long r14 = this.f15336j.k(r13);
        this.f15332f.remove(r13.getId());
        this.f15336j.a(r13.getId());
        if (r14 <= 0) goto L6;
        r8 = r8 + 1;
        r11 = r11 + r14;
        k r9 = k.a();
        r9.j(r13.getId());
        r9.g(r20);
        r9.i(r14);
        r9.f(r4 - r11);
        r9.e(r18);
        this.f15331e.b(r9);
        r9.b();
    L14:
        this.n.c(-r11, -r8);
        this.f15336j.b();
        return;
    L16:
        e = move-exception;
        this.f15338l.a(d.c.b.a.a.EnumC0411a.t, r, "evictAboveSize: " + e.getMessage(), e);
        throw e;
    }

    private Collection<d.a> p(Collection<d.a> r8) {
        long r0 = this.o.now() + s;
        ArrayList r2 = new ArrayList(r8.size());
        ArrayList r3 = new ArrayList(r8.size());
        Iterator<d.a> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L9;
        d.a r4 = r9.next();
        if (r4.b() > r0) goto L7;
        r3.add(r4);
        goto L4
    L7:
        r2.add(r4);
        goto L4
    L9:
        Collections.sort(r3, this.f15337k.get());
        r2.addAll(r3);
        return r2;
    }

    private void r() {
        Object r0 = this.p;
        monitor-enter(r0);
        boolean r1 = s();     // Catch: Throwable -> L13
        y();     // Catch: Throwable -> L13
        long r2 = this.n.b();     // Catch: Throwable -> L13
        if (r2 <= this.f15330d) goto L8;
        if (r1 == true) goto L8;
        this.n.e();     // Catch: Throwable -> L13
        s();     // Catch: Throwable -> L13
    L8:
        long r4 = this.f15330d;     // Catch: Throwable -> L13
        if (r2 <= r4) goto L11;
        o((r4 * 9) / 10, d.c.b.a.c.a.f15263f);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private boolean s() {
        long r0 = this.o.now();
        if (this.n.d() == false) goto L12;
        long r2 = this.f15333g;
        if (r2 == (-1)) goto L12;
        if ((r0 - r2) > t) goto L12;
        return false;
    L12:
        return t();
    }

    private boolean t() {
        long r2 = this.o.now();
        long r4 = s + r2;
        if (this.m == false) goto L8;
        if (this.f15332f.isEmpty() == false) goto L8;
        Set<String> r0 = this.f15332f;
    L39:
        Iterator<d.a> r8 = this.f15336j.h().iterator();     // Catch: IOException -> L36
        long r9 = 0;
        long r11 = -1;
        int r7 = 0;
        boolean r13 = false;
        int r14 = 0;
        int r15 = 0;
    L13:
        if (r8.hasNext() == false) goto L21;
        d.a r16 = r8.next();     // Catch: IOException -> L36
        r14 = r14 + 1;     // Catch: IOException -> L36
        r9 = r9 + r16.a();     // Catch: IOException -> L36
        if (r16.b() <= r4) goto L17;
        r15 = r15 + 1;     // Catch: IOException -> L36
        r7 = (int) (((long) r7) + r16.a());     // Catch: IOException -> L36
        long r21 = r4;
        r11 = Math.max(r16.b() - r2, r11);     // Catch: IOException -> L36
        r13 = true;
    L20:
        r4 = r21;
        goto L13
    L17:
        r21 = r4;
        if (this.m == false) goto L20;
        r0.add(r16.getId());     // Catch: IOException -> L36
        goto L20
    L21:
        if (r13 == false) goto L23;
        this.f15338l.a(d.c.b.a.a.EnumC0411a.f15259i, r, "Future timestamp found in " + r15 + " files , with a total size of " + r7 + " bytes, and a maximum time delta of " + r11 + "ms", null);     // Catch: IOException -> L36
    L23:
        long r6 = r14;
        if (this.n.a() != r6) goto L28;
        if (this.n.b() != r9) goto L28;
    L33:
        x();     // Catch: IOException -> L36
        this.f15333g = r2;
        return true;
    L28:
        if (this.m == false) goto L32;
        Set<String> r5 = this.f15332f;     // Catch: IOException -> L36
        if (r5 == r0) goto L32;
        r5.clear();     // Catch: IOException -> L36
        this.f15332f.addAll(r0);     // Catch: IOException -> L36
    L32:
        this.n.f(r9, r6);     // Catch: IOException -> L36
    L36:
        e = move-exception;
        this.f15338l.a(d.c.b.a.a.EnumC0411a.u, r, "calcFileCacheSize: " + e.getMessage(), e);
        return false;
    L8:
        if (this.m == false) goto L10;
        r0 = new HashSet();
        goto L39
    L10:
        r0 = null;
        goto L39
    }

    private void u(String r2, Collection<d.a> r3) {
        Iterator<d.a> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == true) goto L6;
        this.f15336j.a(r2);     // Catch: IOException -> L10
        return;
    L10:
        e = move-exception;
        throw e;
    L6:
        if (r2.equals(r4.next().getId()) == false) goto L4;
    }

    private d.b v(String r1, d.c.b.a.d r2) {
        r();
        return this.f15336j.c(r1, r2);
    }

    private void w(double r6) {
        Object r0 = this.p;
        monitor-enter(r0);
        this.n.e();     // Catch: Throwable -> L6 IOException -> L8
        s();     // Catch: Throwable -> L6 IOException -> L8
        long r1 = this.n.b();     // Catch: Throwable -> L6 IOException -> L8
        o(r1 - ((long) (r6 * r1)), d.c.b.a.c.a.f15266i);     // Catch: Throwable -> L6 IOException -> L8
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    L8:
        e = move-exception;
        this.f15338l.a(d.c.b.a.a.EnumC0411a.t, r, "trimBy: " + e.getMessage(), e);     // Catch: Throwable -> L6
        goto L10
    }

    private void x() {
        Object r0 = this.p;
        monitor-enter(r0);
        Collection<d.a> r1 = this.f15336j.d();     // Catch: Throwable -> L11 IOException -> L13
        List<d.a> r2 = this.f15336j.j();     // Catch: Throwable -> L11 IOException -> L13
        if (r1.size() <= r2.size()) goto L14;
        Iterator<d.a> r3 = r1.iterator();     // Catch: Throwable -> L11 IOException -> L13
    L8:
        if (r3.hasNext() == false) goto L14;
        u(r3.next().getId(), r2);     // Catch: Throwable -> L11 IOException -> L13
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L13:
        d.c.c.e.a.f(r, "remove config file failed");     // Catch: Throwable -> L11
        goto L14
    }

    private void y() {
        if (this.f15336j.isExternal() == false) goto L5;
        d.c.c.i.a.EnumC0415a r0 = d.c.c.i.a.EnumC0415a.f15435g;
    L7:
        if (this.f15335i.f(r0, this.f15328b - this.n.b()) == false) goto L9;
        long r1 = this.f15327a;
    L10:
        this.f15330d = r1;
        return;
    L9:
        r1 = this.f15328b;
        goto L10
    L5:
        r0 = d.c.c.i.a.EnumC0415a.f15434f;
        goto L7
    }

    @Override // d.c.b.b.j
    public long a() {
        return this.n.b();
    }

    @Override // d.c.b.b.j
    public Map<String, String> b(d.c.b.a.d r5) {
        List<String> r0 = d.c.b.a.e.b(r5);
        Map<String, String> r1 = null;
        int r2 = 0;
    L4:
        if (r2 >= r0.size()) goto L9;
        String r3 = r0.get(r2);
        r1 = this.f15336j.f(r3, r5);
        if (r1 != null) goto L9;
        r2 = r2 + 1;
    L9:
        return r1;
    }

    @Override // d.c.b.b.j
    public d.c.a.a c(d.c.b.a.d r9) {
        k r0 = k.a();
        r0.d(r9);
        Object r2 = this.p;     // Catch: Throwable -> L21 IOException -> L23
        monitor-enter(r2);     // Catch: Throwable -> L21 IOException -> L23
        List<String> r3 = d.c.b.a.e.b(r9);     // Catch: Throwable -> L18
        int r4 = 0;
        String r5 = null;
        d.c.a.a r6 = null;
    L7:
        if (r4 >= r3.size()) goto L12;
        r5 = r3.get(r4);     // Catch: Throwable -> L18
        r0.j(r5);     // Catch: Throwable -> L18
        r6 = this.f15336j.g(r5, r9);     // Catch: Throwable -> L18
        if (r6 != null) goto L12;
        r4 = r4 + 1;     // Catch: Throwable -> L18
    L12:
        if (r6 != null) goto L14;
        this.f15331e.a(r0);     // Catch: Throwable -> L18
        this.f15332f.remove(r5);     // Catch: Throwable -> L18
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L18
        r0.b();
        return r6;
    L14:
        this.f15331e.e(r0);     // Catch: Throwable -> L18
        this.f15332f.add(r5);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21 IOException -> L23
    L21:
        th = move-exception;
        r0.b();
        throw th;
    L23:
        e = move-exception;
        this.f15338l.a(d.c.b.a.a.EnumC0411a.u, r, "getResource", e);     // Catch: Throwable -> L21
        r0.h(e);     // Catch: Throwable -> L21
        this.f15331e.g(r0);     // Catch: Throwable -> L21
        r0.b();
        return null;
    }

    @Override // d.c.c.a.a
    public void d() {
        m();
    }

    @Override // d.c.c.a.a
    public void e() {
        Object r0 = this.p;
        monitor-enter(r0);
        s();     // Catch: Throwable -> L18
        long r1 = this.n.b();     // Catch: Throwable -> L18
        long r3 = this.f15334h;     // Catch: Throwable -> L18
        if (r3 > 0) goto L7;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L7:
        if (r1 <= 0) goto L16;
        if (r1 < r3) goto L16;
        double r5 = 1.0d - (r3 / r1);     // Catch: Throwable -> L18
        if (r5 <= 0.02d) goto L14;
        w(r5);     // Catch: Throwable -> L18
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // d.c.b.b.j
    public void f(d.c.b.a.d r6) {
        Object r0 = this.p;
        monitor-enter(r0);
        List<String> r7 = d.c.b.a.e.b(r6);     // Catch: Throwable -> L9 IOException -> L11
        int r1 = 0;
    L6:
        if (r1 >= r7.size()) goto L13;
        String r2 = r7.get(r1);     // Catch: Throwable -> L9 IOException -> L11
        this.f15336j.remove(r2);     // Catch: Throwable -> L9 IOException -> L11
        this.f15332f.remove(r2);     // Catch: Throwable -> L9 IOException -> L11
        this.f15336j.a(r2);     // Catch: Throwable -> L9 IOException -> L11
        r1 = r1 + 1;
        goto L6
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        e = move-exception;
        this.f15338l.a(d.c.b.a.a.EnumC0411a.s, r, "delete: " + e.getMessage(), e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // d.c.b.b.j
    public boolean g(d.c.b.a.d r8) {
        Object r0 = this.p;
        monitor-enter(r0);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (q(r8) == false) goto L26;
        monitor-exit(r0);     // Catch: Throwable -> L22
        return true;
    L26:
        List<String> r3 = d.c.b.a.e.b(r8);     // Catch: IOException -> L20 Throwable -> L22
        int r4 = 0;
    L11:
        if (r4 >= r3.size()) goto L18;
        String r5 = r3.get(r4);     // Catch: IOException -> L20 Throwable -> L22
        if (this.f15336j.e(r5, r8) == true) goto L14;
        r4 = r4 + 1;     // Catch: Throwable -> L22
        goto L11
    L14:
        this.f15332f.add(r5);     // Catch: IOException -> L20 Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        return true;
        goto L21
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L22
        return false;
    L21:
        return false;
    }

    @Override // d.c.b.b.j
    public long getCount() {
        return this.n.a();
    }

    @Override // d.c.b.b.j
    public d.c.a.a h(d.c.b.a.d r5, d.c.b.a.k r6) {
        k r0 = k.a();
        r0.d(r5);
        this.f15331e.h(r0);
        Object r1 = this.p;
        monitor-enter(r1);
        String r2 = d.c.b.a.e.a(r5);     // Catch: Throwable -> L26
        monitor-exit(r1);     // Catch: Throwable -> L26
        r0.j(r2);
        d.b r3 = v(r2, r5);     // Catch: Throwable -> L19 IOException -> L21
        r3.b(r6, r5);     // Catch: Throwable -> L14
        d.c.a.a r7 = n(r3, r5, r2);     // Catch: Throwable -> L14
        r0.i(r7.size());     // Catch: Throwable -> L14
        r0.f(this.n.b());     // Catch: Throwable -> L14
        this.f15331e.f(r0);     // Catch: Throwable -> L14
        if (r3.a() == true) goto L12;
        d.c.c.e.a.f(r, "Failed to delete temp file");     // Catch: Throwable -> L19 IOException -> L21
    L12:
        r0.b();
        return r7;
    L14:
        th = move-exception;
        if (r3.a() == true) goto L18;
        d.c.c.e.a.f(r, "Failed to delete temp file");     // Catch: Throwable -> L19 IOException -> L21
    L18:
        throw th;     // Catch: Throwable -> L19 IOException -> L21
    L21:
        e = move-exception;
        r0.h(e);     // Catch: Throwable -> L19
        this.f15331e.d(r0);     // Catch: Throwable -> L19
        d.c.c.e.a.g(r, "Failed inserting a file into the cache", e);     // Catch: Throwable -> L19
        throw e;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r0.b();
        throw th;
    L26:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void m() {
        Object r0 = this.p;
        monitor-enter(r0);
        this.f15336j.i();     // Catch: Throwable -> L6 Throwable -> L8
        this.f15332f.clear();     // Catch: Throwable -> L6 Throwable -> L8
        this.f15331e.c();     // Catch: Throwable -> L6 Throwable -> L8
    L10:
        this.n.e();     // Catch: Throwable -> L6
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L8:
        e = move-exception;
        this.f15338l.a(d.c.b.a.a.EnumC0411a.t, r, "clearAll: " + e.getMessage(), e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public boolean q(d.c.b.a.d r6) {
        Object r0 = this.p;
        monitor-enter(r0);
        List<String> r7 = d.c.b.a.e.b(r6);     // Catch: Throwable -> L15
        int r2 = 0;
    L6:
        if (r2 >= r7.size()) goto L13;
        if (this.f15332f.contains(r7.get(r2)) == true) goto L9;
        r2 = r2 + 1;     // Catch: Throwable -> L15
        goto L6
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return true;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return false;
    L15:
        th = move-exception;
        throw th;
    }
}
