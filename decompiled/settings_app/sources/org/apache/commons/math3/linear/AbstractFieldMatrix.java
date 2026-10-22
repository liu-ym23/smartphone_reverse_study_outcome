package org.apache.commons.math3.linear;

import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractFieldMatrix<T extends FieldElement<T>> implements FieldMatrix<T> {
    private final Field<T> field;

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public abstract void addToEntry(int r1, int r2, T r3) throws OutOfRangeException;

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public abstract FieldMatrix<T> copy();

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public abstract FieldMatrix<T> createMatrix(int r1, int r2) throws NotStrictlyPositiveException;

    @Override // org.apache.commons.math3.linear.AnyMatrix
    public abstract int getColumnDimension();

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public abstract T getEntry(int r1, int r2) throws OutOfRangeException;

    @Override // org.apache.commons.math3.linear.AnyMatrix
    public abstract int getRowDimension();

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public abstract void multiplyEntry(int r1, int r2, T r3) throws OutOfRangeException;

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public abstract void setEntry(int r1, int r2, T r3) throws OutOfRangeException;

    protected AbstractFieldMatrix() {
        this.field = null;
    }

    protected AbstractFieldMatrix(Field<T> r1) {
        this.field = r1;
    }

    protected AbstractFieldMatrix(Field<T> r1, int r2, int r3) throws NotStrictlyPositiveException {
        if (r2 <= 0) goto L10;
        if (r3 <= 0) goto L8;
        this.field = r1;
        return;
    L8:
        throw new NotStrictlyPositiveException(LocalizedFormats.DIMENSION, Integer.valueOf(r3));
    L10:
        throw new NotStrictlyPositiveException(LocalizedFormats.DIMENSION, Integer.valueOf(r2));
    }

    protected static <T extends FieldElement<T>> Field<T> extractField(T[][] r2) throws NoDataException, NullArgumentException {
        if (r2 == null) goto L14;
        if (r2.length == 0) goto L12;
        T[] r3 = r2[0];
        if (r3.length == 0) goto L10;
        return r3[0].getField();
    L10:
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
    L12:
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
    L14:
        throw new NullArgumentException();
    }

    protected static <T extends FieldElement<T>> Field<T> extractField(T[] r1) throws NoDataException {
        if (r1.length == 0) goto L7;
        return r1[0].getField();
    L7:
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
    }

    @Deprecated
    protected static <T extends FieldElement<T>> T[][] buildArray(Field<T> r0, int r1, int r2) {
        return (T[][]) ((FieldElement[][]) MathArrays.buildArray(r0, r1, r2));
    }

    @Deprecated
    protected static <T extends FieldElement<T>> T[] buildArray(Field<T> r0, int r1) {
        return (T[]) ((FieldElement[]) MathArrays.buildArray(r0, r1));
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public Field<T> getField() {
        return this.field;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> add(FieldMatrix<T> r9) throws MatrixDimensionMismatchException {
        checkAdditionCompatible(r9);
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        FieldMatrix<T> r2 = createMatrix(r0, r1);
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L8;
        int r5 = 0;
    L5:
        if (r5 >= r1) goto L7;
        r2.setEntry(r4, r5, (FieldElement) getEntry(r4, r5).add(r9.getEntry(r4, r5)));
        r5 = r5 + 1;
        goto L5
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        return r2;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> subtract(FieldMatrix<T> r9) throws MatrixDimensionMismatchException {
        checkSubtractionCompatible(r9);
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        FieldMatrix<T> r2 = createMatrix(r0, r1);
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L8;
        int r5 = 0;
    L5:
        if (r5 >= r1) goto L7;
        r2.setEntry(r4, r5, (FieldElement) getEntry(r4, r5).subtract(r9.getEntry(r4, r5)));
        r5 = r5 + 1;
        goto L5
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        return r2;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> scalarAdd(T r8) {
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        FieldMatrix<T> r2 = createMatrix(r0, r1);
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L8;
        int r5 = 0;
    L5:
        if (r5 >= r1) goto L7;
        r2.setEntry(r4, r5, (FieldElement) getEntry(r4, r5).add(r8));
        r5 = r5 + 1;
        goto L5
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        return r2;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> scalarMultiply(T r8) {
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        FieldMatrix<T> r2 = createMatrix(r0, r1);
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L8;
        int r5 = 0;
    L5:
        if (r5 >= r1) goto L7;
        r2.setEntry(r4, r5, (FieldElement) getEntry(r4, r5).multiply(r8));
        r5 = r5 + 1;
        goto L5
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        return r2;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> multiply(FieldMatrix<T> r12) throws DimensionMismatchException {
        checkMultiplicationCompatible(r12);
        int r0 = getRowDimension();
        int r1 = r12.getColumnDimension();
        int r2 = getColumnDimension();
        FieldMatrix<T> r3 = createMatrix(r0, r1);
        int r5 = 0;
    L3:
        if (r5 >= r0) goto L11;
        int r6 = 0;
    L5:
        if (r6 >= r1) goto L10;
        T r7 = this.field.getZero();
        int r8 = 0;
    L7:
        if (r8 >= r2) goto L9;
        r7 = (FieldElement) r7.add(getEntry(r5, r8).multiply(r12.getEntry(r8, r6)));
        r8 = r8 + 1;
        goto L7
    L9:
        r3.setEntry(r5, r6, r7);
        r6 = r6 + 1;
        goto L5
    L10:
        r5 = r5 + 1;
        goto L3
    L11:
        return r3;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> preMultiply(FieldMatrix<T> r1) throws DimensionMismatchException {
        return r1.multiply(this);
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> power(int r7) throws NonSquareMatrixException, NotPositiveException {
        if (r7 < 0) goto L31;
        if (isSquare() == false) goto L29;
        if (r7 == 0) goto L7;
        int r0 = 1;
        if (r7 == 1) goto L11;
        char[] r8 = Integer.toBinaryString(r7 - 1).toCharArray();
        ArrayList r1 = new ArrayList();
        int r3 = 0;
    L14:
        if (r3 >= r8.length) goto L19;
        if (r8[r3] != '1') goto L18;
        r1.add(Integer.valueOf((r8.length - r3) - 1));
    L18:
        r3 = r3 + 1;
        goto L14
    L19:
        ArrayList r4 = new ArrayList(r8.length);
        r4.add(0, copy());
    L21:
        if (r0 >= r8.length) goto L23;
        FieldMatrix<T> r2 = (FieldMatrix) r4.get(r0 - 1);
        r4.add(r0, r2.multiply(r2));
        r0 = r0 + 1;
        goto L21
    L23:
        FieldMatrix<T> r6 = copy();
        Iterator r9 = r1.iterator();
    L25:
        if (r9.hasNext() == false) goto L27;
        r6 = r6.multiply((FieldMatrix) r4.get(((Integer) r9.next()).intValue()));
        goto L25
    L27:
        return r6;
    L11:
        return copy();
    L7:
        return MatrixUtils.createFieldIdentityMatrix(getField(), getRowDimension());
    L29:
        throw new NonSquareMatrixException(getRowDimension(), getColumnDimension());
    L31:
        throw new NotPositiveException(Integer.valueOf(r7));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T[][] getData() {
        T[][] r0 = (T[][]) ((FieldElement[][]) MathArrays.buildArray(this.field, getRowDimension(), getColumnDimension()));
        int r2 = 0;
    L4:
        if (r2 >= r0.length) goto L10;
        FieldElement[] r3 = r0[r2];
        int r4 = 0;
    L7:
        if (r4 >= r3.length) goto L9;
        r3[r4] = getEntry(r2, r4);
        r4 = r4 + 1;
        goto L7
    L9:
        r2 = r2 + 1;
        goto L4
    L10:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> getSubMatrix(int r7, int r8, int r9, int r10) throws NumberIsTooSmallException, OutOfRangeException {
        checkSubMatrixIndex(r7, r8, r9, r10);
        FieldMatrix<T> r0 = createMatrix((r8 - r7) + 1, (r10 - r9) + 1);
        int r1 = r7;
    L3:
        if (r1 > r8) goto L8;
        int r2 = r9;
    L5:
        if (r2 > r10) goto L7;
        r0.setEntry(r1 - r7, r2 - r9, getEntry(r1, r2));
        r2 = r2 + 1;
        goto L5
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> getSubMatrix(final int[] r4, final int[] r5) throws NoDataException, NullArgumentException, OutOfRangeException {
        checkSubMatrixIndex(r4, r5);
        FieldMatrix<T> r0 = createMatrix(r4.length, r5.length);
        final T r2 = this.field.getZero();
        r0.walkInOptimizedOrder(new AnonymousClass1(this, r2, r4, r5));
        return r0;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public void copySubMatrix(int r11, int r12, int r13, int r14, final T[][] r15) throws MatrixDimensionMismatchException, NumberIsTooSmallException, OutOfRangeException {
        checkSubMatrixIndex(r11, r12, r13, r14);
        int r0 = (r12 + 1) - r11;
        int r1 = (r14 + 1) - r13;
        if (r15.length < r0) goto L9;
        if (r15[0].length < r1) goto L9;
        final T r2 = this.field.getZero();
        walkInOptimizedOrder(new AnonymousClass2(this, r2, r15), r11, r12, r13, r14);
        return;
    L9:
        throw new MatrixDimensionMismatchException(r15.length, r15[0].length, r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.FieldMatrix
    public void copySubMatrix(int[] r7, int[] r8, T[][] r9) throws MatrixDimensionMismatchException, NoDataException, NullArgumentException, OutOfRangeException {
        checkSubMatrixIndex(r7, r8);
        if (r9.length < r7.length) goto L16;
        if (r9[0].length < r8.length) goto L16;
        int r0 = 0;
    L8:
        if (r0 >= r7.length) goto L14;
        FieldElement[] r1 = r9[r0];
        int r3 = 0;
    L11:
        if (r3 >= r8.length) goto L13;
        r1[r3] = getEntry(r7[r0], r8[r3]);
        r3 = r3 + 1;
        goto L11
    L13:
        r0 = r0 + 1;
        goto L8
    L14:
        return;
    L16:
        throw new MatrixDimensionMismatchException(r9.length, r9[0].length, r7.length, r8.length);
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public void setSubMatrix(T[][] r9, int r10, int r11) throws DimensionMismatchException, OutOfRangeException, NoDataException, NullArgumentException {
        if (r9 == null) goto L26;
        int r0 = r9.length;
        if (r0 == 0) goto L24;
        int r2 = r9[0].length;
        if (r2 == 0) goto L22;
        int r4 = 1;
    L8:
        if (r4 >= r0) goto L14;
        if (r9[r4].length != r2) goto L13;
        r4 = r4 + 1;
        goto L8
    L13:
        throw new DimensionMismatchException(r2, r9[r4].length);
    L14:
        checkRowIndex(r10);
        checkColumnIndex(r11);
        checkRowIndex((r0 + r10) - 1);
        checkColumnIndex((r2 + r11) - 1);
        int r3 = 0;
    L15:
        if (r3 >= r0) goto L20;
        int r5 = 0;
    L17:
        if (r5 >= r2) goto L19;
        setEntry(r10 + r3, r11 + r5, r9[r3][r5]);
        r5 = r5 + 1;
        goto L17
    L19:
        r3 = r3 + 1;
        goto L15
    L20:
        return;
    L22:
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
    L24:
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
    L26:
        throw new NullArgumentException();
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> getRowMatrix(int r6) throws OutOfRangeException {
        checkRowIndex(r6);
        int r0 = getColumnDimension();
        FieldMatrix<T> r1 = createMatrix(1, r0);
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1.setEntry(0, r3, getEntry(r6, r3));
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public void setRowMatrix(int r5, FieldMatrix<T> r6) throws OutOfRangeException, MatrixDimensionMismatchException {
        checkRowIndex(r5);
        int r0 = getColumnDimension();
        if (r6.getRowDimension() != 1) goto L11;
        if (r6.getColumnDimension() != r0) goto L11;
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        setEntry(r5, r2, r6.getEntry(0, r2));
        r2 = r2 + 1;
        goto L7
    L9:
        return;
    L11:
        throw new MatrixDimensionMismatchException(r6.getRowDimension(), r6.getColumnDimension(), 1, r0);
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> getColumnMatrix(int r6) throws OutOfRangeException {
        checkColumnIndex(r6);
        int r0 = getRowDimension();
        FieldMatrix<T> r1 = createMatrix(r0, 1);
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1.setEntry(r3, 0, getEntry(r3, r6));
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public void setColumnMatrix(int r5, FieldMatrix<T> r6) throws OutOfRangeException, MatrixDimensionMismatchException {
        checkColumnIndex(r5);
        int r0 = getRowDimension();
        if (r6.getRowDimension() != r0) goto L11;
        if (r6.getColumnDimension() != 1) goto L11;
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        setEntry(r2, r5, r6.getEntry(r2, 0));
        r2 = r2 + 1;
        goto L7
    L9:
        return;
    L11:
        throw new MatrixDimensionMismatchException(r6.getRowDimension(), r6.getColumnDimension(), r0, 1);
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldVector<T> getRowVector(int r3) throws OutOfRangeException {
        return new ArrayFieldVector(this.field, getRow(r3), false);
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public void setRowVector(int r4, FieldVector<T> r5) throws OutOfRangeException, MatrixDimensionMismatchException {
        checkRowIndex(r4);
        int r0 = getColumnDimension();
        if (r5.getDimension() != r0) goto L9;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        setEntry(r4, r1, r5.getEntry(r1));
        r1 = r1 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new MatrixDimensionMismatchException(1, r5.getDimension(), 1, r0);
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldVector<T> getColumnVector(int r3) throws OutOfRangeException {
        return new ArrayFieldVector(this.field, getColumn(r3), false);
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public void setColumnVector(int r4, FieldVector<T> r5) throws OutOfRangeException, MatrixDimensionMismatchException {
        checkColumnIndex(r4);
        int r0 = getRowDimension();
        if (r5.getDimension() != r0) goto L9;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        setEntry(r1, r4, r5.getEntry(r1));
        r1 = r1 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new MatrixDimensionMismatchException(r5.getDimension(), 1, r0, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T[] getRow(int r5) throws OutOfRangeException {
        checkRowIndex(r5);
        int r0 = getColumnDimension();
        T[] r1 = (T[]) ((FieldElement[]) MathArrays.buildArray(this.field, r0));
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = getEntry(r5, r2);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public void setRow(int r4, T[] r5) throws OutOfRangeException, MatrixDimensionMismatchException {
        checkRowIndex(r4);
        int r0 = getColumnDimension();
        if (r5.length != r0) goto L9;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        setEntry(r4, r1, r5[r1]);
        r1 = r1 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new MatrixDimensionMismatchException(1, r5.length, 1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T[] getColumn(int r5) throws OutOfRangeException {
        checkColumnIndex(r5);
        int r0 = getRowDimension();
        T[] r1 = (T[]) ((FieldElement[]) MathArrays.buildArray(this.field, r0));
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = getEntry(r2, r5);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public void setColumn(int r4, T[] r5) throws OutOfRangeException, MatrixDimensionMismatchException {
        checkColumnIndex(r4);
        int r0 = getRowDimension();
        if (r5.length != r0) goto L9;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        setEntry(r1, r4, r5[r1]);
        r1 = r1 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new MatrixDimensionMismatchException(r5.length, 1, r0, 1);
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> transpose() {
        int r0 = getRowDimension();
        final FieldMatrix<T> r1 = createMatrix(getColumnDimension(), r0);
        final T r2 = this.field.getZero();
        walkInOptimizedOrder(new AnonymousClass3(this, r2, r1));
        return r1;
    }

    @Override // org.apache.commons.math3.linear.AnyMatrix
    public boolean isSquare() {
        if (getColumnDimension() != getRowDimension()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T getTrace() throws NonSquareMatrixException {
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        if (r0 != r1) goto L9;
        T r2 = this.field.getZero();
        int r3 = 0;
    L5:
        if (r3 >= r0) goto L7;
        r2 = (T) r2.add(getEntry(r3, r3));
        r3 = r3 + 1;
        goto L5
    L7:
        return r2;
    L9:
        throw new NonSquareMatrixException(r0, r1);
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T[] operate(T[] r10) throws DimensionMismatchException {
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        if (r10.length != r1) goto L12;
        T[] r2 = (T[]) ((FieldElement[]) MathArrays.buildArray(this.field, r0));
        int r4 = 0;
    L5:
        if (r4 >= r0) goto L10;
        T r5 = this.field.getZero();
        int r6 = 0;
    L7:
        if (r6 >= r1) goto L9;
        r5 = (T) r5.add(getEntry(r4, r6).multiply(r10[r6]));
        r6 = r6 + 1;
        goto L7
    L9:
        r2[r4] = r5;
        r4 = r4 + 1;
        goto L5
    L10:
        return r2;
    L12:
        throw new DimensionMismatchException(r10.length, r1);
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldVector<T> operate(FieldVector<T> r10) throws DimensionMismatchException {
        return new ArrayFieldVector(this.field, operate(((ArrayFieldVector) r10).getDataRef()), false);
    L5:
        int r1 = getRowDimension();
        int r2 = getColumnDimension();
        if (r10.getDimension() != r2) goto L16;
        FieldElement[] r3 = (FieldElement[]) MathArrays.buildArray(this.field, r1);
        int r4 = 0;
    L8:
        if (r4 >= r1) goto L14;
        T r5 = this.field.getZero();
        int r6 = 0;
    L10:
        if (r6 >= r2) goto L12;
        r5 = (FieldElement) r5.add(getEntry(r4, r6).multiply(r10.getEntry(r6)));
        r6 = r6 + 1;
        goto L10
    L12:
        r3[r4] = r5;
        r4 = r4 + 1;
        goto L8
    L14:
        return new ArrayFieldVector(this.field, r3, false);
    L16:
        throw new DimensionMismatchException(r10.getDimension(), r2);
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T[] preMultiply(T[] r10) throws DimensionMismatchException {
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        if (r10.length != r0) goto L12;
        T[] r2 = (T[]) ((FieldElement[]) MathArrays.buildArray(this.field, r1));
        int r4 = 0;
    L5:
        if (r4 >= r1) goto L10;
        T r5 = this.field.getZero();
        int r6 = 0;
    L7:
        if (r6 >= r0) goto L9;
        r5 = (T) r5.add(getEntry(r6, r4).multiply(r10[r6]));
        r6 = r6 + 1;
        goto L7
    L9:
        r2[r4] = r5;
        r4 = r4 + 1;
        goto L5
    L10:
        return r2;
    L12:
        throw new DimensionMismatchException(r10.length, r0);
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldVector<T> preMultiply(FieldVector<T> r10) throws DimensionMismatchException {
        return new ArrayFieldVector(this.field, preMultiply(((ArrayFieldVector) r10).getDataRef()), false);
    L5:
        int r1 = getRowDimension();
        int r2 = getColumnDimension();
        if (r10.getDimension() != r1) goto L16;
        FieldElement[] r3 = (FieldElement[]) MathArrays.buildArray(this.field, r2);
        int r4 = 0;
    L8:
        if (r4 >= r2) goto L14;
        T r5 = this.field.getZero();
        int r6 = 0;
    L10:
        if (r6 >= r1) goto L12;
        r5 = (FieldElement) r5.add(getEntry(r6, r4).multiply(r10.getEntry(r6)));
        r6 = r6 + 1;
        goto L10
    L12:
        r3[r4] = r5;
        r4 = r4 + 1;
        goto L8
    L14:
        return new ArrayFieldVector(this.field, r3, false);
    L16:
        throw new DimensionMismatchException(r10.getDimension(), r1);
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixChangingVisitor<T> r10) {
        int r7 = getRowDimension();
        int r8 = getColumnDimension();
        r10.start(r7, r8, 0, r7 - 1, 0, r8 - 1);
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L9;
        int r2 = 0;
    L5:
        if (r2 >= r8) goto L7;
        setEntry(r1, r2, r10.visit(r1, r2, getEntry(r1, r2)));
        r2 = r2 + 1;
        goto L5
    L7:
        r1 = r1 + 1;
        goto L3
    L9:
        return (T) r10.end();
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixPreservingVisitor<T> r10) {
        int r7 = getRowDimension();
        int r8 = getColumnDimension();
        r10.start(r7, r8, 0, r7 - 1, 0, r8 - 1);
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L9;
        int r2 = 0;
    L5:
        if (r2 >= r8) goto L7;
        r10.visit(r1, r2, getEntry(r1, r2));
        r2 = r2 + 1;
        goto L5
    L7:
        r1 = r1 + 1;
        goto L3
    L9:
        return (T) r10.end();
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixChangingVisitor<T> r8, int r9, int r10, int r11, int r12) throws NumberIsTooSmallException, OutOfRangeException {
        checkSubMatrixIndex(r9, r10, r11, r12);
        r8.start(getRowDimension(), getColumnDimension(), r9, r10, r11, r12);
    L3:
        if (r9 > r10) goto L9;
        int r0 = r11;
    L5:
        if (r0 > r12) goto L7;
        setEntry(r9, r0, r8.visit(r9, r0, getEntry(r9, r0)));
        r0 = r0 + 1;
        goto L5
    L7:
        r9 = r9 + 1;
        goto L3
    L9:
        return (T) r8.end();
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixPreservingVisitor<T> r8, int r9, int r10, int r11, int r12) throws NumberIsTooSmallException, OutOfRangeException {
        checkSubMatrixIndex(r9, r10, r11, r12);
        r8.start(getRowDimension(), getColumnDimension(), r9, r10, r11, r12);
    L3:
        if (r9 > r10) goto L9;
        int r0 = r11;
    L5:
        if (r0 > r12) goto L7;
        r8.visit(r9, r0, getEntry(r9, r0));
        r0 = r0 + 1;
        goto L5
    L7:
        r9 = r9 + 1;
        goto L3
    L9:
        return (T) r8.end();
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInColumnOrder(FieldMatrixChangingVisitor<T> r10) {
        int r7 = getRowDimension();
        int r8 = getColumnDimension();
        r10.start(r7, r8, 0, r7 - 1, 0, r8 - 1);
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L9;
        int r2 = 0;
    L5:
        if (r2 >= r7) goto L7;
        setEntry(r2, r1, r10.visit(r2, r1, getEntry(r2, r1)));
        r2 = r2 + 1;
        goto L5
    L7:
        r1 = r1 + 1;
        goto L3
    L9:
        return (T) r10.end();
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInColumnOrder(FieldMatrixPreservingVisitor<T> r10) {
        int r7 = getRowDimension();
        int r8 = getColumnDimension();
        r10.start(r7, r8, 0, r7 - 1, 0, r8 - 1);
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L9;
        int r2 = 0;
    L5:
        if (r2 >= r7) goto L7;
        r10.visit(r2, r1, getEntry(r2, r1));
        r2 = r2 + 1;
        goto L5
    L7:
        r1 = r1 + 1;
        goto L3
    L9:
        return (T) r10.end();
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInColumnOrder(FieldMatrixChangingVisitor<T> r8, int r9, int r10, int r11, int r12) throws NumberIsTooSmallException, OutOfRangeException {
        checkSubMatrixIndex(r9, r10, r11, r12);
        r8.start(getRowDimension(), getColumnDimension(), r9, r10, r11, r12);
    L3:
        if (r11 > r12) goto L9;
        int r0 = r9;
    L5:
        if (r0 > r10) goto L7;
        setEntry(r0, r11, r8.visit(r0, r11, getEntry(r0, r11)));
        r0 = r0 + 1;
        goto L5
    L7:
        r11 = r11 + 1;
        goto L3
    L9:
        return (T) r8.end();
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInColumnOrder(FieldMatrixPreservingVisitor<T> r8, int r9, int r10, int r11, int r12) throws NumberIsTooSmallException, OutOfRangeException {
        checkSubMatrixIndex(r9, r10, r11, r12);
        r8.start(getRowDimension(), getColumnDimension(), r9, r10, r11, r12);
    L3:
        if (r11 > r12) goto L9;
        int r0 = r9;
    L5:
        if (r0 > r10) goto L7;
        r8.visit(r0, r11, getEntry(r0, r11));
        r0 = r0 + 1;
        goto L5
    L7:
        r11 = r11 + 1;
        goto L3
    L9:
        return (T) r8.end();
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixChangingVisitor<T> r1) {
        return (T) walkInRowOrder(r1);
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixPreservingVisitor<T> r1) {
        return (T) walkInRowOrder(r1);
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixChangingVisitor<T> r1, int r2, int r3, int r4, int r5) throws NumberIsTooSmallException, OutOfRangeException {
        return (T) walkInRowOrder(r1, r2, r3, r4, r5);
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixPreservingVisitor<T> r1, int r2, int r3, int r4, int r5) throws NumberIsTooSmallException, OutOfRangeException {
        return (T) walkInRowOrder(r1, r2, r3, r4, r5);
    }

    public String toString() {
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        StringBuffer r2 = new StringBuffer();
        String r3 = getClass().getName();
        r2.append(r3.substring(r3.lastIndexOf(46) + 1)).append(VectorFormat.DEFAULT_PREFIX);
        int r5 = 0;
    L4:
        if (r5 >= r0) goto L14;
        if (r5 <= 0) goto L8;
        r2.append(",");
    L8:
        r2.append(VectorFormat.DEFAULT_PREFIX);
        int r8 = 0;
    L9:
        if (r8 >= r1) goto L13;
        if (r8 <= 0) goto L12;
        r2.append(",");
    L12:
        r2.append(getEntry(r5, r8));
        r8 = r8 + 1;
        goto L9
    L13:
        r2.append(VectorFormat.DEFAULT_SUFFIX);
        r5 = r5 + 1;
        goto L4
    L14:
        r2.append(VectorFormat.DEFAULT_SUFFIX);
        return r2.toString();
    }

    public boolean equals(Object r9) {
        if (r9 != this) goto L6;
        return true;
    L6:
        if ((r9 instanceof FieldMatrix) == true) goto L8;
        return false;
    L8:
        FieldMatrix r10 = (FieldMatrix) r9;
        int r1 = getRowDimension();
        int r3 = getColumnDimension();
        if (r10.getColumnDimension() == r3) goto L11;
    L23:
        return false;
    L11:
        if (r10.getRowDimension() != r1) goto L23;
        int r4 = 0;
    L14:
        if (r4 >= r1) goto L22;
        int r5 = 0;
    L16:
        if (r5 >= r3) goto L21;
        if (getEntry(r4, r5).equals(r10.getEntry(r4, r5)) == false) goto L19;
        r5 = r5 + 1;
        goto L16
    L19:
        return false;
    L21:
        r4 = r4 + 1;
        goto L14
    L22:
        return true;
    }

    public int hashCode() {
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        int r2 = ((9999422 + r0) * 31) + r1;
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L8;
        int r5 = 0;
    L5:
        if (r5 >= r1) goto L7;
        int r7 = r5 + 1;
        r2 = (r2 * 31) + ((((r4 + 1) * 11) + (r7 * 17)) * getEntry(r4, r5).hashCode());
        r5 = r7;
        goto L5
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        return r2;
    }

    protected void checkRowIndex(int r4) throws OutOfRangeException {
        if (r4 < 0) goto L7;
        if (r4 >= getRowDimension()) goto L7;
        return;
    L7:
        throw new OutOfRangeException(LocalizedFormats.ROW_INDEX, Integer.valueOf(r4), 0, Integer.valueOf(getRowDimension() - 1));
    }

    protected void checkColumnIndex(int r4) throws OutOfRangeException {
        if (r4 < 0) goto L7;
        if (r4 >= getColumnDimension()) goto L7;
        return;
    L7:
        throw new OutOfRangeException(LocalizedFormats.COLUMN_INDEX, Integer.valueOf(r4), 0, Integer.valueOf(getColumnDimension() - 1));
    }

    protected void checkSubMatrixIndex(int r2, int r3, int r4, int r5) throws NumberIsTooSmallException, OutOfRangeException {
        checkRowIndex(r2);
        checkRowIndex(r3);
        if (r3 < r2) goto L10;
        checkColumnIndex(r4);
        checkColumnIndex(r5);
        if (r5 < r4) goto L8;
        return;
    L8:
        throw new NumberIsTooSmallException(LocalizedFormats.INITIAL_COLUMN_AFTER_FINAL_COLUMN, Integer.valueOf(r5), Integer.valueOf(r4), true);
    L10:
        throw new NumberIsTooSmallException(LocalizedFormats.INITIAL_ROW_AFTER_FINAL_ROW, Integer.valueOf(r3), Integer.valueOf(r2), true);
    }

    protected void checkSubMatrixIndex(int[] r5, int[] r6) throws NoDataException, NullArgumentException, OutOfRangeException {
        if (r5 == null) goto L18;
        if (r6 == null) goto L18;
        if (r5.length == 0) goto L16;
        if (r6.length == 0) goto L16;
        int r0 = r5.length;
        int r1 = 0;
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L11;
        checkRowIndex(r5[r2]);
        r2 = r2 + 1;
        goto L9
    L11:
        int r7 = r6.length;
    L12:
        if (r1 >= r7) goto L14;
        checkColumnIndex(r6[r1]);
        r1 = r1 + 1;
        goto L12
    L14:
        return;
    L16:
        throw new NoDataException();
    L18:
        throw new NullArgumentException();
    }

    protected void checkAdditionCompatible(FieldMatrix<T> r4) throws MatrixDimensionMismatchException {
        if (getRowDimension() != r4.getRowDimension()) goto L8;
        if (getColumnDimension() != r4.getColumnDimension()) goto L8;
        return;
    L8:
        throw new MatrixDimensionMismatchException(r4.getRowDimension(), r4.getColumnDimension(), getRowDimension(), getColumnDimension());
    }

    protected void checkSubtractionCompatible(FieldMatrix<T> r4) throws MatrixDimensionMismatchException {
        if (getRowDimension() != r4.getRowDimension()) goto L8;
        if (getColumnDimension() != r4.getColumnDimension()) goto L8;
        return;
    L8:
        throw new MatrixDimensionMismatchException(r4.getRowDimension(), r4.getColumnDimension(), getRowDimension(), getColumnDimension());
    }

    protected void checkMultiplicationCompatible(FieldMatrix<T> r3) throws DimensionMismatchException {
        if (getColumnDimension() != r3.getRowDimension()) goto L6;
        return;
    L6:
        throw new DimensionMismatchException(r3.getRowDimension(), getColumnDimension());
    }
}
