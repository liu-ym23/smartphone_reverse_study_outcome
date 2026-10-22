package com.bytedance.apm.v;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f2085a = false;

    static {
    }

    public static e.a a() {
        if (f2085a == false) goto L5;
        return null;
    L5:
        f2085a = true;
        if (a.b().a().d() == true) goto L9;
        return null;
    L9:
        if (com.bytedance.apm.internal.a.d(4) == true) goto L12;
        return null;
    L12:
        return e.b();
    }

    public static JSONObject b(e.a r11) {
        if (r11 != null) goto L5;
        return null;
    L5:
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
    L62:
        th = move-exception;
        th.printStackTrace();
        a.b().e(th.getLocalizedMessage());
        return null;
    L7:
        if (r11.t() == (-1)) goto L10;
        r2.put("launch_perf_gc_count", r11.t());     // Catch: Throwable -> L62
    L10:
        if (r11.u() == (-1)) goto L13;
        r2.put("launch_perf_gc_time", r11.u());     // Catch: Throwable -> L62
    L13:
        if (r11.q() == (-1)) goto L16;
        r2.put("launch_perf_block_gc_count", r11.q());     // Catch: Throwable -> L62
    L16:
        if (r11.r() == (-1)) goto L19;
        r2.put("launch_perf_block_gc_time", r11.r());     // Catch: Throwable -> L62
    L19:
        if (r11.w() == (-1.0d)) goto L22;
        r2.put("launch_perf_iowait_time", r11.w());     // Catch: Throwable -> L62
    L22:
        if (r11.B() == (-1.0d)) goto L25;
        r2.put("launch_perf_runnable_time", r11.B());     // Catch: Throwable -> L62
    L25:
        if (r11.C() == (-1.0d)) goto L28;
        r2.put("launch_perf_sleep_time", r11.C());     // Catch: Throwable -> L62
    L28:
        if (r11.A() == (-1)) goto L31;
        r2.put("launch_perf_minfor_fault", r11.A());     // Catch: Throwable -> L62
    L31:
        if (r11.z() == (-1)) goto L34;
        r2.put("launch_perf_major_fault", r11.z());     // Catch: Throwable -> L62
    L34:
        if (r11.s() == (-1.0d)) goto L37;
        r2.put("launch_perf_cpu_time", r11.s());     // Catch: Throwable -> L62
    L37:
        if (r11.D() == (-1)) goto L40;
        r2.put("launch_perf_voluntary_switches", r11.D());     // Catch: Throwable -> L62
    L40:
        if (r11.v() == (-1)) goto L43;
        r2.put("launch_perf_involuntary_switches", r11.v());     // Catch: Throwable -> L62
    L43:
        if (r11.o() == (-1)) goto L46;
        r2.put("launch_perf_all_thread_count", r11.o());     // Catch: Throwable -> L62
    L46:
        if (r11.y() == (-1)) goto L49;
        r2.put("launch_perf_lock_time", r11.y());     // Catch: Throwable -> L62
    L49:
        if (r11.p() == (-1)) goto L51;
        r2.put("launch_perf_binder_time", r11.p());     // Catch: Throwable -> L62
    L51:
        r1.put("list_data", r2);     // Catch: Throwable -> L62
        List<String> r12 = r11.x();     // Catch: Throwable -> L62
        if (r12 != null) goto L54;
    L60:
        a.b().d("perf data: " + r1);     // Catch: Throwable -> L62
        return r1;
    L54:
        if (r12.isEmpty() == true) goto L60;
        JSONArray r3 = new JSONArray();     // Catch: Throwable -> L62
        Iterator<String> r13 = r12.iterator();     // Catch: Throwable -> L62
    L57:
        if (r13.hasNext() == false) goto L59;
        r3.put(r13.next());     // Catch: Throwable -> L62
        goto L57
    L59:
        r1.put("current_thread_list", r3);     // Catch: Throwable -> L62
        goto L60
    }
}
