package d.b.i.a.b.e;

import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f13847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, b> f13848b;

    static {
        f13847a = new a();
        ConcurrentHashMap<String, b> r0 = new ConcurrentHashMap();
        f13848b = r0;
        r0.put("default", f13847a);
    }

    public static boolean a(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L9:
        b r2 = f13847a;
    L8:
        return r2.a();
    L5:
        if (f13848b.get(r1) == null) goto L9;
        r2 = f13848b.get(r1);
        goto L8
    }

    public static int b(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L9:
        b r2 = f13847a;
    L8:
        return r2.f();
    L5:
        if (f13848b.get(r1) == null) goto L9;
        r2 = f13848b.get(r1);
        goto L8
    }

    public static int c(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L9:
        b r2 = f13847a;
    L8:
        return r2.g() * 1000;
    L5:
        if (f13848b.get(r1) == null) goto L9;
        r2 = f13848b.get(r1);
        goto L8
    }

    public static int d(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L9:
        b r2 = f13847a;
    L8:
        return r2.h();
    L5:
        if (f13848b.get(r1) == null) goto L9;
        r2 = f13848b.get(r1);
        goto L8
    }

    public static int e(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L9:
        b r2 = f13847a;
    L8:
        return r2.b();
    L5:
        if (f13848b.get(r1) == null) goto L9;
        r2 = f13848b.get(r1);
        goto L8
    }

    public static JSONObject f(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L9:
        b r2 = f13847a;
    L8:
        return r2.e();
    L5:
        if (f13848b.get(r1) == null) goto L9;
        r2 = f13848b.get(r1);
        goto L8
    }

    public static List<String> g(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L9:
        b r3 = f13847a;
    L8:
        return r3.d(r2);
    L5:
        if (f13848b.get(r1) == null) goto L9;
        r3 = f13848b.get(r1);
        goto L8
    }

    public static void h(String r1, b r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        f13848b.put(r1, r2);
    }
}
