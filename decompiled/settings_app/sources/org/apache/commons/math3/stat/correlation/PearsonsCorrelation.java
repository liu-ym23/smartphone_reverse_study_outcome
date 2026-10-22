package org.apache.commons.math3.stat.correlation;

import java.lang.reflect.Array;
import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class PearsonsCorrelation {
    private final RealMatrix correlationMatrix;
    private final int nObs;

    public PearsonsCorrelation() {
        this.correlationMatrix = null;
        this.nObs = 0;
    }

    public PearsonsCorrelation(double[][] r2) {
        this(new BlockRealMatrix(r2));
    }

    public PearsonsCorrelation(RealMatrix r2) {
        this.nObs = r2.getRowDimension();
        this.correlationMatrix = computeCorrelationMatrix(r2);
    }

    public PearsonsCorrelation(Covariance r2) {
        RealMatrix r0 = r2.getCovarianceMatrix();
        if (r0 == null) goto L7;
        this.nObs = r2.getN();
        this.correlationMatrix = covarianceToCorrelation(r0);
        return;
    L7:
        throw new NullArgumentException(LocalizedFormats.COVARIANCE_MATRIX, new Object[0]);
    }

    public PearsonsCorrelation(RealMatrix r1, int r2) {
        this.nObs = r2;
        this.correlationMatrix = covarianceToCorrelation(r1);
    }

    public RealMatrix getCorrelationMatrix() {
        return this.correlationMatrix;
    }

    public RealMatrix getCorrelationStandardErrors() {
        int r0 = this.correlationMatrix.getColumnDimension();
        double[][] r2 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r0, r0});
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L9;
        int r5 = 0;
    L5:
        if (r5 >= r0) goto L7;
        double r6 = this.correlationMatrix.getEntry(r4, r5);
        r2[r4][r5] = FastMath.sqrt((1.0d - (r6 * r6)) / ((double) (this.nObs - 2)));
        r5 = r5 + 1;
        goto L5
    L7:
        r4 = r4 + 1;
        goto L3
    L9:
        return new BlockRealMatrix(r2);
    }

    public RealMatrix getCorrelationPValues() {
        TDistribution r0 = new TDistribution(this.nObs - 2);
        int r1 = this.correlationMatrix.getColumnDimension();
        double[][] r3 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r1, r1});
        int r5 = 0;
    L3:
        if (r5 >= r1) goto L12;
        int r6 = 0;
    L5:
        if (r6 >= r1) goto L10;
        if (r5 != r6) goto L8;
        r3[r5][r6] = 0.0d;
    L9:
        r6 = r6 + 1;
        goto L5
    L8:
        double r7 = this.correlationMatrix.getEntry(r5, r6);
        r3[r5][r6] = r0.cumulativeProbability(-FastMath.abs(r7 * FastMath.sqrt(((double) (this.nObs - 2)) / (1.0d - (r7 * r7))))) * 2.0d;
        goto L9
    L10:
        r5 = r5 + 1;
        goto L3
    L12:
        return new BlockRealMatrix(r3);
    }

    public RealMatrix computeCorrelationMatrix(RealMatrix r8) {
        checkSufficientData(r8);
        int r0 = r8.getColumnDimension();
        BlockRealMatrix r1 = new BlockRealMatrix(r0, r0);
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L8;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L7;
        double r5 = correlation(r8.getColumn(r3), r8.getColumn(r4));
        r1.setEntry(r3, r4, r5);
        r1.setEntry(r4, r3, r5);
        r4 = r4 + 1;
        goto L5
    L7:
        r1.setEntry(r3, r3, 1.0d);
        r3 = r3 + 1;
        goto L3
    L8:
        return r1;
    }

    public RealMatrix computeCorrelationMatrix(double[][] r2) {
        return computeCorrelationMatrix(new BlockRealMatrix(r2));
    }

    public double correlation(double[] r7, double[] r8) {
        SimpleRegression r6 = new SimpleRegression();
        if (r7.length != r8.length) goto L14;
        int r1 = 0;
        if (r7.length < 2) goto L12;
    L7:
        if (r1 >= r7.length) goto L10;
        r6.addData(r7[r1], r8[r1]);
        r1 = r1 + 1;
        goto L7
    L10:
        return r6.getR();
    L12:
        throw new MathIllegalArgumentException(LocalizedFormats.INSUFFICIENT_DIMENSION, new Object[]{Integer.valueOf(r7.length), 2});
    L14:
        throw new DimensionMismatchException(r7.length, r8.length);
    }

    public RealMatrix covarianceToCorrelation(RealMatrix r11) {
        int r10 = r11.getColumnDimension();
        BlockRealMatrix r0 = new BlockRealMatrix(r10, r10);
        int r2 = 0;
    L3:
        if (r2 >= r10) goto L8;
        double r3 = FastMath.sqrt(r11.getEntry(r2, r2));
        r0.setEntry(r2, r2, 1.0d);
        int r5 = 0;
    L5:
        if (r5 >= r2) goto L7;
        double r6 = r11.getEntry(r2, r5) / (FastMath.sqrt(r11.getEntry(r5, r5)) * r3);
        r0.setEntry(r2, r5, r6);
        r0.setEntry(r5, r2, r6);
        r5 = r5 + 1;
        goto L5
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        return r0;
    }

    private void checkSufficientData(RealMatrix r5) {
        int r4 = r5.getRowDimension();
        int r6 = r5.getColumnDimension();
        if (r4 < 2) goto L7;
        if (r6 < 2) goto L7;
        return;
    L7:
        throw new MathIllegalArgumentException(LocalizedFormats.INSUFFICIENT_ROWS_AND_COLUMNS, new Object[]{Integer.valueOf(r4), Integer.valueOf(r6)});
    }
}
