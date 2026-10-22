package com.google.crypto.tink.signature;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.Ed25519;
import com.google.crypto.tink.util.SecretBytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class Ed25519PrivateKey extends SignaturePrivateKey {
    private final SecretBytes privateKeyBytes;
    private final Ed25519PublicKey publicKey;

    @Override // com.google.crypto.tink.signature.SignaturePrivateKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.signature.SignaturePrivateKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ SignatureParameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.signature.SignaturePrivateKey, com.google.crypto.tink.PrivateKey
    public /* bridge */ /* synthetic */ Key getPublicKey() {
        return getPublicKey();
    }

    @Override // com.google.crypto.tink.signature.SignaturePrivateKey, com.google.crypto.tink.PrivateKey
    public /* bridge */ /* synthetic */ SignaturePublicKey getPublicKey() {
        return getPublicKey();
    }

    private Ed25519PrivateKey(Ed25519PublicKey publicKey, SecretBytes privateKeyBytes) {
        this.publicKey = publicKey;
        this.privateKeyBytes = privateKeyBytes;
    }

    public static Ed25519PrivateKey create(Ed25519PublicKey publicKey, SecretBytes privateKeyBytes) throws GeneralSecurityException {
        if (publicKey == null) goto L14;
        if (privateKeyBytes.size() != 32) goto L12;
        if (Arrays.equals(publicKey.getPublicKeyBytes().toByteArray(), Ed25519.scalarMultWithBaseToBytes(Ed25519.getHashedScalar(privateKeyBytes.toByteArray(InsecureSecretKeyAccess.get())))) == false) goto L10;
        return new Ed25519PrivateKey(publicKey, privateKeyBytes);
    L10:
        throw new GeneralSecurityException("Ed25519 keys mismatch");
    L12:
        throw new GeneralSecurityException("Ed25519 key must be constructed with key of length 32 bytes, not " + privateKeyBytes.size());
    L14:
        throw new GeneralSecurityException("Ed25519 key cannot be constructed without an Ed25519 public key");
    }

    @Override // com.google.crypto.tink.signature.SignaturePrivateKey, com.google.crypto.tink.Key
    public Ed25519Parameters getParameters() {
        return this.publicKey.getParameters();
    }

    @Override // com.google.crypto.tink.signature.SignaturePrivateKey, com.google.crypto.tink.PrivateKey
    public Ed25519PublicKey getPublicKey() {
        return this.publicKey;
    }

    public SecretBytes getPrivateKeyBytes() {
        return this.privateKeyBytes;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key o) {
        if ((o instanceof Ed25519PrivateKey) == true) goto L5;
        return false;
    L5:
        Ed25519PrivateKey r4 = (Ed25519PrivateKey) o;
        if (r4.publicKey.equalsKey(this.publicKey) == true) goto L8;
        return false;
    L8:
        if (this.privateKeyBytes.equalsSecretBytes(r4.privateKeyBytes) == false) goto L12;
        return true;
    L12:
        return false;
    }
}
