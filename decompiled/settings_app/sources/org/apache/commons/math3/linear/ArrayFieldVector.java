package org.apache.commons.math3.linear;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class ArrayFieldVector<T extends FieldElement<T>> implements FieldVector<T>, Serializable {
    private static final long serialVersionUID = 7648186910365927050L;
    private T[] data;
    private final Field<T> field;

    public ArrayFieldVector(Field<T> r2) {
        this(r2, 0);
    }

    public ArrayFieldVector(Field<T> r1, int r2) {
        this.field = r1;
        this.data = (T[]) ((FieldElement[]) MathArrays.buildArray(r1, r2));
    }

    public ArrayFieldVector(int r2, T r3) {
        this(r3.getField(), r2);
        Arrays.fill(this.data, r3);
    }

    public ArrayFieldVector(T[] r3) throws NullArgumentException, ZeroException {
        MathUtils.checkNotNull(r3);
        this.field = r3[0].getField();     // Catch: ArrayIndexOutOfBoundsException -> L5
        this.data = (T[]) ((FieldElement[]) r3.clone());     // Catch: ArrayIndexOutOfBoundsException -> L5
        return;
    L6:
        throw new ZeroException(LocalizedFormats.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT, new Object[0]);
    }

    public ArrayFieldVector(Field<T> r1, T[] r2) throws NullArgumentException {
        MathUtils.checkNotNull(r2);
        this.field = r1;
        this.data = (T[]) ((FieldElement[]) r2.clone());
    }

    public ArrayFieldVector(T[] r3, boolean r4) throws NullArgumentException, ZeroException {
        MathUtils.checkNotNull(r3);
        if (r3.length == 0) goto L10;
        this.field = r3[0].getField();
        if (r4 == false) goto L7;
        r3 = (T[]) ((FieldElement[]) r3.clone());
    L7:
        this.data = r3;
        return;
    L10:
        throw new ZeroException(LocalizedFormats.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT, new Object[0]);
    }

    public ArrayFieldVector(Field<T> r1, T[] r2, boolean r3) throws NullArgumentException {
        MathUtils.checkNotNull(r2);
        this.field = r1;
        if (r3 == false) goto L5;
        r2 = (T[]) ((FieldElement[]) r2.clone());
    L5:
        this.data = r2;
    }

    public ArrayFieldVector(T[] r3, int r4, int r5) throws NullArgumentException, NumberIsTooLargeException {
        MathUtils.checkNotNull(r3);
        int r1 = r4 + r5;
        if (r3.length < r1) goto L7;
        Field<T> r2 = r3[0].getField();
        this.field = r2;
        T[] r6 = (T[]) ((FieldElement[]) MathArrays.buildArray(r2, r5));
        this.data = r6;
        System.arraycopy(r3, r4, r6, 0, r5);
        return;
    L7:
        throw new NumberIsTooLargeException(Integer.valueOf(r1), Integer.valueOf(r3.length), true);
    }

    public ArrayFieldVector(Field<T> r3, T[] r4, int r5, int r6) throws NullArgumentException, NumberIsTooLargeException {
        MathUtils.checkNotNull(r4);
        int r1 = r5 + r6;
        if (r4.length < r1) goto L7;
        this.field = r3;
        T[] r7 = (T[]) ((FieldElement[]) MathArrays.buildArray(r3, r6));
        this.data = r7;
        System.arraycopy(r4, r5, r7, 0, r6);
        return;
    L7:
        throw new NumberIsTooLargeException(Integer.valueOf(r1), Integer.valueOf(r4.length), true);
    }

    public ArrayFieldVector(FieldVector<T> r4) throws NullArgumentException {
        MathUtils.checkNotNull(r4);
        Field<T> r0 = r4.getField();
        this.field = r0;
        this.data = (T[]) ((FieldElement[]) MathArrays.buildArray(r0, r4.getDimension()));
        int r1 = 0;
    L3:
        FieldElement[] r2 = (T[]) this.data;
        if (r1 >= r2.length) goto L6;
        r2[r1] = r4.getEntry(r1);
        r1 = r1 + 1;
        goto L3
    }

    public ArrayFieldVector(ArrayFieldVector<T> r2) throws NullArgumentException {
        MathUtils.checkNotNull(r2);
        this.field = r2.getField();
        this.data = (T[]) ((FieldElement[]) r2.data.clone());
    }

    public ArrayFieldVector(ArrayFieldVector<T> r2, boolean r3) throws NullArgumentException {
        MathUtils.checkNotNull(r2);
        this.field = r2.getField();
        T[] r4 = r2.data;
        if (r3 == false) goto L5;
        r4 = (T[]) ((FieldElement[]) r4.clone());
    L5:
        this.data = r4;
    }

    @Deprecated
    public ArrayFieldVector(ArrayFieldVector<T> r1, ArrayFieldVector<T> r2) throws NullArgumentException {
        this(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArrayFieldVector(FieldVector<T> r4, FieldVector<T> r5) throws NullArgumentException {
        MathUtils.checkNotNull(r4);
        MathUtils.checkNotNull(r5);
        Field<T> r0 = r4.getField();
        this.field = r0;
        if ((r4 instanceof ArrayFieldVector) == false) goto L5;
        Object[] r6 = ((ArrayFieldVector) r4).data;
    L7:
        if ((r5 instanceof ArrayFieldVector) == false) goto L9;
        Object[] r7 = ((ArrayFieldVector) r5).data;
    L10:
        T[] r1 = (T[]) ((FieldElement[]) MathArrays.buildArray(r0, r6.length + r7.length));
        this.data = r1;
        System.arraycopy(r6, 0, r1, 0, r6.length);
        System.arraycopy(r7, 0, this.data, r6.length, r7.length);
        return;
    L9:
        r7 = (T[]) r5.toArray();
        goto L10
    L5:
        r6 = (T[]) r4.toArray();
        goto L7
    }

    @Deprecated
    public ArrayFieldVector(ArrayFieldVector<T> r1, T[] r2) throws NullArgumentException {
        this(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArrayFieldVector(FieldVector<T> r4, T[] r5) throws NullArgumentException {
        MathUtils.checkNotNull(r4);
        MathUtils.checkNotNull(r5);
        Field<T> r0 = r4.getField();
        this.field = r0;
        if ((r4 instanceof ArrayFieldVector) == false) goto L5;
        Object[] r6 = ((ArrayFieldVector) r4).data;
    L6:
        T[] r1 = (T[]) ((FieldElement[]) MathArrays.buildArray(r0, r6.length + r5.length));
        this.data = r1;
        System.arraycopy(r6, 0, r1, 0, r6.length);
        System.arraycopy(r5, 0, this.data, r6.length, r5.length);
        return;
    L5:
        r6 = (T[]) r4.toArray();
        goto L6
    }

    @Deprecated
    public ArrayFieldVector(T[] r1, ArrayFieldVector<T> r2) throws NullArgumentException {
        this(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArrayFieldVector(T[] r4, FieldVector<T> r5) throws NullArgumentException {
        MathUtils.checkNotNull(r4);
        MathUtils.checkNotNull(r5);
        Field<T> r0 = r5.getField();
        this.field = r0;
        if ((r5 instanceof ArrayFieldVector) == false) goto L5;
        Object[] r6 = ((ArrayFieldVector) r5).data;
    L6:
        T[] r1 = (T[]) ((FieldElement[]) MathArrays.buildArray(r0, r4.length + r6.length));
        this.data = r1;
        System.arraycopy(r4, 0, r1, 0, r4.length);
        System.arraycopy(r6, 0, this.data, r4.length, r6.length);
        return;
    L5:
        r6 = (T[]) r5.toArray();
        goto L6
    }

    public ArrayFieldVector(T[] r5, T[] r6) throws NullArgumentException, ZeroException {
        MathUtils.checkNotNull(r5);
        MathUtils.checkNotNull(r6);
        if ((r5.length + r6.length) == 0) goto L7;
        T[] r0 = (T[]) ((FieldElement[]) MathArrays.buildArray(r5[0].getField(), r5.length + r6.length));
        this.data = r0;
        System.arraycopy(r5, 0, r0, 0, r5.length);
        System.arraycopy(r6, 0, this.data, r5.length, r6.length);
        this.field = this.data[0].getField();
        return;
    L7:
        throw new ZeroException(LocalizedFormats.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT, new Object[0]);
    }

    public ArrayFieldVector(Field<T> r4, T[] r5, T[] r6) throws NullArgumentException, ZeroException {
        MathUtils.checkNotNull(r5);
        MathUtils.checkNotNull(r6);
        if ((r5.length + r6.length) == 0) goto L7;
        T[] r0 = (T[]) ((FieldElement[]) MathArrays.buildArray(r4, r5.length + r6.length));
        this.data = r0;
        System.arraycopy(r5, 0, r0, 0, r5.length);
        System.arraycopy(r6, 0, this.data, r5.length, r6.length);
        this.field = r4;
        return;
    L7:
        throw new ZeroException(LocalizedFormats.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT, new Object[0]);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public Field<T> getField() {
        return this.field;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> copy() {
        return new ArrayFieldVector(this, true);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> add(FieldVector<T> r6) throws DimensionMismatchException {
        return add((ArrayFieldVector) r6);
    L4:
        checkVectorDimensions(r6);
        FieldElement[] r0 = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
        int r2 = 0;
    L5:
        T[] r3 = this.data;
        if (r2 >= r3.length) goto L9;
        r0[r2] = (FieldElement) r3[r2].add(r6.getEntry(r2));
        r2 = r2 + 1;
        goto L5
    L9:
        return new ArrayFieldVector(this.field, r0, false);
    }

    public ArrayFieldVector<T> add(ArrayFieldVector<T> r6) throws DimensionMismatchException {
        checkVectorDimensions(r6.data.length);
        FieldElement[] r0 = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
        int r2 = 0;
    L3:
        T[] r3 = this.data;
        if (r2 >= r3.length) goto L7;
        r0[r2] = (FieldElement) r3[r2].add(r6.data[r2]);
        r2 = r2 + 1;
        goto L3
    L7:
        return new ArrayFieldVector(this.field, r0, false);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> subtract(FieldVector<T> r6) throws DimensionMismatchException {
        return subtract((ArrayFieldVector) r6);
    L4:
        checkVectorDimensions(r6);
        FieldElement[] r0 = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
        int r2 = 0;
    L5:
        T[] r3 = this.data;
        if (r2 >= r3.length) goto L9;
        r0[r2] = (FieldElement) r3[r2].subtract(r6.getEntry(r2));
        r2 = r2 + 1;
        goto L5
    L9:
        return new ArrayFieldVector(this.field, r0, false);
    }

    public ArrayFieldVector<T> subtract(ArrayFieldVector<T> r6) throws DimensionMismatchException {
        checkVectorDimensions(r6.data.length);
        FieldElement[] r0 = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
        int r2 = 0;
    L3:
        T[] r3 = this.data;
        if (r2 >= r3.length) goto L7;
        r0[r2] = (FieldElement) r3[r2].subtract(r6.data[r2]);
        r2 = r2 + 1;
        goto L3
    L7:
        return new ArrayFieldVector(this.field, r0, false);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapAdd(T r6) throws NullArgumentException {
        FieldElement[] r0 = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
        int r2 = 0;
    L3:
        T[] r3 = this.data;
        if (r2 >= r3.length) goto L7;
        r0[r2] = (FieldElement) r3[r2].add(r6);
        r2 = r2 + 1;
        goto L3
    L7:
        return new ArrayFieldVector(this.field, r0, false);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapAddToSelf(T r4) throws NullArgumentException {
        int r0 = 0;
    L3:
        FieldElement[] r1 = this.data;
        if (r0 >= r1.length) goto L6;
        r1[r0] = (FieldElement) r1[r0].add(r4);
        r0 = r0 + 1;
        goto L3
    L6:
        return this;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapSubtract(T r6) throws NullArgumentException {
        FieldElement[] r0 = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
        int r2 = 0;
    L3:
        T[] r3 = this.data;
        if (r2 >= r3.length) goto L7;
        r0[r2] = (FieldElement) r3[r2].subtract(r6);
        r2 = r2 + 1;
        goto L3
    L7:
        return new ArrayFieldVector(this.field, r0, false);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapSubtractToSelf(T r4) throws NullArgumentException {
        int r0 = 0;
    L3:
        FieldElement[] r1 = this.data;
        if (r0 >= r1.length) goto L6;
        r1[r0] = (FieldElement) r1[r0].subtract(r4);
        r0 = r0 + 1;
        goto L3
    L6:
        return this;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapMultiply(T r6) throws NullArgumentException {
        FieldElement[] r0 = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
        int r2 = 0;
    L3:
        T[] r3 = this.data;
        if (r2 >= r3.length) goto L7;
        r0[r2] = (FieldElement) r3[r2].multiply(r6);
        r2 = r2 + 1;
        goto L3
    L7:
        return new ArrayFieldVector(this.field, r0, false);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapMultiplyToSelf(T r4) throws NullArgumentException {
        int r0 = 0;
    L3:
        FieldElement[] r1 = this.data;
        if (r0 >= r1.length) goto L6;
        r1[r0] = (FieldElement) r1[r0].multiply(r4);
        r0 = r0 + 1;
        goto L3
    L6:
        return this;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapDivide(T r6) throws NullArgumentException, MathArithmeticException {
        MathUtils.checkNotNull(r6);
        FieldElement[] r0 = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
        int r2 = 0;
    L3:
        T[] r3 = this.data;
        if (r2 >= r3.length) goto L7;
        r0[r2] = (FieldElement) r3[r2].divide(r6);
        r2 = r2 + 1;
        goto L3
    L7:
        return new ArrayFieldVector(this.field, r0, false);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapDivideToSelf(T r4) throws NullArgumentException, MathArithmeticException {
        MathUtils.checkNotNull(r4);
        int r0 = 0;
    L3:
        FieldElement[] r1 = this.data;
        if (r0 >= r1.length) goto L6;
        r1[r0] = (FieldElement) r1[r0].divide(r4);
        r0 = r0 + 1;
        goto L3
    L6:
        return this;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapInv() throws MathArithmeticException {
        FieldElement[] r0 = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
        T r1 = this.field.getOne();
        int r3 = 0;
    L3:
        T[] r4 = this.data;
        if (r3 >= r4.length) goto L10;
        r0[r3] = (FieldElement) r1.divide(r4[r3]);     // Catch: MathArithmeticException -> L7
        r3 = r3 + 1;
    L8:
        throw new MathArithmeticException(LocalizedFormats.INDEX, new Object[]{Integer.valueOf(r3)});
    L10:
        return new ArrayFieldVector(this.field, r0, false);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapInvToSelf() throws MathArithmeticException {
        T r0 = this.field.getOne();
        int r2 = 0;
    L3:
        T[] r3 = this.data;
        if (r2 >= r3.length) goto L9;
        r3[r2] = (FieldElement) r0.divide(r3[r2]);     // Catch: MathArithmeticException -> L7
        r2 = r2 + 1;
    L8:
        throw new MathArithmeticException(LocalizedFormats.INDEX, new Object[]{Integer.valueOf(r2)});
    L9:
        return this;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> ebeMultiply(FieldVector<T> r6) throws DimensionMismatchException {
        return ebeMultiply((ArrayFieldVector) r6);
    L4:
        checkVectorDimensions(r6);
        FieldElement[] r0 = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
        int r2 = 0;
    L5:
        T[] r3 = this.data;
        if (r2 >= r3.length) goto L9;
        r0[r2] = (FieldElement) r3[r2].multiply(r6.getEntry(r2));
        r2 = r2 + 1;
        goto L5
    L9:
        return new ArrayFieldVector(this.field, r0, false);
    }

    public ArrayFieldVector<T> ebeMultiply(ArrayFieldVector<T> r6) throws DimensionMismatchException {
        checkVectorDimensions(r6.data.length);
        FieldElement[] r0 = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
        int r2 = 0;
    L3:
        T[] r3 = this.data;
        if (r2 >= r3.length) goto L7;
        r0[r2] = (FieldElement) r3[r2].multiply(r6.data[r2]);
        r2 = r2 + 1;
        goto L3
    L7:
        return new ArrayFieldVector(this.field, r0, false);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> ebeDivide(FieldVector<T> r6) throws DimensionMismatchException, MathArithmeticException {
        return ebeDivide((ArrayFieldVector) r6);
    L4:
        checkVectorDimensions(r6);
        FieldElement[] r0 = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
        int r2 = 0;
    L5:
        T[] r3 = this.data;
        if (r2 >= r3.length) goto L12;
        r0[r2] = (FieldElement) r3[r2].divide(r6.getEntry(r2));     // Catch: MathArithmeticException -> L9
        r2 = r2 + 1;
    L10:
        throw new MathArithmeticException(LocalizedFormats.INDEX, new Object[]{Integer.valueOf(r2)});
    L12:
        return new ArrayFieldVector(this.field, r0, false);
    }

    public ArrayFieldVector<T> ebeDivide(ArrayFieldVector<T> r6) throws DimensionMismatchException, MathArithmeticException {
        checkVectorDimensions(r6.data.length);
        FieldElement[] r0 = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
        int r2 = 0;
    L3:
        T[] r3 = this.data;
        if (r2 >= r3.length) goto L10;
        r0[r2] = (FieldElement) r3[r2].divide(r6.data[r2]);     // Catch: MathArithmeticException -> L7
        r2 = r2 + 1;
    L8:
        throw new MathArithmeticException(LocalizedFormats.INDEX, new Object[]{Integer.valueOf(r2)});
    L10:
        return new ArrayFieldVector(this.field, r0, false);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public T[] getData() {
        return (T[]) ((FieldElement[]) this.data.clone());
    }

    public T[] getDataRef() {
        return this.data;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public T dotProduct(FieldVector<T> r5) throws DimensionMismatchException {
        return (T) dotProduct((ArrayFieldVector) r5);
    L4:
        checkVectorDimensions(r5);
        T r0 = this.field.getZero();
        int r1 = 0;
    L5:
        T[] r2 = this.data;
        if (r1 >= r2.length) goto L8;
        r0 = (T) r0.add(r2[r1].multiply(r5.getEntry(r1)));
        r1 = r1 + 1;
        goto L5
    L8:
        return r0;
    }

    public T dotProduct(ArrayFieldVector<T> r5) throws DimensionMismatchException {
        checkVectorDimensions(r5.data.length);
        T r0 = this.field.getZero();
        int r1 = 0;
    L3:
        T[] r2 = this.data;
        if (r1 >= r2.length) goto L6;
        r0 = (T) r0.add(r2[r1].multiply(r5.data[r1]));
        r1 = r1 + 1;
        goto L3
    L6:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> projection(FieldVector<T> r2) throws DimensionMismatchException, MathArithmeticException {
        return r2.mapMultiply((FieldElement) dotProduct(r2).divide(r2.dotProduct(r2)));
    }

    public ArrayFieldVector<T> projection(ArrayFieldVector<T> r2) throws DimensionMismatchException, MathArithmeticException {
        return (ArrayFieldVector) r2.mapMultiply((FieldElement) dotProduct(r2).divide(r2.dotProduct(r2)));
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldMatrix<T> outerProduct(FieldVector<T> r9) {
        return outerProduct((ArrayFieldVector) r9);
    L4:
        int r0 = this.data.length;
        int r1 = r9.getDimension();
        Array2DRowFieldMatrix r2 = new Array2DRowFieldMatrix(this.field, r0, r1);
        int r4 = 0;
    L5:
        if (r4 >= r0) goto L10;
        int r5 = 0;
    L7:
        if (r5 >= r1) goto L9;
        r2.setEntry(r4, r5, (FieldElement) this.data[r4].multiply(r9.getEntry(r5)));
        r5 = r5 + 1;
        goto L7
    L9:
        r4 = r4 + 1;
        goto L5
    L10:
        return r2;
    }

    public FieldMatrix<T> outerProduct(ArrayFieldVector<T> r9) {
        int r0 = this.data.length;
        int r1 = r9.data.length;
        Array2DRowFieldMatrix r2 = new Array2DRowFieldMatrix(this.field, r0, r1);
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L8;
        int r5 = 0;
    L5:
        if (r5 >= r1) goto L7;
        r2.setEntry(r4, r5, (FieldElement) this.data[r4].multiply(r9.data[r5]));
        r5 = r5 + 1;
        goto L5
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        return r2;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public T getEntry(int r1) {
        return this.data[r1];
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public int getDimension() {
        return this.data.length;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> append(FieldVector<T> r3) {
        return append((ArrayFieldVector) r3);
    L5:
        return new ArrayFieldVector(this, new ArrayFieldVector(r3));
    }

    public ArrayFieldVector<T> append(ArrayFieldVector<T> r2) {
        return new ArrayFieldVector(this, r2);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> append(T r5) {
        FieldElement[] r0 = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length + 1);
        T[] r1 = this.data;
        System.arraycopy(r1, 0, r0, 0, r1.length);
        r0[this.data.length] = r5;
        return new ArrayFieldVector(this.field, r0, false);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> getSubVector(int r5, int r6) throws OutOfRangeException, NotPositiveException {
        if (r6 < 0) goto L9;
        ArrayFieldVector r0 = new ArrayFieldVector(this.field, r6);
        System.arraycopy(this.data, r5, r0.data, 0, r6);     // Catch: IndexOutOfBoundsException -> L6
    L7:
        return r0;
    L6:
        checkIndex(r5);
        checkIndex((r5 + r6) - 1);
        goto L7
    L9:
        throw new NotPositiveException(LocalizedFormats.NUMBER_OF_ELEMENTS_SHOULD_BE_POSITIVE, Integer.valueOf(r6));
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public void setEntry(int r2, T r3) {
        this.data[r2] = r3;     // Catch: IndexOutOfBoundsException -> L4
        return;
    L4:
        checkIndex(r2);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public void setSubVector(int r4, FieldVector<T> r5) throws OutOfRangeException {
        set(r4, (ArrayFieldVector) r5);     // Catch: ClassCastException -> L4 IndexOutOfBoundsException -> L9
    L14:
        return;
    L9:
        checkIndex(r4);
        checkIndex((r4 + r5.getDimension()) - 1);
        return;
    L4:
        int r0 = r4;
    L6:
        if (r0 >= (r5.getDimension() + r4)) goto L15;
        ((T[]) this.data)[r0] = r5.getEntry(r0 - r4);     // Catch: IndexOutOfBoundsException -> L9
        r0 = r0 + 1;
        goto L6
    }

    public void set(int r5, ArrayFieldVector<T> r6) throws OutOfRangeException {
        T[] r0 = r6.data;     // Catch: IndexOutOfBoundsException -> L4
        System.arraycopy(r0, 0, this.data, r5, r0.length);     // Catch: IndexOutOfBoundsException -> L4
        return;
    L4:
        checkIndex(r5);
        checkIndex((r5 + r6.data.length) - 1);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public void set(T r1) {
        Arrays.fill(this.data, r1);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public T[] toArray() {
        return (T[]) ((FieldElement[]) this.data.clone());
    }

    protected void checkVectorDimensions(FieldVector<T> r1) throws DimensionMismatchException {
        checkVectorDimensions(r1.getDimension());
    }

    protected void checkVectorDimensions(int r2) throws DimensionMismatchException {
        if (this.data.length != r2) goto L6;
        return;
    L6:
        throw new DimensionMismatchException(this.data.length, r2);
    }

    public T walkInDefaultOrder(FieldVectorPreservingVisitor<T> r4) {
        int r0 = getDimension();
        int r2 = 0;
        r4.start(r0, 0, r0 - 1);
    L3:
        if (r2 >= r0) goto L6;
        r4.visit(r2, getEntry(r2));
        r2 = r2 + 1;
        goto L3
    L6:
        return (T) r4.end();
    }

    public T walkInDefaultOrder(FieldVectorPreservingVisitor<T> r2, int r3, int r4) throws NumberIsTooSmallException, OutOfRangeException {
        checkIndices(r3, r4);
        r2.start(getDimension(), r3, r4);
    L3:
        if (r3 > r4) goto L6;
        r2.visit(r3, getEntry(r3));
        r3 = r3 + 1;
        goto L3
    L6:
        return (T) r2.end();
    }

    public T walkInOptimizedOrder(FieldVectorPreservingVisitor<T> r1) {
        return (T) walkInDefaultOrder(r1);
    }

    public T walkInOptimizedOrder(FieldVectorPreservingVisitor<T> r1, int r2, int r3) throws NumberIsTooSmallException, OutOfRangeException {
        return (T) walkInDefaultOrder(r1, r2, r3);
    }

    public T walkInDefaultOrder(FieldVectorChangingVisitor<T> r4) {
        int r0 = getDimension();
        int r2 = 0;
        r4.start(r0, 0, r0 - 1);
    L3:
        if (r2 >= r0) goto L6;
        setEntry(r2, r4.visit(r2, getEntry(r2)));
        r2 = r2 + 1;
        goto L3
    L6:
        return (T) r4.end();
    }

    public T walkInDefaultOrder(FieldVectorChangingVisitor<T> r2, int r3, int r4) throws NumberIsTooSmallException, OutOfRangeException {
        checkIndices(r3, r4);
        r2.start(getDimension(), r3, r4);
    L3:
        if (r3 > r4) goto L6;
        setEntry(r3, r2.visit(r3, getEntry(r3)));
        r3 = r3 + 1;
        goto L3
    L6:
        return (T) r2.end();
    }

    public T walkInOptimizedOrder(FieldVectorChangingVisitor<T> r1) {
        return (T) walkInDefaultOrder(r1);
    }

    public T walkInOptimizedOrder(FieldVectorChangingVisitor<T> r1, int r2, int r3) throws NumberIsTooSmallException, OutOfRangeException {
        return (T) walkInDefaultOrder(r1, r2, r3);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if (r6 != null) goto L20;
        return false;
    L20:
        FieldVector r7 = (FieldVector) r6;     // Catch: ClassCastException -> L19
        if (this.data.length == r7.getDimension()) goto L11;
        return false;
    L11:
        int r2 = 0;
    L12:
        T[] r3 = this.data;     // Catch: ClassCastException -> L19
        if (r2 >= r3.length) goto L18;
        if (r3[r2].equals(r7.getEntry(r2)) == false) goto L16;
        r2 = r2 + 1;
        goto L12
    L16:
        return false;
    L18:
        return true;
    L19:
        return false;
    }

    public int hashCode() {
        T[] r4 = this.data;
        int r0 = r4.length;
        int r1 = 3542;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1 = r1 ^ r4[r2].hashCode();
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    private void checkIndex(int r4) throws OutOfRangeException {
        if (r4 < 0) goto L7;
        if (r4 >= getDimension()) goto L7;
        return;
    L7:
        throw new OutOfRangeException(LocalizedFormats.INDEX, Integer.valueOf(r4), 0, Integer.valueOf(getDimension() - 1));
    }

    private void checkIndices(int r3, int r4) throws NumberIsTooSmallException, OutOfRangeException {
        int r2 = getDimension();
        if (r3 < 0) goto L14;
        if (r3 >= r2) goto L14;
        if (r4 < 0) goto L12;
        if (r4 >= r2) goto L12;
        if (r4 < r3) goto L10;
        return;
    L10:
        throw new NumberIsTooSmallException(LocalizedFormats.INITIAL_ROW_AFTER_FINAL_ROW, Integer.valueOf(r4), Integer.valueOf(r3), false);
    L12:
        throw new OutOfRangeException(LocalizedFormats.INDEX, Integer.valueOf(r4), 0, Integer.valueOf(r2 - 1));
    L14:
        throw new OutOfRangeException(LocalizedFormats.INDEX, Integer.valueOf(r3), 0, Integer.valueOf(r2 - 1));
    }
}
