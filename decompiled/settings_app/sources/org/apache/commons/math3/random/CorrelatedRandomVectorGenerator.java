package org.apache.commons.math3.random;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RectangularCholeskyDecomposition;

/* JADX INFO: loaded from: classes6.dex */
public class CorrelatedRandomVectorGenerator implements RandomVectorGenerator {
    private final NormalizedRandomGenerator generator;
    private final double[] mean;
    private final double[] normalized;
    private final RealMatrix root;

    public CorrelatedRandomVectorGenerator(double[] r3, RealMatrix r4, double r5, NormalizedRandomGenerator r7) {
        int r0 = r4.getRowDimension();
        if (r3.length != r0) goto L7;
        this.mean = (double[]) r3.clone();
        RectangularCholeskyDecomposition r6 = new RectangularCholeskyDecomposition(r4, r5);
        this.root = r6.getRootMatrix();
        this.generator = r7;
        this.normalized = new double[r6.getRank()];
        return;
    L7:
        throw new DimensionMismatchException(r3.length, r0);
    }

    public CorrelatedRandomVectorGenerator(RealMatrix r6, double r7, NormalizedRandomGenerator r9) {
        int r0 = r6.getRowDimension();
        this.mean = new double[r0];
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mean[r1] = 0.0d;
        r1 = r1 + 1;
        goto L3
    L5:
        RectangularCholeskyDecomposition r2 = new RectangularCholeskyDecomposition(r6, r7);
        this.root = r2.getRootMatrix();
        this.generator = r9;
        this.normalized = new double[r2.getRank()];
    }

    public NormalizedRandomGenerator getGenerator() {
        return this.generator;
    }

    public int getRank() {
        return this.normalized.length;
    }

    public RealMatrix getRootMatrix() {
        return this.root;
    }

    @Override // org.apache.commons.math3.random.RandomVectorGenerator
    public double[] nextVector() {
        int r1 = 0;
    L3:
        double[] r2 = this.normalized;
        if (r1 >= r2.length) goto L6;
        r2[r1] = this.generator.nextNormalizedDouble();
        r1 = r1 + 1;
        goto L3
    L6:
        int r3 = this.mean.length;
        double[] r4 = new double[r3];
        int r5 = 0;
    L7:
        if (r5 >= r3) goto L13;
        r4[r5] = this.mean[r5];
        int r6 = 0;
    L10:
        if (r6 >= this.root.getColumnDimension()) goto L12;
        r4[r5] = r4[r5] + (this.root.getEntry(r5, r6) * this.normalized[r6]);
        r6 = r6 + 1;
        goto L10
    L12:
        r5 = r5 + 1;
        goto L7
    L13:
        return r4;
    }
}
