package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.hybrid.HpkeParameters;
import com.google.crypto.tink.subtle.EllipticCurves;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class HpkePrimitiveFactory {
    public static HpkeKem createKem(byte[] kemId) throws GeneralSecurityException {
        if (Arrays.equals(kemId, HpkeUtil.X25519_HKDF_SHA256_KEM_ID) == false) goto L7;
        return new X25519HpkeKem(new HkdfHpkeKdf("HmacSha256"));
    L7:
        if (Arrays.equals(kemId, HpkeUtil.P256_HKDF_SHA256_KEM_ID) == false) goto L11;
        return NistCurvesHpkeKem.fromCurve(EllipticCurves.CurveType.NIST_P256);
    L11:
        if (Arrays.equals(kemId, HpkeUtil.P384_HKDF_SHA384_KEM_ID) == false) goto L15;
        return NistCurvesHpkeKem.fromCurve(EllipticCurves.CurveType.NIST_P384);
    L15:
        if (Arrays.equals(kemId, HpkeUtil.P521_HKDF_SHA512_KEM_ID) == false) goto L19;
        return NistCurvesHpkeKem.fromCurve(EllipticCurves.CurveType.NIST_P521);
    L19:
        throw new IllegalArgumentException("Unrecognized HPKE KEM identifier");
    }

    public static HpkeKem createKem(HpkeParameters.KemId kemId) throws GeneralSecurityException {
        if (kemId != HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256) goto L7;
        return new X25519HpkeKem(new HkdfHpkeKdf("HmacSha256"));
    L7:
        if (kemId != HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256) goto L11;
        return NistCurvesHpkeKem.fromCurve(EllipticCurves.CurveType.NIST_P256);
    L11:
        if (kemId != HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384) goto L15;
        return NistCurvesHpkeKem.fromCurve(EllipticCurves.CurveType.NIST_P384);
    L15:
        if (kemId != HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512) goto L19;
        return NistCurvesHpkeKem.fromCurve(EllipticCurves.CurveType.NIST_P521);
    L19:
        throw new IllegalArgumentException("Unrecognized HPKE KEM identifier");
    }

    public static HpkeKdf createKdf(byte[] kdfId) {
        if (Arrays.equals(kdfId, HpkeUtil.HKDF_SHA256_KDF_ID) == false) goto L7;
        return new HkdfHpkeKdf("HmacSha256");
    L7:
        if (Arrays.equals(kdfId, HpkeUtil.HKDF_SHA384_KDF_ID) == false) goto L11;
        return new HkdfHpkeKdf("HmacSha384");
    L11:
        if (Arrays.equals(kdfId, HpkeUtil.HKDF_SHA512_KDF_ID) == false) goto L15;
        return new HkdfHpkeKdf("HmacSha512");
    L15:
        throw new IllegalArgumentException("Unrecognized HPKE KDF identifier");
    }

    public static HpkeKdf createKdf(HpkeParameters.KdfId kdfId) {
        if (kdfId != HpkeParameters.KdfId.HKDF_SHA256) goto L7;
        return new HkdfHpkeKdf("HmacSha256");
    L7:
        if (kdfId != HpkeParameters.KdfId.HKDF_SHA384) goto L11;
        return new HkdfHpkeKdf("HmacSha384");
    L11:
        if (kdfId != HpkeParameters.KdfId.HKDF_SHA512) goto L15;
        return new HkdfHpkeKdf("HmacSha512");
    L15:
        throw new IllegalArgumentException("Unrecognized HPKE KDF identifier");
    }

    public static HpkeAead createAead(byte[] aeadId) throws GeneralSecurityException {
        if (Arrays.equals(aeadId, HpkeUtil.AES_128_GCM_AEAD_ID) == false) goto L7;
        return new AesGcmHpkeAead(16);
    L7:
        if (Arrays.equals(aeadId, HpkeUtil.AES_256_GCM_AEAD_ID) == false) goto L11;
        return new AesGcmHpkeAead(32);
    L11:
        if (Arrays.equals(aeadId, HpkeUtil.CHACHA20_POLY1305_AEAD_ID) == false) goto L15;
        return new ChaCha20Poly1305HpkeAead();
    L15:
        throw new IllegalArgumentException("Unrecognized HPKE AEAD identifier");
    }

    public static HpkeAead createAead(HpkeParameters.AeadId aeadId) throws GeneralSecurityException {
        if (aeadId != HpkeParameters.AeadId.AES_128_GCM) goto L7;
        return new AesGcmHpkeAead(16);
    L7:
        if (aeadId != HpkeParameters.AeadId.AES_256_GCM) goto L11;
        return new AesGcmHpkeAead(32);
    L11:
        if (aeadId != HpkeParameters.AeadId.CHACHA20_POLY1305) goto L15;
        return new ChaCha20Poly1305HpkeAead();
    L15:
        throw new IllegalArgumentException("Unrecognized HPKE AEAD identifier");
    }

    private HpkePrimitiveFactory() {
    }
}
