package d.b.i.a.b.g;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, c> f13871a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, b> f13872b = null;

    static {
        f13871a = new ConcurrentHashMap();
        f13872b = new ConcurrentHashMap();
    }

    public static c a(String r1) {
        return f13871a.get(r1);
    }

    public static b b(String r1) {
        return f13872b.get(r1);
    }

    public static boolean c(String r1, String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return false;
    L7:
        return f13872b.get(r1).a(r2);
    }

    public static void d(String r1, c r2) {
        f13871a.put(r1, r2);
    }

    public static void e(String r1, b r2) {
        f13872b.put(r1, r2);
    }
}
