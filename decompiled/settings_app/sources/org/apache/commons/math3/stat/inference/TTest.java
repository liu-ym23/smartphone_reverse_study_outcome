package org.apache.commons.math3.stat.inference;

import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.StatisticalSummary;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class TTest {
    protected double df(double r7, double r9, double r11, double r13) {
        double r0 = (r7 / r11) + (r9 / r13);
        return (r0 * r0) / (((r7 * r7) / ((r11 * r11) * (r11 - 1.0d))) + ((r9 * r9) / ((r13 * r13) * (r13 - 1.0d))));
    }

    public TTest() {
    }

    public double pairedT(double[] r10, double[] r11) throws NullArgumentException, NoDataException, DimensionMismatchException, NumberIsTooSmallException {
        checkSampleData(r10);
        checkSampleData(r11);
        double r1 = StatUtils.meanDifference(r10, r11);
        return t(r1, 0.0d, StatUtils.varianceDifference(r10, r11, r1), r10.length);
    }

    public double pairedTTest(double[] r10, double[] r11) throws NullArgumentException, NoDataException, DimensionMismatchException, NumberIsTooSmallException, MaxCountExceededException {
        double r1 = StatUtils.meanDifference(r10, r11);
        return tTest(r1, 0.0d, StatUtils.varianceDifference(r10, r11, r1), r10.length);
    }

    public boolean pairedTTest(double[] r1, double[] r2, double r3) throws NullArgumentException, NoDataException, DimensionMismatchException, NumberIsTooSmallException, OutOfRangeException, MaxCountExceededException {
        checkSignificanceLevel(r3);
        if (pairedTTest(r1, r2) >= r3) goto L5;
        return true;
    L5:
        return false;
    }

    public double t(double r10, double[] r12) throws NullArgumentException, NumberIsTooSmallException {
        checkSampleData(r12);
        return t(StatUtils.mean(r12), r10, StatUtils.variance(r12), r12.length);
    }

    public double t(double r10, StatisticalSummary r12) throws NullArgumentException, NumberIsTooSmallException {
        checkSampleData(r12);
        return t(r12.getMean(), r10, r12.getVariance(), r12.getN());
    }

    public double homoscedasticT(double[] r14, double[] r15) throws NullArgumentException, NumberIsTooSmallException {
        checkSampleData(r14);
        checkSampleData(r15);
        return homoscedasticT(StatUtils.mean(r14), StatUtils.mean(r15), StatUtils.variance(r14), StatUtils.variance(r15), r14.length, r15.length);
    }

    public double t(double[] r14, double[] r15) throws NullArgumentException, NumberIsTooSmallException {
        checkSampleData(r14);
        checkSampleData(r15);
        return t(StatUtils.mean(r14), StatUtils.mean(r15), StatUtils.variance(r14), StatUtils.variance(r15), r14.length, r15.length);
    }

    public double t(StatisticalSummary r14, StatisticalSummary r15) throws NullArgumentException, NumberIsTooSmallException {
        checkSampleData(r14);
        checkSampleData(r15);
        return t(r14.getMean(), r15.getMean(), r14.getVariance(), r15.getVariance(), r14.getN(), r15.getN());
    }

    public double homoscedasticT(StatisticalSummary r14, StatisticalSummary r15) throws NullArgumentException, NumberIsTooSmallException {
        checkSampleData(r14);
        checkSampleData(r15);
        return homoscedasticT(r14.getMean(), r15.getMean(), r14.getVariance(), r15.getVariance(), r14.getN(), r15.getN());
    }

    public double tTest(double r10, double[] r12) throws NullArgumentException, NumberIsTooSmallException, MaxCountExceededException {
        checkSampleData(r12);
        return tTest(StatUtils.mean(r12), r10, StatUtils.variance(r12), r12.length);
    }

    public boolean tTest(double r1, double[] r3, double r4) throws NullArgumentException, NumberIsTooSmallException, OutOfRangeException, MaxCountExceededException {
        checkSignificanceLevel(r4);
        if (tTest(r1, r3) >= r4) goto L5;
        return true;
    L5:
        return false;
    }

    public double tTest(double r10, StatisticalSummary r12) throws NullArgumentException, NumberIsTooSmallException, MaxCountExceededException {
        checkSampleData(r12);
        return tTest(r12.getMean(), r10, r12.getVariance(), r12.getN());
    }

    public boolean tTest(double r1, StatisticalSummary r3, double r4) throws NullArgumentException, NumberIsTooSmallException, OutOfRangeException, MaxCountExceededException {
        checkSignificanceLevel(r4);
        if (tTest(r1, r3) >= r4) goto L5;
        return true;
    L5:
        return false;
    }

    public double tTest(double[] r14, double[] r15) throws NullArgumentException, NumberIsTooSmallException, MaxCountExceededException {
        checkSampleData(r14);
        checkSampleData(r15);
        return tTest(StatUtils.mean(r14), StatUtils.mean(r15), StatUtils.variance(r14), StatUtils.variance(r15), r14.length, r15.length);
    }

    public double homoscedasticTTest(double[] r14, double[] r15) throws NullArgumentException, NumberIsTooSmallException, MaxCountExceededException {
        checkSampleData(r14);
        checkSampleData(r15);
        return homoscedasticTTest(StatUtils.mean(r14), StatUtils.mean(r15), StatUtils.variance(r14), StatUtils.variance(r15), r14.length, r15.length);
    }

    public boolean tTest(double[] r1, double[] r2, double r3) throws NullArgumentException, NumberIsTooSmallException, OutOfRangeException, MaxCountExceededException {
        checkSignificanceLevel(r3);
        if (tTest(r1, r2) >= r3) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean homoscedasticTTest(double[] r1, double[] r2, double r3) throws NullArgumentException, NumberIsTooSmallException, OutOfRangeException, MaxCountExceededException {
        checkSignificanceLevel(r3);
        if (homoscedasticTTest(r1, r2) >= r3) goto L5;
        return true;
    L5:
        return false;
    }

    public double tTest(StatisticalSummary r14, StatisticalSummary r15) throws NullArgumentException, NumberIsTooSmallException, MaxCountExceededException {
        checkSampleData(r14);
        checkSampleData(r15);
        return tTest(r14.getMean(), r15.getMean(), r14.getVariance(), r15.getVariance(), r14.getN(), r15.getN());
    }

    public double homoscedasticTTest(StatisticalSummary r14, StatisticalSummary r15) throws NullArgumentException, NumberIsTooSmallException, MaxCountExceededException {
        checkSampleData(r14);
        checkSampleData(r15);
        return homoscedasticTTest(r14.getMean(), r15.getMean(), r14.getVariance(), r15.getVariance(), r14.getN(), r15.getN());
    }

    public boolean tTest(StatisticalSummary r1, StatisticalSummary r2, double r3) throws NullArgumentException, NumberIsTooSmallException, OutOfRangeException, MaxCountExceededException {
        checkSignificanceLevel(r3);
        if (tTest(r1, r2) >= r3) goto L5;
        return true;
    L5:
        return false;
    }

    protected double t(double r1, double r3, double r5, double r7) {
        return (r1 - r3) / FastMath.sqrt(r5 / r7);
    }

    protected double t(double r1, double r3, double r5, double r7, double r9, double r11) {
        return (r1 - r3) / FastMath.sqrt((r5 / r9) + (r7 / r11));
    }

    protected double homoscedasticT(double r9, double r11, double r13, double r15, double r17, double r19) {
        double r2 = (((r17 - 1.0d) * r13) + ((r19 - 1.0d) * r15)) / ((r17 + r19) - 2.0d);
        return (r9 - r11) / FastMath.sqrt(r2 * ((1.0d / r17) + (1.0d / r19)));
    }

    protected double tTest(double r1, double r3, double r5, double r7) throws MaxCountExceededException, MathIllegalArgumentException {
        double r0 = FastMath.abs(t(r1, r3, r5, r7));
        return new TDistribution(null, r7 - 1.0d).cumulativeProbability(-r0) * 2.0d;
    }

    protected double tTest(double r12, double r14, double r16, double r18, double r20, double r22) throws MaxCountExceededException, NotStrictlyPositiveException {
        double r0 = FastMath.abs(t(r12, r14, r16, r18, r20, r22));
        return new TDistribution(null, df(r16, r18, r20, r22)).cumulativeProbability(-r0) * 2.0d;
    }

    protected double homoscedasticTTest(double r1, double r3, double r5, double r7, double r9, double r11) throws MaxCountExceededException, NotStrictlyPositiveException {
        double r0 = FastMath.abs(homoscedasticT(r1, r3, r5, r7, r9, r11));
        return new TDistribution(null, (r9 + r11) - 2.0d).cumulativeProbability(-r0) * 2.0d;
    }

    private void checkSignificanceLevel(double r6) throws OutOfRangeException {
        if (r6 <= 0.0d) goto L8;
        if (r6 > 0.5d) goto L8;
        return;
    L8:
        throw new OutOfRangeException(LocalizedFormats.SIGNIFICANCE_LEVEL, Double.valueOf(r6), Double.valueOf(0.0d), Double.valueOf(0.5d));
    }

    private void checkSampleData(double[] r4) throws NullArgumentException, NumberIsTooSmallException {
        if (r4 == null) goto L9;
        if (r4.length < 2) goto L7;
        return;
    L7:
        throw new NumberIsTooSmallException(LocalizedFormats.INSUFFICIENT_DATA_FOR_T_STATISTIC, Integer.valueOf(r4.length), 2, true);
    L9:
        throw new NullArgumentException();
    }

    private void checkSampleData(StatisticalSummary r5) throws NullArgumentException, NumberIsTooSmallException {
        if (r5 == null) goto L9;
        if (r5.getN() < 2) goto L7;
        return;
    L7:
        throw new NumberIsTooSmallException(LocalizedFormats.INSUFFICIENT_DATA_FOR_T_STATISTIC, Long.valueOf(r5.getN()), 2, true);
    L9:
        throw new NullArgumentException();
    }
}
