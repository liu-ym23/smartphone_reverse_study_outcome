package l.b.g.c.a.g;

import java.io.IOException;
import java.security.Key;
import java.security.PublicKey;
import l.b.a.o;
import l.b.a.v2.f;
import l.b.g.a.e;
import l.b.g.a.h;
import l.b.g.b.g.d;

/* JADX INFO: loaded from: classes2.dex */
public class b implements PublicKey, Key {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient o f22247f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient l.b.g.b.f.c f22248g;

    public b(f r1) {
        a(r1);
    }

    private void a(f r2) {
        this.f22247f = h.n(r2.n().q()).o().n();
        this.f22248g = (l.b.g.b.f.c) l.b.g.b.g.c.a(r2);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == false) goto L14;
        b r6 = (b) r5;
        if (this.f22247f.r(r6.f22247f) == false) goto L13;
        if (l.b.h.a.a(this.f22248g.b(), r6.f22248g.b()) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "SPHINCS-256";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
    L8:
        return null;
    L3:
        if (this.f22248g.a() == null) goto L5;
        f r5 = d.a(this.f22248g);     // Catch: IOException -> L8
    L6:
        return r5.getEncoded();
    L5:
        r5 = new f(new l.b.a.v2.a(e.f21933e, new h(new l.b.a.v2.a(this.f22247f))), this.f22248g.b());     // Catch: IOException -> L8
        goto L6
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return this.f22247f.hashCode() + (l.b.h.a.j(this.f22248g.b()) * 37);
    }
}
