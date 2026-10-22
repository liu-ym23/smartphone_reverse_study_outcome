package com.obric.oui.color;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StrokeToken.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b@\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\b\u0010F\u001a\u0004\u0018\u00010GH\u0007J\u001c\u0010E\u001a\u0004\u0018\u00010\u00062\b\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010H\u001a\u00020\u0005H\u0007J\u001a\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00012\b\b\u0002\u0010L\u001a\u00020\u0005H\u0007J\u001a\u0010M\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00012\b\b\u0002\u0010L\u001a\u00020\u0005H\u0007J2\u0010N\u001a\u00020J2\u001e\u0010O\u001a\u001a\u0012\u0004\u0012\u00020G\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040P2\b\b\u0002\u0010L\u001a\u00020\u0005H\u0007J&\u0010Q\u001a\u00020J2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u00060P2\b\b\u0002\u0010L\u001a\u00020\u0005H\u0007R(\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\tR\u0010\u0010\u000f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\tR\u0010\u0010\u0014\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0002\u001a\u0004\b\u0018\u0010\tR\u0010\u0010\u0019\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0002\u001a\u0004\b\u001d\u0010\tR\u0010\u0010\u001e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0002\u001a\u0004\b\"\u0010\tR\u0010\u0010#\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0002\u001a\u0004\b'\u0010\tR\u0010\u0010(\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0002\u001a\u0004\b,\u0010\tR\u0010\u0010-\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u0002\u001a\u0004\b1\u0010\tR\u0010\u00102\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010\u0002\u001a\u0004\b8\u0010\tR\u0010\u00109\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010\u0002\u001a\u0004\b=\u0010\tR\u0010\u0010>\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u0010\u0002\u001a\u0004\bB\u0010\tR\u0010\u0010C\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/obric/oui/color/StrokeToken;", "", "()V", "OUI_Effect_Stroke_Blue_Regular", "Lkotlin/Function1;", "", "Lcom/obric/oui/color/StrokeConfig;", "getOUI_Effect_Stroke_Blue_Regular$annotations", "getOUI_Effect_Stroke_Blue_Regular", "()Lkotlin/jvm/functions/Function1;", "OUI_Effect_Stroke_Blue_Regular_Dark", "OUI_Effect_Stroke_Blue_Regular_Light", "OUI_Effect_Stroke_Blue_Thin", "getOUI_Effect_Stroke_Blue_Thin$annotations", "getOUI_Effect_Stroke_Blue_Thin", "OUI_Effect_Stroke_Blue_Thin_Dark", "OUI_Effect_Stroke_Blue_Thin_Light", "OUI_Effect_Stroke_Green_Regular", "getOUI_Effect_Stroke_Green_Regular$annotations", "getOUI_Effect_Stroke_Green_Regular", "OUI_Effect_Stroke_Green_Regular_Dark", "OUI_Effect_Stroke_Green_Regular_Light", "OUI_Effect_Stroke_Green_Thin", "getOUI_Effect_Stroke_Green_Thin$annotations", "getOUI_Effect_Stroke_Green_Thin", "OUI_Effect_Stroke_Green_Thin_Dark", "OUI_Effect_Stroke_Green_Thin_Light", "OUI_Effect_Stroke_Red_Regular", "getOUI_Effect_Stroke_Red_Regular$annotations", "getOUI_Effect_Stroke_Red_Regular", "OUI_Effect_Stroke_Red_Regular_Dark", "OUI_Effect_Stroke_Red_Regular_Light", "OUI_Effect_Stroke_Red_Thin", "getOUI_Effect_Stroke_Red_Thin$annotations", "getOUI_Effect_Stroke_Red_Thin", "OUI_Effect_Stroke_Red_Thin_Dark", "OUI_Effect_Stroke_Red_Thin_Light", "OUI_Effect_Stroke_Regular", "getOUI_Effect_Stroke_Regular$annotations", "getOUI_Effect_Stroke_Regular", "OUI_Effect_Stroke_Regular_Dark", "OUI_Effect_Stroke_Regular_Light", "OUI_Effect_Stroke_Thick", "getOUI_Effect_Stroke_Thick$annotations", "getOUI_Effect_Stroke_Thick", "OUI_Effect_Stroke_Thick_Dark", "OUI_Effect_Stroke_Thick_Light", "OUI_Effect_Stroke_Thin", "getOUI_Effect_Stroke_Thin$annotations", "getOUI_Effect_Stroke_Thin", "OUI_Effect_Stroke_Thin_Dark", "OUI_Effect_Stroke_Thin_Light", "OUI_Effect_Stroke_Tinted_Dark", "OUI_Effect_Stroke_Tinted_Light", "OUI_Effect_Stroke_UltraThin", "getOUI_Effect_Stroke_UltraThin$annotations", "getOUI_Effect_Stroke_UltraThin", "OUI_Effect_Stroke_UltraThin_Dark", "OUI_Effect_Stroke_UltraThin_Light", "OUI_Effect_Stroke_Yellow_Regular", "getOUI_Effect_Stroke_Yellow_Regular$annotations", "getOUI_Effect_Stroke_Yellow_Regular", "OUI_Effect_Stroke_Yellow_Regular_Dark", "OUI_Effect_Stroke_Yellow_Regular_Light", "OUI_Effect_Stroke_Yellow_Thin", "getOUI_Effect_Stroke_Yellow_Thin$annotations", "getOUI_Effect_Stroke_Yellow_Thin", "OUI_Effect_Stroke_Yellow_Thin_Dark", "OUI_Effect_Stroke_Yellow_Thin_Light", "parse", "name", "", "isLight", "register", "", "customTokenOwner", "overrideExisting", "registerProvider", "registerProviderTokens", "customTokens", "", "registerTokens", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StrokeToken {
    public static final StrokeToken INSTANCE = null;
    private static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Blue_Regular = null;
    public static final StrokeConfig OUI_Effect_Stroke_Blue_Regular_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Blue_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Blue_Thin = null;
    public static final StrokeConfig OUI_Effect_Stroke_Blue_Thin_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Blue_Thin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Green_Regular = null;
    public static final StrokeConfig OUI_Effect_Stroke_Green_Regular_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Green_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Green_Thin = null;
    public static final StrokeConfig OUI_Effect_Stroke_Green_Thin_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Green_Thin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Red_Regular = null;
    public static final StrokeConfig OUI_Effect_Stroke_Red_Regular_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Red_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Red_Thin = null;
    public static final StrokeConfig OUI_Effect_Stroke_Red_Thin_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Red_Thin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Regular = null;
    public static final StrokeConfig OUI_Effect_Stroke_Regular_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Thick = null;
    public static final StrokeConfig OUI_Effect_Stroke_Thick_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Thick_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Thin = null;
    public static final StrokeConfig OUI_Effect_Stroke_Thin_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Thin_Light = null;
    public static final StrokeConfig OUI_Effect_Stroke_Tinted_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Tinted_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_UltraThin = null;
    public static final StrokeConfig OUI_Effect_Stroke_UltraThin_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_UltraThin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Yellow_Regular = null;
    public static final StrokeConfig OUI_Effect_Stroke_Yellow_Regular_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Yellow_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Yellow_Thin = null;
    public static final StrokeConfig OUI_Effect_Stroke_Yellow_Thin_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Yellow_Thin_Light = null;

    /* JADX INFO: renamed from: $r8$lambda$_GeQlzusQxJSFhYRyr5T0ebR-dc, reason: not valid java name */
    public static /* synthetic */ StrokeConfigCore m1086$r8$lambda$_GeQlzusQxJSFhYRyr5T0ebRdc(kotlin.jvm.functions.Function1 r0, Boolean r1) {
        return m1087registerProviderTokens$lambda2$lambda1(r0, r1);
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Blue_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Blue_Thin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Green_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Green_Thin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Red_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Red_Thin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Thick$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Thin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_UltraThin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Yellow_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Yellow_Thin$annotations() {
    }

    private StrokeToken() {
    }

    public static /* synthetic */ void register$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        register(r0, r1);
    }

    @JvmStatic
    public static final void register(Object r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "customTokenOwner");
        StrokeTokenCore.register(INSTANCE, r1, r2);
    }

    public static /* synthetic */ void registerTokens$default(Map r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerTokens(r0, r1);
    }

    @JvmStatic
    public static final void registerTokens(Map<String, StrokeConfig> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "customTokens");
        StrokeToken r0 = INSTANCE;
        LinkedHashMap r1 = new LinkedHashMap(MapsKt.mapCapacity(r4.size()));
        Iterator<T> r6 = r4.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) r6.next();
        r1.put(r2.getKey(), ((StrokeConfig) r2.getValue()).toCore$OUI_standardRelease());
        goto L4
    L6:
        StrokeTokenCore.registerTokens(r0, r1, r5);
    }

    public static /* synthetic */ void registerProvider$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerProvider(r0, r1);
    }

    @JvmStatic
    public static final void registerProvider(Object r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "customTokenOwner");
        StrokeTokenCore.registerProvider(INSTANCE, r1, r2);
    }

    public static /* synthetic */ void registerProviderTokens$default(Map r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerProviderTokens(r0, r1);
    }

    @JvmStatic
    public static final void registerProviderTokens(Map<String, ? extends kotlin.jvm.functions.Function1<? super Boolean, StrokeConfig>> r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "customTokens");
        StrokeToken r0 = INSTANCE;
        LinkedHashMap r1 = new LinkedHashMap(MapsKt.mapCapacity(r5.size()));
        Iterator<T> r7 = r5.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) r7.next();
        Object r3 = r2.getKey();
        final kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r2.getValue();
        r1.put(r3, new StrokeToken$$ExternalSyntheticLambda0(r4));
        goto L4
    L6:
        StrokeTokenCore.registerProviderTokens(r0, r1, r6);
    }

    /* JADX INFO: renamed from: registerProviderTokens$lambda-2$lambda-1, reason: not valid java name */
    private static final StrokeConfigCore m1087registerProviderTokens$lambda2$lambda1(kotlin.jvm.functions.Function1 r1, Boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "$provider");
        Intrinsics.checkNotNullExpressionValue(r2, "isLight");
        return ((StrokeConfig) r1.invoke(r2)).toCore$OUI_standardRelease();
    }

    @JvmStatic
    public static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> parse(String r1) {
        final Function1<Boolean, StrokeConfigCore> r2 = StrokeTokenCore.parseProvider(INSTANCE, r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass1(r2);
    }

    @JvmStatic
    public static final StrokeConfig parse(String r1, boolean r2) {
        StrokeConfigCore r3 = StrokeTokenCore.parse(INSTANCE, r1, r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        return StrokeConfigKt.toConfig(r3);
    }

    static {
        INSTANCE = new StrokeToken();
        StrokeConfigCore r0 = StrokeTokenCore.OUI_Effect_Stroke_Regular_Light;
        Intrinsics.checkNotNullExpressionValue(r0, "OUI_Effect_Stroke_Regular_Light");
        OUI_Effect_Stroke_Regular_Light = StrokeConfigKt.toConfig(r0);
        StrokeConfigCore r1 = StrokeTokenCore.OUI_Effect_Stroke_Regular_Dark;
        Intrinsics.checkNotNullExpressionValue(r1, "OUI_Effect_Stroke_Regular_Dark");
        OUI_Effect_Stroke_Regular_Dark = StrokeConfigKt.toConfig(r1);
        OUI_Effect_Stroke_Regular = StrokeToken$OUI_Effect_Stroke_Regular$1.INSTANCE;
        StrokeConfigCore r2 = StrokeTokenCore.OUI_Effect_Stroke_UltraThin_Light;
        Intrinsics.checkNotNullExpressionValue(r2, "OUI_Effect_Stroke_UltraThin_Light");
        OUI_Effect_Stroke_UltraThin_Light = StrokeConfigKt.toConfig(r2);
        StrokeConfigCore r3 = StrokeTokenCore.OUI_Effect_Stroke_UltraThin_Dark;
        Intrinsics.checkNotNullExpressionValue(r3, "OUI_Effect_Stroke_UltraThin_Dark");
        OUI_Effect_Stroke_UltraThin_Dark = StrokeConfigKt.toConfig(r3);
        OUI_Effect_Stroke_UltraThin = StrokeToken$OUI_Effect_Stroke_UltraThin$1.INSTANCE;
        StrokeConfigCore r4 = StrokeTokenCore.OUI_Effect_Stroke_Thin_Light;
        Intrinsics.checkNotNullExpressionValue(r4, "OUI_Effect_Stroke_Thin_Light");
        OUI_Effect_Stroke_Thin_Light = StrokeConfigKt.toConfig(r4);
        StrokeConfigCore r5 = StrokeTokenCore.OUI_Effect_Stroke_Thin_Dark;
        Intrinsics.checkNotNullExpressionValue(r5, "OUI_Effect_Stroke_Thin_Dark");
        OUI_Effect_Stroke_Thin_Dark = StrokeConfigKt.toConfig(r5);
        OUI_Effect_Stroke_Thin = StrokeToken$OUI_Effect_Stroke_Thin$1.INSTANCE;
        StrokeConfigCore r6 = StrokeTokenCore.OUI_Effect_Stroke_Thick_Light;
        Intrinsics.checkNotNullExpressionValue(r6, "OUI_Effect_Stroke_Thick_Light");
        OUI_Effect_Stroke_Thick_Light = StrokeConfigKt.toConfig(r6);
        StrokeConfigCore r7 = StrokeTokenCore.OUI_Effect_Stroke_Thick_Dark;
        Intrinsics.checkNotNullExpressionValue(r7, "OUI_Effect_Stroke_Thick_Dark");
        OUI_Effect_Stroke_Thick_Dark = StrokeConfigKt.toConfig(r7);
        OUI_Effect_Stroke_Thick = StrokeToken$OUI_Effect_Stroke_Thick$1.INSTANCE;
        StrokeConfigCore r8 = StrokeTokenCore.OUI_Effect_Stroke_Tinted_Light;
        Intrinsics.checkNotNullExpressionValue(r8, "OUI_Effect_Stroke_Tinted_Light");
        OUI_Effect_Stroke_Tinted_Light = StrokeConfigKt.toConfig(r8);
        StrokeConfigCore r9 = StrokeTokenCore.OUI_Effect_Stroke_Tinted_Dark;
        Intrinsics.checkNotNullExpressionValue(r9, "OUI_Effect_Stroke_Tinted_Dark");
        OUI_Effect_Stroke_Tinted_Dark = StrokeConfigKt.toConfig(r9);
        StrokeConfigCore r10 = StrokeTokenCore.OUI_Effect_Stroke_Blue_Regular_Light;
        Intrinsics.checkNotNullExpressionValue(r10, "OUI_Effect_Stroke_Blue_Regular_Light");
        OUI_Effect_Stroke_Blue_Regular_Light = StrokeConfigKt.toConfig(r10);
        StrokeConfigCore r11 = StrokeTokenCore.OUI_Effect_Stroke_Blue_Regular_Dark;
        Intrinsics.checkNotNullExpressionValue(r11, "OUI_Effect_Stroke_Blue_Regular_Dark");
        OUI_Effect_Stroke_Blue_Regular_Dark = StrokeConfigKt.toConfig(r11);
        OUI_Effect_Stroke_Blue_Regular = StrokeToken$OUI_Effect_Stroke_Blue_Regular$1.INSTANCE;
        StrokeConfigCore r12 = StrokeTokenCore.OUI_Effect_Stroke_Blue_Thin_Light;
        Intrinsics.checkNotNullExpressionValue(r12, "OUI_Effect_Stroke_Blue_Thin_Light");
        OUI_Effect_Stroke_Blue_Thin_Light = StrokeConfigKt.toConfig(r12);
        StrokeConfigCore r13 = StrokeTokenCore.OUI_Effect_Stroke_Blue_Thin_Dark;
        Intrinsics.checkNotNullExpressionValue(r13, "OUI_Effect_Stroke_Blue_Thin_Dark");
        OUI_Effect_Stroke_Blue_Thin_Dark = StrokeConfigKt.toConfig(r13);
        OUI_Effect_Stroke_Blue_Thin = StrokeToken$OUI_Effect_Stroke_Blue_Thin$1.INSTANCE;
        StrokeConfigCore r14 = StrokeTokenCore.OUI_Effect_Stroke_Red_Regular_Light;
        Intrinsics.checkNotNullExpressionValue(r14, "OUI_Effect_Stroke_Red_Regular_Light");
        OUI_Effect_Stroke_Red_Regular_Light = StrokeConfigKt.toConfig(r14);
        StrokeConfigCore r15 = StrokeTokenCore.OUI_Effect_Stroke_Red_Regular_Dark;
        Intrinsics.checkNotNullExpressionValue(r15, "OUI_Effect_Stroke_Red_Regular_Dark");
        OUI_Effect_Stroke_Red_Regular_Dark = StrokeConfigKt.toConfig(r15);
        OUI_Effect_Stroke_Red_Regular = StrokeToken$OUI_Effect_Stroke_Red_Regular$1.INSTANCE;
        StrokeConfigCore r16 = StrokeTokenCore.OUI_Effect_Stroke_Red_Thin_Light;
        Intrinsics.checkNotNullExpressionValue(r16, "OUI_Effect_Stroke_Red_Thin_Light");
        OUI_Effect_Stroke_Red_Thin_Light = StrokeConfigKt.toConfig(r16);
        StrokeConfigCore r17 = StrokeTokenCore.OUI_Effect_Stroke_Red_Thin_Dark;
        Intrinsics.checkNotNullExpressionValue(r17, "OUI_Effect_Stroke_Red_Thin_Dark");
        OUI_Effect_Stroke_Red_Thin_Dark = StrokeConfigKt.toConfig(r17);
        OUI_Effect_Stroke_Red_Thin = StrokeToken$OUI_Effect_Stroke_Red_Thin$1.INSTANCE;
        StrokeConfigCore r18 = StrokeTokenCore.OUI_Effect_Stroke_Green_Regular_Light;
        Intrinsics.checkNotNullExpressionValue(r18, "OUI_Effect_Stroke_Green_Regular_Light");
        OUI_Effect_Stroke_Green_Regular_Light = StrokeConfigKt.toConfig(r18);
        StrokeConfigCore r19 = StrokeTokenCore.OUI_Effect_Stroke_Green_Regular_Dark;
        Intrinsics.checkNotNullExpressionValue(r19, "OUI_Effect_Stroke_Green_Regular_Dark");
        OUI_Effect_Stroke_Green_Regular_Dark = StrokeConfigKt.toConfig(r19);
        OUI_Effect_Stroke_Green_Regular = StrokeToken$OUI_Effect_Stroke_Green_Regular$1.INSTANCE;
        StrokeConfigCore r20 = StrokeTokenCore.OUI_Effect_Stroke_Green_Thin_Light;
        Intrinsics.checkNotNullExpressionValue(r20, "OUI_Effect_Stroke_Green_Thin_Light");
        OUI_Effect_Stroke_Green_Thin_Light = StrokeConfigKt.toConfig(r20);
        StrokeConfigCore r21 = StrokeTokenCore.OUI_Effect_Stroke_Green_Thin_Dark;
        Intrinsics.checkNotNullExpressionValue(r21, "OUI_Effect_Stroke_Green_Thin_Dark");
        OUI_Effect_Stroke_Green_Thin_Dark = StrokeConfigKt.toConfig(r21);
        OUI_Effect_Stroke_Green_Thin = StrokeToken$OUI_Effect_Stroke_Green_Thin$1.INSTANCE;
        StrokeConfigCore r22 = StrokeTokenCore.OUI_Effect_Stroke_Yellow_Regular_Light;
        Intrinsics.checkNotNullExpressionValue(r22, "OUI_Effect_Stroke_Yellow_Regular_Light");
        OUI_Effect_Stroke_Yellow_Regular_Light = StrokeConfigKt.toConfig(r22);
        StrokeConfigCore r23 = StrokeTokenCore.OUI_Effect_Stroke_Yellow_Regular_Dark;
        Intrinsics.checkNotNullExpressionValue(r23, "OUI_Effect_Stroke_Yellow_Regular_Dark");
        OUI_Effect_Stroke_Yellow_Regular_Dark = StrokeConfigKt.toConfig(r23);
        OUI_Effect_Stroke_Yellow_Regular = StrokeToken$OUI_Effect_Stroke_Yellow_Regular$1.INSTANCE;
        StrokeConfigCore r24 = StrokeTokenCore.OUI_Effect_Stroke_Yellow_Thin_Light;
        Intrinsics.checkNotNullExpressionValue(r24, "OUI_Effect_Stroke_Yellow_Thin_Light");
        OUI_Effect_Stroke_Yellow_Thin_Light = StrokeConfigKt.toConfig(r24);
        StrokeConfigCore r25 = StrokeTokenCore.OUI_Effect_Stroke_Yellow_Thin_Dark;
        Intrinsics.checkNotNullExpressionValue(r25, "OUI_Effect_Stroke_Yellow_Thin_Dark");
        OUI_Effect_Stroke_Yellow_Thin_Dark = StrokeConfigKt.toConfig(r25);
        OUI_Effect_Stroke_Yellow_Thin = StrokeToken$OUI_Effect_Stroke_Yellow_Thin$1.INSTANCE;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> getOUI_Effect_Stroke_Regular() {
        return OUI_Effect_Stroke_Regular;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> getOUI_Effect_Stroke_UltraThin() {
        return OUI_Effect_Stroke_UltraThin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> getOUI_Effect_Stroke_Thin() {
        return OUI_Effect_Stroke_Thin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> getOUI_Effect_Stroke_Thick() {
        return OUI_Effect_Stroke_Thick;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> getOUI_Effect_Stroke_Blue_Regular() {
        return OUI_Effect_Stroke_Blue_Regular;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> getOUI_Effect_Stroke_Blue_Thin() {
        return OUI_Effect_Stroke_Blue_Thin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> getOUI_Effect_Stroke_Red_Regular() {
        return OUI_Effect_Stroke_Red_Regular;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> getOUI_Effect_Stroke_Red_Thin() {
        return OUI_Effect_Stroke_Red_Thin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> getOUI_Effect_Stroke_Green_Regular() {
        return OUI_Effect_Stroke_Green_Regular;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> getOUI_Effect_Stroke_Green_Thin() {
        return OUI_Effect_Stroke_Green_Thin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> getOUI_Effect_Stroke_Yellow_Regular() {
        return OUI_Effect_Stroke_Yellow_Regular;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, StrokeConfig> getOUI_Effect_Stroke_Yellow_Thin() {
        return OUI_Effect_Stroke_Yellow_Thin;
    }
}
