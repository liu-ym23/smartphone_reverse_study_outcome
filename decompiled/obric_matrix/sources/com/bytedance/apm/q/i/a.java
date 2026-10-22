package com.bytedance.apm.q.i;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.d;
import com.bytedance.apm.q.j.l;
import com.bytedance.apm.util.i;
import com.bytedance.apm.x.e;
import com.bytedance.bdlocation.trace.TraceCons;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.apm.battery.dao.c.a f1748c;

    /* JADX INFO: renamed from: com.bytedance.apm.q.i.a$a, reason: collision with other inner class name */
    class RunnableC0055a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f1749f;

        RunnableC0055a(a r1) {
            this.f1749f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(this.f1749f);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            EnsureManager.ensureNotReachHere(th, "handleReportAndHandleCache");
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f1750a = null;

        static {
            f1750a = new a(null);
        }

        static /* synthetic */ a a() {
            return f1750a;
        }
    }

    private a() {
        this.f1746a = "";
    }

    /* synthetic */ a(RunnableC0055a r1) {
        this();
    }

    static /* synthetic */ void a(a r0) {
        r0.n();
    }

    private void b(long r1) {
        f().n(r1);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "cleanBatteryLog");
    }

    private boolean c(com.bytedance.apm.q.i.b r5, List<com.bytedance.apm.u.a> r6) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Iterator<com.bytedance.apm.u.a> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L25;
        com.bytedance.apm.u.a r2 = r7.next();
        if (r2.m() == true) goto L7;
        r1.add(r2);
        goto L4
    L7:
        r0.add(r2);
        goto L4
    L25:
    L22:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "divideByChargingStatusAndReport");
        return false;
    L11:
        if (r0.isEmpty() == false) goto L13;
    L15:
        boolean r3 = true;
    L17:
        if (r1.isEmpty() == true) goto L33;
        if (m(r5, r1) == true) goto L33;
        return false;
    L33:
        return r3;
    L13:
        if (m(r5, r0) == true) goto L15;
        r3 = false;
        goto L17
    }

    private boolean d(com.bytedance.apm.q.i.b r5, List<com.bytedance.apm.u.a> r6) {
        HashMap r0 = new HashMap(4);
        Iterator<com.bytedance.apm.u.a> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L20;
        com.bytedance.apm.u.a r1 = r7.next();
        String r2 = r1.d();
        List r3 = (List) r0.get(r2);
        if (r3 != null) goto L7;
        LinkedList r4 = new LinkedList();
        r4.add(r1);
        r0.put(r2, r4);
        goto L4
    L7:
        r3.add(r1);
        goto L4
    L20:
        Iterator r8 = r0.values().iterator();     // Catch: Exception -> L17
        boolean r9 = true;
    L12:
        if (r8.hasNext() == false) goto L33;
        if (c(r5, (List) r8.next()) == true) goto L12;
        r9 = false;
        goto L12
    L33:
        return r9;
    L17:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "divideBySceneAndReport");
        return false;
    }

    private List<com.bytedance.apm.u.a> e(boolean r1, long r2) {
        return f().l(r1, r2);
    L5:
        return Collections.emptyList();
    }

    private com.bytedance.apm.battery.dao.c.a f() {
        if (this.f1748c != null) goto L6;
        this.f1748c = com.bytedance.apm.battery.dao.c.a.k();
    L6:
        return this.f1748c;
    }

    public static a h() {
        return b.a();
    }

    private void i(com.bytedance.apm.u.a r2) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return;
    L5:
        if (r2.k() == true) goto L10;
        r2.t(false);
        return;
    }

    private void j(com.bytedance.apm.u.a r4) {
        if (TextUtils.isEmpty(this.f1747b) == false) goto L5;
        this.f1747b = String.valueOf(System.currentTimeMillis());
    L5:
        r4.p(d.G());
        r4.q(d.i());
        r4.s(this.f1747b);
        if (r4.k() == false) goto L8;
        String r0 = this.f1746a;
    L10:
        if (TextUtils.isEmpty(r4.d()) == true) goto L13;
        r0 = r4.d() + "#" + r0;
    L13:
        r4.r(r0);
        i(r4);
        o(r4);
        return;
    L8:
        r0 = TraceCons.METRIC_BACKGROUND;
        goto L10
    }

    private boolean m(com.bytedance.apm.q.i.b r7, List<com.bytedance.apm.u.a> r8) {
        Map<String, l> r6 = com.bytedance.apm.q.a.F().D();
        StringBuilder r0 = new StringBuilder();
        Iterator<com.bytedance.apm.u.a> r1 = r8.iterator();
        String r2 = null;
    L4:
        if (r1.hasNext() == false) goto L19;
        com.bytedance.apm.u.a r3 = r1.next();
        if (r2 != null) goto L8;
    L9:
        r2 = r3.f();
        r0.append(r2);
    L11:
        if ("ground_record".equals(r3.f2010d) == true) goto L13;
        l r4 = r6.get(r3.f2010d);
        if (r4 == null) goto L4;
        r4.e(r7, r3);
        goto L4
    L13:
        if (r3.k() == true) goto L14;
        r7.c(r3.a());
        goto L4
    L14:
        r7.m(r3.a());
        goto L4
    L8:
        if (r2.equals(r3.f()) == true) goto L11;
    L19:
        com.bytedance.apm.u.a r9 = r8.get(0);
        r7.C(r9.l());
        r7.D(r9.c());
        r7.F(r0.toString());
        r7.E(r9.d());
        r7.B(r9.m());
        com.bytedance.apm.x.a.d("APM-Battery", "Report Data proc:" + r9.c() + " scene:" + r9.d() + " size:" + r8.size());
        return r7.z(true);
    }

    private void n() {
        if (d.G() == true) goto L5;
        return;
    L5:
        com.bytedance.apm.q.i.b r0 = new com.bytedance.apm.q.i.b();
        List<com.bytedance.apm.u.a> r1 = e(true, 0);
        if (i.b(r1) == false) goto L8;
        return;
    L8:
        boolean r2 = d(r0, r1);
        r0.y();
        com.bytedance.apm.u.a r3 = r1.get(r1.size() - 1);
        long r4 = r3.b();
        long r5 = r3.g();
        if (r2 == true) goto L16;
        if (d.C() == false) goto L13;
        e.f(com.bytedance.apm.x.b.f2126b, new String[]{"report main process data failed, clean data and stop calc data of other process"});
    L13:
        b(r4);
        return;
    L16:
        if (d.C() == false) goto L18;
        e.d(com.bytedance.apm.x.b.f2126b, new String[]{"report main process data over, begin handle other process data"});
    L18:
        List<com.bytedance.apm.u.a> r6 = e(false, r5);
        HashMap r7 = new HashMap(4);
        Iterator<com.bytedance.apm.u.a> r8 = r6.iterator();
    L20:
        if (r8.hasNext() == false) goto L34;
        com.bytedance.apm.u.a r9 = r8.next();
        String r10 = r9.c();
        List r11 = (List) r7.get(r10);
        if (r11 != null) goto L23;
        LinkedList r12 = new LinkedList();
        r12.add(r9);
        r7.put(r10, r12);
        goto L20
    L23:
        r11.add(r9);
        goto L20
    L34:
        Iterator r13 = r7.values().iterator();     // Catch: Exception -> L30
    L27:
        if (r13.hasNext() == false) goto L32;
        d(r0, (List) r13.next());     // Catch: Exception -> L30
        r0.y();     // Catch: Exception -> L30
    L32:
        r0.A();
        b(r4);
        com.bytedance.apm.x.a.d("APM-Battery", "Report Data All Success");
        return;
    L30:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "reportLastTimeBattery");
        goto L32
    }

    private void o(com.bytedance.apm.u.a r6) {
    L7:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "saveBatteryLog");
        return;
    L3:
        if (d.C() == false) goto L5;
        e.d(com.bytedance.apm.x.b.f2126b, new String[]{"saveBatteryLog into db: " + r6});     // Catch: Exception -> L7
    L5:
        com.bytedance.apm.x.a.d("APM-BatteryLocal", q(r6));     // Catch: Exception -> L7
        f().m(r6);     // Catch: Exception -> L7
    }

    private String q(com.bytedance.apm.u.a r7) {
        JSONObject r6 = r7.v();
        if (TextUtils.equals(r7.h(), "cpu_active_time") == false) goto L7;
        long r2 = r7.a() * 1000;
        long r4 = com.bytedance.apm.util.b.j(100);
    L5:
        r2 = r2 / r4;
    L6:
        r6.put("accumulation", r2);
        return r6.toString();
    L7:
        boolean r0 = TextUtils.equals(r7.h(), "traffic");
        r2 = r7.a();
        if (r0 == false) goto L6;
        r4 = 1024;
        goto L5
    }

    public String g() {
        return this.f1746a;
    }

    public void k(boolean r2) {
        if (r2 == false) goto L9;
        com.bytedance.apm.f0.b.f().i(new RunnableC0055a(this));
        return;
    L9:
        n();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th, "handleReportAndHandleCache");
    }

    public void l(com.bytedance.apm.u.a r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        j(r1);
    }

    public void p(String r1) {
        this.f1746a = r1;
    }
}
