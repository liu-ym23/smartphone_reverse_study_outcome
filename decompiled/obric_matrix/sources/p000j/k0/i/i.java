package p000j.k0.i;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import k.a0;
import k.d;
import k.e;
import k.g;
import k.x;
import k.z;
import p000j.v;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f18037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f18038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f18039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final g f18040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Deque<v> f18041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private j.k0.i.c.a f18042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f18043g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final b f18044h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final a f18045i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final c f18046j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final c f18047k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    p000j.k0.i.b f18048l;

    final class a implements x {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final e f18049f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f18050g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f18051h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ i f18052i;

        static {
        }

        a(i r1) {
            this.f18052i = r1;
            this.f18049f = new e();
        }

        private void a(boolean r12) {
            i r0 = this.f18052i;
            monitor-enter(r0);
            this.f18052i.f18047k.r();     // Catch: Throwable -> L33
        L36:
            i r1 = this.f18052i;     // Catch: Throwable -> L30
            if (r1.f18038b > 0) goto L15;
            if (this.f18051h == true) goto L15;
            if (this.f18050g == true) goto L15;
            if (r1.f18048l != null) goto L15;
            r1.t();     // Catch: Throwable -> L30
        L15:
            r1.f18047k.y();     // Catch: Throwable -> L33
            this.f18052i.e();     // Catch: Throwable -> L33
            long r9 = Math.min(this.f18052i.f18038b, this.f18049f.k0());     // Catch: Throwable -> L33
            i r2 = this.f18052i;     // Catch: Throwable -> L33
            r2.f18038b -= r9;     // Catch: Throwable -> L33
            monitor-exit(r0);     // Catch: Throwable -> L33
            r2.f18047k.r();
            i r3 = this.f18052i;     // Catch: Throwable -> L27
            g r5 = r3.f18040d;     // Catch: Throwable -> L27
            int r6 = r3.f18039c;     // Catch: Throwable -> L27
            if (r12 == true) goto L21;
        L23:
            boolean r13 = false;
        L24:
            r5.q0(r6, r13, this.f18049f, r9);     // Catch: Throwable -> L27
            this.f18052i.f18047k.y();
            return;
        L21:
            if (r9 != this.f18049f.k0()) goto L23;
            r13 = true;
        L27:
            th = move-exception;
            this.f18052i.f18047k.y();
            throw th;
        L30:
            th = move-exception;
            this.f18052i.f18047k.y();     // Catch: Throwable -> L33
            throw th;     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            throw th;
        }

        @Override // k.x
        public void J(e r3, long r4) {
            this.f18049f.J(r3, r4);
        L4:
            if (this.f18049f.k0() < 16384) goto L6;
            a(false);
            goto L4
        }

        @Override // k.x, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            i r0 = this.f18052i;
            monitor-enter(r0);
        L26:
            th = move-exception;
            throw th;
        L5:
            if (this.f18050g == false) goto L8;
            monitor-exit(r0);     // Catch: Throwable -> L26
            return;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L26
            if (this.f18052i.f18045i.f18051h == false) goto L12;
        L17:
            i r2 = this.f18052i;
            monitor-enter(r2);
            this.f18050g = true;     // Catch: Throwable -> L23
            monitor-exit(r2);     // Catch: Throwable -> L23
            this.f18052i.f18040d.flush();
            this.f18052i.d();
            return;
        L23:
            th = move-exception;
            throw th;
        L12:
            if (this.f18049f.k0() > 0) goto L14;
            i r1 = this.f18052i;
            r1.f18040d.q0(r1.f18039c, true, null, 0);
        L14:
            if (this.f18049f.k0() <= 0) goto L17;
            a(true);
            goto L14
        }

        @Override // k.x
        public a0 e() {
            return this.f18052i.f18047k;
        }

        @Override // k.x, java.io.Flushable
        public void flush() {
            i r0 = this.f18052i;
            monitor-enter(r0);
            this.f18052i.e();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
        L7:
            if (this.f18049f.k0() <= 0) goto L9;
            a(false);
            this.f18052i.f18040d.flush();
            goto L7
        L9:
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    private final class b implements z {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final e f18053f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final e f18054g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final long f18055h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f18056i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f18057j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ i f18058k;

        static {
        }

        b(i r1, long r2) {
            this.f18058k = r1;
            this.f18053f = new e();
            this.f18054g = new e();
            this.f18055h = r2;
        }

        private void b(long r1) {
            this.f18058k.f18040d.p0(r1);
        }

        @Override // k.z
        public long Z(e r17, long r18) {
            if (r18 < 0) goto L57;
        L4:
            i r6 = this.f18058k;
            monitor-enter(r6);
            this.f18058k.f18046j.r();     // Catch: Throwable -> L53
            i r0 = this.f18058k;     // Catch: Throwable -> L50
            p000j.k0.i.b r7 = r0.f18048l;     // Catch: Throwable -> L50
            if (r7 != null) goto L12;
            r7 = null;
        L12:
            if (this.f18056i == true) goto L49;
            if (i.a(r0).isEmpty() == true) goto L19;
            if (i.b(this.f18058k) == null) goto L19;
            v r8 = (v) i.a(this.f18058k).removeFirst();     // Catch: Throwable -> L50
            j.k0.i.c.a r10 = i.b(this.f18058k);     // Catch: Throwable -> L50
        L34:
            long r11 = -1;
        L35:
            this.f18058k.f18046j.y();     // Catch: Throwable -> L53
            monitor-exit(r6);     // Catch: Throwable -> L53
            if (r8 == null) goto L41;
            if (r10 == null) goto L41;
            r10.a(r8);
        L41:
            if (r11 == (-1)) goto L44;
            b(r11);
            return r11;
        L44:
            if (r7 != null) goto L47;
            return -1;
        L47:
            throw new n(r7);
        L19:
            if (this.f18054g.k0() > 0) goto L20;
            if (this.f18057j == true) goto L33;
            if (r7 != null) goto L33;
            this.f18058k.t();     // Catch: Throwable -> L50
            this.f18058k.f18046j.y();     // Catch: Throwable -> L53
            monitor-exit(r6);     // Catch: Throwable -> L53
        L33:
            r8 = null;
            r10 = null;
            goto L34
        L20:
            e r1 = this.f18054g;     // Catch: Throwable -> L50
            r11 = r1.Z(r17, Math.min(r18, r1.k0()));     // Catch: Throwable -> L50
            i r2 = this.f18058k;     // Catch: Throwable -> L50
            long r14 = r2.f18037a + r11;     // Catch: Throwable -> L50
            r2.f18037a = r14;     // Catch: Throwable -> L50
            if (r7 == null) goto L23;
        L25:
            r8 = null;
            r10 = null;
            goto L35
        L23:
            if (r14 < (r2.f18040d.x.d() / 2)) goto L25;
            i r3 = this.f18058k;     // Catch: Throwable -> L50
            r3.f18040d.u0(r3.f18039c, r3.f18037a);     // Catch: Throwable -> L50
            this.f18058k.f18037a = 0;     // Catch: Throwable -> L50
            goto L25
        L49:
            throw new IOException("stream closed");     // Catch: Throwable -> L50
        L50:
            th = move-exception;
            this.f18058k.f18046j.y();     // Catch: Throwable -> L53
            throw th;     // Catch: Throwable -> L53
        L53:
            th = move-exception;
            throw th;
        L57:
            throw new IllegalArgumentException("byteCount < 0: " + r18);
        }

        void a(g r10, long r11) {
        L3:
            if (r11 <= 0) goto L44;
            i r2 = this.f18058k;
            monitor-enter(r2);
            boolean r3 = this.f18057j;     // Catch: Throwable -> L41
            boolean r5 = true;
            if ((this.f18054g.k0() + r11) <= this.f18055h) goto L9;
            boolean r4 = true;
        L10:
            monitor-exit(r2);     // Catch: Throwable -> L41
            if (r4 == true) goto L12;
            if (r3 == true) goto L15;
            long r6 = r10.Z(this.f18053f, r11);
            if (r6 == (-1)) goto L40;
            r11 = r11 - r6;
            i r7 = this.f18058k;
            monitor-enter(r7);
            if (this.f18056i == false) goto L25;
            long r8 = this.f18053f.k0();     // Catch: Throwable -> L36
            this.f18053f.a();     // Catch: Throwable -> L36
        L32:
            monitor-exit(r7);     // Catch: Throwable -> L36
            if (r8 <= 0) goto L3;
            b(r8);
            goto L3
        L25:
            if (this.f18054g.k0() == 0) goto L28;
            r5 = false;
        L28:
            this.f18054g.r0(this.f18053f);     // Catch: Throwable -> L36
            if (r5 == false) goto L31;
            this.f18058k.notifyAll();     // Catch: Throwable -> L36
        L31:
            r8 = 0;
        L36:
            th = move-exception;
            throw th;
        L40:
            throw new EOFException();
        L15:
            r10.skip(r11);
            return;
        L12:
            r10.skip(r11);
            this.f18058k.h(p000j.k0.i.b.f17929j);
            return;
        L9:
            r4 = false;
        L41:
            th = move-exception;
            throw th;
        }

        @Override // k.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            i r0 = this.f18058k;
            monitor-enter(r0);
            this.f18056i = true;     // Catch: Throwable -> L23
            long r1 = this.f18054g.k0();     // Catch: Throwable -> L23
            this.f18054g.a();     // Catch: Throwable -> L23
            j.k0.i.c.a r4 = null;
            if (i.a(this.f18058k).isEmpty() == false) goto L8;
        L10:
            ArrayList r3 = null;
        L11:
            this.f18058k.notifyAll();     // Catch: Throwable -> L23
            monitor-exit(r0);     // Catch: Throwable -> L23
            if (r1 <= 0) goto L16;
            b(r1);
        L16:
            this.f18058k.d();
            if (r4 == null) goto L22;
            Iterator r8 = r3.iterator();
        L20:
            if (r8.hasNext() == false) goto L29;
            r4.a((v) r8.next());
            goto L20
        L29:
            return;
        L22:
            return;
        L8:
            if (i.b(this.f18058k) == null) goto L10;
            ArrayList r5 = new ArrayList(i.a(this.f18058k));     // Catch: Throwable -> L23
            i.a(this.f18058k).clear();     // Catch: Throwable -> L23
            r4 = i.b(this.f18058k);     // Catch: Throwable -> L23
            r3 = r5;
        L23:
            th = move-exception;
            throw th;
        }

        @Override // k.z
        public a0 e() {
            return this.f18058k.f18046j;
        }
    }

    class c extends d {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ i f18059l;

        c(i r1) {
            this.f18059l = r1;
        }

        @Override // k.d
        protected IOException t(IOException r2) {
            SocketTimeoutException r1 = new SocketTimeoutException(LocationMonitorConst.TIMEOUT);
            if (r2 == null) goto L5;
            r1.initCause(r2);
        L5:
            return r1;
        }

        @Override // k.d
        protected void x() {
            this.f18059l.h(p000j.k0.i.b.f17931l);
            this.f18059l.f18040d.l0();
        }

        public void y() {
            if (s() == true) goto L6;
            return;
        L6:
            throw t(null);
        }
    }

    static {
    }

    i(int r4, g r5, boolean r6, boolean r7, v r8) {
        this.f18037a = 0;
        ArrayDeque r0 = new ArrayDeque();
        this.f18041e = r0;
        this.f18046j = new c(this);
        this.f18047k = new c(this);
        this.f18048l = null;
        Objects.requireNonNull(r5, "connection == null");
        this.f18039c = r4;
        this.f18040d = r5;
        this.f18038b = r5.y.d();
        b r9 = new b(this, r5.x.d());
        this.f18044h = r9;
        a r10 = new a(this);
        this.f18045i = r10;
        r9.f18057j = r7;
        r10.f18051h = r6;
        if (r8 == null) goto L6;
        r0.add(r8);
    L6:
        if (l() == false) goto L12;
        if (r8 == null) goto L12;
        throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
    L12:
        if (l() == true) goto L17;
        if (r8 == null) goto L16;
        return;
    L16:
        throw new IllegalStateException("remotely-initiated streams should have headers");
    }

    static /* synthetic */ Deque a(i r0) {
        return r0.f18041e;
    }

    static /* synthetic */ j.k0.i.c.a b(i r0) {
        return r0.f18042f;
    }

    private boolean g(p000j.k0.i.b r3) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.f18048l == null) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L17
        return false;
    L8:
        if (this.f18044h.f18057j == true) goto L10;
    L13:
        this.f18048l = r3;     // Catch: Throwable -> L17
        notifyAll();     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        this.f18040d.k0(this.f18039c);
        return true;
    L10:
        if (this.f18045i.f18051h == false) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L17
        return false;
    }

    void c(long r3) {
        this.f18038b += r3;
        if (r3 <= 0) goto L6;
        notifyAll();
        return;
    }

    void d() {
        monitor-enter(this);
        b r0 = this.f18044h;     // Catch: Throwable -> L20
        if (r0.f18057j == false) goto L6;
    L12:
        boolean r1 = false;
    L13:
        boolean r2 = m();     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
        if (r1 == false) goto L17;
        f(p000j.k0.i.b.f17931l);
        return;
    L17:
        if (r2 == true) goto L26;
        this.f18040d.k0(this.f18039c);
        return;
    L26:
        return;
    L6:
        if (r0.f18056i == false) goto L12;
        a r3 = this.f18045i;     // Catch: Throwable -> L20
        if (r3.f18051h == false) goto L10;
    L11:
        r1 = true;
        goto L13
    L10:
        if (r3.f18050g == false) goto L12;
    L20:
        th = move-exception;
        throw th;
    }

    void e() {
        a r0 = this.f18045i;
        if (r0.f18050g == true) goto L14;
        if (r0.f18051h == true) goto L12;
        if (this.f18048l != null) goto L10;
        return;
    L10:
        throw new n(this.f18048l);
    L12:
        throw new IOException("stream finished");
    L14:
        throw new IOException("stream closed");
    }

    public void f(p000j.k0.i.b r2) {
        if (g(r2) == true) goto L5;
        return;
    L5:
        this.f18040d.s0(this.f18039c, r2);
    }

    public void h(p000j.k0.i.b r2) {
        if (g(r2) == true) goto L5;
        return;
    L5:
        this.f18040d.t0(this.f18039c, r2);
    }

    public int i() {
        return this.f18039c;
    }

    public x j() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f18043g == false) goto L6;
    L10:
        monitor-exit(this);     // Catch: Throwable -> L13
        return this.f18045i;
    L6:
        if (l() == true) goto L10;
        throw new IllegalStateException("reply before requesting the sink");     // Catch: Throwable -> L13
    }

    public z k() {
        return this.f18044h;
    }

    public boolean l() {
        if ((this.f18039c & 1) != 1) goto L5;
        boolean r0 = true;
    L7:
        if (this.f18040d.f17975f != r0) goto L10;
        return true;
    L10:
        return false;
    L5:
        r0 = false;
        goto L7
    }

    public synchronized boolean m() {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (this.f18048l == null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        b r0 = this.f18044h;     // Catch: Throwable -> L23
        if (r0.f18057j == false) goto L11;
    L12:
        a r1 = this.f18045i;     // Catch: Throwable -> L23
        if (r1.f18051h == false) goto L15;
    L16:
        if (this.f18043g == false) goto L21;
        monitor-exit(this);
        return false;
    L21:
        monitor-exit(this);
        return true;
    L15:
        if (r1.f18050g == false) goto L21;
    L11:
        if (r0.f18056i == false) goto L21;
        goto L12
    }

    public a0 n() {
        return this.f18046j;
    }

    void o(g r3, int r4) {
        this.f18044h.a(r3, r4);
    }

    void p() {
        monitor-enter(this);
        this.f18044h.f18057j = true;     // Catch: Throwable -> L8
        boolean r0 = m();     // Catch: Throwable -> L8
        notifyAll();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        if (r0 == true) goto L13;
        this.f18040d.k0(this.f18039c);
        return;
    L13:
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void q(List<p000j.k0.i.c> r2) {
        monitor-enter(this);
        this.f18043g = true;     // Catch: Throwable -> L9
        this.f18041e.add(p000j.k0.c.H(r2));     // Catch: Throwable -> L9
        boolean r3 = m();     // Catch: Throwable -> L9
        notifyAll();     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        if (r3 == true) goto L14;
        this.f18040d.k0(this.f18039c);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    synchronized void r(p000j.k0.i.b r2) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f18048l != null) goto L6;
        this.f18048l = r2;     // Catch: Throwable -> L8
        notifyAll();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public synchronized v s() {
        monitor-enter(this);
        this.f18046j.r();     // Catch: Throwable -> L20
    L23:
    L17:
        th = move-exception;
        this.f18046j.y();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L5:
        if (this.f18041e.isEmpty() == false) goto L10;
        if (this.f18048l != null) goto L10;
        t();     // Catch: Throwable -> L17
    L10:
        this.f18046j.y();     // Catch: Throwable -> L20
        if (this.f18041e.isEmpty() == true) goto L16;
        v r0 = this.f18041e.removeFirst();     // Catch: Throwable -> L20
        monitor-exit(this);
        return r0;
    L16:
        throw new n(this.f18048l);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    void t() {
        wait();     // Catch: InterruptedException -> L4
        return;
    L4:
        Thread.currentThread().interrupt();
        throw new InterruptedIOException();
    }

    public a0 u() {
        return this.f18047k;
    }
}
