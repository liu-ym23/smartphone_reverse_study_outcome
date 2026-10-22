package com.bytedance.apm.q.j;

import android.app.PendingIntent;
import androidx.core.app.NotificationCompat;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends c<com.bytedance.apm.q.j.m.a> implements com.bytedance.apm.q.h.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int[] f1781f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1782g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<Long> f1783h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f1784i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Object f1785j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List<Long> f1786k;

    public d() {
        super(NotificationCompat.CATEGORY_ALARM);
        this.f1783h = new ArrayList();
        this.f1785j = new Object();
        this.f1786k = new ArrayList();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void k(Object[] r6) {
        if (r6[0] != null) goto L5;
    L7:
        int r7 = -1;
    L8:
        com.bytedance.apm.q.j.m.a r0 = (com.bytedance.apm.q.j.m.a) this.f1780e.get(Integer.valueOf(r7));
        if (r0 != null) goto L11;
        return;
    L11:
        if (r0.f1803f <= 0) goto L15;
        r0.f1806b = System.currentTimeMillis();
        this.f1780e.put(Integer.valueOf(r7), r0);
        return;
    L15:
        return;
    L5:
        if ((r6[0] instanceof PendingIntent) == false) goto L7;
        r7 = r6[0].hashCode();
        goto L8
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void l(Object[] r10) {
        com.bytedance.apm.q.j.m.a r0 = new com.bytedance.apm.q.j.m.a();
        int r1 = r10.length;
        int r3 = 0;
        int r6 = -1;
        boolean r4 = false;
        int r5 = 0;
    L3:
        if (r3 >= r1) goto L20;
        Object r7 = r10[r3];
        if ((r7 instanceof Integer) == false) goto L9;
        if (r4 == true) goto L9;
        r0.f1802e = ((Integer) r7).intValue();
        r4 = true;
    L19:
        r3 = r3 + 1;
    L9:
        if ((r7 instanceof Long) == false) goto L17;
        if (r5 != 0) goto L13;
        r0.f1805a = ((Long) r7).longValue();
        r0.f1805a = r0.b();
    L15:
        r5 = r5 + 1;
        goto L19
    L13:
        if (r5 != 2) goto L15;
        r0.f1803f = ((Long) r7).longValue();
        goto L15
    L17:
        if ((r7 instanceof PendingIntent) == false) goto L19;
        PendingIntent r8 = (PendingIntent) r7;
        r0.f1804g = com.bytedance.apm.util.g.a(r8);
        r6 = r8.hashCode();
        goto L19
    L20:
        if (r6 != (-1)) goto L22;
        return;
    L22:
        if (r0.f1803f != 0) goto L24;
        long r2 = r0.f1805a;
    L25:
        r0.f1806b = r2;
        if (com.bytedance.apm.q.a.F().I() == false) goto L28;
        r0.f1807c = Thread.currentThread().getName();
        r0.f1808d = Thread.currentThread().getStackTrace();
    L28:
        this.f1780e.put(Integer.valueOf(r6), r0);
        return;
    L24:
        r2 = -1;
        goto L25
    }

    private void m(int[] r14, int r15) {
        long r9 = System.currentTimeMillis();
        if (this.f1778c == false) goto L7;
        if ((r15 % 2) != 0) goto L7;
    L10:
        com.bytedance.apm.q.i.a.h().l(new com.bytedance.apm.u.a(false, r9, h(), this.f1779d, r14[0], null));
        com.bytedance.apm.q.i.a r16 = com.bytedance.apm.q.i.a.h();
        com.bytedance.apm.u.a r12 = new com.bytedance.apm.u.a(true, r9, h(), this.f1779d, r14[1], null);
    L12:
        r16.l(r12);
        return;
    L7:
        if (this.f1778c == false) goto L9;
    L11:
        com.bytedance.apm.q.i.a.h().l(new com.bytedance.apm.u.a(true, r9, h(), this.f1779d, r14[0], null));
        r16 = com.bytedance.apm.q.i.a.h();
        r12 = new com.bytedance.apm.u.a(false, r9, h(), this.f1779d, r14[1], null);
        goto L12
    L9:
        if ((r15 % 2) != 1) goto L11;
        goto L10
    }

    private void n() {
        long r1 = System.currentTimeMillis();
        int[] r3 = this.f1781f;
        int r4 = 0;
        double r5 = (((((double) r3[0]) + ((double) r3[1])) / (r1 - this.f1777b)) * 60000.0d) * 10.0d;
        double r11 = ((((double) this.f1782g) / (r1 - this.f1777b)) * 60000.0d) * 10.0d;
        if (r5 < com.bytedance.apm.q.g.a.h()) goto L6;
        r4 = 49;
    L6:
        if (r11 < com.bytedance.apm.q.g.a.a()) goto L8;
        r4 = r4 | 50;
    L8:
        if (r4 != 0) goto L22;
        return;
    L22:
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L21
        r2.put("issue_type", r4).put("wake_up_count", r5).put("normal_count", r11);     // Catch: Throwable -> L21
        ConcurrentHashMap<Integer, T> r6 = this.f1780e;     // Catch: Throwable -> L21
        if (r6 != 0) goto L13;
    L19:
        com.bytedance.apm.a0.b.b(r2, "battery_trace");     // Catch: Throwable -> L21
        com.bytedance.apm.t.c.a.p().e(new com.bytedance.apm.t.d.d("battery_trace", r2));     // Catch: Throwable -> L21
        return;
    L13:
        if (r6.size() <= 0) goto L19;
        JSONArray r7 = new JSONArray();     // Catch: Throwable -> L21
        Iterator r15 = this.f1780e.values().iterator();     // Catch: Throwable -> L21
    L16:
        if (r15.hasNext() == false) goto L18;
        r7.put(((com.bytedance.apm.q.j.m.a) r15.next()).d());     // Catch: Throwable -> L21
        goto L16
    L18:
        r2.put("detail", r7);     // Catch: Throwable -> L21
    }

    @Override // com.bytedance.apm.q.j.c, com.bytedance.apm.q.j.l
    public void b(boolean r3) {
        super.b(r3);
        long r0 = System.currentTimeMillis();
        Object r4 = this.f1785j;
        monitor-enter(r4);
        this.f1783h.add(Long.valueOf(r0));     // Catch: Throwable -> L7
        monitor-exit(r4);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.q.h.b
    public String c() {
        return "android.app.IAlarmManager";
    }

    @Override // com.bytedance.apm.q.j.l
    public void d(boolean r1, boolean r2) {
        this.f1779d = r1;
    }

    @Override // com.bytedance.apm.q.j.l
    public void e(com.bytedance.apm.q.i.b r3, com.bytedance.apm.u.a r4) {
        if (h().equals(r4.f2010d) == true) goto L5;
        return;
    L5:
        boolean r2 = r4.j();
        long r0 = r4.a();
        if (r2 == false) goto L8;
        r3.i(r0);
        return;
    L8:
        r3.s(r0);
    }

    @Override // com.bytedance.apm.q.j.c, com.bytedance.apm.q.j.l
    public void f(boolean r3) {
        super.f(r3);
        long r0 = System.currentTimeMillis();
        Object r4 = this.f1785j;
        monitor-enter(r4);
        this.f1783h.add(Long.valueOf(r0));     // Catch: Throwable -> L7
        monitor-exit(r4);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.q.j.c
    protected /* bridge */ /* synthetic */ void g(com.bytedance.apm.q.j.m.b r1, long r2, long r4) {
        j((com.bytedance.apm.q.j.m.a) r1, r2, r4);
    }

    @Override // com.bytedance.apm.q.j.c
    protected void i(long r8, long r10, boolean r12) {
        this.f1782g = 0;
        this.f1781f = new int[2];
        this.f1786k.add(Long.valueOf(r8));
        Object r9 = this.f1785j;
        monitor-enter(r9);
        this.f1786k.addAll(this.f1783h);     // Catch: Throwable -> L15
        this.f1783h.clear();     // Catch: Throwable -> L15
        monitor-exit(r9);     // Catch: Throwable -> L15
        this.f1786k.add(Long.valueOf(r10));
        this.f1784i = 1;
    L8:
        if (this.f1784i >= this.f1786k.size()) goto L10;
        super.i(this.f1786k.get(this.f1784i - 1).longValue(), this.f1786k.get(this.f1784i).longValue(), r12);
        this.f1784i++;
        goto L8
    L10:
        int[] r11 = this.f1781f;
        if ((r11[0] + r11[1]) == 0) goto L13;
        m(r11, this.f1786k.size());
    L13:
        this.f1786k.clear();
        n();
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.q.h.b
    public void invoke(Object r1, Method r2, Object[] r3) {
        String r4 = r2.getName();     // Catch: Exception -> L9
        if ("set".equals(r4) == false) goto L6;
        l(r3);     // Catch: Exception -> L9
    L10:
        return;
    L6:
        if ("remove".equals(r4) == false) goto L10;
        k(r3);     // Catch: Exception -> L9
    }

    protected void j(com.bytedance.apm.q.j.m.a r11, long r12, long r14) {
        long r0 = r11.f1803f;
        int r5 = 1;
        if (r0 > 0) goto L10;
        long r1 = r11.f1805a;
        if (r12 <= r1) goto L7;
        return;
    L7:
        if (r1 <= r14) goto L23;
        return;
    L23:
        if (r11.c() == false) goto L25;
        int[] r13 = this.f1781f;
        int r10 = this.f1784i % 2;
        r13[r10] = r13[r10] + r5;
        return;
    L25:
        this.f1782g += r5;
        return;
    L10:
        long r6 = r11.f1805a;
        if (r6 >= r12) goto L13;
        r6 = (r12 + r0) - ((r12 - r6) % r0);
    L13:
        long r15 = r11.f1806b;
        if (r15 <= r14) goto L16;
    L19:
        long r16 = r14 - r6;
        if (r16 <= 0) goto L28;
        r5 = 1 + ((int) (r16 / r0));
        goto L23
    L28:
        return;
    L16:
        if (r15 <= 0) goto L19;
        r14 = r15;
        goto L19
    }
}
