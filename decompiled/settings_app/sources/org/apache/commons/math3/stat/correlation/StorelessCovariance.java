package org.apache.commons.math3.stat.correlation;

import java.lang.reflect.Array;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

/* JADX INFO: loaded from: classes6.dex */
public class StorelessCovariance extends Covariance {
    private StorelessBivariateCovariance[] covMatrix;
    private int dimension;

    public StorelessCovariance(int r2) {
        this(r2, true);
    }

    public StorelessCovariance(int r2, boolean r3) {
        this.dimension = r2;
        this.covMatrix = new StorelessBivariateCovariance[(r2 * (r2 + 1)) / 2];
        initializeMatrix(r3);
    }

    private void initializeMatrix(boolean r5) {
        int r1 = 0;
    L4:
        if (r1 >= this.dimension) goto L10;
        int r2 = 0;
    L7:
        if (r2 >= this.dimension) goto L9;
        setElement(r1, r2, new StorelessBivariateCovariance(r5));
        r2 = r2 + 1;
        goto L7
    L9:
        r1 = r1 + 1;
        goto L4
    }

    private int indexOf(int r1, int r2) {
        if (r2 >= r1) goto L5;
        return ((r1 * (r1 + 1)) / 2) + r2;
    L5:
        return r1 + ((r2 * (r2 + 1)) / 2);
    }

    private StorelessBivariateCovariance getElement(int r2, int r3) {
        return this.covMatrix[indexOf(r2, r3)];
    }

    private void setElement(int r2, int r3, StorelessBivariateCovariance r4) {
        this.covMatrix[indexOf(r2, r3)] = r4;
    }

    public double getCovariance(int r1, int r2) throws NumberIsTooSmallException {
        return getElement(r1, r2).getResult();
    }

    public void increment(double[] r9) throws DimensionMismatchException {
        int r0 = r9.length;
        if (r0 != this.dimension) goto L12;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L10;
        int r2 = r1;
    L7:
        if (r2 >= r0) goto L9;
        getElement(r1, r2).increment(r9[r1], r9[r2]);
        r2 = r2 + 1;
        goto L7
    L9:
        r1 = r1 + 1;
        goto L5
    L10:
        return;
    L12:
        throw new DimensionMismatchException(r0, this.dimension);
    }

    public void append(StorelessCovariance r5) throws DimensionMismatchException {
        if (r5.dimension != this.dimension) goto L14;
        int r0 = 0;
    L6:
        if (r0 >= this.dimension) goto L12;
        int r1 = r0;
    L9:
        if (r1 >= this.dimension) goto L11;
        getElement(r0, r1).append(r5.getElement(r0, r1));
        r1 = r1 + 1;
        goto L9
    L11:
        r0 = r0 + 1;
        goto L6
    L12:
        return;
    L14:
        throw new DimensionMismatchException(r5.dimension, this.dimension);
    }

    @Override // org.apache.commons.math3.stat.correlation.Covariance
    public RealMatrix getCovarianceMatrix() throws NumberIsTooSmallException {
        return MatrixUtils.createRealMatrix(getData());
    }

    public double[][] getData() throws NumberIsTooSmallException {
        int r0 = this.dimension;
        double[][] r1 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r0, r0});
        int r2 = 0;
    L4:
        if (r2 >= this.dimension) goto L10;
        int r3 = 0;
    L7:
        if (r3 >= this.dimension) goto L9;
        r1[r2][r3] = getElement(r2, r3).getResult();
        r3 = r3 + 1;
        goto L7
    L9:
        r2 = r2 + 1;
        goto L4
    L10:
        return r1;
    }

    @Override // org.apache.commons.math3.stat.correlation.Covariance
    public int getN() throws MathUnsupportedOperationException {
        throw new MathUnsupportedOperationException();
    }
}
