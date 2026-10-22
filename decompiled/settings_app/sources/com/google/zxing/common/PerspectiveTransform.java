package com.google.zxing.common;

/* JADX INFO: loaded from: classes4.dex */
public final class PerspectiveTransform {
    private final float a11;
    private final float a12;
    private final float a13;
    private final float a21;
    private final float a22;
    private final float a23;
    private final float a31;
    private final float a32;
    private final float a33;

    private PerspectiveTransform(float r1, float r2, float r3, float r4, float r5, float r6, float r7, float r8, float r9) {
        this.a11 = r1;
        this.a12 = r4;
        this.a13 = r7;
        this.a21 = r2;
        this.a22 = r5;
        this.a23 = r8;
        this.a31 = r3;
        this.a32 = r6;
        this.a33 = r9;
    }

    public static PerspectiveTransform quadrilateralToQuadrilateral(float r0, float r1, float r2, float r3, float r4, float r5, float r6, float r7, float r8, float r9, float r10, float r11, float r12, float r13, float r14, float r15) {
        PerspectiveTransform r16 = quadrilateralToSquare(r0, r1, r2, r3, r4, r5, r6, r7);
        return squareToQuadrilateral(r8, r9, r10, r11, r12, r13, r14, r15).times(r16);
    }

    public void transformPoints(float[] r19) {
        int r2 = r19.length;
        float r3 = this.a11;
        float r4 = this.a12;
        float r5 = this.a13;
        float r6 = this.a21;
        float r7 = this.a22;
        float r8 = this.a23;
        float r9 = this.a31;
        float r10 = this.a32;
        float r0 = this.a33;
        int r11 = 0;
    L3:
        if (r11 >= r2) goto L5;
        float r12 = r19[r11];
        int r13 = r11 + 1;
        float r14 = r19[r13];
        float r15 = ((r5 * r12) + (r8 * r14)) + r0;
        r19[r11] = (((r3 * r12) + (r6 * r14)) + r9) / r15;
        r19[r13] = (((r12 * r4) + (r14 * r7)) + r10) / r15;
        r11 = r11 + 2;
        goto L3
    }

    public void transformPoints(float[] r8, float[] r9) {
        int r0 = r8.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        float r2 = r8[r1];
        float r3 = r9[r1];
        float r4 = ((this.a13 * r2) + (this.a23 * r3)) + this.a33;
        r8[r1] = (((this.a11 * r2) + (this.a21 * r3)) + this.a31) / r4;
        r9[r1] = (((this.a12 * r2) + (this.a22 * r3)) + this.a32) / r4;
        r1 = r1 + 1;
        goto L3
    }

    public static PerspectiveTransform squareToQuadrilateral(float r11, float r12, float r13, float r14, float r15, float r16, float r17, float r18) {
        float r0 = ((r11 - r13) + r15) - r17;
        float r1 = ((r12 - r14) + r16) - r18;
        if (r0 == 0.0f) goto L5;
    L8:
        float r2 = r13 - r15;
        float r3 = r17 - r15;
        float r4 = r14 - r16;
        float r5 = r18 - r16;
        float r6 = (r2 * r5) - (r3 * r4);
        float r7 = ((r5 * r0) - (r3 * r1)) / r6;
        float r8 = ((r2 * r1) - (r0 * r4)) / r6;
        float r9 = r7 * r13;
        float r10 = r8 * r17;
        return new PerspectiveTransform(r9 + (r13 - r11), r10 + (r17 - r11), r11, (r14 - r12) + (r7 * r14), (r18 - r12) + (r8 * r18), r12, r7, r8, 1.0f);
    L5:
        if (r1 != 0.0f) goto L8;
        return new PerspectiveTransform(r13 - r11, r15 - r13, r11, r14 - r12, r16 - r14, r12, 0.0f, 0.0f, 1.0f);
    }

    public static PerspectiveTransform quadrilateralToSquare(float r0, float r1, float r2, float r3, float r4, float r5, float r6, float r7) {
        return squareToQuadrilateral(r0, r1, r2, r3, r4, r5, r6, r7).buildAdjoint();
    }

    PerspectiveTransform buildAdjoint() {
        float r1 = this.a22;
        float r2 = this.a33;
        float r4 = this.a23;
        float r5 = this.a32;
        float r3 = (r1 * r2) - (r4 * r5);
        float r6 = this.a31;
        float r8 = this.a21;
        float r7 = (r4 * r6) - (r8 * r2);
        float r9 = (r8 * r5) - (r1 * r6);
        float r11 = this.a13;
        float r13 = this.a12;
        float r0 = this.a11;
        return new PerspectiveTransform(r3, r7, r9, (r11 * r5) - (r13 * r2), (r2 * r0) - (r11 * r6), (r6 * r13) - (r5 * r0), (r13 * r4) - (r11 * r1), (r11 * r8) - (r4 * r0), (r0 * r1) - (r13 * r8));
    }

    PerspectiveTransform times(PerspectiveTransform r20) {
        float r2 = this.a11;
        float r3 = r20.a11;
        float r5 = this.a21;
        float r6 = r20.a12;
        float r4 = (r2 * r3) + (r5 * r6);
        float r7 = this.a31;
        float r8 = r20.a13;
        float r9 = r4 + (r7 * r8);
        float r10 = r20.a21;
        float r12 = r20.a22;
        float r11 = (r2 * r10) + (r5 * r12);
        float r13 = r20.a23;
        float r14 = r11 + (r7 * r13);
        float r15 = r20.a31;
        float r16 = r20.a32;
        float r1 = r20.a33;
        float r17 = ((r2 * r15) + (r5 * r16)) + (r7 * r1);
        float r18 = this.a12;
        float r19 = this.a22;
        float r110 = this.a32;
        float r21 = ((r18 * r3) + (r19 * r6)) + (r110 * r8);
        float r111 = ((r18 * r10) + (r19 * r12)) + (r110 * r13);
        float r112 = r110 * r1;
        float r113 = r112 + ((r18 * r15) + (r19 * r16));
        float r22 = this.a13;
        float r23 = this.a23;
        float r0 = this.a33;
        float r24 = r8 * r0;
        return new PerspectiveTransform(r9, r14, r17, r21, r111, r113, r24 + ((r3 * r22) + (r6 * r23)), ((r10 * r22) + (r12 * r23)) + (r13 * r0), ((r22 * r15) + (r23 * r16)) + (r0 * r1));
    }
}
