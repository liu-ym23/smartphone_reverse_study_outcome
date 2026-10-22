package com.google.zxing.pdf417.decoder;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

/* JADX INFO: loaded from: classes4.dex */
final class BoundingBox {
    private final ResultPoint bottomLeft;
    private final ResultPoint bottomRight;
    private final BitMatrix image;
    private final int maxX;
    private final int maxY;
    private final int minX;
    private final int minY;
    private final ResultPoint topLeft;
    private final ResultPoint topRight;

    BoundingBox(BitMatrix r4, ResultPoint r5, ResultPoint r6, ResultPoint r7, ResultPoint r8) throws NotFoundException {
        boolean r0 = false;
        if (r5 == null) goto L7;
        if (r6 == null) goto L7;
        boolean r2 = false;
    L8:
        if (r7 == null) goto L10;
        if (r8 == null) goto L10;
    L11:
        if (r2 == false) goto L16;
        if (r0 == false) goto L16;
        throw NotFoundException.getNotFoundInstance();
    L16:
        if (r2 == false) goto L18;
        r5 = new ResultPoint(0.0f, r7.getY());
        r6 = new ResultPoint(0.0f, r8.getY());
    L20:
        this.image = r4;
        this.topLeft = r5;
        this.bottomLeft = r6;
        this.topRight = r7;
        this.bottomRight = r8;
        this.minX = (int) Math.min(r5.getX(), r6.getX());
        this.maxX = (int) Math.max(r7.getX(), r8.getX());
        this.minY = (int) Math.min(r5.getY(), r7.getY());
        this.maxY = (int) Math.max(r6.getY(), r8.getY());
        return;
    L18:
        if (r0 == false) goto L20;
        r7 = new ResultPoint(r4.getWidth() - 1, r5.getY());
        r8 = new ResultPoint(r4.getWidth() - 1, r6.getY());
    L10:
        r0 = true;
    L7:
        r2 = true;
        goto L8
    }

    BoundingBox(BoundingBox r2) {
        this.image = r2.image;
        this.topLeft = r2.getTopLeft();
        this.bottomLeft = r2.getBottomLeft();
        this.topRight = r2.getTopRight();
        this.bottomRight = r2.getBottomRight();
        this.minX = r2.getMinX();
        this.maxX = r2.getMaxX();
        this.minY = r2.getMinY();
        this.maxY = r2.getMaxY();
    }

    static BoundingBox merge(BoundingBox r7, BoundingBox r8) throws NotFoundException {
        if (r7 != null) goto L4;
        return r8;
    L4:
        if (r8 != null) goto L7;
        return r7;
    L7:
        return new BoundingBox(r7.image, r7.topLeft, r7.bottomLeft, r8.topRight, r8.bottomRight);
    }

    BoundingBox addMissingRows(int r13, int r14, boolean r15) throws NotFoundException {
        ResultPoint r0 = this.topLeft;
        ResultPoint r1 = this.bottomLeft;
        ResultPoint r2 = this.topRight;
        ResultPoint r3 = this.bottomRight;
        if (r13 <= 0) goto L14;
        if (r15 == false) goto L6;
        ResultPoint r4 = r0;
    L7:
        int r5 = ((int) r4.getY()) - r13;
        if (r5 >= 0) goto L10;
        r5 = 0;
    L10:
        ResultPoint r16 = new ResultPoint(r4.getX(), r5);
        if (r15 == false) goto L13;
        ResultPoint r8 = r16;
    L15:
        ResultPoint r10 = r2;
    L16:
        if (r14 <= 0) goto L27;
        if (r15 == false) goto L19;
        ResultPoint r17 = this.bottomLeft;
    L20:
        int r6 = ((int) r17.getY()) + r14;
        if (r6 < this.image.getHeight()) goto L23;
        r6 = this.image.getHeight() - 1;
    L23:
        ResultPoint r18 = new ResultPoint(r17.getX(), r6);
        if (r15 == false) goto L26;
        ResultPoint r9 = r18;
    L28:
        ResultPoint r11 = r3;
    L30:
        return new BoundingBox(this.image, r8, r9, r10, r11);
    L26:
        r11 = r18;
        r9 = r1;
        goto L30
    L19:
        r17 = this.bottomRight;
        goto L20
    L27:
        r9 = r1;
        goto L28
    L13:
        r10 = r16;
        r8 = r0;
        goto L16
    L6:
        r4 = r2;
        goto L7
    L14:
        r8 = r0;
        goto L15
    }

    int getMinX() {
        return this.minX;
    }

    int getMaxX() {
        return this.maxX;
    }

    int getMinY() {
        return this.minY;
    }

    int getMaxY() {
        return this.maxY;
    }

    ResultPoint getTopLeft() {
        return this.topLeft;
    }

    ResultPoint getTopRight() {
        return this.topRight;
    }

    ResultPoint getBottomLeft() {
        return this.bottomLeft;
    }

    ResultPoint getBottomRight() {
        return this.bottomRight;
    }
}
