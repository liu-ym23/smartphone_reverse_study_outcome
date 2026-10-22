package com.bytedance.sync.v2;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.bytedance.sync.v2.f.m;
import com.bytedance.sync.v2.h.i;
import d.b.u.r;
import d.b.u.w.e;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class WsMonitor implements LifecycleObserver {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f5847f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f5848g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f5849h;

    class a implements i.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ m f5850f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ WsMonitor f5851g;

        /* JADX INFO: renamed from: com.bytedance.sync.v2.WsMonitor$a$a, reason: collision with other inner class name */
        class RunnableC0187a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ long f5852f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ a f5853g;

            RunnableC0187a(a r1, long r2) {
                this.f5853g = r1;
                this.f5852f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                WsMonitor.c(this.f5853g.f5851g, this.f5852f);
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ a f5854f;

            b(a r1) {
                this.f5854f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                ProcessLifecycleOwner.get().getLifecycle().removeObserver(this.f5854f.f5851g);     // Catch: Exception -> L4
                return;
            L4:
                d.b.u.x.b.b("there is something wrong when remove life cycle Observer,maybe someone add addObserver in work thread");
            }
        }

        a(WsMonitor r1, m r2) {
            this.f5851g = r1;
            this.f5850f = r2;
        }

        @Override // com.bytedance.sync.v2.h.i.a
        public void M(boolean r5) {
            monitor-enter(this);
            long r0 = WsMonitor.a(this.f5851g);     // Catch: Throwable -> L10
            if (r5 == true) goto L6;
        L8:
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        L6:
            if (r0 <= 0) goto L8;
            WsMonitor.b(this.f5851g, 0);     // Catch: Throwable -> L10
            this.f5850f.X(this);     // Catch: Throwable -> L10
            new Handler(((e) com.ss.android.ug.bus.b.a(e.class)).get(), null).post(new RunnableC0187a(this, SystemClock.elapsedRealtime() - r0));     // Catch: Throwable -> L10
            WsMonitor.d(this.f5851g, new b(this));     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ WsMonitor f5855f;

        b(WsMonitor r1) {
            this.f5855f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            ProcessLifecycleOwner.get().getLifecycle().addObserver(this.f5855f);     // Catch: Exception -> L4
            return;
        L4:
            d.b.u.x.b.b("there is something wrong when add life cycle Observer,maybe someone add addObserver in work thread");
        }
    }

    public WsMonitor() {
        this.f5848g = new AtomicBoolean(false);
    }

    static /* synthetic */ long a(WsMonitor r2) {
        return r2.f5847f;
    }

    static /* synthetic */ long b(WsMonitor r0, long r1) {
        r0.f5847f = r1;
        return r1;
    }

    static /* synthetic */ void c(WsMonitor r0, long r1) {
        r0.e(r1);
    }

    static /* synthetic */ void d(WsMonitor r0, Runnable r1) {
        r0.h(r1);
    }

    private void e(long r7) {
        boolean r1 = false;
        if (this.f5848g.compareAndSet(false, true) == false) goto L23;
        JSONObject r0 = new JSONObject();
        if (r7 > 0) goto L21;
        r1 = true;
    L21:
        r0.put("socket_connected_when_start", r1);     // Catch: JSONException -> L10
        r0.put("foreground_may_launch", this.f5849h);     // Catch: JSONException -> L10
    L12:
        JSONObject r6 = new JSONObject();
        r6.put("time", r7);     // Catch: JSONException -> L15
    L17:
        r.c("sync_sdk_ws_connect_ts", r0, r6, null);
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    private void g() {
        h(new b(this));
    }

    private void h(Runnable r2) {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        r2.run();
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(r2);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void onAnyActivityPause() {
        d.b.u.x.b.a("WsMonitor ON_PAUSE");
        this.f5849h = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onAnyActivityResume() {
        d.b.u.x.b.a("WsMonitor ON_RESUME");
        this.f5849h = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void onAnyActivityStart() {
        d.b.u.x.b.a("WsMonitor ON_START");
        this.f5849h = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onAnyActivityStop() {
        d.b.u.x.b.a("WsMonitor ON_STOP");
        this.f5849h = true;
    }

    public void f() {
        this.f5847f = SystemClock.elapsedRealtime();
        m r0 = (m) com.ss.android.ug.bus.b.a(m.class);
        if (r0.j() == false) goto L5;
        e(0);
        return;
    L5:
        r0.E(new a(this, r0));
        g();
    }
}
