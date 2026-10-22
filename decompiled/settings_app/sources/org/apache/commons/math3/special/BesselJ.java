package org.apache.commons.math3.special;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class BesselJ implements UnivariateFunction {
    private static final double ENMTEN = 8.9E-308d;
    private static final double ENSIG = 1.0E16d;
    private static final double ENTEN = 1.0E308d;
    private static final double[] FACT = null;
    private static final double PI2 = 0.6366197723675814d;
    private static final double RTNSIG = 1.0E-4d;
    private static final double TOWPI1 = 6.28125d;
    private static final double TWOPI = 6.283185307179586d;
    private static final double TWOPI2 = 0.001935307179586477d;
    private static final double X_MAX = 10000.0d;
    private static final double X_MIN = 0.0d;
    private final double order;

    public static class BesselJResult {
        private final int nVals;
        private final double[] vals;

        static /* synthetic */ int access$000(BesselJResult r0) {
            return r0.nVals;
        }

        static /* synthetic */ double[] access$100(BesselJResult r0) {
            return r0.vals;
        }

        public BesselJResult(double[] r2, int r3) {
            this.vals = MathArrays.copyOf(r2, r2.length);
            this.nVals = r3;
        }

        public double[] getVals() {
            double[] r1 = this.vals;
            return MathArrays.copyOf(r1, r1.length);
        }

        public int getnVals() {
            return this.nVals;
        }
    }

    static {
        FACT = new double[]{1.0d, 1.0d, 2.0d, 6.0d, 24.0d, 120.0d, 720.0d, 5040.0d, 40320.0d, 362880.0d, 3628800.0d, 3.99168E7d, 4.790016E8d, 6.2270208E9d, 8.71782912E10d, 1.307674368E12d, 2.0922789888E13d, 3.55687428096E14d, 6.402373705728E15d, 1.21645100408832E17d, 2.43290200817664E18d, 5.109094217170944E19d, 1.1240007277776077E21d, 2.585201673888498E22d, 6.204484017332394E23d};
    }

    public BesselJ(double r1) {
        this.order = r1;
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double r3) throws MathIllegalArgumentException, ConvergenceException {
        return value(this.order, r3);
    }

    public static double value(double r10, double r12) throws MathIllegalArgumentException, ConvergenceException {
        int r0 = (int) r10;
        int r3 = r0 + 1;
        BesselJResult r1 = rjBesl(r12, r10 - ((double) r0), r3);
        if (BesselJResult.access$000(r1) < r3) goto L7;
        return BesselJResult.access$100(r1)[r0];
    L7:
        if (BesselJResult.access$000(r1) < 0) goto L15;
        if (FastMath.abs(BesselJResult.access$100(r1)[BesselJResult.access$000(r1) - 1]) >= 1.0E-100d) goto L13;
        return BesselJResult.access$100(r1)[r0];
    L13:
        throw new ConvergenceException(LocalizedFormats.BESSEL_FUNCTION_FAILED_CONVERGENCE, new Object[]{Double.valueOf(r10), Double.valueOf(r12)});
    L15:
        throw new MathIllegalArgumentException(LocalizedFormats.BESSEL_FUNCTION_BAD_ARGUMENT, new Object[]{Double.valueOf(r10), Double.valueOf(r12)});
    }

    public static BesselJResult rjBesl(double r52, double r54, int r56) {
        double[] r5 = new double[r56];
        int r6 = (int) r52;
        int r7 = 0;
        double r8 = 0.0d;
        int r10 = 1;
        if (r56 > 0) goto L5;
    L181:
        int r0 = r56;
        if (r0 <= 0) goto L184;
        r5[0] = 0.0d;
    L184:
        r7 = FastMath.min(r0, 0) - 1;
    L186:
        return new BesselJResult(MathArrays.copyOf(r5, r0), r7);
    L5:
        if (r52 < 0.0d) goto L181;
        if (r52 > X_MAX) goto L181;
        if (r54 < 0.0d) goto L181;
        if (r54 >= 1.0d) goto L181;
        int r15 = 0;
    L13:
        if (r15 >= r56) goto L15;
        r5[r15] = 0.0d;
        r15 = r15 + 1;
        goto L13
    L15:
        double r16 = ENMTEN;
        if (r52 >= RTNSIG) goto L55;
        double r20 = r54 + 1.0d;
        if (r52 <= ENMTEN) goto L20;
        r8 = 0.5d * r52;
    L20:
        if (r54 == 0.0d) goto L22;
        double r18 = FastMath.pow(r8, r54) / (r54 * Gamma.gamma(r54));
    L24:
        if ((r52 + 1.0d) <= 1.0d) goto L26;
        double r2 = (-r8) * r8;
    L27:
        double r24 = r18 + ((r18 * r2) / r20);
        r5[0] = r24;
        if (r52 == 0.0d) goto L32;
        double r11 = 0.0d;
        if (r24 == 0.0d) goto L34;
    L33:
        r7 = r56;
    L34:
        if (r56 != 1) goto L36;
    L53:
        r0 = r56;
        goto L186
    L36:
        if (r52 > r11) goto L40;
    L37:
        if (r10 >= r56) goto L53;
        r5[r10] = r11;
        r10 = r10 + 1;
        goto L37
    L40:
        if (r2 == r11) goto L42;
        double r17 = ENMTEN / r2;
    L43:
        if (r10 >= r56) goto L53;
        double r19 = r18 / r20;
        r20 = r20 + 1.0d;
        double r1 = r19 * r8;
        if (r1 > (r17 * r20)) goto L47;
        r18 = 0.0d;
    L48:
        double r3 = r18 + ((r18 * r2) / r20);
        r5[r10] = r3;
        if (r3 != 0.0d) goto L52;
        if (r7 <= r10) goto L52;
        r7 = r10;
    L52:
        r10 = r10 + 1;
        goto L43
    L47:
        r18 = r1;
        goto L48
    L42:
        r17 = 1.78E-307d / r52;
        goto L43
    L32:
        r11 = 0.0d;
        goto L33
    L26:
        r2 = 0.0d;
        goto L27
    L22:
        r18 = 1.0d;
        goto L24
    L55:
        if (r52 > 25.0d) goto L57;
    L81:
        int r9 = r6 + 1;
        double r12 = (((double) r9) + r54) * 2.0d;
        double r13 = r12 / r52;
        double r21 = 2.0E16d;
        if ((r56 - r6) < 3) goto L104;
        int r14 = r6 + 2;
        int r22 = r56 - 1;
        double r110 = 2.0d;
        r12 = (((double) (r14 - 1)) + r54) * 2.0d;
        double r26 = r13;
        double r111 = 1.0d;
    L84:
        int r50 = r9;
        r9 = r14;
        int r23 = r50;
        if (r9 > r22) goto L100;
        r12 = r12 + r110;
        double r112 = ((r12 * r26) / r52) - r111;
        if (r112 > 1.0E292d) goto L88;
        r14 = r9 + 1;
        r111 = r26;
        r26 = r112;
        r110 = 2.0d;
        goto L84
    L88:
        double r33 = r112 / ENTEN;
        double r35 = r26 / ENTEN;
        int r25 = r9 + 1;
        double r27 = r33;
        double r113 = r35;
    L89:
        r9 = r9 + 1;
        r12 = r12 + 2.0d;
        double r28 = ((r12 * r27) / r52) - r113;
        if (r28 > 1.0d) goto L91;
        r113 = r27;
        r27 = r28;
        goto L89
    L91:
        double r29 = r12 / r52;
        double r114 = ((r113 * r27) * (0.5d - (0.5d / (r29 * r29)))) / ENSIG;
        r13 = ENTEN * r27;
        int r30 = r9 - 1;
        r12 = r12 - 2.0d;
        int r31 = FastMath.min(r56, r30);
    L92:
        if (r25 > r31) goto L97;
        double r210 = ((r12 * r33) / r52) - r35;
        if ((r210 * r33) > r114) goto L97;
        r25 = r25 + 1;
        r35 = r33;
        r33 = r210;
    L97:
        r23 = r30;
        boolean r211 = true;
        r9 = r31;
    L101:
        if (r211 == true) goto L103;
        double r212 = 2.0d;
        r12 = (((double) r9) + r54) * 2.0d;
        double r32 = FastMath.max(r114, FastMath.sqrt(ENSIG * r27) * FastMath.sqrt(r13 * 2.0d));
        double r115 = r27;
        r21 = r32;
        int r34 = r31;
    L106:
        if (r211 == true) goto L111;
    L107:
        r9 = r9 + 1;
        r12 = r12 + r212;
        double r116 = ((r12 * r13) / r52) - r115;
        if (r116 >= r21) goto L109;
        double r51 = r13;
        r13 = r116;
        r115 = r51;
        goto L107
    L109:
        r13 = r116;
    L111:
        int r36 = r9 + 1;
        double r117 = r12 + r212;
        double r118 = 1.0d / r13;
        int r37 = r36 / 2;
        int r38 = (r36 * 2) - (r37 * 4);
        int r213 = r34;
        double r39 = r37;
        double r214 = (r39 - 1.0d) + r54;
        double r310 = (r39 * 2.0d) + r54;
        if (r38 == 0) goto L114;
        double r119 = ((r214 * r118) * r310) / r39;
    L115:
        int r40 = r36 - r56;
        double r215 = r118;
        int r4 = 1;
        double r120 = 0.0d;
    L116:
        if (r4 > r40) goto L127;
        r36 = r36 - 1;
        r117 = r117 - 2.0d;
        double r311 = ((r117 * r215) / r52) - r120;
        r38 = 2 - r38;
        if (r38 == 0) goto L126;
        r39 = r39 - 1.0d;
        double r312 = (r39 * 2.0d) + r54;
        if (r36 == 1) goto L121;
        double r121 = (r39 - 1.0d) + r54;
        if (r121 != 0.0d) goto L125;
        r121 = 1.0d;
    L125:
        r119 = ((r119 + (r312 * r311)) * r121) / r39;
        goto L126
    L121:
        r120 = r215;
        r215 = r311;
    L126:
        r4 = r4 + 1;
        r120 = r215;
        r215 = r311;
    L127:
        r5[r36 - 1] = r215;
        if (r40 >= 0) goto L130;
    L145:
        boolean r41 = false;
    L146:
        boolean r122 = false;
    L147:
        if (r41 == true) goto L160;
        if (r122 == true) goto L160;
        int r123 = r36 - 2;
        if (r123 == 0) goto L160;
        int r42 = 1;
    L152:
        if (r42 > r123) goto L160;
        r36 = r36 - 1;
        r117 = r117 - 2.0d;
        double r313 = ((r5[r36] * r117) / r52) - r5[r36 + 1];
        r5[r36 - 1] = r313;
        r38 = 2 - r38;
        if (r38 == 0) goto L159;
        r39 = r39 - 1.0d;
        double r314 = (r39 * 2.0d) + r54;
        double r216 = (r39 - 1.0d) + r54;
        if (r216 != 0.0d) goto L158;
        r216 = 1.0d;
    L158:
        r119 = ((r119 + (r313 * r314)) * r216) / r39;
    L159:
        r42 = r42 + 1;
    L160:
        if (r41 == true) goto L169;
        if (r122 == true) goto L163;
        double r43 = 1.0d;
        double r217 = 2.0d;
        char r44 = 0;
        r5[0] = ((((r54 + 1.0d) * 2.0d) * r5[1]) / r52) - r5[2];
    L164:
        double r45 = ((r39 - r43) * r217) + r54;
        if (r45 != 0.0d) goto L167;
        r45 = 1.0d;
    L167:
        r119 = r119 + (r5[r44] * r45);
        goto L169
    L163:
        r44 = 0;
        r43 = 1.0d;
        r217 = 2.0d;
    L169:
        if (FastMath.abs(r54) <= 1.0E-16d) goto L172;
        r119 = r119 * (Gamma.gamma(r54) * FastMath.pow(r52 * 0.5d, -r54));
    L172:
        if (r119 <= 1.0d) goto L174;
        r16 = ENMTEN * r119;
    L174:
        r0 = r56;
        int r46 = 0;
    L175:
        if (r46 >= r0) goto L180;
        if (FastMath.abs(r5[r46]) >= r16) goto L179;
        r5[r46] = 0.0d;
    L179:
        r5[r46] = r5[r46] / r119;
        r46 = r46 + 1;
        goto L175
    L180:
        r7 = r213;
        goto L186
    L130:
        if (r56 <= 1) goto L132;
        r36 = r36 - 1;
        r117 = r117 - 2.0d;
        double r218 = ((r215 * r117) / r52) - r120;
        r5[r36 - 1] = r218;
        if (r36 != 1) goto L139;
        r41 = false;
        r122 = true;
        goto L147
    L139:
        r38 = 2 - r38;
        if (r38 == 0) goto L145;
        r39 = r39 - 1.0d;
        double r315 = (r39 * 2.0d) + r54;
        double r124 = (r39 - 1.0d) + r54;
        if (r124 != 0.0d) goto L144;
        r124 = 1.0d;
    L144:
        r119 = ((r119 + (r218 * r315)) * r124) / r39;
        goto L145
    L132:
        if ((r54 + 1.0d) != 1.0d) goto L134;
        char r47 = 0;
        double r125 = 1.0d;
    L135:
        r119 = r119 + (r5[r47] * r125);
        r41 = true;
        goto L146
    L134:
        r125 = r54;
        r47 = 0;
        goto L135
    L114:
        r119 = 0.0d;
        goto L115
    L103:
        r212 = 2.0d;
        r9 = r23;
        r34 = r31;
        double r53 = r114;
        r115 = r27;
        r21 = r53;
        goto L106
    L100:
        r9 = r22;
        r114 = 2.0E16d;
        r31 = r56;
        r27 = r111;
        r13 = r26;
        r211 = false;
        goto L101
    L104:
        r212 = 2.0d;
        r34 = r56;
        r115 = 1.0d;
        r211 = false;
        goto L106
    L57:
        if (r56 > (r6 + 1)) goto L81;
        double r126 = FastMath.sqrt(PI2 / r52);
        double r219 = 0.125d / r52;
        double r220 = r219 * r219;
        if (r52 < 130.0d) goto L62;
        int r48 = 4;
    L65:
        double r127 = ((double) r48) * 4.0d;
        double r49 = (int) ((r52 / 6.283185307179586d) + 0.5d);
        double r221 = ((r52 - (TOWPI1 * r49)) - (r49 * TWOPI2)) - ((r54 + 0.5d) / PI2);
        double r55 = FastMath.sin(r221);
        double r57 = FastMath.cos(r221);
        double r58 = r54 * 2.0d;
        double r316 = r58;
        int r128 = 1;
        int r129 = 2;
    L66:
        if (r128 > r129) goto L76;
        double r317 = r127 - 1.0d;
        double r318 = (((r317 - r316) * (r317 + r316)) * r220) * 0.5d;
        double r319 = r127 - 3.0d;
        double r320 = (r316 - r319) * (r316 + r319);
        double[] r130 = FACT;
        int r131 = r48 * 2;
        double r321 = (r318 * r320) / r130[r131];
        double r410 = r127 + 1.0d;
        double r322 = (r318 * ((r316 - r410) * (r316 + r410))) / r130[r131 + 1];
        double r411 = r127;
        int r132 = 2;
    L68:
        if (r132 > r48) goto L70;
        r411 = r411 - 4.0d;
        double r412 = r411 - 1.0d;
        double r413 = (r412 - r316) * (r412 + r316);
        double r414 = r411 - 3.0d;
        double r415 = (r316 + r414) * (r316 - r414);
        double[] r416 = FACT;
        r321 = (((r321 + (1.0d / r416[r131 - 2])) * r413) * r415) * r220;
        r322 = (((r322 + (1.0d / r416[r131 - 1])) * r413) * r320) * r220;
        r131 = r131 - 2;
        r132 = r132 + 1;
        r320 = r415;
        goto L68
    L70:
        r5[r128 - 1] = (((r321 + 1.0d) * r57) - ((((r322 + 1.0d) * ((r316 * r316) - 1.0d)) * r219) * r55)) * r126;
        if (r56 == 1) goto L73;
        r316 = r316 + 2.0d;
        r128 = r128 + 1;
        r129 = 2;
        double r59 = r55;
        r55 = -r57;
        r57 = r59;
        goto L66
    L73:
        return new BesselJResult(MathArrays.copyOf(r5, r56), r56);
    L76:
        if (r56 <= r129) goto L80;
        double r60 = r58 + 2.0d;
        int r61 = 2;
    L78:
        if (r61 >= r56) goto L80;
        r5[r61] = ((r5[r61 - 1] * r60) / r52) - r5[r61 - 2];
        r60 = r60 + 2.0d;
        r61 = r61 + 1;
    L80:
        r0 = r56;
        r7 = r0;
        goto L186
    L62:
        if (r52 < 35.0d) goto L64;
        r48 = 8;
        goto L65
    L64:
        r48 = 11;
        goto L65
    }
}
