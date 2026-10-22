package com.google.crypto.tink.hybrid.subtle;

import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.aead.subtle.AeadFactory;
import com.google.crypto.tink.subtle.Hkdf;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.RSAPublicKey;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes4.dex */
public final class RsaKemHybridEncrypt implements HybridEncrypt {
    private final AeadFactory aeadFactory;
    private final String hkdfHmacAlgo;
    private final byte[] hkdfSalt;
    private final RSAPublicKey recipientPublicKey;

    public RsaKemHybridEncrypt(final RSAPublicKey recipientPublicKey, String hkdfHmacAlgo, final byte[] hkdfSalt, AeadFactory aeadFactory) throws GeneralSecurityException {
        RsaKem.validateRsaModulus(recipientPublicKey.getModulus());
        this.recipientPublicKey = recipientPublicKey;
        this.hkdfHmacAlgo = hkdfHmacAlgo;
        this.hkdfSalt = hkdfSalt;
        this.aeadFactory = aeadFactory;
    }

    @Override // com.google.crypto.tink.HybridEncrypt
    public byte[] encrypt(final byte[] plaintext, final byte[] contextInfo) throws GeneralSecurityException {
        byte[] r0 = RsaKem.generateSecret(this.recipientPublicKey.getModulus());
        Cipher r1 = Cipher.getInstance("RSA/ECB/NoPadding");
        r1.init(1, this.recipientPublicKey);
        byte[] r2 = r1.doFinal(r0);
        byte[] r7 = Hkdf.computeHkdf(this.hkdfHmacAlgo, r0, this.hkdfSalt, contextInfo, this.aeadFactory.getKeySizeInBytes());
        byte[] r5 = this.aeadFactory.createAead(r7).encrypt(plaintext, RsaKem.EMPTY_AAD);
        return ByteBuffer.allocate(r2.length + r5.length).put(r2).put(r5).array();
    }
}
