package l.b.g.c.a.d;

import java.security.Key;
import java.security.PrivateKey;
import l.b.a.r2.e;
import l.b.a.w;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Key, PrivateKey {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient l.b.g.b.c.a f22228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient w f22229g;

    public a(e r1) {
        a(r1);
    }

    private void a(e r2) {
        this.f22229g = r2.n();
        this.f22228f = (l.b.g.b.c.a) l.b.g.b.g.a.b(r2);
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof a) == true) goto L7;
        return false;
    L7:
        return l.b.h.a.c(this.f22228f.a(), ((a) r2).f22228f.a());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "NH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return l.b.g.b.g.b.a(this.f22228f, this.f22229g).getEncoded();
    L4:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return l.b.h.a.n(this.f22228f.a());
    }
}
