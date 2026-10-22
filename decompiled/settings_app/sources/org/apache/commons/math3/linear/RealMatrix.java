package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;

/* JADX INFO: loaded from: classes6.dex */
public interface RealMatrix extends AnyMatrix {
    RealMatrix add(RealMatrix r1) throws MatrixDimensionMismatchException;

    void addToEntry(int r1, int r2, double r3) throws OutOfRangeException;

    RealMatrix copy();

    void copySubMatrix(int r1, int r2, int r3, int r4, double[][] r5) throws OutOfRangeException, NumberIsTooSmallException, MatrixDimensionMismatchException;

    void copySubMatrix(int[] r1, int[] r2, double[][] r3) throws OutOfRangeException, NullArgumentException, NoDataException, MatrixDimensionMismatchException;

    RealMatrix createMatrix(int r1, int r2) throws NotStrictlyPositiveException;

    double[] getColumn(int r1) throws OutOfRangeException;

    RealMatrix getColumnMatrix(int r1) throws OutOfRangeException;

    RealVector getColumnVector(int r1) throws OutOfRangeException;

    double[][] getData();

    double getEntry(int r1, int r2) throws OutOfRangeException;

    double getFrobeniusNorm();

    double getNorm();

    double[] getRow(int r1) throws OutOfRangeException;

    RealMatrix getRowMatrix(int r1) throws OutOfRangeException;

    RealVector getRowVector(int r1) throws OutOfRangeException;

    RealMatrix getSubMatrix(int r1, int r2, int r3, int r4) throws OutOfRangeException, NumberIsTooSmallException;

    RealMatrix getSubMatrix(int[] r1, int[] r2) throws NullArgumentException, NoDataException, OutOfRangeException;

    double getTrace() throws NonSquareMatrixException;

    RealMatrix multiply(RealMatrix r1) throws DimensionMismatchException;

    void multiplyEntry(int r1, int r2, double r3) throws OutOfRangeException;

    RealVector operate(RealVector r1) throws DimensionMismatchException;

    double[] operate(double[] r1) throws DimensionMismatchException;

    RealMatrix power(int r1) throws NotPositiveException, NonSquareMatrixException;

    RealMatrix preMultiply(RealMatrix r1) throws DimensionMismatchException;

    RealVector preMultiply(RealVector r1) throws DimensionMismatchException;

    double[] preMultiply(double[] r1) throws DimensionMismatchException;

    RealMatrix scalarAdd(double r1);

    RealMatrix scalarMultiply(double r1);

    void setColumn(int r1, double[] r2) throws OutOfRangeException, MatrixDimensionMismatchException;

    void setColumnMatrix(int r1, RealMatrix r2) throws OutOfRangeException, MatrixDimensionMismatchException;

    void setColumnVector(int r1, RealVector r2) throws OutOfRangeException, MatrixDimensionMismatchException;

    void setEntry(int r1, int r2, double r3) throws OutOfRangeException;

    void setRow(int r1, double[] r2) throws OutOfRangeException, MatrixDimensionMismatchException;

    void setRowMatrix(int r1, RealMatrix r2) throws OutOfRangeException, MatrixDimensionMismatchException;

    void setRowVector(int r1, RealVector r2) throws OutOfRangeException, MatrixDimensionMismatchException;

    void setSubMatrix(double[][] r1, int r2, int r3) throws NoDataException, OutOfRangeException, DimensionMismatchException, NullArgumentException;

    RealMatrix subtract(RealMatrix r1) throws MatrixDimensionMismatchException;

    RealMatrix transpose();

    double walkInColumnOrder(RealMatrixChangingVisitor r1);

    double walkInColumnOrder(RealMatrixChangingVisitor r1, int r2, int r3, int r4, int r5) throws OutOfRangeException, NumberIsTooSmallException;

    double walkInColumnOrder(RealMatrixPreservingVisitor r1);

    double walkInColumnOrder(RealMatrixPreservingVisitor r1, int r2, int r3, int r4, int r5) throws OutOfRangeException, NumberIsTooSmallException;

    double walkInOptimizedOrder(RealMatrixChangingVisitor r1);

    double walkInOptimizedOrder(RealMatrixChangingVisitor r1, int r2, int r3, int r4, int r5) throws OutOfRangeException, NumberIsTooSmallException;

    double walkInOptimizedOrder(RealMatrixPreservingVisitor r1);

    double walkInOptimizedOrder(RealMatrixPreservingVisitor r1, int r2, int r3, int r4, int r5) throws OutOfRangeException, NumberIsTooSmallException;

    double walkInRowOrder(RealMatrixChangingVisitor r1);

    double walkInRowOrder(RealMatrixChangingVisitor r1, int r2, int r3, int r4, int r5) throws OutOfRangeException, NumberIsTooSmallException;

    double walkInRowOrder(RealMatrixPreservingVisitor r1);

    double walkInRowOrder(RealMatrixPreservingVisitor r1, int r2, int r3, int r4, int r5) throws OutOfRangeException, NumberIsTooSmallException;
}
