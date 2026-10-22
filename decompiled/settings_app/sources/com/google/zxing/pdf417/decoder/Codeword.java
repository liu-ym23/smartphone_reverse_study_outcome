package com.google.zxing.pdf417.decoder;

import com.android.settings.search.Index;

/* JADX INFO: loaded from: classes4.dex */
final class Codeword {
    private static final int BARCODE_ROW_UNKNOWN = -1;
    private final int bucket;
    private final int endX;
    private int rowNumber;
    private final int startX;
    private final int value;

    Codeword(int r2, int r3, int r4, int r5) {
        this.rowNumber = -1;
        this.startX = r2;
        this.endX = r3;
        this.bucket = r4;
        this.value = r5;
    }

    boolean hasValidRowNumber() {
        return isValidRowNumber(this.rowNumber);
    }

    boolean isValidRowNumber(int r2) {
        if (r2 != (-1)) goto L5;
        return false;
    L5:
        if (this.bucket != ((r2 % 3) * 3)) goto L10;
        return true;
    L10:
        return false;
    }

    void setRowNumberAsRowIndicatorColumn() {
        this.rowNumber = ((this.value / 30) * 3) + (this.bucket / 3);
    }

    int getWidth() {
        return this.endX - this.startX;
    }

    int getStartX() {
        return this.startX;
    }

    int getEndX() {
        return this.endX;
    }

    int getBucket() {
        return this.bucket;
    }

    int getValue() {
        return this.value;
    }

    int getRowNumber() {
        return this.rowNumber;
    }

    void setRowNumber(int r1) {
        this.rowNumber = r1;
    }

    public String toString() {
        return this.rowNumber + Index.ENTRIES_SEPARATOR + this.value;
    }
}
