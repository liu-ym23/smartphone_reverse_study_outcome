package com.google.crypto.tink.internal;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class BigIntegerEncoding {
    public static byte[] toBigEndianBytes(BigInteger n) {
        if (n.signum() == (-1)) goto L7;
        return n.toByteArray();
    L7:
        throw new IllegalArgumentException("n must not be negative");
    }

    public static byte[] toUnsignedBigEndianBytes(BigInteger n) {
        if (n.signum() == (-1)) goto L9;
        byte[] r2 = n.toByteArray();
        if (r2[0] == 0) goto L7;
        return r2;
    L7:
        return Arrays.copyOfRange(r2, 1, r2.length);
    L9:
        throw new IllegalArgumentException("n must not be negative");
    }

    public static byte[] toBigEndianBytesOfFixedLength(BigInteger n, int length) throws GeneralSecurityException {
        if (n.signum() == (-1)) goto L22;
        byte[] r4 = n.toByteArray();
        if (r4.length != length) goto L7;
        return r4;
    L7:
        int r1 = length + 1;
        if (r4.length > r1) goto L20;
        if (r4.length == r1) goto L12;
        byte[] r0 = new byte[length];
        System.arraycopy(r4, 0, r0, length - r4.length, r4.length);
        return r0;
    L12:
        if (r4[0] != 0) goto L16;
        return Arrays.copyOfRange(r4, 1, r4.length);
    L16:
        throw new GeneralSecurityException("integer too large");
    L20:
        throw new GeneralSecurityException("integer too large");
    L22:
        throw new IllegalArgumentException("integer must be nonnegative");
    }

    public static BigInteger fromUnsignedBigEndianBytes(byte[] bytes) {
        return new BigInteger(1, bytes);
    }

    private BigIntegerEncoding() {
    }
}
