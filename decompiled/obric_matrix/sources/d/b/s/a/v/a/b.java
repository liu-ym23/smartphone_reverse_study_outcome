package d.b.s.a.v.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Integer, a> f14939a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<a> f14940b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f14941c;

    static {
        f14939a = new HashMap();
        f14940b = new ArrayList();
        f14941c = "";
    }

    public static List<a> a() {
        return f14940b;
    }

    public static a b(int... r4) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        int r2 = r4[r1];
        a r3 = f14939a.get(Integer.valueOf(r2));
        if (r3 != null) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public static Map<Integer, a> c() {
        return f14939a;
    }

    public static String d() {
        return f14941c;
    }

    public static void e(a... r1) {
        f(r1);
        Collections.addAll(f14940b, r1);
    }

    private static void f(a... r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L13;
        a r2 = r5[r1];
        if (f14939a.containsValue(r2) == true) goto L12;
        if (f14940b.contains(r2) == true) goto L12;
        String r3 = r2.getName();
        if (f14941c.length() <= 0) goto L11;
        f14941c += ",";
    L11:
        f14941c += r3;
    L12:
        r1 = r1 + 1;
        goto L3
    }
}
