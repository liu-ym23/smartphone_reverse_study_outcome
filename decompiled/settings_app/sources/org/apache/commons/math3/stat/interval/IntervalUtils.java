package org.apache.commons.math3.stat.interval;

import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public final class IntervalUtils {
    private static final BinomialConfidenceInterval AGRESTI_COULL = null;
    private static final BinomialConfidenceInterval CLOPPER_PEARSON = null;
    private static final BinomialConfidenceInterval NORMAL_APPROXIMATION = null;
    private static final BinomialConfidenceInterval WILSON_SCORE = null;

    static {
        AGRESTI_COULL = new AgrestiCoullInterval();
        CLOPPER_PEARSON = new ClopperPearsonInterval();
        NORMAL_APPROXIMATION = new NormalApproximationInterval();
        WILSON_SCORE = new WilsonScoreInterval();
    }

    private IntervalUtils() {
    }

    public static ConfidenceInterval getAgrestiCoullInterval(int r1, int r2, double r3) {
        return AGRESTI_COULL.createInterval(r1, r2, r3);
    }

    public static ConfidenceInterval getClopperPearsonInterval(int r1, int r2, double r3) {
        return CLOPPER_PEARSON.createInterval(r1, r2, r3);
    }

    public static ConfidenceInterval getNormalApproximationInterval(int r1, int r2, double r3) {
        return NORMAL_APPROXIMATION.createInterval(r1, r2, r3);
    }

    public static ConfidenceInterval getWilsonScoreInterval(int r1, int r2, double r3) {
        return WILSON_SCORE.createInterval(r1, r2, r3);
    }

    static void checkParameters(int r1, int r2, double r3) {
        if (r1 <= 0) goto L18;
        if (r2 < 0) goto L16;
        if (r2 > r1) goto L14;
        if (r3 <= 0.0d) goto L12;
        if (r3 >= 1.0d) goto L12;
        return;
    L12:
        throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUNDS_CONFIDENCE_LEVEL, Double.valueOf(r3), 0, 1);
    L14:
        throw new NumberIsTooLargeException(LocalizedFormats.NUMBER_OF_SUCCESS_LARGER_THAN_POPULATION_SIZE, Integer.valueOf(r2), Integer.valueOf(r1), true);
    L16:
        throw new NotPositiveException(LocalizedFormats.NEGATIVE_NUMBER_OF_SUCCESSES, Integer.valueOf(r2));
    L18:
        throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_TRIALS, Integer.valueOf(r1));
    }
}
