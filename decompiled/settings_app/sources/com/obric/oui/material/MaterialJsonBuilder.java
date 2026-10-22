package com.obric.oui.material;

import android.content.res.ColorStateList;
import com.android.settings.search.IndexDatabaseHelper;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.obric.oui.blur.BlurConfig;
import com.obric.oui.color.BlendConfig;
import com.obric.oui.color.StrokeConfig;
import com.obric.oui.fluid.FluidConfig;
import com.obric.oui.res.BlendConfigStateList;
import com.obric.oui.res.StrokeStateList;
import com.obric.oui.shadow.ShadowConfig;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: MaterialConfigFormatBuilders.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007J%\u0010\t\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\fJ&\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0002J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0014H\u0002J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0015H\u0002J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0016H\u0002J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0017H\u0002J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0006H\u0002J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0018H\u0002J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0019H\u0002J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u001aH\u0002J\u0017\u0010\u0011\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00150\u000bH\u0002¢\u0006\u0002\u0010\u001cJ\u0017\u0010\u0011\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u001a0\u000bH\u0002¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/material/MaterialJsonBuilder;", "", "()V", IndexDatabaseHelper.MetaColumns.BUILD, "", "config", "Lcom/obric/oui/material/MaterialConfig;", "indentSpaces", "", "buildArray", Constants.KEY_CONFIG, "", "([Lcom/obric/oui/material/MaterialConfig;I)Ljava/lang/String;", "buildToken", "tokenName", "isLight", "", "toJson", "Lorg/json/JSONObject;", "Landroid/content/res/ColorStateList;", "Lcom/obric/oui/blur/BlurConfig;", "Lcom/obric/oui/color/BlendConfig;", "Lcom/obric/oui/color/StrokeConfig;", "Lcom/obric/oui/fluid/FluidConfig;", "Lcom/obric/oui/res/BlendConfigStateList;", "Lcom/obric/oui/res/StrokeStateList;", "Lcom/obric/oui/shadow/ShadowConfig;", "Lorg/json/JSONArray;", "([Lcom/obric/oui/color/BlendConfig;)Lorg/json/JSONArray;", "([Lcom/obric/oui/shadow/ShadowConfig;)Lorg/json/JSONArray;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MaterialJsonBuilder {
    public static final MaterialJsonBuilder INSTANCE = null;

    static {
        INSTANCE = new MaterialJsonBuilder();
    }

    @JvmStatic
    public static final String build(MaterialConfig r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        return build$default(r3, 0, 2, null);
    }

    @JvmStatic
    public static final String buildArray(MaterialConfig[] r3) {
        Intrinsics.checkNotNullParameter(r3, Constants.KEY_CONFIG);
        return buildArray$default(r3, 0, 2, null);
    }

    @JvmStatic
    public static final String buildToken(String r3) {
        Intrinsics.checkNotNullParameter(r3, "tokenName");
        return buildToken$default(r3, false, 0, 6, null);
    }

    @JvmStatic
    public static final String buildToken(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "tokenName");
        return buildToken$default(r3, r4, 0, 4, null);
    }

    private MaterialJsonBuilder() {
    }

    public static /* synthetic */ String build$default(MaterialConfig r0, int r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = 2;
    L6:
        return build(r0, r1);
    }

    @JvmStatic
    public static final String build(MaterialConfig r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "config");
        String r3 = INSTANCE.toJson(r1).toString(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "config.toJson().toString(indentSpaces)");
        return r3;
    }

    public static /* synthetic */ String buildArray$default(MaterialConfig[] r0, int r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = 2;
    L6:
        return buildArray(r0, r1);
    }

    @JvmStatic
    public static final String buildArray(MaterialConfig[] r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, Constants.KEY_CONFIG);
        JSONArray r0 = new JSONArray();
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        MaterialConfig r3 = r5[r2];
        r0.put(INSTANCE.toJson(r3));
        r2 = r2 + 1;
        goto L3
    L5:
        String r7 = r0.toString(r6);
        Intrinsics.checkNotNullExpressionValue(r7, "JSONArray().apply { conf… }.toString(indentSpaces)");
        return r7;
    }

    public static /* synthetic */ String buildToken$default(String r0, boolean r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r1 = true;
    L6:
        if ((r3 & 4) == 0) goto L9;
        r2 = 2;
    L9:
        return buildToken(r0, r1, r2);
    }

    @JvmStatic
    public static final String buildToken(String r1, boolean r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "tokenName");
        MaterialConfig[] r4 = MaterialToken.INSTANCE.resolveTokenForBuilder$OUI_standardRelease(r1, r2);
        if (r4 != null) goto L7;
        return null;
    L7:
        if (r4.length != 1) goto L10;
        return build(r4[0], r3);
    L10:
        return buildArray(r4, r3);
    }

    private final JSONObject toJson(MaterialConfig r4) {
        JSONObject r3 = new JSONObject();
        ColorStateList r0 = r4.getFallbackBgColor();
        if (r0 == null) goto L6;
        r3.put(MaterialConfigFormatNames.FALLBACK_BG_COLOR, INSTANCE.toJson(r0));
    L6:
        BlendConfigStateList r1 = r4.getBlendConfigStateList();
        JSONObject r2 = null;
        if (r1 != null) goto L9;
        JSONObject r5 = null;
    L10:
        if (r5 != null) goto L15;
        BlendConfig[] r6 = r4.getBlendConfig();
        if (r6 == null) goto L15;
        r3.put(MaterialConfigFormatNames.BLEND_CONFIG, INSTANCE.toJson(r6));
    L15:
        BlendConfigStateList r7 = r4.getOverlayBlendConfigStateList();
        if (r7 == null) goto L19;
        r3.put(MaterialConfigFormatNames.OVERLAY_BLEND_CONFIGS, INSTANCE.toJson(r7));
    L19:
        StrokeStateList r8 = r4.getStrokeStateList();
        if (r8 != null) goto L22;
        JSONObject r9 = null;
    L23:
        if (r9 != null) goto L28;
        StrokeConfig r10 = r4.getStroke();
        if (r10 == null) goto L28;
        r3.put(MaterialConfigFormatNames.STROKE, INSTANCE.toJson(r10));
    L28:
        BlurConfig r11 = r4.getBlurConfig();
        if (r11 == null) goto L32;
        r2 = r3.put(MaterialConfigFormatNames.BLUR_CONFIG, INSTANCE.toJson(r11));
    L32:
        if (r2 != null) goto L37;
        Float r12 = r4.getBlurRadius();
        if (r12 == null) goto L37;
        r3.put(MaterialConfigFormatNames.BLUR_RADIUS, Float.valueOf(r12.floatValue()));
    L37:
        ShadowConfig[] r13 = r4.getShadow();
        if (r13 == null) goto L41;
        r3.put(MaterialConfigFormatNames.SHADOWS, INSTANCE.toJson(r13));
    L41:
        FluidConfig r14 = r4.getFluid();
        if (r14 == null) goto L45;
        r3.put(MaterialConfigFormatNames.FLUID, INSTANCE.toJson(r14));
    L45:
        return r3;
    L22:
        r9 = r3.put(MaterialConfigFormatNames.STROKE_STATE_LIST, INSTANCE.toJson(r8));
        goto L23
    L9:
        r5 = r3.put(MaterialConfigFormatNames.BLEND_CONFIGS, INSTANCE.toJson(r1));
        goto L10
    }

    private final JSONObject toJson(ColorStateList r5) {
        JSONObject r4 = new JSONObject();
        Iterator r0 = MaterialConfigFormatBuildersKt.access$getMATERIAL_STATES$p().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        MaterialOutputState r1 = (MaterialOutputState) r0.next();
        r4.put(r1.getXmlName(), MaterialConfigFormatBuildersKt.access$formatColor(r5.getColorForState(r1.getStateSet(), r5.getDefaultColor())));
        goto L4
    L6:
        return r4;
    }

    private final JSONObject toJson(BlendConfigStateList r7) {
        JSONObject r6 = new JSONObject();
        Iterator r0 = MaterialConfigFormatBuildersKt.access$getMATERIAL_STATES$p().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        MaterialOutputState r1 = (MaterialOutputState) r0.next();
        r6.put(r1.getXmlName(), INSTANCE.toJson(BlendConfigStateList.getConfigForState$default(r7, r1.getStateSet(), null, 2, null)));
        goto L4
    L6:
        return r6;
    }

    private final JSONArray toJson(BlendConfig[] r5) {
        JSONArray r4 = new JSONArray();
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        BlendConfig r2 = r5[r1];
        r4.put(INSTANCE.toJson(r2));
        r1 = r1 + 1;
        goto L3
    L5:
        return r4;
    }

    private final JSONObject toJson(BlendConfig r3) {
        JSONObject r2 = new JSONObject();
        r2.put("color", MaterialConfigFormatBuildersKt.access$formatColor(r3.getColor()));
        r2.put(MaterialConfigFormatNames.BLEND_MODE, MaterialConfigFormatBuildersKt.access$formatBlendMode(r3.getBlendMode()));
        return r2;
    }

    private final JSONObject toJson(StrokeStateList r6) {
        JSONObject r5 = new JSONObject();
        Iterator r0 = MaterialConfigFormatBuildersKt.access$getMATERIAL_STATES$p().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        MaterialOutputState r1 = (MaterialOutputState) r0.next();
        StrokeConfig r2 = StrokeStateList.getConfigForState$default(r6, r1.getStateSet(), null, 2, null);
        if (r2 == null) goto L4;
        r5.put(r1.getXmlName(), INSTANCE.toJson(r2));
        goto L4
    L9:
        return r5;
    }

    private final JSONObject toJson(StrokeConfig r3) {
        JSONObject r2 = new JSONObject();
        r2.put(MaterialConfigFormatNames.WIDTH, Float.valueOf(r3.getWidth()));
        r2.put("color", MaterialConfigFormatBuildersKt.access$formatColor(r3.getColor()));
        r2.put(MaterialConfigFormatNames.BLEND_MODE, r3.getBlendMode().name());
        return r2;
    }

    private final JSONObject toJson(BlurConfig r3) {
        JSONObject r2 = new JSONObject();
        r2.put(MaterialConfigFormatNames.BLUR_RADIUS, Float.valueOf(r3.getBlurRadius()));
        r2.put(MaterialConfigFormatNames.DIRECTION, MaterialConfigFormatBuildersKt.access$formatBlurDirection(r3.getDirection()));
        r2.put("alpha", Float.valueOf(r3.getAlpha()));
        r2.put(MaterialConfigFormatNames.CURVE_TYPE, MaterialConfigFormatBuildersKt.access$formatCurveType(r3.getCurveType()));
        r2.put(MaterialConfigFormatNames.END_POINT, Float.valueOf(r3.getEndPoint()));
        return r2;
    }

    private final JSONArray toJson(ShadowConfig[] r5) {
        JSONArray r4 = new JSONArray();
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ShadowConfig r2 = r5[r1];
        r4.put(INSTANCE.toJson(r2));
        r1 = r1 + 1;
        goto L3
    L5:
        return r4;
    }

    private final JSONObject toJson(ShadowConfig r3) {
        JSONObject r2 = new JSONObject();
        r2.put(MaterialConfigFormatNames.X, Float.valueOf(r3.getX()));
        r2.put("y", Float.valueOf(r3.getY()));
        r2.put(MaterialConfigFormatNames.BLUR_RADIUS, Float.valueOf(r3.getBlurRadius()));
        r2.put("color", MaterialConfigFormatBuildersKt.access$formatColor(r3.getColor()));
        r2.put(MaterialConfigFormatNames.SPREAD, Float.valueOf(r3.getSpread()));
        r2.put(MaterialConfigFormatNames.BLEND_MODE, MaterialConfigFormatBuildersKt.access$formatBlendMode(r3.getBlendMode()));
        return r2;
    }

    private final JSONObject toJson(FluidConfig r5) {
        JSONObject r4 = new JSONObject();
        float[] r6 = r5.getGlassParams();
        if (r6 != null) goto L6;
    L17:
        return r4;
    L6:
        if (r6.length < 8) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L12;
        r6 = null;
    L12:
        if (r6 == null) goto L17;
        r4.put(MaterialConfigFormatNames.REFRACTION_HEIGHT, Float.valueOf(r6[0]));
        r4.put(MaterialConfigFormatNames.REFRACTION_STRENGTH, Float.valueOf(r6[1]));
        r4.put(MaterialConfigFormatNames.HIGHLIGHT_ANGLE, Float.valueOf(r6[2]));
        r4.put(MaterialConfigFormatNames.HIGHLIGHT_FALLOFF, Float.valueOf(r6[3]));
        r4.put(MaterialConfigFormatNames.HIGHLIGHT_WIDTH, Float.valueOf(r6[4]));
        r4.put(MaterialConfigFormatNames.HIGHLIGHT_ALPHA, Float.valueOf(r6[5]));
        r4.put(MaterialConfigFormatNames.HIGHLIGHT_INSET, Float.valueOf(r6[6]));
        r4.put(MaterialConfigFormatNames.HIGHLIGHT_STRENGTH, Float.valueOf(r6[7]));
        if (r6.length < 13) goto L17;
        r4.put(MaterialConfigFormatNames.FIRST_LAYER_HIGHLIGHT_COLOR, MaterialConfigFormatBuildersKt.access$formatColor(Float.floatToRawIntBits(r6[8])));
        r4.put(MaterialConfigFormatNames.FIRST_LAYER_HIGHLIGHT_BLEND_MODE, MaterialConfigFormatBuildersKt.access$formatBlendMode((int) r6[9]));
        r4.put(MaterialConfigFormatNames.SECOND_LAYER_HIGHLIGHT_COLOR, MaterialConfigFormatBuildersKt.access$formatColor(Float.floatToRawIntBits(r6[10])));
        r4.put(MaterialConfigFormatNames.SECOND_LAYER_HIGHLIGHT_BLEND_MODE, MaterialConfigFormatBuildersKt.access$formatBlendMode((int) r6[11]));
        r4.put(MaterialConfigFormatNames.CHROMATIC_ABERRATION, Float.valueOf(r6[12]));
        goto L17
    L8:
        r0 = false;
        goto L9
    }
}
