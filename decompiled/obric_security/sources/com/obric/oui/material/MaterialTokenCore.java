package com.obric.oui.material;

import android.content.res.ColorStateList;
import com.obric.oui.color.BlendConfig;
import com.obric.oui.color.BlendTokenCore;
import com.obric.oui.color.StrokeConfig;
import com.obric.oui.color.StrokeTokenCore;
import com.obric.oui.fluid.FluidTokenCore;
import com.obric.oui.res.BlendConfigStateList;
import com.obric.oui.shadow.ShadowTokenCore;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class MaterialTokenCore {
    public static final MaterialConfig[] OUI_Bg_Floating_Blue_Dark = null;
    public static final MaterialConfig[] OUI_Bg_Floating_Blue_Light = null;
    public static final MaterialConfig[] OUI_Bg_Floating_Dark = null;
    public static final MaterialConfig[] OUI_Bg_Floating_Fill_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_Fill_Fluid_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_Fill_Fluid_Light = null;
    public static final MaterialConfig OUI_Bg_Floating_Fill_Frost_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_Fill_Frost_Light = null;
    public static final MaterialConfig[] OUI_Bg_Floating_Fill_Light = null;
    public static final MaterialConfig OUI_Bg_Floating_Fluid_Blue_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_Fluid_Blue_Light = null;
    public static final MaterialConfig OUI_Bg_Floating_Fluid_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_Fluid_Light = null;
    public static final MaterialConfig OUI_Bg_Floating_Fluid_Tinted_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_Fluid_Tinted_Light = null;
    public static final MaterialConfig OUI_Bg_Floating_Frost_Blue_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_Frost_Blue_Light = null;
    public static final MaterialConfig OUI_Bg_Floating_Frost_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_Frost_Light = null;
    public static final MaterialConfig OUI_Bg_Floating_Frost_Tinted_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_Frost_Tinted_Light = null;
    public static final MaterialConfig[] OUI_Bg_Floating_Light = null;
    public static final MaterialConfig[] OUI_Bg_Floating_OnImage_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_OnImage_Fluid_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_OnImage_Fluid_Light = null;
    public static final MaterialConfig OUI_Bg_Floating_OnImage_Frost_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_OnImage_Frost_Light = null;
    public static final MaterialConfig[] OUI_Bg_Floating_OnImage_Light = null;
    public static final MaterialConfig[] OUI_Bg_Floating_Overlay_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_Overlay_Fluid_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_Overlay_Fluid_Light = null;
    public static final MaterialConfig OUI_Bg_Floating_Overlay_Frost_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_Overlay_Frost_Light = null;
    public static final MaterialConfig[] OUI_Bg_Floating_Overlay_Light = null;
    public static final MaterialConfig[] OUI_Bg_Floating_Tinted_Dark = null;
    public static final MaterialConfig[] OUI_Bg_Floating_Tinted_Light = null;
    public static final MaterialConfig[] OUI_Bg_Modal_Dark = null;
    public static final MaterialConfig OUI_Bg_Modal_Fluid_Dark = null;
    public static final MaterialConfig OUI_Bg_Modal_Fluid_Light = null;
    public static final MaterialConfig OUI_Bg_Modal_Frost_Dark = null;
    public static final MaterialConfig OUI_Bg_Modal_Frost_Light = null;
    public static final MaterialConfig[] OUI_Bg_Modal_Light = null;

    @Deprecated
    public static final MaterialConfig[] OUI_Bg_Overlay_Search_Dark = null;

    @Deprecated
    public static final MaterialConfig OUI_Bg_Overlay_Search_Fluid_Dark = null;

    @Deprecated
    public static final MaterialConfig OUI_Bg_Overlay_Search_Fluid_Light = null;

    @Deprecated
    public static final MaterialConfig OUI_Bg_Overlay_Search_Frost_Dark = null;

    @Deprecated
    public static final MaterialConfig OUI_Bg_Overlay_Search_Frost_Light = null;

    @Deprecated
    public static final MaterialConfig[] OUI_Bg_Overlay_Search_Light = null;
    public static final MaterialConfig[] OUI_Bg_Popup_Dark = null;
    public static final MaterialConfig OUI_Bg_Popup_Fluid_Dark = null;
    public static final MaterialConfig OUI_Bg_Popup_Fluid_Light = null;
    public static final MaterialConfig OUI_Bg_Popup_Frost_Dark = null;
    public static final MaterialConfig OUI_Bg_Popup_Frost_Light = null;
    public static final MaterialConfig[] OUI_Bg_Popup_Light = null;
    public static final MaterialConfig[] OUI_Bg_Popup_OnImage_Dark = null;
    public static final MaterialConfig OUI_Bg_Popup_OnImage_Fluid_Dark = null;
    public static final MaterialConfig OUI_Bg_Popup_OnImage_Fluid_Light = null;
    public static final MaterialConfig OUI_Bg_Popup_OnImage_Frost_Dark = null;
    public static final MaterialConfig OUI_Bg_Popup_OnImage_Frost_Light = null;
    public static final MaterialConfig[] OUI_Bg_Popup_OnImage_Light = null;
    public static final MaterialConfig[] OUI_Bg_Popup_Overlay_Dark = null;
    public static final MaterialConfig OUI_Bg_Popup_Overlay_Fluid_Dark = null;
    public static final MaterialConfig OUI_Bg_Popup_Overlay_Fluid_Light = null;
    public static final MaterialConfig OUI_Bg_Popup_Overlay_Frost_Dark = null;
    public static final MaterialConfig OUI_Bg_Popup_Overlay_Frost_Light = null;
    public static final MaterialConfig[] OUI_Bg_Popup_Overlay_Light = null;
    public static final MaterialConfig OUI_Text_Primary_Dark = null;
    public static final MaterialConfig OUI_Text_Primary_Light = null;
    public static final MaterialConfig OUI_Text_Secondary_Dark = null;
    public static final MaterialConfig OUI_Text_Secondary_Light = null;
    public static final MaterialConfig OUI_Text_Tertiary_Dark = null;
    public static final MaterialConfig OUI_Text_Tertiary_Light = null;
    public static final String TOKEN_BG_FLOATING = "oui_bg_floating";
    public static final String TOKEN_BG_FLOATING_BLUE = "oui_bg_floating_blue";
    public static final String TOKEN_BG_FLOATING_FILL = "oui_bg_floating_fill";
    public static final String TOKEN_BG_FLOATING_ON_IMAGE = "oui_bg_floating_onimage";
    public static final String TOKEN_BG_FLOATING_OVERLAY = "oui_bg_floating_overlay";
    public static final String TOKEN_BG_FLOATING_TINTED = "oui_bg_floating_tinted";
    public static final String TOKEN_BG_MODAL = "oui_bg_modal";
    public static final String TOKEN_BG_POPUP = "oui_bg_popup";
    public static final String TOKEN_BG_POPUP_ON_IMAGE = "oui_bg_popup_onimage";
    public static final String TOKEN_BG_POPUP_OVERLAY = "oui_bg_popup_overlay";
    public static final String TOKEN_TEXT_PRIMARY = "oui_text_primary";
    public static final String TOKEN_TEXT_SECONDARY = "oui_text_secondary";
    public static final String TOKEN_TEXT_TERTIARY = "oui_text_tertiary";
    private static volatile ConcurrentHashMap<String, MaterialConfig[]> tokenSets;
    private static volatile ConcurrentHashMap<String, MaterialConfig> tokens;

    static {
        ColorStateList r1 = ColorStateList.valueOf(-1);
        BlendConfigStateList r2 = BlendConfigStateList.ofWithOverlay(BlendTokenCore.OUI_Color_Blend_Frost_Regular_Light, BlendTokenCore.OUI_Color_Blend_Frost_Regular_Light, BlendTokenCore.OUI_Color_State_Press_Light, BlendConfig.TRANSPARENT, BlendConfig.TRANSPARENT, BlendConfig.TRANSPARENT);
        StrokeConfig r5 = StrokeTokenCore.OUI_Effect_Stroke_Regular_Light;
        Float r24 = Float.valueOf(8.0f);
        MaterialConfig r11 = new MaterialConfig(r1, r2, null, null, r5, null, null, r24, ShadowTokenCore.Oui_Shadow_Regular, null);
        OUI_Bg_Floating_Frost_Light = r11;
        MaterialConfig r0 = new MaterialConfig(ColorStateList.valueOf(-13421773), BlendConfigStateList.ofWithOverlay(BlendTokenCore.OUI_Color_Blend_Frost_Regular_Dark, BlendTokenCore.OUI_Color_Blend_Frost_Regular_Dark, BlendTokenCore.OUI_Color_State_Press_Dark, BlendConfig.TRANSPARENT, BlendConfig.TRANSPARENT, BlendConfig.TRANSPARENT), null, null, StrokeTokenCore.OUI_Effect_Stroke_Regular_Dark, null, null, r24, ShadowTokenCore.Oui_Shadow_Regular, null);
        OUI_Bg_Floating_Frost_Dark = r0;
        ColorStateList r26 = ColorStateList.valueOf(-1);
        BlendConfigStateList r27 = BlendConfigStateList.ofWithOverlay(BlendTokenCore.OUI_Color_Blend_Fluid_Regular_Light, BlendTokenCore.OUI_Color_Blend_Fluid_Regular_Light, BlendTokenCore.OUI_Color_State_Press_Light, BlendConfig.TRANSPARENT, BlendConfig.TRANSPARENT, BlendConfig.TRANSPARENT);
        Float r3 = Float.valueOf(2.0f);
        MaterialConfig r4 = new MaterialConfig(r26, r27, null, null, null, null, null, r3, ShadowTokenCore.Oui_Shadow_Regular, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Floating_Fluid_Light = r4;
        MaterialConfig r6 = new MaterialConfig(ColorStateList.valueOf(-13421773), BlendConfigStateList.ofWithOverlay(BlendTokenCore.OUI_Color_Blend_Fluid_Regular_Dark, BlendTokenCore.OUI_Color_Blend_Fluid_Regular_Dark, BlendTokenCore.OUI_Color_State_Press_Dark, BlendConfig.TRANSPARENT, BlendConfig.TRANSPARENT, BlendConfig.TRANSPARENT), null, null, null, null, null, r3, ShadowTokenCore.Oui_Shadow_Regular, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Floating_Fluid_Dark = r6;
        OUI_Bg_Floating_Light = new MaterialConfig[]{r11, r4};
        OUI_Bg_Floating_Dark = new MaterialConfig[]{r0, r6};
        ColorStateList r14 = ColorStateList.valueOf(-1);
        BlendConfig[] r16 = BlendTokenCore.OUI_Color_Blend_Frost_Thin_Light;
        StrokeConfig r18 = StrokeTokenCore.OUI_Effect_Stroke_Thin_Light;
        Float r7 = Float.valueOf(20.0f);
        MaterialConfig r8 = new MaterialConfig(r14, null, r16, null, r18, null, null, r7, ShadowTokenCore.Oui_Shadow_Thick, null);
        OUI_Bg_Floating_OnImage_Frost_Light = r8;
        MaterialConfig r9 = new MaterialConfig(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Frost_Thin_Dark, null, StrokeTokenCore.OUI_Effect_Stroke_Thin_Dark, null, null, r7, ShadowTokenCore.Oui_Shadow_Thick, null);
        OUI_Bg_Floating_OnImage_Frost_Dark = r9;
        MaterialConfig r10 = new MaterialConfig(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Fluid_Thin_Light, null, null, null, null, r24, ShadowTokenCore.Oui_Shadow_Thick, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Floating_OnImage_Fluid_Light = r10;
        MaterialConfig r12 = new MaterialConfig(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Fluid_Thin_Dark, null, null, null, null, r24, ShadowTokenCore.Oui_Shadow_Thick, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Floating_OnImage_Fluid_Dark = r12;
        OUI_Bg_Floating_OnImage_Light = new MaterialConfig[]{r8, r10};
        OUI_Bg_Floating_OnImage_Dark = new MaterialConfig[]{r9, r12};
        MaterialConfig r13 = new MaterialConfig(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Fills_Thick_Light, null, null, null, null, r24, null, null);
        OUI_Bg_Floating_Fill_Frost_Light = r13;
        MaterialConfig r15 = new MaterialConfig(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Fills_Thick_Dark, null, null, null, null, r24, null, null);
        OUI_Bg_Floating_Fill_Frost_Dark = r15;
        OUI_Bg_Floating_Fill_Fluid_Light = new MaterialConfig(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Fills_Thick_Light, null, null, null, null, r24, null, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Floating_Fill_Fluid_Dark = new MaterialConfig(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Fills_Thick_Dark, null, null, null, null, r24, null, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Floating_Fill_Light = new MaterialConfig[]{r13};
        OUI_Bg_Floating_Fill_Dark = new MaterialConfig[]{r15};
        MaterialConfig r17 = new MaterialConfig(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Frost_Regular_Light, null, StrokeTokenCore.OUI_Effect_Stroke_Regular_Light, null, null, r7, ShadowTokenCore.Oui_Shadow_Thick, null);
        OUI_Bg_Popup_Frost_Light = r17;
        MaterialConfig r19 = new MaterialConfig(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Frost_Regular_Dark, null, StrokeTokenCore.OUI_Effect_Stroke_Regular_Dark, null, null, r7, ShadowTokenCore.Oui_Shadow_Thick, null);
        OUI_Bg_Popup_Frost_Dark = r19;
        MaterialConfig r20 = new MaterialConfig(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Fluid_Regular_Light, null, null, null, null, r7, ShadowTokenCore.Oui_Shadow_Thick, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Popup_Fluid_Light = r20;
        MaterialConfig r21 = new MaterialConfig(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Fluid_Regular_Dark, null, null, null, null, r7, ShadowTokenCore.Oui_Shadow_Thick, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Popup_Fluid_Dark = r21;
        OUI_Bg_Popup_Light = new MaterialConfig[]{r17, r20};
        OUI_Bg_Popup_Dark = new MaterialConfig[]{r19, r21};
        ColorStateList r110 = ColorStateList.valueOf(-1);
        BlendConfig[] r111 = BlendTokenCore.OUI_Color_Blend_Frost_Thin_Light;
        StrokeConfig r112 = StrokeTokenCore.OUI_Effect_Stroke_Thin_Light;
        Float r22 = Float.valueOf(32.0f);
        MaterialConfig r23 = new MaterialConfig(r110, null, r111, null, r112, null, null, r22, ShadowTokenCore.Oui_Shadow_UltraThick, null);
        OUI_Bg_Popup_OnImage_Frost_Light = r23;
        MaterialConfig r25 = new MaterialConfig(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Frost_Thin_Dark, null, StrokeTokenCore.OUI_Effect_Stroke_Thin_Dark, null, null, r22, ShadowTokenCore.Oui_Shadow_UltraThick, null);
        OUI_Bg_Popup_OnImage_Frost_Dark = r25;
        MaterialConfig r28 = new MaterialConfig(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Fluid_Thin_Light, null, null, null, null, r7, ShadowTokenCore.Oui_Shadow_UltraThick, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Popup_OnImage_Fluid_Light = r28;
        MaterialConfig r113 = new MaterialConfig(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Fluid_Thin_Dark, null, null, null, null, r7, ShadowTokenCore.Oui_Shadow_UltraThick, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Popup_OnImage_Fluid_Dark = r113;
        OUI_Bg_Popup_OnImage_Light = new MaterialConfig[]{r23, r28};
        OUI_Bg_Popup_OnImage_Dark = new MaterialConfig[]{r25, r113};
        MaterialConfig r29 = new MaterialConfig(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Frost_Thick_Light, null, StrokeTokenCore.OUI_Effect_Stroke_Thick_Light, null, null, r22, null, null);
        OUI_Bg_Modal_Frost_Light = r29;
        MaterialConfig r30 = new MaterialConfig(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Frost_Thick_Dark, null, StrokeTokenCore.OUI_Effect_Stroke_Thick_Dark, null, null, r22, null, null);
        OUI_Bg_Modal_Frost_Dark = r30;
        MaterialConfig r31 = new MaterialConfig(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Fluid_Thick_Light, null, null, null, null, r22, null, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Modal_Fluid_Light = r31;
        MaterialConfig r114 = new MaterialConfig(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Fluid_Thick_Dark, null, null, null, null, r22, null, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Modal_Fluid_Dark = r114;
        OUI_Bg_Modal_Light = new MaterialConfig[]{r29, r31};
        OUI_Bg_Modal_Dark = new MaterialConfig[]{r30, r114};
        MaterialConfig r32 = new MaterialConfig(null, BlendConfigStateList.ofWithOverlay(BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Light, BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Light, BlendTokenCore.OUI_Color_State_Press_Light, BlendConfig.TRANSPARENT, BlendConfig.TRANSPARENT, BlendConfig.TRANSPARENT), null, null, StrokeTokenCore.OUI_Effect_Stroke_Thin_Light, null, null, r24, null, null);
        OUI_Bg_Floating_Overlay_Frost_Light = r32;
        MaterialConfig r33 = new MaterialConfig(null, BlendConfigStateList.ofWithOverlay(BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Dark, BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Dark, BlendTokenCore.OUI_Color_State_Press_Dark, BlendConfig.TRANSPARENT, BlendConfig.TRANSPARENT, BlendConfig.TRANSPARENT), null, null, StrokeTokenCore.OUI_Effect_Stroke_Thin_Dark, null, null, r24, null, null);
        OUI_Bg_Floating_Overlay_Frost_Dark = r33;
        MaterialConfig r34 = new MaterialConfig(null, BlendConfigStateList.ofWithOverlay(BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Light, BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Light, BlendTokenCore.OUI_Color_State_Press_Light, BlendConfig.TRANSPARENT, BlendConfig.TRANSPARENT, BlendConfig.TRANSPARENT), null, null, null, null, null, r24, null, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Floating_Overlay_Fluid_Light = r34;
        MaterialConfig r35 = new MaterialConfig(null, BlendConfigStateList.ofWithOverlay(BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_State_Press_Dark, BlendConfig.TRANSPARENT, BlendConfig.TRANSPARENT, BlendConfig.TRANSPARENT), null, null, null, null, null, r24, null, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Floating_Overlay_Fluid_Dark = r35;
        MaterialConfig[] r36 = {r32, r34};
        OUI_Bg_Floating_Overlay_Light = r36;
        MaterialConfig[] r115 = {r33, r35};
        OUI_Bg_Floating_Overlay_Dark = r115;
        OUI_Bg_Overlay_Search_Frost_Light = r32;
        OUI_Bg_Overlay_Search_Frost_Dark = r33;
        OUI_Bg_Overlay_Search_Fluid_Light = r34;
        OUI_Bg_Overlay_Search_Fluid_Dark = r35;
        OUI_Bg_Overlay_Search_Light = r36;
        OUI_Bg_Overlay_Search_Dark = r115;
        MaterialConfig r37 = new MaterialConfig(null, BlendConfigStateList.ofWithOverlay(BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Dark, BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Dark, BlendTokenCore.OUI_Color_State_Press_Dark), null, null, StrokeTokenCore.OUI_Effect_Stroke_Thin_Dark, null, null, r7, ShadowTokenCore.Oui_Shadow_Thick, null);
        OUI_Bg_Popup_Overlay_Frost_Light = r37;
        MaterialConfig r38 = new MaterialConfig(null, BlendConfigStateList.ofWithOverlay(BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Dark, BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Dark, BlendTokenCore.OUI_Color_State_Press_Dark), null, null, StrokeTokenCore.OUI_Effect_Stroke_Thin_Dark, null, null, r7, ShadowTokenCore.Oui_Shadow_Thick, null);
        OUI_Bg_Popup_Overlay_Frost_Dark = r38;
        MaterialConfig r39 = new MaterialConfig(null, BlendConfigStateList.ofWithOverlay(BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_State_Press_Dark), null, null, null, null, null, r7, ShadowTokenCore.Oui_Shadow_Thick, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Popup_Overlay_Fluid_Light = r39;
        MaterialConfig r40 = new MaterialConfig(null, BlendConfigStateList.ofWithOverlay(BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_State_Press_Dark), null, null, null, null, null, r7, ShadowTokenCore.Oui_Shadow_Thick, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Popup_Overlay_Fluid_Dark = r40;
        OUI_Bg_Popup_Overlay_Light = new MaterialConfig[]{r37, r39};
        OUI_Bg_Popup_Overlay_Dark = new MaterialConfig[]{r38, r40};
        MaterialConfig r41 = new MaterialConfig(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Fill_Tinted_Light, null, StrokeTokenCore.OUI_Effect_Stroke_Tinted_Light, null, null, r24, ShadowTokenCore.Oui_Shadow_Regular, null);
        OUI_Bg_Floating_Frost_Tinted_Light = r41;
        MaterialConfig r42 = new MaterialConfig(ColorStateList.valueOf(-16777216), null, BlendTokenCore.OUI_Color_Blend_Fill_Tinted_Dark, null, StrokeTokenCore.OUI_Effect_Stroke_Tinted_Dark, null, null, r24, ShadowTokenCore.Oui_Shadow_Regular, null);
        OUI_Bg_Floating_Frost_Tinted_Dark = r42;
        MaterialConfig r43 = new MaterialConfig(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Fill_Tinted_Light, null, null, null, null, r3, ShadowTokenCore.Oui_Shadow_Regular, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Floating_Fluid_Tinted_Light = r43;
        MaterialConfig r44 = new MaterialConfig(ColorStateList.valueOf(-16777216), null, BlendTokenCore.OUI_Color_Blend_Fill_Tinted_Dark, null, null, null, null, r3, ShadowTokenCore.Oui_Shadow_Regular, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Floating_Fluid_Tinted_Dark = r44;
        OUI_Bg_Floating_Tinted_Light = new MaterialConfig[]{r41, r43};
        OUI_Bg_Floating_Tinted_Dark = new MaterialConfig[]{r42, r44};
        MaterialConfig r45 = new MaterialConfig(ColorStateList.valueOf(-15895809), null, BlendTokenCore.OUI_Color_Blend_Blue_Regular_Light, null, StrokeTokenCore.OUI_Effect_Stroke_Blue_Regular_Light, null, null, r24, ShadowTokenCore.Oui_Shadow_Regular, null);
        OUI_Bg_Floating_Frost_Blue_Light = r45;
        MaterialConfig r46 = new MaterialConfig(ColorStateList.valueOf(-16087553), null, BlendTokenCore.OUI_Color_Blend_Blue_Regular_Dark, null, StrokeTokenCore.OUI_Effect_Stroke_Blue_Regular_Dark, null, null, r24, ShadowTokenCore.Oui_Shadow_Regular, null);
        OUI_Bg_Floating_Frost_Blue_Dark = r46;
        MaterialConfig r47 = new MaterialConfig(ColorStateList.valueOf(-15895809), null, BlendTokenCore.OUI_Color_Blend_Blue_Regular_Light, null, null, null, null, r3, ShadowTokenCore.Oui_Shadow_Regular, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Floating_Fluid_Blue_Light = r47;
        MaterialConfig r48 = new MaterialConfig(ColorStateList.valueOf(-16087553), null, BlendTokenCore.OUI_Color_Blend_Blue_Regular_Dark, null, null, null, null, r3, ShadowTokenCore.Oui_Shadow_Regular, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Floating_Fluid_Blue_Dark = r48;
        OUI_Bg_Floating_Blue_Light = new MaterialConfig[]{r45, r47};
        OUI_Bg_Floating_Blue_Dark = new MaterialConfig[]{r46, r48};
        OUI_Text_Primary_Light = new MaterialConfig(null, null, BlendTokenCore.OUI_Color_Blend_Text_Primary_Light, null, null, null, null, null, null, null);
        OUI_Text_Primary_Dark = new MaterialConfig(null, null, BlendTokenCore.OUI_Color_Blend_Text_Primary_Dark, null, null, null, null, null, null, null);
        OUI_Text_Secondary_Light = new MaterialConfig(null, null, BlendTokenCore.OUI_Color_Blend_Text_Secondary_Light, null, null, null, null, null, null, null);
        OUI_Text_Secondary_Dark = new MaterialConfig(null, null, BlendTokenCore.OUI_Color_Blend_Text_Secondary_Dark, null, null, null, null, null, null, null);
        OUI_Text_Tertiary_Light = new MaterialConfig(null, null, BlendTokenCore.OUI_Color_Blend_Text_Tertiary_Light, null, null, null, null, null, null, null);
        OUI_Text_Tertiary_Dark = new MaterialConfig(null, null, BlendTokenCore.OUI_Color_Blend_Text_Tertiary_Dark, null, null, null, null, null, null, null);
    }

    private MaterialTokenCore() {
    }

    public static void register(Object r1, Object r2, boolean r3) {
        TokenCoreParser.register(getTokens(r1), r2, MaterialConfig.class, r3);
    }

    public static void registerSet(Object r1, Object r2, boolean r3) {
        TokenCoreParser.register(getTokenSets(r1), r2, MaterialConfig[].class, r3);
    }

    public static void registerTokens(Object r0, Map<String, MaterialConfig> r1, boolean r2) {
        TokenCoreParser.registerTokens(getTokens(r0), r1, r2);
    }

    public static void registerTokenSets(Object r0, Map<String, MaterialConfig[]> r1, boolean r2) {
        TokenCoreParser.registerTokens(getTokenSets(r0), r1, r2);
    }

    public static MaterialConfig parse(Object r1, String r2, boolean r3) {
        MaterialConfig r0 = (MaterialConfig) TokenCoreParser.parse(r2, getTokens(r1));
        if (r0 != null) goto L10;
        StringBuilder r4 = new StringBuilder().append(r2);
        if (r3 == false) goto L7;
        String r5 = "_light";
    L9:
        return (MaterialConfig) TokenCoreParser.parse(r4.append(r5).toString(), getTokens(r1));
    L7:
        r5 = "_dark";
        goto L9
    L10:
        return r0;
    }

    public static MaterialConfig[] parseSet(Object r2, String r3, boolean r4) {
        MaterialConfig[] r0 = (MaterialConfig[]) TokenCoreParser.parse(r3, getTokenSets(r2));
        if (r0 != null) goto L9;
        StringBuilder r1 = new StringBuilder().append(r3);
        if (r4 == false) goto L7;
        String r5 = "_light";
    L8:
        r0 = (MaterialConfig[]) TokenCoreParser.parse(r1.append(r5).toString(), getTokenSets(r2));
        goto L9
    L7:
        r5 = "_dark";
    L9:
        if (r0 != null) goto L14;
        MaterialConfig r6 = parse(r2, r3, r4);
        if (r6 != null) goto L13;
        return r0;
    L13:
        return new MaterialConfig[]{r6};
    L14:
        return r0;
    }

    private static ConcurrentHashMap<String, MaterialConfig> getTokens(Object r2) {
        ConcurrentHashMap<String, MaterialConfig> r0 = tokens;
        if (r0 == null) goto L5;
    L14:
        return r0;
    L5:
        monitor-enter(MaterialTokenCore.class);
        r0 = tokens;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        ConcurrentHashMap<String, MaterialConfig> r3 = TokenCoreParser.createTokenMap(r2, MaterialConfig.class);     // Catch: Throwable -> L11
        tokens = r3;     // Catch: Throwable -> L11
        r0 = r3;
    L9:
        monitor-exit(MaterialTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private static ConcurrentHashMap<String, MaterialConfig[]> getTokenSets(Object r2) {
        ConcurrentHashMap<String, MaterialConfig[]> r0 = tokenSets;
        if (r0 == null) goto L5;
    L14:
        return r0;
    L5:
        monitor-enter(MaterialTokenCore.class);
        r0 = tokenSets;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        ConcurrentHashMap<String, MaterialConfig[]> r3 = TokenCoreParser.createTokenMap(r2, MaterialConfig[].class);     // Catch: Throwable -> L11
        tokenSets = r3;     // Catch: Throwable -> L11
        r0 = r3;
    L9:
        monitor-exit(MaterialTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
