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
public class e extends KeyFactorySpi implements l.b.c.c.c.b {
    public e() {
    }

    @Override // java.security.KeyFactorySpi
    protected PrivateKey engineGeneratePrivate(KeySpec r9) {
        if ((r9 instanceof PKCS8EncodedKeySpec) == false) goto L18;
        l.b.a.r2.e r8 = l.b.a.r2.e.o(t.s(((PKCS8EncodedKeySpec) r9).getEncoded()));     // Catch: IOException -> L14
        if (l.b.g.a.e.f21932d.r(r8.p().n()) == false) goto L11;
        l.b.g.a.a r10 = l.b.g.a.a.q(r8.s());     // Catch: IOException -> L12
        return new a(new l.b.g.b.b.b(r10.s(), r10.r(), r10.o(), r10.p(), r10.t(), g.b(r10.n()).e()));
    L11:
        throw new InvalidKeySpecException("Unable to recognise OID in McEliece public key");     // Catch: IOException -> L12
    L13:
        throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec.");
    L14:
        e = move-exception;
        throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec: " + e);
    L18:
        throw new InvalidKeySpecException("Unsupported key specification: " + r9.getClass() + ".");
    }

    @Override // java.security.KeyFactorySpi
    protected PublicKey engineGeneratePublic(KeySpec r5) {
        if ((r5 instanceof X509EncodedKeySpec) == false) goto L19;
        l.b.a.v2.f r4 = l.b.a.v2.f.o(t.s(((X509EncodedKeySpec) r5).getEncoded()));     // Catch: IOException -> L15
    L12:
        e = move-exception;
        throw new InvalidKeySpecException("Unable to decode X509EncodedKeySpec: " + e.getMessage());
    L7:
        if (l.b.g.a.e.f21932d.r(r4.n().n()) == false) goto L11;
        l.b.g.a.b r6 = l.b.g.a.b.p(r4.q());     // Catch: IOException -> L12
        return new b(new l.b.g.b.b.c(r6.q(), r6.r(), r6.o(), g.b(r6.n()).e()));
    L11:
        throw new InvalidKeySpecException("Unable to recognise OID in McEliece private key");     // Catch: IOException -> L12
    L15:
        e = move-exception;
        throw new InvalidKeySpecException(e.toString());
    L19:
        throw new InvalidKeySpecException("Unsupported key specification: " + r5.getClass() + ".");
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
