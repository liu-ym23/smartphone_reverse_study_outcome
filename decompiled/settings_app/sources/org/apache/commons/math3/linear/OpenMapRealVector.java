package org.apache.commons.math3.linear;

import java.io.Serializable;
import java.util.Iterator;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.OpenIntToDoubleHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class OpenMapRealVector extends SparseRealVector implements Serializable {
    public static final double DEFAULT_ZERO_TOLERANCE = 1.0E-12d;
    private static final long serialVersionUID = 8772222695580707260L;
    private final OpenIntToDoubleHashMap entries;
    private final double epsilon;
    private final int virtualSize;

    protected class OpenMapEntry extends RealVector.Entry {
        private final OpenIntToDoubleHashMap.Iterator iter;
        final /* synthetic */ OpenMapRealVector this$0;

        protected OpenMapEntry(OpenMapRealVector r1, OpenIntToDoubleHashMap.Iterator r2) {
            this.this$0 = r1;
            super(r1);
            this.iter = r2;
        }

        @Override // org.apache.commons.math3.linear.RealVector.Entry
        public double getValue() {
            return this.iter.value();
        }

        @Override // org.apache.commons.math3.linear.RealVector.Entry
        public void setValue(double r2) {
            OpenMapRealVector.access$000(this.this$0).put(this.iter.key(), r2);
        }

        @Override // org.apache.commons.math3.linear.RealVector.Entry
        public int getIndex() {
            return this.iter.key();
        }
    }

    protected class OpenMapSparseIterator implements Iterator<RealVector.Entry> {
        private final RealVector.Entry current;
        private final OpenIntToDoubleHashMap.Iterator iter;
        final /* synthetic */ OpenMapRealVector this$0;

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ RealVector.Entry next() {
            return next2();
        }

        protected OpenMapSparseIterator(OpenMapRealVector r3) {
            this.this$0 = r3;
            OpenIntToDoubleHashMap.Iterator r0 = OpenMapRealVector.access$000(r3).iterator();
            this.iter = r0;
            this.current = new OpenMapEntry(r3, r0);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public RealVector.Entry next2() {
            this.iter.advance();
            return this.current;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Not supported");
        }
    }

    static /* synthetic */ OpenIntToDoubleHashMap access$000(OpenMapRealVector r0) {
        return r0.entries;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector append(double r1) {
        return append(r1);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector append(RealVector r1) {
        return append(r1);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector copy() {
        return copy();
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector ebeDivide(RealVector r1) throws DimensionMismatchException {
        return ebeDivide(r1);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector ebeMultiply(RealVector r1) throws DimensionMismatchException {
        return ebeMultiply(r1);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector getSubVector(int r1, int r2) throws NotPositiveException, OutOfRangeException {
        return getSubVector(r1, r2);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector mapAdd(double r1) {
        return mapAdd(r1);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector mapAddToSelf(double r1) {
        return mapAddToSelf(r1);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector unitVector() throws MathArithmeticException {
        return unitVector();
    }

    public OpenMapRealVector() {
        this(0, 1.0E-12d);
    }

    public OpenMapRealVector(int r3) {
        this(r3, 1.0E-12d);
    }

    public OpenMapRealVector(int r3, double r4) {
        this.virtualSize = r3;
        this.entries = new OpenIntToDoubleHashMap(0.0d);
        this.epsilon = r4;
    }

    protected OpenMapRealVector(OpenMapRealVector r2, int r3) {
        this.virtualSize = r2.getDimension() + r3;
        this.entries = new OpenIntToDoubleHashMap(r2.entries);
        this.epsilon = r2.epsilon;
    }

    public OpenMapRealVector(int r3, int r4) {
        this(r3, r4, 1.0E-12d);
    }

    public OpenMapRealVector(int r3, int r4, double r5) {
        this.virtualSize = r3;
        this.entries = new OpenIntToDoubleHashMap(r4, 0.0d);
        this.epsilon = r5;
    }

    public OpenMapRealVector(double[] r3) {
        this(r3, 1.0E-12d);
    }

    public OpenMapRealVector(double[] r4, double r5) {
        this.virtualSize = r4.length;
        this.entries = new OpenIntToDoubleHashMap(0.0d);
        this.epsilon = r5;
        int r6 = 0;
    L4:
        if (r6 >= r4.length) goto L9;
        double r0 = r4[r6];
        if (isDefaultValue(r0) == true) goto L8;
        this.entries.put(r6, r0);
    L8:
        r6 = r6 + 1;
        goto L4
    }

    public OpenMapRealVector(Double[] r3) {
        this(r3, 1.0E-12d);
    }

    public OpenMapRealVector(Double[] r4, double r5) {
        this.virtualSize = r4.length;
        this.entries = new OpenIntToDoubleHashMap(0.0d);
        this.epsilon = r5;
        int r6 = 0;
    L4:
        if (r6 >= r4.length) goto L9;
        double r0 = r4[r6].doubleValue();
        if (isDefaultValue(r0) == true) goto L8;
        this.entries.put(r6, r0);
    L8:
        r6 = r6 + 1;
        goto L4
    }

    public OpenMapRealVector(OpenMapRealVector r3) {
        this.virtualSize = r3.getDimension();
        this.entries = new OpenIntToDoubleHashMap(r3.getEntries());
        this.epsilon = r3.epsilon;
    }

    public OpenMapRealVector(RealVector r5) {
        this.virtualSize = r5.getDimension();
        this.entries = new OpenIntToDoubleHashMap(0.0d);
        this.epsilon = 1.0E-12d;
        int r0 = 0;
    L4:
        if (r0 >= this.virtualSize) goto L9;
        double r1 = r5.getEntry(r0);
        if (isDefaultValue(r1) == true) goto L8;
        this.entries.put(r0, r1);
    L8:
        r0 = r0 + 1;
        goto L4
    }

    private OpenIntToDoubleHashMap getEntries() {
        return this.entries;
    }

    protected boolean isDefaultValue(double r3) {
        if (FastMath.abs(r3) >= this.epsilon) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public RealVector add(RealVector r2) throws DimensionMismatchException {
        checkVectorDimensions(r2.getDimension());
        if ((r2 instanceof OpenMapRealVector) == false) goto L7;
        return add((OpenMapRealVector) r2);
    L7:
        return super.add(r2);
    }

    public OpenMapRealVector add(OpenMapRealVector r8) throws DimensionMismatchException {
        checkVectorDimensions(r8.getDimension());
        if (this.entries.size() <= r8.entries.size()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        OpenMapRealVector r1 = copy();
    L9:
        if (r0 == false) goto L11;
        OpenIntToDoubleHashMap r2 = r8.entries;
    L12:
        OpenIntToDoubleHashMap.Iterator r3 = r2.iterator();
        if (r0 == false) goto L15;
        OpenIntToDoubleHashMap r7 = this.entries;
    L17:
        if (r3.hasNext() == false) goto L22;
        r3.advance();
        int r9 = r3.key();
        if (r7.containsKey(r9) == true) goto L20;
        r1.setEntry(r9, r3.value());
        goto L17
    L20:
        r1.setEntry(r9, r7.get(r9) + r3.value());
        goto L17
    L22:
        return r1;
    L15:
        r7 = r8.entries;
        goto L17
    L11:
        r2 = this.entries;
        goto L12
    L8:
        r1 = r8.copy();
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    public OpenMapRealVector append(OpenMapRealVector r5) {
        OpenMapRealVector r0 = new OpenMapRealVector(this, r5.getDimension());
        OpenIntToDoubleHashMap.Iterator r6 = r5.entries.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r6.advance();
        r0.setEntry(r6.key() + this.virtualSize, r6.value());
        goto L4
    L6:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public OpenMapRealVector append(RealVector r6) {
        if ((r6 instanceof OpenMapRealVector) == true) goto L5;
        OpenMapRealVector r0 = new OpenMapRealVector(this, r6.getDimension());
        int r1 = 0;
    L8:
        if (r1 >= r6.getDimension()) goto L10;
        r0.setEntry(this.virtualSize + r1, r6.getEntry(r1));
        r1 = r1 + 1;
        goto L8
    L10:
        return r0;
    L5:
        return append((OpenMapRealVector) r6);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public OpenMapRealVector append(double r3) {
        OpenMapRealVector r0 = new OpenMapRealVector(this, 1);
        r0.setEntry(this.virtualSize, r3);
        return r0;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public OpenMapRealVector copy() {
        return new OpenMapRealVector(this);
    }

    @Deprecated
    public double dotProduct(OpenMapRealVector r1) throws DimensionMismatchException {
        return dotProduct(r1);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public OpenMapRealVector ebeDivide(RealVector r8) throws DimensionMismatchException {
        checkVectorDimensions(r8.getDimension());
        OpenMapRealVector r0 = new OpenMapRealVector(this);
        int r1 = getDimension();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.setEntry(r2, getEntry(r2) / r8.getEntry(r2));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public OpenMapRealVector ebeMultiply(RealVector r7) throws DimensionMismatchException {
        checkVectorDimensions(r7.getDimension());
        OpenMapRealVector r0 = new OpenMapRealVector(this);
        OpenIntToDoubleHashMap.Iterator r6 = this.entries.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r6.advance();
        r0.setEntry(r6.key(), r6.value() * r7.getEntry(r6.key()));
        goto L4
    L6:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public OpenMapRealVector getSubVector(int r5, int r6) throws NotPositiveException, OutOfRangeException {
        checkIndex(r5);
        if (r6 < 0) goto L13;
        int r0 = r5 + r6;
        checkIndex(r0 - 1);
        OpenMapRealVector r1 = new OpenMapRealVector(r6);
        OpenIntToDoubleHashMap.Iterator r4 = this.entries.iterator();
    L6:
        if (r4.hasNext() == false) goto L11;
        r4.advance();
        int r7 = r4.key();
        if (r7 < r5) goto L6;
        if (r7 >= r0) goto L6;
        r1.setEntry(r7 - r5, r4.value());
        goto L6
    L11:
        return r1;
    L13:
        throw new NotPositiveException(LocalizedFormats.NUMBER_OF_ELEMENTS_SHOULD_BE_POSITIVE, Integer.valueOf(r6));
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public int getDimension() {
        return this.virtualSize;
    }

    public double getDistance(OpenMapRealVector r9) throws DimensionMismatchException {
        checkVectorDimensions(r9.getDimension());
        OpenIntToDoubleHashMap.Iterator r0 = this.entries.iterator();
        double r1 = 0.0d;
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.advance();
        int r3 = r0.key();
        double r4 = r0.value() - r9.getEntry(r3);
        r1 = r1 + (r4 * r4);
        goto L4
    L6:
        OpenIntToDoubleHashMap.Iterator r10 = r9.getEntries().iterator();
    L8:
        if (r10.hasNext() == false) goto L13;
        r10.advance();
        int r2 = r10.key();
        if (this.entries.containsKey(r2) == true) goto L8;
        double r5 = r10.value();
        r1 = r1 + (r5 * r5);
        goto L8
    L13:
        return FastMath.sqrt(r1);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double getDistance(RealVector r2) throws DimensionMismatchException {
        checkVectorDimensions(r2.getDimension());
        if ((r2 instanceof OpenMapRealVector) == false) goto L7;
        return getDistance((OpenMapRealVector) r2);
    L7:
        return super.getDistance(r2);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double getEntry(int r1) throws OutOfRangeException {
        checkIndex(r1);
        return this.entries.get(r1);
    }

    public double getL1Distance(OpenMapRealVector r8) throws DimensionMismatchException {
        checkVectorDimensions(r8.getDimension());
        OpenIntToDoubleHashMap.Iterator r0 = this.entries.iterator();
        double r1 = 0.0d;
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.advance();
        r1 = r1 + FastMath.abs(r0.value() - r8.getEntry(r0.key()));
        goto L4
    L6:
        OpenIntToDoubleHashMap.Iterator r9 = r8.getEntries().iterator();
    L8:
        if (r9.hasNext() == false) goto L12;
        r9.advance();
        int r2 = r9.key();
        if (this.entries.containsKey(r2) == true) goto L8;
        r1 = r1 + FastMath.abs(FastMath.abs(r9.value()));
        goto L8
    L12:
        return r1;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double getL1Distance(RealVector r2) throws DimensionMismatchException {
        checkVectorDimensions(r2.getDimension());
        if ((r2 instanceof OpenMapRealVector) == false) goto L7;
        return getL1Distance((OpenMapRealVector) r2);
    L7:
        return super.getL1Distance(r2);
    }

    private double getLInfDistance(OpenMapRealVector r8) throws DimensionMismatchException {
        checkVectorDimensions(r8.getDimension());
        OpenIntToDoubleHashMap.Iterator r0 = this.entries.iterator();
        double r1 = 0.0d;
    L4:
        if (r0.hasNext() == false) goto L8;
        r0.advance();
        double r3 = FastMath.abs(r0.value() - r8.getEntry(r0.key()));
        if (r3 <= r1) goto L4;
        r1 = r3;
        goto L4
    L8:
        OpenIntToDoubleHashMap.Iterator r9 = r8.getEntries().iterator();
    L10:
        if (r9.hasNext() == false) goto L16;
        r9.advance();
        int r2 = r9.key();
        if (this.entries.containsKey(r2) == true) goto L10;
        if (r9.value() <= r1) goto L10;
        r1 = r9.value();
        goto L10
    L16:
        return r1;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double getLInfDistance(RealVector r2) throws DimensionMismatchException {
        checkVectorDimensions(r2.getDimension());
        if ((r2 instanceof OpenMapRealVector) == false) goto L7;
        return getLInfDistance((OpenMapRealVector) r2);
    L7:
        return super.getLInfDistance(r2);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public boolean isInfinite() {
        OpenIntToDoubleHashMap.Iterator r5 = this.entries.iterator();
        boolean r1 = false;
    L4:
        if (r5.hasNext() == false) goto L11;
        r5.advance();
        double r2 = r5.value();
        if (Double.isNaN(r2) == true) goto L7;
        if (Double.isInfinite(r2) == false) goto L4;
        r1 = true;
        goto L4
    L7:
        return false;
    L11:
        return r1;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public boolean isNaN() {
        OpenIntToDoubleHashMap.Iterator r2 = this.entries.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        r2.advance();
        if (Double.isNaN(r2.value()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public OpenMapRealVector mapAdd(double r1) {
        return copy().mapAddToSelf(r1);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public OpenMapRealVector mapAddToSelf(double r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.virtualSize) goto L6;
        setEntry(r0, getEntry(r0) + r4);
        r0 = r0 + 1;
        goto L4
    L6:
        return this;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public void setEntry(int r2, double r3) throws OutOfRangeException {
        checkIndex(r2);
        if (isDefaultValue(r3) == true) goto L6;
        this.entries.put(r2, r3);
        return;
    L6:
        if (this.entries.containsKey(r2) == false) goto L10;
        this.entries.remove(r2);
        return;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public void setSubVector(int r5, RealVector r6) throws OutOfRangeException {
        checkIndex(r5);
        checkIndex((r6.getDimension() + r5) - 1);
        int r0 = 0;
    L4:
        if (r0 >= r6.getDimension()) goto L6;
        setEntry(r0 + r5, r6.getEntry(r0));
        r0 = r0 + 1;
        goto L4
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public void set(double r3) {
        int r0 = 0;
    L4:
        if (r0 >= this.virtualSize) goto L6;
        setEntry(r0, r3);
        r0 = r0 + 1;
        goto L4
    }

    public OpenMapRealVector subtract(OpenMapRealVector r7) throws DimensionMismatchException {
        checkVectorDimensions(r7.getDimension());
        OpenMapRealVector r0 = copy();
        OpenIntToDoubleHashMap.Iterator r8 = r7.getEntries().iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        r8.advance();
        int r1 = r8.key();
        if (this.entries.containsKey(r1) == true) goto L7;
        r0.setEntry(r1, -r8.value());
        goto L4
    L7:
        r0.setEntry(r1, this.entries.get(r1) - r8.value());
        goto L4
    L9:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public RealVector subtract(RealVector r2) throws DimensionMismatchException {
        checkVectorDimensions(r2.getDimension());
        if ((r2 instanceof OpenMapRealVector) == false) goto L7;
        return subtract((OpenMapRealVector) r2);
    L7:
        return super.subtract(r2);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public OpenMapRealVector unitVector() throws MathArithmeticException {
        OpenMapRealVector r0 = copy();
        r0.unitize();
        return r0;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public void unitize() throws MathArithmeticException {
        double r0 = getNorm();
        if (isDefaultValue(r0) == true) goto L10;
        OpenIntToDoubleHashMap.Iterator r2 = this.entries.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r2.advance();
        this.entries.put(r2.key(), r2.value() / r0);
        goto L6
    L8:
        return;
    L10:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double[] toArray() {
        double[] r0 = new double[this.virtualSize];
        OpenIntToDoubleHashMap.Iterator r4 = this.entries.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r4.advance();
        r0[r4.key()] = r4.value();
        goto L4
    L6:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public int hashCode() {
        long r0 = Double.doubleToLongBits(this.epsilon);
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) + 31) * 31) + this.virtualSize;
        OpenIntToDoubleHashMap.Iterator r7 = this.entries.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r7.advance();
        long r3 = Double.doubleToLongBits(r7.value());
        r1 = (r1 * 31) + ((int) (r3 ^ (r3 >> 32)));
        goto L4
    L6:
        return r1;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof OpenMapRealVector) == true) goto L8;
        return false;
    L8:
        OpenMapRealVector r9 = (OpenMapRealVector) r8;
        if (this.virtualSize == r9.virtualSize) goto L12;
        return false;
    L12:
        if (Double.doubleToLongBits(this.epsilon) == Double.doubleToLongBits(r9.epsilon)) goto L14;
        return false;
    L14:
        OpenIntToDoubleHashMap.Iterator r1 = this.entries.iterator();
    L16:
        if (r1.hasNext() == false) goto L20;
        r1.advance();
        if (Double.doubleToLongBits(r9.getEntry(r1.key())) == Double.doubleToLongBits(r1.value())) goto L16;
        return false;
    L20:
        OpenIntToDoubleHashMap.Iterator r10 = r9.getEntries().iterator();
    L22:
        if (r10.hasNext() == false) goto L26;
        r10.advance();
        if (Double.doubleToLongBits(r10.value()) == Double.doubleToLongBits(getEntry(r10.key()))) goto L22;
        return false;
    L26:
        return true;
    }

    public double getSparsity() {
        return ((double) this.entries.size()) / ((double) getDimension());
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public Iterator<RealVector.Entry> sparseIterator() {
        return new OpenMapSparseIterator(this);
    }
}
