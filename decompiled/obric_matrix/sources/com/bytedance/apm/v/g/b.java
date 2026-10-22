package com.bytedance.apm.v.g;

import android.os.Handler;
import com.bytedance.apm.PerfConfig;
import com.bytedance.apm.block.evil.EvilMethodSwitcher;
import com.bytedance.apm.r.m.e;
import com.bytedance.apm.r.m.f;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.monitor.collector.h;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f2111a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f2112b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static d.b.o.b.a f2113c;

    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.c();
        }
    }

    static {
    }

    public static synchronized void a() {
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f2113c != null) goto L7;
    L9:
        monitor-exit(b.class);
        return;
    L7:
        if (EvilMethodSwitcher.isOpenLaunchEvilMethod() == false) goto L9;
        f2113c.j();     // Catch: Throwable -> L11
        goto L9
    }

    public static synchronized void b() {
        monitor-enter(b.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (f2111a == false) goto L9;
        monitor-exit(b.class);
        return;
    L9:
        f2111a = true;     // Catch: Throwable -> L18
        if (f2112b == true) goto L15;
        f2112b = true;     // Catch: Throwable -> L18
        d.b.o.b.a.m(EvilMethodSwitcher.getLaunchEvilThresholdMs());     // Catch: Throwable -> L18
        d.b.o.b.a.n(true);     // Catch: Throwable -> L18
        if (EvilMethodSwitcher.isMessageKeyEnable() == false) goto L14;
        PerfConfig.setReportMessage();     // Catch: Throwable -> L18
    L14:
        e.A().C();     // Catch: Throwable -> L18
        f.E().K();     // Catch: Throwable -> L18
        d.b.o.b.a.m = true;     // Catch: Throwable -> L18
        d.b.o.b.a r2 = new d.b.o.b.a(EvilMethodSwitcher.isLaunchLimitEvilMethodDepth(), true);     // Catch: Throwable -> L18
        f2113c = r2;     // Catch: Throwable -> L18
        r2.p();     // Catch: Throwable -> L18
        h.d(true, "launch", null);     // Catch: Throwable -> L18
        new Handler().postDelayed(new a(), BDLocationConfig.sScanBleMaxInterval);     // Catch: Throwable -> L18
    L15:
        com.bytedance.apm.g0.h.b.a("app_launch_evil_method_scene_apm_2");     // Catch: Throwable -> L18
        monitor-exit(b.class);
    }

    public static synchronized void c() {
        monitor-enter(b.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f2111a == true) goto L9;
        monitor-exit(b.class);
        return;
    L9:
        f2111a = false;     // Catch: Throwable -> L12
        f2113c.o(EvilMethodSwitcher.isLimitEvilMethodDepth());     // Catch: Throwable -> L12
        d.b.o.b.a.m(EvilMethodSwitcher.getEvilThresholdMs());     // Catch: Throwable -> L12
        com.bytedance.apm.g0.h.b.c("app_launch_evil_method_scene_apm_2");     // Catch: Throwable -> L12
        monitor-exit(b.class);
    }
}
