package org.apache.commons.math3.linear;

import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class RRQRDecomposition extends QRDecomposition {
    private RealMatrix cachedP;
    private int[] p;

    /* JADX INFO: renamed from: org.apache.commons.math3.linear.RRQRDecomposition$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Solver implements DecompositionSolver {
        private RealMatrix p;
        private final DecompositionSolver upper;

        /* synthetic */ Solver(DecompositionSolver r1, RealMatrix r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private Solver(DecompositionSolver r1, RealMatrix r2) {
            this.upper = r1;
            this.p = r2;
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public boolean isNonSingular() {
            return this.upper.isNonSingular();
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealVector solve(RealVector r2) {
            return this.p.operate(this.upper.solve(r2));
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix solve(RealMatrix r2) {
            return this.p.multiply(this.upper.solve(r2));
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix getInverse() {
            return solve(MatrixUtils.createRealIdentityMatrix(this.p.getRowDimension()));
        }
    }

    public RRQRDecomposition(RealMatrix r3) {
        this(r3, 0.0d);
    }

    public RRQRDecomposition(RealMatrix r1, double r2) {
        super(r1, r2);
    }

    @Override // org.apache.commons.math3.linear.QRDecomposition
    protected void decompose(double[][] r4) {
        this.p = new int[r4.length];
        int r0 = 0;
    L3:
        int[] r1 = this.p;
        if (r0 >= r1.length) goto L6;
        r1[r0] = r0;
        r0 = r0 + 1;
        goto L3
    L6:
        super.decompose(r4);
    }

    @Override // org.apache.commons.math3.linear.QRDecomposition
    protected void performHouseholderReflection(int r12, double[][] r13) {
        int r2 = r12;
        int r3 = r2;
        double r4 = 0.0d;
    L4:
        if (r2 >= r13.length) goto L13;
        int r6 = 0;
        double r7 = 0.0d;
    L6:
        double[] r9 = r13[r2];
        if (r6 >= r9.length) goto L10;
        double r10 = r9[r6];
        r7 = r7 + (r10 * r10);
        r6 = r6 + 1;
        goto L6
    L10:
        if (r7 <= r4) goto L12;
        r3 = r2;
        r4 = r7;
    L12:
        r2 = r2 + 1;
        goto L4
    L13:
        if (r3 == r12) goto L15;
        double[] r0 = r13[r12];
        r13[r12] = r13[r3];
        r13[r3] = r0;
        int[] r1 = this.p;
        int r5 = r1[r12];
        r1[r12] = r1[r3];
        r1[r3] = r5;
    L15:
        super.performHouseholderReflection(r12, r13);
    }

    public RealMatrix getP() {
        if (this.cachedP != null) goto L8;
        int r0 = this.p.length;
        this.cachedP = MatrixUtils.createRealMatrix(r0, r0);
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L8;
        this.cachedP.setEntry(this.p[r1], r1, 1.0d);
        r1 = r1 + 1;
    L8:
        return this.cachedP;
    }

    public int getRank(double r12) {
        RealMatrix r11 = getR();
        int r0 = r11.getRowDimension();
        int r1 = r11.getColumnDimension();
        double r2 = r11.getFrobeniusNorm();
        int r4 = 1;
        double r5 = r2;
    L4:
        if (r4 >= FastMath.min(r0, r1)) goto L11;
        double r7 = r11.getSubMatrix(r4, r0 - 1, r4, r1 - 1).getFrobeniusNorm();
        if (r7 == 0.0d) goto L11;
        if (((r7 / r5) * r2) < r12) goto L11;
        r4 = r4 + 1;
        r5 = r7;
    L11:
        return r4;
    }

    @Override // org.apache.commons.math3.linear.QRDecomposition
    public DecompositionSolver getSolver() {
        return new Solver(super.getSolver(), getP(), null);
    }
}
