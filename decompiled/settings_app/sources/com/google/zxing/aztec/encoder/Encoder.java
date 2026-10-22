package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

/* JADX INFO: loaded from: classes4.dex */
public final class Encoder {
    public static final int DEFAULT_AZTEC_LAYERS = 0;
    public static final int DEFAULT_EC_PERCENT = 33;
    private static final int MAX_NB_BITS = 32;
    private static final int MAX_NB_BITS_COMPACT = 4;
    private static final int[] WORD_SIZE = null;

    private static int totalBitsInLayer(int r1, boolean r2) {
        if (r2 == false) goto L4;
        int r3 = 88;
    L6:
        return (r3 + (r1 << 4)) * r1;
    L4:
        r3 = 112;
        goto L6
    }

    static {
        WORD_SIZE = new int[]{4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};
    }

    private Encoder() {
    }

    public static AztecCode encode(byte[] r2) {
        return encode(r2, 33, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static AztecCode encode(byte[] r19, int r20, int r21) {
        BitArray r0 = new HighLevelEncoder(r19).encode();
        int r2 = 11;
        int r1 = ((r0.getSize() * r20) / 100) + 11;
        int r3 = r0.getSize() + r1;
        int r4 = 32;
        int r5 = 0;
        int r6 = 1;
        if (r21 == 0) goto L23;
        if (r21 >= 0) goto L6;
        boolean r7 = true;
    L7:
        int r8 = Math.abs(r21);
        if (r7 == false) goto L10;
        r4 = 4;
    L10:
        if (r8 > r4) goto L22;
        int r9 = totalBitsInLayer(r8, r7);
        int r10 = WORD_SIZE[r8];
        int r11 = r9 - (r9 % r10);
        BitArray r12 = stuffBits(r0, r10);
        boolean r13 = r7;
        if ((r12.getSize() + r1) > r11) goto L20;
        if (r7 == false) goto L46;
        r13 = r7;
        if (r12.getSize() <= (r10 << 6)) goto L46;
        throw new IllegalArgumentException("Data to large for user specified layer");
    L46:
        BitArray r14 = generateCheckWords(r12, r9, r10);
        int r15 = r12.getSize() / r10;
        BitArray r16 = generateModeMessage(r13, r8, r15);
        if (r13 == true) goto L50;
        r2 = 14;
    L50:
        int r17 = r2 + (r8 << 2);
        int[] r18 = new int[r17];
        int r22 = 2;
        if (r13 == false) goto L56;
        int r110 = r5;
    L53:
        if (r110 >= r17) goto L55;
        r18[r110] = r110;
        r110 = r110 + 1;
        goto L53
    L55:
        int r111 = r17;
    L59:
        BitMatrix r112 = new BitMatrix(r111);
        int r113 = r5;
        int r114 = r113;
    L60:
        if (r113 >= r8) goto L84;
        int r115 = (r8 - r113) << r22;
        if (r13 == false) goto L64;
        int r116 = 9;
    L65:
        int r117 = r115 + r116;
        int r118 = r5;
    L66:
        if (r118 >= r117) goto L83;
        int r119 = r118 << 1;
    L68:
        if (r5 >= r22) goto L82;
        if (r14.get((r114 + r119) + r5) == false) goto L73;
        int r23 = r113 << 1;
        r112.set(r18[r23 + r5], r18[r23 + r118]);
    L73:
        if (r14.get((((r117 << 1) + r114) + r119) + r5) == false) goto L76;
        int r24 = r113 << 1;
        r112.set(r18[r24 + r118], r18[((r17 - 1) - r24) - r5]);
    L76:
        if (r14.get((((r117 << 2) + r114) + r119) + r5) == false) goto L79;
        int r25 = (r17 - 1) - (r113 << 1);
        r112.set(r18[r25 - r5], r18[r25 - r118]);
    L79:
        if (r14.get((((r117 * 6) + r114) + r119) + r5) == false) goto L81;
        int r26 = r113 << 1;
        r112.set(r18[((r17 - 1) - r26) - r118], r18[r26 + r5]);
    L81:
        r5 = r5 + 1;
        r22 = 2;
        goto L68
    L82:
        r118 = r118 + 1;
        r5 = 0;
        r22 = 2;
        goto L66
    L83:
        r114 = r114 + (r117 << 3);
        r113 = r113 + 1;
        r5 = 0;
        r22 = 2;
        goto L60
    L64:
        r116 = 12;
        goto L65
    L84:
        drawModeMessage(r112, r13, r111, r16);
        if (r13 == false) goto L87;
        drawBullsEye(r112, r111 / 2, 5);
    L94:
        AztecCode r27 = new AztecCode();
        r27.setCompact(r13);
        r27.setSize(r111);
        r27.setLayers(r8);
        r27.setCodeWords(r15);
        r27.setMatrix(r112);
        return r27;
    L87:
        int r28 = r111 / 2;
        drawBullsEye(r112, r28, 7);
        int r29 = 0;
        int r30 = 0;
    L89:
        if (r30 >= ((r17 / 2) - 1)) goto L94;
        int r31 = r28 & 1;
    L91:
        if (r31 >= r111) goto L93;
        int r32 = r28 - r29;
        r112.set(r32, r31);
        int r120 = r28 + r29;
        r112.set(r120, r31);
        r112.set(r31, r32);
        r112.set(r31, r120);
        r31 = r31 + 2;
        goto L91
    L93:
        r30 = r30 + 15;
        r29 = r29 + 16;
        goto L89
    L56:
        int r121 = r17 / 2;
        r111 = (r17 + 1) + (((r121 - 1) / 15) * 2);
        int r122 = r111 / 2;
        int r123 = r5;
    L57:
        if (r123 >= r121) goto L59;
        int r124 = (r123 / 15) + r123;
        r18[(r121 - r123) - r6] = (r122 - r124) - 1;
        r18[r121 + r123] = (r124 + r122) + r6;
        r123 = r123 + 1;
        goto L57
    L20:
        throw new IllegalArgumentException("Data to large for user specified layer");
    L22:
        throw new IllegalArgumentException(String.format("Illegal value %s for layers", new Object[]{Integer.valueOf(r21)}));
    L6:
        r7 = false;
        goto L7
    L23:
        BitArray r33 = null;
        int r34 = 0;
        int r35 = 0;
    L24:
        if (r34 > 32) goto L98;
        if (r34 > 3) goto L28;
        boolean r125 = r6;
    L29:
        if (r125 == 0) goto L31;
        int r126 = r34 + 1;
    L32:
        int r127 = totalBitsInLayer(r126, r125);
        if (r3 > r127) goto L96;
        if (r33 != null) goto L36;
    L37:
        int r36 = WORD_SIZE[r126];
        r35 = r36;
        r33 = stuffBits(r0, r36);
    L38:
        int r128 = r127 - (r127 % r35);
        if (r125 == 0) goto L43;
        if (r33.getSize() > (r35 << 6)) goto L96;
    L43:
        if ((r33.getSize() + r1) > r128) goto L96;
        r12 = r33;
        r10 = r35;
        r13 = r125;
        r8 = r126;
        r9 = r127;
        goto L46
    L36:
        if (r35 == WORD_SIZE[r126]) goto L38;
    L96:
        r34 = r34 + 1;
        r6 = r6;
        r5 = 0;
        goto L24
    L31:
        r126 = r34;
        goto L32
    L28:
        r125 = r5;
        goto L29
    L98:
        throw new IllegalArgumentException("Data too large for an Aztec code");
    }

    private static void drawBullsEye(BitMatrix r4, int r5, int r6) {
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L9;
        int r1 = r5 - r0;
        int r2 = r1;
    L5:
        int r3 = r5 + r0;
        if (r2 > r3) goto L8;
        r4.set(r2, r1);
        r4.set(r2, r3);
        r4.set(r1, r2);
        r4.set(r3, r2);
        r2 = r2 + 1;
        goto L5
    L8:
        r0 = r0 + 2;
        goto L3
    L9:
        int r7 = r5 - r6;
        r4.set(r7, r7);
        int r8 = r7 + 1;
        r4.set(r8, r7);
        r4.set(r7, r8);
        int r9 = r5 + r6;
        r4.set(r9, r7);
        r4.set(r9, r8);
        r4.set(r9, r9 - 1);
    }

    static BitArray generateModeMessage(boolean r2, int r3, int r4) {
        BitArray r0 = new BitArray();
        if (r2 == false) goto L5;
        r0.appendBits(r3 - 1, 2);
        r0.appendBits(r4 - 1, 6);
        return generateCheckWords(r0, 28, 4);
    L5:
        r0.appendBits(r3 - 1, 5);
        r0.appendBits(r4 - 1, 11);
        return generateCheckWords(r0, 40, 4);
    }

    private static void drawModeMessage(BitMatrix r2, boolean r3, int r4, BitArray r5) {
        int r6 = r4 / 2;
        int r0 = 0;
        if (r3 == false) goto L21;
    L5:
        if (r0 >= 7) goto L19;
        int r7 = (r6 - 3) + r0;
        if (r5.get(r0) == false) goto L10;
        r2.set(r7, r6 - 5);
    L10:
        if (r5.get(r0 + 7) == false) goto L13;
        r2.set(r6 + 5, r7);
    L13:
        if (r5.get(20 - r0) == false) goto L16;
        r2.set(r7, r6 + 5);
    L16:
        if (r5.get(27 - r0) == false) goto L18;
        r2.set(r6 - 5, r7);
    L18:
        r0 = r0 + 1;
        goto L5
    L19:
        return;
    L21:
        if (r0 >= 10) goto L35;
        int r8 = ((r6 - 5) + r0) + (r0 / 5);
        if (r5.get(r0) == false) goto L26;
        r2.set(r8, r6 - 7);
    L26:
        if (r5.get(r0 + 10) == false) goto L29;
        r2.set(r6 + 7, r8);
    L29:
        if (r5.get(29 - r0) == false) goto L32;
        r2.set(r8, r6 + 7);
    L32:
        if (r5.get(39 - r0) == false) goto L34;
        r2.set(r6 - 7, r8);
    L34:
        r0 = r0 + 1;
        goto L21
    }

    private static BitArray generateCheckWords(BitArray r3, int r4, int r5) {
        int r0 = r3.getSize() / r5;
        ReedSolomonEncoder r1 = new ReedSolomonEncoder(getGF(r5));
        int r2 = r4 / r5;
        int[] r6 = bitsToWords(r3, r5, r2);
        r1.encode(r6, r2 - r0);
        BitArray r7 = new BitArray();
        int r8 = 0;
        r7.appendBits(0, r4 % r5);
        int r9 = r6.length;
    L3:
        if (r8 >= r9) goto L5;
        r7.appendBits(r6[r8], r5);
        r8 = r8 + 1;
        goto L3
    L5:
        return r7;
    }

    private static int[] bitsToWords(BitArray r7, int r8, int r9) {
        int[] r10 = new int[r9];
        int r0 = r7.getSize() / r8;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        int r3 = 0;
        int r4 = 0;
    L5:
        if (r3 >= r8) goto L11;
        if (r7.get((r2 * r8) + r3) == false) goto L9;
        int r5 = 1 << ((r8 - r3) - 1);
    L10:
        r4 = r4 | r5;
        r3 = r3 + 1;
        goto L5
    L9:
        r5 = 0;
        goto L10
    L11:
        r10[r2] = r4;
        r2 = r2 + 1;
        goto L3
    L12:
        return r10;
    }

    private static GenericGF getGF(int r2) {
        if (r2 == 4) goto L23;
        if (r2 == 6) goto L21;
        if (r2 == 8) goto L19;
        if (r2 == 10) goto L17;
        if (r2 != 12) goto L15;
        return GenericGF.AZTEC_DATA_12;
    L15:
        throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(r2)));
    L17:
        return GenericGF.AZTEC_DATA_10;
    L19:
        return GenericGF.AZTEC_DATA_8;
    L21:
        return GenericGF.AZTEC_DATA_6;
    L23:
        return GenericGF.AZTEC_PARAM;
    }

    static BitArray stuffBits(BitArray r9, int r10) {
        BitArray r0 = new BitArray();
        int r1 = r9.getSize();
        int r3 = (1 << r10) - 2;
        int r5 = 0;
    L3:
        if (r5 >= r1) goto L20;
        int r6 = 0;
        int r7 = 0;
    L5:
        if (r6 >= r10) goto L12;
        int r8 = r5 + r6;
        if (r8 < r1) goto L9;
    L10:
        r7 = r7 | (1 << ((r10 - 1) - r6));
    L11:
        r6 = r6 + 1;
        goto L5
    L9:
        if (r9.get(r8) == false) goto L11;
    L12:
        int r11 = r7 & r3;
        if (r11 != r3) goto L16;
        r0.appendBits(r11, r10);
    L15:
        r5 = r5 - 1;
    L19:
        r5 = r5 + r10;
        goto L3
    L16:
        if (r11 != 0) goto L18;
        r0.appendBits(r7 | 1, r10);
        goto L15
    L18:
        r0.appendBits(r7, r10);
        goto L19
    L20:
        return r0;
    }
}
