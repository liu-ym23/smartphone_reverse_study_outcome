package k;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ttnet.org.chromium.base.TimeUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.f0;

/* JADX INFO: loaded from: classes2.dex */
public class d extends a0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final long f18244h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f18245i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static d f18246j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f18247k = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f18248e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d f18249f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f18250g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public static final /* synthetic */ boolean a(a r0, d r1) {
            return r0.d(r1);
        }

        public static final /* synthetic */ void b(a r0, d r1, long r2, boolean r4) {
            r0.e(r1, r2, r4);
        }

        private final boolean d(d r3) {
            monitor-enter(d.class);
            d r0 = d.i();     // Catch: Throwable -> L15
        L5:
            if (r0 == null) goto L14;
            if (d.l(r0) == r3) goto L8;
            r0 = d.l(r0);     // Catch: Throwable -> L15
            goto L5
        L8:
            d.p(r0, d.l(r3));     // Catch: Throwable -> L15
            d.p(r3, null);     // Catch: Throwable -> L15
            boolean r4 = false;
        L10:
            monitor-exit(d.class);
            return r4;
        L14:
            r4 = true;
        L15:
            th = move-exception;
            throw th;
        }

        private final void e(d r6, long r7, boolean r9) {
            monitor-enter(d.class);
        L42:
            th = move-exception;
            throw th;
        L5:
            if (d.i() != null) goto L7;
            d.o(new d());     // Catch: Throwable -> L42
            new b().start();     // Catch: Throwable -> L42
        L7:
            long r0 = System.nanoTime();     // Catch: Throwable -> L42
            if (r7 == 0) goto L12;
            if (r9 == false) goto L12;
            r7 = Math.min(r7, r6.c() - r0);     // Catch: Throwable -> L42
        L11:
            d.q(r6, r7 + r0);     // Catch: Throwable -> L42
        L16:
            long r8 = d.n(r6, r0);     // Catch: Throwable -> L42
            d r10 = d.i();     // Catch: Throwable -> L42
            if (r10 != null) goto L19;
            kotlin.n0.d.o.p();     // Catch: Throwable -> L42
            throw null;
        L19:
            if (d.l(r10) == null) goto L32;
            d r3 = d.l(r10);     // Catch: Throwable -> L42
            if (r3 == null) goto L30;
            if (r8 < d.n(r3, r0)) goto L32;
            r10 = d.l(r10);     // Catch: Throwable -> L42
            if (r10 != null) goto L19;
            kotlin.n0.d.o.p();     // Catch: Throwable -> L42
            throw null;
        L30:
            kotlin.n0.d.o.p();     // Catch: Throwable -> L42
            throw null;
        L32:
            d.p(r6, d.l(r10));     // Catch: Throwable -> L42
            d.p(r10, r6);     // Catch: Throwable -> L42
            if (r10 != d.i()) goto L35;
            d.class.notify();     // Catch: Throwable -> L42
        L35:
            f0 r11 = f0.f18324a;     // Catch: Throwable -> L42
            monitor-exit(d.class);
            return;
        L12:
            if (r7 != 0) goto L11;
            if (r9 == false) goto L41;
            d.q(r6, r6.c());     // Catch: Throwable -> L42
            goto L16
        L41:
            throw new AssertionError();     // Catch: Throwable -> L42
        }

        public final d c() {
            d r0 = d.i();
            if (r0 == null) goto L26;
            d r1 = d.l(r0);
            long r2 = System.nanoTime();
            if (r1 != null) goto L16;
            d.class.wait(d.j());
            d r8 = d.i();
            if (r8 != null) goto L9;
            kotlin.n0.d.o.p();
            throw null;
        L9:
            if (d.l(r8) == null) goto L11;
            return null;
        L11:
            if ((System.nanoTime() - r2) >= d.k()) goto L13;
            return null;
        L13:
            return d.i();
        L16:
            long r3 = d.n(r1, r2);
            if (r3 <= 0) goto L20;
            long r6 = r3 / TimeUtils.NANOSECONDS_PER_MILLISECOND;
            d.class.wait(r6, (int) (r3 - (TimeUtils.NANOSECONDS_PER_MILLISECOND * r6)));
            return null;
        L20:
            d r9 = d.i();
            if (r9 == null) goto L24;
            d.p(r9, d.l(r1));
            d.p(r1, null);
            return r1;
        L24:
            kotlin.n0.d.o.p();
            throw null;
        L26:
            kotlin.n0.d.o.p();
            throw null;
        }
    }

    private static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
        L17:
            monitor-enter(d.class);     // Catch: InterruptedException -> L16
            d r0 = d.f18247k.c();     // Catch: Throwable -> L13
            if (r0 != d.i()) goto L9;
            d.o(null);     // Catch: Throwable -> L13
            goto L17
        L7:
            monitor-exit(d.class);     // Catch: InterruptedException -> L16
            return;
        L9:
            f0 r1 = f0.f18324a;     // Catch: Throwable -> L13
            monitor-exit(d.class);     // Catch: InterruptedException -> L16
            if (r0 == null) goto L17;
            r0.x();     // Catch: InterruptedException -> L16
        L13:
            th = move-exception;
            throw th;     // Catch: InterruptedException -> L16
        }
    }

    public static final class c implements x {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f18251f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ x f18252g;

        c(d r1, x r2) {
            this.f18251f = r1;
            this.f18252g = r2;
        }

        @Override // k.x
        public void J(e r8, long r9) {
            kotlin.n0.d.o.g(r8, "source");
            k.c.b(r8.k0(), 0, r9);
        L3:
            long r0 = 0;
            if (r9 <= 0) goto L36;
            u r2 = r8.f18255f;
            if (r2 == null) goto L34;
        L8:
            if (r0 >= 65536) goto L17;
            r0 = r0 + ((long) (r2.f18305c - r2.f18304b));
            if (r0 >= r9) goto L11;
            r2 = r2.f18308f;
            if (r2 != null) goto L8;
            kotlin.n0.d.o.p();
            throw null;
        L11:
            r0 = r9;
        L17:
            d r3 = this.f18251f;
            r3.r();
            this.f18252g.J(r8, r0);     // Catch: Throwable -> L24 IOException -> L26
            f0 r4 = f0.f18324a;     // Catch: Throwable -> L24 IOException -> L26
        L20:
            if (r3.s() == true) goto L23;
            r9 = r9 - r0;
            goto L3
        L23:
            throw r3.m(null);
        L24:
            th = move-exception;
            r3.s();
            throw th;
        L26:
            e = move-exception;
            if (r3.s() == true) goto L31;
            throw e;     // Catch: Throwable -> L24
        L31:
            throw r3.m(e);     // Catch: Throwable -> L24
        L34:
            kotlin.n0.d.o.p();
            throw null;
        }

        public d a() {
            return this.f18251f;
        }

        @Override // k.x, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            d r0 = this.f18251f;
            r0.r();
            this.f18252g.close();     // Catch: Throwable -> L9 IOException -> L11
            f0 r2 = f0.f18324a;     // Catch: Throwable -> L9 IOException -> L11
        L5:
            if (r0.s() == true) goto L8;
            return;
        L8:
            throw r0.m(null);
        L9:
            th = move-exception;
            r0.s();
            throw th;
        L11:
            e = move-exception;
            if (r0.s() == true) goto L16;
            throw e;     // Catch: Throwable -> L9
        L16:
            throw r0.m(e);     // Catch: Throwable -> L9
        }

        @Override // k.x
        public /* bridge */ /* synthetic */ a0 e() {
            return a();
        }

        @Override // k.x, java.io.Flushable
        public void flush() {
            d r0 = this.f18251f;
            r0.r();
            this.f18252g.flush();     // Catch: Throwable -> L9 IOException -> L11
            f0 r2 = f0.f18324a;     // Catch: Throwable -> L9 IOException -> L11
        L5:
            if (r0.s() == true) goto L8;
            return;
        L8:
            throw r0.m(null);
        L9:
            th = move-exception;
            r0.s();
            throw th;
        L11:
            e = move-exception;
            if (r0.s() == true) goto L16;
            throw e;     // Catch: Throwable -> L9
        L16:
            throw r0.m(e);     // Catch: Throwable -> L9
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f18252g + ')';
        }
    }

    /* JADX INFO: renamed from: k.d$d, reason: collision with other inner class name */
    public static final class C0471d implements z {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f18253f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ z f18254g;

        C0471d(d r1, z r2) {
            this.f18253f = r1;
            this.f18254g = r2;
        }

        @Override // k.z
        public long Z(e r2, long r3) {
            kotlin.n0.d.o.g(r2, "sink");
            d r0 = this.f18253f;
            r0.r();
            long r1 = this.f18254g.Z(r2, r3);     // Catch: Throwable -> L9 IOException -> L11
        L5:
            if (r0.s() == true) goto L8;
            return r1;
        L8:
            throw r0.m(null);
        L11:
            e = move-exception;
            if (r0.s() == true) goto L16;
            throw e;     // Catch: Throwable -> L9
        L16:
            throw r0.m(e);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            r0.s();
            throw th;
        }

        public d a() {
            return this.f18253f;
        }

        @Override // k.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            d r0 = this.f18253f;
            r0.r();
            this.f18254g.close();     // Catch: Throwable -> L9 IOException -> L11
            f0 r2 = f0.f18324a;     // Catch: Throwable -> L9 IOException -> L11
        L5:
            if (r0.s() == true) goto L8;
            return;
        L8:
            throw r0.m(null);
        L9:
            th = move-exception;
            r0.s();
            throw th;
        L11:
            e = move-exception;
            if (r0.s() == true) goto L16;
            throw e;     // Catch: Throwable -> L9
        L16:
            throw r0.m(e);     // Catch: Throwable -> L9
        }

        @Override // k.z
        public /* bridge */ /* synthetic */ a0 e() {
            return a();
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f18254g + ')';
        }
    }

    static {
        f18247k = new a(null);
        long r0 = TimeUnit.SECONDS.toMillis(60);
        f18244h = r0;
        f18245i = TimeUnit.MILLISECONDS.toNanos(r0);
    }

    public d() {
    }

    public static final /* synthetic */ d i() {
        return f18246j;
    }

    public static final /* synthetic */ long j() {
        return f18244h;
    }

    public static final /* synthetic */ long k() {
        return f18245i;
    }

    public static final /* synthetic */ d l(d r0) {
        return r0.f18249f;
    }

    public static final /* synthetic */ long n(d r0, long r1) {
        return r0.u(r1);
    }

    public static final /* synthetic */ void o(d r0) {
        f18246j = r0;
    }

    public static final /* synthetic */ void p(d r0, d r1) {
        r0.f18249f = r1;
    }

    public static final /* synthetic */ void q(d r0, long r1) {
        r0.f18250g = r1;
    }

    private final long u(long r3) {
        return this.f18250g - r3;
    }

    public final IOException m(IOException r1) {
        return t(r1);
    }

    public final void r() {
        if ((!this.f18248e) == false) goto L11;
        long r2 = h();
        boolean r0 = e();
        if (r2 != 0) goto L8;
        if (r0 == true) goto L8;
        return;
    L8:
        this.f18248e = true;
        a.b(f18247k, this, r2, r0);
        return;
    L11:
        throw new IllegalStateException("Unbalanced enter/exit".toString());
    }

    public final boolean s() {
        if (this.f18248e == true) goto L5;
        return false;
    L5:
        this.f18248e = false;
        return a.a(f18247k, this);
    }

    protected IOException t(IOException r2) {
        InterruptedIOException r1 = new InterruptedIOException(LocationMonitorConst.TIMEOUT);
        if (r2 == null) goto L5;
        r1.initCause(r2);
    L5:
        return r1;
    }

    public final x v(x r2) {
        kotlin.n0.d.o.g(r2, "sink");
        return new c(this, r2);
    }

    public final z w(z r2) {
        kotlin.n0.d.o.g(r2, "source");
        return new C0471d(this, r2);
    }

    protected void x() {
    }
}
