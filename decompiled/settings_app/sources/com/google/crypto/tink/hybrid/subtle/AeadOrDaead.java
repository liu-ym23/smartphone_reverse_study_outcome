package com.google.crypto.tink.hybrid.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.DeterministicAead;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public class AeadOrDaead {
    private final Aead aead;
    private final DeterministicAead deterministicAead;

    public AeadOrDaead(Aead aead) {
        this.aead = aead;
        this.deterministicAead = null;
    }

    public AeadOrDaead(DeterministicAead deterministicAead) {
        this.aead = null;
        this.deterministicAead = deterministicAead;
    }

    public byte[] encrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        Aead r0 = this.aead;
        if (r0 == null) goto L7;
        return r0.encrypt(plaintext, associatedData);
    L7:
        return this.deterministicAead.encryptDeterministically(plaintext, associatedData);
    }

    public byte[] decrypt(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        Aead r0 = this.aead;
        if (r0 == null) goto L7;
        return r0.decrypt(ciphertext, associatedData);
    L7:
        return this.deterministicAead.decryptDeterministically(ciphertext, associatedData);
    }
}
