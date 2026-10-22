package l.b.a;

/* JADX INFO: loaded from: classes2.dex */
public class j1 extends t implements z {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f21606f;

    j1(byte[] r1) {
        this.f21606f = r1;
    }

    @Override // l.b.a.z
    public String c() {
        return l.b.h.g.b(this.f21606f);
    }

    @Override // l.b.a.n
    public int hashCode() {
        return l.b.h.a.j(this.f21606f);
    }

    @Override // l.b.a.t
    boolean n(t r2) {
        if ((r2 instanceof j1) == true) goto L7;
        return false;
    L7:
        return l.b.h.a.a(this.f21606f, ((j1) r2).f21606f);
    }

    @Override // l.b.a.t
    void o(r r2, boolean r3) {
        r2.n(r3, 26, this.f21606f);
    }

    @Override // l.b.a.t
    int p() {
        return (c2.a(this.f21606f.length) + 1) + this.f21606f.length;
    }

    @Override // l.b.a.t
    boolean t() {
        return false;
    }

    public String toString() {
        return c();
    }
}
