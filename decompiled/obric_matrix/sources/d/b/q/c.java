package d.b.q;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f14316a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f14317b = false;

    static {
    }

    private static String a(Context r1) {
        ApplicationInfo r2 = r1.getApplicationInfo();     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return null;
    L6:
        return r2.sourceDir;
    L11:
        return null;
    }

    public static String b(Context r1) {
        if (f14317b == true) goto L5;
        f14316a = d(r1);
        f14317b = true;
    L5:
        Map<String, String> r2 = c(f14316a);
        if (r2 != null) goto L8;
        return "";
    L8:
        if (r2.size() > 0) goto L10;
        return "";
    L10:
        return r2.get("meta_umeng_channel");
    }

    private static Map<String, String> c(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L16;
        return null;
    L16:
        JSONObject r0 = new JSONObject(r5);     // Catch: Exception -> L11 JSONException -> L13
        Iterator<String> r6 = r0.keys();     // Catch: Exception -> L11 JSONException -> L13
        HashMap r2 = new HashMap();     // Catch: Exception -> L11 JSONException -> L13
    L7:
        if (r6.hasNext() == false) goto L10;
        String r3 = r6.next().toString();     // Catch: Exception -> L11 JSONException -> L13
        r2.put(r3, r0.getString(r3));     // Catch: Exception -> L11 JSONException -> L13
    L10:
        return r2;
    L13:
        e = move-exception;
        e.printStackTrace();
    L15:
        return null;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    private static String d(Context r1) {
        return e(r1, 1903654775);
    }

    private static String e(Context r2, int r3) {
        String r4 = a(r2);
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return "";
    L5:
        File r0 = new File(r4);
        String r5 = d.d(r0, r3);
        if (TextUtils.isEmpty(r5) == false) goto L8;
        r5 = d.b.q.f.a.b(r0);
    L8:
        if (r5 != null) goto L11;
        return "";
    L11:
        return r5;
    }
}
