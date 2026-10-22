package org.apache.commons.math3.util;

import java.math.BigDecimal;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class Precision {
    public static final double EPSILON = 0.0d;
    private static final long EXPONENT_OFFSET = 1023;
    private static final long NEGATIVE_ZERO_DOUBLE_BITS = 0;
    private static final int NEGATIVE_ZERO_FLOAT_BITS = 0;
    private static final double POSITIVE_ZERO = 0.0d;
    private static final long POSITIVE_ZERO_DOUBLE_BITS = 0;
    private static final int POSITIVE_ZERO_FLOAT_BITS = 0;
    public static final double SAFE_MIN = 0.0d;
    private static final long SGN_MASK = Long.MIN_VALUE;
    private static final int SGN_MASK_FLOAT = Integer.MIN_VALUE;

    public static double representableDelta(double r0, double r2) {
        return (r2 + r0) - r0;
    }

    static {
        POSITIVE_ZERO_DOUBLE_BITS = Double.doubleToRawLongBits(POSITIVE_ZERO);
        NEGATIVE_ZERO_DOUBLE_BITS = Double.doubleToRawLongBits(-0.0d);
        POSITIVE_ZERO_FLOAT_BITS = Float.floatToRawIntBits(0.0f);
        NEGATIVE_ZERO_FLOAT_BITS = Float.floatToRawIntBits(-0.0f);
        EPSILON = Double.longBitsToDouble(4368491638549381120L);
        SAFE_MIN = Double.longBitsToDouble(4503599627370496L);
    }

    private Precision() {
    }

    public static int compareTo(double r0, double r2, double r4) {
        if (equals(r0, r2, r4) == false) goto L7;
        return 0;
    L7:
        if (r0 >= r2) goto L10;
        return -1;
    L10:
        return 1;
    }

    public static int compareTo(double r0, double r2, int r4) {
        if (equals(r0, r2, r4) == false) goto L7;
        return 0;
    L7:
        if (r0 >= r2) goto L10;
        return -1;
    L10:
        return 1;
    }

    public static boolean equals(float r1, float r2) {
        return equals(r1, r2, 1);
    }

    public static boolean equalsIncludingNaN(float r3, float r4) {
        if (r3 != r3) goto L9;
        if (r4 != r4) goto L9;
        return equals(r3, r4, 1);
    L9:
        if (r3 == r3) goto L11;
        boolean r0 = true;
    L13:
        if (r4 == r4) goto L15;
        boolean r5 = true;
    L17:
        if ((r5 ^ r0) == true) goto L20;
        return true;
    L20:
        return false;
    L15:
        r5 = false;
        goto L17
    L11:
        r0 = false;
        goto L13
    }

    public static boolean equals(float r2, float r3, float r4) {
        if (equals(r2, r3, 1) == false) goto L5;
        return true;
    L5:
        if (FastMath.abs(r3 - r2) <= r4) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean equalsIncludingNaN(float r1, float r2, float r3) {
        if (equalsIncludingNaN(r1, r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (FastMath.abs(r2 - r1) <= r3) goto L8;
        return false;
    }

    public static boolean equals(float r6, float r7, int r8) {
        int r0 = Float.floatToRawIntBits(r6);
        int r1 = Float.floatToRawIntBits(r7);
        if (((r0 ^ r1) & Integer.MIN_VALUE) == 0) goto L5;
        if (r0 >= r1) goto L9;
        int r2 = r1 - POSITIVE_ZERO_FLOAT_BITS;
        int r3 = r0 - NEGATIVE_ZERO_FLOAT_BITS;
    L10:
        if (r2 <= r8) goto L13;
    L11:
        boolean r9 = false;
    L15:
        if (r9 == false) goto L22;
        if (Float.isNaN(r6) == true) goto L22;
        if (Float.isNaN(r7) == true) goto L22;
        return true;
    L22:
        return false;
    L13:
        if (r3 > (r8 - r2)) goto L11;
    L6:
        r9 = true;
        goto L15
    L9:
        int r4 = r0 - POSITIVE_ZERO_FLOAT_BITS;
        int r5 = r1 - NEGATIVE_ZERO_FLOAT_BITS;
        r2 = r4;
        r3 = r5;
        goto L10
    L5:
        if (FastMath.abs(r0 - r1) > r8) goto L11;
        goto L6
    }

    public static boolean equalsIncludingNaN(float r2, float r3, int r4) {
        if (r2 != r2) goto L9;
        if (r3 != r3) goto L9;
        return equals(r2, r3, r4);
    L9:
        if (r2 == r2) goto L11;
        boolean r0 = true;
    L13:
        if (r3 == r3) goto L15;
        boolean r5 = true;
    L17:
        if ((r5 ^ r0) == true) goto L20;
        return true;
    L20:
        return false;
    L15:
        r5 = false;
        goto L17
    L11:
        r0 = false;
        goto L13
    }

    public static boolean equals(double r1, double r3) {
        return equals(r1, r3, 1);
    }

    public static boolean equalsIncludingNaN(double r3, double r5) {
        if (r3 != r3) goto L9;
        if (r5 != r5) goto L9;
        return equals(r3, r5, 1);
    L9:
        if (r3 == r3) goto L11;
        boolean r4 = true;
    L13:
        if (r5 == r5) goto L15;
        boolean r6 = true;
    L17:
        if ((r4 ^ r6) == true) goto L20;
        return true;
    L20:
        return false;
    L15:
        r6 = false;
        goto L17
    L11:
        r4 = false;
        goto L13
    }

    public static boolean equals(double r2, double r4, double r6) {
        if (equals(r2, r4, 1) == false) goto L5;
        return true;
    L5:
        if (FastMath.abs(r4 - r2) <= r6) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean equalsWithRelativeTolerance(double r5, double r7, double r9) {
        if (equals(r5, r7, 1) == false) goto L5;
        return true;
    L5:
        double r1 = FastMath.max(FastMath.abs(r5), FastMath.abs(r7));
        if (FastMath.abs((r5 - r7) / r1) <= r9) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean equalsIncludingNaN(double r1, double r3, double r5) {
        if (equalsIncludingNaN(r1, r3) == false) goto L5;
    L8:
        return true;
    L5:
        if (FastMath.abs(r3 - r1) <= r5) goto L8;
        return false;
    }

    public static boolean equals(double r11, double r13, int r15) {
        long r0 = Double.doubleToRawLongBits(r11);
        long r2 = Double.doubleToRawLongBits(r13);
        if (((r0 ^ r2) & Long.MIN_VALUE) != 0) goto L8;
        if (FastMath.abs(r0 - r2) > r15) goto L13;
    L6:
        boolean r16 = true;
    L17:
        if (r16 == false) goto L24;
        if (Double.isNaN(r11) == true) goto L24;
        if (Double.isNaN(r13) == true) goto L24;
        return true;
    L24:
        return false;
    L13:
        r16 = false;
        goto L17
    L8:
        if (r0 >= r2) goto L10;
        long r3 = r2 - POSITIVE_ZERO_DOUBLE_BITS;
        long r1 = r0 - NEGATIVE_ZERO_DOUBLE_BITS;
    L11:
        long r7 = r15;
        if (r3 > r7) goto L13;
        if (r1 > (r7 - r3)) goto L13;
    L10:
        long r4 = r0 - POSITIVE_ZERO_DOUBLE_BITS;
        r1 = r2 - NEGATIVE_ZERO_DOUBLE_BITS;
        r3 = r4;
        goto L11
    }

    public static boolean equalsIncludingNaN(double r2, double r4, int r6) {
        if (r2 != r2) goto L9;
        if (r4 != r4) goto L9;
        return equals(r2, r4, r6);
    L9:
        if (r2 == r2) goto L11;
        boolean r7 = true;
    L13:
        if (r4 == r4) goto L15;
        boolean r5 = true;
    L17:
        if ((r5 ^ r7) == true) goto L20;
        return true;
    L20:
        return false;
    L15:
        r5 = false;
        goto L17
    L11:
        r7 = false;
        goto L13
    }

    public static double round(double r1, int r3) {
        return round(r1, r3, 4);
    }

    public static double round(double r3, int r5, int r6) {
        double r7 = new BigDecimal(Double.toString(r3)).setScale(r5, r6).doubleValue();     // Catch: NumberFormatException -> L7
        if (r7 == POSITIVE_ZERO) goto L6;
        return r7;
    L6:
        return r3 * POSITIVE_ZERO;
    L8:
        if (Double.isInfinite(r3) == false) goto L10;
        return r3;
    L10:
        return Double.NaN;
    }

    public static float round(float r1, int r2) {
        return round(r1, r2, 4);
    }

    public static float round(float r5, int r6, int r7) throws MathArithmeticException, MathIllegalArgumentException {
        float r0 = FastMath.copySign(1.0f, r5);
        float r8 = ((float) FastMath.pow(10.0d, r6)) * r0;
        return ((float) roundUnscaled(r5 * r8, r0, r7)) / r8;
    }

    private static double roundUnscaled(double r8, double r10, int r12) throws MathArithmeticException, MathIllegalArgumentException {
        switch(r12) {
            case 0: goto L39;
            case 1: goto L54;
            case 2: goto L34;
            case 3: goto L30;
            case 4: goto L25;
            case 5: goto L21;
            case 6: goto L11;
            case 7: goto L7;
            default: goto L5;
        };
    L11:
        double r11 = r8 - FastMath.floor(r8);
        if (r11 <= 0.5d) goto L15;
        return FastMath.ceil(r8);
    L15:
        if (r11 >= 0.5d) goto L18;
        return FastMath.floor(r8);
    L18:
        if ((FastMath.floor(r8) / 2.0d) != FastMath.floor(FastMath.floor(r8) / 2.0d)) goto L45;
        return FastMath.floor(r8);
    L45:
        return FastMath.ceil(r8);
    L21:
        double r9 = FastMath.nextAfter(r8, Double.NEGATIVE_INFINITY);
        if ((r9 - FastMath.floor(r9)) <= 0.5d) goto L47;
        return FastMath.ceil(r9);
    L47:
        return FastMath.floor(r9);
    L25:
        double r13 = FastMath.nextAfter(r8, Double.POSITIVE_INFINITY);
        if ((r13 - FastMath.floor(r13)) < 0.5d) goto L49;
        return FastMath.ceil(r13);
    L49:
        return FastMath.floor(r13);
    L5:
        throw new MathIllegalArgumentException(LocalizedFormats.INVALID_ROUNDING_METHOD, new Object[]{Integer.valueOf(r12), "ROUND_CEILING", 2, "ROUND_DOWN", 1, "ROUND_FLOOR", 3, "ROUND_HALF_DOWN", 5, "ROUND_HALF_EVEN", 6, "ROUND_HALF_UP", 4, "ROUND_UNNECESSARY", 7, "ROUND_UP", 0});
    L7:
        if (r8 != FastMath.floor(r8)) goto L10;
        return r8;
    L10:
        throw new MathArithmeticException();
    L30:
        if (r10 != (-1.0d)) goto L51;
        return FastMath.ceil(FastMath.nextAfter(r8, Double.POSITIVE_INFINITY));
    L51:
        return FastMath.floor(FastMath.nextAfter(r8, Double.NEGATIVE_INFINITY));
    L34:
        if (r10 != (-1.0d)) goto L53;
        return FastMath.floor(FastMath.nextAfter(r8, Double.NEGATIVE_INFINITY));
    L53:
        return FastMath.ceil(FastMath.nextAfter(r8, Double.POSITIVE_INFINITY));
    L54:
        return FastMath.floor(FastMath.nextAfter(r8, Double.NEGATIVE_INFINITY));
    L39:
        if (r8 != FastMath.floor(r8)) goto L41;
        return r8;
    L41:
        return FastMath.ceil(FastMath.nextAfter(r8, Double.POSITIVE_INFINITY));
    }
}
