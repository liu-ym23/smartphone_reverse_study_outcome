package com.google.zxing;

import com.google.zxing.common.detector.MathUtils;

/* JADX INFO: loaded from: classes4.dex */
public class ResultPoint {
    private final float x;
    private final float y;

    public ResultPoint(float r1, float r2) {
        this.x = r1;
        this.y = r2;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public final boolean equals(Object r4) {
        if ((r4 instanceof ResultPoint) == false) goto L10;
        ResultPoint r5 = (ResultPoint) r4;
        if (this.x != r5.x) goto L10;
        if (this.y != r5.y) goto L10;
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y);
    }

    public final String toString() {
        return "(" + this.x + ',' + this.y + ')';
    }

    public static void orderBestPatterns(ResultPoint[] r9) {
        float r1 = distance(r9[0], r9[1]);
        float r3 = distance(r9[1], r9[2]);
        float r5 = distance(r9[0], r9[2]);
        if (r3 < r1) goto L8;
        if (r3 < r5) goto L8;
        ResultPoint r2 = r9[0];
        ResultPoint r4 = r9[1];
        ResultPoint r6 = r9[2];
    L14:
        if (crossProductZ(r4, r2, r6) >= 0.0f) goto L16;
        ResultPoint r8 = r6;
        r6 = r4;
        r4 = r8;
    L16:
        r9[0] = r4;
        r9[1] = r2;
        r9[2] = r6;
        return;
    L8:
        if (r5 >= r3) goto L10;
    L12:
        r2 = r9[2];
        r4 = r9[0];
        r6 = r9[1];
        goto L14
    L10:
        if (r5 < r1) goto L12;
        r2 = r9[1];
        r4 = r9[0];
        r6 = r9[2];
        goto L14
    }

    public static float distance(ResultPoint r2, ResultPoint r3) {
        return MathUtils.distance(r2.x, r2.y, r3.x, r3.y);
    }

    private static float crossProductZ(ResultPoint r3, ResultPoint r4, ResultPoint r5) {
        float r0 = r4.x;
        float r6 = r4.y;
        return ((r5.x - r0) * (r3.y - r6)) - ((r5.y - r6) * (r3.x - r0));
    }
}
