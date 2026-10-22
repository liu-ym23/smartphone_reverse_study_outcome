package d.b.s.a.f0.g;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static a a(String r5) {
        if (TextUtils.isEmpty(r5) == true) goto L18;
        JSONObject r0 = new JSONObject(r5);     // Catch: Exception -> L20
        Iterator<String> r6 = r0.keys();     // Catch: Exception -> L20
        a r1 = new a();     // Catch: Exception -> L20
        if (r6.hasNext() == false) goto L17;
        String r7 = r6.next();     // Catch: Exception -> L20
        if (TextUtils.isEmpty(r7) == true) goto L17;
        byte r2 = -1;
        if (r7.hashCode() == 1481071862) goto L12;
    L14:
        if (r2 != 0) goto L17;
        r1.b(Integer.valueOf(r0.optInt(r7)));     // Catch: Exception -> L20
    L12:
        if (r7.equals("country_code") == false) goto L14;
        r2 = 0;
    L17:
        return r1;
    L18:
        return null;
    L23:
        return null;
    }

    public static String b(a r2) {
        if (r2 != null) goto L11;
        return null;
    L11:
        Integer r3 = r2.a();     // Catch: Exception -> L10
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L10
        if (r3 == null) goto L6;
        r0.put("country_code", r3);     // Catch: Exception -> L10
    L6:
        return r0.toString();
    L13:
        return null;
    }
}
