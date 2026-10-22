package org.apache.commons.math3.linear;

import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.OpenIntToFieldHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class SparseFieldVector<T extends FieldElement<T>> implements FieldVector<T>, Serializable {
    private static final long serialVersionUID = 7841233292190413362L;
    private final OpenIntToFieldHashMap<T> entries;
    private final Field<T> field;
    private final int virtualSize;

    public SparseFieldVector(Field<T> r2) {
        this(r2, 0);
    }

    public SparseFieldVector(Field<T> r1, int r2) {
        this.field = r1;
        this.virtualSize = r2;
        this.entries = new OpenIntToFieldHashMap(r1);
    }

    protected SparseFieldVector(SparseFieldVector<T> r2, int r3) {
        this.field = r2.field;
        this.virtualSize = r2.getDimension() + r3;
        this.entries = new OpenIntToFieldHashMap(r2.entries);
    }

    public SparseFieldVector(Field<T> r1, int r2, int r3) {
        this.field = r1;
        this.virtualSize = r2;
        this.entries = new OpenIntToFieldHashMap(r1, r3);
    }

    public SparseFieldVector(Field<T> r3, T[] r4) throws NullArgumentException {
        MathUtils.checkNotNull(r4);
        this.field = r3;
        this.virtualSize = r4.length;
        this.entries = new OpenIntToFieldHashMap(r3);
        int r5 = 0;
    L4:
        if (r5 >= r4.length) goto L6;
        T r0 = r4[r5];
        this.entries.put(r5, r0);
        r5 = r5 + 1;
        goto L4
    }

    public SparseFieldVector(SparseFieldVector<T> r2) {
        this.field = r2.field;
        this.virtualSize = r2.getDimension();
        this.entries = new OpenIntToFieldHashMap(r2.getEntries());
    }

    private OpenIntToFieldHashMap<T> getEntries() {
        return this.entries;
    }

    public FieldVector<T> add(SparseFieldVector<T> r5) throws DimensionMismatchException {
        checkVectorDimensions(r5.getDimension());
        SparseFieldVector r0 = (SparseFieldVector) copy();
        OpenIntToFieldHashMap<T>.Iterator r6 = r5.getEntries().iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        r6.advance();
        int r1 = r6.key();
        FieldElement r2 = r6.value();
        if (this.entries.containsKey(r1) == true) goto L7;
        r0.setEntry(r1, r2);
        goto L4
    L7:
        r0.setEntry(r1, (FieldElement) this.entries.get(r1).add(r2));
        goto L4
    L9:
        return r0;
    }

    public FieldVector<T> append(SparseFieldVector<T> r4) {
        SparseFieldVector r0 = new SparseFieldVector(this, r4.getDimension());
        OpenIntToFieldHashMap<T>.Iterator r5 = r4.entries.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.advance();
        r0.setEntry(r5.key() + this.virtualSize, r5.value());
        goto L4
    L6:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> append(FieldVector<T> r6) {
        if ((r6 instanceof SparseFieldVector) == true) goto L5;
        int r0 = r6.getDimension();
        SparseFieldVector r1 = new SparseFieldVector(this, r0);
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        r1.setEntry(this.virtualSize + r2, r6.getEntry(r2));
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    L5:
        return append((SparseFieldVector) r6);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> append(T r3) throws NullArgumentException {
        MathUtils.checkNotNull(r3);
        SparseFieldVector r0 = new SparseFieldVector(this, 1);
        r0.setEntry(this.virtualSize, r3);
        return r0;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> copy() {
        return new SparseFieldVector(this);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public T dotProduct(FieldVector<T> r4) throws DimensionMismatchException {
        checkVectorDimensions(r4.getDimension());
        T r0 = this.field.getZero();
        OpenIntToFieldHashMap<T>.Iterator r3 = this.entries.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.advance();
        r0 = (T) r0.add(r4.getEntry(r3.key()).multiply(r3.value()));
        goto L4
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> ebeDivide(FieldVector<T> r5) throws DimensionMismatchException, MathArithmeticException {
        checkVectorDimensions(r5.getDimension());
        SparseFieldVector r0 = new SparseFieldVector(this);
        OpenIntToFieldHashMap<T>.Iterator r4 = r0.entries.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r4.advance();
        r0.setEntry(r4.key(), (FieldElement) r4.value().divide(r5.getEntry(r4.key())));
        goto L4
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> ebeMultiply(FieldVector<T> r5) throws DimensionMismatchException {
        checkVectorDimensions(r5.getDimension());
        SparseFieldVector r0 = new SparseFieldVector(this);
        OpenIntToFieldHashMap<T>.Iterator r4 = r0.entries.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r4.advance();
        r0.setEntry(r4.key(), (FieldElement) r4.value().multiply(r5.getEntry(r4.key())));
        goto L4
    L6:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    @Deprecated
    public T[] getData() {
        return (T[]) toArray();
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public int getDimension() {
        return this.virtualSize;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public T getEntry(int r1) throws OutOfRangeException {
        checkIndex(r1);
        return (T) this.entries.get(r1);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public Field<T> getField() {
        return this.field;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> getSubVector(int r4, int r5) throws OutOfRangeException, NotPositiveException {
        if (r5 < 0) goto L12;
        checkIndex(r4);
        int r0 = r4 + r5;
        checkIndex(r0 - 1);
        SparseFieldVector r1 = new SparseFieldVector(this.field, r5);
        OpenIntToFieldHashMap<T>.Iterator r3 = this.entries.iterator();
    L5:
        if (r3.hasNext() == false) goto L10;
        r3.advance();
        int r6 = r3.key();
        if (r6 < r4) goto L5;
        if (r6 >= r0) goto L5;
        r1.setEntry(r6 - r4, r3.value());
        goto L5
    L10:
        return r1;
    L12:
        throw new NotPositiveException(LocalizedFormats.NUMBER_OF_ELEMENTS_SHOULD_BE_POSITIVE, Integer.valueOf(r5));
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapAdd(T r1) throws NullArgumentException {
        return copy().mapAddToSelf(r1);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapAddToSelf(T r3) throws NullArgumentException {
        int r0 = 0;
    L4:
        if (r0 >= this.virtualSize) goto L6;
        setEntry(r0, (FieldElement) getEntry(r0).add(r3));
        r0 = r0 + 1;
        goto L4
    L6:
        return this;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapDivide(T r1) throws NullArgumentException, MathArithmeticException {
        return copy().mapDivideToSelf(r1);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapDivideToSelf(T r5) throws NullArgumentException, MathArithmeticException {
        OpenIntToFieldHashMap<T>.Iterator r0 = this.entries.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.advance();
        this.entries.put(r0.key(), (FieldElement) r0.value().divide(r5));
        goto L4
    L6:
        return this;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapInv() throws MathArithmeticException {
        return copy().mapInvToSelf();
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapInvToSelf() throws MathArithmeticException {
        int r0 = 0;
    L4:
        if (r0 >= this.virtualSize) goto L6;
        setEntry(r0, (FieldElement) this.field.getOne().divide(getEntry(r0)));
        r0 = r0 + 1;
        goto L4
    L6:
        return this;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapMultiply(T r1) throws NullArgumentException {
        return copy().mapMultiplyToSelf(r1);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapMultiplyToSelf(T r5) throws NullArgumentException {
        OpenIntToFieldHashMap<T>.Iterator r0 = this.entries.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.advance();
        this.entries.put(r0.key(), (FieldElement) r0.value().multiply(r5));
        goto L4
    L6:
        return this;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapSubtract(T r1) throws NullArgumentException {
        return copy().mapSubtractToSelf(r1);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapSubtractToSelf(T r2) throws NullArgumentException {
        return mapAddToSelf((FieldElement) this.field.getZero().subtract(r2));
    }

    public FieldMatrix<T> outerProduct(SparseFieldVector<T> r7) {
        int r0 = r7.getDimension();
        SparseFieldMatrix r1 = new SparseFieldMatrix(this.field, this.virtualSize, r0);
        OpenIntToFieldHashMap<T>.Iterator r6 = this.entries.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        r6.advance();
        OpenIntToFieldHashMap<T>.Iterator r2 = r7.entries.iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        r2.advance();
        r1.setEntry(r6.key(), r2.key(), (FieldElement) r6.value().multiply(r2.value()));
        goto L7
    L9:
        return r1;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldMatrix<T> outerProduct(FieldVector<T> r7) {
        if ((r7 instanceof SparseFieldVector) == true) goto L5;
        int r0 = r7.getDimension();
        SparseFieldMatrix r1 = new SparseFieldMatrix(this.field, this.virtualSize, r0);
        OpenIntToFieldHashMap<T>.Iterator r6 = this.entries.iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        r6.advance();
        int r2 = r6.key();
        FieldElement r3 = r6.value();
        int r4 = 0;
    L10:
        if (r4 >= r0) goto L8;
        r1.setEntry(r2, r4, (FieldElement) r3.multiply(r7.getEntry(r4)));
        r4 = r4 + 1;
        goto L10
    L12:
        return r1;
    L5:
        return outerProduct((SparseFieldVector) r7);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> projection(FieldVector<T> r2) throws DimensionMismatchException, MathArithmeticException {
        checkVectorDimensions(r2.getDimension());
        return r2.mapMultiply((FieldElement) dotProduct(r2).divide(r2.dotProduct(r2)));
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public void set(T r3) {
        MathUtils.checkNotNull(r3);
        int r0 = 0;
    L4:
        if (r0 >= this.virtualSize) goto L6;
        setEntry(r0, r3);
        r0 = r0 + 1;
        goto L4
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public void setEntry(int r1, T r2) throws NullArgumentException, OutOfRangeException {
        MathUtils.checkNotNull(r2);
        checkIndex(r1);
        this.entries.put(r1, r2);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public void setSubVector(int r5, FieldVector<T> r6) throws OutOfRangeException {
        checkIndex(r5);
        checkIndex((r6.getDimension() + r5) - 1);
        int r0 = r6.getDimension();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        setEntry(r1 + r5, r6.getEntry(r1));
        r1 = r1 + 1;
        goto L3
    }

    public SparseFieldVector<T> subtract(SparseFieldVector<T> r5) throws DimensionMismatchException {
        checkVectorDimensions(r5.getDimension());
        SparseFieldVector<T> r0 = (SparseFieldVector) copy();
        OpenIntToFieldHashMap<T>.Iterator r6 = r5.getEntries().iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        r6.advance();
        int r1 = r6.key();
        if (this.entries.containsKey(r1) == true) goto L7;
        r0.setEntry(r1, (FieldElement) this.field.getZero().subtract(r6.value()));
        goto L4
    L7:
        r0.setEntry(r1, (FieldElement) this.entries.get(r1).subtract(r6.value()));
        goto L4
    L9:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> subtract(FieldVector<T> r6) throws DimensionMismatchException {
        if ((r6 instanceof SparseFieldVector) == true) goto L5;
        int r0 = r6.getDimension();
        checkVectorDimensions(r0);
        SparseFieldVector r1 = new SparseFieldVector(this);
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L13;
        if (this.entries.containsKey(r2) == false) goto L11;
        r1.setEntry(r2, (FieldElement) this.entries.get(r2).subtract(r6.getEntry(r2)));
    L12:
        r2 = r2 + 1;
        goto L7
    L11:
        r1.setEntry(r2, (FieldElement) this.field.getZero().subtract(r6.getEntry(r2)));
        goto L12
    L13:
        return r1;
    L5:
        return subtract((SparseFieldVector) r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.FieldVector
    public T[] toArray() {
        T[] r0 = (T[]) ((FieldElement[]) MathArrays.buildArray(this.field, this.virtualSize));
        OpenIntToFieldHashMap<T>.Iterator r3 = this.entries.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.advance();
        r0[r3.key()] = r3.value();
        goto L4
    L6:
        return r0;
    }

    private void checkIndex(int r3) throws OutOfRangeException {
        if (r3 < 0) goto L7;
        if (r3 >= getDimension()) goto L7;
        return;
    L7:
        throw new OutOfRangeException(Integer.valueOf(r3), 0, Integer.valueOf(getDimension() - 1));
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

    protected void checkVectorDimensions(int r2) throws DimensionMismatchException {
        if (getDimension() != r2) goto L6;
        return;
    L6:
        throw new DimensionMismatchException(getDimension(), r2);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> add(FieldVector<T> r6) throws DimensionMismatchException {
        if ((r6 instanceof SparseFieldVector) == true) goto L5;
        int r0 = r6.getDimension();
        checkVectorDimensions(r0);
        SparseFieldVector r1 = new SparseFieldVector(this.field, getDimension());
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        r1.setEntry(r2, (FieldElement) r6.getEntry(r2).add(getEntry(r2)));
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    L5:
        return add((SparseFieldVector) r6);
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

    public int hashCode() {
        Field<T> r0 = this.field;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = ((r1 + 31) * 31) + this.virtualSize;
        OpenIntToFieldHashMap<T>.Iterator r3 = this.entries.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        r3.advance();
        int r4 = r2 * 31;
        r2 = r4 + r3.value().hashCode();
        goto L8
    L10:
        return r2;
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if ((r6 instanceof SparseFieldVector) == true) goto L8;
        return false;
    L8:
        SparseFieldVector r7 = (SparseFieldVector) r6;
        Field<T> r1 = this.field;
        if (r1 != null) goto L14;
        if (r7.field == null) goto L17;
        return false;
    L17:
        if (this.virtualSize == r7.virtualSize) goto L19;
        return false;
    L19:
        OpenIntToFieldHashMap<T>.Iterator r2 = this.entries.iterator();
    L21:
        if (r2.hasNext() == false) goto L25;
        r2.advance();
        if (r7.getEntry(r2.key()).equals(r2.value()) == true) goto L21;
        return false;
    L25:
        OpenIntToFieldHashMap<T>.Iterator r8 = r7.getEntries().iterator();
    L27:
        if (r8.hasNext() == false) goto L31;
        r8.advance();
        if (r8.value().equals(getEntry(r8.key())) == true) goto L27;
        return false;
    L31:
        return true;
    L14:
        if (r1.equals(r7.field) == true) goto L17;
        return false;
    }
}
