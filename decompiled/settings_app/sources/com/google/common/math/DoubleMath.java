package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class DoubleMath {
    private static final double LN_2 = 0.0d;
    static final int MAX_FACTORIAL = 170;
    private static final double MAX_INT_AS_DOUBLE = 2.147483647E9d;
    private static final double MAX_LONG_AS_DOUBLE_PLUS_ONE = 9.223372036854776E18d;
    private static final double MIN_INT_AS_DOUBLE = -2.147483648E9d;
    private static final double MIN_LONG_AS_DOUBLE = -9.223372036854776E18d;
    static final double[] everySixteenthFactorial = null;

    /* JADX INFO: renamed from: com.google.common.math.DoubleMath$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode = null;

        static {
            int[] r0 = new int[RoundingMode.values().length];
            $SwitchMap$java$math$RoundingMode = r0;
            r0[RoundingMode.UNNECESSARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    static double roundIntermediate(double r6, RoundingMode r8) {
        if (DoubleUtils.isFinite(r6) == false) goto L45;
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r8.ordinal()]) {
            case 1: goto L42;
            case 2: goto L36;
            case 3: goto L29;
            case 4: goto L46;
            case 5: goto L20;
            case 6: goto L18;
            case 7: goto L12;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        double r0 = Math.rint(r6);
        if (Math.abs(r6 - r0) != 0.5d) goto L11;
        return r6;
    L11:
        return r0;
    L12:
        double r1 = Math.rint(r6);
        if (Math.abs(r6 - r1) == 0.5d) goto L15;
        return r1;
    L15:
        return r6 + Math.copySign(0.5d, r6);
    L42:
        MathPreconditions.checkRoundingUnnecessary(isMathematicalInteger(r6));
        return r6;
    L46:
        return r6;
    L7:
        throw new AssertionError();
    L18:
        return Math.rint(r6);
    L20:
        if (isMathematicalInteger(r6) == false) goto L22;
        return r6;
    L22:
        long r2 = (long) r6;
        if (r6 <= 0.0d) goto L25;
        int r7 = 1;
    L27:
        return r2 + ((long) r7);
    L25:
        r7 = -1;
        goto L27
    L29:
        if (r6 > 0.0d) goto L31;
        return r6;
    L31:
        if (isMathematicalInteger(r6) == false) goto L34;
        return r6;
    L34:
        return ((long) r6) + 1;
    L36:
        if (r6 < 0.0d) goto L38;
        return r6;
    L38:
        if (isMathematicalInteger(r6) == false) goto L41;
        return r6;
    L41:
        return ((long) r6) - 1;
    L45:
        throw new ArithmeticException("input is infinite or NaN");
    }

    public static int roundToInt(double r7, RoundingMode r9) {
        double r0 = roundIntermediate(r7, r9);
        boolean r3 = true;
        if (r0 <= (-2.147483649E9d)) goto L5;
        boolean r2 = true;
    L7:
        if (r0 < 2.147483648E9d) goto L10;
        r3 = false;
    L10:
        MathPreconditions.checkInRangeForRoundingInputs(r2 & r3, r7, r9);
        return (int) r0;
    L5:
        r2 = false;
        goto L7
    }

    public static long roundToLong(double r7, RoundingMode r9) {
        double r0 = roundIntermediate(r7, r9);
        boolean r3 = true;
        if ((MIN_LONG_AS_DOUBLE - r0) >= 1.0d) goto L5;
        boolean r2 = true;
    L7:
        if (r0 < MAX_LONG_AS_DOUBLE_PLUS_ONE) goto L10;
        r3 = false;
    L10:
        MathPreconditions.checkInRangeForRoundingInputs(r2 & r3, r7, r9);
        return (long) r0;
    L5:
        r2 = false;
        goto L7
    }

    public static BigInteger roundToBigInteger(double r4, RoundingMode r6) {
        double r5 = roundIntermediate(r4, r6);
        boolean r0 = true;
        if ((MIN_LONG_AS_DOUBLE - r5) >= 1.0d) goto L5;
        boolean r7 = true;
    L7:
        if (r5 < MAX_LONG_AS_DOUBLE_PLUS_ONE) goto L11;
        r0 = false;
    L11:
        if ((r7 & r0) == true) goto L13;
        BigInteger r8 = BigInteger.valueOf(DoubleUtils.getSignificand(r5)).shiftLeft(Math.getExponent(r5) - 52);
        if (r5 < 0.0d) goto L17;
        return r8;
    L17:
        return r8.negate();
    L13:
        return BigInteger.valueOf((long) r5);
    L5:
        r7 = false;
        goto L7
    }

    public static boolean isPowerOfTwo(double r4) {
        if (r4 > 0.0d) goto L5;
        return false;
    L5:
        if (DoubleUtils.isFinite(r4) == false) goto L11;
        long r5 = DoubleUtils.getSignificand(r4);
        if ((r5 & (r5 - 1)) != 0) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    public static double log2(double r2) {
        return Math.log(r2) / LN_2;
    }

    public static int log2(double r5, RoundingMode r7) {
        boolean r1 = false;
        if (r5 > 0.0d) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Preconditions.checkArgument(r0, "x must be positive and finite");
        int r2 = Math.getExponent(r5);
        if (DoubleUtils.isNormal(r5) == true) goto L13;
        return log2(r5 * 4.503599627370496E15d, r7) - 52;
    L13:
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r7.ordinal()]) {
            case 1: goto L27;
            case 2: goto L28;
            case 3: goto L26;
            case 4: goto L22;
            case 5: goto L19;
            case 6: goto L16;
            case 7: goto L16;
            case 8: goto L16;
            default: goto L15;
        };
    L16:
        double r6 = DoubleUtils.scaleNormalize(r5);
        if ((r6 * r6) <= 2.0d) goto L28;
        r1 = true;
        goto L28
    L19:
        if (r2 < 0) goto L21;
        r1 = true;
    L21:
        boolean r8 = isPowerOfTwo(r5);
    L25:
        r1 = r1 & (!r8);
        goto L28
    L22:
        if (r2 >= 0) goto L24;
        r1 = true;
    L24:
        r8 = isPowerOfTwo(r5);
        goto L25
    L26:
        r1 = !isPowerOfTwo(r5);
        goto L28
    L27:
        MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(r5));
    L28:
        if (r1 == true) goto L30;
        return r2;
    L30:
        return r2 + 1;
    L15:
        throw new AssertionError();
    L5:
        if (DoubleUtils.isFinite(r5) == false) goto L7;
        r0 = true;
        goto L8
    }

    static {
        LN_2 = Math.log(2.0d);
        everySixteenthFactorial = new double[]{1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};
    }

    public static boolean isMathematicalInteger(double r2) {
        if (DoubleUtils.isFinite(r2) == true) goto L5;
    L9:
        return false;
    L5:
        if (r2 != 0.0d) goto L7;
    L8:
        return true;
    L7:
        if ((52 - Long.numberOfTrailingZeros(DoubleUtils.getSignificand(r2))) > Math.getExponent(r2)) goto L9;
        goto L8
    }

    public static double factorial(int r5) {
        MathPreconditions.checkNonNegative("n", r5);
        if (r5 <= 170) goto L6;
        return Double.POSITIVE_INFINITY;
    L6:
        int r0 = (r5 & (-16)) + 1;
        double r1 = 1.0d;
    L7:
        if (r0 > r5) goto L10;
        r1 = r1 * ((double) r0);
        r0 = r0 + 1;
        goto L7
    L10:
        return r1 * everySixteenthFactorial[r5 >> 4];
    }

    public static boolean fuzzyEquals(double r4, double r6, double r8) {
        MathPreconditions.checkNonNegative("tolerance", r8);
        if (Math.copySign(r4 - r6, 1.0d) > r8) goto L5;
    L12:
        return true;
    L5:
        if (r4 == r6) goto L12;
        if (Double.isNaN(r4) == true) goto L9;
    L11:
        return false;
    L9:
        if (Double.isNaN(r6) == false) goto L11;
        goto L11
    }

    public static int fuzzyCompare(double r0, double r2, double r4) {
        if (fuzzyEquals(r0, r2, r4) == false) goto L7;
        return 0;
    L7:
        if (r0 >= r2) goto L11;
        return -1;
    L11:
        if (r0 <= r2) goto L15;
        return 1;
    L15:
        return Booleans.compare(Double.isNaN(r0), Double.isNaN(r2));
    }

    @Deprecated
    public static double mean(double... r11) {
        int r2 = 1;
        if (r11.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "Cannot take mean of 0 values");
        double r1 = checkFinite(r11[0]);
        long r5 = 1;
    L8:
        if (r2 >= r11.length) goto L10;
        checkFinite(r11[r2]);
        r5 = r5 + 1;
        r1 = r1 + ((r11[r2] - r1) / r5);
        r2 = r2 + 1;
        goto L8
    L10:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    @Deprecated
    public static double mean(int... r6) {
        int r1 = 0;
        if (r6.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "Cannot take mean of 0 values");
        long r2 = 0;
    L8:
        if (r1 >= r6.length) goto L11;
        r2 = r2 + ((long) r6[r1]);
        r1 = r1 + 1;
        goto L8
    L11:
        return r2 / ((double) r6.length);
    L5:
        r0 = false;
        goto L6
    }

    @Deprecated
    public static double mean(long... r11) {
        int r2 = 1;
        if (r11.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "Cannot take mean of 0 values");
        double r1 = r11[0];
        long r5 = 1;
    L8:
        if (r2 >= r11.length) goto L10;
        r5 = r5 + 1;
        r1 = r1 + ((r11[r2] - r1) / r5);
        r2 = r2 + 1;
        goto L8
    L10:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    @Deprecated
    public static double mean(Iterable<? extends Number> r2) {
        return mean(r2.iterator());
    }

    @Deprecated
    public static double mean(Iterator<? extends Number> r10) {
        Preconditions.checkArgument(r10.hasNext(), "Cannot take mean of 0 values");
        double r0 = checkFinite(r10.next().doubleValue());
        long r4 = 1;
    L4:
        if (r10.hasNext() == false) goto L6;
        r4 = r4 + 1;
        r0 = r0 + ((checkFinite(r10.next().doubleValue()) - r0) / r4);
        goto L4
    L6:
        return r0;
    }

    private static double checkFinite(double r1) {
        Preconditions.checkArgument(DoubleUtils.isFinite(r1));
        return r1;
    }

    private DoubleMath() {
    }
}
