package org.apache.commons.math3.util;

import java.util.Arrays;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public final class MathUtils {
    public static final double PI_SQUARED = 9.869604401089358d;
    public static final double TWO_PI = 6.283185307179586d;

    private MathUtils() {
    }

    public static int hash(double r1) {
        return new Double(r1).hashCode();
    }

    public static boolean equals(double r1, double r3) {
        return new Double(r1).equals(new Double(r3));
    }

    public static int hash(double[] r0) {
        return Arrays.hashCode(r0);
    }

    public static double normalizeAngle(double r2, double r4) {
        return r2 - (FastMath.floor(((3.141592653589793d + r2) - r4) / 6.283185307179586d) * 6.283185307179586d);
    }

    public static <T extends RealFieldElement<T>> T max(T r4, T r5) {
        if (((RealFieldElement) r4.subtract(r5)).getReal() < 0.0d) goto L6;
        return r4;
    L6:
        return r5;
    }

    public static <T extends RealFieldElement<T>> T min(T r4, T r5) {
        if (((RealFieldElement) r4.subtract(r5)).getReal() >= 0.0d) goto L5;
        return r4;
    L5:
        return r5;
    }

    public static double reduce(double r2, double r4, double r6) {
        double r5 = FastMath.abs(r4);
        return (r2 - (r5 * FastMath.floor((r2 - r6) / r5))) - r6;
    }

    public static byte copySign(byte r1, byte r2) throws MathArithmeticException {
        if (r1 < 0) goto L4;
        if (r2 < 0) goto L4;
    L6:
        return r1;
    L4:
        if (r1 >= 0) goto L7;
        if (r2 < 0) goto L6;
    L7:
        if (r2 < 0) goto L14;
        if (r1 != (-128)) goto L14;
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW, new Object[0]);
    L14:
        return (byte) (-r1);
    }

    public static short copySign(short r1, short r2) throws MathArithmeticException {
        if (r1 < 0) goto L4;
        if (r2 < 0) goto L4;
    L6:
        return r1;
    L4:
        if (r1 >= 0) goto L7;
        if (r2 < 0) goto L6;
    L7:
        if (r2 < 0) goto L14;
        if (r1 != Short.MIN_VALUE) goto L14;
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW, new Object[0]);
    L14:
        return (short) (-r1);
    }

    public static int copySign(int r1, int r2) throws MathArithmeticException {
        if (r1 < 0) goto L4;
        if (r2 < 0) goto L4;
    L6:
        return r1;
    L4:
        if (r1 >= 0) goto L7;
        if (r2 < 0) goto L6;
    L7:
        if (r2 < 0) goto L14;
        if (r1 != Integer.MIN_VALUE) goto L14;
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW, new Object[0]);
    L14:
        return -r1;
    }

    public static long copySign(long r4, long r6) throws MathArithmeticException {
        if (r4 >= 0) goto L5;
    L6:
        if (r4 >= 0) goto L11;
        if (r6 >= 0) goto L11;
    L9:
        return r4;
    L11:
        if (r6 < 0) goto L18;
        if (r4 != Long.MIN_VALUE) goto L18;
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW, new Object[0]);
    L18:
        return -r4;
    L5:
        if (r6 >= 0) goto L9;
        goto L6
    }

    public static void checkFinite(double r1) throws NotFiniteNumberException {
        if (Double.isInfinite(r1) == true) goto L8;
        if (Double.isNaN(r1) == true) goto L8;
        return;
    L8:
        throw new NotFiniteNumberException(Double.valueOf(r1), new Object[0]);
    }

    public static void checkFinite(double[] r5) throws NotFiniteNumberException {
        int r1 = 0;
    L4:
        if (r1 >= r5.length) goto L12;
        double r2 = r5[r1];
        if (Double.isInfinite(r2) == true) goto L11;
        if (Double.isNaN(r2) == true) goto L11;
        r1 = r1 + 1;
    L11:
        throw new NotFiniteNumberException(LocalizedFormats.ARRAY_ELEMENT, Double.valueOf(r2), new Object[]{Integer.valueOf(r1)});
    }

    public static void checkNotNull(Object r0, Localizable r1, Object... r2) throws NullArgumentException {
        if (r0 == null) goto L5;
        return;
    L5:
        throw new NullArgumentException(r1, r2);
    }

    public static void checkNotNull(Object r0) throws NullArgumentException {
        if (r0 == null) goto L5;
        return;
    L5:
        throw new NullArgumentException();
    }
}
