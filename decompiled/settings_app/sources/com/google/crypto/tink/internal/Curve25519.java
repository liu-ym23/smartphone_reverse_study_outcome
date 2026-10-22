package com.google.crypto.tink.internal;

import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.Hex;
import java.security.InvalidKeyException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class Curve25519 {
    static final byte[][] BANNED_PUBLIC_KEYS = null;

    static {
        BANNED_PUBLIC_KEYS = new byte[][]{new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{-32, -21, 122, 124, 59, 65, -72, -82, 22, 86, -29, -6, -15, -97, -60, 106, -38, 9, -115, -21, -100, 50, -79, -3, -122, 98, 5, 22, 95, 73, -72, 0}, new byte[]{95, -100, -107, -68, -93, 80, -116, 36, -79, -48, -79, 85, -100, -125, -17, 91, 4, 68, 92, -60, 88, 28, -114, -122, -40, 34, 78, -35, -48, -97, 17, 87}, new byte[]{-20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 127}, new byte[]{-19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 127}, new byte[]{-18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 127}};
    }

    private static void monty(long[] x2, long[] z2, long[] x3, long[] z3, long[] x, long[] z, long[] xprime, long[] zprime, long[] qmqp) {
        long[] r5 = Arrays.copyOf(x, 10);
        long[] r7 = new long[19];
        long[] r8 = new long[19];
        long[] r9 = new long[19];
        long[] r10 = new long[19];
        long[] r11 = new long[19];
        long[] r12 = new long[19];
        long[] r6 = new long[19];
        Field25519.sum(x, z);
        Field25519.sub(z, r5);
        long[] r13 = Arrays.copyOf(xprime, 10);
        Field25519.sum(xprime, zprime);
        Field25519.sub(zprime, r13);
        Field25519.product(r10, xprime, z);
        Field25519.product(r11, x, zprime);
        Field25519.reduceSizeByModularReduction(r10);
        Field25519.reduceCoefficients(r10);
        Field25519.reduceSizeByModularReduction(r11);
        Field25519.reduceCoefficients(r11);
        System.arraycopy(r10, 0, r13, 0, 10);
        Field25519.sum(r10, r11);
        Field25519.sub(r11, r13);
        Field25519.square(r6, r10);
        Field25519.square(r12, r11);
        Field25519.product(r11, r12, qmqp);
        Field25519.reduceSizeByModularReduction(r11);
        Field25519.reduceCoefficients(r11);
        System.arraycopy(r6, 0, x3, 0, 10);
        System.arraycopy(r11, 0, z3, 0, 10);
        Field25519.square(r8, x);
        Field25519.square(r9, z);
        Field25519.product(x2, r8, r9);
        Field25519.reduceSizeByModularReduction(x2);
        Field25519.reduceCoefficients(x2);
        Field25519.sub(r9, r8);
        Arrays.fill(r7, 10, 18, 0);
        Field25519.scalarProduct(r7, r9, 121665);
        Field25519.reduceCoefficients(r7);
        Field25519.sum(r7, r8);
        Field25519.product(z2, r9, r7);
        Field25519.reduceSizeByModularReduction(z2);
        Field25519.reduceCoefficients(z2);
    }

    static void swapConditional(long[] a, long[] b, int iswap) {
        int r8 = -iswap;
        int r0 = 0;
    L4:
        if (r0 >= 10) goto L6;
        long r1 = a[r0];
        int r3 = (((int) r1) ^ ((int) b[r0])) & r8;
        a[r0] = ((int) r1) ^ r3;
        b[r0] = ((int) b[r0]) ^ r3;
        r0 = r0 + 1;
        goto L4
    }

    static void copyConditional(long[] a, long[] b, int icopy) {
        int r8 = -icopy;
        int r0 = 0;
    L4:
        if (r0 >= 10) goto L6;
        long r1 = a[r0];
        a[r0] = ((int) r1) ^ ((((int) r1) ^ ((int) b[r0])) & r8);
        r0 = r0 + 1;
        goto L4
    }

    public static void curveMult(long[] resultx, byte[] n, byte[] qBytes) throws InvalidKeyException {
        long[] r1 = Field25519.expand(validatePubKeyAndClearMsb(qBytes));
        long[] r3 = new long[19];
        long[] r4 = new long[19];
        int r11 = 0;
        r4[0] = 1;
        long[] r7 = new long[19];
        r7[0] = 1;
        long[] r8 = new long[19];
        long[] r9 = new long[19];
        long[] r10 = new long[19];
        r10[0] = 1;
        long[] r12 = new long[19];
        long[] r2 = new long[19];
        r2[0] = 1;
        int r13 = 10;
        System.arraycopy(r1, 0, r3, 0, 10);
        int r14 = 0;
    L4:
        if (r14 >= 32) goto L10;
        int r15 = n[(32 - r14) - 1] & 255;
        long[] r6 = r9;
        long[] r5 = r12;
        long[] r16 = r2;
        long[] r17 = r4;
        long[] r18 = r10;
        long[] r19 = r3;
        int r20 = r11;
        long[] r23 = r8;
        long[] r21 = r7;
        long[] r22 = r23;
    L7:
        if (r20 >= 8) goto L9;
        int r24 = (r15 >> (7 - r20)) & 1;
        swapConditional(r21, r19, r24);
        swapConditional(r22, r17, r24);
        long[] r110 = r18;
        long[] r111 = r5;
        int r112 = r15;
        long[] r113 = r6;
        long[] r114 = r22;
        long[] r25 = r21;
        long[] r26 = r17;
        long[] r27 = r19;
        monty(r5, r16, r6, r110, r21, r22, r19, r17, r1);
        swapConditional(r111, r113, r24);
        swapConditional(r16, r110, r24);
        r20 = r20 + 1;
        r17 = r110;
        r22 = r16;
        r21 = r111;
        r19 = r113;
        r15 = r112;
        r16 = r114;
        r5 = r25;
        r18 = r26;
        r6 = r27;
        goto L7
    L9:
        long[] r28 = r21;
        long[] r29 = r17;
        long[] r210 = r19;
        r10 = r18;
        r14 = r14 + 1;
        r2 = r16;
        r12 = r5;
        r9 = r6;
        r8 = r22;
        r7 = r28;
        r4 = r29;
        r3 = r210;
        r11 = 0;
        r13 = 10;
        goto L4
    L10:
        long[] r30 = new long[r13];
        Field25519.inverse(r30, r8);
        Field25519.mult(resultx, r7, r30);
        if (isCollinear(r1, resultx, r3, r4) == false) goto L14;
        return;
    L14:
        throw new IllegalStateException("Arithmetic error in curve multiplication with the public key: " + Hex.encode(qBytes));
    }

    private static byte[] validatePubKeyAndClearMsb(byte[] pubKey) throws InvalidKeyException {
        if (pubKey.length != 32) goto L14;
        byte[] r4 = Arrays.copyOf(pubKey, pubKey.length);
        r4[31] = (byte) (r4[31] & 127);
        int r0 = 0;
    L5:
        byte[][] r1 = BANNED_PUBLIC_KEYS;
        if (r0 >= r1.length) goto L12;
        if (Bytes.equal(r1[r0], r4) == true) goto L11;
        r0 = r0 + 1;
        goto L5
    L11:
        throw new InvalidKeyException("Banned public key: " + Hex.encode(r1[r0]));
    L12:
        return r4;
    L14:
        throw new InvalidKeyException("Public key length is not 32-byte");
    }

    private static boolean isCollinear(long[] x1, long[] x2, long[] x3, long[] z3) {
        long[] r1 = new long[10];
        long[] r2 = new long[10];
        long[] r4 = new long[11];
        long[] r5 = new long[11];
        long[] r3 = new long[11];
        Field25519.mult(r1, x1, x2);
        Field25519.sum(r2, x1, x2);
        long[] r8 = new long[10];
        r8[0] = 486662;
        Field25519.sum(r5, r2, r8);
        Field25519.mult(r5, r5, z3);
        Field25519.sum(r5, x3);
        Field25519.mult(r5, r5, r1);
        Field25519.mult(r5, r5, x3);
        Field25519.scalarProduct(r4, r5, 4);
        Field25519.reduceCoefficients(r4);
        Field25519.mult(r5, r1, z3);
        Field25519.sub(r5, r5, z3);
        Field25519.mult(r3, r2, x3);
        Field25519.sum(r5, r5, r3);
        Field25519.square(r5, r5);
        return Bytes.equal(Field25519.contract(r4), Field25519.contract(r5));
    }

    private Curve25519() {
    }
}
