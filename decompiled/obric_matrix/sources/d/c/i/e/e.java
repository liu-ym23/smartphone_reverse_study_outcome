package d.c.i.e;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Class<?> f15926j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.b.b.j f15927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.c.g.i f15928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.c.c.g.l f15929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Executor f15930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Executor f15931e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final w f15932f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final n f15933g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f15934h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f15935i;

    class a implements Callable<d.c.i.l.e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f15936f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d.c.b.a.d f15937g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ e f15938h;

        a(e r1, AtomicBoolean r2, d.c.b.a.d r3) {
            this.f15938h = r1;
            this.f15936f = r2;
            this.f15937g = r3;
        }

        public d.c.i.l.e a() {
        L45:
            th = move-exception;
            if (d.c.i.r.b.d() == false) goto L49;
            d.c.i.r.b.b();
        L49:
            throw th;
        L3:
            if (d.c.i.r.b.d() == false) goto L6;
            d.c.i.r.b.a("BufferedDiskCache#getAsync");     // Catch: Throwable -> L45
        L6:
            if (this.f15936f.get() == true) goto L44;
            d.c.i.l.e r0 = e.a(this.f15938h).a(this.f15937g);     // Catch: Throwable -> L45
            if (r0 == null) goto L10;
            d.c.c.e.a.s(e.d(), "Found image for %s in staging area", this.f15937g.a());     // Catch: Throwable -> L45
            e.e(this.f15938h).m(this.f15937g);     // Catch: Throwable -> L45
        L26:
            if (Thread.interrupted() == false) goto L33;
            d.c.c.e.a.r(e.d(), "Host thread was interrupted, decreasing reference count");     // Catch: Throwable -> L45
            if (r0 == null) goto L31;
            r0.close();     // Catch: Throwable -> L45
        L31:
            throw new InterruptedException();     // Catch: Throwable -> L45
        L33:
            if (d.c.i.r.b.d() == false) goto L35;
            d.c.i.r.b.b();
        L35:
            return r0;
        L10:
            d.c.c.e.a.s(e.d(), "Did not find image for %s in staging area", this.f15937g.a());     // Catch: Throwable -> L45
            e.e(this.f15938h).j();     // Catch: Throwable -> L45
            Map<String, String> r1 = e.f(this.f15938h).b(this.f15937g);     // Catch: Exception -> L39 Throwable -> L45
            if (e.g(this.f15938h) == false) goto L15;
            String r2 = r1.get(this.f15937g.a());     // Catch: Exception -> L39 Throwable -> L45
            d.c.c.g.h r4 = e.h(this.f15938h, this.f15937g, r2);     // Catch: Exception -> L39 Throwable -> L45
        L16:
            if (r4 == null) goto L18;
            d.c.c.h.a r5 = d.c.c.h.a.V(r4);     // Catch: Exception -> L39 Throwable -> L45
            d.c.i.l.e r3 = new d.c.i.l.e(r5);     // Catch: Throwable -> L36
            r3.B0(r1);     // Catch: Throwable -> L36
            d.c.c.h.a.L(r5);     // Catch: Exception -> L39 Throwable -> L45
            r0 = r3;
        L36:
            th = move-exception;
            d.c.c.h.a.L(r5);     // Catch: Exception -> L39 Throwable -> L45
            throw th;     // Catch: Exception -> L39 Throwable -> L45
        L18:
            if (d.c.i.r.b.d() == false) goto L20;
            d.c.i.r.b.b();
        L20:
            return null;
        L15:
            r4 = e.i(this.f15938h, this.f15937g);     // Catch: Exception -> L39 Throwable -> L45
            goto L16
        L40:
            if (d.c.i.r.b.d() == false) goto L42;
            d.c.i.r.b.b();
        L42:
            return null;
        L44:
            throw new CancellationException();     // Catch: Throwable -> L45
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ d.c.i.l.e call() {
            return a();
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d.c.b.a.d f15939f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d.c.i.l.e f15940g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ e f15941h;

        b(e r1, d.c.b.a.d r2, d.c.i.l.e r3) {
            this.f15941h = r1;
            this.f15939f = r2;
            this.f15940g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
        L13:
            th = move-exception;
            e.a(this.f15941h).f(this.f15939f, this.f15940g);
            d.c.i.l.e.g(this.f15940g);
            if (d.c.i.r.b.d() == false) goto L17;
            d.c.i.r.b.b();
        L17:
            throw th;
        L3:
            if (d.c.i.r.b.d() == false) goto L6;
            d.c.i.r.b.a("BufferedDiskCache#putAsync");     // Catch: Throwable -> L13
        L6:
            if (e.j(this.f15941h) == false) goto L8;
            e.k(this.f15941h, this.f15939f, this.f15940g);     // Catch: Throwable -> L13
        L9:
            e.a(this.f15941h).f(this.f15939f, this.f15940g);
            d.c.i.l.e.g(this.f15940g);
            if (d.c.i.r.b.d() == false) goto L19;
            d.c.i.r.b.b();
            return;
        L19:
            return;
        L8:
            e.b(this.f15941h, this.f15939f, this.f15940g);     // Catch: Throwable -> L13
            goto L9
        }
    }

    class c implements Callable<Void> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d.c.b.a.d f15942f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f15943g;

        c(e r1, d.c.b.a.d r2) {
            this.f15943g = r1;
            this.f15942f = r2;
        }

        public Void a() {
        L11:
            th = move-exception;
            if (d.c.i.r.b.d() == false) goto L15;
            d.c.i.r.b.b();
        L15:
            throw th;
        L3:
            if (d.c.i.r.b.d() == false) goto L5;
            d.c.i.r.b.a("BufferedDiskCache#remove");     // Catch: Throwable -> L11
        L5:
            e.a(this.f15943g).e(this.f15942f);     // Catch: Throwable -> L11
            e.f(this.f15943g).f(this.f15942f);     // Catch: Throwable -> L11
            if (d.c.i.r.b.d() == false) goto L18;
            d.c.i.r.b.b();
            return null;
        L18:
            return null;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Void call() {
            return a();
        }
    }

    class d implements d.c.b.a.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.c.i.l.e f15944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f15945b;

        d(e r1, d.c.i.l.e r2) {
            this.f15945b = r1;
            this.f15944a = r2;
        }

        @Override // d.c.b.a.k
        public void a(OutputStream r2) {
            e.c(this.f15945b).b(this.f15944a.O(), r2);
        }
    }

    static {
        f15926j = e.class;
    }

    public e(d.c.b.b.j r1, d.c.c.g.i r2, d.c.c.g.l r3, Executor r4, Executor r5, n r6) {
        this.f15927a = r1;
        this.f15928b = r2;
        this.f15929c = r3;
        this.f15930d = r4;
        this.f15931e = r5;
        this.f15933g = r6;
        this.f15932f = w.b();
    }

    static /* synthetic */ w a(e r0) {
        return r0.f15932f;
    }

    static /* synthetic */ void b(e r0, d.c.b.a.d r1, d.c.i.l.e r2) {
        r0.v(r1, r2);
    }

    static /* synthetic */ d.c.c.g.l c(e r0) {
        return r0.f15929c;
    }

    static /* synthetic */ Class d() {
        return f15926j;
    }

    static /* synthetic */ n e(e r0) {
        return r0.f15933g;
    }

    static /* synthetic */ d.c.b.b.j f(e r0) {
        return r0.f15927a;
    }

    static /* synthetic */ boolean g(e r0) {
        return r0.f15934h;
    }

    static /* synthetic */ d.c.c.g.h h(e r0, d.c.b.a.d r1, String r2) {
        return r0.r(r1, r2);
    }

    static /* synthetic */ d.c.c.g.h i(e r0, d.c.b.a.d r1) {
        return r0.q(r1);
    }

    static /* synthetic */ boolean j(e r0) {
        return r0.f15935i;
    }

    static /* synthetic */ void k(e r0, d.c.b.a.d r1, d.c.i.l.e r2) {
        r0.w(r1, r2);
    }

    private c.f<d.c.i.l.e> l(d.c.b.a.d r4, d.c.i.l.e r5) {
        d.c.c.e.a.s(f15926j, "Found image for %s in staging area", r4.a());
        this.f15933g.m(r4);
        return c.f.h(r5);
    }

    private c.f<d.c.i.l.e> n(d.c.b.a.d r3, AtomicBoolean r4) {
        return c.f.b(new a(this, r4, r3), this.f15930d);
    L4:
        e = move-exception;
        d.c.c.e.a.B(f15926j, e, "Failed to schedule disk-cache read for %s", new Object[]{r3.a()});
        return c.f.g(e);
    }

    private d.c.c.g.h q(d.c.b.a.d r7) {
        Class<?> r0 = f15926j;     // Catch: Exception -> L18
        d.c.c.e.a.t(r0, "Disk cache read for %s needEncrypt = %s", r7.a(), Boolean.valueOf(this.f15935i));     // Catch: Exception -> L18
        d.c.a.a r1 = this.f15927a.c(r7);     // Catch: Exception -> L18
        d.c.c.g.h r2 = null;
        if (r1 != null) goto L6;
        d.c.c.e.a.s(r0, "Disk cache miss for %s", r7.a());     // Catch: Exception -> L18
        this.f15933g.h();     // Catch: Exception -> L18
        return null;
    L6:
        d.c.c.e.a.s(r0, "Found entry in disk cache for %s", r7.a());     // Catch: Exception -> L18
        this.f15933g.d(r7);     // Catch: Exception -> L18
        InputStream r3 = r1.a();     // Catch: Exception -> L18
    L15:
        th = move-exception;
        r3.close();     // Catch: Exception -> L18
        throw th;     // Catch: Exception -> L18
    L8:
        if (this.f15935i == false) goto L12;
        byte[] r4 = o.a(r3);     // Catch: Throwable -> L15
        if (r4 == null) goto L13;
        r2 = this.f15928b.b(r4);     // Catch: Throwable -> L15
    L13:
        r3.close();     // Catch: Exception -> L18
        d.c.c.e.a.t(r0, "Successful read from disk cache for %s needEncrypt = %s", r7.a(), Boolean.valueOf(this.f15935i));     // Catch: Exception -> L18
        return r2;
    L12:
        r2 = this.f15928b.e(r3, (int) r1.size());     // Catch: Throwable -> L15
    L18:
        e = move-exception;
        d.c.c.e.a.B(f15926j, e, "Exception reading from cache for %s needEncrypt = %s", new Object[]{r7.a(), Boolean.valueOf(this.f15935i)});
        this.f15933g.f();
        throw e;
    }

    private d.c.c.g.h r(d.c.b.a.d r7, String r8) {
        Class<?> r0 = f15926j;     // Catch: IOException -> L16
        d.c.c.e.a.t(r0, "Disk cache read for %s, compare to md5:%s", r7.a(), r8);     // Catch: IOException -> L16
        d.c.a.a r1 = this.f15927a.c(r7);     // Catch: IOException -> L16
        if (r1 != null) goto L6;
        d.c.c.e.a.s(r0, "Disk cache miss for %s", r7.a());     // Catch: IOException -> L16
        this.f15933g.h();     // Catch: IOException -> L16
        return null;
    L6:
        d.c.c.e.a.s(r0, "Found entry in disk cache for %s", r7.a());     // Catch: IOException -> L16
        this.f15933g.d(r7);     // Catch: IOException -> L16
        InputStream r2 = r1.a();     // Catch: IOException -> L16
        d.c.c.g.h r9 = this.f15928b.c(r2, (int) r1.size(), r8);     // Catch: Throwable -> L13
        r2.close();     // Catch: IOException -> L16
        if (r9 != null) goto L11;
        d.c.c.e.a.s(r0, "Failed read from disk cache or MD5 did not match for %s", r7.a());     // Catch: IOException -> L16
        this.f15933g.h();     // Catch: IOException -> L16
    L12:
        return r9;
    L11:
        d.c.c.e.a.s(r0, "Successful read from disk cache for %s", r7.a());     // Catch: IOException -> L16
        this.f15933g.d(r7);     // Catch: IOException -> L16
        goto L12
    L13:
        th = move-exception;
        r2.close();     // Catch: IOException -> L16
        throw th;     // Catch: IOException -> L16
    L16:
        e = move-exception;
        d.c.c.e.a.B(f15926j, e, "Exception reading from cache for %s", new Object[]{r7.a()});
        this.f15933g.f();
        throw e;
    }

    private void v(d.c.b.a.d r5, d.c.i.l.e r6) {
        Class<?> r0 = f15926j;
        d.c.c.e.a.s(r0, "About to write to disk-cache for key %s", r5.a());
        this.f15927a.h(new d.c.b.b.f(r5, r6.F()), new d(this, r6));     // Catch: IOException -> L5
        d.c.c.e.a.s(r0, "Successful disk-cache write for key %s", r5.a());     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        d.c.c.e.a.B(f15926j, e, "Failed to write to disk-cache for key %s", new Object[]{r5.a()});
    }

    private void w(d.c.b.a.d r5, d.c.i.l.e r6) {
        d.c.c.e.a.s(f15926j, "About to write to disk-cache encrypt for key %s", r5.a());
        d.c.i.l.e r0 = null;
        byte[] r1 = o.b(r6.O());     // Catch: Throwable -> L13 Exception -> L15
        if (r1 == null) goto L12;
        d.c.i.l.e r2 = new d.c.i.l.e(d.c.c.h.a.V(this.f15928b.b(r1)));     // Catch: Throwable -> L13 Exception -> L15
        r2.l(r6);     // Catch: Throwable -> L8 Exception -> L10
        v(r5, r2);     // Catch: Throwable -> L8 Exception -> L10
        r0 = r2;
        goto L12
    L10:
        e = e;
        r0 = r2;
    L16:
        d.c.c.e.a.B(f15926j, e, "Failed to write to disk-cache encrypt for key %s", new Object[]{r5.a()});     // Catch: Throwable -> L13
    L8:
        th = th;
        r0 = r2;
    L19:
        d.c.i.l.e.g(r0);
        throw th;
    L12:
        d.c.i.l.e.g(r0);
        return;
    L15:
        e = e;
    L13:
        th = th;
        goto L19
    }

    public c.f<d.c.i.l.e> m(d.c.b.a.d r2, AtomicBoolean r3) {
    L17:
        th = move-exception;
        if (d.c.i.r.b.d() == false) goto L21;
        d.c.i.r.b.b();
    L21:
        throw th;
    L3:
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("BufferedDiskCache#get");     // Catch: Throwable -> L17
    L5:
        d.c.i.l.e r0 = this.f15932f.a(r2);     // Catch: Throwable -> L17
        if (r0 == null) goto L12;
        c.f<d.c.i.l.e> r1 = l(r2, r0);     // Catch: Throwable -> L17
        if (d.c.i.r.b.d() == false) goto L11;
        d.c.i.r.b.b();
    L11:
        return r1;
    L12:
        c.f<d.c.i.l.e> r4 = n(r2, r3);     // Catch: Throwable -> L17
        if (d.c.i.r.b.d() == false) goto L16;
        d.c.i.r.b.b();
    L16:
        return r4;
    }

    public boolean o() {
        return this.f15934h;
    }

    public void p(d.c.b.a.d r8, d.c.i.l.e r9) {
    L14:
        th = move-exception;
        if (d.c.i.r.b.d() == false) goto L18;
        d.c.i.r.b.b();
    L18:
        throw th;
    L3:
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("BufferedDiskCache#put");     // Catch: Throwable -> L14
    L5:
        d.c.c.d.i.g(r8);     // Catch: Throwable -> L14
        d.c.c.d.i.b(d.c.i.l.e.q0(r9));     // Catch: Throwable -> L14
        this.f15932f.d(r8, r9);     // Catch: Throwable -> L14
        d.c.i.l.e r0 = d.c.i.l.e.b(r9);     // Catch: Throwable -> L14
        this.f15931e.execute(new b(this, r8, r0));     // Catch: Exception -> L8 Throwable -> L14
    L11:
        if (d.c.i.r.b.d() == false) goto L23;
        d.c.i.r.b.b();
        return;
    L23:
        return;
    L8:
        e = move-exception;
        d.c.c.e.a.B(f15926j, e, "Failed to schedule disk-cache write for %s", new Object[]{r8.a()});     // Catch: Throwable -> L14
        this.f15932f.f(r8, r9);     // Catch: Throwable -> L14
        d.c.i.l.e.g(r0);     // Catch: Throwable -> L14
        goto L11
    }

    public c.f<Void> s(d.c.b.a.d r4) {
        d.c.c.d.i.g(r4);
        this.f15932f.e(r4);
        return c.f.b(new c(this, r4), this.f15931e);
    L5:
        e = move-exception;
        d.c.c.e.a.B(f15926j, e, "Failed to schedule disk-cache remove for %s", new Object[]{r4.a()});
        return c.f.g(e);
    }

    public void t(boolean r1) {
        this.f15935i = r1;
    }

    public void u(boolean r1) {
        this.f15934h = r1;
    }
}
