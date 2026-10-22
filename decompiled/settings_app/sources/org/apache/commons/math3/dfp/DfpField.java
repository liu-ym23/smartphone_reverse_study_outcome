package org.apache.commons.math3.dfp;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

/* JADX INFO: loaded from: classes6.dex */
public class DfpField implements Field<Dfp> {
    public static final int FLAG_DIV_ZERO = 2;
    public static final int FLAG_INEXACT = 16;
    public static final int FLAG_INVALID = 1;
    public static final int FLAG_OVERFLOW = 4;
    public static final int FLAG_UNDERFLOW = 8;
    private static String eString;
    private static String ln10String;
    private static String ln2String;
    private static String ln5String;
    private static String piString;
    private static String sqr2ReciprocalString;
    private static String sqr2String;
    private static String sqr3ReciprocalString;
    private static String sqr3String;
    private final Dfp e;
    private final Dfp[] eSplit;
    private int ieeeFlags;
    private final Dfp ln10;
    private final Dfp ln2;
    private final Dfp[] ln2Split;
    private final Dfp ln5;
    private final Dfp[] ln5Split;
    private final Dfp one;
    private final Dfp pi;
    private final Dfp[] piSplit;
    private RoundingMode rMode;
    private final int radixDigits;
    private final Dfp sqr2;
    private final Dfp sqr2Reciprocal;
    private final Dfp[] sqr2Split;
    private final Dfp sqr3;
    private final Dfp sqr3Reciprocal;
    private final Dfp two;
    private final Dfp zero;

    public static final enum RoundingMode extends Enum<RoundingMode> {
        private static final /* synthetic */ RoundingMode[] $VALUES = null;
        public static final RoundingMode ROUND_CEIL = null;
        public static final RoundingMode ROUND_DOWN = null;
        public static final RoundingMode ROUND_FLOOR = null;
        public static final RoundingMode ROUND_HALF_DOWN = null;
        public static final RoundingMode ROUND_HALF_EVEN = null;
        public static final RoundingMode ROUND_HALF_ODD = null;
        public static final RoundingMode ROUND_HALF_UP = null;
        public static final RoundingMode ROUND_UP = null;

        private RoundingMode(String r1, int r2) {
            super(r1, r2);
        }

        public static RoundingMode valueOf(String r1) {
            return (RoundingMode) Enum.valueOf(RoundingMode.class, r1);
        }

        public static RoundingMode[] values() {
            return (RoundingMode[]) $VALUES.clone();
        }

        static {
            RoundingMode r0 = new RoundingMode("ROUND_DOWN", 0);
            ROUND_DOWN = r0;
            RoundingMode r1 = new RoundingMode("ROUND_UP", 1);
            ROUND_UP = r1;
            RoundingMode r3 = new RoundingMode("ROUND_HALF_UP", 2);
            ROUND_HALF_UP = r3;
            RoundingMode r5 = new RoundingMode("ROUND_HALF_DOWN", 3);
            ROUND_HALF_DOWN = r5;
            RoundingMode r7 = new RoundingMode("ROUND_HALF_EVEN", 4);
            ROUND_HALF_EVEN = r7;
            RoundingMode r9 = new RoundingMode("ROUND_HALF_ODD", 5);
            ROUND_HALF_ODD = r9;
            RoundingMode r11 = new RoundingMode("ROUND_CEIL", 6);
            ROUND_CEIL = r11;
            RoundingMode r13 = new RoundingMode("ROUND_FLOOR", 7);
            ROUND_FLOOR = r13;
            $VALUES = new RoundingMode[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }
    }

    @Override // org.apache.commons.math3.Field
    public /* bridge */ /* synthetic */ Dfp getOne() {
        return getOne2();
    }

    @Override // org.apache.commons.math3.Field
    public /* bridge */ /* synthetic */ Dfp getZero() {
        return getZero2();
    }

    public DfpField(int r2) {
        this(r2, true);
    }

    private DfpField(int r3, boolean r4) {
        int r1 = 4;
        if (r3 < 13) goto L6;
        r1 = (r3 + 3) / 4;
    L6:
        this.radixDigits = r1;
        this.rMode = RoundingMode.ROUND_HALF_EVEN;
        this.ieeeFlags = 0;
        this.zero = new Dfp(this, 0);
        this.one = new Dfp(this, 1);
        this.two = new Dfp(this, 2);
        if (r4 == true) goto L9;
        this.sqr2 = null;
        this.sqr2Split = null;
        this.sqr2Reciprocal = null;
        this.sqr3 = null;
        this.sqr3Reciprocal = null;
        this.pi = null;
        this.piSplit = null;
        this.e = null;
        this.eSplit = null;
        this.ln2 = null;
        this.ln2Split = null;
        this.ln5 = null;
        this.ln5Split = null;
        this.ln10 = null;
        return;
    L9:
        monitor-enter(DfpField.class);
        if (r3 >= 67) goto L13;
        int r5 = 200;
    L22:
        computeStringConstants(r5);     // Catch: Throwable -> L17
        this.sqr2 = new Dfp(this, sqr2String);     // Catch: Throwable -> L17
        this.sqr2Split = split(sqr2String);     // Catch: Throwable -> L17
        this.sqr2Reciprocal = new Dfp(this, sqr2ReciprocalString);     // Catch: Throwable -> L17
        this.sqr3 = new Dfp(this, sqr3String);     // Catch: Throwable -> L17
        this.sqr3Reciprocal = new Dfp(this, sqr3ReciprocalString);     // Catch: Throwable -> L17
        this.pi = new Dfp(this, piString);     // Catch: Throwable -> L17
        this.piSplit = split(piString);     // Catch: Throwable -> L17
        this.e = new Dfp(this, eString);     // Catch: Throwable -> L17
        this.eSplit = split(eString);     // Catch: Throwable -> L17
        this.ln2 = new Dfp(this, ln2String);     // Catch: Throwable -> L17
        this.ln2Split = split(ln2String);     // Catch: Throwable -> L17
        this.ln5 = new Dfp(this, ln5String);     // Catch: Throwable -> L17
        this.ln5Split = split(ln5String);     // Catch: Throwable -> L17
        this.ln10 = new Dfp(this, ln10String);     // Catch: Throwable -> L17
        monitor-exit(DfpField.class);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    L13:
        r5 = r3 * 3;
        goto L22
    }

    public int getRadixDigits() {
        return this.radixDigits;
    }

    public void setRoundingMode(RoundingMode r1) {
        this.rMode = r1;
    }

    public RoundingMode getRoundingMode() {
        return this.rMode;
    }

    public int getIEEEFlags() {
        return this.ieeeFlags;
    }

    public void clearIEEEFlags() {
        this.ieeeFlags = 0;
    }

    public void setIEEEFlags(int r1) {
        this.ieeeFlags = r1 & 31;
    }

    public void setIEEEFlagsBits(int r2) {
        int r3 = r2 & 31;
        this.ieeeFlags = r3 | this.ieeeFlags;
    }

    public Dfp newDfp() {
        return new Dfp(this);
    }

    public Dfp newDfp(byte r2) {
        return new Dfp(this, r2);
    }

    public Dfp newDfp(int r2) {
        return new Dfp(this, r2);
    }

    public Dfp newDfp(long r2) {
        return new Dfp(this, r2);
    }

    public Dfp newDfp(double r2) {
        return new Dfp(this, r2);
    }

    public Dfp newDfp(Dfp r1) {
        return new Dfp(r1);
    }

    public Dfp newDfp(String r2) {
        return new Dfp(this, r2);
    }

    public Dfp newDfp(byte r2, byte r3) {
        return new Dfp(this, r2, r3);
    }

    @Override // org.apache.commons.math3.Field
    /* JADX INFO: renamed from: getZero, reason: avoid collision after fix types in other method */
    public Dfp getZero2() {
        return this.zero;
    }

    @Override // org.apache.commons.math3.Field
    /* JADX INFO: renamed from: getOne, reason: avoid collision after fix types in other method */
    public Dfp getOne2() {
        return this.one;
    }

    @Override // org.apache.commons.math3.Field
    public Class<? extends FieldElement<Dfp>> getRuntimeClass() {
        return Dfp.class;
    }

    public Dfp getTwo() {
        return this.two;
    }

    public Dfp getSqr2() {
        return this.sqr2;
    }

    public Dfp[] getSqr2Split() {
        return (Dfp[]) this.sqr2Split.clone();
    }

    public Dfp getSqr2Reciprocal() {
        return this.sqr2Reciprocal;
    }

    public Dfp getSqr3() {
        return this.sqr3;
    }

    public Dfp getSqr3Reciprocal() {
        return this.sqr3Reciprocal;
    }

    public Dfp getPi() {
        return this.pi;
    }

    public Dfp[] getPiSplit() {
        return (Dfp[]) this.piSplit.clone();
    }

    public Dfp getE() {
        return this.e;
    }

    public Dfp[] getESplit() {
        return (Dfp[]) this.eSplit.clone();
    }

    public Dfp getLn2() {
        return this.ln2;
    }

    public Dfp[] getLn2Split() {
        return (Dfp[]) this.ln2Split.clone();
    }

    public Dfp getLn5() {
        return this.ln5;
    }

    public Dfp[] getLn5Split() {
        return (Dfp[]) this.ln5Split.clone();
    }

    public Dfp getLn10() {
        return this.ln10;
    }

    private Dfp[] split(String r14) {
        Dfp[] r1 = new Dfp[2];
        int r2 = r14.length();
        char[] r3 = new char[r2];
        int r5 = 0;
        boolean r8 = true;
        int r6 = 0;
        int r7 = 0;
    L4:
        if (r6 >= r2) goto L20;
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
        if (r7 == ((this.radixDigits / 2) * 4)) goto L21;
        if (r11 < '0') goto L19;
        if (r11 > '9') goto L19;
        if (r8 == true) goto L19;
        r7 = r7 + 1;
    L19:
        r6 = r6 + 1;
    L21:
        r1[0] = new Dfp(this, new String(r3, 0, r6));
    L22:
        if (r5 >= r2) goto L29;
        char r0 = r14.charAt(r5);
        r3[r5] = r0;
        if (r0 < '0') goto L28;
        if (r0 > '9') goto L28;
        if (r5 >= r6) goto L28;
        r3[r5] = '0';
    L28:
        r5 = r5 + 1;
        goto L22
    L29:
        r1[1] = new Dfp(this, new String(r3));
        return r1;
    L20:
        r6 = 0;
        goto L21
    }

    private static void computeStringConstants(int r5) {
        String r0 = sqr2String;
        if (r0 != null) goto L5;
    L6:
        DfpField r1 = new DfpField(r5, false);
        Dfp r6 = new Dfp(r1, 1);
        Dfp r2 = new Dfp(r1, 2);
        Dfp r3 = new Dfp(r1, 3);
        Dfp r4 = r2.sqrt2();
        sqr2String = r4.toString();
        sqr2ReciprocalString = r6.divide(r4).toString();
        Dfp r7 = r3.sqrt2();
        sqr3String = r7.toString();
        sqr3ReciprocalString = r6.divide(r7).toString();
        piString = computePi(r6, r2, r3).toString();
        eString = computeExp(r6, r6).toString();
        ln2String = computeLn(r2, r6, r2).toString();
        ln5String = computeLn(new Dfp(r1, 5), r6, r2).toString();
        ln10String = computeLn(new Dfp(r1, 10), r6, r2).toString();
        return;
    L5:
        if (r0.length() < (r5 - 3)) goto L6;
    }

    private static Dfp computePi(Dfp r7, Dfp r8, Dfp r9) {
        Dfp r0 = r8.sqrt2();
        Dfp r1 = r0.subtract(r7);
        Dfp r2 = r8.add(r8);
        Dfp r10 = r8.multiply(r9.subtract(r8.multiply(r0)));
        int r3 = 1;
        Dfp r4 = r1;
        Dfp r11 = r8;
    L4:
        if (r3 >= 20) goto L10;
        Dfp r5 = r4.multiply(r4);
        Dfp r6 = r7.subtract(r5.multiply(r5)).sqrt2().sqrt2();
        Dfp r12 = r7.subtract(r6).divide(r7.add(r6));
        Dfp r13 = r11.multiply(r2);
        Dfp r14 = r7.add(r12);
        Dfp r15 = r14.multiply(r14);
        r10 = r10.multiply(r15.multiply(r15)).subtract(r13.multiply(r12).multiply(r7.add(r12).add(r12.multiply(r12))));
        if (r12.equals(r4) == true) goto L10;
        r3 = r3 + 1;
        r4 = r12;
        r11 = r13;
    L10:
        return r7.divide(r10);
    }

    public static Dfp computeExp(Dfp r7, Dfp r8) {
        Dfp r0 = new Dfp(r8);
        Dfp r1 = new Dfp(r8);
        Dfp r2 = new Dfp(r8);
        Dfp r3 = new Dfp(r8);
        Dfp r4 = new Dfp(r8);
        int r5 = 0;
    L4:
        if (r5 >= 10000) goto L9;
        r4 = r4.multiply(r7);
        r0 = r0.add(r4.divide(r2));
        r3 = r3.add(r8);
        r2 = r2.multiply(r3);
        if (r0.equals(r1) == true) goto L9;
        r1 = new Dfp(r0);
        r5 = r5 + 1;
    L9:
        return r0;
    }

    public static Dfp computeLn(Dfp r5, Dfp r6, Dfp r7) {
        Dfp r8 = r5.add(new Dfp(r5.getField(), -1)).divide(r5.add(r6));
        Dfp r9 = new Dfp(r8);
        Dfp r0 = new Dfp(r8);
        Dfp r1 = new Dfp(r9);
        int r2 = 1;
        int r3 = 0;
    L4:
        if (r3 >= 10000) goto L10;
        r0 = r0.multiply(r8).multiply(r8);
        r2 = r2 + 2;
        r9 = r9.add(r0.divide(r2));
        if (r9.equals(r1) == true) goto L10;
        r1 = new Dfp(r9);
        r3 = r3 + 1;
    L10:
        return r9.multiply(r7);
    }
}
