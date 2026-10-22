package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.aead.XChaCha20Poly1305Key;
import com.google.crypto.tink.aead.internal.InsecureNonceXChaCha20Poly1305;
import com.google.crypto.tink.internal.Util;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class XChaCha20Poly1305 implements Aead {
    private final InsecureNonceXChaCha20Poly1305 cipher;
    private final byte[] outputPrefix;

    private XChaCha20Poly1305(final byte[] key, final byte[] outputPrefix) throws GeneralSecurityException {
        this.cipher = new InsecureNonceXChaCha20Poly1305(key);
        this.outputPrefix = outputPrefix;
    }

    public XChaCha20Poly1305(final byte[] key) throws GeneralSecurityException {
        this(key, new byte[0]);
    }

    public static Aead create(XChaCha20Poly1305Key key) throws GeneralSecurityException {
        return new XChaCha20Poly1305(key.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), key.getOutputPrefix().toByteArray());
    }

    private byte[] rawEncrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        ByteBuffer r0 = ByteBuffer.allocate((plaintext.length + 24) + 16);
        byte[] r1 = Random.randBytes(24);
        r0.put(r1);
        this.cipher.encrypt(r0, r1, plaintext, associatedData);
        return r0.array();
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        byte[] r2 = rawEncrypt(plaintext, associatedData);
        byte[] r1 = this.outputPrefix;
        if (r1.length != 0) goto L6;
        return r2;
    L6:
        return Bytes.concat(new byte[][]{r1, r2});
    }

    private byte[] rawDecrypt(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        if (ciphertext.length < 40) goto L7;
        byte[] r1 = Arrays.copyOf(ciphertext, 24);
        ByteBuffer r4 = ByteBuffer.wrap(ciphertext, 24, ciphertext.length - 24);
        return this.cipher.decrypt(r4, r1, associatedData);
    L7:
        throw new GeneralSecurityException("ciphertext too short");
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        byte[] r0 = this.outputPrefix;
        if (r0.length != 0) goto L7;
        return rawDecrypt(ciphertext, associatedData);
    L7:
        if (Util.isPrefix(r0, ciphertext) == false) goto L11;
        return rawDecrypt(Arrays.copyOfRange(ciphertext, this.outputPrefix.length, ciphertext.length), associatedData);
    L11:
        throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
    }
}
