package l.b.g.c.a.i;

import java.security.PrivateKey;
import l.b.a.o;
import l.b.a.w;
import l.b.g.a.i;
import l.b.g.b.h.y;

/* JADX INFO: loaded from: classes2.dex */
public class c implements PrivateKey {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient y f22254f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient o f22255g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient w f22256h;

    public c(l.b.a.r2.e r1) {
        a(r1);
    }

    private void a(l.b.a.r2.e r2) {
        this.f22256h = r2.n();
        this.f22255g = i.o(r2.p().q()).p().n();
        this.f22254f = (y) l.b.g.b.g.a.b(r2);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == false) goto L14;
        c r6 = (c) r5;
        if (this.f22255g.r(r6.f22255g) == false) goto L13;
        if (l.b.h.a.a(this.f22254f.c(), r6.f22254f.c()) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "XMSS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return l.b.g.b.g.b.a(this.f22254f, this.f22256h).getEncoded();
    L4:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return this.f22255g.hashCode() + (l.b.h.a.j(this.f22254f.c()) * 37);
    }
}
