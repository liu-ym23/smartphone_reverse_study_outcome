package com.bytedance.common.wschannel;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;

/* JADX INFO: loaded from: classes.dex */
class d implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static WeakHandler f3522d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f3524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Runnable f3525c;

    static class a implements WeakHandler.IHandler {
        a() {
        }

        @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
        public void handleMsg(Message r1) {
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f3526f;

        b(d r1) {
            this.f3526f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Logger.debug() == false) goto L6;
            Logger.d("WsChannelSdk", "sRunnable AppAlive = " + d.a(this.f3526f));
        L6:
            if (d.a(this.f3526f) == false) goto L11;
            d.b(this.f3526f, false);
            if (d.c(this.f3526f) == null) goto L12;
            d.c(this.f3526f).onEnterToBackground();
            return;
        L12:
            return;
        }
    }

    public interface c {
        void onEnterToBackground();

        void onEnterToForeground();
    }

    static {
        f3522d = new WeakHandler(Looper.getMainLooper(), new a());
    }

    d() {
        this.f3523a = false;
        this.f3525c = new b(this);
    }

    static /* synthetic */ boolean a(d r0) {
        return r0.f3523a;
    }

    static /* synthetic */ boolean b(d r0, boolean r1) {
        r0.f3523a = r1;
        return r1;
    }

    static /* synthetic */ c c(d r0) {
        return r0.f3524b;
    }

    public void d(c r1) {
        this.f3524b = r1;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r3) {
        if (this.f3523a == false) goto L6;
        f3522d.postDelayed(this.f3525c, WsConstants.EXIT_DELAY_TIME);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r2) {
        if (this.f3523a == true) goto L8;
        this.f3523a = true;
        c r3 = this.f3524b;
        if (r3 == null) goto L8;
        r3.onEnterToForeground();
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("WsChannelSdk", "onResume sAppAlive = " + this.f3523a);
    L10:
        f3522d.removeCallbacks(this.f3525c);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r1) {
    }
}
