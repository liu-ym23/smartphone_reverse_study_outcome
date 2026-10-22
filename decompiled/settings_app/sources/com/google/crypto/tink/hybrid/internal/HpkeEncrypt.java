package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.hybrid.HpkeParameters;
import com.google.crypto.tink.hybrid.HpkePublicKey;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class HpkeEncrypt implements HybridEncrypt {
    private static final byte[] EMPTY_ASSOCIATED_DATA = null;
    private final HpkeAead aead;
    private final HpkeKdf kdf;
    private final HpkeKem kem;
    private final byte[] outputPrefix;
    private final byte[] recipientPublicKey;

    static {
        EMPTY_ASSOCIATED_DATA = new byte[0];
    }

    private HpkeEncrypt(Bytes recipientPublicKey, HpkeKem kem, HpkeKdf kdf, HpkeAead aead, Bytes outputPrefix) {
        this.recipientPublicKey = recipientPublicKey.toByteArray();
        this.kem = kem;
        this.kdf = kdf;
        this.aead = aead;
        this.outputPrefix = outputPrefix.toByteArray();
    }

    public static HybridEncrypt create(HpkePublicKey key) throws GeneralSecurityException {
        HpkeParameters r0 = key.getParameters();
        return new HpkeEncrypt(key.getPublicKeyBytes(), createKem(r0.getKemId()), createKdf(r0.getKdfId()), createAead(r0.getAeadId()), key.getOutputPrefix());
    }

    static HpkeKem createKem(HpkeParameters.KemId kemId) throws GeneralSecurityException {
        if (kemId.equals(HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256) == false) goto L7;
        return new X25519HpkeKem(new HkdfHpkeKdf("HmacSha256"));
    L7:
        if (kemId.equals(HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256) == false) goto L11;
        return NistCurvesHpkeKem.fromCurve(EllipticCurves.CurveType.NIST_P256);
    L11:
        if (kemId.equals(HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384) == false) goto L15;
        return NistCurvesHpkeKem.fromCurve(EllipticCurves.CurveType.NIST_P384);
    L15:
        if (kemId.equals(HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512) == false) goto L19;
        return NistCurvesHpkeKem.fromCurve(EllipticCurves.CurveType.NIST_P521);
    L19:
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    static HpkeKdf createKdf(HpkeParameters.KdfId kdfId) throws GeneralSecurityException {
        if (kdfId.equals(HpkeParameters.KdfId.HKDF_SHA256) == false) goto L7;
        return new HkdfHpkeKdf("HmacSha256");
    L7:
        if (kdfId.equals(HpkeParameters.KdfId.HKDF_SHA384) == false) goto L11;
        return new HkdfHpkeKdf("HmacSha384");
    L11:
        if (kdfId.equals(HpkeParameters.KdfId.HKDF_SHA512) == false) goto L15;
        return new HkdfHpkeKdf("HmacSha512");
    L15:
        throw new GeneralSecurityException("Unrecognized HPKE KDF identifier");
    }

    static HpkeAead createAead(HpkeParameters.AeadId aeadId) throws GeneralSecurityException {
        if (aeadId.equals(HpkeParameters.AeadId.AES_128_GCM) == false) goto L7;
        return new AesGcmHpkeAead(16);
    L7:
        if (aeadId.equals(HpkeParameters.AeadId.AES_256_GCM) == false) goto L11;
        return new AesGcmHpkeAead(32);
    L11:
        if (aeadId.equals(HpkeParameters.AeadId.CHACHA20_POLY1305) == false) goto L15;
        return new ChaCha20Poly1305HpkeAead();
    L15:
        throw new GeneralSecurityException("Unrecognized HPKE AEAD identifier");
    }

    private byte[] noPrefixEncrypt(final byte[] plaintext, final byte[] contextInfo) throws GeneralSecurityException {
        if (contextInfo != null) goto L5;
        contextInfo = new byte[0];
    L5:
        HpkeContext r4 = HpkeContext.createSenderContext(this.recipientPublicKey, this.kem, this.kdf, this.aead, contextInfo);
        return com.google.crypto.tink.subtle.Bytes.concat(new byte[][]{r4.getEncapsulatedKey(), r4.seal(plaintext, EMPTY_ASSOCIATED_DATA)});
    }

    @Override // com.google.crypto.tink.HybridEncrypt
    public byte[] encrypt(final byte[] plaintext, final byte[] contextInfo) throws GeneralSecurityException {
        byte[] r2 = noPrefixEncrypt(plaintext, contextInfo);
        byte[] r1 = this.outputPrefix;
        if (r1.length != 0) goto L6;
        return r2;
    L6:
        return com.google.crypto.tink.subtle.Bytes.concat(new byte[][]{r1, r2});
    }
}
