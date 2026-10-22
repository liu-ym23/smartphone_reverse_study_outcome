package org.apache.commons.math3.stat.descriptive;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.VectorialCovariance;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.apache.commons.math3.stat.descriptive.summary.SumOfLogs;
import org.apache.commons.math3.stat.descriptive.summary.SumOfSquares;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class MultivariateSummaryStatistics implements StatisticalMultivariateSummary, Serializable {
    private static final long serialVersionUID = 2271900808994826718L;
    private VectorialCovariance covarianceImpl;
    private StorelessUnivariateStatistic[] geoMeanImpl;
    private int k;
    private StorelessUnivariateStatistic[] maxImpl;
    private StorelessUnivariateStatistic[] meanImpl;
    private StorelessUnivariateStatistic[] minImpl;
    private long n;
    private StorelessUnivariateStatistic[] sumImpl;
    private StorelessUnivariateStatistic[] sumLogImpl;
    private StorelessUnivariateStatistic[] sumSqImpl;

    public MultivariateSummaryStatistics(int r4, boolean r5) {
        this.n = 0;
        this.k = r4;
        this.sumImpl = new StorelessUnivariateStatistic[r4];
        this.sumSqImpl = new StorelessUnivariateStatistic[r4];
        this.minImpl = new StorelessUnivariateStatistic[r4];
        this.maxImpl = new StorelessUnivariateStatistic[r4];
        this.sumLogImpl = new StorelessUnivariateStatistic[r4];
        this.geoMeanImpl = new StorelessUnivariateStatistic[r4];
        this.meanImpl = new StorelessUnivariateStatistic[r4];
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L5;
        this.sumImpl[r0] = new Sum();
        this.sumSqImpl[r0] = new SumOfSquares();
        this.minImpl[r0] = new Min();
        this.maxImpl[r0] = new Max();
        this.sumLogImpl[r0] = new SumOfLogs();
        this.geoMeanImpl[r0] = new GeometricMean();
        this.meanImpl[r0] = new Mean();
        r0 = r0 + 1;
        goto L3
    L5:
        this.covarianceImpl = new VectorialCovariance(r4, r5);
    }

    public void addValue(double[] r5) throws DimensionMismatchException {
        checkDimension(r5.length);
        int r0 = 0;
    L4:
        if (r0 >= this.k) goto L6;
        double r1 = r5[r0];
        this.sumImpl[r0].increment(r1);
        this.sumSqImpl[r0].increment(r1);
        this.minImpl[r0].increment(r1);
        this.maxImpl[r0].increment(r1);
        this.sumLogImpl[r0].increment(r1);
        this.geoMeanImpl[r0].increment(r1);
        this.meanImpl[r0].increment(r1);
        r0 = r0 + 1;
        goto L4
    L6:
        this.covarianceImpl.increment(r5);
        this.n++;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public int getDimension() {
        return this.k;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public long getN() {
        return this.n;
    }

    private double[] getResults(StorelessUnivariateStatistic[] r5) {
        int r4 = r5.length;
        double[] r0 = new double[r4];
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        r0[r1] = r5[r1].getResult();
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public double[] getSum() {
        return getResults(this.sumImpl);
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public double[] getSumSq() {
        return getResults(this.sumSqImpl);
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public double[] getSumLog() {
        return getResults(this.sumLogImpl);
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public double[] getMean() {
        return getResults(this.meanImpl);
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public double[] getStandardDeviation() {
        double[] r0 = new double[this.k];
        if (getN() >= 1) goto L6;
        Arrays.fill(r0, Double.NaN);
    L12:
        return r0;
    L6:
        if (getN() >= 2) goto L8;
        Arrays.fill(r0, 0.0d);
        goto L12
    L8:
        RealMatrix r1 = this.covarianceImpl.getResult();
        int r2 = 0;
    L10:
        if (r2 >= this.k) goto L12;
        r0[r2] = FastMath.sqrt(r1.getEntry(r2, r2));
        r2 = r2 + 1;
        goto L10
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public RealMatrix getCovariance() {
        return this.covarianceImpl.getResult();
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public double[] getMax() {
        return getResults(this.maxImpl);
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public double[] getMin() {
        return getResults(this.minImpl);
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public double[] getGeometricMean() {
        return getResults(this.geoMeanImpl);
    }

    public String toString() {
        String r0 = System.getProperty("line.separator");
        StringBuilder r7 = new StringBuilder();
        r7.append("MultivariateSummaryStatistics:" + r0);
        r7.append("n: " + getN() + r0);
        append(r7, getMin(), "min: ", ", ", r0);
        append(r7, getMax(), "max: ", ", ", r0);
        append(r7, getMean(), "mean: ", ", ", r0);
        append(r7, getGeometricMean(), "geometric mean: ", ", ", r0);
        append(r7, getSumSq(), "sum of squares: ", ", ", r0);
        append(r7, getSumLog(), "sum of logarithms: ", ", ", r0);
        append(r7, getStandardDeviation(), "standard deviation: ", ", ", r0);
        r7.append("covariance: " + getCovariance().toString() + r0);
        return r7.toString();
    }

    private void append(StringBuilder r3, double[] r4, String r5, String r6, String r7) {
        r3.append(r5);
        int r2 = 0;
    L4:
        if (r2 >= r4.length) goto L8;
        if (r2 <= 0) goto L7;
        r3.append(r6);
    L7:
        r3.append(r4[r2]);
        r2 = r2 + 1;
        goto L4
    L8:
        r3.append(r7);
    }

    public void clear() {
        this.n = 0;
        int r0 = 0;
    L4:
        if (r0 >= this.k) goto L6;
        this.minImpl[r0].clear();
        this.maxImpl[r0].clear();
        this.sumImpl[r0].clear();
        this.sumLogImpl[r0].clear();
        this.sumSqImpl[r0].clear();
        this.geoMeanImpl[r0].clear();
        this.meanImpl[r0].clear();
        r0 = r0 + 1;
        goto L4
    L6:
        this.covarianceImpl.clear();
    }

    public boolean equals(Object r6) {
        if (r6 != this) goto L6;
        return true;
    L6:
        if ((r6 instanceof MultivariateSummaryStatistics) == true) goto L8;
        return false;
    L8:
        MultivariateSummaryStatistics r7 = (MultivariateSummaryStatistics) r6;
        if (MathArrays.equalsIncludingNaN(r7.getGeometricMean(), getGeometricMean()) == false) goto L28;
        if (MathArrays.equalsIncludingNaN(r7.getMax(), getMax()) == false) goto L28;
        if (MathArrays.equalsIncludingNaN(r7.getMean(), getMean()) == false) goto L28;
        if (MathArrays.equalsIncludingNaN(r7.getMin(), getMin()) == false) goto L28;
        if (Precision.equalsIncludingNaN(r7.getN(), getN()) == false) goto L28;
        if (MathArrays.equalsIncludingNaN(r7.getSum(), getSum()) == false) goto L28;
        if (MathArrays.equalsIncludingNaN(r7.getSumSq(), getSumSq()) == false) goto L28;
        if (MathArrays.equalsIncludingNaN(r7.getSumLog(), getSumLog()) == false) goto L28;
        if (r7.getCovariance().equals(getCovariance()) == false) goto L28;
        return true;
    L28:
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((MathUtils.hash(getGeometricMean()) + 31) * 31) + MathUtils.hash(getGeometricMean())) * 31) + MathUtils.hash(getMax())) * 31) + MathUtils.hash(getMean())) * 31) + MathUtils.hash(getMin())) * 31) + MathUtils.hash(getN())) * 31) + MathUtils.hash(getSum())) * 31) + MathUtils.hash(getSumSq())) * 31) + MathUtils.hash(getSumLog())) * 31) + getCovariance().hashCode();
    }

    private void setImpl(StorelessUnivariateStatistic[] r2, StorelessUnivariateStatistic[] r3) throws MathIllegalStateException, DimensionMismatchException {
        checkEmpty();
        checkDimension(r2.length);
        System.arraycopy(r2, 0, r3, 0, r2.length);
    }

    public StorelessUnivariateStatistic[] getSumImpl() {
        return (StorelessUnivariateStatistic[]) this.sumImpl.clone();
    }

    public void setSumImpl(StorelessUnivariateStatistic[] r2) throws MathIllegalStateException, DimensionMismatchException {
        setImpl(r2, this.sumImpl);
    }

    public StorelessUnivariateStatistic[] getSumsqImpl() {
        return (StorelessUnivariateStatistic[]) this.sumSqImpl.clone();
    }

    public void setSumsqImpl(StorelessUnivariateStatistic[] r2) throws MathIllegalStateException, DimensionMismatchException {
        setImpl(r2, this.sumSqImpl);
    }

    public StorelessUnivariateStatistic[] getMinImpl() {
        return (StorelessUnivariateStatistic[]) this.minImpl.clone();
    }

    public void setMinImpl(StorelessUnivariateStatistic[] r2) throws MathIllegalStateException, DimensionMismatchException {
        setImpl(r2, this.minImpl);
    }

    public StorelessUnivariateStatistic[] getMaxImpl() {
        return (StorelessUnivariateStatistic[]) this.maxImpl.clone();
    }

    public void setMaxImpl(StorelessUnivariateStatistic[] r2) throws MathIllegalStateException, DimensionMismatchException {
        setImpl(r2, this.maxImpl);
    }

    public StorelessUnivariateStatistic[] getSumLogImpl() {
        return (StorelessUnivariateStatistic[]) this.sumLogImpl.clone();
    }

    public void setSumLogImpl(StorelessUnivariateStatistic[] r2) throws MathIllegalStateException, DimensionMismatchException {
        setImpl(r2, this.sumLogImpl);
    }

    public StorelessUnivariateStatistic[] getGeoMeanImpl() {
        return (StorelessUnivariateStatistic[]) this.geoMeanImpl.clone();
    }

    public void setGeoMeanImpl(StorelessUnivariateStatistic[] r2) throws MathIllegalStateException, DimensionMismatchException {
        setImpl(r2, this.geoMeanImpl);
    }

    public StorelessUnivariateStatistic[] getMeanImpl() {
        return (StorelessUnivariateStatistic[]) this.meanImpl.clone();
    }

    public void setMeanImpl(StorelessUnivariateStatistic[] r2) throws MathIllegalStateException, DimensionMismatchException {
        setImpl(r2, this.meanImpl);
    }

    private void checkEmpty() throws MathIllegalStateException {
        if (this.n > 0) goto L6;
        return;
    L6:
        throw new MathIllegalStateException(LocalizedFormats.VALUES_ADDED_BEFORE_CONFIGURING_STATISTIC, new Object[]{Long.valueOf(this.n)});
    }

    private void checkDimension(int r2) throws DimensionMismatchException {
        if (r2 != this.k) goto L6;
        return;
    L6:
        throw new DimensionMismatchException(r2, this.k);
    }
}
