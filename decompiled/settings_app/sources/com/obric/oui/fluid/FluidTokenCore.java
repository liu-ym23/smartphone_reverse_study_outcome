package com.obric.oui.fluid;

import com.obric.oui.graphic.BlendMode;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.TokenParserCore;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class FluidTokenCore {
    public static final FluidConfigCore OUI_Effect_Fluid_Regular_Dark = null;
    static final FluidConfigCore OUI_Effect_Fluid_Regular_Dark_V1 = null;
    static final FluidConfigCore OUI_Effect_Fluid_Regular_Dark_V2 = null;
    public static final FluidConfigCore OUI_Effect_Fluid_Regular_Light = null;
    static final FluidConfigCore OUI_Effect_Fluid_Regular_Light_V1 = null;
    static final FluidConfigCore OUI_Effect_Fluid_Regular_Light_V2 = null;
    public static final FluidConfigCore OUI_Effect_Fluid_Thin_Dark = null;
    static final FluidConfigCore OUI_Effect_Fluid_Thin_Dark_V1 = null;
    static final FluidConfigCore OUI_Effect_Fluid_Thin_Dark_V2 = null;
    public static final FluidConfigCore OUI_Effect_Fluid_Thin_Light = null;
    static final FluidConfigCore OUI_Effect_Fluid_Thin_Light_V1 = null;
    static final FluidConfigCore OUI_Effect_Fluid_Thin_Light_V2 = null;
    private static volatile ConcurrentHashMap<String, FluidConfigCore> tokens;

    static {
        FluidConfigCore r0 = new FluidConfigCore(new float[]{40.0f, -120.0f, 1.5f, 3.0f, 6.0f, 1.0f, 0.0f, 2.0f, Float.intBitsToFloat(-8355712), BlendMode.COLOR_DODGE.getPorterDuffMode(), Float.intBitsToFloat(452984831), BlendMode.PLUS_LIGHTER.getPorterDuffMode(), 0.0f});
        OUI_Effect_Fluid_Regular_Light_V2 = r0;
        FluidConfigCore r2 = new FluidConfigCore(new float[]{40.0f, -120.0f, 1.5f, 3.0f, 6.0f, 0.8f, 0.0f, 2.0f, Float.intBitsToFloat(-8355712), BlendMode.COLOR_DODGE.getPorterDuffMode(), Float.intBitsToFloat(872415231), BlendMode.PLUS_LIGHTER.getPorterDuffMode(), 0.0f});
        OUI_Effect_Fluid_Regular_Dark_V2 = r2;
        FluidConfigCore r13 = new FluidConfigCore(new float[]{40.0f, -120.0f, 1.5f, 3.0f, 6.0f, 0.7f, 0.0f, 2.0f, Float.intBitsToFloat(-8355712), BlendMode.COLOR_DODGE.getPorterDuffMode(), Float.intBitsToFloat(452984831), BlendMode.PLUS_LIGHTER.getPorterDuffMode(), 0.0f});
        OUI_Effect_Fluid_Thin_Light_V2 = r13;
        FluidConfigCore r11 = new FluidConfigCore(new float[]{40.0f, -120.0f, 1.5f, 3.0f, 6.0f, 0.4f, 0.0f, 2.0f, Float.intBitsToFloat(-8355712), BlendMode.COLOR_DODGE.getPorterDuffMode(), Float.intBitsToFloat(872415231), BlendMode.PLUS_LIGHTER.getPorterDuffMode(), 0.0f});
        OUI_Effect_Fluid_Thin_Dark_V2 = r11;
        FluidConfigCore r1 = new FluidConfigCore(new float[]{12.0f, -200.0f, 0.8f, 3.0f, 5.0f, 0.6f, 0.0f});
        OUI_Effect_Fluid_Regular_Light_V1 = r1;
        FluidConfigCore r4 = new FluidConfigCore(new float[]{12.0f, -200.0f, 0.8f, 3.0f, 5.0f, 0.16f, 0.0f});
        OUI_Effect_Fluid_Regular_Dark_V1 = r4;
        FluidConfigCore r5 = new FluidConfigCore(new float[]{12.0f, -200.0f, 0.8f, 3.0f, 5.0f, 0.3f, 0.0f});
        OUI_Effect_Fluid_Thin_Light_V1 = r5;
        FluidConfigCore r6 = new FluidConfigCore(new float[]{12.0f, -200.0f, 0.8f, 3.0f, 5.0f, 0.1f, 0.0f});
        OUI_Effect_Fluid_Thin_Dark_V1 = r6;
        if (OMaterialHelper.getMaterialApiVersion() >= 4) goto L6;
        r0 = r1;
    L6:
        OUI_Effect_Fluid_Regular_Light = r0;
        if (OMaterialHelper.getMaterialApiVersion() >= 4) goto L10;
        r2 = r4;
    L10:
        OUI_Effect_Fluid_Regular_Dark = r2;
        if (OMaterialHelper.getMaterialApiVersion() >= 4) goto L14;
        r13 = r5;
    L14:
        OUI_Effect_Fluid_Thin_Light = r13;
        if (OMaterialHelper.getMaterialApiVersion() >= 4) goto L18;
        r11 = r6;
    L18:
        OUI_Effect_Fluid_Thin_Dark = r11;
    }

    private FluidTokenCore() {
    }

    public static FluidConfigCore parse(Object r0, String r1) {
        return (FluidConfigCore) TokenParserCore.parse(r1, getTokens(r0));
    }

    public static void register(Object r1, Object r2, boolean r3) {
        TokenParserCore.register(getTokens(r1), r2, FluidConfigCore.class, r3);
    }

    public static void registerTokens(Object r0, Map<String, FluidConfigCore> r1, boolean r2) {
        TokenParserCore.registerTokens(getTokens(r0), r1, r2);
    }

    private static ConcurrentHashMap<String, FluidConfigCore> getTokens(Object r2) {
        ConcurrentHashMap<String, FluidConfigCore> r3 = tokens;
        if (r3 == null) goto L5;
    L14:
        return r3;
    L5:
        monitor-enter(FluidTokenCore.class);
        r3 = tokens;     // Catch: Throwable -> L11
        if (r3 != null) goto L9;
        r3 = TokenParserCore.createTokenMap(FluidTokenCore.class, FluidConfigCore.class);     // Catch: Throwable -> L11
        tokens = r3;     // Catch: Throwable -> L11
    L9:
        monitor-exit(FluidTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
