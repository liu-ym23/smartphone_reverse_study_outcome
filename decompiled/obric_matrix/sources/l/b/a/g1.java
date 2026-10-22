package l.b.a;

/* JADX INFO: loaded from: classes2.dex */
public class g1 extends t implements z {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f21574f;

    public g1(String r1) {
        this.f21574f = l.b.h.g.h(r1);
    }

    g1(byte[] r1) {
        this.f21574f = r1;
    }

    @Override // l.b.a.z
    public String c() {
        return l.b.h.g.c(this.f21574f);
    }

    @Override // l.b.a.n
    public int hashCode() {
        return l.b.h.a.j(this.f21574f);
    }

    @Override // l.b.a.t
    boolean n(t r2) {
        if ((r2 instanceof g1) == true) goto L7;
        return false;
    L7:
        return l.b.h.a.a(this.f21574f, ((g1) r2).f21574f);
    }

    @Override // l.b.a.t
    void o(r r2, boolean r3) {
        r2.n(r3, 12, this.f21574f);
    }

    @Override // l.b.a.t
    int p() {
        return (c2.a(this.f21574f.length) + 1) + this.f21574f.length;
    }

    @Override // l.b.a.t
    boolean t() {
        return false;
    }

    public String toString() {
        return c();
    }
}
