package org.apache.commons.math3.distribution;

import org.apache.commons.math3.special.Gamma;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
final class SaddlePointExpansion {
    private static final double[] EXACT_STIRLING_ERRORS = null;
    private static final double HALF_LOG_2_PI = 0.0d;

    static {
        HALF_LOG_2_PI = FastMath.log(6.283185307179586d) * 0.5d;
        EXACT_STIRLING_ERRORS = new double[]{0.0d, 0.15342640972002736d, 0.08106146679532726d, 0.05481412105191765d, 0.0413406959554093d, 0.03316287351993629d, 0.02767792568499834d, 0.023746163656297496d, 0.020790672103765093d, 0.018488450532673187d, 0.016644691189821193d, 0.015134973221917378d, 0.013876128823070748d, 0.012810465242920227d, 0.01189670994589177d, 0.011104559758206917d, 0.010411265261972096d, 0.009799416126158804d, 0.009255462182712733d, 0.008768700134139386d, 0.00833056343336287d, 0.00793411456431402d, 0.007573675487951841d, 0.007244554301320383d, 0.00694284010720953d, 0.006665247032707682d, 0.006408994188004207d, 0.006171712263039458d, 0.0059513701127588475d, 0.0057462165130101155d, 0.005554733551962801d};
    }

    private SaddlePointExpansion() {
    }

    static double getStirlingError(double r6) {
        if (r6 >= 15.0d) goto L8;
        double r0 = 2.0d * r6;
        if (FastMath.floor(r0) != r0) goto L11;
        return EXACT_STIRLING_ERRORS[(int) r0];
    L11:
        return ((Gamma.logGamma(1.0d + r6) - ((0.5d + r6) * FastMath.log(r6))) + r6) - HALF_LOG_2_PI;
    L8:
        double r1 = r6 * r6;
        return (0.08333333333333333d - ((0.002777777777777778d - ((7.936507936507937E-4d - ((5.952380952380953E-4d - (8.417508417508417E-4d / r1)) / r1)) / r1)) / r1)) / r6;
    }

    static double getDeviancePart(double r10, double r12) {
        double r0 = r10 - r12;
        double r4 = r10 + r12;
        if (FastMath.abs(r0) >= (0.1d * r4)) goto L9;
        double r13 = r0 / r4;
        double r1 = r0 * r13;
        double r11 = (r10 * 2.0d) * r13;
        double r14 = r13 * r13;
        double r3 = Double.NaN;
        int r5 = 1;
    L6:
        if (r1 == r3) goto L11;
        r11 = r11 * r14;
        double r6 = (r11 / ((double) ((r5 * 2) + 1))) + r1;
        r5 = r5 + 1;
        double r8 = r1;
        r1 = r6;
        r3 = r8;
        goto L6
    L11:
        return r1;
    L9:
        return ((FastMath.log(r10 / r12) * r10) + r12) - r10;
    }

    static double logBinomialProbability(int r8, int r9, double r10, double r12) {
        if (r8 == 0) goto L5;
        if (r8 == r9) goto L11;
        double r0 = r9;
        double r4 = r8;
        double r11 = r9 - r8;
        return (FastMath.log(((r4 * 6.283185307179586d) * r11) / r0) * (-0.5d)) + ((((getStirlingError(r0) - getStirlingError(r4)) - getStirlingError(r11)) - getDeviancePart(r4, r10 * r0)) - getDeviancePart(r11, r12 * r0));
    L11:
        if (r12 >= 0.1d) goto L13;
        double r13 = r9;
        return (-getDeviancePart(r13, r10 * r13)) - (r13 * r12);
    L13:
        double r14 = r9;
        double r15 = FastMath.log(r10);
    L17:
        return r14 * r15;
    L5:
        if (r10 >= 0.1d) goto L7;
        double r16 = r9;
        return (-getDeviancePart(r16, r12 * r16)) - (r16 * r10);
    L7:
        r14 = r9;
        r15 = FastMath.log(r12);
        goto L17
    }
}
