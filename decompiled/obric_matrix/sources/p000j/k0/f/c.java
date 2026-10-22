package p000j.k0.f;

import androidx.core.location.LocationRequestCompat;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import k.f;
import k.q;
import k.z;
import p000j.a0;
import p000j.b0;
import p000j.d0;
import p000j.e;
import p000j.f0;
import p000j.h0;
import p000j.j;
import p000j.k;
import p000j.k0.i.b;
import p000j.k0.i.g;
import p000j.k0.i.i;
import p000j.k0.m.d;
import p000j.l;
import p000j.s;
import p000j.u;
import p000j.w;
import p000j.x;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends g.j implements j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f17830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h0 f17831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Socket f17832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Socket f17833e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private u f17834f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b0 f17835g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private g f17836h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private k.g f17837i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private f f17838j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f17839k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f17840l;
    public int m;
    public final List<Reference<g>> n;
    public long o;

    class a extends p000j.k0.n.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ g f17841i;

        a(c r1, boolean r2, k.g r3, f r4, g r5) {
            this.f17841i = r5;
            super(r2, r3, r4);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            g r0 = this.f17841i;
            r0.s(true, r0.c(), -1, null);
        }
    }

    public c(k r3, h0 r4) {
        this.m = 1;
        this.n = new ArrayList();
        this.o = LocationRequestCompat.PASSIVE_INTERVAL;
        this.f17830b = r3;
        this.f17831c = r4;
    }

    private void g(int r5, int r6, e r7, s r8) {
        Proxy r0 = this.f17831c.c();
        p000j.a r1 = this.f17831c.a();
        if (r0.type() != Proxy.Type.DIRECT) goto L5;
    L8:
        Socket r2 = r1.j().createSocket();
    L9:
        this.f17832d = r2;
        r8.h(r7, this.f17831c.e(), r0);
        this.f17832d.setSoTimeout(r6);
        p000j.k0.j.g.m().i(this.f17832d, this.f17831c.e(), r5);     // Catch: ConnectException -> L19
        this.f17837i = q.b(q.k(this.f17832d));     // Catch: NullPointerException -> L13
        this.f17838j = q.a(q.g(this.f17832d));     // Catch: NullPointerException -> L13
        return;
    L13:
        e = move-exception;
        if ("throw with null exception".equals(e.getMessage()) == true) goto L18;
        return;
    L18:
        throw new IOException(e);
    L19:
        e = move-exception;
        ConnectException r9 = new ConnectException("Failed to connect to " + this.f17831c.e());
        r9.initCause(e);
        throw r9;
    L5:
        if (r0.type() == Proxy.Type.HTTP) goto L8;
        r2 = new Socket(r0);
        goto L9
    }

    private void h(b r8) {
        p000j.a r0 = this.f17831c.a();
        SSLSocket r2 = null;
        String r3 = null;
        SSLSocket r1 = (SSLSocket) r0.k().createSocket(this.f17832d, r0.m().m(), r0.m().y(), true);     // Catch: Throwable -> L32 AssertionError -> L34
        l r9 = r8.a(r1);     // Catch: Throwable -> L28 AssertionError -> L30
        if (r9.f() == false) goto L7;
        p000j.k0.j.g.m().h(r1, r0.m().m(), r0.f());     // Catch: Throwable -> L28 AssertionError -> L30
    L7:
        r1.startHandshake();     // Catch: Throwable -> L28 AssertionError -> L30
        SSLSession r4 = r1.getSession();     // Catch: Throwable -> L28 AssertionError -> L30
        u r5 = u.b(r4);     // Catch: Throwable -> L28 AssertionError -> L30
        if (r0.e().verify(r0.m().m(), r4) == true) goto L17;
        List<Certificate> r7 = r5.c();     // Catch: Throwable -> L28 AssertionError -> L30
        if (r7.isEmpty() == true) goto L16;
        X509Certificate r10 = (X509Certificate) r7.get(0);     // Catch: Throwable -> L28 AssertionError -> L30
        throw new SSLPeerUnverifiedException("Hostname " + r0.m().m() + " not verified:\n    certificate: " + p000j.g.c(r10) + "\n    DN: " + r10.getSubjectDN().getName() + "\n    subjectAltNames: " + d.a(r10));     // Catch: Throwable -> L28 AssertionError -> L30
    L16:
        throw new SSLPeerUnverifiedException("Hostname " + r0.m().m() + " not verified (no certificates)");     // Catch: Throwable -> L28 AssertionError -> L30
    L17:
        r0.a().a(r0.m().m(), r5.c());     // Catch: Throwable -> L28 AssertionError -> L30
        if (r9.f() == false) goto L20;
        r3 = p000j.k0.j.g.m().o(r1);     // Catch: Throwable -> L28 AssertionError -> L30
    L20:
        this.f17833e = r1;     // Catch: Throwable -> L28 AssertionError -> L30
        this.f17837i = q.b(q.k(r1));     // Catch: Throwable -> L28 AssertionError -> L30
        this.f17838j = q.a(q.g(this.f17833e));     // Catch: Throwable -> L28 AssertionError -> L30
        this.f17834f = r5;     // Catch: Throwable -> L28 AssertionError -> L30
        if (r3 == null) goto L23;
        b0 r11 = b0.a(r3);     // Catch: Throwable -> L28 AssertionError -> L30
    L24:
        this.f17835g = r11;     // Catch: Throwable -> L28 AssertionError -> L30
        if (r1 == null) goto L47;
        p000j.k0.j.g.m().a(r1);
        return;
    L47:
        return;
    L23:
        r11 = b0.f17673h;     // Catch: Throwable -> L28 AssertionError -> L30
    L30:
        e = e;
    L36:
        if (p000j.k0.c.A(e) == true) goto L38;
        throw e;     // Catch: Throwable -> L32
    L38:
        throw new IOException(e);     // Catch: Throwable -> L32
    L28:
        th = th;
        r2 = r1;
    L40:
        if (r2 == null) goto L42;
        p000j.k0.j.g.m().a(r2);
    L42:
        p000j.k0.c.h(r2);
        throw th;
    L34:
        e = e;
    L32:
        th = th;
        goto L40
    }

    private void i(int r7, int r8, int r9, e r10, s r11) {
        d0 r0 = k();
        w r1 = r0.k();
        int r2 = 0;
    L4:
        if (r2 >= 21) goto L9;
        g(r7, r8, r10, r11);
        r0 = j(r8, r9, r0, r1);
        if (r0 == null) goto L12;
        p000j.k0.c.h(this.f17832d);
        this.f17832d = null;
        this.f17838j = null;
        this.f17837i = null;
        r11.e(r10, this.f17831c.e(), this.f17831c.c(), null);
        r2 = r2 + 1;
        goto L4
    L12:
        return;
    }

    private d0 j(int r9, int r10, d0 r11, w r12) {
        String r13 = "CONNECT " + p000j.k0.c.s(r12, true) + " HTTP/1.1";
    L3:
        k.g r1 = this.f17837i;
        p000j.k0.h.a r0 = new p000j.k0.h.a(null, null, r1, this.f17838j);
        TimeUnit r2 = TimeUnit.MILLISECONDS;
        r1.e().g(r9, r2);
        this.f17838j.e().g(r10, r2);
        r0.o(r11.d(), r13);
        r0.a();
        f0.a r3 = r0.d(false);
        r3.p(r11);
        f0 r14 = r3.c();
        long r4 = p000j.k0.g.e.b(r14);
        if (r4 != (-1)) goto L6;
        r4 = 0;
    L6:
        z r5 = r0.k(r4);
        p000j.k0.c.D(r5, Integer.MAX_VALUE, r2);
        r5.close();
        int r6 = r14.s();
        if (r6 == 200) goto L21;
        if (r6 != 407) goto L19;
        d0 r7 = this.f17831c.a().h().a(this.f17831c, r14);
        if (r7 == null) goto L17;
        if ("close".equalsIgnoreCase(r14.A("Connection")) == true) goto L14;
        r11 = r7;
        goto L3
    L14:
        return r7;
    L17:
        throw new IOException("Failed to authenticate with proxy");
    L19:
        throw new IOException("Unexpected response code for CONNECT: " + r14.s());
    L21:
        if (this.f17837i.c().v() == false) goto L26;
        if (this.f17838j.c().v() == false) goto L26;
        return null;
    L26:
        throw new IOException("TLS tunnel buffered too many bytes!");
    }

    private d0 k() {
        d0.a r0 = new d0.a();
        r0.l(this.f17831c.a().m());
        r0.f("CONNECT", null);
        r0.d("Host", p000j.k0.c.s(this.f17831c.a().m(), true));
        r0.d("Proxy-Connection", "Keep-Alive");
        r0.d("User-Agent", p000j.k0.d.a());
        d0 r1 = r0.b();
        f0.a r2 = new f0.a();
        r2.p(r1);
        r2.n(b0.f17673h);
        r2.g(407);
        r2.k("Preemptive Authenticate");
        r2.b(p000j.k0.c.f17794c);
        r2.q(-1);
        r2.o(-1);
        r2.i("Proxy-Authenticate", "OkHttp-Preemptive");
        f0 r3 = r2.c();
        d0 r4 = this.f17831c.a().h().a(this.f17831c, r3);
        if (r4 != null) goto L5;
        return r1;
    L5:
        return r4;
    }

    private void l(b r2, int r3, e r4, s r5) {
        if (this.f17831c.a().k() != null) goto L10;
        List<b0> r6 = this.f17831c.a().f();
        b0 r7 = b0.f17676k;
        if (r6.contains(r7) == false) goto L8;
        this.f17833e = this.f17832d;
        this.f17835g = r7;
        s(r3);
        return;
    L8:
        this.f17833e = this.f17832d;
        this.f17835g = b0.f17673h;
        return;
    L10:
        r5.x(r4);
        h(r2);
        r5.w(r4, this.f17834f);
        if (this.f17835g != b0.f17675j) goto L14;
        s(r3);
        return;
    }

    private void s(int r6) {
        this.f17833e.setSoTimeout(0);
        g.h r0 = new g.h(true);
        r0.d(this.f17833e, this.f17831c.a().m().m(), this.f17837i, this.f17838j);
        r0.b(this);
        r0.c(r6);
        g r7 = r0.a();
        this.f17836h = r7;
        r7.n0();
    }

    @Override // p000j.j
    public h0 a() {
        return this.f17831c;
    }

    @Override // p000j.j
    public Socket b() {
        return this.f17833e;
    }

    @Override // j.k0.i.g.j
    public void c(g r2) {
        k r0 = this.f17830b;
        monitor-enter(r0);
        this.m = r2.S();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // j.k0.i.g.j
    public void d(i r1) {
        r1.f(b.f17930k);
    }

    public void e() {
        p000j.k0.c.h(this.f17832d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [j.b0, j.k0.i.g, j.u, java.net.Socket, k.f, k.g] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public void f(int r17, int r18, int r19, int r20, boolean r21, e r22, s r23) {
        if (this.f17835g != null) goto L66;
        List<l> r0 = this.f17831c.a().b();
        b r13 = new b(r0);
        if (this.f17831c.a().k() != null) goto L16;
        if (r0.contains(l.f18126k) == false) goto L14;
        String r1 = this.f17831c.a().m().m();
        if (p000j.k0.j.g.m().r(r1) == false) goto L12;
    L17:
        ?? r12 = 0;
        e r11 = null;
    L67:
    L50:
        e = e;
    L53:
        p000j.k0.c.h(this.f17833e);
        p000j.k0.c.h(this.f17832d);
        this.f17833e = r12;
        this.f17832d = r12;
        this.f17837i = r12;
        this.f17838j = r12;
        this.f17834f = r12;
        this.f17835g = r12;
        this.f17836h = r12;
        r23.f(r22, this.f17831c.e(), this.f17831c.c(), null, e);
        e r2 = r11;
        ?? r3 = r12;
        b r4 = r13;
        r23.g(r22, this.f17831c.e(), this.f17831c.c(), null, e, this.f17831c.b());
        if (r2 != null) goto L56;
        r2 = new e(e);
    L57:
        r11 = r2;
        if (r21 == false) goto L62;
        if (r4.b(e) == false) goto L80;
        r12 = r3;
        r13 = r4;
        goto L67
    L80:
        throw r11;
    L62:
        throw r11;
    L56:
        r2.a(e);
        goto L57
    L19:
        if (this.f17831c.d() == false) goto L71;
        i(r17, r18, r19, r22, r23);     // Catch: IOException -> L50
        if (this.f17832d == null) goto L29;
    L73:
        l(r13, r20, r22, r23);     // Catch: IOException -> L46
        r23.e(r22, this.f17831c.e(), this.f17831c.c(), this.f17835g);     // Catch: IOException -> L46
    L46:
        e = e;
    L29:
        if (this.f17831c.d() == false) goto L36;
        if (this.f17832d != null) goto L36;
        throw new e(new ProtocolException("Too many tunnel connections attempted: 21"));
    L36:
        if (this.f17836h == null) goto L45;
        k r5 = this.f17830b;
        monitor-enter(r5);
        this.m = this.f17836h.S();     // Catch: Throwable -> L42
        monitor-exit(r5);     // Catch: Throwable -> L42
        return;
    L42:
        th = move-exception;
        throw th;
    L45:
        return;
    L71:
        g(r17, r18, r22, r23);     // Catch: IOException -> L48
    L48:
        e = e;
        goto L53
    L12:
        throw new e(new UnknownServiceException("CLEARTEXT communication to " + r1 + " not permitted by network security policy"));
    L14:
        throw new e(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
    L16:
        if (this.f17831c.a().f().contains(b0.f17676k) == false) goto L17;
        throw new e(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
    L66:
        throw new IllegalStateException("already connected");
    }

    public u m() {
        return this.f17834f;
    }

    public boolean n(p000j.a r5, h0 r6) {
        if (this.n.size() < this.m) goto L5;
    L35:
        return false;
    L5:
        if (this.f17839k == true) goto L35;
        if (p000j.k0.a.f17790a.g(this.f17831c.a(), r5) == true) goto L11;
        return false;
    L11:
        if (r5.m().m().equals(a().a().m().m()) == false) goto L14;
        return true;
    L14:
        if (this.f17836h != null) goto L16;
        return false;
    L16:
        if (r6 != null) goto L19;
        return false;
    L19:
        if (r6.c().type() == Proxy.Type.DIRECT) goto L22;
        return false;
    L22:
        if (this.f17831c.c().type() == Proxy.Type.DIRECT) goto L25;
        return false;
    L25:
        if (this.f17831c.e().equals(r6.e()) == true) goto L28;
        return false;
    L28:
        if (r6.a().e() == d.f18116a) goto L31;
        return false;
    L31:
        if (t(r5.m()) == true) goto L37;
        return false;
    L37:
        r5.a().a(r5.m().m(), m().c());     // Catch: SSLPeerUnverifiedException -> L36
        return true;
    }

    public boolean o(boolean r4) {
        if (this.f17833e.isClosed() == false) goto L5;
    L27:
        return false;
    L5:
        if (this.f17833e.isInputShutdown() == true) goto L27;
        if (this.f17833e.isOutputShutdown() == true) goto L27;
        g r0 = this.f17836h;
        if (r0 == null) goto L14;
        return r0.Q(System.nanoTime());
    L14:
        if (r4 == true) goto L31;
    L26:
        return true;
    L31:
        int r5 = this.f17833e.getSoTimeout();     // Catch: IOException -> L25 SocketTimeoutException -> L28
        this.f17833e.setSoTimeout(1);     // Catch: Throwable -> L22
        if (this.f17837i.v() == false) goto L20;
        this.f17833e.setSoTimeout(r5);     // Catch: IOException -> L25 SocketTimeoutException -> L28
        return false;
    L20:
        this.f17833e.setSoTimeout(r5);     // Catch: IOException -> L25 SocketTimeoutException -> L28
        return true;
    L22:
        th = move-exception;
        this.f17833e.setSoTimeout(r5);     // Catch: IOException -> L25 SocketTimeoutException -> L28
        throw th;     // Catch: IOException -> L25 SocketTimeoutException -> L28
    L25:
        return false;
    }

    public boolean p() {
        if (this.f17836h == null) goto L5;
        return true;
    L5:
        return false;
    }

    public p000j.k0.g.c q(a0 r5, x.a r6, g r7) {
        if (this.f17836h != null) goto L5;
        this.f17833e.setSoTimeout(r6.a());
        k.a0 r0 = this.f17837i.e();
        long r1 = r6.a();
        TimeUnit r3 = TimeUnit.MILLISECONDS;
        r0.g(r1, r3);
        this.f17838j.e().g(r6.c(), r3);
        return new p000j.k0.h.a(r5, r7, this.f17837i, this.f17838j);
    L5:
        return new p000j.k0.i.f(r5, r6, r7, this.f17836h);
    }

    public p000j.k0.n.a r(g r8) {
        return new a(this, true, this.f17837i, this.f17838j, r8);
    }

    public boolean t(w r4) {
        if (r4.y() == this.f17831c.a().m().y()) goto L6;
        return false;
    L6:
        if (r4.m().equals(this.f17831c.a().m().m()) == false) goto L8;
        return true;
    L8:
        if (this.f17834f != null) goto L10;
        return false;
    L10:
        if (d.f18116a.c(r4.m(), (X509Certificate) this.f17834f.c().get(0)) == true) goto L12;
        return false;
    L12:
        return true;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("Connection{");
        r0.append(this.f17831c.a().m().m());
        r0.append(":");
        r0.append(this.f17831c.a().m().y());
        r0.append(", proxy=");
        r0.append(this.f17831c.c());
        r0.append(" hostAddress=");
        r0.append(this.f17831c.e());
        r0.append(" cipherSuite=");
        u r1 = this.f17834f;
        if (r1 == null) goto L5;
        Object r2 = r1.a();
    L6:
        r0.append(r2);
        r0.append(" protocol=");
        r0.append(this.f17835g);
        r0.append('}');
        return r0.toString();
    L5:
        r2 = "none";
        goto L6
    }
}
