package l.b.a;

/* JADX INFO: loaded from: classes2.dex */
public class b0 extends t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f21517f;

    b0(byte[] r3) {
        if (r3.length < 2) goto L12;
        this.f21517f = r3;
        if (w(0) == false) goto L10;
        if (w(1) == false) goto L10;
        return;
    L10:
        throw new IllegalArgumentException("illegal characters in UTCTime string");
    L12:
        throw new IllegalArgumentException("UTCTime string too short");
    }

    private boolean w(int r3) {
        byte[] r2 = this.f21517f;
        if (r2.length > r3) goto L5;
    L9:
        return false;
    L5:
        if (r2[r3] < 48) goto L9;
        if (r2[r3] > 57) goto L9;
        return true;
    }

    @Override // l.b.a.n
    public int hashCode() {
        return l.b.h.a.j(this.f21517f);
    }

    @Override // l.b.a.t
    boolean n(t r2) {
        if ((r2 instanceof b0) == true) goto L7;
        return false;
    L7:
        return l.b.h.a.a(this.f21517f, ((b0) r2).f21517f);
    }

    @Override // l.b.a.t
    void o(r r2, boolean r3) {
        r2.n(r3, 23, this.f21517f);
    }

    @Override // l.b.a.t
    int p() {
        int r1 = this.f21517f.length;
        return (c2.a(r1) + 1) + r1;
    }

    @Override // l.b.a.t
    boolean t() {
        return false;
    }

    public String toString() {
        return l.b.h.g.b(this.f21517f);
    }
}
