package com.obric.oui.texteffects.core;

import kotlin.Metadata;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006 "}, d2 = {"Lcom/obric/oui/texteffects/core/BlendSpec;", "", "(Ljava/lang/String;I)V", "CLEAR", "SRC", "DST", "SRC_OVER", "DST_OVER", "SRC_IN", "DST_IN", "SRC_OUT", "DST_OUT", "SRC_ATOP", "DST_ATOP", "XOR", "PLUS", "MODULATE", "SCREEN", "OVERLAY", "DARKEN", "LIGHTEN", "COLOR_DODGE", "COLOR_BURN", "HARD_LIGHT", "SOFT_LIGHT", "DIFFERENCE", "EXCLUSION", "MULTIPLY", "HUE", "SATURATION", "COLOR", "LUMINOSITY", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum BlendSpec extends Enum<BlendSpec> {
    private static final /* synthetic */ BlendSpec[] $VALUES = null;
    public static final BlendSpec CLEAR = null;
    public static final BlendSpec COLOR = null;
    public static final BlendSpec COLOR_BURN = null;
    public static final BlendSpec COLOR_DODGE = null;
    public static final BlendSpec DARKEN = null;
    public static final BlendSpec DIFFERENCE = null;
    public static final BlendSpec DST = null;
    public static final BlendSpec DST_ATOP = null;
    public static final BlendSpec DST_IN = null;
    public static final BlendSpec DST_OUT = null;
    public static final BlendSpec DST_OVER = null;
    public static final BlendSpec EXCLUSION = null;
    public static final BlendSpec HARD_LIGHT = null;
    public static final BlendSpec HUE = null;
    public static final BlendSpec LIGHTEN = null;
    public static final BlendSpec LUMINOSITY = null;
    public static final BlendSpec MODULATE = null;
    public static final BlendSpec MULTIPLY = null;
    public static final BlendSpec OVERLAY = null;
    public static final BlendSpec PLUS = null;
    public static final BlendSpec SATURATION = null;
    public static final BlendSpec SCREEN = null;
    public static final BlendSpec SOFT_LIGHT = null;
    public static final BlendSpec SRC = null;
    public static final BlendSpec SRC_ATOP = null;
    public static final BlendSpec SRC_IN = null;
    public static final BlendSpec SRC_OUT = null;
    public static final BlendSpec SRC_OVER = null;
    public static final BlendSpec XOR = null;

    private static final /* synthetic */ BlendSpec[] $values() {
        return new BlendSpec[]{CLEAR, SRC, DST, SRC_OVER, DST_OVER, SRC_IN, DST_IN, SRC_OUT, DST_OUT, SRC_ATOP, DST_ATOP, XOR, PLUS, MODULATE, SCREEN, OVERLAY, DARKEN, LIGHTEN, COLOR_DODGE, COLOR_BURN, HARD_LIGHT, SOFT_LIGHT, DIFFERENCE, EXCLUSION, MULTIPLY, HUE, SATURATION, COLOR, LUMINOSITY};
    }

    public static BlendSpec valueOf(String r1) {
        return (BlendSpec) Enum.valueOf(BlendSpec.class, r1);
    }

    public static BlendSpec[] values() {
        return (BlendSpec[]) $VALUES.clone();
    }

    private BlendSpec(String r1, int r2) {
        super(r1, r2);
    }

    static {
        CLEAR = new BlendSpec("CLEAR", 0);
        SRC = new BlendSpec("SRC", 1);
        DST = new BlendSpec("DST", 2);
        SRC_OVER = new BlendSpec("SRC_OVER", 3);
        DST_OVER = new BlendSpec("DST_OVER", 4);
        SRC_IN = new BlendSpec("SRC_IN", 5);
        DST_IN = new BlendSpec("DST_IN", 6);
        SRC_OUT = new BlendSpec("SRC_OUT", 7);
        DST_OUT = new BlendSpec("DST_OUT", 8);
        SRC_ATOP = new BlendSpec("SRC_ATOP", 9);
        DST_ATOP = new BlendSpec("DST_ATOP", 10);
        XOR = new BlendSpec("XOR", 11);
        PLUS = new BlendSpec("PLUS", 12);
        MODULATE = new BlendSpec("MODULATE", 13);
        SCREEN = new BlendSpec("SCREEN", 14);
        OVERLAY = new BlendSpec("OVERLAY", 15);
        DARKEN = new BlendSpec("DARKEN", 16);
        LIGHTEN = new BlendSpec("LIGHTEN", 17);
        COLOR_DODGE = new BlendSpec("COLOR_DODGE", 18);
        COLOR_BURN = new BlendSpec("COLOR_BURN", 19);
        HARD_LIGHT = new BlendSpec("HARD_LIGHT", 20);
        SOFT_LIGHT = new BlendSpec("SOFT_LIGHT", 21);
        DIFFERENCE = new BlendSpec("DIFFERENCE", 22);
        EXCLUSION = new BlendSpec("EXCLUSION", 23);
        MULTIPLY = new BlendSpec("MULTIPLY", 24);
        HUE = new BlendSpec("HUE", 25);
        SATURATION = new BlendSpec("SATURATION", 26);
        COLOR = new BlendSpec("COLOR", 27);
        LUMINOSITY = new BlendSpec("LUMINOSITY", 28);
        $VALUES = $values();
    }
}
