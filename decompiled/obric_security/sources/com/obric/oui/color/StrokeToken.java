package com.obric.oui.color;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StrokeToken.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b@\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\b\u0010F\u001a\u0004\u0018\u00010GH\u0007J\u001c\u0010E\u001a\u0004\u0018\u00010\u00062\b\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010H\u001a\u00020\u0005H\u0007J\u001a\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00012\b\b\u0002\u0010L\u001a\u00020\u0005H\u0007J\u001a\u0010M\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00012\b\b\u0002\u0010L\u001a\u00020\u0005H\u0007J2\u0010N\u001a\u00020J2\u001e\u0010O\u001a\u001a\u0012\u0004\u0012\u00020G\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040P2\b\b\u0002\u0010L\u001a\u00020\u0005H\u0007J&\u0010Q\u001a\u00020J2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u00060P2\b\b\u0002\u0010L\u001a\u00020\u0005H\u0007R(\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\tR\u0010\u0010\u000f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\tR\u0010\u0010\u0014\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0002\u001a\u0004\b\u0018\u0010\tR\u0010\u0010\u0019\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0002\u001a\u0004\b\u001d\u0010\tR\u0010\u0010\u001e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0002\u001a\u0004\b\"\u0010\tR\u0010\u0010#\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0002\u001a\u0004\b'\u0010\tR\u0010\u0010(\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0002\u001a\u0004\b,\u0010\tR\u0010\u0010-\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u0002\u001a\u0004\b1\u0010\tR\u0010\u00102\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010\u0002\u001a\u0004\b8\u0010\tR\u0010\u00109\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010\u0002\u001a\u0004\b=\u0010\tR\u0010\u0010>\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u0010\u0002\u001a\u0004\bB\u0010\tR\u0010\u0010C\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/obric/oui/color/StrokeToken;", "", "()V", "OUI_Effect_Stroke_Blue_Regular", "Lkotlin/Function1;", "", "Lcom/obric/oui/color/StrokeConfig;", "getOUI_Effect_Stroke_Blue_Regular$annotations", "getOUI_Effect_Stroke_Blue_Regular", "()Lkotlin/jvm/functions/Function1;", "OUI_Effect_Stroke_Blue_Regular_Dark", "OUI_Effect_Stroke_Blue_Regular_Light", "OUI_Effect_Stroke_Blue_Thin", "getOUI_Effect_Stroke_Blue_Thin$annotations", "getOUI_Effect_Stroke_Blue_Thin", "OUI_Effect_Stroke_Blue_Thin_Dark", "OUI_Effect_Stroke_Blue_Thin_Light", "OUI_Effect_Stroke_Green_Regular", "getOUI_Effect_Stroke_Green_Regular$annotations", "getOUI_Effect_Stroke_Green_Regular", "OUI_Effect_Stroke_Green_Regular_Dark", "OUI_Effect_Stroke_Green_Regular_Light", "OUI_Effect_Stroke_Green_Thin", "getOUI_Effect_Stroke_Green_Thin$annotations", "getOUI_Effect_Stroke_Green_Thin", "OUI_Effect_Stroke_Green_Thin_Dark", "OUI_Effect_Stroke_Green_Thin_Light", "OUI_Effect_Stroke_Red_Regular", "getOUI_Effect_Stroke_Red_Regular$annotations", "getOUI_Effect_Stroke_Red_Regular", "OUI_Effect_Stroke_Red_Regular_Dark", "OUI_Effect_Stroke_Red_Regular_Light", "OUI_Effect_Stroke_Red_Thin", "getOUI_Effect_Stroke_Red_Thin$annotations", "getOUI_Effect_Stroke_Red_Thin", "OUI_Effect_Stroke_Red_Thin_Dark", "OUI_Effect_Stroke_Red_Thin_Light", "OUI_Effect_Stroke_Regular", "getOUI_Effect_Stroke_Regular$annotations", "getOUI_Effect_Stroke_Regular", "OUI_Effect_Stroke_Regular_Dark", "OUI_Effect_Stroke_Regular_Light", "OUI_Effect_Stroke_Thick", "getOUI_Effect_Stroke_Thick$annotations", "getOUI_Effect_Stroke_Thick", "OUI_Effect_Stroke_Thick_Dark", "OUI_Effect_Stroke_Thick_Light", "OUI_Effect_Stroke_Thin", "getOUI_Effect_Stroke_Thin$annotations", "getOUI_Effect_Stroke_Thin", "OUI_Effect_Stroke_Thin_Dark", "OUI_Effect_Stroke_Thin_Light", "OUI_Effect_Stroke_Tinted_Dark", "OUI_Effect_Stroke_Tinted_Light", "OUI_Effect_Stroke_UltraThin", "getOUI_Effect_Stroke_UltraThin$annotations", "getOUI_Effect_Stroke_UltraThin", "OUI_Effect_Stroke_UltraThin_Dark", "OUI_Effect_Stroke_UltraThin_Light", "OUI_Effect_Stroke_Yellow_Regular", "getOUI_Effect_Stroke_Yellow_Regular$annotations", "getOUI_Effect_Stroke_Yellow_Regular", "OUI_Effect_Stroke_Yellow_Regular_Dark", "OUI_Effect_Stroke_Yellow_Regular_Light", "OUI_Effect_Stroke_Yellow_Thin", "getOUI_Effect_Stroke_Yellow_Thin$annotations", "getOUI_Effect_Stroke_Yellow_Thin", "OUI_Effect_Stroke_Yellow_Thin_Dark", "OUI_Effect_Stroke_Yellow_Thin_Light", "parse", "name", "", "isLight", "register", "", "customTokenOwner", "overrideExisting", "registerProvider", "registerProviderTokens", "customTokens", "", "registerTokens", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StrokeToken {
    public static final StrokeToken INSTANCE = null;
    private static final Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Blue_Regular = null;
    public static final StrokeConfig OUI_Effect_Stroke_Blue_Regular_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Blue_Regular_Light = null;
    private static final Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Blue_Thin = null;
    public static final StrokeConfig OUI_Effect_Stroke_Blue_Thin_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Blue_Thin_Light = null;
    private static final Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Green_Regular = null;
    public static final StrokeConfig OUI_Effect_Stroke_Green_Regular_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Green_Regular_Light = null;
    private static final Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Green_Thin = null;
    public static final StrokeConfig OUI_Effect_Stroke_Green_Thin_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Green_Thin_Light = null;
    private static final Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Red_Regular = null;
    public static final StrokeConfig OUI_Effect_Stroke_Red_Regular_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Red_Regular_Light = null;
    private static final Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Red_Thin = null;
    public static final StrokeConfig OUI_Effect_Stroke_Red_Thin_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Red_Thin_Light = null;
    private static final Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Regular = null;
    public static final StrokeConfig OUI_Effect_Stroke_Regular_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Regular_Light = null;
    private static final Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Thick = null;
    public static final StrokeConfig OUI_Effect_Stroke_Thick_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Thick_Light = null;
    private static final Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Thin = null;
    public static final StrokeConfig OUI_Effect_Stroke_Thin_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Thin_Light = null;
    public static final StrokeConfig OUI_Effect_Stroke_Tinted_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Tinted_Light = null;
    private static final Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_UltraThin = null;
    public static final StrokeConfig OUI_Effect_Stroke_UltraThin_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_UltraThin_Light = null;
    private static final Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Yellow_Regular = null;
    public static final StrokeConfig OUI_Effect_Stroke_Yellow_Regular_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Yellow_Regular_Light = null;
    private static final Function1<Boolean, StrokeConfig> OUI_Effect_Stroke_Yellow_Thin = null;
    public static final StrokeConfig OUI_Effect_Stroke_Yellow_Thin_Dark = null;
    public static final StrokeConfig OUI_Effect_Stroke_Yellow_Thin_Light = null;

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
    public static final void registerTokens(Map<String, StrokeConfig> r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "customTokens");
        StrokeTokenCore.registerTokens(INSTANCE, r1, r2);
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
    public static final void registerProviderTokens(Map<String, ? extends Function1<? super Boolean, StrokeConfig>> r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "customTokens");
        StrokeTokenCore.registerProviderTokens(INSTANCE, r1, r2);
    }

    @JvmStatic
    public static final Function1<Boolean, StrokeConfig> parse(String r1) {
        return StrokeTokenCore.parseProvider(INSTANCE, r1);
    }

    @JvmStatic
    public static final StrokeConfig parse(String r1, boolean r2) {
        return StrokeTokenCore.parse(INSTANCE, r1, r2);
    }

    static {
        INSTANCE = new StrokeToken();
        StrokeConfig r0 = StrokeTokenCore.OUI_Effect_Stroke_Regular_Light;
        Intrinsics.checkNotNullExpressionValue(r0, "OUI_Effect_Stroke_Regular_Light");
        OUI_Effect_Stroke_Regular_Light = r0;
        StrokeConfig r1 = StrokeTokenCore.OUI_Effect_Stroke_Regular_Dark;
        Intrinsics.checkNotNullExpressionValue(r1, "OUI_Effect_Stroke_Regular_Dark");
        OUI_Effect_Stroke_Regular_Dark = r1;
        Function1<Boolean, StrokeConfig> r2 = StrokeTokenCore.OUI_Effect_Stroke_Regular;
        Intrinsics.checkNotNullExpressionValue(r2, "OUI_Effect_Stroke_Regular");
        OUI_Effect_Stroke_Regular = r2;
        StrokeConfig r3 = StrokeTokenCore.OUI_Effect_Stroke_UltraThin_Light;
        Intrinsics.checkNotNullExpressionValue(r3, "OUI_Effect_Stroke_UltraThin_Light");
        OUI_Effect_Stroke_UltraThin_Light = r3;
        StrokeConfig r4 = StrokeTokenCore.OUI_Effect_Stroke_UltraThin_Dark;
        Intrinsics.checkNotNullExpressionValue(r4, "OUI_Effect_Stroke_UltraThin_Dark");
        OUI_Effect_Stroke_UltraThin_Dark = r4;
        Function1<Boolean, StrokeConfig> r5 = StrokeTokenCore.OUI_Effect_Stroke_UltraThin;
        Intrinsics.checkNotNullExpressionValue(r5, "OUI_Effect_Stroke_UltraThin");
        OUI_Effect_Stroke_UltraThin = r5;
        StrokeConfig r6 = StrokeTokenCore.OUI_Effect_Stroke_Thin_Light;
        Intrinsics.checkNotNullExpressionValue(r6, "OUI_Effect_Stroke_Thin_Light");
        OUI_Effect_Stroke_Thin_Light = r6;
        StrokeConfig r7 = StrokeTokenCore.OUI_Effect_Stroke_Thin_Dark;
        Intrinsics.checkNotNullExpressionValue(r7, "OUI_Effect_Stroke_Thin_Dark");
        OUI_Effect_Stroke_Thin_Dark = r7;
        Function1<Boolean, StrokeConfig> r8 = StrokeTokenCore.OUI_Effect_Stroke_Thin;
        Intrinsics.checkNotNullExpressionValue(r8, "OUI_Effect_Stroke_Thin");
        OUI_Effect_Stroke_Thin = r8;
        StrokeConfig r9 = StrokeTokenCore.OUI_Effect_Stroke_Thick_Light;
        Intrinsics.checkNotNullExpressionValue(r9, "OUI_Effect_Stroke_Thick_Light");
        OUI_Effect_Stroke_Thick_Light = r9;
        StrokeConfig r10 = StrokeTokenCore.OUI_Effect_Stroke_Thick_Dark;
        Intrinsics.checkNotNullExpressionValue(r10, "OUI_Effect_Stroke_Thick_Dark");
        OUI_Effect_Stroke_Thick_Dark = r10;
        Function1<Boolean, StrokeConfig> r11 = StrokeTokenCore.OUI_Effect_Stroke_Thick;
        Intrinsics.checkNotNullExpressionValue(r11, "OUI_Effect_Stroke_Thick");
        OUI_Effect_Stroke_Thick = r11;
        StrokeConfig r12 = StrokeTokenCore.OUI_Effect_Stroke_Tinted_Light;
        Intrinsics.checkNotNullExpressionValue(r12, "OUI_Effect_Stroke_Tinted_Light");
        OUI_Effect_Stroke_Tinted_Light = r12;
        StrokeConfig r13 = StrokeTokenCore.OUI_Effect_Stroke_Tinted_Dark;
        Intrinsics.checkNotNullExpressionValue(r13, "OUI_Effect_Stroke_Tinted_Dark");
        OUI_Effect_Stroke_Tinted_Dark = r13;
        StrokeConfig r14 = StrokeTokenCore.OUI_Effect_Stroke_Blue_Regular_Light;
        Intrinsics.checkNotNullExpressionValue(r14, "OUI_Effect_Stroke_Blue_Regular_Light");
        OUI_Effect_Stroke_Blue_Regular_Light = r14;
        StrokeConfig r15 = StrokeTokenCore.OUI_Effect_Stroke_Blue_Regular_Dark;
        Intrinsics.checkNotNullExpressionValue(r15, "OUI_Effect_Stroke_Blue_Regular_Dark");
        OUI_Effect_Stroke_Blue_Regular_Dark = r15;
        Function1<Boolean, StrokeConfig> r16 = StrokeTokenCore.OUI_Effect_Stroke_Blue_Regular;
        Intrinsics.checkNotNullExpressionValue(r16, "OUI_Effect_Stroke_Blue_Regular");
        OUI_Effect_Stroke_Blue_Regular = r16;
        StrokeConfig r17 = StrokeTokenCore.OUI_Effect_Stroke_Blue_Thin_Light;
        Intrinsics.checkNotNullExpressionValue(r17, "OUI_Effect_Stroke_Blue_Thin_Light");
        OUI_Effect_Stroke_Blue_Thin_Light = r17;
        StrokeConfig r18 = StrokeTokenCore.OUI_Effect_Stroke_Blue_Thin_Dark;
        Intrinsics.checkNotNullExpressionValue(r18, "OUI_Effect_Stroke_Blue_Thin_Dark");
        OUI_Effect_Stroke_Blue_Thin_Dark = r18;
        Function1<Boolean, StrokeConfig> r19 = StrokeTokenCore.OUI_Effect_Stroke_Blue_Thin;
        Intrinsics.checkNotNullExpressionValue(r19, "OUI_Effect_Stroke_Blue_Thin");
        OUI_Effect_Stroke_Blue_Thin = r19;
        StrokeConfig r20 = StrokeTokenCore.OUI_Effect_Stroke_Red_Regular_Light;
        Intrinsics.checkNotNullExpressionValue(r20, "OUI_Effect_Stroke_Red_Regular_Light");
        OUI_Effect_Stroke_Red_Regular_Light = r20;
        StrokeConfig r21 = StrokeTokenCore.OUI_Effect_Stroke_Red_Regular_Dark;
        Intrinsics.checkNotNullExpressionValue(r21, "OUI_Effect_Stroke_Red_Regular_Dark");
        OUI_Effect_Stroke_Red_Regular_Dark = r21;
        Function1<Boolean, StrokeConfig> r22 = StrokeTokenCore.OUI_Effect_Stroke_Red_Regular;
        Intrinsics.checkNotNullExpressionValue(r22, "OUI_Effect_Stroke_Red_Regular");
        OUI_Effect_Stroke_Red_Regular = r22;
        StrokeConfig r23 = StrokeTokenCore.OUI_Effect_Stroke_Red_Thin_Light;
        Intrinsics.checkNotNullExpressionValue(r23, "OUI_Effect_Stroke_Red_Thin_Light");
        OUI_Effect_Stroke_Red_Thin_Light = r23;
        StrokeConfig r24 = StrokeTokenCore.OUI_Effect_Stroke_Red_Thin_Dark;
        Intrinsics.checkNotNullExpressionValue(r24, "OUI_Effect_Stroke_Red_Thin_Dark");
        OUI_Effect_Stroke_Red_Thin_Dark = r24;
        Function1<Boolean, StrokeConfig> r25 = StrokeTokenCore.OUI_Effect_Stroke_Red_Thin;
        Intrinsics.checkNotNullExpressionValue(r25, "OUI_Effect_Stroke_Red_Thin");
        OUI_Effect_Stroke_Red_Thin = r25;
        StrokeConfig r26 = StrokeTokenCore.OUI_Effect_Stroke_Green_Regular_Light;
        Intrinsics.checkNotNullExpressionValue(r26, "OUI_Effect_Stroke_Green_Regular_Light");
        OUI_Effect_Stroke_Green_Regular_Light = r26;
        StrokeConfig r27 = StrokeTokenCore.OUI_Effect_Stroke_Green_Regular_Dark;
        Intrinsics.checkNotNullExpressionValue(r27, "OUI_Effect_Stroke_Green_Regular_Dark");
        OUI_Effect_Stroke_Green_Regular_Dark = r27;
        Function1<Boolean, StrokeConfig> r28 = StrokeTokenCore.OUI_Effect_Stroke_Green_Regular;
        Intrinsics.checkNotNullExpressionValue(r28, "OUI_Effect_Stroke_Green_Regular");
        OUI_Effect_Stroke_Green_Regular = r28;
        StrokeConfig r29 = StrokeTokenCore.OUI_Effect_Stroke_Green_Thin_Light;
        Intrinsics.checkNotNullExpressionValue(r29, "OUI_Effect_Stroke_Green_Thin_Light");
        OUI_Effect_Stroke_Green_Thin_Light = r29;
        StrokeConfig r30 = StrokeTokenCore.OUI_Effect_Stroke_Green_Thin_Dark;
        Intrinsics.checkNotNullExpressionValue(r30, "OUI_Effect_Stroke_Green_Thin_Dark");
        OUI_Effect_Stroke_Green_Thin_Dark = r30;
        Function1<Boolean, StrokeConfig> r31 = StrokeTokenCore.OUI_Effect_Stroke_Green_Thin;
        Intrinsics.checkNotNullExpressionValue(r31, "OUI_Effect_Stroke_Green_Thin");
        OUI_Effect_Stroke_Green_Thin = r31;
        StrokeConfig r32 = StrokeTokenCore.OUI_Effect_Stroke_Yellow_Regular_Light;
        Intrinsics.checkNotNullExpressionValue(r32, "OUI_Effect_Stroke_Yellow_Regular_Light");
        OUI_Effect_Stroke_Yellow_Regular_Light = r32;
        StrokeConfig r33 = StrokeTokenCore.OUI_Effect_Stroke_Yellow_Regular_Dark;
        Intrinsics.checkNotNullExpressionValue(r33, "OUI_Effect_Stroke_Yellow_Regular_Dark");
        OUI_Effect_Stroke_Yellow_Regular_Dark = r33;
        Function1<Boolean, StrokeConfig> r34 = StrokeTokenCore.OUI_Effect_Stroke_Yellow_Regular;
        Intrinsics.checkNotNullExpressionValue(r34, "OUI_Effect_Stroke_Yellow_Regular");
        OUI_Effect_Stroke_Yellow_Regular = r34;
        StrokeConfig r35 = StrokeTokenCore.OUI_Effect_Stroke_Yellow_Thin_Light;
        Intrinsics.checkNotNullExpressionValue(r35, "OUI_Effect_Stroke_Yellow_Thin_Light");
        OUI_Effect_Stroke_Yellow_Thin_Light = r35;
        StrokeConfig r36 = StrokeTokenCore.OUI_Effect_Stroke_Yellow_Thin_Dark;
        Intrinsics.checkNotNullExpressionValue(r36, "OUI_Effect_Stroke_Yellow_Thin_Dark");
        OUI_Effect_Stroke_Yellow_Thin_Dark = r36;
        Function1<Boolean, StrokeConfig> r37 = StrokeTokenCore.OUI_Effect_Stroke_Yellow_Thin;
        Intrinsics.checkNotNullExpressionValue(r37, "OUI_Effect_Stroke_Yellow_Thin");
        OUI_Effect_Stroke_Yellow_Thin = r37;
    }

    public static final Function1<Boolean, StrokeConfig> getOUI_Effect_Stroke_Regular() {
        return OUI_Effect_Stroke_Regular;
    }

    public static final Function1<Boolean, StrokeConfig> getOUI_Effect_Stroke_UltraThin() {
        return OUI_Effect_Stroke_UltraThin;
    }

    public static final Function1<Boolean, StrokeConfig> getOUI_Effect_Stroke_Thin() {
        return OUI_Effect_Stroke_Thin;
    }

    public static final Function1<Boolean, StrokeConfig> getOUI_Effect_Stroke_Thick() {
        return OUI_Effect_Stroke_Thick;
    }

    public static final Function1<Boolean, StrokeConfig> getOUI_Effect_Stroke_Blue_Regular() {
        return OUI_Effect_Stroke_Blue_Regular;
    }

    public static final Function1<Boolean, StrokeConfig> getOUI_Effect_Stroke_Blue_Thin() {
        return OUI_Effect_Stroke_Blue_Thin;
    }

    public static final Function1<Boolean, StrokeConfig> getOUI_Effect_Stroke_Red_Regular() {
        return OUI_Effect_Stroke_Red_Regular;
    }

    public static final Function1<Boolean, StrokeConfig> getOUI_Effect_Stroke_Red_Thin() {
        return OUI_Effect_Stroke_Red_Thin;
    }

    public static final Function1<Boolean, StrokeConfig> getOUI_Effect_Stroke_Green_Regular() {
        return OUI_Effect_Stroke_Green_Regular;
    }

    public static final Function1<Boolean, StrokeConfig> getOUI_Effect_Stroke_Green_Thin() {
        return OUI_Effect_Stroke_Green_Thin;
    }

    public static final Function1<Boolean, StrokeConfig> getOUI_Effect_Stroke_Yellow_Regular() {
        return OUI_Effect_Stroke_Yellow_Regular;
    }

    public static final Function1<Boolean, StrokeConfig> getOUI_Effect_Stroke_Yellow_Thin() {
        return OUI_Effect_Stroke_Yellow_Thin;
    }
}
