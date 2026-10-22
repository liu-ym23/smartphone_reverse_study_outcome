package d.b.b.m.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static JSONObject a(JSONObject r2, String r3) {
        if (r2 != null) goto L8;
        return null;
    L8:
        return r2.optJSONObject("performance_modules").optJSONObject(r3);
    L7:
        return null;
    }
}
