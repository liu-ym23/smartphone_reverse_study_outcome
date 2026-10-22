package com.bytedance.bdinstall.w0;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b.a f2894d;

    public a() {
    }

    private void a() {
        this.f2892b = false;
    }

    private void d() {
        this.f2892b = true;
    }

    @Override // com.bytedance.bdinstall.w0.b
    public boolean b() {
        return this.f2893c;
    }

    @Override // com.bytedance.bdinstall.w0.b
    public void c(b.a r1) {
        this.f2894d = r1;
    }

    @Override // com.bytedance.bdinstall.w0.b
    public boolean isForeground() {
        return this.f2892b;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r1) {
        int r2 = this.f2891a - 1;
        this.f2891a = r2;
        if (r2 > 0) goto L6;
        a();
    L6:
        if (this.f2891a >= 0) goto L9;
        this.f2891a = 0;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r2) {
        if (this.f2891a >= 0) goto L6;
        this.f2891a = 0;
    L6:
        if (this.f2891a != 0) goto L8;
        d();
    L8:
        this.f2891a++;
        this.f2893c = true;
        b.a r1 = this.f2894d;
        if (r1 == null) goto L12;
        r1.onResume();
        return;
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
