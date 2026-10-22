package com.obric.oui.material;

import android.content.res.ColorStateList;
import com.obric.oui.blur.BlurTokenCore;
import com.obric.oui.color.BlendConfigCore;
import com.obric.oui.color.BlendTokenCore;
import com.obric.oui.color.StrokeConfigCore;
import com.obric.oui.color.StrokeTokenCore;
import com.obric.oui.fluid.FluidTokenCore;
import com.obric.oui.res.BlendConfigStateListCore;
import com.obric.oui.shadow.ShadowTokenCore;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class MaterialTokenCore {
    public static final MaterialConfigCore[] OUI_Bg_Floating_Blue_Dark = null;
    public static final MaterialConfigCore[] OUI_Bg_Floating_Blue_Light = null;
    public static final MaterialConfigCore[] OUI_Bg_Floating_Dark = null;
    public static final MaterialConfigCore[] OUI_Bg_Floating_Fill_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Floating_Fill_Fluid_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Floating_Fill_Fluid_Light = null;
    public static final MaterialConfigCore OUI_Bg_Floating_Fill_Frost_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Floating_Fill_Frost_Light = null;
    public static final MaterialConfigCore[] OUI_Bg_Floating_Fill_Light = null;
    public static final MaterialConfigCore OUI_Bg_Floating_Fluid_Blue_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Floating_Fluid_Blue_Light = null;
    public static final MaterialConfigCore OUI_Bg_Floating_Fluid_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Floating_Fluid_Light = null;
    public static final MaterialConfigCore OUI_Bg_Floating_Fluid_Tinted_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Floating_Fluid_Tinted_Light = null;
    public static final MaterialConfigCore OUI_Bg_Floating_Frost_Blue_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Floating_Frost_Blue_Light = null;
    public static final MaterialConfigCore OUI_Bg_Floating_Frost_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Floating_Frost_Light = null;
    public static final MaterialConfigCore OUI_Bg_Floating_Frost_Tinted_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Floating_Frost_Tinted_Light = null;
    public static final MaterialConfigCore[] OUI_Bg_Floating_Light = null;
    public static final MaterialConfigCore[] OUI_Bg_Floating_OnImage_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Floating_OnImage_Fluid_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Floating_OnImage_Fluid_Light = null;
    public static final MaterialConfigCore OUI_Bg_Floating_OnImage_Frost_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Floating_OnImage_Frost_Light = null;
    public static final MaterialConfigCore[] OUI_Bg_Floating_OnImage_Light = null;
    public static final MaterialConfigCore[] OUI_Bg_Floating_Overlay_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Floating_Overlay_Fluid_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Floating_Overlay_Fluid_Light = null;
    public static final MaterialConfigCore OUI_Bg_Floating_Overlay_Frost_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Floating_Overlay_Frost_Light = null;
    public static final MaterialConfigCore[] OUI_Bg_Floating_Overlay_Light = null;
    public static final MaterialConfigCore[] OUI_Bg_Floating_Tinted_Dark = null;
    public static final MaterialConfigCore[] OUI_Bg_Floating_Tinted_Light = null;
    public static final MaterialConfigCore[] OUI_Bg_Modal_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Modal_Fluid_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Modal_Fluid_Light = null;
    public static final MaterialConfigCore OUI_Bg_Modal_Frost_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Modal_Frost_Light = null;
    public static final MaterialConfigCore[] OUI_Bg_Modal_Light = null;

    @Deprecated
    public static final MaterialConfigCore[] OUI_Bg_Overlay_Search_Dark = null;

    @Deprecated
    public static final MaterialConfigCore OUI_Bg_Overlay_Search_Fluid_Dark = null;

    @Deprecated
    public static final MaterialConfigCore OUI_Bg_Overlay_Search_Fluid_Light = null;

    @Deprecated
    public static final MaterialConfigCore OUI_Bg_Overlay_Search_Frost_Dark = null;

    @Deprecated
    public static final MaterialConfigCore OUI_Bg_Overlay_Search_Frost_Light = null;

    @Deprecated
    public static final MaterialConfigCore[] OUI_Bg_Overlay_Search_Light = null;
    public static final MaterialConfigCore[] OUI_Bg_Popup_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Popup_Fluid_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Popup_Fluid_Light = null;
    public static final MaterialConfigCore OUI_Bg_Popup_Frost_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Popup_Frost_Light = null;
    public static final MaterialConfigCore[] OUI_Bg_Popup_Light = null;
    public static final MaterialConfigCore[] OUI_Bg_Popup_OnImage_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Popup_OnImage_Fluid_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Popup_OnImage_Fluid_Light = null;
    public static final MaterialConfigCore OUI_Bg_Popup_OnImage_Frost_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Popup_OnImage_Frost_Light = null;
    public static final MaterialConfigCore[] OUI_Bg_Popup_OnImage_Light = null;
    public static final MaterialConfigCore[] OUI_Bg_Popup_Overlay_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Popup_Overlay_Fluid_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Popup_Overlay_Fluid_Light = null;
    public static final MaterialConfigCore OUI_Bg_Popup_Overlay_Frost_Dark = null;
    public static final MaterialConfigCore OUI_Bg_Popup_Overlay_Frost_Light = null;
    public static final MaterialConfigCore[] OUI_Bg_Popup_Overlay_Light = null;
    public static final MaterialConfigCore OUI_Text_Primary_Dark = null;
    public static final MaterialConfigCore OUI_Text_Primary_Light = null;
    public static final MaterialConfigCore OUI_Text_Secondary_Dark = null;
    public static final MaterialConfigCore OUI_Text_Secondary_Light = null;
    public static final MaterialConfigCore OUI_Text_Tertiary_Dark = null;
    public static final MaterialConfigCore OUI_Text_Tertiary_Light = null;
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
    private static volatile ConcurrentHashMap<String, MaterialConfigCore[]> tokenSets;
    private static volatile ConcurrentHashMap<String, MaterialConfigCore> tokens;

    static {
        ColorStateList r1 = ColorStateList.valueOf(-1);
        BlendConfigStateListCore r2 = BlendConfigStateListCore.ofWithOverlay(BlendTokenCore.OUI_Color_Blend_Frost_Regular_Light, BlendTokenCore.OUI_Color_Blend_Frost_Regular_Light, BlendTokenCore.OUI_Color_State_Press_Light, BlendConfigCore.TRANSPARENT, BlendConfigCore.TRANSPARENT, BlendConfigCore.TRANSPARENT);
        StrokeConfigCore r5 = StrokeTokenCore.OUI_Effect_Stroke_Regular_Light;
        Float r24 = Float.valueOf(8.0f);
        MaterialConfigCore r11 = new MaterialConfigCore(r1, r2, null, null, r5, null, null, r24, ShadowTokenCore.Oui_Shadow_Regular, null);
        OUI_Bg_Floating_Frost_Light = r11;
        MaterialConfigCore r0 = new MaterialConfigCore(ColorStateList.valueOf(-13421773), BlendConfigStateListCore.ofWithOverlay(BlendTokenCore.OUI_Color_Blend_Frost_Regular_Dark, BlendTokenCore.OUI_Color_Blend_Frost_Regular_Dark, BlendTokenCore.OUI_Color_State_Press_Dark, BlendConfigCore.TRANSPARENT, BlendConfigCore.TRANSPARENT, BlendConfigCore.TRANSPARENT), null, null, StrokeTokenCore.OUI_Effect_Stroke_Regular_Dark, null, null, r24, ShadowTokenCore.Oui_Shadow_Regular, null);
        OUI_Bg_Floating_Frost_Dark = r0;
        MaterialConfigCore r3 = new MaterialConfigCore(ColorStateList.valueOf(-1), BlendConfigStateListCore.ofWithOverlay(BlendTokenCore.OUI_Color_Blend_Fluid_Regular_Light, BlendTokenCore.OUI_Color_Blend_Fluid_Regular_Light, BlendTokenCore.OUI_Color_State_Press_Light, BlendConfigCore.TRANSPARENT, BlendConfigCore.TRANSPARENT, BlendConfigCore.TRANSPARENT), null, null, null, null, null, Float.valueOf(BlurTokenCore.Blur_UltraThin), ShadowTokenCore.Oui_Shadow_Regular, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Floating_Fluid_Light = r3;
        MaterialConfigCore r4 = new MaterialConfigCore(ColorStateList.valueOf(-13421773), BlendConfigStateListCore.ofWithOverlay(BlendTokenCore.OUI_Color_Blend_Fluid_Regular_Dark, BlendTokenCore.OUI_Color_Blend_Fluid_Regular_Dark, BlendTokenCore.OUI_Color_State_Press_Dark, BlendConfigCore.TRANSPARENT, BlendConfigCore.TRANSPARENT, BlendConfigCore.TRANSPARENT), null, null, null, null, null, Float.valueOf(BlurTokenCore.Blur_UltraThin), ShadowTokenCore.Oui_Shadow_Regular, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Floating_Fluid_Dark = r4;
        OUI_Bg_Floating_Light = new MaterialConfigCore[]{r11, r3};
        OUI_Bg_Floating_Dark = new MaterialConfigCore[]{r0, r4};
        ColorStateList r14 = ColorStateList.valueOf(-1);
        BlendConfigCore[] r16 = BlendTokenCore.OUI_Color_Blend_Frost_Thin_Light;
        StrokeConfigCore r18 = StrokeTokenCore.OUI_Effect_Stroke_Thin_Light;
        Float r6 = Float.valueOf(20.0f);
        MaterialConfigCore r7 = new MaterialConfigCore(r14, null, r16, null, r18, null, null, r6, ShadowTokenCore.Oui_Shadow_Thick, null);
        OUI_Bg_Floating_OnImage_Frost_Light = r7;
        MaterialConfigCore r8 = new MaterialConfigCore(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Frost_Thin_Dark, null, StrokeTokenCore.OUI_Effect_Stroke_Thin_Dark, null, null, r6, ShadowTokenCore.Oui_Shadow_Thick, null);
        OUI_Bg_Floating_OnImage_Frost_Dark = r8;
        MaterialConfigCore r9 = new MaterialConfigCore(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Fluid_Thin_Light, null, null, null, null, r24, ShadowTokenCore.Oui_Shadow_Thick, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Floating_OnImage_Fluid_Light = r9;
        MaterialConfigCore r10 = new MaterialConfigCore(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Fluid_Thin_Dark, null, null, null, null, r24, ShadowTokenCore.Oui_Shadow_Thick, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Floating_OnImage_Fluid_Dark = r10;
        OUI_Bg_Floating_OnImage_Light = new MaterialConfigCore[]{r7, r9};
        OUI_Bg_Floating_OnImage_Dark = new MaterialConfigCore[]{r8, r10};
        MaterialConfigCore r12 = new MaterialConfigCore(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Fills_Thick_Light, null, null, null, null, r24, null, null);
        OUI_Bg_Floating_Fill_Frost_Light = r12;
        MaterialConfigCore r13 = new MaterialConfigCore(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Fills_Thick_Dark, null, null, null, null, r24, null, null);
        OUI_Bg_Floating_Fill_Frost_Dark = r13;
        OUI_Bg_Floating_Fill_Fluid_Light = new MaterialConfigCore(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Fills_Thick_Light, null, null, null, null, r24, null, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Floating_Fill_Fluid_Dark = new MaterialConfigCore(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Fills_Thick_Dark, null, null, null, null, r24, null, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Floating_Fill_Light = new MaterialConfigCore[]{r12};
        OUI_Bg_Floating_Fill_Dark = new MaterialConfigCore[]{r13};
        MaterialConfigCore r15 = new MaterialConfigCore(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Frost_Regular_Light, null, StrokeTokenCore.OUI_Effect_Stroke_Regular_Light, null, null, r6, ShadowTokenCore.Oui_Shadow_Thick, null);
        OUI_Bg_Popup_Frost_Light = r15;
        MaterialConfigCore r17 = new MaterialConfigCore(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Frost_Regular_Dark, null, StrokeTokenCore.OUI_Effect_Stroke_Regular_Dark, null, null, r6, ShadowTokenCore.Oui_Shadow_Thick, null);
        OUI_Bg_Popup_Frost_Dark = r17;
        MaterialConfigCore r19 = new MaterialConfigCore(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Fluid_Regular_Light, null, null, null, null, r6, ShadowTokenCore.Oui_Shadow_Thick, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Popup_Fluid_Light = r19;
        MaterialConfigCore r20 = new MaterialConfigCore(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Fluid_Regular_Dark, null, null, null, null, r6, ShadowTokenCore.Oui_Shadow_Thick, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Popup_Fluid_Dark = r20;
        OUI_Bg_Popup_Light = new MaterialConfigCore[]{r15, r19};
        OUI_Bg_Popup_Dark = new MaterialConfigCore[]{r17, r20};
        ColorStateList r110 = ColorStateList.valueOf(-1);
        BlendConfigCore[] r111 = BlendTokenCore.OUI_Color_Blend_Frost_Thin_Light;
        StrokeConfigCore r112 = StrokeTokenCore.OUI_Effect_Stroke_Thin_Light;
        Float r21 = Float.valueOf(32.0f);
        MaterialConfigCore r22 = new MaterialConfigCore(r110, null, r111, null, r112, null, null, r21, ShadowTokenCore.Oui_Shadow_UltraThick, null);
        OUI_Bg_Popup_OnImage_Frost_Light = r22;
        MaterialConfigCore r23 = new MaterialConfigCore(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Frost_Thin_Dark, null, StrokeTokenCore.OUI_Effect_Stroke_Thin_Dark, null, null, r21, ShadowTokenCore.Oui_Shadow_UltraThick, null);
        OUI_Bg_Popup_OnImage_Frost_Dark = r23;
        MaterialConfigCore r25 = new MaterialConfigCore(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Fluid_Thin_Light, null, null, null, null, r6, ShadowTokenCore.Oui_Shadow_UltraThick, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Popup_OnImage_Fluid_Light = r25;
        MaterialConfigCore r26 = new MaterialConfigCore(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Fluid_Thin_Dark, null, null, null, null, r6, ShadowTokenCore.Oui_Shadow_UltraThick, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Popup_OnImage_Fluid_Dark = r26;
        OUI_Bg_Popup_OnImage_Light = new MaterialConfigCore[]{r22, r25};
        OUI_Bg_Popup_OnImage_Dark = new MaterialConfigCore[]{r23, r26};
        MaterialConfigCore r27 = new MaterialConfigCore(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Frost_Thick_Light, null, StrokeTokenCore.OUI_Effect_Stroke_Thick_Light, null, null, r21, null, null);
        OUI_Bg_Modal_Frost_Light = r27;
        MaterialConfigCore r28 = new MaterialConfigCore(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Frost_Thick_Dark, null, StrokeTokenCore.OUI_Effect_Stroke_Thick_Dark, null, null, r21, null, null);
        OUI_Bg_Modal_Frost_Dark = r28;
        MaterialConfigCore r29 = new MaterialConfigCore(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Fluid_Thick_Light, null, null, null, null, r21, null, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Modal_Fluid_Light = r29;
        MaterialConfigCore r30 = new MaterialConfigCore(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Fluid_Thick_Dark, null, null, null, null, r21, null, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Modal_Fluid_Dark = r30;
        OUI_Bg_Modal_Light = new MaterialConfigCore[]{r27, r29};
        OUI_Bg_Modal_Dark = new MaterialConfigCore[]{r28, r30};
        MaterialConfigCore r31 = new MaterialConfigCore(null, BlendConfigStateListCore.ofWithOverlay(BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Light, BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Light, BlendTokenCore.OUI_Color_State_Press_Light, BlendConfigCore.TRANSPARENT, BlendConfigCore.TRANSPARENT, BlendConfigCore.TRANSPARENT), null, null, StrokeTokenCore.OUI_Effect_Stroke_Thin_Light, null, null, r24, null, null);
        OUI_Bg_Floating_Overlay_Frost_Light = r31;
        MaterialConfigCore r32 = new MaterialConfigCore(null, BlendConfigStateListCore.ofWithOverlay(BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Dark, BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Dark, BlendTokenCore.OUI_Color_State_Press_Dark, BlendConfigCore.TRANSPARENT, BlendConfigCore.TRANSPARENT, BlendConfigCore.TRANSPARENT), null, null, StrokeTokenCore.OUI_Effect_Stroke_Thin_Dark, null, null, r24, null, null);
        OUI_Bg_Floating_Overlay_Frost_Dark = r32;
        MaterialConfigCore r33 = new MaterialConfigCore(null, BlendConfigStateListCore.ofWithOverlay(BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Light, BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Light, BlendTokenCore.OUI_Color_State_Press_Light, BlendConfigCore.TRANSPARENT, BlendConfigCore.TRANSPARENT, BlendConfigCore.TRANSPARENT), null, null, null, null, null, r24, null, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Floating_Overlay_Fluid_Light = r33;
        MaterialConfigCore r34 = new MaterialConfigCore(null, BlendConfigStateListCore.ofWithOverlay(BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_State_Press_Dark, BlendConfigCore.TRANSPARENT, BlendConfigCore.TRANSPARENT, BlendConfigCore.TRANSPARENT), null, null, null, null, null, r24, null, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Floating_Overlay_Fluid_Dark = r34;
        MaterialConfigCore[] r35 = {r31, r33};
        OUI_Bg_Floating_Overlay_Light = r35;
        MaterialConfigCore[] r36 = {r32, r34};
        OUI_Bg_Floating_Overlay_Dark = r36;
        OUI_Bg_Overlay_Search_Frost_Light = r31;
        OUI_Bg_Overlay_Search_Frost_Dark = r32;
        OUI_Bg_Overlay_Search_Fluid_Light = r33;
        OUI_Bg_Overlay_Search_Fluid_Dark = r34;
        OUI_Bg_Overlay_Search_Light = r35;
        OUI_Bg_Overlay_Search_Dark = r36;
        MaterialConfigCore r37 = new MaterialConfigCore(null, BlendConfigStateListCore.ofWithOverlay(BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Dark, BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Dark, BlendTokenCore.OUI_Color_State_Press_Dark), null, null, StrokeTokenCore.OUI_Effect_Stroke_Thin_Dark, null, null, r6, ShadowTokenCore.Oui_Shadow_Thick, null);
        OUI_Bg_Popup_Overlay_Frost_Light = r37;
        MaterialConfigCore r38 = new MaterialConfigCore(null, BlendConfigStateListCore.ofWithOverlay(BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Dark, BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Dark, BlendTokenCore.OUI_Color_State_Press_Dark), null, null, StrokeTokenCore.OUI_Effect_Stroke_Thin_Dark, null, null, r6, ShadowTokenCore.Oui_Shadow_Thick, null);
        OUI_Bg_Popup_Overlay_Frost_Dark = r38;
        MaterialConfigCore r39 = new MaterialConfigCore(null, BlendConfigStateListCore.ofWithOverlay(BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_State_Press_Dark), null, null, null, null, null, r6, ShadowTokenCore.Oui_Shadow_Thick, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Popup_Overlay_Fluid_Light = r39;
        MaterialConfigCore r40 = new MaterialConfigCore(null, BlendConfigStateListCore.ofWithOverlay(BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_State_Press_Dark), null, null, null, null, null, r6, ShadowTokenCore.Oui_Shadow_Thick, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Popup_Overlay_Fluid_Dark = r40;
        OUI_Bg_Popup_Overlay_Light = new MaterialConfigCore[]{r37, r39};
        OUI_Bg_Popup_Overlay_Dark = new MaterialConfigCore[]{r38, r40};
        MaterialConfigCore r41 = new MaterialConfigCore(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Fill_Tinted_Light, null, StrokeTokenCore.OUI_Effect_Stroke_Tinted_Light, null, null, r24, ShadowTokenCore.Oui_Shadow_Regular, null);
        OUI_Bg_Floating_Frost_Tinted_Light = r41;
        MaterialConfigCore r42 = new MaterialConfigCore(ColorStateList.valueOf(-16777216), null, BlendTokenCore.OUI_Color_Blend_Fill_Tinted_Dark, null, StrokeTokenCore.OUI_Effect_Stroke_Tinted_Dark, null, null, r24, ShadowTokenCore.Oui_Shadow_Regular, null);
        OUI_Bg_Floating_Frost_Tinted_Dark = r42;
        MaterialConfigCore r43 = new MaterialConfigCore(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Fill_Tinted_Light, null, null, null, null, Float.valueOf(BlurTokenCore.Blur_UltraThin), ShadowTokenCore.Oui_Shadow_Regular, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Floating_Fluid_Tinted_Light = r43;
        MaterialConfigCore r44 = new MaterialConfigCore(ColorStateList.valueOf(-16777216), null, BlendTokenCore.OUI_Color_Blend_Fill_Tinted_Dark, null, null, null, null, Float.valueOf(BlurTokenCore.Blur_UltraThin), ShadowTokenCore.Oui_Shadow_Regular, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Floating_Fluid_Tinted_Dark = r44;
        OUI_Bg_Floating_Tinted_Light = new MaterialConfigCore[]{r41, r43};
        OUI_Bg_Floating_Tinted_Dark = new MaterialConfigCore[]{r42, r44};
        MaterialConfigCore r45 = new MaterialConfigCore(ColorStateList.valueOf(-15895809), null, BlendTokenCore.OUI_Color_Blend_Blue_Regular_Light, null, StrokeTokenCore.OUI_Effect_Stroke_Blue_Regular_Light, null, null, r24, ShadowTokenCore.Oui_Shadow_Regular, null);
        OUI_Bg_Floating_Frost_Blue_Light = r45;
        MaterialConfigCore r46 = new MaterialConfigCore(ColorStateList.valueOf(-16087553), null, BlendTokenCore.OUI_Color_Blend_Blue_Regular_Dark, null, StrokeTokenCore.OUI_Effect_Stroke_Blue_Regular_Dark, null, null, r24, ShadowTokenCore.Oui_Shadow_Regular, null);
        OUI_Bg_Floating_Frost_Blue_Dark = r46;
        MaterialConfigCore r47 = new MaterialConfigCore(ColorStateList.valueOf(-15895809), null, BlendTokenCore.OUI_Color_Blend_Blue_Regular_Light, null, null, null, null, Float.valueOf(BlurTokenCore.Blur_UltraThin), ShadowTokenCore.Oui_Shadow_Regular, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Floating_Fluid_Blue_Light = r47;
        MaterialConfigCore r48 = new MaterialConfigCore(ColorStateList.valueOf(-16087553), null, BlendTokenCore.OUI_Color_Blend_Blue_Regular_Dark, null, null, null, null, Float.valueOf(BlurTokenCore.Blur_UltraThin), ShadowTokenCore.Oui_Shadow_Regular, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Floating_Fluid_Blue_Dark = r48;
        OUI_Bg_Floating_Blue_Light = new MaterialConfigCore[]{r45, r47};
        OUI_Bg_Floating_Blue_Dark = new MaterialConfigCore[]{r46, r48};
        OUI_Text_Primary_Light = new MaterialConfigCore(null, null, BlendTokenCore.OUI_Color_Blend_Text_Primary_Light, null, null, null, null, null, null, null);
        OUI_Text_Primary_Dark = new MaterialConfigCore(null, null, BlendTokenCore.OUI_Color_Blend_Text_Primary_Dark, null, null, null, null, null, null, null);
        OUI_Text_Secondary_Light = new MaterialConfigCore(null, null, BlendTokenCore.OUI_Color_Blend_Text_Secondary_Light, null, null, null, null, null, null, null);
        OUI_Text_Secondary_Dark = new MaterialConfigCore(null, null, BlendTokenCore.OUI_Color_Blend_Text_Secondary_Dark, null, null, null, null, null, null, null);
        OUI_Text_Tertiary_Light = new MaterialConfigCore(null, null, BlendTokenCore.OUI_Color_Blend_Text_Tertiary_Light, null, null, null, null, null, null, null);
        OUI_Text_Tertiary_Dark = new MaterialConfigCore(null, null, BlendTokenCore.OUI_Color_Blend_Text_Tertiary_Dark, null, null, null, null, null, null, null);
    }

    private MaterialTokenCore() {
    }

    public static void register(Object r1, Object r2, boolean r3) {
        TokenParserCore.register(getTokens(r1), r2, MaterialConfigCore.class, r3);
    }

    public static void registerSet(Object r1, Object r2, boolean r3) {
        TokenParserCore.register(getTokenSets(r1), r2, MaterialConfigCore[].class, r3);
    }

    public static void registerTokens(Object r0, Map<String, MaterialConfigCore> r1, boolean r2) {
        TokenParserCore.registerTokens(getTokens(r0), r1, r2);
    }

    public static void registerTokenSets(Object r0, Map<String, MaterialConfigCore[]> r1, boolean r2) {
        TokenParserCore.registerTokens(getTokenSets(r0), r1, r2);
    }

    public static MaterialConfigCore parse(Object r1, String r2, boolean r3) {
        MaterialConfigCore r0 = (MaterialConfigCore) TokenParserCore.parse(r2, getTokens(r1));
        if (r0 != null) goto L10;
        StringBuilder r4 = new StringBuilder().append(r2);
        if (r3 == false) goto L7;
        String r5 = "_light";
    L9:
        return (MaterialConfigCore) TokenParserCore.parse(r4.append(r5).toString(), getTokens(r1));
    L7:
        r5 = "_dark";
        goto L9
    L10:
        return r0;
    }

    public static MaterialConfigCore[] parseSet(Object r2, String r3, boolean r4) {
        MaterialConfigCore[] r0 = (MaterialConfigCore[]) TokenParserCore.parse(r3, getTokenSets(r2));
        if (r0 != null) goto L9;
        StringBuilder r1 = new StringBuilder().append(r3);
        if (r4 == false) goto L7;
        String r5 = "_light";
    L8:
        r0 = (MaterialConfigCore[]) TokenParserCore.parse(r1.append(r5).toString(), getTokenSets(r2));
        goto L9
    L7:
        r5 = "_dark";
    L9:
        if (r0 != null) goto L14;
        MaterialConfigCore r6 = parse(r2, r3, r4);
        if (r6 != null) goto L13;
        return r0;
    L13:
        return new MaterialConfigCore[]{r6};
    L14:
        return r0;
    }

    private static ConcurrentHashMap<String, MaterialConfigCore> getTokens(Object r2) {
        ConcurrentHashMap<String, MaterialConfigCore> r3 = tokens;
        if (r3 == null) goto L5;
    L14:
        return r3;
    L5:
        monitor-enter(MaterialTokenCore.class);
        r3 = tokens;     // Catch: Throwable -> L11
        if (r3 != null) goto L9;
        r3 = TokenParserCore.createTokenMap(MaterialTokenCore.class, MaterialConfigCore.class);     // Catch: Throwable -> L11
        tokens = r3;     // Catch: Throwable -> L11
    L9:
        monitor-exit(MaterialTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private static ConcurrentHashMap<String, MaterialConfigCore[]> getTokenSets(Object r2) {
        ConcurrentHashMap<String, MaterialConfigCore[]> r3 = tokenSets;
        if (r3 == null) goto L5;
    L14:
        return r3;
    L5:
        monitor-enter(MaterialTokenCore.class);
        r3 = tokenSets;     // Catch: Throwable -> L11
        if (r3 != null) goto L9;
        r3 = TokenParserCore.createTokenMap(MaterialTokenCore.class, MaterialConfigCore[].class);     // Catch: Throwable -> L11
        tokenSets = r3;     // Catch: Throwable -> L11
    L9:
        monitor-exit(MaterialTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
