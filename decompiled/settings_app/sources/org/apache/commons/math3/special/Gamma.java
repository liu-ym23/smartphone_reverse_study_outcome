package org.apache.commons.math3.special;

import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class Gamma {
    private static final double C_LIMIT = 49.0d;
    private static final double DEFAULT_EPSILON = 1.0E-14d;
    public static final double GAMMA = 0.5772156649015329d;
    private static final double HALF_LOG_2_PI = 0.0d;
    private static final double INV_GAMMA1P_M1_A0 = 6.116095104481416E-9d;
    private static final double INV_GAMMA1P_M1_A1 = 6.247308301164655E-9d;
    private static final double INV_GAMMA1P_M1_B1 = 0.203610414066807d;
    private static final double INV_GAMMA1P_M1_B2 = 0.026620534842894922d;
    private static final double INV_GAMMA1P_M1_B3 = 4.939449793824468E-4d;
    private static final double INV_GAMMA1P_M1_B4 = -8.514194324403149E-6d;
    private static final double INV_GAMMA1P_M1_B5 = -6.4304548177935305E-6d;
    private static final double INV_GAMMA1P_M1_B6 = 9.926418406727737E-7d;
    private static final double INV_GAMMA1P_M1_B7 = -6.077618957228252E-8d;
    private static final double INV_GAMMA1P_M1_B8 = 1.9575583661463974E-10d;
    private static final double INV_GAMMA1P_M1_C = -0.42278433509846713d;
    private static final double INV_GAMMA1P_M1_C0 = 0.5772156649015329d;
    private static final double INV_GAMMA1P_M1_C1 = -0.6558780715202539d;
    private static final double INV_GAMMA1P_M1_C10 = -2.013485478078824E-5d;
    private static final double INV_GAMMA1P_M1_C11 = -1.2504934821426706E-6d;
    private static final double INV_GAMMA1P_M1_C12 = 1.133027231981696E-6d;
    private static final double INV_GAMMA1P_M1_C13 = -2.056338416977607E-7d;
    private static final double INV_GAMMA1P_M1_C2 = -0.04200263503409524d;
    private static final double INV_GAMMA1P_M1_C3 = 0.16653861138229148d;
    private static final double INV_GAMMA1P_M1_C4 = -0.04219773455554433d;
    private static final double INV_GAMMA1P_M1_C5 = -0.009621971527876973d;
    private static final double INV_GAMMA1P_M1_C6 = 0.0072189432466631d;
    private static final double INV_GAMMA1P_M1_C7 = -0.0011651675918590652d;
    private static final double INV_GAMMA1P_M1_C8 = -2.1524167411495098E-4d;
    private static final double INV_GAMMA1P_M1_C9 = 1.280502823881162E-4d;
    private static final double INV_GAMMA1P_M1_P0 = 6.116095104481416E-9d;
    private static final double INV_GAMMA1P_M1_P1 = 6.8716741130671986E-9d;
    private static final double INV_GAMMA1P_M1_P2 = 6.820161668496171E-10d;
    private static final double INV_GAMMA1P_M1_P3 = 4.686843322948848E-11d;
    private static final double INV_GAMMA1P_M1_P4 = 1.5728330277104463E-12d;
    private static final double INV_GAMMA1P_M1_P5 = -1.2494415722763663E-13d;
    private static final double INV_GAMMA1P_M1_P6 = 4.343529937408594E-15d;
    private static final double INV_GAMMA1P_M1_Q1 = 0.3056961078365221d;
    private static final double INV_GAMMA1P_M1_Q2 = 0.054642130860422966d;
    private static final double INV_GAMMA1P_M1_Q3 = 0.004956830093825887d;
    private static final double INV_GAMMA1P_M1_Q4 = 2.6923694661863613E-4d;
    private static final double[] LANCZOS = null;
    public static final double LANCZOS_G = 4.7421875d;
    private static final double SQRT_TWO_PI = 2.5066282746310007d;
    private static final double S_LIMIT = 1.0E-5d;

    static {
        LANCZOS = new double[]{0.9999999999999971d, 57.15623566586292d, -59.59796035547549d, 14.136097974741746d, -0.4919138160976202d, 3.399464998481189E-5d, 4.652362892704858E-5d, -9.837447530487956E-5d, 1.580887032249125E-4d, -2.1026444172410488E-4d, 2.1743961811521265E-4d, -1.643181065367639E-4d, 8.441822398385275E-5d, -2.6190838401581408E-5d, 3.6899182659531625E-6d};
        HALF_LOG_2_PI = FastMath.log(6.283185307179586d) * 0.5d;
    }

    private Gamma() {
    }

    public static double logGamma(double r8) {
        if (Double.isNaN(r8) == false) goto L5;
    L23:
        return Double.NaN;
    L5:
        if (r8 <= 0.0d) goto L23;
        if (r8 >= 0.5d) goto L12;
        return logGamma1p(r8) - FastMath.log(r8);
    L12:
        if (r8 > 2.5d) goto L16;
        return logGamma1p((r8 - 0.5d) - 0.5d);
    L16:
        if (r8 > 8.0d) goto L22;
        int r0 = (int) FastMath.floor(r8 - 1.5d);
        double r2 = 1.0d;
        int r4 = 1;
    L18:
        if (r4 > r0) goto L21;
        r2 = r2 * (r8 - ((double) r4));
        r4 = r4 + 1;
        goto L18
    L21:
        return logGamma1p(r8 - ((double) (r0 + 1))) + FastMath.log(r2);
    L22:
        double r5 = (4.7421875d + r8) + 0.5d;
        return ((((0.5d + r8) * FastMath.log(r5)) - r5) + HALF_LOG_2_PI) + FastMath.log(lanczos(r8) / r8);
    }

    public static double regularizedGammaP(double r7, double r9) {
        return regularizedGammaP(r7, r9, DEFAULT_EPSILON, Integer.MAX_VALUE);
    }

    public static double regularizedGammaP(double r13, double r15, double r17, int r19) {
        if (Double.isNaN(r13) == false) goto L5;
    L33:
        return Double.NaN;
    L5:
        if (Double.isNaN(r15) == true) goto L33;
        double r3 = 0.0d;
        if (r13 <= 0.0d) goto L33;
        if (r15 < 0.0d) goto L33;
        if (r15 != 0.0d) goto L15;
        return 0.0d;
    L15:
        if (r15 >= (r13 + 1.0d)) goto L38;
        double r7 = 1.0d / r13;
        double r9 = r7;
    L19:
        if (FastMath.abs(r7 / r9) <= r17) goto L26;
        if (r3 >= r19) goto L26;
        if (r9 >= Double.POSITIVE_INFINITY) goto L26;
        r3 = r3 + 1.0d;
        r7 = r7 * (r15 / (r13 + r3));
        r9 = r9 + r7;
    L26:
        if (r3 >= r19) goto L32;
        if (Double.isInfinite(r9) == false) goto L40;
        return 1.0d;
    L40:
        return FastMath.exp(((-r15) + (FastMath.log(r15) * r13)) - logGamma(r13)) * r9;
    L32:
        throw new MaxCountExceededException(Integer.valueOf(r19));
    L38:
        return 1.0d - regularizedGammaQ(r13, r15, r17, r19);
    }

    public static double regularizedGammaQ(double r7, double r9) {
        return regularizedGammaQ(r7, r9, DEFAULT_EPSILON, Integer.MAX_VALUE);
    }

    public static double regularizedGammaQ(final double r9, double r11, double r13, int r15) {
        if (Double.isNaN(r9) == false) goto L5;
    L18:
        return Double.NaN;
    L5:
        if (Double.isNaN(r11) == true) goto L18;
        if (r9 <= 0.0d) goto L18;
        if (r11 < 0.0d) goto L18;
        if (r11 != 0.0d) goto L15;
        return 1.0d;
    L15:
        if (r11 >= (r9 + 1.0d)) goto L21;
        return 1.0d - regularizedGammaP(r9, r11, r13, r15);
    L21:
        return (1.0d / new AnonymousClass1(r9).evaluate(r11, r13, r15)) * FastMath.exp(((-r11) + (FastMath.log(r11) * r9)) - logGamma(r9));
    }

    public static double digamma(double r7) {
        if (Double.isNaN(r7) == false) goto L5;
    L19:
        return r7;
    L5:
        if (Double.isInfinite(r7) == true) goto L19;
        if (r7 <= 0.0d) goto L16;
        if (r7 > 1.0E-5d) goto L16;
        double r3 = -0.5772156649015329d;
    L12:
        double r1 = 1.0d / r7;
    L14:
        return r3 - r1;
    L16:
        if (r7 < C_LIMIT) goto L18;
        double r2 = 1.0d / (r7 * r7);
        r3 = FastMath.log(r7) - (0.5d / r7);
        r1 = r2 * (((0.008333333333333333d - (r2 / 252.0d)) * r2) + 0.08333333333333333d);
        goto L14
    L18:
        r3 = digamma(r7 + 1.0d);
        goto L12
    }

    public static double trigamma(double r9) {
        if (Double.isNaN(r9) == false) goto L5;
    L19:
        return r9;
    L5:
        if (Double.isInfinite(r9) == true) goto L19;
        if (r9 <= 0.0d) goto L14;
        if (r9 > 1.0E-5d) goto L14;
        return 1.0d / (r9 * r9);
    L14:
        if (r9 < C_LIMIT) goto L18;
        double r3 = 1.0d / (r9 * r9);
        return ((1.0d / r9) + (r3 / 2.0d)) + ((r3 / r9) * (0.16666666666666666d - (r3 * ((r3 / 42.0d) + 0.03333333333333333d))));
    L18:
        return trigamma(r9 + 1.0d) + (1.0d / (r9 * r9));
    }

    public static double lanczos(double r7) {
        int r0 = LANCZOS.length - 1;
        double r1 = 0.0d;
    L3:
        if (r0 <= 0) goto L6;
        r1 = r1 + (LANCZOS[r0] / (((double) r0) + r7));
        r0 = r0 - 1;
        goto L3
    L6:
        return r1 + LANCZOS[0];
    }

    public static double invGamma1pm1(double r39) {
        if (r39 < (-0.5d)) goto L24;
        if (r39 > 1.5d) goto L22;
        if (r39 > 0.5d) goto L9;
        double r2 = r39;
    L11:
        if (r2 >= 0.0d) goto L16;
        double r35 = ((((((((((((((((((((((((((((((INV_GAMMA1P_M1_A1 * r2) + 6.116095104481416E-9d) / ((((((((((((((((INV_GAMMA1P_M1_B8 * r2) + INV_GAMMA1P_M1_B7) * r2) + INV_GAMMA1P_M1_B6) * r2) + INV_GAMMA1P_M1_B5) * r2) + INV_GAMMA1P_M1_B4) * r2) + INV_GAMMA1P_M1_B3) * r2) + INV_GAMMA1P_M1_B2) * r2) + INV_GAMMA1P_M1_B1) * r2) + 1.0d)) * r2) + INV_GAMMA1P_M1_C13) * r2) + INV_GAMMA1P_M1_C12) * r2) + INV_GAMMA1P_M1_C11) * r2) + INV_GAMMA1P_M1_C10) * r2) + INV_GAMMA1P_M1_C9) * r2) + INV_GAMMA1P_M1_C8) * r2) + INV_GAMMA1P_M1_C7) * r2) + INV_GAMMA1P_M1_C6) * r2) + INV_GAMMA1P_M1_C5) * r2) + INV_GAMMA1P_M1_C4) * r2) + INV_GAMMA1P_M1_C3) * r2) + INV_GAMMA1P_M1_C2) * r2) + INV_GAMMA1P_M1_C1) * r2) + INV_GAMMA1P_M1_C;
        if (r39 <= 0.5d) goto L26;
        return (r2 * r35) / r39;
    L26:
        return r39 * ((r35 + 0.5d) + 0.5d);
    L16:
        double r37 = ((((((((((((((((((((((((((((((((((((((((INV_GAMMA1P_M1_P6 * r2) + INV_GAMMA1P_M1_P5) * r2) + INV_GAMMA1P_M1_P4) * r2) + INV_GAMMA1P_M1_P3) * r2) + INV_GAMMA1P_M1_P2) * r2) + INV_GAMMA1P_M1_P1) * r2) + 6.116095104481416E-9d) / ((((((((INV_GAMMA1P_M1_Q4 * r2) + INV_GAMMA1P_M1_Q3) * r2) + INV_GAMMA1P_M1_Q2) * r2) + INV_GAMMA1P_M1_Q1) * r2) + 1.0d)) * r2) + INV_GAMMA1P_M1_C13) * r2) + INV_GAMMA1P_M1_C12) * r2) + INV_GAMMA1P_M1_C11) * r2) + INV_GAMMA1P_M1_C10) * r2) + INV_GAMMA1P_M1_C9) * r2) + INV_GAMMA1P_M1_C8) * r2) + INV_GAMMA1P_M1_C7) * r2) + INV_GAMMA1P_M1_C6) * r2) + INV_GAMMA1P_M1_C5) * r2) + INV_GAMMA1P_M1_C4) * r2) + INV_GAMMA1P_M1_C3) * r2) + INV_GAMMA1P_M1_C2) * r2) + INV_GAMMA1P_M1_C1) * r2) + 0.5772156649015329d;
        if (r39 <= 0.5d) goto L20;
        return (r2 / r39) * ((r37 - 0.5d) - 0.5d);
    L20:
        return r39 * r37;
    L9:
        r2 = (r39 - 0.5d) - 0.5d;
        goto L11
    L22:
        throw new NumberIsTooLargeException(Double.valueOf(r39), Double.valueOf(1.5d), true);
    L24:
        throw new NumberIsTooSmallException(Double.valueOf(r39), Double.valueOf(-0.5d), true);
    }

    public static double logGamma1p(double r4) throws NumberIsTooSmallException, NumberIsTooLargeException {
        if (r4 < (-0.5d)) goto L11;
        if (r4 > 1.5d) goto L9;
        return -FastMath.log1p(invGamma1pm1(r4));
    L9:
        throw new NumberIsTooLargeException(Double.valueOf(r4), Double.valueOf(1.5d), true);
    L11:
        throw new NumberIsTooSmallException(Double.valueOf(r4), Double.valueOf(-0.5d), true);
    }

    public static double gamma(double r11) {
        if (r11 == FastMath.rint(r11)) goto L5;
    L8:
        double r3 = FastMath.abs(r11);
        if (r3 <= 20.0d) goto L11;
        double r5 = (4.7421875d + r3) + 0.5d;
        double r4 = lanczos(r3) * (((SQRT_TWO_PI / r3) * FastMath.pow(r5, 0.5d + r3)) * FastMath.exp(-r5));
        if (r11 <= 0.0d) goto L26;
        return r4;
    L26:
        return (-3.141592653589793d) / ((r11 * FastMath.sin(3.141592653589793d * r11)) * r4);
    L11:
        if (r11 < 1.0d) goto L17;
        double r2 = 1.0d;
    L14:
        if (r11 <= 2.5d) goto L29;
        r11 = r11 - 1.0d;
        r2 = r2 * r11;
        goto L14
    L29:
        return r2 / (invGamma1pm1(r11 - 1.0d) + 1.0d);
    L17:
        double r6 = r11;
    L19:
        if (r11 >= (-0.5d)) goto L30;
        r11 = r11 + 1.0d;
        r6 = r6 * r11;
        goto L19
    L30:
        return 1.0d / (r6 * (invGamma1pm1(r11) + 1.0d));
    L5:
        if (r11 > 0.0d) goto L8;
        return Double.NaN;
    }
}
