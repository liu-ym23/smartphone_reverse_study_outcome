package com.google.crypto.tink.internal;

import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class Field25519 {
    private static final int[] EXPAND_SHIFT = null;
    private static final int[] EXPAND_START = null;
    public static final int FIELD_LEN = 32;
    public static final int LIMB_CNT = 10;
    private static final int[] MASK = null;
    private static final int[] SHIFT = null;
    private static final long TWO_TO_25 = 33554432;
    private static final long TWO_TO_26 = 67108864;

    private static int eq(int a, int b) {
        int r0 = ~(a ^ b);
        int r1 = r0 & (r0 << 16);
        int r2 = r1 & (r1 << 8);
        int r3 = r2 & (r2 << 4);
        int r4 = r3 & (r3 << 2);
        return (r4 & (r4 << 1)) >> 31;
    }

    private static int gte(int a, int b) {
        return ~((a - b) >> 31);
    }

    static {
        EXPAND_START = new int[]{0, 3, 6, 9, 12, 16, 19, 22, 25, 28};
        EXPAND_SHIFT = new int[]{0, 2, 3, 5, 6, 0, 1, 3, 4, 6};
        MASK = new int[]{67108863, 33554431};
        SHIFT = new int[]{26, 25};
    }

    static void sum(long[] output, long[] in1, long[] in2) {
        int r0 = 0;
    L4:
        if (r0 >= 10) goto L6;
        output[r0] = in1[r0] + in2[r0];
        r0 = r0 + 1;
        goto L4
    }

    static void sum(long[] output, long[] in) {
        sum(output, output, in);
    }

    static void sub(long[] output, long[] in1, long[] in2) {
        int r0 = 0;
    L4:
        if (r0 >= 10) goto L6;
        output[r0] = in1[r0] - in2[r0];
        r0 = r0 + 1;
        goto L4
    }

    static void sub(long[] output, long[] in) {
        sub(output, in, output);
    }

    static void scalarProduct(long[] output, long[] in, long scalar) {
        int r0 = 0;
    L4:
        if (r0 >= 10) goto L6;
        output[r0] = in[r0] * scalar;
        r0 = r0 + 1;
        goto L4
    }

    static void product(long[] out, long[] in2, long[] in) {
        out[0] = in2[0] * in[0];
        long r1 = in2[0];
        long r4 = in[1] * r1;
        long r6 = in2[1];
        long r8 = in[0];
        out[1] = r4 + (r6 * r8);
        long r5 = in2[1];
        long r12 = in[1];
        out[2] = (((r5 * 2) * r12) + (in[2] * r1)) + (in2[2] * r8);
        long r10 = in[2];
        long r16 = in2[2];
        out[3] = (((r5 * r10) + (r16 * r12)) + (in[3] * r1)) + (in2[3] * r8);
        long r18 = in[3];
        long r22 = in2[3];
        out[4] = (((r16 * r10) + (((r5 * r18) + (r22 * r12)) * 2)) + (in[4] * r1)) + (in2[4] * r8);
        long r14 = (r16 * r18) + (r22 * r10);
        long r20 = in[4];
        long r15 = r14 + (r5 * r20);
        long r24 = in2[4];
        out[5] = ((r15 + (r24 * r12)) + (in[5] * r1)) + (in2[5] * r8);
        long r26 = in[5];
        long r17 = (r22 * r18) + (r5 * r26);
        long r28 = in2[5];
        out[6] = (((((r17 + (r28 * r12)) * 2) + (r16 * r20)) + (r24 * r10)) + (in[6] * r1)) + (in2[6] * r8);
        long r19 = (((r22 * r20) + (r24 * r18)) + (r16 * r26)) + (r28 * r10);
        long r30 = in[6];
        long r110 = r19 + (r5 * r30);
        long r32 = in2[6];
        out[7] = ((r110 + (r32 * r12)) + (in[7] * r1)) + (in2[7] * r8);
        long r34 = (r22 * r26) + (r28 * r18);
        long r36 = in[7];
        long r35 = r34 + (r5 * r36);
        long r38 = in2[7];
        out[8] = (((((r24 * r20) + ((r35 + (r38 * r12)) * 2)) + (r16 * r30)) + (r32 * r10)) + (in[8] * r1)) + (in2[8] * r8);
        long r111 = (((((r24 * r26) + (r28 * r20)) + (r22 * r30)) + (r32 * r18)) + (r16 * r36)) + (r38 * r10);
        long r37 = in[8];
        long r112 = r111 + (r5 * r37);
        long r40 = in2[8];
        out[9] = ((r112 + (r40 * r12)) + (r1 * in[9])) + (in2[9] * r8);
        long r2 = ((r28 * r26) + (r22 * r36)) + (r38 * r18);
        long r9 = in[9];
        long r3 = in2[9];
        out[10] = ((((((r2 + (r5 * r9)) + (r12 * r3)) * 2) + (r24 * r30)) + (r32 * r20)) + (r16 * r37)) + (r40 * r10);
        out[11] = (((((((r28 * r30) + (r32 * r26)) + (r24 * r36)) + (r38 * r20)) + (r22 * r37)) + (r40 * r18)) + (r16 * r9)) + (r10 * r3);
        out[12] = (((r32 * r30) + (((((r28 * r36) + (r38 * r26)) + (r22 * r9)) + (r18 * r3)) * 2)) + (r24 * r37)) + (r40 * r20);
        out[13] = (((((r32 * r36) + (r38 * r30)) + (r28 * r37)) + (r40 * r26)) + (r24 * r9)) + (r20 * r3);
        out[14] = (((((r38 * r36) + (r28 * r9)) + (r26 * r3)) * 2) + (r32 * r37)) + (r40 * r30);
        out[15] = (((r38 * r37) + (r40 * r36)) + (r32 * r9)) + (r30 * r3);
        out[16] = (r40 * r37) + (((r38 * r9) + (r36 * r3)) * 2);
        out[17] = (r40 * r9) + (r37 * r3);
        out[18] = (r3 * 2) * r9;
    }

    static void reduce(long[] input, long[] output) {
        if (input.length == 19) goto L6;
        long[] r0 = new long[19];
        System.arraycopy(input, 0, r0, 0, input.length);
        input = r0;
    L6:
        reduceSizeByModularReduction(input);
        reduceCoefficients(input);
        System.arraycopy(input, 0, output, 0, 10);
    }

    static void reduceSizeByModularReduction(long[] output) {
        long r1 = output[8];
        long r3 = output[18];
        long r2 = r1 + (r3 << 4);
        output[8] = r2;
        long r4 = r2 + (r3 << 1);
        output[8] = r4;
        output[8] = r4 + r3;
        long r5 = output[7];
        long r6 = output[17];
        long r7 = r5 + (r6 << 4);
        output[7] = r7;
        long r8 = r7 + (r6 << 1);
        output[7] = r8;
        output[7] = r8 + r6;
        long r9 = output[6];
        long r10 = output[16];
        long r11 = r9 + (r10 << 4);
        output[6] = r11;
        long r12 = r11 + (r10 << 1);
        output[6] = r12;
        output[6] = r12 + r10;
        long r13 = output[5];
        long r14 = output[15];
        long r15 = r13 + (r14 << 4);
        output[5] = r15;
        long r16 = r15 + (r14 << 1);
        output[5] = r16;
        output[5] = r16 + r14;
        long r0 = output[4];
        long r17 = output[14];
        long r18 = r0 + (r17 << 4);
        output[4] = r18;
        long r19 = r18 + (r17 << 1);
        output[4] = r19;
        output[4] = r19 + r17;
        long r20 = output[3];
        long r21 = output[13];
        long r22 = r20 + (r21 << 4);
        output[3] = r22;
        long r23 = r22 + (r21 << 1);
        output[3] = r23;
        output[3] = r23 + r21;
        long r24 = output[2];
        long r25 = output[12];
        long r26 = r24 + (r25 << 4);
        output[2] = r26;
        long r27 = r26 + (r25 << 1);
        output[2] = r27;
        output[2] = r27 + r25;
        long r28 = output[1];
        long r29 = output[11];
        long r30 = r28 + (r29 << 4);
        output[1] = r30;
        long r31 = r30 + (r29 << 1);
        output[1] = r31;
        output[1] = r31 + r29;
        long r32 = output[0];
        long r33 = output[10];
        long r34 = r32 + (r33 << 4);
        output[0] = r34;
        long r35 = r34 + (r33 << 1);
        output[0] = r35;
        output[0] = r35 + r33;
    }

    static void reduceCoefficients(long[] output) {
        output[10] = 0;
        int r4 = 0;
    L4:
        if (r4 >= 10) goto L6;
        long r8 = output[r4];
        long r6 = r8 / 67108864;
        output[r4] = r8 - (r6 << 26);
        int r5 = r4 + 1;
        long r9 = output[r5] + r6;
        output[r5] = r9;
        long r7 = r9 / 33554432;
        output[r5] = r9 - (r7 << 25);
        r4 = r4 + 2;
        output[r4] = output[r4] + r7;
        goto L4
    L6:
        long r10 = output[0];
        long r11 = output[10];
        long r12 = r10 + (r11 << 4);
        output[0] = r12;
        long r13 = r12 + (r11 << 1);
        output[0] = r13;
        long r14 = r13 + r11;
        output[0] = r14;
        output[10] = 0;
        long r0 = r14 / 67108864;
        output[0] = r14 - (r0 << 26);
        output[1] = output[1] + r0;
    }

    static void mult(long[] output, long[] in, long[] in2) {
        long[] r0 = new long[19];
        product(r0, in, in2);
        reduce(r0, output);
    }

    private static void squareInner(long[] out, long[] in) {
        long r1 = in[0];
        out[0] = r1 * r1;
        long r0 = in[0];
        out[1] = (r0 * 2) * in[1];
        long r4 = in[1];
        out[2] = ((r4 * r4) + (in[2] * r0)) * 2;
        long r6 = in[2];
        out[3] = ((r4 * r6) + (in[3] * r0)) * 2;
        long r15 = in[3];
        out[4] = ((r6 * r6) + ((r4 * 4) * r15)) + ((r0 * 2) * in[4]);
        long r13 = in[4];
        out[5] = (((r6 * r15) + (r4 * r13)) + (in[5] * r0)) * 2;
        long r8 = ((r15 * r15) + (r6 * r13)) + (in[6] * r0);
        long r20 = in[5];
        out[6] = (r8 + ((r4 * 2) * r20)) * 2;
        long r17 = in[6];
        out[7] = ((((r15 * r13) + (r6 * r20)) + (r4 * r17)) + (in[7] * r0)) * 2;
        long r22 = (r6 * r17) + (in[8] * r0);
        long r24 = in[7];
        out[8] = (r13 * r13) + ((r22 + (((r4 * r24) + (r15 * r20)) * 2)) * 2);
        long r9 = ((r13 * r20) + (r15 * r17)) + (r6 * r24);
        long r23 = in[8];
        out[9] = ((r9 + (r4 * r23)) + (r0 * in[9])) * 2;
        long r26 = in[9];
        out[10] = ((((r20 * r20) + (r13 * r17)) + (r6 * r23)) + (((r15 * r24) + (r4 * r26)) * 2)) * 2;
        out[11] = ((((r20 * r17) + (r13 * r24)) + (r15 * r23)) + (r6 * r26)) * 2;
        out[12] = (r17 * r17) + (((r13 * r23) + (((r20 * r24) + (r15 * r26)) * 2)) * 2);
        out[13] = (((r17 * r24) + (r20 * r23)) + (r13 * r26)) * 2;
        out[14] = (((r24 * r24) + (r17 * r23)) + ((r20 * 2) * r26)) * 2;
        out[15] = ((r24 * r23) + (r17 * r26)) * 2;
        out[16] = (r23 * r23) + ((r24 * 4) * r26);
        out[17] = (r23 * 2) * r26;
        out[18] = (2 * r26) * r26;
    }

    static void square(long[] output, long[] in) {
        long[] r0 = new long[19];
        squareInner(r0, in);
        reduce(r0, output);
    }

    static long[] expand(byte[] input) {
        long[] r1 = new long[10];
        int r2 = 0;
    L3:
        if (r2 >= 10) goto L5;
        int r3 = EXPAND_START[r2];
        r1[r2] = ((((((long) (input[r3] & 255)) | (((long) (input[r3 + 1] & 255)) << 8)) | (((long) (input[r3 + 2] & 255)) << 16)) | (((long) (input[r3 + 3] & 255)) << 24)) >> EXPAND_SHIFT[r2]) & ((long) MASK[r2 & 1]);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public static byte[] contract(long[] inputLimbs) {
        long[] r1 = Arrays.copyOf(inputLimbs, 10);
        int r2 = 0;
        int r3 = 0;
    L3:
        int r8 = 2;
        if (r3 >= 2) goto L9;
        int r9 = 0;
    L6:
        if (r9 >= 9) goto L8;
        long r10 = r1[r9];
        int r14 = SHIFT[r9 & 1];
        int r12 = -((int) (((r10 >> 31) & r10) >> r14));
        r1[r9] = r10 + ((long) (r12 << r14));
        r9 = r9 + 1;
        r1[r9] = r1[r9] - ((long) r12);
        goto L6
    L8:
        long r11 = r1[9];
        int r6 = -((int) (((r11 >> 31) & r11) >> 25));
        r1[9] = r11 + ((long) (r6 << 25));
        r1[0] = r1[0] - (((long) r6) * 19);
        r3 = r3 + 1;
        goto L3
    L9:
        long r13 = r1[0];
        int r4 = -((int) (((r13 >> 31) & r13) >> 26));
        r1[0] = r13 + ((long) (r4 << 26));
        r1[1] = r1[1] - ((long) r4);
        int r5 = 0;
    L10:
        if (r5 >= r8) goto L15;
        int r15 = 0;
    L12:
        if (r15 >= 9) goto L14;
        long r16 = r1[r15];
        int r17 = r15 & 1;
        int r7 = (int) (r16 >> SHIFT[r17]);
        r1[r15] = r16 & ((long) MASK[r17]);
        r15 = r15 + 1;
        r1[r15] = r1[r15] + ((long) r7);
        goto L12
    L14:
        r5 = r5 + 1;
        r8 = 2;
        goto L10
    L15:
        long r18 = r1[9];
        r1[9] = r18 & 33554431;
        long r19 = r1[0] + (((long) ((int) (r18 >> 25))) * 19);
        r1[0] = r19;
        int r20 = gte((int) r19, 67108845);
        int r21 = 1;
    L16:
        if (r21 >= 10) goto L18;
        r20 = r20 & eq((int) r1[r21], MASK[r21 & 1]);
        r21 = r21 + 1;
        goto L16
    L18:
        r1[0] = r1[0] - ((long) (67108845 & r20));
        long r22 = 33554431 & r20;
        r1[1] = r1[1] - r22;
        int r23 = 2;
    L19:
        if (r23 >= 10) goto L21;
        r1[r23] = r1[r23] - ((long) (67108863 & r20));
        int r24 = r23 + 1;
        r1[r24] = r1[r24] - r22;
        r23 = r23 + 2;
        goto L19
    L21:
        int r25 = 0;
    L22:
        if (r25 >= 10) goto L24;
        r1[r25] = r1[r25] << EXPAND_SHIFT[r25];
        r25 = r25 + 1;
        goto L22
    L24:
        byte[] r26 = new byte[32];
    L25:
        if (r2 >= 10) goto L27;
        int r27 = EXPAND_START[r2];
        long r28 = r26[r27];
        long r29 = r1[r2];
        r26[r27] = (byte) (r28 | (r29 & 255));
        int r30 = r27 + 1;
        r26[r30] = (byte) (((long) r26[r30]) | ((r29 >> 8) & 255));
        int r31 = r27 + 2;
        r26[r31] = (byte) (((long) r26[r31]) | ((r29 >> 16) & 255));
        int r32 = r27 + 3;
        r26[r32] = (byte) (((long) r26[r32]) | ((r29 >> 24) & 255));
        r2 = r2 + 1;
        goto L25
    L27:
        return r26;
    }

    static void inverse(long[] out, long[] z) {
        long[] r1 = new long[10];
        long[] r2 = new long[10];
        long[] r3 = new long[10];
        long[] r4 = new long[10];
        long[] r5 = new long[10];
        long[] r6 = new long[10];
        long[] r7 = new long[10];
        long[] r8 = new long[10];
        long[] r9 = new long[10];
        long[] r10 = new long[10];
        square(r1, z);
        square(r10, r1);
        square(r9, r10);
        mult(r2, r9, z);
        mult(r3, r2, r1);
        square(r9, r3);
        mult(r4, r9, r2);
        square(r9, r4);
        square(r10, r9);
        square(r9, r10);
        square(r10, r9);
        square(r9, r10);
        mult(r5, r9, r4);
        square(r9, r5);
        square(r10, r9);
        int r12 = 2;
        int r11 = 2;
    L3:
        if (r11 >= 10) goto L5;
        square(r9, r10);
        square(r10, r9);
        r11 = r11 + 2;
        goto L3
    L5:
        mult(r6, r10, r5);
        square(r9, r6);
        square(r10, r9);
        int r13 = 2;
    L7:
        if (r13 >= 20) goto L9;
        square(r9, r10);
        square(r10, r9);
        r13 = r13 + 2;
        goto L7
    L9:
        mult(r9, r10, r6);
        square(r10, r9);
        square(r9, r10);
        int r14 = 2;
    L10:
        if (r14 >= 10) goto L12;
        square(r10, r9);
        square(r9, r10);
        r14 = r14 + 2;
        goto L10
    L12:
        mult(r7, r9, r5);
        square(r9, r7);
        square(r10, r9);
        int r0 = 2;
    L14:
        if (r0 >= 50) goto L16;
        square(r9, r10);
        square(r10, r9);
        r0 = r0 + 2;
        goto L14
    L16:
        mult(r8, r10, r7);
        square(r10, r8);
        square(r9, r10);
        int r15 = 2;
    L18:
        if (r15 >= 100) goto L20;
        square(r10, r9);
        square(r9, r10);
        r15 = r15 + 2;
        goto L18
    L20:
        mult(r10, r9, r8);
        square(r9, r10);
        square(r10, r9);
    L21:
        if (r12 >= 50) goto L23;
        square(r9, r10);
        square(r10, r9);
        r12 = r12 + 2;
        goto L21
    L23:
        mult(r9, r10, r7);
        square(r10, r9);
        square(r9, r10);
        square(r10, r9);
        square(r9, r10);
        square(r10, r9);
        mult(out, r10, r3);
    }

    private Field25519() {
    }
}
