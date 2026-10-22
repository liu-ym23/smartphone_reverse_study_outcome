package org.apache.commons.math3.util;

import java.math.BigInteger;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public final class ArithmeticUtils {
    public static boolean isPowerOfTwo(long r4) {
        if (r4 > 0) goto L5;
    L7:
        return false;
    L5:
        if ((r4 & (r4 - 1)) != 0) goto L7;
        return true;
    }

    private ArithmeticUtils() {
    }

    public static int addAndCheck(int r4, int r5) throws MathArithmeticException {
        long r0 = ((long) r4) + ((long) r5);
        if (r0 < (-2147483648L)) goto L9;
        if (r0 > 2147483647L) goto L9;
        return (int) r0;
    L9:
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_ADDITION, new Object[]{Integer.valueOf(r4), Integer.valueOf(r5)});
    }

    public static long addAndCheck(long r1, long r3) throws MathArithmeticException {
        return addAndCheck(r1, r3, LocalizedFormats.OVERFLOW_IN_ADDITION);
    }

    @Deprecated
    public static long binomialCoefficient(int r0, int r1) throws NotPositiveException, NumberIsTooLargeException, MathArithmeticException {
        return CombinatoricsUtils.binomialCoefficient(r0, r1);
    }

    @Deprecated
    public static double binomialCoefficientDouble(int r0, int r1) throws NotPositiveException, NumberIsTooLargeException, MathArithmeticException {
        return CombinatoricsUtils.binomialCoefficientDouble(r0, r1);
    }

    @Deprecated
    public static double binomialCoefficientLog(int r0, int r1) throws NotPositiveException, NumberIsTooLargeException, MathArithmeticException {
        return CombinatoricsUtils.binomialCoefficientLog(r0, r1);
    }

    @Deprecated
    public static long factorial(int r2) throws NotPositiveException, MathArithmeticException {
        return CombinatoricsUtils.factorial(r2);
    }

    @Deprecated
    public static double factorialDouble(int r2) throws NotPositiveException {
        return CombinatoricsUtils.factorialDouble(r2);
    }

    @Deprecated
    public static double factorialLog(int r2) throws NotPositiveException {
        return CombinatoricsUtils.factorialLog(r2);
    }

    public static int gcd(int r10, int r11) throws MathArithmeticException {
        if (r10 == 0) goto L35;
        if (r11 == 0) goto L35;
        long r4 = r10;
        long r6 = r11;
        if (r10 >= 0) goto L12;
        if (Integer.MIN_VALUE != r10) goto L10;
        int r8 = r10;
        boolean r9 = true;
    L11:
        r4 = -r4;
    L13:
        if (r11 >= 0) goto L18;
        if (Integer.MIN_VALUE != r11) goto L16;
        int r2 = r11;
        r9 = true;
    L17:
        r6 = -r6;
    L19:
        if (r9 == false) goto L34;
        if (r4 == r6) goto L32;
        long r7 = r6 % r4;
        if (r7 == 0) goto L25;
        r2 = (int) r7;
        r8 = (int) (r4 % r7);
        goto L34
    L25:
        if (r4 > 2147483647L) goto L29;
        return (int) r4;
    L29:
        throw new MathArithmeticException(LocalizedFormats.GCD_OVERFLOW_32_BITS, new Object[]{Integer.valueOf(r10), Integer.valueOf(r11)});
    L32:
        throw new MathArithmeticException(LocalizedFormats.GCD_OVERFLOW_32_BITS, new Object[]{Integer.valueOf(r10), Integer.valueOf(r11)});
    L34:
        return gcdPositive(r8, r2);
    L16:
        r2 = -r11;
        goto L17
    L18:
        r2 = r11;
        goto L19
    L10:
        r8 = -r10;
        r9 = false;
        goto L11
    L12:
        r8 = r10;
        r9 = false;
    L35:
        if (r10 == Integer.MIN_VALUE) goto L40;
        if (r11 == Integer.MIN_VALUE) goto L40;
        return FastMath.abs(r10 + r11);
    L40:
        throw new MathArithmeticException(LocalizedFormats.GCD_OVERFLOW_32_BITS, new Object[]{Integer.valueOf(r10), Integer.valueOf(r11)});
    }

    private static int gcdPositive(int r2, int r3) {
        if (r2 != 0) goto L4;
        return r3;
    L4:
        if (r3 != 0) goto L6;
        return r2;
    L6:
        int r0 = Integer.numberOfTrailingZeros(r2);
        int r4 = r2 >> r0;
        int r1 = Integer.numberOfTrailingZeros(r3);
        int r5 = r3 >> r1;
        int r6 = FastMath.min(r0, r1);
    L7:
        if (r4 == r5) goto L10;
        int r7 = r4 - r5;
        r5 = Math.min(r4, r5);
        int r8 = Math.abs(r7);
        r4 = r8 >> Integer.numberOfTrailingZeros(r8);
        goto L7
    L10:
        return r4 << r6;
    }

    public static long gcd(long r23, long r25) throws MathArithmeticException {
        if (r23 == 0) goto L39;
        if (r25 == 0) goto L39;
        if (r23 <= 0) goto L9;
        long r11 = -r23;
    L10:
        if (r25 <= 0) goto L12;
        long r13 = -r25;
    L13:
        int r6 = 0;
    L14:
        long r17 = r11 & 1;
        if (r17 != 0) goto L20;
        if ((r13 & 1) != 0) goto L20;
        if (r6 >= 63) goto L20;
        r11 = r11 / 2;
        r13 = r13 / 2;
        r6 = r6 + 1;
    L20:
        if (r6 == 63) goto L37;
        if (r17 != 1) goto L24;
        long r0 = r13;
    L26:
        if ((r0 & 1) == 0) goto L27;
        if (r0 <= 0) goto L31;
        r11 = -r0;
    L32:
        r0 = (r13 - r11) / 2;
        if (r0 != 0) goto L26;
        return (-r11) * (1 << r6);
    L31:
        r13 = r0;
        goto L32
    L27:
        r0 = r0 / 2;
        goto L26
    L24:
        r0 = -(r11 / 2);
        goto L26
    L37:
        throw new MathArithmeticException(LocalizedFormats.GCD_OVERFLOW_64_BITS, new Object[]{Long.valueOf(r23), Long.valueOf(r25)});
    L12:
        r13 = r25;
        goto L13
    L9:
        r11 = r23;
    L39:
        if (r23 == Long.MIN_VALUE) goto L45;
        if (r25 == Long.MIN_VALUE) goto L45;
        return FastMath.abs(r23) + FastMath.abs(r25);
    L45:
        throw new MathArithmeticException(LocalizedFormats.GCD_OVERFLOW_64_BITS, new Object[]{Long.valueOf(r23), Long.valueOf(r25)});
    }

    public static int lcm(int r4, int r5) throws MathArithmeticException {
        if (r4 == 0) goto L11;
        if (r5 == 0) goto L11;
        int r1 = FastMath.abs(mulAndCheck(r4 / gcd(r4, r5), r5));
        if (r1 == Integer.MIN_VALUE) goto L10;
        return r1;
    L10:
        throw new MathArithmeticException(LocalizedFormats.LCM_OVERFLOW_32_BITS, new Object[]{Integer.valueOf(r4), Integer.valueOf(r5)});
    L11:
        return 0;
    }

    public static long lcm(long r4, long r6) throws MathArithmeticException {
        if (r4 != 0) goto L5;
    L12:
        return 0;
    L5:
        if (r6 == 0) goto L12;
        long r0 = FastMath.abs(mulAndCheck(r4 / gcd(r4, r6), r6));
        if (r0 == Long.MIN_VALUE) goto L11;
        return r0;
    L11:
        throw new MathArithmeticException(LocalizedFormats.LCM_OVERFLOW_64_BITS, new Object[]{Long.valueOf(r4), Long.valueOf(r6)});
    }

    public static int mulAndCheck(int r2, int r3) throws MathArithmeticException {
        long r0 = ((long) r2) * ((long) r3);
        if (r0 < (-2147483648L)) goto L9;
        if (r0 > 2147483647L) goto L9;
        return (int) r0;
    L9:
        throw new MathArithmeticException();
    }

    public static long mulAndCheck(long r5, long r7) throws MathArithmeticException {
        if (r5 <= r7) goto L6;
        return mulAndCheck(r7, r5);
    L6:
        if (r5 < 0) goto L8;
        if (r5 > 0) goto L22;
    L27:
        return 0;
    L22:
        if (r5 > (Long.MAX_VALUE / r7)) goto L25;
    L29:
        return r5 * r7;
    L25:
        throw new MathArithmeticException();
    L8:
        if (r7 < 0) goto L10;
        if (r7 <= 0) goto L27;
        if ((Long.MIN_VALUE / r7) <= r5) goto L29;
        throw new MathArithmeticException();
    L10:
        if (r5 >= (Long.MAX_VALUE / r7)) goto L29;
        throw new MathArithmeticException();
    }

    public static int subAndCheck(int r4, int r5) throws MathArithmeticException {
        long r0 = ((long) r4) - ((long) r5);
        if (r0 < (-2147483648L)) goto L9;
        if (r0 > 2147483647L) goto L9;
        return (int) r0;
    L9:
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_SUBTRACTION, new Object[]{Integer.valueOf(r4), Integer.valueOf(r5)});
    }

    public static long subAndCheck(long r4, long r6) throws MathArithmeticException {
        if (r6 != Long.MIN_VALUE) goto L10;
        if (r4 >= 0) goto L8;
        return r4 - r6;
    L8:
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_ADDITION, new Object[]{Long.valueOf(r4), Long.valueOf(-r6)});
    L10:
        return addAndCheck(r4, -r6, LocalizedFormats.OVERFLOW_IN_ADDITION);
    }

    public static int pow(int r6, int r7) throws NotPositiveException, MathArithmeticException {
        if (r7 < 0) goto L17;
        int r3 = r6;
        int r1 = r7;
        int r2 = 1;
    L5:
        if ((r1 & 1) != 0) goto L18;
    L9:
        r1 = r1 >> 1;     // Catch: MathArithmeticException -> L7
        if (r1 == 0) goto L11;
        r3 = mulAndCheck(r3, r3);     // Catch: MathArithmeticException -> L7
        goto L5
    L11:
        return r2;
    L18:
        r2 = mulAndCheck(r2, r3);     // Catch: MathArithmeticException -> L7
    L7:
        e = move-exception;
        e.getContext().addMessage(LocalizedFormats.OVERFLOW, new Object[0]);
        e.getContext().addMessage(LocalizedFormats.BASE, new Object[]{Integer.valueOf(r6)});
        e.getContext().addMessage(LocalizedFormats.EXPONENT, new Object[]{Integer.valueOf(r7)});
        throw e;
    L17:
        throw new NotPositiveException(LocalizedFormats.EXPONENT, Integer.valueOf(r7));
    }

    @Deprecated
    public static int pow(int r6, long r7) throws NotPositiveException {
        if (r7 < 0) goto L13;
        int r3 = 1;
    L6:
        if (r7 == 0) goto L11;
        if ((1 & r7) == 0) goto L10;
        r3 = r3 * r6;
    L10:
        r6 = r6 * r6;
        r7 = r7 >> 1;
        goto L6
    L11:
        return r3;
    L13:
        throw new NotPositiveException(LocalizedFormats.EXPONENT, Long.valueOf(r7));
    }

    public static long pow(long r6, int r8) throws NotPositiveException, MathArithmeticException {
        if (r8 < 0) goto L17;
        long r0 = 1;
        long r3 = r6;
        int r2 = r8;
    L5:
        if ((r2 & 1) != 0) goto L18;
    L9:
        r2 = r2 >> 1;     // Catch: MathArithmeticException -> L7
        if (r2 == 0) goto L11;
        r3 = mulAndCheck(r3, r3);     // Catch: MathArithmeticException -> L7
        goto L5
    L11:
        return r0;
    L18:
        r0 = mulAndCheck(r0, r3);     // Catch: MathArithmeticException -> L7
    L7:
        e = move-exception;
        e.getContext().addMessage(LocalizedFormats.OVERFLOW, new Object[0]);
        e.getContext().addMessage(LocalizedFormats.BASE, new Object[]{Long.valueOf(r6)});
        e.getContext().addMessage(LocalizedFormats.EXPONENT, new Object[]{Integer.valueOf(r8)});
        throw e;
    L17:
        throw new NotPositiveException(LocalizedFormats.EXPONENT, Integer.valueOf(r8));
    }

    @Deprecated
    public static long pow(long r8, long r10) throws NotPositiveException {
        if (r10 < 0) goto L13;
        long r4 = 1;
    L6:
        if (r10 == 0) goto L11;
        if ((r10 & 1) == 0) goto L10;
        r4 = r4 * r8;
    L10:
        r8 = r8 * r8;
        r10 = r10 >> 1;
        goto L6
    L11:
        return r4;
    L13:
        throw new NotPositiveException(LocalizedFormats.EXPONENT, Long.valueOf(r10));
    }

    public static BigInteger pow(BigInteger r1, int r2) throws NotPositiveException {
        if (r2 < 0) goto L6;
        return r1.pow(r2);
    L6:
        throw new NotPositiveException(LocalizedFormats.EXPONENT, Integer.valueOf(r2));
    }

    public static BigInteger pow(BigInteger r5, long r6) throws NotPositiveException {
        if (r6 < 0) goto L13;
        BigInteger r2 = BigInteger.ONE;
    L6:
        if (r6 == 0) goto L11;
        if ((1 & r6) == 0) goto L10;
        r2 = r2.multiply(r5);
    L10:
        r5 = r5.multiply(r5);
        r6 = r6 >> 1;
        goto L6
    L11:
        return r2;
    L13:
        throw new NotPositiveException(LocalizedFormats.EXPONENT, Long.valueOf(r6));
    }

    public static BigInteger pow(BigInteger r2, BigInteger r3) throws NotPositiveException {
        if (r3.compareTo(BigInteger.ZERO) < 0) goto L13;
        BigInteger r0 = BigInteger.ONE;
    L6:
        if (BigInteger.ZERO.equals(r3) == true) goto L11;
        if (r3.testBit(0) == false) goto L10;
        r0 = r0.multiply(r2);
    L10:
        r2 = r2.multiply(r2);
        r3 = r3.shiftRight(1);
        goto L6
    L11:
        return r0;
    L13:
        throw new NotPositiveException(LocalizedFormats.EXPONENT, r3);
    }

    @Deprecated
    public static long stirlingS2(int r0, int r1) throws NotPositiveException, NumberIsTooLargeException, MathArithmeticException {
        return CombinatoricsUtils.stirlingS2(r0, r1);
    }

    private static long addAndCheck(long r9, long r11, Localizable r13) throws MathArithmeticException {
        long r0 = r9 + r11;
        if ((r9 ^ r11) >= 0) goto L5;
        boolean r2 = true;
    L7:
        if ((r9 ^ r0) < 0) goto L9;
        boolean r4 = true;
    L11:
        if ((r2 | r4) == false) goto L14;
        return r0;
    L14:
        throw new MathArithmeticException(r13, new Object[]{Long.valueOf(r9), Long.valueOf(r11)});
    L9:
        r4 = false;
        goto L11
    L5:
        r2 = false;
        goto L7
    }
}
