package com.obric.oui.graphic;

import android.graphics.PorterDuff;
import com.obric.oui.material.OMaterial;
import com.obric.oui.material.OMaterialHelper;

/* JADX INFO: loaded from: classes4.dex */
public final enum BlendMode extends Enum<BlendMode> {
    private static final /* synthetic */ BlendMode[] $VALUES = null;
    public static final BlendMode[] BLEND_MODES = null;
    public static final BlendMode CLEAR = null;
    public static final BlendMode COLOR = null;
    public static final BlendMode COLOR_BURN = null;
    public static final BlendMode COLOR_DODGE = null;
    public static final BlendMode DARKEN = null;
    public static final BlendMode DIFFERENCE = null;
    public static final BlendMode DST = null;
    public static final BlendMode DST_ATOP = null;
    public static final BlendMode DST_IN = null;
    public static final BlendMode DST_OUT = null;
    public static final BlendMode DST_OVER = null;
    public static final BlendMode EXCLUSION = null;
    public static final BlendMode HARD_LIGHT = null;
    public static final BlendMode HUE = null;
    public static final BlendMode LIGHTEN = null;
    public static final BlendMode LUMINOSITY = null;
    public static final BlendMode MODULATE = null;
    public static final BlendMode MULTIPLY = null;
    public static final BlendMode OVERLAY = null;
    public static final BlendMode PLUS = null;
    public static final BlendMode PLUS_DARKER = null;
    public static final BlendMode PLUS_LIGHTER = null;
    public static final BlendMode SATURATION = null;
    public static final BlendMode SCREEN = null;
    public static final BlendMode SOFT_LIGHT = null;
    public static final BlendMode SRC = null;
    public static final BlendMode SRC_ATOP = null;
    public static final BlendMode SRC_IN = null;
    public static final BlendMode SRC_OUT = null;
    public static final BlendMode SRC_OVER = null;
    public static final BlendMode XOR = null;
    public final int porterDuffMode;

    /* JADX INFO: renamed from: com.obric.oui.graphic.BlendMode$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$oui$graphic$BlendMode = null;

        static {
            int[] r0 = new int[BlendMode.values().length];
            $SwitchMap$com$obric$oui$graphic$BlendMode = r0;
            r0[BlendMode.CLEAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L62:
            $SwitchMap$com$obric$oui$graphic$BlendMode[BlendMode.SRC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L46:
            $SwitchMap$com$obric$oui$graphic$BlendMode[BlendMode.DST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L58:
            $SwitchMap$com$obric$oui$graphic$BlendMode[BlendMode.SRC_OVER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L64:
            $SwitchMap$com$obric$oui$graphic$BlendMode[BlendMode.DST_OVER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L48:
            $SwitchMap$com$obric$oui$graphic$BlendMode[BlendMode.SRC_IN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L52:
            $SwitchMap$com$obric$oui$graphic$BlendMode[BlendMode.DST_IN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L74:
            $SwitchMap$com$obric$oui$graphic$BlendMode[BlendMode.SRC_OUT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L42:
            $SwitchMap$com$obric$oui$graphic$BlendMode[BlendMode.DST_OUT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L30
        L68:
            $SwitchMap$com$obric$oui$graphic$BlendMode[BlendMode.SRC_ATOP.ordinal()] = 10;     // Catch: NoSuchFieldError -> L31
        L70:
            $SwitchMap$com$obric$oui$graphic$BlendMode[BlendMode.DST_ATOP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L32
        L54:
            $SwitchMap$com$obric$oui$graphic$BlendMode[BlendMode.XOR.ordinal()] = 12;     // Catch: NoSuchFieldError -> L33
        L60:
            $SwitchMap$com$obric$oui$graphic$BlendMode[BlendMode.DARKEN.ordinal()] = 13;     // Catch: NoSuchFieldError -> L34
        L44:
            $SwitchMap$com$obric$oui$graphic$BlendMode[BlendMode.LIGHTEN.ordinal()] = 14;     // Catch: NoSuchFieldError -> L35
        L50:
            $SwitchMap$com$obric$oui$graphic$BlendMode[BlendMode.MODULATE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L36
        L72:
            $SwitchMap$com$obric$oui$graphic$BlendMode[BlendMode.SCREEN.ordinal()] = 16;     // Catch: NoSuchFieldError -> L37
        L40:
            $SwitchMap$com$obric$oui$graphic$BlendMode[BlendMode.PLUS.ordinal()] = 17;     // Catch: NoSuchFieldError -> L38
        L66:
            $SwitchMap$com$obric$oui$graphic$BlendMode[BlendMode.OVERLAY.ordinal()] = 18;     // Catch: NoSuchFieldError -> L39
            return;
        }
    }

    public static BlendMode valueOf(String r1) {
        return (BlendMode) Enum.valueOf(BlendMode.class, r1);
    }

    public static BlendMode[] values() {
        return (BlendMode[]) $VALUES.clone();
    }

    static {
        BlendMode r0 = new BlendMode("CLEAR", 0, 0);
        CLEAR = r0;
        BlendMode r1 = new BlendMode("SRC", 1, 1);
        SRC = r1;
        BlendMode r3 = new BlendMode("DST", 2, 2);
        DST = r3;
        BlendMode r5 = new BlendMode("SRC_OVER", 3, 3);
        SRC_OVER = r5;
        BlendMode r7 = new BlendMode("DST_OVER", 4, 4);
        DST_OVER = r7;
        BlendMode r9 = new BlendMode("SRC_IN", 5, 5);
        SRC_IN = r9;
        BlendMode r11 = new BlendMode("DST_IN", 6, 6);
        DST_IN = r11;
        BlendMode r13 = new BlendMode("SRC_OUT", 7, 7);
        SRC_OUT = r13;
        BlendMode r15 = new BlendMode("DST_OUT", 8, 8);
        DST_OUT = r15;
        BlendMode r14 = new BlendMode("SRC_ATOP", 9, 9);
        SRC_ATOP = r14;
        BlendMode r12 = new BlendMode("DST_ATOP", 10, 10);
        DST_ATOP = r12;
        BlendMode r10 = new BlendMode("XOR", 11, 11);
        XOR = r10;
        BlendMode r8 = new BlendMode("PLUS", 12, 12);
        PLUS = r8;
        BlendMode r6 = new BlendMode("MODULATE", 13, 13);
        MODULATE = r6;
        BlendMode r4 = new BlendMode("SCREEN", 14, 14);
        SCREEN = r4;
        BlendMode r2 = new BlendMode("OVERLAY", 15, 15);
        OVERLAY = r2;
        BlendMode r16 = new BlendMode("DARKEN", 16, 16);
        DARKEN = r16;
        BlendMode r17 = new BlendMode("LIGHTEN", 17, 17);
        LIGHTEN = r17;
        BlendMode r18 = new BlendMode("COLOR_DODGE", 18, 18);
        COLOR_DODGE = r18;
        BlendMode r19 = new BlendMode("COLOR_BURN", 19, 19);
        COLOR_BURN = r19;
        BlendMode r20 = new BlendMode("HARD_LIGHT", 20, 20);
        HARD_LIGHT = r20;
        BlendMode r21 = new BlendMode("SOFT_LIGHT", 21, 21);
        SOFT_LIGHT = r21;
        BlendMode r22 = new BlendMode("DIFFERENCE", 22, 22);
        DIFFERENCE = r22;
        BlendMode r23 = new BlendMode("EXCLUSION", 23, 23);
        EXCLUSION = r23;
        BlendMode r24 = new BlendMode("MULTIPLY", 24, 24);
        MULTIPLY = r24;
        BlendMode r25 = new BlendMode("HUE", 25, 25);
        HUE = r25;
        BlendMode r26 = new BlendMode("SATURATION", 26, 26);
        SATURATION = r26;
        BlendMode r27 = new BlendMode("COLOR", 27, 27);
        COLOR = r27;
        BlendMode r28 = new BlendMode("LUMINOSITY", 28, 28);
        LUMINOSITY = r28;
        BlendMode r29 = new BlendMode("PLUS_DARKER", 29, 101);
        PLUS_DARKER = r29;
        BlendMode r30 = new BlendMode("PLUS_LIGHTER", 30, 102);
        PLUS_LIGHTER = r30;
        $VALUES = new BlendMode[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30};
        BLEND_MODES = values();
    }

    private BlendMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.porterDuffMode = r3;
    }

    public int getPorterDuffMode() {
        return this.porterDuffMode;
    }

    public static int toValue(BlendMode r0) {
        return r0.porterDuffMode;
    }

    public static BlendMode fromValue(int r5) {
        BlendMode[] r0 = BLEND_MODES;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        BlendMode r3 = r0[r2];
        if (r3.porterDuffMode == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public static int mapToLegacyObricBlend(int r1) {
        return mapToLegacyObricBlend(r1, false);
    }

    public static int mapToLegacyObricBlend(int r1, boolean r2) {
        if (OMaterial.ENABLE_BLEND_MODE_COMPAT == true) goto L7;
        if (r2 == true) goto L7;
        return r1;
    L7:
        if (r1 != SRC_OVER.ordinal()) goto L11;
        return OMaterialHelper.LEGACY_BLEND_MODE.DEFAULT.ordinal();
    L11:
        if (r1 != COLOR_BURN.ordinal()) goto L15;
        return OMaterialHelper.LEGACY_BLEND_MODE.COLOR_BURN.ordinal();
    L15:
        if (r1 != COLOR_DODGE.ordinal()) goto L19;
        return OMaterialHelper.LEGACY_BLEND_MODE.COLOR_DODGE.ordinal();
    L19:
        if (r1 != PLUS_DARKER.ordinal()) goto L23;
        return OMaterialHelper.LEGACY_BLEND_MODE.PLUS_DARKER.ordinal();
    L23:
        if (r1 != PLUS_LIGHTER.ordinal()) goto L27;
        return OMaterialHelper.LEGACY_BLEND_MODE.PLUS_LIGHTER.ordinal();
    L27:
        if (r1 != LUMINOSITY.ordinal()) goto L31;
        return OMaterialHelper.LEGACY_BLEND_MODE.LUMINOSITY.ordinal();
    L31:
        if (r1 != OVERLAY.ordinal()) goto L35;
        return OMaterialHelper.LEGACY_BLEND_MODE.OVERLAY.ordinal();
    L35:
        if (r1 != SOFT_LIGHT.ordinal()) goto L39;
        return OMaterialHelper.LEGACY_BLEND_MODE.SOFT_LIGHT.ordinal();
    L39:
        return OMaterialHelper.LEGACY_BLEND_MODE.DEFAULT.ordinal();
    }

    public static int mapToLegacyObricBlend(BlendMode r1) {
        return mapToLegacyObricBlend(r1, false);
    }

    public static int mapToLegacyObricBlend(BlendMode r1, boolean r2) {
        if (OMaterial.ENABLE_BLEND_MODE_COMPAT == true) goto L11;
        if (r2 == true) goto L11;
        if (r1 != null) goto L9;
        r1 = SRC_OVER;
    L9:
        return r1.porterDuffMode;
    L11:
        if (r1 != SRC_OVER) goto L15;
        return OMaterialHelper.LEGACY_BLEND_MODE.DEFAULT.ordinal();
    L15:
        if (r1 != COLOR_BURN) goto L19;
        return OMaterialHelper.LEGACY_BLEND_MODE.COLOR_BURN.ordinal();
    L19:
        if (r1 != COLOR_DODGE) goto L23;
        return OMaterialHelper.LEGACY_BLEND_MODE.COLOR_DODGE.ordinal();
    L23:
        if (r1 != PLUS_DARKER) goto L27;
        return OMaterialHelper.LEGACY_BLEND_MODE.PLUS_DARKER.ordinal();
    L27:
        if (r1 != PLUS_LIGHTER) goto L31;
        return OMaterialHelper.LEGACY_BLEND_MODE.PLUS_LIGHTER.ordinal();
    L31:
        if (r1 != LUMINOSITY) goto L35;
        return OMaterialHelper.LEGACY_BLEND_MODE.LUMINOSITY.ordinal();
    L35:
        if (r1 != OVERLAY) goto L39;
        return OMaterialHelper.LEGACY_BLEND_MODE.OVERLAY.ordinal();
    L39:
        if (r1 != SOFT_LIGHT) goto L43;
        return OMaterialHelper.LEGACY_BLEND_MODE.SOFT_LIGHT.ordinal();
    L43:
        return OMaterialHelper.LEGACY_BLEND_MODE.DEFAULT.ordinal();
    }

    public static PorterDuff.Mode blendModeToPorterDuffMode(BlendMode r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        switch(AnonymousClass1.$SwitchMap$com$obric$oui$graphic$BlendMode[r2.ordinal()]) {
            case 1: goto L43;
            case 2: goto L41;
            case 3: goto L39;
            case 4: goto L37;
            case 5: goto L35;
            case 6: goto L33;
            case 7: goto L31;
            case 8: goto L29;
            case 9: goto L27;
            case 10: goto L25;
            case 11: goto L23;
            case 12: goto L21;
            case 13: goto L19;
            case 14: goto L17;
            case 15: goto L15;
            case 16: goto L13;
            case 17: goto L11;
            case 18: goto L9;
            default: goto L7;
        };
    L7:
        return null;
    L9:
        return PorterDuff.Mode.OVERLAY;
    L11:
        return PorterDuff.Mode.ADD;
    L13:
        return PorterDuff.Mode.SCREEN;
    L15:
        return PorterDuff.Mode.MULTIPLY;
    L17:
        return PorterDuff.Mode.LIGHTEN;
    L19:
        return PorterDuff.Mode.DARKEN;
    L21:
        return PorterDuff.Mode.XOR;
    L23:
        return PorterDuff.Mode.DST_ATOP;
    L25:
        return PorterDuff.Mode.SRC_ATOP;
    L27:
        return PorterDuff.Mode.DST_OUT;
    L29:
        return PorterDuff.Mode.SRC_OUT;
    L31:
        return PorterDuff.Mode.DST_IN;
    L33:
        return PorterDuff.Mode.SRC_IN;
    L35:
        return PorterDuff.Mode.DST_OVER;
    L37:
        return PorterDuff.Mode.SRC_OVER;
    L39:
        return PorterDuff.Mode.DST;
    L41:
        return PorterDuff.Mode.SRC;
    L43:
        return PorterDuff.Mode.CLEAR;
    }

    public static android.graphics.BlendMode toAndroidBlendMode(BlendMode r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        switch(AnonymousClass1.$SwitchMap$com$obric$oui$graphic$BlendMode[r2.ordinal()]) {
            case 1: goto L43;
            case 2: goto L41;
            case 3: goto L39;
            case 4: goto L37;
            case 5: goto L35;
            case 6: goto L33;
            case 7: goto L31;
            case 8: goto L29;
            case 9: goto L27;
            case 10: goto L25;
            case 11: goto L23;
            case 12: goto L21;
            case 13: goto L19;
            case 14: goto L17;
            case 15: goto L15;
            case 16: goto L13;
            case 17: goto L11;
            case 18: goto L9;
            default: goto L7;
        };
    L7:
        return null;
    L9:
        return android.graphics.BlendMode.OVERLAY;
    L11:
        return android.graphics.BlendMode.PLUS;
    L13:
        return android.graphics.BlendMode.SCREEN;
    L15:
        return android.graphics.BlendMode.MULTIPLY;
    L17:
        return android.graphics.BlendMode.LIGHTEN;
    L19:
        return android.graphics.BlendMode.DARKEN;
    L21:
        return android.graphics.BlendMode.XOR;
    L23:
        return android.graphics.BlendMode.DST_ATOP;
    L25:
        return android.graphics.BlendMode.SRC_ATOP;
    L27:
        return android.graphics.BlendMode.DST_OUT;
    L29:
        return android.graphics.BlendMode.SRC_OUT;
    L31:
        return android.graphics.BlendMode.DST_IN;
    L33:
        return android.graphics.BlendMode.SRC_IN;
    L35:
        return android.graphics.BlendMode.DST_OVER;
    L37:
        return android.graphics.BlendMode.SRC_OVER;
    L39:
        return android.graphics.BlendMode.DST;
    L41:
        return android.graphics.BlendMode.SRC;
    L43:
        return android.graphics.BlendMode.CLEAR;
    }
}
