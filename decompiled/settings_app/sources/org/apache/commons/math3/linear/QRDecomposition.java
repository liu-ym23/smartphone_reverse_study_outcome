package org.apache.commons.math3.linear;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class QRDecomposition {
    private RealMatrix cachedH;
    private RealMatrix cachedQ;
    private RealMatrix cachedQT;
    private RealMatrix cachedR;
    private double[][] qrt;
    private double[] rDiag;
    private final double threshold;

    /* JADX INFO: renamed from: org.apache.commons.math3.linear.QRDecomposition$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Solver implements DecompositionSolver {
        private final double[][] qrt;
        private final double[] rDiag;
        private final double threshold;

        /* synthetic */ Solver(double[][] r1, double[] r2, double r3, AnonymousClass1 r5) {
            this(r1, r2, r3);
        }

        private Solver(double[][] r1, double[] r2, double r3) {
            this.qrt = r1;
            this.rDiag = r2;
            this.threshold = r3;
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public boolean isNonSingular() {
            double[] r0 = this.rDiag;
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L8;
            if (FastMath.abs(r0[r3]) <= this.threshold) goto L6;
            r3 = r3 + 1;
            goto L3
        L6:
            return false;
        L8:
            return true;
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealVector solve(RealVector r14) {
            double[][] r0 = this.qrt;
            int r1 = r0.length;
            int r2 = r0[0].length;
            if (r14.getDimension() != r2) goto L27;
            if (isNonSingular() == false) goto L25;
            double[] r3 = new double[r1];
            double[] r15 = r14.toArray();
            int r4 = 0;
        L8:
            if (r4 >= FastMath.min(r2, r1)) goto L16;
            double[] r5 = this.qrt[r4];
            double r6 = 0.0d;
            int r8 = r4;
        L10:
            if (r8 >= r2) goto L12;
            r6 = r6 + (r15[r8] * r5[r8]);
            r8 = r8 + 1;
            goto L10
        L12:
            double r7 = r6 / (this.rDiag[r4] * r5[r4]);
            int r9 = r4;
        L13:
            if (r9 >= r2) goto L15;
            r15[r9] = r15[r9] + (r5[r9] * r7);
            r9 = r9 + 1;
            goto L13
        L15:
            r4 = r4 + 1;
            goto L8
        L16:
            int r10 = this.rDiag.length - 1;
        L17:
            if (r10 < 0) goto L23;
            double r11 = r15[r10] / this.rDiag[r10];
            r15[r10] = r11;
            double[] r12 = this.qrt[r10];
            r3[r10] = r11;
            int r13 = 0;
        L19:
            if (r13 >= r10) goto L21;
            r15[r13] = r15[r13] - (r12[r13] * r11);
            r13 = r13 + 1;
            goto L19
        L21:
            r10 = r10 - 1;
            goto L17
        L23:
            return new ArrayRealVector(r3, false);
        L25:
            throw new SingularMatrixException();
        L27:
            throw new DimensionMismatchException(r14.getDimension(), r2);
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix solve(RealMatrix r27) {
            double[][] r1 = this.qrt;
            int r2 = r1.length;
            int r3 = 0;
            int r4 = r1[0].length;
            if (r27.getRowDimension() != r4) goto L45;
            if (isNonSingular() == false) goto L43;
            int r5 = r27.getColumnDimension();
            int r6 = ((r5 + 52) - 1) / 52;
            double[][] r8 = BlockRealMatrix.createBlocksLayout(r2, r5);
            double[][] r9 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r27.getRowDimension(), 52});
            double[] r7 = new double[52];
            int r15 = 0;
        L7:
            if (r15 >= r6) goto L41;
            int r13 = r15 * 52;
            int r10 = FastMath.min(r13 + 52, r5);
            int r14 = r10 - r13;
            int r16 = r15;
            r27.copySubMatrix(0, r4 - 1, r13, r10 - 1, r9);
            int r11 = r3;
        L9:
            double r12 = 1.0d;
            if (r11 >= FastMath.min(r4, r2)) goto L27;
            double[] r17 = this.qrt[r11];
            double r18 = 1.0d / (this.rDiag[r11] * r17[r11]);
            Arrays.fill(r7, r3, r14, 0.0d);
            int r19 = r11;
        L12:
            if (r19 >= r4) goto L17;
            double r110 = r17[r19];
            double[] r111 = r9[r19];
        L14:
            if (r3 >= r14) goto L16;
            r7[r3] = r7[r3] + (r111[r3] * r110);
            r3 = r3 + 1;
            goto L14
        L16:
            r19 = r19 + 1;
            r3 = 0;
            goto L12
        L17:
            int r20 = 0;
        L18:
            if (r20 >= r14) goto L20;
            r7[r20] = r7[r20] * r18;
            r20 = r20 + 1;
            goto L18
        L20:
            int r21 = r11;
        L21:
            if (r21 >= r4) goto L26;
            double r112 = r17[r21];
            double[] r113 = r9[r21];
            int r114 = 0;
        L23:
            if (r114 >= r14) goto L25;
            r113[r114] = r113[r114] + (r7[r114] * r112);
            r114 = r114 + 1;
            goto L23
        L25:
            r21 = r21 + 1;
            goto L21
        L26:
            r11 = r11 + 1;
            r3 = 0;
            goto L9
        L27:
            int r22 = this.rDiag.length - 1;
        L28:
            if (r22 < 0) goto L39;
            int r115 = r22 / 52;
            int r116 = r115 * 52;
            double r117 = r12 / this.rDiag[r22];
            double[] r118 = r9[r22];
            double[] r119 = r8[(r115 * r6) + r16];
            int r120 = (r22 - r116) * r14;
            int r121 = 0;
        L30:
            if (r121 >= r14) goto L32;
            double r23 = r118[r121] * r117;
            r118[r121] = r23;
            r119[r120] = r23;
            r121 = r121 + 1;
            r120 = r120 + 1;
            goto L30
        L32:
            double[] r122 = this.qrt[r22];
            int r123 = 0;
        L33:
            if (r123 >= r22) goto L38;
            double r124 = r122[r123];
            double[] r125 = r9[r123];
            int r126 = 0;
        L35:
            if (r126 >= r14) goto L37;
            r125[r126] = r125[r126] - (r118[r126] * r124);
            r126 = r126 + 1;
            goto L35
        L37:
            r123 = r123 + 1;
            goto L33
        L38:
            r22 = r22 - 1;
            r12 = 1.0d;
            goto L28
        L39:
            r15 = r16 + 1;
            r3 = 0;
            goto L7
        L41:
            return new BlockRealMatrix(r2, r5, r8, false);
        L43:
            throw new SingularMatrixException();
        L45:
            throw new DimensionMismatchException(r27.getRowDimension(), r4);
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix getInverse() {
            return solve(MatrixUtils.createRealIdentityMatrix(this.qrt[0].length));
        }
    }

    public QRDecomposition(RealMatrix r3) {
        this(r3, 0.0d);
    }

    public QRDecomposition(RealMatrix r1, double r2) {
        this.threshold = r2;
        int r3 = r1.getRowDimension();
        int r4 = r1.getColumnDimension();
        this.qrt = r1.transpose().getData();
        this.rDiag = new double[FastMath.min(r3, r4)];
        this.cachedQ = null;
        this.cachedQT = null;
        this.cachedR = null;
        this.cachedH = null;
        decompose(this.qrt);
    }

    protected void decompose(double[][] r5) {
        int r1 = 0;
    L4:
        if (r1 >= FastMath.min(r5.length, r5[0].length)) goto L6;
        performHouseholderReflection(r1, r5);
        r1 = r1 + 1;
        goto L4
    }

    protected void performHouseholderReflection(int r14, double[][] r15) {
        double[] r0 = r15[r14];
        int r3 = r14;
        double r4 = 0.0d;
    L4:
        if (r3 >= r0.length) goto L7;
        double r6 = r0[r3];
        r4 = r4 + (r6 * r6);
        r3 = r3 + 1;
        goto L4
    L7:
        if (r0[r14] <= 0.0d) goto L9;
        double r5 = -FastMath.sqrt(r4);
    L10:
        this.rDiag[r14] = r5;
        if (r5 == 0.0d) goto L24;
        r0[r14] = r0[r14] - r5;
        int r13 = r14 + 1;
    L14:
        if (r13 >= r15.length) goto L29;
        double[] r7 = r15[r13];
        int r8 = r14;
        double r9 = 0.0d;
    L17:
        if (r8 >= r7.length) goto L19;
        r9 = r9 - (r7[r8] * r0[r8]);
        r8 = r8 + 1;
        goto L17
    L19:
        double r10 = r9 / (r0[r14] * r5);
        int r11 = r14;
    L21:
        if (r11 >= r7.length) goto L23;
        r7[r11] = r7[r11] - (r0[r11] * r10);
        r11 = r11 + 1;
        goto L21
    L23:
        r13 = r13 + 1;
        goto L14
    L29:
        return;
    L24:
        return;
    L9:
        r5 = FastMath.sqrt(r4);
        goto L10
    }

    public RealMatrix getR() {
        if (this.cachedR != null) goto L12;
        double[][] r0 = this.qrt;
        int r1 = r0.length;
        int r2 = r0[0].length;
        double[][] r3 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r2, r1});
        int r4 = FastMath.min(r2, r1) - 1;
    L5:
        if (r4 < 0) goto L10;
        r3[r4][r4] = this.rDiag[r4];
        int r5 = r4 + 1;
    L7:
        if (r5 >= r1) goto L9;
        r3[r4][r5] = this.qrt[r5][r4];
        r5 = r5 + 1;
        goto L7
    L9:
        r4 = r4 - 1;
        goto L5
    L10:
        this.cachedR = MatrixUtils.createRealMatrix(r3);
    L12:
        return this.cachedR;
    }

    public RealMatrix getQ() {
        if (this.cachedQ != null) goto L6;
        this.cachedQ = getQT().transpose();
    L6:
        return this.cachedQ;
    }

    public RealMatrix getQT() {
        if (this.cachedQT != null) goto L24;
        double[][] r1 = this.qrt;
        int r2 = r1.length;
        int r3 = r1[0].length;
        double[][] r4 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r3, r3});
        int r5 = r3 - 1;
    L5:
        double r7 = 1.0d;
        if (r5 < FastMath.min(r3, r2)) goto L8;
        r4[r5][r5] = 1.0d;
        r5 = r5 - 1;
        goto L5
    L8:
        int r6 = FastMath.min(r3, r2) - 1;
    L9:
        if (r6 < 0) goto L22;
        double[] r8 = this.qrt[r6];
        r4[r6][r6] = r7;
        if (r8[r6] == 0.0d) goto L21;
        int r9 = r6;
    L13:
        if (r9 >= r3) goto L21;
        int r10 = r6;
        double r11 = 0.0d;
    L15:
        if (r10 >= r3) goto L17;
        r11 = r11 - (r4[r9][r10] * r8[r10]);
        r10 = r10 + 1;
        goto L15
    L17:
        double r12 = r11 / (this.rDiag[r6] * r8[r6]);
        int r13 = r6;
    L18:
        if (r13 >= r3) goto L20;
        double[] r14 = r4[r9];
        r14[r13] = r14[r13] + ((-r12) * r8[r13]);
        r13 = r13 + 1;
        goto L18
    L20:
        r9 = r9 + 1;
    L21:
        r6 = r6 - 1;
        r7 = 1.0d;
        goto L9
    L22:
        this.cachedQT = MatrixUtils.createRealMatrix(r4);
    L24:
        return this.cachedQT;
    }

    public RealMatrix getH() {
        if (this.cachedH != null) goto L13;
        double[][] r0 = this.qrt;
        int r1 = r0.length;
        int r2 = r0[0].length;
        double[][] r3 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r2, r1});
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L11;
        int r5 = 0;
    L7:
        int r6 = r4 + 1;
        if (r5 >= FastMath.min(r6, r1)) goto L10;
        r3[r4][r5] = this.qrt[r5][r4] / (-this.rDiag[r5]);
        r5 = r5 + 1;
        goto L7
    L10:
        r4 = r6;
        goto L5
    L11:
        this.cachedH = MatrixUtils.createRealMatrix(r3);
    L13:
        return this.cachedH;
    }

    public DecompositionSolver getSolver() {
        return new Solver(this.qrt, this.rDiag, this.threshold, null);
    }
}
