package com.obric.oui.blur;

import com.obric.oui.material.TokenCoreParser;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class BlurTokenCore {

    @Deprecated
    public static final float Blur_Background_Regular = 20.0f;

    @Deprecated
    public static final float Blur_Background_Thick = 64.0f;

    @Deprecated
    public static final float Blur_Progress_Regular = 20.0f;

    @Deprecated
    public static final float Blur_Progress_Thin = 8.0f;
    public static final float Blur_Regular = 20.0f;
    public static final float Blur_Thick = 32.0f;
    public static final float Blur_Thin = 8.0f;
    public static final float Blur_UltraThick = 64.0f;
    public static final float Blur_UltraThin = 2.0f;
    public static final float Blur_Zero = 0.1f;
    private static volatile ConcurrentHashMap<String, Float> tokens;

    private BlurTokenCore() {
    }

    public static void register(Object r1, Object r2, boolean r3) {
        TokenCoreParser.register(getTokens(r1), r2, Float.class, r3);
    }

    public static void registerTokens(Object r0, Map<String, Float> r1, boolean r2) {
        TokenCoreParser.registerTokens(getTokens(r0), r1, r2);
    }

    public static Float parse(Object r0, String r1) {
        return (Float) TokenCoreParser.parse(r1, getTokens(r0));
    }

    private static ConcurrentHashMap<String, Float> getTokens(Object r2) {
        ConcurrentHashMap<String, Float> r0 = tokens;
        if (r0 == null) goto L5;
    L14:
        return r0;
    L5:
        monitor-enter(BlurTokenCore.class);
        r0 = tokens;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        ConcurrentHashMap<String, Float> r3 = TokenCoreParser.createTokenMap(r2, Float.class);     // Catch: Throwable -> L11
        tokens = r3;     // Catch: Throwable -> L11
        r0 = r3;
    L9:
        monitor-exit(BlurTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
