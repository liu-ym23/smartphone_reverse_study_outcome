package com.google.common.math;

import android.icu.lang.UCharacter;
import com.bytedance.sysoptimizer.StackLeakChecker;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.math.RoundingMode;
import okhttp3.internal.connection.RealConnection;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class LongMath {
    static final long FLOOR_SQRT_MAX_LONG = 3037000499L;
    static final long MAX_POWER_OF_SQRT2_UNSIGNED = -5402926248376769404L;
    static final long MAX_SIGNED_POWER_OF_TWO = 4611686018427387904L;
    private static final int SIEVE_30 = -545925251;
    static final int[] biggestBinomials = null;
    static final int[] biggestSimpleBinomials = null;
    static final long[] factorials = null;
    static final long[] halfPowersOf10 = null;
    static final byte[] maxLog10ForLeadingZeros = null;
    private static final long[][] millerRabinBaseSets = null;
    static final long[] powersOf10 = null;

    /* JADX INFO: renamed from: com.google.common.math.LongMath$1, reason: invalid class name */
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

    private static abstract enum MillerRabinTester extends Enum<MillerRabinTester> {
        private static final /* synthetic */ MillerRabinTester[] $VALUES = null;
        public static final MillerRabinTester LARGE = null;
        public static final MillerRabinTester SMALL = null;

        abstract long mulMod(long r1, long r3, long r5);

        abstract long squareMod(long r1, long r3);

        private static /* synthetic */ MillerRabinTester[] $values() {
            return new MillerRabinTester[]{SMALL, LARGE};
        }

        private MillerRabinTester(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ MillerRabinTester(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static MillerRabinTester valueOf(String r1) {
            return (MillerRabinTester) Enum.valueOf(MillerRabinTester.class, r1);
        }

        public static MillerRabinTester[] values() {
            return (MillerRabinTester[]) $VALUES.clone();
        }

        static {
            final String r1 = "SMALL";
            final int r2 = 0;
            SMALL = new AnonymousClass1(r1, r2);
            final String r3 = "LARGE";
            final int r4 = 1;
            LARGE = new AnonymousClass2(r3, r4);
            $VALUES = $values();
        }

        static boolean test(long r2, long r4) {
            if (r4 > LongMath.FLOOR_SQRT_MAX_LONG) goto L5;
            MillerRabinTester r0 = SMALL;
        L7:
            return r0.testWitness(r2, r4);
        L5:
            r0 = LARGE;
            goto L7
        }

        private long powMod(long r10, long r12, long r14) {
            long r3 = 1;
        L4:
            if (r12 == 0) goto L9;
            if ((r12 & 1) == 0) goto L8;
            r3 = mulMod(r3, r10, r14);
        L8:
            r10 = squareMod(r10, r14);
            r12 = r12 >> 1;
            goto L4
        L9:
            return r3;
        }

        private boolean testWitness(long r16, long r18) {
            long r11 = r18 - 1;
            int r13 = Long.numberOfTrailingZeros(r11);
            long r3 = r11 >> r13;
            long r1 = r16 % r18;
            if (r1 != 0) goto L5;
            return true;
        L5:
            long r0 = powMod(r1, r3, r18);
            if (r0 != 1) goto L8;
            return true;
        L8:
            int r4 = 0;
        L10:
            if (r0 == r11) goto L15;
            r4 = r4 + 1;
            if (r4 == r13) goto L13;
            r0 = squareMod(r0, r18);
            goto L10
        L13:
            return false;
        L15:
            return true;
        }
    }

    static boolean fitsInInt(long r2) {
        if (((int) r2) != r2) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isPowerOfTwo(long r7) {
        boolean r3 = true;
        if (r7 <= 0) goto L5;
        boolean r2 = true;
    L7:
        if ((r7 & (r7 - 1)) == 0) goto L11;
        r3 = false;
    L11:
        return r2 & r3;
    L5:
        r2 = false;
        goto L7
    }

    static int lessThanBranchFree(long r0, long r2) {
        return (int) ((~(~(r0 - r2))) >>> 63);
    }

    public static long mean(long r2, long r4) {
        return (r2 & r4) + ((r2 ^ r4) >> 1);
    }

    public static long saturatedAdd(long r5, long r7) {
        long r0 = r5 + r7;
        boolean r8 = true;
        if ((r7 ^ r5) >= 0) goto L5;
        boolean r9 = true;
    L7:
        if ((r5 ^ r0) >= 0) goto L11;
        r8 = false;
    L11:
        if ((r9 | r8) == false) goto L14;
        return r0;
    L14:
        return ((r0 >>> 63) ^ 1) + Long.MAX_VALUE;
    L5:
        r9 = false;
        goto L7
    }

    public static long saturatedSubtract(long r5, long r7) {
        long r0 = r5 - r7;
        boolean r8 = true;
        if ((r7 ^ r5) < 0) goto L5;
        boolean r9 = true;
    L7:
        if ((r5 ^ r0) >= 0) goto L11;
        r8 = false;
    L11:
        if ((r9 | r8) == false) goto L14;
        return r0;
    L14:
        return ((r0 >>> 63) ^ 1) + Long.MAX_VALUE;
    L5:
        r9 = false;
        goto L7
    }

    public static long ceilingPowerOfTwo(long r3) {
        MathPreconditions.checkPositive(MaterialConfigFormatNames.X, r3);
        if (r3 > 4611686018427387904L) goto L7;
        return 1 << (-Long.numberOfLeadingZeros(r3 - 1));
    L7:
        throw new ArithmeticException(new StringBuilder(70).append("ceilingPowerOfTwo(").append(r3).append(") is not representable as a long").toString());
    }

    public static long floorPowerOfTwo(long r2) {
        MathPreconditions.checkPositive(MaterialConfigFormatNames.X, r2);
        return 1 << (63 - Long.numberOfLeadingZeros(r2));
    }

    public static int log2(long r2, RoundingMode r4) {
        MathPreconditions.checkPositive(MaterialConfigFormatNames.X, r2);
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r4.ordinal()]) {
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
        int r5 = Long.numberOfLeadingZeros(r2);
        long r0 = MAX_POWER_OF_SQRT2_UNSIGNED >>> r5;
        return (63 - r5) + lessThanBranchFree(r0, r2);
    L10:
        MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(r2));
        goto L12
    L5:
        throw new AssertionError("impossible");
    L9:
        return 64 - Long.numberOfLeadingZeros(r2 - 1);
    L12:
        return 63 - Long.numberOfLeadingZeros(r2);
    }

    public static int log10(long r4, RoundingMode r6) {
        MathPreconditions.checkPositive(MaterialConfigFormatNames.X, r4);
        int r0 = log10Floor(r4);
        long r1 = powersOf10[r0];
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r6.ordinal()]) {
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
        int r5 = lessThanBranchFree(halfPowersOf10[r0], r4);
    L8:
        return r0 + r5;
    L9:
        r5 = lessThanBranchFree(r1, r4);
    L15:
        return r0;
    L5:
        throw new AssertionError();
    L11:
        if (r4 != r1) goto L13;
        boolean r7 = true;
    L14:
        MathPreconditions.checkRoundingUnnecessary(r7);
        goto L15
    L13:
        r7 = false;
        goto L14
    }

    static int log10Floor(long r3) {
        byte r0 = maxLog10ForLeadingZeros[Long.numberOfLeadingZeros(r3)];
        return r0 - lessThanBranchFree(r3, powersOf10[r0]);
    }

    static {
        maxLog10ForLeadingZeros = new byte[]{19, 18, 18, 18, 18, 17, 17, 17, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};
        powersOf10 = new long[]{1, 10, 100, 1000, 10000, 100000, 1000000, StackLeakChecker.CHECK_INTERVAL_10_SEC, 100000000, 1000000000, RealConnection.IDLE_CONNECTION_HEALTHY_NS, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};
        halfPowersOf10 = new long[]{3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};
        factorials = new long[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
        biggestBinomials = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, UCharacter.UnicodeBlock.CYRILLIC_EXTENDED_C_ID, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};
        biggestSimpleBinomials = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, 419, UCharacter.UnicodeBlock.MAKASAR_ID, UCharacter.UnicodeBlock.MEROITIC_CURSIVE_ID, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};
        millerRabinBaseSets = new long[][]{new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};
    }

    public static long pow(long r8, int r10) {
        MathPreconditions.checkNonNegative("exponent", r10);
        if ((-2) <= r8) goto L5;
    L36:
        long r4 = 1;
    L37:
        if (r10 == 0) goto L54;
        if (r10 == 1) goto L45;
        if ((r10 & 1) != 0) goto L42;
        long r6 = 1;
    L43:
        r4 = r4 * r6;
        r8 = r8 * r8;
        r10 = r10 >> 1;
        goto L37
    L42:
        r6 = r8;
        goto L43
    L45:
        return r4 * r8;
    L54:
        return r4;
    L5:
        if (r8 > 2) goto L36;
        int r9 = (int) r8;
        if (r9 != (-2)) goto L9;
        if (r10 < 64) goto L31;
        return 0;
    L31:
        if ((r10 & 1) != 0) goto L34;
        return 1 << r10;
    L34:
        return -(1 << r10);
    L9:
        if (r9 == (-1)) goto L25;
        if (r9 == 0) goto L20;
        if (r9 != 1) goto L13;
        return 1;
    L13:
        if (r9 != 2) goto L18;
        if (r10 < 64) goto L16;
        return 0;
    L16:
        return 1 << r10;
    L18:
        throw new AssertionError();
    L20:
        if (r10 != 0) goto L23;
        return 1;
    L23:
        return 0;
    L25:
        if ((r10 & 1) == 0) goto L52;
        return -1;
    L52:
        return 1;
    }

    public static long sqrt(long r8, RoundingMode r10) {
        MathPreconditions.checkNonNegative(MaterialConfigFormatNames.X, r8);
        if (fitsInInt(r8) == true) goto L5;
        long r0 = (long) Math.sqrt(r8);
        long r2 = r0 * r0;
        boolean r6 = true;
        int r7 = 1;
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r10.ordinal()]) {
            case 1: goto L25;
            case 2: goto L21;
            case 3: goto L21;
            case 4: goto L17;
            case 5: goto L17;
            case 6: goto L11;
            case 7: goto L11;
            case 8: goto L11;
            default: goto L9;
        };
    L9:
        throw new AssertionError();
    L11:
        if (r8 < r2) goto L14;
        r7 = 0;
    L14:
        long r1 = r0 - ((long) r7);
        return r1 + ((long) lessThanBranchFree((r1 * r1) + r1, r8));
    L17:
        if (r8 > r2) goto L19;
        return r0;
    L19:
        return r0 + 1;
    L21:
        if (r8 < r2) goto L23;
        return r0;
    L23:
        return r0 - 1;
    L25:
        if (r2 == r8) goto L28;
        r6 = false;
    L28:
        MathPreconditions.checkRoundingUnnecessary(r6);
        return r0;
    L5:
        return IntMath.sqrt((int) r8, r10);
    }

    public static long divide(long r9, long r11, RoundingMode r13) {
        Preconditions.checkNotNull(r13);
        long r0 = r9 / r11;
        long r2 = r9 - (r11 * r0);
        if (r2 != 0) goto L5;
        return r0;
    L5:
        boolean r10 = true;
        int r12 = ((int) ((r9 ^ r11) >> 63)) | 1;
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r13.ordinal()]) {
            case 1: goto L30;
            case 2: goto L34;
            case 3: goto L28;
            case 4: goto L35;
            case 5: goto L26;
            case 6: goto L9;
            case 7: goto L9;
            case 8: goto L9;
            default: goto L8;
        };
    L9:
        long r3 = Math.abs(r2);
        long r4 = r3 - (Math.abs(r11) - r3);
        if (r4 == 0) goto L12;
        if (r4 <= 0) goto L34;
    L12:
        if (r13 != RoundingMode.HALF_UP) goto L14;
        boolean r14 = true;
    L16:
        if (r13 != RoundingMode.HALF_EVEN) goto L18;
        boolean r15 = true;
    L20:
        if ((1 & r0) != 0) goto L23;
        r10 = false;
    L23:
        r10 = (r10 & r15) | r14;
        goto L35
    L18:
        r15 = false;
        goto L20
    L14:
        r14 = false;
        goto L16
    L26:
        if (r12 <= 0) goto L34;
    L28:
        if (r12 >= 0) goto L34;
    L30:
        if (r2 == 0) goto L33;
        r10 = false;
    L33:
        MathPreconditions.checkRoundingUnnecessary(r10);
    L34:
        r10 = false;
    L35:
        if (r10 == true) goto L37;
        return r0;
    L37:
        return r0 + ((long) r12);
    L8:
        throw new AssertionError();
    }

    public static int mod(long r2, int r4) {
        return (int) mod(r2, r4);
    }

    public static long mod(long r3, long r5) {
        if (r5 <= 0) goto L10;
        long r4 = r3 % r5;
        if (r4 < 0) goto L8;
        return r4;
    L8:
        return r4 + r5;
    L10:
        throw new ArithmeticException("Modulus must be positive");
    }

    public static long gcd(long r4, long r6) {
        MathPreconditions.checkNonNegative("a", r4);
        MathPreconditions.checkNonNegative("b", r6);
        if (r4 != 0) goto L6;
        return r6;
    L6:
        if (r6 != 0) goto L8;
        return r4;
    L8:
        int r0 = Long.numberOfTrailingZeros(r4);
        long r5 = r4 >> r0;
        int r1 = Long.numberOfTrailingZeros(r6);
        long r7 = r6 >> r1;
    L10:
        if (r5 == r7) goto L13;
        long r8 = r5 - r7;
        long r2 = (r8 >> 63) & r8;
        long r9 = (r8 - r2) - r2;
        r7 = r7 + r2;
        r5 = r9 >> Long.numberOfTrailingZeros(r9);
        goto L10
    L13:
        return r5 << Math.min(r0, r1);
    }

    public static long checkedAdd(long r10, long r12) {
        long r0 = r10 + r12;
        boolean r3 = true;
        if ((r10 ^ r12) >= 0) goto L5;
        boolean r2 = true;
    L7:
        if ((r10 ^ r0) >= 0) goto L10;
        r3 = false;
    L10:
        MathPreconditions.checkNoOverflow(r2 | r3, "checkedAdd", r10, r12);
        return r0;
    L5:
        r2 = false;
        goto L7
    }

    public static long checkedSubtract(long r10, long r12) {
        long r0 = r10 - r12;
        boolean r3 = true;
        if ((r10 ^ r12) < 0) goto L5;
        boolean r2 = true;
    L7:
        if ((r10 ^ r0) >= 0) goto L10;
        r3 = false;
    L10:
        MathPreconditions.checkNoOverflow(r2 | r3, "checkedSubtract", r10, r12);
        return r0;
    L5:
        r2 = false;
        goto L7
    }

    public static long checkedMultiply(long r12, long r14) {
        int r0 = ((Long.numberOfLeadingZeros(r12) + Long.numberOfLeadingZeros(~r12)) + Long.numberOfLeadingZeros(r14)) + Long.numberOfLeadingZeros(~r14);
        if (r0 <= 65) goto L7;
        return r12 * r14;
    L7:
        if (r0 < 64) goto L9;
        boolean r4 = true;
    L10:
        MathPreconditions.checkNoOverflow(r4, "checkedMultiply", r12, r14);
        if (r12 < 0) goto L13;
        boolean r1 = true;
    L15:
        if (r14 == Long.MIN_VALUE) goto L17;
        boolean r5 = true;
    L18:
        MathPreconditions.checkNoOverflow(r1 | r5, "checkedMultiply", r12, r14);
        long r6 = r12 * r14;
        if (r12 != 0) goto L21;
    L24:
        boolean r7 = true;
    L25:
        MathPreconditions.checkNoOverflow(r7, "checkedMultiply", r12, r14);
        return r6;
    L21:
        if ((r6 / r12) == r14) goto L24;
        r7 = false;
        goto L25
    L17:
        r5 = false;
        goto L18
    L13:
        r1 = false;
        goto L15
    L9:
        r4 = false;
        goto L10
    }

    public static long checkedPow(long r13, int r15) {
        MathPreconditions.checkNonNegative("exponent", r15);
        if (r13 < (-2)) goto L5;
        boolean r0 = true;
    L7:
        if (r13 > 2) goto L9;
        boolean r5 = true;
    L10:
        long r7 = 1;
        if ((r0 & r5) == false) goto L47;
        int r1 = (int) r13;
        if (r1 == (-2)) goto L39;
        if (r1 == (-1)) goto L34;
        if (r1 == 0) goto L29;
        if (r1 != 1) goto L19;
        return 1;
    L19:
        if (r1 != 2) goto L27;
        if (r15 >= 63) goto L23;
        boolean r2 = true;
    L24:
        MathPreconditions.checkNoOverflow(r2, "checkedPow", r13, r15);
        return 1 << r15;
    L23:
        r2 = false;
        goto L24
    L27:
        throw new AssertionError();
    L29:
        if (r15 == 0) goto L70;
        return 0;
    L70:
        return 1;
    L34:
        if ((r15 & 1) != 0) goto L37;
        return 1;
    L37:
        return -1;
    L39:
        if (r15 >= 64) goto L41;
        boolean r3 = true;
    L42:
        MathPreconditions.checkNoOverflow(r3, "checkedPow", r13, r15);
        if ((r15 & 1) != 0) goto L46;
        return 1 << r15;
    L46:
        return (-1) << r15;
    L41:
        r3 = false;
        goto L42
    L47:
        long r4 = r13;
        int r6 = r15;
    L48:
        if (r6 == 0) goto L65;
        if (r6 == 1) goto L64;
        if ((r6 & 1) == 0) goto L53;
        r7 = checkedMultiply(r7, r4);
    L53:
        long r11 = r7;
        int r8 = r6 >> 1;
        if (r8 <= 0) goto L62;
        if ((-3037000499L) <= r4) goto L58;
    L60:
        boolean r9 = false;
    L61:
        MathPreconditions.checkNoOverflow(r9, "checkedPow", r4, r8);
        r4 = r4 * r4;
        goto L62
    L58:
        if (r4 > FLOOR_SQRT_MAX_LONG) goto L60;
        r9 = true;
    L62:
        r6 = r8;
        r7 = r11;
        goto L48
    L64:
        return checkedMultiply(r7, r4);
    L65:
        return r7;
    L9:
        r5 = false;
        goto L10
    L5:
        r0 = false;
        goto L7
    }

    public static long saturatedMultiply(long r9, long r11) {
        int r0 = ((Long.numberOfLeadingZeros(r9) + Long.numberOfLeadingZeros(~r9)) + Long.numberOfLeadingZeros(r11)) + Long.numberOfLeadingZeros(~r11);
        if (r0 > 65) goto L5;
        long r1 = ((r9 ^ r11) >>> 63) + Long.MAX_VALUE;
        boolean r4 = true;
        if (r0 >= 64) goto L9;
        boolean r2 = true;
    L11:
        if (r9 >= 0) goto L13;
        boolean r6 = true;
    L15:
        if (r11 == Long.MIN_VALUE) goto L19;
        r4 = false;
    L19:
        if ((r2 | (r4 & r6)) == false) goto L21;
        return r1;
    L21:
        long r5 = r9 * r11;
        if (r9 != 0) goto L24;
    L27:
        return r5;
    L24:
        if ((r5 / r9) == r11) goto L27;
        return r1;
    L13:
        r6 = false;
        goto L15
    L9:
        r2 = false;
        goto L11
    L5:
        return r9 * r11;
    }

    public static long saturatedPow(long r12, int r14) {
        MathPreconditions.checkNonNegative("exponent", r14);
        if (r12 < (-2)) goto L5;
        boolean r0 = true;
    L7:
        if (r12 > 2) goto L9;
        boolean r3 = true;
    L10:
        long r6 = 1;
        if ((r0 & r3) == false) goto L45;
        int r13 = (int) r12;
        if (r13 == (-2)) goto L37;
        if (r13 == (-1)) goto L32;
        if (r13 == 0) goto L27;
        if (r13 != 1) goto L19;
        return 1;
    L19:
        if (r13 != 2) goto L25;
        if (r14 < 63) goto L23;
        return Long.MAX_VALUE;
    L23:
        return 1 << r14;
    L25:
        throw new AssertionError();
    L27:
        if (r14 == 0) goto L75;
        return 0;
    L75:
        return 1;
    L32:
        if ((r14 & 1) != 0) goto L35;
        return 1;
    L35:
        return -1;
    L37:
        if (r14 < 64) goto L41;
        return ((long) (r14 & 1)) + Long.MAX_VALUE;
    L41:
        if ((r14 & 1) != 0) goto L44;
        return 1 << r14;
    L44:
        return (-1) << r14;
    L45:
        long r8 = ((r12 >>> 63) & ((long) (r14 & 1))) + Long.MAX_VALUE;
    L46:
        if (r14 == 0) goto L67;
        if (r14 == 1) goto L66;
        if ((r14 & 1) == 0) goto L51;
        r6 = saturatedMultiply(r6, r12);
    L51:
        r14 = r14 >> 1;
        if (r14 <= 0) goto L46;
        if ((-3037000499L) <= r12) goto L56;
        boolean r1 = true;
    L58:
        if (r12 <= FLOOR_SQRT_MAX_LONG) goto L60;
        boolean r4 = true;
    L62:
        if ((r1 | r4) == true) goto L63;
        r12 = r12 * r12;
        goto L46
    L63:
        return r8;
    L60:
        r4 = false;
        goto L62
    L56:
        r1 = false;
        goto L58
    L66:
        return saturatedMultiply(r6, r12);
    L67:
        return r6;
    L9:
        r3 = false;
        goto L10
    L5:
        r0 = false;
        goto L7
    }

    public static long factorial(int r2) {
        MathPreconditions.checkNonNegative("n", r2);
        long[] r0 = factorials;
        if (r2 < r0.length) goto L7;
        return Long.MAX_VALUE;
    L7:
        return r0[r2];
    }

    public static long binomial(int r11, int r12) {
        MathPreconditions.checkNonNegative("n", r11);
        MathPreconditions.checkNonNegative("k", r12);
        if (r12 > r11) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "k (%s) > n (%s)", r12, r11);
        if (r12 <= (r11 >> 1)) goto L9;
        r12 = r11 - r12;
    L9:
        long r2 = 1;
        if (r12 == 0) goto L42;
        if (r12 == 1) goto L41;
        long[] r0 = factorials;
        if (r11 < r0.length) goto L15;
        int[] r3 = biggestBinomials;
        if (r12 < r3.length) goto L19;
        return Long.MAX_VALUE;
    L19:
        if (r11 > r3[r12]) goto L47;
        int[] r4 = biggestSimpleBinomials;
        int r5 = 2;
        if (r12 < r4.length) goto L24;
    L29:
        long r6 = r11;
        int r7 = log2(r6, RoundingMode.CEILING);
        int r13 = r11 - 1;
        int r8 = r7;
        int r9 = 2;
        long r10 = r6;
        long r14 = 1;
    L30:
        if (r9 > r12) goto L37;
        r8 = r8 + r7;
        if (r8 >= 63) goto L34;
        r10 = r10 * ((long) r13);
        r14 = r14 * ((long) r9);
    L35:
        r9 = r9 + 1;
        r13 = r13 - 1;
        goto L30
    L34:
        r2 = multiplyFraction(r2, r10, r14);
        r10 = r13;
        r14 = r9;
        r8 = r7;
        goto L35
    L37:
        return multiplyFraction(r2, r10, r14);
    L24:
        if (r11 > r4[r12]) goto L29;
        int r15 = r11 - 1;
        long r16 = r11;
    L26:
        if (r5 > r12) goto L28;
        r16 = (r16 * ((long) r15)) / ((long) r5);
        r15 = r15 - 1;
        r5 = r5 + 1;
        goto L26
    L28:
        return r16;
    L47:
        return Long.MAX_VALUE;
    L15:
        return r0[r11] / (r0[r12] * r0[r11 - r12]);
    L41:
        return r11;
    L42:
        return 1;
    L5:
        r1 = false;
        goto L6
    }

    static long multiplyFraction(long r2, long r4, long r6) {
        if (r2 == 1) goto L5;
        long r0 = gcd(r2, r6);
        return (r2 / r0) * (r4 / (r6 / r0));
    L5:
        return r4 / r6;
    }

    public static boolean isPrime(long r8) {
        if (r8 >= 2) goto L7;
        MathPreconditions.checkNonNegative("n", r8);
        return false;
    L7:
        if (r8 >= 66) goto L13;
        if (((722865708377213483 >> (((int) r8) - 2)) & 1) != 0) goto L11;
        return false;
    L11:
        return true;
    L13:
        if (((1 << ((int) (r8 % 30))) & SIEVE_30) == 0) goto L16;
        return false;
    L16:
        if ((r8 % 7) != 0) goto L18;
    L40:
        return false;
    L18:
        if ((r8 % 11) == 0) goto L40;
        if ((r8 % 13) == 0) goto L40;
        if (r8 >= 289) goto L25;
        return true;
    L25:
        long[][] r0 = millerRabinBaseSets;
        int r2 = r0.length;
        int r3 = 0;
    L26:
        if (r3 >= r2) goto L39;
        long[] r5 = r0[r3];
        if (r8 <= r5[0]) goto L29;
        r3 = r3 + 1;
        goto L26
    L29:
        int r1 = 1;
    L31:
        if (r1 >= r5.length) goto L36;
        if (MillerRabinTester.test(r5[r1], r8) == false) goto L34;
        r1 = r1 + 1;
        goto L31
    L34:
        return false;
    L36:
        return true;
    L39:
        throw new AssertionError();
    }

    public static double roundToDouble(long r21, RoundingMode r23) {
        double r2 = r21;
        long r4 = (long) r2;
        if (r4 != Long.MAX_VALUE) goto L5;
        int r8 = -1;
    L7:
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r23.ordinal()]) {
            case 1: goto L71;
            case 2: goto L62;
            case 3: goto L57;
            case 4: goto L48;
            case 5: goto L43;
            case 6: goto L10;
            case 7: goto L10;
            case 8: goto L10;
            default: goto L9;
        };
    L10:
        if (r8 < 0) goto L12;
        double r9 = Math.nextUp(r2);
        long r13 = (long) Math.ceil(r9);
    L13:
        long r5 = r21 - r4;
        long r15 = r13 - r21;
        if (r13 != Long.MAX_VALUE) goto L16;
        r15 = r15 + 1;
    L16:
        int r6 = Longs.compare(r5, r15);
        if (r6 >= 0) goto L19;
        return r2;
    L19:
        if (r6 <= 0) goto L21;
        return r9;
    L21:
        int r7 = AnonymousClass1.$SwitchMap$java$math$RoundingMode[r23.ordinal()];
        if (r7 == 6) goto L39;
        if (r7 == 7) goto L35;
        if (r7 != 8) goto L33;
        if ((DoubleUtils.getSignificand(r2) & 1) != 0) goto L31;
        return r2;
    L31:
        return r9;
    L33:
        throw new AssertionError("impossible");
    L35:
        if (r21 >= 0) goto L37;
        return r2;
    L37:
        return r9;
    L39:
        if (r21 < 0) goto L42;
        return r2;
    L42:
        return r9;
    L12:
        double r10 = DoubleUtils.nextDown(r2);
        r4 = (long) Math.floor(r10);
        r13 = r4;
        r2 = r10;
        r9 = r2;
        goto L13
    L43:
        if (r8 > 0) goto L46;
        return r2;
    L46:
        return Math.nextUp(r2);
    L57:
        if (r8 < 0) goto L60;
        return r2;
    L60:
        return DoubleUtils.nextDown(r2);
    L71:
        if (r8 != 0) goto L73;
        boolean r0 = true;
    L74:
        MathPreconditions.checkRoundingUnnecessary(r0);
        return r2;
    L73:
        r0 = false;
        goto L74
    L9:
        throw new AssertionError("impossible");
    L48:
        if (r21 < 0) goto L53;
        if (r8 > 0) goto L52;
        return r2;
    L52:
        return Math.nextUp(r2);
    L53:
        if (r8 < 0) goto L56;
        return r2;
    L56:
        return DoubleUtils.nextDown(r2);
    L62:
        if (r21 < 0) goto L67;
        if (r8 < 0) goto L66;
        return r2;
    L66:
        return DoubleUtils.nextDown(r2);
    L67:
        if (r8 > 0) goto L70;
        return r2;
    L70:
        return Math.nextUp(r2);
    L5:
        r8 = Longs.compare(r21, r4);
        goto L7
    }

    private LongMath() {
    }
}
