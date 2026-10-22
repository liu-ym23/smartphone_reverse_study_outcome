package l.b.g.c.a.i;

import java.io.IOException;
import java.security.PublicKey;
import l.b.a.o;
import l.b.g.b.h.z;

/* JADX INFO: loaded from: classes2.dex */
public class d implements PublicKey {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient z f22257f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient o f22258g;

    public d(l.b.a.v2.f r1) {
        a(r1);
    }

    private void a(l.b.a.v2.f r1) {
        z r2 = (z) l.b.g.b.g.c.a(r1);
        this.f22257f = r2;
        this.f22258g = e.a(r2.a());
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == false) goto L15;
        d r6 = (d) r5;
        if (this.f22258g.r(r6.f22258g) == false) goto L14;
        if (l.b.h.a.a(this.f22257f.getEncoded(), r6.f22257f.getEncoded()) == false) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "XMSS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return l.b.g.b.g.d.a(this.f22257f).getEncoded();
    L4:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        int r0 = this.f22258g.hashCode();     // Catch: IOException -> L5
        return r0 + (l.b.h.a.j(this.f22257f.getEncoded()) * 37);
    L6:
        return this.f22258g.hashCode();
    }
}
