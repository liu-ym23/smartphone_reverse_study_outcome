package org.apache.commons.math3.linear;

import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class DiagonalMatrix extends AbstractRealMatrix implements Serializable {
    private static final long serialVersionUID = 20121229;
    private final double[] data;

    public DiagonalMatrix(int r1) throws NotStrictlyPositiveException {
        super(r1, r1);
        this.data = new double[r1];
    }

    public DiagonalMatrix(double[] r2) {
        this(r2, true);
    }

    public DiagonalMatrix(double[] r1, boolean r2) throws NullArgumentException {
        MathUtils.checkNotNull(r1);
        if (r2 == false) goto L5;
        r1 = (double[]) r1.clone();
    L5:
        this.data = r1;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public RealMatrix createMatrix(int r1, int r2) throws NotStrictlyPositiveException, DimensionMismatchException {
        if (r1 != r2) goto L6;
        return new DiagonalMatrix(r1);
    L6:
        throw new DimensionMismatchException(r1, r2);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public RealMatrix copy() {
        return new DiagonalMatrix(this.data);
    }

    public DiagonalMatrix add(DiagonalMatrix r9) throws MatrixDimensionMismatchException {
        MatrixUtils.checkAdditionCompatible(this, r9);
        int r0 = getRowDimension();
        double[] r1 = new double[r0];
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L6;
        r1[r3] = this.data[r3] + r9.data[r3];
        r3 = r3 + 1;
        goto L3
    L6:
        return new DiagonalMatrix(r1, false);
    }

    public DiagonalMatrix subtract(DiagonalMatrix r9) throws MatrixDimensionMismatchException {
        MatrixUtils.checkSubtractionCompatible(this, r9);
        int r0 = getRowDimension();
        double[] r1 = new double[r0];
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L6;
        r1[r3] = this.data[r3] - r9.data[r3];
        r3 = r3 + 1;
        goto L3
    L6:
        return new DiagonalMatrix(r1, false);
    }

    public DiagonalMatrix multiply(DiagonalMatrix r9) throws DimensionMismatchException {
        MatrixUtils.checkMultiplicationCompatible(this, r9);
        int r0 = getRowDimension();
        double[] r1 = new double[r0];
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L6;
        r1[r3] = this.data[r3] * r9.data[r3];
        r3 = r3 + 1;
        goto L3
    L6:
        return new DiagonalMatrix(r1, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public RealMatrix multiply(RealMatrix r12) throws DimensionMismatchException {
        if ((r12 instanceof DiagonalMatrix) == true) goto L5;
        MatrixUtils.checkMultiplicationCompatible(this, r12);
        int r0 = r12.getRowDimension();
        int r1 = r12.getColumnDimension();
        double[][] r2 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r0, r1});
        int r4 = 0;
    L7:
        if (r4 >= r0) goto L13;
        int r5 = 0;
    L9:
        if (r5 >= r1) goto L11;
        r2[r4][r5] = this.data[r4] * r12.getEntry(r4, r5);
        r5 = r5 + 1;
        goto L9
    L11:
        r4 = r4 + 1;
        goto L7
    L13:
        return new Array2DRowRealMatrix(r2, false);
    L5:
        return multiply((DiagonalMatrix) r12);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double[][] getData() {
        int r0 = getRowDimension();
        int r2 = 0;
        double[][] r1 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r0, r0});
    L3:
        if (r2 >= r0) goto L5;
        r1[r2][r2] = this.data[r2];
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public double[] getDataRef() {
        return this.data;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double getEntry(int r1, int r2) throws OutOfRangeException {
        MatrixUtils.checkMatrixIndex(this, r1, r2);
        if (r1 == r2) goto L7;
        return 0.0d;
    L7:
        return this.data[r1];
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setEntry(int r1, int r2, double r3) throws OutOfRangeException, NumberIsTooLargeException {
        if (r1 != r2) goto L4;
        MatrixUtils.checkRowIndex(this, r1);
        this.data[r1] = r3;
        return;
    L4:
        ensureZero(r3);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void addToEntry(int r3, int r4, double r5) throws OutOfRangeException, NumberIsTooLargeException {
        if (r3 != r4) goto L4;
        MatrixUtils.checkRowIndex(this, r3);
        double[] r2 = this.data;
        r2[r3] = r2[r3] + r5;
        return;
    L4:
        ensureZero(r5);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void multiplyEntry(int r3, int r4, double r5) throws OutOfRangeException {
        if (r3 != r4) goto L5;
        MatrixUtils.checkRowIndex(this, r3);
        double[] r2 = this.data;
        r2[r3] = r2[r3] * r5;
        return;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public int getRowDimension() {
        return this.data.length;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public int getColumnDimension() {
        return this.data.length;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double[] operate(double[] r3) throws DimensionMismatchException {
        return multiply(new DiagonalMatrix(r3, false)).getDataRef();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double[] preMultiply(double[] r1) throws DimensionMismatchException {
        return operate(r1);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public RealVector preMultiply(RealVector r2) throws DimensionMismatchException {
        if ((r2 instanceof ArrayRealVector) == false) goto L5;
        double[] r3 = ((ArrayRealVector) r2).getDataRef();
    L7:
        return MatrixUtils.createRealVector(preMultiply(r3));
    L5:
        r3 = r2.toArray();
        goto L7
    }

    private void ensureZero(double r3) throws NumberIsTooLargeException {
        if (Precision.equals(0.0d, r3, 1) == false) goto L6;
        return;
    L6:
        throw new NumberIsTooLargeException(Double.valueOf(FastMath.abs(r3)), 0, true);
    }

    public DiagonalMatrix inverse() throws SingularMatrixException {
        return inverse(0.0d);
    }

    public DiagonalMatrix inverse(double r7) throws SingularMatrixException {
        if (isSingular(r7) == true) goto L11;
        double[] r8 = new double[this.data.length];
        int r0 = 0;
    L5:
        double[] r1 = this.data;
        if (r0 >= r1.length) goto L9;
        r8[r0] = 1.0d / r1[r0];
        r0 = r0 + 1;
        goto L5
    L9:
        return new DiagonalMatrix(r8, false);
    L11:
        throw new SingularMatrixException();
    }

    public boolean isSingular(double r11) {
        int r1 = 0;
    L3:
        double[] r2 = this.data;
        if (r1 >= r2.length) goto L10;
        if (Precision.equals(r2[r1], 0.0d, r11) == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return true;
    L10:
        return false;
    }
}
