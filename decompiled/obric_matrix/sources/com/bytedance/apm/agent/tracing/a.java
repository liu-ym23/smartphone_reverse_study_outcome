package com.bytedance.apm.agent.tracing;

import androidx.annotation.WorkerThread;
import com.bytedance.apm.d;
import com.bytedance.apm.t.d.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f1263a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f1264b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f1265c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f1266d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f1267e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f1268f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static long f1269g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static long f1270h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static long f1271i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static long f1272j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static long f1273k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static long f1274l = 0;
    private static long m = 0;
    private static boolean n = false;
    public static String o = null;
    private static long p = 15000;

    /* JADX INFO: renamed from: com.bytedance.apm.agent.tracing.a$a, reason: collision with other inner class name */
    static class RunnableC0038a implements Runnable {
        RunnableC0038a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.j();
        }
    }

    static {
    }

    public static JSONArray a() {
        JSONArray r0 = new JSONArray();
        JSONObject r1 = new JSONObject();
        r1.put("module_name", "base");
        r1.put("span_name", "app_constructor");
        r1.put("start", f1263a);
        r1.put("end", f1264b);
        JSONObject r5 = new JSONObject();
        r5.put("module_name", "base");
        r5.put("span_name", "app_attachBaseContext");
        r5.put("start", f1265c);
        r5.put("end", f1266d);
        JSONObject r6 = new JSONObject();
        r6.put("module_name", "base");
        r6.put("span_name", "app_onCreate");
        r6.put("start", f1267e);
        r6.put("end", f1268f);
        JSONObject r9 = new JSONObject();
        r9.put("module_name", "base");
        r9.put("span_name", "activity_onCreate");
        r9.put("start", f1269g);
        r9.put("end", f1270h);
        JSONObject r10 = new JSONObject();
        r10.put("module_name", "base");
        r10.put("span_name", "activity_onResume");
        r10.put("start", f1273k);
        r10.put("end", f1274l);
        JSONObject r11 = new JSONObject();
        r11.put("module_name", "base");
        r11.put("span_name", "activity_onStart");
        r11.put("start", f1271i);
        r11.put("end", f1272j);
        if (m <= 0) goto L5;
        JSONObject r8 = new JSONObject();
        r8.put("module_name", "base");
        r8.put("span_name", "activity_onWindowFocusChanged");
        r8.put("start", m);
        r0.put(r8);
    L5:
        r0.put(r1);
        r0.put(r5);
        r0.put(r6);
        r0.put(r9);
        r0.put(r10);
        r0.put(r11);
        return r0;
    }

    public static void b(long r4, long r6, long r8, long r10, long r12, long r14) {
        com.bytedance.apm.v.a.b().d("assignAppTime: " + f1268f);
        f1263a = r4;
        f1264b = r6;
        f1265c = r8;
        f1266d = r10;
        f1267e = r12;
        f1268f = r14;
        d.L(r4);
    }

    public static void c() {
        com.bytedance.apm.v.a.b().d("onCreateEnd " + f1269g + " " + f1270h);
        if (f1270h == 0) goto L5;
        return;
    L5:
        if (n == false) goto L9;
        f1270h = System.currentTimeMillis();
        return;
    }

    public static void d(String r11) {
        com.bytedance.apm.v.a r0 = com.bytedance.apm.v.a.b();
        StringBuilder r1 = new StringBuilder();
        r1.append(r11);
        r1.append(" onCreateStart ");
        r1.append(f1269g);
        r1.append(" ");
        boolean r5 = false;
        if ((f1269g - f1268f) >= 800) goto L5;
        boolean r4 = true;
    L6:
        r1.append(r4);
        r0.d(r1.toString());
        if (f1269g != 0) goto L15;
        f1269g = System.currentTimeMillis();
        com.bytedance.apm.v.a r2 = com.bytedance.apm.v.a.b();
        StringBuilder r3 = new StringBuilder();
        r3.append(r11);
        r3.append(" onCreateStart ");
        r3.append(f1269g);
        r3.append("  ");
        r3.append(f1268f);
        r3.append(" ");
        if ((f1269g - f1268f) >= 800) goto L11;
        r5 = true;
    L11:
        r3.append(r5);
        r2.d(r3.toString());
        if ((f1269g - f1268f) >= 800) goto L16;
        n = true;
        o = r11;
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r4 = false;
        goto L6
    }

    public static void e() {
        com.bytedance.apm.v.a.b().d("onResumeEnd " + f1273k + " " + f1274l);
        if (f1274l == 0) goto L5;
        return;
    L5:
        if (n == false) goto L9;
        f1274l = System.currentTimeMillis();
        return;
    }

    public static void f(String r4) {
        com.bytedance.apm.v.a.b().d(r4 + " onResume " + f1273k);
        if (f1273k == 0) goto L5;
        return;
    L5:
        if (n == false) goto L9;
        f1273k = System.currentTimeMillis();
        return;
    }

    public static void g(String r4) {
        com.bytedance.apm.v.a.b().d("onStartEnd " + f1271i + " " + f1272j);
        if (f1272j == 0) goto L5;
        return;
    L5:
        if (n == false) goto L9;
        f1272j = System.currentTimeMillis();
        return;
    }

    public static void h(String r4) {
        com.bytedance.apm.v.a.b().d(r4 + " onStart " + f1271i);
        if (f1271i == 0) goto L5;
        return;
    L5:
        if (n == false) goto L9;
        f1271i = System.currentTimeMillis();
        return;
    }

    public static void i(String r5) {
        com.bytedance.apm.v.a.b().d("OnWindowFocusChanged " + r5 + " " + m + " " + f1267e + " " + n);
        if (m == 0) goto L5;
    L9:
        com.bytedance.apm.f0.b.f().i(new RunnableC0038a());
        return;
    L5:
        if (f1267e <= 0) goto L9;
        if (n == false) goto L9;
        m = System.currentTimeMillis();
        o = r5;
        n = false;
        goto L9
    }

    @WorkerThread
    public static void j() {
        if (d.u() != (-1)) goto L6;
        com.bytedance.apm.v.a.b().d("auto launch mode not init");     // Catch: JSONException -> L16
        return;
    L6:
        long r0 = m - f1263a;     // Catch: JSONException -> L16
        if (r0 > 0) goto L9;
        return;
    L9:
        if (r0 > p) goto L19;
        JSONArray r1 = a();     // Catch: JSONException -> L16
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L16
        r2.put("name", "launch_stats");     // Catch: JSONException -> L16
        r2.put("start", f1263a);     // Catch: JSONException -> L16
        r2.put("end", m);     // Catch: JSONException -> L16
        r2.put("spans", r1);     // Catch: JSONException -> L16
        r2.put("collect_from", 1);     // Catch: JSONException -> L16
        r2.put("page_name", o);     // Catch: JSONException -> L16
        r2.put("launch_mode", d.u());     // Catch: JSONException -> L16
        JSONObject r8 = new JSONObject();     // Catch: JSONException -> L16
        r8.put("trace", r2);     // Catch: JSONException -> L16
        if (d.C() == false) goto L14;
        com.bytedance.apm.v.a.b().d("auto span: " + r2);     // Catch: JSONException -> L16
    L14:
        com.bytedance.apm.t.c.a.p().e(new e("start_trace", "", null, null, r8));     // Catch: JSONException -> L16
        return;
    L19:
        return;
    }

    public static void k(long r0) {
        p = r0;
    }
}
