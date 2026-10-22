package org.apache.commons.math3.stat.descriptive;

import java.io.Serializable;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.SecondMoment;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.apache.commons.math3.stat.descriptive.summary.SumOfLogs;
import org.apache.commons.math3.stat.descriptive.summary.SumOfSquares;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class SummaryStatistics implements StatisticalSummary, Serializable {
    private static final long serialVersionUID = -2021321786743555871L;
    private GeometricMean geoMean;
    private StorelessUnivariateStatistic geoMeanImpl;
    private Max max;
    private StorelessUnivariateStatistic maxImpl;
    private Mean mean;
    private StorelessUnivariateStatistic meanImpl;
    private Min min;
    private StorelessUnivariateStatistic minImpl;
    private long n;
    private SecondMoment secondMoment;
    private Sum sum;
    private StorelessUnivariateStatistic sumImpl;
    private SumOfLogs sumLog;
    private StorelessUnivariateStatistic sumLogImpl;
    private SumOfSquares sumsq;
    private StorelessUnivariateStatistic sumsqImpl;
    private Variance variance;
    private StorelessUnivariateStatistic varianceImpl;

    public SummaryStatistics() {
        this.n = 0;
        this.secondMoment = new SecondMoment();
        this.sum = new Sum();
        this.sumsq = new SumOfSquares();
        this.min = new Min();
        this.max = new Max();
        this.sumLog = new SumOfLogs();
        this.geoMean = new GeometricMean(this.sumLog);
        this.mean = new Mean(this.secondMoment);
        Variance r0 = new Variance(this.secondMoment);
        this.variance = r0;
        this.sumImpl = this.sum;
        this.sumsqImpl = this.sumsq;
        this.minImpl = this.min;
        this.maxImpl = this.max;
        this.sumLogImpl = this.sumLog;
        this.geoMeanImpl = this.geoMean;
        this.meanImpl = this.mean;
        this.varianceImpl = r0;
    }

    public SummaryStatistics(SummaryStatistics r3) throws NullArgumentException {
        this.n = 0;
        this.secondMoment = new SecondMoment();
        this.sum = new Sum();
        this.sumsq = new SumOfSquares();
        this.min = new Min();
        this.max = new Max();
        this.sumLog = new SumOfLogs();
        this.geoMean = new GeometricMean(this.sumLog);
        this.mean = new Mean(this.secondMoment);
        Variance r0 = new Variance(this.secondMoment);
        this.variance = r0;
        this.sumImpl = this.sum;
        this.sumsqImpl = this.sumsq;
        this.minImpl = this.min;
        this.maxImpl = this.max;
        this.sumLogImpl = this.sumLog;
        this.geoMeanImpl = this.geoMean;
        this.meanImpl = this.mean;
        this.varianceImpl = r0;
        copy(r3, this);
    }

    public StatisticalSummary getSummary() {
        return new StatisticalSummaryValues(getMean(), getVariance(), getN(), getMax(), getMin(), getSum());
    }

    public void addValue(double r3) {
        this.sumImpl.increment(r3);
        this.sumsqImpl.increment(r3);
        this.minImpl.increment(r3);
        this.maxImpl.increment(r3);
        this.sumLogImpl.increment(r3);
        this.secondMoment.increment(r3);
        StorelessUnivariateStatistic r0 = this.meanImpl;
        if (r0 == this.mean) goto L5;
        r0.increment(r3);
    L5:
        StorelessUnivariateStatistic r1 = this.varianceImpl;
        if (r1 == this.variance) goto L8;
        r1.increment(r3);
    L8:
        StorelessUnivariateStatistic r2 = this.geoMeanImpl;
        if (r2 == this.geoMean) goto L11;
        r2.increment(r3);
    L11:
        this.n++;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public long getN() {
        return this.n;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getSum() {
        return this.sumImpl.getResult();
    }

    public double getSumsq() {
        return this.sumsqImpl.getResult();
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMean() {
        return this.meanImpl.getResult();
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getStandardDeviation() {
        if (getN() > 0) goto L5;
        return Double.NaN;
    L5:
        if (getN() > 1) goto L10;
        return 0.0d;
    L10:
        return FastMath.sqrt(getVariance());
    }

    public double getQuadraticMean() {
        long r0 = getN();
        if (r0 > 0) goto L7;
        return Double.NaN;
    L7:
        return FastMath.sqrt(getSumsq() / r0);
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getVariance() {
        return this.varianceImpl.getResult();
    }

    public double getPopulationVariance() {
        Variance r0 = new Variance(this.secondMoment);
        r0.setBiasCorrected(false);
        return r0.getResult();
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMax() {
        return this.maxImpl.getResult();
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMin() {
        return this.minImpl.getResult();
    }

    public double getGeometricMean() {
        return this.geoMeanImpl.getResult();
    }

    public double getSumOfLogs() {
        return this.sumLogImpl.getResult();
    }

    public double getSecondMoment() {
        return this.secondMoment.getResult();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("SummaryStatistics:\nn: ");
        r0.append(getN()).append("\nmin: ");
        r0.append(getMin()).append("\nmax: ");
        r0.append(getMax()).append("\nsum: ");
        r0.append(getSum()).append("\nmean: ");
        r0.append(getMean()).append("\ngeometric mean: ");
        r0.append(getGeometricMean()).append("\nvariance: ");
        r0.append(getVariance()).append("\npopulation variance: ");
        r0.append(getPopulationVariance()).append("\nsecond moment: ");
        r0.append(getSecondMoment()).append("\nsum of squares: ");
        r0.append(getSumsq()).append("\nstandard deviation: ");
        r0.append(getStandardDeviation()).append("\nsum of logs: ");
        r0.append(getSumOfLogs()).append("\n");
        return r0.toString();
    }

    public void clear() {
        this.n = 0;
        this.minImpl.clear();
        this.maxImpl.clear();
        this.sumImpl.clear();
        this.sumLogImpl.clear();
        this.sumsqImpl.clear();
        this.geoMeanImpl.clear();
        this.secondMoment.clear();
        StorelessUnivariateStatistic r0 = this.meanImpl;
        if (r0 == this.mean) goto L5;
        r0.clear();
    L5:
        StorelessUnivariateStatistic r1 = this.varianceImpl;
        if (r1 == this.variance) goto L9;
        r1.clear();
        return;
    }

    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof SummaryStatistics) == true) goto L8;
        return false;
    L8:
        SummaryStatistics r9 = (SummaryStatistics) r8;
        if (Precision.equalsIncludingNaN(r9.getGeometricMean(), getGeometricMean()) == false) goto L26;
        if (Precision.equalsIncludingNaN(r9.getMax(), getMax()) == false) goto L26;
        if (Precision.equalsIncludingNaN(r9.getMean(), getMean()) == false) goto L26;
        if (Precision.equalsIncludingNaN(r9.getMin(), getMin()) == false) goto L26;
        if (Precision.equalsIncludingNaN(r9.getN(), getN()) == false) goto L26;
        if (Precision.equalsIncludingNaN(r9.getSum(), getSum()) == false) goto L26;
        if (Precision.equalsIncludingNaN(r9.getSumsq(), getSumsq()) == false) goto L26;
        if (Precision.equalsIncludingNaN(r9.getVariance(), getVariance()) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((MathUtils.hash(getGeometricMean()) + 31) * 31) + MathUtils.hash(getGeometricMean())) * 31) + MathUtils.hash(getMax())) * 31) + MathUtils.hash(getMean())) * 31) + MathUtils.hash(getMin())) * 31) + MathUtils.hash(getN())) * 31) + MathUtils.hash(getSum())) * 31) + MathUtils.hash(getSumsq())) * 31) + MathUtils.hash(getVariance());
    }

    public StorelessUnivariateStatistic getSumImpl() {
        return this.sumImpl;
    }

    public void setSumImpl(StorelessUnivariateStatistic r1) throws MathIllegalStateException {
        checkEmpty();
        this.sumImpl = r1;
    }

    public StorelessUnivariateStatistic getSumsqImpl() {
        return this.sumsqImpl;
    }

    public void setSumsqImpl(StorelessUnivariateStatistic r1) throws MathIllegalStateException {
        checkEmpty();
        this.sumsqImpl = r1;
    }

    public StorelessUnivariateStatistic getMinImpl() {
        return this.minImpl;
    }

    public void setMinImpl(StorelessUnivariateStatistic r1) throws MathIllegalStateException {
        checkEmpty();
        this.minImpl = r1;
    }

    public StorelessUnivariateStatistic getMaxImpl() {
        return this.maxImpl;
    }

    public void setMaxImpl(StorelessUnivariateStatistic r1) throws MathIllegalStateException {
        checkEmpty();
        this.maxImpl = r1;
    }

    public StorelessUnivariateStatistic getSumLogImpl() {
        return this.sumLogImpl;
    }

    public void setSumLogImpl(StorelessUnivariateStatistic r1) throws MathIllegalStateException {
        checkEmpty();
        this.sumLogImpl = r1;
        this.geoMean.setSumLogImpl(r1);
    }

    public StorelessUnivariateStatistic getGeoMeanImpl() {
        return this.geoMeanImpl;
    }

    public void setGeoMeanImpl(StorelessUnivariateStatistic r1) throws MathIllegalStateException {
        checkEmpty();
        this.geoMeanImpl = r1;
    }

    public StorelessUnivariateStatistic getMeanImpl() {
        return this.meanImpl;
    }

    public void setMeanImpl(StorelessUnivariateStatistic r1) throws MathIllegalStateException {
        checkEmpty();
        this.meanImpl = r1;
    }

    public StorelessUnivariateStatistic getVarianceImpl() {
        return this.varianceImpl;
    }

    public void setVarianceImpl(StorelessUnivariateStatistic r1) throws MathIllegalStateException {
        checkEmpty();
        this.varianceImpl = r1;
    }

    private void checkEmpty() throws MathIllegalStateException {
        if (this.n > 0) goto L6;
        return;
    L6:
        throw new MathIllegalStateException(LocalizedFormats.VALUES_ADDED_BEFORE_CONFIGURING_STATISTIC, new Object[]{Long.valueOf(this.n)});
    }

    public SummaryStatistics copy() {
        SummaryStatistics r0 = new SummaryStatistics();
        copy(this, r0);
        return r0;
    }

    public static void copy(SummaryStatistics r2, SummaryStatistics r3) throws NullArgumentException {
        MathUtils.checkNotNull(r2);
        MathUtils.checkNotNull(r3);
        r3.maxImpl = r2.maxImpl.copy();
        r3.minImpl = r2.minImpl.copy();
        r3.sumImpl = r2.sumImpl.copy();
        r3.sumLogImpl = r2.sumLogImpl.copy();
        r3.sumsqImpl = r2.sumsqImpl.copy();
        r3.secondMoment = r2.secondMoment.copy();
        r3.n = r2.n;
        if ((r2.getVarianceImpl() instanceof Variance) == false) goto L5;
        r3.varianceImpl = new Variance(r3.secondMoment);
    L6:
        StorelessUnivariateStatistic r0 = r2.meanImpl;
        if ((r0 instanceof Mean) == false) goto L9;
        r3.meanImpl = new Mean(r3.secondMoment);
    L11:
        if ((r2.getGeoMeanImpl() instanceof GeometricMean) == false) goto L13;
        r3.geoMeanImpl = new GeometricMean((SumOfLogs) r3.sumLogImpl);
    L14:
        GeometricMean r1 = r2.geoMean;
        if (r1 != r2.geoMeanImpl) goto L17;
        r3.geoMean = (GeometricMean) r3.geoMeanImpl;
    L18:
        Max r4 = r2.max;
        if (r4 != r2.maxImpl) goto L21;
        r3.max = (Max) r3.maxImpl;
    L22:
        Mean r5 = r2.mean;
        if (r5 != r2.meanImpl) goto L25;
        r3.mean = (Mean) r3.meanImpl;
    L26:
        Min r6 = r2.min;
        if (r6 != r2.minImpl) goto L29;
        r3.min = (Min) r3.minImpl;
    L30:
        Sum r7 = r2.sum;
        if (r7 != r2.sumImpl) goto L33;
        r3.sum = (Sum) r3.sumImpl;
    L34:
        Variance r8 = r2.variance;
        if (r8 != r2.varianceImpl) goto L37;
        r3.variance = (Variance) r3.varianceImpl;
    L38:
        SumOfLogs r9 = r2.sumLog;
        if (r9 != r2.sumLogImpl) goto L41;
        r3.sumLog = (SumOfLogs) r3.sumLogImpl;
    L42:
        SumOfSquares r10 = r2.sumsq;
        if (r10 != r2.sumsqImpl) goto L45;
        r3.sumsq = (SumOfSquares) r3.sumsqImpl;
        return;
    L45:
        SumOfSquares.copy(r10, r3.sumsq);
        return;
    L41:
        SumOfLogs.copy(r9, r3.sumLog);
        goto L42
    L37:
        Variance.copy(r8, r3.variance);
        goto L38
    L33:
        Sum.copy(r7, r3.sum);
        goto L34
    L29:
        Min.copy(r6, r3.min);
        goto L30
    L25:
        Mean.copy(r5, r3.mean);
        goto L26
    L21:
        Max.copy(r4, r3.max);
        goto L22
    L17:
        GeometricMean.copy(r1, r3.geoMean);
        goto L18
    L13:
        r3.geoMeanImpl = r2.geoMeanImpl.copy();
        goto L14
    L9:
        r3.meanImpl = r0.copy();
        goto L11
    L5:
        r3.varianceImpl = r2.varianceImpl.copy();
        goto L6
    }
}
