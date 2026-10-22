package com.google.zxing.pdf417.encoder;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes4.dex */
public final class BarcodeMatrix {
    private int currentRow;
    private final int height;
    private final BarcodeRow[] matrix;
    private final int width;

    BarcodeMatrix(int r6, int r7) {
        BarcodeRow[] r0 = new BarcodeRow[r6];
        this.matrix = r0;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        this.matrix[r2] = new BarcodeRow(((r7 + 4) * 17) + 1);
        r2 = r2 + 1;
        goto L3
    L5:
        this.width = r7 * 17;
        this.height = r6;
        this.currentRow = -1;
    }

    void set(int r1, int r2, byte r3) {
        this.matrix[r2].set(r1, r3);
    }

    void startRow() {
        this.currentRow++;
    }

    BarcodeRow getCurrentRow() {
        return this.matrix[this.currentRow];
    }

    public byte[][] getMatrix() {
        return getScaledMatrix(1, 1);
    }

    public byte[][] getScaledMatrix(int r8, int r9) {
        int r1 = 0;
        byte[][] r0 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{this.height * r9, this.width * r8});
        int r2 = this.height * r9;
    L3:
        if (r1 >= r2) goto L5;
        r0[(r2 - r1) - 1] = this.matrix[r1 / r9].getScaledRow(r8);
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }
}
