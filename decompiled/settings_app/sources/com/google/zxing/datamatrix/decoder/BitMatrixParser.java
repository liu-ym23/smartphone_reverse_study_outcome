package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

/* JADX INFO: loaded from: classes4.dex */
final class BitMatrixParser {
    private final BitMatrix mappingBitMatrix;
    private final BitMatrix readMappingMatrix;
    private final Version version;

    BitMatrixParser(BitMatrix r3) throws FormatException {
        int r0 = r3.getHeight();
        if (r0 < 8) goto L11;
        if (r0 > 144) goto L11;
        if ((r0 & 1) != 0) goto L11;
        this.version = readVersion(r3);
        BitMatrix r4 = extractDataRegion(r3);
        this.mappingBitMatrix = r4;
        this.readMappingMatrix = new BitMatrix(r4.getWidth(), r4.getHeight());
        return;
    L11:
        throw FormatException.getFormatInstance();
    }

    Version getVersion() {
        return this.version;
    }

    private static Version readVersion(BitMatrix r1) throws FormatException {
        return Version.getVersionForDimensions(r1.getHeight(), r1.getWidth());
    }

    byte[] readCodewords() throws FormatException {
        byte[] r0 = new byte[this.version.getTotalCodewords()];
        int r1 = this.mappingBitMatrix.getHeight();
        int r2 = this.mappingBitMatrix.getWidth();
        int r3 = 0;
        boolean r5 = false;
        int r6 = 0;
        boolean r7 = false;
        boolean r8 = false;
        boolean r9 = false;
        int r10 = 4;
    L4:
        if (r10 != r1) goto L8;
        if (r3 != 0) goto L8;
        if (r5 == true) goto L8;
        r0[r6] = (byte) readCorner1(r1, r2);
        r10 = r10 - 2;
        r3 = r3 + 2;
        r6 = r6 + 1;
        r5 = true;
    L47:
        if (r10 < r1) goto L4;
        if (r3 < r2) goto L4;
        if (r6 != this.version.getTotalCodewords()) goto L53;
        return r0;
    L53:
        throw FormatException.getFormatInstance();
    L8:
        int r12 = r1 - 2;
        if (r10 != r12) goto L16;
        if (r3 != 0) goto L16;
        if ((r2 & 3) == 0) goto L16;
        if (r7 == true) goto L16;
        r0[r6] = (byte) readCorner2(r1, r2);
        r10 = r10 - 2;
        r3 = r3 + 2;
        r6 = r6 + 1;
        r7 = true;
    L16:
        if (r10 == (r1 + 4)) goto L18;
    L23:
        if (r10 != r12) goto L29;
        if (r3 != 0) goto L29;
        if ((r2 & 7) != 4) goto L29;
        if (r9 == true) goto L29;
        r0[r6] = (byte) readCorner4(r1, r2);
        r10 = r10 - 2;
        r3 = r3 + 2;
        r6 = r6 + 1;
        r9 = true;
    L29:
        if (r10 >= r1) goto L34;
        if (r3 < 0) goto L34;
        if (this.readMappingMatrix.get(r3, r10) == true) goto L34;
        r0[r6] = (byte) readUtah(r10, r3, r1, r2);
        r6 = r6 + 1;
    L34:
        r10 = r10 - 2;
        r3 = r3 + 2;
        if (r10 < 0) goto L37;
        if (r3 < r2) goto L29;
    L37:
        int r11 = r10 + 1;
        int r4 = r3 + 3;
    L38:
        if (r11 < 0) goto L43;
        if (r4 >= r2) goto L43;
        if (this.readMappingMatrix.get(r4, r11) == true) goto L43;
        r0[r6] = (byte) readUtah(r11, r4, r1, r2);
        r6 = r6 + 1;
    L43:
        r11 = r11 + 2;
        r4 = r4 - 2;
        if (r11 >= r1) goto L46;
        if (r4 >= 0) goto L38;
    L46:
        r10 = r11 + 3;
        r3 = r4 + 1;
        goto L47
    L18:
        if (r3 != 2) goto L23;
        if ((r2 & 7) != 0) goto L23;
        if (r8 == true) goto L23;
        r0[r6] = (byte) readCorner3(r1, r2);
        r10 = r10 - 2;
        r3 = r3 + 2;
        r6 = r6 + 1;
        r8 = true;
        goto L47
    }

    private boolean readModule(int r1, int r2, int r3, int r4) {
        if (r1 >= 0) goto L4;
        r1 = r1 + r3;
        r2 = r2 + (4 - ((r3 + 4) & 7));
    L4:
        if (r2 >= 0) goto L6;
        r2 = r2 + r4;
        r1 = r1 + (4 - ((r4 + 4) & 7));
    L6:
        this.readMappingMatrix.set(r2, r1);
        return this.mappingBitMatrix.get(r2, r1);
    }

    private int readUtah(int r6, int r7, int r8, int r9) {
        int r0 = r6 - 2;
        int r1 = r7 - 2;
        int r2 = (readModule(r0, r1, r8, r9) ? 1 : 0) << 1;
        int r3 = r7 - 1;
        if (readModule(r0, r3, r8, r9) == false) goto L5;
        r2 = r2 | 1;
    L5:
        int r4 = r2 << 1;
        int r5 = r6 - 1;
        if (readModule(r5, r1, r8, r9) == false) goto L8;
        r4 = r4 | 1;
    L8:
        int r10 = r4 << 1;
        if (readModule(r5, r3, r8, r9) == false) goto L11;
        r10 = r10 | 1;
    L11:
        int r11 = r10 << 1;
        if (readModule(r5, r7, r8, r9) == false) goto L14;
        r11 = r11 | 1;
    L14:
        int r12 = r11 << 1;
        if (readModule(r6, r1, r8, r9) == false) goto L17;
        r12 = r12 | 1;
    L17:
        int r13 = r12 << 1;
        if (readModule(r6, r3, r8, r9) == false) goto L20;
        r13 = r13 | 1;
    L20:
        int r14 = r13 << 1;
        if (readModule(r6, r7, r8, r9) == true) goto L23;
        return r14;
    L23:
        return r14 | 1;
    }

    private int readCorner1(int r6, int r7) {
        int r0 = r6 - 1;
        int r2 = (readModule(r0, 0, r6, r7) ? 1 : 0) << 1;
        if (readModule(r0, 1, r6, r7) == false) goto L5;
        r2 = r2 | 1;
    L5:
        int r3 = r2 << 1;
        if (readModule(r0, 2, r6, r7) == false) goto L8;
        r3 = r3 | 1;
    L8:
        int r1 = r3 << 1;
        if (readModule(0, r7 - 2, r6, r7) == false) goto L11;
        r1 = r1 | 1;
    L11:
        int r4 = r1 << 1;
        int r5 = r7 - 1;
        if (readModule(0, r5, r6, r7) == false) goto L14;
        r4 = r4 | 1;
    L14:
        int r8 = r4 << 1;
        if (readModule(1, r5, r6, r7) == false) goto L17;
        r8 = r8 | 1;
    L17:
        int r9 = r8 << 1;
        if (readModule(2, r5, r6, r7) == false) goto L20;
        r9 = r9 | 1;
    L20:
        int r10 = r9 << 1;
        if (readModule(3, r5, r6, r7) == true) goto L23;
        return r10;
    L23:
        return r10 | 1;
    }

    private int readCorner2(int r5, int r6) {
        int r0 = (readModule(r5 + (-3), 0, r5, r6) ? 1 : 0) << 1;
        if (readModule(r5 - 2, 0, r5, r6) == false) goto L5;
        r0 = r0 | 1;
    L5:
        int r1 = r0 << 1;
        if (readModule(r5 - 1, 0, r5, r6) == false) goto L8;
        r1 = r1 | 1;
    L8:
        int r2 = r1 << 1;
        if (readModule(0, r6 - 4, r5, r6) == false) goto L11;
        r2 = r2 | 1;
    L11:
        int r3 = r2 << 1;
        if (readModule(0, r6 - 3, r5, r6) == false) goto L14;
        r3 = r3 | 1;
    L14:
        int r4 = r3 << 1;
        if (readModule(0, r6 - 2, r5, r6) == false) goto L17;
        r4 = r4 | 1;
    L17:
        int r7 = r4 << 1;
        int r8 = r6 - 1;
        if (readModule(0, r8, r5, r6) == false) goto L20;
        r7 = r7 | 1;
    L20:
        int r9 = r7 << 1;
        if (readModule(1, r8, r5, r6) == true) goto L23;
        return r9;
    L23:
        return r9 | 1;
    }

    private int readCorner3(int r8, int r9) {
        int r0 = r8 - 1;
        int r2 = (readModule(r0, 0, r8, r9) ? 1 : 0) << 1;
        int r4 = r9 - 1;
        if (readModule(r0, r4, r8, r9) == false) goto L5;
        r2 = r2 | 1;
    L5:
        int r1 = r2 << 1;
        int r3 = r9 - 3;
        if (readModule(0, r3, r8, r9) == false) goto L8;
        r1 = r1 | 1;
    L8:
        int r5 = r1 << 1;
        int r6 = r9 - 2;
        if (readModule(0, r6, r8, r9) == false) goto L11;
        r5 = r5 | 1;
    L11:
        int r7 = r5 << 1;
        if (readModule(0, r4, r8, r9) == false) goto L14;
        r7 = r7 | 1;
    L14:
        int r10 = r7 << 1;
        if (readModule(1, r3, r8, r9) == false) goto L17;
        r10 = r10 | 1;
    L17:
        int r11 = r10 << 1;
        if (readModule(1, r6, r8, r9) == false) goto L20;
        r11 = r11 | 1;
    L20:
        int r12 = r11 << 1;
        if (readModule(1, r4, r8, r9) == true) goto L23;
        return r12;
    L23:
        return r12 | 1;
    }

    private int readCorner4(int r5, int r6) {
        int r0 = (readModule(r5 + (-3), 0, r5, r6) ? 1 : 0) << 1;
        if (readModule(r5 - 2, 0, r5, r6) == false) goto L5;
        r0 = r0 | 1;
    L5:
        int r1 = r0 << 1;
        if (readModule(r5 - 1, 0, r5, r6) == false) goto L8;
        r1 = r1 | 1;
    L8:
        int r2 = r1 << 1;
        if (readModule(0, r6 - 2, r5, r6) == false) goto L11;
        r2 = r2 | 1;
    L11:
        int r3 = r2 << 1;
        int r4 = r6 - 1;
        if (readModule(0, r4, r5, r6) == false) goto L14;
        r3 = r3 | 1;
    L14:
        int r7 = r3 << 1;
        if (readModule(1, r4, r5, r6) == false) goto L17;
        r7 = r7 | 1;
    L17:
        int r8 = r7 << 1;
        if (readModule(2, r4, r5, r6) == false) goto L20;
        r8 = r8 | 1;
    L20:
        int r9 = r8 << 1;
        if (readModule(3, r4, r5, r6) == true) goto L23;
        return r9;
    L23:
        return r9 | 1;
    }

    private BitMatrix extractDataRegion(BitMatrix r15) {
        int r0 = this.version.getSymbolSizeRows();
        int r1 = this.version.getSymbolSizeColumns();
        if (r15.getHeight() != r0) goto L21;
        int r2 = this.version.getDataRegionSizeRows();
        int r14 = this.version.getDataRegionSizeColumns();
        int r3 = r0 / r2;
        int r4 = r1 / r14;
        BitMatrix r5 = new BitMatrix(r4 * r14, r3 * r2);
        int r6 = 0;
    L5:
        if (r6 >= r3) goto L19;
        int r7 = r6 * r2;
        int r8 = 0;
    L7:
        if (r8 >= r4) goto L18;
        int r9 = r8 * r14;
        int r10 = 0;
    L9:
        if (r10 >= r2) goto L17;
        int r11 = (((r2 + 2) * r6) + 1) + r10;
        int r12 = r7 + r10;
        int r13 = 0;
    L11:
        if (r13 >= r14) goto L16;
        if (r15.get((((r14 + 2) * r8) + 1) + r13, r11) == false) goto L15;
        r5.set(r9 + r13, r12);
    L15:
        r13 = r13 + 1;
        goto L11
    L16:
        r10 = r10 + 1;
        goto L9
    L17:
        r8 = r8 + 1;
        goto L7
    L18:
        r6 = r6 + 1;
        goto L5
    L19:
        return r5;
    L21:
        throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
    }
}
