package com.bytedance.apm.q.j;

import android.app.usage.NetworkStatsManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.bytedance.services.apm.api.EnsureManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class i extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long[] f1795e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Method f1796f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object f1797g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1798h;

    public i() {
        super("traffic_all_interface");
        this.f1798h = false;
    }

    @RequiresApi(api = 23)
    private long[] i() {
        if (this.f1796f != null) goto L10;
        NetworkStatsManager r0 = (NetworkStatsManager) com.bytedance.apm.d.h().getSystemService("netstats");
        Field r3 = r0.getClass().getDeclaredField("mService");
        r3.setAccessible(true);
        Object r1 = r3.get(r0);
        this.f1797g = r1;
        Method[] r2 = r1.getClass().getDeclaredMethods();
        int r4 = r2.length;
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L10;
        Method r6 = r2[r5];
        if (TextUtils.equals("getDataLayerSnapshotForUid", r6.getName()) == true) goto L8;
        r5 = r5 + 1;
        goto L5
    L8:
        this.f1796f = r6;
        r6.setAccessible(true);
    L10:
        Object r7 = this.f1796f.invoke(this.f1797g, new Object[]{Integer.valueOf(Process.myUid())});
        Field r8 = r7.getClass().getDeclaredField("rxBytes");
        r8.setAccessible(true);
        long[] r9 = (long[]) r8.get(r7);
        Field r10 = r7.getClass().getDeclaredField("txBytes");
        r10.setAccessible(true);
        long[] r11 = (long[]) r10.get(r7);
        Field r12 = r7.getClass().getDeclaredField("rxPackets");
        r12.setAccessible(true);
        long[] r13 = (long[]) r12.get(r7);
        Field r14 = r7.getClass().getDeclaredField("txPackets");
        r14.setAccessible(true);
        return new long[]{k(r9) + k(r11), k(r13) + k((long[]) r14.get(r7))};
    }

    private void j(boolean r12, long r13, String r15, String r16) {
        if (r13 < 0) goto L5;
        com.bytedance.apm.q.i.a.h().l(new com.bytedance.apm.u.a(r12, System.currentTimeMillis(), "traffic_all_interface", this.f1773b, r13, r16, r15));
        return;
    L5:
        if (com.bytedance.apm.d.C() == false) goto L7;
        com.bytedance.apm.x.e.d(com.bytedance.apm.x.b.f2126b, new String[]{"BatteryTrafficAllInterface value error: " + r13});
    L7:
        com.bytedance.apm.x.a.d("APM-Battery", "BatteryTrafficAllInterface value error: " + r13);
    }

    private long k(long[] r6) {
        long r0 = 0;
        if (r6 != null) goto L5;
    L10:
        return r0;
    L5:
        if (r6.length == 0) goto L10;
        int r5 = r6.length;
        int r2 = 0;
    L8:
        if (r2 >= r5) goto L10;
        r0 = r0 + r6[r2];
        r2 = r2 + 1;
        goto L8
    }

    @Override // com.bytedance.apm.q.j.b
    protected void c(boolean r10, boolean r11) {
        if (g() == true) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 23) goto L21;
        return;
    L21:
        long[] r2 = i();     // Catch: Throwable -> L13
        if (this.f1795e == null) goto L11;
        if (r11 == false) goto L11;
        String r12 = com.bytedance.apm.q.a.F().E();     // Catch: Throwable -> L13
        j(r10, r2[0] - this.f1795e[0], "source_bytes", r12);     // Catch: Throwable -> L13
        j(r10, r2[1] - this.f1795e[1], "source_packets", r12);     // Catch: Throwable -> L13
    L11:
        this.f1795e = r2;     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        if (com.bytedance.apm.d.C() == false) goto L18;
        com.bytedance.apm.x.e.d(com.bytedance.apm.x.b.f2126b, new String[]{"handleTrafficMonitor error: " + th.getCause()});
    L18:
        if (this.f1798h == true) goto L25;
        EnsureManager.ensureNotReachHere(th, "BatteryTrafficAllInterface");
        this.f1798h = true;
        return;
    }

    @Override // com.bytedance.apm.q.j.l
    public void e(com.bytedance.apm.q.i.b r3, com.bytedance.apm.u.a r4) {
        if (r4.k() == false) goto L11;
        if (TextUtils.equals(r4.e(), "source_bytes") == false) goto L8;
        r3.k(r4.a());
        return;
    L8:
        if (TextUtils.equals(r4.e(), "source_packets") == false) goto L18;
        r3.o(r4.a());
        return;
    L18:
        return;
    L11:
        if (TextUtils.equals(r4.e(), "source_bytes") == false) goto L14;
        r3.a(r4.a());
        return;
    L14:
        if (TextUtils.equals(r4.e(), "source_packets") == false) goto L21;
        r3.e(r4.a());
        return;
    }
}
