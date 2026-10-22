package d.b.b.f.e.k;

import android.util.Log;
import d.b.b.f.e.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements d.b.b.l.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f12843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f12844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f12845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f12846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<j> f12847e;

    public b(double r1, double r3, List<j> r5, String r6, boolean r7) {
        this.f12843a = r1;
        this.f12844b = r3;
        this.f12845c = r6;
        this.f12846d = r7;
        this.f12847e = new ArrayList(r5);
    }

    @Override // d.b.b.l.b
    public String a() {
        return "cpu_exception_trace";
    }

    @Override // d.b.b.l.b
    public boolean b() {
        List<j> r0 = this.f12847e;
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L11;
        if (this.f12843a <= 0.0d) goto L11;
        if (this.f12844b <= 0.0d) goto L11;
        return true;
    }

    @Override // d.b.b.l.b
    public JSONObject c() {
        JSONObject r2 = new JSONObject();
        r2.put("event_type", "cpu_exception_trace");     // Catch: Throwable -> L26
        r2.put("log_type", "cpu_exception_trace");     // Catch: Throwable -> L26
        r2.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L26
        r2.put("crash_time", System.currentTimeMillis());     // Catch: Throwable -> L26
        r2.put("is_main_process", com.bytedance.apm.d.G());     // Catch: Throwable -> L26
        r2.put("process_name", com.bytedance.apm.d.i());     // Catch: Throwable -> L26
        if (this.f12846d == false) goto L8;
        Object r1 = "back";
    L7:
        r2.put("data_type", r1);     // Catch: Throwable -> L26
        r2.put("scene", this.f12845c);     // Catch: Throwable -> L26
        r2.put("report_scene", this.f12845c);     // Catch: Throwable -> L26
        if (com.bytedance.apm.d.g() <= com.bytedance.apm.d.A()) goto L13;
    L16:
        long r4 = com.bytedance.apm.d.A();     // Catch: Throwable -> L26
    L15:
        r2.put("app_launch_start_time", r4);     // Catch: Throwable -> L26
        r2.put("process_speed_avg", this.f12843a);     // Catch: Throwable -> L26
        r2.put("process_speed_max", this.f12844b);     // Catch: Throwable -> L26
        r2.put("battery_temperature", com.bytedance.apm.a0.g.d().f());     // Catch: Throwable -> L26
        r2.put("battery_recharge_state", com.bytedance.apm.a0.g.d().e());     // Catch: Throwable -> L26
        JSONArray r3 = new JSONArray();     // Catch: Throwable -> L26
        Iterator<j> r8 = this.f12847e.iterator();     // Catch: Throwable -> L26
    L19:
        if (r8.hasNext() == false) goto L24;
        j r5 = r8.next();     // Catch: Throwable -> L26
        if (r5 == null) goto L19;
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L26
        r6.put("nice", r5.b());     // Catch: Throwable -> L26
        r6.put("weight", Double.valueOf(r5.h()));     // Catch: Throwable -> L26
        r6.put("cpu_usage", r5.a());     // Catch: Throwable -> L26
        r6.put("thread_name", r5.g());     // Catch: Throwable -> L26
        r6.put("thread_back_trace", r5.d());     // Catch: Throwable -> L26
        r6.put("thread_id", r5.f());     // Catch: Throwable -> L26
        r3.put(r6);     // Catch: Throwable -> L26
        goto L19
    L24:
        r2.put("threads_info", r3);     // Catch: Throwable -> L26
    L29:
        Log.i("APM-CPU", "exception data: " + r2);
        return r2;
    L13:
        if (com.bytedance.apm.d.g() == 0) goto L16;
        r4 = com.bytedance.apm.d.g();     // Catch: Throwable -> L26
        goto L15
    L8:
        r1 = "front";
    L26:
        th = move-exception;
        d.b.b.o.m.b.c("APM-CPU", "cpu_exception_data_assemble", th);
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L31
        r7.put("exception", th.getLocalizedMessage());     // Catch: Throwable -> L31
        d.b.b.d.a.e("cpu_exception_no_stack", r7, null);     // Catch: Throwable -> L31
        goto L29
    }
}
