package com.google.crypto.tink.aead.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
final class ChaCha20Util {
    static final int BLOCK_SIZE_IN_BYTES = 64;
    static final int BLOCK_SIZE_IN_INTS = 16;
    static final int KEY_SIZE_IN_BYTES = 32;
    static final int KEY_SIZE_IN_INTS = 8;
    private static final int[] SIGMA = null;

    private static int rotateLeft(int x, int y) {
        int r0 = x << y;
        return (x >>> (-y)) | r0;
    }

    static {
        SIGMA = toIntArray(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});
    }

    static void setSigmaAndKey(int[] state, final int[] key) {
        int[] r0 = SIGMA;
        System.arraycopy(r0, 0, state, 0, r0.length);
        System.arraycopy(key, 0, state, r0.length, 8);
    }

    static void shuffleState(final int[] state) {
        int r2 = 0;
    L4:
        if (r2 >= 10) goto L6;
        quarterRound(state, 0, 4, 8, 12);
        quarterRound(state, 1, 5, 9, 13);
        quarterRound(state, 2, 6, 10, 14);
        quarterRound(state, 3, 7, 11, 15);
        quarterRound(state, 0, 5, 10, 15);
        quarterRound(state, 1, 6, 11, 12);
        quarterRound(state, 2, 7, 8, 13);
        quarterRound(state, 3, 4, 9, 14);
        r2 = r2 + 1;
        goto L4
    }

    static void quarterRound(int[] x, int a, int b, int c, int d) {
        int r0 = x[a] + x[b];
        x[a] = r0;
        int r1 = rotateLeft(r0 ^ x[d], 16);
        x[d] = r1;
        int r2 = x[c] + r1;
        x[c] = r2;
        int r3 = rotateLeft(x[b] ^ r2, 12);
        x[b] = r3;
        int r4 = x[a] + r3;
        x[a] = r4;
        int r5 = rotateLeft(x[d] ^ r4, 8);
        x[d] = r5;
        int r6 = x[c] + r5;
        x[c] = r6;
        x[b] = rotateLeft(x[b] ^ r6, 7);
    }

    static int[] toIntArray(final byte[] input) {
        if ((input.length % 4) != 0) goto L7;
        IntBuffer r1 = ByteBuffer.wrap(input).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] r0 = new int[r1.remaining()];
        r1.get(r0);
        return r0;
    L7:
        throw new IllegalArgumentException("invalid input length");
    }

    static byte[] toByteArray(final int[] input) {
        ByteBuffer r0 = ByteBuffer.allocate(input.length * 4).order(ByteOrder.LITTLE_ENDIAN);
        r0.asIntBuffer().put(input);
        return r0.array();
    }

    static int[] hChaCha20(final int[] key, final int[] nonce) {
        int[] r0 = new int[16];
        setSigmaAndKey(r0, key);
        r0[12] = nonce[0];
        r0[13] = nonce[1];
        r0[14] = nonce[2];
        r0[15] = nonce[3];
        shuffleState(r0);
        r0[4] = r0[12];
        r0[5] = r0[13];
        r0[6] = r0[14];
        r0[7] = r0[15];
        return Arrays.copyOf(r0, 8);
    }

    static byte[] hChaCha20(final byte[] key, final byte[] nonce) {
        return toByteArray(hChaCha20(toIntArray(key), toIntArray(nonce)));
    }

    private ChaCha20Util() {
    }
}
