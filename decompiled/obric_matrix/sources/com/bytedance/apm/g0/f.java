package com.bytedance.apm.g0;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bytedance.apm.util.j;
import com.bytedance.monitor.collector.LockMonitorManager;
import com.bytedance.monitor.collector.k;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile boolean f1562f = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f1563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f1564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<String, com.bytedance.apm.u.b> f1565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f1566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f1567e;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm.v.e.a f1568f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f1569g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f1570h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f1571i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ f f1572j;

        a(f r1, com.bytedance.apm.v.e.a r2, int r3, String r4, String r5) {
            this.f1572j = r1;
            this.f1568f = r2;
            this.f1569g = r3;
            this.f1570h = r4;
            this.f1571i = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.a(this.f1572j) == false) goto L9;
            long r0 = com.bytedance.apm.v.g.a.a();
            if (r0 == 0) goto L9;
            com.bytedance.apm.v.e.a r2 = this.f1568f;
            if (r2 == null) goto L9;
            r2.E(r0);
        L9:
            f r3 = this.f1572j;
            f.c(r3, this.f1569g, this.f1570h, this.f1571i, f.b(r3), this.f1568f);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long[] f1573f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f1574g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f1575h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f1576i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f1577j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f1578k;

        b(f r1, long[] r2, long r3, long r5, long r7, int r9, String r10) {
            this.f1573f = r2;
            this.f1574g = r3;
            this.f1575h = r5;
            this.f1576i = r7;
            this.f1577j = r9;
            this.f1578k = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r1 = com.bytedance.apm.r.m.f.E().A(this.f1573f, this.f1574g);     // Catch: Throwable -> L8
            if (TextUtils.isEmpty(r1) == false) goto L6;
            return;
        L6:
            long r2 = this.f1575h - this.f1576i;     // Catch: Throwable -> L8
            JSONObject r4 = k.n().e();     // Catch: Throwable -> L8
            JSONObject r5 = new JSONObject();     // Catch: Throwable -> L8
            r5.put("is_main_process", com.bytedance.apm.d.G());     // Catch: Throwable -> L8
            r5.put("block_duration", r2);     // Catch: Throwable -> L8
            r5.put("stack", r1);     // Catch: Throwable -> L8
            r5.put("stack_key", "1048574\n");     // Catch: Throwable -> L8
            r5.put("scene", "launchTrace");     // Catch: Throwable -> L8
            r5.put("cost_time", r2);     // Catch: Throwable -> L8
            r5.put("method_time", r2);     // Catch: Throwable -> L8
            r5.put("message", "launchTrace");     // Catch: Throwable -> L8
            r5.put("event_type", "lag_drop_frame");     // Catch: Throwable -> L8
            JSONObject r3 = d.b.b.m.a.c.a().c(true);     // Catch: Throwable -> L8
            r3.put("crash_section", com.bytedance.apm.d.B(System.currentTimeMillis()));     // Catch: Throwable -> L8
            r3.put("trace_type", "launchTrace");     // Catch: Throwable -> L8
            r3.put("launchMode", String.valueOf(this.f1577j));     // Catch: Throwable -> L8
            r3.put("customLaunchMode", this.f1578k);     // Catch: Throwable -> L8
            r5.put("custom", r4);     // Catch: Throwable -> L8
            r5.put("filters", r3);     // Catch: Throwable -> L8
            com.bytedance.apm.t.c.a.p().e(new com.bytedance.apm.t.d.d("drop_frame_stack", r5));     // Catch: Throwable -> L8
            return;
        }
    }

    static {
    }

    public f(String r3, String r4) {
        this.f1565c = new ConcurrentHashMap(4);
        if ("start_trace".equals(r3) == false) goto L5;
    L9:
        this.f1566d = r3;
        this.f1567e = r4;
        return;
    L5:
        if ("page_load_trace".equals(r3) == true) goto L9;
        throw new IllegalStateException("Please add TraceServiceName support on TraceState#reportAsync");
    }

    static /* synthetic */ boolean a(f r0) {
        return r0.i();
    }

    static /* synthetic */ long b(f r2) {
        return r2.f1564b;
    }

    static /* synthetic */ void c(f r0, int r1, String r2, String r3, long r4, com.bytedance.apm.v.e.a r6) {
        r0.j(r1, r2, r3, r4, r6);
    }

    @RequiresApi(api = 18)
    private void g(int r12, String r13, String r14, long r15, long r17) {
        if (r12 == (-1)) goto L5;
    L11:
        com.bytedance.apm.v.e.a r0 = null;
        if (i() == false) goto L14;
        r0 = com.bytedance.apm.v.b.a();
    L14:
        com.bytedance.apm.v.e.a r10 = r0;
        this.f1564b = System.currentTimeMillis();
        if (r17 <= 0) goto L17;
        this.f1564b = this.f1563a + r17;
    L17:
        long r2 = this.f1564b - this.f1563a;
        if (r15 <= 0) goto L23;
        if (r2 <= r15) goto L23;
        return;
    L23:
        if (i() == false) goto L30;
        if (d.b.o.b.a.n == false) goto L30;
        if (f1562f == false) goto L30;
        f1562f = false;
        k(r12, r13, this.f1563a, this.f1564b);
    L30:
        if (i() == true) goto L32;
    L41:
        com.bytedance.apm.f0.b.f().i(new a(this, r10, r12, r13, r14));
        if (i() == false) goto L47;
        com.bytedance.apm.v.g.c.a();
        return;
    L47:
        return;
    L32:
        if (com.bytedance.apm.v.a.b().c().b() == false) goto L41;
        if (com.bytedance.apm.internal.a.d(8) == false) goto L41;
        JSONObject r1 = new JSONObject();
        r1.put("is_launch_lock", true);     // Catch: JSONException -> L38
    L40:
        LockMonitorManager.endLockDetect(r1);
    L38:
        e = move-exception;
        e.printStackTrace();
        goto L40
    L5:
        if (r13.isEmpty() == false) goto L11;
        if (com.bytedance.apm.d.C() == false) goto L11;
        throw new IllegalArgumentException("Launch mode is both none");
    }

    private boolean i() {
        return "start_trace".equals(this.f1566d);
    }

    private void j(int r19, String r20, String r21, long r22, @Nullable com.bytedance.apm.v.e.a r24) {
        JSONArray r8 = new JSONArray();
        int r9 = 2;
        char r11 = 1;
    L29:
        e = move-exception;
        e.printStackTrace();
    L31:
        ConcurrentHashMap<String, com.bytedance.apm.u.b> r0 = this.f1565c;
        if (r0 == null) goto L34;
        r0.clear();
    L34:
        JSONObject r1 = new JSONObject();
        r1.put("name", this.f1567e);     // Catch: JSONException -> L61
        r1.put("page_type", this.f1567e);     // Catch: JSONException -> L61
        r1.put("start", this.f1563a);     // Catch: JSONException -> L61
        r1.put("end", r22);     // Catch: JSONException -> L61
        r1.put("spans", r8);     // Catch: JSONException -> L61
        r1.put("collect_from", 2);     // Catch: JSONException -> L61
        r1.put("page_name", r21);     // Catch: JSONException -> L61
        if (r19 == (-1)) goto L39;
        r1.put("launch_mode", r19);     // Catch: JSONException -> L61
    L39:
        if (r20.isEmpty() == true) goto L42;
        r1.put("custom_launch_mode", r20);     // Catch: JSONException -> L61
    L42:
        if (com.bytedance.apm.x.a.e() == false) goto L45;
        com.bytedance.apm.x.a.b("AppStartStats", r1.toString());     // Catch: JSONException -> L61
    L45:
        if (i() == true) goto L47;
    L50:
        JSONObject r2 = new JSONObject();
        r2.put("trace", r1);     // Catch: JSONException -> L63
        if (r24 == null) goto L56;
        JSONObject r3 = com.bytedance.apm.v.b.b(r24);     // Catch: JSONException -> L63
        if (r3 == null) goto L56;
        r2.put("perf_data", r3);     // Catch: JSONException -> L63
    L56:
        com.bytedance.apm.t.d.e r4 = new com.bytedance.apm.t.d.e(this.f1566d, "", null, null, r2);
        d.b.b.m.a.b.a(r4, false);
        if (com.bytedance.apm.d.C() == false) goto L59;
        j.a("AppStartStats", "reportAsync: " + r2);
    L59:
        com.bytedance.apm.t.c.a.p().e(r4);
        return;
    L47:
        if (com.bytedance.apm.v.a.b().a().b() == false) goto L50;
        JSONObject r5 = new JSONObject();
        com.bytedance.apm.util.c.k().f(r5, true);
        com.bytedance.apm.util.c.k().b(r5, true);
        r1.put("device_info_data", r5);     // Catch: Throwable -> L62
        goto L50
    L4:
        if (TextUtils.equals(r21, com.bytedance.apm.agent.tracing.a.o) == false) goto L6;
        r8 = com.bytedance.apm.agent.tracing.a.a();     // Catch: JSONException -> L29
    L6:
        ConcurrentHashMap<String, com.bytedance.apm.u.b> r6 = this.f1565c;     // Catch: JSONException -> L29
        if (r6 == null) goto L31;
        if (r6.isEmpty() == true) goto L31;
        Iterator<Map.Entry<String, com.bytedance.apm.u.b>> r7 = this.f1565c.entrySet().iterator();     // Catch: JSONException -> L29
    L11:
        if (r7.hasNext() == false) goto L31;
        Map.Entry<String, com.bytedance.apm.u.b> r12 = r7.next();     // Catch: JSONException -> L29
        String r13 = r12.getKey();     // Catch: JSONException -> L29
        com.bytedance.apm.u.b r14 = r12.getValue();     // Catch: JSONException -> L29
        if (r14.f2020b == 0) goto L11;
        JSONObject r15 = new JSONObject();     // Catch: JSONException -> L29
        String[] r16 = r13.split("#");     // Catch: JSONException -> L29
        if (r16.length != r9) goto L25;
        if ("page_load_trace".equals(this.f1566d) == false) goto L22;
        r15.put("name", r16[r11]);     // Catch: JSONException -> L29
    L27:
        r15.put("start", r14.f2019a);     // Catch: JSONException -> L29
        r15.put("end", r14.f2020b);     // Catch: JSONException -> L29
        r15.put("thread", r14.f2021c);     // Catch: JSONException -> L29
        r8.put(r15);     // Catch: JSONException -> L29
        r9 = 2;
        r11 = 1;
        goto L11
    L22:
        r15.put("module_name", r16[0]);     // Catch: JSONException -> L29
        String r17 = r16[1];     // Catch: JSONException -> L29
    L23:
        r15.put("span_name", r17);     // Catch: JSONException -> L29
        goto L27
    L25:
        if (r16.length != 1) goto L27;
        r17 = r16[0];     // Catch: JSONException -> L29
        goto L23
    }

    private void k(int r14, String r15, long r16, long r18) {
        long[] r3 = com.bytedance.apm.r.m.f.E().t();
        long r4 = SystemClock.uptimeMillis();
        if (r3 == null) goto L6;
        com.bytedance.apm.f0.b.f().i(new b(this, r3, r4, r18, r16, r14, r15));
        return;
    }

    public void d() {
        this.f1565c.clear();
    }

    public void e(String r6, String r7) {
        com.bytedance.apm.u.b r0 = this.f1565c.get(r6 + "#" + r7);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(System.currentTimeMillis(), Thread.currentThread().getName());
        this.f1565c.put(r6 + "#" + r7, r0);
    }

    public void f(int r9, String r10, long r11, long r13) {
        g(r9, "", r10, r11, r13);
    }

    public long h() {
        return this.f1563a;
    }

    public void l(String r2, String r3) {
        m(r2, r3, false);
    }

    public void m(String r4, String r5, boolean r6) {
        if (this.f1565c.get(r4 + "#" + r5) == null) goto L5;
        if (r6 == true) goto L5;
        return;
    L5:
        com.bytedance.apm.u.b r7 = new com.bytedance.apm.u.b(System.currentTimeMillis());
        this.f1565c.put(r4 + "#" + r5, r7);
    }

    public void n() {
        this.f1563a = System.currentTimeMillis();
    }
}
