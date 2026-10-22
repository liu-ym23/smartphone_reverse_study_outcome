package org.apache.commons.math3.util;

import com.android.settings.CustomKeyUtils;
import java.io.PrintStream;
import org.apache.commons.math3.exception.DimensionMismatchException;

/* JADX INFO: loaded from: classes6.dex */
class FastMathCalc {
    private static final double[] FACT = null;
    private static final long HEX_40000000 = 1073741824;
    private static final double[][] LN_SPLIT_COEF = null;
    private static final String TABLE_END_DECL = "    };";
    private static final String TABLE_START_DECL = "    {";

    static {
        FACT = new double[]{1.0d, 1.0d, 2.0d, 6.0d, 24.0d, 120.0d, 720.0d, 5040.0d, 40320.0d, 362880.0d, 3628800.0d, 3.99168E7d, 4.790016E8d, 6.2270208E9d, 8.71782912E10d, 1.307674368E12d, 2.0922789888E13d, 3.55687428096E14d, 6.402373705728E15d, 1.21645100408832E17d};
        LN_SPLIT_COEF = new double[][]{new double[]{2.0d, 0.0d}, new double[]{0.6666666269302368d, 3.9736429850260626E-8d}, new double[]{0.3999999761581421d, 2.3841857910019882E-8d}, new double[]{0.2857142686843872d, 1.7029898543501842E-8d}, new double[]{0.2222222089767456d, 1.3245471311735498E-8d}, new double[]{0.1818181574344635d, 2.4384203044354907E-8d}, new double[]{0.1538461446762085d, 9.140260083262505E-9d}, new double[]{0.13333332538604736d, 9.220590270857665E-9d}, new double[]{0.11764700710773468d, 1.2393345855018391E-8d}, new double[]{0.10526403784751892d, 8.251545029714408E-9d}, new double[]{0.0952233225107193d, 1.2675934823758863E-8d}, new double[]{0.08713622391223907d, 1.1430250008909141E-8d}, new double[]{0.07842259109020233d, 2.404307984052299E-9d}, new double[]{0.08371849358081818d, 1.176342548272881E-8d}, new double[]{0.030589580535888672d, 1.2958646899018938E-9d}, new double[]{0.14982303977012634d, 1.225743062930824E-8d}};
    }

    private FastMathCalc() {
    }

    private static void buildSinCosTables(double[] r15, double[] r16, double[] r17, double[] r18, int r19, double[] r20, double[] r21) {
        double[] r2 = new double[2];
        int r4 = 0;
    L3:
        int r5 = 7;
        if (r4 >= 7) goto L6;
        double r7 = ((double) r4) / 8.0d;
        slowSin(r7, r2);
        r15[r4] = r2[0];
        r16[r4] = r2[1];
        slowCos(r7, r2);
        r17[r4] = r2[0];
        r18[r4] = r2[1];
        r4 = r4 + 1;
    L6:
        if (r5 >= r19) goto L12;
        double[] r6 = new double[2];
        double[] r8 = new double[2];
        double[] r9 = new double[2];
        double[] r10 = new double[2];
        double[] r11 = new double[2];
        if ((r5 & 1) != 0) goto L10;
        int r12 = r5 / 2;
        r6[0] = r15[r12];
        r6[1] = r16[r12];
        r8[0] = r17[r12];
        r8[1] = r18[r12];
        splitMult(r6, r8, r2);
        r15[r5] = r2[0] * 2.0d;
        r16[r5] = r2[1] * 2.0d;
        splitMult(r8, r8, r9);
        splitMult(r6, r6, r11);
        r11[0] = -r11[0];
        r11[1] = -r11[1];
        splitAdd(r9, r11, r2);
        r17[r5] = r2[0];
        r18[r5] = r2[1];
    L11:
        r5 = r5 + 1;
        goto L6
    L10:
        int r13 = r5 / 2;
        r6[0] = r15[r13];
        r6[1] = r16[r13];
        r8[0] = r17[r13];
        r8[1] = r18[r13];
        int r14 = r13 + 1;
        r9[0] = r15[r14];
        r9[1] = r16[r14];
        r10[0] = r17[r14];
        r10[1] = r18[r14];
        splitMult(r6, r10, r11);
        splitMult(r8, r9, r2);
        splitAdd(r2, r11, r2);
        r15[r5] = r2[0];
        r16[r5] = r2[1];
        splitMult(r8, r10, r2);
        splitMult(r6, r9, r11);
        r11[0] = -r11[0];
        r11[1] = -r11[1];
        splitAdd(r2, r11, r2);
        r17[r5] = r2[0];
        r18[r5] = r2[1];
        goto L11
    L12:
        int r3 = 0;
    L13:
        if (r3 >= r19) goto L15;
        double[] r22 = new double[2];
        double[] r23 = {r17[r3], r18[r3]};
        splitReciprocal(r23, r22);
        splitMult(new double[]{r15[r3], r16[r3]}, r22, r23);
        r20[r3] = r23[0];
        r21[r3] = r23[1];
        r3 = r3 + 1;
        goto L13
    }

    static double slowCos(double r7, double[] r9) {
        double[] r1 = new double[2];
        double[] r2 = {0.0d, 0.0d};
        double[] r3 = new double[2];
        double[] r0 = new double[2];
        split(r7, r1);
        int r8 = FACT.length - 1;
    L4:
        if (r8 < 0) goto L13;
        splitMult(r1, r2, r0);
        r2[0] = r0[0];
        r2[1] = r0[1];
        if ((r8 & 1) != 0) goto L12;
        split(FACT[r8], r0);
        splitReciprocal(r0, r3);
        if ((r8 & 2) == 0) goto L11;
        r3[0] = -r3[0];
        r3[1] = -r3[1];
    L11:
        splitAdd(r2, r3, r0);
        r2[0] = r0[0];
        r2[1] = r0[1];
    L12:
        r8 = r8 - 1;
        goto L4
    L13:
        if (r9 == null) goto L16;
        r9[0] = r2[0];
        r9[1] = r2[1];
    L16:
        return r2[0] + r2[1];
    }

    static double slowSin(double r7, double[] r9) {
        double[] r1 = new double[2];
        double[] r2 = {0.0d, 0.0d};
        double[] r3 = new double[2];
        double[] r0 = new double[2];
        split(r7, r1);
        int r8 = FACT.length - 1;
    L4:
        if (r8 < 0) goto L13;
        splitMult(r1, r2, r0);
        r2[0] = r0[0];
        r2[1] = r0[1];
        if ((r8 & 1) == 0) goto L12;
        split(FACT[r8], r0);
        splitReciprocal(r0, r3);
        if ((r8 & 2) == 0) goto L11;
        r3[0] = -r3[0];
        r3[1] = -r3[1];
    L11:
        splitAdd(r2, r3, r0);
        r2[0] = r0[0];
        r2[1] = r0[1];
    L12:
        r8 = r8 - 1;
        goto L4
    L13:
        if (r9 == null) goto L16;
        r9[0] = r2[0];
        r9[1] = r2[1];
    L16:
        return r2[0] + r2[1];
    }

    static double slowexp(double r7, double[] r9) {
        double[] r1 = new double[2];
        double[] r2 = {0.0d, 0.0d};
        double[] r3 = new double[2];
        double[] r0 = new double[2];
        split(r7, r1);
        int r8 = FACT.length - 1;
    L4:
        if (r8 < 0) goto L6;
        splitMult(r1, r2, r0);
        r2[0] = r0[0];
        r2[1] = r0[1];
        split(FACT[r8], r0);
        splitReciprocal(r0, r3);
        splitAdd(r2, r3, r0);
        r2[0] = r0[0];
        r2[1] = r0[1];
        r8 = r8 - 1;
        goto L4
    L6:
        if (r9 == null) goto L9;
        r9[0] = r2[0];
        r9[1] = r2[1];
    L9:
        return r2[0] + r2[1];
    }

    private static void split(double r7, double[] r9) {
        if (r7 < 8.0E298d) goto L5;
    L7:
        double r5 = (((9.313225746154785E-10d * r7) + r7) - r7) * 1.073741824E9d;
        r9[0] = r5;
        r9[1] = r7 - r5;
        return;
    L5:
        if (r7 <= (-8.0E298d)) goto L7;
        double r2 = 1.073741824E9d * r7;
        double r6 = (r7 + r2) - r2;
        r9[0] = r6;
        r9[1] = r7 - r6;
    }

    private static void resplit(double[] r10) {
        double r1 = r10[0];
        double r4 = r10[1];
        double r6 = r1 + r4;
        double r2 = -((r6 - r1) - r4);
        if (r6 < 8.0E298d) goto L5;
    L7:
        double r5 = (((9.313225746154785E-10d * r6) + r6) - r6) * 1.073741824E9d;
        r10[0] = r5;
        r10[1] = (r6 - r5) + r2;
        return;
    L5:
        if (r6 <= (-8.0E298d)) goto L7;
        double r8 = 1.073741824E9d * r6;
        double r7 = (r6 + r8) - r8;
        r10[0] = r7;
        r10[1] = (r6 - r7) + r2;
    }

    private static void splitMult(double[] r8, double[] r9, double[] r10) {
        r10[0] = r8[0] * r9[0];
        double r1 = r8[0];
        double r4 = r9[1];
        double r6 = r8[1];
        r10[1] = ((r1 * r4) + (r9[0] * r6)) + (r6 * r4);
        resplit(r10);
    }

    private static void splitAdd(double[] r5, double[] r6, double[] r7) {
        r7[0] = r5[0] + r6[0];
        r7[1] = r5[1] + r6[1];
        resplit(r7);
    }

    static void splitReciprocal(double[] r13, double[] r14) {
        if (r13[0] != 0.0d) goto L5;
        r13[0] = r13[1];
        r13[1] = 0.0d;
    L5:
        r14[0] = 0.9999997615814209d / r13[0];
        double r5 = r13[0];
        double r11 = r13[1];
        double r9 = ((2.384185791015625E-7d * r5) - (0.9999997615814209d * r11)) / ((r5 * r5) + (r5 * r11));
        r14[1] = r9;
        if (r9 == r9) goto L8;
        r14[1] = 0.0d;
    L8:
        resplit(r14);
        int r1 = 0;
    L10:
        if (r1 >= 2) goto L12;
        double r3 = r14[0];
        double r6 = r13[0];
        double r7 = r13[1];
        double r12 = r14[1];
        r14[1] = r12 + (((((1.0d - (r3 * r6)) - (r3 * r7)) - (r6 * r12)) - (r7 * r12)) * (r3 + r12));
        r1 = r1 + 1;
        goto L10
    }

    private static void quadMult(double[] r13, double[] r14, double[] r15) {
        double[] r1 = new double[2];
        double[] r2 = new double[2];
        double[] r0 = new double[2];
        split(r13[0], r1);
        split(r14[0], r2);
        splitMult(r1, r2, r0);
        r15[0] = r0[0];
        r15[1] = r0[1];
        split(r14[1], r2);
        splitMult(r1, r2, r0);
        double r5 = r15[0];
        double r7 = r0[0];
        double r9 = r5 + r7;
        double r11 = r15[1] - ((r9 - r5) - r7);
        r15[1] = r11;
        r15[0] = r9;
        double r6 = r0[1];
        double r8 = r9 + r6;
        r15[1] = r11 - ((r8 - r9) - r6);
        r15[0] = r8;
        split(r13[1], r1);
        split(r14[0], r2);
        splitMult(r1, r2, r0);
        double r10 = r15[0];
        double r12 = r0[0];
        double r16 = r10 + r12;
        double r17 = r15[1] - ((r16 - r10) - r12);
        r15[1] = r17;
        r15[0] = r16;
        double r18 = r0[1];
        double r19 = r16 + r18;
        r15[1] = r17 - ((r19 - r16) - r18);
        r15[0] = r19;
        split(r13[1], r1);
        split(r14[1], r2);
        splitMult(r1, r2, r0);
        double r110 = r15[0];
        double r3 = r0[0];
        double r20 = r110 + r3;
        double r21 = r15[1] - ((r20 - r110) - r3);
        r15[1] = r21;
        r15[0] = r20;
        double r111 = r0[1];
        double r4 = r20 + r111;
        r15[1] = r21 - ((r4 - r20) - r111);
        r15[0] = r4;
    }

    static double expint(int r7, double[] r8) {
        double[] r1 = {2.718281828459045d, 1.4456468917292502E-16d};
        double[] r2 = new double[2];
        double[] r0 = new double[2];
        split(1.0d, r0);
    L4:
        if (r7 <= 0) goto L9;
        if ((r7 & 1) == 0) goto L8;
        quadMult(r0, r1, r2);
        r0[0] = r2[0];
        r0[1] = r2[1];
    L8:
        quadMult(r1, r1, r2);
        r1[0] = r2[0];
        r1[1] = r2[1];
        r7 = r7 >> 1;
        goto L4
    L9:
        if (r8 == null) goto L12;
        r8[0] = r0[0];
        r8[1] = r0[1];
        resplit(r8);
    L12:
        return r0[0] + r0[1];
    }

    static double[] slowLog(double r9) {
        double[] r1 = new double[2];
        double[] r2 = new double[2];
        double[] r4 = new double[2];
        split(r9, r1);
        r1[0] = r1[0] + 1.0d;
        resplit(r1);
        splitReciprocal(r1, r4);
        r1[0] = r1[0] - 2.0d;
        resplit(r1);
        double[] r3 = {r5[r5.length - 1][0], r5[r5.length - 1][1]};
        splitMult(r1, r4, r3);
        r1[0] = r3[0];
        r1[1] = r3[1];
        splitMult(r1, r1, r2);
        double[][] r5 = LN_SPLIT_COEF;
        int r6 = r5.length - 2;
    L3:
        if (r6 < 0) goto L5;
        splitMult(r3, r2, r4);
        r3[0] = r4[0];
        r3[1] = r4[1];
        splitAdd(r3, LN_SPLIT_COEF[r6], r4);
        r3[0] = r4[0];
        r3[1] = r4[1];
        r6 = r6 - 1;
        goto L3
    L5:
        splitMult(r3, r1, r4);
        r3[0] = r4[0];
        r3[1] = r4[1];
        return r3;
    }

    static void printarray(PrintStream r8, String r9, int r10, double[][] r11) {
        r8.println(r9);
        checkLen(r10, r11.length);
        r8.println("    { ");
        int r12 = r11.length;
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r0 >= r12) goto L8;
        double[] r2 = r11[r0];
        r8.print("        {");
        int r3 = r2.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L7;
        r8.printf("%-25.25s", new Object[]{format(r2[r4])});
        r4 = r4 + 1;
        goto L5
    L7:
        r8.println("}, // " + r1);
        r0 = r0 + 1;
        r1 = r1 + 1;
        goto L3
    L8:
        r8.println(TABLE_END_DECL);
    }

    static void printarray(PrintStream r4, String r5, int r6, double[] r7) {
        r4.println(r5 + "=");
        checkLen(r6, r7.length);
        r4.println(TABLE_START_DECL);
        int r8 = r7.length;
        int r0 = 0;
    L3:
        if (r0 >= r8) goto L5;
        r4.printf("        %s%n", new Object[]{format(r7[r0])});
        r0 = r0 + 1;
        goto L3
    L5:
        r4.println(TABLE_END_DECL);
    }

    static String format(double r3) {
        if (r3 == r3) goto L6;
        return "Double.NaN,";
    L6:
        StringBuilder r0 = new StringBuilder();
        if (r3 < 0.0d) goto L9;
        String r1 = CustomKeyUtils.KEY_SEPARATE_FOR_SHOW;
    L11:
        return r0.append(r1).append(Double.toString(r3)).append("d,").toString();
    L9:
        r1 = "";
        goto L11
    }

    private static void checkLen(int r1, int r2) throws DimensionMismatchException {
        if (r1 != r2) goto L5;
        return;
    L5:
        throw new DimensionMismatchException(r2, r1);
    }
}
