package l.b.g.c.a.g;

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
import l.b.a.v2.f;

/* JADX INFO: loaded from: classes2.dex */
public class c extends KeyFactorySpi implements l.b.c.c.c.b {
    public c() {
    }

    public PrivateKey a(e r1) {
        return new a(r1);
    }

    public PublicKey b(f r1) {
        return new b(r1);
    }

    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec r3) {
        if ((r3 instanceof PKCS8EncodedKeySpec) == false) goto L11;
        return a(e.o(t.s(((PKCS8EncodedKeySpec) r3).getEncoded())));
    L7:
        e = move-exception;
        throw new InvalidKeySpecException(e.toString());
    L11:
        throw new InvalidKeySpecException("Unsupported key specification: " + r3.getClass() + ".");
    }

    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec r3) {
        if ((r3 instanceof X509EncodedKeySpec) == false) goto L11;
        return b(f.o(((X509EncodedKeySpec) r3).getEncoded()));
    L7:
        e = move-exception;
        throw new InvalidKeySpecException(e.toString());
    L11:
        throw new InvalidKeySpecException("Unknown key specification: " + r3 + ".");
    }

    @Override // java.security.KeyFactorySpi
    public final KeySpec engineGetKeySpec(Key r3, Class r4) {
        if ((r3 instanceof a) == false) goto L9;
        if (PKCS8EncodedKeySpec.class.isAssignableFrom(r4) == false) goto L15;
        return new PKCS8EncodedKeySpec(r3.getEncoded());
    L15:
        throw new InvalidKeySpecException("Unknown key specification: " + r4 + ".");
    L9:
        if ((r3 instanceof b) == false) goto L17;
        if (X509EncodedKeySpec.class.isAssignableFrom(r4) == false) goto L15;
        return new X509EncodedKeySpec(r3.getEncoded());
    L17:
        throw new InvalidKeySpecException("Unsupported key type: " + r3.getClass() + ".");
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
