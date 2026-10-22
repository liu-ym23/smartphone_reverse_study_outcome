package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.math.RoundingMode;
import org.apache.commons.math3.distribution.PoissonDistribution;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class IntMath {
    static final int FLOOR_SQRT_MAX_INT = 46340;
    static final int MAX_POWER_OF_SQRT2_UNSIGNED = -1257966797;
    static final int MAX_SIGNED_POWER_OF_TWO = 1073741824;
    static int[] biggestBinomials;
    private static final int[] factorials = null;
    static final int[] halfPowersOf10 = null;
    static final byte[] maxLog10ForLeadingZeros = null;
    static final int[] powersOf10 = null;

    /* JADX INFO: renamed from: com.google.common.math.IntMath$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode = null;

        static {
            int[] r0 = new int[RoundingMode.values().length];
            $SwitchMap$java$math$RoundingMode = r0;
            r0[RoundingMode.UNNECESSARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public static boolean isPowerOfTwo(int r4) {
        boolean r0 = false;
        if (r4 <= 0) goto L5;
        boolean r2 = true;
    L7:
        if ((r4 & (r4 - 1)) != 0) goto L10;
        r0 = true;
    L10:
        return r2 & r0;
    L5:
        r2 = false;
        goto L7
    }

    static int lessThanBranchFree(int r0, int r1) {
        return (~(~(r0 - r1))) >>> 31;
    }

    public static int mean(int r1, int r2) {
        return (r1 & r2) + ((r1 ^ r2) >> 1);
    }

    public static int ceilingPowerOfTwo(int r3) {
        MathPreconditions.checkPositive(MaterialConfigFormatNames.X, r3);
        if (r3 > 1073741824) goto L7;
        return 1 << (-Integer.numberOfLeadingZeros(r3 - 1));
    L7:
        throw new ArithmeticException(new StringBuilder(58).append("ceilingPowerOfTwo(").append(r3).append(") not representable as an int").toString());
    }

    public static int floorPowerOfTwo(int r1) {
        MathPreconditions.checkPositive(MaterialConfigFormatNames.X, r1);
        return Integer.highestOneBit(r1);
    }

    public static int log2(int r1, RoundingMode r2) {
        MathPreconditions.checkPositive(MaterialConfigFormatNames.X, r1);
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r2.ordinal()]) {
            case 1: goto L10;
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        int r3 = Integer.numberOfLeadingZeros(r1);
        return (31 - r3) + lessThanBranchFree(MAX_POWER_OF_SQRT2_UNSIGNED >>> r3, r1);
    L10:
        MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(r1));
        goto L12
    L5:
        throw new AssertionError();
    L9:
        return 32 - Integer.numberOfLeadingZeros(r1 - 1);
    L12:
        return 31 - Integer.numberOfLeadingZeros(r1);
    }

    public static int log10(int r3, RoundingMode r4) {
        MathPreconditions.checkPositive(MaterialConfigFormatNames.X, r3);
        int r0 = log10Floor(r3);
        int r1 = powersOf10[r0];
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r4.ordinal()]) {
            case 1: goto L10;
            case 2: goto L14;
            case 3: goto L14;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        int r5 = lessThanBranchFree(halfPowersOf10[r0], r3);
    L8:
        return r0 + r5;
    L9:
        r5 = lessThanBranchFree(r1, r3);
        goto L8
    L10:
        if (r3 != r1) goto L12;
        boolean r6 = true;
    L13:
        MathPreconditions.checkRoundingUnnecessary(r6);
        goto L14
    L12:
        r6 = false;
    L14:
        return r0;
    L5:
        throw new AssertionError();
    }

    private static int log10Floor(int r2) {
        byte r0 = maxLog10ForLeadingZeros[Integer.numberOfLeadingZeros(r2)];
        return r0 - lessThanBranchFree(r2, powersOf10[r0]);
    }

    static {
        maxLog10ForLeadingZeros = new byte[]{9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};
        powersOf10 = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000, PoissonDistribution.DEFAULT_MAX_ITERATIONS, 100000000, 1000000000};
        halfPowersOf10 = new int[]{3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};
        factorials = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
        biggestBinomials = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};
    }

    public static int pow(int r4, int r5) {
        MathPreconditions.checkNonNegative("exponent", r5);
        if (r4 != (-2)) goto L5;
        if (r5 < 32) goto L35;
        return 0;
    L35:
        if ((r5 & 1) != 0) goto L38;
        return 1 << r5;
    L38:
        return -(1 << r5);
    L5:
        if (r4 == (-1)) goto L29;
        if (r4 == 0) goto L25;
        if (r4 != 1) goto L9;
        return 1;
    L9:
        if (r4 == 2) goto L21;
        int r0 = 1;
    L11:
        if (r5 == 0) goto L20;
        if (r5 == 1) goto L19;
        if ((r5 & 1) != 0) goto L16;
        int r1 = 1;
    L17:
        r0 = r0 * r1;
        r4 = r4 * r4;
        r5 = r5 >> 1;
        goto L11
    L16:
        r1 = r4;
        goto L17
    L19:
        return r4 * r0;
    L20:
        return r0;
    L21:
        if (r5 < 32) goto L23;
        return 0;
    L23:
        return 1 << r5;
    L25:
        if (r5 == 0) goto L27;
        return 0;
    L27:
        return 1;
    L29:
        if ((r5 & 1) != 0) goto L32;
        return 1;
    L32:
        return -1;
    }

    public static int sqrt(int r2, RoundingMode r3) {
        MathPreconditions.checkNonNegative(MaterialConfigFormatNames.X, r2);
        int r0 = sqrtFloor(r2);
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r3.ordinal()]) {
            case 1: goto L11;
            case 2: goto L15;
            case 3: goto L15;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        int r4 = lessThanBranchFree((r0 * r0) + r0, r2);
    L8:
        return r0 + r4;
    L9:
        r4 = lessThanBranchFree(r0 * r0, r2);
    L15:
        return r0;
    L5:
        throw new AssertionError();
    L11:
        if ((r0 * r0) != r2) goto L13;
        boolean r5 = true;
    L14:
        MathPreconditions.checkRoundingUnnecessary(r5);
        goto L15
    L13:
        r5 = false;
        goto L14
    }

    private static int sqrtFloor(int r2) {
        return (int) Math.sqrt(r2);
    }

    public static int divide(int r5, int r6, RoundingMode r7) {
        Preconditions.checkNotNull(r7);
        if (r6 == 0) goto L41;
        int r0 = r5 / r6;
        int r1 = r5 - (r6 * r0);
        if (r1 != 0) goto L7;
        return r0;
    L7:
        boolean r2 = true;
        int r8 = ((r5 ^ r6) >> 31) | 1;
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r7.ordinal()]) {
            case 1: goto L32;
            case 2: goto L36;
            case 3: goto L30;
            case 4: goto L37;
            case 5: goto L28;
            case 6: goto L11;
            case 7: goto L11;
            case 8: goto L11;
            default: goto L10;
        };
    L11:
        int r3 = Math.abs(r1);
        int r4 = r3 - (Math.abs(r6) - r3);
        if (r4 == 0) goto L14;
        if (r4 <= 0) goto L36;
    L14:
        if (r7 == RoundingMode.HALF_UP) goto L37;
        if (r7 != RoundingMode.HALF_EVEN) goto L18;
        boolean r9 = true;
    L20:
        if ((r0 & 1) == 0) goto L22;
        boolean r10 = true;
    L24:
        if ((r9 & r10) == false) goto L36;
    L22:
        r10 = false;
        goto L24
    L18:
        r9 = false;
        goto L20
    L28:
        if (r8 <= 0) goto L36;
    L30:
        if (r8 >= 0) goto L36;
    L32:
        if (r1 == 0) goto L35;
        r2 = false;
    L35:
        MathPreconditions.checkRoundingUnnecessary(r2);
    L36:
        r2 = false;
    L37:
        if (r2 == true) goto L39;
        return r0;
    L39:
        return r0 + r8;
    L10:
        throw new AssertionError();
    L41:
        throw new ArithmeticException("/ by zero");
    }

    public static int mod(int r2, int r3) {
        if (r3 <= 0) goto L9;
        int r4 = r2 % r3;
        if (r4 < 0) goto L7;
        return r4;
    L7:
        return r4 + r3;
    L9:
        throw new ArithmeticException(new StringBuilder(31).append("Modulus ").append(r3).append(" must be > 0").toString());
    }

    public static int gcd(int r3, int r4) {
        MathPreconditions.checkNonNegative("a", r3);
        MathPreconditions.checkNonNegative("b", r4);
        if (r3 != 0) goto L5;
        return r4;
    L5:
        if (r4 != 0) goto L7;
        return r3;
    L7:
        int r0 = Integer.numberOfTrailingZeros(r3);
        int r5 = r3 >> r0;
        int r1 = Integer.numberOfTrailingZeros(r4);
        int r6 = r4 >> r1;
    L8:
        if (r5 == r6) goto L11;
        int r7 = r5 - r6;
        int r2 = (r7 >> 31) & r7;
        int r8 = (r7 - r2) - r2;
        r6 = r6 + r2;
        r5 = r8 >> Integer.numberOfTrailingZeros(r8);
        goto L8
    L11:
        return r5 << Math.min(r0, r1);
    }

    public static int checkedAdd(int r5, int r6) {
        long r0 = ((long) r5) + ((long) r6);
        int r2 = (int) r0;
        if (r0 != r2) goto L5;
        boolean r1 = true;
    L6:
        MathPreconditions.checkNoOverflow(r1, "checkedAdd", r5, r6);
        return r2;
    L5:
        r1 = false;
        goto L6
    }

    public static int checkedSubtract(int r5, int r6) {
        long r0 = ((long) r5) - ((long) r6);
        int r2 = (int) r0;
        if (r0 != r2) goto L5;
        boolean r1 = true;
    L6:
        MathPreconditions.checkNoOverflow(r1, "checkedSubtract", r5, r6);
        return r2;
    L5:
        r1 = false;
        goto L6
    }

    public static int checkedMultiply(int r5, int r6) {
        long r0 = ((long) r5) * ((long) r6);
        int r2 = (int) r0;
        if (r0 != r2) goto L5;
        boolean r1 = true;
    L6:
        MathPreconditions.checkNoOverflow(r1, "checkedMultiply", r5, r6);
        return r2;
    L5:
        r1 = false;
        goto L6
    }

    public static int checkedPow(int r6, int r7) {
        MathPreconditions.checkNonNegative("exponent", r7);
        boolean r3 = false;
        if (r6 == (-2)) goto L43;
        if (r6 == (-1)) goto L39;
        if (r6 == 0) goto L35;
        if (r6 != 1) goto L8;
        return 1;
    L8:
        if (r6 == 2) goto L30;
        int r0 = 1;
    L10:
        if (r7 == 0) goto L28;
        if (r7 == 1) goto L27;
        if ((r7 & 1) == 0) goto L15;
        r0 = checkedMultiply(r0, r6);
    L15:
        r7 = r7 >> 1;
        if (r7 <= 0) goto L10;
        if ((-46340) > r6) goto L20;
        boolean r2 = true;
    L22:
        if (r6 > FLOOR_SQRT_MAX_INT) goto L24;
        boolean r5 = true;
    L25:
        MathPreconditions.checkNoOverflow(r2 & r5, "checkedPow", r6, r7);
        r6 = r6 * r6;
        goto L10
    L24:
        r5 = false;
        goto L25
    L20:
        r2 = false;
        goto L22
    L27:
        return checkedMultiply(r0, r6);
    L28:
        return r0;
    L30:
        if (r7 >= 31) goto L32;
        r3 = true;
    L32:
        MathPreconditions.checkNoOverflow(r3, "checkedPow", r6, r7);
        return 1 << r7;
    L35:
        if (r7 == 0) goto L37;
        return 0;
    L37:
        return 1;
    L39:
        if ((r7 & 1) == 0) goto L41;
        return -1;
    L41:
        return 1;
    L43:
        if (r7 >= 32) goto L45;
        r3 = true;
    L45:
        MathPreconditions.checkNoOverflow(r3, "checkedPow", r6, r7);
        if ((r7 & 1) != 0) goto L49;
        return 1 << r7;
    L49:
        return (-1) << r7;
    }

    public static int saturatedAdd(int r2, int r3) {
        return Ints.saturatedCast(((long) r2) + ((long) r3));
    }

    public static int saturatedSubtract(int r2, int r3) {
        return Ints.saturatedCast(((long) r2) - ((long) r3));
    }

    public static int saturatedMultiply(int r2, int r3) {
        return Ints.saturatedCast(((long) r2) * ((long) r3));
    }

    public static int saturatedPow(int r6, int r7) {
        MathPreconditions.checkNonNegative("exponent", r7);
        if (r6 == (-2)) goto L48;
        if (r6 == (-1)) goto L44;
        if (r6 == 0) goto L39;
        if (r6 != 1) goto L9;
        return 1;
    L9:
        if (r6 == 2) goto L34;
        int r2 = ((r6 >>> 31) & (r7 & 1)) + Integer.MAX_VALUE;
        int r1 = 1;
    L11:
        if (r7 == 0) goto L32;
        if (r7 == 1) goto L31;
        if ((r7 & 1) == 0) goto L16;
        r1 = saturatedMultiply(r1, r6);
    L16:
        r7 = r7 >> 1;
        if (r7 <= 0) goto L11;
        if ((-46340) <= r6) goto L21;
        boolean r4 = true;
    L23:
        if (r6 <= FLOOR_SQRT_MAX_INT) goto L25;
        boolean r5 = true;
    L27:
        if ((r4 | r5) == true) goto L28;
        r6 = r6 * r6;
        goto L11
    L28:
        return r2;
    L25:
        r5 = false;
        goto L27
    L21:
        r4 = false;
        goto L23
    L31:
        return saturatedMultiply(r1, r6);
    L32:
        return r1;
    L34:
        if (r7 < 31) goto L37;
        return Integer.MAX_VALUE;
    L37:
        return 1 << r7;
    L39:
        if (r7 != 0) goto L42;
        return 1;
    L42:
        return 0;
    L44:
        if ((r7 & 1) == 0) goto L46;
        return -1;
    L46:
        return 1;
    L48:
        if (r7 < 32) goto L52;
        return (r7 & 1) + Integer.MAX_VALUE;
    L52:
        if ((r7 & 1) != 0) goto L55;
        return 1 << r7;
    L55:
        return (-1) << r7;
    }

    public static int factorial(int r2) {
        MathPreconditions.checkNonNegative("n", r2);
        int[] r0 = factorials;
        if (r2 < r0.length) goto L7;
        return Integer.MAX_VALUE;
    L7:
        return r0[r2];
    }

    public static int binomial(int r5, int r6) {
        MathPreconditions.checkNonNegative("n", r5);
        MathPreconditions.checkNonNegative("k", r6);
        int r0 = 0;
        if (r6 > r5) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2, "k (%s) > n (%s)", r6, r5);
        if (r6 <= (r5 >> 1)) goto L9;
        r6 = r5 - r6;
    L9:
        int[] r3 = biggestBinomials;
        if (r6 < r3.length) goto L12;
        return Integer.MAX_VALUE;
    L12:
        if (r5 > r3[r6]) goto L26;
        if (r6 == 0) goto L21;
        if (r6 == 1) goto L25;
        long r1 = 1;
    L17:
        if (r0 >= r6) goto L20;
        long r4 = r1 * ((long) (r5 - r0));
        r0 = r0 + 1;
        r1 = r4 / ((long) r0);
        goto L17
    L20:
        return (int) r1;
    L25:
        return r5;
    L21:
        return 1;
    L26:
        return Integer.MAX_VALUE;
    L5:
        r2 = false;
        goto L6
    }

    public static boolean isPrime(int r2) {
        return LongMath.isPrime(r2);
    }

    private IntMath() {
    }
}
