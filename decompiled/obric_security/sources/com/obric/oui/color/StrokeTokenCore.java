package com.obric.oui.color;

import com.obric.oui.graphic.BlendMode;
import com.obric.oui.material.TokenCoreParser;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class StrokeTokenCore {
    public static final Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Blue_Regular = null;
    public static final StrokeConfig OUI_Effect_Stroke_Blue_Regular_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Blue_Regular_Light = null;
    public static final Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Blue_Thin = null;
    public static final StrokeConfig OUI_Effect_Stroke_Blue_Thin_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Blue_Thin_Light = null;
    public static final Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Green_Regular = null;
    public static final StrokeConfig OUI_Effect_Stroke_Green_Regular_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Green_Regular_Light = null;
    public static final Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Green_Thin = null;
    public static final StrokeConfig OUI_Effect_Stroke_Green_Thin_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Green_Thin_Light = null;
    public static final Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Red_Regular = null;
    public static final StrokeConfig OUI_Effect_Stroke_Red_Regular_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Red_Regular_Light = null;
    public static final Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Red_Thin = null;
    public static final StrokeConfig OUI_Effect_Stroke_Red_Thin_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Red_Thin_Light = null;
    public static final Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Regular = null;
    public static final StrokeConfig OUI_Effect_Stroke_Regular_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Regular_Light = null;
    public static final Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Thick = null;
    public static final StrokeConfig OUI_Effect_Stroke_Thick_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Thick_Light = null;
    public static final Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Thin = null;
    public static final StrokeConfig OUI_Effect_Stroke_Thin_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Thin_Light = null;
    public static final StrokeConfig OUI_Effect_Stroke_Tinted_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Tinted_Light = null;
    public static final Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_UltraThin = null;
    public static final StrokeConfig OUI_Effect_Stroke_UltraThin_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_UltraThin_Light = null;
    public static final Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Yellow_Regular = null;
    public static final StrokeConfig OUI_Effect_Stroke_Yellow_Regular_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Yellow_Regular_Light = null;
    public static final Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Yellow_Thin = null;
    public static final StrokeConfig OUI_Effect_Stroke_Yellow_Thin_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Yellow_Thin_Light = null;
    private static volatile ConcurrentHashMap<String, Function1<Boolean, StrokeConfig>> providers;
    private static volatile ConcurrentHashMap<String, StrokeConfig> tokens;

    static {
        OUI_Effect_Stroke_Regular_Light = new StrokeConfig(1.0f, 1728053247, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Regular_Dark = new StrokeConfig(1.0f, 1715618370, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Regular = new StrokeTokenCore$$ExternalSyntheticLambda0();
        OUI_Effect_Stroke_UltraThin_Light = new StrokeConfig(1.0f, 452984831, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_UltraThin_Dark = new StrokeConfig(1.0f, 452984831, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_UltraThin = new StrokeTokenCore$$ExternalSyntheticLambda5();
        OUI_Effect_Stroke_Thin_Light = new StrokeConfig(1.0f, 1728053247, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Thin_Dark = new StrokeConfig(1.0f, 134217728, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Thin = new StrokeTokenCore$$ExternalSyntheticLambda6();
        OUI_Effect_Stroke_Thick_Light = new StrokeConfig(1.0f, 1727526903, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Thick_Dark = new StrokeConfig(1.0f, 1294872110, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Thick = new StrokeTokenCore$$ExternalSyntheticLambda7();
        OUI_Effect_Stroke_Tinted_Light = new StrokeConfig(1.0f, 1728053247, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Tinted_Dark = new StrokeConfig(1.0f, 1728053247, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Blue_Regular_Light = new StrokeConfig(1.0f, 1713799679, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Blue_Regular_Dark = new StrokeConfig(1.0f, 1713799679, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Blue_Regular = new StrokeTokenCore$$ExternalSyntheticLambda8();
        OUI_Effect_Stroke_Blue_Thin_Light = new StrokeConfig(1.0f, 1718003455, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Blue_Thin_Dark = new StrokeConfig(1.0f, 1718003455, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Blue_Thin = new StrokeTokenCore$$ExternalSyntheticLambda9();
        OUI_Effect_Stroke_Red_Regular_Light = new StrokeConfig(1.0f, 1728007501, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Red_Regular_Dark = new StrokeConfig(1.0f, 1728007501, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Red_Regular = new StrokeTokenCore$$ExternalSyntheticLambda10();
        OUI_Effect_Stroke_Red_Thin_Light = new StrokeConfig(1.0f, 1728022407, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Red_Thin_Dark = new StrokeConfig(1.0f, 1728022407, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Red_Thin = new StrokeTokenCore$$ExternalSyntheticLambda11();
        OUI_Effect_Stroke_Green_Regular_Light = new StrokeConfig(1.0f, 1712637776, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Green_Regular_Dark = new StrokeConfig(1.0f, 1712637776, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Green_Regular = new StrokeTokenCore$$ExternalSyntheticLambda1();
        OUI_Effect_Stroke_Green_Thin_Light = new StrokeConfig(1.0f, 1719135647, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Green_Thin_Dark = new StrokeConfig(1.0f, 1719135647, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Green_Thin = new StrokeTokenCore$$ExternalSyntheticLambda2();
        OUI_Effect_Stroke_Yellow_Regular_Light = new StrokeConfig(1.0f, 1728038170, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Yellow_Regular_Dark = new StrokeConfig(1.0f, 1728038170, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Yellow_Regular = new StrokeTokenCore$$ExternalSyntheticLambda3();
        OUI_Effect_Stroke_Yellow_Thin_Light = new StrokeConfig(1.0f, 1728041577, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Yellow_Thin_Dark = new StrokeConfig(1.0f, 1728041577, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Yellow_Thin = new StrokeTokenCore$$ExternalSyntheticLambda4();
    }

    static /* synthetic */ StrokeConfig lambda$static$0(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Regular_Dark;
    }

    static /* synthetic */ StrokeConfig lambda$static$1(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_UltraThin_Light;
    L6:
        return OUI_Effect_Stroke_UltraThin_Dark;
    }

    static /* synthetic */ StrokeConfig lambda$static$2(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Thin_Dark;
    }

    static /* synthetic */ StrokeConfig lambda$static$3(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Thick_Light;
    L6:
        return OUI_Effect_Stroke_Thick_Dark;
    }

    static /* synthetic */ StrokeConfig lambda$static$4(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Blue_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Blue_Regular_Dark;
    }

    static /* synthetic */ StrokeConfig lambda$static$5(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Blue_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Blue_Thin_Dark;
    }

    static /* synthetic */ StrokeConfig lambda$static$6(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Red_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Red_Regular_Dark;
    }

    static /* synthetic */ StrokeConfig lambda$static$7(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Red_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Red_Thin_Dark;
    }

    static /* synthetic */ StrokeConfig lambda$static$8(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Green_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Green_Regular_Dark;
    }

    static /* synthetic */ StrokeConfig lambda$static$9(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Green_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Green_Thin_Dark;
    }

    static /* synthetic */ StrokeConfig lambda$static$10(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Yellow_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Yellow_Regular_Dark;
    }

    static /* synthetic */ StrokeConfig lambda$static$11(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Yellow_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Yellow_Thin_Dark;
    }

    private StrokeTokenCore() {
    }

    public static void register(Object r1, Object r2, boolean r3) {
        TokenCoreParser.register(getTokens(r1), r2, StrokeConfig.class, r3);
    }

    public static void registerTokens(Object r0, Map<String, StrokeConfig> r1, boolean r2) {
        TokenCoreParser.registerTokens(getTokens(r0), r1, r2);
    }

    public static void registerProvider(Object r1, Object r2, boolean r3) {
        TokenCoreParser.register(getProviders(r1), r2, Function1.class, r3);
    }

    public static void registerProviderTokens(Object r0, Map<String, ? extends Function1<Boolean, StrokeConfig>> r1, boolean r2) {
        TokenCoreParser.registerTokens(getProviders(r0), r1, r2);
    }

    public static Function1<Boolean, StrokeConfig> parseProvider(Object r0, String r1) {
        return (Function1) TokenCoreParser.parse(r1, getProviders(r0));
    }

    public static StrokeConfig parse(Object r1, String r2, boolean r3) {
        StrokeConfig r0 = (StrokeConfig) TokenCoreParser.parse(r2, getTokens(r1));
        if (r0 != null) goto L10;
        StringBuilder r4 = new StringBuilder().append(r2);
        if (r3 == false) goto L7;
        String r5 = "_light";
    L9:
        return (StrokeConfig) TokenCoreParser.parse(r4.append(r5).toString(), getTokens(r1));
    L7:
        r5 = "_dark";
        goto L9
    L10:
        return r0;
    }

    private static ConcurrentHashMap<String, StrokeConfig> getTokens(Object r2) {
        ConcurrentHashMap<String, StrokeConfig> r0 = tokens;
        if (r0 == null) goto L5;
    L14:
        return r0;
    L5:
        monitor-enter(StrokeTokenCore.class);
        r0 = tokens;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        ConcurrentHashMap<String, StrokeConfig> r3 = TokenCoreParser.createTokenMap(r2, StrokeConfig.class);     // Catch: Throwable -> L11
        tokens = r3;     // Catch: Throwable -> L11
        r0 = r3;
    L9:
        monitor-exit(StrokeTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private static ConcurrentHashMap<String, Function1<Boolean, StrokeConfig>> getProviders(Object r2) {
        ConcurrentHashMap<String, Function1<Boolean, StrokeConfig>> r0 = providers;
        if (r0 == null) goto L5;
    L14:
        return r0;
    L5:
        monitor-enter(StrokeTokenCore.class);
        r0 = providers;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        ConcurrentHashMap<String, Function1<Boolean, StrokeConfig>> r3 = TokenCoreParser.createTokenMap(r2, Function1.class);     // Catch: Throwable -> L11
        providers = r3;     // Catch: Throwable -> L11
        r0 = r3;
    L9:
        monitor-exit(StrokeTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
