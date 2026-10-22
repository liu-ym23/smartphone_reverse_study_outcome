package org.apache.commons.math3.linear;

import java.lang.reflect.Array;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
class BiDiagonalTransformer {
    private RealMatrix cachedB;
    private RealMatrix cachedU;
    private RealMatrix cachedV;
    private final double[][] householderVectors;
    private final double[] main;
    private final double[] secondary;

    BiDiagonalTransformer(RealMatrix r4) {
        int r0 = r4.getRowDimension();
        int r1 = r4.getColumnDimension();
        int r2 = FastMath.min(r0, r1);
        this.householderVectors = r4.getData();
        this.main = new double[r2];
        this.secondary = new double[r2 - 1];
        this.cachedU = null;
        this.cachedB = null;
        this.cachedV = null;
        if (r0 < r1) goto L5;
        transformToUpperBiDiagonal();
        return;
    L5:
        transformToLowerBiDiagonal();
    }

    public RealMatrix getU() {
        if (this.cachedU != null) goto L33;
        double[][] r1 = this.householderVectors;
        int r2 = r1.length;
        int r3 = r1[0].length;
        double[] r4 = this.main;
        int r5 = r4.length;
        if (r2 < r3) goto L7;
        int r7 = 0;
    L8:
        if (r2 >= r3) goto L11;
        r4 = this.secondary;
    L11:
        double[][] r6 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r2, r2});
        int r8 = r2 - 1;
    L12:
        double r9 = 1.0d;
        if (r8 < r5) goto L15;
        r6[r8][r8] = 1.0d;
        r8 = r8 - 1;
        goto L12
    L15:
        int r10 = r5 - 1;
    L16:
        if (r10 < r7) goto L29;
        double[] r11 = this.householderVectors[r10];
        r6[r10][r10] = r9;
        int r12 = r10 - r7;
        double r13 = 0.0d;
        if (r11[r12] == 0.0d) goto L28;
        int r14 = r10;
    L20:
        if (r14 >= r2) goto L28;
        int r15 = r10;
        double r16 = r13;
    L22:
        if (r15 >= r2) goto L24;
        r16 = r16 - (r6[r15][r14] * this.householderVectors[r15][r12]);
        r15 = r15 + 1;
        goto L22
    L24:
        double r17 = r16 / (r4[r12] * r11[r12]);
        int r18 = r10;
    L25:
        if (r18 >= r2) goto L27;
        double[] r19 = r6[r18];
        r19[r14] = r19[r14] + ((-r17) * this.householderVectors[r18][r12]);
        r18 = r18 + 1;
        goto L25
    L27:
        r14 = r14 + 1;
        r13 = 0.0d;
    L28:
        r10 = r10 - 1;
        r9 = 1.0d;
        goto L16
    L29:
        if (r7 <= 0) goto L31;
        r6[0][0] = 1.0d;
    L31:
        this.cachedU = MatrixUtils.createRealMatrix(r6);
        goto L33
    L7:
        r7 = 1;
    L33:
        return this.cachedU;
    }

    public RealMatrix getB() {
        if (this.cachedB != null) goto L17;
        double[][] r0 = this.householderVectors;
        int r1 = r0.length;
        int r2 = 0;
        int r3 = r0[0].length;
        double[][] r4 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r1, r3});
    L5:
        double[] r5 = this.main;
        if (r2 >= r5.length) goto L15;
        double[] r6 = r4[r2];
        r6[r2] = r5[r2];
        if (r1 >= r3) goto L12;
        if (r2 <= 0) goto L14;
        int r7 = r2 - 1;
        r6[r7] = this.secondary[r7];
    L14:
        r2 = r2 + 1;
        goto L5
    L12:
        if (r2 >= (r5.length - 1)) goto L14;
        r6[r2 + 1] = this.secondary[r2];
        goto L14
    L15:
        this.cachedB = MatrixUtils.createRealMatrix(r4);
    L17:
        return this.cachedB;
    }

    public RealMatrix getV() {
        if (this.cachedV != null) goto L32;
        double[][] r1 = this.householderVectors;
        int r2 = r1.length;
        int r3 = r1[0].length;
        double[] r4 = this.main;
        int r5 = r4.length;
        if (r2 < r3) goto L7;
        int r7 = 1;
    L8:
        if (r2 < r3) goto L10;
        r4 = this.secondary;
    L10:
        double[][] r6 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r3, r3});
        int r8 = r3 - 1;
    L11:
        double r9 = 1.0d;
        if (r8 < r5) goto L14;
        r6[r8][r8] = 1.0d;
        r8 = r8 - 1;
        goto L11
    L14:
        int r10 = r5 - 1;
    L15:
        if (r10 < r7) goto L28;
        int r11 = r10 - r7;
        double[] r12 = this.householderVectors[r11];
        r6[r10][r10] = r9;
        double r13 = 0.0d;
        if (r12[r10] == 0.0d) goto L27;
        int r14 = r10;
    L19:
        if (r14 >= r3) goto L27;
        int r15 = r10;
        double r16 = r13;
    L21:
        if (r15 >= r3) goto L23;
        r16 = r16 - (r6[r15][r14] * r12[r15]);
        r15 = r15 + 1;
        goto L21
    L23:
        double r17 = r16 / (r4[r11] * r12[r10]);
        int r18 = r10;
    L24:
        if (r18 >= r3) goto L26;
        double[] r19 = r6[r18];
        r19[r14] = r19[r14] + ((-r17) * r12[r18]);
        r18 = r18 + 1;
        goto L24
    L26:
        r14 = r14 + 1;
        r13 = 0.0d;
    L27:
        r10 = r10 - 1;
        r9 = 1.0d;
        goto L15
    L28:
        if (r7 <= 0) goto L30;
        r6[0][0] = 1.0d;
    L30:
        this.cachedV = MatrixUtils.createRealMatrix(r6);
        goto L32
    L7:
        r7 = 0;
    L32:
        return this.cachedV;
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

    boolean isUpperBiDiagonal() {
        double[][] r2 = this.householderVectors;
        if (r2.length < r2[0].length) goto L6;
        return true;
    L6:
        return false;
    }

    private void transformToUpperBiDiagonal() {
        double[][] r1 = this.householderVectors;
        int r2 = r1.length;
        int r3 = 0;
        int r4 = r1[0].length;
    L3:
        if (r3 >= r4) goto L42;
        int r6 = r3;
        double r7 = 0.0d;
    L5:
        if (r6 >= r2) goto L7;
        double r9 = this.householderVectors[r6][r3];
        r7 = r7 + (r9 * r9);
        r6 = r6 + 1;
        goto L5
    L7:
        double[] r8 = this.householderVectors[r3];
        double r10 = r8[r3];
        double r11 = FastMath.sqrt(r7);
        if (r10 <= 0.0d) goto L10;
        r11 = -r11;
    L10:
        this.main[r3] = r11;
        if (r11 == 0.0d) goto L22;
        r8[r3] = r8[r3] - r11;
        int r12 = r3 + 1;
    L13:
        if (r12 >= r4) goto L22;
        int r13 = r3;
        double r14 = 0.0d;
    L15:
        if (r13 >= r2) goto L17;
        double[] r15 = this.householderVectors[r13];
        r14 = r14 - (r15[r12] * r15[r3]);
        r13 = r13 + 1;
        goto L15
    L17:
        double r16 = r14 / (this.householderVectors[r3][r3] * r11);
        int r17 = r3;
    L18:
        if (r17 >= r2) goto L20;
        double[] r18 = this.householderVectors[r17];
        r18[r12] = r18[r12] - (r18[r3] * r16);
        r17 = r17 + 1;
        goto L18
    L20:
        r12 = r12 + 1;
    L22:
        if (r3 >= (r4 - 1)) goto L41;
        int r19 = r3 + 1;
        double r20 = 0.0d;
        int r21 = r19;
    L24:
        if (r21 >= r4) goto L27;
        double r110 = r8[r21];
        r20 = r20 + (r110 * r110);
        r21 = r21 + 1;
        goto L24
    L27:
        if (r8[r19] <= 0.0d) goto L29;
        double r22 = -FastMath.sqrt(r20);
    L30:
        this.secondary[r3] = r22;
        if (r22 == 0.0d) goto L41;
        r8[r19] = r8[r19] - r22;
        int r111 = r19;
    L33:
        if (r111 >= r2) goto L41;
        double[] r112 = this.householderVectors[r111];
        double r113 = 0.0d;
        int r114 = r19;
    L35:
        if (r114 >= r4) goto L37;
        r113 = r113 - (r112[r114] * r8[r114]);
        r114 = r114 + 1;
        goto L35
    L37:
        double r115 = r113 / (r8[r19] * r22);
        int r116 = r19;
    L38:
        if (r116 >= r4) goto L40;
        r112[r116] = r112[r116] - (r8[r116] * r115);
        r116 = r116 + 1;
        goto L38
    L40:
        r111 = r111 + 1;
        goto L33
    L29:
        r22 = FastMath.sqrt(r20);
    L41:
        r3 = r3 + 1;
        goto L3
    }

    private void transformToLowerBiDiagonal() {
        double[][] r1 = this.householderVectors;
        int r2 = r1.length;
        int r3 = 0;
        int r4 = r1[0].length;
    L3:
        if (r3 >= r2) goto L43;
        double[] r5 = this.householderVectors[r3];
        int r7 = r3;
        double r8 = 0.0d;
    L5:
        if (r7 >= r4) goto L8;
        double r10 = r5[r7];
        r8 = r8 + (r10 * r10);
        r7 = r7 + 1;
        goto L5
    L8:
        if (r5[r3] <= 0.0d) goto L10;
        double r9 = -FastMath.sqrt(r8);
    L11:
        this.main[r3] = r9;
        if (r9 == 0.0d) goto L23;
        r5[r3] = r5[r3] - r9;
        int r11 = r3 + 1;
    L14:
        if (r11 >= r2) goto L23;
        double[] r12 = this.householderVectors[r11];
        int r13 = r3;
        double r14 = 0.0d;
    L16:
        if (r13 >= r4) goto L18;
        r14 = r14 - (r12[r13] * r5[r13]);
        r13 = r13 + 1;
        goto L16
    L18:
        double r15 = r14 / (this.householderVectors[r3][r3] * r9);
        int r16 = r3;
    L19:
        if (r16 >= r4) goto L21;
        r12[r16] = r12[r16] - (r5[r16] * r15);
        r16 = r16 + 1;
        goto L19
    L21:
        r11 = r11 + 1;
    L23:
        if (r3 >= (r2 - 1)) goto L42;
        int r17 = r3 + 1;
        double[] r6 = this.householderVectors[r17];
        double r18 = 0.0d;
        int r19 = r17;
    L25:
        if (r19 >= r2) goto L28;
        double r110 = this.householderVectors[r19][r3];
        r18 = r18 + (r110 * r110);
        r19 = r19 + 1;
        goto L25
    L28:
        if (r6[r3] <= 0.0d) goto L30;
        double r20 = -FastMath.sqrt(r18);
    L31:
        this.secondary[r3] = r20;
        if (r20 == 0.0d) goto L42;
        r6[r3] = r6[r3] - r20;
        int r111 = r17;
    L34:
        if (r111 >= r4) goto L42;
        double r112 = 0.0d;
        int r113 = r17;
    L36:
        if (r113 >= r2) goto L38;
        double[] r114 = this.householderVectors[r113];
        r112 = r112 - (r114[r111] * r114[r3]);
        r113 = r113 + 1;
        goto L36
    L38:
        double r115 = r112 / (r6[r3] * r20);
        int r116 = r17;
    L39:
        if (r116 >= r2) goto L41;
        double[] r117 = this.householderVectors[r116];
        r117[r111] = r117[r111] - (r117[r3] * r115);
        r116 = r116 + 1;
        goto L39
    L41:
        r111 = r111 + 1;
        goto L34
    L30:
        r20 = FastMath.sqrt(r18);
    L42:
        r3 = r3 + 1;
        goto L3
    L10:
        r9 = FastMath.sqrt(r8);
        goto L11
    }
}
