package l.b.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class h1 extends t implements z {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final char[] f21588g = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f21589f;

    static {
        f21588g = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public h1(byte[] r1) {
        this.f21589f = l.b.h.a.d(r1);
    }

    @Override // l.b.a.z
    public String c() {
        StringBuffer r0 = new StringBuffer("#");
        byte[] r4 = getEncoded();     // Catch: IOException -> L10
        int r1 = 0;
    L6:
        if (r1 == r4.length) goto L9;
        char[] r2 = f21588g;
        r0.append(r2[(r4[r1] >>> 4) & 15]);
        r0.append(r2[r4[r1] & 15]);
        r1 = r1 + 1;
        goto L6
    L9:
        return r0.toString();
    L11:
        throw new s("internal error encoding UniversalString");
    }

    @Override // l.b.a.n
    public int hashCode() {
        return l.b.h.a.j(this.f21589f);
    }

    @Override // l.b.a.t
    boolean n(t r2) {
        if ((r2 instanceof h1) == true) goto L7;
        return false;
    L7:
        return l.b.h.a.a(this.f21589f, ((h1) r2).f21589f);
    }

    @Override // l.b.a.t
    void o(r r2, boolean r3) {
        r2.n(r3, 28, this.f21589f);
    }

    @Override // l.b.a.t
    int p() {
        return (c2.a(this.f21589f.length) + 1) + this.f21589f.length;
    }

    @Override // l.b.a.t
    boolean t() {
        return false;
    }

    public String toString() {
        return c();
    }
}
