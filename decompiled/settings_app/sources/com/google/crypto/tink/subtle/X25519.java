package com.google.crypto.tink.subtle;

import com.google.common.primitives.SignedBytes;
import com.google.crypto.tink.internal.Curve25519;
import com.google.crypto.tink.internal.Field25519;
import java.security.InvalidKeyException;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: loaded from: classes4.dex */
public final class X25519 {
    public static byte[] generatePrivateKey() {
        byte[] r0 = Random.randBytes(32);
        r0[0] = (byte) (r0[0] | 7);
        byte r2 = (byte) (r0[31] & Utf8.REPLACEMENT_BYTE);
        r0[31] = r2;
        r0[31] = (byte) (r2 | 128);
        return r0;
    }

    public static byte[] computeSharedSecret(byte[] privateKey, byte[] peersPublicValue) throws InvalidKeyException {
        if (privateKey.length != 32) goto L7;
        long[] r0 = new long[11];
        byte[] r3 = Arrays.copyOf(privateKey, 32);
        r3[0] = (byte) (r3[0] & 248);
        byte r2 = (byte) (r3[31] & 127);
        r3[31] = r2;
        r3[31] = (byte) (r2 | SignedBytes.MAX_POWER_OF_TWO);
        Curve25519.curveMult(r0, r3, peersPublicValue);
        return Field25519.contract(r0);
    L7:
        throw new InvalidKeyException("Private key must have 32 bytes.");
    }

    public static byte[] publicFromPrivate(byte[] privateKey) throws InvalidKeyException {
        if (privateKey.length != 32) goto L7;
        byte[] r0 = new byte[32];
        r0[0] = 9;
        return computeSharedSecret(privateKey, r0);
    L7:
        throw new InvalidKeyException("Private key must have 32 bytes.");
    }

    private X25519() {
    }
}
