package l.b.g.c.a.i;

import java.security.PublicKey;
import l.b.a.o;
import l.b.g.b.h.t;

/* JADX INFO: loaded from: classes2.dex */
public class b implements PublicKey {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient o f22252f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient t f22253g;

    public b(l.b.a.v2.f r1) {
        a(r1);
    }

    private void a(l.b.a.v2.f r1) {
        t r2 = (t) l.b.g.b.g.c.a(r1);
        this.f22253g = r2;
        this.f22252f = e.a(r2.a());
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == false) goto L14;
        b r6 = (b) r5;
        if (this.f22252f.r(r6.f22252f) == false) goto L13;
        if (l.b.h.a.a(this.f22253g.e(), r6.f22253g.e()) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "XMSSMT";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return l.b.g.b.g.d.a(this.f22253g).getEncoded();
    L4:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return this.f22252f.hashCode() + (l.b.h.a.j(this.f22253g.e()) * 37);
    }
}
