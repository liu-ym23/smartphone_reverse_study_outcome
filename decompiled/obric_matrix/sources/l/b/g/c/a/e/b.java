package l.b.g.c.a.e;

import java.security.PublicKey;
import l.b.a.v2.f;
import l.b.g.b.g.d;

/* JADX INFO: loaded from: classes2.dex */
public class b implements PublicKey {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient l.b.g.b.d.b f22233f;

    public b(f r1) {
        a(r1);
    }

    private void a(f r1) {
        this.f22233f = (l.b.g.b.d.b) l.b.g.b.g.c.a(r1);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == false) goto L14;
        b r6 = (b) r5;
        if (this.f22233f.b() != r6.f22233f.b()) goto L13;
        if (l.b.h.a.a(this.f22233f.a(), r6.f22233f.a()) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return l.b.g.b.d.c.a(this.f22233f.b());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return d.a(this.f22233f).getEncoded();
    L4:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return this.f22233f.b() + (l.b.h.a.j(this.f22233f.a()) * 37);
    }
}
