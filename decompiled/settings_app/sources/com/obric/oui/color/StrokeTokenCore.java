package com.obric.oui.color;

import com.android.vcard.VCardConfig;
import com.obric.oui.graphic.BlendMode;
import com.obric.oui.material.TokenParserCore;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class StrokeTokenCore {
    public static final Function1<Boolean, StrokeConfigCore> OUI_Effect_Stroke_Blue_Regular = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_Blue_Regular_Dark = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_Blue_Regular_Light = null;
    public static final Function1<Boolean, StrokeConfigCore> OUI_Effect_Stroke_Blue_Thin = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_Blue_Thin_Dark = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_Blue_Thin_Light = null;
    public static final Function1<Boolean, StrokeConfigCore> OUI_Effect_Stroke_Green_Regular = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_Green_Regular_Dark = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_Green_Regular_Light = null;
    public static final Function1<Boolean, StrokeConfigCore> OUI_Effect_Stroke_Green_Thin = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_Green_Thin_Dark = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_Green_Thin_Light = null;
    public static final Function1<Boolean, StrokeConfigCore> OUI_Effect_Stroke_Red_Regular = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_Red_Regular_Dark = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_Red_Regular_Light = null;
    public static final Function1<Boolean, StrokeConfigCore> OUI_Effect_Stroke_Red_Thin = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_Red_Thin_Dark = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_Red_Thin_Light = null;
    public static final Function1<Boolean, StrokeConfigCore> OUI_Effect_Stroke_Regular = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_Regular_Dark = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_Regular_Light = null;
    public static final Function1<Boolean, StrokeConfigCore> OUI_Effect_Stroke_Thick = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_Thick_Dark = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_Thick_Light = null;
    public static final Function1<Boolean, StrokeConfigCore> OUI_Effect_Stroke_Thin = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_Thin_Dark = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_Thin_Light = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_Tinted_Dark = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_Tinted_Light = null;
    public static final Function1<Boolean, StrokeConfigCore> OUI_Effect_Stroke_UltraThin = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_UltraThin_Dark = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_UltraThin_Light = null;
    public static final Function1<Boolean, StrokeConfigCore> OUI_Effect_Stroke_Yellow_Regular = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_Yellow_Regular_Dark = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_Yellow_Regular_Light = null;
    public static final Function1<Boolean, StrokeConfigCore> OUI_Effect_Stroke_Yellow_Thin = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_Yellow_Thin_Dark = null;
    public static final StrokeConfigCore OUI_Effect_Stroke_Yellow_Thin_Light = null;
    private static volatile ConcurrentHashMap<String, Function1<Boolean, StrokeConfigCore>> providers;
    private static volatile ConcurrentHashMap<String, StrokeConfigCore> tokens;

    static {
        OUI_Effect_Stroke_Regular_Light = new StrokeConfigCore(1.0f, 1728053247, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Regular_Dark = new StrokeConfigCore(1.0f, 1715618370, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Regular = new StrokeTokenCore$$ExternalSyntheticLambda4();
        OUI_Effect_Stroke_UltraThin_Light = new StrokeConfigCore(1.0f, 452984831, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_UltraThin_Dark = new StrokeConfigCore(1.0f, 452984831, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_UltraThin = new StrokeTokenCore$$ExternalSyntheticLambda7();
        OUI_Effect_Stroke_Thin_Light = new StrokeConfigCore(1.0f, 1728053247, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Thin_Dark = new StrokeConfigCore(1.0f, VCardConfig.FLAG_CONVERT_PHONETIC_NAME_STRINGS, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Thin = new StrokeTokenCore$$ExternalSyntheticLambda8();
        OUI_Effect_Stroke_Thick_Light = new StrokeConfigCore(1.0f, 1727526903, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Thick_Dark = new StrokeConfigCore(1.0f, 1294872110, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Thick = new StrokeTokenCore$$ExternalSyntheticLambda9();
        OUI_Effect_Stroke_Tinted_Light = new StrokeConfigCore(1.0f, 1728053247, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Tinted_Dark = new StrokeConfigCore(1.0f, 1728053247, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Blue_Regular_Light = new StrokeConfigCore(1.0f, 1713799679, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Blue_Regular_Dark = new StrokeConfigCore(1.0f, 1713799679, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Blue_Regular = new StrokeTokenCore$$ExternalSyntheticLambda10();
        OUI_Effect_Stroke_Blue_Thin_Light = new StrokeConfigCore(1.0f, 1718003455, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Blue_Thin_Dark = new StrokeConfigCore(1.0f, 1718003455, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Blue_Thin = new StrokeTokenCore$$ExternalSyntheticLambda11();
        OUI_Effect_Stroke_Red_Regular_Light = new StrokeConfigCore(1.0f, 1728007501, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Red_Regular_Dark = new StrokeConfigCore(1.0f, 1728007501, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Red_Regular = new StrokeTokenCore$$ExternalSyntheticLambda12();
        OUI_Effect_Stroke_Red_Thin_Light = new StrokeConfigCore(1.0f, 1728022407, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Red_Thin_Dark = new StrokeConfigCore(1.0f, 1728022407, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Red_Thin = new StrokeTokenCore$$ExternalSyntheticLambda1();
        OUI_Effect_Stroke_Green_Regular_Light = new StrokeConfigCore(1.0f, 1712637776, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Green_Regular_Dark = new StrokeConfigCore(1.0f, 1712637776, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Green_Regular = new StrokeTokenCore$$ExternalSyntheticLambda2();
        OUI_Effect_Stroke_Green_Thin_Light = new StrokeConfigCore(1.0f, 1719135647, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Green_Thin_Dark = new StrokeConfigCore(1.0f, 1719135647, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Green_Thin = new StrokeTokenCore$$ExternalSyntheticLambda3();
        OUI_Effect_Stroke_Yellow_Regular_Light = new StrokeConfigCore(1.0f, 1728038170, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Yellow_Regular_Dark = new StrokeConfigCore(1.0f, 1728038170, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Yellow_Regular = new StrokeTokenCore$$ExternalSyntheticLambda5();
        OUI_Effect_Stroke_Yellow_Thin_Light = new StrokeConfigCore(1.0f, 1728041577, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Yellow_Thin_Dark = new StrokeConfigCore(1.0f, 1728041577, BlendMode.SRC_OVER);
        OUI_Effect_Stroke_Yellow_Thin = new StrokeTokenCore$$ExternalSyntheticLambda6();
    }

    static /* synthetic */ StrokeConfigCore lambda$static$0(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Regular_Dark;
    }

    static /* synthetic */ StrokeConfigCore lambda$static$1(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_UltraThin_Light;
    L6:
        return OUI_Effect_Stroke_UltraThin_Dark;
    }

    static /* synthetic */ StrokeConfigCore lambda$static$2(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Thin_Dark;
    }

    static /* synthetic */ StrokeConfigCore lambda$static$3(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Thick_Light;
    L6:
        return OUI_Effect_Stroke_Thick_Dark;
    }

    static /* synthetic */ StrokeConfigCore lambda$static$4(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Blue_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Blue_Regular_Dark;
    }

    static /* synthetic */ StrokeConfigCore lambda$static$5(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Blue_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Blue_Thin_Dark;
    }

    static /* synthetic */ StrokeConfigCore lambda$static$6(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Red_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Red_Regular_Dark;
    }

    static /* synthetic */ StrokeConfigCore lambda$static$7(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Red_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Red_Thin_Dark;
    }

    static /* synthetic */ StrokeConfigCore lambda$static$8(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Green_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Green_Regular_Dark;
    }

    static /* synthetic */ StrokeConfigCore lambda$static$9(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Green_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Green_Thin_Dark;
    }

    static /* synthetic */ StrokeConfigCore lambda$static$10(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Yellow_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Yellow_Regular_Dark;
    }

    static /* synthetic */ StrokeConfigCore lambda$static$11(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Yellow_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Yellow_Thin_Dark;
    }

    private StrokeTokenCore() {
    }

    public static void register(Object r2, Object r3, boolean r4) {
        TokenParserCore.register(getTokens(r2), r3, StrokeConfigCore.class, r4);
        TokenParserCore.registerTokens(getTokens(r2), toCoreTokens(TokenParserCore.createTokenMap(r3, StrokeConfigCore.class)), r4);
    }

    public static void registerTokens(Object r0, Map<String, StrokeConfigCore> r1, boolean r2) {
        TokenParserCore.registerTokens(getTokens(r0), toCoreTokens(r1), r2);
    }

    public static void registerProvider(Object r1, Object r2, boolean r3) {
        TokenParserCore.register(getProviders(r1), r2, Function1.class, r3);
    }

    public static void registerProviderTokens(Object r0, Map<String, ? extends Function1<Boolean, StrokeConfigCore>> r1, boolean r2) {
        TokenParserCore.registerTokens(getProviders(r0), toCoreProviders(r1), r2);
    }

    public static Function1<Boolean, StrokeConfigCore> parseProvider(Object r0, String r1) {
        return (Function1) TokenParserCore.parse(r1, getProviders(r0));
    }

    public static StrokeConfigCore parse(Object r1, String r2, boolean r3) {
        StrokeConfigCore r0 = (StrokeConfigCore) TokenParserCore.parse(r2, getTokens(r1));
        if (r0 != null) goto L10;
        StringBuilder r4 = new StringBuilder().append(r2);
        if (r3 == false) goto L7;
        String r5 = "_light";
    L9:
        return (StrokeConfigCore) TokenParserCore.parse(r4.append(r5).toString(), getTokens(r1));
    L7:
        r5 = "_dark";
        goto L9
    L10:
        return r0;
    }

    private static ConcurrentHashMap<String, StrokeConfigCore> getTokens(Object r2) {
        ConcurrentHashMap<String, StrokeConfigCore> r3 = tokens;
        if (r3 == null) goto L5;
    L14:
        return r3;
    L5:
        monitor-enter(StrokeTokenCore.class);
        r3 = tokens;     // Catch: Throwable -> L11
        if (r3 != null) goto L9;
        r3 = TokenParserCore.createTokenMap(StrokeTokenCore.class, StrokeConfigCore.class);     // Catch: Throwable -> L11
        tokens = r3;     // Catch: Throwable -> L11
    L9:
        monitor-exit(StrokeTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private static ConcurrentHashMap<String, Function1<Boolean, StrokeConfigCore>> getProviders(Object r2) {
        ConcurrentHashMap<String, Function1<Boolean, StrokeConfigCore>> r3 = providers;
        if (r3 == null) goto L5;
    L14:
        return r3;
    L5:
        monitor-enter(StrokeTokenCore.class);
        r3 = providers;     // Catch: Throwable -> L11
        if (r3 != null) goto L9;
        r3 = TokenParserCore.createTokenMap(StrokeTokenCore.class, Function1.class);     // Catch: Throwable -> L11
        providers = r3;     // Catch: Throwable -> L11
    L9:
        monitor-exit(StrokeTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private static ConcurrentHashMap<String, StrokeConfigCore> toCoreTokens(Map<String, StrokeConfigCore> r3) {
        ConcurrentHashMap<String, StrokeConfigCore> r0 = new ConcurrentHashMap();
        if (r3 != null) goto L5;
    L11:
        return r0;
    L5:
        if (r3.isEmpty() == true) goto L11;
        Iterator<Map.Entry<String, StrokeConfigCore>> r4 = r3.entrySet().iterator();
    L9:
        if (r4.hasNext() == false) goto L11;
        Map.Entry<String, StrokeConfigCore> r1 = r4.next();
        r0.put(r1.getKey(), toCore(r1.getValue()));
        goto L9
    }

    private static ConcurrentHashMap<String, Function1<Boolean, StrokeConfigCore>> toCoreProviders(Map<String, ? extends Function1<Boolean, StrokeConfigCore>> r4) {
        ConcurrentHashMap<String, Function1<Boolean, StrokeConfigCore>> r0 = new ConcurrentHashMap();
        if (r4 != null) goto L5;
    L11:
        return r0;
    L5:
        if (r4.isEmpty() == true) goto L11;
        Iterator<Map.Entry<String, ? extends Function1<Boolean, StrokeConfigCore>>> r5 = r4.entrySet().iterator();
    L9:
        if (r5.hasNext() == false) goto L11;
        Map.Entry<String, ? extends Function1<Boolean, StrokeConfigCore>> r1 = r5.next();
        final Function1<Boolean, StrokeConfigCore> r2 = r1.getValue();
        r0.put(r1.getKey(), new StrokeTokenCore$$ExternalSyntheticLambda0(r2));
        goto L9
    }

    static /* synthetic */ StrokeConfigCore lambda$toCoreProviders$12(Function1 r0, Boolean r1) {
        return toCore((StrokeConfigCore) r0.invoke(r1));
    }

    private static StrokeConfigCore toCore(StrokeConfigCore r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        return new StrokeConfigCore(r3.getWidth(), r3.getColor(), r3.getBlendMode());
    }
}
