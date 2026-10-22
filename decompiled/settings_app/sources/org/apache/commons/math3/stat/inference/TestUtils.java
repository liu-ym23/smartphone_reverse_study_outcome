package org.apache.commons.math3.stat.inference;

import java.util.Collection;
import org.apache.commons.math3.distribution.RealDistribution;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.InsufficientDataException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.stat.descriptive.StatisticalSummary;

/* JADX INFO: loaded from: classes6.dex */
public class TestUtils {
    private static final ChiSquareTest CHI_SQUARE_TEST = null;
    private static final GTest G_TEST = null;
    private static final KolmogorovSmirnovTest KS_TEST = null;
    private static final OneWayAnova ONE_WAY_ANANOVA = null;
    private static final TTest T_TEST = null;

    static {
        T_TEST = new TTest();
        CHI_SQUARE_TEST = new ChiSquareTest();
        ONE_WAY_ANANOVA = new OneWayAnova();
        G_TEST = new GTest();
        KS_TEST = new KolmogorovSmirnovTest();
    }

    private TestUtils() {
    }

    public static double homoscedasticT(double[] r1, double[] r2) throws NullArgumentException, NumberIsTooSmallException {
        return T_TEST.homoscedasticT(r1, r2);
    }

    public static double homoscedasticT(StatisticalSummary r1, StatisticalSummary r2) throws NullArgumentException, NumberIsTooSmallException {
        return T_TEST.homoscedasticT(r1, r2);
    }

    public static boolean homoscedasticTTest(double[] r1, double[] r2, double r3) throws NullArgumentException, NumberIsTooSmallException, OutOfRangeException, MaxCountExceededException {
        return T_TEST.homoscedasticTTest(r1, r2, r3);
    }

    public static double homoscedasticTTest(double[] r1, double[] r2) throws NullArgumentException, NumberIsTooSmallException, MaxCountExceededException {
        return T_TEST.homoscedasticTTest(r1, r2);
    }

    public static double homoscedasticTTest(StatisticalSummary r1, StatisticalSummary r2) throws NullArgumentException, NumberIsTooSmallException, MaxCountExceededException {
        return T_TEST.homoscedasticTTest(r1, r2);
    }

    public static double pairedT(double[] r1, double[] r2) throws NullArgumentException, NoDataException, DimensionMismatchException, NumberIsTooSmallException {
        return T_TEST.pairedT(r1, r2);
    }

    public static boolean pairedTTest(double[] r1, double[] r2, double r3) throws NullArgumentException, NoDataException, DimensionMismatchException, NumberIsTooSmallException, OutOfRangeException, MaxCountExceededException {
        return T_TEST.pairedTTest(r1, r2, r3);
    }

    public static double pairedTTest(double[] r1, double[] r2) throws NullArgumentException, NoDataException, DimensionMismatchException, NumberIsTooSmallException, MaxCountExceededException {
        return T_TEST.pairedTTest(r1, r2);
    }

    public static double t(double r1, double[] r3) throws NullArgumentException, NumberIsTooSmallException {
        return T_TEST.t(r1, r3);
    }

    public static double t(double r1, StatisticalSummary r3) throws NullArgumentException, NumberIsTooSmallException {
        return T_TEST.t(r1, r3);
    }

    public static double t(double[] r1, double[] r2) throws NullArgumentException, NumberIsTooSmallException {
        return T_TEST.t(r1, r2);
    }

    public static double t(StatisticalSummary r1, StatisticalSummary r2) throws NullArgumentException, NumberIsTooSmallException {
        return T_TEST.t(r1, r2);
    }

    public static boolean tTest(double r6, double[] r8, double r9) throws NullArgumentException, NumberIsTooSmallException, OutOfRangeException, MaxCountExceededException {
        return T_TEST.tTest(r6, r8, r9);
    }

    public static double tTest(double r1, double[] r3) throws NullArgumentException, NumberIsTooSmallException, MaxCountExceededException {
        return T_TEST.tTest(r1, r3);
    }

    public static boolean tTest(double r6, StatisticalSummary r8, double r9) throws NullArgumentException, NumberIsTooSmallException, OutOfRangeException, MaxCountExceededException {
        return T_TEST.tTest(r6, r8, r9);
    }

    public static double tTest(double r1, StatisticalSummary r3) throws NullArgumentException, NumberIsTooSmallException, MaxCountExceededException {
        return T_TEST.tTest(r1, r3);
    }

    public static boolean tTest(double[] r1, double[] r2, double r3) throws NullArgumentException, NumberIsTooSmallException, OutOfRangeException, MaxCountExceededException {
        return T_TEST.tTest(r1, r2, r3);
    }

    public static double tTest(double[] r1, double[] r2) throws NullArgumentException, NumberIsTooSmallException, MaxCountExceededException {
        return T_TEST.tTest(r1, r2);
    }

    public static boolean tTest(StatisticalSummary r1, StatisticalSummary r2, double r3) throws NullArgumentException, NumberIsTooSmallException, OutOfRangeException, MaxCountExceededException {
        return T_TEST.tTest(r1, r2, r3);
    }

    public static double tTest(StatisticalSummary r1, StatisticalSummary r2) throws NullArgumentException, NumberIsTooSmallException, MaxCountExceededException {
        return T_TEST.tTest(r1, r2);
    }

    public static double chiSquare(double[] r1, long[] r2) throws NotPositiveException, NotStrictlyPositiveException, DimensionMismatchException {
        return CHI_SQUARE_TEST.chiSquare(r1, r2);
    }

    public static double chiSquare(long[][] r2) throws NullArgumentException, NotPositiveException, DimensionMismatchException {
        return CHI_SQUARE_TEST.chiSquare(r2);
    }

    public static boolean chiSquareTest(double[] r1, long[] r2, double r3) throws NotPositiveException, NotStrictlyPositiveException, DimensionMismatchException, OutOfRangeException, MaxCountExceededException {
        return CHI_SQUARE_TEST.chiSquareTest(r1, r2, r3);
    }

    public static double chiSquareTest(double[] r1, long[] r2) throws NotPositiveException, NotStrictlyPositiveException, DimensionMismatchException, MaxCountExceededException {
        return CHI_SQUARE_TEST.chiSquareTest(r1, r2);
    }

    public static boolean chiSquareTest(long[][] r1, double r2) throws NullArgumentException, DimensionMismatchException, NotPositiveException, OutOfRangeException, MaxCountExceededException {
        return CHI_SQUARE_TEST.chiSquareTest(r1, r2);
    }

    public static double chiSquareTest(long[][] r2) throws NullArgumentException, DimensionMismatchException, NotPositiveException, MaxCountExceededException {
        return CHI_SQUARE_TEST.chiSquareTest(r2);
    }

    public static double chiSquareDataSetsComparison(long[] r1, long[] r2) throws DimensionMismatchException, NotPositiveException, ZeroException {
        return CHI_SQUARE_TEST.chiSquareDataSetsComparison(r1, r2);
    }

    public static double chiSquareTestDataSetsComparison(long[] r1, long[] r2) throws DimensionMismatchException, NotPositiveException, ZeroException, MaxCountExceededException {
        return CHI_SQUARE_TEST.chiSquareTestDataSetsComparison(r1, r2);
    }

    public static boolean chiSquareTestDataSetsComparison(long[] r1, long[] r2, double r3) throws DimensionMismatchException, NotPositiveException, ZeroException, OutOfRangeException, MaxCountExceededException {
        return CHI_SQUARE_TEST.chiSquareTestDataSetsComparison(r1, r2, r3);
    }

    public static double oneWayAnovaFValue(Collection<double[]> r2) throws NullArgumentException, DimensionMismatchException {
        return ONE_WAY_ANANOVA.anovaFValue(r2);
    }

    public static double oneWayAnovaPValue(Collection<double[]> r2) throws NullArgumentException, DimensionMismatchException, ConvergenceException, MaxCountExceededException {
        return ONE_WAY_ANANOVA.anovaPValue(r2);
    }

    public static boolean oneWayAnovaTest(Collection<double[]> r1, double r2) throws NullArgumentException, DimensionMismatchException, OutOfRangeException, ConvergenceException, MaxCountExceededException {
        return ONE_WAY_ANANOVA.anovaTest(r1, r2);
    }

    public static double g(double[] r1, long[] r2) throws NotPositiveException, NotStrictlyPositiveException, DimensionMismatchException {
        return G_TEST.g(r1, r2);
    }

    public static double gTest(double[] r1, long[] r2) throws NotPositiveException, NotStrictlyPositiveException, DimensionMismatchException, MaxCountExceededException {
        return G_TEST.gTest(r1, r2);
    }

    public static double gTestIntrinsic(double[] r1, long[] r2) throws NotPositiveException, NotStrictlyPositiveException, DimensionMismatchException, MaxCountExceededException {
        return G_TEST.gTestIntrinsic(r1, r2);
    }

    public static boolean gTest(double[] r1, long[] r2, double r3) throws NotPositiveException, NotStrictlyPositiveException, DimensionMismatchException, OutOfRangeException, MaxCountExceededException {
        return G_TEST.gTest(r1, r2, r3);
    }

    public static double gDataSetsComparison(long[] r1, long[] r2) throws DimensionMismatchException, NotPositiveException, ZeroException {
        return G_TEST.gDataSetsComparison(r1, r2);
    }

    public static double rootLogLikelihoodRatio(long r9, long r11, long r13, long r15) throws DimensionMismatchException, NotPositiveException, ZeroException {
        return G_TEST.rootLogLikelihoodRatio(r9, r11, r13, r15);
    }

    public static double gTestDataSetsComparison(long[] r1, long[] r2) throws DimensionMismatchException, NotPositiveException, ZeroException, MaxCountExceededException {
        return G_TEST.gTestDataSetsComparison(r1, r2);
    }

    public static boolean gTestDataSetsComparison(long[] r1, long[] r2, double r3) throws DimensionMismatchException, NotPositiveException, ZeroException, OutOfRangeException, MaxCountExceededException {
        return G_TEST.gTestDataSetsComparison(r1, r2, r3);
    }

    public static double kolmogorovSmirnovStatistic(RealDistribution r1, double[] r2) throws InsufficientDataException, NullArgumentException {
        return KS_TEST.kolmogorovSmirnovStatistic(r1, r2);
    }

    public static double kolmogorovSmirnovTest(RealDistribution r1, double[] r2) throws InsufficientDataException, NullArgumentException {
        return KS_TEST.kolmogorovSmirnovTest(r1, r2);
    }

    public static double kolmogorovSmirnovTest(RealDistribution r1, double[] r2, boolean r3) throws InsufficientDataException, NullArgumentException {
        return KS_TEST.kolmogorovSmirnovTest(r1, r2, r3);
    }

    public static boolean kolmogorovSmirnovTest(RealDistribution r1, double[] r2, double r3) throws InsufficientDataException, NullArgumentException {
        return KS_TEST.kolmogorovSmirnovTest(r1, r2, r3);
    }

    public static double kolmogorovSmirnovStatistic(double[] r1, double[] r2) throws InsufficientDataException, NullArgumentException {
        return KS_TEST.kolmogorovSmirnovStatistic(r1, r2);
    }

    public static double kolmogorovSmirnovTest(double[] r1, double[] r2) throws InsufficientDataException, NullArgumentException {
        return KS_TEST.kolmogorovSmirnovTest(r1, r2);
    }

    public static double kolmogorovSmirnovTest(double[] r1, double[] r2, boolean r3) throws InsufficientDataException, NullArgumentException {
        return KS_TEST.kolmogorovSmirnovTest(r1, r2, r3);
    }

    public static double exactP(double r6, int r8, int r9, boolean r10) {
        return KS_TEST.exactP(r6, r9, r8, r10);
    }

    public static double approximateP(double r1, int r3, int r4) {
        return KS_TEST.approximateP(r1, r3, r4);
    }

    public static double monteCarloP(double r7, int r9, int r10, boolean r11, int r12) {
        return KS_TEST.monteCarloP(r7, r9, r10, r11, r12);
    }
}
