package l.b.g.c.a.b;

import java.security.Key;
import java.security.PublicKey;
import l.b.a.v2.f;
import l.b.g.b.a.g;
import l.b.g.b.g.d;

/* JADX INFO: loaded from: classes2.dex */
public class b implements PublicKey, Key {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient g f22223f;

    public b(f r1) {
        a(r1);
    }

    private void a(f r1) {
        this.f22223f = (g) l.b.g.b.g.c.a(r1);
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L6;
        return true;
    L6:
        if ((r3 instanceof b) == false) goto L10;
        b r4 = (b) r3;
        return l.b.h.a.a(this.f22223f.getEncoded(), r4.f22223f.getEncoded());
    L10:
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "LMS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return d.a(this.f22223f).getEncoded();
    L4:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return l.b.h.a.j(this.f22223f.getEncoded());
    L4:
        return -1;
    }
}
