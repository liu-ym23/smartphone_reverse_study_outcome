package com.google.zxing.datamatrix;

import android.icu.util.ULocale;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Dimension;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.encoder.DefaultPlacement;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
import com.google.zxing.datamatrix.encoder.SymbolInfo;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class DataMatrixWriter implements Writer {
    public DataMatrixWriter() {
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String r7, BarcodeFormat r8, int r9, int r10) {
        return encode(r7, r8, r9, r10, null);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String r3, BarcodeFormat r4, int r5, int r6, Map<EncodeHintType, ?> r7) {
        if (r3.isEmpty() == true) goto L30;
        if (r4 != BarcodeFormat.DATA_MATRIX) goto L28;
        if (r5 < 0) goto L26;
        if (r6 < 0) goto L26;
        SymbolShapeHint r2 = SymbolShapeHint.FORCE_NONE;
        Dimension r8 = null;
        if (r7 == null) goto L22;
        SymbolShapeHint r0 = (SymbolShapeHint) r7.get(EncodeHintType.DATA_MATRIX_SHAPE);
        if (r0 == null) goto L13;
        r2 = r0;
    L13:
        Dimension r1 = (Dimension) r7.get(EncodeHintType.MIN_SIZE);
        if (r1 != null) goto L17;
        r1 = null;
    L17:
        Dimension r9 = (Dimension) r7.get(EncodeHintType.MAX_SIZE);
        if (r9 != null) goto L21;
        r9 = null;
    L21:
        r8 = r1;
    L23:
        String r10 = HighLevelEncoder.encodeHighLevel(r3, r2, r8, r9);
        SymbolInfo r11 = SymbolInfo.lookup(r10.length(), r2, r8, r9, true);
        DefaultPlacement r12 = new DefaultPlacement(ErrorCorrection.encodeECC200(r10, r11), r11.getSymbolDataWidth(), r11.getSymbolDataHeight());
        r12.place();
        return encodeLowLevel(r12, r11, r5, r6);
    L22:
        r9 = null;
    L26:
        throw new IllegalArgumentException("Requested dimensions can't be negative: " + r5 + ULocale.PRIVATE_USE_EXTENSION + r6);
    L28:
        throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(r4)));
    L30:
        throw new IllegalArgumentException("Found empty contents");
    }

    private static BitMatrix encodeLowLevel(DefaultPlacement r11, SymbolInfo r12, int r13, int r14) {
        int r0 = r12.getSymbolDataWidth();
        int r1 = r12.getSymbolDataHeight();
        ByteMatrix r2 = new ByteMatrix(r12.getSymbolWidth(), r12.getSymbolHeight());
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r1) goto L37;
        if ((r4 % r12.matrixHeight) != 0) goto L15;
        int r6 = 0;
        int r8 = 0;
    L8:
        if (r6 >= r12.getSymbolWidth()) goto L14;
        if ((r6 % 2) != 0) goto L12;
        boolean r9 = true;
    L13:
        r2.set(r8, r5, r9);
        r8 = r8 + 1;
        r6 = r6 + 1;
        goto L8
    L12:
        r9 = false;
        goto L13
    L14:
        r5 = r5 + 1;
    L15:
        int r7 = 0;
        int r10 = 0;
    L16:
        if (r7 >= r0) goto L28;
        if ((r7 % r12.matrixWidth) != 0) goto L20;
        r2.set(r10, r5, true);
        r10 = r10 + 1;
    L20:
        r2.set(r10, r5, r11.getBit(r7, r4));
        r10 = r10 + 1;
        if ((r7 % r12.matrixWidth) != (r12.matrixWidth - 1)) goto L27;
        if ((r4 % 2) != 0) goto L25;
        boolean r15 = true;
    L26:
        r2.set(r10, r5, r15);
        r10 = r10 + 1;
        goto L27
    L25:
        r15 = false;
    L27:
        r7 = r7 + 1;
        goto L16
    L28:
        r5 = r5 + 1;
        if ((r4 % r12.matrixHeight) != (r12.matrixHeight - 1)) goto L35;
        int r16 = 0;
        int r17 = 0;
    L32:
        if (r16 >= r12.getSymbolWidth()) goto L34;
        r2.set(r17, r5, true);
        r17 = r17 + 1;
        r16 = r16 + 1;
        goto L32
    L34:
        r5 = r5 + 1;
    L35:
        r4 = r4 + 1;
        goto L3
    L37:
        return convertByteMatrixToBitMatrix(r2, r13, r14);
    }

    private static BitMatrix convertByteMatrixToBitMatrix(ByteMatrix r10, int r11, int r12) {
        int r0 = r10.getWidth();
        int r1 = r10.getHeight();
        int r2 = Math.max(r11, r0);
        int r3 = Math.max(r12, r1);
        int r4 = Math.min(r2 / r0, r3 / r1);
        int r5 = (r2 - (r0 * r4)) / 2;
        int r6 = (r3 - (r1 * r4)) / 2;
        if (r12 < r1) goto L7;
        if (r11 < r0) goto L7;
        BitMatrix r7 = new BitMatrix(r11, r12);
    L8:
        r7.clear();
        int r13 = 0;
    L9:
        if (r13 >= r1) goto L17;
        int r8 = r5;
        int r14 = 0;
    L11:
        if (r14 >= r0) goto L16;
        if (r10.get(r14, r13) != 1) goto L15;
        r7.setRegion(r8, r6, r4, r4);
    L15:
        r14 = r14 + 1;
        r8 = r8 + r4;
        goto L11
    L16:
        r13 = r13 + 1;
        r6 = r6 + r4;
        goto L9
    L17:
        return r7;
    L7:
        r7 = new BitMatrix(r0, r1);
        r5 = 0;
        r6 = 0;
        goto L8
    }
}
