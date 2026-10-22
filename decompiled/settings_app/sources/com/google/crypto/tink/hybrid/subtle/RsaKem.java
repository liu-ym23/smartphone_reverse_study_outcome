package com.google.crypto.tink.hybrid.subtle;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes4.dex */
class RsaKem {
    static final byte[] EMPTY_AAD = null;
    static final int MIN_RSA_KEY_LENGTH_BITS = 2048;

    static {
        EMPTY_AAD = new byte[0];
    }

    private RsaKem() {
    }

    static void validateRsaModulus(BigInteger mod) throws GeneralSecurityException {
        if (mod.bitLength() < 2048) goto L6;
        return;
    L6:
        throw new GeneralSecurityException(String.format("RSA key must be of at least size %d bits, but got %d", new Object[]{2048, Integer.valueOf(mod.bitLength())}));
    }

    static int bigIntSizeInBytes(BigInteger mod) {
        return (mod.bitLength() + 7) / 8;
    }

    static byte[] bigIntToByteArray(BigInteger bigInt, int size) {
        byte[] r5 = bigInt.toByteArray();
        if (r5.length != size) goto L5;
        return r5;
    L5:
        byte[] r0 = new byte[size];
        if (r5.length != (size + 1)) goto L13;
        if (r5[0] != 0) goto L11;
        System.arraycopy(r5, 1, r0, 0, size);
    L15:
        return r0;
    L11:
        throw new IllegalArgumentException("Value is one-byte longer than the expected size, but its first byte is not 0");
    L13:
        if (r5.length >= size) goto L17;
        System.arraycopy(r5, 0, r0, size - r5.length, r5.length);
        goto L15
    L17:
        throw new IllegalArgumentException(String.format("Value has invalid length, must be of length at most (%d + 1), but got %d", new Object[]{Integer.valueOf(size), Integer.valueOf(r5.length)}));
    }

    static byte[] generateSecret(BigInteger max) {
        int r0 = bigIntSizeInBytes(max);
        SecureRandom r1 = new SecureRandom();
    L3:
        BigInteger r2 = new BigInteger(max.bitLength(), r1);
        if (r2.signum() <= 0) goto L3;
        if (r2.compareTo(max) >= 0) goto L3;
        return bigIntToByteArray(r2, r0);
    }

    static KeyPair generateRsaKeyPair(int keySize) {
        KeyPairGenerator r0 = KeyPairGenerator.getInstance("RSA");     // Catch: NoSuchAlgorithmException -> L5
        r0.initialize(keySize);     // Catch: NoSuchAlgorithmException -> L5
        return r0.generateKeyPair();
    L5:
        e = move-exception;
        throw new IllegalStateException("No support for RSA algorithm.", e);
    }
}
