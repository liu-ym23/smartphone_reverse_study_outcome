package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class ITFWriter extends OneDimensionalCodeWriter {
    private static final int[] END_PATTERN = null;
    private static final int N = 1;
    private static final int[][] PATTERNS = null;
    private static final int[] START_PATTERN = null;
    private static final int W = 3;

    public ITFWriter() {
    }

    static {
        START_PATTERN = new int[]{1, 1, 1, 1};
        END_PATTERN = new int[]{3, 1, 1};
        PATTERNS = new int[][]{new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String r2, BarcodeFormat r3, int r4, int r5, Map<EncodeHintType, ?> r6) throws WriterException {
        if (r3 != BarcodeFormat.ITF) goto L7;
        return super.encode(r2, r3, r4, r5, r6);
    L7:
        throw new IllegalArgumentException("Can only encode ITF, but got ".concat(String.valueOf(r3)));
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String r13) {
        int r12 = r13.length();
        if ((r12 % 2) != 0) goto L18;
        if (r12 > 80) goto L16;
        boolean[] r0 = new boolean[(r12 * 9) + 9];
        int r1 = appendPattern(r0, 0, START_PATTERN, true);
        int r4 = 0;
    L7:
        if (r4 >= r12) goto L13;
        int r5 = Character.digit(r13.charAt(r4), 10);
        int r7 = Character.digit(r13.charAt(r4 + 1), 10);
        int[] r6 = new int[10];
        int r8 = 0;
    L10:
        if (r8 >= 5) goto L12;
        int r9 = r8 * 2;
        int[][] r10 = PATTERNS;
        r6[r9] = r10[r5][r8];
        r6[r9 + 1] = r10[r7][r8];
        r8 = r8 + 1;
        goto L10
    L12:
        r1 = r1 + appendPattern(r0, r1, r6, true);
        r4 = r4 + 2;
        goto L7
    L13:
        appendPattern(r0, r1, END_PATTERN, true);
        return r0;
    L16:
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(r12)));
    L18:
        throw new IllegalArgumentException("The length of the input should be even");
    }
}
