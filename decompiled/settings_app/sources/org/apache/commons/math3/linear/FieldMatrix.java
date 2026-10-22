package org.apache.commons.math3.linear;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;

/* JADX INFO: loaded from: classes6.dex */
public interface FieldMatrix<T extends FieldElement<T>> extends AnyMatrix {
    FieldMatrix<T> add(FieldMatrix<T> r1) throws MatrixDimensionMismatchException;

    void addToEntry(int r1, int r2, T r3) throws OutOfRangeException;

    FieldMatrix<T> copy();

    void copySubMatrix(int r1, int r2, int r3, int r4, T[][] r5) throws MatrixDimensionMismatchException, NumberIsTooSmallException, OutOfRangeException;

    void copySubMatrix(int[] r1, int[] r2, T[][] r3) throws MatrixDimensionMismatchException, NoDataException, NullArgumentException, OutOfRangeException;

    FieldMatrix<T> createMatrix(int r1, int r2) throws NotStrictlyPositiveException;

    T[] getColumn(int r1) throws OutOfRangeException;

    FieldMatrix<T> getColumnMatrix(int r1) throws OutOfRangeException;

    FieldVector<T> getColumnVector(int r1) throws OutOfRangeException;

    T[][] getData();

    T getEntry(int r1, int r2) throws OutOfRangeException;

    Field<T> getField();

    T[] getRow(int r1) throws OutOfRangeException;

    FieldMatrix<T> getRowMatrix(int r1) throws OutOfRangeException;

    FieldVector<T> getRowVector(int r1) throws OutOfRangeException;

    FieldMatrix<T> getSubMatrix(int r1, int r2, int r3, int r4) throws NumberIsTooSmallException, OutOfRangeException;

    FieldMatrix<T> getSubMatrix(int[] r1, int[] r2) throws NoDataException, NullArgumentException, OutOfRangeException;

    T getTrace() throws NonSquareMatrixException;

    FieldMatrix<T> multiply(FieldMatrix<T> r1) throws DimensionMismatchException;

    void multiplyEntry(int r1, int r2, T r3) throws OutOfRangeException;

    FieldVector<T> operate(FieldVector<T> r1) throws DimensionMismatchException;

    T[] operate(T[] r1) throws DimensionMismatchException;

    FieldMatrix<T> power(int r1) throws NonSquareMatrixException, NotPositiveException;

    FieldMatrix<T> preMultiply(FieldMatrix<T> r1) throws DimensionMismatchException;

    FieldVector<T> preMultiply(FieldVector<T> r1) throws DimensionMismatchException;

    T[] preMultiply(T[] r1) throws DimensionMismatchException;

    FieldMatrix<T> scalarAdd(T r1);

    FieldMatrix<T> scalarMultiply(T r1);

    void setColumn(int r1, T[] r2) throws MatrixDimensionMismatchException, OutOfRangeException;

    void setColumnMatrix(int r1, FieldMatrix<T> r2) throws MatrixDimensionMismatchException, OutOfRangeException;

    void setColumnVector(int r1, FieldVector<T> r2) throws MatrixDimensionMismatchException, OutOfRangeException;

    void setEntry(int r1, int r2, T r3) throws OutOfRangeException;

    void setRow(int r1, T[] r2) throws MatrixDimensionMismatchException, OutOfRangeException;

    void setRowMatrix(int r1, FieldMatrix<T> r2) throws MatrixDimensionMismatchException, OutOfRangeException;

    void setRowVector(int r1, FieldVector<T> r2) throws MatrixDimensionMismatchException, OutOfRangeException;

    void setSubMatrix(T[][] r1, int r2, int r3) throws DimensionMismatchException, OutOfRangeException, NoDataException, NullArgumentException;

    FieldMatrix<T> subtract(FieldMatrix<T> r1) throws MatrixDimensionMismatchException;

    FieldMatrix<T> transpose();

    T walkInColumnOrder(FieldMatrixChangingVisitor<T> r1);

    T walkInColumnOrder(FieldMatrixChangingVisitor<T> r1, int r2, int r3, int r4, int r5) throws NumberIsTooSmallException, OutOfRangeException;

    T walkInColumnOrder(FieldMatrixPreservingVisitor<T> r1);

    T walkInColumnOrder(FieldMatrixPreservingVisitor<T> r1, int r2, int r3, int r4, int r5) throws NumberIsTooSmallException, OutOfRangeException;

    T walkInOptimizedOrder(FieldMatrixChangingVisitor<T> r1);

    T walkInOptimizedOrder(FieldMatrixChangingVisitor<T> r1, int r2, int r3, int r4, int r5) throws NumberIsTooSmallException, OutOfRangeException;

    T walkInOptimizedOrder(FieldMatrixPreservingVisitor<T> r1);

    T walkInOptimizedOrder(FieldMatrixPreservingVisitor<T> r1, int r2, int r3, int r4, int r5) throws NumberIsTooSmallException, OutOfRangeException;

    T walkInRowOrder(FieldMatrixChangingVisitor<T> r1);

    T walkInRowOrder(FieldMatrixChangingVisitor<T> r1, int r2, int r3, int r4, int r5) throws OutOfRangeException, NumberIsTooSmallException;

    T walkInRowOrder(FieldMatrixPreservingVisitor<T> r1);

    T walkInRowOrder(FieldMatrixPreservingVisitor<T> r1, int r2, int r3, int r4, int r5) throws OutOfRangeException, NumberIsTooSmallException;
}
