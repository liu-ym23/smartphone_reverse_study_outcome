package com.google.zxing.qrcode.decoder;

/* JADX INFO: loaded from: classes4.dex */
public final enum Mode extends Enum<Mode> {
    private static final /* synthetic */ Mode[] $VALUES = null;
    public static final Mode ALPHANUMERIC = null;
    public static final Mode BYTE = null;
    public static final Mode ECI = null;
    public static final Mode FNC1_FIRST_POSITION = null;
    public static final Mode FNC1_SECOND_POSITION = null;
    public static final Mode HANZI = null;
    public static final Mode KANJI = null;
    public static final Mode NUMERIC = null;
    public static final Mode STRUCTURED_APPEND = null;
    public static final Mode TERMINATOR = null;
    private final int bits;
    private final int[] characterCountBitsForVersions;

    public static Mode valueOf(String r1) {
        return (Mode) Enum.valueOf(Mode.class, r1);
    }

    public static Mode[] values() {
        return (Mode[]) $VALUES.clone();
    }

    static {
        Mode r0 = new Mode("TERMINATOR", 0, new int[]{0, 0, 0}, 0);
        TERMINATOR = r0;
        Mode r2 = new Mode("NUMERIC", 1, new int[]{10, 12, 14}, 1);
        NUMERIC = r2;
        Mode r3 = new Mode("ALPHANUMERIC", 2, new int[]{9, 11, 13}, 2);
        ALPHANUMERIC = r3;
        Mode r5 = new Mode("STRUCTURED_APPEND", 3, new int[]{0, 0, 0}, 3);
        STRUCTURED_APPEND = r5;
        Mode r7 = new Mode("BYTE", 4, new int[]{8, 16, 16}, 4);
        BYTE = r7;
        Mode r9 = new Mode("ECI", 5, new int[]{0, 0, 0}, 7);
        ECI = r9;
        Mode r10 = new Mode("KANJI", 6, new int[]{8, 10, 12}, 8);
        KANJI = r10;
        Mode r12 = new Mode("FNC1_FIRST_POSITION", 7, new int[]{0, 0, 0}, 5);
        FNC1_FIRST_POSITION = r12;
        Mode r11 = new Mode("FNC1_SECOND_POSITION", 8, new int[]{0, 0, 0}, 9);
        FNC1_SECOND_POSITION = r11;
        Mode r14 = new Mode("HANZI", 9, new int[]{8, 10, 12}, 13);
        HANZI = r14;
        $VALUES = new Mode[]{r0, r2, r3, r5, r7, r9, r10, r12, r11, r14};
    }

    private Mode(String r1, int r2, int[] r3, int r4) {
        super(r1, r2);
        this.characterCountBitsForVersions = r3;
        this.bits = r4;
    }

    public static Mode forBits(int r1) {
        if (r1 == 0) goto L42;
        if (r1 == 1) goto L40;
        if (r1 == 2) goto L38;
        if (r1 == 3) goto L36;
        if (r1 == 4) goto L34;
        if (r1 == 5) goto L32;
        if (r1 == 7) goto L30;
        if (r1 == 8) goto L28;
        if (r1 == 9) goto L26;
        if (r1 != 13) goto L24;
        return HANZI;
    L24:
        throw new IllegalArgumentException();
    L26:
        return FNC1_SECOND_POSITION;
    L28:
        return KANJI;
    L30:
        return ECI;
    L32:
        return FNC1_FIRST_POSITION;
    L34:
        return BYTE;
    L36:
        return STRUCTURED_APPEND;
    L38:
        return ALPHANUMERIC;
    L40:
        return NUMERIC;
    L42:
        return TERMINATOR;
    }

    public int getCharacterCountBits(Version r2) {
        int r3 = r2.getVersionNumber();
        if (r3 > 9) goto L6;
        char r4 = 0;
    L10:
        return this.characterCountBitsForVersions[r4];
    L6:
        if (r3 > 26) goto L8;
        r4 = 1;
        goto L10
    L8:
        r4 = 2;
        goto L10
    }

    public int getBits() {
        return this.bits;
    }
}
