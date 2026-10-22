package p000j;

import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.keva.KevaImpl;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import p000j.k0.e.d;
import p000j.k0.f.g;
import p000j.k0.m.c;

/* JADX INFO: loaded from: classes2.dex */
public class a0 implements Cloneable {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    static final List<b0> f17651J = null;
    static final List<l> K = null;
    final boolean A;
    final boolean B;
    final int C;
    final int D;
    final int E;
    final int F;
    final int G;
    final p000j.l0.b H;
    final boolean I;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final q f17652f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Proxy f17653g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final List<b0> f17654h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final List<l> f17655i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final List<x> f17656j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final List<x> f17657k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final s.c f17658l;
    final ProxySelector m;
    final o n;
    final c o;
    final d p;
    final SocketFactory q;
    final SSLSocketFactory r;
    final c s;
    final HostnameVerifier t;
    final g u;
    final p000j.b v;
    final p000j.b w;
    final k x;
    final r y;
    final boolean z;

    static class a extends p000j.k0.a {
        a() {
        }

        @Override // p000j.k0.a
        public void a(v.a r1, String r2) {
            r1.b(r2);
        }

        @Override // p000j.k0.a
        public void b(v.a r1, String r2, String r3) {
            r1.c(r2, r3);
        }

        @Override // p000j.k0.a
        public void c(l r1, SSLSocket r2, boolean r3) {
            r1.a(r2, r3);
        }

        @Override // p000j.k0.a
        public int d(f0.a r1) {
            return r1.f17736c;
        }

        @Override // p000j.k0.a
        public boolean e(k r1, p000j.k0.f.c r2) {
            return r1.b(r2);
        }

        @Override // p000j.k0.a
        public Socket f(k r1, p000j.a r2, g r3) {
            return r1.c(r2, r3);
        }

        @Override // p000j.k0.a
        public boolean g(p000j.a r1, p000j.a r2) {
            return r1.d(r2);
        }

        @Override // p000j.k0.a
        public p000j.k0.f.c h(k r1, p000j.a r2, g r3, h0 r4) {
            return r1.d(r2, r3, r4);
        }

        @Override // p000j.k0.a
        public e i(a0 r1, d0 r2) {
            return c0.h(r1, r2, true);
        }

        @Override // p000j.k0.a
        public void j(k r1, p000j.k0.f.c r2) {
            r1.f(r2);
        }

        @Override // p000j.k0.a
        public p000j.k0.f.d k(k r1) {
            return r1.f17787e;
        }

        @Override // p000j.k0.a
        public g l(e r1) {
            return ((c0) r1).j();
        }

        @Override // p000j.k0.a
        public IOException m(e r1, IOException r2) {
            return ((c0) r1).k(r2);
        }
    }

    public static final class b {
        int A;
        int B;
        p000j.l0.b C;
        boolean D;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        q f17659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Proxy f17660b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        List<b0> f17661c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        List<l> f17662d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final List<x> f17663e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final List<x> f17664f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        s.c f17665g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        ProxySelector f17666h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        o f17667i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        c f17668j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        d f17669k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        SocketFactory f17670l;
        SSLSocketFactory m;
        c n;
        HostnameVerifier o;
        g p;
        p000j.b q;
        p000j.b r;
        k s;
        r t;
        boolean u;
        boolean v;
        boolean w;
        int x;
        int y;
        int z;

        public b() {
            this.f17663e = new ArrayList();
            this.f17664f = new ArrayList();
            this.f17659a = new q();
            this.f17661c = a0.f17651J;
            this.f17662d = a0.K;
            this.f17665g = s.n(s.f18185a);
            ProxySelector r0 = ProxySelector.getDefault();
            this.f17666h = r0;
            if (r0 != null) goto L5;
            this.f17666h = new p000j.k0.k.a();
        L5:
            this.f17667i = o.f18176a;
            this.f17670l = SocketFactory.getDefault();
            this.o = p000j.k0.m.d.f18116a;
            this.p = g.f17746c;
            p000j.b r1 = p000j.b.f17671a;
            this.q = r1;
            this.r = r1;
            this.s = new k();
            this.t = r.f18184a;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 0;
            this.y = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
            this.z = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
            this.A = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
            this.B = 0;
            this.C = null;
            this.D = false;
        }

        b(a0 r4) {
            ArrayList r0 = new ArrayList();
            this.f17663e = r0;
            ArrayList r1 = new ArrayList();
            this.f17664f = r1;
            this.f17659a = r4.f17652f;
            this.f17660b = r4.f17653g;
            this.f17661c = r4.f17654h;
            this.f17662d = r4.f17655i;
            r0.addAll(r4.f17656j);
            r1.addAll(r4.f17657k);
            this.f17665g = r4.f17658l;
            this.f17666h = r4.m;
            this.f17667i = r4.n;
            this.f17669k = r4.p;
            c r2 = r4.o;
            this.f17670l = r4.q;
            this.m = r4.r;
            this.n = r4.s;
            this.o = r4.t;
            this.p = r4.u;
            this.q = r4.v;
            this.r = r4.w;
            this.s = r4.x;
            this.t = r4.y;
            this.u = r4.z;
            this.v = r4.A;
            this.w = r4.B;
            this.x = r4.C;
            this.y = r4.D;
            this.z = r4.E;
            this.A = r4.F;
            this.B = r4.G;
            this.C = r4.H;
            this.D = r4.I;
        }

        public b a(x r2) {
            if (r2 == null) goto L6;
            this.f17663e.add(r2);
            return this;
        L6:
            throw new IllegalArgumentException("interceptor == null");
        }

        public b b(x r2) {
            if (r2 == null) goto L6;
            this.f17664f.add(r2);
            return this;
        L6:
            throw new IllegalArgumentException("interceptor == null");
        }

        public a0 c() {
            return new a0(this);
        }

        public b d(long r2, TimeUnit r4) {
            this.y = p000j.k0.c.e(LocationMonitorConst.TIMEOUT, r2, r4);
            return this;
        }

        public b e(k r2) {
            Objects.requireNonNull(r2, "connectionPool == null");
            this.s = r2;
            return this;
        }

        public b f(List<l> r1) {
            this.f17662d = p000j.k0.c.t(r1);
            return this;
        }

        public b g(o r2) {
            Objects.requireNonNull(r2, "cookieJar == null");
            this.f17667i = r2;
            return this;
        }

        public b h(boolean r1) {
            this.D = r1;
            return this;
        }

        public b i(s r2) {
            Objects.requireNonNull(r2, "eventListener == null");
            this.f17665g = s.n(r2);
            return this;
        }

        public b j(boolean r1) {
            this.v = r1;
            return this;
        }

        public b k(List<b0> r3) {
            ArrayList r0 = new ArrayList(r3);
            b0 r4 = b0.f17676k;
            if (r0.contains(r4) == true) goto L10;
            if (r0.contains(b0.f17673h) == true) goto L10;
            throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + r0);
        L10:
            if (r0.contains(r4) == false) goto L17;
            if (r0.size() <= 1) goto L17;
            throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + r0);
        L17:
            if (r0.contains(b0.f17672g) == true) goto L25;
            if (r0.contains(null) == true) goto L23;
            r0.remove(b0.f17674i);
            this.f17661c = Collections.unmodifiableList(r0);
            return this;
        L23:
            throw new IllegalArgumentException("protocols must not contain null");
        L25:
            throw new IllegalArgumentException("protocols must not contain http/1.0: " + r0);
        }

        public b l(Proxy r1) {
            this.f17660b = r1;
            return this;
        }

        public b m(p000j.b r2) {
            Objects.requireNonNull(r2, "proxyAuthenticator == null");
            this.q = r2;
            return this;
        }

        public b n(long r2, TimeUnit r4) {
            this.z = p000j.k0.c.e(LocationMonitorConst.TIMEOUT, r2, r4);
            return this;
        }

        public b o(boolean r1) {
            this.w = r1;
            return this;
        }

        public b p(SSLSocketFactory r2) {
            Objects.requireNonNull(r2, "sslSocketFactory == null");
            this.m = r2;
            this.n = p000j.k0.j.g.m().c(r2);
            return this;
        }

        public b q(SSLSocketFactory r2, X509TrustManager r3) {
            Objects.requireNonNull(r2, "sslSocketFactory == null");
            Objects.requireNonNull(r3, "trustManager == null");
            this.m = r2;
            this.n = c.b(r3);
            return this;
        }

        public b r(p000j.l0.b r2) {
            Objects.requireNonNull(r2, "ttnetDns == null");
            this.C = r2;
            return this;
        }

        public b s(long r2, TimeUnit r4) {
            this.A = p000j.k0.c.e(LocationMonitorConst.TIMEOUT, r2, r4);
            return this;
        }
    }

    static {
        f17651J = p000j.k0.c.u(new b0[]{b0.f17675j, b0.f17673h});
        K = p000j.k0.c.u(new l[]{l.f18124i, l.f18126k});
        p000j.k0.a.f17790a = new a();
    }

    public a0() {
        this(new b());
    }

    a0(b r5) {
        this.f17652f = r5.f17659a;
        this.f17653g = r5.f17660b;
        this.f17654h = r5.f17661c;
        List<l> r0 = r5.f17662d;
        this.f17655i = r0;
        this.f17656j = p000j.k0.c.t(r5.f17663e);
        this.f17657k = p000j.k0.c.t(r5.f17664f);
        this.f17658l = r5.f17665g;
        this.m = r5.f17666h;
        this.n = r5.f17667i;
        c r1 = r5.f17668j;
        this.p = r5.f17669k;
        this.q = r5.f17670l;
        Iterator<l> r2 = r0.iterator();
    L3:
        boolean r3 = false;
    L5:
        if (r2.hasNext() == false) goto L11;
        l r4 = r2.next();
        if (r3 == true) goto L10;
        if (r4.d() == false) goto L3;
    L10:
        r3 = true;
        goto L5
    L11:
        SSLSocketFactory r6 = r5.m;
        if (r6 != null) goto L16;
        if (r3 == false) goto L16;
        X509TrustManager r7 = p000j.k0.c.C();
        this.r = y(r7);
        c r8 = c.b(r7);
    L17:
        this.s = r8;
        if (this.r == null) goto L20;
        p000j.k0.j.g.m().g(this.r);
    L20:
        this.t = r5.o;
        this.u = r5.p.f(this.s);
        this.v = r5.q;
        this.w = r5.r;
        this.x = r5.s;
        this.y = r5.t;
        this.z = r5.u;
        this.A = r5.v;
        this.B = r5.w;
        this.C = r5.x;
        this.D = r5.y;
        this.E = r5.z;
        this.F = r5.A;
        this.G = r5.B;
        this.H = r5.C;
        this.I = r5.D;
        if (this.f17656j.contains(null) == true) goto L28;
        if (this.f17657k.contains(null) == true) goto L26;
        return;
    L26:
        throw new IllegalStateException("Null network interceptor: " + this.f17657k);
    L28:
        throw new IllegalStateException("Null interceptor: " + this.f17656j);
    L16:
        this.r = r6;
        r8 = r5.n;
        goto L17
    }

    private static SSLSocketFactory y(X509TrustManager r3) {
        SSLContext r0 = p000j.k0.j.g.m().n();     // Catch: GeneralSecurityException -> L4
        r0.init(null, new TrustManager[]{r3}, null);     // Catch: GeneralSecurityException -> L4
        return r0.getSocketFactory();
    L4:
        e = move-exception;
        throw p000j.k0.c.b("No System TLS", e);
    }

    public int B(String r2, int r3) {
        if (TextUtils.isEmpty(r2) == true) goto L9;
        if (p000j.l0.a.j().c().contains(r2 + ":" + r3) == false) goto L9;
        return p000j.l0.a.j().d();
    L9:
        return this.G;
    }

    public List<b0> C() {
        return this.f17654h;
    }

    public Proxy D() {
        return this.f17653g;
    }

    public p000j.b E() {
        return this.v;
    }

    public ProxySelector F() {
        return this.m;
    }

    public int G() {
        return this.E;
    }

    public boolean H() {
        return this.B;
    }

    public SocketFactory I() {
        return this.q;
    }

    public SSLSocketFactory J() {
        return this.r;
    }

    public p000j.l0.b K() {
        return this.H;
    }

    public int L() {
        return this.F;
    }

    public p000j.b a() {
        return this.w;
    }

    public int c() {
        return this.C;
    }

    public g d() {
        return this.u;
    }

    public int e() {
        return this.D;
    }

    public k f() {
        return this.x;
    }

    public List<l> h() {
        return this.f17655i;
    }

    public o i() {
        return this.n;
    }

    public q j() {
        return this.f17652f;
    }

    public r k() {
        return this.y;
    }

    public boolean m() {
        return this.I;
    }

    public s.c n() {
        return this.f17658l;
    }

    public boolean o() {
        return this.A;
    }

    public boolean p() {
        return this.z;
    }

    public HostnameVerifier q() {
        return this.t;
    }

    public List<x> r() {
        return this.f17656j;
    }

    d t() {
        c r0 = this.o;
        if (r0 == null) goto L6;
        return r0.f17679f;
    L6:
        return this.p;
    }

    public List<x> u() {
        return this.f17657k;
    }

    public b v() {
        return new b(this);
    }

    public e w(d0 r2) {
        return c0.h(this, r2, false);
    }

    public int z() {
        return this.G;
    }
}
