package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class CodaBarReader extends OneDReader {
    static final char[] ALPHABET = null;
    private static final String ALPHABET_STRING = "0123456789-$:/.+ABCD";
    static final int[] CHARACTER_ENCODINGS = null;
    private static final float MAX_ACCEPTABLE = 2.0f;
    private static final int MIN_CHARACTER_LENGTH = 3;
    private static final float PADDING = 1.5f;
    private static final char[] STARTEND_ENCODING = null;
    private int counterLength;
    private int[] counters;
    private final StringBuilder decodeRowResult;

    static {
        ALPHABET = ALPHABET_STRING.toCharArray();
        CHARACTER_ENCODINGS = new int[]{3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
        STARTEND_ENCODING = new char[]{'A', 'B', 'C', 'D'};
    }

    public CodaBarReader() {
        this.decodeRowResult = new StringBuilder(20);
        this.counters = new int[80];
        this.counterLength = 0;
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int r11, BitArray r12, Map<DecodeHintType, ?> r13) throws NotFoundException {
        Arrays.fill(this.counters, 0);
        setCounters(r12);
        int r14 = findStartPattern();
        this.decodeRowResult.setLength(0);
        int r0 = r14;
    L3:
        int r2 = toNarrowWidePattern(r0);
        if (r2 == (-1)) goto L50;
        this.decodeRowResult.append((char) r2);
        r0 = r0 + 8;
        if (this.decodeRowResult.length() <= 1) goto L10;
        if (arrayContains(STARTEND_ENCODING, ALPHABET[r2]) == false) goto L10;
    L11:
        int r4 = r0 - 1;
        int r3 = this.counters[r4];
        int r6 = -8;
        int r7 = 0;
    L12:
        if (r6 >= (-1)) goto L15;
        r7 = r7 + this.counters[r0 + r6];
        r6 = r6 + 1;
        goto L12
    L15:
        if (r0 < this.counterLength) goto L17;
    L21:
        validatePattern(r14);
        int r1 = 0;
    L23:
        if (r1 >= this.decodeRowResult.length()) goto L25;
        StringBuilder r5 = this.decodeRowResult;
        r5.setCharAt(r1, ALPHABET[r5.charAt(r1)]);
        r1 = r1 + 1;
        goto L23
    L25:
        char r8 = this.decodeRowResult.charAt(0);
        char[] r9 = STARTEND_ENCODING;
        if (arrayContains(r9, r8) == false) goto L48;
        StringBuilder r10 = this.decodeRowResult;
        if (arrayContains(r9, r10.charAt(r10.length() - 1)) == false) goto L46;
        if (this.decodeRowResult.length() <= 3) goto L44;
        if (r13 != null) goto L33;
    L34:
        StringBuilder r15 = this.decodeRowResult;
        r15.deleteCharAt(r15.length() - 1);
        this.decodeRowResult.deleteCharAt(0);
    L35:
        int r16 = 0;
        int r17 = 0;
    L36:
        if (r16 >= r14) goto L38;
        r17 = r17 + this.counters[r16];
        r16 = r16 + 1;
        goto L36
    L38:
        float r18 = r17;
    L39:
        if (r14 >= r4) goto L41;
        r17 = r17 + this.counters[r14];
        r14 = r14 + 1;
        goto L39
    L41:
        float r19 = r11;
        return new Result(this.decodeRowResult.toString(), null, new ResultPoint[]{new ResultPoint(r18, r19), new ResultPoint(r17, r19)}, BarcodeFormat.CODABAR);
    L33:
        if (r13.containsKey(DecodeHintType.RETURN_CODABAR_START_END) == true) goto L35;
    L44:
        throw NotFoundException.getNotFoundInstance();
    L46:
        throw NotFoundException.getNotFoundInstance();
    L48:
        throw NotFoundException.getNotFoundInstance();
    L17:
        if (r3 >= (r7 / 2)) goto L21;
        throw NotFoundException.getNotFoundInstance();
    L10:
        if (r0 < this.counterLength) goto L3;
    L50:
        throw NotFoundException.getNotFoundInstance();
    }

    private void validatePattern(int r15) throws NotFoundException {
        int[] r1 = {0, 0, 0, 0};
        int[] r2 = {0, 0, 0, 0};
        int r3 = this.decodeRowResult.length() - 1;
        int r4 = 0;
        int r6 = r15;
        int r5 = 0;
    L3:
        int r7 = CHARACTER_ENCODINGS[this.decodeRowResult.charAt(r5)];
        int r9 = 6;
    L4:
        if (r9 < 0) goto L6;
        int r10 = (r9 & 1) + ((r7 & 1) << 1);
        r1[r10] = r1[r10] + this.counters[r6 + r9];
        r2[r10] = r2[r10] + 1;
        r7 = r7 >> 1;
        r9 = r9 - 1;
        goto L4
    L6:
        if (r5 >= r3) goto L8;
        r6 = r6 + 8;
        r5 = r5 + 1;
        goto L3
    L8:
        float[] r8 = new float[4];
        float[] r0 = new float[4];
        int r11 = 0;
    L10:
        if (r11 >= 2) goto L12;
        r0[r11] = 0.0f;
        int r12 = r11 + 2;
        float r13 = r1[r11] / r2[r11];
        int r14 = r1[r12];
        int r16 = r2[r12];
        float r17 = (r13 + (r14 / r16)) / 2.0f;
        r0[r12] = r17;
        r8[r11] = r17;
        r8[r12] = ((r14 * 2.0f) + PADDING) / r16;
        r11 = r11 + 1;
    L12:
        int r18 = CHARACTER_ENCODINGS[this.decodeRowResult.charAt(r4)];
        int r19 = 6;
    L13:
        if (r19 < 0) goto L21;
        int r20 = (r19 & 1) + ((r18 & 1) << 1);
        float r21 = this.counters[r15 + r19];
        if (r21 < r0[r20]) goto L20;
        if (r21 > r8[r20]) goto L20;
        r18 = r18 >> 1;
        r19 = r19 - 1;
    L20:
        throw NotFoundException.getNotFoundInstance();
    L21:
        if (r4 >= r3) goto L23;
        r15 = r15 + 8;
        r4 = r4 + 1;
        goto L12
    }

    private void setCounters(BitArray r7) throws NotFoundException {
        int r0 = 0;
        this.counterLength = 0;
        int r1 = r7.getNextUnset(0);
        int r2 = r7.getSize();
        if (r1 >= r2) goto L14;
        boolean r4 = true;
    L5:
        if (r1 >= r2) goto L11;
        if (r7.get(r1) == r4) goto L9;
        r0 = r0 + 1;
    L10:
        r1 = r1 + 1;
        goto L5
    L9:
        counterAppend(r0);
        r4 = !r4;
        r0 = 1;
        goto L10
    L11:
        counterAppend(r0);
        return;
    L14:
        throw NotFoundException.getNotFoundInstance();
    }

    private void counterAppend(int r4) {
        int[] r0 = this.counters;
        int r1 = this.counterLength;
        r0[r1] = r4;
        int r2 = r1 + 1;
        this.counterLength = r2;
        if (r2 < r0.length) goto L6;
        int[] r5 = new int[r2 << 1];
        System.arraycopy(r0, 0, r5, 0, r2);
        this.counters = r5;
        return;
    }

    private int findStartPattern() throws NotFoundException {
        int r1 = 1;
    L4:
        if (r1 >= this.counterLength) goto L19;
        int r2 = toNarrowWidePattern(r1);
        if (r2 == (-1)) goto L17;
        if (arrayContains(STARTEND_ENCODING, ALPHABET[r2]) == false) goto L17;
        int r3 = 0;
        int r4 = r1;
    L11:
        if (r4 >= (r1 + 7)) goto L13;
        r3 = r3 + this.counters[r4];
        r4 = r4 + 1;
        goto L11
    L13:
        if (r1 == 1) goto L16;
        if (this.counters[r1 - 1] < (r3 / 2)) goto L17;
    L16:
        return r1;
    L17:
        r1 = r1 + 2;
        goto L4
    L19:
        throw NotFoundException.getNotFoundInstance();
    }

    static boolean arrayContains(char[] r4, char r5) {
        if (r4 == null) goto L11;
        int r1 = r4.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L11;
        if (r4[r2] == r5) goto L8;
        r2 = r2 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }

    private int toNarrowWidePattern(int r10) {
        int r0 = r10 + 7;
        if (r0 < this.counterLength) goto L5;
        return -1;
    L5:
        int[] r9 = this.counters;
        int r1 = Integer.MAX_VALUE;
        int r3 = 0;
        int r4 = r10;
        int r5 = Integer.MAX_VALUE;
        int r6 = 0;
    L6:
        if (r4 >= r0) goto L13;
        int r7 = r9[r4];
        if (r7 >= r5) goto L10;
        r5 = r7;
    L10:
        if (r7 <= r6) goto L12;
        r6 = r7;
    L12:
        r4 = r4 + 2;
        goto L6
    L13:
        int r8 = (r5 + r6) / 2;
        int r11 = r10 + 1;
        int r12 = 0;
    L14:
        if (r11 >= r0) goto L21;
        int r13 = r9[r11];
        if (r13 >= r1) goto L18;
        r1 = r13;
    L18:
        if (r13 <= r12) goto L20;
        r12 = r13;
    L20:
        r11 = r11 + 2;
        goto L14
    L21:
        int r2 = (r1 + r12) / 2;
        int r14 = 128;
        int r15 = 0;
        int r16 = 0;
    L23:
        if (r15 >= 7) goto L32;
        if ((r15 & 1) != 0) goto L27;
        int r17 = r8;
    L28:
        r14 = r14 >> 1;
        if (r9[r10 + r15] <= r17) goto L31;
        r16 = r16 | r14;
    L31:
        r15 = r15 + 1;
        goto L23
    L27:
        r17 = r2;
    L32:
        int[] r18 = CHARACTER_ENCODINGS;
        if (r3 >= r18.length) goto L38;
        if (r18[r3] == r16) goto L36;
        r3 = r3 + 1;
        goto L32
    L36:
        return r3;
    L38:
        return -1;
    }
}
