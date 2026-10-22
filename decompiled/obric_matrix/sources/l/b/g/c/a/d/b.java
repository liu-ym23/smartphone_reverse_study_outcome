package l.b.g.c.a.d;

import java.security.Key;
import java.security.PublicKey;
import l.b.a.v2.f;
import l.b.g.b.g.d;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Key, PublicKey {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient l.b.g.b.c.b f22230f;

    public b(f r1) {
        a(r1);
    }

    private void a(f r1) {
        this.f22230f = (l.b.g.b.c.b) l.b.g.b.g.c.a(r1);
    }

    public boolean equals(Object r2) {
        if (r2 != null) goto L4;
        return false;
    L4:
        if ((r2 instanceof b) == true) goto L7;
        return false;
    L7:
        return l.b.h.a.a(this.f22230f.a(), ((b) r2).f22230f.a());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "NH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return d.a(this.f22230f).getEncoded();
    L4:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return l.b.h.a.j(this.f22230f.a());
    }
}
