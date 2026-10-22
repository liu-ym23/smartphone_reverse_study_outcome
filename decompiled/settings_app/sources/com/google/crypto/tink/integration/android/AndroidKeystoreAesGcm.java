package com.google.crypto.tink.integration.android;

import android.util.Log;
import com.google.crypto.tink.Aead;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: loaded from: classes4.dex */
public final class AndroidKeystoreAesGcm implements Aead {
    private static final int IV_SIZE_IN_BYTES = 12;
    private static final int MAX_WAIT_TIME_MILLISECONDS_BEFORE_RETRY = 100;
    private static final String TAG = "AndroidKeystoreAesGcm";
    private static final int TAG_SIZE_IN_BYTES = 16;
    private final SecretKey key;

    static {
    }

    public AndroidKeystoreAesGcm(String keyId) throws GeneralSecurityException, IOException {
        KeyStore r0 = KeyStore.getInstance("AndroidKeyStore");
        r0.load(null);
        SecretKey r1 = (SecretKey) r0.getKey(keyId, null);
        this.key = r1;
        if (r1 == null) goto L6;
        return;
    L6:
        throw new InvalidKeyException("Keystore cannot load the key with ID: " + keyId);
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        return encryptInternal(plaintext, associatedData);
    L4:
        e = move-exception;
        Log.w(TAG, "encountered a potentially transient KeyStore error, will wait and retry", e);
        sleepRandomAmount();
        return encryptInternal(plaintext, associatedData);
    }

    private byte[] encryptInternal(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        if (plaintext.length > 2147483619) goto L7;
        byte[] r0 = new byte[(plaintext.length + 12) + 16];
        Cipher r8 = Cipher.getInstance("AES/GCM/NoPadding");
        r8.init(1, this.key);
        r8.updateAAD(associatedData);
        r8.doFinal(plaintext, 0, plaintext.length, r0, 12);
        System.arraycopy(r8.getIV(), 0, r0, 0, 12);
        return r0;
    L7:
        throw new GeneralSecurityException("plaintext too long");
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        if (ciphertext.length < 28) goto L12;
        return decryptInternal(ciphertext, associatedData);
    L9:
        e = move-exception;
        throw e;
    L6:
        e = move-exception;
        Log.w(TAG, "encountered a potentially transient KeyStore error, will wait and retry", e);
        sleepRandomAmount();
        return decryptInternal(ciphertext, associatedData);
    L12:
        throw new GeneralSecurityException("ciphertext too short");
    }

    private byte[] decryptInternal(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        GCMParameterSpec r0 = new GCMParameterSpec(128, ciphertext, 0, 12);
        Cipher r1 = Cipher.getInstance("AES/GCM/NoPadding");
        r1.init(2, this.key, r0);
        r1.updateAAD(associatedData);
        return r1.doFinal(ciphertext, 12, ciphertext.length - 12);
    }

    private static void sleepRandomAmount() {
        Thread.sleep((int) (Math.random() * 100.0d));     // Catch: InterruptedException -> L5
        return;
    }
}
