package l.b.g.c.a.c;

import java.security.PrivateKey;
import l.b.g.d.a.h;
import l.b.g.d.a.i;

/* JADX INFO: loaded from: classes2.dex */
public class c implements PrivateKey {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private l.b.g.b.b.f f22226f;

    public c(l.b.g.b.b.f r1) {
        this.f22226f = r1;
    }

    public l.b.g.d.a.b a() {
        return this.f22226f.a();
    }

    public i b() {
        return this.f22226f.b();
    }

    public int c() {
        return this.f22226f.c();
    }

    public int d() {
        return this.f22226f.d();
    }

    public h e() {
        return this.f22226f.e();
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof c) == true) goto L5;
        return false;
    L5:
        c r5 = (c) r4;
        if (d() == r5.d()) goto L8;
        return false;
    L8:
        if (c() == r5.c()) goto L10;
        return false;
    L10:
        if (a().equals(r5.a()) == true) goto L12;
        return false;
    L12:
        if (b().equals(r5.b()) == true) goto L14;
        return false;
    L14:
        if (g().equals(r5.g()) == true) goto L16;
        return false;
    L16:
        if (e().equals(r5.e()) == true) goto L18;
        return false;
    L18:
        if (f().equals(r5.f()) == false) goto L27;
        return true;
    L27:
        return false;
    }

    public h f() {
        return this.f22226f.f();
    }

    public l.b.g.d.a.a g() {
        return this.f22226f.g();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        l.b.g.a.c r8 = new l.b.g.a.c(this.f22226f.d(), this.f22226f.c(), this.f22226f.a(), this.f22226f.b(), this.f22226f.e(), this.f22226f.f(), this.f22226f.g());
        return new l.b.a.r2.e(new l.b.a.v2.a(l.b.g.a.e.f21931c), r8).getEncoded();
    L9:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return (((((((((((this.f22226f.c() * 37) + this.f22226f.d()) * 37) + this.f22226f.a().hashCode()) * 37) + this.f22226f.b().hashCode()) * 37) + this.f22226f.e().hashCode()) * 37) + this.f22226f.f().hashCode()) * 37) + this.f22226f.g().hashCode();
    }
}
