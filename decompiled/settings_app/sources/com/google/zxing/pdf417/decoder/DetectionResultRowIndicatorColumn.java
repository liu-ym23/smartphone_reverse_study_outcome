package com.google.zxing.pdf417.decoder;

import com.google.zxing.ResultPoint;

/* JADX INFO: loaded from: classes4.dex */
final class DetectionResultRowIndicatorColumn extends DetectionResultColumn {
    private final boolean isLeft;

    DetectionResultRowIndicatorColumn(BoundingBox r1, boolean r2) {
        super(r1);
        this.isLeft = r2;
    }

    private void setRowNumbers() {
        Codeword[] r3 = getCodewords();
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        Codeword r2 = r3[r1];
        if (r2 == null) goto L7;
        r2.setRowNumberAsRowIndicatorColumn();
    L7:
        r1 = r1 + 1;
        goto L3
    }

    void adjustCompleteIndicatorColumnRowNumbers(BarcodeMetadata r13) {
        Codeword[] r0 = getCodewords();
        setRowNumbers();
        removeIncorrectCodewords(r0, r13);
        BoundingBox r1 = getBoundingBox();
        if (this.isLeft == false) goto L5;
        ResultPoint r2 = r1.getTopLeft();
    L7:
        if (this.isLeft == false) goto L9;
        ResultPoint r3 = r1.getBottomLeft();
    L10:
        int r4 = imageRowToCodewordIndex((int) r2.getY());
        int r12 = imageRowToCodewordIndex((int) r3.getY());
        int r5 = -1;
        int r6 = 0;
        int r7 = 1;
    L11:
        if (r4 >= r12) goto L45;
        Codeword r8 = r0[r4];
        if (r8 == null) goto L44;
        int r9 = r8.getRowNumber() - r5;
        if (r9 != 0) goto L17;
        r6 = r6 + 1;
        goto L44
    L17:
        if (r9 != 1) goto L21;
        r7 = Math.max(r7, r6);
        r5 = r8.getRowNumber();
    L19:
        r6 = 1;
        goto L44
    L21:
        if (r9 >= 0) goto L23;
    L43:
        r0[r4] = null;
        goto L44
    L23:
        if (r8.getRowNumber() >= r13.getRowCount()) goto L43;
        if (r9 > r4) goto L43;
        if (r7 <= 2) goto L29;
        r9 = r9 * (r7 - 2);
    L29:
        if (r9 < r4) goto L31;
        boolean r10 = true;
    L32:
        int r11 = 1;
    L33:
        if (r11 > r9) goto L40;
        if (r10 == true) goto L40;
        if (r0[r4 - r11] == null) goto L38;
        r10 = true;
    L39:
        r11 = r11 + 1;
        goto L33
    L38:
        r10 = false;
    L40:
        if (r10 == false) goto L42;
        r0[r4] = null;
        goto L44
    L42:
        r5 = r8.getRowNumber();
        goto L19
    L31:
        r10 = false;
    L44:
        r4 = r4 + 1;
        goto L11
    L45:
        return;
    L9:
        r3 = r1.getBottomRight();
        goto L10
    L5:
        r2 = r1.getTopRight();
        goto L7
    }

    int[] getRowHeights() {
        BarcodeMetadata r0 = getBarcodeMetadata();
        if (r0 != null) goto L6;
        return null;
    L6:
        adjustIncompleteIndicatorColumnRowNumbers(r0);
        int r1 = r0.getRowCount();
        int[] r2 = new int[r1];
        Codeword[] r6 = getCodewords();
        int r3 = r6.length;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L14;
        Codeword r5 = r6[r4];
        if (r5 == null) goto L13;
        int r7 = r5.getRowNumber();
        if (r7 >= r1) goto L13;
        r2[r7] = r2[r7] + 1;
    L13:
        r4 = r4 + 1;
        goto L7
    L14:
        return r2;
    }

    private void adjustIncompleteIndicatorColumnRowNumbers(BarcodeMetadata r10) {
        BoundingBox r0 = getBoundingBox();
        if (this.isLeft == false) goto L5;
        ResultPoint r1 = r0.getTopLeft();
    L7:
        if (this.isLeft == false) goto L9;
        ResultPoint r2 = r0.getBottomLeft();
    L10:
        int r3 = imageRowToCodewordIndex((int) r1.getY());
        int r4 = imageRowToCodewordIndex((int) r2.getY());
        Codeword[] r9 = getCodewords();
        int r5 = -1;
        int r6 = 0;
        int r7 = 1;
    L11:
        if (r3 >= r4) goto L25;
        Codeword r8 = r9[r3];
        if (r8 == null) goto L24;
        r8.setRowNumberAsRowIndicatorColumn();
        int r11 = r8.getRowNumber() - r5;
        if (r11 != 0) goto L17;
        r6 = r6 + 1;
        goto L24
    L17:
        if (r11 != 1) goto L21;
        r7 = Math.max(r7, r6);
        r5 = r8.getRowNumber();
    L19:
        r6 = 1;
        goto L24
    L21:
        if (r8.getRowNumber() < r10.getRowCount()) goto L23;
        r9[r3] = null;
        goto L24
    L23:
        r5 = r8.getRowNumber();
    L24:
        r3 = r3 + 1;
        goto L11
    L25:
        return;
    L9:
        r2 = r0.getBottomRight();
        goto L10
    L5:
        r1 = r0.getTopRight();
        goto L7
    }

    BarcodeMetadata getBarcodeMetadata() {
        Codeword[] r0 = getCodewords();
        BarcodeValue r1 = new BarcodeValue();
        BarcodeValue r2 = new BarcodeValue();
        BarcodeValue r3 = new BarcodeValue();
        BarcodeValue r4 = new BarcodeValue();
        int r5 = r0.length;
        int r7 = 0;
    L4:
        if (r7 >= r5) goto L21;
        Codeword r9 = r0[r7];
        if (r9 == null) goto L19;
        r9.setRowNumberAsRowIndicatorColumn();
        int r10 = r9.getValue() % 30;
        int r11 = r9.getRowNumber();
        if (this.isLeft == true) goto L10;
        r11 = r11 + 2;
    L10:
        int r12 = r11 % 3;
        if (r12 == 0) goto L18;
        if (r12 != 1) goto L14;
        r4.setValue(r10 / 3);
        r3.setValue(r10 % 3);
        goto L19
    L14:
        if (r12 != 2) goto L19;
        r1.setValue(r10 + 1);
        goto L19
    L18:
        r2.setValue((r10 * 3) + 1);
    L19:
        r7 = r7 + 1;
        goto L4
    L21:
        if (r1.getValue().length != 0) goto L23;
        return null;
    L23:
        if (r2.getValue().length != 0) goto L25;
        return null;
    L25:
        if (r3.getValue().length != 0) goto L27;
        return null;
    L27:
        if (r4.getValue().length != 0) goto L29;
        return null;
    L29:
        if (r1.getValue()[0] > 0) goto L31;
        return null;
    L31:
        if ((r2.getValue()[0] + r3.getValue()[0]) >= 3) goto L33;
        return null;
    L33:
        if ((r2.getValue()[0] + r3.getValue()[0]) > 90) goto L50;
        BarcodeMetadata r6 = new BarcodeMetadata(r1.getValue()[0], r2.getValue()[0], r3.getValue()[0], r4.getValue()[0]);
        removeIncorrectCodewords(r0, r6);
        return r6;
    L50:
        return null;
    }

    private void removeIncorrectCodewords(Codeword[] r6, BarcodeMetadata r7) {
        int r0 = 0;
    L4:
        if (r0 >= r6.length) goto L31;
        Codeword r1 = r6[r0];
        if (r1 == null) goto L30;
        int r2 = r1.getValue() % 30;
        int r3 = r1.getRowNumber();
        if (r3 <= r7.getRowCount()) goto L11;
        r6[r0] = null;
        goto L30
    L11:
        if (this.isLeft == true) goto L13;
        r3 = r3 + 2;
    L13:
        int r4 = r3 % 3;
        if (r4 == 0) goto L28;
        if (r4 == 1) goto L23;
        if (r4 != 2) goto L30;
        if ((r2 + 1) == r7.getColumnCount()) goto L30;
        r6[r0] = null;
        goto L30
    L23:
        if ((r2 / 3) == r7.getErrorCorrectionLevel()) goto L25;
    L26:
        r6[r0] = null;
        goto L30
    L25:
        if ((r2 % 3) == r7.getRowCountLowerPart()) goto L30;
    L28:
        if (((r2 * 3) + 1) == r7.getRowCountUpperPart()) goto L30;
        r6[r0] = null;
    L30:
        r0 = r0 + 1;
        goto L4
    }

    boolean isLeft() {
        return this.isLeft;
    }

    @Override // com.google.zxing.pdf417.decoder.DetectionResultColumn
    public String toString() {
        return "IsLeft: " + this.isLeft + '\n' + super.toString();
    }
}
