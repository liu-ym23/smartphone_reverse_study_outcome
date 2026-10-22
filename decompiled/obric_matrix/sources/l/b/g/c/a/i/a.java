package l.b.g.c.a.i;

import java.security.PrivateKey;
import l.b.a.o;
import l.b.a.w;
import l.b.g.a.j;
import l.b.g.b.h.s;

/* JADX INFO: loaded from: classes2.dex */
public class a implements PrivateKey {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient o f22249f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient s f22250g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient w f22251h;

    public a(l.b.a.r2.e r1) {
        a(r1);
    }

    private void a(l.b.a.r2.e r2) {
        this.f22251h = r2.n();
        this.f22249f = j.o(r2.p().q()).q().n();
        this.f22250g = (s) l.b.g.b.g.a.b(r2);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == false) goto L14;
        a r6 = (a) r5;
        if (this.f22249f.r(r6.f22249f) == false) goto L13;
        if (l.b.h.a.a(this.f22250g.c(), r6.f22250g.c()) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "XMSSMT";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return l.b.g.b.g.b.a(this.f22250g, this.f22251h).getEncoded();
    L4:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return this.f22249f.hashCode() + (l.b.h.a.j(this.f22250g.c()) * 37);
    }
}
