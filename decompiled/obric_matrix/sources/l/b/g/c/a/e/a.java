package l.b.g.c.a.e;

import java.security.PrivateKey;
import l.b.a.r2.e;
import l.b.a.w;

/* JADX INFO: loaded from: classes2.dex */
public class a implements PrivateKey {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient l.b.g.b.d.a f22231f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient w f22232g;

    public a(e r1) {
        a(r1);
    }

    private void a(e r2) {
        this.f22232g = r2.n();
        this.f22231f = (l.b.g.b.d.a) l.b.g.b.g.a.b(r2);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == false) goto L14;
        a r6 = (a) r5;
        if (this.f22231f.b() != r6.f22231f.b()) goto L13;
        if (l.b.h.a.a(this.f22231f.a(), r6.f22231f.a()) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return l.b.g.b.d.c.a(this.f22231f.b());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return l.b.g.b.g.b.a(this.f22231f, this.f22232g).getEncoded();
    L4:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return this.f22231f.b() + (l.b.h.a.j(this.f22231f.a()) * 37);
    }
}
