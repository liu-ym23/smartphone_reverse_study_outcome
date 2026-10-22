package d.b.s.a.l0;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.CookieSyncManager;
import androidx.annotation.NonNull;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class s {
    public static boolean a(Object r3, Object r4) {
        if (r3 != r4) goto L6;
        return true;
    L6:
        if (r3 == null) goto L18;
        if (r4 == null) goto L18;
        if (r3.getClass() == r4.getClass()) goto L13;
        return false;
    L13:
        if ((r3 instanceof JSONObject) == false) goto L17;
        return f((JSONObject) r3, (JSONObject) r4);
    L17:
        return r3.equals(r4);
    L18:
        return false;
    }

    public static void b() {
        CookieSyncManager.getInstance().sync();     // Catch: Throwable -> L4
        return;
    }

    public static String[] c(String r5) {
        int r0 = 0;
        String[] r1 = null;
        String r6 = (String) d.b.s.a.r.a.c(null, "CookieManager", "getCookie", new Object[]{r5});     // Catch: Throwable -> L5
    L7:
        if (TextUtils.isEmpty(r6) == true) goto L9;
        r1 = r6.split(";");
    L9:
        if (r1 != null) goto L11;
    L16:
        return r1;
    L11:
        if (r0 >= r1.length) goto L16;
        String r7 = r1[r0];
        if (r7 == null) goto L15;
        r1[r0] = r7.trim();
    L15:
        r0 = r0 + 1;
    L5:
        r6 = null;
        goto L7
    }

    public static String d(long r2) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").format(new Date(r2));
    }

    public static String e(String r7, String r8) {
        String[] r9 = c(r7);
        if (r9 != null) goto L5;
        return "";
    L5:
        if (r9.length == 0) goto L28;
        int r1 = r9.length;
        int r3 = 0;
    L8:
        if (r3 >= r1) goto L29;
        String r4 = r9[r3];
        if (TextUtils.isEmpty(r4) == true) goto L19;
        String[] r5 = r4.split("=");
        if (r5.length < 2) goto L19;
        if (r5[0] == null) goto L19;
        if (r5[0].trim().equalsIgnoreCase(r8) == false) goto L19;
        return r5[1];
    L19:
        r3 = r3 + 1;
        goto L8
    L29:
        return "";
    L28:
        return "";
    }

    public static boolean f(JSONObject r7, JSONObject r8) {
        if (r7 != r8) goto L6;
        return true;
    L6:
        if (r7 == null) goto L28;
        if (r8 == null) goto L28;
        if (r7.length() != r8.length()) goto L28;
        Iterator<String> r2 = r7.keys();
    L13:
        if (r2.hasNext() == false) goto L27;
        String r3 = r2.next();
        Object r4 = r7.opt(r3);
        Object r5 = r8.opt(r3);
        if (r5 == null) goto L26;
        if (r4.getClass() != r5.getClass()) goto L26;
        if ((r4 instanceof JSONObject) == true) goto L22;
        if (r4.equals(r5) == true) goto L13;
    L22:
        if (f((JSONObject) r4, (JSONObject) r5) == true) goto L13;
        return false;
    L26:
        return false;
    L27:
        return true;
    L28:
        return false;
    }

    public static JSONArray g(@NonNull JSONArray r3, int r4) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        r3.remove(r4);
        return r3;
    L6:
        if (r4 < 0) goto L17;
        if (r4 > (r3.length() - 1)) goto L17;
        JSONArray r0 = new JSONArray();
        int r1 = 0;
    L11:
        if (r1 >= r3.length()) goto L15;
        if (r1 == r4) goto L14;
        r0.put(r3.get(r1));
    L14:
        r1 = r1 + 1;
        goto L11
    L15:
        return r0;
    L17:
        throw new IndexOutOfBoundsException();
    }

    public static String h(String r1) {
        return i(r1, 3, 3);
    }

    public static String i(String r5, int r6, int r7) {
        if (r5 != null) goto L4;
        return "";
    L4:
        if (r5.isEmpty() == true) goto L18;
        int r0 = r5.length();
        if ((r6 + r7) < r0) goto L9;
        return "*";
    L9:
        StringBuilder r1 = new StringBuilder();
        int r3 = 0;
        r1.append(r5, 0, r6);
    L11:
        if (r3 >= ((r0 - r6) - r7)) goto L13;
        r1.append("*");
        r3 = r3 + 1;
        goto L11
    L13:
        r1.append(r5, r0 - r7, r0);
        return r1.toString();
    L18:
        return "";
    }

    public static String j(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L7;
        return "";
    L7:
        if (r4.length() >= 10) goto L9;
        return r4;
    L9:
        return r4.substring(0, 9) + "****" + r4.substring(r4.length() - 10);
    }

    public static List<Pair<String, String>> k(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L6;
        return null;
    L6:
        ArrayList r1 = new ArrayList();
        String[] r9 = r8.split("&");     // Catch: Throwable -> L12
        int r2 = r9.length;     // Catch: Throwable -> L12
        int r4 = 0;
    L8:
        if (r4 >= r2) goto L11;
        String[] r5 = r9[r4].split("=");     // Catch: Throwable -> L12
        r1.add(new Pair(URLDecoder.decode(r5[0], "UTF-8"), URLDecoder.decode(r5[1], "UTF-8")));     // Catch: Throwable -> L12
        r4 = r4 + 1;
    L11:
        return r1;
    }
}
