package l.b.g.c.a.c;

import java.io.IOException;
import java.security.PrivateKey;
import l.b.g.d.a.h;
import l.b.g.d.a.i;

/* JADX INFO: loaded from: classes2.dex */
public class a implements PrivateKey {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private l.b.g.b.b.b f22224f;

    public a(l.b.g.b.b.b r1) {
        this.f22224f = r1;
    }

    public l.b.g.d.a.b a() {
        return this.f22224f.b();
    }

    public i b() {
        return this.f22224f.c();
    }

    public l.b.g.d.a.a c() {
        return this.f22224f.d();
    }

    public int d() {
        return this.f22224f.e();
    }

    public int e() {
        return this.f22224f.f();
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if ((r4 instanceof a) == false) goto L28;
        a r5 = (a) r4;
        if (e() == r5.e()) goto L10;
        return false;
    L10:
        if (d() == r5.d()) goto L12;
        return false;
    L12:
        if (a().equals(r5.a()) == true) goto L14;
        return false;
    L14:
        if (b().equals(r5.b()) == true) goto L16;
        return false;
    L16:
        if (f().equals(r5.f()) == true) goto L18;
        return false;
    L18:
        if (c().equals(r5.c()) == false) goto L27;
        return true;
    L27:
        return false;
    L28:
        return false;
    }

    public h f() {
        return this.f22224f.g();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece-CCA2";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        l.b.g.a.a r7 = new l.b.g.a.a(e(), d(), a(), b(), f(), g.a(this.f22224f.a()));     // Catch: IOException -> L4
        return new l.b.a.r2.e(new l.b.a.v2.a(l.b.g.a.e.f21932d), r7).getEncoded();
    L4:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return (((((((((this.f22224f.e() * 37) + this.f22224f.f()) * 37) + this.f22224f.b().hashCode()) * 37) + this.f22224f.c().hashCode()) * 37) + this.f22224f.g().hashCode()) * 37) + this.f22224f.d().hashCode();
    }
}
