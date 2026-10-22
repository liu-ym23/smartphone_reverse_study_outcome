package androidx.core.graphics;

import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final enum BlendModeCompat extends Enum<BlendModeCompat> {
    private static final /* synthetic */ BlendModeCompat[] $VALUES = null;
    public static final BlendModeCompat CLEAR = null;

    @RequiresApi(29)
    public static final BlendModeCompat COLOR = null;

    @RequiresApi(29)
    public static final BlendModeCompat COLOR_BURN = null;

    @RequiresApi(29)
    public static final BlendModeCompat COLOR_DODGE = null;
    public static final BlendModeCompat DARKEN = null;

    @RequiresApi(29)
    public static final BlendModeCompat DIFFERENCE = null;
    public static final BlendModeCompat DST = null;
    public static final BlendModeCompat DST_ATOP = null;
    public static final BlendModeCompat DST_IN = null;
    public static final BlendModeCompat DST_OUT = null;
    public static final BlendModeCompat DST_OVER = null;

    @RequiresApi(29)
    public static final BlendModeCompat EXCLUSION = null;

    @RequiresApi(29)
    public static final BlendModeCompat HARD_LIGHT = null;

    @RequiresApi(29)
    public static final BlendModeCompat HUE = null;
    public static final BlendModeCompat LIGHTEN = null;

    @RequiresApi(29)
    public static final BlendModeCompat LUMINOSITY = null;
    public static final BlendModeCompat MODULATE = null;

    @RequiresApi(29)
    public static final BlendModeCompat MULTIPLY = null;
    public static final BlendModeCompat OVERLAY = null;
    public static final BlendModeCompat PLUS = null;

    @RequiresApi(29)
    public static final BlendModeCompat SATURATION = null;
    public static final BlendModeCompat SCREEN = null;

    @RequiresApi(29)
    public static final BlendModeCompat SOFT_LIGHT = null;
    public static final BlendModeCompat SRC = null;
    public static final BlendModeCompat SRC_ATOP = null;
    public static final BlendModeCompat SRC_IN = null;
    public static final BlendModeCompat SRC_OUT = null;
    public static final BlendModeCompat SRC_OVER = null;
    public static final BlendModeCompat XOR = null;

    static {
        BlendModeCompat r0 = new BlendModeCompat("CLEAR", 0);
        CLEAR = r0;
        BlendModeCompat r1 = new BlendModeCompat("SRC", 1);
        SRC = r1;
        BlendModeCompat r3 = new BlendModeCompat("DST", 2);
        DST = r3;
        BlendModeCompat r5 = new BlendModeCompat("SRC_OVER", 3);
        SRC_OVER = r5;
        BlendModeCompat r7 = new BlendModeCompat("DST_OVER", 4);
        DST_OVER = r7;
        BlendModeCompat r9 = new BlendModeCompat("SRC_IN", 5);
        SRC_IN = r9;
        BlendModeCompat r11 = new BlendModeCompat("DST_IN", 6);
        DST_IN = r11;
        BlendModeCompat r13 = new BlendModeCompat("SRC_OUT", 7);
        SRC_OUT = r13;
        BlendModeCompat r15 = new BlendModeCompat("DST_OUT", 8);
        DST_OUT = r15;
        BlendModeCompat r14 = new BlendModeCompat("SRC_ATOP", 9);
        SRC_ATOP = r14;
        BlendModeCompat r12 = new BlendModeCompat("DST_ATOP", 10);
        DST_ATOP = r12;
        BlendModeCompat r10 = new BlendModeCompat("XOR", 11);
        XOR = r10;
        BlendModeCompat r8 = new BlendModeCompat("PLUS", 12);
        PLUS = r8;
        BlendModeCompat r6 = new BlendModeCompat("MODULATE", 13);
        MODULATE = r6;
        BlendModeCompat r4 = new BlendModeCompat("SCREEN", 14);
        SCREEN = r4;
        BlendModeCompat r2 = new BlendModeCompat("OVERLAY", 15);
        OVERLAY = r2;
        BlendModeCompat r16 = new BlendModeCompat("DARKEN", 16);
        DARKEN = r16;
        BlendModeCompat r17 = new BlendModeCompat("LIGHTEN", 17);
        LIGHTEN = r17;
        BlendModeCompat r18 = new BlendModeCompat("COLOR_DODGE", 18);
        COLOR_DODGE = r18;
        BlendModeCompat r19 = new BlendModeCompat("COLOR_BURN", 19);
        COLOR_BURN = r19;
        BlendModeCompat r20 = new BlendModeCompat("HARD_LIGHT", 20);
        HARD_LIGHT = r20;
        BlendModeCompat r21 = new BlendModeCompat("SOFT_LIGHT", 21);
        SOFT_LIGHT = r21;
        BlendModeCompat r22 = new BlendModeCompat("DIFFERENCE", 22);
        DIFFERENCE = r22;
        BlendModeCompat r23 = new BlendModeCompat("EXCLUSION", 23);
        EXCLUSION = r23;
        BlendModeCompat r24 = new BlendModeCompat("MULTIPLY", 24);
        MULTIPLY = r24;
        BlendModeCompat r25 = new BlendModeCompat("HUE", 25);
        HUE = r25;
        BlendModeCompat r26 = new BlendModeCompat("SATURATION", 26);
        SATURATION = r26;
        BlendModeCompat r27 = new BlendModeCompat("COLOR", 27);
        COLOR = r27;
        BlendModeCompat r28 = new BlendModeCompat("LUMINOSITY", 28);
        LUMINOSITY = r28;
        $VALUES = new BlendModeCompat[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28};
    }

    private BlendModeCompat(String r1, int r2) {
        super(r1, r2);
    }

    public static BlendModeCompat valueOf(String r1) {
        return (BlendModeCompat) Enum.valueOf(BlendModeCompat.class, r1);
    }

    public static BlendModeCompat[] values() {
        return (BlendModeCompat[]) $VALUES.clone();
    }
}
