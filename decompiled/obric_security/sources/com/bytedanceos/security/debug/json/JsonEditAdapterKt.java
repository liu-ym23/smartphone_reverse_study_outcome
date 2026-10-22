package com.bytedanceos.security.debug.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: JsonEditAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0006\u001a\f\u0010\u0007\u001a\u00020\u0005*\u00020\u0001H\u0002\u001a\u000e\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u0001H\u0002\u001a\f\u0010\n\u001a\u00020\u0005*\u00020\u0001H\u0002\u001a\u000e\u0010\u000b\u001a\u0004\u0018\u00010\u0001*\u00020\u0005H\u0002¨\u0006\f"}, d2 = {"defaultFromTemplate", "Lcom/google/gson/JsonElement;", "template", "arrayIndexOrNull", "", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "asDisplayString", "asJsonPrimitiveOrNull", "Lcom/google/gson/JsonPrimitive;", "containerLabel", "toJsonNumberOrNull", "app_neridaCnRelease"}, k = 2, mv = {1, 4, 3})
public final class JsonEditAdapterKt {
    public static final /* synthetic */ Integer access$arrayIndexOrNull(String r0) {
        return arrayIndexOrNull(r0);
    }

    public static final /* synthetic */ String access$asDisplayString(JsonElement r0) {
        return asDisplayString(r0);
    }

    public static final /* synthetic */ JsonPrimitive access$asJsonPrimitiveOrNull(JsonElement r0) {
        return asJsonPrimitiveOrNull(r0);
    }

    public static final /* synthetic */ String access$containerLabel(JsonElement r0) {
        return containerLabel(r0);
    }

    public static final /* synthetic */ JsonElement access$toJsonNumberOrNull(String r0) {
        return toJsonNumberOrNull(r0);
    }

    private static final String asDisplayString(JsonElement r1) {
        if (r1.isJsonNull() == false) goto L7;
        return "null";
    L7:
        if (r1.isJsonPrimitive() == true) goto L10;
        return "";
    L10:
        JsonPrimitive r2 = r1.getAsJsonPrimitive();
        Intrinsics.checkNotNullExpressionValue(r2, "p");
        if (r2.isBoolean() == false) goto L14;
        return String.valueOf(r2.getAsBoolean());
    L14:
        if (r2.isNumber() == false) goto L17;
        return r2.getAsNumber().toString();
    L17:
        if (r2.isString() == false) goto L19;
        String r3 = r2.getAsString();
        Intrinsics.checkNotNullExpressionValue(r3, "p.asString");
        return r3;
    L19:
        String r4 = r2.toString();
        Intrinsics.checkNotNullExpressionValue(r4, "p.toString()");
        return r4;
    }

    private static final JsonPrimitive asJsonPrimitiveOrNull(JsonElement r1) {
        if (r1.isJsonPrimitive() == true) goto L7;
        return null;
    L7:
        return r1.getAsJsonPrimitive();
    }

    private static final JsonElement toJsonNumberOrNull(String r6) {
        String r7 = StringsKt.trim(r6).toString();
        String r0 = r7;
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        JsonPrimitive r4 = null;
        if (r1 == false) goto L10;
        return null;
    L10:
        if (StringsKt.contains$default(r0, '.', false, 2, null) == false) goto L12;
    L25:
        Double r8 = StringsKt.toDoubleOrNull(r7);
        if (r8 == null) goto L29;
        r4 = new JsonPrimitive(Double.valueOf(r8.doubleValue()));
    L29:
        return r4;
    L12:
        if (StringsKt.contains(r0, 'e', true) == true) goto L25;
        Long r9 = StringsKt.toLongOrNull(r7);
        if (r9 == null) goto L24;
        long r2 = r9.longValue();
        long r5 = Integer.MAX_VALUE;
        if (Integer.MIN_VALUE <= r2) goto L20;
    L22:
        JsonPrimitive r10 = new JsonPrimitive(Long.valueOf(r2));
    L30:
        return r10;
    L20:
        if (r5 < r2) goto L22;
        r10 = new JsonPrimitive(Integer.valueOf((int) r2));
        goto L30
    L24:
        return null;
    L5:
        r1 = false;
        goto L6
    }

    private static final String containerLabel(JsonElement r2) {
        if (r2.isJsonObject() == false) goto L6;
        return "object {" + r2.getAsJsonObject().entrySet().size() + '}';
    L6:
        if (r2.isJsonArray() == true) goto L11;
        return "";
    L11:
        return "array [" + r2.getAsJsonArray().size() + ']';
    }

    private static final Integer arrayIndexOrNull(String r4) {
        if (r4.length() >= 3) goto L5;
        return null;
    L5:
        String r0 = r4;
        if (StringsKt.first(r0) == '[') goto L8;
    L12:
        return null;
    L8:
        if (StringsKt.last(r0) != ']') goto L12;
        String r5 = r4.substring(1, r4.length() - 1);
        Intrinsics.checkNotNullExpressionValue(r5, "this as java.lang.String…ing(startIndex, endIndex)");
        return StringsKt.toIntOrNull(r5);
    }

    public static final JsonElement defaultFromTemplate(JsonElement r3) {
        if (r3 != null) goto L6;
        return new JsonObject();
    L6:
        if (r3.isJsonObject() == false) goto L13;
        JsonObject r0 = new JsonObject();
        Iterator<Map.Entry<String, JsonElement>> r4 = r3.getAsJsonObject().entrySet().iterator();
    L9:
        if (r4.hasNext() == false) goto L35;
        Map.Entry<String, JsonElement> r1 = r4.next();
        r0.add(r1.getKey(), defaultFromTemplate(r1.getValue()));
        goto L9
    L35:
        return r0;
    L13:
        if (r3.isJsonArray() == false) goto L16;
        return new JsonArray();
    L16:
        if (r3.isJsonNull() == false) goto L19;
        JsonNull r5 = JsonNull.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r5, "JsonNull.INSTANCE");
        return r5;
    L19:
        if (r3.isJsonPrimitive() == false) goto L32;
        JsonPrimitive r6 = r3.getAsJsonPrimitive();
        Intrinsics.checkNotNullExpressionValue(r6, "p");
        if (r6.isBoolean() == false) goto L25;
        JsonNull r7 = new JsonPrimitive(false);
    L23:
        JsonElement r2 = r7;
        Intrinsics.checkNotNullExpressionValue(r2, "when {\n                p…ll.INSTANCE\n            }");
        return r2;
    L25:
        if (r6.isNumber() == false) goto L28;
        r7 = new JsonPrimitive((Number) 0);
        goto L23
    L28:
        if (r6.isString() == false) goto L30;
        r7 = new JsonPrimitive("");
        goto L23
    L30:
        r7 = JsonNull.INSTANCE;
        goto L23
    L32:
        JsonNull r8 = JsonNull.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r8, "JsonNull.INSTANCE");
        return r8;
    }
}
