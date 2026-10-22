package org.apache.commons.math3.linear;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.function.Add;
import org.apache.commons.math3.analysis.function.Divide;
import org.apache.commons.math3.analysis.function.Multiply;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public abstract class RealVector {

    protected class Entry {
        private int index;
        final /* synthetic */ RealVector this$0;

        public Entry(RealVector r1) {
            this.this$0 = r1;
            setIndex(0);
        }

        public double getValue() {
            return this.this$0.getEntry(getIndex());
        }

        public void setValue(double r2) {
            this.this$0.setEntry(getIndex(), r2);
        }

        public int getIndex() {
            return this.index;
        }

        public void setIndex(int r1) {
            this.index = r1;
        }
    }

    protected class SparseEntryIterator implements Iterator<Entry> {
        private Entry current;
        private final int dim;
        private Entry next;
        final /* synthetic */ RealVector this$0;

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Entry next() {
            return next2();
        }

        protected SparseEntryIterator(RealVector r5) {
            this.this$0 = r5;
            this.dim = r5.getDimension();
            this.current = new Entry(r5);
            Entry r0 = new Entry(r5);
            this.next = r0;
            if (r0.getValue() != 0.0d) goto L6;
            advance(this.next);
            return;
        }

        protected void advance(Entry r5) {
            if (r5 != null) goto L4;
            return;
        L4:
            r5.setIndex(r5.getIndex() + 1);
            if (r5.getIndex() >= this.dim) goto L9;
            if (r5.getValue() == 0.0d) goto L4;
        L9:
            if (r5.getIndex() < this.dim) goto L15;
            r5.setIndex(-1);
            return;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.next.getIndex() < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public Entry next2() {
            int r0 = this.next.getIndex();
            if (r0 < 0) goto L7;
            this.current.setIndex(r0);
            advance(this.next);
            return this.current;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() throws MathUnsupportedOperationException {
            throw new MathUnsupportedOperationException();
        }
    }

    public abstract RealVector append(double r1);

    public abstract RealVector append(RealVector r1);

    public abstract RealVector copy();

    public abstract RealVector ebeDivide(RealVector r1) throws DimensionMismatchException;

    public abstract RealVector ebeMultiply(RealVector r1) throws DimensionMismatchException;

    public abstract int getDimension();

    public abstract double getEntry(int r1) throws OutOfRangeException;

    public abstract RealVector getSubVector(int r1, int r2) throws NotPositiveException, OutOfRangeException;

    public abstract boolean isInfinite();

    public abstract boolean isNaN();

    public abstract void setEntry(int r1, double r2) throws OutOfRangeException;

    public abstract void setSubVector(int r1, RealVector r2) throws OutOfRangeException;

    public RealVector() {
    }

    public void addToEntry(int r3, double r4) throws OutOfRangeException {
        setEntry(r3, getEntry(r3) + r4);
    }

    protected void checkVectorDimensions(RealVector r1) throws DimensionMismatchException {
        checkVectorDimensions(r1.getDimension());
    }

    protected void checkVectorDimensions(int r2) throws DimensionMismatchException {
        int r1 = getDimension();
        if (r1 != r2) goto L6;
        return;
    L6:
        throw new DimensionMismatchException(r1, r2);
    }

    protected void checkIndex(int r4) throws OutOfRangeException {
        if (r4 < 0) goto L7;
        if (r4 >= getDimension()) goto L7;
        return;
    L7:
        throw new OutOfRangeException(LocalizedFormats.INDEX, Integer.valueOf(r4), 0, Integer.valueOf(getDimension() - 1));
    }

    protected void checkIndices(int r3, int r4) throws NumberIsTooSmallException, OutOfRangeException {
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

    public RealVector add(RealVector r7) throws DimensionMismatchException {
        checkVectorDimensions(r7);
        RealVector r8 = r7.copy();
        Iterator<Entry> r6 = iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Entry r0 = r6.next();
        int r1 = r0.getIndex();
        r8.setEntry(r1, r0.getValue() + r8.getEntry(r1));
        goto L4
    L6:
        return r8;
    }

    public RealVector subtract(RealVector r7) throws DimensionMismatchException {
        checkVectorDimensions(r7);
        RealVector r8 = r7.mapMultiply(-1.0d);
        Iterator<Entry> r6 = iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Entry r0 = r6.next();
        int r1 = r0.getIndex();
        r8.setEntry(r1, r0.getValue() + r8.getEntry(r1));
        goto L4
    L6:
        return r8;
    }

    public RealVector mapAdd(double r1) {
        return copy().mapAddToSelf(r1);
    }

    public RealVector mapAddToSelf(double r3) {
        if (r3 != 0.0d) goto L5;
        return this;
    L5:
        return mapToSelf(FunctionUtils.fix2ndArgument(new Add(), r3));
    }

    public double dotProduct(RealVector r9) throws DimensionMismatchException {
        checkVectorDimensions(r9);
        int r0 = getDimension();
        double r1 = 0.0d;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1 = r1 + (getEntry(r3) * r9.getEntry(r3));
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    public double cosine(RealVector r8) throws DimensionMismatchException, MathArithmeticException {
        double r0 = getNorm();
        double r2 = r8.getNorm();
        if (r0 == 0.0d) goto L9;
        if (r2 == 0.0d) goto L9;
        return dotProduct(r8) / (r0 * r2);
    L9:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    public double getDistance(RealVector r8) throws DimensionMismatchException {
        checkVectorDimensions(r8);
        Iterator<Entry> r7 = iterator();
        double r0 = 0.0d;
    L4:
        if (r7.hasNext() == false) goto L7;
        Entry r2 = r7.next();
        double r3 = r2.getValue() - r8.getEntry(r2.getIndex());
        r0 = r0 + (r3 * r3);
        goto L4
    L7:
        return FastMath.sqrt(r0);
    }

    public double getNorm() {
        Iterator<Entry> r4 = iterator();
        double r0 = 0.0d;
    L4:
        if (r4.hasNext() == false) goto L7;
        double r2 = r4.next().getValue();
        r0 = r0 + (r2 * r2);
        goto L4
    L7:
        return FastMath.sqrt(r0);
    }

    public double getL1Norm() {
        Iterator<Entry> r4 = iterator();
        double r0 = 0.0d;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 + FastMath.abs(r4.next().getValue());
        goto L4
    L6:
        return r0;
    }

    public double getLInfNorm() {
        Iterator<Entry> r4 = iterator();
        double r0 = 0.0d;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = FastMath.max(r0, FastMath.abs(r4.next().getValue()));
        goto L4
    L6:
        return r0;
    }

    public double getL1Distance(RealVector r8) throws DimensionMismatchException {
        checkVectorDimensions(r8);
        Iterator<Entry> r7 = iterator();
        double r0 = 0.0d;
    L4:
        if (r7.hasNext() == false) goto L6;
        Entry r2 = r7.next();
        r0 = r0 + FastMath.abs(r2.getValue() - r8.getEntry(r2.getIndex()));
        goto L4
    L6:
        return r0;
    }

    public double getLInfDistance(RealVector r8) throws DimensionMismatchException {
        checkVectorDimensions(r8);
        Iterator<Entry> r7 = iterator();
        double r0 = 0.0d;
    L4:
        if (r7.hasNext() == false) goto L6;
        Entry r2 = r7.next();
        r0 = FastMath.max(FastMath.abs(r2.getValue() - r8.getEntry(r2.getIndex())), r0);
        goto L4
    L6:
        return r0;
    }

    public int getMinIndex() {
        Iterator<Entry> r6 = iterator();
        int r0 = -1;
        double r1 = Double.POSITIVE_INFINITY;
    L4:
        if (r6.hasNext() == false) goto L8;
        Entry r3 = r6.next();
        if (r3.getValue() > r1) goto L4;
        r0 = r3.getIndex();
        r1 = r3.getValue();
        goto L4
    L8:
        return r0;
    }

    public double getMinValue() {
        int r0 = getMinIndex();
        if (r0 >= 0) goto L6;
        return Double.NaN;
    L6:
        return getEntry(r0);
    }

    public int getMaxIndex() {
        Iterator<Entry> r6 = iterator();
        int r0 = -1;
        double r1 = Double.NEGATIVE_INFINITY;
    L4:
        if (r6.hasNext() == false) goto L8;
        Entry r3 = r6.next();
        if (r3.getValue() < r1) goto L4;
        r0 = r3.getIndex();
        r1 = r3.getValue();
        goto L4
    L8:
        return r0;
    }

    public double getMaxValue() {
        int r0 = getMaxIndex();
        if (r0 >= 0) goto L6;
        return Double.NaN;
    L6:
        return getEntry(r0);
    }

    public RealVector mapMultiply(double r1) {
        return copy().mapMultiplyToSelf(r1);
    }

    public RealVector mapMultiplyToSelf(double r2) {
        return mapToSelf(FunctionUtils.fix2ndArgument(new Multiply(), r2));
    }

    public RealVector mapSubtract(double r1) {
        return copy().mapSubtractToSelf(r1);
    }

    public RealVector mapSubtractToSelf(double r1) {
        return mapAddToSelf(-r1);
    }

    public RealVector mapDivide(double r1) {
        return copy().mapDivideToSelf(r1);
    }

    public RealVector mapDivideToSelf(double r2) {
        return mapToSelf(FunctionUtils.fix2ndArgument(new Divide(), r2));
    }

    public RealMatrix outerProduct(RealVector r11) {
        int r0 = getDimension();
        int r1 = r11.getDimension();
        if ((r11 instanceof SparseRealVector) == false) goto L5;
    L8:
        RealMatrix r2 = new OpenMapRealMatrix(r0, r1);
    L9:
        int r4 = 0;
    L10:
        if (r4 >= r0) goto L15;
        int r5 = 0;
    L12:
        if (r5 >= r1) goto L14;
        r2.setEntry(r4, r5, getEntry(r4) * r11.getEntry(r5));
        r5 = r5 + 1;
        goto L12
    L14:
        r4 = r4 + 1;
        goto L10
    L15:
        return r2;
    L5:
        if ((this instanceof SparseRealVector) == true) goto L8;
        r2 = new Array2DRowRealMatrix(r0, r1);
        goto L9
    }

    public RealVector projection(RealVector r5) throws DimensionMismatchException, MathArithmeticException {
        if (r5.dotProduct(r5) == 0.0d) goto L7;
        return r5.mapMultiply(dotProduct(r5) / r5.dotProduct(r5));
    L7:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    public void set(double r2) {
        Iterator<Entry> r1 = iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().setValue(r2);
        goto L4
    }

    public double[] toArray() {
        int r0 = getDimension();
        double[] r1 = new double[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = getEntry(r2);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public RealVector unitVector() throws MathArithmeticException {
        double r0 = getNorm();
        if (r0 == 0.0d) goto L7;
        return mapDivide(r0);
    L7:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    public void unitize() throws MathArithmeticException {
        if (getNorm() == 0.0d) goto L7;
        mapDivideToSelf(getNorm());
        return;
    L7:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    public Iterator<Entry> sparseIterator() {
        return new SparseEntryIterator(this);
    }

    public Iterator<Entry> iterator() {
        final int r0 = getDimension();
        return new AnonymousClass1(this, r0);
    }

    public RealVector map(UnivariateFunction r1) {
        return copy().mapToSelf(r1);
    }

    public RealVector mapToSelf(UnivariateFunction r5) {
        Iterator<Entry> r0 = iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Entry r1 = r0.next();
        r1.setValue(r5.value(r1.getValue()));
        goto L4
    L6:
        return this;
    }

    public RealVector combine(double r7, double r9, RealVector r11) throws DimensionMismatchException {
        return copy().combineToSelf(r7, r9, r11);
    }

    public RealVector combineToSelf(double r6, double r8, RealVector r10) throws DimensionMismatchException {
        checkVectorDimensions(r10);
        int r0 = 0;
    L4:
        if (r0 >= getDimension()) goto L6;
        double r1 = getEntry(r0);
        setEntry(r0, (r1 * r6) + (r10.getEntry(r0) * r8));
        r0 = r0 + 1;
        goto L4
    L6:
        return this;
    }

    public double walkInDefaultOrder(RealVectorPreservingVisitor r6) {
        int r0 = getDimension();
        int r2 = 0;
        r6.start(r0, 0, r0 - 1);
    L3:
        if (r2 >= r0) goto L6;
        r6.visit(r2, getEntry(r2));
        r2 = r2 + 1;
        goto L3
    L6:
        return r6.end();
    }

    public double walkInDefaultOrder(RealVectorPreservingVisitor r3, int r4, int r5) throws NumberIsTooSmallException, OutOfRangeException {
        checkIndices(r4, r5);
        r3.start(getDimension(), r4, r5);
    L3:
        if (r4 > r5) goto L6;
        r3.visit(r4, getEntry(r4));
        r4 = r4 + 1;
        goto L3
    L6:
        return r3.end();
    }

    public double walkInOptimizedOrder(RealVectorPreservingVisitor r1) {
        return walkInDefaultOrder(r1);
    }

    public double walkInOptimizedOrder(RealVectorPreservingVisitor r1, int r2, int r3) throws NumberIsTooSmallException, OutOfRangeException {
        return walkInDefaultOrder(r1, r2, r3);
    }

    public double walkInDefaultOrder(RealVectorChangingVisitor r6) {
        int r0 = getDimension();
        int r2 = 0;
        r6.start(r0, 0, r0 - 1);
    L3:
        if (r2 >= r0) goto L6;
        setEntry(r2, r6.visit(r2, getEntry(r2)));
        r2 = r2 + 1;
        goto L3
    L6:
        return r6.end();
    }

    public double walkInDefaultOrder(RealVectorChangingVisitor r3, int r4, int r5) throws NumberIsTooSmallException, OutOfRangeException {
        checkIndices(r4, r5);
        r3.start(getDimension(), r4, r5);
    L3:
        if (r4 > r5) goto L6;
        setEntry(r4, r3.visit(r4, getEntry(r4)));
        r4 = r4 + 1;
        goto L3
    L6:
        return r3.end();
    }

    public double walkInOptimizedOrder(RealVectorChangingVisitor r1) {
        return walkInDefaultOrder(r1);
    }

    public double walkInOptimizedOrder(RealVectorChangingVisitor r1, int r2, int r3) throws NumberIsTooSmallException, OutOfRangeException {
        return walkInDefaultOrder(r1, r2, r3);
    }

    public boolean equals(Object r1) throws MathUnsupportedOperationException {
        throw new MathUnsupportedOperationException();
    }

    public int hashCode() throws MathUnsupportedOperationException {
        throw new MathUnsupportedOperationException();
    }

    public static RealVector unmodifiableRealVector(final RealVector r1) {
        return new AnonymousClass2(r1);
    }
}
