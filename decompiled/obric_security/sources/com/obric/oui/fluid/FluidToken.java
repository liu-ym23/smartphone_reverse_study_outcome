package com.obric.oui.fluid;

import android.util.Log;
import com.bytedance.tracing.internal.TracingConstants;
import com.obric.oui.material.TokenParser;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FluidToken.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0007J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00012\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007J&\u0010\u0016\u001a\u00020\u00122\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u00182\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/obric/oui/fluid/FluidToken;", "", "()V", "OUI_Effect_Fluid_Regular_Dark", "Lcom/obric/oui/fluid/FluidConfig;", "OUI_Effect_Fluid_Regular_Light", "OUI_Effect_Fluid_Thin_Dark", "OUI_Effect_Fluid_Thin_Light", "tokens", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getTokens", "()Ljava/util/concurrent/ConcurrentHashMap;", "tokens$delegate", "Lkotlin/Lazy;", "parse", "name", "register", "", "customTokenOwner", "overrideExisting", "", "registerTokens", "customTokens", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FluidToken {
    public static final FluidToken INSTANCE = null;
    public static final FluidConfig OUI_Effect_Fluid_Regular_Dark = null;
    public static final FluidConfig OUI_Effect_Fluid_Regular_Light = null;
    public static final FluidConfig OUI_Effect_Fluid_Thin_Dark = null;
    public static final FluidConfig OUI_Effect_Fluid_Thin_Light = null;
    private static final Lazy tokens$delegate = null;

    private FluidToken() {
    }

    static {
        INSTANCE = new FluidToken();
        tokens$delegate = LazyKt.lazy(FluidToken$tokens$2.INSTANCE);
        FluidConfig r0 = FluidTokenCore.OUI_Effect_Fluid_Thin_Light;
        Intrinsics.checkNotNullExpressionValue(r0, "OUI_Effect_Fluid_Thin_Light");
        OUI_Effect_Fluid_Thin_Light = r0;
        FluidConfig r1 = FluidTokenCore.OUI_Effect_Fluid_Thin_Dark;
        Intrinsics.checkNotNullExpressionValue(r1, "OUI_Effect_Fluid_Thin_Dark");
        OUI_Effect_Fluid_Thin_Dark = r1;
        FluidConfig r2 = FluidTokenCore.OUI_Effect_Fluid_Regular_Light;
        Intrinsics.checkNotNullExpressionValue(r2, "OUI_Effect_Fluid_Regular_Light");
        OUI_Effect_Fluid_Regular_Light = r2;
        FluidConfig r3 = FluidTokenCore.OUI_Effect_Fluid_Regular_Dark;
        Intrinsics.checkNotNullExpressionValue(r3, "OUI_Effect_Fluid_Regular_Dark");
        OUI_Effect_Fluid_Regular_Dark = r3;
    }

    private final ConcurrentHashMap<String, FluidConfig> getTokens() {
        return (ConcurrentHashMap) tokens$delegate.getValue();
    }

    @JvmStatic
    public static final FluidConfig parse(String r2) {
        return (FluidConfig) TokenParser.INSTANCE.parse(r2, INSTANCE.getTokens());
    }

    public static /* synthetic */ void register$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        register(r0, r1);
    }

    @JvmStatic
    public static final void register(Object r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "customTokenOwner");
        TokenParser r0 = TokenParser.INSTANCE;
        ConcurrentHashMap<String, FluidConfig> r1 = INSTANCE.getTokens();
        LinkedHashMap r3 = new LinkedHashMap();
        Field[] r4 = r11.getClass().getDeclaredFields();     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r4, TracingConstants.KEY_FIELDS);     // Catch: Exception -> L11
        int r5 = r4.length;     // Catch: Exception -> L11
        int r6 = 0;
    L4:
        if (r6 >= r5) goto L13;
        Field r7 = r4[r6];     // Catch: Exception -> L11
        r6 = r6 + 1;     // Catch: Exception -> L11
        if (FluidConfig.class.isAssignableFrom(r7.getType()) == false) goto L4;
        r7.setAccessible(true);     // Catch: Exception -> L11
        Object r8 = r7.get(r11);     // Catch: Exception -> L11
        if ((r8 instanceof FluidConfig) == false) goto L4;
        String r9 = r7.getName();     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r9, "field.name");     // Catch: Exception -> L11
        Locale r10 = Locale.ROOT;     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r10, "ROOT");     // Catch: Exception -> L11
        String r13 = r9.toLowerCase(r10);     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
        r3.put(r13, r8);     // Catch: Exception -> L11
    L13:
        r0.registerTokens(r1, r3, r12);
        return;
    L11:
        e = move-exception;
        Log.e("TokenParser", Intrinsics.stringPlus("Failed to parse tokens from ", r11.getClass().getSimpleName()), e);
        goto L13
    }

    public static /* synthetic */ void registerTokens$default(Map r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerTokens(r0, r1);
    }

    @JvmStatic
    public static final void registerTokens(Map<String, FluidConfig> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "customTokens");
        TokenParser.INSTANCE.registerTokens(INSTANCE.getTokens(), r2, r3);
    }
}
