package l.b.g.c.a.g;

import java.io.IOException;
import java.security.Key;
import java.security.PrivateKey;
import l.b.a.o;
import l.b.a.r2.e;
import l.b.a.w;
import l.b.a.y0;
import l.b.g.a.h;

/* JADX INFO: loaded from: classes2.dex */
public class a implements PrivateKey, Key {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient o f22244f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient l.b.g.b.f.b f22245g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient w f22246h;

    public a(e r1) {
        a(r1);
    }

    private void a(e r2) {
        this.f22246h = r2.n();
        this.f22244f = h.n(r2.p().q()).o().n();
        this.f22245g = (l.b.g.b.f.b) l.b.g.b.g.a.b(r2);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == false) goto L14;
        a r6 = (a) r5;
        if (this.f22244f.r(r6.f22244f) == false) goto L13;
        if (l.b.h.a.a(this.f22245g.b(), r6.f22245g.b()) == false) goto L13;
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
        if (this.f22245g.a() == null) goto L5;
        e r5 = l.b.g.b.g.b.a(this.f22245g, this.f22246h);     // Catch: IOException -> L8
    L6:
        return r5.getEncoded();
    L5:
        r5 = new e(new l.b.a.v2.a(l.b.g.a.e.f21933e, new h(new l.b.a.v2.a(this.f22244f))), new y0(this.f22245g.b()), this.f22246h);     // Catch: IOException -> L8
        goto L6
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return this.f22244f.hashCode() + (l.b.h.a.j(this.f22245g.b()) * 37);
    }
}
