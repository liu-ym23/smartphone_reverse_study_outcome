package com.bytedance.apm.q.j;

import android.os.BatteryManager;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.bytedance.services.apm.api.EnsureManager;

/* JADX INFO: loaded from: classes.dex */
public class e extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final BatteryManager f1787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1789g;

    @RequiresApi(api = 21)
    public e() {
        super("battery_consume");
        this.f1788f = false;
        this.f1789g = -1;
        this.f1787e = (BatteryManager) com.bytedance.apm.d.h().getSystemService("batterymanager");
    }

    private void i(boolean r4, boolean r5) {
        if (Build.VERSION.SDK_INT < 21) goto L12;
        int r0 = this.f1787e.getIntProperty(1);
        if (r5 == true) goto L10;
        if (r4 == false) goto L10;
        if (this.f1788f == false) goto L10;
        h(true, Math.abs(r0 - this.f1789g), com.bytedance.apm.q.a.F().E());
    L10:
        this.f1789g = r0;
        this.f1788f = true;
        return;
    }

    @Override // com.bytedance.apm.q.j.b
    protected void c(boolean r4, boolean r5) {
        if (g() == true) goto L6;
        return;
    L6:
        if (r4 == true) goto L21;
    L13:
        boolean r6 = true;
    L14:
        i(r5, r6);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        if (com.bytedance.apm.d.C() == false) goto L19;
        com.bytedance.apm.x.e.d(com.bytedance.apm.x.b.f2126b, new String[]{"BatteryConsumeStatsImpl error: " + th.getCause()});
    L19:
        EnsureManager.ensureNotReachHere("BatteryConsumeStatsImpl");
        return;
    L21:
        if (this.f1773b == true) goto L13;
        r6 = false;
        goto L14
    }

    @Override // com.bytedance.apm.q.j.l
    public void e(com.bytedance.apm.q.i.b r5, com.bytedance.apm.u.a r6) {
        r5.j(r6.a() / 1000);
    }
}
