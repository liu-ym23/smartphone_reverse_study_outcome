package com.obric.oui.material;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.oui.blur.BlurConfig;
import com.obric.oui.color.BlendConfig;
import com.obric.oui.color.StrokeConfig;
import com.obric.oui.fluid.FluidConfig;
import com.obric.oui.graphic.BlendMode;
import com.obric.oui.res.BlendConfigStateList;
import com.obric.oui.res.StrokeStateList;
import com.obric.oui.shadow.ShadowConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.FloatSpreadBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: compiled from: MaterialJsonParser.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001HB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u0004\"\u00020\u000bH\u0002¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J+\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u0004\"\u00020\u000bH\u0002¢\u0006\u0002\u0010\u0013J+\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u0004\"\u00020\u000bH\u0002¢\u0006\u0002\u0010\u0015J+\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u0004\"\u00020\u000bH\u0002¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u000bH\u0007J\u001f\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u0010\u001cJ\u001d\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\b\u001a\u00020\tH\u0002J\u001d\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\"J\u0014\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\u0012H\u0002J\u001f\u0010&\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010'J\u0019\u0010(\u001a\u0004\u0018\u00010)2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010*J\u0014\u0010+\u001a\u0004\u0018\u00010,2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0002J\u0014\u0010-\u001a\u0004\u0018\u00010.2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0019\u0010/\u001a\u0004\u0018\u00010)2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010*J\u0019\u00100\u001a\u0004\u0018\u00010)2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010*J\u0014\u00101\u001a\u0004\u0018\u0001022\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u00103\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\tH\u0002J\u0019\u00104\u001a\u0004\u0018\u00010)2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010*J\u0019\u00105\u001a\u0004\u0018\u0001062\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u00107J\u0014\u00108\u001a\u0004\u0018\u0001092\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0019\u0010<\u001a\u0004\u0018\u00010)2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010*J\u001d\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0002¢\u0006\u0002\u0010>J\u0012\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010\b\u001a\u00020\tH\u0002J\u001f\u0010A\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010BJ\u0014\u0010C\u001a\u0004\u0018\u00010$2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0014\u0010D\u001a\u0004\u0018\u00010E2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0002J\u0014\u0010F\u001a\u0004\u0018\u00010G2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006I"}, d2 = {"Lcom/obric/oui/material/MaterialJsonParser;", "", "()V", "MATERIAL_STATE_SPECS", "", "", "[[I", "opt", "obj", "Lorg/json/JSONObject;", "names", "", "(Lorg/json/JSONObject;[Ljava/lang/String;)Ljava/lang/Object;", "optBoolean", "", "name", "default", "optJSONArray", "Lorg/json/JSONArray;", "(Lorg/json/JSONObject;[Ljava/lang/String;)Lorg/json/JSONArray;", "optJSONObject", "(Lorg/json/JSONObject;[Ljava/lang/String;)Lorg/json/JSONObject;", "optString", "(Lorg/json/JSONObject;[Ljava/lang/String;)Ljava/lang/String;", "parse", "Lcom/obric/oui/material/MaterialConfig;", MaterialConfigBuilder.SERIALIZATION_FORMAT_JSON, "parseArray", "(Ljava/lang/String;)[Lcom/obric/oui/material/MaterialConfig;", "array", "(Lorg/json/JSONArray;)[Lcom/obric/oui/material/MaterialConfig;", "parseBlend", "Lcom/obric/oui/color/BlendConfig;", "parseBlendArray", "(Lorg/json/JSONArray;)[Lcom/obric/oui/color/BlendConfig;", "parseBlendArrayContainer", "Lcom/obric/oui/material/MaterialJsonParser$ParsedBlendContainer;", "value", "parseBlendArrayOrObject", "(Ljava/lang/Object;)[Lcom/obric/oui/color/BlendConfig;", "parseBlendMode", "", "(Ljava/lang/Object;)Ljava/lang/Integer;", "parseBlendModeEnum", "Lcom/obric/oui/graphic/BlendMode;", "parseBlurConfig", "Lcom/obric/oui/blur/BlurConfig;", "parseBlurDirection", "parseColor", "parseColorStateList", "Landroid/content/res/ColorStateList;", "parseConfig", "parseCurveType", "parseFloat", "", "(Ljava/lang/Object;)Ljava/lang/Float;", "parseFluidConfig", "Lcom/obric/oui/fluid/FluidConfig;", "parseFluidParams", "", "parseInt", "parseObjectOrToken", "(Lorg/json/JSONObject;)[Lcom/obric/oui/material/MaterialConfig;", "parseShadow", "Lcom/obric/oui/shadow/ShadowConfig;", "parseShadowArray", "(Ljava/lang/Object;)[Lcom/obric/oui/shadow/ShadowConfig;", "parseStatefulBlendContainer", "parseStroke", "Lcom/obric/oui/color/StrokeConfig;", "parseStrokeStateList", "Lcom/obric/oui/res/StrokeStateList;", "ParsedBlendContainer", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MaterialJsonParser {
    public static final MaterialJsonParser INSTANCE = null;
    private static final int[][] MATERIAL_STATE_SPECS = null;

    /* JADX INFO: compiled from: MaterialJsonParser.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J(\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/material/MaterialJsonParser$ParsedBlendContainer;", "", "defaultConfig", "", "Lcom/obric/oui/color/BlendConfig;", "stateList", "Lcom/obric/oui/res/BlendConfigStateList;", "([Lcom/obric/oui/color/BlendConfig;Lcom/obric/oui/res/BlendConfigStateList;)V", "getDefaultConfig", "()[Lcom/obric/oui/color/BlendConfig;", "[Lcom/obric/oui/color/BlendConfig;", "getStateList", "()Lcom/obric/oui/res/BlendConfigStateList;", "component1", "component2", "copy", "([Lcom/obric/oui/color/BlendConfig;Lcom/obric/oui/res/BlendConfigStateList;)Lcom/obric/oui/material/MaterialJsonParser$ParsedBlendContainer;", "equals", "", "other", "hashCode", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class ParsedBlendContainer {
        private final BlendConfig[] defaultConfig;
        private final BlendConfigStateList stateList;

        public static /* synthetic */ ParsedBlendContainer copy$default(ParsedBlendContainer r0, BlendConfig[] r1, BlendConfigStateList r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.defaultConfig;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.stateList;
        L9:
            return r0.copy(r1, r2);
        }

        public final BlendConfig[] component1() {
            return this.defaultConfig;
        }

        public final BlendConfigStateList component2() {
            return this.stateList;
        }

        public final ParsedBlendContainer copy(BlendConfig[] r1, BlendConfigStateList r2) {
            Intrinsics.checkNotNullParameter(r1, "defaultConfig");
            Intrinsics.checkNotNullParameter(r2, "stateList");
            return new ParsedBlendContainer(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ParsedBlendContainer) == true) goto L8;
            return false;
        L8:
            ParsedBlendContainer r6 = (ParsedBlendContainer) r5;
            if (Intrinsics.areEqual(this.defaultConfig, r6.defaultConfig) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.stateList, r6.stateList) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.defaultConfig) * 31) + this.stateList.hashCode();
        }

        public String toString() {
            return "ParsedBlendContainer(defaultConfig=" + Arrays.toString(this.defaultConfig) + ", stateList=" + this.stateList + ')';
        }

        public ParsedBlendContainer(BlendConfig[] r2, BlendConfigStateList r3) {
            Intrinsics.checkNotNullParameter(r2, "defaultConfig");
            Intrinsics.checkNotNullParameter(r3, "stateList");
            this.defaultConfig = r2;
            this.stateList = r3;
        }

        public final BlendConfig[] getDefaultConfig() {
            return this.defaultConfig;
        }

        public final BlendConfigStateList getStateList() {
            return this.stateList;
        }
    }

    private MaterialJsonParser() {
    }

    static {
        INSTANCE = new MaterialJsonParser();
        MATERIAL_STATE_SPECS = new int[][]{new int[]{R.attr.state_pressed, R.attr.state_checked}, new int[]{R.attr.state_hovered, R.attr.state_checked}, new int[]{R.attr.state_pressed, R.attr.state_selected}, new int[]{R.attr.state_hovered, R.attr.state_selected}, new int[]{R.attr.state_pressed, R.attr.state_activated}, new int[]{R.attr.state_hovered, R.attr.state_activated}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_selected}, new int[]{-16842910}, new int[]{R.attr.state_enabled}};
    }

    @JvmStatic
    public static final MaterialConfig parse(String r3) {
        Object r0 = null;
        if (r3 != null) goto L5;
    L4:
        String r4 = null;
    L13:
        if (r4 != null) goto L15;
        return null;
    L15:
        MaterialJsonParser r1 = INSTANCE;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L31
        Object r5 = new JSONTokener(r4).nextValue();     // Catch: Throwable -> L31
        if ((r5 instanceof JSONObject) == false) goto L23;
        MaterialConfig[] r6 = r1.parseObjectOrToken((JSONObject) r5);     // Catch: Throwable -> L31
        if (r6 == null) goto L28;
        MaterialConfig r7 = (MaterialConfig) ArraysKt.firstOrNull(r6);     // Catch: Throwable -> L31
    L29:
        Object r8 = Result.m774constructorimpl(r7);     // Catch: Throwable -> L31
    L34:
        if (Result.m780isFailureimpl(r8) == true) goto L38;
        r0 = r8;
    L38:
        return (MaterialConfig) r0;
    L28:
        r7 = null;
        goto L29
    L23:
        if ((r5 instanceof JSONArray) == false) goto L28;
        MaterialConfig[] r9 = r1.parseArray((JSONArray) r5);     // Catch: Throwable -> L31
        if (r9 == null) goto L28;
        r7 = (MaterialConfig) ArraysKt.firstOrNull(r9);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L34
    L5:
        r4 = StringsKt.trim(r3).toString();
        if (r4 == null) goto L4;
        if (r4.length() <= 0) goto L11;
        boolean r11 = true;
    L12:
        if (r11 == false) goto L4;
    L11:
        r11 = false;
        goto L12
    }

    @JvmStatic
    public static final MaterialConfig[] parseArray(String r3) {
        Object r0 = null;
        if (r3 != null) goto L5;
    L4:
        String r4 = null;
    L13:
        if (r4 != null) goto L15;
        return null;
    L15:
        MaterialJsonParser r1 = INSTANCE;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L25
        Object r5 = new JSONTokener(r4).nextValue();     // Catch: Throwable -> L25
        if ((r5 instanceof JSONObject) == false) goto L20;
        MaterialConfig[] r6 = r1.parseObjectOrToken((JSONObject) r5);     // Catch: Throwable -> L25
    L23:
        Object r7 = Result.m774constructorimpl(r6);     // Catch: Throwable -> L25
    L28:
        if (Result.m780isFailureimpl(r7) == true) goto L32;
        r0 = r7;
    L32:
        return (MaterialConfig[]) r0;
    L20:
        if ((r5 instanceof JSONArray) == false) goto L22;
        r6 = r1.parseArray((JSONArray) r5);     // Catch: Throwable -> L25
        goto L23
    L22:
        r6 = null;
    L25:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L28
    L5:
        r4 = StringsKt.trim(r3).toString();
        if (r4 == null) goto L4;
        if (r4.length() <= 0) goto L11;
        boolean r9 = true;
    L12:
        if (r9 == false) goto L4;
    L11:
        r9 = false;
        goto L12
    }

    private final MaterialConfig[] parseObjectOrToken(JSONObject r6) {
        boolean r0 = optBoolean(r6, MaterialConfigFormatNames.IS_LIGHT, true);
        String r2 = optString(r6, new String[]{"token"});
        if (r2 == null) goto L10;
        MaterialConfig[] r4 = MaterialToken.parseSet(r2, r0);
        if (r4 != null) goto L18;
        MaterialConfig r1 = MaterialToken.parse(r2, r0);
        if (r1 != null) goto L17;
        Void r3 = (Void) null;
        goto L10
    L17:
        return new MaterialConfig[]{r1};
    L18:
        return r4;
    L10:
        JSONArray r5 = optJSONArray(r6, new String[]{MaterialConfigFormatNames.ROOT_MATERIAL_CONFIGS});
        if (r5 != null) goto L15;
        return new MaterialConfig[]{parseConfig(r6)};
    L15:
        return INSTANCE.parseArray(r5);
    }

    private final MaterialConfig[] parseArray(JSONArray r8) {
        ArrayList r0 = new ArrayList();
        int r1 = r8.length();
        boolean r2 = false;
        int r3 = 0;
    L3:
        Object r4 = null;
        if (r3 >= r1) goto L15;
        int r5 = r3 + 1;
        Object r6 = r8.opt(r3);
        if ((r6 instanceof JSONObject) == false) goto L14;
        MaterialConfig[] r7 = parseObjectOrToken((JSONObject) r6);
        if (r7 == null) goto L11;
        r4 = ArraysKt.toList(r7);
    L11:
        if (r4 != null) goto L13;
        r4 = CollectionsKt.emptyList();
    L13:
        r0.addAll((Collection) r4);
    L14:
        r3 = r5;
        goto L3
    L15:
        Object r9 = r0.toArray(new MaterialConfig[0]);
        if (r9 == null) goto L26;
        if (((MaterialConfig[]) r9).length != 0) goto L21;
        r2 = true;
    L21:
        if ((!r2) == false) goto L24;
        r4 = r9;
    L24:
        return (MaterialConfig[]) r4;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    private final MaterialConfig parseConfig(JSONObject r15) {
        JSONObject r2 = null;
        MaterialConfig r13 = new MaterialConfig(parseColorStateList(opt(r15, new String[]{MaterialConfigFormatNames.FALLBACK_BG_COLOR})), null, null, null, null, null, null, parseFloat(opt(r15, new String[]{MaterialConfigFormatNames.BLUR_RADIUS})), null, null, 894, null);
        Object r0 = opt(r15, new String[]{MaterialConfigFormatNames.BLEND_CONFIG});
        if ((r0 instanceof JSONArray) == false) goto L5;
        JSONArray r1 = (JSONArray) r0;
    L6:
        ParsedBlendContainer r3 = parseBlendArrayContainer(r1);
        if (r3 == null) goto L10;
        r13.setBlendConfig(r3.getDefaultConfig());
        r13.setBlendConfigStateList(r3.getStateList());
    L10:
        Object r4 = opt(r15, new String[]{MaterialConfigFormatNames.BLEND_CONFIGS});
        if ((r4 instanceof JSONObject) == false) goto L13;
        JSONObject r5 = (JSONObject) r4;
    L14:
        ParsedBlendContainer r6 = parseStatefulBlendContainer(r5);
        if (r6 == null) goto L18;
        r13.setBlendConfig(r6.getDefaultConfig());
        r13.setBlendConfigStateList(r6.getStateList());
    L18:
        Object r7 = opt(r15, new String[]{MaterialConfigFormatNames.OVERLAY_BLEND_CONFIGS});
        if ((r7 instanceof JSONObject) == false) goto L21;
        r2 = (JSONObject) r7;
    L21:
        ParsedBlendContainer r8 = parseStatefulBlendContainer(r2);
        if (r8 == null) goto L25;
        r13.setOverlayBlendConfigStateList(r8.getStateList());
    L25:
        r13.setStroke(parseStroke(opt(r15, new String[]{MaterialConfigFormatNames.STROKE})));
        StrokeStateList r9 = parseStrokeStateList(opt(r15, new String[]{MaterialConfigFormatNames.STROKE_STATE_LIST}));
        if (r9 == null) goto L29;
        r13.setStrokeStateList(r9);
    L29:
        r13.setBlurConfig(parseBlurConfig(optJSONObject(r15, new String[]{MaterialConfigFormatNames.BLUR_CONFIG})));
        r13.setShadow(parseShadowArray(opt(r15, new String[]{MaterialConfigFormatNames.SHADOWS})));
        r13.setFluid(parseFluidConfig(optJSONObject(r15, new String[]{MaterialConfigFormatNames.FLUID})));
        return r13;
    L13:
        r5 = null;
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    private final ParsedBlendContainer parseBlendArrayContainer(JSONArray r2) {
        if (r2 == null) goto L10;
        BlendConfig[] r1 = parseBlendArray(r2);
        if (r1 != null) goto L9;
        return null;
    L9:
        return new ParsedBlendContainer(r1, BlendConfigStateList.Companion.valueOf(r1));
    L10:
        return null;
    }

    private final ParsedBlendContainer parseStatefulBlendContainer(JSONObject r9) {
        if (r9 != null) goto L5;
        return null;
    L5:
        BlendConfig[] r1 = parseBlendArrayOrObject(opt(r9, new String[]{"normal"}));
        if (r1 != null) goto L8;
        return null;
    L8:
        BlendConfig[] r0 = parseBlendArrayOrObject(opt(r9, new String[]{MaterialConfigFormatNames.PRESS}));
        if (r0 != null) goto L11;
        r0 = r1;
    L11:
        BlendConfig[] r2 = parseBlendArrayOrObject(opt(r9, new String[]{MaterialConfigFormatNames.HOVER}));
        if (r2 != null) goto L14;
        r2 = r0;
    L14:
        BlendConfig[] r3 = parseBlendArrayOrObject(opt(r9, new String[]{"checked"}));
        if (r3 != null) goto L17;
        r3 = r1;
    L17:
        BlendConfig[] r4 = parseBlendArrayOrObject(opt(r9, new String[]{MaterialConfigFormatNames.SELECTED}));
        if (r4 != null) goto L20;
        r4 = r1;
    L20:
        BlendConfig[] r8 = parseBlendArrayOrObject(opt(r9, new String[]{MaterialConfigFormatNames.DISABLE}));
        if (r8 != null) goto L23;
        r8 = r1;
    L23:
        BlendConfigStateList r10 = BlendConfigStateList.Companion.of(MATERIAL_STATE_SPECS, new BlendConfig[][]{r3, r3, r4, r4, r4, r4, r0, r2, r3, r4, r8, r1});
        return new ParsedBlendContainer(r10.getDefaultBlendConfig(), r10);
    }

    private final BlendConfig[] parseBlendArrayOrObject(Object r2) {
        if ((r2 instanceof JSONArray) == true) goto L7;
        return null;
    L7:
        return parseBlendArray((JSONArray) r2);
    }

    private final BlendConfig[] parseBlendArray(JSONArray r7) {
        Object[] r0 = null;
        if (r7.length() != 0) goto L5;
        return null;
    L5:
        boolean r6 = false;
        if ((r7.opt(0) instanceof JSONObject) == true) goto L16;
        int r1 = r7.length();
        int[] r2 = new int[r1];
        int r3 = 0;
    L8:
        if (r3 >= r1) goto L15;
        Integer r4 = INSTANCE.parseInt(r7.opt(r3));
        if (r4 != null) goto L12;
        int r5 = 0;
    L13:
        r2[r3] = r5;
        r3 = r3 + 1;
        goto L8
    L12:
        r5 = r4.intValue();
        goto L13
    L15:
        return BlendConfig.Companion.fromIntArray(r2);
    L16:
        ArrayList r8 = new ArrayList();
        int r9 = r7.length();
        int r10 = 0;
    L17:
        if (r10 >= r9) goto L29;
        int r11 = r10 + 1;
        Object r12 = r7.opt(r10);
        if ((r12 instanceof JSONObject) == false) goto L21;
        JSONObject r13 = (JSONObject) r12;
    L22:
        if (r13 == null) goto L28;
        BlendConfig r14 = INSTANCE.parseBlend(r13);
        if (r14 == null) goto L28;
        r8.add(r14);
    L28:
        r10 = r11;
        goto L17
    L21:
        r13 = null;
        goto L22
    L29:
        Object[] r15 = r8.toArray(new BlendConfig[0]);
        if (r15 == null) goto L40;
        if (((BlendConfig[]) r15).length != 0) goto L35;
        r6 = true;
    L35:
        if ((!r6) == false) goto L38;
        r0 = r15;
    L38:
        return (BlendConfig[]) r0;
    L40:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    private final BlendConfig parseBlend(JSONObject r4) {
        Integer r0 = parseColor(opt(r4, new String[]{"color"}));
        if (r0 != null) goto L6;
        return null;
    L6:
        int r1 = r0.intValue();
        Integer r3 = parseBlendMode(opt(r4, new String[]{MaterialConfigFormatNames.BLEND_MODE}));
        if (r3 != null) goto L9;
        int r5 = BlendMode.SRC_OVER.porterDuffMode;
    L11:
        return new BlendConfig(r1, r5);
    L9:
        r5 = r3.intValue();
        goto L11
    }

    private final StrokeStateList parseStrokeStateList(Object r12) {
        if ((r12 instanceof JSONObject) == false) goto L5;
        JSONObject r13 = (JSONObject) r12;
    L6:
        if (r13 != null) goto L8;
        return null;
    L8:
        StrokeConfig r3 = parseStroke(opt(r13, new String[]{"normal"}));
        if (r3 != null) goto L11;
        return null;
    L11:
        StrokeStateList.Companion r2 = StrokeStateList.Companion;
        StrokeConfig r0 = parseStroke(opt(r13, new String[]{MaterialConfigFormatNames.PRESS}));
        if (r0 != null) goto L14;
        StrokeConfig r6 = r3;
    L15:
        StrokeConfig r1 = parseStroke(opt(r13, new String[]{MaterialConfigFormatNames.HOVER}));
        if (r1 != null) goto L18;
        StrokeConfig r7 = r3;
    L19:
        StrokeConfig r4 = parseStroke(opt(r13, new String[]{"checked"}));
        if (r4 != null) goto L22;
        StrokeConfig r5 = r3;
    L23:
        StrokeConfig r11 = parseStroke(opt(r13, new String[]{MaterialConfigFormatNames.DISABLE}));
        if (r11 != null) goto L26;
        StrokeConfig r8 = r3;
    L28:
        return StrokeStateList.Companion.of$default(r2, r3, null, r5, r6, r7, r8, 2, null);
    L26:
        r8 = r11;
        goto L28
    L22:
        r5 = r4;
        goto L23
    L18:
        r7 = r1;
        goto L19
    L14:
        r6 = r0;
        goto L15
    L5:
        r13 = null;
        goto L6
    }

    private final StrokeConfig parseStroke(Object r4) {
        if ((r4 instanceof JSONObject) == false) goto L5;
        JSONObject r5 = (JSONObject) r4;
    L6:
        if (r5 != null) goto L8;
        return null;
    L8:
        Float r0 = parseFloat(opt(r5, new String[]{MaterialConfigFormatNames.WIDTH}));
        if (r0 != null) goto L11;
        return null;
    L11:
        float r1 = r0.floatValue();
        Integer r2 = parseColor(opt(r5, new String[]{"color"}));
        if (r2 != null) goto L14;
        return null;
    L14:
        int r3 = r2.intValue();
        BlendMode r6 = parseBlendModeEnum(opt(r5, new String[]{MaterialConfigFormatNames.BLEND_MODE}));
        if (r6 != null) goto L18;
        r6 = BlendMode.SRC_OVER;
    L18:
        return new StrokeConfig(r1, r3, r6);
    L5:
        r5 = null;
        goto L6
    }

    private final BlurConfig parseBlurConfig(JSONObject r9) {
        if (r9 != null) goto L5;
        return null;
    L5:
        Float r1 = parseFloat(opt(r9, new String[]{MaterialConfigFormatNames.BLUR_RADIUS}));
        if (r1 != null) goto L8;
        return null;
    L8:
        float r3 = r1.floatValue();
        Integer r2 = parseBlurDirection(opt(r9, new String[]{MaterialConfigFormatNames.DIRECTION}));
        int r4 = 0;
        if (r2 != null) goto L11;
        int r5 = 0;
    L12:
        Float r6 = parseFloat(opt(r9, new String[]{"alpha"}));
        if (r6 != null) goto L15;
        float r7 = 1.0f;
    L16:
        Integer r8 = parseCurveType(opt(r9, new String[]{MaterialConfigFormatNames.CURVE_TYPE}));
        if (r8 == null) goto L20;
        r4 = r8.intValue();
    L20:
        int r10 = r4;
        Float r11 = parseFloat(opt(r9, new String[]{MaterialConfigFormatNames.END_POINT}));
        if (r11 != null) goto L23;
        float r12 = 1.0f;
    L25:
        return new BlurConfig(r3, r5, r7, r10, r12);
    L23:
        r12 = r11.floatValue();
        goto L25
    L15:
        r7 = r6.floatValue();
        goto L16
    L11:
        r5 = r2.intValue();
        goto L12
    }

    private final ShadowConfig[] parseShadowArray(Object r7) {
        Object[] r0 = null;
        if ((r7 instanceof JSONArray) == false) goto L28;
        ArrayList r6 = new ArrayList();
        JSONArray r8 = (JSONArray) r7;
        int r1 = r8.length();
        boolean r2 = false;
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L17;
        int r4 = r3 + 1;
        Object r5 = r8.opt(r3);
        if ((r5 instanceof JSONObject) == false) goto L9;
        JSONObject r9 = (JSONObject) r5;
    L10:
        if (r9 == null) goto L16;
        ShadowConfig r10 = INSTANCE.parseShadow(r9);
        if (r10 == null) goto L16;
        r6.add(r10);
    L16:
        r3 = r4;
        goto L5
    L9:
        r9 = null;
        goto L10
    L17:
        Object[] r11 = r6.toArray(new ShadowConfig[0]);
        if (r11 == null) goto L27;
        if (((ShadowConfig[]) r11).length != 0) goto L23;
        r2 = true;
    L23:
        if ((!r2) == false) goto L33;
        r0 = r11;
    L33:
        return (ShadowConfig[]) r0;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L28:
        return null;
    }

    private final ShadowConfig parseShadow(JSONObject r9) {
        Integer r0 = parseColor(opt(r9, new String[]{"color"}));
        if (r0 != null) goto L6;
        return null;
    L6:
        int r4 = r0.intValue();
        Float r1 = parseFloat(opt(r9, new String[]{MaterialConfigFormatNames.X}));
        if (r1 != null) goto L9;
        float r2 = 0.0f;
    L10:
        Float r3 = parseFloat(opt(r9, new String[]{MaterialConfigFormatNames.Y}));
        if (r3 != null) goto L13;
        float r5 = 0.0f;
    L14:
        Float r6 = parseFloat(opt(r9, new String[]{MaterialConfigFormatNames.BLUR_RADIUS}));
        if (r6 != null) goto L17;
        float r7 = 0.0f;
    L18:
        Float r8 = parseFloat(opt(r9, new String[]{MaterialConfigFormatNames.SPREAD}));
        if (r8 != null) goto L21;
        float r10 = 0.0f;
    L22:
        Integer r11 = parseBlendMode(opt(r9, new String[]{MaterialConfigFormatNames.BLEND_MODE}));
        if (r11 != null) goto L25;
        int r12 = -1;
    L27:
        return new ShadowConfig(r2, r5, r7, r4, r10, r12);
    L25:
        r12 = r11.intValue();
        goto L27
    L21:
        r10 = r8.floatValue();
        goto L22
    L17:
        r7 = r6.floatValue();
        goto L18
    L13:
        r5 = r3.floatValue();
        goto L14
    L9:
        r2 = r1.floatValue();
        goto L10
    }

    private final FluidConfig parseFluidConfig(JSONObject r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new FluidConfig(parseFluidParams(r2));
    }

    private final float[] parseFluidParams(JSONObject r11) {
        Float r0 = parseFloat(opt(r11, new String[]{MaterialConfigFormatNames.REFRACTION_HEIGHT}));
        if (r0 != null) goto L5;
        return null;
    L5:
        float r1 = r0.floatValue();
        Float r2 = parseFloat(opt(r11, new String[]{MaterialConfigFormatNames.REFRACTION_STRENGTH}));
        if (r2 != null) goto L8;
        return null;
    L8:
        float r3 = r2.floatValue();
        Float r4 = parseFloat(opt(r11, new String[]{MaterialConfigFormatNames.HIGHLIGHT_ANGLE}));
        if (r4 != null) goto L11;
        return null;
    L11:
        float r5 = r4.floatValue();
        Float r6 = parseFloat(opt(r11, new String[]{MaterialConfigFormatNames.HIGHLIGHT_FALLOFF}));
        if (r6 != null) goto L14;
        return null;
    L14:
        float r7 = r6.floatValue();
        Float r8 = parseFloat(opt(r11, new String[]{MaterialConfigFormatNames.HIGHLIGHT_WIDTH}));
        if (r8 != null) goto L17;
        return null;
    L17:
        float r9 = r8.floatValue();
        Float r10 = parseFloat(opt(r11, new String[]{MaterialConfigFormatNames.HIGHLIGHT_ALPHA}));
        if (r10 != null) goto L20;
        return null;
    L20:
        float r12 = r10.floatValue();
        Float r13 = parseFloat(opt(r11, new String[]{MaterialConfigFormatNames.HIGHLIGHT_INSET}));
        if (r13 != null) goto L23;
        return null;
    L23:
        float r14 = r13.floatValue();
        Float r15 = parseFloat(opt(r11, new String[]{MaterialConfigFormatNames.HIGHLIGHT_STRENGTH}));
        if (r15 != null) goto L26;
        return null;
    L26:
        int r16 = 0;
        float[] r17 = {r1, r3, r5, r7, r9, r12, r14, r15.floatValue()};
        Integer r18 = parseColor(opt(r11, new String[]{MaterialConfigFormatNames.FIRST_LAYER_HIGHLIGHT_COLOR}));
        Integer r19 = parseBlendMode(opt(r11, new String[]{MaterialConfigFormatNames.FIRST_LAYER_HIGHLIGHT_BLEND_MODE}));
        Integer r20 = parseColor(opt(r11, new String[]{MaterialConfigFormatNames.SECOND_LAYER_HIGHLIGHT_COLOR}));
        Integer r21 = parseBlendMode(opt(r11, new String[]{MaterialConfigFormatNames.SECOND_LAYER_HIGHLIGHT_BLEND_MODE}));
        Float r110 = parseFloat(opt(r11, new String[]{MaterialConfigFormatNames.CHROMATIC_ABERRATION}));
        if (r18 != null) goto L32;
        if (r19 != null) goto L32;
        if (r20 != null) goto L32;
        if (r21 != null) goto L32;
        if (r110 != null) goto L32;
        return r17;
    L32:
        FloatSpreadBuilder r111 = new FloatSpreadBuilder(6);
        r111.addSpread(r17);
        FloatCompanionObject r22 = FloatCompanionObject.INSTANCE;
        if (r18 != null) goto L35;
        int r23 = 0;
    L36:
        r111.add(Float.intBitsToFloat(r23));
        if (r19 != null) goto L39;
        int r24 = BlendMode.SRC_OVER.porterDuffMode;
    L40:
        r111.add(r24);
        FloatCompanionObject r25 = FloatCompanionObject.INSTANCE;
        if (r20 == null) goto L44;
        r16 = r20.intValue();
    L44:
        r111.add(Float.intBitsToFloat(r16));
        if (r21 != null) goto L47;
        int r26 = BlendMode.SRC_OVER.porterDuffMode;
    L48:
        r111.add(r26);
        if (r110 != null) goto L51;
        float r112 = 0.0f;
    L52:
        r111.add(r112);
        return r111.toArray();
    L51:
        r112 = r110.floatValue();
        goto L52
    L47:
        r26 = r21.intValue();
        goto L48
    L39:
        r24 = r19.intValue();
        goto L40
    L35:
        r23 = r18.intValue();
        goto L36
    }

    private final ColorStateList parseColorStateList(Object r9) {
        Integer r0 = parseColor(r9);
        if (r0 != null) goto L36;
        if ((r9 instanceof JSONObject) == false) goto L7;
        JSONObject r10 = (JSONObject) r9;
    L8:
        if (r10 != null) goto L10;
        return null;
    L10:
        Integer r1 = parseColor(opt(r10, new String[]{"normal"}));
        if (r1 != null) goto L13;
        return null;
    L13:
        int r2 = r1.intValue();
        Integer r3 = parseColor(opt(r10, new String[]{MaterialConfigFormatNames.PRESS}));
        if (r3 != null) goto L16;
        int r4 = r2;
    L17:
        Integer r5 = parseColor(opt(r10, new String[]{MaterialConfigFormatNames.HOVER}));
        if (r5 != null) goto L20;
        int r6 = r4;
    L21:
        Integer r7 = parseColor(opt(r10, new String[]{"checked"}));
        if (r7 != null) goto L24;
        int r8 = r2;
    L25:
        Integer r11 = parseColor(opt(r10, new String[]{MaterialConfigFormatNames.SELECTED}));
        if (r11 != null) goto L28;
        int r12 = r2;
    L29:
        Integer r13 = parseColor(opt(r10, new String[]{MaterialConfigFormatNames.DISABLE}));
        if (r13 != null) goto L32;
        int r14 = r2;
    L34:
        return new ColorStateList(MATERIAL_STATE_SPECS, new int[]{r8, r8, r12, r12, r12, r12, r4, r6, r8, r12, r14, r2});
    L32:
        r14 = r13.intValue();
        goto L34
    L28:
        r12 = r11.intValue();
        goto L29
    L24:
        r8 = r7.intValue();
        goto L25
    L20:
        r6 = r5.intValue();
        goto L21
    L16:
        r4 = r3.intValue();
        goto L17
    L7:
        r10 = null;
        goto L8
    L36:
        return ColorStateList.valueOf(r0.intValue());
    }

    private final Integer parseColor(Object r5) {
        if ((r5 instanceof Number) == true) goto L33;
        Object r1 = null;
        if ((r5 instanceof String) == false) goto L30;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L22
        MaterialJsonParser r4 = this;     // Catch: Throwable -> L22
        String r6 = StringsKt.trim((String) r5).toString();     // Catch: Throwable -> L22
        if (StringsKt.startsWith$default(r6, "#", false, 2, null) == false) goto L11;
        int r7 = Color.parseColor(r6);     // Catch: Throwable -> L22
    L20:
        Object r8 = Result.m774constructorimpl(Integer.valueOf(r7));     // Catch: Throwable -> L22
    L25:
        if (Result.m780isFailureimpl(r8) == true) goto L34;
        r1 = r8;
    L34:
        return (Integer) r1;
    L11:
        if (StringsKt.startsWith(r6, "0x", true) == false) goto L13;
        String r9 = r6.substring(2);     // Catch: Throwable -> L22
        Intrinsics.checkNotNullExpressionValue(r9, "this as java.lang.String).substring(startIndex)");     // Catch: Throwable -> L22
        r7 = (int) Long.parseLong(r9, CharsKt.checkRadix(16));     // Catch: Throwable -> L22
        goto L20
    L13:
        Long r10 = StringsKt.toLongOrNull(r6);     // Catch: Throwable -> L22
        if (r10 != null) goto L16;
        Integer r11 = null;
    L17:
        if (r11 != null) goto L19;
        r7 = Color.parseColor(r6);     // Catch: Throwable -> L22
        goto L20
    L19:
        r7 = r11.intValue();     // Catch: Throwable -> L22
        goto L20
    L16:
        r11 = Integer.valueOf((int) r10.longValue());     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r8 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L25
    L30:
        return null;
    L33:
        return Integer.valueOf(((Number) r5).intValue());
    }

    private final Float parseFloat(Object r1) {
        if ((r1 instanceof Number) == false) goto L6;
        return Float.valueOf(((Number) r1).floatValue());
    L6:
        if ((r1 instanceof String) == true) goto L11;
        return null;
    L11:
        return StringsKt.toFloatOrNull(StringsKt.removeSuffix(StringsKt.removeSuffix(StringsKt.removeSuffix(StringsKt.trim((String) r1).toString(), "dp"), "px"), CloudControlInf.SP));
    }

    private final Integer parseInt(Object r2) {
        if ((r2 instanceof Number) == false) goto L6;
        return Integer.valueOf(((Number) r2).intValue());
    L6:
        if ((r2 instanceof String) == false) goto L11;
        Integer r0 = StringsKt.toIntOrNull(StringsKt.trim((String) r2).toString());
        if (r0 != null) goto L15;
        return parseColor(r2);
    L15:
        return r0;
    L11:
        return null;
    }

    private final Integer parseBlendMode(Object r2) {
        Integer r0 = parseInt(r2);
        if (r0 != null) goto L9;
        BlendMode r1 = parseBlendModeEnum(r2);
        if (r1 != null) goto L8;
        return null;
    L8:
        return Integer.valueOf(r1.porterDuffMode);
    L9:
        return r0;
    }

    private final BlendMode parseBlendModeEnum(Object r6) {
        if ((r6 instanceof String) == false) goto L5;
        String r7 = (String) r6;
    L6:
        int r5 = 0;
        if (r7 != null) goto L9;
    L8:
        String r8 = null;
    L17:
        if (r8 != null) goto L19;
        return null;
    L19:
        String r9 = r8.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r9, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        BlendMode[] r1 = BlendMode.values();
        int r2 = r1.length;
    L20:
        if (r5 >= r2) goto L28;
        BlendMode r3 = r1[r5];
        if (Intrinsics.areEqual(r3.name(), r9) == true) goto L25;
        r5 = r5 + 1;
        goto L20
    L25:
        return r3;
    L28:
        return null;
    L9:
        r8 = StringsKt.trim(r7).toString();
        if (r8 == null) goto L8;
        if (r8.length() <= 0) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L8;
    L15:
        r4 = false;
        goto L16
    L5:
        r7 = null;
        goto L6
    }

    private final Integer parseBlurDirection(Object r2) {
        Integer r1 = parseInt(r2);
        if (r1 != null) goto L45;
        if ((r2 instanceof String) == false) goto L7;
        String r3 = (String) r2;
    L8:
        if (r3 != null) goto L10;
    L9:
        String r4 = null;
    L14:
        if (r4 != null) goto L17;
        return null;
    L17:
        switch(r4.hashCode()) {
            case -1372950257: goto L40;
            case -1039745817: goto L36;
            case -885896177: goto L32;
            case -149309725: goto L28;
            case 3387192: goto L24;
            case 818060433: goto L20;
            default: goto L51;
        };
    L51:
        return null;
    L20:
        if (r4.equals("progress_rightleft") == true) goto L46;
        return null;
    L46:
        return 4;
    L24:
        if (r4.equals("none") == true) goto L47;
        return null;
    L47:
        return -1;
    L28:
        if (r4.equals("progress_leftright") == true) goto L48;
        return null;
    L48:
        return 3;
    L32:
        if (r4.equals("progress_updown") == true) goto L49;
        return null;
    L49:
        return 2;
    L36:
        if (r4.equals("normal") == true) goto L50;
        return null;
    L50:
        return 0;
    L40:
        if (r4.equals("progress_downup") == true) goto L43;
        return null;
    L43:
        return 1;
    L10:
        String r5 = StringsKt.trim(r3).toString();
        if (r5 == null) goto L9;
        r4 = r5.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r4, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        goto L14
    L7:
        r3 = null;
        goto L8
    L45:
        return Integer.valueOf(r1.intValue());
    }

    private final Integer parseCurveType(Object r2) {
        Integer r1 = parseInt(r2);
        if (r1 != null) goto L49;
        if ((r2 instanceof String) == false) goto L7;
        String r3 = (String) r2;
    L8:
        if (r3 != null) goto L10;
    L9:
        String r4 = null;
    L14:
        if (r4 != null) goto L17;
        return null;
    L17:
        switch(r4.hashCode()) {
            case -1102672091: goto L44;
            case -356211779: goto L40;
            case -32570448: goto L36;
            case 54365080: goto L32;
            case 1672389401: goto L28;
            case 1829408660: goto L24;
            case 1939029025: goto L20;
            default: goto L56;
        };
    L56:
        return null;
    L20:
        if (r4.equals("in_quad") == true) goto L50;
        return null;
    L50:
        return 1;
    L24:
        if (r4.equals("inout_cubic") == true) goto L51;
        return null;
    L51:
        return 6;
    L28:
        if (r4.equals("out_cubic") == true) goto L52;
        return null;
    L52:
        return 5;
    L32:
        if (r4.equals("out_quad") == true) goto L53;
        return null;
    L53:
        return 2;
    L36:
        if (r4.equals("in_cubic") == true) goto L54;
        return null;
    L54:
        return 4;
    L40:
        if (r4.equals("inout_quad") == true) goto L55;
        return null;
    L55:
        return 3;
    L44:
        if (r4.equals("linear") == true) goto L47;
        return null;
    L47:
        return 0;
    L10:
        String r5 = StringsKt.trim(r3).toString();
        if (r5 == null) goto L9;
        r4 = r5.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r4, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        goto L14
    L7:
        r3 = null;
        goto L8
    L49:
        return Integer.valueOf(r1.intValue());
    }

    private final Object opt(JSONObject r4, String... r5) {
        int r3 = r5.length;
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L10;
        String r1 = r5[r0];
        r0 = r0 + 1;
        if (r4.has(r1) == false) goto L3;
        if (r4.isNull(r1) == true) goto L3;
        return r4.opt(r1);
    L10:
        return null;
    }

    private final String optString(JSONObject r2, String... r3) {
        Object r1 = opt(r2, (String[]) Arrays.copyOf(r3, r3.length));
        if ((r1 instanceof String) == false) goto L5;
        String r4 = (String) r1;
    L6:
        if (r4 == null) goto L19;
        String r5 = StringsKt.trim(r4).toString();
        if (r5 != null) goto L12;
        return null;
    L12:
        if (r5.length() <= 0) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == true) goto L17;
        return null;
    L17:
        return r5;
    L14:
        r6 = false;
        goto L15
    L19:
        return null;
    L5:
        r4 = null;
        goto L6
    }

    private final boolean optBoolean(JSONObject r3, String r4, boolean r5) {
        Object r2 = opt(r3, new String[]{r4});
        if ((r2 instanceof Boolean) == false) goto L6;
        return ((Boolean) r2).booleanValue();
    L6:
        if ((r2 instanceof String) == false) goto L13;
        Boolean r6 = StringsKt.toBooleanStrictOrNull((String) r2);
        if (r6 != null) goto L11;
        return r5;
    L11:
        return r6.booleanValue();
    L13:
        return r5;
    }

    private final JSONObject optJSONObject(JSONObject r2, String... r3) {
        Object r1 = opt(r2, (String[]) Arrays.copyOf(r3, r3.length));
        if ((r1 instanceof JSONObject) == true) goto L7;
        return null;
    L7:
        return (JSONObject) r1;
    }

    private final JSONArray optJSONArray(JSONObject r2, String... r3) {
        Object r1 = opt(r2, (String[]) Arrays.copyOf(r3, r3.length));
        if ((r1 instanceof JSONArray) == true) goto L7;
        return null;
    L7:
        return (JSONArray) r1;
    }
}
