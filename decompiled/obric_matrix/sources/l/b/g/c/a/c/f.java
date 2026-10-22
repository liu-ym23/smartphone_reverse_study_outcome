package l.b.g.c.a.c;

import java.io.IOException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import l.b.a.t;

/* JADX INFO: loaded from: classes2.dex */
public class f extends KeyFactorySpi implements l.b.c.c.c.b {
    public f() {
    }

    @Override // java.security.KeyFactorySpi
    protected PrivateKey engineGeneratePrivate(KeySpec r10) {
        if ((r10 instanceof PKCS8EncodedKeySpec) == false) goto L18;
        l.b.a.r2.e r9 = l.b.a.r2.e.o(t.s(((PKCS8EncodedKeySpec) r10).getEncoded()));     // Catch: IOException -> L14
        if (l.b.g.a.e.f21931c.r(r9.p().n()) == false) goto L11;
        l.b.g.a.c r11 = l.b.g.a.c.p(r9.s());     // Catch: IOException -> L12
        return new c(new l.b.g.b.b.f(r11.r(), r11.q(), r11.n(), r11.o(), r11.s(), r11.t(), r11.u()));
    L11:
        throw new InvalidKeySpecException("Unable to recognise OID in McEliece private key");     // Catch: IOException -> L12
    L13:
        throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec.");
    L14:
        e = move-exception;
        throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec: " + e);
    L18:
        throw new InvalidKeySpecException("Unsupported key specification: " + r10.getClass() + ".");
    }

    @Override // java.security.KeyFactorySpi
    protected PublicKey engineGeneratePublic(KeySpec r4) {
        if ((r4 instanceof X509EncodedKeySpec) == false) goto L19;
        l.b.a.v2.f r3 = l.b.a.v2.f.o(t.s(((X509EncodedKeySpec) r4).getEncoded()));     // Catch: IOException -> L15
    L12:
        e = move-exception;
        throw new InvalidKeySpecException("Unable to decode X509EncodedKeySpec: " + e.getMessage());
    L7:
        if (l.b.g.a.e.f21931c.r(r3.n().n()) == false) goto L11;
        l.b.g.a.d r5 = l.b.g.a.d.o(r3.q());     // Catch: IOException -> L12
        return new d(new l.b.g.b.b.g(r5.p(), r5.q(), r5.n()));
    L11:
        throw new InvalidKeySpecException("Unable to recognise OID in McEliece public key");     // Catch: IOException -> L12
    L15:
        e = move-exception;
        throw new InvalidKeySpecException(e.toString());
    L19:
        throw new InvalidKeySpecException("Unsupported key specification: " + r4.getClass() + ".");
    }

    @Override // java.security.KeyFactorySpi
    protected KeySpec engineGetKeySpec(Key r1, Class r2) {
        return null;
    }

    @Override // java.security.KeyFactorySpi
    protected Key engineTranslateKey(Key r1) {
        return null;
    }
}
