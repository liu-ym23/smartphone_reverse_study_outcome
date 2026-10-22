package d.b.u.d0;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void a(JSONObject r0, String r1, int r2) {
        r0.put(r1, r2);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void b(JSONObject r0, String r1, long r2) {
        r0.put(r1, r2);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void c(JSONObject r0, String r1, String r2) {
        r0.put(r1, r2);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void d(JSONObject r0, String r1, boolean r2) {
        r0.put(r1, r2);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
