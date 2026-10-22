package z0;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f23359a = null;

    static {
        f23359a = new b();
    }

    public static final JsonArray a(JSONArray r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JsonArray r10 = new JsonArray();
        int r11 = r5.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L23;
        Object r13 = r5.get(r12);
        if ((r13 instanceof Number) == false) goto L8;
        r10.add((Number) r13);
    L22:
        r12 = r12 + 1;
        goto L3
    L8:
        if ((r13 instanceof String) == false) goto L11;
        r10.add((String) r13);
        goto L22
    L11:
        if ((r13 instanceof Character) == false) goto L14;
        r10.add((Character) r13);
        goto L22
    L14:
        if ((r13 instanceof Boolean) == false) goto L17;
        r10.add((Boolean) r13);
        goto L22
    L17:
        if ((r13 instanceof JSONObject) == false) goto L20;
        r10.add(b((JSONObject) r13));
        goto L22
    L20:
        if ((r13 instanceof JSONArray) == false) goto L22;
        r10.add(a((JSONArray) r13));
        goto L22
    L23:
        return r10;
    }

    public static final JsonObject b(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JsonObject r10 = new JsonObject();
        Iterator<String> r11 = r5.keys();
    L4:
        if (r11.hasNext() == false) goto L23;
        String r12 = r11.next();
        Object r13 = r5.get(r12);
        if ((r13 instanceof Number) == true) goto L7;
        if ((r13 instanceof String) == true) goto L10;
        if ((r13 instanceof Character) == true) goto L13;
        if ((r13 instanceof Boolean) == true) goto L16;
        if ((r13 instanceof JSONObject) == true) goto L19;
        if ((r13 instanceof JSONArray) == false) goto L4;
        r10.add(r12, a((JSONArray) r13));
        goto L4
    L19:
        r10.add(r12, b((JSONObject) r13));
        goto L4
    L16:
        r10.addProperty(r12, (Boolean) r13);
        goto L4
    L13:
        r10.addProperty(r12, (Character) r13);
        goto L4
    L10:
        r10.addProperty(r12, (String) r13);
        goto L4
    L7:
        r10.addProperty(r12, (Number) r13);
        goto L4
    L23:
        return r10;
    }

    public static String c(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        return a.a().toJson(r5);
    }
}
