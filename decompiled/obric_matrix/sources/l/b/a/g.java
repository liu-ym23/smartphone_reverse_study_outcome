package l.b.a;

/* JADX INFO: loaded from: classes2.dex */
public class g extends t {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static g[] f21571g;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f21572f;

    static {
        f21571g = new g[12];
    }

    public g(byte[] r2) {
        if (l.C(r2) == true) goto L11;
        if ((r2[0] & 128) != 0) goto L9;
        this.f21572f = l.b.h.a.d(r2);
        l.F(r2);
        return;
    L9:
        throw new IllegalArgumentException("enumerated must be non-negative");
    L11:
        throw new IllegalArgumentException("malformed enumerated");
    }

    static g w(byte[] r3) {
        if (r3.length <= 1) goto L7;
        return new g(r3);
    L7:
        if (r3.length == 0) goto L17;
        int r0 = r3[0] & 255;
        g[] r1 = f21571g;
        if (r0 >= r1.length) goto L11;
        g r2 = r1[r0];
        if (r2 != null) goto L18;
        g r4 = new g(r3);
        r1[r0] = r4;
        return r4;
    L18:
        return r2;
    L11:
        return new g(r3);
    L17:
        throw new IllegalArgumentException("ENUMERATED has zero length");
    }

    @Override // l.b.a.n
    public int hashCode() {
        return l.b.h.a.j(this.f21572f);
    }

    @Override // l.b.a.t
    boolean n(t r2) {
        if ((r2 instanceof g) == true) goto L7;
        return false;
    L7:
        return l.b.h.a.a(this.f21572f, ((g) r2).f21572f);
    }

    @Override // l.b.a.t
    void o(r r2, boolean r3) {
        r2.n(r3, 10, this.f21572f);
    }

    @Override // l.b.a.t
    int p() {
        return (c2.a(this.f21572f.length) + 1) + this.f21572f.length;
    }

    @Override // l.b.a.t
    boolean t() {
        return false;
    }
}
