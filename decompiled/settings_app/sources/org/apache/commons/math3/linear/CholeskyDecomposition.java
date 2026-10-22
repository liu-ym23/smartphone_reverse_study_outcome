package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class CholeskyDecomposition {
    public static final double DEFAULT_ABSOLUTE_POSITIVITY_THRESHOLD = 1.0E-10d;
    public static final double DEFAULT_RELATIVE_SYMMETRY_THRESHOLD = 1.0E-15d;
    private RealMatrix cachedL;
    private RealMatrix cachedLT;
    private double[][] lTData;

    /* JADX INFO: renamed from: org.apache.commons.math3.linear.CholeskyDecomposition$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Solver implements DecompositionSolver {
        private final double[][] lTData;

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public boolean isNonSingular() {
            return true;
        }

        /* synthetic */ Solver(double[][] r1, AnonymousClass1 r2) {
            this(r1);
        }

        private Solver(double[][] r1) {
            this.lTData = r1;
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealVector solve(RealVector r12) {
            int r0 = this.lTData.length;
            if (r12.getDimension() != r0) goto L18;
            double[] r13 = r12.toArray();
            int r2 = 0;
        L5:
            if (r2 >= r0) goto L9;
            double[] r3 = this.lTData[r2];
            double r4 = r13[r2] / r3[r2];
            r13[r2] = r4;
            r2 = r2 + 1;
            int r6 = r2;
        L7:
            if (r6 >= r0) goto L5;
            r13[r6] = r13[r6] - (r3[r6] * r4);
            r6 = r6 + 1;
            goto L7
        L9:
            int r1 = r0 - 1;
        L10:
            if (r1 < 0) goto L16;
            double r5 = r13[r1] / this.lTData[r1][r1];
            r13[r1] = r5;
            int r7 = 0;
        L12:
            if (r7 >= r1) goto L14;
            r13[r7] = r13[r7] - (this.lTData[r7][r1] * r5);
            r7 = r7 + 1;
            goto L12
        L14:
            r1 = r1 - 1;
            goto L10
        L16:
            return new ArrayRealVector(r13, false);
        L18:
            throw new DimensionMismatchException(r12.getDimension(), r0);
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix solve(RealMatrix r18) {
            int r1 = this.lTData.length;
            if (r18.getRowDimension() != r1) goto L30;
            int r2 = r18.getColumnDimension();
            double[][] r3 = r18.getData();
            int r5 = 0;
        L5:
            if (r5 >= r1) goto L15;
            double[] r6 = this.lTData[r5];
            double r7 = r6[r5];
            double[] r9 = r3[r5];
            int r10 = 0;
        L7:
            if (r10 >= r2) goto L9;
            r9[r10] = r9[r10] / r7;
            r10 = r10 + 1;
            goto L7
        L9:
            r5 = r5 + 1;
            int r8 = r5;
        L10:
            if (r8 >= r1) goto L5;
            double[] r11 = r3[r8];
            double r12 = r6[r8];
            int r13 = 0;
        L12:
            if (r13 >= r2) goto L14;
            r11[r13] = r11[r13] - (r9[r13] * r12);
            r13 = r13 + 1;
            goto L12
        L14:
            r8 = r8 + 1;
            goto L10
        L15:
            int r4 = r1 - 1;
        L16:
            if (r4 < 0) goto L28;
            double r14 = this.lTData[r4][r4];
            double[] r15 = r3[r4];
            int r16 = 0;
        L18:
            if (r16 >= r2) goto L20;
            r15[r16] = r15[r16] / r14;
            r16 = r16 + 1;
            goto L18
        L20:
            int r17 = 0;
        L21:
            if (r17 >= r4) goto L26;
            double[] r19 = r3[r17];
            double r20 = this.lTData[r17][r4];
            int r110 = 0;
        L23:
            if (r110 >= r2) goto L25;
            r19[r110] = r19[r110] - (r15[r110] * r20);
            r110 = r110 + 1;
            goto L23
        L25:
            r17 = r17 + 1;
            goto L21
        L26:
            r4 = r4 - 1;
            goto L16
        L28:
            return new Array2DRowRealMatrix(r3);
        L30:
            throw new DimensionMismatchException(r18.getRowDimension(), r1);
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix getInverse() {
            return solve(MatrixUtils.createRealIdentityMatrix(this.lTData.length));
        }
    }

    public CholeskyDecomposition(RealMatrix r7) {
        this(r7, 1.0E-15d, 1.0E-10d);
    }

    public CholeskyDecomposition(RealMatrix r18, double r19, double r21) {
        if (r18.isSquare() == false) goto L29;
        int r3 = r18.getRowDimension();
        this.lTData = r18.getData();
        this.cachedL = null;
        this.cachedLT = null;
        int r5 = 0;
    L5:
        if (r5 >= r3) goto L14;
        double[] r6 = this.lTData[r5];
        int r7 = r5 + 1;
        int r8 = r7;
    L7:
        if (r8 >= r3) goto L13;
        double[] r9 = this.lTData[r8];
        double r10 = r6[r8];
        double r12 = r9[r5];
        int r16 = r5;
        if (FastMath.abs(r10 - r12) > (FastMath.max(FastMath.abs(r10), FastMath.abs(r12)) * r19)) goto L12;
        r9[r16] = 0.0d;
        r8 = r8 + 1;
        r5 = r16;
        goto L7
    L12:
        throw new NonSymmetricMatrixException(r16, r8, r19);
    L13:
        r5 = r7;
        goto L5
    L14:
        int r13 = 0;
    L15:
        if (r13 >= r3) goto L27;
        double[] r1 = this.lTData[r13];
        double r4 = r1[r13];
        if (r4 <= r21) goto L26;
        double r11 = FastMath.sqrt(r4);
        r1[r13] = r11;
        double r14 = 1.0d / r11;
        int r2 = r3 - 1;
    L19:
        if (r2 <= r13) goto L24;
        r1[r2] = r1[r2] * r14;
        double[] r15 = this.lTData[r2];
        int r17 = r2;
    L21:
        if (r17 >= r3) goto L23;
        r15[r17] = r15[r17] - (r1[r2] * r1[r17]);
        r17 = r17 + 1;
        goto L21
    L23:
        r2 = r2 - 1;
        goto L19
    L24:
        r13 = r13 + 1;
        goto L15
    L26:
        throw new NonPositiveDefiniteMatrixException(r1[r13], r13, r21);
    L27:
        return;
    L29:
        throw new NonSquareMatrixException(r18.getRowDimension(), r18.getColumnDimension());
    }

    public RealMatrix getL() {
        if (this.cachedL != null) goto L6;
        this.cachedL = getLT().transpose();
    L6:
        return this.cachedL;
    }

    public RealMatrix getLT() {
        if (this.cachedLT != null) goto L6;
        this.cachedLT = MatrixUtils.createRealMatrix(this.lTData);
    L6:
        return this.cachedLT;
    }

    public double getDeterminant() {
        double r0 = 1.0d;
        int r2 = 0;
    L3:
        double[][] r3 = this.lTData;
        if (r2 >= r3.length) goto L6;
        double r4 = r3[r2][r2];
        r0 = r0 * (r4 * r4);
        r2 = r2 + 1;
        goto L3
    L6:
        return r0;
    }

    public DecompositionSolver getSolver() {
        return new Solver(this.lTData, null);
    }
}
