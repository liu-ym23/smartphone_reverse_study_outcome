package org.apache.commons.math3.linear;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.util.OpenIntToFieldHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class SparseFieldMatrix<T extends FieldElement<T>> extends AbstractFieldMatrix<T> {
    private final int columns;
    private final OpenIntToFieldHashMap<T> entries;
    private final int rows;

    public SparseFieldMatrix(Field<T> r2) {
        super(r2);
        this.rows = 0;
        this.columns = 0;
        this.entries = new OpenIntToFieldHashMap(r2);
    }

    public SparseFieldMatrix(Field<T> r1, int r2, int r3) {
        super(r1, r2, r3);
        this.rows = r2;
        this.columns = r3;
        this.entries = new OpenIntToFieldHashMap(r1);
    }

    public SparseFieldMatrix(SparseFieldMatrix<T> r4) {
        super(r4.getField(), r4.getRowDimension(), r4.getColumnDimension());
        this.rows = r4.getRowDimension();
        this.columns = r4.getColumnDimension();
        this.entries = new OpenIntToFieldHashMap(r4.entries);
    }

    public SparseFieldMatrix(FieldMatrix<T> r5) {
        super(r5.getField(), r5.getRowDimension(), r5.getColumnDimension());
        this.rows = r5.getRowDimension();
        this.columns = r5.getColumnDimension();
        this.entries = new OpenIntToFieldHashMap(getField());
        int r1 = 0;
    L4:
        if (r1 >= this.rows) goto L10;
        int r2 = 0;
    L7:
        if (r2 >= this.columns) goto L9;
        setEntry(r1, r2, r5.getEntry(r1, r2));
        r2 = r2 + 1;
        goto L7
    L9:
        r1 = r1 + 1;
        goto L4
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void addToEntry(int r1, int r2, T r3) {
        checkRowIndex(r1);
        checkColumnIndex(r2);
        int r4 = computeKey(r1, r2);
        FieldElement r5 = (FieldElement) this.entries.get(r4).add(r3);
        if (getField().getZero().equals(r5) == false) goto L5;
        this.entries.remove(r4);
        return;
    L5:
        this.entries.put(r4, r5);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> copy() {
        return new SparseFieldMatrix(this);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> createMatrix(int r2, int r3) {
        return new SparseFieldMatrix(getField(), r2, r3);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.AnyMatrix
    public int getColumnDimension() {
        return this.columns;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T getEntry(int r2, int r3) {
        checkRowIndex(r2);
        checkColumnIndex(r3);
        return (T) this.entries.get(computeKey(r2, r3));
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.AnyMatrix
    public int getRowDimension() {
        return this.rows;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void multiplyEntry(int r1, int r2, T r3) {
        checkRowIndex(r1);
        checkColumnIndex(r2);
        int r4 = computeKey(r1, r2);
        FieldElement r5 = (FieldElement) this.entries.get(r4).multiply(r3);
        if (getField().getZero().equals(r5) == false) goto L5;
        this.entries.remove(r4);
        return;
    L5:
        this.entries.put(r4, r5);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void setEntry(int r2, int r3, T r4) {
        checkRowIndex(r2);
        checkColumnIndex(r3);
        if (getField().getZero().equals(r4) == false) goto L5;
        this.entries.remove(computeKey(r2, r3));
        return;
    L5:
        this.entries.put(computeKey(r2, r3), r4);
    }

    private int computeKey(int r1, int r2) {
        return (r1 * this.columns) + r2;
    }
}
