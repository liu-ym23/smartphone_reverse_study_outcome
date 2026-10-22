package com.bytedance.apm.agent.tracing;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.apm.d;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AutoPageTraceHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f1259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashSet<String> f1260b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentLinkedQueue<com.bytedance.apm.agent.tracing.b> f1261c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f1262d;

    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoPageTraceHelper.a();
        }
    }

    static class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoPageTraceHelper.a();
        }
    }

    static {
        f1260b = new HashSet(32);
        f1261c = new ConcurrentLinkedQueue();
        f1262d = 20000;
    }

    public AutoPageTraceHelper() {
    }

    static /* synthetic */ void a() {
        b();
    }

    private static void b() {
        int r3 = f1261c.size();     // Catch: Exception -> L39
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L58;
        ConcurrentLinkedQueue<com.bytedance.apm.agent.tracing.b> r5 = f1261c;     // Catch: Exception -> L39
        com.bytedance.apm.agent.tracing.b r6 = r5.peek();     // Catch: Exception -> L39
        if (r6 == null) goto L59;
        if (r6.f1280f == 0) goto L10;
    L12:
        com.bytedance.apm.agent.tracing.b r7 = r5.poll();     // Catch: Exception -> L39
        if (r7.a() == false) goto L56;
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L39
        r8.put("name", "onCreate");     // Catch: Exception -> L39
        r8.put("start", r7.f1276b);     // Catch: Exception -> L39
        r8.put("end", r7.f1277c);     // Catch: Exception -> L39
        JSONObject r9 = new JSONObject();     // Catch: Exception -> L39
        r9.put("name", "onResume");     // Catch: Exception -> L39
        r9.put("start", r7.f1278d);     // Catch: Exception -> L39
        r9.put("end", r7.f1279e);     // Catch: Exception -> L39
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L39
        r10.put("name", "onWindowFocusChanged");     // Catch: Exception -> L39
        r10.put("start", r7.f1280f);     // Catch: Exception -> L39
        JSONArray r11 = new JSONArray();     // Catch: Exception -> L39
        r11.put(r8);     // Catch: Exception -> L39
        r11.put(r9);     // Catch: Exception -> L39
        r11.put(r10);     // Catch: Exception -> L39
        if (r7.f1281g <= 0) goto L18;
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L39
        r12.put("name", "viewShow");     // Catch: Exception -> L39
        r12.put("start", r7.f1281g);     // Catch: Exception -> L39
        r11.put(r12);     // Catch: Exception -> L39
    L18:
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L39
        r13.put("name", "page_load_stats");     // Catch: Exception -> L39
        r13.put("page_type", "activity");     // Catch: Exception -> L39
        r13.put("start", r7.f1276b);     // Catch: Exception -> L39
        long r14 = r7.f1281g;     // Catch: Exception -> L39
        if (r14 <= 0) goto L25;
        r13.put("end", r14);     // Catch: Exception -> L39
        long r15 = r7.f1281g;     // Catch: Exception -> L39
        long r16 = r7.f1276b;     // Catch: Exception -> L39
        if ((r15 - r16) < 0) goto L38;
        if ((r15 - r16) > f1262d) goto L38;
    L30:
        r13.put("spans", r11);     // Catch: Exception -> L39
        HashSet<String> r17 = f1260b;     // Catch: Exception -> L39
        if (r17.contains(r7.f1275a) == false) goto L33;
        int r18 = 2;
    L34:
        r17.add(r7.f1275a);     // Catch: Exception -> L39
        r13.put("launch_mode", r18);     // Catch: Exception -> L39
        r13.put("collect_from", 1);     // Catch: Exception -> L39
        r13.put("page_name", r7.f1275a);     // Catch: Exception -> L39
        JSONObject r19 = new JSONObject();     // Catch: Exception -> L39
        r19.put("trace", r13);     // Catch: Exception -> L39
        if (com.bytedance.apm.x.a.e() == false) goto L37;
        com.bytedance.apm.x.a.b("PageLoadTrace", r13.toString());     // Catch: Exception -> L39
    L37:
        com.bytedance.apm.o.b.a.a("page_load_trace", null, null, r19);     // Catch: Exception -> L39
        goto L38
    L33:
        r18 = 1;
    L38:
        r4 = r4 + 1;
        goto L4
    L25:
        r13.put("end", r7.f1280f);     // Catch: Exception -> L39
        long r20 = r7.f1280f;     // Catch: Exception -> L39
        long r110 = r7.f1276b;     // Catch: Exception -> L39
        if ((r20 - r110) < 0) goto L38;
        if ((r20 - r110) <= f1262d) goto L30;
    L56:
        return;
    L10:
        if (r6.f1281g != 0) goto L12;
        return;
    L59:
        return;
    L58:
        return;
    L39:
        e = move-exception;
        if (d.C() == false) goto L57;
        e.printStackTrace();
        return;
    }

    public static void c(long r2, String r4) {
        com.bytedance.apm.agent.tracing.b r0 = f1261c.peek();
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r4, r0.f1275a) == false) goto L10;
        r0.f1281g = r2;
        com.bytedance.apm.f0.b.f().i(new b());
        return;
    }

    public static void d(long r0) {
        f1262d = r0;
    }

    @Keep
    public static void onTrace(String r4, String r5, boolean r6) {
        if (TextUtils.equals("onCreate", r5) == false) goto L19;
        if (r6 == false) goto L13;
        if (f1259a == true) goto L8;
        com.bytedance.apm.agent.tracing.a.d(r4);
    L8:
        ConcurrentLinkedQueue<com.bytedance.apm.agent.tracing.b> r7 = f1261c;
        if (r7.size() <= 50) goto L11;
        r7.poll();
    L11:
        r7.add(new com.bytedance.apm.agent.tracing.b(r4, System.currentTimeMillis()));
        return;
    L13:
        if (f1259a == true) goto L15;
        com.bytedance.apm.agent.tracing.a.c();
    L15:
        com.bytedance.apm.agent.tracing.b r8 = f1261c.peek();
        if (r8 == null) goto L56;
        r8.f1277c = System.currentTimeMillis();
        return;
    L56:
        return;
    L19:
        if (TextUtils.equals("onResume", r5) == false) goto L34;
        if (r6 == false) goto L28;
        if (f1259a == true) goto L24;
        com.bytedance.apm.agent.tracing.a.f(r4);
    L24:
        com.bytedance.apm.agent.tracing.b r9 = f1261c.peek();
        if (r9 == null) goto L58;
        r9.f1278d = System.currentTimeMillis();
        return;
    L58:
        return;
    L28:
        if (f1259a == true) goto L30;
        com.bytedance.apm.agent.tracing.a.e();
    L30:
        com.bytedance.apm.agent.tracing.b r10 = f1261c.peek();
        if (r10 == null) goto L60;
        r10.f1279e = System.currentTimeMillis();
        return;
    L60:
        return;
    L34:
        if (TextUtils.equals("onWindowFocusChanged", r5) == false) goto L47;
        if (r6 == true) goto L37;
        return;
    L37:
        if (f1259a == true) goto L39;
        com.bytedance.apm.agent.tracing.a.i(r4);
        f1259a = true;
    L39:
        com.bytedance.apm.agent.tracing.b r11 = f1261c.peek();
        if (r11 != null) goto L42;
        return;
    L42:
        if (r11.f1280f != 0) goto L64;
        r11.f1280f = System.currentTimeMillis();
        if (com.bytedance.apm.g0.i.a.c(r4) != null) goto L65;
        com.bytedance.apm.f0.b.f().i(new a());
        return;
    L65:
        return;
    L64:
        return;
    L47:
        if (TextUtils.equals("onStart", r5) == false) goto L67;
        boolean r12 = f1259a;
        if (r6 == false) goto L52;
        if (r12 == true) goto L68;
        com.bytedance.apm.agent.tracing.a.h(r4);
        return;
    L68:
        return;
    L52:
        if (r12 == true) goto L70;
        com.bytedance.apm.agent.tracing.a.g(r4);
        return;
    L70:
        return;
    }
}
