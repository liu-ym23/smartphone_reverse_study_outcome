package com.bytedance.apm.q.j;

import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g extends a<com.bytedance.apm.q.j.m.c> implements com.bytedance.apm.q.h.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<String> f1791k;

    public g() {
        super(LocationMonitorConst.LOCATION);
        this.f1791k = new ArrayList();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void q(Object[] r4) {
        if (r4[0] == null) goto L13;
        int r5 = r4[0].hashCode();
        String r0 = String.valueOf(r5);
        if (this.f1791k.contains(r0) == false) goto L8;
        n();
        this.f1791k.remove(r0);
    L8:
        if (com.bytedance.apm.q.a.F().I() == false) goto L14;
        com.bytedance.apm.q.j.m.c r1 = (com.bytedance.apm.q.j.m.c) this.f1780e.get(Integer.valueOf(r5));
        if (r1 == null) goto L15;
        r1.f1806b = System.currentTimeMillis();
        this.f1780e.put(Integer.valueOf(r5), r1);
        return;
    L15:
        return;
    L14:
        return;
    }

    private void r(Object[] r4) {
        if (r4[0] != null) goto L5;
        return;
    L5:
        if (r4[1] == null) goto L9;
        t(r4[1].hashCode(), r4[0].toString());
        return;
    }

    private void s(Object[] r4) {
        if (r4[1] != null) goto L5;
        return;
    L5:
        if (r4[2] == null) goto L9;
        t(r4[2].hashCode(), r4[1].toString());
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void t(int r4, String r5) {
        String r0 = String.valueOf(r4);
        if (this.f1791k.contains(r0) == true) goto L6;
        k();
        this.f1791k.add(r0);
    L6:
        if (com.bytedance.apm.q.a.F().I() == false) goto L12;
        com.bytedance.apm.q.j.m.c r1 = (com.bytedance.apm.q.j.m.c) this.f1780e.get(Integer.valueOf(r4));
        if (r1 != null) goto L10;
        r1 = new com.bytedance.apm.q.j.m.c();
        r1.f1809e = r5;
    L10:
        r1.f1805a = System.currentTimeMillis();
        r1.f1806b = -1;
        r1.f1808d = Thread.currentThread().getStackTrace();
        r1.f1807c = Thread.currentThread().getName();
        this.f1780e.put(Integer.valueOf(r4), r1);
        return;
    }

    @Override // com.bytedance.apm.q.h.b
    public String c() {
        return "android.location.ILocationManager";
    }

    @Override // com.bytedance.apm.q.j.l
    public void e(com.bytedance.apm.q.i.b r3, com.bytedance.apm.u.a r4) {
        if (h().equals(r4.f2010d) == false) goto L9;
        boolean r2 = r4.k();
        long r0 = r4.a();
        if (r2 == false) goto L7;
        r3.n(r0);
        return;
    L7:
        r3.d(r0);
        return;
    }

    @Override // com.bytedance.apm.q.h.b
    public void invoke(Object r1, Method r2, Object[] r3) {
        String r4 = r2.getName();     // Catch: Exception -> L14
        if (TextUtils.equals(r4, "requestLocationUpdates") == false) goto L6;
        r(r3);     // Catch: Exception -> L14
    L15:
        return;
    L6:
        if (TextUtils.equals(r4, "registerLocationListener") == false) goto L9;
        s(r3);     // Catch: Exception -> L14
        goto L15
    L9:
        if (TextUtils.equals(r4, "removeUpdates") == false) goto L11;
    L12:
        q(r3);     // Catch: Exception -> L14
        goto L15
    L11:
        if (TextUtils.equals(r4, "unregisterLocationListener") == false) goto L15;
    }

    @Override // com.bytedance.apm.q.j.a
    void o(double r5, double r7) {
        if (r5 < com.bytedance.apm.q.g.a.e()) goto L5;
        int r1 = 33;
    L7:
        if (r7 < com.bytedance.apm.q.g.a.d()) goto L9;
        r1 = r1 | 34;
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
        r8.put(((com.bytedance.apm.q.j.m.c) r4.next()).b());     // Catch: Throwable -> L22
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
        u((com.bytedance.apm.q.j.m.c) r1, r2);
    }

    protected void u(com.bytedance.apm.q.j.m.c r4, long r5) {
        if (r5 >= com.bytedance.apm.q.g.a.b()) goto L8;
        return;
    L8:
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L7
        r0.put("issue_type", 32).put("single_hold_time", r5);     // Catch: Throwable -> L7
        JSONArray r6 = new JSONArray();     // Catch: Throwable -> L7
        r6.put(r4.b());     // Catch: Throwable -> L7
        r0.put("detail", r6);     // Catch: Throwable -> L7
        com.bytedance.apm.a0.b.b(r0, "battery_trace");     // Catch: Throwable -> L7
        com.bytedance.apm.t.c.a.p().e(new com.bytedance.apm.t.d.d("battery_trace", r0));     // Catch: Throwable -> L7
        return;
    }
}
