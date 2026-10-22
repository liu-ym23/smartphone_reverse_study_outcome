package p000j.k0.f;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import p000j.e;
import p000j.h0;
import p000j.l0.c;
import p000j.s;
import p000j.w;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p000j.a f17845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f17846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f17847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final s f17848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f17849e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f17850f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<Proxy> f17851g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f17852h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<InetSocketAddress> f17853i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List<h0> f17854j;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<h0> f17855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f17856b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f17857c;

        a(List<h0> r4) {
            this.f17856b = 0;
            this.f17857c = false;
            this.f17855a = r4;
            if (r4.size() >= p000j.l0.a.j().g()) goto L6;
            ArrayList r0 = new ArrayList(r4);
            r4.addAll(r0);
            r4.addAll(r0);
            this.f17857c = true;
        L6:
            if (r4.size() <= 1) goto L9;
            this.f17857c = true;
            return;
        }

        public List<h0> a() {
            return new ArrayList(this.f17855a);
        }

        public boolean b() {
            if (this.f17857c == false) goto L8;
            if (this.f17856b != this.f17855a.size()) goto L8;
            this.f17856b = 0;
            this.f17857c = false;
        L8:
            if (this.f17856b >= this.f17855a.size()) goto L11;
            return true;
        L11:
            return false;
        }

        public boolean c() {
            return this.f17857c;
        }

        public h0 d() {
            if (b() == false) goto L7;
            List<h0> r0 = this.f17855a;
            int r1 = this.f17856b;
            this.f17856b = r1 + 1;
            return r0.get(r1);
        L7:
            throw new NoSuchElementException();
        }

        public void e(boolean r1) {
            this.f17857c = r1;
        }
    }

    public f(p000j.a r2, d r3, e r4, s r5) {
        this.f17849e = 0;
        this.f17850f = null;
        this.f17851g = Collections.emptyList();
        this.f17853i = Collections.emptyList();
        this.f17854j = new ArrayList();
        this.f17845a = r2;
        this.f17846b = r3;
        this.f17847c = r4;
        this.f17848d = r5;
        i(r2.m(), r2.g());
    }

    static String b(InetSocketAddress r1) {
        InetAddress r0 = r1.getAddress();
        if (r0 != null) goto L7;
        return r1.getHostName();
    L7:
        return r0.getHostAddress();
    }

    private boolean d() {
        if (this.f17852h >= this.f17851g.size()) goto L5;
        return true;
    L5:
        return false;
    }

    private Proxy f() {
        if (d() == false) goto L7;
        List<Proxy> r0 = this.f17851g;
        int r1 = this.f17852h;
        this.f17852h = r1 + 1;
        Proxy r2 = r0.get(r1);
        g(r2);
        return r2;
    L7:
        throw new SocketException("No route to " + this.f17845a.m().m() + "; exhausted proxy configurations: " + this.f17851g);
    }

    private void g(Proxy r7) {
        this.f17853i = new ArrayList();
        if (r7.type() != Proxy.Type.DIRECT) goto L5;
    L12:
        String r1 = this.f17845a.m().m();
        int r0 = this.f17845a.m().y();
    L14:
        if (r0 < 1) goto L39;
        if (r0 > 65535) goto L39;
        if (r7.type() != Proxy.Type.SOCKS) goto L20;
        this.f17853i.add(InetSocketAddress.createUnresolved(r1, r0));
        return;
    L20:
        this.f17848d.m(this.f17847c, r1);
        List<InetAddress> r8 = new ArrayList();
        String r2 = null;
        if (this.f17845a.l() == null) goto L30;
        c r3 = this.f17845a.l().a(r1, this.f17849e);
        if (r3 == null) goto L25;
        r8 = r3.b();
        r2 = r3.a();
    L25:
        this.f17848d.l(this.f17847c, r1, r8, r2);
        this.f17850f = r2;
        if (r8.isEmpty() == true) goto L29;
    L32:
        this.f17848d.k(this.f17847c, r1, r8);
        int r4 = 0;
        int r5 = r8.size();
    L33:
        if (r4 >= r5) goto L41;
        this.f17853i.add(new InetSocketAddress(r8.get(r4), r0));
        r4 = r4 + 1;
        goto L33
    L41:
        return;
    L29:
        throw new UnknownHostException(this.f17845a.l() + " returned no addresses for " + r1);
    L30:
        r8 = this.f17845a.c().a(r1);
        this.f17848d.l(this.f17847c, r1, r8, null);
        if (r8.isEmpty() == false) goto L32;
        throw new UnknownHostException(this.f17845a.c() + " returned no addresses for " + r1);
    L39:
        throw new SocketException("No route to " + r1 + ":" + r0 + "; port is out of range");
    L5:
        if (r7.type() == Proxy.Type.SOCKS) goto L12;
        SocketAddress r6 = r7.address();
        if ((r6 instanceof InetSocketAddress) == false) goto L11;
        InetSocketAddress r9 = (InetSocketAddress) r6;
        r1 = b(r9);
        r0 = r9.getPort();
        goto L14
    L11:
        throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + r6.getClass());
    }

    private void i(w r2, Proxy r3) {
        if (r3 == null) goto L6;
        List<Proxy> r4 = Collections.singletonList(r3);
    L5:
        this.f17851g = r4;
        this.f17852h = 0;
        return;
    L6:
        List<Proxy> r5 = this.f17845a.i().select(r2.E());
        if (r5 != null) goto L9;
    L11:
        r4 = p000j.k0.c.u(new Proxy[]{Proxy.NO_PROXY});
        goto L5
    L9:
        if (r5.isEmpty() == true) goto L11;
        r4 = p000j.k0.c.t(r5);
        goto L5
    }

    public void a(h0 r4, IOException r5) {
        if (r4.c().type() != Proxy.Type.DIRECT) goto L5;
    L7:
        this.f17846b.b(r4);
        return;
    L5:
        if (this.f17845a.i() == null) goto L7;
        this.f17845a.i().connectFailed(this.f17845a.m().E(), r4.c().address(), r5);
        goto L7
    }

    public boolean c() {
        if (d() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f17854j.isEmpty() == false) goto L8;
        return false;
    }

    public a e() {
        if (c() == false) goto L22;
        ArrayList r0 = new ArrayList();
    L6:
        if (d() == false) goto L17;
        Proxy r1 = f();
        int r2 = 0;
        int r3 = this.f17853i.size();
    L8:
        if (r2 >= r3) goto L15;
        h0 r4 = new h0(this.f17845a, r1, this.f17853i.get(r2), this.f17850f);
        if (this.f17846b.c(r4) == false) goto L12;
        this.f17854j.add(r4);
    L13:
        r2 = r2 + 1;
        goto L8
    L12:
        r0.add(r4);
        goto L13
    L15:
        if (r0.isEmpty() == true) goto L6;
    L17:
        if (r0.isEmpty() == false) goto L20;
        r0.addAll(this.f17854j);
        this.f17854j.clear();
    L20:
        return new a(r0);
    L22:
        throw new NoSuchElementException();
    }

    public void h(int r3) {
        i(this.f17845a.m(), this.f17845a.g());
        this.f17853i.clear();
        this.f17854j.clear();
        this.f17849e = r3;
        this.f17850f = null;
    }
}
