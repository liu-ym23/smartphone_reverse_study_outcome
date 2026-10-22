package com.bytedance.apm6.hub.b;

import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements d.b.b.f.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d.b.b.f.d.a f2158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d.b.b.f.d.c f2159b;

    class a implements com.bytedance.apm6.hub.b.i.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f2160a;

        a(b r1) {
            this.f2160a = r1;
        }

        @Override // com.bytedance.apm6.hub.b.i.b
        public void a(JSONObject r1, boolean r2) {
            b.a(this.f2160a, r1, r2);
        }
    }

    public b() {
        com.bytedance.apm6.hub.b.i.a.g().h();
        com.bytedance.apm6.hub.b.i.a.g().k(new a(this));
    }

    static /* synthetic */ void a(b r0, JSONObject r1, boolean r2) {
        r0.d(r1, r2);
    }

    private void d(JSONObject r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        JSONObject r12 = d.b.b.m.a.a.a(r10, "cpu");
        if (r12 == null) goto L79;
        this.f2158a = new d.b.b.f.d.a();
        boolean r1 = true;
        if (r12.optInt("enable_upload", 0) != 1) goto L9;
        boolean r13 = true;
    L10:
        this.f2158a.k(r13);
        if (r12.optInt("enable_collect_all_process", 0) != 1) goto L13;
        boolean r14 = true;
    L14:
        this.f2158a.j(r14);
        long r4 = r12.optLong("front_collect_interval", 0);
        if (r4 <= 0) goto L17;
        this.f2158a.l(r4);
    L17:
        long r5 = r12.optLong("back_collect_interval", 0);
        if (r5 <= 0) goto L20;
        this.f2158a.h(r5);
    L20:
        long r6 = r12.optLong("monitor_interval", 0);
        if (r6 <= 0) goto L23;
        this.f2158a.n(r6);
    L23:
        long r7 = r12.optLong("front_thread_collect_interval", 0);
        if (r7 <= 0) goto L26;
        this.f2158a.m(r7);
    L26:
        long r8 = r12.optLong("back_thread_collect_interval", 0);
        if (r8 <= 0) goto L29;
        this.f2158a.i(r8);
    L29:
        this.f2159b = new d.b.b.f.d.c();
        if (r12.optInt("exception_switch", 0) != 1) goto L32;
        boolean r15 = true;
    L33:
        this.f2159b.x(r15);
        double r9 = r12.optDouble("exception_process_back_max_speed", 0.0d);
        if (r9 <= 0.0d) goto L36;
        this.f2159b.t(r9);
    L36:
        double r16 = r12.optDouble("exception_process_fore_max_speed", 0.0d);
        if (r16 <= 0.0d) goto L40;
        this.f2159b.u(r16);
    L40:
        if (r12.optInt("main_thread_collect_enabled", 0) != 1) goto L42;
        boolean r17 = true;
    L43:
        this.f2159b.p(r17);
        if (r12.optInt("exception_collect_all_process", 0) != 1) goto L46;
        boolean r18 = true;
    L47:
        this.f2159b.o(r18);
        if (r12.optInt("exception_thread_stack_enabled", 1) == 1) goto L51;
        r1 = false;
    L51:
        this.f2159b.r(r1);
        double r19 = r12.optDouble("exception_thread_max_usage", 0.0d);
        if (r19 <= 0.0d) goto L54;
        this.f2159b.v(r19);
    L54:
        JSONObject r110 = r12.optJSONObject("exception_thread_max_usage_map");
        HashMap r2 = new HashMap();
        if (r110 == null) goto L62;
        Iterator<String> r20 = r110.keys();
    L58:
        if (r20.hasNext() == false) goto L62;
        String r21 = r20.next();
        double r22 = r110.optDouble(r21, 0.0d);
        if (r22 <= 0.0d) goto L58;
        r2.put(r21, Double.valueOf(r22));
    L62:
        this.f2159b.w(r2);
        this.f2159b.y(r12.optInt("process_detect_interval", 30));
        this.f2159b.z(r12.optInt("thread_detect_interval", 30));
        JSONObject r111 = r12.optJSONObject("exception_fore_max_speed_scene");
        HashMap r3 = new HashMap();
        if (r111 == null) goto L70;
        Iterator<String> r23 = r111.keys();
    L66:
        if (r23.hasNext() == false) goto L70;
        String r24 = r23.next();
        double r25 = r111.optDouble(r24, 0.0d);
        if (r25 <= 0.0d) goto L66;
        r3.put(r24, Double.valueOf(r25));
    L70:
        this.f2159b.s(r3);
        JSONObject r112 = r12.optJSONObject("exception_back_max_speed_scene");
        HashMap r26 = new HashMap();
        if (r112 == null) goto L78;
        Iterator<String> r27 = r112.keys();
    L74:
        if (r27.hasNext() == false) goto L78;
        String r28 = r27.next();
        double r29 = r112.optDouble(r28, 0.0d);
        if (r29 <= 0.0d) goto L74;
        r26.put(r28, Double.valueOf(r29));
    L78:
        this.f2159b.n(r26);
        this.f2159b.q(r12.optBoolean("exception_native_thread_enabled", false));
        goto L79
    L46:
        r18 = false;
        goto L47
    L42:
        r17 = false;
        goto L43
    L32:
        r15 = false;
        goto L33
    L13:
        r14 = false;
        goto L14
    L9:
        r13 = false;
    L79:
        d.b.b.o.m.b.a("APM-CPU", b() + " " + c());
        d.b.b.f.c.b.e().h(b());
        d.b.b.f.e.c.c().f(c());
    }

    @Nullable
    public d.b.b.f.d.a b() {
        return this.f2158a;
    }

    public d.b.b.f.d.c c() {
        return this.f2159b;
    }
}
