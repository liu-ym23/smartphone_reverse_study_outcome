package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.hybrid.HpkePublicKey;
import com.google.crypto.tink.internal.BigIntegerEncoding;
import com.google.crypto.tink.subtle.Bytes;
import com.zte.faceverify.FaceVerifyManager;
import java.math.BigInteger;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public final class HpkeContext {
    private static final byte[] EMPTY_IKM = null;
    private final HpkeAead aead;
    private final byte[] baseNonce;
    private final byte[] encapsulatedKey;
    private final byte[] key;
    private final BigInteger maxSequenceNumber;
    private BigInteger sequenceNumber;

    static {
        EMPTY_IKM = new byte[0];
    }

    private HpkeContext(byte[] encapsulatedKey, byte[] key, byte[] baseNonce, BigInteger maxSequenceNumber, HpkeAead aead) {
        this.encapsulatedKey = encapsulatedKey;
        this.key = key;
        this.baseNonce = baseNonce;
        this.sequenceNumber = BigInteger.ZERO;
        this.maxSequenceNumber = maxSequenceNumber;
        this.aead = aead;
    }

    static HpkeContext createContext(byte[] mode, byte[] encapsulatedKey, byte[] sharedSecret, HpkeKem kem, HpkeKdf kdf, HpkeAead aead, byte[] info) throws GeneralSecurityException {
        byte[] r7 = HpkeUtil.hpkeSuiteId(kem.getKemId(), kdf.getKdfId(), aead.getAeadId());
        byte[] r0 = HpkeUtil.EMPTY_SALT;
        byte[] r1 = EMPTY_IKM;
        byte[] r8 = Bytes.concat(new byte[][]{mode, kdf.labeledExtract(r0, r1, "psk_id_hash", r7), kdf.labeledExtract(HpkeUtil.EMPTY_SALT, info, "info_hash", r7)});
        byte[] r9 = kdf.labeledExtract(sharedSecret, r1, FaceVerifyManager.PATH_SECRET, r7);
        return new HpkeContext(encapsulatedKey, kdf.labeledExpand(r9, r8, "key", r7, aead.getKeyLength()), kdf.labeledExpand(r9, r8, "base_nonce", r7, aead.getNonceLength()), maxSequenceNumber(aead.getNonceLength()), aead);
    }

    static HpkeContext createSenderContext(byte[] recipientPublicKey, HpkeKem kem, HpkeKdf kdf, HpkeAead aead, byte[] info) throws GeneralSecurityException {
        HpkeKemEncapOutput r7 = kem.encapsulate(recipientPublicKey);
        byte[] r1 = r7.getEncapsulatedKey();
        byte[] r2 = r7.getSharedSecret();
        return createContext(HpkeUtil.BASE_MODE, r1, r2, kem, kdf, aead, info);
    }

    public static HpkeContext createAuthSenderContext(HpkePublicKey recipientPublicKey, HpkeKem kem, HpkeKdf kdf, HpkeAead aead, byte[] info, HpkeKemPrivateKey senderPrivateKey) throws GeneralSecurityException {
        HpkeKemEncapOutput r7 = kem.authEncapsulate(recipientPublicKey.getPublicKeyBytes().toByteArray(), senderPrivateKey);
        byte[] r1 = r7.getEncapsulatedKey();
        byte[] r2 = r7.getSharedSecret();
        return createContext(HpkeUtil.AUTH_MODE, r1, r2, kem, kdf, aead, info);
    }

    public static HpkeContext createRecipientContext(byte[] encapsulatedKey, HpkeKemPrivateKey recipientPrivateKey, HpkeKem kem, HpkeKdf kdf, HpkeAead aead, byte[] info) throws GeneralSecurityException {
        byte[] r2 = kem.decapsulate(encapsulatedKey, recipientPrivateKey);
        return createContext(HpkeUtil.BASE_MODE, encapsulatedKey, r2, kem, kdf, aead, info);
    }

    public static HpkeContext createAuthRecipientContext(byte[] encapsulatedKey, HpkeKemPrivateKey recipientPrivateKey, HpkeKem kem, HpkeKdf kdf, HpkeAead aead, byte[] info, HpkePublicKey senderPublicKey) throws GeneralSecurityException {
        byte[] r2 = kem.authDecapsulate(encapsulatedKey, recipientPrivateKey, senderPublicKey.getPublicKeyBytes().toByteArray());
        return createContext(HpkeUtil.AUTH_MODE, encapsulatedKey, r2, kem, kdf, aead, info);
    }

    private static BigInteger maxSequenceNumber(int nonceLength) {
        return BigInteger.ONE.shiftLeft(nonceLength * 8).subtract(BigInteger.ONE);
    }

    private void incrementSequenceNumber() throws GeneralSecurityException {
        if (this.sequenceNumber.compareTo(this.maxSequenceNumber) >= 0) goto L7;
        this.sequenceNumber = this.sequenceNumber.add(BigInteger.ONE);
        return;
    L7:
        throw new GeneralSecurityException("message limit reached");
    }

    private byte[] computeNonce() throws GeneralSecurityException {
        return Bytes.xor(this.baseNonce, BigIntegerEncoding.toBigEndianBytesOfFixedLength(this.sequenceNumber, this.aead.getNonceLength()));
    }

    private synchronized byte[] computeNonceAndIncrementSequenceNumber() throws GeneralSecurityException {
        monitor-enter(this);
        byte[] r0 = computeNonce();     // Catch: Throwable -> L6
        incrementSequenceNumber();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    byte[] getKey() {
        return this.key;
    }

    byte[] getBaseNonce() {
        return this.baseNonce;
    }

    public byte[] getEncapsulatedKey() {
        return this.encapsulatedKey;
    }

    public byte[] seal(byte[] plaintext, byte[] associatedData) throws GeneralSecurityException {
        byte[] r0 = computeNonceAndIncrementSequenceNumber();
        return this.aead.seal(this.key, r0, plaintext, associatedData);
    }

    public byte[] open(byte[] ciphertext, byte[] associatedData) throws GeneralSecurityException {
        byte[] r0 = computeNonceAndIncrementSequenceNumber();
        return this.aead.open(this.key, r0, ciphertext, associatedData);
    }
}
