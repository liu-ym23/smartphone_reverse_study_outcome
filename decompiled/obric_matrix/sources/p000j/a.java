package p000j;

import com.bytedance.bdlocation.client.LocationInfoConst;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import p000j.k0.c;
import p000j.l0.b;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final w f17639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final r f17640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final SocketFactory f17641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final b f17642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final List<b0> f17643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final List<l> f17644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final ProxySelector f17645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Proxy f17646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final SSLSocketFactory f17647i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final HostnameVerifier f17648j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final g f17649k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    b f17650l;

    public a(String r3, int r4, r r5, SocketFactory r6, SSLSocketFactory r7, HostnameVerifier r8, g r9, b r10, Proxy r11, List<b0> r12, List<l> r13, ProxySelector r14) {
        w.a r0 = new w.a();
        if (r7 == null) goto L5;
        String r1 = LocationInfoConst.HTTPS;
    L6:
        r0.r(r1);
        r0.f(r3);
        r0.m(r4);
        this.f17639a = r0.b();
        Objects.requireNonNull(r5, "dns == null");
        this.f17640b = r5;
        Objects.requireNonNull(r6, "socketFactory == null");
        this.f17641c = r6;
        Objects.requireNonNull(r10, "proxyAuthenticator == null");
        this.f17642d = r10;
        Objects.requireNonNull(r12, "protocols == null");
        this.f17643e = c.t(r12);
        Objects.requireNonNull(r13, "connectionSpecs == null");
        this.f17644f = c.t(r13);
        Objects.requireNonNull(r14, "proxySelector == null");
        this.f17645g = r14;
        this.f17646h = r11;
        this.f17647i = r7;
        this.f17648j = r8;
        this.f17649k = r9;
        return;
    L5:
        r1 = "http";
        goto L6
    }

    public a(String r1, int r2, r r3, SocketFactory r4, SSLSocketFactory r5, HostnameVerifier r6, g r7, b r8, Proxy r9, List<b0> r10, List<l> r11, ProxySelector r12, b r13) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
        this.f17650l = r13;
    }

    public g a() {
        return this.f17649k;
    }

    public List<l> b() {
        return this.f17644f;
    }

    public r c() {
        return this.f17640b;
    }

    boolean d(a r3) {
        if (this.f17640b.equals(r3.f17640b) == true) goto L5;
    L23:
        return false;
    L5:
        if (this.f17642d.equals(r3.f17642d) == false) goto L23;
        if (this.f17643e.equals(r3.f17643e) == false) goto L23;
        if (this.f17644f.equals(r3.f17644f) == false) goto L23;
        if (this.f17645g.equals(r3.f17645g) == false) goto L23;
        if (c.q(this.f17646h, r3.f17646h) == false) goto L23;
        if (c.q(this.f17647i, r3.f17647i) == false) goto L23;
        if (c.q(this.f17648j, r3.f17648j) == false) goto L23;
        if (c.q(this.f17649k, r3.f17649k) == false) goto L23;
        if (m().y() != r3.m().y()) goto L23;
        return true;
    }

    public HostnameVerifier e() {
        return this.f17648j;
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof a) == false) goto L9;
        a r4 = (a) r3;
        if (this.f17639a.equals(r4.f17639a) == false) goto L9;
        if (d(r4) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public List<b0> f() {
        return this.f17643e;
    }

    public Proxy g() {
        return this.f17646h;
    }

    public b h() {
        return this.f17642d;
    }

    public int hashCode() {
        int r1 = (((((((((((527 + this.f17639a.hashCode()) * 31) + this.f17640b.hashCode()) * 31) + this.f17642d.hashCode()) * 31) + this.f17643e.hashCode()) * 31) + this.f17644f.hashCode()) * 31) + this.f17645g.hashCode()) * 31;
        Proxy r0 = this.f17646h;
        int r2 = 0;
        if (r0 == null) goto L5;
        int r3 = r0.hashCode();
    L6:
        int r4 = (r1 + r3) * 31;
        SSLSocketFactory r5 = this.f17647i;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        HostnameVerifier r8 = this.f17648j;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        g r11 = this.f17649k;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        return r10 + r2;
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public ProxySelector i() {
        return this.f17645g;
    }

    public SocketFactory j() {
        return this.f17641c;
    }

    public SSLSocketFactory k() {
        return this.f17647i;
    }

    public b l() {
        return this.f17650l;
    }

    public w m() {
        return this.f17639a;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("Address{");
        r0.append(this.f17639a.m());
        r0.append(":");
        r0.append(this.f17639a.y());
        if (this.f17646h == null) goto L5;
        r0.append(", proxy=");
        Object r2 = this.f17646h;
    L6:
        r0.append(r2);
        r0.append("}");
        return r0.toString();
    L5:
        r0.append(", proxySelector=");
        r2 = this.f17645g;
        goto L6
    }
}
