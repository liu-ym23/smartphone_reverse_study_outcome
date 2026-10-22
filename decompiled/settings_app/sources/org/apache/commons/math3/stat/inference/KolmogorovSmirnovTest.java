package org.apache.commons.math3.stat.inference;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import org.apache.commons.math3.distribution.EnumeratedRealDistribution;
import org.apache.commons.math3.distribution.RealDistribution;
import org.apache.commons.math3.distribution.UniformRealDistribution;
import org.apache.commons.math3.exception.InsufficientDataException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.TooManyIterationsException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.fraction.BigFraction;
import org.apache.commons.math3.fraction.BigFractionField;
import org.apache.commons.math3.fraction.FractionConversionException;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.commons.math3.linear.FieldMatrix;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.CombinatoricsUtils;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class KolmogorovSmirnovTest {
    protected static final double KS_SUM_CAUCHY_CRITERION = 1.0E-20d;
    protected static final int LARGE_SAMPLE_PRODUCT = 10000;
    protected static final int MAXIMUM_PARTIAL_SUM_COUNT = 100000;

    @Deprecated
    protected static final int MONTE_CARLO_ITERATIONS = 1000000;
    protected static final double PG_SUM_RELATIVE_ERROR = 1.0E-10d;

    @Deprecated
    protected static final int SMALL_SAMPLE_PRODUCT = 200;
    private final RandomGenerator rng;

    public KolmogorovSmirnovTest() {
        this.rng = new Well19937c();
    }

    @Deprecated
    public KolmogorovSmirnovTest(RandomGenerator r1) {
        this.rng = r1;
    }

    public double kolmogorovSmirnovTest(RealDistribution r3, double[] r4, boolean r5) {
        return 1.0d - cdf(kolmogorovSmirnovStatistic(r3, r4), r4.length, r5);
    }

    public double kolmogorovSmirnovStatistic(RealDistribution r13, double[] r14) {
        checkArray(r14);
        int r12 = r14.length;
        double r0 = r12;
        double[] r2 = new double[r12];
        System.arraycopy(r14, 0, r2, 0, r12);
        Arrays.sort(r2);
        double r3 = 0.0d;
        int r15 = 1;
    L3:
        if (r15 > r12) goto L8;
        int r5 = r15 - 1;
        double r6 = r13.cumulativeProbability(r2[r5]);
        double r7 = FastMath.max(r6 - (((double) r5) / r0), (((double) r15) / r0) - r6);
        if (r7 <= r3) goto L7;
        r3 = r7;
    L7:
        r15 = r15 + 1;
        goto L3
    L8:
        return r3;
    }

    public double kolmogorovSmirnovTest(double[] r10, double[] r11, boolean r12) {
        long r0 = ((long) r10.length) * ((long) r11.length);
        if (r0 < 10000) goto L5;
    L7:
        double[] r1 = r10;
        double[] r2 = r11;
    L8:
        if (r0 >= 10000) goto L12;
        return exactP(kolmogorovSmirnovStatistic(r1, r2), r10.length, r11.length, r12);
    L12:
        return approximateP(kolmogorovSmirnovStatistic(r10, r11), r10.length, r11.length);
    L5:
        if (hasTies(r10, r11) == false) goto L7;
        r1 = MathArrays.copyOf(r10);
        r2 = MathArrays.copyOf(r11);
        fixTies(r1, r2);
        goto L8
    }

    public double kolmogorovSmirnovTest(double[] r2, double[] r3) {
        return kolmogorovSmirnovTest(r2, r3, true);
    }

    public double kolmogorovSmirnovStatistic(double[] r5, double[] r6) {
        return integralKolmogorovSmirnovStatistic(r5, r6) / (((long) r5.length) * ((long) r6.length));
    }

    private long integralKolmogorovSmirnovStatistic(double[] r12, double[] r13) {
        checkArray(r12);
        checkArray(r13);
        double[] r11 = MathArrays.copyOf(r12);
        double[] r14 = MathArrays.copyOf(r13);
        Arrays.sort(r11);
        Arrays.sort(r14);
        int r15 = r11.length;
        int r0 = r14.length;
        int r1 = 0;
        long r5 = 0;
        int r2 = 0;
        long r3 = 0;
    L4:
        if (Double.compare(r11[r1], r14[r2]) > 0) goto L6;
        double r7 = r11[r1];
    L7:
        if (r1 >= r15) goto L11;
        if (Double.compare(r11[r1], r7) != 0) goto L11;
        r1 = r1 + 1;
        r3 = r3 + ((long) r0);
    L11:
        if (r2 >= r0) goto L16;
        if (Double.compare(r14[r2], r7) != 0) goto L16;
        r2 = r2 + 1;
        r3 = r3 - ((long) r15);
    L16:
        if (r3 <= r5) goto L18;
        r5 = r3;
    L21:
        if (r1 >= r15) goto L23;
        if (r2 < r0) goto L4;
    L23:
        return r5;
    L18:
        long r8 = -r3;
        if (r8 <= r5) goto L21;
        r5 = r8;
        goto L21
    L6:
        r7 = r14[r2];
        goto L7
    }

    public double kolmogorovSmirnovTest(RealDistribution r2, double[] r3) {
        return kolmogorovSmirnovTest(r2, r3, false);
    }

    public boolean kolmogorovSmirnovTest(RealDistribution r5, double[] r6, double r7) {
        if (r7 <= 0.0d) goto L11;
        if (r7 > 0.5d) goto L11;
        if (kolmogorovSmirnovTest(r5, r6) >= r7) goto L12;
        return true;
    L12:
        return false;
    L11:
        throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, Double.valueOf(r7), 0, Double.valueOf(0.5d));
    }

    public double bootstrap(double[] r9, double[] r10, int r11, boolean r12) {
        int r0 = r9.length;
        int r1 = r10.length;
        double[] r2 = new double[r0 + r1];
        int r3 = 0;
        System.arraycopy(r9, 0, r2, 0, r0);
        System.arraycopy(r10, 0, r2, r0, r1);
        EnumeratedRealDistribution r4 = new EnumeratedRealDistribution(this.rng, r2);
        long r13 = integralKolmogorovSmirnovStatistic(r9, r10);
        int r5 = 0;
        int r6 = 0;
    L3:
        if (r3 >= r11) goto L10;
        long r7 = integralKolmogorovSmirnovStatistic(r4.sample(r0), r4.sample(r1));
        if (r7 <= r13) goto L7;
        r5 = r5 + 1;
    L9:
        r3 = r3 + 1;
        goto L3
    L7:
        if (r7 != r13) goto L9;
        r6 = r6 + 1;
        goto L9
    L10:
        if (r12 == true) goto L14;
        r5 = r5 + r6;
    L14:
        return ((double) r5) / ((double) r11);
    }

    public double bootstrap(double[] r2, double[] r3, int r4) {
        return bootstrap(r2, r3, r4, true);
    }

    public double cdf(double r2, int r4) throws MathArithmeticException {
        return cdf(r2, r4, false);
    }

    public double cdfExact(double r2, int r4) throws MathArithmeticException {
        return cdf(r2, r4, true);
    }

    public double cdf(double r10, int r12, boolean r13) throws MathArithmeticException {
        double r0 = r12;
        double r2 = 1.0d;
        double r4 = 1.0d / r0;
        double r6 = 0.5d * r4;
        if (r10 > r6) goto L7;
        return 0.0d;
    L7:
        if (r6 >= r10) goto L15;
        if (r10 > r4) goto L15;
        double r11 = (r10 * 2.0d) - r4;
        int r9 = 1;
    L11:
        if (r9 > r12) goto L13;
        r2 = r2 * (((double) r9) * r11);
        r9 = r9 + 1;
        goto L11
    L13:
        return r2;
    L15:
        if ((1.0d - r4) > r10) goto L21;
        if (r10 >= 1.0d) goto L21;
        return 1.0d - (Math.pow(1.0d - r10, r0) * 2.0d);
    L21:
        if (1.0d > r10) goto L23;
        return 1.0d;
    L23:
        if (r13 == false) goto L27;
        return exactK(r10, r12);
    L27:
        if (r12 > 140) goto L31;
        return roundedK(r10, r12);
    L31:
        return pelzGood(r10, r12);
    }

    private double exactK(double r3, int r5) throws MathArithmeticException {
        int r0 = (int) Math.ceil(((double) r5) * r3);
        FieldMatrix<T> r2 = createExactH(r3, r5).power(r5);
        int r4 = 1;
        int r1 = r0 - 1;
        BigFraction r6 = (BigFraction) r2.getEntry(r1, r1);
    L3:
        if (r4 > r5) goto L6;
        r6 = r6.multiply2(r4).divide(r5);
        r4 = r4 + 1;
        goto L3
    L6:
        return r6.bigDecimalValue(20, 4).doubleValue();
    }

    private double roundedK(double r7, int r9) {
        double r0 = r9;
        int r2 = (int) Math.ceil(r0 * r7);
        RealMatrix r6 = createRoundedH(r7, r9).power(r9);
        int r8 = 1;
        int r3 = r2 - 1;
        double r4 = r6.getEntry(r3, r3);
    L3:
        if (r8 > r9) goto L5;
        r4 = r4 * (((double) r8) / r0);
        r8 = r8 + 1;
        goto L3
    L5:
        return r4;
    }

    public double pelzGood(double r51, int r53) {
        double r0 = r53;
        double r2 = FastMath.sqrt(r0);
        double r4 = r51 * r2;
        double r6 = (r51 * r51) * r0;
        double r8 = r6 * r6;
        double r10 = r8 * r6;
        double r14 = 9.869604401089358d / (8.0d * r6);
        double r18 = 0.0d;
        double r50 = r8 * r8;
        double r21 = 0.0d;
        int r12 = 1;
    L4:
        if (r12 >= 100000) goto L9;
        double r26 = r0;
        double r1 = (r12 * 2) - 1;
        double r28 = r10;
        double r3 = FastMath.exp(((-r14) * r1) * r1);
        r21 = r21 + r3;
        if (r3 <= (r21 * 1.0E-10d)) goto L7;
        r12 = r12 + 1;
        r0 = r26;
        r10 = r28;
        goto L4
    L7:
        int r5 = 100000;
    L10:
        if (r12 == r5) goto L61;
        double r22 = (r21 * FastMath.sqrt(6.283185307179586d)) / r4;
        double r13 = r6 * 2.0d;
        double r30 = 0.0d;
        int r15 = 0;
    L13:
        if (r15 >= r5) goto L18;
        double r11 = ((double) r15) + 0.5d;
        double r16 = r11 * r11;
        double r38 = ((r16 * 9.869604401089358d) - r6) * FastMath.exp((r16 * (-9.869604401089358d)) / r13);
        r30 = r30 + r38;
        if (FastMath.abs(r38) < (FastMath.abs(r30) * 1.0E-10d)) goto L16;
        r15 = r15 + 1;
        r5 = 100000;
        goto L13
    L16:
        r5 = 100000;
    L18:
        if (r15 == r5) goto L59;
        double r17 = FastMath.sqrt(1.5707963267948966d);
        double r23 = r22 + ((r30 * r17) / ((3.0d * r8) * r2));
        double r19 = 2.0d * r8;
        double r31 = 6.0d * r28;
        double r39 = r6 * 5.0d;
        double r40 = 0.0d;
        int r7 = 0;
    L20:
        int r9 = 100000;
        double r44 = r2;
        if (r7 >= 100000) goto L26;
        double r20 = ((double) r7) + 0.5d;
        double r24 = r20 * r20;
        double r46 = (((r31 + r19) + (((r19 - r39) * 9.869604401089358d) * r24)) + ((((1.0d - r13) * 97.40909103400243d) * r24) * r24)) * FastMath.exp((r24 * (-9.869604401089358d)) / r13);
        r40 = r40 + r46;
        if (FastMath.abs(r46) < (FastMath.abs(r40) * 1.0E-10d)) goto L24;
        r7 = r7 + 1;
        r2 = r44;
        goto L20
    L24:
        r9 = 100000;
    L26:
        if (r7 == r9) goto L57;
        double r25 = 0.0d;
        int r27 = 1;
    L28:
        if (r27 >= r9) goto L33;
        double r110 = r27 * r27;
        double r32 = (r110 * 9.869604401089358d) * FastMath.exp((r110 * (-9.869604401089358d)) / r13);
        r25 = r25 + r32;
        if (FastMath.abs(r32) < (FastMath.abs(r25) * 1.0E-10d)) goto L31;
        r27 = r27 + 1;
        r9 = 100000;
        goto L28
    L31:
        r9 = 100000;
    L33:
        if (r27 == r9) goto L55;
        double r29 = r23 + ((r17 / r26) * ((r40 / ((((36.0d * r6) * r6) * r6) * r4)) - (r25 / ((18.0d * r6) * r4))));
        double r33 = 0.0d;
        int r34 = 100000;
        int r35 = 0;
    L35:
        if (r35 >= r34) goto L40;
        double r36 = ((double) r35) + 0.5d;
        double r37 = r36 * r36;
        double r111 = r37 * r37;
        double r310 = r50;
        double r311 = (((((((r111 * r37) * 961.3891935753043d) * (5.0d - (r6 * 30.0d))) + ((r111 * 97.40909103400243d) * (((-60.0d) * r6) + (212.0d * r8)))) + ((r37 * 9.869604401089358d) * ((135.0d * r8) - (96.0d * r28)))) - (r28 * 30.0d)) - (90.0d * r310)) * FastMath.exp((r37 * (-9.869604401089358d)) / r13);
        r33 = r33 + r311;
        if (FastMath.abs(r311) < (FastMath.abs(r33) * 1.0E-10d)) goto L38;
        r35 = r35 + 1;
        r50 = r310;
        r34 = 100000;
        goto L35
    L38:
        r34 = 100000;
    L40:
        if (r35 == r34) goto L53;
        int r41 = 1;
    L42:
        if (r41 >= r34) goto L47;
        double r42 = r41 * r41;
        double r112 = (((r42 * r42) * (-97.40909103400243d)) + ((29.608813203268074d * r42) * r6)) * FastMath.exp((r42 * (-9.869604401089358d)) / r13);
        r18 = r18 + r112;
        if (FastMath.abs(r112) < (FastMath.abs(r18) * 1.0E-10d)) goto L45;
        r41 = r41 + 1;
        r34 = 100000;
        goto L42
    L45:
        r34 = 100000;
    L47:
        if (r41 == r34) goto L51;
        return r29 + ((r17 / (r44 * r26)) * ((r33 / ((3240.0d * r28) * r8)) + (r18 / (108.0d * r28))));
    L51:
        throw new TooManyIterationsException(100000);
    L53:
        throw new TooManyIterationsException(Integer.valueOf(r34));
    L55:
        throw new TooManyIterationsException(Integer.valueOf(r9));
    L57:
        throw new TooManyIterationsException(Integer.valueOf(r9));
    L59:
        throw new TooManyIterationsException(Integer.valueOf(r5));
    L61:
        throw new TooManyIterationsException(Integer.valueOf(r5));
    L9:
        r26 = r0;
        r28 = r10;
        r5 = 100000;
        goto L10
    }

    private FieldMatrix<BigFraction> createExactH(double r11, int r13) throws NumberIsTooLargeException, FractionConversionException {
        double r0 = ((double) r13) * r11;
        int r10 = (int) Math.ceil(r0);
        int r12 = (r10 * 2) - 1;
        double r1 = ((double) r10) - r0;
        if (r1 >= 1.0d) goto L43;
        BigFraction r14 = new BigFraction(r1, KS_SUM_CAUCHY_CRITERION, 10000);     // Catch: FractionConversionException -> L6
    L9:
        BigFraction[][] r2 = (BigFraction[][]) Array.newInstance(BigFraction.class, new int[]{r12, r12});
        int r3 = 0;
    L10:
        if (r3 >= r12) goto L19;
        int r4 = 0;
    L12:
        if (r4 >= r12) goto L18;
        if (((r3 - r4) + 1) >= 0) goto L16;
        r2[r3][r4] = BigFraction.ZERO;
    L17:
        r4 = r4 + 1;
        goto L12
    L16:
        r2[r3][r4] = BigFraction.ONE;
        goto L17
    L18:
        r3 = r3 + 1;
        goto L10
    L19:
        BigFraction[] r5 = new BigFraction[r12];
        r5[0] = r14;
        int r6 = 1;
    L20:
        if (r6 >= r12) goto L22;
        r5[r6] = r14.multiply2(r5[r6 - 1]);
        r6 = r6 + 1;
        goto L20
    L22:
        int r7 = 0;
    L23:
        if (r7 >= r12) goto L26;
        BigFraction[] r8 = r2[r7];
        r8[0] = r8[0].subtract2(r5[r7]);
        BigFraction[] r9 = r2[r12 - 1];
        r9[r7] = r9[r7].subtract2(r5[(r12 - r7) - 1]);
        r7 = r7 + 1;
        goto L23
    L26:
        if (r14.compareTo2(BigFraction.ONE_HALF) != 1) goto L28;
        BigFraction[] r15 = r2[r12 - 1];
        r15[0] = r15[0].add2(r14.multiply2(2).subtract(1).pow(r12));
    L28:
        int r16 = 0;
    L29:
        if (r16 >= r12) goto L41;
        int r17 = 0;
    L31:
        int r18 = r16 + 1;
        if (r17 >= r18) goto L39;
        int r19 = (r16 - r17) + 1;
        if (r19 <= 0) goto L38;
        int r20 = 2;
    L36:
        if (r20 > r19) goto L38;
        BigFraction[] r21 = r2[r16];
        r21[r17] = r21[r17].divide(r20);
        r20 = r20 + 1;
    L38:
        r17 = r17 + 1;
        goto L31
    L39:
        r16 = r18;
        goto L29
    L41:
        return new Array2DRowFieldMatrix(BigFractionField.getInstance(), r2);
    L6:
        r14 = new BigFraction(r1, 1.0E-10d, 10000);     // Catch: FractionConversionException -> L8
    L8:
        r14 = new BigFraction(r1, 1.0E-5d, 10000);
        goto L9
    L43:
        throw new NumberIsTooLargeException(Double.valueOf(r1), Double.valueOf(1.0d), false);
    }

    private RealMatrix createRoundedH(double r13, int r15) throws NumberIsTooLargeException {
        double r0 = ((double) r15) * r13;
        int r12 = (int) Math.ceil(r0);
        int r14 = (r12 * 2) - 1;
        double r2 = ((double) r12) - r0;
        if (r2 >= 1.0d) goto L38;
        double[][] r4 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r14, r14});
        int r5 = 0;
    L5:
        if (r5 >= r14) goto L14;
        int r6 = 0;
    L7:
        if (r6 >= r14) goto L13;
        if (((r5 - r6) + 1) >= 0) goto L11;
        r4[r5][r6] = 0.0d;
    L12:
        r6 = r6 + 1;
        goto L7
    L11:
        r4[r5][r6] = 1.0d;
        goto L12
    L13:
        r5 = r5 + 1;
        goto L5
    L14:
        double[] r7 = new double[r14];
        r7[0] = r2;
        int r8 = 1;
    L15:
        if (r8 >= r14) goto L17;
        r7[r8] = r7[r8 - 1] * r2;
        r8 = r8 + 1;
        goto L15
    L17:
        int r9 = 0;
    L18:
        if (r9 >= r14) goto L21;
        double[] r10 = r4[r9];
        r10[0] = r10[0] - r7[r9];
        double[] r11 = r4[r14 - 1];
        r11[r9] = r11[r9] - r7[(r14 - r9) - 1];
        r9 = r9 + 1;
        goto L18
    L21:
        if (Double.compare(r2, 0.5d) <= 0) goto L23;
        double[] r16 = r4[r14 - 1];
        r16[0] = r16[0] + FastMath.pow((r2 * 2.0d) - 1.0d, r14);
    L23:
        int r1 = 0;
    L24:
        if (r1 >= r14) goto L36;
        int r3 = 0;
    L26:
        int r17 = r1 + 1;
        if (r3 >= r17) goto L34;
        int r18 = (r1 - r3) + 1;
        if (r18 <= 0) goto L33;
        int r19 = 2;
    L31:
        if (r19 > r18) goto L33;
        double[] r20 = r4[r1];
        r20[r3] = r20[r3] / ((double) r19);
        r19 = r19 + 1;
    L33:
        r3 = r3 + 1;
        goto L26
    L34:
        r1 = r17;
        goto L24
    L36:
        return MatrixUtils.createRealMatrix(r4);
    L38:
        throw new NumberIsTooLargeException(Double.valueOf(r2), Double.valueOf(1.0d), false);
    }

    private void checkArray(double[] r5) {
        if (r5 == null) goto L10;
        if (r5.length < 2) goto L8;
        return;
    L8:
        throw new InsufficientDataException(LocalizedFormats.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE, new Object[]{Integer.valueOf(r5.length), 2});
    L10:
        throw new NullArgumentException(LocalizedFormats.NULL_NOT_ALLOWED, new Object[0]);
    }

    public double ksSum(double r16, double r18, int r20) {
        if (r16 != 0.0d) goto L5;
        return 0.0d;
    L5:
        double r1 = ((-2.0d) * r16) * r16;
        double r6 = 0.5d;
        double r8 = 1.0d;
        long r10 = 1;
        int r12 = -1;
    L7:
        if (r8 <= r18) goto L12;
        if (r10 >= r20) goto L12;
        double r9 = r10;
        r8 = FastMath.exp((r1 * r9) * r9);
        r6 = r6 + (((double) r12) * r8);
        r12 = r12 * (-1);
        r10 = r10 + 1;
    L12:
        if (r10 == r20) goto L16;
        return r6 * 2.0d;
    L16:
        throw new TooManyIterationsException(Integer.valueOf(r20));
    }

    private static long calculateIntegralD(double r4, int r6, int r7, boolean r8) {
        double r0 = ((long) r6) * ((long) r7);
        long r2 = (long) FastMath.ceil((r4 - 1.0E-12d) * r0);
        long r5 = (long) FastMath.floor((r4 + 1.0E-12d) * r0);
        if (r8 == true) goto L5;
        return r2;
    L5:
        if (r5 == r2) goto L7;
        return r2;
    L7:
        return r2 + 1;
    }

    public double exactP(double r8, int r10, int r11, boolean r12) {
        return 1.0d - (n(r11, r10, r11, r10, calculateIntegralD(r8, r11, r10, r12), r12) / CombinatoricsUtils.binomialCoefficientDouble(r10 + r11, r11));
    }

    public double approximateP(double r7, int r9, int r10) {
        double r0 = r10;
        double r11 = r9;
        return 1.0d - ksSum(r7 * FastMath.sqrt((r0 * r11) / (r0 + r11)), KS_SUM_CAUCHY_CRITERION, 100000);
    }

    static void fillBooleanArrayRandomlyWithFixedNumberTrueValues(boolean[] r3, int r4, RandomGenerator r5) {
        Arrays.fill(r3, true);
    L4:
        if (r4 >= r3.length) goto L9;
        int r0 = r4 + 1;
        int r1 = r5.nextInt(r0);
        if (r3[r1] == false) goto L8;
        r4 = r1;
    L8:
        r3[r4] = false;
        r4 = r0;
        goto L4
    }

    public double monteCarloP(double r7, int r9, int r10, boolean r11, int r12) {
        return integralMonteCarloP(calculateIntegralD(r7, r9, r10, r11), r9, r10, r12);
    }

    private double integralMonteCarloP(long r11, int r13, int r14, int r15) {
        int r0 = FastMath.max(r13, r14);
        int r16 = FastMath.min(r13, r14);
        int r17 = r0 + r16;
        boolean[] r1 = new boolean[r17];
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r15) goto L17;
        fillBooleanArrayRandomlyWithFixedNumberTrueValues(r1, r0, this.rng);
        long r5 = 0;
        int r7 = 0;
    L5:
        if (r7 >= r17) goto L15;
        if (r1[r7] == false) goto L11;
        r5 = r5 + ((long) r16);
        if (r5 < r11) goto L14;
    L13:
        r4 = r4 + 1;
    L14:
        r7 = r7 + 1;
        goto L5
    L11:
        r5 = r5 - ((long) r0);
        if (r5 > (-r11)) goto L14;
    L15:
        r3 = r3 + 1;
        goto L3
    L17:
        return ((double) r4) / ((double) r15);
    }

    private static void fixTies(double[] r13, double[] r14) {
        int r1 = 0;
        double[] r0 = MathArrays.unique(MathArrays.concatenate(new double[][]{r13, r14}));
        if (r0.length != (r13.length + r14.length)) goto L5;
        return;
    L5:
        double r3 = r0[0];
        double r5 = 1.0d;
        int r7 = 1;
    L7:
        if (r7 >= r0.length) goto L12;
        double r8 = r0[r7];
        double r4 = r3 - r8;
        if (r4 >= r5) goto L11;
        r5 = r4;
    L11:
        r7 = r7 + 1;
        r3 = r8;
        goto L7
    L12:
        double r11 = r5 / 2.0d;
        UniformRealDistribution r2 = new UniformRealDistribution(new JDKRandomGenerator(100), -r11, r11);
    L13:
        jitter(r13, r2);
        jitter(r14, r2);
        boolean r6 = hasTies(r13, r14);
        r1 = r1 + 1;
        if (r6 == false) goto L17;
        if (r1 < 1000) goto L13;
    L17:
        if (r6 == true) goto L20;
        return;
    L20:
        throw new MathInternalError();
    }

    private static boolean hasTies(double[] r7, double[] r8) {
        HashSet r0 = new HashSet();
        int r2 = 0;
    L4:
        if (r2 >= r7.length) goto L9;
        if (r0.add(Double.valueOf(r7[r2])) == false) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        return true;
    L9:
        int r9 = 0;
    L11:
        if (r9 >= r8.length) goto L16;
        if (r0.add(Double.valueOf(r8[r9])) == false) goto L14;
        r9 = r9 + 1;
        goto L11
    L14:
        return true;
    L16:
        return false;
    }

    private static void jitter(double[] r5, RealDistribution r6) {
        int r0 = 0;
    L4:
        if (r0 >= r5.length) goto L6;
        r5[r0] = r5[r0] + r6.sample();
        r0 = r0 + 1;
        goto L4
    }

    private static int c(int r6, int r7, int r8, int r9, long r10, boolean r12) {
        if (r12 == false) goto L10;
        if (FastMath.abs((((long) r6) * ((long) r9)) - (((long) r7) * ((long) r8))) > r10) goto L8;
        return 1;
    L8:
        return 0;
    L10:
        if (FastMath.abs((((long) r6) * ((long) r9)) - (((long) r7) * ((long) r8))) >= r10) goto L13;
        return 1;
    L13:
        return 0;
    }

    private static double n(int r17, int r18, int r19, int r20, long r21, boolean r23) {
        double[] r8 = new double[r20];
        int r9 = 0;
    L3:
        if (r9 >= r20) goto L5;
        int r10 = r9 + 1;
        r8[r9] = c(0, r10, r19, r20, r21, r23);
        r9 = r10;
        goto L3
    L5:
        double r0 = 0.0d;
        int r11 = 1;
    L6:
        if (r11 > r17) goto L11;
        double r12 = c(r11, 0, r19, r20, r21, r23);
        int r15 = 1;
    L8:
        if (r15 > r18) goto L10;
        int r16 = r15 - 1;
        r12 = (r12 + r8[r16]) * c(r11, r15, r19, r20, r21, r23);
        r8[r16] = r12;
        r15 = r15 + 1;
        goto L8
    L10:
        r11 = r11 + 1;
        r0 = r12;
        goto L6
    L11:
        return r0;
    }
}
