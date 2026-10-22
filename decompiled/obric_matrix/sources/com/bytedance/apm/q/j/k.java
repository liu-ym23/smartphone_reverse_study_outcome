package com.bytedance.apm.q.j;

import android.os.IBinder;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k extends a<com.bytedance.apm.q.j.m.d> implements com.bytedance.apm.q.h.b {
    public k() {
        super("power");
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void q(Object[] r5) {
        k();
        if (com.bytedance.apm.q.a.F().I() == true) goto L5;
        return;
    L5:
        if (r5.length <= 7) goto L7;
        return;
    L7:
        if (r5.length >= 4) goto L10;
        return;
    L10:
        if (r5[0] != null) goto L12;
        return;
    L12:
        if ((r5[0] instanceof IBinder) == false) goto L36;
        int r0 = r5[0].hashCode();
        if (this.f1780e.containsKey(Integer.valueOf(r0)) == true) goto L25;
        com.bytedance.apm.q.j.m.d r1 = new com.bytedance.apm.q.j.m.d();
        if (r5[1] != null) goto L18;
        return;
    L18:
        if ((r5[1] instanceof Integer) == false) goto L30;
        r1.f1810e = ((Integer) r5[1]).intValue();
        if (r5[2] != null) goto L22;
        return;
    L22:
        if ((r5[2] instanceof String) == false) goto L32;
        r1.f1811f = (String) r5[2];
        r1.f1806b = -1;
    L28:
        r1.f1808d = Thread.currentThread().getStackTrace();
        r1.f1807c = Thread.currentThread().getName();
        r1.f1805a = System.currentTimeMillis();
        this.f1780e.put(Integer.valueOf(r0), r1);
        return;
    L32:
        return;
    L30:
        return;
    L25:
        r1 = (com.bytedance.apm.q.j.m.d) this.f1780e.get(Integer.valueOf(r0));
        if (r1 != null) goto L28;
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void r(Object[] r4) {
        n();
        if (com.bytedance.apm.q.a.F().I() == true) goto L5;
        return;
    L5:
        if (r4.length == 2) goto L8;
        return;
    L8:
        if (r4[0] != null) goto L10;
        return;
    L10:
        if ((r4[0] instanceof IBinder) == false) goto L17;
        int r5 = r4[0].hashCode();
        com.bytedance.apm.q.j.m.d r0 = (com.bytedance.apm.q.j.m.d) this.f1780e.get(Integer.valueOf(r5));
        if (r0 == null) goto L18;
        r0.f1806b = System.currentTimeMillis();
        this.f1780e.put(Integer.valueOf(r5), r0);
        return;
    L18:
        return;
    }

    @Override // com.bytedance.apm.q.h.b
    public String c() {
        return "android.os.IPowerManager";
    }

    @Override // com.bytedance.apm.q.j.l
    public void e(com.bytedance.apm.q.i.b r3, com.bytedance.apm.u.a r4) {
        if (h().equals(r4.f2010d) == false) goto L9;
        boolean r2 = r4.k();
        long r0 = r4.a();
        if (r2 == false) goto L7;
        r3.r(r0);
        return;
    L7:
        r3.h(r0);
        return;
    }

    @Override // com.bytedance.apm.q.h.b
    public synchronized void invoke(Object r1, Method r2, Object[] r3) {
        monitor-enter(this);
        String r4 = r2.getName();     // Catch: Throwable -> L10 Exception -> L15
        if ("acquireWakeLock".equals(r4) == false) goto L7;
        q(r3);     // Catch: Throwable -> L10 Exception -> L15
    L16:
        goto L13
    L7:
        if ("releaseWakeLock".equals(r4) == false) goto L16;
        r(r3);     // Catch: Throwable -> L10 Exception -> L15
    L10:
        th = move-exception;
        throw th;
    L13:
        monitor-exit(this);
    }

    @Override // com.bytedance.apm.q.j.a
    protected void o(double r5, double r7) {
        if (r5 < com.bytedance.apm.q.g.a.g()) goto L5;
        int r1 = 17;
    L7:
        if (r7 < com.bytedance.apm.q.g.a.f()) goto L9;
        r1 = r1 | 18;
    L9:
        if (r1 != 0) goto L23;
        return;
    L23:
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L22
        r2.put("issue_type", r1).put("total_hold_time", r5).put("total_acquire_count", r7);     // Catch: Throwable -> L22
        ConcurrentHashMap<Integer, T> r6 = this.f1780e;     // Catch: Throwable -> L22
        if (r6 != 0) goto L14;
    L20:
        com.bytedance.apm.a0.b.b(r2, "battery_trace");     // Catch: Throwable -> L22
        com.bytedance.apm.t.c.a.p().e(new com.bytedance.apm.t.d.d("battery_trace", r2));     // Catch: Throwable -> L22
        return;
    L14:
        if (r6.size() <= 0) goto L20;
        JSONArray r8 = new JSONArray();     // Catch: Throwable -> L22
        Iterator r4 = this.f1780e.values().iterator();     // Catch: Throwable -> L22
    L17:
        if (r4.hasNext() == false) goto L19;
        r8.put(((com.bytedance.apm.q.j.m.d) r4.next()).b());     // Catch: Throwable -> L22
        goto L17
    L19:
        r2.put("detail", r8);     // Catch: Throwable -> L22
    L26:
        return;
    L5:
        r1 = 0;
        goto L7
    }

    @Override // com.bytedance.apm.q.j.a
    protected /* bridge */ /* synthetic */ void p(com.bytedance.apm.q.j.m.b r1, long r2) {
        s((com.bytedance.apm.q.j.m.d) r1, r2);
    }

    protected void s(com.bytedance.apm.q.j.m.d r4, long r5) {
        if (r5 >= com.bytedance.apm.q.g.a.c()) goto L8;
        return;
    L8:
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L7
        r0.put("event_type", "battery_trace");     // Catch: JSONException -> L7
        r0.put("issue_type", 16).put("single_hold_time", r5).put("wake_lock_info", r4.toString());     // Catch: JSONException -> L7
        com.bytedance.apm.a0.b.b(r0, "battery_trace");     // Catch: JSONException -> L7
        com.bytedance.apm.t.c.a.p().e(new com.bytedance.apm.t.d.d("battery_trace", r0));     // Catch: JSONException -> L7
        return;
    }
}
