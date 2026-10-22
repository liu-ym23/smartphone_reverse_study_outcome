package l.b.g.c.a.b;

import java.security.Key;
import java.security.PrivateKey;
import l.b.a.r2.e;
import l.b.a.w;
import l.b.g.b.a.g;

/* JADX INFO: loaded from: classes2.dex */
public class a implements PrivateKey, Key {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient g f22221f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient w f22222g;

    public a(e r1) {
        a(r1);
    }

    private void a(e r2) {
        this.f22222g = r2.n();
        this.f22221f = (g) l.b.g.b.g.a.b(r2);
    }

    public boolean equals(Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof a) == false) goto L12;
        a r3 = (a) r2;
        return l.b.h.a.a(this.f22221f.getEncoded(), r3.f22221f.getEncoded());
    L11:
        throw new IllegalStateException("unable to perform equals");
    L12:
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "LMS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return l.b.g.b.g.b.a(this.f22221f, this.f22222g).getEncoded();
    L4:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return l.b.h.a.j(this.f22221f.getEncoded());
    L5:
        throw new IllegalStateException("unable to calculate hashCode");
    }
}
