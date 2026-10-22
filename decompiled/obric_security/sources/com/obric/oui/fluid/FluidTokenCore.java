package com.obric.oui.fluid;

import com.obric.oui.graphic.BlendMode;
import com.obric.oui.material.TokenCoreParser;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class FluidTokenCore {
    public static final FluidConfig OUI_Effect_Fluid_Regular_Dark = null;
    public static final FluidConfig OUI_Effect_Fluid_Regular_Light = null;
    public static final FluidConfig OUI_Effect_Fluid_Thin_Dark = null;
    public static final FluidConfig OUI_Effect_Fluid_Thin_Light = null;
    private static volatile ConcurrentHashMap<String, FluidConfig> tokens;

    static {
        OUI_Effect_Fluid_Regular_Light = new FluidConfig(new float[]{40.0f, -120.0f, 1.5f, 3.0f, 6.0f, 1.0f, 0.0f, 2.0f, Float.intBitsToFloat(-8355712), BlendMode.COLOR_DODGE.getPorterDuffMode(), Float.intBitsToFloat(452984831), BlendMode.PLUS_LIGHTER.getPorterDuffMode(), 0.0f});
        OUI_Effect_Fluid_Regular_Dark = new FluidConfig(new float[]{40.0f, -120.0f, 1.5f, 3.0f, 6.0f, 0.8f, 0.0f, 2.0f, Float.intBitsToFloat(-8355712), BlendMode.COLOR_DODGE.getPorterDuffMode(), Float.intBitsToFloat(872415231), BlendMode.PLUS_LIGHTER.getPorterDuffMode(), 0.0f});
        OUI_Effect_Fluid_Thin_Light = new FluidConfig(new float[]{40.0f, -120.0f, 1.5f, 3.0f, 6.0f, 0.7f, 0.0f, 2.0f, Float.intBitsToFloat(-8355712), BlendMode.COLOR_DODGE.getPorterDuffMode(), Float.intBitsToFloat(452984831), BlendMode.PLUS_LIGHTER.getPorterDuffMode(), 0.0f});
        OUI_Effect_Fluid_Thin_Dark = new FluidConfig(new float[]{40.0f, -120.0f, 1.5f, 3.0f, 6.0f, 0.4f, 0.0f, 2.0f, Float.intBitsToFloat(-8355712), BlendMode.COLOR_DODGE.getPorterDuffMode(), Float.intBitsToFloat(872415231), BlendMode.PLUS_LIGHTER.getPorterDuffMode(), 0.0f});
    }

    private FluidTokenCore() {
    }

    public static FluidConfig parse(Object r0, String r1) {
        return (FluidConfig) TokenCoreParser.parse(r1, getTokens(r0));
    }

    public static void register(Object r1, Object r2, boolean r3) {
        TokenCoreParser.register(getTokens(r1), r2, FluidConfig.class, r3);
    }

    public static void registerTokens(Object r0, Map<String, FluidConfig> r1, boolean r2) {
        TokenCoreParser.registerTokens(getTokens(r0), r1, r2);
    }

    private static ConcurrentHashMap<String, FluidConfig> getTokens(Object r2) {
        ConcurrentHashMap<String, FluidConfig> r0 = tokens;
        if (r0 == null) goto L5;
    L14:
        return r0;
    L5:
        monitor-enter(FluidTokenCore.class);
        r0 = tokens;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        ConcurrentHashMap<String, FluidConfig> r3 = TokenCoreParser.createTokenMap(r2, FluidConfig.class);     // Catch: Throwable -> L11
        tokens = r3;     // Catch: Throwable -> L11
        r0 = r3;
    L9:
        monitor-exit(FluidTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
