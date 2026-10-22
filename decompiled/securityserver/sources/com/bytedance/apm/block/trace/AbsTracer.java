package com.bytedance.apm.block.trace;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.block.AbsLooperObserver;
import com.bytedance.apm6.foundation.ActivityLifeManager;
import com.bytedance.apm6.service.ServiceManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsTracer extends AbsLooperObserver implements ITracer {
    private static final String TAG = "Matrix.AbsTracer";
    private volatile boolean isAlive;

    public AbsTracer() {
        this.isAlive = false;
    }

    @Override // com.bytedance.apm.block.trace.ITracer
    public boolean isAlive() {
        return this.isAlive;
    }

    public boolean isForeground() {
        return ((ActivityLifeManager) ServiceManager.getService(ActivityLifeManager.class)).isForeground();
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

    @CallSuper
    public void onAlive() {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r1) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onChange(Activity r1, Fragment r2) {
    }

    @Override // com.bytedance.apm.block.trace.ITracer
    public final synchronized void onCloseTrace() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.isAlive == false) goto L9;
        this.isAlive = false;     // Catch: Throwable -> L7
        onDead();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }

    @CallSuper
    public void onDead() {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r1) {
    }

    @Override // com.bytedance.apm.block.trace.ITracer
    public final synchronized void onStartTrace() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.isAlive == true) goto L9;
        this.isAlive = true;     // Catch: Throwable -> L7
        onAlive();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }
}
