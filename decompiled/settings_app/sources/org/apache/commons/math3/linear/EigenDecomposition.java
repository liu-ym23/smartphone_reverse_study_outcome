package org.apache.commons.math3.linear;

import com.google.common.base.Ascii;
import java.lang.reflect.Array;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class EigenDecomposition {
    private static final double EPSILON = 1.0E-12d;
    private RealMatrix cachedD;
    private RealMatrix cachedV;
    private RealMatrix cachedVt;
    private ArrayRealVector[] eigenvectors;
    private double[] imagEigenvalues;
    private final boolean isSymmetric;
    private double[] main;
    private byte maxIter;
    private double[] realEigenvalues;
    private double[] secondary;
    private TriDiagonalTransformer transformer;

    /* JADX INFO: renamed from: org.apache.commons.math3.linear.EigenDecomposition$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Solver implements DecompositionSolver {
        private final ArrayRealVector[] eigenvectors;
        private double[] imagEigenvalues;
        private double[] realEigenvalues;

        /* synthetic */ Solver(double[] r1, double[] r2, ArrayRealVector[] r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        private Solver(double[] r1, double[] r2, ArrayRealVector[] r3) {
            this.realEigenvalues = r1;
            this.imagEigenvalues = r2;
            this.eigenvectors = r3;
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealVector solve(RealVector r13) {
            if (isNonSingular() == false) goto L17;
            int r0 = this.realEigenvalues.length;
            if (r13.getDimension() != r0) goto L15;
            double[] r1 = new double[r0];
            int r3 = 0;
        L7:
            if (r3 >= r0) goto L13;
            ArrayRealVector r4 = this.eigenvectors[r3];
            double[] r5 = r4.getDataRef();
            double r6 = r4.dotProduct(r13) / this.realEigenvalues[r3];
            int r7 = 0;
        L9:
            if (r7 >= r0) goto L11;
            r1[r7] = r1[r7] + (r5[r7] * r6);
            r7 = r7 + 1;
            goto L9
        L11:
            r3 = r3 + 1;
            goto L7
        L13:
            return new ArrayRealVector(r1, false);
        L15:
            throw new DimensionMismatchException(r13.getDimension(), r0);
        L17:
            throw new SingularMatrixException();
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix solve(RealMatrix r21) {
            if (isNonSingular() == false) goto L27;
            int r1 = this.realEigenvalues.length;
            if (r21.getRowDimension() != r1) goto L25;
            int r2 = r21.getColumnDimension();
            double[][] r3 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r1, r2});
            double[] r5 = new double[r1];
            int r6 = 0;
        L7:
            if (r6 >= r2) goto L23;
            int r7 = 0;
        L10:
            if (r7 >= r1) goto L12;
            r5[r7] = r21.getEntry(r7, r6);
            r3[r7][r6] = 0.0d;
            r7 = r7 + 1;
            goto L10
        L12:
            int r8 = 0;
        L13:
            if (r8 >= r1) goto L21;
            ArrayRealVector r11 = this.eigenvectors[r8];
            double[] r12 = r11.getDataRef();
            int r13 = 0;
            double r14 = 0.0d;
        L15:
            if (r13 >= r1) goto L17;
            r14 = r14 + (r11.getEntry(r13) * r5[r13]);
            r13 = r13 + 1;
            goto L15
        L17:
            double r15 = r14 / this.realEigenvalues[r8];
            int r16 = 0;
        L18:
            if (r16 >= r1) goto L20;
            double[] r17 = r3[r16];
            r17[r6] = r17[r6] + (r12[r16] * r15);
            r16 = r16 + 1;
            goto L18
        L20:
            r8 = r8 + 1;
            goto L13
        L21:
            r6 = r6 + 1;
            goto L7
        L23:
            return new Array2DRowRealMatrix(r3, false);
        L25:
            throw new DimensionMismatchException(r21.getRowDimension(), r1);
        L27:
            throw new SingularMatrixException();
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public boolean isNonSingular() {
            double r4 = 0.0d;
            int r3 = 0;
        L4:
            if (r3 >= this.realEigenvalues.length) goto L7;
            r4 = FastMath.max(r4, eigenvalueNorm(r3));
            r3 = r3 + 1;
            goto L4
        L7:
            if (r4 != 0.0d) goto L9;
            return false;
        L9:
            int r0 = 0;
        L11:
            if (r0 >= this.realEigenvalues.length) goto L16;
            if (Precision.equals(eigenvalueNorm(r0) / r4, 0.0d, 1.0E-12d) == true) goto L14;
            r0 = r0 + 1;
            goto L11
        L14:
            return false;
        L16:
            return true;
        }

        private double eigenvalueNorm(int r3) {
            double r0 = this.realEigenvalues[r3];
            double r2 = this.imagEigenvalues[r3];
            return FastMath.sqrt((r0 * r0) + (r2 * r2));
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix getInverse() {
            if (isNonSingular() == false) goto L16;
            int r0 = this.realEigenvalues.length;
            double[][] r1 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r0, r0});
            int r3 = 0;
        L5:
            if (r3 >= r0) goto L14;
            double[] r4 = r1[r3];
            int r5 = 0;
        L7:
            if (r5 >= r0) goto L12;
            double r6 = 0.0d;
            int r8 = 0;
        L9:
            if (r8 >= r0) goto L11;
            double[] r9 = this.eigenvectors[r8].getDataRef();
            r6 = r6 + ((r9[r3] * r9[r5]) / this.realEigenvalues[r8]);
            r8 = r8 + 1;
            goto L9
        L11:
            r4[r5] = r6;
            r5 = r5 + 1;
            goto L7
        L12:
            r3 = r3 + 1;
            goto L5
        L14:
            return MatrixUtils.createRealMatrix(r1);
        L16:
            throw new SingularMatrixException();
        }
    }

    public EigenDecomposition(RealMatrix r5) throws MathArithmeticException {
        this.maxIter = Ascii.RS;
        boolean r0 = MatrixUtils.isSymmetric(r5, ((double) ((r5.getRowDimension() * 10) * r5.getColumnDimension())) * Precision.EPSILON);
        this.isSymmetric = r0;
        if (r0 == false) goto L5;
        transformToTridiagonal(r5);
        findEigenVectors(this.transformer.getQ().getData());
        return;
    L5:
        findEigenVectorsFromSchur(transformToSchur(r5));
    }

    @Deprecated
    public EigenDecomposition(RealMatrix r1, double r2) throws MathArithmeticException {
        this(r1);
    }

    public EigenDecomposition(double[] r5, double[] r6) {
        this.maxIter = Ascii.RS;
        this.isSymmetric = true;
        this.main = (double[]) r5.clone();
        this.secondary = (double[]) r6.clone();
        this.transformer = null;
        int r7 = r5.length;
        int r0 = 0;
        double[][] r8 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r7, r7});
    L3:
        if (r0 >= r7) goto L5;
        r8[r0][r0] = 1.0d;
        r0 = r0 + 1;
        goto L3
    L5:
        findEigenVectors(r8);
    }

    @Deprecated
    public EigenDecomposition(double[] r1, double[] r2, double r3) {
        this(r1, r2);
    }

    public RealMatrix getV() {
        if (this.cachedV != null) goto L8;
        int r0 = this.eigenvectors.length;
        this.cachedV = MatrixUtils.createRealMatrix(r0, r0);
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L8;
        this.cachedV.setColumnVector(r1, this.eigenvectors[r1]);
        r1 = r1 + 1;
    L8:
        return this.cachedV;
    }

    public RealMatrix getD() {
        if (this.cachedD != null) goto L15;
        this.cachedD = MatrixUtils.createRealDiagonalMatrix(this.realEigenvalues);
        int r0 = 0;
    L5:
        double[] r1 = this.imagEigenvalues;
        if (r0 >= r1.length) goto L15;
        if (Precision.compareTo(r1[r0], 0.0d, 1.0E-12d) <= 0) goto L11;
        this.cachedD.setEntry(r0, r0 + 1, this.imagEigenvalues[r0]);
    L13:
        r0 = r0 + 1;
        goto L5
    L11:
        if (Precision.compareTo(this.imagEigenvalues[r0], 0.0d, 1.0E-12d) >= 0) goto L13;
        this.cachedD.setEntry(r0, r0 - 1, this.imagEigenvalues[r0]);
    L15:
        return this.cachedD;
    }

    public RealMatrix getVT() {
        if (this.cachedVt != null) goto L8;
        int r0 = this.eigenvectors.length;
        this.cachedVt = MatrixUtils.createRealMatrix(r0, r0);
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L8;
        this.cachedVt.setRowVector(r1, this.eigenvectors[r1]);
        r1 = r1 + 1;
    L8:
        return this.cachedVt;
    }

    public boolean hasComplexEigenvalues() {
        int r1 = 0;
    L3:
        double[] r2 = this.imagEigenvalues;
        if (r1 >= r2.length) goto L10;
        if (Precision.equals(r2[r1], 0.0d, 1.0E-12d) == false) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return true;
    L10:
        return false;
    }

    public double[] getRealEigenvalues() {
        return (double[]) this.realEigenvalues.clone();
    }

    public double getRealEigenvalue(int r1) {
        return this.realEigenvalues[r1];
    }

    public double[] getImagEigenvalues() {
        return (double[]) this.imagEigenvalues.clone();
    }

    public double getImagEigenvalue(int r1) {
        return this.imagEigenvalues[r1];
    }

    public RealVector getEigenvector(int r1) {
        return this.eigenvectors[r1].copy();
    }

    public double getDeterminant() {
        double[] r6 = this.realEigenvalues;
        int r0 = r6.length;
        double r1 = 1.0d;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1 = r1 * r6[r3];
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    public RealMatrix getSquareRoot() {
        if (this.isSymmetric == false) goto L15;
        double[] r0 = new double[this.realEigenvalues.length];
        int r1 = 0;
    L5:
        double[] r2 = this.realEigenvalues;
        if (r1 >= r2.length) goto L12;
        double r3 = r2[r1];
        if (r3 <= 0.0d) goto L11;
        r0[r1] = FastMath.sqrt(r3);
        r1 = r1 + 1;
        goto L5
    L11:
        throw new MathUnsupportedOperationException();
    L12:
        RealMatrix r4 = MatrixUtils.createRealDiagonalMatrix(r0);
        RealMatrix r5 = getV();
        RealMatrix r6 = getVT();
        return r5.multiply(r4).multiply(r6);
    L15:
        throw new MathUnsupportedOperationException();
    }

    public DecompositionSolver getSolver() {
        if (hasComplexEigenvalues() == true) goto L7;
        return new Solver(this.realEigenvalues, this.imagEigenvalues, this.eigenvectors, null);
    L7:
        throw new MathUnsupportedOperationException();
    }

    private void transformToTridiagonal(RealMatrix r2) {
        TriDiagonalTransformer r0 = new TriDiagonalTransformer(r2);
        this.transformer = r0;
        this.main = r0.getMainDiagonalRef();
        this.secondary = this.transformer.getSecondaryDiagonalRef();
    }

    private void findEigenVectors(double[][] r38) {
        double[][] r1 = (double[][]) r38.clone();
        int r2 = this.main.length;
        this.realEigenvalues = new double[r2];
        this.imagEigenvalues = new double[r2];
        double[] r3 = new double[r2];
        int r5 = 0;
    L3:
        int r6 = r2 - 1;
        if (r5 >= r6) goto L6;
        this.realEigenvalues[r5] = this.main[r5];
        r3[r5] = this.secondary[r5];
        r5 = r5 + 1;
        goto L3
    L6:
        this.realEigenvalues[r6] = this.main[r6];
        r3[r6] = 0.0d;
        int r7 = 0;
        double r9 = 0.0d;
    L7:
        if (r7 >= r2) goto L16;
        if (FastMath.abs(this.realEigenvalues[r7]) <= r9) goto L12;
        r9 = FastMath.abs(this.realEigenvalues[r7]);
    L12:
        if (FastMath.abs(r3[r7]) <= r9) goto L14;
        r9 = FastMath.abs(r3[r7]);
    L14:
        r7 = r7 + 1;
        goto L7
    L16:
        if (r9 == 0.0d) goto L26;
        int r8 = 0;
    L18:
        if (r8 >= r2) goto L26;
        if (FastMath.abs(this.realEigenvalues[r8]) > (Precision.EPSILON * r9)) goto L23;
        this.realEigenvalues[r8] = 0.0d;
    L23:
        if (FastMath.abs(r3[r8]) > (Precision.EPSILON * r9)) goto L25;
        r3[r8] = 0.0d;
    L25:
        r8 = r8 + 1;
    L26:
        int r10 = 0;
    L27:
        if (r10 >= r2) goto L64;
        int r11 = 0;
    L29:
        int r12 = r10;
    L30:
        if (r12 >= r6) goto L35;
        int r14 = r12 + 1;
        double r13 = FastMath.abs(this.realEigenvalues[r12]) + FastMath.abs(this.realEigenvalues[r14]);
        if ((FastMath.abs(r3[r12]) + r13) == r13) goto L35;
        r12 = r14;
    L35:
        if (r12 == r10) goto L62;
        if (r11 == this.maxIter) goto L61;
        r11 = r11 + 1;
        double[] r15 = this.realEigenvalues;
        double r16 = (r15[r10 + 1] - r15[r10]) / (r3[r10] * 2.0d);
        double r17 = FastMath.sqrt((r16 * r16) + 1.0d);
        if (r16 >= 0.0d) goto L41;
        double[] r18 = this.realEigenvalues;
        double r20 = r18[r12] - r18[r10];
        double r22 = r3[r10];
        double r19 = r16 - r17;
    L42:
        double r21 = r20 + (r22 / r19);
        int r110 = r12 - 1;
        double r24 = 0.0d;
        double r111 = 1.0d;
        double r23 = 1.0d;
    L43:
        if (r110 < r10) goto L56;
        double r112 = r3[r110];
        double r113 = r111 * r112;
        double r25 = r23 * r112;
        if (FastMath.abs(r113) < FastMath.abs(r21)) goto L47;
        double r114 = r21 / r113;
        double r26 = FastMath.sqrt((r114 * r114) + 1.0d);
        r3[r110 + 1] = r113 * r26;
        r111 = 1.0d / r26;
        double r115 = r114 * r111;
        r17 = r26;
        double r27 = r115;
    L48:
        int r28 = r110 + 1;
        if (r3[r28] == 0.0d) goto L50;
        double[] r116 = this.realEigenvalues;
        double r29 = r116[r28] - r24;
        double r210 = ((r116[r110] - r29) * r111) + ((r27 * 2.0d) * r25);
        double r211 = r111 * r210;
        r116[r28] = r29 + r211;
        r21 = (r27 * r210) - r25;
        int r117 = 0;
    L52:
        if (r117 >= r2) goto L54;
        double[] r118 = r1[r117];
        double r212 = r118[r28];
        r118[r28] = (r118[r110] * r111) + (r27 * r212);
        r118[r110] = (r118[r110] * r27) - (r212 * r111);
        r117 = r117 + 1;
        goto L52
    L54:
        r110 = r110 - 1;
        r17 = r210;
        r23 = r27;
        r24 = r211;
        goto L43
    L50:
        double[] r119 = this.realEigenvalues;
        r119[r28] = r119[r28] - r24;
        r3[r12] = 0.0d;
        goto L56
    L47:
        double r120 = r113 / r21;
        r17 = FastMath.sqrt((r120 * r120) + 1.0d);
        r3[r110 + 1] = r21 * r17;
        r27 = 1.0d / r17;
        r111 = r120 * r27;
    L56:
        if (r17 != 0.0d) goto L59;
        if (r110 >= r10) goto L62;
    L59:
        double[] r121 = this.realEigenvalues;
        r121[r10] = r121[r10] - r24;
        r3[r10] = r21;
        r3[r12] = 0.0d;
        goto L62
    L41:
        double[] r122 = this.realEigenvalues;
        r20 = r122[r12] - r122[r10];
        r22 = r3[r10];
        r19 = r16 + r17;
        goto L42
    L61:
        throw new MaxCountExceededException(LocalizedFormats.CONVERGENCE_FAILED, Byte.valueOf(this.maxIter), new Object[0]);
    L62:
        if (r12 != r10) goto L29;
        r10 = r10 + 1;
        goto L27
    L64:
        int r4 = 0;
    L65:
        if (r4 >= r2) goto L77;
        double r30 = this.realEigenvalues[r4];
        int r31 = r4 + 1;
        int r123 = r4;
        int r124 = r31;
    L67:
        if (r124 >= r2) goto L72;
        double r125 = this.realEigenvalues[r124];
        if (r125 <= r30) goto L71;
        r123 = r124;
        r30 = r125;
    L71:
        r124 = r124 + 1;
        goto L67
    L72:
        if (r123 == r4) goto L76;
        double[] r126 = this.realEigenvalues;
        r126[r123] = r126[r4];
        r126[r4] = r30;
        int r32 = 0;
    L74:
        if (r32 >= r2) goto L76;
        double[] r33 = r1[r32];
        double r127 = r33[r4];
        r33[r4] = r33[r123];
        r33[r123] = r127;
        r32 = r32 + 1;
    L76:
        r4 = r31;
        goto L65
    L77:
        int r34 = 0;
        double r35 = 0.0d;
    L78:
        if (r34 >= r2) goto L84;
        if (FastMath.abs(this.realEigenvalues[r34]) <= r35) goto L82;
        r35 = FastMath.abs(this.realEigenvalues[r34]);
    L82:
        r34 = r34 + 1;
        goto L78
    L84:
        if (r35 == 0.0d) goto L91;
        int r36 = 0;
    L86:
        if (r36 >= r2) goto L91;
        if (FastMath.abs(this.realEigenvalues[r36]) >= (Precision.EPSILON * r35)) goto L90;
        this.realEigenvalues[r36] = 0.0d;
    L90:
        r36 = r36 + 1;
    L91:
        this.eigenvectors = new ArrayRealVector[r2];
        double[] r37 = new double[r2];
        int r39 = 0;
    L92:
        if (r39 >= r2) goto L97;
        int r40 = 0;
    L94:
        if (r40 >= r2) goto L96;
        r37[r40] = r1[r40][r39];
        r40 = r40 + 1;
        goto L94
    L96:
        this.eigenvectors[r39] = new ArrayRealVector(r37);
        r39 = r39 + 1;
        goto L92
    }

    private SchurTransformer transformToSchur(RealMatrix r18) {
        SchurTransformer r1 = new SchurTransformer(r18);
        double[][] r2 = r1.getT().getData();
        this.realEigenvalues = new double[r2.length];
        this.imagEigenvalues = new double[r2.length];
        int r3 = 0;
    L3:
        double[] r4 = this.realEigenvalues;
        if (r3 >= r4.length) goto L13;
        if (r3 == (r4.length - 1)) goto L11;
        int r5 = r3 + 1;
        if (Precision.equals(r2[r5][r3], 0.0d, 1.0E-12d) == true) goto L11;
        double[] r6 = r2[r5];
        double r7 = r6[r5];
        double[] r8 = r2[r3];
        double r9 = (r8[r3] - r7) * 0.5d;
        double r11 = FastMath.sqrt(FastMath.abs((r9 * r9) + (r6[r3] * r8[r5])));
        double[] r10 = this.realEigenvalues;
        double r12 = r7 + r9;
        r10[r3] = r12;
        double[] r13 = this.imagEigenvalues;
        r13[r3] = r11;
        r10[r5] = r12;
        r13[r5] = -r11;
        r3 = r5;
    L12:
        r3 = r3 + 1;
    L11:
        this.realEigenvalues[r3] = r2[r3][r3];
        goto L12
    L13:
        return r1;
    }

    private Complex cdiv(double r1, double r3, double r5, double r7) {
        return new Complex(r1, r3).divide2(new Complex(r5, r7));
    }

    private void findEigenVectorsFromSchur(SchurTransformer r47) throws MathArithmeticException {
        double[][] r10 = r47.getT().getData();
        double[][] r11 = r47.getP().getData();
        int r12 = r10.length;
        double r13 = 0.0d;
        double r16 = 0.0d;
        int r0 = 0;
    L3:
        if (r0 >= r12) goto L9;
        int r1 = FastMath.max(r0 - 1, 0);
    L5:
        if (r1 >= r12) goto L7;
        r16 = r16 + FastMath.abs(r10[r0][r1]);
        r1 = r1 + 1;
        goto L5
    L7:
        r0 = r0 + 1;
        goto L3
    L9:
        if (Precision.equals(r16, 0.0d, 1.0E-12d) == true) goto L96;
        int r7 = r12 - 1;
        int r8 = r7;
        double r18 = 0.0d;
        double r20 = 0.0d;
        double r22 = 0.0d;
    L11:
        if (r8 < 0) goto L78;
        double r24 = this.realEigenvalues[r8];
        double r5 = this.imagEigenvalues[r8];
        if (Precision.equals(r5, r13) == false) goto L40;
        r10[r8][r8] = 1.0d;
        int r2 = r8 - 1;
        int r3 = r8;
        double r4 = r18;
    L15:
        if (r2 < 0) goto L39;
        double r6 = r10[r2][r2] - r24;
        int r9 = r3;
    L17:
        if (r9 > r8) goto L20;
        r13 = r13 + (r10[r2][r9] * r10[r9][r8]);
        r9 = r9 + 1;
        goto L17
    L20:
        if (Precision.compareTo(this.imagEigenvalues[r2], 0.0d, 1.0E-12d) >= 0) goto L23;
        r20 = r6;
        r4 = r13;
    L38:
        r2 = r2 - 1;
        r7 = r7;
        r22 = r13;
        r11 = r11;
        r12 = r12;
        r13 = 0.0d;
        goto L15
    L23:
        if (Precision.equals(this.imagEigenvalues[r2], 0.0d) == true) goto L25;
        double[] r14 = r10[r2];
        int r15 = r2 + 1;
        double r17 = r14[r15];
        double r19 = r10[r15][r2];
        double r23 = this.realEigenvalues[r2];
        double r32 = (r23 - r24) * (r23 - r24);
        double r25 = this.imagEigenvalues[r2];
        double r26 = ((r17 * r4) - (r20 * r13)) / (r32 + (r25 * r25));
        r14[r8] = r26;
        if (FastMath.abs(r17) <= FastMath.abs(r20)) goto L31;
        r10[r15][r8] = ((-r13) - (r6 * r26)) / r17;
    L32:
        double r21 = FastMath.abs(r10[r2][r8]);
        if (((Precision.EPSILON * r21) * r21) <= 1.0d) goto L37;
        int r27 = r2;
    L35:
        if (r27 > r8) goto L37;
        double[] r28 = r10[r27];
        r28[r8] = r28[r8] / r21;
        r27 = r27 + 1;
    L37:
        r3 = r2;
        goto L38
    L31:
        r10[r15][r8] = ((-r4) - (r19 * r26)) / r20;
        goto L32
    L25:
        if (r6 == 0.0d) goto L27;
        r10[r2][r8] = (-r13) / r6;
        goto L32
    L27:
        r10[r2][r8] = (-r13) / (Precision.EPSILON * r16);
        goto L32
    L39:
        double[][] r30 = r11;
        int r31 = r12;
        r18 = r4;
        int r36 = r7;
    L76:
        int r29 = r8;
    L77:
        r8 = r29 - 1;
        r11 = r30;
        r12 = r31;
        r7 = r36;
        r13 = 0.0d;
        goto L11
    L40:
        int r48 = r7;
        r30 = r11;
        r31 = r12;
        if (r5 >= r13) goto L75;
        int r110 = r8 - 1;
        if (FastMath.abs(r10[r8][r110]) <= FastMath.abs(r10[r110][r8])) goto L45;
        double[] r33 = r10[r110];
        double[] r34 = r10[r8];
        r33[r110] = r5 / r34[r110];
        r33[r8] = (-(r34[r8] - r24)) / r34[r110];
        double r35 = r5;
        int r111 = r8;
    L46:
        double[] r37 = r10[r111];
        r37[r110] = 0.0d;
        r37[r111] = 1.0d;
        int r112 = r111 - 2;
        int r38 = r110;
        double r39 = r18;
        double r40 = r22;
    L47:
        if (r112 < 0) goto L74;
        int r113 = r38;
        double r41 = 0.0d;
        double r42 = 0.0d;
    L49:
        if (r113 > r111) goto L51;
        double r114 = r10[r112][r113];
        double[] r210 = r10[r113];
        r42 = r42 + (r210[r110] * r114);
        r41 = r41 + (r114 * r210[r111]);
        r113 = r113 + 1;
        goto L49
    L51:
        double r115 = r10[r112][r112] - r24;
        if (Precision.compareTo(this.imagEigenvalues[r112], 0.0d, 1.0E-12d) >= 0) goto L54;
        r40 = r42;
        int r310 = r48;
        int r43 = r111;
        r20 = r115;
    L73:
        r112 = r112 - 1;
        r111 = r43;
        r48 = r310;
        r39 = r41;
        goto L47
    L54:
        double r211 = r40;
        double r311 = r39;
        if (Precision.equals(this.imagEigenvalues[r112], 0.0d) == false) goto L57;
        Complex r44 = cdiv(-r42, -r41, r115, r35);
        r10[r112][r110] = r44.getReal();
        r10[r112][r111] = r44.getImaginary();
        r310 = r48;
        int r312 = r111;
        double r116 = r311;
        double r117 = r211;
    L66:
        double r45 = FastMath.max(FastMath.abs(r10[r112][r110]), FastMath.abs(r10[r112][r312]));
        if (((Precision.EPSILON * r45) * r45) <= 1.0d) goto L71;
        int r46 = r112;
        r43 = r312;
    L69:
        if (r46 > r43) goto L72;
        double[] r49 = r10[r46];
        r49[r110] = r49[r110] / r45;
        r49[r43] = r49[r43] / r45;
        r46 = r46 + 1;
    L72:
        r40 = r117;
        r38 = r112;
        r41 = r116;
        goto L73
    L71:
        r43 = r312;
        goto L72
    L57:
        int r118 = r112 + 1;
        double r212 = r10[r112][r118];
        double r313 = r10[r118][r112];
        double r50 = this.realEigenvalues[r112];
        double r314 = this.imagEigenvalues[r112];
        double r51 = (((r50 - r24) * (r50 - r24)) + (r314 * r314)) - (r35 * r35);
        double r52 = ((r50 - r24) * 2.0d) * r35;
        r310 = r48;
        r312 = r111;
        if (Precision.equals(r51, 0.0d) == true) goto L60;
    L62:
        double r119 = r41;
        double r120 = r42;
        Complex r53 = cdiv(((r212 * r211) - (r20 * r42)) + (r35 * r41), ((r212 * r311) - (r20 * r41)) - (r35 * r42), r51, r52);
        r10[r112][r110] = r53.getReal();
        r10[r112][r312] = r53.getImaginary();
        if (FastMath.abs(r212) <= (FastMath.abs(r20) + FastMath.abs(r35))) goto L65;
        double[] r54 = r10[r118];
        double[] r55 = r10[r112];
        r54[r110] = (((-r120) - (r55[r110] * r115)) + (r35 * r55[r312])) / r212;
        r54[r312] = (((-r119) - (r115 * r55[r312])) - (r35 * r55[r110])) / r212;
        r117 = r211;
        r116 = r311;
        goto L66
    L65:
        r117 = r211;
        double[] r56 = r10[r112];
        r116 = r311;
        Complex r57 = cdiv((-r117) - (r56[r110] * r313), (-r311) - (r313 * r56[r312]), r20, r35);
        r10[r118][r110] = r57.getReal();
        r10[r118][r312] = r57.getImaginary();
        goto L66
    L60:
        if (Precision.equals(r52, 0.0d) == false) goto L62;
        r51 = (Precision.EPSILON * r16) * ((((FastMath.abs(r115) + FastMath.abs(r35)) + FastMath.abs(r212)) + FastMath.abs(r313)) + FastMath.abs(r20));
        goto L62
    L74:
        r18 = r39;
        r36 = r48;
        r29 = r111;
        r22 = r40;
        goto L77
    L45:
        double[] r58 = r10[r110];
        r35 = r5;
        r111 = r8;
        Complex r59 = cdiv(0.0d, -r58[r8], r58[r110] - r24, r35);
        r10[r110][r110] = r59.getReal();
        r10[r110][r111] = r59.getImaginary();
        goto L46
    L75:
        r36 = r48;
        goto L76
    L78:
        int r315 = r7;
        double[][] r316 = r11;
        int r317 = r12;
    L79:
        if (r7 < 0) goto L88;
        int r121 = r315;
        int r60 = 0;
    L81:
        if (r60 > r121) goto L87;
        double r61 = 0.0d;
        int r62 = 0;
    L84:
        if (r62 > FastMath.min(r7, r121)) goto L86;
        r61 = r61 + (r316[r60][r62] * r10[r62][r7]);
        r62 = r62 + 1;
        goto L84
    L86:
        r316[r60][r7] = r61;
        r60 = r60 + 1;
        goto L81
    L87:
        r7 = r7 - 1;
        r315 = r121;
        goto L79
    L88:
        this.eigenvectors = new ArrayRealVector[r317];
        double[] r63 = new double[r317];
        int r64 = 0;
    L89:
        if (r64 >= r317) goto L94;
        int r65 = 0;
    L91:
        if (r65 >= r317) goto L93;
        r63[r65] = r316[r65][r64];
        r65 = r65 + 1;
        goto L91
    L93:
        this.eigenvectors[r64] = new ArrayRealVector(r63);
        r64 = r64 + 1;
        goto L89
    L94:
        return;
    L96:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }
}
