package org.apache.commons.math3.dfp;

/* JADX INFO: loaded from: classes6.dex */
public class DfpDec extends Dfp {

    /* JADX INFO: renamed from: org.apache.commons.math3.dfp.DfpDec$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode = null;

        static {
            int[] r0 = new int[DfpField.RoundingMode.values().length];
            $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode = r0;
            r0[DfpField.RoundingMode.ROUND_DOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_UP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_HALF_UP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_HALF_DOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_HALF_EVEN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_HALF_ODD.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_CEIL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_FLOOR.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    protected DfpDec(DfpField r1) {
        super(r1);
    }

    protected DfpDec(DfpField r1, byte r2) {
        super(r1, r2);
    }

    protected DfpDec(DfpField r1, int r2) {
        super(r1, r2);
    }

    protected DfpDec(DfpField r1, long r2) {
        super(r1, r2);
    }

    protected DfpDec(DfpField r1, double r2) {
        super(r1, r2);
        round(0);
    }

    public DfpDec(Dfp r1) {
        super(r1);
        round(0);
    }

    protected DfpDec(DfpField r1, String r2) {
        super(r1, r2);
        round(0);
    }

    protected DfpDec(DfpField r1, byte r2, byte r3) {
        super(r1, r2, r3);
    }

    @Override // org.apache.commons.math3.dfp.Dfp
    public Dfp newInstance() {
        return new DfpDec(getField());
    }

    @Override // org.apache.commons.math3.dfp.Dfp
    public Dfp newInstance(byte r2) {
        return new DfpDec(getField(), r2);
    }

    @Override // org.apache.commons.math3.dfp.Dfp
    public Dfp newInstance(int r2) {
        return new DfpDec(getField(), r2);
    }

    @Override // org.apache.commons.math3.dfp.Dfp
    public Dfp newInstance(long r2) {
        return new DfpDec(getField(), r2);
    }

    @Override // org.apache.commons.math3.dfp.Dfp
    public Dfp newInstance(double r2) {
        return new DfpDec(getField(), r2);
    }

    @Override // org.apache.commons.math3.dfp.Dfp
    public Dfp newInstance(Dfp r4) {
        if (getField().getRadixDigits() == r4.getField().getRadixDigits()) goto L7;
        getField().setIEEEFlagsBits(1);
        Dfp r0 = newInstance(getZero());
        r0.nans = 3;
        return dotrap(1, "newInstance", r4, r0);
    L7:
        return new DfpDec(r4);
    }

    @Override // org.apache.commons.math3.dfp.Dfp
    public Dfp newInstance(String r2) {
        return new DfpDec(getField(), r2);
    }

    @Override // org.apache.commons.math3.dfp.Dfp
    public Dfp newInstance(byte r2, byte r3) {
        return new DfpDec(getField(), r2, r3);
    }

    protected int getDecimalDigits() {
        return (getRadixDigits() * 4) - 3;
    }

    @Override // org.apache.commons.math3.dfp.Dfp
    protected int round(int r12) {
        int r0 = this.mant[this.mant.length - 1];
        if (r0 != 0) goto L5;
        return 0;
    L5:
        int r3 = this.mant.length * 4;
        int r6 = 1000;
    L6:
        if (r6 <= r0) goto L8;
        r6 = r6 / 10;
        r3 = r3 - 1;
        goto L6
    L8:
        int r1 = getDecimalDigits();
        int r4 = r3 - r1;
        int r7 = r4 / 4;
        int r8 = 0;
        int r9 = 1;
    L10:
        if (r8 >= (r4 % 4)) goto L12;
        r9 = r9 * 10;
        r8 = r8 + 1;
        goto L10
    L12:
        int r5 = this.mant[r7];
        if (r9 <= 1) goto L15;
    L18:
        if (r9 != 1) goto L20;
        int r10 = r7 - 1;
        int r2 = (this.mant[r10] / 1000) % 10;
        int[] r11 = this.mant;
        r11[r10] = r11[r10] % 1000;
        int r13 = this.mant[r10];
    L21:
        int r14 = r12 | r13;
        int r15 = 0;
    L22:
        if (r15 >= r7) goto L24;
        r14 = r14 | this.mant[r15];
        this.mant[r15] = 0;
        r15 = r15 + 1;
        goto L22
    L24:
        int r16 = r5 / r9;
        this.mant[r7] = r16 * r9;
        switch(AnonymousClass1.$SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[getField().getRoundingMode().ordinal()]) {
            case 1: goto L59;
            case 2: goto L56;
            case 3: goto L54;
            case 4: goto L52;
            case 5: goto L44;
            case 6: goto L36;
            case 7: goto L32;
            default: goto L27;
        };
    L36:
        if (r2 <= 5) goto L37;
    L35:
        boolean r17 = true;
    L60:
        if (r17 == false) goto L67;
    L62:
        if (r7 >= this.mant.length) goto L64;
        int r18 = this.mant[r7] + r9;
        r9 = r18 / 10000;
        this.mant[r7] = r18 % 10000;
        r7 = r7 + 1;
        goto L62
    L64:
        if (r9 == 0) goto L67;
        shiftRight();
        this.mant[this.mant.length - 1] = r9;
    L67:
        if (this.exp >= (-32767)) goto L71;
        getField().setIEEEFlagsBits(8);
        return 8;
    L71:
        if (this.exp <= 32768) goto L74;
        getField().setIEEEFlagsBits(4);
        return 4;
    L74:
        if (r2 != 0) goto L78;
        if (r14 != 0) goto L78;
        return 0;
    L78:
        getField().setIEEEFlagsBits(16);
        return 16;
    L37:
        if (r2 != 5) goto L39;
        if (r14 != 0) goto L35;
    L39:
        if (r2 != 5) goto L88;
        if (r14 == 0) goto L42;
        r17 = false;
        goto L60
    L42:
        if ((r16 & 1) == 0) goto L35;
        r17 = false;
        goto L60
    L88:
        r17 = false;
        goto L60
    L44:
        if (r2 > 5) goto L35;
        if (r2 != 5) goto L47;
        if (r14 != 0) goto L35;
    L47:
        if (r2 != 5) goto L91;
        if (r14 == 0) goto L50;
        r17 = false;
        goto L60
    L50:
        if ((r16 & 1) == 1) goto L35;
        r17 = false;
        goto L60
    L91:
        r17 = false;
        goto L60
    L52:
        if (r2 > 5) goto L35;
        r17 = false;
        goto L60
    L54:
        if (r2 >= 5) goto L35;
        r17 = false;
        goto L60
    L56:
        if (r2 != 0) goto L35;
        if (r14 != 0) goto L35;
        r17 = false;
        goto L60
    L59:
        r17 = false;
        goto L60
    L27:
        if (this.sign != (-1)) goto L84;
        if (r2 != 0) goto L35;
        if (r14 != 0) goto L35;
        r17 = false;
        goto L60
    L84:
        r17 = false;
        goto L60
    L32:
        if (this.sign != 1) goto L86;
        if (r2 != 0) goto L35;
        if (r14 != 0) goto L35;
        r17 = false;
        goto L60
    L86:
        r17 = false;
        goto L60
    L20:
        r2 = ((r5 * 10) / r9) % 10;
        r13 = r5 % (r9 / 10);
        goto L21
    L15:
        if (r1 != ((this.mant.length * 4) - 3)) goto L18;
        return super.round(r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.dfp.Dfp
    public Dfp nextAfter(Dfp r6) {
        if (getField().getRadixDigits() == r6.getField().getRadixDigits()) goto L6;
        getField().setIEEEFlagsBits(1);
        Dfp r0 = newInstance(getZero());
        r0.nans = 3;
        return dotrap(1, "nextAfter", r6, r0);
    L6:
        boolean r1 = lessThan(r6);
        if (equals(r6) == false) goto L11;
        return newInstance(r6);
    L11:
        if (lessThan(getZero()) == false) goto L13;
        r1 = !r1;
    L13:
        if (r1 == false) goto L21;
        Dfp r2 = copysign(power10((intLog10() - getDecimalDigits()) + 1), this);
        if (equals(getZero()) == false) goto L18;
        r2 = power10K(((-32767) - this.mant.length) - 1);
    L18:
        if (r2.equals(getZero()) == false) goto L20;
        Dfp r3 = copysign(newInstance(getZero()), this);
    L33:
        if (r3.classify() != 1) goto L38;
        if (classify() == 1) goto L38;
        getField().setIEEEFlagsBits(16);
        r3 = dotrap(16, "nextAfter", r6, r3);
    L38:
        if (r3.equals(getZero()) == true) goto L40;
        return r3;
    L40:
        if (equals(getZero()) == true) goto L44;
        getField().setIEEEFlagsBits(16);
        return dotrap(16, "nextAfter", r6, r3);
    L44:
        return r3;
    L20:
        r3 = add(r2);
        goto L33
    L21:
        Dfp r4 = copysign(power10(intLog10()), this);
        if (equals(r4) == false) goto L24;
        Dfp r5 = r4.divide(power10(getDecimalDigits()));
    L26:
        if (equals(getZero()) == false) goto L29;
        r5 = power10K(((-32767) - this.mant.length) - 1);
    L29:
        if (r5.equals(getZero()) == false) goto L31;
        r3 = copysign(newInstance(getZero()), this);
        goto L33
    L31:
        r3 = subtract(r5);
        goto L33
    L24:
        r5 = r4.divide(power10(getDecimalDigits() - 1));
        goto L26
    }
}
