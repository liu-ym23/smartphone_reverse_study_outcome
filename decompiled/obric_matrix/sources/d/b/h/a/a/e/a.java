package d.b.h.a.a.e;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000j.v;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f13255a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArraySet<String> f13256b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final CopyOnWriteArraySet<String> f13257c = null;

    static {
        f13256b = new CopyOnWriteArraySet();
        f13257c = new CopyOnWriteArraySet();
    }

    public static Set<String> a(List<String> r8) {
        CopyOnWriteArraySet<String> r0 = f13256b;
        if (r0.isEmpty() == true) goto L31;
        if (r8 != null) goto L6;
        return null;
    L6:
        if (r8.isEmpty() == true) goto L34;
        HashSet r1 = new HashSet();
        Iterator<String> r2 = r0.iterator();
    L10:
        if (r2.hasNext() == false) goto L20;
        String r3 = r2.next();
        Iterator<String> r4 = r8.iterator();
    L13:
        if (r4.hasNext() == false) goto L10;
        String r5 = r4.next();
        if (r5 == null) goto L13;
        if (r5.contains(r3 + "=") == false) goto L13;
        r1.add(r3);
        goto L13
    L20:
        if (r1.size() > 0) goto L22;
        return null;
    L22:
        return r1;
    L34:
        return null;
    L31:
        return null;
    }

    public static Set<String> b(v r5) {
        CopyOnWriteArraySet<String> r0 = f13257c;
        if (r0.isEmpty() == true) goto L23;
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.k() == 0) goto L26;
        HashSet r1 = new HashSet();
        Iterator<String> r2 = r0.iterator();
    L10:
        if (r2.hasNext() == false) goto L15;
        String r3 = r2.next();
        if (r5.d(r3) == null) goto L10;
        r1.add(r3);
        goto L10
    L15:
        if (r1.size() > 0) goto L17;
        return null;
    L17:
        return r1;
    L26:
        return null;
    L23:
        return null;
    }

    public static boolean c() {
        return f13255a;
    }

    public static void d(JSONObject r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        f();
        JSONObject r3 = r2.optJSONObject("insecure_request_control");
        if (r3 != null) goto L7;
        return;
    L7:
        boolean r1 = false;
        if (r3.optInt("disable_share_insecure_cookie", 0) <= 0) goto L10;
        r1 = true;
    L10:
        f13255a = r1;
        e(r3.optJSONArray("secret_cookie_list"), f13256b);
        e(r3.optJSONArray("secret_header_list"), f13257c);
    }

    private static void e(JSONArray r3, CopyOnWriteArraySet<String> r4) {
        if (r3 == null) goto L12;
        if (r4 == null) goto L19;
        int r0 = 0;
    L14:
        if (r0 >= r3.length()) goto L21;
        String r1 = r3.getString(r0);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r1) == true) goto L11;
        r4.add(r1);     // Catch: JSONException -> L13
    L11:
        r0 = r0 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    private static void f() {
        f13255a = false;
        f13256b.clear();
        f13257c.clear();
    }
}
