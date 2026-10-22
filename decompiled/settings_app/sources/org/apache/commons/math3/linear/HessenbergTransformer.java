package org.apache.commons.math3.linear;

import java.lang.reflect.Array;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
class HessenbergTransformer {
    private RealMatrix cachedH;
    private RealMatrix cachedP;
    private RealMatrix cachedPt;
    private final double[][] householderVectors;
    private final double[] ort;

    HessenbergTransformer(RealMatrix r2) {
        if (r2.isSquare() == false) goto L7;
        int r0 = r2.getRowDimension();
        this.householderVectors = r2.getData();
        this.ort = new double[r0];
        this.cachedP = null;
        this.cachedPt = null;
        this.cachedH = null;
        transform();
        return;
    L7:
        throw new NonSquareMatrixException(r2.getRowDimension(), r2.getColumnDimension());
    }

    public RealMatrix getP() {
        if (this.cachedP != null) goto L34;
        int r1 = this.householderVectors.length;
        int r2 = r1 - 1;
        double[][] r3 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r1, r1});
        int r6 = 0;
    L6:
        if (r6 >= r1) goto L15;
        int r9 = 0;
    L8:
        if (r9 >= r1) goto L14;
        double[] r10 = r3[r6];
        if (r6 != r9) goto L12;
        double r11 = 1.0d;
    L13:
        r10[r9] = r11;
        r9 = r9 + 1;
        goto L8
    L12:
        r11 = 0.0d;
        goto L13
    L14:
        r6 = r6 + 1;
        goto L6
    L15:
        int r4 = r2 - 1;
    L16:
        if (r4 < 1) goto L32;
        int r7 = r4 - 1;
        if (this.householderVectors[r4][r7] == 0.0d) goto L31;
        int r5 = r4 + 1;
    L20:
        if (r5 > r2) goto L22;
        this.ort[r5] = this.householderVectors[r5][r7];
        r5 = r5 + 1;
        goto L20
    L22:
        int r8 = r4;
    L23:
        if (r8 > r2) goto L31;
        int r12 = r4;
        double r13 = 0.0d;
    L25:
        if (r12 > r2) goto L27;
        r13 = r13 + (this.ort[r12] * r3[r12][r8]);
        r12 = r12 + 1;
        goto L25
    L27:
        double r14 = (r13 / this.ort[r4]) / this.householderVectors[r4][r7];
        int r15 = r4;
    L28:
        if (r15 > r2) goto L30;
        double[] r16 = r3[r15];
        r16[r8] = r16[r8] + (this.ort[r15] * r14);
        r15 = r15 + 1;
        goto L28
    L30:
        r8 = r8 + 1;
    L31:
        r4 = r4 - 1;
        goto L16
    L32:
        this.cachedP = MatrixUtils.createRealMatrix(r3);
    L34:
        return this.cachedP;
    }

    public RealMatrix getPT() {
        if (this.cachedPt != null) goto L6;
        this.cachedPt = getP().transpose();
    L6:
        return this.cachedPt;
    }

    public RealMatrix getH() {
        if (this.cachedH != null) goto L14;
        int r0 = this.householderVectors.length;
        int r2 = 0;
        double[][] r1 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r0, r0});
    L5:
        if (r2 >= r0) goto L12;
        if (r2 <= 0) goto L8;
        int r4 = r2 - 1;
        r1[r2][r4] = this.householderVectors[r2][r4];
    L8:
        int r3 = r2;
    L9:
        if (r3 >= r0) goto L11;
        r1[r2][r3] = this.householderVectors[r2][r3];
        r3 = r3 + 1;
        goto L9
    L11:
        r2 = r2 + 1;
        goto L5
    L12:
        this.cachedH = MatrixUtils.createRealMatrix(r1);
    L14:
        return this.cachedH;
    }

    double[][] getHouseholderVectorsRef() {
        return this.householderVectors;
    }

    private void transform() {
        int r1 = this.householderVectors.length;
        int r2 = r1 - 1;
        int r3 = 1;
    L4:
        if (r3 > (r2 - 1)) goto L37;
        double r4 = 0.0d;
        int r6 = r3;
        double r7 = 0.0d;
    L6:
        if (r6 > r2) goto L9;
        r7 = r7 + FastMath.abs(this.householderVectors[r6][r3 - 1]);
        r6 = r6 + 1;
        goto L6
    L9:
        if (Precision.equals(r7, 0.0d) == true) goto L35;
        int r8 = r2;
        double r9 = 0.0d;
    L11:
        if (r8 < r3) goto L13;
        double[] r11 = this.ort;
        double r12 = this.householderVectors[r8][r3 - 1] / r7;
        r11[r8] = r12;
        r9 = r9 + (r12 * r12);
        r8 = r8 - 1;
        goto L11
    L13:
        double r13 = this.ort[r3];
        double r14 = FastMath.sqrt(r9);
        if (r13 <= 0.0d) goto L16;
        r14 = -r14;
    L16:
        double[] r10 = this.ort;
        double r15 = r10[r3];
        double r16 = r9 - (r15 * r14);
        r10[r3] = r15 - r14;
        int r17 = r3;
    L17:
        if (r17 >= r1) goto L25;
        int r18 = r2;
        double r19 = r4;
    L19:
        if (r18 < r3) goto L21;
        r19 = r19 + (this.ort[r18] * this.householderVectors[r18][r17]);
        r18 = r18 - 1;
        r1 = r1;
        goto L19
    L21:
        int r110 = r1;
        double r111 = r19 / r16;
        int r5 = r3;
    L22:
        if (r5 > r2) goto L24;
        double[] r20 = this.householderVectors[r5];
        r20[r17] = r20[r17] - (this.ort[r5] * r111);
        r5 = r5 + 1;
        goto L22
    L24:
        r17 = r17 + 1;
        r1 = r110;
        r4 = 0.0d;
        goto L17
    L25:
        int r112 = r1;
        int r21 = 0;
    L26:
        if (r21 > r2) goto L34;
        int r22 = r2;
        double r23 = 0.0d;
    L28:
        if (r22 < r3) goto L30;
        r23 = r23 + (this.ort[r22] * this.householderVectors[r21][r22]);
        r22 = r22 - 1;
        goto L28
    L30:
        double r24 = r23 / r16;
        int r25 = r3;
    L31:
        if (r25 > r2) goto L33;
        double[] r113 = this.householderVectors[r21];
        r113[r25] = r113[r25] - (this.ort[r25] * r24);
        r25 = r25 + 1;
        r2 = r2;
        goto L31
    L33:
        r21 = r21 + 1;
        goto L26
    L34:
        int r114 = r2;
        double[] r26 = this.ort;
        r26[r3] = r26[r3] * r7;
        this.householderVectors[r3][r3 - 1] = r7 * r14;
    L36:
        r3 = r3 + 1;
        r1 = r112;
        r2 = r114;
        goto L4
    L35:
        r112 = r1;
        r114 = r2;
        goto L36
    }
}
