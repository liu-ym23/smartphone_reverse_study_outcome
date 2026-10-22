package com.google.crypto.tink.hybrid.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.aead.subtle.AeadFactory;
import com.google.crypto.tink.subtle.Hkdf;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.RSAPrivateKey;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes4.dex */
public final class RsaKemHybridDecrypt implements HybridDecrypt {
    private final AeadFactory aeadFactory;
    private final String hkdfHmacAlgo;
    private final byte[] hkdfSalt;
    private final RSAPrivateKey recipientPrivateKey;

    public RsaKemHybridDecrypt(final RSAPrivateKey recipientPrivateKey, String hkdfHmacAlgo, final byte[] hkdfSalt, AeadFactory aeadFactory) throws GeneralSecurityException {
        RsaKem.validateRsaModulus(recipientPrivateKey.getModulus());
        this.recipientPrivateKey = recipientPrivateKey;
        this.hkdfSalt = hkdfSalt;
        this.hkdfHmacAlgo = hkdfHmacAlgo;
        this.aeadFactory = aeadFactory;
    }

    @Override // com.google.crypto.tink.HybridDecrypt
    public byte[] decrypt(final byte[] ciphertext, final byte[] contextInfo) throws GeneralSecurityException {
        int r0 = RsaKem.bigIntSizeInBytes(this.recipientPrivateKey.getModulus());
        if (ciphertext.length < r0) goto L7;
        ByteBuffer r5 = ByteBuffer.wrap(ciphertext);
        byte[] r1 = new byte[r0];
        r5.get(r1);
        Cipher r2 = Cipher.getInstance("RSA/ECB/NoPadding");
        r2.init(2, this.recipientPrivateKey);
        Aead r4 = this.aeadFactory.createAead(Hkdf.computeHkdf(this.hkdfHmacAlgo, r2.doFinal(r1), this.hkdfSalt, contextInfo, this.aeadFactory.getKeySizeInBytes()));
        byte[] r6 = new byte[r5.remaining()];
        r5.get(r6);
        return r4.decrypt(r6, RsaKem.EMPTY_AAD);
    L7:
        throw new GeneralSecurityException(String.format("Ciphertext must be of at least size %d bytes, but got %d", new Object[]{Integer.valueOf(r0), Integer.valueOf(ciphertext.length)}));
    }
}
