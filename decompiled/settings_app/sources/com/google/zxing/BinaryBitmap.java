package com.google.zxing;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;

/* JADX INFO: loaded from: classes4.dex */
public final class BinaryBitmap {
    private final Binarizer binarizer;
    private BitMatrix matrix;

    public BinaryBitmap(Binarizer r1) {
        if (r1 == null) goto L7;
        this.binarizer = r1;
        return;
    L7:
        throw new IllegalArgumentException("Binarizer must be non-null.");
    }

    public int getWidth() {
        return this.binarizer.getWidth();
    }

    public int getHeight() {
        return this.binarizer.getHeight();
    }

    public BitArray getBlackRow(int r1, BitArray r2) throws NotFoundException {
        return this.binarizer.getBlackRow(r1, r2);
    }

    public BitMatrix getBlackMatrix() throws NotFoundException {
        if (this.matrix != null) goto L6;
        this.matrix = this.binarizer.getBlackMatrix();
    L6:
        return this.matrix;
    }

    public boolean isCropSupported() {
        return this.binarizer.getLuminanceSource().isCropSupported();
    }

    public BinaryBitmap crop(int r2, int r3, int r4, int r5) {
        LuminanceSource r6 = this.binarizer.getLuminanceSource().crop(r2, r3, r4, r5);
        return new BinaryBitmap(this.binarizer.createBinarizer(r6));
    }

    public boolean isRotateSupported() {
        return this.binarizer.getLuminanceSource().isRotateSupported();
    }

    public BinaryBitmap rotateCounterClockwise() {
        LuminanceSource r0 = this.binarizer.getLuminanceSource().rotateCounterClockwise();
        return new BinaryBitmap(this.binarizer.createBinarizer(r0));
    }

    public BinaryBitmap rotateCounterClockwise45() {
        LuminanceSource r0 = this.binarizer.getLuminanceSource().rotateCounterClockwise45();
        return new BinaryBitmap(this.binarizer.createBinarizer(r0));
    }

    public String toString() {
        return getBlackMatrix().toString();
    L4:
        return "";
    }
}
