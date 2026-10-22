package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class Code128Reader extends OneDReader {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    static final int[][] CODE_PATTERNS = null;
    private static final int CODE_SHIFT = 98;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final float MAX_AVG_VARIANCE = 0.25f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;

    public Code128Reader() {
    }

    static {
        CODE_PATTERNS = new int[][]{new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};
    }

    private static int[] findStartPattern(BitArray r13) throws NotFoundException {
        int r0 = r13.getSize();
        int r2 = r13.getNextSet(0);
        int[] r3 = new int[6];
        boolean r5 = false;
        int r6 = 0;
        int r4 = r2;
    L3:
        if (r2 >= r0) goto L27;
        if (r13.get(r2) == r5) goto L8;
        r3[r6] = r3[r6] + 1;
    L25:
        r2 = r2 + 1;
        goto L3
    L8:
        if (r6 != 5) goto L23;
        int r7 = -1;
        float r9 = MAX_AVG_VARIANCE;
        int r10 = 103;
    L11:
        if (r10 > 105) goto L17;
        float r11 = patternMatchVariance(r3, CODE_PATTERNS[r10], 0.7f);
        if (r11 >= r9) goto L15;
        r7 = r10;
        r9 = r11;
    L15:
        r10 = r10 + 1;
        goto L11
    L17:
        if (r7 >= 0) goto L19;
    L22:
        r4 = r4 + (r3[0] + r3[1]);
        int r8 = r6 - 1;
        System.arraycopy(r3, 2, r3, 0, r8);
        r3[r8] = 0;
        r3[r6] = 0;
        r6 = r6 - 1;
    L24:
        r3[r6] = 1;
        r5 = !r5;
        goto L25
    L19:
        if (r13.isRange(Math.max(0, r4 - ((r2 - r4) / 2)), r4, false) == false) goto L22;
        return new int[]{r4, r2, r7};
    L23:
        r6 = r6 + 1;
        goto L24
    L27:
        throw NotFoundException.getNotFoundInstance();
    }

    private static int decodeCode(BitArray r3, int[] r4, int r5) throws NotFoundException {
        recordPattern(r3, r5, r4);
        float r6 = MAX_AVG_VARIANCE;
        int r7 = -1;
        int r0 = 0;
    L3:
        int[][] r1 = CODE_PATTERNS;
        if (r0 >= r1.length) goto L9;
        float r2 = patternMatchVariance(r4, r1[r0], 0.7f);
        if (r2 >= r6) goto L8;
        r7 = r0;
        r6 = r2;
    L8:
        r0 = r0 + 1;
        goto L3
    L9:
        if (r7 < 0) goto L12;
        return r7;
    L12:
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int r24, BitArray r25, Map<DecodeHintType, ?> r26) throws NotFoundException, FormatException, ChecksumException {
        if (r26 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        int[] r4 = findStartPattern(r25);
        int r6 = r4[2];
        ArrayList r7 = new ArrayList(20);
        r7.add(Byte.valueOf((byte) r6));
        switch(r6) {
            case 103: goto L14;
            case 104: goto L13;
            case 105: goto L12;
            default: goto L11;
        };
    L12:
        char r12 = 'c';
    L15:
        StringBuilder r13 = new StringBuilder(20);
        int r8 = r4[0];
        int r15 = 6;
        int[] r2 = new int[6];
        boolean r17 = false;
        int r18 = 0;
        int r19 = 0;
        int r20 = 0;
        int r16 = r6;
        char r5 = r12;
        int r9 = r4[1];
        boolean r10 = false;
        boolean r14 = false;
        boolean r110 = false;
        int r3 = r8;
        boolean r11 = true;
    L16:
        if (r10 == true) goto L118;
        int r21 = decodeCode(r25, r2, r9);
        r7.add(Byte.valueOf((byte) r21));
        if (r21 == 106) goto L20;
        r11 = true;
    L20:
        if (r21 == 106) goto L22;
        r19 = r19 + 1;
        r16 = r16 + (r19 * r21);
    L22:
        int r22 = r9;
        int r111 = 0;
    L23:
        if (r111 >= r15) goto L25;
        r22 = r22 + r2[r111];
        r111 = r111 + 1;
        goto L23
    L25:
        switch(r21) {
            case 103: goto L30;
            case 104: goto L30;
            case 105: goto L30;
            default: goto L27;
        };
    L27:
        switch(r5) {
            case 99: goto L89;
            case 100: goto L60;
            case 101: goto L32;
            default: goto L28;
        };
    L28:
        char r112 = 'd';
    L110:
        r11 = r11;
    L111:
        boolean r23 = r10;
        char r27 = r5;
        boolean r28 = false;
    L113:
        if (r17 == false) goto L117;
        if (r27 != 'e') goto L116;
        r27 = r112;
        goto L117
    L116:
        r27 = 'e';
    L117:
        r17 = r28;
        r5 = r27;
        r10 = r23;
        r11 = r11;
        r15 = 6;
        int r29 = r18;
        r18 = r21;
        r3 = r9;
        r9 = r22;
        r20 = r29;
        goto L16
    L60:
        if (r21 >= 96) goto L66;
        if (r14 != r110) goto L63;
        r13.append((char) (r21 + 32));
    L64:
        r11 = r11;
        r112 = 'd';
        r14 = false;
        goto L111
    L63:
        r13.append((char) ((r21 + 32) + 128));
        goto L64
    L66:
        if (r21 == 106) goto L68;
        r11 = false;
    L68:
        if (r21 == 106) goto L87;
        switch(r21) {
            case 96: goto L88;
            case 97: goto L88;
            case 98: goto L85;
            case 99: goto L84;
            case 100: goto L77;
            case 101: goto L76;
            case 102: goto L71;
            default: goto L88;
        };
    L71:
        if (r1 == false) goto L88;
        if (r13.length() != 0) goto L75;
        r13.append("]C1");
        goto L88
    L75:
        r13.append(29);
        goto L88
    L76:
        r28 = false;
    L86:
        r112 = 'd';
    L107:
        r23 = r10;
        r27 = 'e';
        goto L113
    L77:
        if (r110 == true) goto L80;
        if (r14 == false) goto L80;
    L79:
        r11 = r11;
        r112 = 'd';
        r14 = false;
        r110 = true;
    L80:
        if (r110 == false) goto L83;
        if (r14 == false) goto L83;
    L82:
        r11 = r11;
        r112 = 'd';
        r14 = false;
        r110 = false;
    L83:
        r11 = r11;
        r112 = 'd';
        r14 = true;
    L84:
        r11 = r11;
        r28 = false;
        r112 = 'd';
        r23 = r10;
        r27 = 'c';
        goto L113
    L85:
        r28 = true;
    L88:
        r11 = r11;
        r112 = 'd';
    L87:
        r10 = true;
        goto L88
    L89:
        r112 = 'd';
        if (r21 >= 100) goto L96;
        if (r21 >= 10) goto L94;
        r13.append('0');
    L94:
        r13.append(r21);
        goto L110
    L96:
        if (r21 == 106) goto L98;
        r11 = false;
    L98:
        if (r21 == 106) goto L109;
        switch(r21) {
            case 100: goto L108;
            case 101: goto L106;
            case 102: goto L101;
            default: goto L110;
        };
    L101:
        if (r1 == false) goto L110;
        if (r13.length() != 0) goto L105;
        r13.append("]C1");
        goto L110
    L105:
        r13.append(29);
        goto L110
    L106:
        r11 = r11;
        r28 = false;
        goto L107
    L108:
        r11 = r11;
        r28 = false;
        r23 = r10;
        r27 = 'd';
        goto L113
    L109:
        r27 = r5;
        r11 = r11;
        r28 = false;
        r23 = true;
        goto L113
    L32:
        if (r21 >= 64) goto L36;
        if (r14 != r110) goto L35;
        r13.append((char) (r21 + 32));
        goto L64
    L35:
        r13.append((char) ((r21 + 32) + 128));
        goto L64
    L36:
        if (r21 >= 96) goto L41;
        if (r14 != r110) goto L39;
        r13.append((char) (r21 - 64));
        goto L64
    L39:
        r13.append((char) (r21 + 64));
        goto L64
    L41:
        if (r21 == 106) goto L43;
        r11 = false;
    L43:
        if (r21 == 106) goto L87;
        switch(r21) {
            case 96: goto L88;
            case 97: goto L88;
            case 98: goto L58;
            case 99: goto L84;
            case 100: goto L57;
            case 101: goto L51;
            case 102: goto L46;
            default: goto L88;
        };
    L46:
        if (r1 == false) goto L88;
        if (r13.length() != 0) goto L50;
        r13.append("]C1");
        goto L88
    L50:
        r13.append(29);
        goto L88
    L51:
        if (r110 == true) goto L54;
        if (r14 == true) goto L79;
    L54:
        if (r110 == false) goto L83;
        if (r14 == false) goto L83;
    L57:
        r28 = false;
    L59:
        r112 = 'd';
        r23 = r10;
        r27 = 'd';
        goto L113
    L58:
        r28 = true;
        goto L59
    L30:
        throw FormatException.getFormatInstance();
    L118:
        int r30 = r9 - r3;
        int r31 = r25.getNextUnset(r9);
        if (r25.isRange(r31, Math.min(r25.getSize(), ((r31 - r3) / 2) + r31), false) == false) goto L140;
        int r0 = r20;
        if (((r16 - (r19 * r0)) % 103) != r0) goto L138;
        int r32 = r13.length();
        if (r32 == 0) goto L136;
        if (r32 <= 0) goto L130;
        if (r11 == false) goto L130;
        if (r5 != 'c') goto L129;
        r13.delete(r32 - 2, r32);
        goto L130
    L129:
        r13.delete(r32 - 1, r32);
    L130:
        float r33 = (r4[1] + r4[0]) / 2.0f;
        float r34 = r3 + (r30 / 2.0f);
        int r35 = r7.size();
        byte[] r36 = new byte[r35];
        int r37 = 0;
    L131:
        if (r37 >= r35) goto L133;
        r36[r37] = ((Byte) r7.get(r37)).byteValue();
        r37 = r37 + 1;
        goto L131
    L133:
        float r38 = r24;
        return new Result(r13.toString(), r36, new ResultPoint[]{new ResultPoint(r33, r38), new ResultPoint(r34, r38)}, BarcodeFormat.CODE_128);
    L136:
        throw NotFoundException.getNotFoundInstance();
    L138:
        throw ChecksumException.getChecksumInstance();
    L140:
        throw NotFoundException.getNotFoundInstance();
    L13:
        r12 = 'd';
        goto L15
    L14:
        r12 = 'e';
        goto L15
    L11:
        throw FormatException.getFormatInstance();
    L5:
        if (r26.containsKey(DecodeHintType.ASSUME_GS1) == false) goto L7;
        r1 = true;
        goto L8
    }
}
