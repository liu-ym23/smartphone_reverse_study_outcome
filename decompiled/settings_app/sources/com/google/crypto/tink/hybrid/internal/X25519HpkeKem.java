package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.X25519;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
final class X25519HpkeKem implements HpkeKem {
    private final HkdfHpkeKdf hkdf;

    X25519HpkeKem(HkdfHpkeKdf hkdf) {
        this.hkdf = hkdf;
    }

    private byte[] deriveKemSharedSecret(byte[] dhSharedSecret, byte[] senderEphemeralPublicKey, byte[] recipientPublicKey) throws GeneralSecurityException {
        return extractAndExpand(dhSharedSecret, Bytes.concat(new byte[][]{senderEphemeralPublicKey, recipientPublicKey}));
    }

    private byte[] deriveKemSharedSecret(byte[] dhSharedSecret, byte[] senderEphemeralPublicKey, byte[] recipientPublicKey, byte[] senderPublicKey) throws GeneralSecurityException {
        return extractAndExpand(dhSharedSecret, Bytes.concat(new byte[][]{senderEphemeralPublicKey, recipientPublicKey, senderPublicKey}));
    }

    private byte[] extractAndExpand(byte[] dhSharedSecret, byte[] kemContext) throws GeneralSecurityException {
        byte[] r7 = HpkeUtil.kemSuiteId(HpkeUtil.X25519_HKDF_SHA256_KEM_ID);
        HkdfHpkeKdf r1 = this.hkdf;
        return r1.extractAndExpand(null, dhSharedSecret, "eae_prk", kemContext, "shared_secret", r7, r1.getMacLength());
    }

    HpkeKemEncapOutput encapsulate(byte[] recipientPublicKey, byte[] senderPrivateKey) throws GeneralSecurityException {
        byte[] r0 = X25519.computeSharedSecret(senderPrivateKey, recipientPublicKey);
        byte[] r3 = X25519.publicFromPrivate(senderPrivateKey);
        return new HpkeKemEncapOutput(deriveKemSharedSecret(r0, r3, recipientPublicKey), r3);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public HpkeKemEncapOutput encapsulate(byte[] recipientPublicKey) throws GeneralSecurityException {
        return encapsulate(recipientPublicKey, X25519.generatePrivateKey());
    }

    HpkeKemEncapOutput authEncapsulate(byte[] recipientPublicKey, byte[] senderEphemeralPrivateKey, HpkeKemPrivateKey senderPrivateKey) throws GeneralSecurityException {
        byte[] r0 = Bytes.concat(new byte[][]{X25519.computeSharedSecret(senderEphemeralPrivateKey, recipientPublicKey), X25519.computeSharedSecret(senderPrivateKey.getSerializedPrivate().toByteArray(), recipientPublicKey)});
        byte[] r5 = X25519.publicFromPrivate(senderEphemeralPrivateKey);
        return new HpkeKemEncapOutput(deriveKemSharedSecret(r0, r5, recipientPublicKey, X25519.publicFromPrivate(senderPrivateKey.getSerializedPrivate().toByteArray())), r5);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public HpkeKemEncapOutput authEncapsulate(byte[] recipientPublicKey, HpkeKemPrivateKey senderPrivateKey) throws GeneralSecurityException {
        return authEncapsulate(recipientPublicKey, X25519.generatePrivateKey(), senderPrivateKey);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public byte[] decapsulate(byte[] encapsulatedKey, HpkeKemPrivateKey recipientPrivateKey) throws GeneralSecurityException {
        return deriveKemSharedSecret(X25519.computeSharedSecret(recipientPrivateKey.getSerializedPrivate().toByteArray(), encapsulatedKey), encapsulatedKey, recipientPrivateKey.getSerializedPublic().toByteArray());
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public byte[] authDecapsulate(byte[] encapsulatedKey, HpkeKemPrivateKey recipientPrivateKey, byte[] senderPublicKey) throws GeneralSecurityException {
        byte[] r5 = recipientPrivateKey.getSerializedPrivate().toByteArray();
        return deriveKemSharedSecret(Bytes.concat(new byte[][]{X25519.computeSharedSecret(r5, encapsulatedKey), X25519.computeSharedSecret(r5, senderPublicKey)}), encapsulatedKey, X25519.publicFromPrivate(r5), senderPublicKey);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public byte[] getKemId() throws GeneralSecurityException {
        if (Arrays.equals(this.hkdf.getKdfId(), HpkeUtil.HKDF_SHA256_KDF_ID) == false) goto L7;
        return HpkeUtil.X25519_HKDF_SHA256_KEM_ID;
    L7:
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
