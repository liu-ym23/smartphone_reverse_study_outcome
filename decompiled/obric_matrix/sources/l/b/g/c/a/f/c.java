package l.b.g.c.a.f;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import l.b.a.r2.e;
import l.b.a.t;
import l.b.g.a.f;
import l.b.g.a.g;

/* JADX INFO: loaded from: classes2.dex */
public class c extends KeyFactorySpi implements l.b.c.c.c.b {
    public c() {
    }

    public PrivateKey a(e r8) {
        f r7 = f.p(r8.s());
        return new a(r7.q(), r7.n(), r7.r(), r7.o(), r7.t(), r7.s());
    }

    public PublicKey b(l.b.a.v2.f r4) {
        g r3 = g.r(r4.q());
        return new b(r3.q(), r3.n(), r3.p(), r3.o());
    }

    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec r3) {
        if ((r3 instanceof l.b.g.c.b.a) == false) goto L7;
        return new a((l.b.g.c.b.a) r3);
    L7:
        if ((r3 instanceof PKCS8EncodedKeySpec) == false) goto L15;
        return a(e.o(t.s(((PKCS8EncodedKeySpec) r3).getEncoded())));
    L11:
        e = move-exception;
        throw new InvalidKeySpecException(e.toString());
    L15:
        throw new InvalidKeySpecException("Unsupported key specification: " + r3.getClass() + ".");
    }

    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec r3) {
        if ((r3 instanceof l.b.g.c.b.b) == false) goto L7;
        return new b((l.b.g.c.b.b) r3);
    L7:
        if ((r3 instanceof X509EncodedKeySpec) == false) goto L15;
        return b(l.b.a.v2.f.o(((X509EncodedKeySpec) r3).getEncoded()));
    L11:
        e = move-exception;
        throw new InvalidKeySpecException(e.toString());
    L15:
        throw new InvalidKeySpecException("Unknown key specification: " + r3 + ".");
    }

    @Override // java.security.KeyFactorySpi
    public final KeySpec engineGetKeySpec(Key r8, Class r9) {
        if ((r8 instanceof a) == false) goto L13;
        if (PKCS8EncodedKeySpec.class.isAssignableFrom(r9) == false) goto L9;
        return new PKCS8EncodedKeySpec(r8.getEncoded());
    L9:
        if (l.b.g.c.b.a.class.isAssignableFrom(r9) == false) goto L23;
        a r10 = (a) r8;
        return new l.b.g.c.b.a(r10.c(), r10.a(), r10.d(), r10.b(), r10.f(), r10.e());
    L23:
        throw new InvalidKeySpecException("Unknown key specification: " + r9 + ".");
    L13:
        if ((r8 instanceof b) == false) goto L25;
        if (X509EncodedKeySpec.class.isAssignableFrom(r9) == false) goto L19;
        return new X509EncodedKeySpec(r8.getEncoded());
    L19:
        if (l.b.g.c.b.b.class.isAssignableFrom(r9) == false) goto L23;
        b r11 = (b) r8;
        return new l.b.g.c.b.b(r11.d(), r11.a(), r11.c(), r11.b());
    L25:
        throw new InvalidKeySpecException("Unsupported key type: " + r8.getClass() + ".");
    }

    @Override // java.security.KeyFactorySpi
    public final Key engineTranslateKey(Key r1) {
        if ((r1 instanceof a) == false) goto L5;
    L9:
        return r1;
    L5:
        if ((r1 instanceof b) == true) goto L9;
        throw new InvalidKeyException("Unsupported key type");
    }
}
