package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.hybrid.HpkeParameters;
import com.google.crypto.tink.hybrid.HpkePrivateKey;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public final class HpkeKemKeyFactory {
    public static HpkeKemPrivateKey createPrivate(HpkePrivateKey privateKey) throws GeneralSecurityException {
        HpkeParameters.KemId r0 = privateKey.getParameters().getKemId();
        if (r0 != HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256) goto L7;
        return X25519HpkeKemPrivateKey.fromBytes(privateKey.getPrivateKeyBytes().toByteArray(InsecureSecretKeyAccess.get()));
    L7:
        if (r0 == HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256) goto L16;
        if (r0 == HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384) goto L16;
        if (r0 == HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512) goto L16;
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    L16:
        return NistCurvesHpkeKemPrivateKey.fromBytes(privateKey.getPrivateKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), privateKey.getPublicKey().getPublicKeyBytes().toByteArray(), HpkeUtil.nistHpkeKemToCurve(r0));
    }

    private HpkeKemKeyFactory() {
    }
}
