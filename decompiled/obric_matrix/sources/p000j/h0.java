package p000j;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final a f17759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Proxy f17760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final InetSocketAddress f17761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String f17762d;

    public h0(a r2, Proxy r3, InetSocketAddress r4, String r5) {
        Objects.requireNonNull(r2, "address == null");
        Objects.requireNonNull(r3, "proxy == null");
        Objects.requireNonNull(r4, "inetSocketAddress == null");
        this.f17759a = r2;
        this.f17760b = r3;
        this.f17761c = r4;
        this.f17762d = r5;
    }

    public a a() {
        return this.f17759a;
    }

    public String b() {
        return this.f17762d;
    }

    public Proxy c() {
        return this.f17760b;
    }

    public boolean d() {
        if (this.f17759a.f17647i != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f17760b.type() != Proxy.Type.HTTP) goto L7;
        return true;
    }

    public InetSocketAddress e() {
        return this.f17761c;
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof h0) == false) goto L11;
        h0 r4 = (h0) r3;
        if (r4.f17759a.equals(this.f17759a) == false) goto L11;
        if (r4.f17760b.equals(this.f17760b) == false) goto L11;
        if (r4.f17761c.equals(this.f17761c) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f17759a.hashCode()) * 31) + this.f17760b.hashCode()) * 31) + this.f17761c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f17761c + "}";
    }
}
