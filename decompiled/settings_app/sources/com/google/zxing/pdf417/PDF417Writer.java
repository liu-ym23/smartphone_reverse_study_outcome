package com.google.zxing.pdf417;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.encoder.Compaction;
import com.google.zxing.pdf417.encoder.Dimensions;
import com.google.zxing.pdf417.encoder.PDF417;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class PDF417Writer implements Writer {
    private static final int DEFAULT_ERROR_CORRECTION_LEVEL = 2;
    private static final int WHITE_SPACE = 30;

    public PDF417Writer() {
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String r7, BarcodeFormat r8, int r9, int r10, Map<EncodeHintType, ?> r11) throws WriterException {
        if (r8 != BarcodeFormat.PDF_417) goto L27;
        PDF417 r0 = new PDF417();
        int r6 = 30;
        int r12 = 2;
        if (r11 != null) goto L7;
    L24:
        int r2 = r12;
        return bitMatrixFromEncoder(r0, r7, r2, r9, r10, r6);
    L7:
        if (r11.containsKey(EncodeHintType.PDF417_COMPACT) == false) goto L10;
        r0.setCompact(Boolean.valueOf(r11.get(EncodeHintType.PDF417_COMPACT).toString()).booleanValue());
    L10:
        if (r11.containsKey(EncodeHintType.PDF417_COMPACTION) == false) goto L13;
        r0.setCompaction(Compaction.valueOf(r11.get(EncodeHintType.PDF417_COMPACTION).toString()));
    L13:
        if (r11.containsKey(EncodeHintType.PDF417_DIMENSIONS) == false) goto L16;
        Dimensions r1 = (Dimensions) r11.get(EncodeHintType.PDF417_DIMENSIONS);
        r0.setDimensions(r1.getMaxCols(), r1.getMinCols(), r1.getMaxRows(), r1.getMinRows());
    L16:
        if (r11.containsKey(EncodeHintType.MARGIN) == false) goto L19;
        r6 = Integer.parseInt(r11.get(EncodeHintType.MARGIN).toString());
    L19:
        if (r11.containsKey(EncodeHintType.ERROR_CORRECTION) == false) goto L22;
        r12 = Integer.parseInt(r11.get(EncodeHintType.ERROR_CORRECTION).toString());
    L22:
        if (r11.containsKey(EncodeHintType.CHARACTER_SET) == false) goto L24;
        r0.setEncoding(Charset.forName(r11.get(EncodeHintType.CHARACTER_SET).toString()));
        goto L24
    L27:
        throw new IllegalArgumentException("Can only encode PDF_417, but got ".concat(String.valueOf(r8)));
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String r7, BarcodeFormat r8, int r9, int r10) throws WriterException {
        return encode(r7, r8, r9, r10, null);
    }

    private static BitMatrix bitMatrixFromEncoder(PDF417 r4, String r5, int r6, int r7, int r8, int r9) throws WriterException {
        r4.generateBarcodeLogic(r5, r6);
        byte[][] r10 = r4.getBarcodeMatrix().getScaledMatrix(1, 4);
        if (r8 <= r7) goto L5;
        boolean r1 = true;
    L7:
        if (r10[0].length >= r10.length) goto L9;
        boolean r2 = true;
    L10:
        if (r1 == r2) goto L12;
        r10 = rotateArray(r10);
        boolean r3 = true;
    L13:
        int r11 = r7 / r10[0].length;
        int r12 = r8 / r10.length;
        if (r11 < r12) goto L17;
        r11 = r12;
    L17:
        if (r11 <= 1) goto L24;
        byte[][] r13 = r4.getBarcodeMatrix().getScaledMatrix(r11, r11 << 2);
        if (r3 == false) goto L22;
        r13 = rotateArray(r13);
    L22:
        return bitMatrixFromBitArray(r13, r9);
    L24:
        return bitMatrixFromBitArray(r10, r9);
    L12:
        r3 = false;
        goto L13
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = false;
        goto L7
    }

    private static BitMatrix bitMatrixFromBitArray(byte[][] r8, int r9) {
        int r3 = r9 * 2;
        BitMatrix r0 = new BitMatrix(r8[0].length + r3, r8.length + r3);
        r0.clear();
        int r2 = (r0.getHeight() - r9) - 1;
        int r4 = 0;
    L4:
        if (r4 >= r8.length) goto L13;
        byte[] r5 = r8[r4];
        int r6 = 0;
    L7:
        if (r6 >= r8[0].length) goto L12;
        if (r5[r6] != 1) goto L11;
        r0.set(r6 + r9, r2);
    L11:
        r6 = r6 + 1;
        goto L7
    L12:
        r4 = r4 + 1;
        r2 = r2 - 1;
        goto L4
    L13:
        return r0;
    }

    private static byte[][] rotateArray(byte[][] r8) {
        byte[][] r1 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{r8[0].length, r8.length});
        int r2 = 0;
    L4:
        if (r2 >= r8.length) goto L10;
        int r3 = (r8.length - r2) - 1;
        int r5 = 0;
    L7:
        if (r5 >= r8[0].length) goto L9;
        r1[r5][r3] = r8[r2][r5];
        r5 = r5 + 1;
        goto L7
    L9:
        r2 = r2 + 1;
        goto L4
    L10:
        return r1;
    }
}
