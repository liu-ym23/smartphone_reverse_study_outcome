package com.bytedance.monitor.collector;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm6.perf.base.model.ThreadStatInfo;
import com.bytedance.services.apm.api.IActivityLifeObserver;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k {
    private static b o = null;
    static volatile boolean p = false;
    private static volatile k q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.bytedance.monitor.collector.b> f5195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f5196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f5197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f5198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f5199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f5200f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f5201g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BinderMonitor f5202h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private l f5203i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private c f5204j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private g f5205k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private d f5206l;
    private e m;
    protected com.bytedance.apm.f0.e n;

    class a implements IActivityLifeObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f5207a;

        a(k r1) {
            this.f5207a = r1;
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onActivityCreated(Activity r1, Bundle r2) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onActivityPause(Activity r1) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onActivityResume(Activity r1) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onActivityStarted(Activity r1) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onBackground(Activity r1) {
            this.f5207a.D();
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onChange(Activity r1, Fragment r2) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onFront(Activity r1) {
            this.f5207a.B();
        }
    }

    public interface b {
        void loadLibrary(String r1);
    }

    static {
    }

    private k() {
        this.f5196b = false;
        this.f5197c = false;
        this.f5198d = false;
        this.f5199e = false;
        this.f5200f = false;
        this.f5195a = new CopyOnWriteArrayList();
        ActivityLifeObserver.getInstance().register(new a(this));
    }

    public static k n() {
        if (q != null) goto L15;
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (q != null) goto L9;
        q = new k();     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
    L15:
        return q;
    }

    public static boolean t() {
        return p;
    }

    public static synchronized boolean u(Context r2) {
        monitor-enter(k.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (p == true) goto L11;
        b r1 = o;     // Catch: Throwable -> L14
        if (r1 == null) goto L9;
        r1.loadLibrary("monitorcollector-lib");     // Catch: Throwable -> L14
        p = true;     // Catch: Throwable -> L14
    L10:
        ByteHook.init();     // Catch: Throwable -> L14
        goto L11
    L9:
        p = d.b.l.a.g.b.c(r2, "monitorcollector-lib");     // Catch: Throwable -> L14
    L11:
        boolean r3 = p;     // Catch: Throwable -> L14
        monitor-exit(k.class);
        return r3;
    }

    public synchronized void A(long r2, boolean r4) {
        monitor-enter(this);
        LockMonitorManager.setOpenFetchStack(true);     // Catch: Throwable -> L9
        if (p == true) goto L13;
    L7:
        monitor-exit(this);
        return;
    L13:
        MonitorJni.enableLockAll(r2, r4);     // Catch: Throwable -> L12
    L9:
        th = move-exception;
        throw th;
    }

    public void B() {
        if (this.m != null) goto L5;
        return;
    L5:
        if (this.f5200f == false) goto L9;
        this.m.start();
        return;
    }

    public void C() {
        int r1 = 0;
    L4:
        if (r1 >= this.f5195a.size()) goto L6;
        this.f5195a.get(r1).e();
        r1 = r1 + 1;
        goto L4
    L6:
        this.f5197c = false;
    }

    public void D() {
        if (this.m != null) goto L5;
        return;
    L5:
        if (this.f5200f == false) goto L9;
        this.m.stop();
        return;
    }

    public synchronized boolean E(j r6) {
        monitor-enter(this);
    L42:
        th = move-exception;
        throw th;
    L4:
        if (com.bytedance.apm.d.C() == false) goto L8;
        Log.i("PerfMonitorManager", "PerfMonitorManager update config:\n " + r6);     // Catch: Throwable -> L42
        b(true);     // Catch: Throwable -> L42
    L8:
        if (t() == true) goto L11;
        monitor-exit(this);
        return false;
    L11:
        this.f5200f = r6.f();     // Catch: Throwable -> L42
        e r0 = this.m;     // Catch: Throwable -> L42
        if (r0 == null) goto L21;
        if (this.f5199e == false) goto L16;
    L18:
        boolean r3 = false;
    L19:
        r0.b(r3);     // Catch: Throwable -> L42
        goto L21
    L16:
        if (this.f5200f == false) goto L18;
        r3 = true;
    L21:
        if (this.f5203i != null) goto L24;
        this.f5203i = new l(r6.b());     // Catch: Throwable -> L42
    L24:
        if (r6.d() == false) goto L30;
        if (this.f5202h != null) goto L28;
        this.f5202h = new BinderMonitor(r6.b());     // Catch: Throwable -> L42
    L28:
        this.f5202h.j();     // Catch: Throwable -> L42
    L30:
        if (r6.c() == false) goto L36;
        if (this.f5204j != null) goto L34;
        this.f5204j = new c(r6.b());     // Catch: Throwable -> L42
    L34:
        this.f5204j.i(r6.a());     // Catch: Throwable -> L42
    L36:
        if (r6.e() == true) goto L38;
    L40:
        monitor-exit(this);
        return true;
    L38:
        if (this.f5205k != null) goto L40;
        this.f5205k = new g(r6.b(), false);     // Catch: Throwable -> L42
        goto L40
    }

    public void a(com.bytedance.monitor.collector.b r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.f5195a.contains(r2) == true) goto L10;
        this.f5195a.add(r2);
        if (this.f5197c == false) goto L11;
        r2.d();
        return;
    L11:
        return;
    }

    void b(boolean r1) {
        if (p == true) goto L5;
        return;
    L5:
        MonitorJni.doSetDebugMode(r1);     // Catch: Throwable -> L7
        return;
    }

    public long c() {
        if (this.f5201g == true) goto L7;
        return com.bytedance.apm.util.b.b();
    L7:
        if (t() == true) goto L12;
        return 0;
    L12:
        return MonitorJni.doGetAppCpuTime();
    L14:
        return 0;
    }

    @Nullable
    public List<BinderMonitor.a> d() {
        BinderMonitor r0 = this.f5202h;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.k();
    }

    public JSONObject e() {
        JSONObject r0 = new JSONObject();
        int r1 = 0;
    L10:
    L7:
        e = move-exception;
        e.printStackTrace();
    L9:
        return r0;
    L4:
        if (r1 >= this.f5195a.size()) goto L9;
        Pair<String, ?> r2 = this.f5195a.get(r1).a();     // Catch: Exception -> L7
        r0.put((String) r2.first, r2.second);     // Catch: Exception -> L7
        r1 = r1 + 1;
        goto L10
    }

    public JSONObject f(long r7, long r9) {
        return g(r7, r9, false);
    }

    public JSONObject g(long r5, long r7, boolean r9) {
        JSONObject r0 = new JSONObject();
        int r1 = 0;
    L4:
        if (r1 >= this.f5195a.size()) goto L12;
        com.bytedance.monitor.collector.b r2 = this.f5195a.get(r1);     // Catch: Exception -> L13
        if (r9 == true) goto L8;
    L10:
        Pair<String, ?> r3 = r2.b(r5, r7);     // Catch: Exception -> L13
        r0.put((String) r3.first, r3.second);     // Catch: Exception -> L13
        goto L11
    L8:
        if ((r2 instanceof g) == false) goto L10;
    L11:
        r1 = r1 + 1;
        goto L4
    L12:
        return r0;
    }

    public String h(int r1) {
        return MonitorJni.doDumpNativeStack(r1);
    }

    public String i(long r2, long r4) {
        if (this.m != null) goto L5;
        return null;
    L5:
        if (this.f5199e == false) goto L8;
        return null;
    L8:
        return this.m.a(r2, r4);
    }

    public ThreadStatInfo j(int r1, int r2) {
        return MonitorJni.getThreadStatInfo(r1, r2);
    }

    public long k(int r3) {
        if (this.f5201g == true) goto L7;
        return com.bytedance.apm.util.b.k();
    L7:
        if (t() == true) goto L12;
        return 0;
    L12:
        return MonitorJni.getTotalCPUTimeByTimeInStat(r3);
    L11:
        return 0;
    }

    public synchronized void l() {
        monitor-enter(this);
        LockMonitorManager.setOpenFetchStack(false);     // Catch: Throwable -> L9
        if (p == true) goto L13;
    L7:
        monitor-exit(this);
        return;
    L13:
        MonitorJni.disableLock();     // Catch: Throwable -> L12
    L9:
        th = move-exception;
        throw th;
    }

    public g.InterfaceC0165g m() {
        g r0 = this.f5205k;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.f5115f;
    }

    public g.i o() {
        g r0 = this.f5205k;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.E();
    }

    public d.a p() {
        d r0 = this.f5206l;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public int q(int r1) {
        return MonitorJni.getProcCGroup(r1);
    }

    public com.bytedance.apm.f0.e r() {
        return this.n;
    }

    public synchronized void s(Context r3, @NonNull j r4) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f5196b == false) goto L12;
        if (com.bytedance.apm.d.C() == false) goto L8;
        Log.w("PerfMonitorManager", "PerfMonitorManager init twice? " + r4, new Throwable());     // Catch: Throwable -> L16
    L8:
        E(r4);     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L12:
        if (u(r3) == false) goto L14;
        l.i();     // Catch: Throwable -> L16
        E(r4);     // Catch: Throwable -> L16
        this.f5196b = true;     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
    }

    public void v() {
        this.f5198d = true;
    }

    public void w(int r2) {
        if (this.f5198d == false) goto L10;
        Iterator<com.bytedance.monitor.collector.b> r1 = this.f5195a.iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        com.bytedance.monitor.collector.b r0 = r1.next();
        if (r0 == null) goto L6;
        r0.c(r2);
        goto L6
    L16:
        return;
    }

    public void x(boolean r1) {
        this.f5201g = r1;
    }

    public void y(boolean r1) {
        this.f5199e = r1;
    }

    public void z() {
        int r0 = 0;
    L4:
        if (r0 >= this.f5195a.size()) goto L6;
        this.f5195a.get(r0).d();
        r0 = r0 + 1;
        goto L4
    L6:
        this.f5197c = true;
    }
}
