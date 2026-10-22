package com.google.zxing.common.reedsolomon;

import android.icu.lang.UCharacter;

/* JADX INFO: loaded from: classes4.dex */
public final class GenericGF {
    public static final GenericGF AZTEC_DATA_10 = null;
    public static final GenericGF AZTEC_DATA_12 = null;
    public static final GenericGF AZTEC_DATA_6 = null;
    public static final GenericGF AZTEC_DATA_8 = null;
    public static final GenericGF AZTEC_PARAM = null;
    public static final GenericGF DATA_MATRIX_FIELD_256 = null;
    public static final GenericGF MAXICODE_FIELD_64 = null;
    public static final GenericGF QR_CODE_FIELD_256 = null;
    private final int[] expTable;
    private final int generatorBase;
    private final int[] logTable;
    private final GenericGFPoly one;
    private final int primitive;
    private final int size;
    private final GenericGFPoly zero;

    static int addOrSubtract(int r0, int r1) {
        return r0 ^ r1;
    }

    static {
        AZTEC_DATA_12 = new GenericGF(4201, 4096, 1);
        AZTEC_DATA_10 = new GenericGF(1033, 1024, 1);
        GenericGF r0 = new GenericGF(67, 64, 1);
        AZTEC_DATA_6 = r0;
        AZTEC_PARAM = new GenericGF(19, 16, 1);
        QR_CODE_FIELD_256 = new GenericGF(UCharacter.UnicodeBlock.HANIFI_ROHINGYA_ID, 256, 0);
        GenericGF r1 = new GenericGF(301, 256, 1);
        DATA_MATRIX_FIELD_256 = r1;
        AZTEC_DATA_8 = r1;
        MAXICODE_FIELD_64 = r0;
    }

    public GenericGF(int r5, int r6, int r7) {
        this.primitive = r5;
        this.size = r6;
        this.generatorBase = r7;
        this.expTable = new int[r6];
        this.logTable = new int[r6];
        int r2 = 1;
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L8;
        this.expTable[r1] = r2;
        r2 = r2 << 1;
        if (r2 < r6) goto L7;
        r2 = (r2 ^ r5) & (r6 - 1);
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        int r8 = 0;
    L10:
        if (r8 >= (r6 - 1)) goto L12;
        this.logTable[this.expTable[r8]] = r8;
        r8 = r8 + 1;
        goto L10
    L12:
        this.zero = new GenericGFPoly(this, new int[]{0});
        this.one = new GenericGFPoly(this, new int[]{1});
    }

    GenericGFPoly getZero() {
        return this.zero;
    }

    GenericGFPoly getOne() {
        return this.one;
    }

    GenericGFPoly buildMonomial(int r2, int r3) {
        if (r2 < 0) goto L9;
        if (r3 == 0) goto L5;
        int[] r4 = new int[r2 + 1];
        r4[0] = r3;
        return new GenericGFPoly(this, r4);
    L5:
        return this.zero;
    L9:
        throw new IllegalArgumentException();
    }

    int exp(int r1) {
        return this.expTable[r1];
    }

    int log(int r1) {
        if (r1 == 0) goto L6;
        return this.logTable[r1];
    L6:
        throw new IllegalArgumentException();
    }

    int inverse(int r3) {
        if (r3 == 0) goto L6;
        return this.expTable[(this.size - this.logTable[r3]) - 1];
    L6:
        throw new ArithmeticException();
    }

    int multiply(int r3, int r4) {
        if (r3 == 0) goto L7;
        if (r4 == 0) goto L9;
        int[] r0 = this.expTable;
        int[] r1 = this.logTable;
        return r0[(r1[r3] + r1[r4]) % (this.size - 1)];
    L9:
        return 0;
    L7:
        return 0;
    }

    public int getSize() {
        return this.size;
    }

    public int getGeneratorBase() {
        return this.generatorBase;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.primitive) + ',' + this.size + ')';
    }
}
