package org.apache.commons.math3.dfp;

/* JADX INFO: loaded from: classes6.dex */
public class DfpMath {
    private static final String POW_TRAP = "pow";

    private DfpMath() {
    }

    protected static Dfp[] split(DfpField r13, String r14) {
        Dfp[] r1 = new Dfp[2];
        int r2 = r14.length();
        char[] r3 = new char[r2];
        int r5 = 0;
        boolean r8 = true;
        int r6 = 0;
        int r7 = 0;
    L4:
        if (r6 >= r2) goto L21;
        char r11 = r14.charAt(r6);
        r3[r6] = r11;
        if (r11 < '1') goto L10;
        if (r11 > '9') goto L10;
        r8 = false;
    L10:
        if (r11 != '.') goto L13;
        r7 = r7 + ((400 - r7) % 4);
        r8 = false;
    L13:
        if (r7 == ((r13.getRadixDigits() / 2) * 4)) goto L22;
        char r12 = r3[r6];
        if (r12 < '0') goto L20;
        if (r12 > '9') goto L20;
        if (r8 == true) goto L20;
        r7 = r7 + 1;
    L20:
        r6 = r6 + 1;
    L22:
        r1[0] = r13.newDfp(new String(r3, 0, r6));
    L23:
        if (r5 >= r2) goto L30;
        char r0 = r14.charAt(r5);
        r3[r5] = r0;
        if (r0 < '0') goto L29;
        if (r0 > '9') goto L29;
        if (r5 >= r6) goto L29;
        r3[r5] = '0';
    L29:
        r5 = r5 + 1;
        goto L23
    L30:
        r1[1] = r13.newDfp(new String(r3));
        return r1;
    L21:
        r6 = 0;
        goto L22
    }

    protected static Dfp[] split(Dfp r3) {
        Dfp r0 = r3.multiply(r3.power10K(r3.getRadixDigits() / 2));
        Dfp r1 = r3.add(r0).subtract(r0);
        return new Dfp[]{r1, r3.subtract(r1)};
    }

    protected static Dfp[] splitMult(Dfp[] r5, Dfp[] r6) {
        Dfp[] r0 = {r2, r5[0].getZero()};
        Dfp r2 = r5[0].multiply(r6[0]);
        if (r2.classify() != 1) goto L5;
    L8:
        return r0;
    L5:
        if (r0[0].equals(r0[1]) == true) goto L8;
        r0[1] = r5[0].multiply(r6[1]).add(r5[1].multiply(r6[0])).add(r5[1].multiply(r6[1]));
        goto L8
    }

    protected static Dfp[] splitDiv(Dfp[] r5, Dfp[] r6) {
        Dfp r7 = r5[1].multiply(r6[0]).subtract(r5[0].multiply(r6[1]));
        Dfp[] r0 = {r5[0].divide(r6[0]), r7};
        Dfp r3 = r6[0];
        r0[1] = r7.divide(r3.multiply(r3).add(r6[0].multiply(r6[1])));
        return r0;
    }

    protected static Dfp splitPow(Dfp[] r7, int r8) {
        Dfp[] r1 = new Dfp[2];
        Dfp r3 = r7[0].getZero();
        Dfp[] r0 = {r7[0].getOne(), r3};
        if (r8 == 0) goto L5;
        if (r8 >= 0) goto L8;
        r8 = -r8;
        boolean r4 = true;
    L9:
        r1[0] = new Dfp(r7[0]);
        r1[1] = new Dfp(r7[1]);
        int r5 = 1;
    L10:
        int r6 = r5 * 2;
        if (r6 > r8) goto L12;
        r1 = splitMult(r1, r1);
        r5 = r6;
        goto L10
    L12:
        r8 = r8 - r5;
        r0 = splitMult(r0, r1);
        if (r8 >= 1) goto L9;
        r0[0] = r0[0].add(r0[1]);
        if (r4 == false) goto L18;
        r0[0] = r7[0].getOne().divide(r0[0]);
    L18:
        return r0[0];
    L8:
        r4 = false;
        goto L9
    L5:
        return r0[0].add(r3);
    }

    public static Dfp pow(Dfp r7, int r8) {
        Dfp r0 = r7.getOne();
        if (r8 != 0) goto L6;
        return r0;
    L6:
        if (r8 >= 0) goto L8;
        r8 = -r8;
        boolean r2 = true;
    L9:
        Dfp r3 = new Dfp(r7);
        int r4 = 1;
    L10:
        Dfp r5 = new Dfp(r3);
        r3 = r3.multiply(r3);
        int r6 = r4 * 2;
        if (r8 <= r6) goto L12;
        r4 = r6;
        goto L10
    L12:
        r8 = r8 - r4;
        r0 = r0.multiply(r5);
        if (r8 >= 1) goto L9;
        if (r2 == false) goto L17;
        r0 = r7.getOne().divide(r0);
    L17:
        return r7.newInstance(r0);
    L8:
        r2 = false;
        goto L9
    }

    public static Dfp exp(Dfp r3) {
        Dfp r0 = r3.rint2();
        Dfp r1 = r3.subtract(r0);
        int r2 = r0.intValue();
        if (r2 <= 2147483646) goto L7;
        return r3.newInstance((byte) 1, (byte) 1);
    L7:
        if (r2 >= (-2147483646)) goto L11;
        return r3.newInstance();
    L11:
        return splitPow(r3.getField().getESplit(), r2).multiply(expInternal(r1));
    }

    protected static Dfp expInternal(Dfp r6) {
        Dfp r0 = r6.getOne();
        Dfp r1 = r6.getOne();
        Dfp r2 = r6.getOne();
        Dfp r3 = new Dfp(r0);
        int r4 = 1;
    L4:
        if (r4 >= 90) goto L9;
        r1 = r1.multiply(r6);
        r2 = r2.divide(r4);
        r0 = r0.add(r1.multiply(r2));
        if (r0.equals(r3) == true) goto L9;
        r3 = new Dfp(r0);
        r4 = r4 + 1;
    L9:
        return r0;
    }

    public static Dfp log(Dfp r9) {
        if (r9.equals(r9.getZero()) == false) goto L5;
    L22:
        r9.getField().setIEEEFlagsBits(1);
        return r9.dotrap(1, "ln", r9, r9.newInstance((byte) 1, (byte) 3));
    L5:
        if (r9.lessThan(r9.getZero()) == true) goto L22;
        if (r9.isNaN() == true) goto L22;
        if (r9.classify() != 1) goto L12;
        return r9;
    L12:
        Dfp r0 = new Dfp(r9);
        int r2 = r0.log10K();
        Dfp r1 = r0.divide(pow(r9.newInstance(10000), r2));
        int r3 = r1.floor2().intValue();
        int r5 = 0;
    L14:
        if (r3 <= 2) goto L16;
        r3 = r3 >> 1;
        r5 = r5 + 1;
        goto L14
    L16:
        Dfp[] r4 = split(r1);
        Dfp[] r6 = new Dfp[2];
        Dfp r7 = pow(r9.getTwo(), r5);
        r6[0] = r7;
        r4[0] = r4[0].divide(r7);
        r4[1] = r4[1].divide(r6[0]);
        r6[0] = r9.newInstance("1.33333");
    L18:
        if (r4[0].add(r4[1]).greaterThan(r6[0]) == false) goto L20;
        r4[0] = r4[0].divide(2);
        r4[1] = r4[1].divide(2);
        r5 = r5 + 1;
        goto L18
    L20:
        Dfp[] r8 = logInternal(r4);
        int r10 = r2 * 4;
        r4[0] = r9.newInstance(new StringBuilder().append(r5 + r10).toString());
        r4[1] = r9.getZero();
        Dfp[] r11 = splitMult(r9.getField().getLn2Split(), r4);
        r8[0] = r8[0].add(r11[0]);
        r8[1] = r8[1].add(r11[1]);
        r4[0] = r9.newInstance(new StringBuilder().append(r10).toString());
        r4[1] = r9.getZero();
        Dfp[] r12 = splitMult(r9.getField().getLn5Split(), r4);
        r8[0] = r8[0].add(r12[0]);
        Dfp r13 = r8[1].add(r12[1]);
        r8[1] = r13;
        return r9.newInstance(r8[0].add(r13));
    }

    protected static Dfp[] logInternal(Dfp[] r8) {
        int r3 = 1;
        Dfp r1 = r8[0].divide(4).add(r8[1].divide(4));
        Dfp r2 = r1.add(r8[0].newInstance("-0.25")).divide(r1.add(r8[0].newInstance("0.25")));
        Dfp r4 = new Dfp(r2);
        Dfp r5 = new Dfp(r2);
        Dfp r6 = new Dfp(r4);
        int r7 = 0;
    L4:
        if (r7 >= 10000) goto L10;
        r5 = r5.multiply(r2).multiply(r2);
        r3 = r3 + 2;
        r4 = r4.add(r5.divide(r3));
        if (r4.equals(r6) == true) goto L10;
        r6 = new Dfp(r4);
        r7 = r7 + 1;
    L10:
        return split(r4.multiply(r8[0].getTwo()));
    }

    public static Dfp pow(Dfp r9, Dfp r10) {
        if (r9.getField().getRadixDigits() == r10.getField().getRadixDigits()) goto L6;
        r9.getField().setIEEEFlagsBits(1);
        Dfp r11 = r9.newInstance(r9.getZero());
        r11.nans = 3;
        return r9.dotrap(1, POW_TRAP, r9, r11);
    L6:
        Dfp r0 = r9.getZero();
        Dfp r1 = r9.getOne();
        Dfp r5 = r9.getTwo();
        if (r10.equals(r0) == false) goto L11;
        return r9.newInstance(r1);
    L11:
        if (r10.equals(r1) == false) goto L17;
        if (r9.isNaN() == false) goto L128;
        r9.getField().setIEEEFlagsBits(1);
        return r9.dotrap(1, POW_TRAP, r9, r9);
    L128:
        return r9;
    L17:
        if (r9.isNaN() == false) goto L19;
    L126:
        r9.getField().setIEEEFlagsBits(1);
        return r9.dotrap(1, POW_TRAP, r9, r9.newInstance((byte) 1, (byte) 3));
    L19:
        if (r10.isNaN() == true) goto L126;
        if (r9.equals(r0) == false) goto L50;
        if (Dfp.copysign(r1, r9).greaterThan(r0) == false) goto L32;
        if (r10.greaterThan(r0) == false) goto L30;
        return r9.newInstance(r0);
    L30:
        return r9.newInstance(r9.newInstance((byte) 1, (byte) 1));
    L32:
        if (r10.classify() != 0) goto L44;
        if (r10.rint2().equals(r10) == false) goto L44;
        if (r10.remainder2(r5).equals(r0) == true) goto L44;
        if (r10.greaterThan(r0) == false) goto L42;
        return r9.newInstance(r0.negate());
    L42:
        return r9.newInstance(r9.newInstance((byte) -1, (byte) 1));
    L44:
        if (r10.greaterThan(r0) == false) goto L48;
        return r9.newInstance(r0);
    L48:
        return r9.newInstance(r9.newInstance((byte) 1, (byte) 1));
    L50:
        if (r9.lessThan(r0) == false) goto L52;
        r9 = r9.negate();
        boolean r6 = true;
    L54:
        if (r9.greaterThan(r1) == false) goto L63;
        if (r10.classify() != 1) goto L63;
        if (r10.greaterThan(r0) == false) goto L61;
        return r10;
    L61:
        return r9.newInstance(r0);
    L63:
        if (r9.lessThan(r1) == false) goto L73;
        if (r10.classify() != 1) goto L73;
        if (r10.greaterThan(r0) == false) goto L71;
        return r9.newInstance(r0);
    L71:
        return r9.newInstance(Dfp.copysign(r10, r1));
    L73:
        if (r9.equals(r1) == false) goto L79;
        if (r10.classify() != 1) goto L79;
        r9.getField().setIEEEFlagsBits(1);
        return r9.dotrap(1, POW_TRAP, r9, r9.newInstance((byte) 1, (byte) 3));
    L79:
        if (r9.classify() != 1) goto L104;
        if (r6 == false) goto L100;
        if (r10.classify() != 0) goto L94;
        if (r10.rint2().equals(r10) == false) goto L94;
        if (r10.remainder2(r5).equals(r0) == true) goto L94;
        if (r10.greaterThan(r0) == false) goto L92;
        return r9.newInstance(r9.newInstance((byte) -1, (byte) 1));
    L92:
        return r9.newInstance(r0.negate());
    L94:
        if (r10.greaterThan(r0) == false) goto L98;
        return r9.newInstance(r9.newInstance((byte) 1, (byte) 1));
    L98:
        return r9.newInstance(r0);
    L100:
        if (r10.greaterThan(r0) == false) goto L103;
        return r9;
    L103:
        return r9.newInstance(r0);
    L104:
        if (r6 == false) goto L110;
        if (r10.rint2().equals(r10) == true) goto L110;
        r9.getField().setIEEEFlagsBits(1);
        return r9.dotrap(1, POW_TRAP, r9, r9.newInstance((byte) 1, (byte) 3));
    L110:
        if (r10.lessThan(r9.newInstance(100000000)) == true) goto L112;
    L117:
        Dfp r2 = exp(log(r9).multiply(r10));
    L118:
        if (r6 == false) goto L125;
        if (r10.rint2().equals(r10) == false) goto L125;
        if (r10.remainder2(r5).equals(r0) == true) goto L125;
        r2 = r2.negate();
    L125:
        return r9.newInstance(r2);
    L112:
        if (r10.greaterThan(r9.newInstance(-100000000)) == false) goto L117;
        Dfp r3 = r10.rint2();
        int r4 = r3.intValue();
        Dfp r7 = r10.subtract(r3);
        if (r7.unequal(r0) == false) goto L116;
        Dfp r8 = r7.multiply(log(r9));
        Dfp r12 = r8.divide(r9.getField().getLn2()).rint2();
        r2 = splitPow(split(r9), r4).multiply(pow(r5, r12.intValue())).multiply(exp(r8.subtract(r12.multiply(r9.getField().getLn2()))));
        goto L118
    L116:
        r2 = splitPow(split(r9), r4);
        goto L118
    L52:
        r6 = false;
        goto L54
    }

    protected static Dfp sinInternal(Dfp[] r6) {
        Dfp r1 = r6[0].add(r6[1]);
        Dfp r2 = r1.multiply(r1);
        Dfp r7 = r6[0].getOne();
        Dfp r0 = new Dfp(r1);
        int r4 = 3;
        Dfp r3 = r1;
    L4:
        if (r4 >= 90) goto L9;
        r1 = r1.multiply(r2).negate();
        r7 = r7.divide((r4 - 1) * r4);
        r3 = r3.add(r1.multiply(r7));
        if (r3.equals(r0) == true) goto L9;
        r0 = new Dfp(r3);
        r4 = r4 + 2;
    L9:
        return r3;
    }

    protected static Dfp cosInternal(Dfp[] r6) {
        Dfp r1 = r6[0].getOne();
        Dfp r7 = r6[0].add(r6[1]);
        Dfp r8 = r7.multiply(r7);
        Dfp r0 = new Dfp(r1);
        Dfp r3 = r1;
        int r4 = 2;
        Dfp r2 = r3;
    L4:
        if (r4 >= 90) goto L9;
        r1 = r1.multiply(r8).negate();
        r2 = r2.divide((r4 - 1) * r4);
        r3 = r3.add(r1.multiply(r2));
        if (r3.equals(r0) == true) goto L9;
        r0 = new Dfp(r3);
        r4 = r4 + 2;
    L9:
        return r3;
    }

    public static Dfp sin(Dfp r8) {
        Dfp r0 = r8.getField().getPi();
        Dfp r1 = r8.getField().getZero2();
        Dfp r3 = r8.remainder2(r0.multiply(2));
        if (r3.lessThan(r1) == false) goto L5;
        r3 = r3.negate();
        boolean r2 = true;
    L7:
        if (r3.greaterThan(r0.divide(2)) == false) goto L10;
        r3 = r0.subtract(r3);
    L10:
        if (r3.lessThan(r0.divide(4)) == false) goto L12;
        Dfp r4 = sinInternal(split(r3));
    L13:
        if (r2 == false) goto L16;
        r4 = r4.negate();
    L16:
        return r8.newInstance(r4);
    L12:
        Dfp[] r6 = r8.getField().getPiSplit();
        r4 = cosInternal(new Dfp[]{r6[0].divide(2).subtract(r3), r6[1].divide(2)});
        goto L13
    L5:
        r2 = false;
        goto L7
    }

    public static Dfp cos(Dfp r8) {
        Dfp r0 = r8.getField().getPi();
        Dfp r1 = r8.getField().getZero2();
        Dfp r3 = r8.remainder2(r0.multiply(2));
        if (r3.lessThan(r1) == false) goto L6;
        r3 = r3.negate();
    L6:
        if (r3.greaterThan(r0.divide(2)) == false) goto L8;
        r3 = r0.subtract(r3);
        boolean r4 = true;
    L10:
        if (r3.lessThan(r0.divide(4)) == false) goto L12;
        Dfp r2 = cosInternal(new Dfp[]{r3, r1});
    L13:
        if (r4 == false) goto L16;
        r2 = r2.negate();
    L16:
        return r8.newInstance(r2);
    L12:
        Dfp[] r5 = r8.getField().getPiSplit();
        r2 = sinInternal(new Dfp[]{r5[0].divide(2).subtract(r3), r5[1].divide(2)});
        goto L13
    L8:
        r4 = false;
        goto L10
    }

    public static Dfp tan(Dfp r1) {
        return sin(r1).divide(cos(r1));
    }

    protected static Dfp atanInternal(Dfp r5) {
        Dfp r0 = new Dfp(r5);
        Dfp r1 = new Dfp(r0);
        Dfp r2 = new Dfp(r0);
        int r3 = 3;
    L4:
        if (r3 >= 90) goto L9;
        r1 = r1.multiply(r5).multiply(r5).negate();
        r0 = r0.add(r1.divide(r3));
        if (r0.equals(r2) == true) goto L9;
        r2 = new Dfp(r0);
        r3 = r3 + 2;
    L9:
        return r0;
    }

    public static Dfp atan(Dfp r11) {
        Dfp r0 = r11.getField().getZero2();
        Dfp r1 = r11.getField().getOne2();
        Dfp[] r2 = r11.getField().getSqr2Split();
        Dfp[] r3 = r11.getField().getPiSplit();
        Dfp r5 = r2[0].subtract(r1).add(r2[1]);
        Dfp r7 = new Dfp(r11);
        if (r7.lessThan(r0) == false) goto L5;
        r7 = r7.negate();
        boolean r4 = true;
    L7:
        if (r7.greaterThan(r1) == false) goto L9;
        r7 = r1.divide(r7);
        boolean r8 = true;
    L11:
        if (r7.greaterThan(r5) == false) goto L13;
        Dfp[] r6 = {r2[0].subtract(r1), r2[1]};
        Dfp[] r9 = split(r7);
        Dfp[] r10 = splitMult(r9, r6);
        r10[0] = r10[0].add(r1);
        r9[0] = r9[0].subtract(r6[0]);
        r9[1] = r9[1].subtract(r6[1]);
        Dfp[] r12 = splitDiv(r9, r10);
        r7 = r12[0].add(r12[1]);
        boolean r13 = true;
    L14:
        Dfp r14 = atanInternal(r7);
        if (r13 == false) goto L17;
        r14 = r14.add(r3[0].divide(8)).add(r3[1].divide(8));
    L17:
        if (r8 == false) goto L19;
        r14 = r3[0].divide(2).subtract(r14).add(r3[1].divide(2));
    L19:
        if (r4 == false) goto L22;
        r14 = r14.negate();
    L22:
        return r11.newInstance(r14);
    L13:
        r13 = false;
        goto L14
    L9:
        r8 = false;
        goto L11
    L5:
        r4 = false;
        goto L7
    }

    public static Dfp asin(Dfp r2) {
        return atan(r2.divide(r2.getOne().subtract(r2.multiply(r2)).sqrt2()));
    }

    public static Dfp acos(Dfp r3) {
        boolean r0 = r3.lessThan(r3.getZero());
        Dfp r4 = Dfp.copysign(r3, r3.getOne());
        Dfp r1 = atan(r4.getOne().subtract(r4.multiply(r4)).sqrt2().divide(r4));
        if (r0 == false) goto L6;
        r1 = r4.getField().getPi().subtract(r1);
    L6:
        return r4.newInstance(r1);
    }
}
