package l.b.g.c.a.f;

import java.security.PublicKey;
import l.b.a.w0;
import l.b.g.a.e;
import l.b.g.a.g;

/* JADX INFO: loaded from: classes2.dex */
public class b implements PublicKey {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private short[][] f22240f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private short[][] f22241g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private short[] f22242h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f22243i;

    public b(int r1, short[][] r2, short[][] r3, short[] r4) {
        this.f22243i = r1;
        this.f22240f = r2;
        this.f22241g = r3;
        this.f22242h = r4;
    }

    public b(l.b.g.c.b.b r4) {
        this(r4.d(), r4.a(), r4.c(), r4.b());
    }

    public short[][] a() {
        return this.f22240f;
    }

    public short[] b() {
        return l.b.h.a.e(this.f22242h);
    }

    public short[][] c() {
        short[][] r0 = new short[this.f22241g.length][];
        int r1 = 0;
    L3:
        short[][] r2 = this.f22241g;
        if (r1 == r2.length) goto L6;
        r0[r1] = l.b.h.a.e(r2[r1]);
        r1 = r1 + 1;
        goto L3
    L6:
        return r0;
    }

    public int d() {
        return this.f22243i;
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if ((r4 instanceof b) == false) goto L22;
        b r5 = (b) r4;
        if (this.f22243i == r5.d()) goto L10;
        return false;
    L10:
        if (l.b.g.b.e.b.a.j(this.f22240f, r5.a()) == true) goto L12;
        return false;
    L12:
        if (l.b.g.b.e.b.a.j(this.f22241g, r5.c()) == true) goto L14;
        return false;
    L14:
        if (l.b.g.b.e.b.a.i(this.f22242h, r5.b()) == false) goto L21;
        return true;
    L21:
        return false;
    L22:
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "Rainbow";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        g r0 = new g(this.f22243i, this.f22240f, this.f22241g, this.f22242h);
        return l.b.g.c.a.h.a.a(new l.b.a.v2.a(e.f21929a, w0.f21794f), r0);
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return (((((this.f22243i * 37) + l.b.h.a.o(this.f22240f)) * 37) + l.b.h.a.o(this.f22241g)) * 37) + l.b.h.a.n(this.f22242h);
    }
}
