package org.apache.commons.math3.stat;

import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.UnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.apache.commons.math3.stat.descriptive.summary.SumOfLogs;
import org.apache.commons.math3.stat.descriptive.summary.SumOfSquares;

/* JADX INFO: loaded from: classes6.dex */
public final class StatUtils {
    private static final GeometricMean GEOMETRIC_MEAN = null;
    private static final UnivariateStatistic MAX = null;
    private static final UnivariateStatistic MEAN = null;
    private static final UnivariateStatistic MIN = null;
    private static final Percentile PERCENTILE = null;
    private static final UnivariateStatistic PRODUCT = null;
    private static final UnivariateStatistic SUM = null;
    private static final UnivariateStatistic SUM_OF_LOGS = null;
    private static final UnivariateStatistic SUM_OF_SQUARES = null;
    private static final Variance VARIANCE = null;

    static {
        SUM = new Sum();
        SUM_OF_SQUARES = new SumOfSquares();
        PRODUCT = new Product();
        SUM_OF_LOGS = new SumOfLogs();
        MIN = new Min();
        MAX = new Max();
        MEAN = new Mean();
        VARIANCE = new Variance();
        PERCENTILE = new Percentile();
        GEOMETRIC_MEAN = new GeometricMean();
    }

    private StatUtils() {
    }

    public static double sum(double[] r2) throws MathIllegalArgumentException {
        return SUM.evaluate(r2);
    }

    public static double sum(double[] r1, int r2, int r3) throws MathIllegalArgumentException {
        return SUM.evaluate(r1, r2, r3);
    }

    public static double sumSq(double[] r2) throws MathIllegalArgumentException {
        return SUM_OF_SQUARES.evaluate(r2);
    }

    public static double sumSq(double[] r1, int r2, int r3) throws MathIllegalArgumentException {
        return SUM_OF_SQUARES.evaluate(r1, r2, r3);
    }

    public static double product(double[] r2) throws MathIllegalArgumentException {
        return PRODUCT.evaluate(r2);
    }

    public static double product(double[] r1, int r2, int r3) throws MathIllegalArgumentException {
        return PRODUCT.evaluate(r1, r2, r3);
    }

    public static double sumLog(double[] r2) throws MathIllegalArgumentException {
        return SUM_OF_LOGS.evaluate(r2);
    }

    public static double sumLog(double[] r1, int r2, int r3) throws MathIllegalArgumentException {
        return SUM_OF_LOGS.evaluate(r1, r2, r3);
    }

    public static double mean(double[] r2) throws MathIllegalArgumentException {
        return MEAN.evaluate(r2);
    }

    public static double mean(double[] r1, int r2, int r3) throws MathIllegalArgumentException {
        return MEAN.evaluate(r1, r2, r3);
    }

    public static double geometricMean(double[] r2) throws MathIllegalArgumentException {
        return GEOMETRIC_MEAN.evaluate(r2);
    }

    public static double geometricMean(double[] r1, int r2, int r3) throws MathIllegalArgumentException {
        return GEOMETRIC_MEAN.evaluate(r1, r2, r3);
    }

    public static double variance(double[] r2) throws MathIllegalArgumentException {
        return VARIANCE.evaluate(r2);
    }

    public static double variance(double[] r1, int r2, int r3) throws MathIllegalArgumentException {
        return VARIANCE.evaluate(r1, r2, r3);
    }

    public static double variance(double[] r6, double r7, int r9, int r10) throws MathIllegalArgumentException {
        return VARIANCE.evaluate(r6, r7, r9, r10);
    }

    public static double variance(double[] r1, double r2) throws MathIllegalArgumentException {
        return VARIANCE.evaluate(r1, r2);
    }

    public static double populationVariance(double[] r2) throws MathIllegalArgumentException {
        return new Variance(false).evaluate(r2);
    }

    public static double populationVariance(double[] r2, int r3, int r4) throws MathIllegalArgumentException {
        return new Variance(false).evaluate(r2, r3, r4);
    }

    public static double populationVariance(double[] r6, double r7, int r9, int r10) throws MathIllegalArgumentException {
        return new Variance(false).evaluate(r6, r7, r9, r10);
    }

    public static double populationVariance(double[] r2, double r3) throws MathIllegalArgumentException {
        return new Variance(false).evaluate(r2, r3);
    }

    public static double max(double[] r2) throws MathIllegalArgumentException {
        return MAX.evaluate(r2);
    }

    public static double max(double[] r1, int r2, int r3) throws MathIllegalArgumentException {
        return MAX.evaluate(r1, r2, r3);
    }

    public static double min(double[] r2) throws MathIllegalArgumentException {
        return MIN.evaluate(r2);
    }

    public static double min(double[] r1, int r2, int r3) throws MathIllegalArgumentException {
        return MIN.evaluate(r1, r2, r3);
    }

    public static double percentile(double[] r1, double r2) throws MathIllegalArgumentException {
        return PERCENTILE.evaluate(r1, r2);
    }

    public static double percentile(double[] r6, int r7, int r8, double r9) throws MathIllegalArgumentException {
        return PERCENTILE.evaluate(r6, r7, r8, r9);
    }

    public static double sumDifference(double[] r8, double[] r9) throws DimensionMismatchException, NoDataException {
        int r0 = r8.length;
        if (r0 != r9.length) goto L12;
        if (r0 <= 0) goto L10;
        double r1 = 0.0d;
        int r3 = 0;
    L6:
        if (r3 >= r0) goto L8;
        r1 = r1 + (r8[r3] - r9[r3]);
        r3 = r3 + 1;
        goto L6
    L8:
        return r1;
    L10:
        throw new NoDataException(LocalizedFormats.INSUFFICIENT_DIMENSION);
    L12:
        throw new DimensionMismatchException(r0, r9.length);
    }

    public static double meanDifference(double[] r2, double[] r3) throws DimensionMismatchException, NoDataException {
        return sumDifference(r2, r3) / ((double) r2.length);
    }

    public static double varianceDifference(double[] r11, double[] r12, double r13) throws DimensionMismatchException, NumberIsTooSmallException {
        int r0 = r11.length;
        if (r0 != r12.length) goto L14;
        if (r0 < 2) goto L12;
        double r3 = 0.0d;
        int r1 = 0;
        double r5 = 0.0d;
    L7:
        if (r1 >= r0) goto L10;
        double r7 = (r11[r1] - r12[r1]) - r13;
        r3 = r3 + (r7 * r7);
        r5 = r5 + r7;
        r1 = r1 + 1;
        goto L7
    L10:
        return (r3 - ((r5 * r5) / ((double) r0))) / ((double) (r0 - 1));
    L12:
        throw new NumberIsTooSmallException(Integer.valueOf(r0), 2, true);
    L14:
        throw new DimensionMismatchException(r0, r12.length);
    }

    public static double[] normalize(double[] r8) {
        DescriptiveStatistics r0 = new DescriptiveStatistics();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= r8.length) goto L6;
        r0.addValue(r8[r2]);
        r2 = r2 + 1;
        goto L4
    L6:
        double r3 = r0.getMean();
        double r4 = r0.getStandardDeviation();
        double[] r5 = new double[r8.length];
    L8:
        if (r1 >= r8.length) goto L10;
        r5[r1] = (r8[r1] - r3) / r4;
        r1 = r1 + 1;
        goto L8
    L10:
        return r5;
    }

    public static double[] mode(double[] r2) throws MathIllegalArgumentException {
        if (r2 == null) goto L7;
        return getMode(r2, 0, r2.length);
    L7:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
    }

    public static double[] mode(double[] r0, int r1, int r2) {
        if (r0 == null) goto L12;
        if (r1 < 0) goto L10;
        if (r2 < 0) goto L8;
        return getMode(r0, r1, r2);
    L8:
        throw new NotPositiveException(LocalizedFormats.LENGTH, Integer.valueOf(r2));
    L10:
        throw new NotPositiveException(LocalizedFormats.START_POSITION, Integer.valueOf(r1));
    L12:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
    }

    private static double[] getMode(double[] r5, int r6, int r7) {
        Frequency r0 = new Frequency();
        int r1 = r6;
    L4:
        if (r1 >= (r6 + r7)) goto L9;
        double r2 = r5[r1];
        if (Double.isNaN(r2) == true) goto L8;
        r0.addValue(Double.valueOf(r2));
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        List<Comparable<?>> r8 = r0.getMode();
        double[] r9 = new double[r8.size()];
        Iterator<Comparable<?>> r10 = r8.iterator();
        int r11 = 0;
    L11:
        if (r10.hasNext() == false) goto L13;
        r9[r11] = ((Double) r10.next()).doubleValue();
        r11 = r11 + 1;
        goto L11
    L13:
        return r9;
    }
}
