package l.b.g.c.a.c;

import java.security.PublicKey;

/* JADX INFO: loaded from: classes2.dex */
public class b implements PublicKey {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private l.b.g.b.b.c f22225f;

    public b(l.b.g.b.b.c r1) {
        this.f22225f = r1;
    }

    public l.b.g.d.a.a a() {
        return this.f22225f.b();
    }

    public int b() {
        return this.f22225f.c();
    }

    public int c() {
        return this.f22225f.d();
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if ((r4 instanceof b) == false) goto L19;
        b r5 = (b) r4;
        if (this.f22225f.c() == r5.b()) goto L10;
        return false;
    L10:
        if (this.f22225f.d() == r5.c()) goto L12;
        return false;
    L12:
        if (this.f22225f.b().equals(r5.a()) == false) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece-CCA2";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        l.b.g.a.b r0 = new l.b.g.a.b(this.f22225f.c(), this.f22225f.d(), this.f22225f.b(), g.a(this.f22225f.a()));
        return new l.b.a.v2.f(new l.b.a.v2.a(l.b.g.a.e.f21932d), r0).getEncoded();
    L5:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return ((this.f22225f.c() + (this.f22225f.d() * 37)) * 37) + this.f22225f.b().hashCode();
    }

    public String toString() {
        return (("McEliecePublicKey:\n length of the code         : " + this.f22225f.c() + "\n") + " error correction capability: " + this.f22225f.d() + "\n") + " generator matrix           : " + this.f22225f.b().toString();
    }
}
