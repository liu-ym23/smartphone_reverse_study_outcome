package com.bytedance.apm.q;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.bdlocation.trace.TraceCons;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends com.bytedance.apm.a0.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BroadcastReceiver f1709g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private IntentFilter f1710h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1711i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f1712j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f1713k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1714l;
    private long m;
    private List<com.bytedance.apm.c.p> n;

    class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f1715a;

        /* JADX INFO: renamed from: com.bytedance.apm.q.d$a$a, reason: collision with other inner class name */
        class RunnableC0054a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ float f1716f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ float f1717g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f1718h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ a f1719i;

            RunnableC0054a(a r1, float r2, float r3, String r4) {
                this.f1719i = r1;
                this.f1716f = r2;
                this.f1717g = r3;
                this.f1718h = r4;
            }

            @Override // java.lang.Runnable
            public void run() {
                JSONObject r6 = new JSONObject();     // Catch: Exception -> L21
                r6.put("battery_temperature", this.f1716f);     // Catch: Exception -> L21
                r6.put("remaining_energy", this.f1717g);     // Catch: Exception -> L21
                if (d.s(this.f1719i.f1715a) == false) goto L18;
                if (d.u(this.f1719i.f1715a) != null) goto L7;
            L12:
                JSONObject r4 = new JSONObject();     // Catch: Exception -> L21
                if (TextUtils.isEmpty(this.f1718h) == false) goto L15;
                String r1 = TraceCons.METRIC_BACKGROUND;
            L16:
                r4.put("scene", r1);     // Catch: Exception -> L21
                com.bytedance.apm.t.d.e r7 = new com.bytedance.apm.t.d.e("temperature", "", r6, r4, null);     // Catch: Exception -> L21
                com.bytedance.apm.a0.b.a(r7, false);     // Catch: Exception -> L21
                com.bytedance.apm.t.c.a.p().e(r7);     // Catch: Exception -> L21
                goto L18
            L15:
                r1 = this.f1718h;     // Catch: Exception -> L21
                goto L16
            L7:
                if (d.u(this.f1719i.f1715a).isEmpty() == true) goto L12;
                Iterator r0 = d.u(this.f1719i.f1715a).iterator();     // Catch: Exception -> L21
            L10:
                if (r0.hasNext() == false) goto L12;
                ((com.bytedance.apm.c.p) r0.next()).a(this.f1717g, this.f1716f, this.f1718h);     // Catch: Exception -> L21
            L18:
                if (d.t(this.f1719i.f1715a) == false) goto L25;
                com.bytedance.apm.x.a.d("APM-BatteryLocal", r6.toString());     // Catch: Exception -> L21
                return;
            L25:
                return;
            }
        }

        a(d r1) {
            this.f1715a = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r7, Intent r8) {
            long r0 = SystemClock.elapsedRealtime();
            if ((r0 - d.p(this.f1715a)) <= (d.r(this.f1715a) * 1000)) goto L5;
            boolean r9 = true;
        L6:
            if (r9 == true) goto L8;
            return;
        L8:
            if (d.s(this.f1715a) == false) goto L10;
        L11:
            d.q(this.f1715a, r0);
            com.bytedance.apm.f0.b.f().i(new RunnableC0054a(this, r8.getIntExtra("temperature", 0) / 10.0f, (r8.getIntExtra("level", 0) * 100.0f) / r8.getIntExtra("scale", 100), ActivityLifeObserver.getInstance().getTopActivityClassName()));
            return;
        L10:
            if (d.t(this.f1715a) == true) goto L11;
            return;
        L5:
            r9 = false;
            goto L6
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f1720a = null;

        static {
            f1720a = new d();
        }

        static /* synthetic */ d a() {
            return f1720a;
        }
    }

    public d() {
        this.f1712j = false;
        this.f1714l = 60;
        this.f1122e = "battery";
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent o(Context r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    static /* synthetic */ long p(d r2) {
        return r2.m;
    }

    static /* synthetic */ long q(d r0, long r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ int r(d r0) {
        return r0.f1714l;
    }

    static /* synthetic */ boolean s(d r0) {
        return r0.f1712j;
    }

    static /* synthetic */ boolean t(d r0) {
        return r0.f1713k;
    }

    static /* synthetic */ List u(d r0) {
        return r0.n;
    }

    public static d v() {
        return b.a();
    }

    private void x() {
        if (this.f1711i == false) goto L8;
        return;
    L8:
        o(com.bytedance.apm.d.h(), this.f1709g, this.f1710h);     // Catch: Exception -> L7
        this.f1711i = true;     // Catch: Exception -> L7
        return;
    }

    private void y() {
        if (this.f1711i == true) goto L8;
        return;
    L8:
        com.bytedance.apm.d.h().unregisterReceiver(this.f1709g);     // Catch: Exception -> L7
        this.f1711i = false;     // Catch: Exception -> L7
        return;
    }

    @Override // com.bytedance.apm.a0.a
    protected void c(JSONObject r4) {
        super.c(r4);
        boolean r1 = false;
        if (r4.optInt("temperature_enable_upload", 0) != 1) goto L5;
        r1 = true;
    L5:
        this.f1712j = r1;
        this.f1714l = r4.optInt("temperature_upload_interval", 60);
        if (this.f1712j == false) goto L8;
        return;
    L8:
        if (this.f1713k == true) goto L12;
        ActivityLifeObserver.getInstance().unregister(this);
        y();
        return;
    }

    @Override // com.bytedance.apm.a0.a
    protected boolean f() {
        return false;
    }

    @Override // com.bytedance.apm.a0.a
    protected void h() {
        this.f1709g = new a(this);
        this.f1710h = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        x();
    }

    @Override // com.bytedance.apm.a0.a
    protected long n() {
        return 0;
    }

    @Override // com.bytedance.apm.a0.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r1) {
        super.onBackground(r1);
        y();
    }

    @Override // com.bytedance.apm.a0.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r1) {
        super.onFront(r1);
        x();
    }

    public void w(boolean r1) {
        this.f1713k = r1;
        d();
    }
}
