package com.bytedance.apm.q;

import android.app.Activity;
import android.os.BatteryManager;
import android.os.Build;
import android.os.SystemClock;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.bdlocation.trace.TraceCons;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f extends com.bytedance.apm.a0.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1721g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f1722h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f1723i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f1724j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final LinkedList<b> f1725k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1726l;
    long m;
    long n;
    int o;
    int p;
    long q;
    long r;
    private long s;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final f f1727a = null;

        static {
            f1727a = new f();
        }

        static /* synthetic */ f a() {
            return f1727a;
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f1728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f1729b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f1730c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f1731d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f1732e;

        private b() {
        }

        public double a() {
            double r0 = c() / 1000.0d;
            if (r0 > 0.0d) goto L5;
            return 0.0d;
        L5:
            return (Math.round(b() / r0) * 100) / 100.0d;
        }

        public long b() {
            return this.f1732e - this.f1730c;
        }

        public long c() {
            return this.f1731d - this.f1729b;
        }

        public String toString() {
            return String.format("Scene{ name=%s, cpu=%s ms, dur=%s ms, speed=%s", new Object[]{this.f1728a, Long.valueOf(b()), Long.valueOf(c()), Double.valueOf(a())});
        }
    }

    public f() {
        new ConcurrentHashMap();
        new LinkedList();
        this.f1725k = new LinkedList();
        this.f1726l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.f1122e = "battery";
    }

    private void o() {
        long r0 = SystemClock.uptimeMillis();
        long r2 = this.q;
        if ((this.f1723i + r2) <= r0) goto L5;
        return;
    L5:
        long r3 = r0 - r2;
        this.q = r0;
        int r1 = ((BatteryManager) d.b.b.o.a.b().getSystemService("batterymanager")).getIntProperty(4);
        int r4 = r1 - this.p;
        if (this.r == this.f1726l) goto L8;
    L13:
        this.p = r1;
        this.r = this.f1726l;
        return;
    L8:
        if (e() == true) goto L13;
        if (r4 > 0) goto L13;
        int r5 = Math.abs(r4);
        if (r5 > 100) goto L13;
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L15
        r6.put("battery", Math.abs(r5));     // Catch: Exception -> L15
        r6.put("duraion", r3);     // Catch: Exception -> L15
        d.b.b.d.a.h("apm_battery_monitor", null, r6, null);     // Catch: Exception -> L15
        goto L13
    }

    public static f q() {
        return a.a();
    }

    private void r() {
        long r0 = SystemClock.uptimeMillis();
        if ((this.s + this.f1724j) <= r0) goto L5;
        return;
    L5:
        this.s = r0;
        LinkedList<b> r1 = this.f1725k;
        monitor-enter(r1);
        Iterator<b> r2 = this.f1725k.iterator();     // Catch: Throwable -> L16
    L9:
        if (r2.hasNext() == false) goto L13;
        b r3 = r2.next();     // Catch: Throwable -> L16
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L19 Throwable -> L16
        r4.put("scene", r3.f1728a);     // Catch: Exception -> L19 Throwable -> L16
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L19 Throwable -> L16
        r5.put("cpu_speed", r3.a());     // Catch: Exception -> L19 Throwable -> L16
        d.b.b.d.a.h("apm_proc_cpu_info", r4, r5, null);     // Catch: Exception -> L19 Throwable -> L16
        goto L9
    L13:
        this.f1725k.clear();     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.a0.a
    protected void c(JSONObject r5) {
        boolean r1 = true;
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L7:
        r1 = false;
    L8:
        this.f1721g = r1;
        if (r1 == false) goto L11;
        this.f1722h = r5.optLong("power_cpu_monitor_interval", 60000);
        this.f1723i = r5.optLong("power_battery_monior_interval", 300000);
        this.f1724j = r5.optLong("power_proc_cpu_upload_interval", 120000);
        return;
    L11:
        ActivityLifeObserver.getInstance().unregister(this);
        com.bytedance.apm.f0.b.f().m(this);
        return;
    L5:
        if (r5.optInt("power_monitor_enable", 0) != 1) goto L7;
        goto L7
    }

    @Override // com.bytedance.apm.a0.a
    protected boolean f() {
        return this.f1721g;
    }

    @Override // com.bytedance.apm.a0.a
    protected void i() {
        super.i();
        p();
        o();
        r();
    }

    @Override // com.bytedance.apm.a0.a
    protected void j() {
        super.j();
    }

    @Override // com.bytedance.apm.a0.a
    protected long n() {
        return this.f1722h;
    }

    @Override // com.bytedance.apm.a0.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r1) {
        super.onBackground(r1);
        this.f1726l++;
    }

    @Override // com.bytedance.apm.a0.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r1) {
        super.onFront(r1);
        this.f1726l++;
    }

    public void p() {
        long r0 = com.bytedance.apm.util.b.b();
        long r2 = SystemClock.uptimeMillis();
        long r4 = this.n;
        if (r4 != 0) goto L5;
    L14:
        this.o = this.f1726l;
        this.m = r0;
        this.n = r2;
        return;
    L5:
        if (this.o != this.f1726l) goto L14;
        double r5 = (r2 - r4) / 60000.0d;
        if (r5 <= 0.0d) goto L14;
        double r6 = Math.round(((r0 - this.m) / r5) * 100.0d) / 100.0d;
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L16
        if (e() == false) goto L12;
        String r8 = TraceCons.METRIC_BACKGROUND;
    L13:
        r7.put("status", r8);     // Catch: Exception -> L16
        JSONObject r9 = new JSONObject();     // Catch: Exception -> L16
        r9.put("cpu_speed_min", r6);     // Catch: Exception -> L16
        d.b.b.d.a.h("apm_cpu_speed", r7, r9, null);     // Catch: Exception -> L16
        goto L14
    L12:
        r8 = "foreground";
        goto L13
    }
}
