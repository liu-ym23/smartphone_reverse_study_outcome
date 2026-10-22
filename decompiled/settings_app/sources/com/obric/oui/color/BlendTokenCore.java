package com.obric.oui.color;

import com.obric.oui.graphic.BlendMode;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.TokenParserCore;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class BlendTokenCore {
    public static final Function1<Boolean, BlendConfigCore[]> Blend_Base_Regular = null;
    public static final BlendConfigCore[] Blend_Base_Regular_Dark = null;
    public static final BlendConfigCore[] Blend_Base_Regular_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> Blend_Base_Thick = null;
    public static final BlendConfigCore[] Blend_Base_Thick_Dark = null;
    public static final BlendConfigCore[] Blend_Base_Thick_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> Blend_Blue_4 = null;
    public static final BlendConfigCore[] Blend_Blue_4_Dark = null;
    public static final BlendConfigCore[] Blend_Blue_4_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> Blend_Blue_6 = null;
    public static final BlendConfigCore[] Blend_Blue_6_Dark = null;
    public static final BlendConfigCore[] Blend_Blue_6_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> Blend_Fill_Element_2 = null;
    public static final BlendConfigCore[] Blend_Fill_Element_2_Dark = null;
    public static final BlendConfigCore[] Blend_Fill_Element_2_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> Blend_Fluid_Thin = null;
    public static final BlendConfigCore[] Blend_Fluid_Thin_Dark = null;
    public static final BlendConfigCore[] Blend_Fluid_Thin_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> Blend_Green_4 = null;
    public static final BlendConfigCore[] Blend_Green_4_Dark = null;
    public static final BlendConfigCore[] Blend_Green_4_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> Blend_Green_6 = null;
    public static final BlendConfigCore[] Blend_Green_6_Dark = null;
    public static final BlendConfigCore[] Blend_Green_6_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> Blend_Red_4 = null;
    public static final BlendConfigCore[] Blend_Red_4_Dark = null;
    public static final BlendConfigCore[] Blend_Red_4_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> Blend_Red_6 = null;
    public static final BlendConfigCore[] Blend_Red_6_Dark = null;
    public static final BlendConfigCore[] Blend_Red_6_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> Blend_Yellow_4 = null;
    public static final BlendConfigCore[] Blend_Yellow_4_Dark = null;
    public static final BlendConfigCore[] Blend_Yellow_4_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> Blend_Yellow_6 = null;
    public static final BlendConfigCore[] Blend_Yellow_6_Dark = null;
    public static final BlendConfigCore[] Blend_Yellow_6_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> OUI_Color_Blend_Blue_Regular = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Blue_Regular_Dark = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Blue_Regular_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> OUI_Color_Blend_Blue_Thin = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Blue_Thin_Dark = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Blue_Thin_Light = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Fill_Tinted_Dark = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Fill_Tinted_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> OUI_Color_Blend_Fluid_Regular = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Fluid_Regular_Dark = null;
    static final BlendConfigCore[] OUI_Color_Blend_Fluid_Regular_Dark_V1 = null;
    static final BlendConfigCore[] OUI_Color_Blend_Fluid_Regular_Dark_V2 = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Fluid_Regular_Light = null;
    static final BlendConfigCore[] OUI_Color_Blend_Fluid_Regular_Light_V1 = null;
    static final BlendConfigCore[] OUI_Color_Blend_Fluid_Regular_Light_V2 = null;
    public static final Function1<Boolean, BlendConfigCore[]> OUI_Color_Blend_Fluid_Thick = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Fluid_Thick_Dark = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Fluid_Thick_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> OUI_Color_Blend_Fluid_Thin = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Fluid_Thin_Dark = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Fluid_Thin_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> OUI_Color_Blend_Fluid_UltraThin = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Fluid_UltraThin_Dark = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Fluid_UltraThin_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> OUI_Color_Blend_Frost_Regular = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Frost_Regular_Dark = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Frost_Regular_Light = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Frost_Thick_Dark = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Frost_Thick_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> OUI_Color_Blend_Frost_Thin = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Frost_Thin_Dark = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Frost_Thin_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> OUI_Color_Blend_Frost_UltraThin = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Frost_UltraThin_Dark = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Frost_UltraThin_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> OUI_Color_Blend_Green_Regular = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Green_Regular_Dark = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Green_Regular_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> OUI_Color_Blend_Green_Thin = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Green_Thin_Dark = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Green_Thin_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> OUI_Color_Blend_Red_Regular = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Red_Regular_Dark = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Red_Regular_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> OUI_Color_Blend_Red_Thin = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Red_Thin_Dark = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Red_Thin_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> OUI_Color_Blend_Text_Primary = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Text_Primary_Dark = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Text_Primary_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> OUI_Color_Blend_Text_Secondary = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Text_Secondary_Dark = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Text_Secondary_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> OUI_Color_Blend_Text_Tertiary = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Text_Tertiary_Dark = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Text_Tertiary_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> OUI_Color_Blend_Yellow_Regular = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Yellow_Regular_Dark = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Yellow_Regular_Light = null;
    public static final Function1<Boolean, BlendConfigCore[]> OUI_Color_Blend_Yellow_Thin = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Yellow_Thin_Dark = null;
    public static final BlendConfigCore[] OUI_Color_Blend_Yellow_Thin_Light = null;
    public static final BlendConfigCore[] OUI_Color_Fills_Thick_Dark = null;
    public static final BlendConfigCore[] OUI_Color_Fills_Thick_Light = null;
    public static final BlendConfigCore OUI_Color_State_Active_Dark = null;
    public static final BlendConfigCore OUI_Color_State_Active_Light = null;
    public static final BlendConfigCore OUI_Color_State_Press_Dark = null;
    public static final BlendConfigCore OUI_Color_State_Press_Light = null;
    private static volatile ConcurrentHashMap<String, Function1<Boolean, BlendConfigCore[]>> providers;
    private static volatile ConcurrentHashMap<String, BlendConfigCore[]> tokens;

    static {
        Blend_Base_Thick_Light = new BlendConfigCore[]{new BlendConfigCore(-1726013665, BlendMode.COLOR_DODGE), new BlendConfigCore(-604571914, BlendMode.SRC_OVER)};
        Blend_Base_Thick_Dark = new BlendConfigCore[]{new BlendConfigCore(-3355444, BlendMode.COLOR_BURN), new BlendConfigCore(-618388444, BlendMode.SRC_OVER)};
        Blend_Base_Thick = new BlendTokenCore$$ExternalSyntheticLambda0();
        Blend_Base_Regular_Light = new BlendConfigCore[]{new BlendConfigCore(-14737633, BlendMode.COLOR_DODGE), new BlendConfigCore(-855638017, BlendMode.SRC_OVER)};
        Blend_Base_Regular_Dark = new BlendConfigCore[]{new BlendConfigCore(-3355444, BlendMode.COLOR_BURN), new BlendConfigCore(-666746302, BlendMode.SRC_OVER)};
        Blend_Base_Regular = new BlendTokenCore$$ExternalSyntheticLambda2();
        OUI_Color_Blend_Frost_Regular_Light = new BlendConfigCore[]{new BlendConfigCore(-14737633, BlendMode.COLOR_DODGE), new BlendConfigCore(-855638017, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Frost_Regular_Dark = new BlendConfigCore[]{new BlendConfigCore(-3355444, BlendMode.COLOR_BURN), new BlendConfigCore(-868072894, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Frost_Regular = new BlendTokenCore$$ExternalSyntheticLambda14();
        BlendConfigCore[] r2 = {new BlendConfigCore(-1716342094, BlendMode.LUMINOSITY), new BlendConfigCore(-13421773, BlendMode.COLOR_DODGE), new BlendConfigCore(1626074091, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Regular_Light_V2 = r2;
        BlendConfigCore[] r6 = {new BlendConfigCore(-1718052712, BlendMode.LUMINOSITY), new BlendConfigCore(-860572492, BlendMode.COLOR_BURN), new BlendConfigCore(335544320, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Regular_Dark_V2 = r6;
        BlendConfigCore[] r9 = {new BlendConfigCore(869059788, BlendMode.LUMINOSITY), new BlendConfigCore(-1724697805, BlendMode.COLOR_DODGE), new BlendConfigCore(-1929379841, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Regular_Light_V1 = r9;
        BlendConfigCore[] r11 = {new BlendConfigCore(869059788, BlendMode.LUMINOSITY), new BlendConfigCore(-1714631476, BlendMode.COLOR_BURN), new BlendConfigCore(-1724697805, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Regular_Dark_V1 = r11;
        if (OMaterialHelper.getMaterialApiVersion() >= 4) goto L6;
        r2 = r9;
    L6:
        OUI_Color_Blend_Fluid_Regular_Light = r2;
        if (OMaterialHelper.getMaterialApiVersion() >= 4) goto L10;
        r6 = r11;
    L10:
        OUI_Color_Blend_Fluid_Regular_Dark = r6;
        OUI_Color_Blend_Fluid_Regular = new BlendTokenCore$$ExternalSyntheticLambda15();
        OUI_Color_Blend_Frost_UltraThin_Light = new BlendConfigCore[]{new BlendConfigCore(-14737633, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Frost_UltraThin_Dark = new BlendConfigCore[]{new BlendConfigCore(-14737633, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Frost_UltraThin = new BlendTokenCore$$ExternalSyntheticLambda16();
        OUI_Color_Blend_Fluid_UltraThin_Light = new BlendConfigCore[]{new BlendConfigCore(-15461356, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Fluid_UltraThin_Dark = new BlendConfigCore[]{new BlendConfigCore(-15461356, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Fluid_UltraThin = new BlendTokenCore$$ExternalSyntheticLambda17();
        OUI_Color_Blend_Frost_Thin_Light = new BlendConfigCore[]{new BlendConfigCore(1722329256, BlendMode.LUMINOSITY), new BlendConfigCore(-13421773, BlendMode.COLOR_DODGE), new BlendConfigCore(-1711276033, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Frost_Thin_Dark = new BlendConfigCore[]{new BlendConfigCore(-2137417319, BlendMode.LUMINOSITY)};
        OUI_Color_Blend_Frost_Thin = new BlendTokenCore$$ExternalSyntheticLambda18();
        OUI_Color_Blend_Fluid_Thin_Light = new BlendConfigCore[]{new BlendConfigCore(869059788, BlendMode.LUMINOSITY), new BlendConfigCore(-1724697805, BlendMode.COLOR_DODGE), new BlendConfigCore(352321535, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Thin_Dark = new BlendConfigCore[]{new BlendConfigCore(1721342361, BlendMode.LUMINOSITY)};
        OUI_Color_Blend_Fluid_Thin = new BlendTokenCore$$ExternalSyntheticLambda19();
        OUI_Color_Blend_Frost_Thick_Light = new BlendConfigCore[]{new BlendConfigCore(-1726013665, BlendMode.COLOR_DODGE), new BlendConfigCore(-604506121, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Frost_Thick_Dark = new BlendConfigCore[]{new BlendConfigCore(-3355444, BlendMode.COLOR_BURN), new BlendConfigCore(-618059479, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Thick_Light = new BlendConfigCore[]{new BlendConfigCore(-1726013665, BlendMode.COLOR_DODGE), new BlendConfigCore(-604506121, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Thick_Dark = new BlendConfigCore[]{new BlendConfigCore(-858993460, BlendMode.COLOR_BURN), new BlendConfigCore(-869717719, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Thick = new BlendTokenCore$$ExternalSyntheticLambda20();
        OUI_Color_Fills_Thick_Light = new BlendConfigCore[]{new BlendConfigCore(251658240, BlendMode.SRC_OVER)};
        OUI_Color_Fills_Thick_Dark = new BlendConfigCore[]{new BlendConfigCore(620756991, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Text_Primary_Light = new BlendConfigCore[]{new BlendConfigCore(-13421773, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Text_Primary_Dark = new BlendConfigCore[]{new BlendConfigCore(-2500135, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Text_Primary = new BlendTokenCore$$ExternalSyntheticLambda21();
        OUI_Color_Blend_Text_Secondary_Light = new BlendConfigCore[]{new BlendConfigCore(-6710887, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Text_Secondary_Dark = new BlendConfigCore[]{new BlendConfigCore(-9211021, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Text_Secondary = new BlendTokenCore$$ExternalSyntheticLambda11();
        OUI_Color_Blend_Text_Tertiary_Light = new BlendConfigCore[]{new BlendConfigCore(-4342339, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Text_Tertiary_Dark = new BlendConfigCore[]{new BlendConfigCore(-10921639, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Text_Tertiary = new BlendTokenCore$$ExternalSyntheticLambda22();
        OUI_Color_Blend_Fill_Tinted_Light = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-1, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Fill_Tinted_Dark = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-16777216, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Thin_Light = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-10049793, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Thin_Dark = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-10049793, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Thin = new BlendTokenCore$$ExternalSyntheticLambda23();
        OUI_Color_Blend_Blue_Regular_Light = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-14253569, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Regular_Dark = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-14253569, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Regular = new BlendTokenCore$$ExternalSyntheticLambda24();
        OUI_Color_Blend_Red_Thin_Light = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-30841, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Red_Thin_Dark = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-30841, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Red_Thin = new BlendTokenCore$$ExternalSyntheticLambda25();
        OUI_Color_Blend_Red_Regular_Light = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-45747, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Red_Regular_Dark = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-45747, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Red_Regular = new BlendTokenCore$$ExternalSyntheticLambda26();
        OUI_Color_Blend_Green_Thin_Light = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-8917601, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Green_Thin_Dark = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-8917601, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Green_Thin = new BlendTokenCore$$ExternalSyntheticLambda27();
        OUI_Color_Blend_Green_Regular_Light = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-15415472, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Green_Regular_Dark = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-15415472, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Green_Regular = new BlendTokenCore$$ExternalSyntheticLambda28();
        OUI_Color_Blend_Yellow_Thin_Light = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-11671, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Yellow_Thin_Dark = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-11671, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Yellow_Thin = new BlendTokenCore$$ExternalSyntheticLambda29();
        OUI_Color_Blend_Yellow_Regular_Light = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-15078, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Yellow_Regular_Dark = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-15078, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Yellow_Regular = new BlendTokenCore$$ExternalSyntheticLambda1();
        OUI_Color_State_Press_Light = new BlendConfigCore(-13421773, BlendMode.PLUS_LIGHTER);
        OUI_Color_State_Press_Dark = new BlendConfigCore(-1724697805, BlendMode.PLUS_LIGHTER);
        OUI_Color_State_Active_Light = new BlendConfigCore(-6710887, BlendMode.PLUS_LIGHTER);
        OUI_Color_State_Active_Dark = new BlendConfigCore(-6710887, BlendMode.PLUS_LIGHTER);
        Blend_Blue_6_Light = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-15042049, BlendMode.PLUS_DARKER)};
        Blend_Blue_6_Dark = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-15042049, BlendMode.PLUS_DARKER)};
        Blend_Blue_6 = new BlendTokenCore$$ExternalSyntheticLambda3();
        Blend_Blue_4_Light = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-10049793, BlendMode.PLUS_DARKER)};
        Blend_Blue_4_Dark = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-10049793, BlendMode.PLUS_DARKER)};
        Blend_Blue_4 = new BlendTokenCore$$ExternalSyntheticLambda4();
        Blend_Yellow_6_Light = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-873984, BlendMode.PLUS_DARKER)};
        Blend_Yellow_6_Dark = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-873984, BlendMode.PLUS_DARKER)};
        Blend_Yellow_6 = new BlendTokenCore$$ExternalSyntheticLambda5();
        Blend_Yellow_4_Light = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-11671, BlendMode.PLUS_DARKER)};
        Blend_Yellow_4_Dark = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-11671, BlendMode.PLUS_DARKER)};
        Blend_Yellow_4 = new BlendTokenCore$$ExternalSyntheticLambda6();
        Blend_Green_6_Light = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-16722873, BlendMode.PLUS_DARKER)};
        Blend_Green_6_Dark = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-16722873, BlendMode.PLUS_DARKER)};
        Blend_Green_6 = new BlendTokenCore$$ExternalSyntheticLambda7();
        Blend_Green_4_Light = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-8917601, BlendMode.PLUS_DARKER)};
        Blend_Green_4_Dark = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-8917601, BlendMode.PLUS_DARKER)};
        Blend_Green_4 = new BlendTokenCore$$ExternalSyntheticLambda8();
        Blend_Red_6_Light = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-53971, BlendMode.PLUS_DARKER)};
        Blend_Red_6_Dark = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-53971, BlendMode.PLUS_DARKER)};
        Blend_Red_6 = new BlendTokenCore$$ExternalSyntheticLambda9();
        Blend_Red_4_Light = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-30841, BlendMode.PLUS_DARKER)};
        Blend_Red_4_Dark = new BlendConfigCore[]{new BlendConfigCore(-2130706433, BlendMode.SRC_OVER), new BlendConfigCore(-3355444, BlendMode.OVERLAY), new BlendConfigCore(-30841, BlendMode.PLUS_DARKER)};
        Blend_Red_4 = new BlendTokenCore$$ExternalSyntheticLambda10();
        Blend_Fill_Element_2_Light = new BlendConfigCore[]{new BlendConfigCore(167772160, BlendMode.SRC_OVER)};
        Blend_Fill_Element_2_Dark = new BlendConfigCore[]{new BlendConfigCore(536870911, BlendMode.SRC_OVER)};
        Blend_Fill_Element_2 = new BlendTokenCore$$ExternalSyntheticLambda12();
        Blend_Fluid_Thin_Light = new BlendConfigCore[]{new BlendConfigCore(-13421773, BlendMode.COLOR_DODGE), new BlendConfigCore(1088018905, BlendMode.SRC_OVER)};
        Blend_Fluid_Thin_Dark = new BlendConfigCore[]{new BlendConfigCore(-13421773, BlendMode.COLOR_DODGE), new BlendConfigCore(1088018905, BlendMode.SRC_OVER)};
        Blend_Fluid_Thin = new BlendTokenCore$$ExternalSyntheticLambda13();
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$0(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Base_Thick_Light;
    L6:
        return Blend_Base_Thick_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$1(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Base_Regular_Light;
    L6:
        return Blend_Base_Regular_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$2(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Frost_Regular_Light;
    L6:
        return OUI_Color_Blend_Frost_Regular_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$3(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Fluid_Regular_Light;
    L6:
        return OUI_Color_Blend_Fluid_Regular_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$4(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Frost_UltraThin_Light;
    L6:
        return OUI_Color_Blend_Frost_UltraThin_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$5(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Fluid_UltraThin_Light;
    L6:
        return OUI_Color_Blend_Fluid_UltraThin_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$6(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Frost_Thin_Light;
    L6:
        return OUI_Color_Blend_Frost_Thin_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$7(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Fluid_Thin_Light;
    L6:
        return OUI_Color_Blend_Fluid_Thin_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$8(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Fluid_Thick_Light;
    L6:
        return OUI_Color_Blend_Fluid_Thick_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$9(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Text_Primary_Light;
    L6:
        return OUI_Color_Blend_Text_Primary_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$10(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Text_Secondary_Light;
    L6:
        return OUI_Color_Blend_Text_Secondary_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$11(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Text_Tertiary_Light;
    L6:
        return OUI_Color_Blend_Text_Tertiary_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$12(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Blue_Thin_Light;
    L6:
        return OUI_Color_Blend_Blue_Thin_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$13(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Blue_Regular_Light;
    L6:
        return OUI_Color_Blend_Blue_Regular_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$14(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Red_Thin_Light;
    L6:
        return OUI_Color_Blend_Red_Thin_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$15(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Red_Regular_Light;
    L6:
        return OUI_Color_Blend_Red_Regular_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$16(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Green_Thin_Light;
    L6:
        return OUI_Color_Blend_Green_Thin_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$17(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Green_Regular_Light;
    L6:
        return OUI_Color_Blend_Green_Regular_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$18(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Yellow_Thin_Light;
    L6:
        return OUI_Color_Blend_Yellow_Thin_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$19(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Yellow_Regular_Light;
    L6:
        return OUI_Color_Blend_Yellow_Regular_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$20(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Blue_6_Light;
    L6:
        return Blend_Blue_6_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$21(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Blue_4_Light;
    L6:
        return Blend_Blue_4_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$22(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Yellow_6_Light;
    L6:
        return Blend_Yellow_6_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$23(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Yellow_4_Light;
    L6:
        return Blend_Yellow_4_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$24(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Green_6_Light;
    L6:
        return Blend_Green_6_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$25(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Green_4_Light;
    L6:
        return Blend_Green_4_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$26(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Red_6_Light;
    L6:
        return Blend_Red_6_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$27(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Red_4_Light;
    L6:
        return Blend_Red_4_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$28(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Fill_Element_2_Light;
    L6:
        return Blend_Fill_Element_2_Dark;
    }

    static /* synthetic */ BlendConfigCore[] lambda$static$29(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Fluid_Thin_Light;
    L6:
        return Blend_Fluid_Thin_Dark;
    }

    private BlendTokenCore() {
    }

    public static void register(Object r1, Object r2, boolean r3) {
        TokenParserCore.register(getTokens(r1), r2, BlendConfigCore[].class, r3);
    }

    public static void registerTokens(Object r0, Map<String, BlendConfigCore[]> r1, boolean r2) {
        TokenParserCore.registerTokens(getTokens(r0), r1, r2);
    }

    public static void registerProvider(Object r1, Object r2, boolean r3) {
        TokenParserCore.register(getProviders(r1), r2, Function1.class, r3);
    }

    public static void registerProviderTokens(Object r0, Map<String, ? extends Function1<Boolean, BlendConfigCore[]>> r1, boolean r2) {
        TokenParserCore.registerTokens(getProviders(r0), r1, r2);
    }

    public static Function1<Boolean, BlendConfigCore[]> parseProvider(Object r0, String r1) {
        return (Function1) TokenParserCore.parse(r1, getProviders(r0));
    }

    public static BlendConfigCore[] parse(Object r1, String r2, boolean r3) {
        BlendConfigCore[] r0 = (BlendConfigCore[]) TokenParserCore.parse(r2, getTokens(r1));
        if (r0 != null) goto L10;
        StringBuilder r4 = new StringBuilder().append(r2);
        if (r3 == false) goto L7;
        String r5 = "_light";
    L9:
        return (BlendConfigCore[]) TokenParserCore.parse(r4.append(r5).toString(), getTokens(r1));
    L7:
        r5 = "_dark";
        goto L9
    L10:
        return r0;
    }

    private static ConcurrentHashMap<String, BlendConfigCore[]> getTokens(Object r2) {
        ConcurrentHashMap<String, BlendConfigCore[]> r3 = tokens;
        if (r3 == null) goto L5;
    L14:
        return r3;
    L5:
        monitor-enter(BlendTokenCore.class);
        r3 = tokens;     // Catch: Throwable -> L11
        if (r3 != null) goto L9;
        r3 = TokenParserCore.createTokenMap(BlendTokenCore.class, BlendConfigCore[].class);     // Catch: Throwable -> L11
        tokens = r3;     // Catch: Throwable -> L11
    L9:
        monitor-exit(BlendTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private static ConcurrentHashMap<String, Function1<Boolean, BlendConfigCore[]>> getProviders(Object r2) {
        ConcurrentHashMap<String, Function1<Boolean, BlendConfigCore[]>> r3 = providers;
        if (r3 == null) goto L5;
    L14:
        return r3;
    L5:
        monitor-enter(BlendTokenCore.class);
        r3 = providers;     // Catch: Throwable -> L11
        if (r3 != null) goto L9;
        r3 = TokenParserCore.createTokenMap(BlendTokenCore.class, Function1.class);     // Catch: Throwable -> L11
        providers = r3;     // Catch: Throwable -> L11
    L9:
        monitor-exit(BlendTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
