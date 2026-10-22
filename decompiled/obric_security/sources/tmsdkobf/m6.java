package tmsdkobf;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public abstract class m6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f347a;
    private static String b;
    private static String c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;
    private static String h;
    private static String i;
    private static String j;
    private static List k;
    private static List l;

    static {
        k = new ArrayList();
        l = new ArrayList();
    }

    public static String a() {
        return e;
    }

    public static String b() {
        return j;
    }

    public static List c() {
        return k;
    }

    public static List d() {
        return l;
    }

    public static String e() {
        return b;
    }

    public static String f() {
        return g;
    }

    public static String g() {
        return d;
    }

    public static String h() {
        return i;
    }

    public static String i() {
        return c;
    }

    public static String j() {
        return h;
    }

    public static String k() {
        return f347a;
    }

    public static String l() {
        return f;
    }

    protected static void a(JSONObject r5) {
        JSONObject r6 = r5.getJSONObject("ipConfig");
        f347a = r6.getString("tcpHost");
        b = r6.getString("tcpDefaultIpPortCm");
        c = r6.getString("tcpDefaultIpPortCu");
        d = r6.getString("tcpDefaultIpPortCt");
        e = r6.getString("httpUrl");
        f = r6.getString("tcpHostV6");
        g = r6.getString("tcpDefaultIpPortCmV6");
        h = r6.getString("tcpDefaultIpPortCuV6");
        i = r6.getString("tcpDefaultIpPortCtV6");
        j = r6.getString("httpUrlV6");
        JSONArray r0 = r6.getJSONArray("ipv4list");
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= r0.length()) goto L6;
        k.add(r0.getString(r2));
        r2 = r2 + 1;
        goto L4
    L6:
        JSONArray r7 = r6.getJSONArray("ipv6list");
    L8:
        if (r1 >= r7.length()) goto L10;
        l.add(r7.getString(r1));
        r1 = r1 + 1;
        goto L8
    }
}
