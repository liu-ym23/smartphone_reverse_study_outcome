package org.apache.commons.math3.linear;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
class TriDiagonalTransformer {
    private RealMatrix cachedQ;
    private RealMatrix cachedQt;
    private RealMatrix cachedT;
    private final double[][] householderVectors;
    private final double[] main;
    private final double[] secondary;

    TriDiagonalTransformer(RealMatrix r2) {
        if (r2.isSquare() == false) goto L7;
        int r0 = r2.getRowDimension();
        this.householderVectors = r2.getData();
        this.main = new double[r0];
        this.secondary = new double[r0 - 1];
        this.cachedQ = null;
        this.cachedQt = null;
        this.cachedT = null;
        transform();
        return;
    L7:
        throw new NonSquareMatrixException(r2.getRowDimension(), r2.getColumnDimension());
    }

    public RealMatrix getQ() {
        if (this.cachedQ != null) goto L6;
        this.cachedQ = getQT().transpose();
    L6:
        return this.cachedQ;
    }

    public RealMatrix getQT() {
        if (this.cachedQt != null) goto L24;
        int r1 = this.householderVectors.length;
        double[][] r2 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r1, r1});
        int r5 = r1 - 1;
    L6:
        if (r5 < 1) goto L22;
        int r9 = r5 - 1;
        double[] r8 = this.householderVectors[r9];
        double[] r10 = r2[r5];
        r10[r5] = 1.0d;
        double r11 = r8[r5];
        if (r11 == 0.0d) goto L21;
        double r15 = this.secondary[r9];
        double r17 = 1.0d / (r15 * r11);
        double r16 = 1.0d / r15;
        r10[r5] = (r11 * r16) + 1.0d;
        int r6 = r5 + 1;
        int r7 = r6;
    L10:
        if (r7 >= r1) goto L12;
        r2[r5][r7] = r8[r7] * r16;
        r7 = r7 + 1;
        goto L10
    L12:
        int r12 = r6;
    L13:
        if (r12 >= r1) goto L21;
        int r13 = r6;
        double r14 = 0.0d;
    L15:
        if (r13 >= r1) goto L17;
        r14 = r14 + (r2[r12][r13] * r8[r13]);
        r13 = r13 + 1;
        goto L15
    L17:
        double r18 = r14 * r17;
        r2[r12][r5] = r8[r5] * r18;
        int r19 = r6;
    L18:
        if (r19 >= r1) goto L20;
        double[] r110 = r2[r12];
        r110[r19] = r110[r19] + (r8[r19] * r18);
        r19 = r19 + 1;
        goto L18
    L20:
        r12 = r12 + 1;
    L21:
        r5 = r5 - 1;
        goto L6
    L22:
        r2[0][0] = 1.0d;
        this.cachedQt = MatrixUtils.createRealMatrix(r2);
    L24:
        return this.cachedQt;
    }

    public RealMatrix getT() {
        if (this.cachedT != null) goto L15;
        int r0 = this.main.length;
        int r3 = 0;
        double[][] r1 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r0, r0});
    L5:
        if (r3 >= r0) goto L13;
        double[] r4 = r1[r3];
        double[] r5 = this.main;
        r4[r3] = r5[r3];
        if (r3 <= 0) goto L10;
        int r6 = r3 - 1;
        r4[r6] = this.secondary[r6];
    L10:
        if (r3 >= (r5.length - 1)) goto L12;
        r4[r3 + 1] = this.secondary[r3];
    L12:
        r3 = r3 + 1;
        goto L5
    L13:
        this.cachedT = MatrixUtils.createRealMatrix(r1);
    L15:
        return this.cachedT;
    }

    double[][] getHouseholderVectorsRef() {
        return this.householderVectors;
    }

    double[] getMainDiagonalRef() {
        return this.main;
    }

    double[] getSecondaryDiagonalRef() {
        return this.secondary;
    }

    private void transform() {
        int r1 = this.householderVectors.length;
        double[] r2 = new double[r1];
        int r3 = 0;
    L3:
        int r4 = r1 - 1;
        if (r3 >= r4) goto L33;
        double[] r5 = this.householderVectors[r3];
        this.main[r3] = r5[r3];
        int r6 = r3 + 1;
        int r8 = r6;
        double r9 = 0.0d;
    L6:
        if (r8 >= r1) goto L9;
        double r11 = r5[r8];
        r9 = r9 + (r11 * r11);
        r8 = r8 + 1;
        goto L6
    L9:
        if (r5[r6] <= 0.0d) goto L11;
        double r10 = -FastMath.sqrt(r9);
    L12:
        this.secondary[r3] = r10;
        if (r10 == 0.0d) goto L32;
        double r12 = r5[r6] - r10;
        r5[r6] = r12;
        double r13 = (-1.0d) / (r10 * r12);
        Arrays.fill(r2, r6, r1, 0.0d);
        int r7 = r6;
    L15:
        if (r7 >= r1) goto L20;
        double[] r14 = this.householderVectors[r7];
        double r15 = r5[r7];
        double r16 = r14[r7] * r15;
        int r17 = r7 + 1;
        int r18 = r17;
    L17:
        if (r18 >= r1) goto L19;
        double r19 = r14[r18];
        r16 = r16 + (r5[r18] * r19);
        r2[r18] = r2[r18] + (r19 * r15);
        r18 = r18 + 1;
        goto L17
    L19:
        r2[r7] = (r2[r7] + r16) * r13;
        r7 = r17;
        goto L15
    L20:
        int r20 = r6;
        double r21 = 0.0d;
    L21:
        if (r20 >= r1) goto L23;
        r21 = r21 + (r2[r20] * r5[r20]);
        r20 = r20 + 1;
        goto L21
    L23:
        double r22 = r21 * (r13 / 2.0d);
        int r23 = r6;
    L24:
        if (r23 >= r1) goto L26;
        r2[r23] = r2[r23] - (r5[r23] * r22);
        r23 = r23 + 1;
        goto L24
    L26:
        int r24 = r6;
    L27:
        if (r24 >= r1) goto L32;
        double[] r25 = this.householderVectors[r24];
        int r26 = r24;
    L29:
        if (r26 >= r1) goto L31;
        r25[r26] = r25[r26] - ((r5[r24] * r2[r26]) + (r2[r24] * r5[r26]));
        r26 = r26 + 1;
        goto L29
    L31:
        r24 = r24 + 1;
    L32:
        r3 = r6;
        goto L3
    L11:
        r10 = FastMath.sqrt(r9);
        goto L12
    L33:
        this.main[r4] = this.householderVectors[r4][r4];
    }
}
