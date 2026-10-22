package org.apache.commons.math3.linear;

import java.lang.reflect.Array;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class LUDecomposition {
    private static final double DEFAULT_TOO_SMALL = 1.0E-11d;
    private RealMatrix cachedL;
    private RealMatrix cachedP;
    private RealMatrix cachedU;
    private boolean even;
    private final double[][] lu;
    private final int[] pivot;
    private boolean singular;

    /* JADX INFO: renamed from: org.apache.commons.math3.linear.LUDecomposition$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Solver implements DecompositionSolver {
        private final double[][] lu;
        private final int[] pivot;
        private final boolean singular;

        /* synthetic */ Solver(double[][] r1, int[] r2, boolean r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        private Solver(double[][] r1, int[] r2, boolean r3) {
            this.lu = r1;
            this.pivot = r2;
            this.singular = r3;
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public boolean isNonSingular() {
            return !this.singular;
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealVector solve(RealVector r12) {
            int r0 = this.pivot.length;
            if (r12.getDimension() != r0) goto L26;
            if (this.singular == true) goto L24;
            double[] r1 = new double[r0];
            int r3 = 0;
        L7:
            if (r3 >= r0) goto L9;
            r1[r3] = r12.getEntry(this.pivot[r3]);
            r3 = r3 + 1;
            goto L7
        L9:
            int r13 = 0;
        L10:
            if (r13 >= r0) goto L15;
            double r4 = r1[r13];
            int r5 = r13 + 1;
            int r6 = r5;
        L12:
            if (r6 >= r0) goto L14;
            r1[r6] = r1[r6] - (this.lu[r6][r13] * r4);
            r6 = r6 + 1;
            goto L12
        L14:
            r13 = r5;
            goto L10
        L15:
            int r2 = r0 - 1;
        L16:
            if (r2 < 0) goto L22;
            double r7 = r1[r2] / this.lu[r2][r2];
            r1[r2] = r7;
            int r14 = 0;
        L18:
            if (r14 >= r2) goto L20;
            r1[r14] = r1[r14] - (this.lu[r14][r2] * r7);
            r14 = r14 + 1;
            goto L18
        L20:
            r2 = r2 - 1;
            goto L16
        L22:
            return new ArrayRealVector(r1, false);
        L24:
            throw new SingularMatrixException();
        L26:
            throw new DimensionMismatchException(r12.getDimension(), r0);
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix solve(RealMatrix r19) {
            int r1 = this.pivot.length;
            if (r19.getRowDimension() != r1) goto L38;
            if (this.singular == true) goto L36;
            int r2 = r19.getColumnDimension();
            double[][] r3 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r1, r2});
            int r6 = 0;
        L7:
            if (r6 >= r1) goto L12;
            double[] r7 = r3[r6];
            int r8 = this.pivot[r6];
            int r9 = 0;
        L9:
            if (r9 >= r2) goto L11;
            r7[r9] = r19.getEntry(r8, r9);
            r9 = r9 + 1;
            goto L9
        L11:
            r6 = r6 + 1;
            goto L7
        L12:
            int r10 = 0;
        L13:
            if (r10 >= r1) goto L21;
            double[] r11 = r3[r10];
            int r12 = r10 + 1;
            int r13 = r12;
        L15:
            if (r13 >= r1) goto L20;
            double[] r14 = r3[r13];
            double r15 = this.lu[r13][r10];
            int r16 = 0;
        L17:
            if (r16 >= r2) goto L19;
            r14[r16] = r14[r16] - (r11[r16] * r15);
            r16 = r16 + 1;
            goto L17
        L19:
            r13 = r13 + 1;
            goto L15
        L20:
            r10 = r12;
            goto L13
        L21:
            int r4 = r1 - 1;
        L22:
            if (r4 < 0) goto L34;
            double[] r5 = r3[r4];
            double r17 = this.lu[r4][r4];
            int r18 = 0;
        L24:
            if (r18 >= r2) goto L26;
            r5[r18] = r5[r18] / r17;
            r18 = r18 + 1;
            goto L24
        L26:
            int r20 = 0;
        L27:
            if (r20 >= r4) goto L32;
            double[] r21 = r3[r20];
            double r22 = this.lu[r20][r4];
            int r110 = 0;
        L29:
            if (r110 >= r2) goto L31;
            r21[r110] = r21[r110] - (r5[r110] * r22);
            r110 = r110 + 1;
            goto L29
        L31:
            r20 = r20 + 1;
            goto L27
        L32:
            r4 = r4 - 1;
            goto L22
        L34:
            return new Array2DRowRealMatrix(r3, false);
        L36:
            throw new SingularMatrixException();
        L38:
            throw new DimensionMismatchException(r19.getRowDimension(), r1);
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix getInverse() {
            return solve(MatrixUtils.createRealIdentityMatrix(this.pivot.length));
        }
    }

    public LUDecomposition(RealMatrix r3) {
        this(r3, DEFAULT_TOO_SMALL);
    }

    public LUDecomposition(RealMatrix r18, double r19) {
        if (r18.isSquare() == false) goto L39;
        int r1 = r18.getColumnDimension();
        this.lu = r18.getData();
        this.pivot = new int[r1];
        this.cachedL = null;
        this.cachedU = null;
        this.cachedP = null;
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L7;
        this.pivot[r3] = r3;
        r3 = r3 + 1;
        goto L5
    L7:
        this.even = true;
        this.singular = false;
        int r4 = 0;
    L8:
        if (r4 >= r1) goto L37;
        int r5 = 0;
    L10:
        if (r5 >= r4) goto L15;
        double[] r6 = this.lu[r5];
        double r7 = r6[r4];
        int r9 = 0;
    L12:
        if (r9 >= r5) goto L14;
        r7 = r7 - (r6[r9] * this.lu[r9][r4]);
        r9 = r9 + 1;
        goto L12
    L14:
        r6[r4] = r7;
        r5 = r5 + 1;
        goto L10
    L15:
        double r8 = Double.NEGATIVE_INFINITY;
        int r10 = r4;
        int r11 = r10;
    L16:
        if (r10 >= r1) goto L25;
        double[] r12 = this.lu[r10];
        double r13 = r12[r4];
        int r14 = 0;
    L18:
        if (r14 >= r4) goto L20;
        r13 = r13 - (r12[r14] * this.lu[r14][r4]);
        r14 = r14 + 1;
        goto L18
    L20:
        r12[r4] = r13;
        if (FastMath.abs(r13) <= r8) goto L23;
        r8 = FastMath.abs(r13);
        r11 = r10;
    L23:
        r10 = r10 + 1;
        goto L16
    L25:
        if (FastMath.abs(this.lu[r11][r4]) < r19) goto L26;
        if (r11 == r4) goto L33;
        double[][] r15 = this.lu;
        double[] r16 = r15[r11];
        double[] r17 = r15[r4];
        int r20 = 0;
    L30:
        if (r20 >= r1) goto L32;
        double r21 = r16[r20];
        r16[r20] = r17[r20];
        r17[r20] = r21;
        r20 = r20 + 1;
        goto L30
    L32:
        int[] r22 = this.pivot;
        int r23 = r22[r11];
        r22[r11] = r22[r4];
        r22[r4] = r23;
        this.even = !this.even;
    L33:
        double r24 = this.lu[r4][r4];
        int r25 = r4 + 1;
        int r26 = r25;
    L34:
        if (r26 >= r1) goto L36;
        double[] r27 = this.lu[r26];
        r27[r4] = r27[r4] / r24;
        r26 = r26 + 1;
        goto L34
    L36:
        r4 = r25;
        goto L8
    L26:
        this.singular = true;
        return;
    L37:
        return;
    L39:
        throw new NonSquareMatrixException(r18.getRowDimension(), r18.getColumnDimension());
    }

    public RealMatrix getL() {
        if (this.cachedL != null) goto L13;
        if (this.singular == true) goto L13;
        int r0 = this.pivot.length;
        this.cachedL = MatrixUtils.createRealMatrix(r0, r0);
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L13;
        double[] r3 = this.lu[r2];
        int r4 = 0;
    L9:
        if (r4 >= r2) goto L11;
        this.cachedL.setEntry(r2, r4, r3[r4]);
        r4 = r4 + 1;
        goto L9
    L11:
        this.cachedL.setEntry(r2, r2, 1.0d);
        r2 = r2 + 1;
    L13:
        return this.cachedL;
    }

    public RealMatrix getU() {
        if (this.cachedU != null) goto L13;
        if (this.singular == true) goto L13;
        int r0 = this.pivot.length;
        this.cachedU = MatrixUtils.createRealMatrix(r0, r0);
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L13;
        double[] r2 = this.lu[r1];
        int r3 = r1;
    L9:
        if (r3 >= r0) goto L11;
        this.cachedU.setEntry(r1, r3, r2[r3]);
        r3 = r3 + 1;
        goto L9
    L11:
        r1 = r1 + 1;
    L13:
        return this.cachedU;
    }

    public RealMatrix getP() {
        if (this.cachedP != null) goto L10;
        if (this.singular == true) goto L10;
        int r0 = this.pivot.length;
        this.cachedP = MatrixUtils.createRealMatrix(r0, r0);
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L10;
        this.cachedP.setEntry(r1, this.pivot[r1], 1.0d);
        r1 = r1 + 1;
    L10:
        return this.cachedP;
    }

    public int[] getPivot() {
        return (int[]) this.pivot.clone();
    }

    public double getDeterminant() {
        if (this.singular == false) goto L6;
        return 0.0d;
    L6:
        int r0 = this.pivot.length;
        if (this.even == false) goto L9;
        double r1 = 1.0d;
    L10:
        int r3 = 0;
    L11:
        if (r3 >= r0) goto L13;
        r1 = r1 * this.lu[r3][r3];
        r3 = r3 + 1;
        goto L11
    L13:
        return r1;
    L9:
        r1 = -1.0d;
        goto L10
    }

    public DecompositionSolver getSolver() {
        return new Solver(this.lu, this.pivot, this.singular, null);
    }
}
