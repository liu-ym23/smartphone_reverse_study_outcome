package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.hybrid.HpkeParameters;
import com.google.crypto.tink.hybrid.HpkePrivateKey;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class HpkeDecrypt implements HybridDecrypt {
    private static final byte[] EMPTY_ASSOCIATED_DATA = null;
    private final HpkeAead aead;
    private final int encapsulatedKeyLength;
    private final HpkeKdf kdf;
    private final HpkeKem kem;
    private final byte[] outputPrefix;
    private final HpkeKemPrivateKey recipientPrivateKey;

    static {
        EMPTY_ASSOCIATED_DATA = new byte[0];
    }

    private HpkeDecrypt(HpkeKemPrivateKey recipientPrivateKey, HpkeKem kem, HpkeKdf kdf, HpkeAead aead, int encapsulatedKeyLength, Bytes outputPrefix) {
        this.recipientPrivateKey = recipientPrivateKey;
        this.kem = kem;
        this.kdf = kdf;
        this.aead = aead;
        this.encapsulatedKeyLength = encapsulatedKeyLength;
        this.outputPrefix = outputPrefix.toByteArray();
    }

    private static int encodingSizeInBytes(HpkeParameters.KemId kemId) throws GeneralSecurityException {
        if (kemId.equals(HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256) == false) goto L7;
        return 32;
    L7:
        if (kemId.equals(HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256) == false) goto L11;
        return 65;
    L11:
        if (kemId.equals(HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384) == false) goto L15;
        return 97;
    L15:
        if (kemId.equals(HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512) == false) goto L19;
        return 133;
    L19:
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    static EllipticCurves.CurveType nistHpkeKemToCurve(HpkeParameters.KemId kemId) throws GeneralSecurityException {
        if (kemId.equals(HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256) == false) goto L7;
        return EllipticCurves.CurveType.NIST_P256;
    L7:
        if (kemId.equals(HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384) == false) goto L11;
        return EllipticCurves.CurveType.NIST_P384;
    L11:
        if (kemId.equals(HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512) == false) goto L15;
        return EllipticCurves.CurveType.NIST_P521;
    L15:
        throw new GeneralSecurityException("Unrecognized NIST HPKE KEM identifier");
    }

    private static HpkeKemPrivateKey createHpkeKemPrivateKey(HpkePrivateKey privateKey) throws GeneralSecurityException {
        HpkeParameters.KemId r0 = privateKey.getParameters().getKemId();
        if (r0.equals(HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256) == false) goto L7;
        return X25519HpkeKemPrivateKey.fromBytes(privateKey.getPrivateKeyBytes().toByteArray(InsecureSecretKeyAccess.get()));
    L7:
        if (r0.equals(HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256) == true) goto L16;
        if (r0.equals(HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384) == true) goto L16;
        if (r0.equals(HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512) == true) goto L16;
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    L16:
        return NistCurvesHpkeKemPrivateKey.fromBytes(privateKey.getPrivateKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), privateKey.getPublicKey().getPublicKeyBytes().toByteArray(), nistHpkeKemToCurve(r0));
    }

    public static HybridDecrypt create(HpkePrivateKey privateKey) throws GeneralSecurityException {
        HpkeParameters r0 = privateKey.getParameters();
        HpkeKem r4 = HpkeEncrypt.createKem(r0.getKemId());
        HpkeKdf r5 = HpkeEncrypt.createKdf(r0.getKdfId());
        HpkeAead r6 = HpkeEncrypt.createAead(r0.getAeadId());
        int r7 = encodingSizeInBytes(r0.getKemId());
        return new HpkeDecrypt(createHpkeKemPrivateKey(privateKey), r4, r5, r6, r7, privateKey.getOutputPrefix());
    }

    private byte[] decryptNoPrefix(final byte[] ciphertext, final byte[] contextInfo) throws GeneralSecurityException {
        int r0 = ciphertext.length;
        int r1 = this.encapsulatedKeyLength;
        if (r0 < r1) goto L9;
        if (contextInfo != null) goto L6;
        contextInfo = new byte[0];
    L6:
        byte[] r7 = contextInfo;
        byte[] r2 = Arrays.copyOf(ciphertext, r1);
        byte[] r9 = Arrays.copyOfRange(ciphertext, this.encapsulatedKeyLength, ciphertext.length);
        return HpkeContext.createRecipientContext(r2, this.recipientPrivateKey, this.kem, this.kdf, this.aead, r7).open(r9, EMPTY_ASSOCIATED_DATA);
    L9:
        throw new GeneralSecurityException("Ciphertext is too short.");
    }

    @Override // com.google.crypto.tink.HybridDecrypt
    public byte[] decrypt(final byte[] ciphertext, final byte[] contextInfo) throws GeneralSecurityException {
        byte[] r0 = this.outputPrefix;
        if (r0.length != 0) goto L7;
        return decryptNoPrefix(ciphertext, contextInfo);
    L7:
        if (Util.isPrefix(r0, ciphertext) == false) goto L11;
        return decryptNoPrefix(Arrays.copyOfRange(ciphertext, this.outputPrefix.length, ciphertext.length), contextInfo);
    L11:
        throw new GeneralSecurityException("Invalid ciphertext (output prefix mismatch)");
    }
}
