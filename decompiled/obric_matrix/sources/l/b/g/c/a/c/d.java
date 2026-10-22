package l.b.g.c.a.c;

import java.security.PublicKey;

/* JADX INFO: loaded from: classes2.dex */
public class d implements PublicKey {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private l.b.g.b.b.g f22227f;

    public d(l.b.g.b.b.g r1) {
        this.f22227f = r1;
    }

    public l.b.g.d.a.a a() {
        return this.f22227f.a();
    }

    public int b() {
        return this.f22227f.b();
    }

    public int c() {
        return this.f22227f.c();
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof d) == false) goto L12;
        d r5 = (d) r4;
        if (this.f22227f.b() == r5.b()) goto L7;
        return false;
    L7:
        if (this.f22227f.c() == r5.c()) goto L9;
        return false;
    L9:
        if (this.f22227f.a().equals(r5.a()) == false) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        l.b.g.a.d r0 = new l.b.g.a.d(this.f22227f.b(), this.f22227f.c(), this.f22227f.a());
        return new l.b.a.v2.f(new l.b.a.v2.a(l.b.g.a.e.f21931c), r0).getEncoded();
    L5:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return ((this.f22227f.b() + (this.f22227f.c() * 37)) * 37) + this.f22227f.a().hashCode();
    }

    public String toString() {
        return (("McEliecePublicKey:\n length of the code         : " + this.f22227f.b() + "\n") + " error correction capability: " + this.f22227f.c() + "\n") + " generator matrix           : " + this.f22227f.a();
    }
}
