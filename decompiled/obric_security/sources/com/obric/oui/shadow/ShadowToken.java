package com.obric.oui.shadow;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShadowToken.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0002\u0010\u0013R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/shadow/ShadowToken;", "", "()V", "Oui_Shadow_Regular", "", "Lcom/obric/oui/shadow/ShadowConfig;", "[Lcom/obric/oui/shadow/ShadowConfig;", "Oui_Shadow_Text_Regular", "Oui_Shadow_Thick", "Oui_Shadow_Thin", "Oui_Shadow_UltraThick", "Shadow_1", "Shadow_2", "Shadow_3", "Shadow_Text", "Shadow_Thick", "parse", "name", "", "(Ljava/lang/String;)[Lcom/obric/oui/shadow/ShadowConfig;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShadowToken {
    public static final ShadowToken INSTANCE = null;
    public static final ShadowConfig[] Oui_Shadow_Regular = null;
    public static final ShadowConfig[] Oui_Shadow_Text_Regular = null;
    public static final ShadowConfig[] Oui_Shadow_Thick = null;
    public static final ShadowConfig[] Oui_Shadow_Thin = null;
    public static final ShadowConfig[] Oui_Shadow_UltraThick = null;
    public static final ShadowConfig[] Shadow_1 = null;
    public static final ShadowConfig[] Shadow_2 = null;
    public static final ShadowConfig[] Shadow_3 = null;
    public static final ShadowConfig[] Shadow_Text = null;
    public static final ShadowConfig[] Shadow_Thick = null;

    private ShadowToken() {
    }

    @JvmStatic
    public static final ShadowConfig[] parse(String r1) {
        return ShadowTokenCore.parse(INSTANCE, r1);
    }

    static {
        INSTANCE = new ShadowToken();
        ShadowConfig[] r0 = ShadowTokenCore.Oui_Shadow_Thin;
        Intrinsics.checkNotNullExpressionValue(r0, "Oui_Shadow_Thin");
        Oui_Shadow_Thin = r0;
        ShadowConfig[] r1 = ShadowTokenCore.Oui_Shadow_Regular;
        Intrinsics.checkNotNullExpressionValue(r1, "Oui_Shadow_Regular");
        Oui_Shadow_Regular = r1;
        ShadowConfig[] r2 = ShadowTokenCore.Oui_Shadow_Thick;
        Intrinsics.checkNotNullExpressionValue(r2, "Oui_Shadow_Thick");
        Oui_Shadow_Thick = r2;
        ShadowConfig[] r3 = ShadowTokenCore.Oui_Shadow_UltraThick;
        Intrinsics.checkNotNullExpressionValue(r3, "Oui_Shadow_UltraThick");
        Oui_Shadow_UltraThick = r3;
        ShadowConfig[] r4 = ShadowTokenCore.Oui_Shadow_Text_Regular;
        Intrinsics.checkNotNullExpressionValue(r4, "Oui_Shadow_Text_Regular");
        Oui_Shadow_Text_Regular = r4;
        ShadowConfig[] r5 = ShadowTokenCore.Shadow_1;
        Intrinsics.checkNotNullExpressionValue(r5, "Shadow_1");
        Shadow_1 = r5;
        ShadowConfig[] r6 = ShadowTokenCore.Shadow_2;
        Intrinsics.checkNotNullExpressionValue(r6, "Shadow_2");
        Shadow_2 = r6;
        ShadowConfig[] r7 = ShadowTokenCore.Shadow_3;
        Intrinsics.checkNotNullExpressionValue(r7, "Shadow_3");
        Shadow_3 = r7;
        ShadowConfig[] r8 = ShadowTokenCore.Shadow_Thick;
        Intrinsics.checkNotNullExpressionValue(r8, "Shadow_Thick");
        Shadow_Thick = r8;
        ShadowConfig[] r9 = ShadowTokenCore.Shadow_Text;
        Intrinsics.checkNotNullExpressionValue(r9, "Shadow_Text");
        Shadow_Text = r9;
    }
}
