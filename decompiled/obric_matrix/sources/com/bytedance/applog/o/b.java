package com.bytedance.applog.o;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile com.bytedance.applog.r.b f2257a;

    static class a implements com.bytedance.applog.r.a {
        a() {
        }

        @Override // com.bytedance.applog.r.a
        public boolean a(List<com.bytedance.applog.r.c> r2) {
            if (r2 != null) goto L4;
            return false;
        L4:
            if (r2.size() == 0) goto L22;
            Iterator<com.bytedance.applog.r.c> r1 = r2.iterator();
        L8:
            if (r1.hasNext() == false) goto L13;
            com.bytedance.applog.r.c r3 = r1.next();
            if (r3 == null) goto L8;
            com.bytedance.applog.a.F(r3.f2352a, r3.f2353b);
            goto L8
        L13:
            return true;
        L22:
            return false;
        }
    }

    static {
        f2257a = new com.bytedance.applog.r.b(null, new a());
    }

    public static String a(com.bytedance.applog.w.a r1) {
        if (r1 != null) goto L6;
        return "";
    L6:
        if ((r1 instanceof com.bytedance.applog.w.c) == false) goto L10;
        return ((com.bytedance.applog.w.c) r1).w;
    L10:
        if ((r1 instanceof com.bytedance.applog.w.e) == false) goto L14;
        return ((com.bytedance.applog.w.e) r1).D();
    L14:
        if ((r1 instanceof com.bytedance.applog.w.d) == false) goto L18;
        return ((com.bytedance.applog.w.d) r1).C();
    L18:
        if ((r1 instanceof com.bytedance.applog.w.f) == false) goto L22;
        return "launch";
    L22:
        if ((r1 instanceof com.bytedance.applog.w.i) == false) goto L26;
        return "terminate";
    L26:
        if ((r1 instanceof com.bytedance.applog.w.g) == false) goto L29;
        return "pack";
    L29:
        return "unknown_event_type";
    }

    private static com.bytedance.applog.r.b.a b(com.bytedance.applog.w.a r1) {
        if (r1 != null) goto L6;
        return com.bytedance.applog.r.b.a.f2330f;
    L6:
        if ((r1 instanceof com.bytedance.applog.w.c) == false) goto L10;
        return com.bytedance.applog.r.b.a.f2331g;
    L10:
        if ((r1 instanceof com.bytedance.applog.w.e) == false) goto L14;
        return com.bytedance.applog.r.b.a.f2332h;
    L14:
        if ((r1 instanceof com.bytedance.applog.w.d) == false) goto L18;
        return com.bytedance.applog.r.b.a.f2333i;
    L18:
        if ((r1 instanceof com.bytedance.applog.w.f) == false) goto L22;
        return com.bytedance.applog.r.b.a.f2335k;
    L22:
        if ((r1 instanceof com.bytedance.applog.w.i) == false) goto L26;
        return com.bytedance.applog.r.b.a.f2336l;
    L26:
        if ((r1 instanceof com.bytedance.applog.w.g) == false) goto L30;
        return com.bytedance.applog.r.b.a.n;
    L30:
        return com.bytedance.applog.r.b.a.f2330f;
    }

    private static com.bytedance.applog.r.b.d c(com.bytedance.applog.w.g r2) {
        com.bytedance.applog.r.b.d r0 = com.bytedance.applog.r.b.d.p;
        int r3 = r2.x;
        if (r3 < 0) goto L41;
        if (r3 != 0) goto L8;
        return com.bytedance.applog.r.b.d.R;
    L8:
        if (r3 != 10) goto L11;
        return com.bytedance.applog.r.b.d.S;
    L11:
        if (r3 != 11) goto L14;
        return com.bytedance.applog.r.b.d.T;
    L14:
        if (r3 != 12) goto L17;
        return com.bytedance.applog.r.b.d.U;
    L17:
        if (r3 != 13) goto L20;
        return com.bytedance.applog.r.b.d.V;
    L20:
        if (r3 != 14) goto L23;
        return com.bytedance.applog.r.b.d.W;
    L23:
        if (r3 != 15) goto L26;
        return com.bytedance.applog.r.b.d.X;
    L26:
        if (r3 >= 200) goto L29;
        return com.bytedance.applog.r.b.d.Y;
    L29:
        if (r3 >= 300) goto L32;
        return com.bytedance.applog.r.b.d.Z;
    L32:
        if (r3 >= 400) goto L35;
        return com.bytedance.applog.r.b.d.a0;
    L35:
        if (r3 >= 500) goto L38;
        return com.bytedance.applog.r.b.d.b0;
    L38:
        if (r3 < 600) goto L40;
        return r0;
    L40:
        return com.bytedance.applog.r.b.d.c0;
    L41:
        return com.bytedance.applog.r.b.d.Q;
    }

    public static void d(com.bytedance.applog.r.b.a r1, com.bytedance.applog.r.b.d r2) {
        if (f2257a != null) goto L5;
        return;
    L5:
        f2257a.f(r1, r2);
    }

    public static void e(com.bytedance.applog.w.a r1, com.bytedance.applog.r.b.d r2) {
        if (f2257a != null) goto L5;
        return;
    L5:
        f2257a.f(b(r1), r2);
    }

    public static void f(com.bytedance.applog.r.b.a r1, com.bytedance.applog.r.b.d r2, int r3) {
        if (f2257a != null) goto L5;
        return;
    L5:
        f2257a.g(r1, r2, r3);
    }

    public static void g(com.bytedance.applog.w.g r1, com.bytedance.applog.r.b.d r2) {
        ArrayList r0 = new ArrayList();
        r0.add(r1);
        h(r0, r2);
    }

    public static void h(List<com.bytedance.applog.w.g> r8, com.bytedance.applog.r.b.d r9) {
        if (f2257a == null) goto L18;
        if (r8 != null) goto L6;
        return;
    L6:
        if (r8.size() == 0) goto L27;
        f2257a.g(com.bytedance.applog.r.b.a.n, r9, r8.size());
        Iterator<com.bytedance.applog.w.g> r10 = r8.iterator();
    L10:
        if (r10.hasNext() == false) goto L28;
        com.bytedance.applog.w.g r0 = r10.next();
        JSONObject r2 = new JSONObject(r0.D());     // Catch: Exception -> L19
        JSONArray r1 = r2.optJSONArray("JSON_PARAM_LAUNCH_COUNT");     // Catch: Exception -> L19
        JSONArray r3 = r2.optJSONArray("JSON_PARAM_TERMINATE_COUNT");     // Catch: Exception -> L19
        JSONArray r4 = r2.optJSONArray("JSON_PARAM_EVENT_V1_COUNT");     // Catch: Exception -> L19
        JSONArray r5 = r2.optJSONArray("JSON_PARAM_EVENT_V3_COUNT");     // Catch: Exception -> L19
        JSONArray r6 = r2.optJSONArray("JSON_PARAM_MISC_COUNT");     // Catch: Exception -> L19
        JSONArray r7 = r2.optJSONArray("JSON_PARAM_IMPRESSION_COUNT");     // Catch: Exception -> L19
        if (r9 != com.bytedance.applog.r.b.d.p) goto L15;
        com.bytedance.applog.r.b.d r11 = c(r0);     // Catch: Exception -> L19
    L16:
        j(com.bytedance.applog.r.b.a.f2335k, r11, r1);     // Catch: Exception -> L19
        j(com.bytedance.applog.r.b.a.f2336l, r11, r3);     // Catch: Exception -> L19
        j(com.bytedance.applog.r.b.a.f2331g, r11, r4);     // Catch: Exception -> L19
        j(com.bytedance.applog.r.b.a.f2332h, r11, r5);     // Catch: Exception -> L19
        j(com.bytedance.applog.r.b.a.f2333i, r11, r6);     // Catch: Exception -> L19
        j(com.bytedance.applog.r.b.a.f2334j, r11, r7);     // Catch: Exception -> L19
        goto L10
    L15:
        r11 = r9;
        goto L16
    L28:
        return;
    L27:
        return;
    }

    public static void i(com.bytedance.applog.r.b.a r1, String r2) {
        if (f2257a != null) goto L5;
        return;
    L5:
        f2257a.i(r1, r2);
    }

    private static void j(com.bytedance.applog.r.b.a r3, com.bytedance.applog.r.b.d r4, JSONArray r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        int r0 = 0;
    L6:
        if (r0 >= r5.length()) goto L11;
        if ((r5.get(r0) instanceof Long) == false) goto L10;
        f2257a.g(r3, r4, 1);
    L10:
        r0 = r0 + 1;
        goto L6
    }

    static void k(List<com.bytedance.applog.w.g> r1, List<com.bytedance.applog.w.g> r2) {
        if (f2257a != null) goto L5;
        return;
    L5:
        h(r1, com.bytedance.applog.r.b.d.o);
        h(r2, com.bytedance.applog.r.b.d.p);
    }

    public static void l(com.bytedance.applog.r.b.a r1, com.bytedance.applog.r.b.d r2, long r3) {
        if (f2257a != null) goto L5;
        return;
    L5:
        f2257a.k(r1, r2, r3);
    }
}
