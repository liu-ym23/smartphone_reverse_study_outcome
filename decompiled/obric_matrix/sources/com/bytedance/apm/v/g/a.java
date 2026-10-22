package com.bytedance.apm.v.g;

import com.bytedance.apm.d;
import com.bytedance.apm.util.u;
import com.bytedance.monitor.collector.BinderMonitor;
import com.bytedance.monitor.collector.k;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: com.bytedance.apm.v.g.a$a, reason: collision with other inner class name */
    static class RunnableC0064a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ StackTraceElement[] f2109f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f2110g;

        RunnableC0064a(StackTraceElement[] r1, long r2) {
            this.f2109f = r1;
            this.f2110g = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r1 = u.c(this.f2109f);     // Catch: JSONException -> L10
            if (this.f2110g != 0) goto L6;
            return;
        L6:
            if (r1.isEmpty() == true) goto L16;
            JSONObject r2 = new JSONObject();     // Catch: JSONException -> L10
            r2.put("timestamp", System.currentTimeMillis());     // Catch: JSONException -> L10
            r2.put("crash_time", System.currentTimeMillis());     // Catch: JSONException -> L10
            r2.put("is_main_process", d.G());     // Catch: JSONException -> L10
            r2.put("process_name", d.i());     // Catch: JSONException -> L10
            r2.put("block_duration", this.f2110g);     // Catch: JSONException -> L10
            r2.put("stack", r1);     // Catch: JSONException -> L10
            r2.put("event_type", "lag");     // Catch: JSONException -> L10
            JSONObject r6 = d.b.b.m.a.c.a().b();     // Catch: JSONException -> L10
            r6.put("block_stack_type", "stack");     // Catch: JSONException -> L10
            r6.put("is_launch_binder", "true");     // Catch: JSONException -> L10
            r2.put("filters", r6);     // Catch: JSONException -> L10
            com.bytedance.apm.v.a.b().d("binder report json: " + r2);     // Catch: JSONException -> L10
            com.bytedance.apm.t.c.a.p().e(new com.bytedance.apm.t.d.d("block_monitor", r2));     // Catch: JSONException -> L10
            return;
        L16:
            return;
        L10:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public static long a() {
        long r1 = 0;
        if (com.bytedance.apm.v.a.b().c().a() == true) goto L5;
    L15:
        return r1;
    L5:
        if (com.bytedance.apm.internal.a.d(2) == false) goto L15;
        List<BinderMonitor.a> r0 = k.n().d();
        if (r0 != null) goto L9;
    L14:
        com.bytedance.apm.v.a.b().d("binder cost when launch: " + r1);
        goto L15
    L9:
        if (r0.isEmpty() == true) goto L14;
        Iterator<BinderMonitor.a> r2 = r0.iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        BinderMonitor.a r3 = r2.next();
        long r4 = r3.c() - r3.a();
        r1 = r1 + r4;
        c(r4, b(r3.b()));
        goto L12
    }

    private static StackTraceElement[] b(StackTraceElement[] r4) {
        if (r4 != null) goto L4;
        return r4;
    L4:
        if (r4.length == 0) goto L21;
        int r0 = 0;
        int r1 = 0;
    L8:
        if (r1 >= r4.length) goto L13;
        if ("saveBinderInfo".equals(r4[r1].getMethodName()) == true) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        r0 = r1;
    L13:
        int r2 = r0 + 1;
        if (r2 <= r4.length) goto L16;
        return r4;
    L16:
        return (StackTraceElement[]) Arrays.copyOfRange(r4, r2, r4.length);
    L21:
        return r4;
    }

    private static void c(long r2, StackTraceElement[] r4) {
        com.bytedance.apm.f0.b.f().i(new RunnableC0064a(r4, r2));
    }
}
