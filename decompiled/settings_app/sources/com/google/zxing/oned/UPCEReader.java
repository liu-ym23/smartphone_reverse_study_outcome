package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* JADX INFO: loaded from: classes4.dex */
public final class UPCEReader extends UPCEANReader {
    private static final int[] MIDDLE_END_PATTERN = null;
    static final int[][] NUMSYS_AND_CHECK_DIGIT_PATTERNS = null;
    private final int[] decodeMiddleCounters;

    static {
        MIDDLE_END_PATTERN = new int[]{1, 1, 1, 1, 1, 1};
        NUMSYS_AND_CHECK_DIGIT_PATTERNS = new int[][]{new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};
    }

    public UPCEReader() {
        this.decodeMiddleCounters = new int[4];
    }

    @Override // com.google.zxing.oned.UPCEANReader
    protected int decodeMiddle(BitArray r10, int[] r11, StringBuilder r12) throws NotFoundException {
        int[] r9 = this.decodeMiddleCounters;
        r9[0] = 0;
        r9[1] = 0;
        r9[2] = 0;
        r9[3] = 0;
        int r2 = r10.getSize();
        int r13 = r11[1];
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r3 >= 6) goto L13;
        if (r13 >= r2) goto L13;
        int r5 = decodeDigit(r10, r9, r13, L_AND_G_PATTERNS);
        r12.append((char) ((r5 % 10) + 48));
        int r6 = r9.length;
        int r7 = 0;
    L7:
        if (r7 >= r6) goto L10;
        r13 = r13 + r9[r7];
        r7 = r7 + 1;
        goto L7
    L10:
        if (r5 < 10) goto L12;
        r4 = r4 | (1 << (5 - r3));
    L12:
        r3 = r3 + 1;
    L13:
        determineNumSysAndCheckDigit(r12, r4);
        return r13;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    protected int[] decodeEnd(BitArray r2, int r3) throws NotFoundException {
        return findGuardPattern(r2, r3, true, MIDDLE_END_PATTERN);
    }

    @Override // com.google.zxing.oned.UPCEANReader
    protected boolean checkChecksum(String r1) throws FormatException {
        return super.checkChecksum(convertUPCEtoUPCA(r1));
    }

    private static void determineNumSysAndCheckDigit(StringBuilder r4, int r5) throws NotFoundException {
        int r1 = 0;
    L4:
        if (r1 > 1) goto L15;
        int r2 = 0;
    L7:
        if (r2 >= 10) goto L13;
        if (r5 == NUMSYS_AND_CHECK_DIGIT_PATTERNS[r1][r2]) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        r4.insert(0, (char) (r1 + 48));
        r4.append((char) (r2 + 48));
        return;
    L13:
        r1 = r1 + 1;
        goto L4
    L15:
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.UPCEANReader
    BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.UPC_E;
    }

    public static String convertUPCEtoUPCA(String r10) {
        char[] r0 = new char[6];
        r10.getChars(1, 7, r0, 0);
        StringBuilder r1 = new StringBuilder(12);
        r1.append(r10.charAt(0));
        char r5 = r0[5];
        switch(r5) {
            case 48: goto L7;
            case 49: goto L7;
            case 50: goto L7;
            case 51: goto L6;
            case 52: goto L5;
            default: goto L4;
        };
    L4:
        r1.append(r0, 0, 5);
        r1.append("0000");
        r1.append(r5);
    L9:
        if (r10.length() < 8) goto L12;
        r1.append(r10.charAt(7));
    L12:
        return r1.toString();
    L5:
        r1.append(r0, 0, 4);
        r1.append("00000");
        r1.append(r0[4]);
        goto L9
    L6:
        r1.append(r0, 0, 3);
        r1.append("00000");
        r1.append(r0, 3, 2);
        goto L9
    L7:
        r1.append(r0, 0, 2);
        r1.append(r5);
        r1.append("0000");
        r1.append(r0, 2, 3);
        goto L9
    }
}
