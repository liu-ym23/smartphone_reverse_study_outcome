package org.apache.commons.math3.util;

import com.ttnet.org.chromium.net.NetError;
import cz.msebera.android.httpclient.impl.client.cache.CacheValidityPolicy;
import java.io.PrintStream;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class FastMath {
    private static final double[] CBRTTWO = null;
    private static final double[] COSINE_TABLE_A = null;
    private static final double[] COSINE_TABLE_B = null;
    public static final double E = 2.718281828459045d;
    private static final double[] EIGHTHS = null;
    static final int EXP_FRAC_TABLE_LEN = 1025;
    static final int EXP_INT_TABLE_LEN = 1500;
    static final int EXP_INT_TABLE_MAX_INDEX = 750;
    private static final double F_11_12 = 0.9166666666666666d;
    private static final double F_13_14 = 0.9285714285714286d;
    private static final double F_15_16 = 0.9375d;
    private static final double F_1_11 = 0.09090909090909091d;
    private static final double F_1_13 = 0.07692307692307693d;
    private static final double F_1_15 = 0.06666666666666667d;
    private static final double F_1_17 = 0.058823529411764705d;
    private static final double F_1_2 = 0.5d;
    private static final double F_1_3 = 0.3333333333333333d;
    private static final double F_1_4 = 0.25d;
    private static final double F_1_5 = 0.2d;
    private static final double F_1_7 = 0.14285714285714285d;
    private static final double F_1_9 = 0.1111111111111111d;
    private static final double F_3_4 = 0.75d;
    private static final double F_5_6 = 0.8333333333333334d;
    private static final double F_7_8 = 0.875d;
    private static final double F_9_10 = 0.9d;
    private static final long HEX_40000000 = 1073741824;
    private static final long IMPLICIT_HIGH_BIT = 4503599627370496L;
    private static final double LN_2_A = 0.6931470632553101d;
    private static final double LN_2_B = 1.1730463525082348E-7d;
    private static final double[][] LN_HI_PREC_COEF = null;
    static final int LN_MANT_LEN = 1024;
    private static final double[][] LN_QUICK_COEF = null;
    private static final double LOG_MAX_VALUE = 0.0d;
    private static final long MASK_30BITS = -1073741824;
    private static final long MASK_DOUBLE_EXPONENT = 9218868437227405312L;
    private static final long MASK_DOUBLE_MANTISSA = 4503599627370495L;
    private static final int MASK_NON_SIGN_INT = Integer.MAX_VALUE;
    private static final long MASK_NON_SIGN_LONG = Long.MAX_VALUE;
    public static final double PI = 3.141592653589793d;
    private static final long[] PI_O_4_BITS = null;
    private static final long[] RECIP_2PI = null;
    private static final boolean RECOMPUTE_TABLES_AT_RUNTIME = false;
    private static final double[] SINE_TABLE_A = null;
    private static final double[] SINE_TABLE_B = null;
    private static final int SINE_TABLE_LEN = 14;
    private static final double[] TANGENT_TABLE_A = null;
    private static final double[] TANGENT_TABLE_B = null;
    private static final double TWO_POWER_52 = 4.503599627370496E15d;

    private static class CodyWaite {
        private final int finalK;
        private final double finalRemA;
        private final double finalRemB;

        CodyWaite(double r12) {
            int r0 = (int) (0.6366197723675814d * r12);
        L3:
            double r1 = -r0;
            double r3 = 1.570796251296997d * r1;
            double r5 = r12 + r3;
            double r7 = 7.549789948768648E-8d * r1;
            double r9 = r7 + r5;
            double r4 = (-((r5 - r12) - r3)) + (-((r9 - r5) - r7));
            double r2 = r1 * 6.123233995736766E-17d;
            double r6 = r2 + r9;
            double r8 = r4 + (-((r6 - r9) - r2));
            if (r6 > 0.0d) goto L5;
            r0 = r0 - 1;
            goto L3
        L5:
            this.finalK = r0;
            this.finalRemA = r6;
            this.finalRemB = r8;
        }

        int getK() {
            return this.finalK;
        }

        double getRemA() {
            return this.finalRemA;
        }

        double getRemB() {
            return this.finalRemB;
        }
    }

    private static class ExpFracTable {
        private static final double[] EXP_FRAC_TABLE_A = null;
        private static final double[] EXP_FRAC_TABLE_B = null;

        private ExpFracTable() {
        }

        static /* synthetic */ double[] access$200() {
            return EXP_FRAC_TABLE_A;
        }

        static /* synthetic */ double[] access$300() {
            return EXP_FRAC_TABLE_B;
        }

        static {
            EXP_FRAC_TABLE_A = FastMathLiteralArrays.loadExpFracA();
            EXP_FRAC_TABLE_B = FastMathLiteralArrays.loadExpFracB();
        }
    }

    private static class ExpIntTable {
        private static final double[] EXP_INT_TABLE_A = null;
        private static final double[] EXP_INT_TABLE_B = null;

        private ExpIntTable() {
        }

        static /* synthetic */ double[] access$000() {
            return EXP_INT_TABLE_A;
        }

        static /* synthetic */ double[] access$100() {
            return EXP_INT_TABLE_B;
        }

        static {
            EXP_INT_TABLE_A = FastMathLiteralArrays.loadExpIntA();
            EXP_INT_TABLE_B = FastMathLiteralArrays.loadExpIntB();
        }
    }

    private static class Split {
        public static final Split NAN = null;
        public static final Split NEGATIVE_INFINITY = null;
        public static final Split POSITIVE_INFINITY = null;
        private final double full;
        private final double high;
        private final double low;

        static /* synthetic */ Split access$500(Split r0, long r1) {
            return r0.pow(r1);
        }

        static /* synthetic */ double access$600(Split r2) {
            return r2.full;
        }

        static {
            NAN = new Split(Double.NaN, 0.0d);
            POSITIVE_INFINITY = new Split(Double.POSITIVE_INFINITY, 0.0d);
            NEGATIVE_INFINITY = new Split(Double.NEGATIVE_INFINITY, 0.0d);
        }

        Split(double r5) {
            this.full = r5;
            double r0 = Double.longBitsToDouble(Double.doubleToRawLongBits(r5) & (-134217728));
            this.high = r0;
            this.low = r5 - r0;
        }

        Split(double r10, double r12) {
            if (r10 == 0.0d) goto L5;
            double r0 = r10 + r12;
        L11:
            double r3 = r0;
        L12:
            this(r3, r10, r12);
            return;
        L5:
            if (r12 == 0.0d) goto L7;
        L9:
            r3 = r12;
            goto L12
        L7:
            if (Double.doubleToRawLongBits(r10) != Long.MIN_VALUE) goto L9;
            r0 = -0.0d;
            goto L11
        }

        Split(double r1, double r3, double r5) {
            this.full = r1;
            this.high = r3;
            this.low = r5;
        }

        public Split multiply(Split r14) {
            Split r0 = new Split(this.full * r14.full);
            double r1 = this.low;
            double r3 = r14.low;
            double r7 = r0.full;
            double r9 = this.high;
            double r13 = r14.high;
            double r5 = (r1 * r3) - (((r7 - (r9 * r13)) - (r1 * r13)) - (r9 * r3));
            return new Split(r0.high, r0.low + r5);
        }

        public Split reciprocal() {
            Split r4 = new Split(1.0d / this.full);
            Split r0 = multiply(r4);
            double r5 = (r0.high - 1.0d) + r0.low;
            if (Double.isNaN(r5) == false) goto L6;
            return r4;
        L6:
            return new Split(r4.high, r4.low - (r5 / this.full));
        }

        private Split pow(long r12) {
            Split r0 = new Split(1.0d);
            Split r10 = new Split(this.full, this.high, this.low);
            long r3 = r12;
        L4:
            if (r3 == 0) goto L10;
            if ((r3 & 1) == 0) goto L8;
            r0 = r0.multiply(r10);
        L8:
            r10 = r10.multiply(r10);
            r3 = r3 >>> 1;
            goto L4
        L10:
            if (Double.isNaN(r0.full) == true) goto L12;
            return r0;
        L12:
            if (Double.isNaN(this.full) == false) goto L16;
            return NAN;
        L16:
            if (FastMath.abs(this.full) >= 1.0d) goto L20;
            return new Split(FastMath.copySign(0.0d, this.full), 0.0d);
        L20:
            if (this.full >= 0.0d) goto L26;
            if ((r12 & 1) != 1) goto L26;
            return NEGATIVE_INFINITY;
        L26:
            return POSITIVE_INFINITY;
        }
    }

    private static class lnMant {
        private static final double[][] LN_MANT = null;

        private lnMant() {
        }

        static /* synthetic */ double[][] access$400() {
            return LN_MANT;
        }

        static {
            LN_MANT = FastMathLiteralArrays.loadLnMant();
        }
    }

    public static int abs(int r2) {
        int r0 = r2 >>> 31;
        return (r2 ^ ((~r0) + 1)) + r0;
    }

    public static long abs(long r6) {
        long r0 = r6 >>> 63;
        return (r6 ^ ((~r0) + 1)) + r0;
    }

    public static double floor(double r4) {
        if (r4 == r4) goto L6;
        return r4;
    L6:
        if (r4 < TWO_POWER_52) goto L8;
        return r4;
    L8:
        if (r4 <= (-4.503599627370496E15d)) goto L22;
        long r0 = (long) r4;
        if (r4 >= 0.0d) goto L16;
        if (r0 == r4) goto L16;
        r0 = r0 - 1;
    L16:
        if (r0 != 0) goto L20;
        return r4 * r0;
    L20:
        return r0;
    L22:
        return r4;
    }

    public static int max(int r0, int r1) {
        if (r0 <= r1) goto L4;
        return r0;
    L4:
        return r1;
    }

    public static long max(long r1, long r3) {
        if (r1 <= r3) goto L5;
        return r1;
    L5:
        return r3;
    }

    public static int min(int r0, int r1) {
        if (r0 > r1) goto L5;
        return r0;
    L5:
        return r1;
    }

    public static long min(long r1, long r3) {
        if (r1 > r3) goto L6;
        return r1;
    L6:
        return r3;
    }

    private static double polyCosine(double r4) {
        double r5 = r4 * r4;
        return ((((((2.479773539153719E-5d * r5) - 0.0013888888689039883d) * r5) + 0.041666666666621166d) * r5) - 0.49999999999999994d) * r5;
    }

    private static double polySine(double r6) {
        double r0 = r6 * r6;
        return (((((((2.7553817452272217E-6d * r0) - 1.9841269659586505E-4d) * r0) + 0.008333333333329196d) * r0) - 0.16666666666666666d) * r0) * r6;
    }

    public static double signum(double r3) {
        if (r3 >= 0.0d) goto L6;
        return -1.0d;
    L6:
        if (r3 <= 0.0d) goto L10;
        return 1.0d;
    L10:
        return r3;
    }

    public static float signum(float r2) {
        if (r2 >= 0.0f) goto L6;
        return -1.0f;
    L6:
        if (r2 <= 0.0f) goto L10;
        return 1.0f;
    L10:
        return r2;
    }

    static {
        LOG_MAX_VALUE = StrictMath.log(Double.MAX_VALUE);
        LN_QUICK_COEF = new double[][]{new double[]{1.0d, 5.669184079525E-24d}, new double[]{-0.25d, -0.25d}, new double[]{0.3333333134651184d, 1.986821492305628E-8d}, new double[]{-0.25d, -6.663542893624021E-14d}, new double[]{0.19999998807907104d, 1.1921056801463227E-8d}, new double[]{-0.1666666567325592d, -7.800414592973399E-9d}, new double[]{0.1428571343421936d, 5.650007086920087E-9d}, new double[]{-0.12502530217170715d, -7.44321345601866E-11d}, new double[]{0.11113807559013367d, 9.219544613762692E-9d}};
        LN_HI_PREC_COEF = new double[][]{new double[]{1.0d, -6.032174644509064E-23d}, new double[]{-0.25d, -0.25d}, new double[]{0.3333333134651184d, 1.9868161777724352E-8d}, new double[]{-0.2499999701976776d, -2.957007209750105E-8d}, new double[]{0.19999954104423523d, 1.5830993332061267E-10d}, new double[]{-0.16624879837036133d, -2.6033824355191673E-8d}};
        SINE_TABLE_A = new double[]{0.0d, 0.1246747374534607d, 0.24740394949913025d, 0.366272509098053d, 0.4794255495071411d, 0.5850973129272461d, 0.6816387176513672d, 0.7675435543060303d, 0.8414709568023682d, 0.902267575263977d, 0.9489846229553223d, 0.9808930158615112d, 0.9974949359893799d, 0.9985313415527344d};
        SINE_TABLE_B = new double[]{0.0d, -4.068233003401932E-9d, 9.755392680573412E-9d, 1.9987994582857286E-8d, -1.0902938113007961E-8d, -3.9986783938944604E-8d, 4.23719669792332E-8d, -5.207000323380292E-8d, 2.800552834259E-8d, 1.883511811213715E-8d, -3.5997360512765566E-9d, 4.116164446561962E-8d, 5.0614674548127384E-8d, -1.0129027912496858E-9d};
        COSINE_TABLE_A = new double[]{1.0d, 0.9921976327896118d, 0.9689123630523682d, 0.9305076599121094d, 0.8775825500488281d, 0.8109631538391113d, 0.7316888570785522d, 0.6409968137741089d, 0.5403022766113281d, 0.4311765432357788d, 0.3153223395347595d, 0.19454771280288696d, 0.07073719799518585d, -0.05417713522911072d};
        COSINE_TABLE_B = new double[]{0.0d, 3.4439717236742845E-8d, 5.865827662008209E-8d, -3.7999795083850525E-8d, 1.184154459111628E-8d, -3.43338934259355E-8d, 1.1795268640216787E-8d, 4.438921624363781E-8d, 2.925681159240093E-8d, -2.6437112632041807E-8d, 2.2860509143963117E-8d, -4.813899778443457E-9d, 3.6725170580355583E-9d, 2.0217439756338078E-10d};
        TANGENT_TABLE_A = new double[]{0.0d, 0.1256551444530487d, 0.25534194707870483d, 0.3936265707015991d, 0.5463024377822876d, 0.7214844226837158d, 0.9315965175628662d, 1.1974215507507324d, 1.5574076175689697d, 2.092571258544922d, 3.0095696449279785d, 5.041914939880371d, 14.101419448852539d, -18.430862426757812d};
        TANGENT_TABLE_B = new double[]{0.0d, -7.877917738262007E-9d, -2.5857668567479893E-8d, 5.2240336371356666E-9d, 5.206150291559893E-8d, 1.8307188599677033E-8d, -5.7618793749770706E-8d, 7.848361555046424E-8d, 1.0708593250394448E-7d, 1.7827257129423813E-8d, 2.893485277253286E-8d, 3.1660099222737955E-7d, 4.983191803254889E-7d, -3.356118100840571E-7d};
        RECIP_2PI = new long[]{2935890503282001226L, 9154082963658192752L, 3952090531849364496L, 9193070505571053912L, 7910884519577875640L, 113236205062349959L, 4577762542105553359L, -5034868814120038111L, 4208363204685324176L, 5648769086999809661L, 2819561105158720014L, -4035746434778044925L, -302932621132653753L, -2644281811660520851L, -3183605296591799669L, 6722166367014452318L, -3512299194304650054L, -7278142539171889152L};
        PI_O_4_BITS = new long[]{-3958705157555305932L, -4267615245585081135L};
        EIGHTHS = new double[]{0.0d, 0.125d, F_1_4, 0.375d, 0.5d, 0.625d, 0.75d, F_7_8, 1.0d, 1.125d, 1.25d, 1.375d, 1.5d, 1.625d};
        CBRTTWO = new double[]{0.6299605249474366d, 0.7937005259840998d, 1.0d, 1.2599210498948732d, 1.5874010519681994d};
    }

    private FastMath() {
    }

    private static double doubleHighPart(double r2) {
        if (r2 <= (-Precision.SAFE_MIN)) goto L8;
        if (r2 >= Precision.SAFE_MIN) goto L8;
        return r2;
    L8:
        return Double.longBitsToDouble(Double.doubleToRawLongBits(r2) & MASK_30BITS);
    }

    public static double sqrt(double r0) {
        return Math.sqrt(r0);
    }

    public static double cosh(double r21) {
        double r0 = r21;
        if (r0 == r0) goto L6;
        return r0;
    L6:
        if (r0 <= 20.0d) goto L16;
        if (r0 < LOG_MAX_VALUE) goto L12;
        double r1 = exp(r0 * 0.5d);
    L11:
        return (0.5d * r1) * r1;
    L12:
        double r2 = exp(r21);
    L14:
        return r2 * 0.5d;
    L16:
        if (r0 < (-20.0d)) goto L18;
        double[] r3 = new double[2];
        if (r0 >= 0.0d) goto L24;
        r0 = -r0;
    L24:
        exp(r0, 0.0d, r3);
        double r4 = r3[0];
        double r5 = r3[1];
        double r7 = r4 + r5;
        double r6 = -((r7 - r4) - r5);
        double r9 = r7 * 1.073741824E9d;
        double r11 = (r7 + r9) - r9;
        double r10 = r7 - r11;
        double r15 = 1.0d / r7;
        double r8 = 1.073741824E9d * r15;
        double r17 = (r15 + r8) - r8;
        double r12 = r15 - r17;
        double r13 = (r12 + (((((1.0d - (r11 * r17)) - (r11 * r12)) - (r10 * r17)) - (r10 * r12)) * r15)) + (((-r6) * r15) * r15);
        double r14 = r7 + r17;
        double r16 = r6 + (-((r14 - r7) - r17));
        double r18 = r14 + r13;
        return (r18 + (r16 + (-((r18 - r14) - r13)))) * 0.5d;
    L18:
        if (r0 > (-LOG_MAX_VALUE)) goto L20;
        r1 = exp(r0 * (-0.5d));
        goto L11
    L20:
        r2 = exp(-r0);
        goto L14
    }

    public static double sinh(double r21) {
        double r0 = r21;
        if (r0 == r0) goto L5;
        return r0;
    L5:
        double r3 = 0.5d;
        if (r0 <= 20.0d) goto L16;
        if (r0 < LOG_MAX_VALUE) goto L12;
        double r1 = exp(r0 * 0.5d);
    L11:
        return (r3 * r1) * r1;
    L12:
        double r2 = exp(r21);
    L14:
        return r2 * r3;
    L16:
        if (r0 >= (-20.0d)) goto L22;
        r3 = -0.5d;
        if (r0 > (-LOG_MAX_VALUE)) goto L20;
        r1 = exp(r0 * (-0.5d));
        goto L11
    L20:
        r2 = exp(-r0);
        goto L14
    L22:
        if (r0 != 0.0d) goto L25;
        return r0;
    L25:
        if (r0 >= 0.0d) goto L27;
        r0 = -r0;
        boolean r4 = true;
    L29:
        if (r0 <= F_1_4) goto L31;
        double[] r9 = new double[2];
        exp(r0, 0.0d, r9);
        double r5 = r9[0];
        double r6 = r9[1];
        double r7 = r5 + r6;
        double r8 = -((r7 - r5) - r6);
        double r10 = r7 * 1.073741824E9d;
        double r11 = (r7 + r10) - r10;
        double r12 = r7 - r11;
        double r15 = 1.0d / r7;
        double r13 = 1.073741824E9d * r15;
        double r14 = (r15 + r13) - r13;
        double r17 = r15 - r14;
        double r16 = (r17 + (((((1.0d - (r11 * r14)) - (r11 * r17)) - (r12 * r14)) - (r12 * r17)) * r15)) + (((-r8) * r15) * r15);
        double r18 = -r14;
        double r19 = -r16;
        double r110 = r7 + r18;
        double r20 = r8 + (-((r110 - r7) - r18));
        double r22 = r110 + r19;
        double r23 = -((r22 - r110) - r19);
    L32:
        double r24 = (r22 + (r20 + r23)) * 0.5d;
        if (r4 == true) goto L35;
        return r24;
    L35:
        return -r24;
    L31:
        double[] r25 = new double[2];
        expm1(r0, r25);
        double r26 = r25[0];
        double r27 = r25[1];
        double r28 = r26 + r27;
        double r29 = -((r28 - r26) - r27);
        double r30 = r28 + 1.0d;
        double r31 = 1.0d / r30;
        double r111 = (-((r30 - 1.0d) - r28)) + r29;
        double r112 = r28 * r31;
        double r113 = r112 * 1.073741824E9d;
        double r114 = (r112 + r113) - r113;
        double r115 = r112 - r114;
        double r116 = 1.073741824E9d * r30;
        double r117 = (r30 + r116) - r116;
        double r32 = r30 - r117;
        double r118 = ((r115 + (((((r28 - (r117 * r114)) - (r117 * r115)) - (r32 * r114)) - (r32 * r115)) * r31)) + (r29 * r31)) + ((((-r28) * r111) * r31) * r31);
        double r33 = r28 + r114;
        r20 = r29 + (-((r33 - r28) - r114));
        r22 = r33 + r118;
        r23 = -((r22 - r33) - r118);
        goto L32
    L27:
        r4 = false;
        goto L29
    }

    public static double tanh(double r19) {
        double r0 = r19;
        if (r0 == r0) goto L6;
        return r0;
    L6:
        if (r0 <= 20.0d) goto L9;
        return 1.0d;
    L9:
        if (r0 >= (-20.0d)) goto L12;
        return -1.0d;
    L12:
        if (r0 != 0.0d) goto L15;
        return r0;
    L15:
        if (r0 >= 0.0d) goto L17;
        r0 = -r0;
        boolean r2 = true;
    L19:
        if (r0 < 0.5d) goto L21;
        double[] r11 = new double[2];
        exp(r0 * 2.0d, 0.0d, r11);
        double r1 = r11[0];
        double r7 = r11[1];
        double r9 = r1 + r7;
        double r3 = -((r9 - r1) - r7);
        double r5 = (-1.0d) + r9;
        double r12 = r5 + r3;
        double r8 = (-((r5 + 1.0d) - r9)) + (-((r12 - r5) - r3));
        double r6 = r9 + 1.0d;
        double r4 = -((r6 - 1.0d) - r9);
        double r10 = r6 + r3;
        double r13 = r4 + (-((r10 - r6) - r3));
        double r14 = r10 * 1.073741824E9d;
        double r15 = (r10 + r14) - r14;
        double r16 = r10 - r15;
        double r17 = r12 / r10;
        double r18 = 1.073741824E9d * r17;
        double r110 = (r17 + r18) - r18;
        double r111 = r17 - r110;
        double r112 = (r111 + (((((r12 - (r15 * r110)) - (r15 * r111)) - (r16 * r110)) - (r16 * r111)) / r10)) + (r8 / r10);
        double r20 = (-r13) * r12;
    L22:
        double r113 = r110 + (r112 + ((r20 / r10) / r10));
        if (r2 == true) goto L25;
        return r113;
    L25:
        return -r113;
    L21:
        double[] r21 = new double[2];
        expm1(r0 * 2.0d, r21);
        double r22 = r21[0];
        double r23 = r21[1];
        double r24 = r22 + r23;
        double r25 = -((r24 - r22) - r23);
        double r26 = r24 + 2.0d;
        r10 = r26 + r25;
        double r27 = (-((r26 - 2.0d) - r24)) + (-((r10 - r26) - r25));
        double r28 = r10 * 1.073741824E9d;
        double r114 = (r10 + r28) - r28;
        double r29 = r10 - r114;
        double r115 = r24 / r10;
        double r116 = 1.073741824E9d * r115;
        r110 = (r115 + r116) - r116;
        double r117 = r115 - r110;
        r112 = (r117 + (((((r24 - (r114 * r110)) - (r114 * r117)) - (r29 * r110)) - (r29 * r117)) / r10)) + (r25 / r10);
        r20 = (-r27) * r24;
        goto L22
    L17:
        r2 = false;
        goto L19
    }

    public static double acosh(double r4) {
        return log(r4 + sqrt((r4 * r4) - 1.0d));
    }

    public static double asinh(double r36) {
        double r0 = r36;
        if (r0 >= 0.0d) goto L5;
        r0 = -r0;
        boolean r2 = true;
    L7:
        if (r0 <= 0.167d) goto L9;
        double r1 = log(sqrt((r0 * r0) + 1.0d) + r0);
    L21:
        if (r2 == true) goto L23;
        return r1;
    L23:
        return -r1;
    L9:
        double r6 = r0 * r0;
        double r12 = F_1_13;
        double r20 = F_1_9;
        double r28 = 0.2d;
        if (r0 <= 0.097d) goto L16;
        r12 = F_1_13 - (((F_1_15 - ((F_1_17 * r6) * F_15_16)) * r6) * F_13_14);
    L12:
        r20 = F_1_9 - (((F_1_11 - ((r12 * r6) * F_11_12)) * r6) * F_9_10);
    L13:
        r28 = 0.2d - (((F_1_7 - ((r20 * r6) * F_7_8)) * r6) * F_5_6);
    L14:
        r1 = r0 * (1.0d - ((r6 * (F_1_3 - ((r28 * r6) * 0.75d))) * 0.5d));
        goto L21
    L16:
        if (r0 > 0.036d) goto L12;
        if (r0 <= 0.0036d) goto L14;
    L5:
        r2 = false;
        goto L7
    }

    public static double atanh(double r24) {
        double r0 = r24;
        if (r0 >= 0.0d) goto L5;
        r0 = -r0;
        boolean r2 = true;
    L7:
        if (r0 <= 0.15d) goto L9;
        double r1 = log((r0 + 1.0d) / (1.0d - r0)) * 0.5d;
    L20:
        if (r2 == true) goto L22;
        return r1;
    L22:
        return -r1;
    L9:
        double r6 = r0 * r0;
        if (r0 <= 0.087d) goto L14;
        double r7 = r6 * ((((((((((((((F_1_17 * r6) + F_1_15) * r6) + F_1_13) * r6) + F_1_11) * r6) + F_1_9) * r6) + F_1_7) * r6) + 0.2d) * r6) + F_1_3);
    L12:
        r1 = r0 * (r7 + 1.0d);
        goto L20
    L14:
        if (r0 <= 0.031d) goto L17;
        r7 = r6 * ((((((((((F_1_13 * r6) + F_1_11) * r6) + F_1_9) * r6) + F_1_7) * r6) + 0.2d) * r6) + F_1_3);
        goto L12
    L17:
        if (r0 <= 0.003d) goto L19;
        r7 = r6 * ((((((F_1_9 * r6) + F_1_7) * r6) + 0.2d) * r6) + F_1_3);
        goto L12
    L19:
        r7 = r6 * ((0.2d * r6) + F_1_3);
        goto L12
    L5:
        r2 = false;
        goto L7
    }

    public static double nextUp(double r2) {
        return nextAfter(r2, Double.POSITIVE_INFINITY);
    }

    public static float nextUp(float r2) {
        return nextAfter(r2, Double.POSITIVE_INFINITY);
    }

    public static double nextDown(double r2) {
        return nextAfter(r2, Double.NEGATIVE_INFINITY);
    }

    public static float nextDown(float r2) {
        return nextAfter(r2, Double.NEGATIVE_INFINITY);
    }

    public static double random() {
        return Math.random();
    }

    public static double exp(double r3) {
        return exp(r3, 0.0d, null);
    }

    private static double exp(double r22, double r24, double[] r26) {
        int r5 = (int) r22;
        if (r22 >= 0.0d) goto L22;
        if (r22 >= (-746.0d)) goto L10;
        if (r26 == null) goto L8;
        r26[0] = 0.0d;
        r26[1] = 0.0d;
    L8:
        return 0.0d;
    L10:
        if (r5 >= (-709)) goto L15;
        double r0 = exp(r22 + 40.19140625d, r24, r26) / 2.8504009514401178E17d;
        if (r26 == null) goto L14;
        r26[0] = r26[0] / 2.8504009514401178E17d;
        r26[1] = r26[1] / 2.8504009514401178E17d;
    L14:
        return r0;
    L15:
        if (r5 != (-709)) goto L20;
        double r1 = exp(r22 + 1.494140625d, r24, r26) / 4.455505956692757d;
        if (r26 == null) goto L19;
        r26[0] = r26[0] / 4.455505956692757d;
        r26[1] = r26[1] / 4.455505956692757d;
    L19:
        return r1;
    L20:
        r5 = r5 - 1;
    L26:
        double[] r8 = ExpIntTable.access$000();
        int r13 = r5 + EXP_INT_TABLE_MAX_INDEX;
        double r14 = r8[r13];
        double r16 = ExpIntTable.access$100()[r13];
        double r11 = r5;
        int r6 = (int) ((r22 - r11) * 1024.0d);
        double r7 = ExpFracTable.access$200()[r6];
        double r18 = ExpFracTable.access$300()[r6];
        double r2 = r22 - (r11 + (((double) r6) / 1024.0d));
        double r9 = (((((((0.04168701738764507d * r2) + 0.1666666505023083d) * r2) + 0.5000000000042687d) * r2) + 1.0d) * r2) - 3.940510424527919E-20d;
        double r3 = r14 * r7;
        double r15 = ((r14 * r18) + (r7 * r16)) + (r16 * r18);
        double r10 = r15 + r3;
        if (r10 != Double.POSITIVE_INFINITY) goto L30;
        return Double.POSITIVE_INFINITY;
    L30:
        if (r24 == 0.0d) goto L32;
        double r12 = r10 * r24;
        double r17 = ((((r12 * r9) + r12) + (r10 * r9)) + r15) + r3;
    L33:
        if (r26 == null) goto L35;
        r26[0] = r3;
        double r4 = r10 * r24;
        r26[1] = (((r4 * r9) + r4) + (r10 * r9)) + r15;
    L35:
        return r17;
    L32:
        r17 = ((r10 * r9) + r15) + r3;
        goto L33
    L22:
        if (r5 <= 709) goto L26;
        if (r26 == null) goto L25;
        r26[0] = Double.POSITIVE_INFINITY;
        r26[1] = 0.0d;
    L25:
        return Double.POSITIVE_INFINITY;
    }

    public static double expm1(double r1) {
        return expm1(r1, null);
    }

    private static double expm1(double r24, double[] r26) {
        double r0 = r24;
        if (r0 == r0) goto L5;
    L29:
        return r0;
    L5:
        if (r0 == 0.0d) goto L29;
        if (r0 > (-1.0d)) goto L10;
    L23:
        double[] r8 = new double[2];
        exp(r0, 0.0d, r8);
        if (r0 > 0.0d) goto L26;
        double r1 = r8[0];
        double r5 = (-1.0d) + r1;
        return r5 + ((-((1.0d + r5) - r1)) + r8[1]);
    L26:
        return (r8[0] - 1.0d) + r8[1];
    L10:
        if (r0 >= 1.0d) goto L23;
        if (r0 >= 0.0d) goto L15;
        r0 = -r0;
        boolean r2 = true;
    L16:
        int r6 = (int) (r0 * 1024.0d);
        double r7 = ExpFracTable.access$200()[r6] - 1.0d;
        double r12 = ExpFracTable.access$300()[r6];
        double r14 = r7 + r12;
        double r16 = r14 * 1.073741824E9d;
        double r18 = (r14 + r16) - r16;
        double r9 = (-((r14 - r7) - r12)) + (r14 - r18);
        double r3 = r0 - (((double) r6) / 1024.0d);
        double r4 = (((((((0.008336750013465571d * r3) + 0.041666663879186654d) * r3) + 0.16666666666745392d) * r3) + 0.49999999999999994d) * r3) * r3;
        double r15 = r3 + r4;
        double r10 = -((r15 - r3) - r4);
        double r11 = r15 * 1.073741824E9d;
        double r17 = (r15 + r11) - r11;
        double r13 = r10 + (r15 - r17);
        double r19 = r17 * r18;
        double r110 = r17 * r9;
        double r20 = r19 + r110;
        double r21 = -((r20 - r19) - r110);
        double r111 = r13 * r18;
        double r22 = r20 + r111;
        double r23 = r21 + (-((r22 - r20) - r111));
        double r112 = r13 * r9;
        double r25 = r22 + r112;
        double r27 = r23 + (-((r25 - r22) - r112));
        double r113 = r25 + r18;
        double r28 = r113 + r17;
        double r29 = (r27 + (-((r113 - r18) - r25))) + (-((r28 - r113) - r17));
        double r114 = r28 + r9;
        double r30 = r114 + r13;
        double r31 = (r29 + (-((r114 - r28) - r9))) + (-((r30 - r114) - r13));
        if (r2 == false) goto L19;
        double r32 = r30 + 1.0d;
        double r33 = 1.0d / r32;
        double r34 = (-((r32 - 1.0d) - r30)) + r31;
        double r115 = r30 * r33;
        double r116 = r115 * 1.073741824E9d;
        double r35 = (r115 + r116) - r116;
        double r117 = r115 - r35;
        double r118 = 1.073741824E9d * r32;
        double r119 = (r32 + r118) - r118;
        double r36 = r32 - r119;
        double r120 = ((r117 + (((((r30 - (r119 * r35)) - (r119 * r117)) - (r36 * r35)) - (r36 * r117)) * r33)) + (r31 * r33)) + ((((-r30) * r34) * r33) * r33);
        r30 = -r35;
        r31 = -r120;
    L19:
        if (r26 == null) goto L22;
        r26[0] = r30;
        r26[1] = r31;
    L22:
        return r30 + r31;
    L15:
        r2 = false;
        goto L16
    }

    public static double log(double r1) {
        return log(r1, null);
    }

    private static double log(double r23, double[] r25) {
        if (r23 != 0.0d) goto L5;
        return Double.NEGATIVE_INFINITY;
    L5:
        long r5 = Double.doubleToRawLongBits(r23);
        if ((Long.MIN_VALUE & r5) == 0) goto L8;
    L9:
        if (r23 != 0.0d) goto L11;
    L15:
        if (r23 != Double.POSITIVE_INFINITY) goto L19;
        if (r25 == null) goto L18;
        r25[0] = Double.POSITIVE_INFINITY;
    L18:
        return Double.POSITIVE_INFINITY;
    L19:
        int r7 = ((int) (r5 >> 52)) - 1023;
        if ((MASK_DOUBLE_EXPONENT & r5) != 0) goto L30;
        if (r23 != 0.0d) goto L25;
        if (r25 == null) goto L24;
        r25[0] = Double.NEGATIVE_INFINITY;
    L24:
        return Double.NEGATIVE_INFINITY;
    L25:
        r5 = r5 << 1;
    L27:
        if ((IMPLICIT_HIGH_BIT & r5) != 0) goto L30;
        r7 = r7 - 1;
        r5 = r5 << 1;
    L30:
        if (r7 == (-1)) goto L33;
        if (r7 == 0) goto L33;
    L42:
        long r13 = 4499201580859392L & r5;
        double[] r0 = lnMant.access$400()[(int) (r13 >> 42)];
        double r4 = r5 & 4398046511103L;
        double r14 = r13 + TWO_POWER_52;
        double r17 = r4 / r14;
        if (r25 == null) goto L48;
        double r1 = r17 * 1.073741824E9d;
        double r19 = (r17 + r1) - r1;
        double r18 = r17 - r19;
        double r110 = r18 + (((r4 - (r19 * r14)) - (r18 * r14)) / r14);
        double[][] r2 = LN_HI_PREC_COEF;
        double[] r3 = r2[r2.length - 1];
        double r6 = r3[0];
        double r8 = r3[1];
        int r9 = r2.length - 2;
    L45:
        if (r9 < 0) goto L47;
        double r15 = r6 * r19;
        double r10 = ((r6 * r110) + (r8 * r19)) + (r8 * r110);
        double r11 = r15 * 1.073741824E9d;
        double r21 = (r15 + r11) - r11;
        double r16 = (r15 - r21) + r10;
        double[] r12 = LN_HI_PREC_COEF[r9];
        double r22 = r21 + r12[0];
        double r111 = r16 + r12[1];
        double r20 = r22 * 1.073741824E9d;
        r6 = (r22 + r20) - r20;
        r8 = (r22 - r6) + r111;
        r9 = r9 - 1;
        goto L45
    L47:
        double r24 = r6 * r19;
        double r26 = ((r6 * r110) + (r19 * r8)) + (r8 * r110);
        double r27 = r24 + r26;
        double r28 = -((r27 - r24) - r26);
    L49:
        double r29 = r7;
        double r30 = LN_2_A * r29;
        double r112 = r0[0];
        double r113 = r30 + r112;
        double r31 = (-((r113 - r30) - r112)) + 0.0d;
        double r114 = r113 + r27;
        double r32 = r31 + (-((r114 - r113) - r27));
        double r33 = r29 * LN_2_B;
        double r34 = r114 + r33;
        double r35 = r32 + (-((r34 - r114) - r33));
        double r36 = r0[1];
        double r115 = r34 + r36;
        double r37 = r35 + (-((r115 - r34) - r36));
        double r38 = r115 + r28;
        double r39 = r37 + (-((r38 - r115) - r28));
        if (r25 == null) goto L53;
        r25[0] = r38;
        r25[1] = r39;
    L53:
        return r38 + r39;
    L48:
        r27 = (((((((((((-0.16624882440418567d) * r17) + 0.19999954120254515d) * r17) - 0.2499999997677497d) * r17) + 0.3333333333332802d) * r17) - 0.5d) * r17) + 1.0d) * r17;
        r28 = 0.0d;
    L33:
        if (r23 >= 1.01d) goto L42;
        if (r23 <= 0.99d) goto L42;
        if (r25 != null) goto L42;
        double r40 = r23 - 1.0d;
        double r41 = r40 * 1.073741824E9d;
        double r42 = (r40 + r41) - r41;
        double r43 = r40 - r42;
        double[][] r44 = LN_QUICK_COEF;
        double[] r45 = r44[r44.length - 1];
        double r46 = r45[0];
        double r116 = r45[1];
        int r47 = r44.length - 2;
    L38:
        if (r47 < 0) goto L40;
        double r117 = r46 * r42;
        double r48 = ((r46 * r43) + (r116 * r42)) + (r116 * r43);
        double r118 = r117 * 1.073741824E9d;
        double r119 = (r117 + r118) - r118;
        double r120 = (r117 - r119) + r48;
        double[] r49 = LN_QUICK_COEF[r47];
        double r121 = r119 + r49[0];
        double r50 = r121 * 1.073741824E9d;
        r46 = (r121 + r50) - r50;
        r116 = (r121 - r46) + (r120 + r49[1]);
        r47 = r47 - 1;
        goto L38
    L40:
        double r51 = r46 * r42;
        double r52 = ((r46 * r43) + (r42 * r116)) + (r116 * r43);
        double r53 = 1.073741824E9d * r51;
        double r54 = (r51 + r53) - r53;
        return r54 + ((r51 - r54) + r52);
    L11:
        if (r25 == null) goto L13;
        r25[0] = Double.NaN;
    L13:
        return Double.NaN;
    L8:
        if (r23 == r23) goto L15;
        goto L9
    }

    public static double log1p(double r10) {
        if (r10 != (-1.0d)) goto L7;
        return Double.NEGATIVE_INFINITY;
    L7:
        if (r10 != Double.POSITIVE_INFINITY) goto L10;
        return Double.POSITIVE_INFINITY;
    L10:
        if (r10 <= 1.0E-6d) goto L12;
    L16:
        double r5 = r10 + 1.0d;
        double r11 = -((r5 - 1.0d) - r10);
        double[] r0 = new double[2];
        double r7 = log(r5, r0);
        if (Double.isInfinite(r7) == false) goto L19;
        return r7;
    L19:
        double r12 = r11 / r5;
        return ((((0.5d * r12) + 1.0d) * r12) + r0[1]) + r0[0];
    L12:
        if (r10 < (-1.0E-6d)) goto L16;
        return ((((F_1_3 * r10) - 0.5d) * r10) + 1.0d) * r10;
    }

    public static double log10(double r7) {
        double[] r0 = new double[2];
        double r8 = log(r7, r0);
        if (Double.isInfinite(r8) == false) goto L5;
        return r8;
    L5:
        double r9 = r0[0];
        double r1 = 1.073741824E9d * r9;
        double r3 = (r9 + r1) - r1;
        double r10 = (r9 - r3) + r0[1];
        return (((r10 * 1.9699272335463627E-8d) + (1.9699272335463627E-8d * r3)) + (r10 * 0.4342944622039795d)) + (r3 * 0.4342944622039795d);
    }

    public static double log(double r0, double r2) {
        return log(r2) / log(r0);
    }

    public static double pow(double r24, double r26) {
        if (r26 != 0.0d) goto L5;
        return 1.0d;
    L5:
        long r7 = Double.doubleToRawLongBits(r26);
        int r11 = (int) ((r7 & MASK_DOUBLE_EXPONENT) >> 52);
        long r8 = r7 & MASK_DOUBLE_MANTISSA;
        long r16 = Double.doubleToRawLongBits(r24);
        int r9 = (int) ((r16 & MASK_DOUBLE_EXPONENT) >> 52);
        long r12 = r16 & MASK_DOUBLE_MANTISSA;
        if (r11 <= 1085) goto L30;
        if (r11 == 2047) goto L9;
    L10:
        if (r9 == 2047) goto L12;
    L14:
        if (r9 == 1023) goto L16;
    L20:
        if (r26 <= 0.0d) goto L22;
        boolean r0 = true;
    L23:
        if (r9 >= 1023) goto L25;
        boolean r14 = true;
    L27:
        if ((r0 ^ r14) == false) goto L29;
        return Double.POSITIVE_INFINITY;
    L29:
        return 0.0d;
    L25:
        r14 = false;
        goto L27
    L22:
        r0 = false;
        goto L23
    L16:
        if (r12 != 0) goto L20;
        if (r11 != 2047) goto L19;
        return Double.NaN;
    L19:
        return 1.0d;
    L12:
        if (r12 == 0) goto L14;
    L13:
        return Double.NaN;
    L9:
        if (r8 != 0) goto L13;
    L30:
        if (r11 < 1023) goto L46;
        long r10 = r8 | IMPLICIT_HIGH_BIT;
        if (r11 >= 1075) goto L40;
        int r4 = 1075 - r11;
        if ((((-1) << r4) & r10) != r10) goto L46;
        long r5 = r10 >> r4;
        if (r26 >= 0.0d) goto L39;
        r5 = -r5;
    L39:
        return pow(r24, r5);
    L40:
        long r6 = r10 << (r11 - 1075);
        if (r26 >= 0.0d) goto L44;
        r6 = -r6;
    L44:
        return pow(r24, r6);
    L46:
        if (r24 == 0.0d) goto L48;
        if (r9 != 2047) goto L61;
        if (r12 == 0) goto L55;
        return Double.NaN;
    L55:
        if (r26 >= 0.0d) goto L58;
        return 0.0d;
    L58:
        return Double.POSITIVE_INFINITY;
    L61:
        if (r24 >= 0.0d) goto L63;
        return Double.NaN;
    L63:
        double r13 = r26 * 1.073741824E9d;
        double r15 = (r26 + r13) - r13;
        double r17 = r26 - r15;
        double[] r18 = new double[2];
        double r1 = log(r24, r18);
        if (Double.isInfinite(r1) == false) goto L66;
        return r1;
    L66:
        double r2 = r18[0];
        double r3 = 1.073741824E9d * r2;
        double r19 = (r2 + r3) - r3;
        double r110 = r18[1] + (r2 - r19);
        double r20 = r19 * r15;
        double r111 = ((r19 * r17) + (r15 * r110)) + (r110 * r17);
        double r21 = r20 + r111;
        double r22 = -((r21 - r20) - r111);
        return exp(r21, ((((((((0.008333333333333333d * r22) + 0.041666666666666664d) * r22) + 0.16666666666666666d) * r22) + 0.5d) * r22) + 1.0d) * r22, null);
    L48:
        if (r26 < 0.0d) goto L50;
        return 0.0d;
    L50:
        return Double.POSITIVE_INFINITY;
    }

    public static double pow(double r2, int r4) {
        return pow(r2, r4);
    }

    public static double pow(double r2, long r4) {
        if (r4 != 0) goto L6;
        return 1.0d;
    L6:
        if (r4 <= 0) goto L10;
        return Split.access$600(Split.access$500(new Split(r2), r4));
    L10:
        return Split.access$600(Split.access$500(new Split(r2).reciprocal(), -r4));
    }

    private static double sinQ(double r23, double r25) {
        int r0 = (int) ((8.0d * r23) + 0.5d);
        double r1 = r23 - EIGHTHS[r0];
        double r3 = SINE_TABLE_A[r0];
        double r5 = SINE_TABLE_B[r0];
        double r7 = COSINE_TABLE_A[r0];
        double r9 = COSINE_TABLE_B[r0];
        double r11 = polySine(r1);
        double r13 = polyCosine(r1);
        double r15 = 1.073741824E9d * r1;
        double r17 = (r1 + r15) - r15;
        double r12 = r11 + (r1 - r17);
        double r16 = r3 + 0.0d;
        double r10 = (-((r16 - 0.0d) - r3)) + 0.0d;
        double r19 = r7 * r17;
        double r21 = r16 + r19;
        double r14 = ((((((r10 + (-((r21 - r16) - r19))) + (r3 * r13)) + (r7 * r12)) + r5) + (r9 * r17)) + (r5 * r13)) + (r9 * r12);
        if (r25 == 0.0d) goto L6;
        double r8 = (((r7 + r9) * (r13 + 1.0d)) - ((r3 + r5) * (r17 + r12))) * r25;
        double r2 = r21 + r8;
        r14 = r14 + (-((r2 - r21) - r8));
        r21 = r2;
    L6:
        return r21 + r14;
    }

    private static double cosQ(double r4, double r6) {
        double r2 = 1.5707963267948966d - r4;
        return sinQ(r2, (-((r2 - 1.5707963267948966d) + r4)) + (6.123233995736766E-17d - r6));
    }

    private static double tanQ(double r31, double r33, boolean r35) {
        int r0 = (int) ((8.0d * r31) + 0.5d);
        double r1 = r31 - EIGHTHS[r0];
        double r3 = SINE_TABLE_A[r0];
        double r5 = SINE_TABLE_B[r0];
        double r7 = COSINE_TABLE_A[r0];
        double r9 = COSINE_TABLE_B[r0];
        double r11 = polySine(r1);
        double r13 = polyCosine(r1);
        double r17 = r1 * 1.073741824E9d;
        double r19 = (r1 + r17) - r17;
        double r12 = r11 + (r1 - r19);
        double r18 = r3 + 0.0d;
        double r6 = (-((r18 - 0.0d) - r3)) + 0.0d;
        double r21 = r7 * r19;
        double r23 = r18 + r21;
        double r8 = ((r6 + (-((r23 - r18) - r21))) + ((r3 * r13) + (r7 * r12))) + (((r5 + (r9 * r19)) + (r5 * r13)) + (r9 * r12));
        double r2 = r23 + r8;
        double r10 = -((r2 - r23) - r8);
        double r24 = r7 * 1.0d;
        double r27 = r24 + 0.0d;
        double r4 = (-((r27 - 0.0d) - r24)) + 0.0d;
        double r25 = r10;
        double r14 = (-r3) * r19;
        double r29 = r27 + r14;
        double r15 = ((r4 + (-((r29 - r27) - r14))) + (((1.0d * r9) + (r7 * r13)) + (r9 * r13))) - (((r5 * r19) + (r3 * r12)) + (r5 * r12));
        double r16 = r29 + r15;
        double r20 = -((r16 - r29) - r15);
        if (r35 == false) goto L5;
        double r22 = r20;
        double r26 = r16;
        r16 = r2;
    L6:
        double r28 = r26 / r16;
        double r30 = r28 * 1.073741824E9d;
        double r110 = (r28 + r30) - r30;
        double r32 = r28 - r110;
        double r111 = 1.073741824E9d * r16;
        double r112 = (r16 + r111) - r111;
        double r113 = r16 - r112;
        double r114 = ((((((r26 - (r110 * r112)) - (r110 * r113)) - (r112 * r32)) - (r32 * r113)) / r16) + (r22 / r16)) + ((((-r26) * r25) / r16) / r16);
        if (r33 == 0.0d) goto L13;
        double r34 = r33 + ((r28 * r28) * r33);
        if (r35 == false) goto L11;
        r34 = -r34;
    L11:
        r114 = r114 + r34;
    L13:
        return r28 + r114;
    L5:
        r22 = r25;
        r25 = r20;
        r26 = r2;
        goto L6
    }

    private static void reducePayneHanek(double r38, double[] r40) {
        long r0 = Double.doubleToRawLongBits(r38);
        int r2 = (((int) ((r0 >> 52) & 2047)) - 1023) + 1;
        long r1 = ((r0 & MASK_DOUBLE_MANTISSA) | IMPLICIT_HIGH_BIT) << 11;
        int r4 = r2 >> 6;
        int r3 = r2 - (r4 << 6);
        if (r3 == 0) goto L8;
        if (r4 != 0) goto L6;
        long r8 = 0;
    L7:
        long[] r10 = RECIP_2PI;
        long r11 = r10[r4];
        int r13 = 64 - r3;
        long r9 = r8 | (r11 >>> r13);
        long r14 = r10[r4 + 1];
        long r12 = (r11 << r3) | (r14 >>> r13);
        long r15 = (r14 << r3) | (r10[r4 + 2] >>> r13);
    L12:
        long r16 = r1 >>> 32;
        long r5 = r1 & 4294967295L;
        long r19 = r12 >>> 32;
        long r17 = r12 & 4294967295L;
        long r21 = r16 * r19;
        long r23 = r5 * r17;
        long r110 = r19 * r5;
        long r18 = r17 * r16;
        long r25 = r23 + (r18 << 32);
        long r22 = r21 + (r18 >>> 32);
        if ((r23 & Long.MIN_VALUE) == 0) goto L15;
        boolean r6 = true;
    L17:
        if ((r18 & CacheValidityPolicy.MAX_AGE) == 0) goto L19;
        boolean r111 = true;
    L20:
        long r29 = r25 & Long.MIN_VALUE;
        if (r29 == 0) goto L23;
        boolean r210 = true;
    L25:
        if (r6 == false) goto L27;
        if (r111 == false) goto L27;
    L30:
        r22 = r22 + 1;
    L31:
        if (r29 == 0) goto L33;
        boolean r7 = true;
    L35:
        if ((r110 & CacheValidityPolicy.MAX_AGE) == 0) goto L37;
        boolean r112 = true;
    L38:
        long r26 = r25 + (r110 << 32);
        long r24 = r22 + (r110 >>> 32);
        long r113 = r26 & Long.MIN_VALUE;
        if (r113 == 0) goto L41;
        boolean r114 = true;
    L42:
        if (r7 == false) goto L44;
        if (r112 == false) goto L44;
    L47:
        r24 = r24 + 1;
    L48:
        long r115 = r15 >>> 32;
        long r32 = (r16 * r115) + (((r115 * r5) + ((r15 & 4294967295L) * r16)) >>> 32);
        if (r113 == 0) goto L51;
        boolean r20 = true;
    L53:
        if ((r32 & Long.MIN_VALUE) == 0) goto L55;
        boolean r116 = true;
    L56:
        long r27 = r26 + r32;
        if ((r27 & Long.MIN_VALUE) == 0) goto L59;
        boolean r117 = true;
    L60:
        if (r20 == false) goto L62;
        if (r116 == false) goto L62;
    L65:
        r24 = r24 + 1;
    L66:
        long r118 = r9 >>> 32;
        long r28 = r9 & 4294967295L;
        long r211 = r24 + ((r5 * r28) + (((r5 * r118) + (r16 * r28)) << 32));
        int r30 = (int) (r211 >>> 62);
        long r31 = (r211 << 2) | (r27 >>> 62);
        long r119 = r27 << 2;
        long r120 = r31 >>> 32;
        long r33 = r31 & 4294967295L;
        long[] r34 = PI_O_4_BITS;
        long r121 = r34[0];
        long r122 = r121 >>> 32;
        long r212 = r121 & 4294967295L;
        long r213 = r120 * r122;
        long r35 = r33 * r212;
        long r123 = r122 * r33;
        long r214 = r212 * r120;
        long r36 = r35 + (r214 << 32);
        long r215 = r213 + (r214 >>> 32);
        if ((r35 & Long.MIN_VALUE) == 0) goto L69;
        boolean r37 = true;
    L71:
        if ((r214 & CacheValidityPolicy.MAX_AGE) == 0) goto L73;
        boolean r216 = true;
    L74:
        long r39 = r36 & Long.MIN_VALUE;
        if (r39 == 0) goto L77;
        boolean r217 = true;
    L78:
        if (r37 == false) goto L80;
        if (r216 == false) goto L80;
    L83:
        r215 = r215 + 1;
    L84:
        if (r39 == 0) goto L86;
        boolean r41 = true;
    L88:
        if ((r123 & CacheValidityPolicy.MAX_AGE) == 0) goto L90;
        boolean r218 = true;
    L91:
        long r310 = r36 + (r123 << 32);
        long r219 = r215 + (r123 >>> 32);
        long r124 = r310 & Long.MIN_VALUE;
        if (r124 == 0) goto L94;
        boolean r220 = true;
    L95:
        if (r41 == false) goto L97;
        if (r218 == false) goto L97;
    L100:
        r219 = r219 + 1;
    L101:
        long r221 = r34[1];
        long r222 = r221 >>> 32;
        long r311 = (r120 * r222) + (((r33 * r222) + (r120 * (r221 & 4294967295L))) >>> 32);
        if (r124 == 0) goto L104;
        boolean r42 = true;
    L106:
        if ((r311 & Long.MIN_VALUE) == 0) goto L108;
        boolean r43 = true;
    L109:
        long r312 = r310 + r311;
        long r44 = r312 & Long.MIN_VALUE;
        if (r44 == 0) goto L112;
        boolean r45 = true;
    L113:
        if (r42 == false) goto L115;
        if (r43 == false) goto L115;
    L118:
        r219 = r219 + 1;
    L119:
        long r125 = r119 >>> 32;
        long r126 = r121 >>> 32;
        long r127 = (r125 * r126) + ((((r119 & 4294967295L) * r126) + (r125 * (r121 & 4294967295L))) >>> 32);
        if (r44 == 0) goto L122;
        boolean r46 = true;
    L124:
        if ((r127 & Long.MIN_VALUE) == 0) goto L126;
        boolean r47 = true;
    L127:
        long r313 = r312 + r127;
        if ((r313 & Long.MIN_VALUE) == 0) goto L130;
        boolean r48 = true;
    L131:
        if (r46 == false) goto L133;
        if (r47 == false) goto L133;
    L136:
        r219 = r219 + 1;
    L137:
        double r49 = (r219 >>> 12) / TWO_POWER_52;
        double r128 = ((((r219 & 4095) << 40) + (r313 >>> 24)) / TWO_POWER_52) / TWO_POWER_52;
        double r50 = r49 + r128;
        r40[0] = r30;
        r40[1] = r50 * 2.0d;
        r40[2] = (-((r50 - r49) - r128)) * 2.0d;
        return;
    L133:
        if (r46 == true) goto L135;
        if (r47 == false) goto L137;
    L135:
        if (r48 == true) goto L137;
    L130:
        r48 = false;
        goto L131
    L126:
        r47 = false;
        goto L127
    L122:
        r46 = false;
    L115:
        if (r42 == true) goto L117;
        if (r43 == false) goto L119;
    L117:
        if (r45 == true) goto L119;
    L112:
        r45 = false;
        goto L113
    L108:
        r43 = false;
        goto L109
    L104:
        r42 = false;
    L97:
        if (r41 == true) goto L99;
        if (r218 == false) goto L101;
    L99:
        if (r220 == true) goto L101;
    L94:
        r220 = false;
        goto L95
    L90:
        r218 = false;
        goto L91
    L86:
        r41 = false;
    L80:
        if (r37 == true) goto L82;
        if (r216 == false) goto L84;
    L82:
        if (r217 == true) goto L84;
    L77:
        r217 = false;
        goto L78
    L73:
        r216 = false;
        goto L74
    L69:
        r37 = false;
    L62:
        if (r20 == true) goto L64;
        if (r116 == false) goto L66;
    L64:
        if (r117 == true) goto L66;
    L59:
        r117 = false;
        goto L60
    L55:
        r116 = false;
        goto L56
    L51:
        r20 = false;
    L44:
        if (r7 == true) goto L46;
        if (r112 == false) goto L48;
    L46:
        if (r114 == true) goto L48;
    L41:
        r114 = false;
        goto L42
    L37:
        r112 = false;
        goto L38
    L33:
        r7 = false;
    L27:
        if (r6 == true) goto L29;
        if (r111 == false) goto L31;
    L29:
        if (r210 == true) goto L31;
    L23:
        r210 = false;
        goto L25
    L19:
        r111 = false;
        goto L20
    L15:
        r6 = false;
        goto L17
    L6:
        r8 = RECIP_2PI[r4 - 1] << r3;
        goto L7
    L8:
        if (r4 != 0) goto L10;
        r9 = 0;
    L11:
        long[] r51 = RECIP_2PI;
        r12 = r51[r4];
        r15 = r51[r4 + 1];
        goto L12
    L10:
        r9 = RECIP_2PI[r4 - 1];
        goto L11
    }

    public static double sin(double r12) {
        double r0 = 0.0d;
        int r4 = 0;
        if (r12 >= 0.0d) goto L5;
        double r5 = -r12;
        boolean r2 = true;
    L7:
        if (r5 != 0.0d) goto L14;
        if (Double.doubleToRawLongBits(r12) >= 0) goto L12;
        return -0.0d;
    L12:
        return 0.0d;
    L14:
        if (r5 == r5) goto L16;
    L39:
        return Double.NaN;
    L16:
        if (r5 == Double.POSITIVE_INFINITY) goto L39;
        if (r5 <= 3294198.0d) goto L22;
        double[] r13 = new double[3];
        reducePayneHanek(r5, r13);
        r4 = ((int) r13[0]) & 3;
        r5 = r13[1];
        r0 = r13[2];
    L24:
        if (r2 == false) goto L26;
        r4 = r4 ^ 2;
    L26:
        if (r4 == 0) goto L38;
        if (r4 == 1) goto L36;
        if (r4 == 2) goto L34;
        if (r4 == 3) goto L31;
        return Double.NaN;
    L31:
        double r14 = cosQ(r5, r0);
    L33:
        return -r14;
    L34:
        r14 = sinQ(r5, r0);
        goto L33
    L36:
        return cosQ(r5, r0);
    L38:
        return sinQ(r5, r0);
    L22:
        if (r5 <= 1.5707963267948966d) goto L24;
        CodyWaite r15 = new CodyWaite(r5);
        r4 = r15.getK() & 3;
        r5 = r15.getRemA();
        r0 = r15.getRemB();
        goto L24
    L5:
        r5 = r12;
        r2 = false;
        goto L7
    }

    public static double cos(double r11) {
        double r0 = 0.0d;
        if (r11 >= 0.0d) goto L6;
        r11 = -r11;
    L6:
        if (r11 == r11) goto L8;
    L29:
        return Double.NaN;
    L8:
        if (r11 == Double.POSITIVE_INFINITY) goto L29;
        int r8 = 0;
        if (r11 <= 3294198.0d) goto L14;
        double[] r1 = new double[3];
        reducePayneHanek(r11, r1);
        r8 = ((int) r1[0]) & 3;
        r11 = r1[1];
        r0 = r1[2];
    L16:
        if (r8 == 0) goto L28;
        if (r8 == 1) goto L26;
        if (r8 == 2) goto L23;
        if (r8 == 3) goto L22;
        return Double.NaN;
    L22:
        return sinQ(r11, r0);
    L23:
        double r12 = cosQ(r11, r0);
    L25:
        return -r12;
    L26:
        r12 = sinQ(r11, r0);
        goto L25
    L28:
        return cosQ(r11, r0);
    L14:
        if (r11 <= 1.5707963267948966d) goto L16;
        CodyWaite r2 = new CodyWaite(r11);
        r8 = r2.getK() & 3;
        r11 = r2.getRemA();
        r0 = r2.getRemB();
        goto L16
    }

    public static double tan(double r13) {
        double r0 = 0.0d;
        if (r13 >= 0.0d) goto L5;
        double r5 = -r13;
        boolean r2 = true;
    L7:
        if (r5 != 0.0d) goto L14;
        if (Double.doubleToRawLongBits(r13) >= 0) goto L12;
        return -0.0d;
    L12:
        return 0.0d;
    L14:
        if (r5 == r5) goto L16;
        return Double.NaN;
    L16:
        if (r5 != Double.POSITIVE_INFINITY) goto L19;
        return Double.NaN;
    L19:
        if (r5 <= 3294198.0d) goto L22;
        double[] r14 = new double[3];
        reducePayneHanek(r5, r14);
        int r15 = 3 & ((int) r14[0]);
        r5 = r14[1];
        r0 = r14[2];
    L26:
        if (r5 <= 1.5d) goto L29;
        double r9 = 1.5707963267948966d - r5;
        double r6 = (-((r9 - 1.5707963267948966d) + r5)) + (6.123233995736766E-17d - r0);
        double r1 = r9 + r6;
        r15 = r15 ^ 1;
        r2 = !r2;
        r0 = -((r1 - r9) - r6);
        r5 = r1;
    L29:
        if ((r15 & 1) != 0) goto L31;
        double r16 = tanQ(r5, r0, false);
    L32:
        if (r2 == true) goto L34;
        return r16;
    L34:
        return -r16;
    L31:
        r16 = -tanQ(r5, r0, true);
        goto L32
    L22:
        if (r5 <= 1.5707963267948966d) goto L24;
        CodyWaite r17 = new CodyWaite(r5);
        r15 = 3 & r17.getK();
        r5 = r17.getRemA();
        r0 = r17.getRemB();
        goto L26
    L24:
        r15 = 0;
        goto L26
    L5:
        r5 = r13;
        r2 = false;
        goto L7
    }

    public static double atan(double r3) {
        return atan(r3, 0.0d, false);
    }

    private static double atan(double r24, double r26, boolean r28) {
        double r0 = r24;
        if (r0 != 0.0d) goto L8;
        if (r28 == true) goto L6;
        return r0;
    L6:
        return copySign(3.141592653589793d, r0);
    L8:
        if (r0 >= 0.0d) goto L10;
        r0 = -r0;
        double r2 = -r26;
        boolean r4 = true;
    L12:
        if (r0 <= 1.633123935319537E16d) goto L19;
        if ((r4 ^ r28) == false) goto L16;
        return -1.5707963267948966d;
    L16:
        return 1.5707963267948966d;
    L19:
        if (r0 >= 1.0d) goto L21;
        int r9 = (int) ((((((-1.7168146928204135d) * r0) * r0) + 8.0d) * r0) + 0.5d);
    L22:
        double r10 = TANGENT_TABLE_A[r9];
        double r12 = TANGENT_TABLE_B[r9];
        double r14 = r0 - r10;
        double r5 = (-((r14 - r0) + r10)) + (r2 - r12);
        double r7 = r14 + r5;
        double r6 = -((r7 - r14) - r5);
        double r16 = r0 * 1.073741824E9d;
        double r18 = (r0 + r16) - r16;
        double r3 = r2 + ((r0 + r2) - r18);
        if (r9 != 0) goto L25;
        double r8 = 1.0d / (((r18 + r3) * (r10 + r12)) + 1.0d);
        double r11 = r7 * r8;
        double r13 = r6 * r8;
    L26:
        double r1 = r11 * r11;
        double r15 = (((((((((((0.07490822288864472d * r1) - 0.09088450866185192d) * r1) + 0.11111095942313305d) * r1) - 0.1428571423679182d) * r1) + 0.19999999999923582d) * r1) - 0.33333333333333287d) * r1) * r11;
        double r17 = r11 + r15;
        double r19 = (-((r17 - r11) - r15)) + (r13 / (r1 + 1.0d));
        double r20 = EIGHTHS[r9];
        double r21 = r20 + r17;
        double r22 = r21 + r19;
        double r23 = (-((r21 - r20) - r17)) + (-((r22 - r21) - r19));
        double r25 = r22 + r23;
        if (r28 == false) goto L30;
        double r27 = -((r25 - r22) - r23);
        double r29 = 3.141592653589793d - r25;
        r25 = ((-((r29 - 3.141592653589793d) + r25)) + (1.2246467991473532E-16d - r27)) + r29;
    L30:
        if ((r4 ^ r28) == true) goto L32;
        return r25;
    L32:
        return -r25;
    L25:
        double r110 = r18 * r10;
        double r210 = r110 + 1.0d;
        double r30 = -((r210 - 1.0d) - r110);
        double r111 = (r10 * r3) + (r18 * r12);
        double r112 = r210 + r111;
        double r31 = (r30 + (-((r112 - r210) - r111))) + (r3 * r12);
        double r32 = r7 / r112;
        double r113 = r32 * 1.073741824E9d;
        double r114 = (r32 + r113) - r113;
        double r115 = r32 - r114;
        double r116 = 1.073741824E9d * r112;
        double r117 = (r112 + r116) - r116;
        double r118 = r112 - r117;
        r13 = ((((((r7 - (r114 * r117)) - (r114 * r118)) - (r117 * r115)) - (r115 * r118)) / r112) + ((((-r7) * r31) / r112) / r112)) + (r6 / r112);
        r11 = r32;
        goto L26
    L21:
        double r119 = 1.0d / r0;
        r9 = (int) ((-(((((-1.7168146928204135d) * r119) * r119) + 8.0d) * r119)) + 13.07d);
        goto L22
    L10:
        r2 = r26;
        r4 = false;
        goto L12
    }

    public static double atan2(double r20, double r22) {
        if (r22 == r22) goto L5;
        return Double.NaN;
    L5:
        if (r20 == r20) goto L8;
        return Double.NaN;
    L8:
        if (r20 != 0.0d) goto L30;
        double r11 = r22 * r20;
        double r13 = 1.0d / r22;
        double r9 = 1.0d / r20;
        if (r13 != 0.0d) goto L17;
        if (r22 <= 0.0d) goto L15;
        return r20;
    L15:
        return copySign(3.141592653589793d, r20);
    L17:
        if (r22 < 0.0d) goto L23;
        if (r13 < 0.0d) goto L23;
        return r11;
    L23:
        if (r20 >= 0.0d) goto L25;
    L28:
        return -3.141592653589793d;
    L25:
        if (r9 < 0.0d) goto L28;
        return 3.141592653589793d;
    L30:
        if (r20 != Double.POSITIVE_INFINITY) goto L41;
        if (r22 != Double.POSITIVE_INFINITY) goto L36;
        return 0.7853981633974483d;
    L36:
        if (r22 != Double.NEGATIVE_INFINITY) goto L39;
        return 2.356194490192345d;
    L39:
        return 1.5707963267948966d;
    L41:
        if (r20 != Double.NEGATIVE_INFINITY) goto L52;
        if (r22 != Double.POSITIVE_INFINITY) goto L47;
        return -0.7853981633974483d;
    L47:
        if (r22 != Double.NEGATIVE_INFINITY) goto L50;
        return -2.356194490192345d;
    L50:
        return -1.5707963267948966d;
    L52:
        if (r22 != Double.POSITIVE_INFINITY) goto L65;
        if (r20 > 0.0d) goto L63;
        double r12 = 1.0d / r20;
        if (r12 > 0.0d) goto L63;
        if (r20 >= 0.0d) goto L60;
        return -0.0d;
    L60:
        if (r12 >= 0.0d) goto L65;
        return -0.0d;
    L63:
        return 0.0d;
    L65:
        if (r22 != Double.NEGATIVE_INFINITY) goto L77;
        if (r20 > 0.0d) goto L75;
        double r14 = 1.0d / r20;
        if (r14 > 0.0d) goto L75;
        if (r20 >= 0.0d) goto L73;
    L74:
        return -3.141592653589793d;
    L73:
        if (r14 >= 0.0d) goto L77;
    L75:
        return 3.141592653589793d;
    L77:
        if (r22 != 0.0d) goto L88;
        if (r20 > 0.0d) goto L87;
        double r10 = 1.0d / r20;
        if (r10 > 0.0d) goto L87;
        if (r20 >= 0.0d) goto L85;
    L86:
        return -1.5707963267948966d;
    L85:
        if (r10 >= 0.0d) goto L88;
    L87:
        return 1.5707963267948966d;
    L88:
        double r4 = r20 / r22;
        boolean r7 = true;
        if (Double.isInfinite(r4) == true) goto L91;
        double r15 = doubleHighPart(r4);
        double r5 = r4 - r15;
        double r16 = doubleHighPart(r22);
        double r17 = r22 - r16;
        double r6 = r5 + (((((r20 - (r15 * r16)) - (r15 * r17)) - (r16 * r5)) - (r17 * r5)) / r22);
        double r18 = r15 + r6;
        double r8 = -((r18 - r15) - r6);
        if (r18 != 0.0d) goto L100;
        r18 = copySign(0.0d, r20);
    L100:
        if (r22 < 0.0d) goto L104;
        r7 = false;
    L104:
        return atan(r18, r8, r7);
    L91:
        if (r22 < 0.0d) goto L95;
        r7 = false;
    L95:
        return atan(r4, 0.0d, r7);
    }

    public static double asin(double r19) {
        if (r19 == r19) goto L6;
        return Double.NaN;
    L6:
        if (r19 <= 1.0d) goto L8;
    L22:
        return Double.NaN;
    L8:
        if (r19 < (-1.0d)) goto L22;
        if (r19 != 1.0d) goto L14;
        return 1.5707963267948966d;
    L14:
        if (r19 != (-1.0d)) goto L18;
        return -1.5707963267948966d;
    L18:
        if (r19 != 0.0d) goto L20;
        return r19;
    L20:
        double r7 = r19 * 1.073741824E9d;
        double r9 = (r19 + r7) - r7;
        double r8 = r19 - r9;
        double r11 = r9 * r9;
        double r10 = ((r9 * r8) * 2.0d) + (r8 * r8);
        double r12 = -r11;
        double r13 = -r10;
        double r14 = r12 + 1.0d;
        double r6 = r14 + r13;
        double r4 = (-((r14 - 1.0d) - r12)) + (-((r6 - r14) - r13));
        double r15 = sqrt(r6);
        double r16 = r15 * 1.073741824E9d;
        double r17 = (r15 + r16) - r16;
        double r18 = r15 - r17;
        double r110 = 2.0d * r15;
        double r111 = r18 + ((((r6 - (r17 * r17)) - ((r17 * 2.0d) * r18)) - (r18 * r18)) / r110);
        double r20 = r19 / r15;
        double r2 = 1.073741824E9d * r20;
        double r112 = (r20 + r2) - r2;
        double r21 = r20 - r112;
        double r0 = -r19;
        double r22 = (r21 + (((((r19 - (r112 * r17)) - (r112 * r111)) - (r17 * r21)) - (r111 * r21)) / r15)) + (((r0 * (r4 / r110)) / r15) / r15);
        double r1 = r112 + r22;
        return atan(r1, -((r1 - r112) - r22), false);
    }

    public static double acos(double r21) {
        if (r21 == r21) goto L6;
        return Double.NaN;
    L6:
        if (r21 <= 1.0d) goto L8;
    L29:
        return Double.NaN;
    L8:
        if (r21 < (-1.0d)) goto L29;
        if (r21 != (-1.0d)) goto L15;
        return 3.141592653589793d;
    L15:
        if (r21 != 1.0d) goto L18;
        return 0.0d;
    L18:
        if (r21 != 0.0d) goto L20;
        return 1.5707963267948966d;
    L20:
        double r9 = r21 * 1.073741824E9d;
        double r11 = (r21 + r9) - r9;
        double r10 = r21 - r11;
        double r13 = -(r11 * r11);
        double r0 = -(((r11 * r10) * 2.0d) + (r10 * r10));
        double r15 = r13 + 1.0d;
        double r2 = -((r15 - 1.0d) - r13);
        double r14 = r15 + r0;
        double r3 = r2 + (-((r14 - r15) - r0));
        double r1 = sqrt(r14);
        double r7 = 1.073741824E9d * r1;
        double r16 = (r1 + r7) - r7;
        double r8 = r1 - r16;
        double r4 = r1 * 2.0d;
        double r12 = (r8 + ((((r14 - (r16 * r16)) - ((r16 * 2.0d) * r8)) - (r8 * r8)) / r4)) + (r3 / r4);
        double r5 = r16 + r12;
        double r6 = -((r5 - r16) - r12);
        double r17 = r5 / r21;
        if (Double.isInfinite(r17) == false) goto L23;
        return 1.5707963267948966d;
    L23:
        double r18 = doubleHighPart(r17);
        double r19 = r17 - r18;
        double r20 = (r19 + (((((r5 - (r18 * r11)) - (r18 * r10)) - (r11 * r19)) - (r10 * r19)) / r21)) + (r6 / r21);
        double r22 = r18 + r20;
        double r23 = -((r22 - r18) - r20);
        if (r21 >= 0.0d) goto L26;
        boolean r24 = true;
    L28:
        return atan(r22, r23, r24);
    L26:
        r24 = false;
        goto L28
    }

    public static double cbrt(double r21) {
        long r0 = Double.doubleToRawLongBits(r21);
        int r3 = ((int) ((r0 >> 52) & 2047)) - 1023;
        if (r3 == (-1023)) goto L5;
        boolean r6 = false;
        int r5 = r3;
        long r4 = r0;
        double r1 = r21;
    L10:
        if (r5 != 1024) goto L12;
        return r1;
    L12:
        double r7 = Double.longBitsToDouble((Long.MIN_VALUE & r4) | (((long) (((r5 / 3) + 1023) & 2047)) << 52));
        double r2 = Double.longBitsToDouble((r4 & MASK_DOUBLE_MANTISSA) | 4607182418800017408L);
        double r9 = (((((((((-0.010714690733195933d) * r2) + 0.0875862700108075d) * r2) - 0.3058015757857271d) * r2) + 0.7249995199969751d) * r2) + 0.5039018405998233d) * CBRTTWO[(r5 % 3) + 2];
        double r8 = r1 / ((r7 * r7) * r7);
        double r10 = r9 + ((r8 - ((r9 * r9) * r9)) / ((r9 * 3.0d) * r9));
        double r11 = r10 + ((r8 - ((r10 * r10) * r10)) / ((r10 * 3.0d) * r10));
        double r12 = r11 * 1.073741824E9d;
        double r13 = (r11 + r12) - r12;
        double r14 = r11 - r13;
        double r15 = r13 * r13;
        double r16 = 1.073741824E9d * r15;
        double r19 = (r15 + r16) - r16;
        double r17 = (((r13 * r14) * 2.0d) + (r14 * r14)) + (r15 - r19);
        double r18 = ((r19 * r14) + (r13 * r17)) + (r17 * r14);
        double r110 = r19 * r13;
        double r111 = r8 - r110;
        double r20 = (r11 + ((r111 + ((-((r111 - r8) + r110)) - r18)) / ((3.0d * r11) * r11))) * r7;
        if (r6 == true) goto L15;
        return r20;
    L15:
        return r20 * 3.814697265625E-6d;
    L5:
        if (r21 != 0.0d) goto L7;
        return r21;
    L7:
        r1 = 1.8014398509481984E16d * r21;
        r4 = Double.doubleToRawLongBits(r1);
        r5 = ((int) (2047 & (r4 >> 52))) - 1023;
        r6 = true;
        goto L10
    }

    public static double toRadians(double r12) {
        if (Double.isInfinite(r12) == false) goto L5;
    L11:
        return r12;
    L5:
        if (r12 == 0.0d) goto L11;
        double r2 = doubleHighPart(r12);
        double r4 = r12 - r2;
        double r8 = (((r4 * 1.997844754509471E-9d) + (r4 * 0.01745329052209854d)) + (1.997844754509471E-9d * r2)) + (r2 * 0.01745329052209854d);
        if (r8 == 0.0d) goto L10;
        return r8;
    L10:
        return r8 * r12;
    }

    public static double toDegrees(double r8) {
        if (Double.isInfinite(r8) == false) goto L5;
    L9:
        return r8;
    L5:
        if (r8 == 0.0d) goto L9;
        double r0 = doubleHighPart(r8);
        double r9 = r8 - r0;
        return (((r9 * 3.145894820876798E-6d) + (r9 * 57.2957763671875d)) + (3.145894820876798E-6d * r0)) + (r0 * 57.2957763671875d);
    }

    public static float abs(float r1) {
        return Float.intBitsToFloat(Float.floatToRawIntBits(r1) & Integer.MAX_VALUE);
    }

    public static double abs(double r2) {
        return Double.longBitsToDouble(Double.doubleToRawLongBits(r2) & Long.MAX_VALUE);
    }

    public static double ulp(double r4) {
        if (Double.isInfinite(r4) == false) goto L7;
        return Double.POSITIVE_INFINITY;
    L7:
        return abs(r4 - Double.longBitsToDouble(Double.doubleToRawLongBits(r4) ^ 1));
    }

    public static float ulp(float r1) {
        if (Float.isInfinite(r1) == false) goto L7;
        return Float.POSITIVE_INFINITY;
    L7:
        return abs(r1 - Float.intBitsToFloat(Float.floatToIntBits(r1) ^ 1));
    }

    public static double scalb(double r20, int r22) {
        if (r22 <= (-1023)) goto L9;
        if (r22 >= 1024) goto L9;
        return Double.longBitsToDouble(((long) (r22 + 1023)) << 52) * r20;
    L9:
        if (Double.isNaN(r20) == false) goto L11;
    L65:
        return r20;
    L11:
        if (Double.isInfinite(r20) == true) goto L65;
        if (r20 == 0.0d) goto L65;
        if (r22 >= (-2098)) goto L22;
        if (r20 > 0.0d) goto L67;
        return -0.0d;
    L67:
        return 0.0d;
    L22:
        if (r22 <= 2097) goto L27;
        if (r20 <= 0.0d) goto L26;
        return Double.POSITIVE_INFINITY;
    L26:
        return Double.NEGATIVE_INFINITY;
    L27:
        long r12 = Double.doubleToRawLongBits(r20);
        long r14 = Long.MIN_VALUE & r12;
        int r1 = ((int) (r12 >>> 52)) & 2047;
        long r13 = r12 & MASK_DOUBLE_MANTISSA;
        int r6 = r1 + r22;
        if (r22 >= 0) goto L44;
        if (r6 <= 0) goto L33;
        return Double.longBitsToDouble(((((long) r6) << 52) | r14) | r13);
    L33:
        if (r6 <= (-53)) goto L40;
        long r0 = IMPLICIT_HIGH_BIT | r13;
        long r2 = (1 << (-r6)) & r0;
        long r3 = r0 >>> (1 - r6);
        if (r2 == 0) goto L38;
        r3 = r3 + 1;
    L38:
        return Double.longBitsToDouble(r3 | r14);
    L40:
        if (r14 != 0) goto L42;
        return 0.0d;
    L42:
        return -0.0d;
    L44:
        if (r1 == 0) goto L46;
        if (r6 >= 2047) goto L61;
        return Double.longBitsToDouble(((((long) r6) << 52) | r14) | r13);
    L61:
        if (r14 != 0) goto L64;
        return Double.POSITIVE_INFINITY;
    L64:
        return Double.NEGATIVE_INFINITY;
    L46:
        if ((r13 >>> 52) == 1) goto L48;
        r13 = r13 << 1;
        r6 = r6 - 1;
        goto L46
    L48:
        int r7 = r6 + 1;
        long r4 = r13 & MASK_DOUBLE_MANTISSA;
        if (r7 >= 2047) goto L53;
        return Double.longBitsToDouble(r4 | ((((long) r7) << 52) | r14));
    L53:
        if (r14 != 0) goto L56;
        return Double.POSITIVE_INFINITY;
    L56:
        return Double.NEGATIVE_INFINITY;
    }

    public static float scalb(float r10, int r11) {
        if (r11 <= (-127)) goto L9;
        if (r11 >= 128) goto L9;
        return r10 * Float.intBitsToFloat((r11 + 127) << 23);
    L9:
        if (Float.isNaN(r10) == false) goto L11;
    L62:
        return r10;
    L11:
        if (Float.isInfinite(r10) == true) goto L62;
        if (r10 == 0.0f) goto L62;
        if (r11 >= (-277)) goto L22;
        if (r10 <= 0.0f) goto L20;
        return 0.0f;
    L20:
        return -0.0f;
    L22:
        if (r11 <= 276) goto L27;
        if (r10 <= 0.0f) goto L26;
        return Float.POSITIVE_INFINITY;
    L26:
        return Float.NEGATIVE_INFINITY;
    L27:
        int r12 = Float.floatToIntBits(r10);
        int r1 = Integer.MIN_VALUE & r12;
        int r2 = (r12 >>> 23) & 255;
        int r13 = r12 & 8388607;
        int r8 = r2 + r11;
        if (r11 >= 0) goto L43;
        if (r8 <= 0) goto L33;
        return Float.intBitsToFloat(r13 | ((r8 << 23) | r1));
    L33:
        if (r8 <= (-24)) goto L39;
        int r14 = r13 | 8388608;
        int r15 = (1 << (-r8)) & r14;
        int r16 = r14 >>> (1 - r8);
        if (r15 == 0) goto L38;
        r16 = r16 + 1;
    L38:
        return Float.intBitsToFloat(r16 | r1);
    L39:
        if (r1 != 0) goto L42;
        return 0.0f;
    L42:
        return -0.0f;
    L43:
        if (r2 == 0) goto L45;
        if (r8 < 255) goto L57;
        if (r1 != 0) goto L61;
        return Float.POSITIVE_INFINITY;
    L61:
        return Float.NEGATIVE_INFINITY;
    L57:
        return Float.intBitsToFloat(r13 | ((r8 << 23) | r1));
    L45:
        if ((r13 >>> 23) == 1) goto L47;
        r13 = r13 << 1;
        r8 = r8 - 1;
        goto L45
    L47:
        int r9 = r8 + 1;
        int r17 = r13 & 8388607;
        if (r9 < 255) goto L50;
        if (r1 != 0) goto L54;
        return Float.POSITIVE_INFINITY;
    L54:
        return Float.NEGATIVE_INFINITY;
    L50:
        return Float.intBitsToFloat(r17 | ((r9 << 23) | r1));
    }

    public static double nextAfter(double r6, double r8) {
        if (Double.isNaN(r6) == false) goto L5;
        return Double.NaN;
    L5:
        if (Double.isNaN(r8) == false) goto L8;
        return Double.NaN;
    L8:
        if (r6 != r8) goto L11;
        return r8;
    L11:
        if (Double.isInfinite(r6) == false) goto L18;
        if (r6 >= 0.0d) goto L15;
        return -1.7976931348623157E308d;
    L15:
        return Double.MAX_VALUE;
    L18:
        if (r6 == 0.0d) goto L20;
        long r0 = Double.doubleToRawLongBits(r6);
        long r2 = Long.MIN_VALUE & r0;
        boolean r7 = true;
        if (r8 >= r6) goto L27;
        boolean r9 = true;
    L29:
        if (r2 == 0) goto L33;
        r7 = false;
    L33:
        if ((r9 ^ r7) == false) goto L37;
        return Double.longBitsToDouble(r2 | ((r0 & Long.MAX_VALUE) + 1));
    L37:
        return Double.longBitsToDouble(r2 | ((r0 & Long.MAX_VALUE) - 1));
    L27:
        r9 = false;
        goto L29
    L20:
        if (r8 >= 0.0d) goto L22;
        return -4.9E-324d;
    L22:
        return Double.MIN_VALUE;
    }

    public static float nextAfter(float r4, double r5) {
        double r0 = r4;
        if (Double.isNaN(r0) == false) goto L5;
        return Float.NaN;
    L5:
        if (Double.isNaN(r5) == false) goto L8;
        return Float.NaN;
    L8:
        if (r0 != r5) goto L12;
        return (float) r5;
    L12:
        if (Float.isInfinite(r4) == false) goto L19;
        if (r4 >= 0.0f) goto L16;
        return -3.4028235E38f;
    L16:
        return Float.MAX_VALUE;
    L19:
        if (r4 == 0.0f) goto L21;
        int r6 = Float.floatToIntBits(r4);
        int r2 = Integer.MIN_VALUE & r6;
        boolean r7 = false;
        if (r5 >= r0) goto L28;
        boolean r8 = true;
    L29:
        if (r2 != 0) goto L32;
        r7 = true;
    L32:
        if ((r8 ^ r7) == false) goto L36;
        return Float.intBitsToFloat(((r6 & Integer.MAX_VALUE) + 1) | r2);
    L36:
        return Float.intBitsToFloat(((r6 & Integer.MAX_VALUE) - 1) | r2);
    L28:
        r8 = false;
        goto L29
    L21:
        if (r5 >= 0.0d) goto L23;
        return -1.4E-45f;
    L23:
        return Float.MIN_VALUE;
    }

    public static double ceil(double r4) {
        if (r4 == r4) goto L5;
        return r4;
    L5:
        double r0 = floor(r4);
        if (r0 != r4) goto L8;
        return r0;
    L8:
        double r1 = r0 + 1.0d;
        if (r1 == 0.0d) goto L11;
        return r1;
    L11:
        return r4 * r1;
    }

    public static double rint(double r7) {
        double r0 = floor(r7);
        double r8 = r7 - r0;
        if (r8 <= 0.5d) goto L11;
        if (r0 != (-1.0d)) goto L9;
        return -0.0d;
    L9:
        return r0 + 1.0d;
    L11:
        if (r8 >= 0.5d) goto L14;
        return r0;
    L14:
        if ((((long) r0) & 1) != 0) goto L17;
        return r0;
    L17:
        return r0 + 1.0d;
    }

    public static long round(double r2) {
        return (long) floor(r2 + 0.5d);
    }

    public static int round(float r2) {
        return (int) floor(r2 + 0.5f);
    }

    public static float min(float r2, float r3) {
        if (r2 <= r3) goto L6;
        return r3;
    L6:
        if (r2 >= r3) goto L8;
        return r2;
    L8:
        if (r2 == r3) goto L12;
        return Float.NaN;
    L12:
        if (Float.floatToRawIntBits(r2) != Integer.MIN_VALUE) goto L14;
        return r2;
    L14:
        return r3;
    }

    public static double min(double r4, double r6) {
        if (r4 <= r6) goto L6;
        return r6;
    L6:
        if (r4 >= r6) goto L8;
        return r4;
    L8:
        if (r4 == r6) goto L12;
        return Double.NaN;
    L12:
        if (Double.doubleToRawLongBits(r4) != Long.MIN_VALUE) goto L14;
        return r4;
    L14:
        return r6;
    }

    public static float max(float r2, float r3) {
        if (r2 <= r3) goto L6;
        return r2;
    L6:
        if (r2 >= r3) goto L8;
        return r3;
    L8:
        if (r2 == r3) goto L12;
        return Float.NaN;
    L12:
        if (Float.floatToRawIntBits(r2) != Integer.MIN_VALUE) goto L14;
        return r3;
    L14:
        return r2;
    }

    public static double max(double r4, double r6) {
        if (r4 <= r6) goto L6;
        return r4;
    L6:
        if (r4 >= r6) goto L8;
        return r6;
    L8:
        if (r4 == r6) goto L12;
        return Double.NaN;
    L12:
        if (Double.doubleToRawLongBits(r4) != Long.MIN_VALUE) goto L14;
        return r6;
    L14:
        return r4;
    }

    public static double hypot(double r3, double r5) {
        if (Double.isInfinite(r3) == false) goto L5;
        return Double.POSITIVE_INFINITY;
    L5:
        if (Double.isInfinite(r5) == false) goto L8;
        return Double.POSITIVE_INFINITY;
    L8:
        if (Double.isNaN(r3) == false) goto L10;
        return Double.NaN;
    L10:
        if (Double.isNaN(r5) == true) goto L26;
        int r0 = getExponent(r3);
        int r1 = getExponent(r5);
        if (r0 <= (r1 + 27)) goto L17;
        return abs(r3);
    L17:
        if (r1 > (r0 + 27)) goto L19;
        int r2 = (r0 + r1) / 2;
        int r4 = -r2;
        double r6 = scalb(r3, r4);
        double r7 = scalb(r5, r4);
        return scalb(sqrt((r6 * r6) + (r7 * r7)), r2);
    L19:
        return abs(r5);
    L26:
        return Double.NaN;
    }

    public static double IEEEremainder(double r0, double r2) {
        return StrictMath.IEEEremainder(r0, r2);
    }

    public static int toIntExact(long r2) throws MathArithmeticException {
        if (r2 < (-2147483648L)) goto L9;
        if (r2 > 2147483647L) goto L9;
        return (int) r2;
    L9:
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW, new Object[0]);
    }

    public static int incrementExact(int r5) throws MathArithmeticException {
        if (r5 == Integer.MAX_VALUE) goto L7;
        return r5 + 1;
    L7:
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_ADDITION, new Object[]{Integer.valueOf(r5), 1});
    }

    public static long incrementExact(long r4) throws MathArithmeticException {
        if (r4 == Long.MAX_VALUE) goto L7;
        return r4 + 1;
    L7:
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_ADDITION, new Object[]{Long.valueOf(r4), 1});
    }

    public static int decrementExact(int r5) throws MathArithmeticException {
        if (r5 == Integer.MIN_VALUE) goto L7;
        return r5 - 1;
    L7:
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_SUBTRACTION, new Object[]{Integer.valueOf(r5), 1});
    }

    public static long decrementExact(long r4) throws MathArithmeticException {
        if (r4 == Long.MIN_VALUE) goto L7;
        return r4 - 1;
    L7:
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_SUBTRACTION, new Object[]{Long.valueOf(r4), 1});
    }

    public static int addExact(int r4, int r5) throws MathArithmeticException {
        int r0 = r4 + r5;
        if ((r4 ^ r5) >= 0) goto L5;
    L9:
        return r0;
    L5:
        if ((r0 ^ r5) >= 0) goto L9;
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_ADDITION, new Object[]{Integer.valueOf(r4), Integer.valueOf(r5)});
    }

    public static long addExact(long r6, long r8) throws MathArithmeticException {
        long r0 = r6 + r8;
        if ((r6 ^ r8) >= 0) goto L5;
    L9:
        return r0;
    L5:
        if ((r0 ^ r8) >= 0) goto L9;
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_ADDITION, new Object[]{Long.valueOf(r6), Long.valueOf(r8)});
    }

    public static int subtractExact(int r4, int r5) {
        int r0 = r4 - r5;
        if ((r4 ^ r5) < 0) goto L5;
    L9:
        return r0;
    L5:
        if ((r0 ^ r5) < 0) goto L9;
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_SUBTRACTION, new Object[]{Integer.valueOf(r4), Integer.valueOf(r5)});
    }

    public static long subtractExact(long r6, long r8) {
        long r0 = r6 - r8;
        if ((r6 ^ r8) < 0) goto L5;
    L9:
        return r0;
    L5:
        if ((r0 ^ r8) < 0) goto L9;
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_SUBTRACTION, new Object[]{Long.valueOf(r6), Long.valueOf(r8)});
    }

    public static int multiplyExact(int r4, int r5) {
        if (r5 <= 0) goto L9;
        if (r4 > (Integer.MAX_VALUE / r5)) goto L18;
        if (r4 >= (Integer.MIN_VALUE / r5)) goto L9;
    L18:
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_MULTIPLICATION, new Object[]{Integer.valueOf(r4), Integer.valueOf(r5)});
    L9:
        if (r5 < (-1)) goto L11;
    L14:
        if (r5 != (-1)) goto L20;
        if (r4 == Integer.MIN_VALUE) goto L18;
    L20:
        return r4 * r5;
    L11:
        if (r4 > (Integer.MIN_VALUE / r5)) goto L18;
        if (r4 < (Integer.MAX_VALUE / r5)) goto L18;
        goto L14
    }

    public static long multiplyExact(long r7, long r9) {
        if (r9 <= 0) goto L9;
        if (r7 > (Long.MAX_VALUE / r9)) goto L19;
        if (r7 >= (Long.MIN_VALUE / r9)) goto L9;
    L19:
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_MULTIPLICATION, new Object[]{Long.valueOf(r7), Long.valueOf(r9)});
    L9:
        if (r9 < (-1)) goto L11;
    L14:
        if (r9 != (-1)) goto L21;
        if (r7 == Long.MIN_VALUE) goto L19;
    L21:
        return r7 * r9;
    L11:
        if (r7 > (Long.MIN_VALUE / r9)) goto L19;
        if (r7 < (Long.MAX_VALUE / r9)) goto L19;
        goto L14
    }

    public static int floorDiv(int r2, int r3) throws MathArithmeticException {
        if (r3 == 0) goto L12;
        int r0 = r2 % r3;
        if ((r2 ^ r3) >= 0) goto L10;
        if (r0 == 0) goto L10;
        return (r2 / r3) - 1;
    L10:
        return r2 / r3;
    L12:
        throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
    }

    public static long floorDiv(long r6, long r8) throws MathArithmeticException {
        if (r8 == 0) goto L14;
        long r2 = r6 % r8;
        if ((r6 ^ r8) >= 0) goto L12;
        if (r2 == 0) goto L12;
        return (r6 / r8) - 1;
    L12:
        return r6 / r8;
    L14:
        throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
    }

    public static int floorMod(int r1, int r2) throws MathArithmeticException {
        if (r2 == 0) goto L11;
        int r0 = r1 % r2;
        if ((r1 ^ r2) >= 0) goto L9;
        if (r0 == 0) goto L9;
        return r2 + r0;
    L9:
        return r0;
    L11:
        throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
    }

    public static long floorMod(long r4, long r6) {
        if (r6 == 0) goto L13;
        long r2 = r4 % r6;
        if ((r4 ^ r6) < 0) goto L7;
    L11:
        return r2;
    L7:
        if (r2 == 0) goto L11;
        return r6 + r2;
    L13:
        throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
    }

    public static double copySign(double r2, double r4) {
        long r0 = Double.doubleToRawLongBits(r2);
        if ((Double.doubleToRawLongBits(r4) ^ r0) < 0) goto L6;
        return r2;
    L6:
        return -r2;
    }

    public static float copySign(float r1, float r2) {
        int r0 = Float.floatToRawIntBits(r1);
        if ((Float.floatToRawIntBits(r2) ^ r0) < 0) goto L6;
        return r1;
    L6:
        return -r1;
    }

    public static int getExponent(double r2) {
        return ((int) ((Double.doubleToRawLongBits(r2) >>> 52) & 2047)) - 1023;
    }

    public static int getExponent(float r0) {
        return ((Float.floatToRawIntBits(r0) >>> 23) & 255) + NetError.ERR_PROXY_AUTH_REQUESTED;
    }

    public static void main(String[] r3) {
        PrintStream r4 = System.out;
        FastMathCalc.printarray(r4, "EXP_INT_TABLE_A", 1500, ExpIntTable.access$000());
        FastMathCalc.printarray(r4, "EXP_INT_TABLE_B", 1500, ExpIntTable.access$100());
        FastMathCalc.printarray(r4, "EXP_FRAC_TABLE_A", 1025, ExpFracTable.access$200());
        FastMathCalc.printarray(r4, "EXP_FRAC_TABLE_B", 1025, ExpFracTable.access$300());
        FastMathCalc.printarray(r4, "LN_MANT", 1024, lnMant.access$400());
        FastMathCalc.printarray(r4, "SINE_TABLE_A", 14, SINE_TABLE_A);
        FastMathCalc.printarray(r4, "SINE_TABLE_B", 14, SINE_TABLE_B);
        FastMathCalc.printarray(r4, "COSINE_TABLE_A", 14, COSINE_TABLE_A);
        FastMathCalc.printarray(r4, "COSINE_TABLE_B", 14, COSINE_TABLE_B);
        FastMathCalc.printarray(r4, "TANGENT_TABLE_A", 14, TANGENT_TABLE_A);
        FastMathCalc.printarray(r4, "TANGENT_TABLE_B", 14, TANGENT_TABLE_B);
    }
}
