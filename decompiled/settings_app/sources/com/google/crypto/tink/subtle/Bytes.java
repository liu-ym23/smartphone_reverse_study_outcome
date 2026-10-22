package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class Bytes {
    public static final boolean equal(final byte[] x, final byte[] y) {
        return MessageDigest.isEqual(x, y);
    }

    public static byte[] concat(byte[]... chunks) throws GeneralSecurityException {
        int r0 = chunks.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L9;
        byte[] r4 = chunks[r2];
        if (r3 > (Integer.MAX_VALUE - r4.length)) goto L8;
        r3 = r3 + r4.length;
        r2 = r2 + 1;
        goto L3
    L8:
        throw new GeneralSecurityException("exceeded size limit");
    L9:
        byte[] r1 = new byte[r3];
        int r5 = chunks.length;
        int r6 = 0;
        int r7 = 0;
    L10:
        if (r6 >= r5) goto L12;
        byte[] r8 = chunks[r6];
        System.arraycopy(r8, 0, r1, r7, r8.length);
        r7 = r7 + r8.length;
        r6 = r6 + 1;
        goto L10
    L12:
        return r1;
    }

    public static final byte[] xor(final byte[] x, int offsetX, final byte[] y, int offsetY, int len) {
        if (len < 0) goto L12;
        if ((x.length - len) < offsetX) goto L12;
        if ((y.length - len) < offsetY) goto L12;
        byte[] r0 = new byte[len];
        int r1 = 0;
    L8:
        if (r1 >= len) goto L10;
        r0[r1] = (byte) (x[r1 + offsetX] ^ y[r1 + offsetY]);
        r1 = r1 + 1;
        goto L8
    L10:
        return r0;
    L12:
        throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
    }

    public static final void xor(ByteBuffer output, ByteBuffer x, ByteBuffer y, int len) {
        if (len < 0) goto L14;
        if (x.remaining() < len) goto L14;
        if (y.remaining() < len) goto L14;
        if (output.remaining() < len) goto L14;
        int r0 = 0;
    L10:
        if (r0 >= len) goto L12;
        output.put((byte) (x.get() ^ y.get()));
        r0 = r0 + 1;
        goto L10
    L12:
        return;
    L14:
        throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
    }

    public static final byte[] xor(final byte[] x, final byte[] y) {
        if (x.length != y.length) goto L7;
        return xor(x, 0, y, 0, x.length);
    L7:
        throw new IllegalArgumentException("The lengths of x and y should match.");
    }

    public static final byte[] xorEnd(final byte[] a, final byte[] b) {
        if (a.length < b.length) goto L10;
        int r0 = a.length - b.length;
        byte[] r5 = Arrays.copyOf(a, a.length);
        int r1 = 0;
    L6:
        if (r1 >= b.length) goto L8;
        int r2 = r0 + r1;
        r5[r2] = (byte) (r5[r2] ^ b[r1]);
        r1 = r1 + 1;
        goto L6
    L8:
        return r5;
    L10:
        throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
    }

    public static byte[] intToByteArray(int capacity, int value) {
        byte[] r0 = new byte[capacity];
        int r1 = 0;
    L3:
        if (r1 >= capacity) goto L5;
        r0[r1] = (byte) ((value >> (r1 * 8)) & 255);
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    public static int byteArrayToInt(byte[] bytes) {
        return byteArrayToInt(bytes, bytes.length);
    }

    public static int byteArrayToInt(byte[] bytes, int length) {
        return byteArrayToInt(bytes, 0, length);
    }

    public static int byteArrayToInt(byte[] bytes, int offset, int length) {
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r0 >= length) goto L5;
        r1 = r1 + ((bytes[r0 + offset] & 255) << (r0 * 8));
        r0 = r0 + 1;
        goto L3
    L5:
        return r1;
    }

    private Bytes() {
    }
}
