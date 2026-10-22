package com.slardaros.client.monitor.startup;

import android.util.Log;
import androidx.annotation.WorkerThread;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.slardaros.client.i;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f11711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f11712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f11713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f11714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f11715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f11716f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static long f11717g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static long f11718h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static long f11719i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static long f11720j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static long f11721k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static long f11722l;
    private static long m;
    private static boolean n;
    public static String o;

    /* JADX INFO: renamed from: com.slardaros.client.monitor.startup.a$a, reason: collision with other inner class name */
    class RunnableC0302a implements Runnable {
        RunnableC0302a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.i();
        }
    }

    public static void a(long r0, long r2, long r4, long r6, long r8, long r10) {
        f11711a = r0;
        f11712b = r2;
        f11713c = r4;
        f11714d = r6;
        f11715e = r8;
        f11716f = r10;
    }

    public static void b() {
        Log.d("monitor plugin", "launcherActivityOnCreateEnd");
        if (f11718h == 0) goto L5;
        return;
    L5:
        if (n == false) goto L9;
        f11718h = System.currentTimeMillis();
        return;
    }

    public static void c(String r4) {
        Log.d("monitor plugin", "launcherActivityOnCreateStart");
        if (f11717g != 0) goto L8;
        long r0 = System.currentTimeMillis();
        f11717g = r0;
        if ((r0 - f11716f) >= 800) goto L9;
        n = true;
        o = r4;
        return;
    L9:
        return;
    }

    public static void d() {
        if (f11722l == 0) goto L5;
        return;
    L5:
        if (n == false) goto L9;
        f11722l = System.currentTimeMillis();
        return;
    }

    public static void e(String r4) {
        if (f11721k == 0) goto L5;
        return;
    L5:
        if (n == false) goto L9;
        f11721k = System.currentTimeMillis();
        return;
    }

    public static void f(String r4) {
        Log.d("monitor plugin", "launcherActivityOnStartStart");
        if (f11720j == 0) goto L5;
        return;
    L5:
        if (n == false) goto L9;
        f11720j = System.currentTimeMillis();
        return;
    }

    public static void g(String r4) {
        Log.d("monitor plugin", "launcherActivityOnStartStart");
        if (f11719i == 0) goto L5;
        return;
    L5:
        if (n == false) goto L9;
        f11719i = System.currentTimeMillis();
        return;
    }

    public static void h(String r4) {
        if (m == 0) goto L5;
    L9:
        new Thread(new RunnableC0302a()).start();
        return;
    L5:
        if (f11715e <= 0) goto L9;
        if (n == false) goto L9;
        m = System.currentTimeMillis();
        o = r4;
        n = false;
        goto L9
    }

    @WorkerThread
    public static void i() {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put("is_first_start", i.e());     // Catch: JSONException -> L4
        r0.put("activity_name", o);     // Catch: JSONException -> L4
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L4
        r1.put("app_construct_time", f11712b - f11711a);     // Catch: JSONException -> L4
        r1.put("app_attach_base_context_time", f11714d - f11713c);     // Catch: JSONException -> L4
        r1.put("app_create_time", f11716f - f11715e);     // Catch: JSONException -> L4
        r1.put("activity_create_time", f11718h - f11717g);     // Catch: JSONException -> L4
        r1.put("activity_start_time", f11720j - f11719i);     // Catch: JSONException -> L4
        r1.put("activity_resume_time", f11722l - f11721k);     // Catch: JSONException -> L4
        r1.put("activity_window_focus_changed", m - f11722l);     // Catch: JSONException -> L4
        r1.put(ICronetClient.KEY_TOTAL_TIME, m - f11711a);     // Catch: JSONException -> L4
        com.slardaros.client.n.a.c("app_startup_event", r0, r1, null);     // Catch: JSONException -> L4
        return;
    }
}
