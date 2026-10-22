package d.b.h.a.a.e;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f13258a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f13259b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f13260c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f13261d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f13262e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile boolean f13263f = false;

    static {
    }

    public static boolean a() {
        return f13259b;
    }

    public static boolean b() {
        return f13260c;
    }

    public static boolean c() {
        return f13261d;
    }

    public static boolean d() {
        return f13258a;
    }

    public static boolean e() {
        return f13262e;
    }

    public static boolean f() {
        return f13263f;
    }

    public static void g(JSONObject r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        h();
        boolean r1 = false;
        if (r3.optInt("cookie_save_v2_enabled", 0) <= 0) goto L7;
        boolean r0 = true;
    L8:
        f13258a = r0;
        if (r3.optInt("cookie_backup_async_save_enabled", 0) <= 0) goto L11;
        boolean r2 = true;
    L12:
        f13259b = r2;
        if (r3.optInt("cookie_backup_disabled", 0) <= 0) goto L15;
        boolean r4 = true;
    L16:
        f13260c = r4;
        if (r3.optInt("cookie_batch", 0) <= 0) goto L19;
        boolean r5 = true;
    L20:
        f13261d = r5;
        if (r3.optInt("disable_cookie_share_host_match_fix", 0) <= 0) goto L23;
        boolean r6 = true;
    L24:
        f13262e = r6;
        if (r3.optInt("enable_flush_cookie_for_region", 0) <= 0) goto L27;
        r1 = true;
    L27:
        f13263f = r1;
        return;
    L23:
        r6 = false;
        goto L24
    L19:
        r5 = false;
        goto L20
    L15:
        r4 = false;
        goto L16
    L11:
        r2 = false;
        goto L12
    L7:
        r0 = false;
        goto L8
    }

    private static void h() {
        f13258a = false;
        f13259b = false;
        f13260c = false;
        f13261d = false;
        f13262e = false;
        f13263f = false;
    }
}
