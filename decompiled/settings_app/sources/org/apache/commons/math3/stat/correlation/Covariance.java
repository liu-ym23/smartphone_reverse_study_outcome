package org.apache.commons.math3.stat.correlation;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.Variance;

/* JADX INFO: loaded from: classes6.dex */
public class Covariance {
    private final RealMatrix covarianceMatrix;
    private final int n;

    public Covariance() {
        this.covarianceMatrix = null;
        this.n = 0;
    }

    public Covariance(double[][] r2, boolean r3) throws MathIllegalArgumentException, NotStrictlyPositiveException {
        this(new BlockRealMatrix(r2), r3);
    }

    public Covariance(double[][] r2) throws MathIllegalArgumentException, NotStrictlyPositiveException {
        this(r2, true);
    }

    public Covariance(RealMatrix r2, boolean r3) throws MathIllegalArgumentException {
        checkSufficientData(r2);
        this.n = r2.getRowDimension();
        this.covarianceMatrix = computeCovarianceMatrix(r2, r3);
    }

    public Covariance(RealMatrix r2) throws MathIllegalArgumentException {
        this(r2, true);
    }

    public RealMatrix getCovarianceMatrix() {
        return this.covarianceMatrix;
    }

    public int getN() {
        return this.n;
    }

    protected RealMatrix computeCovarianceMatrix(RealMatrix r9, boolean r10) throws MathIllegalArgumentException {
        int r0 = r9.getColumnDimension();
        Variance r1 = new Variance(r10);
        BlockRealMatrix r2 = new BlockRealMatrix(r0, r0);
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L8;
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L7;
        double r6 = covariance(r9.getColumn(r4), r9.getColumn(r5), r10);
        r2.setEntry(r4, r5, r6);
        r2.setEntry(r5, r4, r6);
        r5 = r5 + 1;
        goto L5
    L7:
        r2.setEntry(r4, r4, r1.evaluate(r9.getColumn(r4)));
        r4 = r4 + 1;
        goto L3
    L8:
        return r2;
    }

    protected RealMatrix computeCovarianceMatrix(RealMatrix r2) throws MathIllegalArgumentException {
        return computeCovarianceMatrix(r2, true);
    }

    protected RealMatrix computeCovarianceMatrix(double[][] r2, boolean r3) throws MathIllegalArgumentException, NotStrictlyPositiveException {
        return computeCovarianceMatrix(new BlockRealMatrix(r2), r3);
    }

    protected RealMatrix computeCovarianceMatrix(double[][] r2) throws MathIllegalArgumentException, NotStrictlyPositiveException {
        return computeCovarianceMatrix(r2, true);
    }

    public double covariance(double[] r18, double[] r19, boolean r20) throws MathIllegalArgumentException {
        Mean r2 = new Mean();
        int r3 = r18.length;
        int r5 = 0;
        if (r3 != r19.length) goto L14;
        if (r3 < 2) goto L12;
        double r7 = r2.evaluate(r18);
        double r9 = r2.evaluate(r19);
        double r11 = 0.0d;
    L6:
        if (r5 >= r3) goto L8;
        double r13 = ((r18[r5] - r7) * (r19[r5] - r9)) - r11;
        r5 = r5 + 1;
        r11 = r11 + (r13 / ((double) r5));
        r7 = r7;
        goto L6
    L8:
        if (r20 == true) goto L10;
        return r11;
    L10:
        return r11 * (((double) r3) / ((double) (r3 - 1)));
    L12:
        throw new MathIllegalArgumentException(LocalizedFormats.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE, new Object[]{Integer.valueOf(r3), 2});
    L14:
        throw new MathIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(r3), Integer.valueOf(r19.length)});
    }

    public double covariance(double[] r2, double[] r3) throws MathIllegalArgumentException {
        return covariance(r2, r3, true);
    }

    private void checkSufficientData(RealMatrix r6) throws MathIllegalArgumentException {
        int r5 = r6.getRowDimension();
        int r7 = r6.getColumnDimension();
        if (r5 < 2) goto L7;
        if (r7 < 1) goto L7;
        return;
    L7:
        throw new MathIllegalArgumentException(LocalizedFormats.INSUFFICIENT_ROWS_AND_COLUMNS, new Object[]{Integer.valueOf(r5), Integer.valueOf(r7)});
    }
}
