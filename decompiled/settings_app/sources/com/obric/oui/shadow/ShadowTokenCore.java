package com.obric.oui.shadow;

import android.text.TextUtils;
import com.android.vcard.VCardConfig;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.TokenParserCore;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class ShadowTokenCore {
    public static final ShadowConfigCore[] Oui_Shadow_Regular = null;
    static final ShadowConfigCore[] Oui_Shadow_Regular_V1 = null;
    static final ShadowConfigCore[] Oui_Shadow_Regular_V2 = null;
    public static final ShadowConfigCore[] Oui_Shadow_Text_Regular = null;
    public static final ShadowConfigCore[] Oui_Shadow_Thick = null;
    static final ShadowConfigCore[] Oui_Shadow_Thick_V1 = null;
    static final ShadowConfigCore[] Oui_Shadow_Thick_V2 = null;
    public static final ShadowConfigCore[] Oui_Shadow_Thin = null;
    public static final ShadowConfigCore[] Oui_Shadow_UltraThick = null;

    @Deprecated
    public static final ShadowConfigCore[] Shadow_1 = null;

    @Deprecated
    public static final ShadowConfigCore[] Shadow_2 = null;

    @Deprecated
    public static final ShadowConfigCore[] Shadow_3 = null;

    @Deprecated
    public static final ShadowConfigCore[] Shadow_Text = null;

    @Deprecated
    public static final ShadowConfigCore[] Shadow_Thick = null;
    private static final ConcurrentHashMap<String, ShadowConfigCore[]> tokens = null;

    static {
        Oui_Shadow_Thin = new ShadowConfigCore[]{new ShadowConfigCore(0.0f, 2.0f, 10.0f, 251658240, 0.0f, -1)};
        ShadowConfigCore[] r3 = {new ShadowConfigCore(0.0f, 8.0f, 20.0f, 335544320, 0.0f, -1), new ShadowConfigCore(0.0f, 2.0f, 10.0f, VCardConfig.FLAG_CONVERT_PHONETIC_NAME_STRINGS, 0.0f, -1)};
        Oui_Shadow_Regular_V2 = r3;
        ShadowConfigCore[] r4 = {new ShadowConfigCore(0.0f, 6.0f, 20.0f, 218103808, 0.0f, -1), new ShadowConfigCore(0.0f, 2.0f, 10.0f, 83886080, 0.0f, -1)};
        Oui_Shadow_Regular_V1 = r4;
        if (OMaterialHelper.getMaterialApiVersion() >= 4) goto L6;
        r3 = r4;
    L6:
        Oui_Shadow_Regular = r3;
        ShadowConfigCore[] r5 = {new ShadowConfigCore(0.0f, 12.0f, 24.0f, 603979776, 0.0f, -1)};
        Oui_Shadow_Thick_V2 = r5;
        ShadowConfigCore[] r6 = {new ShadowConfigCore(0.0f, 12.0f, 24.0f, 520093696, 0.0f, -1)};
        Oui_Shadow_Thick_V1 = r6;
        if (OMaterialHelper.getMaterialApiVersion() >= 4) goto L10;
        r5 = r6;
    L10:
        Oui_Shadow_Thick = r5;
        Oui_Shadow_UltraThick = new ShadowConfigCore[]{new ShadowConfigCore(0.0f, 16.0f, 60.0f, 687865856, 0.0f, -1)};
        Oui_Shadow_Text_Regular = new ShadowConfigCore[]{new ShadowConfigCore(0.0f, 1.0f, 2.5f, 167772160, 0.0f, -1), new ShadowConfigCore(0.0f, 0.0f, 1.0f, 167772160, 0.0f, -1)};
        Shadow_1 = new ShadowConfigCore[]{new ShadowConfigCore(0.0f, 2.0f, 10.0f, 251658240, 0.0f, -1)};
        Shadow_2 = new ShadowConfigCore[]{new ShadowConfigCore(0.0f, 6.0f, 20.0f, 218103808, 0.0f, -1), new ShadowConfigCore(0.0f, 2.0f, 10.0f, 83886080, 0.0f, -1)};
        Shadow_3 = new ShadowConfigCore[]{new ShadowConfigCore(0.0f, 12.0f, 24.0f, 520093696, 0.0f, -1)};
        Shadow_Thick = new ShadowConfigCore[]{new ShadowConfigCore(0.0f, 16.0f, 60.0f, 687865856, 0.0f, -1)};
        Shadow_Text = new ShadowConfigCore[]{new ShadowConfigCore(0.0f, 1.0f, 2.5f, 167772160, 0.0f, -1), new ShadowConfigCore(0.0f, 0.0f, 1.0f, 167772160, 0.0f, -1)};
        tokens = TokenParserCore.createTokenMap(ShadowTokenCore.class, ShadowConfigCore[].class);
    }

    private ShadowTokenCore() {
    }

    public static ShadowConfigCore[] parse(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return null;
    L7:
        return (ShadowConfigCore[]) TokenParserCore.parse(r1, tokens);
    }
}
