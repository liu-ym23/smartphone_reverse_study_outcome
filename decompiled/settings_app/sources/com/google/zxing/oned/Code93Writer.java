package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class Code93Writer extends OneDimensionalCodeWriter {
    public Code93Writer() {
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String r2, BarcodeFormat r3, int r4, int r5, Map<EncodeHintType, ?> r6) throws WriterException {
        if (r3 != BarcodeFormat.CODE_93) goto L7;
        return super.encode(r2, r3, r4, r5, r6);
    L7:
        throw new IllegalArgumentException("Can only encode CODE_93, but got ".concat(String.valueOf(r3)));
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String r9) {
        int r8 = r9.length();
        if (r8 > 80) goto L11;
        int[] r1 = new int[9];
        int r2 = (((r9.length() + 2) + 2) * 9) + 1;
        toIntArray(Code93Reader.CHARACTER_ENCODINGS[47], r1);
        boolean[] r3 = new boolean[r2];
        int r4 = 0;
        int r5 = appendPattern(r3, 0, r1);
    L6:
        if (r4 >= r8) goto L8;
        toIntArray(Code93Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(r9.charAt(r4))], r1);
        r5 = r5 + appendPattern(r3, r5, r1);
        r4 = r4 + 1;
        goto L6
    L8:
        int r10 = computeChecksumIndex(r9, 20);
        toIntArray(Code93Reader.CHARACTER_ENCODINGS[r10], r1);
        int r6 = r5 + appendPattern(r3, r5, r1);
        toIntArray(Code93Reader.CHARACTER_ENCODINGS[computeChecksumIndex(r9 + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(r10), 15)], r1);
        int r7 = r6 + appendPattern(r3, r6, r1);
        toIntArray(Code93Reader.CHARACTER_ENCODINGS[47], r1);
        r3[r7 + appendPattern(r3, r7, r1)] = true;
        return r3;
    L11:
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(r8)));
    }

    private static void toIntArray(int r4, int[] r5) {
        int r1 = 0;
    L4:
        if (r1 >= 9) goto L9;
        int r3 = 1;
        if (((1 << (8 - r1)) & r4) != 0) goto L8;
        r3 = 0;
    L8:
        r5[r1] = r3;
        r1 = r1 + 1;
        goto L4
    }

    @Deprecated
    protected static int appendPattern(boolean[] r0, int r1, int[] r2, boolean r3) {
        return appendPattern(r0, r1, r2);
    }

    private static int appendPattern(boolean[] r5, int r6, int[] r7) {
        int r0 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        int r4 = r6 + 1;
        if (r7[r2] == 0) goto L7;
        boolean r3 = true;
    L8:
        r5[r6] = r3;
        r2 = r2 + 1;
        r6 = r4;
        goto L3
    L7:
        r3 = false;
        goto L8
    L9:
        return 9;
    }

    private static int computeChecksumIndex(String r6, int r7) {
        int r0 = r6.length() - 1;
        int r2 = 0;
        int r3 = 1;
    L3:
        if (r0 < 0) goto L9;
        r2 = r2 + ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(r6.charAt(r0)) * r3);
        r3 = r3 + 1;
        if (r3 <= r7) goto L7;
        r3 = 1;
    L7:
        r0 = r0 - 1;
        goto L3
    L9:
        return r2 % 47;
    }
}
