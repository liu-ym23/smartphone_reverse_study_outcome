package com.google.crypto.tink.subtle;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;

/* JADX INFO: loaded from: classes4.dex */
public final class SelfKeyTestValidators {
    private static final ByteString TEST_MESSAGE = null;

    private SelfKeyTestValidators() {
    }

    static {
        TEST_MESSAGE = ByteString.copyFromUtf8("Tink and Wycheproof.");
    }

    public static final void validateRsaSsaPss(RSAPrivateCrtKey privateKey, RSAPublicKey publicKey, Enums.HashType sigHash, Enums.HashType mgf1Hash, int saltLength) throws GeneralSecurityException {
        RsaSsaPssSignJce r0 = new RsaSsaPssSignJce(privateKey, sigHash, mgf1Hash, saltLength);
        RsaSsaPssVerifyJce r1 = new RsaSsaPssVerifyJce(publicKey, sigHash, mgf1Hash, saltLength);
        ByteString r2 = TEST_MESSAGE;     // Catch: GeneralSecurityException -> L5
        r1.verify(r0.sign(r2.toByteArray()), r2.toByteArray());     // Catch: GeneralSecurityException -> L5
        return;
    L5:
        e = move-exception;
        throw new GeneralSecurityException("RSA PSS signing with private key followed by verifying with public key failed. The key may be corrupted.", e);
    }

    public static final void validateRsaSsaPkcs1(RSAPrivateCrtKey privateKey, RSAPublicKey publicKey, Enums.HashType sigHash) throws GeneralSecurityException {
        RsaSsaPkcs1SignJce r0 = new RsaSsaPkcs1SignJce(privateKey, sigHash);
        RsaSsaPkcs1VerifyJce r1 = new RsaSsaPkcs1VerifyJce(publicKey, sigHash);
        ByteString r2 = TEST_MESSAGE;     // Catch: GeneralSecurityException -> L5
        r1.verify(r0.sign(r2.toByteArray()), r2.toByteArray());     // Catch: GeneralSecurityException -> L5
        return;
    L5:
        e = move-exception;
        throw new GeneralSecurityException("RSA PKCS1 signing with private key followed by verifying with public key failed. The key may be corrupted.", e);
    }

    public static final void validateEcdsa(ECPrivateKey privateKey, ECPublicKey publicKey, Enums.HashType hash, EllipticCurves.EcdsaEncoding encoding) throws GeneralSecurityException {
        EcdsaSignJce r0 = new EcdsaSignJce(privateKey, hash, encoding);
        EcdsaVerifyJce r1 = new EcdsaVerifyJce(publicKey, hash, encoding);
        ByteString r2 = TEST_MESSAGE;     // Catch: GeneralSecurityException -> L5
        r1.verify(r0.sign(r2.toByteArray()), r2.toByteArray());     // Catch: GeneralSecurityException -> L5
        return;
    L5:
        e = move-exception;
        throw new GeneralSecurityException("ECDSA signing with private key followed by verifying with public key failed. The key may be corrupted.", e);
    }
}
