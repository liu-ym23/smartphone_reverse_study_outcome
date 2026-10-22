package d.b.b.o;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static JSONObject a(JSONObject r3, JSONObject r4) {
        if (r3 == null) goto L15;
        if (r4 == null) goto L15;
        Iterator<String> r1 = r4.keys();
        if (r1 != null) goto L10;
        return null;
    L10:
        if (r1.hasNext() == false) goto L14;
        String r0 = r1.next();
        if (r4.isNull(r0) == true) goto L10;
        r3.put(r0, r4.opt(r0));
        goto L10
    L14:
        return r3;
    L15:
        return null;
    }

    public static void b(JSONObject r5, JSONObject r6) {
        if (r6 == null) goto L20;
        if (r5 == null) goto L29;
        Iterator<String> r7 = r6.keys();
    L7:
        if (r7.hasNext() == false) goto L30;
        String[] r0 = r7.next().split("#");
        int r1 = 0;
        JSONObject r2 = r5;
    L10:
        if (r1 >= (r0.length - 1)) goto L18;
        if (r2.has(r0[r1]) == false) goto L17;
        if (r2.get(r0[r1]).getClass().equals(JSONObject.class) == false) goto L17;
        r2 = r2.getJSONObject(r0[r1]);
        r1 = r1 + 1;
    L17:
        r2 = null;
    L18:
        if (r2 == null) goto L7;
        r2.remove(r0[r0.length - 1]);
        goto L7
    L30:
        return;
    L29:
        return;
    }

    public static boolean c(JSONArray r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }

    public static boolean d(JSONObject r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }

    public static void e(JSONObject r7, JSONObject r8) {
        if (r8 == null) goto L18;
        if (r7 == null) goto L23;
        Iterator<String> r0 = r8.keys();
    L7:
        if (r0.hasNext() == false) goto L24;
        String r1 = r0.next();
        String[] r2 = r1.split("#");
        int r3 = 0;
        JSONObject r4 = r7;
    L10:
        if (r3 >= (r2.length - 1)) goto L17;
        if (r4.has(r2[r3]) == true) goto L14;
    L15:
        r4.put(r2[r3], new JSONObject());
    L16:
        r4 = r4.getJSONObject(r2[r3]);
        r3 = r3 + 1;
        goto L10
    L14:
        if (r4.get(r2[r3]).getClass().equals(JSONObject.class) == true) goto L16;
    L17:
        r4.put(r2[r2.length - 1], r8.get(r1));
        goto L7
    L24:
        return;
    L23:
        return;
    }

    public static int f(JSONObject r1, String r2, String r3) {
        if (r1 != null) goto L5;
        return 0;
    L5:
        JSONObject r4 = r1.optJSONObject(r2);
        if (r4 != null) goto L9;
        return 0;
    L9:
        return r4.optInt(r3, 0);
    }

    public static JSONObject g(JSONObject r1, String r2, String r3) {
        if (r1 != null) goto L5;
        return null;
    L5:
        JSONObject r4 = r1.optJSONObject(r2);
        if (r4 != null) goto L9;
        return null;
    L9:
        return r4.optJSONObject(r3);
    }

    public static JSONObject h(JSONObject r0, String r1, String r2, String r3) {
        JSONObject r4 = g(r0, r1, r2);
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.optJSONObject(r3);
    }

    public static int i(JSONObject r2, String r3) {
    L8:
        e = move-exception;
        d.b.b.o.m.b.c("JsonUtils", "removeInt", e);
        return 0;
    L4:
        if (r2.has(r3) == true) goto L6;
        return 0;
    L6:
        int r1 = r2.getInt(r3);     // Catch: Exception -> L8
        r2.remove(r3);     // Catch: Exception -> L8
        return r1;
    }

    public static long j(JSONObject r4, String r5) {
    L8:
        e = move-exception;
        d.b.b.o.m.b.c("JsonUtils", "removeLong", e);
        return 0;
    L4:
        if (r4.has(r5) == true) goto L6;
        return 0;
    L6:
        long r2 = r4.getLong(r5);     // Catch: Exception -> L8
        r4.remove(r5);     // Catch: Exception -> L8
        return r2;
    }

    public static String k(JSONObject r2, String r3) {
    L8:
        e = move-exception;
        d.b.b.o.m.b.c("JsonUtils", "removeString", e);
        return null;
    L4:
        if (r2.has(r3) == true) goto L6;
        return null;
    L6:
        String r1 = r2.getString(r3);     // Catch: Exception -> L8
        r2.remove(r3);     // Catch: Exception -> L8
        return r1;
    }

    public static JSONObject l(JSONObject r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        Iterator<String> r1 = r7.keys();
        if (r1 != null) goto L26;
        return null;
    L26:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L25
    L9:
        if (r1.hasNext() == false) goto L24;
        String r2 = r1.next();     // Catch: Exception -> L25
        Object r3 = r7.opt(r2);     // Catch: Exception -> L25
        if ((r3 instanceof JSONObject) == true) goto L13;
        if ((r3 instanceof JSONArray) == false) goto L15;
        JSONArray r4 = (JSONArray) r3;     // Catch: Exception -> L25
        JSONArray r5 = new JSONArray();     // Catch: Exception -> L25
        int r6 = 0;
    L20:
        if (r6 >= r4.length()) goto L22;
        r5.put(r4.get(r6));     // Catch: Exception -> L25
        r6 = r6 + 1;     // Catch: Exception -> L25
        goto L20
    L22:
        r0.put(r2, r5);     // Catch: Exception -> L25
    L15:
        r0.put(r2, r3);     // Catch: Exception -> L25
        goto L9
    L13:
        r3 = m((JSONObject) r3);     // Catch: Exception -> L25
        if (r3 == null) goto L9;
    L24:
        return r0;
    L25:
        return r7;
    }

    private static JSONObject m(JSONObject r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        Iterator<String> r1 = r4.keys();
        if (r1 != null) goto L15;
        return null;
    L15:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L14
    L10:
        if (r1.hasNext() == false) goto L13;
        String r2 = r1.next();     // Catch: Exception -> L14
        r0.put(r2, r4.opt(r2));     // Catch: Exception -> L14
        goto L10
    L13:
        return r0;
    L14:
        return r4;
    }
}
