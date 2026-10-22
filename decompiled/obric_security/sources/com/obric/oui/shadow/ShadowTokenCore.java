package com.obric.oui.shadow;

import com.obric.oui.material.TokenCoreParser;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class ShadowTokenCore {
    public static final ShadowConfig[] Oui_Shadow_Regular = null;
    public static final ShadowConfig[] Oui_Shadow_Text_Regular = null;
    public static final ShadowConfig[] Oui_Shadow_Thick = null;
    public static final ShadowConfig[] Oui_Shadow_Thin = null;
    public static final ShadowConfig[] Oui_Shadow_UltraThick = null;
    public static final ShadowConfig[] Shadow_1 = null;
    public static final ShadowConfig[] Shadow_2 = null;
    public static final ShadowConfig[] Shadow_3 = null;
    public static final ShadowConfig[] Shadow_Text = null;
    public static final ShadowConfig[] Shadow_Thick = null;
    private static volatile ConcurrentHashMap<String, ShadowConfig[]> tokens;

    static {
        Oui_Shadow_Thin = new ShadowConfig[]{new ShadowConfig(0.0f, 2.0f, 10.0f, 251658240, 0.0f, -1)};
        Oui_Shadow_Regular = new ShadowConfig[]{new ShadowConfig(0.0f, 8.0f, 24.0f, 335544320, 0.0f, -1), new ShadowConfig(0.0f, 2.0f, 10.0f, 134217728, 0.0f, -1)};
        Oui_Shadow_Thick = new ShadowConfig[]{new ShadowConfig(0.0f, 12.0f, 24.0f, 603979776, 0.0f, -1)};
        Oui_Shadow_UltraThick = new ShadowConfig[]{new ShadowConfig(0.0f, 16.0f, 60.0f, 687865856, 0.0f, -1)};
        Oui_Shadow_Text_Regular = new ShadowConfig[]{new ShadowConfig(0.0f, 1.0f, 2.5f, 167772160, 0.0f, -1), new ShadowConfig(0.0f, 0.0f, 1.0f, 167772160, 0.0f, -1)};
        Shadow_1 = new ShadowConfig[]{new ShadowConfig(0.0f, 2.0f, 10.0f, 251658240, 0.0f, -1)};
        Shadow_2 = new ShadowConfig[]{new ShadowConfig(0.0f, 6.0f, 20.0f, 218103808, 0.0f, -1), new ShadowConfig(0.0f, 2.0f, 10.0f, 83886080, 0.0f, -1)};
        Shadow_3 = new ShadowConfig[]{new ShadowConfig(0.0f, 12.0f, 24.0f, 520093696, 0.0f, -1)};
        Shadow_Thick = new ShadowConfig[]{new ShadowConfig(0.0f, 16.0f, 60.0f, 687865856, 0.0f, -1)};
        Shadow_Text = new ShadowConfig[]{new ShadowConfig(0.0f, 1.0f, 2.5f, 167772160, 0.0f, -1), new ShadowConfig(0.0f, 0.0f, 1.0f, 167772160, 0.0f, -1)};
    }

    private ShadowTokenCore() {
    }

    public static ShadowConfig[] parse(Object r0, String r1) {
        return (ShadowConfig[]) TokenCoreParser.parse(r1, getTokens(r0));
    }

    private static ConcurrentHashMap<String, ShadowConfig[]> getTokens(Object r2) {
        ConcurrentHashMap<String, ShadowConfig[]> r0 = tokens;
        if (r0 == null) goto L5;
    L14:
        return r0;
    L5:
        monitor-enter(ShadowTokenCore.class);
        r0 = tokens;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        ConcurrentHashMap<String, ShadowConfig[]> r3 = TokenCoreParser.createTokenMap(r2, ShadowConfig[].class);     // Catch: Throwable -> L11
        tokens = r3;     // Catch: Throwable -> L11
        r0 = r3;
    L9:
        monitor-exit(ShadowTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
