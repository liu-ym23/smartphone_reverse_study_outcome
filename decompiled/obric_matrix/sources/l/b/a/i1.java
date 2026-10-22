package l.b.a;

/* JADX INFO: loaded from: classes2.dex */
public class i1 extends t implements z {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f21599f;

    public i1(byte[] r1) {
        this.f21599f = l.b.h.a.d(r1);
    }

    @Override // l.b.a.z
    public String c() {
        return l.b.h.g.b(this.f21599f);
    }

    @Override // l.b.a.n
    public int hashCode() {
        return l.b.h.a.j(this.f21599f);
    }

    @Override // l.b.a.t
    boolean n(t r2) {
        if ((r2 instanceof i1) == true) goto L7;
        return false;
    L7:
        return l.b.h.a.a(this.f21599f, ((i1) r2).f21599f);
    }

    @Override // l.b.a.t
    void o(r r2, boolean r3) {
        r2.n(r3, 21, this.f21599f);
    }

    @Override // l.b.a.t
    int p() {
        return (c2.a(this.f21599f.length) + 1) + this.f21599f.length;
    }

    @Override // l.b.a.t
    boolean t() {
        return false;
    }
}
