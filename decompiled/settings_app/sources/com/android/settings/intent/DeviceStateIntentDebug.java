package com.android.settings.intent;

import com.obric.oui.material.MaterialConfigBuilder;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import obric.tablet.widget.BytedanceJustifyTextView;
import org.apache.commons.math3.geometry.VectorFormat;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: DeviceStateIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\b\u0010\r\u001a\u00020\u000bH\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0007J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¨\u0006\u0014"}, d2 = {"Lcom/android/settings/intent/DeviceStateIntentDebug;", "", "()V", "appendIndent", "", "result", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "indent", "", "formatDeviceStatesJsonForDisplay", "", MaterialConfigBuilder.SERIALIZATION_FORMAT_JSON, "getUnsupportedDebugResult", "isDebugInvocationSupported", "", "isDebuggable", "roDebuggable", "prettyPrintJson", "validateJson", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DeviceStateIntentDebug {
    public static final DeviceStateIntentDebug INSTANCE = null;

    static {
        INSTANCE = new DeviceStateIntentDebug();
    }

    @JvmStatic
    public static final String getUnsupportedDebugResult() {
        return "{\"supported\":false,\"reason\":\"debug_only\"}";
    }

    @JvmStatic
    public static final boolean isDebugInvocationSupported(boolean r1, int r2) {
        if (r1 == true) goto L8;
        if (r2 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    private DeviceStateIntentDebug() {
    }

    @JvmStatic
    public static final String formatDeviceStatesJsonForDisplay(String r2) {
        Intrinsics.checkNotNullParameter(r2, MaterialConfigBuilder.SERIALIZATION_FORMAT_JSON);
        DeviceStateIntentDebug r0 = INSTANCE;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        r0.validateJson(r2);     // Catch: Throwable -> L5
        Object r3 = Result.m1508constructorimpl(r0.prettyPrintJson(r2));     // Catch: Throwable -> L5
    L7:
        Object r4 = r2;
        if (Result.m1514isFailureimpl(r3) == true) goto L12;
        r4 = r3;
    L12:
        return (String) r4;
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final void validateJson(String r4) {
        String r3 = StringsKt.trim(r4).toString();
        if (StringsKt.startsWith$default(r3, VectorFormat.DEFAULT_PREFIX, false, 2, null) == false) goto L5;
        new JSONObject(r3);
        return;
    L5:
        new JSONArray(r3);
    }

    private final String prettyPrintJson(String r9) {
        StringBuilder r8 = new StringBuilder();
        String r10 = StringsKt.trim(r9).toString();
        int r1 = 0;
        boolean r2 = false;
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r1 >= r10.length()) goto L41;
        char r5 = r10.charAt(r1);
        if (r2 == false) goto L9;
        r8.append(r5);
        r2 = false;
    L40:
        r1 = r1 + 1;
        goto L4
    L9:
        if (r5 != '\\') goto L13;
        if (r3 == false) goto L13;
        r8.append(r5);
        r2 = true;
    L13:
        if (r5 != '\"') goto L16;
        r8.append(r5);
        r3 = !r3;
        goto L40
    L16:
        if (r3 == false) goto L18;
    L22:
        if (r3 == false) goto L24;
    L28:
        if (r3 == false) goto L30;
    L32:
        if (r3 == false) goto L34;
    L36:
        if (r3 == false) goto L38;
    L39:
        r8.append(r5);
        goto L40
    L38:
        if (CharsKt.isWhitespace(r5) == true) goto L40;
    L34:
        if (r5 != ':') goto L36;
        r8.append(": ");
        goto L40
    L30:
        if (r5 != ',') goto L32;
        r8.append(r5);
        r8.append('\n');
        INSTANCE.appendIndent(r8, r4);
        goto L40
    L24:
        if (r5 != '}') goto L26;
    L27:
        r8.append('\n');
        r4 = RangesKt.coerceAtLeast(r4 - 1, 0);
        INSTANCE.appendIndent(r8, r4);
        r8.append(r5);
        goto L40
    L26:
        if (r5 != ']') goto L28;
    L18:
        if (r5 != '{') goto L20;
    L21:
        r8.append(r5);
        r8.append('\n');
        r4 = r4 + 1;
        INSTANCE.appendIndent(r8, r4);
        goto L40
    L20:
        if (r5 != '[') goto L22;
    L41:
        String r11 = r8.toString();
        Intrinsics.checkNotNullExpressionValue(r11, "toString(...)");
        return r11;
    }

    private final void appendIndent(StringBuilder r2, int r3) {
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L5;
        r2.append(BytedanceJustifyTextView.TWO_BLANK);
        r1 = r1 + 1;
        goto L3
    }
}
