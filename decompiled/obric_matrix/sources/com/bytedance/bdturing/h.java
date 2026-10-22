package com.bytedance.bdturing;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class h implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f3053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3054b;

    h(Activity r2) {
        this.f3054b = 1;
        this.f3053a = r2;
    }

    public void a() {
        Activity r0 = this.f3053a;
        if (r0 == null) goto L6;
        r0.getApplication().registerActivityLifecycleCallbacks(this);
        return;
    }

    public void b() {
        Activity r0 = this.f3053a;
        if (r0 == null) goto L6;
        r0.getApplication().unregisterActivityLifecycleCallbacks(this);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r2) {
        if (r2 != this.f3053a) goto L6;
        this.f3054b++;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r2) {
        if (r2 != this.f3053a) goto L8;
        int r3 = this.f3054b - 1;
        this.f3054b = r3;
        if (r3 != 0) goto L9;
        e.j();
        return;
    L9:
        return;
    }
}
