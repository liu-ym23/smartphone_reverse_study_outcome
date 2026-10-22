package com.google.zxing.datamatrix.encoder;

import android.icu.lang.UCharacter;
import android.icu.util.ULocale;
import com.google.zxing.Dimension;

/* JADX INFO: loaded from: classes4.dex */
public class SymbolInfo {
    static final SymbolInfo[] PROD_SYMBOLS = null;
    private static SymbolInfo[] symbols;
    private final int dataCapacity;
    private final int dataRegions;
    private final int errorCodewords;
    public final int matrixHeight;
    public final int matrixWidth;
    private final boolean rectangular;
    private final int rsBlockData;
    private final int rsBlockError;

    static {
        SymbolInfo[] r0 = {new SymbolInfo(false, 3, 5, 8, 8, 1), new SymbolInfo(false, 5, 7, 10, 10, 1), new SymbolInfo(true, 5, 7, 16, 6, 1), new SymbolInfo(false, 8, 10, 12, 12, 1), new SymbolInfo(true, 10, 11, 14, 6, 2), new SymbolInfo(false, 12, 12, 14, 14, 1), new SymbolInfo(true, 16, 14, 24, 10, 1), new SymbolInfo(false, 18, 14, 16, 16, 1), new SymbolInfo(false, 22, 18, 18, 18, 1), new SymbolInfo(true, 22, 18, 16, 10, 2), new SymbolInfo(false, 30, 20, 20, 20, 1), new SymbolInfo(true, 32, 24, 16, 14, 2), new SymbolInfo(false, 36, 24, 22, 22, 1), new SymbolInfo(false, 44, 28, 24, 24, 1), new SymbolInfo(true, 49, 28, 22, 14, 2), new SymbolInfo(false, 62, 36, 14, 14, 4), new SymbolInfo(false, 86, 42, 16, 16, 4), new SymbolInfo(false, 114, 48, 18, 18, 4), new SymbolInfo(false, 144, 56, 20, 20, 4), new SymbolInfo(false, 174, 68, 22, 22, 4), new SymbolInfo(false, 204, 84, 24, 24, 4, 102, 42), new SymbolInfo(false, UCharacter.UnicodeBlock.ZANABAZAR_SQUARE_ID, 112, 14, 14, 16, 140, 56), new SymbolInfo(false, 368, 144, 16, 16, 16, 92, 36), new SymbolInfo(false, 456, 192, 18, 18, 16, 114, 48), new SymbolInfo(false, 576, 224, 20, 20, 16, 144, 56), new SymbolInfo(false, 696, UCharacter.UnicodeBlock.TANGUT_ID, 22, 22, 16, 174, 68), new SymbolInfo(false, 816, 336, 24, 24, 16, 136, 56), new SymbolInfo(false, 1050, 408, 18, 18, 36, 175, 68), new SymbolInfo(false, 1304, 496, 20, 20, 36, 163, 62), new DataMatrixSymbolInfo144()};
        PROD_SYMBOLS = r0;
        symbols = r0;
    }

    public static void overrideSymbolSet(SymbolInfo[] r0) {
        symbols = r0;
    }

    public SymbolInfo(boolean r10, int r11, int r12, int r13, int r14, int r15) {
        this(r10, r11, r12, r13, r14, r15, r11, r12);
    }

    SymbolInfo(boolean r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8) {
        this.rectangular = r1;
        this.dataCapacity = r2;
        this.errorCodewords = r3;
        this.matrixWidth = r4;
        this.matrixHeight = r5;
        this.dataRegions = r6;
        this.rsBlockData = r7;
        this.rsBlockError = r8;
    }

    public static SymbolInfo lookup(int r2) {
        return lookup(r2, SymbolShapeHint.FORCE_NONE, true);
    }

    public static SymbolInfo lookup(int r1, SymbolShapeHint r2) {
        return lookup(r1, r2, true);
    }

    public static SymbolInfo lookup(int r0, boolean r1, boolean r2) {
        if (r1 == false) goto L4;
        SymbolShapeHint r3 = SymbolShapeHint.FORCE_NONE;
    L6:
        return lookup(r0, r3, r2);
    L4:
        r3 = SymbolShapeHint.FORCE_SQUARE;
        goto L6
    }

    private static SymbolInfo lookup(int r1, SymbolShapeHint r2, boolean r3) {
        return lookup(r1, r2, null, null, r3);
    }

    public static SymbolInfo lookup(int r6, SymbolShapeHint r7, Dimension r8, Dimension r9, boolean r10) {
        SymbolInfo[] r0 = symbols;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L26;
        SymbolInfo r3 = r0[r2];
        if (r7 != SymbolShapeHint.FORCE_SQUARE) goto L9;
        if (r3.rectangular == false) goto L9;
    L25:
        r2 = r2 + 1;
    L9:
        if (r7 == SymbolShapeHint.FORCE_RECTANGLE) goto L11;
    L12:
        if (r8 != null) goto L14;
    L17:
        if (r9 == null) goto L23;
        if (r3.getSymbolWidth() > r9.getWidth()) goto L25;
        if (r3.getSymbolHeight() > r9.getHeight()) goto L25;
    L23:
        if (r6 > r3.dataCapacity) goto L25;
        return r3;
    L14:
        if (r3.getSymbolWidth() < r8.getWidth()) goto L25;
        if (r3.getSymbolHeight() < r8.getHeight()) goto L25;
    L11:
        if (r3.rectangular == false) goto L25;
    L26:
        if (r10 == true) goto L30;
        return null;
    L30:
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(r6)));
    }

    private int getHorizontalDataRegions() {
        int r2 = this.dataRegions;
        int r0 = 1;
        if (r2 == 1) goto L17;
        r0 = 2;
        if (r2 == 2) goto L17;
        if (r2 == 4) goto L17;
        if (r2 != 16) goto L11;
        return 4;
    L11:
        if (r2 != 36) goto L15;
        return 6;
    L15:
        throw new IllegalStateException("Cannot handle this number of data regions");
    L17:
        return r0;
    }

    private int getVerticalDataRegions() {
        int r2 = this.dataRegions;
        if (r2 != 1) goto L5;
    L18:
        return 1;
    L5:
        if (r2 == 2) goto L18;
        if (r2 != 4) goto L9;
        return 2;
    L9:
        if (r2 != 16) goto L11;
        return 4;
    L11:
        if (r2 != 36) goto L15;
        return 6;
    L15:
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public final int getSymbolDataWidth() {
        return getHorizontalDataRegions() * this.matrixWidth;
    }

    public final int getSymbolDataHeight() {
        return getVerticalDataRegions() * this.matrixHeight;
    }

    public final int getSymbolWidth() {
        return getSymbolDataWidth() + (getHorizontalDataRegions() << 1);
    }

    public final int getSymbolHeight() {
        return getSymbolDataHeight() + (getVerticalDataRegions() << 1);
    }

    public int getCodewordCount() {
        return this.dataCapacity + this.errorCodewords;
    }

    public int getInterleavedBlockCount() {
        return this.dataCapacity / this.rsBlockData;
    }

    public final int getDataCapacity() {
        return this.dataCapacity;
    }

    public final int getErrorCodewords() {
        return this.errorCodewords;
    }

    public int getDataLengthForInterleavedBlock(int r1) {
        return this.rsBlockData;
    }

    public final int getErrorLengthForInterleavedBlock(int r1) {
        return this.rsBlockError;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.rectangular == false) goto L5;
        String r1 = "Rectangular Symbol:";
    L7:
        return r0.append(r1).append(" data region ").append(this.matrixWidth).append(ULocale.PRIVATE_USE_EXTENSION).append(this.matrixHeight).append(", symbol size ").append(getSymbolWidth()).append(ULocale.PRIVATE_USE_EXTENSION).append(getSymbolHeight()).append(", symbol data size ").append(getSymbolDataWidth()).append(ULocale.PRIVATE_USE_EXTENSION).append(getSymbolDataHeight()).append(", codewords ").append(this.dataCapacity).append('+').append(this.errorCodewords).toString();
    L5:
        r1 = "Square Symbol:";
        goto L7
    }
}
